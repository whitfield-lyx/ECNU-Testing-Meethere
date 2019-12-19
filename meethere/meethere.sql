CREATE DATABASE `meethere` DEFAULT CHARACTER SET utf8;

USE `meethere`;

DROP TABLE IF EXISTS `user`;
CREATE table user(
user_id int NOT NULL AUTO_INCREMENT,
password VARCHAR(20) NOT NULL,
name VARCHAR(20) NOT NULL,
nickname VARCHAR(20) NOT NULL,
PRIMARY KEY(user_id)
);

DROP TABLE IF EXISTS `admin`;
CREATE table admin(
admin_id int NOT NULL AUTO_INCREMENT,
password VARCHAR(20) NOT NULL,
name VARCHAR(20) NOT NULL,
PRIMARY KEY(admin_id)
);

DROP TABLE IF EXISTS `news`;
CREATE table news(
news_id int NOT NULL AUTO_INCREMENT,
title VARCHAR(45) NOT NULL,
content VARCHAR(500) NOT NULL,
time DATETIME NOT NULL,
name  VARCHAR(20) NOT NULL,
PRIMARY KEY(news_id)
);

DROP TABLE IF EXISTS `message`;
CREATE table message(
message_id int NOT NULL AUTO_INCREMENT,
user_id int NOT NULL,
time DATETIME NOT NULL,
content VARCHAR(255) NOT NULL,
is_checked TINYINT NOT NULL DEFAULT 0,
PRIMARY KEY(message_id)
);

DROP TABLE IF EXISTS `stadium`;
CREATE table stadium(
stadium_id VARCHAR(20) NOT NULL,
time VARCHAR(500) DEFAULT NULL,
price int NOT NULL,
address VARCHAR(45) NOT NULL,
PRIMARY KEY(stadium_id)
);

DROP TABLE IF EXISTS `order`;
CREATE table order(
order_id int NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
stadium_id VARCHAR(20) NOT NULL,
time DATETIME NOT NULL,
hour INT NOT NULL DEFAULT 1,
is_checked TINYINT NOT NULL DEFAULT 0,
PRIMARY KEY(order_id)
);

INSERT INTO admin VALUES (10,'111111','admin10');
INSERT INTO admin VALUES (31415,'123123','myadmin');

INSERT INTO message VALUES(1,1,'2019-10-12 13:20:45','test test test',1);
INSERT INTO message VALUES(2,7,'2019-12-17 10:18:33','开发其实很快乐，就是要熬夜罢了',1);
INSERT INTO message VALUES(3,2,'2019-11-11 10:12:03','我想问问同学们为什么不选卜老师的算法课呢？',0);

INSERT INTO news VALUES(1,'华东师大05级校友唱红《我要把金沙江路走一遍》','“我要把金沙江路走一遍，陪伴我青春的大学校园，你是否也怀念，在丽娃河边，长椅上的梦伴着稚嫩的脸……”这几天来，一首《我要把金沙江路走一遍》成为网上热播歌曲，朋友圈里，不是自己在刷屏就是被自己的朋友们刷屏。词曲作者、演唱者是华东师范大学05级校友大攀。他说，这是一首写给华东师大，回忆大学生活的岁月之歌。','2019-11-18 12:16:04','myadmin');
INSERT INTO news VALUES(3,'南京大屠杀死难者国家公祭仪式','近日，南京市人民政府官网发布《关于南京大屠杀死难者国家公祭仪式有关事项的通告》。通告称，2019年12月13日上午举行国家公祭仪式活动，10:01至10:02南京全城将鸣笛致哀。','2019-12-13 08:30:00','admin10');

INSERT INTO user VALUES (1,'111111','user01','apple');
INSERT INTO user VALUES (2,'111111','2_user','banana');
INSERT INTO user VALUES (7,'123123','my333','');

INSERT INTO stadium VALUES ('东操场',NULL ,1000,'上海市中山北路3664号');
INSERT INTO stadium VALUES ('中北乒乓球馆',NULL ,200,'上海市中山北路3663号');
INSERT INTO stadium VALUES ('大活羽毛球馆',NULL ,300,'上海市金沙江路1556号');
INSERT INTO stadium VALUES ('篮球馆',NULL ,400,'上海市金沙江路1567号');

INSERT INTO `order` VALUES (1,'1','中北乒乓球馆','2019-10-12 13:00:00',2,0);
INSERT INTO `order` VALUES (2,'7','大活羽毛球馆','2019-12-12 15:00:00',1,1);
