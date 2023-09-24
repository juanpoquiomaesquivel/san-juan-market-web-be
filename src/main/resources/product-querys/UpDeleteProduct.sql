CREATE OR ALTER PROCEDURE UpDeleteProduct (
	@Id CHAR(8)
)
AS
BEGIN -- EXEC UpDeleteProduct 'PRO00002'
SET NOCOUNT ON
	DELETE FROM
		product
	WHERE
		id_product = @Id;
END;