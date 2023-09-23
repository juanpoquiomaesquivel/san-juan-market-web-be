CREATE OR ALTER PROCEDURE UpInsertCategory (
	@Name NVARCHAR(255),
	@Description NVARCHAR(MAX)
)
AS
BEGIN -- EXEC UpInsertCategory 'example', NULL
SET NOCOUNT ON
	DECLARE @NewId CHAR(8);

	SET @NewId = dbo.FnGenerateNewUniqueCategoryId();

	INSERT INTO
		category
	VALUES (
		@NewId,
		@Name,
		CASE
			WHEN @Description IS NULL THEN 'There is no description for this category.'
			ELSE @Description
		END
	);
END;