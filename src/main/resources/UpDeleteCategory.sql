CREATE OR ALTER PROCEDURE UpDeleteCategory (
	@Id CHAR(8)
)
AS
BEGIN -- EXEC UpDeleteCategory 'CAT00002'
SET NOCOUNT ON
	DELETE FROM
		category
	WHERE
		id_category = @Id;
END;