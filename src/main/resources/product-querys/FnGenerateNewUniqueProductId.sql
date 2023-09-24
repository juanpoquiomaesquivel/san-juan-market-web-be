CREATE OR ALTER FUNCTION FnGenerateNewUniqueProductId ()
RETURNS CHAR(8)
AS
BEGIN
    DECLARE @CurrentId CHAR(8);
    DECLARE @NewId CHAR(8);

	SELECT @CurrentId = id_product FROM product;

    SET @NewId = 'PRO' + RIGHT('00000' + CAST(CAST(RIGHT(@CurrentId, 5) AS INT) + 1 AS VARCHAR(5)), 5);
	
    RETURN @NewId;
END;

/*
DECLARE @NewProductId CHAR(8);
SET @NewProductId = dbo.FnGenerateNewUniqueProductId();
SELECT @NewProductId;
*/