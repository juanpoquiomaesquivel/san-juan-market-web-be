CREATE OR ALTER PROCEDURE UpRemoveClassTagForCategory (
	@Id CHAR(6)
)
AS
BEGIN -- EXEC UpRemoveClassTagForCategory '101018'
SET NOCOUNT ON
	UPDATE
		class
	SET
		category_id = 'CAT00000'
	WHERE
		id_class = @Id;
END;