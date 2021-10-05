-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: student_portal
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `sub_id` int DEFAULT NULL,
  `div_id` int DEFAULT NULL,
  `deadline` varchar(50) DEFAULT NULL,
  `assignment` varchar(100) DEFAULT NULL,
  `std_id` int DEFAULT NULL,
  `assignment_title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES (24,4,4,1,'21 Sept','f6df74efd39647228ae94a603f36798a',50,'OS'),(25,4,4,1,'21 september 2021','360a2547e9a34d2b976a7f51671d1755',50,'Tree');
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `division` (
  `id` int NOT NULL,
  `div_name` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'A'),(2,'B'),(3,'C');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institute`
--

DROP TABLE IF EXISTS `institute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `contact_no` varchar(30) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `profilepicture` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institute`
--

LOCK TABLES `institute` WRITE;
/*!40000 ALTER TABLE `institute` DISABLE KEYS */;
INSERT INTO `institute` VALUES (109,'New high school','newhighschool@gmail.com','8237214580','Shivaji Peth , Kolhapur','bea8bc60d45446488b6d628bb6838c7c'),(112,'Holy Cross High School','hollycrosshighschool@gmail.com','8237214581','MG road , Mumbai',NULL),(114,'Balak Mandir High School','balakmandirhighschool@gmail.com','8237214582','Sambhaji Nagar , Jalgaon',NULL),(115,'Saint Lawrence High School','saintlawrencehighschool@gmail.com','8237214583','RK Nagar , Nashik',NULL),(126,'Katrap Vidyalay',NULL,'88288996929','Kaly west,Mumbai',NULL);
/*!40000 ALTER TABLE `institute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `information` varchar(1000) DEFAULT NULL,
  `std_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (5,'This is to inform you that according to the Government of Maharashtra circular, that we have just received, the Diwali holidays will now commence from tomorrow 7th November, 2020 and conclude on 20th November, 2020.As a result, the online class assessment scheduled for the 7th and 9th of Noember, 2020 will be postponed to the 21st and 23rd November, 2020 respectively.We know you have worked very hard but it will hold you in good stead in the future. Remember to continue studying during the holidays and reviewing the portion completed. Use this vacation to spread peace and harmony.',50,4);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standard`
--

DROP TABLE IF EXISTS `standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `standard` (
  `id` int NOT NULL AUTO_INCREMENT,
  `std_name` varchar(5) DEFAULT NULL,
  `institute_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard`
--

LOCK TABLES `standard` WRITE;
/*!40000 ALTER TABLE `standard` DISABLE KEYS */;
INSERT INTO `standard` VALUES (50,'1',109),(51,'2',109),(52,'3',109),(53,'4',109),(82,'1',112),(83,'2',112);
/*!40000 ALTER TABLE `standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stddivinst`
--

DROP TABLE IF EXISTS `stddivinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stddivinst` (
  `std_id` int DEFAULT NULL,
  `div_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stddivinst`
--

LOCK TABLES `stddivinst` WRITE;
/*!40000 ALTER TABLE `stddivinst` DISABLE KEYS */;
INSERT INTO `stddivinst` VALUES (55,1),(55,2),(55,3),(51,1),(52,3),(82,1),(53,1),(50,1),(50,2),(50,3);
/*!40000 ALTER TABLE `stddivinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stdsubinst`
--

DROP TABLE IF EXISTS `stdsubinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stdsubinst` (
  `std_id` int DEFAULT NULL,
  `sub_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stdsubinst`
--

LOCK TABLES `stdsubinst` WRITE;
/*!40000 ALTER TABLE `stdsubinst` DISABLE KEYS */;
INSERT INTO `stdsubinst` VALUES (51,1),(51,2),(51,3),(51,4),(52,1),(52,2),(52,3),(52,4),(53,1),(53,2),(53,3),(53,4),(50,1),(50,2),(50,3),(50,4);
/*!40000 ALTER TABLE `stdsubinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `std_id` int DEFAULT NULL,
  `div_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `assignment_id` int DEFAULT NULL,
  `assignment_data` varchar(200) DEFAULT NULL,
  `stddetails_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (4,50,1,3,24,'0438f4fa3be84772ada2979ce32ddacd',1),(5,50,1,3,25,'0d35a204c640403b853f128fdcaf9462',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentdetails`
--

DROP TABLE IF EXISTS `studentdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `std_id` int DEFAULT NULL,
  `div_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdetails`
--

LOCK TABLES `studentdetails` WRITE;
/*!40000 ALTER TABLE `studentdetails` DISABLE KEYS */;
INSERT INTO `studentdetails` VALUES (1,50,1,3),(2,50,1,16);
/*!40000 ALTER TABLE `studentdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int DEFAULT NULL,
  `sub_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Mathematics'),(2,'Science'),(3,'History'),(4,'English');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectteacherstd`
--

DROP TABLE IF EXISTS `subjectteacherstd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjectteacherstd` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sub_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `std_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectteacherstd`
--

LOCK TABLES `subjectteacherstd` WRITE;
/*!40000 ALTER TABLE `subjectteacherstd` DISABLE KEYS */;
INSERT INTO `subjectteacherstd` VALUES (2,4,5,82),(6,1,10,50),(7,1,11,53),(8,4,12,50),(9,4,14,50),(10,4,14,51),(11,3,14,53),(17,4,4,50),(29,4,4,50);
/*!40000 ALTER TABLE `subjectteacherstd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherstddiv`
--

DROP TABLE IF EXISTS `teacherstddiv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherstddiv` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `div_id` int DEFAULT NULL,
  `std_id` int DEFAULT NULL,
  `sub_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherstddiv`
--

LOCK TABLES `teacherstddiv` WRITE;
/*!40000 ALTER TABLE `teacherstddiv` DISABLE KEYS */;
INSERT INTO `teacherstddiv` VALUES (5,5,1,82,NULL),(8,10,1,50,NULL),(9,11,1,53,NULL),(10,12,1,50,NULL),(11,14,1,50,NULL),(12,14,3,51,NULL),(13,14,1,53,NULL),(19,4,1,50,17),(37,4,3,50,29);
/*!40000 ALTER TABLE `teacherstddiv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_table`
--

DROP TABLE IF EXISTS `time_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(60) DEFAULT NULL,
  `std_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_table`
--

LOCK TABLES `time_table` WRITE;
/*!40000 ALTER TABLE `time_table` DISABLE KEYS */;
INSERT INTO `time_table` VALUES (12,'be6fc87ab5eb4592bf0364ab90bbdeb0',50,4);
/*!40000 ALTER TABLE `time_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `role` varchar(15) DEFAULT NULL,
  `institute_id` int DEFAULT NULL,
  `profilepicture` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'soham','vishwas','Soham Vishwas','$2a$10$NKv1K6qg54wEQdVP1NQcb.8.fGK14kfqeKvedkdk1Rads1q/kLy8W','sohamvishwas@gmail.com','8828996929','admin',109,NULL),(2,'Shubham','Paunikar','Shubham Paunikar','$2a$12$9Zp1AtQ3ZidULgCd2peI2.BZ5i2OxV3.IRLAQ65Ez4pxdTxmZK1Mq','shubhampaunikar@gmail.com','9878996929','institute_admin',109,NULL),(3,'Shubham','Survase','Shubham','$2a$10$f9NaOk5tWq.QsIfoSsHjeeW3e2qgeJruzDfzMBnlLQr7XU0V1BYVe','shubhamsurvase@gmail.com','8828996929','student',109,'9ba4604cc5ea4067a7f6b33a1eb56cfc'),(4,'Sudarshana','Sonawane','Sudarshana','$2a$10$DUeq7vtxJqbcU1gH2CjL1.8vQ.x97gP0/OCDiYsl4FX4kaOjGkPQ2','sudarshanasonawane@gmail.com','8828996929','teacher',109,'5b9085365997471280d891398282625f'),(5,'Akanksha','Gadilkar','Akanksha','$2a$12$dTWwUxh.r5cIIlKjJlc3.e9jYMTQ7Yp0ChJ1ba.zZlqe9GhPLA/u2','akankshagadilkar3604@gmail.com','8828996929','teacher',112,NULL),(6,'pratik','tiwari','pratik07','pratik','pratiktiwari@gmail.com','9702535617','student',112,NULL),(7,'omkar','thorat','omkar07','omkar','omkarthorat@gmail.com','9702535617','student',112,NULL),(14,'Tanuja','Vishwas','Tanuja09','tanuja','tanujavishwas@gmail.com','9702535617','teacher',109,NULL),(16,'pratik','tiwari','Pratik Tiwari',' $2a$12$2dixKIQvz9mcpFO/NuXcxuZJSSP4/cSToGHjJKcPLEckl1hRPzO9u','pratiktiwari@gmail.com','8828996929','student',109,'null');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-24  8:26:49
