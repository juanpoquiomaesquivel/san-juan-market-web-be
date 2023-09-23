CREATE OR ALTER PROCEDURE UpInsertProduct (
	@Name NVARCHAR(255),
	@Description NVARCHAR(MAX),
	@CategoryId CHAR(8)
)
AS
BEGIN -- EXEC UpInsertProduct 'example', NULL, 'CAT00001'
SET NOCOUNT ON
	DECLARE @NewId CHAR(8);

	SET @NewId = dbo.FnGenerateNewUniqueProductId();

	IF @Description IS NULL
		BEGIN
			INSERT INTO
				product (
					id_product,
					p_name,
					category_id
				)
			VALUES (
				@NewId,
				@Name,
				@CategoryId
			);
		END
	ELSE
		BEGIN
			INSERT INTO
				product
			VALUES (
				@NewId,
				@Name,
				@Description,
				@CategoryId
			);
		END
END;