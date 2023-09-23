CREATE OR ALTER PROCEDURE UpAddCategoryTag (
	@ClassId CHAR(6),
	@CategoryId CHAR(8)
)
AS
BEGIN -- EXEC UpAddCategoryTag '101018', 'CAT00001'
SET NOCOUNT ON
	UPDATE
		class
	SET
		category_id = @CategoryId
	WHERE
		id_class = @ClassId;
END;