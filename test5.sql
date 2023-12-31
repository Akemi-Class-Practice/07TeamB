/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.27 : Database - teamb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`teamb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `teamb`;

/*Table structure for table `admin_info` */

DROP TABLE IF EXISTS `admin_info`;

CREATE TABLE `admin_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `level` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `admin_info` */

insert  into `admin_info`(`id`,`name`,`password`,`email`,`level`) values (1,'admin','1HNeOiZeFu7gP1lxi5tdAwGcB9i2xR+Q2jpmbuwTqzU=','admin@gmail.com',1),(11,'4','teamb','4',1),(12,'3','teamb','3',1),(13,'1','teamb','1',1),(14,'5','teamb','5',1),(15,'7','teamb','6',1),(17,'8','teamb','5',1),(18,'222222','teamb','222',1),(19,'s','jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=','s',1),(20,'d','NTrx3HN4NGLCzY17B/Nl5cBkwledQ0VXMqopkXmMUQE=','d',1),(22,'hx','1HNeOiZeFu7gP1lxi5tdAwGcB9i2xR+Q2jpmbuwTqzU=',NULL,1);

/*Table structure for table `class_info` */

DROP TABLE IF EXISTS `class_info`;

CREATE TABLE `class_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `teacher` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `yixuan` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `class_info` */

insert  into `class_info`(`id`,`name`,`description`,`time`,`teacher`,`price`,`yixuan`) values (6,'111','111','2023-09-12 00:00:00','111',12333,NULL),(7,'333333','3333333','2023-04-08 00:00:00','333333',2,NULL),(8,'1','1','2023-04-05 00:00:00','1',3,NULL);

/*Table structure for table `inquiry_info` */

DROP TABLE IF EXISTS `inquiry_info`;

CREATE TABLE `inquiry_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `inquiry_info` */

insert  into `inquiry_info`(`id`,`title`,`content`) values (1,'111','111');

/*Table structure for table `xuanke_info` */

DROP TABLE IF EXISTS `xuanke_info`;

CREATE TABLE `xuanke_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `yuuzaId` bigint DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `xuanke_info` */

insert  into `xuanke_info`(`id`,`name`,`description`,`time`,`teacher`,`price`,`yuuzaId`,`status`) values (73,'1','1','2023-04-05 00:00:00','1',3,31,'払い済み');

/*Table structure for table `yuuza_info` */

DROP TABLE IF EXISTS `yuuza_info`;

CREATE TABLE `yuuza_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `level` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `yuuza_info` */

insert  into `yuuza_info`(`id`,`name`,`email`,`password`,`level`) values (22,'1','1','1',3),(23,'2','2','123456',3),(29,'6','6','123456',3),(30,'ee','ee','ee',3),(31,'rr','rr','rr',3),(34,'111','111','9uCh4qxBlFqap/+KiqoM68EqO8yYGpKa1c+BCgkOEa4=',3),(35,'hx',NULL,'123456',3),(36,'333','333','VW19w6EVNWNQ8fmRCxrxqw4xLUs+T8eI0tpjZo820Bc=',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
