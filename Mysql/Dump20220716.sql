-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `bbs`
--

DROP TABLE IF EXISTS `bbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bbs` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `id` varchar(50) NOT NULL,
  `ref` decimal(8,0) NOT NULL,
  `step` decimal(8,0) NOT NULL,
  `depth` decimal(8,0) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(4000) NOT NULL,
  `wdate` timestamp NOT NULL,
  `del` decimal(1,0) NOT NULL,
  `readcount` decimal(8,0) NOT NULL,
  PRIMARY KEY (`seq`),
  KEY `id` (`id`),
  CONSTRAINT `bbs_ibfk_1` FOREIGN KEY (`id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bbs`
--

LOCK TABLES `bbs` WRITE;
/*!40000 ALTER TABLE `bbs` DISABLE KEYS */;
INSERT INTO `bbs` VALUES (1,'123',1,0,0,'123','123','2022-07-04 04:57:58',1,2),(4,'asd',2,0,0,'123','123','2022-07-04 05:05:27',1,25),(5,'123',3,0,0,'더더','전 비상대책위원장의 8월 전당대회 당 대표 출마가 불가능해졌다.','2022-07-04 07:13:25',0,5),(6,'123',4,0,0,'민주당 우상호','비상대책위원장은 4일 비대위 회의에서 \"비대위에서 박 전 위원장의 전당대회 출마에 관한 사안을 논의했다\"며 \"당무위에 박 전 위원장의 출마를 위한 예외 조항을 안건으로 상정해 토론하도록 부의하지 않기로 했다\"고 밝혔다.','2022-07-04 06:52:54',0,0),(7,'123',5,0,0,'우 위원장','우 위원장은 \"비대위원들은 박 전 원장이 소중한 민주당의 인재이지만, 예외를 인정할 불가피한 사유를 발견하지 못했다고 판단했다\"고 설명했다.','2022-07-04 06:53:05',0,0),(8,'123',6,0,0,'박 전 위원장','앞서 박 전 위원장은 당권 도전 의사를 밝히면서 비대위와 당무위 의결을 거쳐 출마를 허용해달라고 촉구했다.','2022-07-04 06:53:16',0,0),(9,'123',7,0,0,'민주당 당헌','민주당 당헌·당규상 당직이나 공직 피선거권을 가지려면 이달 1일 기준으로 6개월 이전에 입당한 권리당원이어야 하는데, 지난 2월 14일 입당한 박 전 위원장은 이 기준을 충족하지 못하기 때문이다.','2022-07-04 06:53:28',0,2),(10,'123',8,0,0,'박 전 위원장은 당헌','이에 박 전 위원장은 당헌·당규상 \'당무위원회 의결로 달리할 수 있다\'는 단서 조항을 근거로 비대위와 당무위 의결을 요구한 것이다.','2022-07-04 06:53:43',0,0),(11,'123',9,0,0,'그러나 이런','그러나 이런 박 전 위원장의 요구에 대해 당 안팎에서는 \"사실상 개인을 위한 특혜를 요구한 것\"이라는 비판도 터져나왔다.','2022-07-04 06:54:14',0,0),(12,'123',10,0,0,'선언한 BTS','‘중단’ 선언한 BTS, 착륙일까 또 다른 이륙일까','2022-07-04 06:54:27',0,2),(13,'123',11,0,0,'방탄소년단','방탄소년단의 단체 활동 중단 소식이 알려지며 전 세계 팬들이 충격에 빠졌다. 하이브는 “팀 활동과 개별 활동을 병행하는 새로운 챕터를 시작한다”라고 밝혔다. 챕터 2의 초점은 솔로 활동이다.','2022-07-04 06:54:37',0,0);
/*!40000 ALTER TABLE `bbs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `department_id` int unsigned NOT NULL,
  `department_name` varchar(30) NOT NULL,
  `manager_id` int unsigned DEFAULT NULL,
  `location_id` int unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (10,'기획부',100,101),(20,'관리부',NULL,NULL),(40,'개발부',500,333);
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `employee_id` int unsigned NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `salary` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (100,'Steven',24000.00),(101,'Neena',17000.00),(102,'Lex',17000.00),(103,'Alexander',9000.00),(104,'Bruce',6000.00),(105,'David',4800.00),(106,'Valli',4800.00),(107,'Diana',4200.00),(108,'Nancy',12000.00),(109,'Daniel',9000.00),(110,'John',8200.00),(111,'Ismael',7700.00),(112,'Jose Manuel',7800.00),(113,'Luis',6900.00),(114,'Den',11000.00),(115,'Alexander',3100.00),(116,'Shelli',2900.00),(117,'Sigal',2800.00),(118,'Guy',2600.00),(119,'Karen',2500.00),(120,'Matthew',8000.00),(121,'Adam',8200.00),(122,'Payam',7900.00),(123,'Shanta',6500.00),(124,'Kevin',5800.00),(125,'Julia',3200.00),(126,'Irene',2700.00),(127,'James',2400.00),(128,'Steven',2200.00),(129,'Laura',3300.00),(130,'Mozhe',2800.00),(131,'James',2500.00),(132,'TJ',2100.00),(133,'Jason',3300.00),(134,'Michael',2900.00),(135,'Ki',2400.00),(136,'Hazel',2200.00),(137,'Renske',3600.00),(138,'Stephen',3200.00),(139,'John',2700.00),(140,'Joshua',2500.00),(141,'Trenna',3500.00),(142,'Curtis',3100.00),(143,'Randall',2600.00),(144,'Peter',2500.00),(145,'John',14000.00),(146,'Karen',13500.00),(147,'Alberto',12000.00),(148,'Gerald',11000.00),(149,'Eleni',10500.00),(150,'Peter',10000.00),(151,'David',9500.00),(152,'Peter',9000.00),(153,'Christopher',8000.00),(154,'Nanette',7500.00),(155,'Oliver',7000.00),(156,'Janette',10000.00),(157,'Patrick',9500.00),(158,'Allan',9000.00),(159,'Lindsey',8000.00),(160,'Louise',7500.00),(161,'Sarath',7000.00),(162,'Clara',10500.00),(163,'Danielle',9500.00),(164,'Mattea',7200.00),(165,'David',6800.00),(166,'Sundar',6400.00),(167,'Amit',6200.00),(168,'Lisa',11500.00),(169,'Harrison',10000.00),(170,'Tayler',9600.00),(171,'William',7400.00),(172,'Elizabeth',7300.00),(173,'Sundita',6100.00),(174,'Ellen',11000.00),(175,'Alyssa',8800.00),(176,'Jonathon',8600.00),(177,'Jack',8400.00),(178,'Kimberely',7000.00),(179,'Charles',6200.00),(180,'Winston',3200.00),(181,'Jean',3100.00),(182,'Martha',2500.00),(183,'Girard',2800.00),(184,'Nandita',4200.00),(185,'Alexis',4100.00),(186,'Julia',3400.00),(187,'Anthony',3000.00),(188,'Kelly',3800.00),(189,'Jennifer',3600.00),(190,'Timothy',2900.00),(191,'Randall',2500.00),(192,'Sarah',4000.00),(193,'Britney',3900.00),(194,'Samuel',3200.00),(195,'Vance',2800.00),(196,'Alana',3100.00),(197,'Kevin',3000.00),(198,'Donald',2600.00),(199,'Douglas',2600.00),(200,'Jennifer',4400.00),(201,'Michael',13000.00),(202,'Pat',6000.00),(203,'Susan',6500.00),(204,'Hermann',10000.00),(205,'Shelley',12000.00),(206,'William',8300.00),(300,'정수동',11000.00);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pds`
--

DROP TABLE IF EXISTS `pds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pds` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `id` varchar(50) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `filename` varchar(50) NOT NULL,
  `newfilename` varchar(50) NOT NULL,
  `readcount` decimal(8,0) NOT NULL,
  `downcount` decimal(8,0) NOT NULL,
  `regdate` timestamp NOT NULL,
  PRIMARY KEY (`seq`),
  KEY `id` (`id`),
  CONSTRAINT `pds_ibfk_1` FOREIGN KEY (`id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pds`
--

LOCK TABLES `pds` WRITE;
/*!40000 ALTER TABLE `pds` DISABLE KEYS */;
INSERT INTO `pds` VALUES (1,'123','123','123','.gitignore','1657161795546.gitignore',0,0,'2022-07-07 02:43:15'),(2,'123','234','234','메모1.txt','1657161885128.txt',0,0,'2022-07-07 02:44:45'),(3,'123','345','345','.gitattributes','1657162156742.gitattributes',0,0,'2022-07-07 02:49:16'),(4,'123','666','666','.gitignore','1657164417002.gitignore',0,0,'2022-07-07 03:26:57'),(5,'123','777','777','README.md','1657164492925.md',0,0,'2022-07-07 03:28:12');
/*!40000 ALTER TABLE `pds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poll`
--

DROP TABLE IF EXISTS `poll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poll` (
  `pollid` int NOT NULL AUTO_INCREMENT,
  `id` varchar(50) NOT NULL,
  `question` varchar(1000) NOT NULL,
  `sdate` date NOT NULL,
  `edate` date NOT NULL,
  `itemcount` int NOT NULL,
  `polltotal` decimal(8,0) NOT NULL,
  `regdate` date NOT NULL,
  PRIMARY KEY (`pollid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poll`
--

LOCK TABLES `poll` WRITE;
/*!40000 ALTER TABLE `poll` DISABLE KEYS */;
INSERT INTO `poll` VALUES (1,'test','gdgd','2021-01-01','2021-03-03',0,0,'2021-03-03');
/*!40000 ALTER TABLE `poll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pollsub`
--

DROP TABLE IF EXISTS `pollsub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pollsub` (
  `pollsubid` int NOT NULL AUTO_INCREMENT,
  `pollid` int NOT NULL,
  `answer` varchar(1000) NOT NULL,
  `acount` decimal(8,0) NOT NULL,
  PRIMARY KEY (`pollsubid`),
  KEY `pollsub_fk` (`pollid`),
  CONSTRAINT `pollsub_fk` FOREIGN KEY (`pollid`) REFERENCES `poll` (`pollid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pollsub`
--

LOCK TABLES `pollsub` WRITE;
/*!40000 ALTER TABLE `pollsub` DISABLE KEYS */;
/*!40000 ALTER TABLE `pollsub` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-16  9:36:38
