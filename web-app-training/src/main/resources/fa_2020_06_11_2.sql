-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fa
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

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
-- Table structure for table `area_ito`
--

DROP TABLE IF EXISTS `area_ito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_ito` (
  `id` int(11) DEFAULT NULL,
  `area` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_ito`
--

LOCK TABLES `area_ito` WRITE;
/*!40000 ALTER TABLE `area_ito` DISABLE KEYS */;
INSERT INTO `area_ito` VALUES (0,NULL,'0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(1,'s','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(2,'éÊ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(3,'çt§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(4,'_Þì§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(5,'ºÉ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(6,'¤m§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(7,'V§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(8,'åã{','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(9,'ÞÇ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(10,'ª§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(11,'s{','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(12,'kC¹','0','2020-03-24 00:00:00','2020-03-24 00:00:00');
/*!40000 ALTER TABLE `area_ito` ENABLE KEYS */;
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
-- Table structure for table `band_main_ito`
--

DROP TABLE IF EXISTS `band_main_ito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `band_main_ito` (
  `id` int(11) DEFAULT NULL,
  `band_name` varchar(256) DEFAULT NULL,
  `sex_id` int(11) DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `form_year` int(4) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_main_ito`
--

LOCK TABLES `band_main_ito` WRITE;
/*!40000 ALTER TABLE `band_main_ito` DISABLE KEYS */;
INSERT INTO `band_main_ito` VALUES (1,'Fear,and loathing in LasVegas',1,5,2008,'Èñ¿áçXxKXÅo¦êêÎOK/Step Of Terror','0',NULL,NULL),(2,'a crowd of rebellion',1,7,2007,'È²A¹AºG³ª¦®¢/Never Say A Gain','0',NULL,NULL),(3,'crossfaith',1,8,2006,'CuÅFlªÜµ½/Blue','0',NULL,NULL),(4,'Coldrain',1,6,2007,'TEhª©Á±¢¢/F.T.T.T','0',NULL,NULL),(6,'HEY-SMITH',1,8,2006,'XJpNªÅ/Drug Free Japan','0',NULL,NULL),(7,'SiM',1,4,2004,'QGvf è/RiOT','0',NULL,NULL),(8,'}LV}Uz',3,1,1998,'CuÝñÈÎ·lá­Èé/uFv','0',NULL,NULL),(9,'Ailiph@Doepa',1,1,2010,'CtGUÌÆ«É©éæ¤ÈMV½¢/MARS','0',NULL,NULL),(10,'04Limted Sazabys',1,6,2008,'ÈÌuõ´/Knife','0',NULL,NULL),(11,'tfbN',1,5,2009,'ÌºàrWà­¢oq/TOGENKYO','0',NULL,NULL),(12,'LE\lRJ~',1,5,2009,'Lb`[ÅÊ¢/w¿áñ','0',NULL,NULL),(13,'ELLEGARDEN',1,3,1998,'½ì/T^N[X','0',NULL,NULL),(14,'¤I',1,5,2009,'o[1l1lÌrW­¢/à¯','0',NULL,NULL),(15,'Åñå¯Dï',3,NULL,2004,'BaªÒïÉ©¦È¢AÑeoh/DNA','0',NULL,NULL),(16,'zÆµÄJ',3,2,2002,'cC{~hªÅ/nakano kill you','0',NULL,NULL),(17,'THE ORAL CIGARETTES',1,9,2010,'_[NÈµÍC©àµÄé/DIP-BAP','0',NULL,NULL),(18,'FACT',1,NULL,1999,'¨Êoh/error','0',NULL,NULL),(19,'MAN WITH A MISSIOM',1,1,2010,'Toh/NEVER FXXKIN\' MIND THE RULES','0',NULL,NULL),(20,'The BONEZ',1,NULL,2012,'JESSE©Á±¢¢/Hello Monster','0',NULL,NULL),(21,'AJ',1,5,2002,'VoªñÉ^oõµÄ¢éigíÈ¢j/`NV[','0',NULL,NULL),(22,'|JhbgXeBOC',2,10,2015,'Í­¢«Vo/GNgbNEpubN','0',NULL,NULL),(23,'@­ÉÈèà',2,NULL,2014,'Voªµá×êÈ­Èéô¢ð©¯çêÄ¢ÄÂ¤¢/qT}Xsbc','0',NULL,NULL),(24,'N[vnCv',1,1,2001,'ºªÈÉÈé/S','0',NULL,NULL),(25,'}Jj¦ñÒÂ',1,4,2012,'©ûÉ®¢½çG©Á½/hNÊ','0',NULL,NULL),(26,'T{}X^[',1,1,2000,'CuÅêÔ¯éoh/u\O','0',NULL,NULL),(27,'»±ÉÂé',3,8,2011,'cCÌdÈè¢ªÇ¢/¶Åxé','0',NULL,NULL),(28,'qXebNpjbN',1,6,2012,'d­ÄLb`[ÈTEhÅÇ¢/Êá','0',NULL,NULL),(29,'ROTTENGRAFFTY',1,11,1999,'|¯¢ª©Á±Ç¢/àFOteB[','0',NULL,NULL),(30,'TJiNV',1,12,2005,'VóÌ®«ªª©ç£êÈ¢/½ªA','0',NULL,NULL),(31,'éÌ{C_X',1,NULL,2008,'ÄéVcª¢Âà¨µáê/with out you','0',NULL,NULL),(32,'Survive Said The Prophet',1,1,2011,'oh¼ÇÝÃç¢/found & lost','0',NULL,NULL),(33,'[ÅÉU¢µ½ÌVgB',1,4,2015,'uCN_Eª¨àµë¢youtuberoh/NÉÍ©È¢ºÍC^AÉàÍ©È¢AÌÉ~m','0',NULL,NULL),(34,'Pay money To my Pain',1,1,2005,'àÁÆ­mÁÄ¨¯Îæ©Á½Æv¤oh/Sweetest vengeance','0',NULL,NULL),(35,'ßOlA©Ä¯ÉcL',1,7,2011,'o[ªå«­ÏíÁÄàÈª©Á±¢¢/öñ','0',NULL,NULL);
/*!40000 ALTER TABLE `band_main_ito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cd_main_kanayama`
--

DROP TABLE IF EXISTS `cd_main_kanayama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cd_main_kanayama` (
  `id` int(11) NOT NULL,
  `cd_title` varchar(252) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `artist_name` varchar(252) NOT NULL,
  `release_year` int(4) NOT NULL,
  `play_time` int(3) DEFAULT NULL,
  `comment` varchar(252) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cd_main_kanayama`
--

LOCK TABLES `cd_main_kanayama` WRITE;
/*!40000 ALTER TABLE `cd_main_kanayama` DISABLE KEYS */;
INSERT INTO `cd_main_kanayama` VALUES (1,'c¿t@X',1,'ONE OK ROCK',2011,40,'Re:makeªüÁÄ¢éAoÅ·Bã\ìÅ·B','0','2020-05-19 00:00:00','2020-06-02 09:40:44'),(2,'âÎâ½',1,'RADWIMPS',2011,65,'NÆrÆÂªD«Å·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'Schwarzenegger',1,'[Alexandros]',2012,57,'{[JªV¿áñªD«¾©ç±Ì^CgÉÈÁ½çµ¢Å·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'period',1,'androp',2014,55,'13ÈÚÌMissingÌMVªØÈ­ÄD«Å·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'SÌê',1,'LEGO BIG MORL',2017,55,' È½ª¢êÎ¢¢ÌÉÌMVÍgòº³ñoÅK©Å·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'ENTERTAINMENT',2,'SEKAI NO OWARI',2012,70,'¡æèëÁÄéÈª½­ÄÁ­là½¢Æv¢Ü·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'GAME',2,'Parfume',2008,56,'|YÌüÁÄ¢éAParfumeÌã\ìÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'YANKEE',2,'ÄÃºt',2014,64,'AClNClªã\ìÅAMVÍÄÃ³ñÌèìèÌAj[VÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'LEO',2,'ÆüI',2012,49,'17ÎÆÍv¦È¢ãYíÈÌºÆ@×ÈÌªø«§ÂìiÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'Checkmate!',2,'ÀºÞüb',2011,70,'SÈ¼ÌA[eBXgÌûÆR{³êÄ¢ÄÆÄàØÈ1Å·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'(Deluxe)',3,'Ed Sheeran',2017,59,'shape of youð·­ÆAÆÄàxè½­ÈèÜ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'Born This Way',3,'Lady GaGa',2011,100,'Í­¢ÌºªóÛIÈAKKÌã\ìÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'Avril Lavigne',3,'Avril Lavigne',2013,56,'bNeCXgÈÈª½­AbNÆ|bvÌZð´¶Ü·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'1',3,'Avicii',2013,73,'NOAS­ÈÁ½±Æª¡ÅàM¶çêÜ¹ñB','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'1989',3,'Taylor Swift',1989,49,'·¢Ä¢é¾¯Å¾é¢C¿ÉÈêéfB[ªóÛIÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'g@Ô',4,'LiSA',2019,17,'SÅÌnÅêôL¼ÉÈÁ½êÈÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'cÈVgÌe[[',4,'´mq',1995,20,'G@ð©½±ÆªÈ­ÄàmÁÄ¢élÌ½¢L¼ÈAj\Å·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'Â¢x',4,'Galileo Galilei',2011,17,'u ÌÔvÌI[vjOe[}ÆµÄmçêÄ¢éAGGÌ¼ÈÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'©RÖÌi',4,'Linked Horizon',2013,15,'iÌlÌI[vjOÆµÄÅàL¼Èg@Ì|îªüÁÄ¢Ü·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(20,'Å¿ã°ÔÎ',4,'DAOKO',2017,13,'fæÌåèÌÅAÄÃºt³ñÆÌR{ªbèÉÈèÜµ½B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(21,'La La Land',5,'Various Artists',2016,46,'Someone In the Crowdð·­ÆAfæÌ_XV[ðN¾Év¢oµÜ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(22,'Phantom Of The Opera Original London Cast',5,'Various Artists',1986,101,'~[WJfæÅÅàD«ÈAoÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(23,'Ìî}Ö',5,'vÎ÷',2004,37,'hCuACª©¦éÆuCÌ©¦éXvð¬µÜ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(24,'Vf',5,'Various Artists',2005,60,'c¢±ëÉ½xàfæÅÝ½Av¢oÌêÅ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(25,'nEÌ®­é',5,'vÎ÷',2004,69,'l¶Ì[S[hð·­ÆA¢ÂàóUàð·éV[ðv¢oµÜ·B','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(27,'ó©ç~éê­Ì¯',1,'plenty',2014,25,'ØÈ¢CªÉÈéÈª½¢AoÅ·B','1','2020-06-02 09:52:48','2020-06-02 09:52:48'),(28,'RebelionStar',4,'Trickstar',2019,15,' ñ³ñÔéX^[YI','1','2020-06-02 15:50:35','2020-06-02 15:50:35');
/*!40000 ALTER TABLE `cd_main_kanayama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comic_main_miyoshi`
--

DROP TABLE IF EXISTS `comic_main_miyoshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comic_main_miyoshi` (
  `id` int(11) NOT NULL,
  `comic_title` varchar(256) DEFAULT NULL,
  `magazine_id` int(11) DEFAULT NULL,
  `author` varchar(256) DEFAULT NULL,
  `volume` int(3) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comic_main_miyoshi`
--

LOCK TABLES `comic_main_miyoshi` WRITE;
/*!40000 ALTER TABLE `comic_main_miyoshi` DISABLE KEYS */;
INSERT INTO `comic_main_miyoshi` VALUES (1,'SÅÌn',1,'á»Ä¢°',20,'¡·²¢lCB®','0','2020-06-02 10:34:03','2020-06-10 16:52:29'),(2,'lÌq[[AJf~A',1,'xzk½',26,'±êàlC','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(3,'nCL[!!',1,'ÃÚtê',43,'o[æ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(4,'qÌoXP',1,'¡ªr',30,'oXPæ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(5,'Dr.STONE',1,'î_êYABoichi',15,'OAjâÁÄ½','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(6,'ÂÌâPt',2,'Á¡ab',24,'¨àµë¢','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(7,'ôpôí',1,'H©ºX',10,'ÇñÅÝ½¢BAj»èB','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(8,'_CÌA',3,'Tñ',47,'ìæ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(9,'_CÌA@actU',3,'Tñ',21,'æ2','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(10,'iÌl',4,'ÐRn',31,'L¼æ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(11,'BLEACH',1,'vÛÑl',74,'®','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(12,'â°',1,'ómpH',77,'®','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(13,'NARUTO',1,'Ý{Äj',72,'®','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(14,'µÂÌåß',3,'éØ',41,'®','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(15,'VejXÌ¤ql',2,'ã',29,'·­±¢Ä¢éC[W','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(16,'D.Gray-man',2,'¯ìj',26,'xXxÚ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(17,'±Ì¹ÆÜê',2,'A~[',22,'OAjâÁÄ½','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(18,'¼TãRi',5,'ÂR¹',98,'L¼æ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(19,'s[X',1,'öchêY',96,'L¼æ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(20,'t[coXPbg',6,'®Þ',23,'Ajú','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(21,'ÅÌi',6,'âÝ¸Ù',32,'Aj»³ê½','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(22,'wxr[Vb^[Y',7,'vìÍè',20,'Aj»³ê½','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(23,'Ô¯ÌáP',7,' «Ã«ó¾',22,'Aj»³ê½','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(24,'÷ZzXg',7,'t¹rXR',18,'®','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(25,'_lÍ¶ßÜµ½',6,'éØWGb^',25,'®','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(26,'HÌ\[}',1,'²r',36,'®','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(27,'ubNN[o[',1,'c©Tî',24,'AÚ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(28,'HUNTER~HUNTER',1,'y~`',36,'xÚÅL¼','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(29,' ÐéÌó',3,'úüj',50,'AÚ','0','2020-06-02 10:34:03','2020-06-02 10:34:03'),(30,'mÁhà',3,'åvÛÄ',23,'AÚ','0','2020-06-02 10:34:03','2020-06-02 10:34:03');
/*!40000 ALTER TABLE `comic_main_miyoshi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comic_main_yanai`
--

DROP TABLE IF EXISTS `comic_main_yanai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comic_main_yanai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comic_title` varchar(256) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `pubco_id` int(11) DEFAULT NULL,
  `volume` int(3) NOT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comic_main_yanai`
--

LOCK TABLES `comic_main_yanai` WRITE;
/*!40000 ALTER TABLE `comic_main_yanai` DISABLE KEYS */;
INSERT INTO `comic_main_yanai` VALUES (1,'HUNTER~HUNTER',1,1,36,'Íâ­±«ªÇÝ½¢',0,'2020-05-20 12:00:00','2020-06-01 16:28:10'),(2,'HV',1,1,12,'Iíèûª¢¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(3,'LO_',5,3,57,'oÄ­é«RªÝñÈ©Á±¢¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(4,'l',4,2,16,'à¤¿å¢ÅIíè»¤',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(5,'SLAM DUNK',2,1,20,'VÅ¾ÆæØèªæ­Ä¢¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(6,'_CÌå`¯',1,1,37,'ßÁ¿á­¿á¤¹',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(7,'âÍpY`à',4,1,17,'¬àÅàÇÝ½­ÈÁ½',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(8,'ht^[Y',5,4,6,'Ê¢ÌÉy[Xªx·¬é',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(9,'gæ·¢Ä­ê',3,2,7,'êÊlªWIðâéRfBæ',0,'2020-05-20 12:00:00','2020-06-01 11:31:54'),(10,'Cé',5,3,5,'×­ÉÈé±Æª½¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(11,']ËéÄ',6,3,2,'æ{Ò¾¯ÅÈ­RªÊ¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(12,'CxX^[Z',6,2,21,'Ì¢Eªí©é',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(13,'TN`A',6,2,8,'àeªM¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(14,'¤lBÌ@CLO',6,1,19,'èÉ¾¬éWJª½¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(15,'ÐòÆ©à',5,1,3,'o½ÎÁ©ÈÌÅ±ê©çyµÝ',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(16,'u[sIh',6,2,7,'üå¶·²¢ÈÆvÁ½',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(17,'rìA_[UubW',3,4,15,'Åãªæ­í©çÈ©Á½',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(18,'eK~o`',1,1,20,'Gª«ê¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(19,'¯ðp®àÌ',4,3,4,'SFåìÌæÅ',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(20,'DAYS',2,2,38,'ålöÌ¬·ª¦Ü¶¢',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(21,'o`o`',2,4,16,'oæBZíqª©Á±¢¢B',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(22,'o`o`BURST',2,4,12,'o`o`V[YÌæñ',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(23,'LAÅãÌ\Üú',2,4,20,'ìÒªS­Èè¢®ÌÜÜ®',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(24,'oN}B',6,1,20,'æÆÍåÏ',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(25,'|ÌBàpt',1,4,27,'ßÄSª©Á½æB',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(26,'iÌl',1,2,31,'üª·²¢I',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(27,'àFÌKbV',1,3,33,'¨ÌêlêlÉXg[[ª é',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(28,'GIANT KILLING',2,2,54,'ÄÂªålöÌ¿µ¢TbJ[æ',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(29,'V[gEs[X',6,3,1,'AIAVÌìÒÌæB±ªó]',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(30,'T[}à¾Y',6,1,30,'à¿áñÌl¶ªsâ·¬éB',0,'2020-05-20 12:00:00','2020-05-20 12:00:00');
/*!40000 ALTER TABLE `comic_main_yanai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `container_ohkubo`
--

DROP TABLE IF EXISTS `container_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `container_ohkubo` (
  `id` int(11) NOT NULL,
  `container` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `container_ohkubo`
--

LOCK TABLES `container_ohkubo` WRITE;
/*!40000 ALTER TABLE `container_ohkubo` DISABLE KEYS */;
INSERT INTO `container_ohkubo` VALUES (0,NULL,'0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(1,'ybg{g','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(2,'Ê','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(3,'pbN','0','2020-05-20 00:00:00','2020-05-20 00:00:00');
/*!40000 ALTER TABLE `container_ohkubo` ENABLE KEYS */;
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
-- Table structure for table `drink_main_ohkubo`
--

DROP TABLE IF EXISTS `drink_main_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drink_main_ohkubo` (
  `id` int(11) NOT NULL,
  `drink_name` varchar(256) NOT NULL,
  `maker_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `ml` int(11) DEFAULT NULL,
  `container_id` int(11) NOT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_main_ohkubo`
--

LOCK TABLES `drink_main_ohkubo` WRITE;
/*!40000 ALTER TABLE `drink_main_ohkubo` DISABLE KEYS */;
INSERT INTO `drink_main_ohkubo` VALUES (1,'RJER[',1,1,500,1,'êÔW[È1','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'uü',1,2,600,1,'17íÞÌA¨fÞz','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'CC',2,1,500,1,'r^~Cª½ÁÕè','0','2020-05-19 00:00:00','2020-06-04 13:40:00'),(4,'Gh}Ee',3,3,190,2,'µI³ê½3%Ì¤ðgp','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'BOSSæÒò÷',2,3,185,2,'ÁÊà÷µ½µI¤ðSÉuh','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'R[q[û',4,4,500,3,'ål©çqÇàÜÅyµßé4','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'t@^O[v',1,1,500,1,'1958NÉ­Bú{Å¤³ê±¯Ä¢ét[o[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'¨[¢¨',5,5,525,1,'ÆÁÌ`óÅõðJbgµANxðÛÂ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'|JXGbg',6,2,500,1,'ÌtÉß¢¬ªBÌàÉf­zû³êé','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'»é',1,5,525,1,'}{Å¢ê½æ¤È¡í¢','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'JsXEH[^[',7,2,500,1,'û_ÛÆyêA­yÆ¢¤©R»@ª¶Ý¾·Æ©Ì¨¢µ³','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'¢ëÍ·',1,6,555,1,'µI³ê½S7ÅÌµ½ðgp','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'CRAFTBOSS',2,3,500,1,'µIµ½YûÆkC¹YÌ¶N[ðí¹½Dµ¢RN','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'¢¿²I[',8,4,500,3,'ÃÝª­¢YÌÆ¿¨Æß¾¯ðgpBÓñíèÆé~N´ªÁ¥','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'JtFI[',8,4,500,3,'¢Âà©íçÊ¨¢µ³B üµÆâ³µ³ð^¦éOZ[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'yvV',2,2,490,1,'ûÉüê½uÔÉ´¶éùÝ²½¦ÆùÝIíÁ½ãÌLÌæ³','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'bhu',9,2,250,2,'ðö¯é','1','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'X^[GiW[',7,2,355,2,'ÆÁÌ¡ªµÂÂàhIÅGiW[ð´¶éùÝ²½¦Ì é¡','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'¶',10,5,525,1,'¶tÌtbVÈ¤ÜÝÉANóÈ5Ìè','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(20,'ìAvXÌVR',2,6,550,1,'·Á«èÆLªæ­A³íâ©È´Á´Ì é¡í¢','1','2020-05-19 00:00:00','2020-05-19 00:00:00'),(21,'t@^',1,1,NULL,1,'500,¨¢µ¢,500,¨¢µ¢','0','2020-06-04 12:15:24','2020-06-04 12:15:24'),(22,'t@^',1,1,NULL,1,'500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢','0','2020-06-04 12:15:34','2020-06-04 12:15:34'),(23,'t@^',1,1,NULL,1,'500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢','1','2020-06-04 13:28:37','2020-06-04 13:28:37'),(24,'t@^',1,1,NULL,1,'500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢','1','2020-06-04 13:30:23','2020-06-04 13:30:23'),(25,'t@^',1,1,NULL,1,'500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢,500,¨¢µ¢','1','2020-06-04 13:32:00','2020-06-04 13:32:00');
/*!40000 ALTER TABLE `drink_main_ohkubo` ENABLE KEYS */;
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
-- Table structure for table `genre_kanayama`
--

DROP TABLE IF EXISTS `genre_kanayama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_kanayama` (
  `id` int(11) NOT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_kanayama`
--

LOCK TABLES `genre_kanayama` WRITE;
/*!40000 ALTER TABLE `genre_kanayama` DISABLE KEYS */;
INSERT INTO `genre_kanayama` VALUES (0,NULL,'0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'Jrock','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'Jpop','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'my','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'Aj','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'TEhgbN','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
/*!40000 ALTER TABLE `genre_kanayama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_kataoka`
--

DROP TABLE IF EXISTS `genre_kataoka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_kataoka` (
  `id` int(1) NOT NULL,
  `genre` varchar(20) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_kataoka`
--

LOCK TABLES `genre_kataoka` WRITE;
/*!40000 ALTER TABLE `genre_kataoka` DISABLE KEYS */;
INSERT INTO `genre_kataoka` VALUES (0,' ','0','2020-03-24 02:37:07','2018-09-17 06:00:00'),(1,'¶»âY','0','2020-03-24 02:39:42','2018-09-17 06:00:00'),(2,'©RâY','0','2020-03-24 02:39:08','2020-03-23 17:00:00');
/*!40000 ALTER TABLE `genre_kataoka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_yanai`
--

DROP TABLE IF EXISTS `genre_yanai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_yanai` (
  `id` int(11) NOT NULL,
  `genre` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_yanai`
--

LOCK TABLES `genre_yanai` WRITE;
/*!40000 ALTER TABLE `genre_yanai` DISABLE KEYS */;
INSERT INTO `genre_yanai` VALUES (0,' ','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(1,'og','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(2,'X|[c','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(3,'úíAMO','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(4,'SF','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(5,'ðj','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(6,'q[}h}','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(7,'»Ì¼','0','2020-05-20 12:00:00','2020-05-20 12:00:00');
/*!40000 ALTER TABLE `genre_yanai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `heritage_main_kataoka`
--

DROP TABLE IF EXISTS `heritage_main_kataoka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `heritage_main_kataoka` (
  `id` int(2) NOT NULL,
  `genre_id` int(1) NOT NULL,
  `image` varchar(256) NOT NULL,
  `heritage_name` varchar(50) NOT NULL,
  `location_id1` int(2) NOT NULL,
  `location_id2` int(2) DEFAULT NULL,
  `location_id3` int(2) DEFAULT NULL,
  `location_id4` int(2) DEFAULT NULL,
  `location_id5` int(2) DEFAULT NULL,
  `location_id6` int(2) DEFAULT NULL,
  `location_id7` int(2) DEFAULT NULL,
  `location_id8` int(2) DEFAULT NULL,
  `registration_year` int(4) NOT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `heritage_main_kataoka`
--

LOCK TABLES `heritage_main_kataoka` WRITE;
/*!40000 ALTER TABLE `heritage_main_kataoka` DISABLE KEYS */;
/*!40000 ALTER TABLE `heritage_main_kataoka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hometown_matsuda`
--

DROP TABLE IF EXISTS `hometown_matsuda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hometown_matsuda` (
  `hometown_id` int(11) DEFAULT NULL,
  `hometown` varchar(256) DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL,
  `create_flag` datetime DEFAULT NULL,
  `update_flag` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hometown_matsuda`
--

LOCK TABLES `hometown_matsuda` WRITE;
/*!40000 ALTER TABLE `hometown_matsuda` DISABLE KEYS */;
INSERT INTO `hometown_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'kC¹','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'ÂX§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'âè§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'{é§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'Hc§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'R`§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'ïé§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'ÈØ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'Qn§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'éÊ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'çt§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'s','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'_Þì§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'V§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'xR§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'Îì§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'ä§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(19,'R§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(20,'·ì§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(21,'ò§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(22,'Ãª§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(23,'¤m§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(24,'Od§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(25,' ê§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(26,'s{','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(27,'åã{','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(28,'ºÉ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(29,'ÞÇ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(30,'aÌR§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(31,'¹æ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(32,'ª§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(33,'ªR§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(34,'L§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(35,'Rû§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(36,'¿§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(37,'ì§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(38,'¤Q§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(39,'m§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(40,'ª§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(41,'²ê§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(42,'·è§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(43,'F{§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(44,'åª§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(45,'{è§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(46,'­§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(47,'«ê§','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
/*!40000 ALTER TABLE `hometown_matsuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kinds_ueno`
--

DROP TABLE IF EXISTS `kinds_ueno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kinds_ueno` (
  `id` int(11) NOT NULL,
  `kind` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kinds_ueno`
--

LOCK TABLES `kinds_ueno` WRITE;
/*!40000 ALTER TABLE `kinds_ueno` DISABLE KEYS */;
INSERT INTO `kinds_ueno` VALUES (0,NULL,'0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(1,'zGC','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(2,'\C','0','2020-05-22 00:00:00','2020-05-22 00:00:00');
/*!40000 ALTER TABLE `kinds_ueno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_kataoka`
--

DROP TABLE IF EXISTS `location_kataoka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_kataoka` (
  `id` int(2) NOT NULL,
  `location` varchar(20) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_kataoka`
--

LOCK TABLES `location_kataoka` WRITE;
/*!40000 ALTER TABLE `location_kataoka` DISABLE KEYS */;
INSERT INTO `location_kataoka` VALUES (0,'','0','2018-09-26 23:49:26','2018-09-17 06:00:00'),(1,'kC¹','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(2,'ÂX§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(3,'âè§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(4,'{é§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(5,'Hc§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(6,'R`§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(7,'§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(8,'ïé§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(9,'ÈØ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(10,'Qn§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(11,'éÊ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(12,'çt§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(13,'s','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(14,'_Þì§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(15,'V§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(16,'xR§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(17,'Îì§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(18,'ä§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(19,'R§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(20,'·ì§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(21,'ò§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(22,'Ãª§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(23,'¤m§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(24,'Od§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(25,' ê§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(26,'s{','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(27,'åã{','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(28,'ºÉ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(29,'ÞÇ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(30,'aÌR§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(31,'¹æ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(32,'ª§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(33,'ªR§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(34,'L§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(35,'Rû§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(36,'¿§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(37,'ì§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(38,'¤Q§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(39,'m§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(40,'ª§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(41,'²ê§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(42,'·è§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(43,'F{§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(44,'åª§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(45,'{è§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(46,'­§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(47,'«ê§','0','2018-09-17 06:00:00','2018-09-17 06:00:00');
/*!40000 ALTER TABLE `location_kataoka` ENABLE KEYS */;
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
-- Table structure for table `magazine_miyoshi`
--

DROP TABLE IF EXISTS `magazine_miyoshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magazine_miyoshi` (
  `id` int(11) NOT NULL,
  `magazine` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazine_miyoshi`
--

LOCK TABLES `magazine_miyoshi` WRITE;
/*!40000 ALTER TABLE `magazine_miyoshi` DISABLE KEYS */;
INSERT INTO `magazine_miyoshi` VALUES (0,NULL,'0','2020-06-02 10:35:17','2020-06-02 10:35:17'),(1,'T§­NWv','0','2020-06-02 10:35:17','2020-06-02 10:35:17'),(2,'WvSQ','0','2020-06-02 10:35:17','2020-06-02 10:35:17'),(3,'T§­N}KW','0','2020-06-02 10:35:17','2020-06-02 10:35:17'),(4,'Êû­N}KW','0','2020-06-02 10:35:17','2020-06-02 10:35:17'),(5,'T§­NTf[','0','2020-06-02 10:35:17','2020-06-02 10:35:17'),(6,'ÔÆäß','0','2020-06-02 10:35:17','2020-06-02 10:35:17'),(7,'LaLa','0','2020-06-02 10:35:17','2020-06-02 10:35:17');
/*!40000 ALTER TABLE `magazine_miyoshi` ENABLE KEYS */;
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
-- Table structure for table `maker_ohkubo`
--

DROP TABLE IF EXISTS `maker_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maker_ohkubo` (
  `id` int(11) NOT NULL,
  `maker` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maker_ohkubo`
--

LOCK TABLES `maker_ohkubo` WRITE;
/*!40000 ALTER TABLE `maker_ohkubo` DISABLE KEYS */;
INSERT INTO `maker_ohkubo` VALUES (0,NULL,'0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(1,'RJER[®ïÐ','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(2,'Tg[','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(3,'W[WA','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(4,'áóO~N','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(5,'É¡','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(6,'åË»ò','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(7,'ATqù¿','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(8,'OR','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(9,'bhu','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(10,'L','0','2020-05-20 00:00:00','2020-05-20 00:00:00');
/*!40000 ALTER TABLE `maker_ohkubo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maker_ueno`
--

DROP TABLE IF EXISTS `maker_ueno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maker_ueno` (
  `id` int(11) NOT NULL,
  `maker` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maker_ueno`
--

LOCK TABLES `maker_ueno` WRITE;
/*!40000 ALTER TABLE `maker_ueno` DISABLE KEYS */;
INSERT INTO `maker_ueno` VALUES (0,NULL,'0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(1,'MYPROTEIN','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(2,'X-PLOSION','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(3,'BODYWING','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(4,'540vWFNg','0','2020-05-22 00:00:00','2020-05-22 00:00:00');
/*!40000 ALTER TABLE `maker_ueno` ENABLE KEYS */;
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
INSERT INTO `movie_main` VALUES (1,'XpC_[}3',1,2,2007,155,'XpC_[}ÌfæÌÅÍêÔD«',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MENa¶ébAÎ¿Ú±Ê¢B',0,'2017-11-08 00:00:00','2020-03-23 09:45:36'),(3,'I',1,4,1994,110,'}`_ª©í¢¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'_[NiCgCWO',1,5,2012,165,'DCR~bNæ£ê',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'xCr[hCo[',1,NULL,2017,113,'±Òª§ì³êé»¤',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'gX',2,3,2013,101,'_j[E{CÄÂ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'tBX',2,3,2013,97,'XRbghÌÅ«Y',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'ØíÈéMcr[',2,2,2013,143,'Øºà£',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'ubWIuXpC',2,1,2015,144,'AJf~[jDÜóÜ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'_EB`ER[h',2,1,2006,174,'IhCEggDV¯½È ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'tHXgKv',3,1,1994,142,'¾í¸Æmê½¼¾ÌóÉ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'®SÈé`FbNCg',3,2,2014,116,'{r[tBbV[',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,' Ì lçÍ',3,2,2001,90,'á©èµfBJvI',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'~[u',3,5,2012,160,'ÌªÍAeRÅÍ èÜ¹ñ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'O[}C',3,1,1999,189,'wV[VNÌóÉxà¢¢Å·',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'ubNX',4,4,2011,108,'ºèÈz[æè|¢©à',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TV[r[ÒàÇ¤¼',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'L[',4,NULL,1976,98,'XeB[uELOÌì',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'Xvbg',4,3,2017,117,'V}ìið©Ä¨­Æg',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'~X^[KX',4,3,2019,129,'XvbgÌ±Ò',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'}CEC^[',5,5,2015,121,'wv_ð½«xà¨··ß',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'^[~i',5,1,2004,128,'ó`ÉZñÅÝ½¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'yls',5,3,2008,104,'»ãÌ¨Æ¬b',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'AXC_[h',5,5,2010,113,'fü·²¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'LbchbOX',5,2,2001,87,'¢Í©í¢¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'Â®È¢',NULL,3,2007,130,'ATÈÉÍ¨··ßµÜ¹ñ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'vChÆÎ©',NULL,NULL,2005,135,'REt@[XÌh}ÅàÇ«',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'OCeXgV[}',3,NULL,2017,105,'ÂlIÉEEhz¦',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'rbO',5,1,1988,130,'fGÈCÉÈêé',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'â½çØÈoDw',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
-- Table structure for table `protein_main_ueno`
--

DROP TABLE IF EXISTS `protein_main_ueno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `protein_main_ueno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flavor` varchar(256) NOT NULL,
  `kind_id` int(11) DEFAULT NULL,
  `maker_id` int(11) DEFAULT NULL,
  `review` int(11) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protein_main_ueno`
--

LOCK TABLES `protein_main_ueno` WRITE;
/*!40000 ALTER TABLE `protein_main_ueno` DISABLE KEYS */;
INSERT INTO `protein_main_ueno` VALUES (1,'~NeB[',1,1,5,'¨¢µ¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(2,'',1,1,3,'Ã­È­ÄÇ¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(3,'u[x[`[YP[L',1,1,3,'æ­í©çñ','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(4,'Çm¤',1,2,3,'¿åÁÆ­Ç¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(5,'t{[Y',1,2,4,'³ÁÏè','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(6,'t[cI',1,2,4,'Ü³É','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(7,'J',1,1,4,'ÃßÌâÂ','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(8,'Ù¤¶e',1,1,2,'cñÚùñÅéÝ½¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(9,'e',1,1,5,'¨¢µ¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(10,'`R~g',1,1,4,'ACXÅæ­ é Ì´¶','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(11,'`R[gIW',1,1,4,'¨ÙqÅæ­ é Ì´¶','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(12,'s[`eB[',1,1,4,'ùÝâ·¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(13,'Xgx[N[',2,1,1,'NZª­­Ü¸¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(14,'`R[gX[Y',2,1,2,'Xgx[æèÍùÝâ·¢ª¨¢µ­ÍÈ¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(15,'mt[o[',2,3,2,'Ü¸­ÍÈ¢ª¨¢µ­àÈ¢','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(16,'mt[o[',2,4,3,'Ü¸­ÍÈ¢ª¨¢µ­àÈ¢ARXpÇ','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(17,'I',1,2,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(18,'',1,2,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(19,'ubhIW',1,2,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(20,'LzCg`R',1,2,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(21,'`Roii',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(22,'_[N`R[g',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(23,'oj',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(24,'}Wp',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(25,'kC¹~N',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(26,'e',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(27,'R[q[L',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(28,'oj',2,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(29,'mt[o[',2,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00'),(30,'eB~X',1,1,3,'¢wü','0','2020-05-22 00:00:00','2020-05-22 00:00:00');
/*!40000 ALTER TABLE `protein_main_ueno` ENABLE KEYS */;
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
-- Table structure for table `sex_ito`
--

DROP TABLE IF EXISTS `sex_ito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sex_ito` (
  `id` int(11) DEFAULT NULL,
  `sex` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sex_ito`
--

LOCK TABLES `sex_ito` WRITE;
/*!40000 ALTER TABLE `sex_ito` DISABLE KEYS */;
INSERT INTO `sex_ito` VALUES (0,NULL,'0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'j«','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'«','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'j','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `sex_ito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_color_matsuda`
--

DROP TABLE IF EXISTS `team_color_matsuda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_color_matsuda` (
  `team_color_id` int(11) DEFAULT NULL,
  `team_color` varchar(256) DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL,
  `create_flag` datetime DEFAULT NULL,
  `update_flag` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_color_matsuda`
--

LOCK TABLES `team_color_matsuda` WRITE;
/*!40000 ALTER TABLE `team_color_matsuda` DISABLE KEYS */;
INSERT INTO `team_color_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'Ô','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'sN','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'IW','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'©F','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'©Î','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'F','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'Â','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'Î','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
/*!40000 ALTER TABLE `team_color_matsuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_main_matsuda`
--

DROP TABLE IF EXISTS `team_main_matsuda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_main_matsuda` (
  `id` int(11) DEFAULT NULL,
  `team_name` varchar(256) DEFAULT NULL,
  `hometown_id` int(11) DEFAULT NULL,
  `team_color_id` int(11) DEFAULT NULL,
  `starplayer` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL,
  `create_flag` datetime DEFAULT NULL,
  `update_flag` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_main_matsuda`
--

LOCK TABLES `team_main_matsuda` WRITE;
/*!40000 ALTER TABLE `team_main_matsuda` DISABLE KEYS */;
INSERT INTO `team_main_matsuda` VALUES (1,'Ttb`FL',34,1,'²XØãÄ','3obNÌv','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'C\',12,4,'ºqã','SÇ','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'FC',13,7,'ºJ¬','£gITChobN','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'YabY',11,1,'»TO','S[OÌdl','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'Koåã',27,7,'¡Ûm','pXR[X360x','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'Zb\åã',27,2,'`JjêN','~X^[[eBeB','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'xK^åä',4,3,'ÔèG½','xK^ÌØèD','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'¡lFC',14,6,'ºrã','WFhteB[','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'¼Ã®OpX',23,3,'nEI','TubgvC[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'BbZ_Ë',28,9,'AhX@CjGX^','THE SOCCER','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'ìèt^[',14,6,'Æ·º','ZIhteB[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'TK¹²',31,6,'´Gl','Q[CJ[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'Ãìx}[',14,5,'Rc¼P','ÔÁÄ«½VË','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'¡lFE}mX',14,7,'ìPl','n}ÌXs[hX^[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'åªgj[^',44,6,'âcqP','gj[^Ìç','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'kC¹RTh[Dy',1,1,'`ieBbv','^CÌbV','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'´GXpX',22,3,'§cIå',' Ì¯','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'­Ag[Y',8,1,'O}l','¢ãå^{`','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
/*!40000 ALTER TABLE `team_main_matsuda` ENABLE KEYS */;
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
-- Table structure for table `type_ohkubo`
--

DROP TABLE IF EXISTS `type_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_ohkubo` (
  `id` int(11) NOT NULL,
  `type` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_ohkubo`
--

LOCK TABLES `type_ohkubo` WRITE;
/*!40000 ALTER TABLE `type_ohkubo` DISABLE KEYS */;
INSERT INTO `type_ohkubo` VALUES (0,NULL,'0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'Y_ù¿','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'´Áù¿','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'R[q[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'ûù¿','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'Î','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'~lEH[^[','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
/*!40000 ALTER TABLE `type_ohkubo` ENABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-11 16:19:51
