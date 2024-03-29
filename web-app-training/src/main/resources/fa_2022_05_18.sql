-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fa
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES cp932 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album_anzai`
--

DROP TABLE IF EXISTS `album_anzai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album_anzai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `album` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album_anzai`
--

LOCK TABLES `album_anzai` WRITE;
/*!40000 ALTER TABLE `album_anzai` DISABLE KEYS */;
INSERT INTO `album_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'Perfume`Complete Best','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'GAME','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'JPN','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'Perfume Global Compilation','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'LOVE THE WORLD','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'LEVEL3','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'COSMIC EXPLORER','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'Future Pop','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Perfume The Best gP Cubedh','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
/*!40000 ALTER TABLE `album_anzai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
  `id` int(11) NOT NULL,
  `artist` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'Zebrahead','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(2,'FLOW','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(3,'ÄÃºt','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(4,'Anly','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(5,'fox capture plan','0','2018-05-23 01:27:00','2018-05-23 01:27:00');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribute_kawamura`
--

DROP TABLE IF EXISTS `attribute_kawamura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute_kawamura` (
  `attribute_id` int(2) NOT NULL,
  `attribute_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0ï¼æå¹ã1ï¼ç¡å¹',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_kawamura`
--

LOCK TABLES `attribute_kawamura` WRITE;
/*!40000 ALTER TABLE `attribute_kawamura` DISABLE KEYS */;
INSERT INTO `attribute_kawamura` VALUES (0,NULL,'0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(1,'Gy[yM®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(2,'Af[yM®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(3,'t{gyM®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(4,'}JjyM®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(5,'LyM®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(6,'RK^yM®','0','2019-12-03 15:19:00','2019-12-03 15:19:00');
/*!40000 ALTER TABLE `attribute_kawamura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `broadcast_station_ige`
--

DROP TABLE IF EXISTS `broadcast_station_ige`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `broadcast_station_ige` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `broadcast_station_ige`
--

LOCK TABLES `broadcast_station_ige` WRITE;
/*!40000 ALTER TABLE `broadcast_station_ige` DISABLE KEYS */;
INSERT INTO `broadcast_station_ige` VALUES (0,NULL,'0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(1,'NHK','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(2,'ú{er','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'er©ú','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'TBS','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'tWer','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(6,'er','0','2021-05-18 12:00:00','2021-05-18 12:00:00');
/*!40000 ALTER TABLE `broadcast_station_ige` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_umehara`
--

DROP TABLE IF EXISTS `company_umehara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_umehara` (
  `id` int(11) NOT NULL,
  `company_name` varchar(256) DEFAULT NULL,
  `company_url` varchar(256) DEFAULT NULL,
  `company_address` varchar(256) DEFAULT NULL,
  `numbers_vtuber` int(11) DEFAULT NULL,
  `company_year` int(11) DEFAULT NULL,
  `company_comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_umehara`
--

LOCK TABLES `company_umehara` WRITE;
/*!40000 ALTER TABLE `company_umehara` DISABLE KEYS */;
INSERT INTO `company_umehara` VALUES (0,NULL,NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'ANYCOLOR®ïÐ','https://www.anycolor.co.jp/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'Jo[®ïÐ','https://cover-corp.com/',NULL,NULL,2016,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'®ïÐâ{¬|\Ð','https://rbc-geino.com/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'ÈÈµ®ïÐ','https://774.co.jp/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'»Ì¼',NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'¢®',NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00');
/*!40000 ALTER TABLE `company_umehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contents_umehara`
--

DROP TABLE IF EXISTS `contents_umehara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contents_umehara` (
  `id` int(11) NOT NULL,
  `stream_content` varchar(256) DEFAULT NULL,
  `del_flg` varchar(256) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contents_umehara`
--

LOCK TABLES `contents_umehara` WRITE;
/*!40000 ALTER TABLE `contents_umehara` DISABLE KEYS */;
INSERT INTO `contents_umehara` VALUES (0,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'Q[','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'Ì','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'ìÆ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'Gk','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'Q[EÌ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'Q[EìÆ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'Q[EGk','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(8,'ÌEìÆ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(9,'ÌEGk','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(10,'ìÆEGk','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(11,'Q[EÌEìÆ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(12,'Q[EÌEGk','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(13,'ÌEGkEìÆ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(14,'Q[EÌEGkEìÆ','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
/*!40000 ALTER TABLE `contents_umehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dog_country_kanno`
--

DROP TABLE IF EXISTS `dog_country_kanno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dog_country_kanno` (
  `id` int(11) NOT NULL,
  `country` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog_country_kanno`
--

LOCK TABLES `dog_country_kanno` WRITE;
/*!40000 ALTER TABLE `dog_country_kanno` DISABLE KEYS */;
INSERT INTO `dog_country_kanno` VALUES (0,NULL,'0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(1,'LVR','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(2,'CMX','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'hCc','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'C^A','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'I[XgA','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(6,'ú{','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(7,'tX','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(8,'','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(9,'AJ','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(10,'RS','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(11,'VA','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(12,'XCX','0','2020-05-21 00:00:00','2020-05-21 00:00:00');
/*!40000 ALTER TABLE `dog_country_kanno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dog_main_kanno`
--

DROP TABLE IF EXISTS `dog_main_kanno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dog_main_kanno` (
  `dog_id` int(11) NOT NULL,
  `dog_name` varchar(256) NOT NULL,
  `country_id` int(11) DEFAULT NULL,
  `size_id` int(11) NOT NULL,
  `charcter` varchar(256) NOT NULL,
  `image` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`dog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog_main_kanno`
--

LOCK TABLES `dog_main_kanno` WRITE;
/*!40000 ALTER TABLE `dog_main_kanno` DISABLE KEYS */;
INSERT INTO `dog_main_kanno` VALUES (1,'S[fEg[o[',2,4,'·úÅ«­th[BZs[¢ÈÇÉü­¢í','/dogKanno/20200605152150187.jpg','0','2020-05-21 00:00:00','2020-06-05 15:21:50'),(2,'uh[Eg[o[',2,4,'j®±Æª¾ÓBÓ±¢ÆµÄàô·éB','Lab.png','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'[NV[EeA',2,1,'Ci Óêé«iBÑª·­lXÈJbgX^CªyµßéB','yorkey.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'|jA',3,1,'DïSª­­E¸BSNSÅÉ©êé®æªbèÉÈÁ½B','pome.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'Ä¢',6,2,'½ÀÈ«iª¢EÅlCðÄñÅ¢éB','shiba.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(6,'ps',7,2,'ÈÅçêé±ÆðDÞBüèÑª©í¢¢B','papi.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(7,'{[_[R[',2,3,'²QÌ^®_oBqr¢ÆµÄp¢çêÄ«½B','border.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(8,'LoAELOE`[YEXpjG',2,2,'¾é­zCBâµªèâÈêÊàB','cavalier.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(9,'h[x}',3,4,'ûÅxúSª­­Ax@¢ÈÇÆµÄô·éB','doberman.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(10,'gCv[h',7,2,'th[©ÂÑª²¯É­¢½ßAîì{ÝÈÇÅÌZs[¢Éü¢Ä¢éB','toypoo.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(11,'~j`AE_bNXth',3,2,'Ã¦ñVB··Z«ÌbNXÅ¤³êÄ¢éB','dachs.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(12,'VFbghEV[vhbO',2,2,'ÓC´ª­­pS[¢ª¤zÌæ¢¢íB','sheltie.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(13,'XReBbVEeA',2,2,'­ÅñÌ¢çµ¢rÁÛ³àÂB','scottish.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(14,'C^AEO[nEh',4,2,'¸â©È«iBX^C²QÅæ­éB','italian.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(15,'Hc¢',6,4,'VRLO¨Éo^³êÄ¢éB~Ì¦³É­¢B','akitainu.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(16,'WbNEbZEeA',5,2,'ÌLclëèðµÄ¢½½ß®­àÌÉrqÉ½·éB','jack.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(17,'~j`AEViEU[',3,2,'¦²«ª èA¢åÉOêIÉs­·B','schnauzer.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(18,'AJERbJ[EXpjG',9,3,'zCÈ«iBÑ¿ª¦Ìæ¤É_ç©¢B','american.jpg','0','2020-05-21 00:00:00','2020-06-08 13:30:10'),(19,'oZW[',10,3,'ûÅlÞÉÆÁÄzÌ¢Æ¢íêÄ¢éB','basenji.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(20,'uhbO',2,3,'µÂ¢©½ÚÌÉDµ¢«iðµÄ¢éB','bull.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(21,'VxAEnXL[',9,4,'ÔÓ¯ª­¢B¢¼èð¡ø·éJbR¢¢¢B','husky.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(22,'o[j[YE}EeEhbO',12,4,'âñ¿áÅÃ¦ñVBûÑª éæ¤Èç§¿ðµÄ¢éB','bernese.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(23,'ZgEo[i[h',12,5,'±Ì¢ªåðÌx[g[xÆ¢¤RfBfæª èÜ·B','st.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(24,'O[gEsj[Y',7,5,'¤î[­DëÈµÍCðÁÄ¢éB','grate.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(25,'{]C',11,4,'IIJ~ÌëÂðµÄ¢½BÌªå«­X_[È©ç¾Â«B','borzoi.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(26,'VFp[h',3,4,'Pûü«AV[ü«ÈÇÌ^CvÊÉ«iªÙÈéª¢¸êàâÃ³ðàÁÄ¢éB','shepherd.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(27,'bã¢',6,3,'Hc¢ÉÂ®ñÔÚÌVRLO¨BµÂ±­µÄà{çÈ¢B','kai.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(28,'`EE`E',8,3,'Ô¢Éü¢Ä¢éBu[ubNÌãªÁ¥B','chow.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(29,'`',1,1,'£gIÅÃ¦ãèBxúSª­­Æi¦éB','chihuahua.png','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(30,'pO',8,2,'Ô³Jã\Blù±­Ô¢ÉÍü©È¢B','pug.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(31,'kC¹¢',6,3,'^CMÅ¨³ñðÉNp³êAÚðWß½B','/dogKanno/20200605141724403.jpg','0','2020-06-05 14:17:24','2020-06-05 16:28:41');
/*!40000 ALTER TABLE `dog_main_kanno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dog_size_kanno`
--

DROP TABLE IF EXISTS `dog_size_kanno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dog_size_kanno` (
  `id` int(11) NOT NULL,
  `size` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog_size_kanno`
--

LOCK TABLES `dog_size_kanno` WRITE;
/*!40000 ALTER TABLE `dog_size_kanno` DISABLE KEYS */;
INSERT INTO `dog_size_kanno` VALUES (0,NULL,'0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(1,'´¬^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(2,'¬^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'å^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'´å^','0','2020-05-21 00:00:00','2020-05-21 00:00:00');
/*!40000 ALTER TABLE `dog_size_kanno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drama_main_ige`
--

DROP TABLE IF EXISTS `drama_main_ige`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drama_main_ige` (
  `id` int(11) NOT NULL,
  `drama_title` varchar(255) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `broadcast_station_id` int(11) DEFAULT NULL,
  `start_season` varchar(11) NOT NULL,
  `day_of_week` varchar(2) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drama_main_ige`
--

LOCK TABLES `drama_main_ige` WRITE;
/*!40000 ALTER TABLE `drama_main_ige` DISABLE KEYS */;
INSERT INTO `drama_main_ige` VALUES (1,'âÎëx',1,5,'2020~','','1úÍãËÊA»êÈ~Íòºê÷åÌYh}B','0','2021-05-18 12:00:00','2021-05-27 15:43:25'),(2,'a@Ì¡µû',2,6,'2020~','','|Yë@©çïÕÌð°½a@ÌÀbªfAåÍ¬òF¾YB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'âßéÆ«àA·±â©ÈéÆ«à',3,2,'2020~','','¯¼¬àð¡J¾ãåÅÀÊ»B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'10Ìé§',4,5,'2020~','Î','åÍüäBlXÈé§É|M³êéB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'öÍÂÃ­æÇ±ÜÅà',3,4,'2020~','Î','æÌÀÊ»B²¡AãÎG¹ªoµAwöÂÃxÌ¤ÌÅà¨È¶ÝB','0','2021-05-18 12:00:00','2021-05-31 10:40:10'),(6,'SEDAI WARS',5,4,'2020~','','ß¢Ìú{ªäBRcTMåB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(7,'mçÈ­Ä¢¢Rg',5,2,'2020~','','¨dnq[}h}BT§ÒWðäÉLÒÌålöðgR¢qª¶éB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(8,'lÍÇ±©ç',4,6,'2020~','','¯¼æðTãÄåÅÀÊ»BÁê\ÍðàÂålöÌÂtTXyXB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(9,'DASADA',6,2,'2020~','Ø','H³NÌéæBúüâ46ªåð±ßéwh}B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(10,'¢ÅÍ¿áñÆµÜ·',3,6,'2020~','Ø','àcåÌuRfBBæÌÀÊ»B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(11,'PCWÆPW',1,3,'2020~','Ø','ËJ¾Æo¹åª_uåÌ®SIWiXg[[B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(12,'ACuªñêåãÌJe',2,5,'2020~','Ø','ªñÉ§¿ü©¤2lÌãÌfBJq[}h}B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(13,'`RTã',3,2,'2020~','Ø','åÍnãgAhåÌR{üBäðð¢Ä¢­B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(14,'äéL¢',7,6,'2020~','à','\Lvð·éqZ¶BÌäéâ©Èúí`­B´yåB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(15,'ÝY2',1,6,'2020~','à','i¶é\"Ý³ñ\"ª¬Ì½aðçé½ßÉ±¬·éB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(16,'aºÅO§ð¥¦È¢Å­¾³¢',2,4,'2020~','à','mµÅ~}~½ãÆ¢¤ålöª¡·épð`­AãÃq[}h}','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(17,'qZ¶Ì³Ê­¢',6,3,'2020~','à','æÌÀÊ»BqZ¶BÌúíð`­RfBB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(18,'gbviCt',2,2,'2020~','y','èpÌVËªW¤a@Ì]_oOÈªäBåÍVCSóB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(19,'eZEXÌD',8,4,'2020~','ú','|àÁ^¶éålöªAeÌðð·é½ß^CXbv·éB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(20,'SUITS2',NULL,5,'2020t','','SÄÌåqbgh}ÌV[YQBqrÙìmÆVËèÅâèððµÄ¢­B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(21,'³µ¢bNohÌìèû',NULL,2,'2020t','Î','sípÅ__¾¯Ç¤·×«4lªgbvxÌ¹ytFXðÚw·¨êB¡ä¬¯A_RqmåB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(22,'TãERÙ¾Y',4,5,'2020t','Î','nãgåÌgìWiÆu¸~ªofBÆÈèAsÌïöÈ¢Eð»ãÉðßµÄ­B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(23,'nPÌii',5,2,'2020t','','2007NÉú³ê½¨dh}Ì±ÒB­­±ÆÌ{¿ÉéB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(24,'^ÈñàµÈ¢l',NULL,6,'2020t','Ø','cMvåBTwitterÅbèÆÈÁ½^ÈñàµÈ¢lðfÉh}»B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(25,'BG`gÓxìl`',11,3,'2020t','Ø','ØºñÆåB¯Ô{fB[K[hÌpð`­V[YìB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(26,'MIU404',1,4,'2020t','à','»ìÆ¯ì¹_uåAìØIqªr{ÌlCìB@®{¸àÌ¨êB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(27,'¢x@',1,2,'2020t','y','lA½ìsª_uåBØÌlCfæðú{ÅÉCNB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(28,'DIVER|ÁêöüÇ|',1,5,'2020Ä','Î','m¿ªÌ_[Nq[[ðB«ÌgDÉöüµÄðµÄ¢­B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(29,'ÌÆ­viMT³ñ',3,4,'2020Ä','Î','ÆªÅ«È¢LAE[}Ìålöª¨¶³ñÆ­vðÙ¤±Æ©çnÜéuRB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(30,'½¿ÍÇ¤©µÄ¢é',8,2,'2020Ä','','VÜaÙqXðäÉAlÓügÆ¡l¬¯¶é2lÌöÍlð`«ÂÂÉéu~Xe[B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(31,'ATOVf',2,5,'2020Ä','Ø','Î´³ÆÝåBa@òÜtª±¬µÈªç³ÒÆü«¤pð`­B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(32,'Þª¬§Å«È¢R',NULL,1,'2020Ä','y','Ol¯w¶ÆHìªDèÈ·¿åÁÆØÈ¢uRfBB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(33,'eoJÂt',9,2,'2020Ä','ú','ºðM¤·é Üè¯¶åwÖüwµ½icVjÆºiiìèèjÌãJð`­z[RfBB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(38,'öÍDeepÉ',3,2,'2021t','','Î´³ÆÝÆ»ì','0','2021-05-27 16:37:53','2021-05-27 16:38:20');
/*!40000 ALTER TABLE `drama_main_ige` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drink_category_yoshimoto`
--

DROP TABLE IF EXISTS `drink_category_yoshimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drink_category_yoshimoto` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_category_yoshimoto`
--

LOCK TABLES `drink_category_yoshimoto` WRITE;
/*!40000 ALTER TABLE `drink_category_yoshimoto` DISABLE KEYS */;
INSERT INTO `drink_category_yoshimoto` VALUES (0,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'Î','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'g','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'R[q[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'RRA','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'Ê`ù¿','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'Y_ù¿','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'X|[cù¿','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'mAR[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'r[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'C','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'nC','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'EBXL[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'Ä','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'û','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'¤û','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
/*!40000 ALTER TABLE `drink_category_yoshimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drink_main_yoshimoto`
--

DROP TABLE IF EXISTS `drink_main_yoshimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drink_main_yoshimoto` (
  `drink_id` int(11) NOT NULL,
  `drink_name` varchar(256) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `maker_id` int(11) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`drink_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_main_yoshimoto`
--

LOCK TABLES `drink_main_yoshimoto` WRITE;
/*!40000 ALTER TABLE `drink_main_yoshimoto` DISABLE KEYS */;
INSERT INTO `drink_main_yoshimoto` VALUES (1,'RJER[@[',8,2,'/DrinkImageYoshimoto/coke.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'¨[¢¨',2,3,'/DrinkImageYoshimoto/20200602141508665.jpg','0','2020-05-19 00:00:00','2020-06-02 14:15:08'),(3,'UEv~AEc',11,1,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'ATqX[p[hC',11,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'~NRRA',6,16,'/DrinkImageYoshimoto/20200602141621489.jpg','0','2020-05-19 00:00:00','2020-06-02 14:16:21'),(6,'¾¡¨¢µ¢û',16,11,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'~æëµ',7,7,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'RoT|[g',8,NULL,'/DrinkImageYoshimoto/kobara.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'ANGAX',9,2,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'REAL@GOLD',8,2,'/DrinkImageYoshimoto/gold.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'¢ëÍ·@àà',1,2,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'gsJ[i@}`r^~',7,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'MBèåèØ»Î',NULL,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'N~lÞ¬',3,3,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'EF`@O[v',7,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'~E',1,7,'/DrinkImageYoshimoto/miu.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'L',8,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'JsXEH[^[',NULL,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'O~N',16,15,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(20,'²®¤û',17,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(21,'¤ûù¿@\[_',17,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(22,'XXgO@ôXp[NO',13,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(23,'v~A{X@A}[Xg',5,1,'/DrinkImageYoshimoto/boss.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(24,'ßãÌg@¨¢µ¢³',4,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(25,'¤lÌÜiÔj',12,NULL,'/DrinkImageYoshimoto/king.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(26,'Ìñ éCª@T[eCXg',10,1,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(27,'oz[e@~N@RRA',6,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(29,'¢¢Æà',15,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(30,'OcîTC_[',8,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(31,'gsJ[i 100%IW',7,6,NULL,'0','2020-05-29 15:28:29','2020-06-01 13:03:03'),(32,'Suntory Whisky pr',14,1,NULL,'1','2020-06-01 11:50:00','2020-06-01 11:50:00'),(33,'|JXEFbg',9,NULL,'/DrinkImageYoshimoto/20200602141840669.jpg','0','2020-06-01 12:02:34','2020-06-02 14:18:40');
/*!40000 ALTER TABLE `drink_main_yoshimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drink_maker_yoshimoto`
--

DROP TABLE IF EXISTS `drink_maker_yoshimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drink_maker_yoshimoto` (
  `maker_id` int(11) NOT NULL,
  `maker_name` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`maker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_maker_yoshimoto`
--

LOCK TABLES `drink_maker_yoshimoto` WRITE;
/*!40000 ALTER TABLE `drink_maker_yoshimoto` DISABLE KEYS */;
INSERT INTO `drink_maker_yoshimoto` VALUES (0,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'Tg[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'RJER[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'É¡','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'Ng','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'ATq','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'L','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'_Ch[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'Tb|','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'JS','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'¬âä','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'¾¡','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'ú´','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'æÂt','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'g{','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'áó','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'Xi','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'¡Ìf','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'lX','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'TKA','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
/*!40000 ALTER TABLE `drink_maker_yoshimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forms_umehara`
--

DROP TABLE IF EXISTS `forms_umehara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forms_umehara` (
  `id` int(11) NOT NULL,
  `stream_form` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forms_umehara`
--

LOCK TABLES `forms_umehara` WRITE;
/*!40000 ALTER TABLE `forms_umehara` DISABLE KEYS */;
INSERT INTO `forms_umehara` VALUES (0,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'¶zM','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'®æe','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'V[g®æ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'¶zME®æe','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'¶zMEV[g®æ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'®æeEV[g®æ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'¶zME®æeEV[g®æ','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
/*!40000 ALTER TABLE `forms_umehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` varchar(14) NOT NULL,
  `update_date` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'ANV',0,'2017/11/08','2017/11/08'),(2,'TXyX',0,'2017/11/08','2017/11/08'),(3,'q[}',0,'2017/11/08','2017/11/08'),(4,'z[',0,'2017/11/08','2017/11/08'),(5,'RfB',0,'2017/11/08','2017/11/08');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_ige`
--

DROP TABLE IF EXISTS `genre_ige`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_ige` (
  `id` int(11) NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_ige`
--

LOCK TABLES `genre_ige` WRITE;
/*!40000 ALTER TABLE `genre_ige` DISABLE KEYS */;
INSERT INTO `genre_ige` VALUES (0,NULL,'0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(1,'Y','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(2,'ãÃ','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'ö¤','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'TXyX','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'Ðïh','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(6,'w','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(7,'lÔh}','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(8,'~Xe[','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(9,'RfB','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(11,'ANV','0','2021-05-18 12:00:00','2021-05-18 12:00:00');
/*!40000 ALTER TABLE `genre_ige` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_ishikawa`
--

DROP TABLE IF EXISTS `genre_ishikawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_ishikawa` (
  `id` int(11) DEFAULT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_ishikawa`
--

LOCK TABLES `genre_ishikawa` WRITE;
/*!40000 ALTER TABLE `genre_ishikawa` DISABLE KEYS */;
INSERT INTO `genre_ishikawa` VALUES (0,NULL,'0','2020-03-24 11:40:38','2020-03-24 11:40:41'),(1,'åH','0','2020-03-24 11:40:58','2020-03-24 11:41:01'),(2,'åØ','0','2020-03-24 11:41:18','2020-03-24 11:41:21'),(3,'Ø','0','2020-03-24 11:41:36','2020-03-24 11:41:39');
/*!40000 ALTER TABLE `genre_ishikawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_takehara`
--

DROP TABLE IF EXISTS `location_takehara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_takehara` (
  `location_id` int(2) NOT NULL,
  `location_name` varchar(20) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_takehara`
--

LOCK TABLES `location_takehara` WRITE;
/*!40000 ALTER TABLE `location_takehara` DISABLE KEYS */;
INSERT INTO `location_takehara` VALUES (0,'','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(1,'é','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'é¼','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'éì','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'ék','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'ªÞ³µ','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
/*!40000 ALTER TABLE `location_takehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maker_mori`
--

DROP TABLE IF EXISTS `maker_mori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maker_mori` (
  `id` int(11) NOT NULL,
  `maker` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maker_mori`
--

LOCK TABLES `maker_mori` WRITE;
/*!40000 ALTER TABLE `maker_mori` DISABLE KEYS */;
INSERT INTO `maker_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'ANCHORiAJ[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'ARGON18(AS18j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'BianchiirALj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'BH(r[GC`)','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'BMC(r[GV[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'BOMAi{[}j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'CANYONiLjIj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'cerveloiT[Fj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'CIPOLLINIi`b|[jj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'COLNAGOiRiSj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'CUBE BIKESiL[uoCNXj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'DIAMOND BIKESi_CAhoCNXj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'EDDYMERCKXiGfBNXj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'FACTORit@N^[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'FELTitFgj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'FUJIitWj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'GIANTiWCAgj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'KhodaaBloomiR[_[u[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'KUOTAiNI[^j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'MERIDAi_j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'PINARELLOisij','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'RIDLEYih[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'SCOTTiXRbgj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'SPECIALIZEDiXyVCYhj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'TREKigbNj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'WilieriEBG[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
/*!40000 ALTER TABLE `maker_mori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actor`
--

DROP TABLE IF EXISTS `movie_actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_actor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` varchar(14) NOT NULL,
  `update_date` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actor`
--

LOCK TABLES `movie_actor` WRITE;
/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
INSERT INTO `movie_actor` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'gEnNX',0,'2017/11/08','2017/11/08'),(2,'gr[E}OCA',0,'2017/11/08','2017/11/08'),(3,'WF[YE}JHC',0,'2017/11/08','2017/11/08'),(4,'i^[E|[g}',0,'2017/11/08','2017/11/08'),(5,'AEnTEFC',0,'2017/11/08','2017/11/08');
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_main`
--

DROP TABLE IF EXISTS `movie_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_main` (
  `id` int(11) NOT NULL,
  `movie_title` varchar(255) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `actor_id` int(11) DEFAULT NULL,
  `release_year` int(4) NOT NULL,
  `run_time` int(3) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `genre_id` (`genre_id`),
  KEY `actor_id` (`actor_id`),
  CONSTRAINT `movie_main_ibfk_1` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `movie_main_ibfk_2` FOREIGN KEY (`actor_id`) REFERENCES `movie_actor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_main`
--

LOCK TABLES `movie_main` WRITE;
/*!40000 ALTER TABLE `movie_main` DISABLE KEYS */;
INSERT INTO `movie_main` VALUES (1,'XpC_[}3',1,2,2007,155,'XpC_[}ÌfæÌÅÍêÔD«',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MENa¶ébAÎ¿Ú±Ê¢B',0,'2017-11-08 00:00:00','2021-05-27 15:33:27'),(3,'I',1,4,1994,110,'}`_ª©í¢¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'_[NiCgCWO',1,5,2012,165,'DCR~bNæ£ê',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'xCr[hCo[',1,NULL,2017,113,'±Òª§ì³êé»¤',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'gX',2,3,2013,101,'_j[E{CÄÂ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'tBX',2,3,2013,97,'XRbghÌÅ«Y',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'ØíÈéMcr[',2,2,2013,143,'Øºà£',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'ubWIuXpC',2,1,2015,144,'AJf~[jDÜóÜ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'_EB`ER[h',2,1,2006,174,'IhCEggDV¯½È ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'tHXgKv',3,1,1994,142,'¾í¸Æmê½¼¾ÌóÉ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'®SÈé`FbNCg',3,2,2014,116,'{r[tBbV[',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,' Ì lçÍ',3,2,2001,90,'á©èµfBJvI',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'~[u',3,5,2012,160,'ÌªÍAeRÅÍ èÜ¹ñ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'O[}C',3,1,1999,189,'wV[VNÌóÉxà¢¢Å·',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'ubNX',4,4,2011,108,'ºèÈz[æè|¢©à',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TV[r[ÒàÇ¤¼',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'L[',4,NULL,1976,98,'XeB[uELOÌì',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'Xvbg',4,3,2017,117,'V}ìið©Ä¨­Æg',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'~X^[KX',4,3,2019,129,'XvbgÌ±Ò',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'}CEC^[',5,5,2015,121,'wv_ð½«xà¨··ß',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'^[~i',5,1,2004,128,'ó`ÉZñÅÝ½¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'yls',5,3,2008,104,'»ãÌ¨Æ¬b',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'AXC_[h',5,5,2010,113,'fü·²¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'LbchbOX',5,2,2001,87,'¢Í©í¢¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'Â®È¢',NULL,3,2007,130,'ATÈÉÍ¨··ßµÜ¹ñ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'vChÆÎ©',NULL,NULL,2005,135,'REt@[XÌh}ÅàÇ«',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'OCeXgV[}',3,NULL,2017,105,'ÂlIÉEEhz¦',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'rbO',5,1,1988,130,'fGÈCÉÈêé',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'â½çØÈoDw',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
/*!40000 ALTER TABLE `movie_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `author` varchar(255) CHARACTER SET utf8 DEFAULT 'unknown',
  `rating` int(11) DEFAULT 0,
  `comment` varchar(255) DEFAULT NULL,
  `category_id` int(11) unsigned DEFAULT 0,
  `video_url` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `fk_music_type` (`category_id`),
  CONSTRAINT `fk_music_type` FOREIGN KEY (`category_id`) REFERENCES `music_category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (4,'S¾?','C??',5,'Nãä?v?IêñÌCNk¬sC?ÝËRLk½lì?B',3,'https://www.youtube.com/embed/ZSWeurc1yMw','2018-03-19 15:12:14','2018-03-19 15:12:14',5),(9,'Ym?CÅ?','¡¡',5,'',3,'https://www.youtube.com/embed/hNQohQBFnwI','2018-03-19 16:05:12','2018-03-19 16:05:12',2),(10,'áÌØ','üÃ',5,'',6,'https://www.youtube.com/embed/mF5Qq2YheTg','2018-03-19 17:18:19','2019-03-28 15:26:31',2),(11,'MY ALL','à_è?',5,'',5,'https://www.youtube.com/embed/PKptgq8jTYw','2018-03-19 17:27:07','2018-03-19 17:27:07',1),(12,'Time after time `Ô¤XÅ`','?Øß',5,'',4,'https://www.youtube.com/embed/Ep_W5rYXyi0','2018-03-19 17:28:57','2018-03-19 17:28:57',1),(13,'²IêyH','¼²q',5,'',6,'https://www.youtube.com/embed/Vn6xGeMY9w8','2018-03-19 17:31:46','2018-03-19 17:31:46',1),(14,'big big world','Emilia',5,'',5,'https://www.youtube.com/embed/wpkS2DU_qMs','2018-03-19 17:33:04','2018-03-19 17:33:04',0);
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music_category`
--

DROP TABLE IF EXISTS `music_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL DEFAULT '',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT 0,
  `delete_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_category`
--

LOCK TABLES `music_category` WRITE;
/*!40000 ALTER TABLE `music_category` DISABLE KEYS */;
INSERT INTO `music_category` VALUES (0,'',NULL,NULL,0,NULL,0),(1,'DJ',NULL,NULL,0,NULL,0),(2,'Light',NULL,NULL,0,NULL,0),(3,'China',NULL,NULL,0,NULL,0),(4,'ACG',NULL,NULL,0,NULL,0),(5,'Pop',NULL,NULL,0,NULL,0),(6,'Classical',NULL,NULL,0,NULL,0);
/*!40000 ALTER TABLE `music_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nbaplayers_main_takahashi`
--

DROP TABLE IF EXISTS `nbaplayers_main_takahashi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nbaplayers_main_takahashi` (
  `id` int(11) DEFAULT NULL,
  `player_image` varchar(256) DEFAULT NULL,
  `player_name` varchar(256) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `team_id` int(30) DEFAULT NULL,
  `height` int(3) DEFAULT NULL,
  `weight` int(3) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nbaplayers_main_takahashi`
--

LOCK TABLES `nbaplayers_main_takahashi` WRITE;
/*!40000 ALTER TABLE `nbaplayers_main_takahashi` DISABLE KEYS */;
INSERT INTO `nbaplayers_main_takahashi` VALUES (1,NULL,'uEWF[X',3,23,206,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,NULL,'XetBEJ[',1,21,191,86,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,NULL,'PrEfg',3,2,208,108,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,NULL,'jXEAegN|',4,10,211,109,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,NULL,'NCEi[h',3,22,201,104,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(6,NULL,'ñRELb`',5,16,213,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(7,NULL,'WF[YEn[f',2,2,196,99,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(8,NULL,'WGEGr[h',5,4,213,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(9,NULL,'JEh`b`',1,26,201,98,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(10,NULL,'fC~AE[h',1,19,188,88,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(11,NULL,'A\j[EfCrX',4,23,208,114,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(12,NULL,'W~[Eog[',3,13,201,104,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(13,NULL,'JC[EA[rO',1,2,188,87,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(14,NULL,'UCIEEBA\',4,29,198,128,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(15,NULL,'WFC\EeC^',3,1,203,94,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(16,NULL,'ubh[Er[',2,15,191,93,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(17,NULL,'NXE|[',1,24,183,79,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(18,NULL,'NCEgv\',2,21,198,97,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(19,NULL,'WAXEh',4,3,203,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(20,NULL,'frEubJ[',2,24,196,95,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(21,NULL,'hmoE~b`F',2,20,185,97,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(22,NULL,'|[EW[W',2,22,203,99,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(23,NULL,'J[EA\j[^EY',5,17,211,112,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(24,NULL,'bZEEGXgubN',1,15,191,90,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(25,NULL,'fBESxA',5,20,216,110,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(26,NULL,'UbNEr[',2,6,198,90,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(27,NULL,'gCEO',1,11,185,81,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(28,NULL,'VFCEMWX=ANT_[',2,18,196,81,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(29,NULL,'fBAEtHbNX',1,25,191,79,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(30,NULL,'oEAfo',5,13,206,115,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(31,NULL,'xEVY',1,4,208,105,'','1','2021-06-08 15:26:54','2021-06-08 15:26:54'),(32,NULL,'ªºÛ',4,15,203,103,'','0','2021-06-09 14:05:57','2021-06-09 14:05:57');
/*!40000 ALTER TABLE `nbaplayers_main_takahashi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penguin_main_kawamura`
--

DROP TABLE IF EXISTS `penguin_main_kawamura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penguin_main_kawamura` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `attribute_id` int(11) NOT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0ï¼æå¹ã1ï¼ç¡å¹',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penguin_main_kawamura`
--

LOCK TABLES `penguin_main_kawamura` WRITE;
/*!40000 ALTER TABLE `penguin_main_kawamura` DISABLE KEYS */;
INSERT INTO `penguin_main_kawamura` VALUES (1,'REeCyM',1,'ìÉå¤üÓÌèXãÉ¶§@ÌÌå«³No.1iú{Ì°ÙÅ©éªoéj','/penguinKawamura/REeC_penguin.jpg','0','2019-12-03 15:08:00','2020-03-23 10:08:48'),(2,'LOyM',1,'ìÉÌXÉ¶§iú{Ì°ÙÅ©éªoéj','/penguinKawamura/LO_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(3,'Af[yM',2,'ìÉå¤ÌÝæAüÓÌXÉ¶§@ICJ[hSuicaÌfÉÈÁ½yMiú{Ì°ÙÅ©éªoéj','/penguinKawamura/Af[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(4,'WFc[yM',2,'ìÉå¤ÌXÌ£ÁÄ¢È¢næAìÉÌXÉ¶§@Bê«ÌFªIWÌyM@j¬Ì¬³No.1iú{Ì°ÙÅ©éªoéj','/penguinKawamura/WFc[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(5,'qQyM',2,'ìÉ¼É¶§@iú{Ì°ÙÅ©éªoéj','/penguinKawamura/qQ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(6,'KpSXyM',3,'KpSXÉ¶§@t{gyM®ÌÅ­¿ÎµÌ×³No.1iú{ÅÍ©êÈ¢j','/penguinKawamura/KpSX_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(7,'P[vyM',3,'ìAtJ¤aÌÝÉ¶§@AtJÉ¶§·éyMÍP[vyM¾¯iú{Ì°ÙÅ©éªoéj','/penguinKawamura/P[v_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(8,'t{gyM',3,'t{gC¬ª¬êéìAJ¼É¶§@¦¢Ìªêè@ú{ÅçNo.1ÌyMiú{Ì°ÙÅ©éªoéj','/penguinKawamura/t{g_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(9,'}[yM',3,'`EA[`EtH[NhÉ¶§@vwÌÌÇ³No.1iú{Ì°ÙÅ©éªoéj','/penguinKawamura/}[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(10,'tBhhyM',4,'tBhnæEI[NhEX`[gÈÇÉ¶§iú{ÅÍ©êÈ¢j','/penguinKawamura/tBhh_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(11,'V[^[yM',4,'oEeBEI[NhE}bR[ÈÇÉ¶§iú{ÅÍ©êÈ¢j','/penguinKawamura/V[^[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(12,'XlA[YyM',4,'XlA[Y(j[W[hÌìÉÊu·é)É¶§iú{ÅÍ©êÈ¢j','/penguinKawamura/XlA[Y_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(13,'}JjyM',4,'`ÌìEå¼m©çChmÉ©¯Ä¶§@yMÌÅÂÌNo.1iú{Ì°ÙÅ©éªoéj','/penguinKawamura/}Jj_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(14,'CyM',4,'I[XgAEj[W[hE}bR[É¶§iú{ÅÍ©êÈ¢j','/penguinKawamura/C_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(15,'CgryM',4,'TEXVFghELxÈÇÉ¶§iú{Ì°ÙÅ©éªoéj','/penguinKawamura/Cgr_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(16,'LKVyM',5,'j[W[hÉ¶§@yMÞÌÅÌ­È³No1iú{ÅÍ©êÈ¢j','/penguinKawamura/LKV_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(17,'RK^yM',6,'j[W[hEI[XgAÌìÝÉ¶§@ÌÌ¬³³No.1iú{Ì°ÙÅ©éªoéj','/penguinKawamura/RK^_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(18,'VcoTyM',6,'oNX¼EgiEÉ¶§@iú{ÅÍ©êÈ¢j','/penguinKawamura/VcoT_panguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00');
/*!40000 ALTER TABLE `penguin_main_kawamura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfume_main_anzai`
--

DROP TABLE IF EXISTS `perfume_main_anzai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfume_main_anzai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `song_name` varchar(256) NOT NULL,
  `release_year` int(4) NOT NULL,
  `lyricist_name` varchar(256) DEFAULT NULL,
  `album_id` int(11) DEFAULT NULL,
  `tieup_id` int(1) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfume_main_anzai`
--

LOCK TABLES `perfume_main_anzai` WRITE;
/*!40000 ALTER TABLE `perfume_main_anzai` DISABLE KEYS */;
INSERT INTO `perfume_main_anzai` VALUES (1,'OMAJINAIy',2002,'pbp[Í',NULL,NULL,'LãÌfr[È','0','2019-10-29 00:00:00','2019-11-06 13:04:05'),(2,'ÞåW',2002,'pbp[Í',NULL,NULL,'LãÌ¼È','0','2019-10-29 00:00:00','2019-11-06 10:34:05'),(3,'XEB[gh[ibc',2003,'ØÌq',1,NULL,'SCfB[Yfr[È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'r^~hbv',2004,'ØÌq',1,NULL,'à¤âéÌÈ¢AChÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'mN[GtFNg',2004,'ØÌq',1,NULL,'à¤âéÌÈ¢AChÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'jA[^[K[',2005,'cX^J',1,NULL,'W[fr[ÌÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'GNgE[h',2006,'cX^J',1,NULL,'CuÅÍÝñÈÅ·èãªé','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'p[tFNgX^[Ep[tFNgX^C',2006,'cX^J',1,NULL,'­³ê½AoÌBêÌVÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'`RCgEfBXR',2007,'cX^J',2,NULL,'o^CèÔÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Twinkle Snow Powdery Snow',2007,'cX^J',2,NULL,'`RCgfBXRÆê­\³ê½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(11,'|Y',2007,'cX^J',2,1,'±ÌÈÅ­Iqbg','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(12,'SEVENTH HEAVEN',2007,'cX^J',6,NULL,'½¾½¾©í¢¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(13,'Baby cruising Love',2008,'cX^J',2,3,'fæueLvÅgp','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(14,'}Jj',2008,'cX^J',2,NULL,'~É¨XXÌêÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(15,'GAME',2008,'cX^J',2,NULL,'AoÈA_Xªß¿á­¿á©Á±¢¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(16,'Z~bNK[',2008,'cX^J',2,2,'[éh}ÅgíêÄ¢½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(17,'V[NbgV[Nbg',2008,'cX^J',2,1,'ACXusmvÌCM¾Á½Cª·é','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(18,'Puppy love',2008,'cX^J',2,NULL,'ÝñÈÅãºãã','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(19,'edge',2008,'cX^J',3,NULL,'©Á±¢¢ªß¿á­¿áÈª·¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(20,'love the world',2008,'cX^J',3,NULL,'mNÌPVªaV','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(21,'Dream Fighter',2008,'cX^J',3,NULL,'ßÄÌ¹ÙÅ­\³ê½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(22,'[EfBXR',2009,'cX^J',3,NULL,'V¶\O','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(23,'I still love U',2009,'cX^J',3,NULL,'«ÂÚµÈªçPVBÁ½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(24,'NIGHT FLIGHT',2009,'cX^J',3,1,'±êàusmvÌCMÌÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(25,'i`ÉöµÄ',2010,'cX^J',4,1,'ApÌCMÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(26,'VOICE',2010,'cX^J',4,1,'PVÌÅã«ê¢ÉÍÜé','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(27,'FAKE IT',2010,'cX^J',6,NULL,'CuªÔ¿ãªéÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(28,'Ë¥',2010,'cX^J',5,1,'ApÌCMÈA_XÌXebvªÆÁ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(29,'÷©ÈJI',2011,'cX^J',5,1,'uXvÌCM@Â¤¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(30,'[U[r[',2011,'cX^J',5,1,'uXvÌCM@©Á±¢¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(31,'GLITTER',2011,'cX^J',5,1,'uXvÌCM@©Á±¢¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(32,'XpCX',2011,'cX^J',5,2,'uXvÌCM@©Á±¢¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(33,'MY COLOR',2011,'cX^J',5,NULL,'¢EÅà¤³ê½êÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(34,'R~jP[V',2012,'cX^J',NULL,1,'vvÂñÂñ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(35,'Spring of Life',2012,'cX^J',7,1,'ßªõé','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(36,'Hurly Burly',2012,'cX^J',10,1,'|bvÈ_Xio[','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(37,'Spending all my time',2012,'cX^J',7,1,'COio·éÛÉoµ½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(38,'¾¢¶åÎÈ¢',2013,'cX^J',7,NULL,'ÌÁ¿ªCðÆÎµ½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(39,'¢Ì~[WA',2013,'cX^J',7,3,'fæuh¦àñvÌåèÌ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(40,'Magic of Love',2013,'cX^J',7,1,'usO~vÌCMNp','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(41,'Handy Man',2013,'cX^J',7,NULL,'ÌÁ¿ªCOÅ·åÉÔá¦½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(42,'Óè©¦éÆ¢éæ',2013,'cX^J',7,NULL,'HìÌÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(43,'Party Maker',2013,'cX^J',7,NULL,'·èãªéÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(44,'1mm',2013,'cX^J',7,NULL,'ÅIdÔÉhçêÄé','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(45,'Sweet Refrain',2013,'cX^J',8,2,'·àVÜ³Ýåh}ÌåèÌ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(46,'öÍOXp¨',2013,'cX^J',8,NULL,'Ü¦Ìßè','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(47,'Cling Cling',2014,'cX^J',8,1,'VOÈÌÉCDª©Èèå«¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(48,'¢¶íéÈn[',2014,'cX^J',NULL,NULL,'Cling@Cling@ÌJbvO','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(49,'DISPLAY',2014,'cX^J',10,1,'SKerÌCM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(50,'Hold Your Hand',2014,'cX^J',8,2,'t@ÆìÁ½PVªóÛI','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(51,'Pick Me Up',2015,'cX^J',8,1,'É¨OÆÌR{','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(52,'Relax In The City',2015,'cX^J',8,1,'VOÈÌÉCDª©Èèå«¢ ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(53,'TOKIMEKI LIGHTS',2015,'cX^J',8,NULL,'D«ÈÈ¾ªóÛª¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(54,'STAR TRAIN',2015,'cX^J',8,3,'15NÌ·×Äðlßñ¾È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(55,'FLASH',2016,'cX^J',8,3,'fæu¿ÍâÓévÅgp³ê½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(56,'STORY',2016,'cX^J',8,1,'docomoÌéæÅ4GðgÁ½oª·²©Á½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(57,'Next Stage with YOU',2016,'cX^J',8,1,'xcCMÉNp','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(58,'Miracle Worker',2016,'cX^J',8,NULL,'ÈÌrÌu¨±¹~R[vªÁ¥I','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(59,'Cosmic Explorer',2016,'cX^J',8,NULL,'AoßÌÈB','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(60,'TOKYO GIRL',2017,'cX^J',9,2,'gR¢qåh}ÌåèÌ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(61,'óÎÌJ',2017,'cX^J',9,1,'¢Ora2£ TV CM\O','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(62,'Everyday',2017,'cX^J',9,1,'upnasonicvÌôó@ÌCM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(63,'If you wanna',2017,'cX^J',9,NULL,'t[`[x[Xðæèüê½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(64,'³À¢',2018,'cX^J',9,3,'fæu¿ÍâÓévÅgp³ê½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(65,'Let Me Know',2018,'cX^J',9,NULL,'PVªÂ¤¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(66,'Vó',2018,'cX^J',9,1,'docomoÌCMÅgpA2019NÅÉâIµ½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(67,'Tiny Baby',2018,'cX^J',9,NULL,'Cuoª·²¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(68,'Future Pop',2018,'cX^J',9,NULL,'2019NgÅâIµ½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(69,'iiiiiC',2019,'cX^J',10,1,'·ðe[}Æµ½È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(70,'Challenger',2019,'cX^J',10,NULL,'cX^JÆÌoï¢ÌÈ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(72,'Perfume',2006,'',NULL,NULL,'','0','2019-11-06 14:01:10','2019-11-06 14:01:10');
/*!40000 ALTER TABLE `perfume_main_anzai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_bt_kuramoto`
--

DROP TABLE IF EXISTS `player_bt_kuramoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_bt_kuramoto` (
  `id` int(11) DEFAULT NULL,
  `bt_info` varchar(5) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_bt_kuramoto`
--

LOCK TABLES `player_bt_kuramoto` WRITE;
/*!40000 ALTER TABLE `player_bt_kuramoto` DISABLE KEYS */;
INSERT INTO `player_bt_kuramoto` VALUES (0,NULL,0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(1,'EEEÅ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(2,'EE¶Å',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(3,'EE¼Å',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(4,'¶EEÅ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(5,'¶E¶Å',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(6,'¶E¼Å',0,'2021-05-19 00:00:00','2021-05-19 00:00:00');
/*!40000 ALTER TABLE `player_bt_kuramoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_main_kuramoto`
--

DROP TABLE IF EXISTS `player_main_kuramoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_main_kuramoto` (
  `id` int(11) DEFAULT NULL,
  `player_name` varchar(256) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `bt_id` int(11) DEFAULT NULL,
  `player_age` int(2) DEFAULT NULL,
  `player_years` int(2) DEFAULT NULL,
  `player_place` varchar(256) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_main_kuramoto`
--

LOCK TABLES `player_main_kuramoto` WRITE;
/*!40000 ALTER TABLE `player_main_kuramoto` DISABLE KEYS */;
INSERT INTO `player_main_kuramoto` VALUES (3,'OêP',1,3,9,9,'ª§',0,'2021-05-19 00:00:00','2021-06-02 11:27:40'),(4,'RèNW',1,1,28,7,'s',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(5,'à_ûyå',1,5,26,5,'²ê§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(6,'½c^á',1,1,31,8,'Rû§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(7,'Oãüç',1,1,32,8,'ò§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(8,'F.',1,1,26,1,'h~jJ¤a',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(9,'M..s[vY',1,1,29,2,'AJ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(10,'»cB÷',1,5,25,8,'kC¹',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(11,'E.GXRo[',1,5,29,5,'xlYG',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(12,'gC÷',1,1,29,12,'åã{',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(13,'ìÕå',1,1,21,4,'aÌR§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(14,'érl',2,1,28,10,'ª§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(15,'ääó',2,1,29,8,'«ê§',1,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(16,'äåî',3,1,31,14,'Od§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(17,'qGá',3,1,23,1,'·ì§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(18,'åa',3,1,33,16,'­§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(19,'cr¾',3,2,27,4,'_Þì§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(20,'{èqY',3,1,32,9,'²ê§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(21,'mì¼l',3,1,22,3,'V§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(22,'RºKP',3,2,28,7,'çt§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(23,'N.\g',3,1,32,4,'vGgR',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(24,'K´«u',4,1,27,10,'åã{',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(25,'²ìb¾',4,2,26,5,'ªR§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(26,'_¢aB',4,2,27,4,'«ê§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(27,'T.I[XeB',4,1,29,2,'AJ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(28,'³âq',4,2,27,10,'_Þì§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(29,'ÖªåC',4,5,25,8,'¤m§',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(30,'¡i¸¾',1,5,27,6,'ª§',0,'2021-06-01 15:31:56','2021-06-01 15:31:56'),(31,'í{×j',4,2,25,4,'åã{',0,'2021-06-01 15:37:26','2021-06-01 15:37:26');
/*!40000 ALTER TABLE `player_main_kuramoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_position_kuramoto`
--

DROP TABLE IF EXISTS `player_position_kuramoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_position_kuramoto` (
  `id` int(11) DEFAULT NULL,
  `position_name` varchar(3) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_position_kuramoto`
--

LOCK TABLES `player_position_kuramoto` WRITE;
/*!40000 ALTER TABLE `player_position_kuramoto` DISABLE KEYS */;
INSERT INTO `player_position_kuramoto` VALUES (0,NULL,0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(1,'è',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(2,'ßè',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(3,'àìè',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(4,'Oìè',0,'2021-05-19 00:00:00','2021-05-19 00:00:00');
/*!40000 ALTER TABLE `player_position_kuramoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_takahashi`
--

DROP TABLE IF EXISTS `position_takahashi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position_takahashi` (
  `id` int(11) DEFAULT NULL,
  `position` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_takahashi`
--

LOCK TABLES `position_takahashi` WRITE;
/*!40000 ALTER TABLE `position_takahashi` DISABLE KEYS */;
INSERT INTO `position_takahashi` VALUES (0,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(1,'|CgK[h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,'V[eBOK[h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,'X[tH[h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,'p[tH[h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,'Z^[','0','2021-05-18 00:00:00','2021-05-18 00:00:00');
/*!40000 ALTER TABLE `position_takahashi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resipe_main_ishikawa`
--

DROP TABLE IF EXISTS `resipe_main_ishikawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resipe_main_ishikawa` (
  `id` int(11) DEFAULT NULL,
  `resipe_title` varchar(256) DEFAULT NULL,
  `resipe_title2` varchar(256) DEFAULT NULL,
  `vegetable_id1` int(11) DEFAULT NULL,
  `vegetable_id2` int(11) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `cook_time` int(3) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resipe_main_ishikawa`
--

LOCK TABLES `resipe_main_ishikawa` WRITE;
/*!40000 ALTER TABLE `resipe_main_ishikawa` DISABLE KEYS */;
INSERT INTO `resipe_main_ishikawa` VALUES (1,'J[','©ê[',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'N[V`[','­è[Þµ¿ã[',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'÷¶áª','É­¶áª',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'[Lxc','ë[é«á×Â',3,4,2,50,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'|gt','ÛÆÓ',2,3,3,30,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'Ø~tB[','Í­³¢ÝéÓ¡[ä',5,0,2,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'|Ø','·Ô½',1,3,2,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'ÄìØO^','ÈÂâ³¢®ç½ñ',7,8,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'Ý¼êç','Ý¼êÈ×',5,11,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'«ñÒç','«ñÒç',1,10,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'s[}Ì÷lß','Ò[ÜñÌÉ­Ãß',3,6,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'no[O','ÍñÎ[®',3,0,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'eq¥','¨â±Çñ',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(14,'â¡²Íñ','½¯Ì±²Íñ',12,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(15,'¥','¬ã¤Çñ',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(16,'©Ú¿áÌÏ¨','©Ú¿áÌÉàÌ',9,0,3,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(17,'Ø`','Æñ¶é',1,3,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(18,'I²Ñ','­è²Íñ',13,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(19,'|egT_','ÛÄÆ³ç¾',2,3,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(20,'i|^','ÈÛè½ñ',6,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(21,'^g','ç½Æ¡ä',7,8,3,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(22,'rV\[Y','Ñµ»í[¸',2,0,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(23,'g}gÏ','ÆÜÆÉ',3,7,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(24,'|h[','ÛàÇ[ë',7,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00');
/*!40000 ALTER TABLE `resipe_main_ishikawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_takahashi`
--

DROP TABLE IF EXISTS `team_takahashi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_takahashi` (
  `id` int(11) DEFAULT NULL,
  `team_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_takahashi`
--

LOCK TABLES `team_takahashi` WRITE;
/*!40000 ALTER TABLE `team_takahashi` DISABLE KEYS */;
INSERT INTO `team_takahashi` VALUES (0,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(1,'{XgEZeBbNX','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,'ubNElbc','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,'j[[NEjbNX','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,'tBftBAEZueBVNT[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,'ggEv^[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(6,'VJSEuY','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(7,'N[ugELoA[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(8,'fgCgEsXgY','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(9,'CfBAiEyCT[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(10,'~EH[L[EobNX','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(11,'Ag^Ez[NX','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(12,'V[bgEz[lbc','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(13,'}CA~Eq[g','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(14,'I[hE}WbN','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(15,'VgEEBU[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(16,'fo[EiQbc','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(17,'~l\^EeBo[EuY','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(18,'INz}VeBET_[','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(19,'|[ghEgCuCU[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(20,'^EWY','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(21,'S[fXeCgEEHA[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(22,'T[XENbp[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(23,'T[XECJ[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(24,'tFjbNXETY','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(25,'TNgELOX','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(26,'_XE}[xbNX','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(27,'q[XgEPbc','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(28,'tBXEOY[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(29,'j[I[YEyJY','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(30,'TAgjIEXp[Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00');
/*!40000 ALTER TABLE `team_takahashi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tieup_anzai`
--

DROP TABLE IF EXISTS `tieup_anzai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tieup_anzai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tieup` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tieup_anzai`
--

LOCK TABLES `tieup_anzai` WRITE;
/*!40000 ALTER TABLE `tieup_anzai` DISABLE KEYS */;
INSERT INTO `tieup_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'CM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'h}','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'fæ','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
/*!40000 ALTER TABLE `tieup_anzai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokyo_main_takehara`
--

DROP TABLE IF EXISTS `tokyo_main_takehara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tokyo_main_takehara` (
  `id` int(2) NOT NULL,
  `ward_name` varchar(20) NOT NULL,
  `symbol` varchar(256) DEFAULT NULL,
  `location_id` int(1) NOT NULL,
  `population` int(7) DEFAULT NULL,
  `area` float DEFAULT NULL,
  `ward_office` varchar(20) DEFAULT NULL,
  `average_annual_income` int(4) DEFAULT NULL,
  `official_land_price` int(7) DEFAULT NULL,
  `performer` varchar(10) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokyo_main_takehara`
--

LOCK TABLES `tokyo_main_takehara` WRITE;
/*!40000 ALTER TABLE `tokyo_main_takehara` DISABLE KEYS */;
INSERT INTO `tokyo_main_takehara` VALUES (1,'çãc','/tokyoTakehara/chiyoda.jpg',5,64533,11.66,'ãiº',784,6330721,'÷ØóÑ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'','/tokyoTakehara/chuo.png',1,163185,10.21,'Vx¬',556,8219777,'áÑ³±','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'`','/tokyoTakehara/minato.png',3,258075,20.37,'åå',902,3611975,'ÖªÎ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'Vh','/tokyoTakehara/shinjuku.png',2,347661,18.22,'Vh¼û',477,3263794,'[åÄ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'¶','/tokyoTakehara/bunkyo.png',4,232801,11.29,'ãy',544,1181450,'ìXº^','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(6,'ä','/tokyoTakehara/taito.png',1,206816,10.11,'ãì',385,1376259,'VCSó','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(7,'nc','/tokyoTakehara/sumida.png',1,268192,13.77,'ó',350,589458,'å|ê÷','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(8,']','/tokyoTakehara/koto.png',1,516636,40.16,'z¬',389,583708,'cD','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(9,'iì','/tokyoTakehara/shinagawa.png',3,407084,22.84,'º_¾',427,1160600,'¡ê','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(10,'Ú','/tokyoTakehara/meguro.png',3,286462,14.67,'Ú',537,1195400,'òJµ°é','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(11,'åc','/tokyoTakehara/ota.png',3,737700,60.83,'c',395,627693,'ÐËÍ¢è','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(12,'¢cJ','/tokyoTakehara/setagaya.png',2,933708,58.05,'¢cJ',506,690153,'äMê','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(13,'aJ','/tokyoTakehara/shibuya.png',2,233060,15.11,'aJ',703,4234271,'gi¬S','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(14,'ì','/tokyoTakehara/nakano.png',2,328215,15.59,'ì',387,812547,'cTñ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(15,'À','/tokyoTakehara/suginami.png',2,582864,34.06,'ì¢²J',436,617023,'¼c´½','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(16,'L','/tokyoTakehara/toshima.png',4,300512,13.01,'rÜ',412,1147581,'RºBY','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(17,'k','/tokyoTakehara/kita.png',4,352806,20.61,'¤q',344,657836,'ÃÚÉmY','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(18,'rì','/tokyoTakehara/arakawa.png',4,217692,10.16,'rìñÚ',345,605586,'Ðªß¾Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(19,'Â´','/tokyoTakehara/itabashi.png',4,581066,32.22,'Â´æðO',350,475214,'î_áY','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(20,'ûn','/tokyoTakehara/nerima.png',2,737906,48.08,'ûn',395,435136,'ãËÊ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(21,'«§','/tokyoTakehara/adachi.png',4,681309,53.25,'~',324,367663,'r[g½¯µ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(22,'ü','/tokyoTakehara/katsushika.png',1,453522,34.8,'¼Väåt¼',333,362640,'ñ{aç','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(23,']Ëì','/tokyoTakehara/edogawa.png',1,693519,49.9,'V¬â',346,392703,'¼èµ°é','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
/*!40000 ALTER TABLE `tokyo_main_takehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `triathlon_main_mori`
--

DROP TABLE IF EXISTS `triathlon_main_mori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `triathlon_main_mori` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `maker_id` int(11) DEFAULT NULL,
  `price` int(7) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `triathlon_main_mori`
--

LOCK TABLES `triathlon_main_mori` WRITE;
/*!40000 ALTER TABLE `triathlon_main_mori` DISABLE KEYS */;
INSERT INTO `triathlon_main_mori` VALUES (1,'RS9s',1,1,800000,'/TriathlonMori/001.jpg','0','2020-03-11 00:00:00','2020-03-23 15:02:09'),(2,'RT9',2,1,410000,'/TriathlonMori/002.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'GALLIUM PRO',1,2,380000,'/TriathlonMori/003.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'E-119 TRI+',2,2,576000,'/TriathlonMori/004.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'OLTRE XR4',1,3,1780000,'/TriathlonMori/005.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'AQUILA CV',2,3,900000,'/TriathlonMori/006.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'G8 PRO',1,4,748000,'/TriathlonMori/007.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'AEROLIGHT',2,4,1050000,'/TriathlonMori/008.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'Timemachine Road 01',1,5,880000,'/TriathlonMori/009.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'Timemachine 01',2,5,870000,'/TriathlonMori/010.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'VIDE pro CT-RTV',1,6,500000,'/TriathlonMori/011.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'SWOOP CT-TT',2,6,418000,'/TriathlonMori/012.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'Ultomate CF Evo',1,7,899000,'/TriathlonMori/013.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'Speedmax CF SLX LTD',2,7,1109000,'/TriathlonMori/014.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'S5',1,8,1580000,'/TriathlonMori/015.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'P5X',2,8,2280000,'/TriathlonMori/016.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'RB1K \"THE ONE\"',1,9,720000,'/TriathlonMori/017.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'NKTT',2,9,990000,'/TriathlonMori/018.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'C64',1,10,738000,'/TriathlonMori/019.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'K.one',2,10,620000,'/TriathlonMori/020.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'LITENING C:68X SLT',1,11,1176000,'/TriathlonMori/021.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'AERIUM C:68 SLT',2,11,1387000,'/TriathlonMori/022.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'TRILLIANT',2,12,470000,'/TriathlonMori/023.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'CARBONADO',2,12,370000,'/TriathlonMori/024.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'525',1,13,466000,'/TriathlonMori/025.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'LUGANO68',2,13,278000,'/TriathlonMori/026.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(27,'O2 V.A.M',1,14,590000,'/TriathlonMori/027.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(28,'SLICK',2,14,680000,'/TriathlonMori/028.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(29,'FR FRD',1,15,1980000,'/TriathlonMori/029.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(30,'IA FRD',2,15,2480000,'/TriathlonMori/030.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(31,'TRANSONIC 1.1',1,16,340000,'/TriathlonMori/031.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(32,'NORCOM STRAIGHT 1.1',2,16,290000,'/TriathlonMori/032.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(33,'PROPEL ADVANCED SL',1,17,1300000,'/TriathlonMori/033.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(34,'TRINITY ADVANCE PRO 1',2,17,690000,'/TriathlonMori/034.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(35,'STRAUSS PRO',1,18,248000,'/TriathlonMori/035.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(36,'STRAUSS TRI',2,18,199000,'/TriathlonMori/036.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(37,'KHAN',1,19,365000,'/TriathlonMori/037.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(38,'KT05',2,19,460000,'/TriathlonMori/038.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(39,'SCULTURA 10K-E',1,20,1200000,'/TriathlonMori/039.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(40,'TIME WARP TRI 10K-E',2,20,1350000,'/TriathlonMori/040.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(41,'DOGMA F12',1,21,1300000,'/TriathlonMori/041.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(42,'BOLIDE TR+',2,21,1570000,'/TriathlonMori/042.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(43,'HELIUM SLX',1,22,365000,'/TriathlonMori/043.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(44,'DEAN',2,22,323000,'/TriathlonMori/044.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(45,'FOIL PREMIUM',1,23,1118000,'/TriathlonMori/045.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(46,'PLASMA RC',2,23,1190000,'/TriathlonMori/046.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(47,'S-Works VENGE',1,24,1375000,'/TriathlonMori/047.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(48,'S-Works Shiv',2,24,1404000,'/TriathlonMori/048.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(49,'Madone SLR 9',1,25,1281000,'/TriathlonMori/049.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(50,'Speed Concept',2,25,510000,'/TriathlonMori/050.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(51,'ZERO SLR',1,26,590000,'/TriathlonMori/051.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(52,'TURBINE',2,26,650000,'/TriathlonMori/052.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(53,'±¶ë¤',0,0,100,'/TriathlonMori/20200323150234372.jpg','0','2020-03-19 11:02:07','2020-03-23 15:02:34'),(54,'àà',1,8,9999999,NULL,'1','2020-03-23 09:12:05','2020-03-23 09:12:05'),(55,'àà',1,10,1,'/TriathlonMori/20200323150336788.jpg','0','2020-03-23 15:03:36','2020-03-23 15:03:36');
/*!40000 ALTER TABLE `triathlon_main_mori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_mori`
--

DROP TABLE IF EXISTS `type_mori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_mori` (
  `id` int(11) NOT NULL,
  `type` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_mori`
--

LOCK TABLES `type_mori` WRITE;
/*!40000 ALTER TABLE `type_mori` DISABLE KEYS */;
INSERT INTO `type_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'[hoCN','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'^CgCAoCNiTT)','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
/*!40000 ALTER TABLE `type_mori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `password` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Spring','Boot');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vegetable_ishikawa`
--

DROP TABLE IF EXISTS `vegetable_ishikawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vegetable_ishikawa` (
  `id` int(11) DEFAULT NULL,
  `vegetable` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vegetable_ishikawa`
--

LOCK TABLES `vegetable_ishikawa` WRITE;
/*!40000 ALTER TABLE `vegetable_ishikawa` DISABLE KEYS */;
INSERT INTO `vegetable_ishikawa` VALUES (1,'Éñ¶ñ','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'¶áª¢à','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'½ÜË¬','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'Lxc','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'Ø','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'s[}','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'g}g','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'iX','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'©Ú¿á','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'²Ú¤','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'¾¢±ñ','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'â¡','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'I','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00');
/*!40000 ALTER TABLE `vegetable_ishikawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vtuber_main_umehara`
--

DROP TABLE IF EXISTS `vtuber_main_umehara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vtuber_main_umehara` (
  `id` int(11) NOT NULL,
  `vtuber_name` varchar(256) NOT NULL,
  `company_id` int(11) NOT NULL,
  `forms_id` int(11) NOT NULL,
  `contents_id` int(11) NOT NULL,
  `channel_followers` int(11) DEFAULT NULL,
  `channel_url` varchar(256) NOT NULL,
  `channel_date` datetime DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vtuber_main_umehara`
--

LOCK TABLES `vtuber_main_umehara` WRITE;
/*!40000 ALTER TABLE `vtuber_main_umehara` DISABLE KEYS */;
INSERT INTO `vtuber_main_umehara` VALUES (1,'müe',1,1,1,862000,'https://www.youtube.com/channel/UCD-miitqNY3nyukJ4Fnf4_A','2018-02-01 00:00:00','¶úðSÉYoutubeÅ®µÄ¢éAo[`¢EÌwÏõÉ®Ìq¶B','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'ecØ±ç',2,1,1,1930000,'https://www.youtube.com/channel/UC1DCedRgGHBdm81E1llLhOQ/','2019-07-03 00:00:00','zCu3ú¶','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'î',1,1,1,630000,'https://www.youtube.com/channel/UCv1fFr156jc65EMiLbaLImw','2018-03-06 00:00:00','êlÌªuíµv','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'óà}',2,1,1,1910000,'https://www.youtube.com/channel/UCCzUftO8KOVkV4wQG1vkUvg/','2019-07-22 00:00:00','zCuOú¶','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'ú_±ëË',2,1,1,1810000,'https://www.youtube.com/channel/UChAnqc_AY5_I3Px5dig3X1Q/','2019-03-25 00:00:00','zCu®','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'t',1,1,1,1270000,'https://www.youtube.com/channel/UCSFCh5NL4qXrAy9u-u2lX3g/','2018-03-05 00:00:00','Îû¤É¥³ê{íêé±ÆðÚWÉµÄ¢éB','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'åóXo',2,1,1,1310000,'https://www.youtube.com/channel/UCvzGlP9oQwU--Y0r9id_jnA/','2018-08-22 00:00:00','i¬ZÆe-sportsÌ}l[W[','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(8,'³­çÝ±',2,1,1,1440000,'https://www.youtube.com/channel/UC-hM6YJuNYVAmUWxeIr9FeA/','2018-04-25 00:00:00','zCu®ÌG[gÞACh','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(9,'',1,1,1,994000,'https://www.youtube.com/channel/UCspv01oxUFf_MTSipURRhkA/','2018-05-01 00:00:00','É¶³ñ¶®Co[','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(10,'LYiAC',4,1,1,3090000,'https://www.youtube.com/channel/UC4YaOt1yT-ZeyB0OmxHgolA/','2016-10-19 00:00:00','®x~','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(11,'© ­ ',2,1,1,1620000,'https://www.youtube.com/channel/UC1opHUrw8rvnsadT-iGp7Cg/','2018-08-01 00:00:00','zCu®·[Ï[ ¢ÇéQ[}[Ch','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(12,'ãtuL',2,1,1,1870000,'https://www.youtube.com/channel/UCdn5BQ06XqgXoAxIhbqw5Rg/','2018-05-24 00:00:00','Ï(FOX)Ìo[`ÏÆµÄ®','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(13,'µ®ê¤¢',5,1,1,725000,'https://www.youtube.com/channel/UCt30jJgChL8qeT9VPadidSw/','2018-09-16 00:00:00','CXg[^[','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(14,'úåÆ±',1,1,1,606000,'https://www.youtube.com/channel/UCXRlIK3Cw_TJIQC5kSJJQMg/','2019-03-19 00:00:00','Q[ÉÌÉGkÉA¢ëñÈðµÄ¢é','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(15,'âmG',2,1,1,1480000,'https://www.youtube.com/channel/UCdyqAaZDKHXg4Ahi7VENThQ/','2019-07-26 00:00:00','¨ÁÆèµÄ¢éªAÈñÅàØÍÅÇ¤É©·é¨ÈÊðÂ äéÓí]ØRm','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(16,'¯X·¢¹¢',2,1,1,1450000,'https://www.youtube.com/channel/UC5CwaMl1eIgY8h02uZw7u8A/','2018-03-18 00:00:00','AChVtuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(17,'²A',1,1,1,353000,'https://www.youtube.com/channel/UCCVwhI5trmaSxfcze_Ovzfw/','2019-01-15 00:00:00','É¶³ñ¶® ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(18,'{ÔÐÜíè',1,1,1,692000,'https://www.youtube.com/channel/UC0g1AE0DOjBYnLhkgoRWN1w/','2018-07-02 00:00:00','ÙÚúQ[zMðµÄ¢éB','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(19,'Pé',4,1,1,914000,'https://www.youtube.com/channel/UCQYADFw7xEJ9oZSM5ZbqyBw/','2017-12-05 00:00:00','yItBVHPzhttp://www.kaguyaluna.jp/','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(20,'xm¨',4,1,1,343000,'https://www.youtube.com/c/Aoich/','2017-10-25 00:00:00','2022/04/20@j[VO[X','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(21,'é­q',1,1,1,531000,'https://www.youtube.com/channel/UCwokZsOK_uEre70XayaFnzA/','2018-03-06 00:00:00','ÌÌ¨o³ñÅqÅ¥Ì26Î','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(22,'Ðz',1,1,1,611000,'https://www.youtube.com/channel/UCKMYISTJAQ8xTplUPHiABlA/','2018-05-25 00:00:00','½¾ÌI^N','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(23,'V¹©È½',2,1,1,1190000,'https://www.youtube.com/channel/UCZlDXzGoo7d44bwdNObFacg/','2019-12-04 00:00:00','zCu4ú¶','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(24,'smÎtA',2,1,1,877000,'https://www.youtube.com/channel/UCvInZx9h3jC2JzsIzoOebWg/','2019-07-26 00:00:00','zCuOú¶','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(25,'ÅÑÅÑEÅÑé',1,1,1,481000,'https://www.youtube.com/channel/UCjlmCrq4TP1I4xguOtJ-31w/','2019-01-31 00:00:00','É¶³ñ¶®¨»ëµ¢ ­ÜÌ¿áñËéÇ¤ªÆÍ¢µñð·é','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(26,'GawrGura',2,1,1,3940000,'https://www.youtube.com/channel/UCoSrY_IQQVpmIRZ9Xf-y93g/','2020-07-16 00:00:00','zCuENÉ®','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(27,'¢R½Ü«',4,1,1,823000,'https://www.youtube.com/channel/UC8NZiqKx6fsDT3AVcMiVFyA/','2017-06-30 00:00:00','æÆ ÏÏÌè¨ªÂl^cµÄ¢éo[`YouTuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(28,'¯ìT',1,1,1,765000,'https://www.youtube.com/channel/UC9V3Y3_uzU5e-usObb6IE1w/','2019-09-25 00:00:00','¨èÆQ[ÆÌª¾¢·«','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(29,'å_~I',2,1,1,982000,'https://www.youtube.com/channel/UCp-5t9SrOQwXMU7iIjQfARg/','2018-12-01 00:00:00','zCu®ÌVtuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(30,'ùØç',1,1,1,731000,'https://www.youtube.com/channel/UCoztvTULBYd3WmStqYeoHcA/','2018-07-02 00:00:00','Q[¾¢·«','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
/*!40000 ALTER TABLE `vtuber_main_umehara` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-18 13:52:03
