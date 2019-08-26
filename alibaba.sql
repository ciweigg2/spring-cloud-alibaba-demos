/*
SQLyog Ultimate v12.3.3 (64 bit)
MySQL - 5.7.26-log : Database - alibaba
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`alibaba` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `alibaba`;

/*Table structure for table `alibaba_gift` */

DROP TABLE IF EXISTS `alibaba_gift`;

CREATE TABLE `alibaba_gift` (
  `gift_id` bigint(20) NOT NULL COMMENT '礼物id',
  `gift_name` varchar(255) DEFAULT NULL COMMENT '礼物名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`gift_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='礼物表';

/*Data for the table `alibaba_gift` */

/*Table structure for table `alibaba_live` */

DROP TABLE IF EXISTS `alibaba_live`;

CREATE TABLE `alibaba_live` (
  `live_id` bigint(20) NOT NULL COMMENT '直播id',
  `live_name` varchar(255) DEFAULT NULL COMMENT '直播名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`live_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='直播表';

/*Data for the table `alibaba_live` */

/*Table structure for table `alibaba_user` */

DROP TABLE IF EXISTS `alibaba_user`;

CREATE TABLE `alibaba_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

/*Data for the table `alibaba_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
