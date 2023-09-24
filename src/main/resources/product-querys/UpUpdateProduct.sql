CREATE OR ALTER PROCEDURE UpUpdateProduct (
	@Id CHAR(8),
	@Name NVARCHAR(255),
	@Description NVARCHAR(MAX),
	@CategoryId CHAR(8)
)
AS
BEGIN -- EXEC UpUpdateProduct 'PRO00002', 'veamos ACTU', NULL, NULL
SET NOCOUNT ON
	UPDATE
		product
	SET
		p_name = @Name,
		p_description = CASE
			WHEN @Description IS NULL THEN p_description
			ELSE @Description
		END,
		category_id = CASE
			WHEN @CategoryId IS NULL THEN category_id
			ELSE @CategoryId
		END
	WHERE
		id_product = @Id;
END;