CREATE TABLE category(
 id IDENTITY,
 name VARCHAR(20),
 description VARCHAR(200),
 image_url VARCHAR(50),
 is_active BOOLEAN,
 CONSTRAINT  pk_category_id PRIMARY KEY(id)
 );
 INSERT INTO category(name,description,image_url, is_active)VALUES('North Indian','Enjoy north indian food','CAT_1.png');
 INSERT INTO category(name,description,image_url, is_active)VALUES('South Indian','Enjoy  south indian food','CAT_2.png');
 INSERT INTO category(name,description,image_url, is_active)VALUES('Chineese','Enjoy chineese food','CAT_3.png');
 INSERT INTO category(name,description,image_url, is_active)VALUES('Sweets and drinks','Enjoy our special drinks and desserts','CAT_4.png');
 
 CREATE TABLE user_detail(
id.IDENTITY,
first_name VARCHAR(50),
last_name  VARCHAR(50) ,
role  VARCHAR(50) ,
enabled BOOLEAN,
password  VARCHAR(50) ,
contact_number  VARCHAR(50) ,
CONSTRAINT  pk_category_id PRIMARY KEY(id)
);

INSERT INTO user_detail(first_name,last_name,role,enabled,password,contact_number)
VALUES('Mohit','Dhawan','ADMIN','true','admin','9999999999');

INSERT INTO user_detail(first_name,last_name,role,enabled,password,contact_number)
VALUES('Heena','Dhawan','SUPPLIER','true','supplier','9999000000');

INSERT INTO user_detail(first_name,last_name,role,enabled,password,contact_number)
VALUES('Mamta','Dhawan','SUPPLIER','true','supplier','8888888888');


 CREATE TABLE product(
id.IDENTITY,
name VARCHAR(30),
description VARCHAR(50),
price INT(6),
unit INT(5),
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT DEFAULT 0,
views  INT DEFAULT 0,
CONSTRAINT  pk_category_id PRIMARY KEY(id)
CONSTRAINT  fk_product_category_id FOREIGN  KEY(category_id)REFERENCES category (id),

CONSTRAINT  fk_product_category_id FOREIGN  KEY(supplier_id)REFERENCES supplier (id),
);

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('Dal Makhni','Creamy and spicy','200','4',true,'1','2');

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('ShaiPaneer','Creamy and tasty','270','5',true,'1','2');

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('Masala Dosa','yummy','100','4',true,'2','2');

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('Idli Sambhar','hot','70','6',true,'2','2');

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('Noddles','Enjoy the noodles','90','4',true,'3','2');

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('Chilli patato',' spicy','100','3',true,'3','2');

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('cold coffe','Creamy and cool','40','4',true,'4','2');

INSERT INTO product(name,description,price, unit,is_active,category_id,supplier_id)
VALUES('kheer','tasty','50','4',true,'4','2');























 )