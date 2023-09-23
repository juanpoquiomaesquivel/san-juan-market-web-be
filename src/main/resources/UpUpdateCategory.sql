CREATE OR ALTER PROCEDURE UpUpdateCategory (
	@Id CHAR(8),
	@Name NVARCHAR(255),
	@Description NVARCHAR(MAX)
)
AS
BEGIN -- EXEC UpUpdateCategory 'CAT00002', 'sql server', 'OJITO'
SET NOCOUNT ON
	DECLARE @NewId CHAR(8);

	SET @NewId = dbo.FnGenerateNewUniqueCategoryId();

	UPDATE
		category
	SET
		ca_name = @Name,
		ca_description = CASE
							WHEN @Description IS NULL THEN ca_description
							ELSE @Description
						END
	WHERE
		id_category = @Id;
END;