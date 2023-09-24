CREATE OR ALTER PROCEDURE UpInsertProduct (
	@Name NVARCHAR(255),
	@Description NVARCHAR(MAX),
	@CategoryId CHAR(8)
)
AS
BEGIN -- EXEC UpInsertProduct 'veamos pueh', NULL, 'CAT00001'
SET NOCOUNT ON
	DECLARE @NewId CHAR(8);

	SET @NewId = dbo.FnGenerateNewUniqueProductId();

	INSERT INTO
		product
	VALUES (
		@NewId,
		@Name,
		CASE
			WHEN @Description IS NULL THEN 'There is no description for this product.'
			ELSE @Description
		END,
		CASE
			WHEN @CategoryId IS NULL THEN 'CAT00000'
			ELSE @CategoryId
		END
	);
END;