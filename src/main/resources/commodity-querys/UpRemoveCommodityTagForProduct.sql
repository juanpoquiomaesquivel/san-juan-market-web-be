CREATE OR ALTER PROCEDURE UpRemoveCommodityTagForProduct (
	@Id CHAR(8)
)
AS
BEGIN -- EXEC UpRemoveCommodityTagForProduct '10101501'
SET NOCOUNT ON
	UPDATE
		commodity
	SET
		product_id = 'PRO00000'
	WHERE
		id_commodity = @Id;
END;
