CREATE OR ALTER PROCEDURE UpAddProductTag (
	@CommodityId CHAR(8),
	@ProductId CHAR(8)
)
AS
BEGIN -- EXEC UpAddProductTag '10101501', 'PRO00001'
SET NOCOUNT ON
	UPDATE
		commodity
	SET
		product_id = @ProductId
	WHERE
		id_commodity = @CommodityId;
END;
