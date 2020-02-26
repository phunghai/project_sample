CREATE DATABASE  IF NOT EXISTS `demo_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demo_db`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: demo_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `authority` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities_users`
--

DROP TABLE IF EXISTS `authorities_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities_users` (
  `user_id` bigint unsigned NOT NULL,
  `authority_id` bigint unsigned NOT NULL,
  UNIQUE KEY `authorities_unique` (`user_id`,`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities_users`
--

LOCK TABLES `authorities_users` WRITE;
/*!40000 ALTER TABLE `authorities_users` DISABLE KEYS */;
INSERT INTO `authorities_users` VALUES (1,2),(12,1),(13,1),(14,1),(15,1),(16,1);
/*!40000 ALTER TABLE `authorities_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_province`
--

DROP TABLE IF EXISTS `m_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `m_province` (
  `cd` varchar(10) NOT NULL,
  `type_cd` varchar(10) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `name_en` varchar(150) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`cd`),
  UNIQUE KEY `cd_UNIQUE` (`cd`),
  KEY `type_pk_idx` (`type_cd`),
  CONSTRAINT `type_pk` FOREIGN KEY (`type_cd`) REFERENCES `m_province_type` (`cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_province`
--

LOCK TABLES `m_province` WRITE;
/*!40000 ALTER TABLE `m_province` DISABLE KEYS */;
INSERT INTO `m_province` VALUES ('01','02','An Giang','An Giang','2020-02-24 14:09:17','2020-02-24 14:09:17'),('02','02','Bà Rịa – Vũng Tàu','Bà Rịa – Vũng Tàu','2020-02-24 14:09:17','2020-02-24 14:09:17'),('03','02','Bắc Giang','Bắc Giang','2020-02-24 14:09:17','2020-02-24 14:09:17'),('04','02','Bắc Kạn','Bắc Kạn','2020-02-24 14:09:17','2020-02-24 14:09:17'),('05','02','Bạc Liêu','Bạc Liêu','2020-02-24 14:09:17','2020-02-24 14:09:17'),('06','02','Bắc Ninh','Bắc Ninh','2020-02-24 14:09:17','2020-02-24 14:09:17'),('07','02','Bến Tre','Bến Tre','2020-02-24 14:09:18','2020-02-24 14:09:18'),('08','02','Bình Định','Bình Định','2020-02-24 14:09:18','2020-02-24 14:09:18'),('09','02','Bình Dương','Bình Dương','2020-02-24 14:09:18','2020-02-24 14:09:18'),('10','02','Bình Phước','Bình Phước','2020-02-24 14:09:18','2020-02-24 14:09:18'),('11','02','Bình Thuận','Bình Thuận','2020-02-24 14:09:18','2020-02-24 14:09:18'),('12','02','Cà Mau','Cà Mau','2020-02-24 14:09:18','2020-02-24 14:09:18'),('13','01','Cần Thơ','Cần Thơ','2020-02-24 14:09:18','2020-02-24 14:09:18'),('14','02','Cao Bằng','Cao Bằng','2020-02-24 14:09:18','2020-02-24 14:09:18'),('15','01','Đà Nẵng','Đà Nẵng','2020-02-24 14:09:18','2020-02-24 14:09:18'),('16','02','Đắk Lắk','Đắk Lắk','2020-02-24 14:09:18','2020-02-24 14:09:18'),('17','02','Đắk Nông','Đắk Nông','2020-02-24 14:09:18','2020-02-24 14:09:18'),('18','02','Điện Biên','Điện Biên','2020-02-24 14:09:18','2020-02-24 14:09:18'),('19','02','Đồng Nai','Đồng Nai','2020-02-24 14:09:18','2020-02-24 14:09:18'),('20','02','Đồng Tháp','Đồng Tháp','2020-02-24 14:09:18','2020-02-24 14:09:18'),('21','02','Gia Lai','Gia Lai','2020-02-24 14:09:18','2020-02-24 14:09:18'),('22','02','Hà Giang','Hà Giang','2020-02-24 14:09:18','2020-02-24 14:09:18'),('23','02','Hà Nam','Hà Nam','2020-02-24 14:09:18','2020-02-24 14:09:18'),('24','01','Hà Nội','Hà Nội','2020-02-24 14:09:19','2020-02-24 14:09:19'),('25','02','Hà Tĩnh','Hà Tĩnh','2020-02-24 14:09:19','2020-02-24 14:09:19'),('26','02','Hải Dương','Hải Dương','2020-02-24 14:09:19','2020-02-24 14:09:19'),('27','01','Hải Phòng','Hải Phòng','2020-02-24 14:09:19','2020-02-24 14:09:19'),('28','02','Hậu Giang','Hậu Giang','2020-02-24 14:09:19','2020-02-24 14:09:19'),('29','02','Hòa Bình','Hòa Bình','2020-02-24 14:09:19','2020-02-24 14:09:19'),('30','02','Hưng Yên','Hưng Yên','2020-02-24 14:09:19','2020-02-24 14:09:19'),('31','02','Khánh Hòa','Khánh Hòa','2020-02-24 14:09:19','2020-02-24 14:09:19'),('32','02','Kiên Giang','Kiên Giang','2020-02-24 14:09:19','2020-02-24 14:09:19'),('33','02','Kon Tum','Kon Tum','2020-02-24 14:09:19','2020-02-24 14:09:19'),('34','02','Lai Châu','Lai Châu','2020-02-24 14:09:19','2020-02-24 14:09:19'),('35','02','Lâm Đồng','Lâm Đồng','2020-02-24 14:09:19','2020-02-24 14:09:19'),('36','02','Lạng Sơn','Lạng Sơn','2020-02-24 14:09:19','2020-02-24 14:09:19'),('37','02','Lào Cai','Lào Cai','2020-02-24 14:09:19','2020-02-24 14:09:19'),('38','02','Long An','Long An','2020-02-24 14:09:19','2020-02-24 14:09:19'),('39','02','Nam Định','Nam Định','2020-02-24 14:09:19','2020-02-24 14:09:19'),('40','02','Nghệ An','Nghệ An','2020-02-24 14:09:20','2020-02-24 14:09:20'),('41','02','Ninh Bình','Ninh Bình','2020-02-24 14:09:20','2020-02-24 14:09:20'),('42','02','Ninh Thuận','Ninh Thuận','2020-02-24 14:09:20','2020-02-24 14:09:20'),('43','02','Phú Thọ','Phú Thọ','2020-02-24 14:09:20','2020-02-24 14:09:20'),('44','02','Phú Yên','Phú Yên','2020-02-24 14:09:20','2020-02-24 14:09:20'),('45','02','Quảng Bình','Quảng Bình','2020-02-24 14:09:20','2020-02-24 14:09:20'),('46','02','Quảng Nam','Quảng Nam','2020-02-24 14:09:20','2020-02-24 14:09:20'),('47','02','Quảng Ngãi','Quảng Ngãi','2020-02-24 14:09:20','2020-02-24 14:09:20'),('48','02','Quảng Ninh','Quảng Ninh','2020-02-24 14:09:20','2020-02-24 14:09:20'),('49','02','Quảng Trị','Quảng Trị','2020-02-24 14:09:20','2020-02-24 14:09:20'),('50','02','Sóc Trăng','Sóc Trăng','2020-02-24 14:09:20','2020-02-24 14:09:20'),('51','02','Sơn La','Sơn La','2020-02-24 14:09:20','2020-02-24 14:09:20'),('52','02','Tây Ninh','Tây Ninh','2020-02-24 14:09:20','2020-02-24 14:09:20'),('53','02','Thái Bình','Thái Bình','2020-02-24 14:09:20','2020-02-24 14:09:20'),('54','02','Thái Nguyên','Thái Nguyên','2020-02-24 14:09:21','2020-02-24 14:09:21'),('55','02','Thanh Hóa','Thanh Hóa','2020-02-24 14:09:21','2020-02-24 14:09:21'),('56','02','Thừa Thiên Huế','Thừa Thiên Huế','2020-02-24 14:09:21','2020-02-24 14:09:21'),('57','02','Tiền Giang','Tiền Giang','2020-02-24 14:09:21','2020-02-24 14:09:21'),('58','01','TP Hồ Chí Minh','TP Hồ Chí Minh','2020-02-24 14:09:21','2020-02-24 14:09:21'),('59','02','Trà Vinh','Trà Vinh','2020-02-24 14:09:21','2020-02-24 14:09:21'),('60','02','Tuyên Quang','Tuyên Quang','2020-02-24 14:09:21','2020-02-24 14:09:21'),('61','02','Vĩnh Long','Vĩnh Long','2020-02-24 14:09:21','2020-02-24 14:09:21'),('62','02','Vĩnh Phúc','Vĩnh Phúc','2020-02-24 14:09:21','2020-02-24 14:09:21'),('63','02','Yên Bái','Yên Bái','2020-02-24 14:09:21','2020-02-24 14:09:21');
/*!40000 ALTER TABLE `m_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_province_type`
--

DROP TABLE IF EXISTS `m_province_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `m_province_type` (
  `cd` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`cd`),
  UNIQUE KEY `cd_UNIQUE` (`cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_province_type`
--

LOCK TABLES `m_province_type` WRITE;
/*!40000 ALTER TABLE `m_province_type` DISABLE KEYS */;
INSERT INTO `m_province_type` VALUES ('01','Municipality','2020-02-20 15:34:21','2020-02-20 15:34:21'),('02','Province','2020-02-20 15:34:21','2020-02-20 15:34:21');
/*!40000 ALTER TABLE `m_province_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province_plates`
--

DROP TABLE IF EXISTS `province_plates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province_plates` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(20) NOT NULL,
  `vehicle_plates_id` bigint unsigned DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicle_pk_idx` (`vehicle_plates_id`),
  CONSTRAINT `vehicle_pk` FOREIGN KEY (`vehicle_plates_id`) REFERENCES `vehicle_registration_plates` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province_plates`
--

LOCK TABLES `province_plates` WRITE;
/*!40000 ALTER TABLE `province_plates` DISABLE KEYS */;
INSERT INTO `province_plates` VALUES (30,'50',13,'2020-02-24 14:11:04','2020-02-24 14:11:04'),(31,'51',13,'2020-02-24 14:11:04','2020-02-24 14:11:04'),(32,'53',13,'2020-02-24 14:11:04','2020-02-24 14:11:04'),(33,'59',13,'2020-02-24 14:11:04','2020-02-24 14:11:04'),(34,'29',14,'2020-02-24 14:11:38','2020-02-24 14:11:38'),(35,'30',14,'2020-02-24 14:11:38','2020-02-24 14:11:38'),(36,'43',15,'2020-02-24 14:12:06','2020-02-24 14:12:06'),(37,'65',16,'2020-02-24 14:12:18','2020-02-24 14:12:18'),(38,'72',17,'2020-02-24 14:13:10','2020-02-24 14:13:10'),(39,'77',18,'2020-02-24 14:13:19','2020-02-24 14:13:19');
/*!40000 ALTER TABLE `province_plates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user','user@email.com','$2a$04$oUXt9Rufs5s1v37Z/Qe2Su9QJyqnhwEpxxQEPoHNg41I9XNq0g0Bm',1),(12,'Admin','admin@email.com','$2a$10$0UByGVTrmrz0mAMpj53p0OJhfFCnNHH0Ni2wemxsRwBySRXBOiGNy',1),(13,'test1','test1@email.com','$2a$10$0MSoW0xWys8ZFAsKc4xQUOFAXALKwBFnoejL.9DDxEhIK3wIE8OHe',1),(14,'test2','test2@email.com','$2a$10$M5pi.dgSTcqd1i4a8mxpbuiYXAU3fpM6GI8UsLeiv2Qc8IOVZ/aIO',1),(15,'test3','test3@email.com','$2a$10$eMBCogc4rjVBIBw08TWl.OyPEDioMNnnDJgB2ga2QgS0J7p2u5Dkq',1),(16,'test4','test4@email.com','$2a$10$TraJ8v7qeknKS8Rj2XSO0uQAhrPTyJQ384l8kTWMVb1QmqoSsqpNG',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_registration_plates`
--

DROP TABLE IF EXISTS `vehicle_registration_plates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_registration_plates` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `province_cd` varchar(10) NOT NULL,
  `published` smallint DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `province_pk_idx` (`province_cd`),
  CONSTRAINT `province_pk` FOREIGN KEY (`province_cd`) REFERENCES `m_province` (`cd`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_registration_plates`
--

LOCK TABLES `vehicle_registration_plates` WRITE;
/*!40000 ALTER TABLE `vehicle_registration_plates` DISABLE KEYS */;
INSERT INTO `vehicle_registration_plates` VALUES (13,'58',1,'2020-02-24 14:11:04','2020-02-24 14:11:04'),(14,'24',1,'2020-02-24 14:11:38','2020-02-24 14:11:38'),(15,'15',1,'2020-02-24 14:12:06','2020-02-24 14:12:06'),(16,'13',1,'2020-02-24 14:12:18','2020-02-24 14:12:18'),(17,'02',1,'2020-02-24 14:13:10','2020-02-24 14:13:10'),(18,'08',1,'2020-02-24 14:13:19','2020-02-24 14:13:19');
/*!40000 ALTER TABLE `vehicle_registration_plates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-25  8:08:05
