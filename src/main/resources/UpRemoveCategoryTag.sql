CREATE OR ALTER PROCEDURE UpRemoveCategoryTag (
	@ClassId CHAR(6)
)
AS
BEGIN -- EXEC UpRemoveCategoryTag '101018'
SET NOCOUNT ON
	UPDATE
		class
	SET
		category_id = 'CAT00000'
	WHERE
		id_class = @ClassId;
END;