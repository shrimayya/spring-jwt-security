/*
-- Query: SELECT * FROM mydb.product
LIMIT 0, 1000

-- Date: 2019-11-26 18:46
*/
INSERT INTO `` (`id`,`brand`,`category`,`color`,`is_available`,`name`,`price`,`size`) VALUES (1,'Puma','PANT','White','1','mypant',20.9,'XL');
INSERT INTO `` (`id`,`brand`,`category`,`color`,`is_available`,`name`,`price`,`size`) VALUES (2,'Puma','SOCKS','White','1','mysocks',20.9,'XL');
INSERT INTO `` (`id`,`brand`,`category`,`color`,`is_available`,`name`,`price`,`size`) VALUES (3,'Puma','SOCKS','White','1','mysocks2',20.9,'XL');

/*
-- Query: SELECT * FROM mydb.user
LIMIT 0, 1000

-- Date: 2019-11-26 18:47
*/
INSERT INTO `` (`id`,`active`,`password`,`roles`,`user_name`) VALUES (1,'1','test','ROLE_USER','test');


localhost:8081/authenticate

{
	"userName":"test",
	"password":"test"
}

Pass JWT token to (get request) got from authenticate :

Header :--  Authorization ---->JWT token

localhost:8081/product/SIZE

localhost:8081/product/COLOR

localhost:8081/product/BRAND


List

localhost:8081/product/name/mypant
localhost:8081/product/category/PANT/

