-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: it6020003_data_tx2
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `tblassignment`
--

DROP TABLE IF EXISTS `tblassignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblassignment` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `todo_id` int DEFAULT NULL,
  `assignment_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  KEY `user_id` (`user_id`),
  KEY `todo_id` (`todo_id`),
  CONSTRAINT `tblassignment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbluser` (`user_id`),
  CONSTRAINT `tblassignment_ibfk_2` FOREIGN KEY (`todo_id`) REFERENCES `tbltodo` (`todo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblassignment`
--

LOCK TABLES `tblassignment` WRITE;
/*!40000 ALTER TABLE `tblassignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblassignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblattachment`
--

DROP TABLE IF EXISTS `tblattachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblattachment` (
  `attachment_id` int NOT NULL AUTO_INCREMENT,
  `todo_id` int DEFAULT NULL,
  `attachment_name` varchar(255) NOT NULL,
  `attachment_src` text,
  PRIMARY KEY (`attachment_id`),
  KEY `todo_id` (`todo_id`),
  CONSTRAINT `tblattachment_ibfk_1` FOREIGN KEY (`todo_id`) REFERENCES `tbltodo` (`todo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblattachment`
--

LOCK TABLES `tblattachment` WRITE;
/*!40000 ALTER TABLE `tblattachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblattachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcomment`
--

DROP TABLE IF EXISTS `tblcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcomment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `todo_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `comment_text` text,
  `comment_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `todo_id` (`todo_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tblcomment_ibfk_1` FOREIGN KEY (`todo_id`) REFERENCES `tbltodo` (`todo_id`),
  CONSTRAINT `tblcomment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbluser` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcomment`
--

LOCK TABLES `tblcomment` WRITE;
/*!40000 ALTER TABLE `tblcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcover`
--

DROP TABLE IF EXISTS `tblcover`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcover` (
  `cover_id` int NOT NULL AUTO_INCREMENT,
  `todo_id` int DEFAULT NULL,
  `cover_name` varchar(255) NOT NULL,
  `cover_color` varchar(50) DEFAULT NULL,
  `cover_image_src` text,
  PRIMARY KEY (`cover_id`),
  KEY `todo_id` (`todo_id`),
  CONSTRAINT `tblcover_ibfk_1` FOREIGN KEY (`todo_id`) REFERENCES `tbltodo` (`todo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcover`
--

LOCK TABLES `tblcover` WRITE;
/*!40000 ALTER TABLE `tblcover` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblcover` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmember`
--

DROP TABLE IF EXISTS `tblmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblmember` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `working_space_id` int DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `user_id` (`user_id`),
  KEY `working_space_id` (`working_space_id`),
  CONSTRAINT `tblmember_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbluser` (`user_id`),
  CONSTRAINT `tblmember_ibfk_2` FOREIGN KEY (`working_space_id`) REFERENCES `tblworkspace` (`working_space_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmember`
--

LOCK TABLES `tblmember` WRITE;
/*!40000 ALTER TABLE `tblmember` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproject`
--

DROP TABLE IF EXISTS `tblproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblproject` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) NOT NULL,
  `working_space_id` int DEFAULT NULL,
  `project_create_date` date DEFAULT NULL,
  `project_start_date` date DEFAULT NULL,
  `project_end_date` date DEFAULT NULL,
  `project_status` varchar(50) DEFAULT NULL,
  `project_background_src` text,
  `project_icon_url` text,
  PRIMARY KEY (`project_id`),
  KEY `working_space_id` (`working_space_id`),
  CONSTRAINT `tblproject_ibfk_1` FOREIGN KEY (`working_space_id`) REFERENCES `tblworkspace` (`working_space_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproject`
--

LOCK TABLES `tblproject` WRITE;
/*!40000 ALTER TABLE `tblproject` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltag`
--

DROP TABLE IF EXISTS `tbltag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltag` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `task_id` int DEFAULT NULL,
  `tag_name` varchar(255) NOT NULL,
  `tag_color` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `task_id` (`task_id`),
  CONSTRAINT `tbltag_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `tbltask` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltag`
--

LOCK TABLES `tbltag` WRITE;
/*!40000 ALTER TABLE `tbltag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltask`
--

DROP TABLE IF EXISTS `tbltask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltask` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `task_name` varchar(255) NOT NULL,
  `work_id` int DEFAULT NULL,
  `task_position` int DEFAULT NULL,
  `task_description` text,
  `task_cover_img_src` text,
  `task_start_date` date DEFAULT NULL,
  `task_expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `work_id` (`work_id`),
  CONSTRAINT `tbltask_ibfk_1` FOREIGN KEY (`work_id`) REFERENCES `tblwork` (`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltask`
--

LOCK TABLES `tbltask` WRITE;
/*!40000 ALTER TABLE `tbltask` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltickstar`
--

DROP TABLE IF EXISTS `tbltickstar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltickstar` (
  `tick_star_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `project_id` int DEFAULT NULL,
  `user_tick_star` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`tick_star_id`),
  KEY `user_id` (`user_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tbltickstar_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbluser` (`user_id`),
  CONSTRAINT `tbltickstar_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `tblproject` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltickstar`
--

LOCK TABLES `tbltickstar` WRITE;
/*!40000 ALTER TABLE `tbltickstar` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltickstar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltodo`
--

DROP TABLE IF EXISTS `tbltodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltodo` (
  `todo_id` int NOT NULL AUTO_INCREMENT,
  `todo_name` varchar(255) NOT NULL,
  `todolist_id` int DEFAULT NULL,
  `todo_expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`todo_id`),
  KEY `todolist_id` (`todolist_id`),
  CONSTRAINT `tbltodo_ibfk_1` FOREIGN KEY (`todolist_id`) REFERENCES `tbltodolist` (`todolist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltodo`
--

LOCK TABLES `tbltodo` WRITE;
/*!40000 ALTER TABLE `tbltodo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltodolist`
--

DROP TABLE IF EXISTS `tbltodolist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltodolist` (
  `todolist_id` int NOT NULL AUTO_INCREMENT,
  `todolist_name` varchar(255) NOT NULL,
  `task_id` int DEFAULT NULL,
  PRIMARY KEY (`todolist_id`),
  KEY `task_id` (`task_id`),
  CONSTRAINT `tbltodolist_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `tbltask` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltodolist`
--

LOCK TABLES `tbltodolist` WRITE;
/*!40000 ALTER TABLE `tbltodolist` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltodolist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbluser` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_parent_id` int DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_background_src` text,
  `user_background_avatar_src` text,
  `user_created_date` date DEFAULT NULL,
  `user_recently_viewed` text,
  `user_password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_fullname` varchar(255) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_mobilephone` varchar(20) DEFAULT NULL,
  `user_homephone` varchar(20) DEFAULT NULL,
  `user_address` text,
  `user_jobarea` varchar(255) DEFAULT NULL,
  `user_job` varchar(255) DEFAULT NULL,
  `user_roles` text,
  `user_logged_in` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluser`
--

LOCK TABLES `tbluser` WRITE;
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblwork`
--

DROP TABLE IF EXISTS `tblwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblwork` (
  `work_id` int NOT NULL AUTO_INCREMENT,
  `work_name` varchar(255) NOT NULL,
  `project_id` int DEFAULT NULL,
  `work_position` varchar(255) DEFAULT NULL,
  `work_create_date` date DEFAULT NULL,
  PRIMARY KEY (`work_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tblwork_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tblproject` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblwork`
--

LOCK TABLES `tblwork` WRITE;
/*!40000 ALTER TABLE `tblwork` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblworkspace`
--

DROP TABLE IF EXISTS `tblworkspace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblworkspace` (
  `working_space_id` int NOT NULL AUTO_INCREMENT,
  `working_space_name` varchar(255) NOT NULL,
  `user_id` int DEFAULT NULL,
  `working_space_create_date` date DEFAULT NULL,
  `working_space_background_src` text,
  `working_space_avatar_src` text,
  PRIMARY KEY (`working_space_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tblworkspace_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbluser` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblworkspace`
--

LOCK TABLES `tblworkspace` WRITE;
/*!40000 ALTER TABLE `tblworkspace` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblworkspace` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05 18:48:05
