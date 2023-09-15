USE sanjuandatabase;

DROP TABLE article;
DROP TABLE product;
DROP TABLE category;

CREATE TABLE category (
    cat_code VARCHAR(8) NOT NULL PRIMARY KEY,
    cat_name NVARCHAR(100) NOT NULL,
    cat_description NVARCHAR(255) NOT NULL
);

ALTER TABLE
	category
ADD
	CONSTRAINT DF_CATEGORY_CAT_NAME
	DEFAULT 'There is no name for this category.' FOR cat_name;

ALTER TABLE
	category
ADD
	CONSTRAINT DF_CATEGORY_CAT_DESCRIPTION
	DEFAULT 'There is no description for this category.' FOR cat_description;

INSERT INTO
	category
VALUES
	('CAT00000', 'ENLATADOS Y ENVASADOS', '1'),
	('CAT00001', 'BEBIDAS', '2'),
	('CAT00002', 'LÁCTEOS', '3'),
	('CAT00003', 'PAN Y PRODUCTOS DE PANADERÍA', '4'),
	('CAT00004', 'CUIDADO PERSONAL', '5'),
	('CAT00005', 'LIMPIEZA DEL HOGAR', '6'),
	('CAT00006', 'CUIDADO DE MASCOTAS', '7'),
	('CAT00007', 'SNACKS Y GOLOSINAS', '8'),
	('CAT00008', 'DE PAPELERÍA', '9'),
	('CAT00009', 'CUIDADO DE BEBÉS', '10');

CREATE TABLE product (
    pro_code VARCHAR(8) NOT NULL PRIMARY KEY,
    pro_name NVARCHAR(100) NOT NULL,
    pro_description NVARCHAR(300) NOT NULL,
    category_code VARCHAR(8) NOT NULL
);

ALTER TABLE
	product
ADD
	CONSTRAINT DF_PRODUCT_PRO_NAME
	DEFAULT 'There is no name for this product.' FOR pro_name;

ALTER TABLE
	product
ADD
	CONSTRAINT DF_PRODUCT_PRO_DESCRIPTION
	DEFAULT 'There is no description for this product.' FOR pro_description;

ALTER TABLE
    product
ADD
    CONSTRAINT FK_PRODUCT_CATEGORY_CODE
	FOREIGN KEY (category_code) REFERENCES category (cat_code);

INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00000', 'CONSERVAS DE VERDURAS', 'CAT00000'),
	('PRO00001', 'SOPAS ENLATADAS', 'CAT00000'),
	('PRO00002', 'ATÚN EN LATA', 'CAT00000'),
	('PRO00003', 'SALSA DE TOMATE', 'CAT00000'),
	('PRO00004', 'FRIJOLES ENLATADOS', 'CAT00000');
	
INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00020', 'REFRESCOS', 'CAT00001'),
	('PRO00021', 'AGUA EMBOTELLADA', 'CAT00001'),
	('PRO00022', 'JUGOS ENVASADOS', 'CAT00001'),
	('PRO00023', 'ALCOHOL', 'CAT00001'),
	('PRO00024', 'BEBIDAS ENERGÉTICAS', 'CAT00001');
	
INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00040', 'LECHE', 'CAT00002'),
	('PRO00041', 'QUESO', 'CAT00002'),
	('PRO00042', 'YOGURT', 'CAT00002'),
	('PRO00043', 'MANTEQUILLA', 'CAT00002'),
	('PRO00044', 'CREMA AGRIA', 'CAT00002');
	
INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00060', 'PAN FRESCO', 'CAT00003'),
	('PRO00061', 'BOLLOS', 'CAT00003'),
	('PRO00062', 'CROISSANTS', 'CAT00003'),
	('PRO00063', 'PASTAS FRESCAS', 'CAT00003'),
	('PRO00064', 'GALLETAS', 'CAT00003');

INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00080', 'PAPEL HIGIÉNICO', 'CAT00004'),
	('PRO00081', 'JABÓN DE BAÑO', 'CAT00004'),
	('PRO00082', 'CHAMPÚ', 'CAT00004'),
	('PRO00083', 'PASTA DE DIENTES', 'CAT00004'),
	('PRO00084', 'CEPILLOS DE DIENTES', 'CAT00004');

INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00100', 'DETERGENTE PARA ROPA', 'CAT00005'),
	('PRO00101', 'LIMPIADORES MULTIUSO', 'CAT00005'),
	('PRO00102', 'DESINFECTANTE', 'CAT00005'),
	('PRO00103', 'TOALLITAS DE LIMPIEZA', 'CAT00005'),
	('PRO00104', 'ESCOBAS Y RECOGEDORES', 'CAT00005');

INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00120', 'COMIDA PARA PERROS O GATOS', 'CAT00006'),
	('PRO00121', 'ARENA PARA GATOS', 'CAT00006'),
	('PRO00122', 'JUGUETES PARA MASCOTAS', 'CAT00006'),
	('PRO00123', 'CORREAS Y COLLARES', 'CAT00006'),
	('PRO00124', 'ÚTILES DE ASEO', 'CAT00006');

INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00140', 'PAPAS FRITAS', 'CAT00007'),
	('PRO00141', 'CHOCOLATE', 'CAT00007'),
	('PRO00142', 'GALLETAS DULCES Y SALADAS', 'CAT00007'),
	('PRO00143', 'CHICLES', 'CAT00007'),
	('PRO00144', 'CARAMELOS', 'CAT00007');

INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00160', 'BOLÍGRAFOS', 'CAT00008'),
	('PRO00161', 'CUADERNOS', 'CAT00008'),
	('PRO00162', 'PAPEL', 'CAT00008'),
	('PRO00163', 'LÁPICES', 'CAT00008'),
	('PRO00164', 'CARPETAS', 'CAT00008');

INSERT INTO
	product
	(pro_code, pro_name, category_code)
VALUES
	('PRO00180', 'PAÑALES', 'CAT00009'),
	('PRO00181', 'FÓRMULA INFANTIL', 'CAT00009'),
	('PRO00182', 'TOALLITAS HÚMEDAS', 'CAT00009'),
	('PRO00183', 'BIBERONES', 'CAT00009'),
	('PRO00184', 'CREMAS PARA BEBÉ', 'CAT00009');

CREATE TABLE article (
    art_code VARCHAR(8) NOT NULL PRIMARY KEY,
    art_name NVARCHAR(100) NOT NULL,
	art_description NVARCHAR(255),
    art_price DECIMAL(16, 2) NOT NULL,
    art_stock INT NOT NULL,
    art_img NVARCHAR(MAX) NOT NULL,
	bar_code VARCHAR(13) NULL,
    product_code VARCHAR(8) NOT NULL
);

ALTER TABLE
	article
ADD
	CONSTRAINT DF_ARTICLE_ART_NAME
	DEFAULT 'There is no name for this article.' FOR art_name;

ALTER TABLE
	article
ADD
	CONSTRAINT DF_ARTICLE_ART_DESCRIPTION
	DEFAULT 'There is no description for this article.' FOR art_description;

ALTER TABLE
    article
ADD
    CONSTRAINT CK_ARTICLE_ART_PRICE 
	CHECK (art_price >= 0);

ALTER TABLE
    article
ADD
    CONSTRAINT CK_ARTICLE_ART_STOCK 
	CHECK (art_stock >= 0);

ALTER TABLE
    article
ADD
    CONSTRAINT DF_ARTICLE_ART_IMG 
	DEFAULT 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.blogto.com%2Farticles%2F07302013-stonegatefarmersmarket2048-23.jpg%3Fw%3D2048%26cmd%3Dresize_then_crop%26height%3D1365%26quality%3D70&f=1&nofb=1&ipt=30b66e1bbadaea494c909929cbcced18fbc8cd43f8a6d7914a7a80ed244e9b66&ipo=images' FOR art_img;

ALTER TABLE
    article
ADD
    CONSTRAINT FK_ARTICLE_PRODUCT_CODE 
	FOREIGN KEY (product_code) REFERENCES product (pro_code);