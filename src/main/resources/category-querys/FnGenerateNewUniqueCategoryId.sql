CREATE OR ALTER FUNCTION FnGenerateNewUniqueCategoryId ()
RETURNS CHAR(8)
AS
BEGIN
    DECLARE @CurrentId CHAR(8);
    DECLARE @NewId CHAR(8);

	SELECT @CurrentId = id_category FROM category;

    SET @NewId = 'CAT' + RIGHT('00000' + CAST(CAST(RIGHT(@CurrentId, 5) AS INT) + 1 AS VARCHAR(5)), 5);
	
    RETURN @NewId;
END;

/*
DECLARE @NewCategoryId CHAR(8);
SET @NewCategoryId = dbo.FnGenerateNewUniqueCategoryId();
SELECT @NewCategoryId;
*/