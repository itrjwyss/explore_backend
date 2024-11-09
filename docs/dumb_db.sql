-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (x86_64)
--
-- Host: commerce.c75cqprpydtw.us-east-2.rds.amazonaws.com    Database: gioconda
-- ------------------------------------------------------
-- Server version	8.0.35

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `browser`
--

DROP TABLE IF EXISTS `browser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `browser` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(25) NOT NULL,
  `name` varchar(50) NOT NULL,
  `os` varchar(25) NOT NULL,
  `os_version` varchar(10) NOT NULL,
  `vendor` varchar(50) DEFAULT NULL,
  `version` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `browser`
--

LOCK TABLES `browser` WRITE;
/*!40000 ALTER TABLE `browser` DISABLE KEYS */;
/*!40000 ALTER TABLE `browser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `state_location_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UniqueNameAndStateLocation` (`name`,`state_location_id`),
  KEY `IDXqsstlki7ni5ovaariyy9u8y79` (`name`),
  KEY `FKlc5abxoi5tdsk67li1yd4gsec` (`state_location_id`),
  CONSTRAINT `FKlc5abxoi5tdsk67li1yd4gsec` FOREIGN KEY (`state_location_id`) REFERENCES `state_location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `iso` varchar(2) NOT NULL,
  `name` varchar(80) NOT NULL,
  `state_label` varchar(30) DEFAULT NULL,
  `city_label` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2cfxo3eh7tywg545x36fugy7i` (`iso`),
  UNIQUE KEY `UKllidyp77h6xkeokpbmoy710d4` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'AF','Afghanistan',NULL,NULL),(2,'AL','Albania',NULL,NULL),(3,'DZ','Algeria',NULL,NULL),(4,'AS','American Samoa',NULL,NULL),(5,'AD','Andorra',NULL,NULL),(6,'AO','Angola',NULL,NULL),(7,'AI','Anguilla',NULL,NULL),(8,'AQ','Antarctica',NULL,NULL),(9,'AG','Antigua and Barbuda',NULL,NULL),(10,'AR','Argentina',NULL,NULL),(11,'AM','Armenia',NULL,NULL),(12,'AW','Aruba',NULL,NULL),(13,'AU','Australia',NULL,NULL),(14,'AT','Austria',NULL,NULL),(15,'AZ','Azerbaijan',NULL,NULL),(16,'BS','Bahamas',NULL,NULL),(17,'BH','Bahrain',NULL,NULL),(18,'BD','Bangladesh',NULL,NULL),(19,'BB','Barbados',NULL,NULL),(20,'BY','Belarus',NULL,NULL),(21,'BE','Belgium',NULL,NULL),(22,'BZ','Belize',NULL,NULL),(23,'BJ','Benin',NULL,NULL),(24,'BM','Bermuda',NULL,NULL),(25,'BT','Bhutan',NULL,NULL),(26,'BO','Bolivia',NULL,NULL),(27,'BA','Bosnia and Herzegovina',NULL,NULL),(28,'BW','Botswana',NULL,NULL),(29,'BR','Brazil',NULL,NULL),(30,'IO','British Indian Ocean Territory',NULL,NULL),(31,'BN','Brunei Darussalam',NULL,NULL),(32,'BG','Bulgaria',NULL,NULL),(33,'BF','Burkina Faso',NULL,NULL),(34,'BI','Burundi',NULL,NULL),(35,'CV','Cabo Verde',NULL,NULL),(36,'KH','Cambodia',NULL,NULL),(37,'CM','Cameroon',NULL,NULL),(38,'CA','Canada',NULL,NULL),(39,'KY','Cayman Islands',NULL,NULL),(40,'CF','Central African Republic',NULL,NULL),(41,'TD','Chad',NULL,NULL),(42,'CL','Chile',NULL,NULL),(43,'CN','China',NULL,NULL),(44,'CO','Colombia',NULL,NULL),(45,'KM','Comoros',NULL,NULL),(46,'CG','Congo (Congo-Brazzaville)',NULL,NULL),(47,'CD','Congo (DRC)',NULL,NULL),(48,'CR','Costa Rica',NULL,NULL),(49,'CI','Côte d’Ivoire',NULL,NULL),(50,'HR','Croatia',NULL,NULL),(51,'CU','Cuba',NULL,NULL),(52,'CY','Cyprus',NULL,NULL),(53,'CZ','Czechia (Czech Republic)',NULL,NULL),(54,'DK','Denmark',NULL,NULL),(55,'DJ','Djibouti',NULL,NULL),(56,'DM','Dominica',NULL,NULL),(57,'DO','Dominican Republic',NULL,NULL),(58,'EC','Ecuador',NULL,NULL),(59,'EG','Egypt',NULL,NULL),(60,'SV','El Salvador',NULL,NULL),(61,'GQ','Equatorial Guinea',NULL,NULL),(62,'ER','Eritrea',NULL,NULL),(63,'EE','Estonia',NULL,NULL),(64,'SZ','Eswatini (fmr. \"Swaziland\")',NULL,NULL),(65,'ET','Ethiopia',NULL,NULL),(66,'FJ','Fiji',NULL,NULL),(67,'FI','Finland',NULL,NULL),(68,'FR','France',NULL,NULL),(69,'GA','Gabon',NULL,NULL),(70,'GM','Gambia',NULL,NULL),(71,'GE','Georgia',NULL,NULL),(72,'DE','Germany',NULL,NULL),(73,'GH','Ghana',NULL,NULL),(74,'GR','Greece',NULL,NULL),(75,'GD','Grenada',NULL,NULL),(76,'GU','Guam',NULL,NULL),(77,'GT','Guatemala',NULL,NULL),(78,'GN','Guinea',NULL,NULL),(79,'GW','Guinea-Bissau',NULL,NULL),(80,'GY','Guyana',NULL,NULL),(81,'HT','Haiti',NULL,NULL),(82,'VA','Holy See',NULL,NULL),(83,'HN','Honduras',NULL,NULL),(84,'HK','Hong Kong',NULL,NULL),(85,'HU','Hungary',NULL,NULL),(86,'IS','Iceland',NULL,NULL),(87,'IN','India',NULL,NULL),(88,'ID','Indonesia',NULL,NULL),(89,'IR','Iran',NULL,NULL),(90,'IQ','Iraq',NULL,NULL),(91,'IE','Ireland',NULL,NULL),(92,'IL','Israel',NULL,NULL),(93,'IT','Italy',NULL,NULL),(94,'JM','Jamaica',NULL,NULL),(95,'JP','Japan',NULL,NULL),(96,'JO','Jordan',NULL,NULL),(97,'KZ','Kazakhstan',NULL,NULL),(98,'KE','Kenya',NULL,NULL),(99,'KI','Kiribati',NULL,NULL),(100,'KP','Korea (North)',NULL,NULL),(101,'KR','Korea (South)',NULL,NULL),(102,'KW','Kuwait',NULL,NULL),(103,'KG','Kyrgyzstan',NULL,NULL),(104,'LA','Lao PDR',NULL,NULL),(105,'LV','Latvia',NULL,NULL),(106,'LB','Lebanon',NULL,NULL),(107,'LS','Lesotho',NULL,NULL),(108,'LR','Liberia',NULL,NULL),(109,'LY','Libya',NULL,NULL),(110,'LI','Liechtenstein',NULL,NULL),(111,'LT','Lithuania',NULL,NULL),(112,'LU','Luxembourg',NULL,NULL),(113,'MG','Madagascar',NULL,NULL),(114,'MW','Malawi',NULL,NULL),(115,'MY','Malaysia',NULL,NULL),(116,'MV','Maldives',NULL,NULL),(117,'ML','Mali',NULL,NULL),(118,'MT','Malta',NULL,NULL),(119,'MH','Marshall Islands',NULL,NULL),(120,'MR','Mauritania',NULL,NULL),(121,'MU','Mauritius',NULL,NULL),(122,'MX','Mexico',NULL,NULL),(123,'FM','Micronesia',NULL,NULL),(124,'MD','Moldova',NULL,NULL),(125,'MC','Monaco',NULL,NULL),(126,'MN','Mongolia',NULL,NULL),(127,'ME','Montenegro',NULL,NULL),(128,'MA','Morocco',NULL,NULL),(129,'MZ','Mozambique',NULL,NULL),(130,'MM','Myanmar (formerly Burma)',NULL,NULL),(131,'NA','Namibia',NULL,NULL),(132,'NR','Nauru',NULL,NULL),(133,'NP','Nepal',NULL,NULL),(134,'NL','Netherlands',NULL,NULL),(135,'NZ','New Zealand',NULL,NULL),(136,'NI','Nicaragua',NULL,NULL),(137,'NE','Niger',NULL,NULL),(138,'NG','Nigeria',NULL,NULL),(139,'MK','North Macedonia',NULL,NULL),(140,'NO','Norway',NULL,NULL),(141,'OM','Oman',NULL,NULL),(142,'PK','Pakistan',NULL,NULL),(143,'PW','Palau',NULL,NULL),(144,'PS','Palestine State',NULL,NULL),(145,'PA','Panama',NULL,NULL),(146,'PG','Papua New Guinea',NULL,NULL),(147,'PY','Paraguay',NULL,NULL),(148,'PE','Peru',NULL,NULL),(149,'PH','Philippines',NULL,NULL),(150,'PL','Poland',NULL,NULL),(151,'PT','Portugal',NULL,NULL),(152,'QA','Qatar',NULL,NULL),(153,'RO','Romania',NULL,NULL),(154,'RU','Russia',NULL,NULL),(155,'RW','Rwanda',NULL,NULL),(156,'KN','Saint Kitts and Nevis',NULL,NULL),(157,'LC','Saint Lucia',NULL,NULL),(158,'VC','Saint Vincent and the Grenadines',NULL,NULL),(159,'WS','Samoa',NULL,NULL),(160,'SM','San Marino',NULL,NULL),(161,'ST','Sao Tome and Principe',NULL,NULL),(162,'SA','Saudi Arabia',NULL,NULL),(163,'SN','Senegal',NULL,NULL),(164,'RS','Serbia',NULL,NULL),(165,'SC','Seychelles',NULL,NULL),(166,'SL','Sierra Leone',NULL,NULL),(167,'SG','Singapore',NULL,NULL),(168,'SK','Slovakia',NULL,NULL),(169,'SI','Slovenia',NULL,NULL),(170,'SB','Solomon Islands',NULL,NULL),(171,'SO','Somalia',NULL,NULL),(172,'ZA','South Africa',NULL,NULL),(173,'SS','South Sudan',NULL,NULL),(174,'ES','Spain',NULL,NULL),(175,'LK','Sri Lanka',NULL,NULL),(176,'SD','Sudan',NULL,NULL),(177,'SR','Suriname',NULL,NULL),(178,'SE','Sweden',NULL,NULL),(179,'CH','Switzerland',NULL,NULL),(180,'SY','Syria',NULL,NULL),(181,'TW','Taiwan',NULL,NULL),(182,'TJ','Tajikistan',NULL,NULL),(183,'TZ','Tanzania',NULL,NULL),(184,'TH','Thailand',NULL,NULL),(185,'TL','Timor-Leste',NULL,NULL),(186,'TG','Togo',NULL,NULL),(187,'TO','Tonga',NULL,NULL),(188,'TT','Trinidad and Tobago',NULL,NULL),(189,'TN','Tunisia',NULL,NULL),(190,'TR','Turkey',NULL,NULL),(191,'TM','Turkmenistan',NULL,NULL),(192,'TV','Tuvalu',NULL,NULL),(193,'UG','Uganda',NULL,NULL),(194,'UA','Ukraine',NULL,NULL),(195,'AE','United Arab Emirates',NULL,NULL),(196,'GB','United Kingdom',NULL,NULL),(197,'US','United States of America',NULL,NULL),(198,'UY','Uruguay',NULL,NULL),(199,'UZ','Uzbekistan',NULL,NULL),(200,'VU','Vanuatu',NULL,NULL),(201,'VE','Venezuela',NULL,NULL),(202,'VN','Vietnam',NULL,NULL),(203,'YE','Yemen',NULL,NULL),(204,'ZM','Zambia',NULL,NULL),(205,'ZW','Zimbabwe',NULL,NULL);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_day` date DEFAULT NULL,
  `end_hour` time(6) DEFAULT NULL,
  `keycode` varchar(100) NOT NULL,
  `start_day` date DEFAULT NULL,
  `start_hour` time(6) DEFAULT NULL,
  `visitor_device_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl4p32rehk247kfnyd0kdqtj63` (`visitor_device_id`),
  CONSTRAINT `FKl4p32rehk247kfnyd0kdqtj63` FOREIGN KEY (`visitor_device_id`) REFERENCES `visitor_device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museum`
--

DROP TABLE IF EXISTS `museum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `museum` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT '1',
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `picture` varchar(200) NOT NULL,
  `registration_date` date DEFAULT NULL,
  `city_id` bigint DEFAULT NULL,
  `country_id` bigint NOT NULL,
  `state_location_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpdcb71whnffgkntnec6wkfdel` (`city_id`),
  KEY `FK2voja7uuti45jdflnjpj8uesb` (`country_id`),
  KEY `FKiifulq4vb3to81pd5drxg31o1` (`state_location_id`),
  CONSTRAINT `FK2voja7uuti45jdflnjpj8uesb` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FKiifulq4vb3to81pd5drxg31o1` FOREIGN KEY (`state_location_id`) REFERENCES `state_location` (`id`),
  CONSTRAINT `FKpdcb71whnffgkntnec6wkfdel` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museum`
--

LOCK TABLES `museum` WRITE;
/*!40000 ALTER TABLE `museum` DISABLE KEYS */;
/*!40000 ALTER TABLE `museum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(30) NOT NULL,
  `model` varchar(30) NOT NULL,
  `release_version` varchar(50) DEFAULT NULL,
  `sdk_int` int DEFAULT NULL,
  `unique_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1tnyot2qpvkiaap8xppqhhony` (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_location`
--

DROP TABLE IF EXISTS `state_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_location` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `country_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UniqueNameAndCountry` (`name`,`country_id`),
  KEY `IDX8k63vhb1sflnpjphki7d73x5` (`name`),
  KEY `FKhyef1eh1ery7auq4y7rh7vi93` (`country_id`),
  CONSTRAINT `FKhyef1eh1ery7auq4y7rh7vi93` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_location`
--

LOCK TABLES `state_location` WRITE;
/*!40000 ALTER TABLE `state_location` DISABLE KEYS */;
INSERT INTO `state_location` VALUES (23,'Alabama',197),(24,'Alaska',197),(1,'Alta Verapaz',77),(25,'Arizona',197),(26,'Arkansas',197),(2,'Baja Verapaz',77),(27,'California',197),(3,'Chimaltenango',77),(4,'Chiquimula',77),(28,'Colorado',197),(29,'Connecticut',197),(30,'Delaware',197),(5,'El Progreso',77),(6,'Escuintla',77),(31,'Florida',197),(32,'Georgia',197),(7,'Guatemala',77),(33,'Hawaii',197),(8,'Huehuetenango',77),(34,'Idaho',197),(35,'Illinois',197),(36,'Indiana',197),(37,'Iowa',197),(9,'Izabal',77),(10,'Jalapa',77),(11,'Jutiapa',77),(38,'Kansas',197),(39,'Kentucky',197),(40,'Louisiana',197),(41,'Maine',197),(42,'Maryland',197),(43,'Massachusetts',197),(44,'Michigan',197),(45,'Minnesota',197),(46,'Mississippi',197),(47,'Missouri',197),(48,'Montana',197),(49,'Nebraska',197),(50,'Nevada',197),(51,'New Hampshire',197),(52,'New Jersey',197),(53,'New Mexico',197),(54,'New York',197),(55,'North Carolina',197),(56,'North Dakota',197),(57,'Ohio',197),(58,'Oklahoma',197),(59,'Oregon',197),(60,'Pennsylvania',197),(12,'Petén',77),(13,'Quetzaltenango',77),(14,'Quiché',77),(15,'Retalhuleu',77),(61,'Rhode Island',197),(16,'Sacatepéquez',77),(17,'San Marcos',77),(18,'Santa Rosa',77),(19,'Sololá',77),(62,'South Carolina',197),(63,'South Dakota',197),(20,'Suchitepéquez',77),(64,'Tennessee',197),(65,'Texas',197),(21,'Totonicapán',77),(66,'Utah',197),(67,'Vermont',197),(68,'Virginia',197),(69,'Washington',197),(70,'West Virginia',197),(71,'Wisconsin',197),(72,'Wyoming',197),(22,'Zacapa',77);
/*!40000 ALTER TABLE `state_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification`
--

DROP TABLE IF EXISTS `verification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `hour` time(6) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `token` varchar(75) NOT NULL,
  `visitor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK431beosusfcjpe6xad6yhlntm` (`token`),
  KEY `FK4xjave1kx3tbqd8nhveypi0xe` (`visitor_id`),
  CONSTRAINT `FK4xjave1kx3tbqd8nhveypi0xe` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification`
--

LOCK TABLES `verification` WRITE;
/*!40000 ALTER TABLE `verification` DISABLE KEYS */;
/*!40000 ALTER TABLE `verification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(75) NOT NULL,
  `last_name` varchar(75) NOT NULL,
  `name` varchar(75) NOT NULL,
  `password` varchar(75) NOT NULL,
  `registration_date` date NOT NULL,
  `status` varchar(10) NOT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `country_id` bigint NOT NULL,
  `city_id` bigint DEFAULT NULL,
  `state_location_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK21o54drbh1sbielx0xcajfkcd` (`email`),
  KEY `FK14p3n1pradbl3qo4vl581nucs` (`country_id`),
  KEY `FK7xa6nmfk85htovvciydwu0okq` (`state_location_id`),
  KEY `FKm44hp81rwdp99b0ng9u2tpg6b` (`city_id`),
  CONSTRAINT `FK14p3n1pradbl3qo4vl581nucs` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FK7xa6nmfk85htovvciydwu0okq` FOREIGN KEY (`state_location_id`) REFERENCES `state_location` (`id`),
  CONSTRAINT `FKm44hp81rwdp99b0ng9u2tpg6b` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor_device`
--

DROP TABLE IF EXISTS `visitor_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor_device` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activation_date` date DEFAULT NULL,
  `activation_hour` time(6) DEFAULT NULL,
  `inactivation_date` date DEFAULT NULL,
  `inactivation_hour` time(6) DEFAULT NULL,
  `last_date` date DEFAULT NULL,
  `last_hour` time(6) DEFAULT NULL,
  `push_notification_token` varchar(255) DEFAULT NULL,
  `version_code` int DEFAULT NULL,
  `version_name` varchar(255) DEFAULT NULL,
  `browser_id` bigint DEFAULT NULL,
  `phone_id` bigint DEFAULT NULL,
  `visitor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsh6nffeu93wi8e8tj0ptprfcv` (`browser_id`),
  KEY `FKmsn01g2h95qtk1gvkqd16aapm` (`phone_id`),
  KEY `FKja8dy4yc8jsc9yao0prggbkpv` (`visitor_id`),
  CONSTRAINT `FKja8dy4yc8jsc9yao0prggbkpv` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`id`),
  CONSTRAINT `FKmsn01g2h95qtk1gvkqd16aapm` FOREIGN KEY (`phone_id`) REFERENCES `phone` (`id`),
  CONSTRAINT `FKsh6nffeu93wi8e8tj0ptprfcv` FOREIGN KEY (`browser_id`) REFERENCES `browser` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor_device`
--

LOCK TABLES `visitor_device` WRITE;
/*!40000 ALTER TABLE `visitor_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitor_device` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-09  0:29:39
