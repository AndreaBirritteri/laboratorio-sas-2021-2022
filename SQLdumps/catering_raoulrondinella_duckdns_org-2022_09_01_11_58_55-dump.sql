-- MySQL dump 10.13  Distrib 8.0.30, for macos12.4 (arm64)
--
-- Host: raoulrondinella.duckdns.org    Database: catering
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `Events`
--

DROP TABLE IF EXISTS `Events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Events` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `date_start` date DEFAULT NULL,
  `date_end` date DEFAULT NULL,
  `expected_participants` int DEFAULT NULL,
  `organizer_id` int NOT NULL,
  `chef_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Events`
--

LOCK TABLES `Events` WRITE;
/*!40000 ALTER TABLE `Events` DISABLE KEYS */;
INSERT INTO `Events` (`id`, `name`, `date_start`, `date_end`, `expected_participants`, `organizer_id`, `chef_id`) VALUES (1,'Convegno Agile Community','2020-09-25','2020-09-25',100,2,3),(2,'Compleanno di Manuela','2020-08-13','2020-08-13',25,2,2),(3,'Fiera del Sedano Rapa','2020-10-02','2020-10-04',400,1,4);
/*!40000 ALTER TABLE `Events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KitchenSheets`
--

DROP TABLE IF EXISTS `KitchenSheets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KitchenSheets` (
  `id` int NOT NULL,
  `title` char(64) DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KitchenSheets`
--

LOCK TABLES `KitchenSheets` WRITE;
/*!40000 ALTER TABLE `KitchenSheets` DISABLE KEYS */;
INSERT INTO `KitchenSheets` (`id`, `title`, `service_id`) VALUES (0,'Convegno Agile Community',1);
/*!40000 ALTER TABLE `KitchenSheets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KitchenTasks`
--

DROP TABLE IF EXISTS `KitchenTasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KitchenTasks` (
  `id` int NOT NULL,
  `priority` int DEFAULT NULL,
  `minutes` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `completed` int DEFAULT NULL,
  `shift_when` char(64) DEFAULT NULL,
  `cook_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KitchenTasks`
--

LOCK TABLES `KitchenTasks` WRITE;
/*!40000 ALTER TABLE `KitchenTasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `KitchenTasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MenuFeatures`
--

DROP TABLE IF EXISTS `MenuFeatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MenuFeatures` (
  `menu_id` int NOT NULL,
  `name` varchar(128) NOT NULL DEFAULT '',
  `value` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MenuFeatures`
--

LOCK TABLES `MenuFeatures` WRITE;
/*!40000 ALTER TABLE `MenuFeatures` DISABLE KEYS */;
INSERT INTO `MenuFeatures` (`menu_id`, `name`, `value`) VALUES (80,'Richiede cuoco',0),(80,'Buffet',0),(80,'Richiede cucina',0),(80,'Finger food',0),(80,'Piatti caldi',0),(82,'Richiede cuoco',0),(82,'Buffet',0),(82,'Richiede cucina',0),(82,'Finger food',0),(82,'Piatti caldi',0),(86,'Richiede cuoco',0),(86,'Buffet',0),(86,'Richiede cucina',0),(86,'Finger food',0),(86,'Piatti caldi',0),(93,'Richiede cuoco',0),(93,'Buffet',0),(93,'Richiede cucina',0),(93,'Finger food',0),(93,'Piatti caldi',0),(94,'Richiede cuoco',1),(94,'Buffet',1),(94,'Richiede cucina',1),(94,'Finger food',1),(94,'Piatti caldi',1),(95,'Richiede cuoco',0),(95,'Buffet',0),(95,'Richiede cucina',0),(95,'Finger food',0),(95,'Piatti caldi',0);
/*!40000 ALTER TABLE `MenuFeatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MenuItems`
--

DROP TABLE IF EXISTS `MenuItems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MenuItems` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int NOT NULL,
  `section_id` int DEFAULT NULL,
  `description` tinytext,
  `recipe_id` int NOT NULL,
  `position` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MenuItems`
--

LOCK TABLES `MenuItems` WRITE;
/*!40000 ALTER TABLE `MenuItems` DISABLE KEYS */;
INSERT INTO `MenuItems` (`id`, `menu_id`, `section_id`, `description`, `recipe_id`, `position`) VALUES (96,80,0,'Croissant vuoti',9,0),(97,80,0,'Croissant alla marmellata',9,1),(98,80,0,'Pane al cioccolato mignon',10,2),(99,80,0,'Panini al latte con prosciutto crudo',12,4),(100,80,0,'Panini al latte con prosciutto cotto',12,5),(101,80,0,'Panini al latte con formaggio spalmabile alle erbe',12,6),(102,80,0,'Girelle all\'uvetta mignon',11,3),(103,82,0,'Biscotti',13,1),(104,82,0,'Lingue di gatto',14,2),(105,82,0,'Bigné alla crema',15,3),(106,82,0,'Bigné al caffè',15,4),(107,82,0,'Pizzette',16,5),(108,82,0,'Croissant al prosciutto crudo mignon',9,6),(109,82,0,'Tramezzini tonno e carciofini mignon',17,7),(112,86,41,'Vitello tonnato',1,0),(113,86,41,'Carpaccio di spada',2,1),(114,86,41,'Alici marinate',3,2),(115,86,42,'Penne alla messinese',5,0),(116,86,42,'Risotto alla zucca',20,1),(117,86,43,'Salmone al forno',8,0),(118,86,44,'Sorbetto al limone',18,0),(119,86,44,'Torta Saint Honoré',19,1),(133,93,52,'Vitello tonnato',1,0),(134,93,52,'Insalatina fresca',7,1),(136,94,53,'Vitello tonnato',1,0),(137,94,53,'Carpaccio di spada',2,1),(138,94,53,'Alici marinate',3,2),(139,94,55,'Hamburger con bacon e cipolla caramellata',7,0),(140,94,55,'Salmone al forno',8,1),(141,94,0,'Insalata di riso',4,0),(142,94,0,'Penne al sugo di baccalà',5,1);
/*!40000 ALTER TABLE `MenuItems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MenuSections`
--

DROP TABLE IF EXISTS `MenuSections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MenuSections` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int NOT NULL,
  `name` tinytext,
  `position` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MenuSections`
--

LOCK TABLES `MenuSections` WRITE;
/*!40000 ALTER TABLE `MenuSections` DISABLE KEYS */;
INSERT INTO `MenuSections` (`id`, `menu_id`, `name`, `position`) VALUES (41,86,'Antipasti',0),(42,86,'Primi',1),(43,86,'Secondi',2),(44,86,'Dessert',3),(45,87,'Antipasti',0),(52,93,'nfhfjfjf',0),(53,94,'Antipasti',0),(54,94,'Primi',1),(55,94,'Secondi',2),(56,95,'Antipasti',0),(57,95,'Primi',1);
/*!40000 ALTER TABLE `MenuSections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Menus`
--

DROP TABLE IF EXISTS `Menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Menus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` tinytext,
  `owner_id` int DEFAULT NULL,
  `published` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menus`
--

LOCK TABLES `Menus` WRITE;
/*!40000 ALTER TABLE `Menus` DISABLE KEYS */;
INSERT INTO `Menus` (`id`, `title`, `owner_id`, `published`) VALUES (80,'Coffee break mattutino',2,1),(82,'Coffee break pomeridiano',2,1),(86,'Cena di compleanno pesce',3,1),(93,'Pranzo',2,1),(94,'Titolo Nuovo',2,1),(95,'Menu Pinco Pallino',2,0);
/*!40000 ALTER TABLE `Menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recipes`
--

DROP TABLE IF EXISTS `Recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Recipes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Recipes`
--

LOCK TABLES `Recipes` WRITE;
/*!40000 ALTER TABLE `Recipes` DISABLE KEYS */;
INSERT INTO `Recipes` (`id`, `name`) VALUES (1,'Vitello tonnato'),(2,'Carpaccio di spada'),(3,'Alici marinate'),(4,'Insalata di riso'),(5,'Penne al sugo di baccalà'),(6,'Pappa al pomodoro'),(7,'Hamburger con bacon e cipolla caramellata'),(8,'Salmone al forno'),(9,'Croissant'),(10,'Pane al cioccolato'),(11,'Girelle all\'uvetta'),(12,'Panini al latte'),(13,'Biscotti di pasta frolla'),(14,'Lingue di gatto'),(15,'Bigné farciti'),(16,'Pizzette'),(17,'Tramezzini'),(18,'Sorbetto al limone'),(19,'Torta Saint Honoré'),(20,'Risotto alla zucca');
/*!40000 ALTER TABLE `Recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Roles` (
  `id` char(1) NOT NULL,
  `role` varchar(128) NOT NULL DEFAULT 'servizio',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
INSERT INTO `Roles` (`id`, `role`) VALUES ('c','cuoco'),('h','chef'),('o','organizzatore'),('s','servizio');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Services`
--

DROP TABLE IF EXISTS `Services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `proposed_menu_id` int NOT NULL DEFAULT '0',
  `approved_menu_id` int DEFAULT '0',
  `service_date` date DEFAULT NULL,
  `time_start` time DEFAULT NULL,
  `time_end` time DEFAULT NULL,
  `expected_participants` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Services`
--

LOCK TABLES `Services` WRITE;
/*!40000 ALTER TABLE `Services` DISABLE KEYS */;
INSERT INTO `Services` (`id`, `event_id`, `name`, `proposed_menu_id`, `approved_menu_id`, `service_date`, `time_start`, `time_end`, `expected_participants`) VALUES (1,2,'Cena',86,0,'2020-08-13','20:00:00','23:30:00',25),(2,1,'Coffee break mattino',0,80,'2020-09-25','10:30:00','11:30:00',100),(3,1,'Colazione di lavoro',0,0,'2020-09-25','13:00:00','14:00:00',80),(4,1,'Coffee break pomeriggio',0,82,'2020-09-25','16:00:00','16:30:00',100),(5,1,'Cena sociale',0,0,'2020-09-25','20:00:00','22:30:00',40),(6,3,'Pranzo giorno 1',0,0,'2020-10-02','12:00:00','15:00:00',200),(7,3,'Pranzo giorno 2',0,0,'2020-10-03','12:00:00','15:00:00',300),(8,3,'Pranzo giorno 3',0,0,'2020-10-04','12:00:00','15:00:00',400);
/*!40000 ALTER TABLE `Services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserRoles`
--

DROP TABLE IF EXISTS `UserRoles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserRoles` (
  `user_id` int NOT NULL,
  `role_id` char(1) NOT NULL DEFAULT 's'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserRoles`
--

LOCK TABLES `UserRoles` WRITE;
/*!40000 ALTER TABLE `UserRoles` DISABLE KEYS */;
INSERT INTO `UserRoles` (`user_id`, `role_id`) VALUES (1,'o'),(2,'o'),(2,'h'),(3,'h'),(4,'h'),(4,'c'),(5,'c'),(6,'c'),(7,'c'),(8,'s'),(9,'s'),(10,'s'),(7,'s');
/*!40000 ALTER TABLE `UserRoles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` (`id`, `username`) VALUES (1,'Carlin'),(2,'Lidia'),(3,'Tony'),(4,'Marinella'),(5,'Guido'),(6,'Antonietta'),(7,'Paola'),(8,'Silvia'),(9,'Marco'),(10,'Piergiorgio');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-01 11:59:11
