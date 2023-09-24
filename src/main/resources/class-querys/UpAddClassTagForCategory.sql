CREATE OR ALTER PROCEDURE UpAddClassTagForCategory (
	@Id CHAR(6),
	@CategoryId CHAR(8)
)
AS
BEGIN -- EXEC UpAddClassTagForCategory '101018', 'CAT00001'
SET NOCOUNT ON
	UPDATE
		class
	SET
		category_id = @CategoryId
	WHERE
		id_class = @Id;
END;