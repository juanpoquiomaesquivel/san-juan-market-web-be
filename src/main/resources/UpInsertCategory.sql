CREATE OR ALTER PROCEDURE UpInsertCategory (
	@Name NVARCHAR(255),
	@Description NVARCHAR(MAX)
)
AS
BEGIN -- EXEC UpInsertCategory 'example', NULL
SET NOCOUNT ON
	DECLARE @NewId CHAR(8);

	SET @NewId = dbo.FnGenerateNewUniqueCategoryId();

	IF @Description IS NULL
		BEGIN
			INSERT INTO
				category (
					id_category,
					ca_name
				)
			VALUES (
				@NewId,
				@Name
			);
		END
	ELSE
		BEGIN
			INSERT INTO
				category
			VALUES (
				@NewId,
				@Name,
				@Description
			);
		END
END;