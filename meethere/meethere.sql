CREATE TABLE `meethere`.`user` (
  `user_id` INT NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_id`));

CREATE TABLE `meethere`.`admin` (
  `admin_id` INT NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`admin_id`));

CREATE TABLE `meethere`.`news` (
  `news_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(500) NOT NULL,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`news_id`));

  CREATE TABLE `meethere`.`message` (
  `message_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `time` DATETIME NOT NULL,
  `content` CHAR(255) NOT NULL,
  `is_checked` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`message_id`));

CREATE TABLE `meethere`.`stadium` (
  `auto_incr` INT NOT NULL AUTO_INCREMENT,
  `stadium_id` INT(20) NOT NULL,
  `time` DATETIME NOT NULL,
  `is_available` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`auto_incr`));

CREATE TABLE `meethere`.`order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `stadium_id` INT(20) NOT NULL,
  `time` DATETIME NOT NULL,
  `is_checked` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`order_id`));
