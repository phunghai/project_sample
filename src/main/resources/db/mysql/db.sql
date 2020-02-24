CREATE DATABASE  IF NOT EXISTS `demo_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities_users`
--

LOCK TABLES `authorities_users` WRITE;
/*!40000 ALTER TABLE `authorities_users` DISABLE KEYS */;
INSERT INTO `authorities_users` VALUES (1,2),(2,1),(5,1),(6,1),(7,1),(8,1),(9,1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_province`
--

LOCK TABLES `m_province` WRITE;
/*!40000 ALTER TABLE `m_province` DISABLE KEYS */;
INSERT INTO `m_province` VALUES ('01','01','Hà Nội','Ha Noi','2020-02-20 15:40:30','2020-02-20 15:40:30'),('02','01','Tp Hồ Chí Minh','Ho Chi Minh','2020-02-20 15:41:45','2020-02-20 15:41:45'),('03','01','Da Nang','Da Nang',NULL,NULL),('04','01','Hai Phong','Hai Phong',NULL,NULL),('05','01','Can Tho','Can Tho',NULL,NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province_plates`
--

LOCK TABLES `province_plates` WRITE;
/*!40000 ALTER TABLE `province_plates` DISABLE KEYS */;
INSERT INTO `province_plates` VALUES (1,'50',2,NULL,NULL),(2,'51',2,NULL,NULL),(3,'29',1,NULL,NULL),(4,'30',1,NULL,NULL),(17,'43',10,'2020-02-24 08:27:17','2020-02-24 08:27:17'),(18,'44',10,'2020-02-24 08:27:17','2020-02-24 08:27:17'),(19,'45',10,'2020-02-24 08:27:17','2020-02-24 08:27:17'),(20,'23',11,'2020-02-24 08:27:30','2020-02-24 08:27:30'),(21,'24',11,'2020-02-24 08:27:30','2020-02-24 08:27:30'),(22,'25',11,'2020-02-24 08:27:30','2020-02-24 08:27:30'),(29,'65\r',12,'2020-02-24 13:40:57','2020-02-24 13:40:57');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user','user@email.com','$2a$04$oUXt9Rufs5s1v37Z/Qe2Su9QJyqnhwEpxxQEPoHNg41I9XNq0g0Bm',1),(2,'demo','demo@email.com','$2a$04$oUXt9Rufs5s1v37Z/Qe2Su9QJyqnhwEpxxQEPoHNg41I9XNq0g0Bm',1),(5,'Hai','hai@email.com','$2a$10$uYPHgA5MlkYNrGrpL176oe2alWxLPfiRE8.1G7EzYZSCgzlFQkVES',1),(6,'Hai','teo@email.com','$2a$10$mBNtBnNKQ5k3nM.EfnmKhOVXQAs7DkL2TFU4OIxm9ZcasUgX6o73W',1),(7,'Aeeee','ba@email.com','$2a$10$leDBiIqqmRiwYS/FKKYIYe9rYleNCKwy0s84dLEB5qqJ9ZAOSwn0O',1),(8,'Admin','admin@email.com','$2a$10$a8ogOA9kfCly3Tsheh/6KuhgsXNA4s0m7f/iGgkgubb.S35t3nIA2',1),(9,'Bon1','bon@email.com','$2a$10$hbnjeKz/wiLtckz.GEgFr.ftsX33ciGjEaBxWdmZFU5um4KG4vlQO',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_registration_plates`
--

LOCK TABLES `vehicle_registration_plates` WRITE;
/*!40000 ALTER TABLE `vehicle_registration_plates` DISABLE KEYS */;
INSERT INTO `vehicle_registration_plates` VALUES (1,'01',1,NULL,NULL),(2,'02',1,NULL,NULL),(10,'03',1,'2020-02-24 08:27:17','2020-02-24 08:27:17'),(11,'04',1,'2020-02-24 08:27:30','2020-02-24 08:27:30'),(12,'05',0,'2020-02-24 08:27:50','2020-02-24 08:27:50');
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

-- Dump completed on 2020-02-24 13:48:08
