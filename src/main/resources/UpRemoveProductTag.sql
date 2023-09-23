CREATE OR ALTER PROCEDURE UpRemoveProductTag (
	@CommodityId CHAR(8)
)
AS
BEGIN -- EXEC UpRemoveProductTag '10101501'
SET NOCOUNT ON
	UPDATE
		commodity
	SET
		product_id = 'PRO00000'
	WHERE
		id_commodity = @CommodityId;
END;
