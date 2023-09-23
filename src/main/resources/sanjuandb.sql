USE sanjuandb;
GO

-- DELETING ALL TABLES

IF OBJECT_ID('article', 'U') IS NOT NULL
BEGIN
    DROP TABLE article;
END

IF OBJECT_ID('product', 'U') IS NOT NULL
BEGIN
    DROP TABLE product;
END

IF OBJECT_ID('category', 'U') IS NOT NULL
BEGIN
    DROP TABLE category;
END

IF OBJECT_ID('commodity', 'U') IS NOT NULL
BEGIN
    DROP TABLE commodity;
END

IF OBJECT_ID('class', 'U') IS NOT NULL
BEGIN
    DROP TABLE class;
END

IF OBJECT_ID('family', 'U') IS NOT NULL
BEGIN
    DROP TABLE family;
END

IF OBJECT_ID('segment', 'U') IS NOT NULL
BEGIN
    DROP TABLE segment;
END



-- CREATING TABLE 'SEGMENT'

CREATE TABLE segment (
	id_segment CHAR(2) PRIMARY KEY,
	s_name NVARCHAR(255) NOT NULL
);



-- CREATING TABLE 'FAMILY'

CREATE TABLE family (
	id_family CHAR(4) PRIMARY KEY,
	f_name NVARCHAR(255) NOT NULL,
	segment_id CHAR(2)
);

ALTER TABLE
	family
ADD
	CONSTRAINT fk_family_segment_id
	FOREIGN KEY (segment_id) REFERENCES segment (id_segment);



-- CREATING TABLE 'CLASS'

CREATE TABLE class (
	id_class CHAR(6) PRIMARY KEY,
	c_name NVARCHAR(255) NOT NULL,
	family_id CHAR(4),
	category_id CHAR(8)
);

ALTER TABLE
	class
ADD 
	CONSTRAINT fk_class_family_id
	FOREIGN KEY (family_id) REFERENCES family (id_family);



-- CREATING TABLE 'COMMODITY'

CREATE TABLE commodity (
	id_commodity CHAR(8) primary key,
	co_name NVARCHAR(255) NOT NULL,
	class_id CHAR(6),
	product_id CHAR(8)
);

ALTER TABLE 
	commodity
ADD 
	CONSTRAINT fk_commodity_class_id
	FOREIGN KEY (class_id) REFERENCES class (id_class);



-- CREATING TABLE 'CATEGORY'

CREATE TABLE category (
    id_category CHAR(8) PRIMARY KEY,
    ca_name NVARCHAR(255) NOT NULL,
    ca_description NVARCHAR(MAX) NULL
);

ALTER TABLE
	category
ADD
	CONSTRAINT df_category_ca_description
	DEFAULT 'There is no description for this category.' FOR ca_description;

ALTER TABLE
	class
ADD
	CONSTRAINT fk_class_category_id
	FOREIGN KEY (category_id) REFERENCES category (id_category);

INSERT INTO
	category (id_category, ca_name)
VALUES
	('CAT00000', 'No category.');



-- CREATING TABLE 'PRODUCT'

CREATE TABLE product (
    id_product CHAR(8) PRIMARY KEY,
    p_name NVARCHAR(255) NOT NULL,
    p_description NVARCHAR(MAX) NULL,
    category_id CHAR(8)
);

ALTER TABLE
	product
ADD
	CONSTRAINT df_product_p_description
	DEFAULT 'There is no description for this product.' FOR p_description;

ALTER TABLE
    product
ADD
    CONSTRAINT fk_product_category_id
	FOREIGN KEY (category_id) REFERENCES category (id_category);

ALTER TABLE
    commodity
ADD
    CONSTRAINT fk_commodity_product_id
	FOREIGN KEY (product_id) REFERENCES product (id_product);

INSERT INTO
	product (id_product, p_name, category_id)
VALUES
	('PRO00000', 'No product.', 'CAT00000');



-- CREATING TABLE 'ARTICLE'

CREATE TABLE article (
    id_article CHAR(8) PRIMARY KEY,
    a_name NVARCHAR(255) NOT NULL,
	a_description NVARCHAR(MAX) NULL,
    a_price DECIMAL(16, 2) NOT NULL,
    a_stock INT NOT NULL,
    a_img NVARCHAR(MAX) NULL,
	bar_code CHAR(13) NULL,
    product_id CHAR(8)
);

ALTER TABLE
	article
ADD
	CONSTRAINT df_article_a_description
	DEFAULT 'There is no description for this article.' FOR a_description;

ALTER TABLE
    article
ADD
    CONSTRAINT ck_article_a_price 
	CHECK (a_price >= 0);

ALTER TABLE
    article
ADD
    CONSTRAINT ck_article_a_stock
	CHECK (a_stock >= 0);

ALTER TABLE
    article
ADD
    CONSTRAINT df_article_a_img 
	DEFAULT 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.blogto.com%2Farticles%2F07302013-stonegatefarmersmarket2048-23.jpg%3Fw%3D2048%26cmd%3Dresize_then_crop%26height%3D1365%26quality%3D70&f=1&nofb=1&ipt=30b66e1bbadaea494c909929cbcced18fbc8cd43f8a6d7914a7a80ed244e9b66&ipo=images' FOR a_img;

ALTER TABLE
    article
ADD
    CONSTRAINT fk_article_product_id 
	FOREIGN KEY (product_id) REFERENCES product (id_product);