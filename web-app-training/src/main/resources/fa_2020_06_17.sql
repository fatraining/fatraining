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
INSERT INTO `album_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'Perfume`Complete Best','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'GAME','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'‡™','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'JPN','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'Perfume Global Compilation','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'LOVE THE WORLD','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'LEVEL3','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'COSMIC EXPLORER','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'Future Pop','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Perfume The Best gP Cubedh','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
/*!40000 ALTER TABLE `album_anzai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_sato`
--

DROP TABLE IF EXISTS `animal_sato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal_sato` (
  `id` int(11) DEFAULT NULL,
  `animal` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_sato`
--

LOCK TABLES `animal_sato` WRITE;
/*!40000 ALTER TABLE `animal_sato` DISABLE KEYS */;
INSERT INTO `animal_sato` VALUES (0,NULL,'0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(1,'Œ¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(2,'”L','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(3,'ƒyƒ“ƒMƒ“','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(4,'ƒAƒqƒ‹','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(5,'‚¤‚³‚¬','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(6,'ƒJƒGƒ‹','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(7,'ŒF','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(8,'¬ŒF','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(9,'ƒTƒC','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(10,'­','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(11,'Û','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(12,'ƒ^ƒR','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(13,'’¹','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(14,'ƒnƒ€ƒXƒ^[','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(15,'—r','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(16,'ƒŠƒX','0','2020-05-28 00:00:00','2020-05-28 00:00:00');
/*!40000 ALTER TABLE `animal_sato` ENABLE KEYS */;
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
INSERT INTO `area_ito` VALUES (0,NULL,'0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(1,'“Œ‹“s','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(2,'é‹ÊŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(3,'ç—tŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(4,'_“ŞìŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(5,'•ºŒÉŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(6,'ˆ¤’mŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(7,'VŠƒŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(8,'‘åã•{','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(9,'“Ş—ÇŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(10,'•Ÿ‰ªŒ§','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(11,'‹“s•{','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(12,'–kŠC“¹','0','2020-03-24 00:00:00','2020-03-24 00:00:00');
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
INSERT INTO `artist` VALUES (1,'Zebrahead','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(2,'FLOW','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(3,'•Ä’ÃŒºt','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(4,'Anly','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(5,'fox capture plan','0','2018-05-23 01:27:00','2018-05-23 01:27:00');
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
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0ï¼šæœ‰åŠ¹ã€€1ï¼šç„¡åŠ¹',
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
INSERT INTO `attribute_kawamura` VALUES (0,NULL,'0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(1,'ƒGƒ“ƒyƒ‰[ƒyƒ“ƒMƒ“‘®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(2,'ƒAƒfƒŠ[ƒyƒ“ƒMƒ“‘®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(3,'ƒtƒ“ƒ{ƒ‹ƒgƒyƒ“ƒMƒ“‘®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(4,'ƒ}ƒJƒƒjƒyƒ“ƒMƒ“‘®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(5,'ƒLƒ“ƒƒyƒ“ƒMƒ“‘®','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(6,'ƒRƒKƒ^ƒyƒ“ƒMƒ“‘®','0','2019-12-03 15:19:00','2019-12-03 15:19:00');
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
INSERT INTO `band_main_ito` VALUES (1,'Fear,and loathing in LasVegas',1,5,2008,'‚È‚ñ‚¿‚á‚çƒ‰ƒXƒxƒKƒX‚ÅŠo‚¦‚ê‚ê‚ÎOK/šStep Of Terror','0',NULL,NULL),(2,'a crowd of rebellion',1,7,2007,'‹È’²A‰¹AºƒGƒ‚‚³‚ª‚¦‚®‚¢/šNever Say A Gain','0',NULL,NULL),(3,'crossfaith',1,8,2006,'ƒ‰ƒCƒu‚Å—Fl‚ªœÜ‚µ‚½/šBlue','0',NULL,NULL),(4,'Coldrain',1,6,2007,'ƒTƒEƒ“ƒh‚ª‚©‚Á‚±‚¢‚¢/šF.T.T.T','0',NULL,NULL),(6,'HEY-SMITH',1,8,2006,'ƒXƒJƒpƒ“ƒN‚ªÅ‚/šDrug Free Japan','0',NULL,NULL),(7,'SiM',1,4,2004,'ƒŒƒQƒG—v‘f‚ ‚è/šRiOT','0',NULL,NULL),(8,'ƒ}ƒLƒVƒ}ƒ€ƒUƒzƒ‹ƒ‚ƒ“',3,1,1998,'ƒ‰ƒCƒu’†‚İ‚ñ‚È•Î·’l’á‚­‚È‚é/šuFv','0',NULL,NULL),(9,'Ailiph@Doepa',1,1,2010,'ƒCƒ“ƒtƒ‹ƒGƒ“ƒU‚Ì‚Æ‚«‚ÉŒ©‚é‚æ‚¤‚ÈMV‘½‚¢/šMARS','0',NULL,NULL),(10,'04Limted Sazabys',1,6,2008,'‹È‚Ì‘u‰õŠ´/šKnife','0',NULL,NULL),(11,'ƒtƒŒƒfƒŠƒbƒN',1,5,2009,'‰Ìº‚àƒrƒWƒ…‚à‹­‚¢‘oq/šTOGENKYO','0',NULL,NULL),(12,'ƒLƒ…ƒEƒ\ƒlƒRƒJƒ~',1,5,2009,'ƒLƒƒƒbƒ`[‚Å–Ê”’‚¢/šƒƒ“ƒwƒ‰‚¿‚á‚ñ','0',NULL,NULL),(13,'ELLEGARDEN',1,3,1998,'•œŠˆŠ½Šì/šƒTƒ“ƒ^ƒNƒ[ƒX','0',NULL,NULL),(14,'—‰¤–I',1,5,2009,'ƒƒ“ƒo[1l1l‚ÌƒrƒWƒ…‹­‚¢/š‹à¯','0',NULL,NULL),(15,'‘Åñ––å“¯D‰ï',3,NULL,2004,'Ba‚ªŠÒ—ï‚ÉŒ©‚¦‚È‚¢A”Ñƒeƒƒoƒ“ƒh/š“‡‘DNA','0',NULL,NULL),(16,'™z‚Æ‚µ‚Ä‰J',3,2,2002,'ƒcƒCƒ“ƒ{~ƒhƒ‰ƒ€‚ªÅ‚/šnakano kill you','0',NULL,NULL),(17,'THE ORAL CIGARETTES',1,9,2010,'ƒ_[ƒN‚È•µˆÍ‹C‚©‚à‚µ‚Ä‚é/šDIP-BAP','0',NULL,NULL),(18,'FACT',1,NULL,1999,'‚¨–Êƒoƒ“ƒh/šerror','0',NULL,NULL),(19,'MAN WITH A MISSIOM',1,1,2010,'˜Tƒoƒ“ƒh/šNEVER FXXKIN\' MIND THE RULES','0',NULL,NULL),(20,'The BONEZ',1,NULL,2012,'JESSE‚©‚Á‚±‚¢‚¢/šHello Monster','0',NULL,NULL),(21,'ƒAƒ‹ƒJƒ‰',1,5,2002,'Vo‚ªñ‚Éƒ^ƒ“ƒoƒŠƒ“‘•”õ‚µ‚Ä‚¢‚éig‚í‚È‚¢j/šƒ`ƒNƒVƒ‡[','0',NULL,NULL),(22,'ƒ|ƒ‹ƒJƒhƒbƒgƒXƒeƒBƒ“ƒOƒŒƒC',2,10,2015,'—Í‹­‚¢—«Vo/šƒGƒŒƒNƒgƒŠƒbƒNEƒpƒuƒŠƒbƒN','0',NULL,NULL),(23,'–‚–@­—‚É‚È‚è‘à',2,NULL,2014,'Vo‚ª‚µ‚á‚×‚ê‚È‚­‚È‚éô‚¢‚ğ‚©‚¯‚ç‚ê‚Ä‚¢‚Ä‰Âˆ¤‚¢/šƒqƒƒTƒ}ƒXƒsƒŠƒbƒc','0',NULL,NULL),(24,'ƒNƒŠ[ƒvƒnƒCƒv',1,1,2001,'º‚ª•È‚É‚È‚é/š‹S','0',NULL,NULL),(25,'ƒ}ƒJƒƒj‚¦‚ñ‚Ò‚Â',1,4,2012,'’©•û‚É’®‚¢‚½‚çƒGƒ‚‚©‚Á‚½/šƒƒ“ƒhƒŠƒ“ƒN•Ê','0',NULL,NULL),(26,'ƒTƒ“ƒ{ƒ}ƒXƒ^[',1,1,2000,'ƒ‰ƒCƒu‚Åˆê”Ô‹ƒ‚¯‚éƒoƒ“ƒh/šƒ‰ƒuƒ\ƒ“ƒO','0',NULL,NULL),(27,'‚»‚±‚É–Â‚é',3,8,2011,'ƒcƒCƒ“‚Ìd‚È‚è‡‚¢‚ª—Ç‚¢/š¶‚Å—x‚é','0',NULL,NULL),(28,'ƒqƒXƒeƒŠƒbƒNƒpƒjƒbƒN',1,6,2012,'d‚­‚ÄƒLƒƒƒbƒ`[‚ÈƒTƒEƒ“ƒh‚Å—Ç‚¢/š”Êá','0',NULL,NULL),(29,'ROTTENGRAFFTY',1,11,1999,'Š|‚¯‡‚¢‚ª‚©‚Á‚±—Ç‚¢/š‹àFƒOƒ‰ƒtƒeƒB[','0',NULL,NULL),(30,'ƒTƒJƒiƒNƒVƒ‡ƒ“',1,12,2005,'V•ó“‡‚Ì“®‚«‚ª“ª‚©‚ç—£‚ê‚È‚¢/š‘½•ªA•—','0',NULL,NULL),(31,'–é‚Ì–{‹Cƒ_ƒ“ƒX',1,NULL,2008,'’…‚Ä‚éƒVƒƒƒc‚ª‚¢‚Â‚à‚¨‚µ‚á‚ê/šwith out you','0',NULL,NULL),(32,'Survive Said The Prophet',1,1,2011,'ƒoƒ“ƒh–¼“Ç‚İ‚Ã‚ç‚¢/šfound & lost','0',NULL,NULL),(33,'—[ˆÅ‚É—U‚¢‚µ½•‚Ì“Vg’B',1,4,2015,'ƒuƒŒƒCƒNƒ_ƒEƒ“‚ª‚¨‚à‚µ‚ë‚¢youtuberƒoƒ“ƒh/šŒN‚É“Í‚©‚È‚¢º‚ÍƒCƒ^ƒŠƒA‚É‚à“Í‚©‚È‚¢AŒÌ‚Éƒ~ƒ‰ƒm•—','0',NULL,NULL),(34,'Pay money To my Pain',1,1,2005,'‚à‚Á‚Æ‘‚­’m‚Á‚Ä‚¨‚¯‚Î‚æ‚©‚Á‚½‚Æv‚¤ƒoƒ“ƒh/šSweetest vengeance','0',NULL,NULL),(35,'Œß‘OlA’©Ä‚¯‚ÉƒcƒL',1,7,2011,'ƒƒ“ƒo[‚ª‘å‚«‚­•Ï‚í‚Á‚Ä‚à‹È‚ª‚©‚Á‚±‚¢‚¢/šˆö™ñ—…','0',NULL,NULL);
/*!40000 ALTER TABLE `band_main_ito` ENABLE KEYS */;
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
INSERT INTO `genre` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'ƒAƒNƒVƒ‡ƒ“',0,'2017/11/08','2017/11/08'),(2,'ƒTƒXƒyƒ“ƒX',0,'2017/11/08','2017/11/08'),(3,'ƒqƒ…[ƒ}ƒ“',0,'2017/11/08','2017/11/08'),(4,'ƒzƒ‰[',0,'2017/11/08','2017/11/08'),(5,'ƒRƒƒfƒB',0,'2017/11/08','2017/11/08');
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
INSERT INTO `genre_ishikawa` VALUES (0,NULL,'0','2020-03-24 11:40:38','2020-03-24 11:40:41'),(1,'åH','0','2020-03-24 11:40:58','2020-03-24 11:41:01'),(2,'åØ','0','2020-03-24 11:41:18','2020-03-24 11:41:21'),(3,'•›Ø','0','2020-03-24 11:41:36','2020-03-24 11:41:39');
/*!40000 ALTER TABLE `genre_ishikawa` ENABLE KEYS */;
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
INSERT INTO `genre_kataoka` VALUES (0,' ','0','2020-03-24 02:37:07','2018-09-17 06:00:00'),(1,'•¶‰»ˆâY','0','2020-03-24 02:39:42','2018-09-17 06:00:00'),(2,'©‘RˆâY','0','2020-03-24 02:39:08','2020-03-23 17:00:00');
/*!40000 ALTER TABLE `genre_kataoka` ENABLE KEYS */;
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
INSERT INTO `heritage_main_kataoka` VALUES (1,1,'/heritageKataoka/horyuji.jpeg\r\n','–@—²›’nˆæ‚Ì•§‹³Œš‘¢•¨',29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,NULL,'0','2018-09-30 21:01:17','2018-09-17 06:00:00'),(2,1,'/heritageKataoka/himejijyo.jpeg\r\n','•P˜Hé',28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,NULL,'0','2018-09-30 21:01:35','2018-09-17 06:00:00'),(3,1,'/heritageKataoka/kyoto.jpeg\r\n','ŒÃ“s‹“s‚Ì•¶‰»ài‹“ssA‰F¡sA‘å’Ãsj',26,25,NULL,NULL,NULL,NULL,NULL,NULL,1994,NULL,'0','2018-09-30 21:01:52','2018-09-17 06:00:00'),(4,1,'/heritageKataoka/shirakawago.jpeg\r\n','”’ì‹½EŒÜ‰ÓR‚Ì‡¶‘¢‚èW—',21,16,NULL,NULL,NULL,NULL,NULL,NULL,1995,NULL,'0','2018-09-30 21:02:06','2018-09-17 06:00:00'),(5,1,'/heritageKataoka/genbakudomu.jpeg\r\n','Œ´”šƒh[ƒ€',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1996,'•‰‚Ì¢ŠEˆâY','0','2018-09-30 21:02:15','2018-09-17 06:00:00'),(6,1,'/heritageKataoka/itsukushima.jpeg\r\n','Œµ“‡_Ğ',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1996,NULL,'0','2018-09-30 21:02:20','2018-09-17 06:00:00'),(7,1,'/heritageKataoka/nara.jpeg\r\n','ŒÃ“s“Ş—Ç‚Ì•¶‰»à',29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1998,NULL,'0','2018-09-30 21:02:25','2018-09-17 06:00:00'),(8,1,'/heritageKataoka/nikkoTemple.jpeg\r\n','“úŒõ‚ÌĞ›',9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1999,NULL,'0','2018-09-30 21:02:30','2018-09-17 06:00:00'),(9,1,'/heritageKataoka/ryukyuKingdum.jpeg\r\n','—®‹…‰¤‘‚ÌƒOƒXƒN‹y‚ÑŠÖ˜AˆâYŒQ',47,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2000,NULL,'0','2018-09-30 21:02:41','2018-09-17 06:00:00'),(10,1,'/heritageKataoka/mtKi.jpeg\r\n','‹IˆÉR’n‚Ì—ìê‚ÆQŒw“¹',30,29,24,NULL,NULL,NULL,NULL,NULL,2004,'•¶‰»“IŒiŠÏA2016”N‚ÉŒy”÷‚È•ÏX','0','2018-09-30 21:02:50','2018-09-17 06:00:00'),(11,1,'/heritageKataoka/iwamiginzan.jpeg\r\n','ÎŒ©‹âRˆâÕ‚Æ‚»‚Ì•¶‰»“IŒiŠÏ',32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2007,'•¶‰»“IŒiŠÏAY‹ÆˆâYA2010”N‚ÌŒy”÷‚È•ÏX','0','2018-09-30 21:02:59','2018-09-17 06:00:00'),(12,1,'/heritageKataoka/hiraizumi.jpeg\r\n','•½ò\•§‘“yiò“yj‚ğ•\‚·Œš’zE’ë‰€‹y‚ÑlŒÃŠw“IˆâÕŒQ\',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2011,NULL,'0','2018-09-30 21:03:15','2018-09-17 06:00:00'),(13,1,'/heritageKataoka/mtFuji.jpeg\r\n','•xmR\M‹Â‚Ì‘ÎÛ‚ÆŒ|p‚ÌŒ¹ò',22,19,NULL,NULL,NULL,NULL,NULL,NULL,2013,NULL,'0','2018-09-30 21:03:10','2018-09-17 06:00:00'),(14,1,'/heritageKataoka/tomiokaseisijyo.jpeg\r\n','•x‰ª»…ê‚ÆŒ¦Y‹ÆˆâYŒQ',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2014,'Y‹ÆˆâYA‹ß‘ã‰»ˆâY','0','2018-09-30 21:03:20','2018-09-17 06:00:00'),(15,1,'/heritageKataoka/meijiRevol.jpg\r\n\r\n','–¾¡“ú–{‚ÌY‹ÆŠv–½ˆâY »“SE»|A‘¢‘DAÎ’YY‹Æ',35,40,41,42,43,46,3,22,2015,'Y‹ÆˆâYA‹ß‘ã‰»ˆâYA‰Ò“­ˆâY','0','2018-09-30 21:09:12','2018-09-17 06:00:00'),(16,1,'/heritageKataoka/luColuvu.jpeg\r\n','ƒ‹EƒRƒ‹ƒrƒ…ƒWƒG‚ÌŒš’zì•i-‹ß‘ãŒš’z‰^“®‚Ö‚ÌŒ°’˜‚ÈvŒ£-',13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2016,'Œ»‘ãŒš’zA‘‹«‚ğ‰z‚¦‚é¢ŠEˆâY','0','2018-09-30 21:03:30','2018-09-17 06:00:00'),(17,1,'/heritageKataoka/okinoshima.jpeg\r\n','u_h‚é“‡v@‘œE‰«ƒm“‡‚ÆŠÖ˜AˆâYŒQ',40,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2017,NULL,'0','2018-09-30 21:03:34','2018-09-17 06:00:00'),(18,1,'/heritageKataoka/nagasaki.jpeg\r\n','’·è‚Æ“V‘’n•û‚Ìö•šƒLƒŠƒVƒ^ƒ“ŠÖ˜AˆâY',42,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2018,NULL,'0','2018-09-30 21:03:39','2018-09-17 06:00:00'),(19,2,'/heritageKataoka/yakushima.jpeg\r\n','‰®‹v“‡',46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,'‰®‹v“‡‘—§Œö‰€A‰®‹v“‡Œ´¶©‘RŠÂ‹«•Û‘S’nˆæ','0','2018-09-30 21:03:46','2018-09-17 06:00:00'),(20,2,'/heritageKataoka/mtSirakami.jpeg\r\n','”’_R’n',2,5,NULL,NULL,NULL,NULL,NULL,NULL,1993,'”’_R’n©‘RŠÂ‹«•Û‘S’nˆæA','0','2018-09-30 21:03:52','2018-09-17 06:00:00'),(21,2,'/heritageKataoka/siretoko.jpeg\r\n','’m°',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2005,'’m°‘—§Œö‰€A‰“‰¹•ÊŠxŒ´¶©‘RŠÂ‹«•Û‘S’nˆæ','0','2018-09-30 21:03:57','2018-09-17 06:00:00'),(22,2,'/heritageKataoka/ogasawara.jpg\r\n\r\n','¬Š}Œ´”“‡',13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2011,'¬Š}Œ´‘—§Œö‰€A“ì—°‰©“‡Œ´¶©‘RŠÂ‹«•Û‘S’nˆæ','0','2018-09-30 21:08:48','2018-09-17 06:00:00');
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
INSERT INTO `hometown_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'–kŠC“¹','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'ÂXŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'ŠâèŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'‹{éŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'H“cŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'RŒ`Œ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'•Ÿ“‡Œ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'ˆïéŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'“È–ØŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'ŒQ”nŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'é‹ÊŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'ç—tŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'“Œ‹“s','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'_“ŞìŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'VŠƒŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'•xRŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'ÎìŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'•ŸˆäŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(19,'R—œŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(20,'’·–ìŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(21,'Šò•ŒŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(22,'Ã‰ªŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(23,'ˆ¤’mŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(24,'OdŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(25,' ‰êŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(26,'‹“s•{','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(27,'‘åã•{','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(28,'•ºŒÉŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(29,'“Ş—ÇŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(30,'˜a‰ÌRŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(31,'’¹æŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(32,'“‡ªŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(33,'‰ªRŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(34,'L“‡Œ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(35,'RŒûŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(36,'“¿“‡Œ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(37,'ìŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(38,'ˆ¤•QŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(39,'‚’mŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(40,'•Ÿ‰ªŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(41,'²‰êŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(42,'’·èŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(43,'ŒF–{Œ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(44,'‘å•ªŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(45,'‹{èŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(46,'­™“‡Œ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(47,'‰«“êŒ§','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
/*!40000 ALTER TABLE `hometown_matsuda` ENABLE KEYS */;
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
INSERT INTO `location_kataoka` VALUES (0,'','0','2018-09-26 23:49:26','2018-09-17 06:00:00'),(1,'–kŠC“¹','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(2,'ÂXŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(3,'ŠâèŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(4,'‹{éŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(5,'H“cŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(6,'RŒ`Œ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(7,'•Ÿ“‡Œ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(8,'ˆïéŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(9,'“È–ØŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(10,'ŒQ”nŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(11,'é‹ÊŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(12,'ç—tŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(13,'“Œ‹“s','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(14,'_“ŞìŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(15,'VŠƒŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(16,'•xRŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(17,'ÎìŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(18,'•ŸˆäŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(19,'R—œŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(20,'’·–ìŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(21,'Šò•ŒŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(22,'Ã‰ªŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(23,'ˆ¤’mŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(24,'OdŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(25,' ‰êŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(26,'‹“s•{','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(27,'‘åã•{','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(28,'•ºŒÉŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(29,'“Ş—ÇŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(30,'˜a‰ÌRŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(31,'’¹æŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(32,'“‡ªŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(33,'‰ªRŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(34,'L“‡Œ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(35,'RŒûŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(36,'“¿“‡Œ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(37,'ìŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(38,'ˆ¤•QŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(39,'‚’mŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(40,'•Ÿ‰ªŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(41,'²‰êŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(42,'’·èŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(43,'ŒF–{Œ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(44,'‘å•ªŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(45,'‹{èŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(46,'­™“‡Œ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(47,'‰«“êŒ§','0','2018-09-17 06:00:00','2018-09-17 06:00:00');
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
INSERT INTO `location_takehara` VALUES (0,'','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(1,'é“Œ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'é¼','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'é“ì','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'é–k','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'•ª—Ş–³‚µ','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
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
INSERT INTO `maker_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'ANCHORiƒAƒ“ƒJ[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'ARGON18(ƒAƒ‹ƒSƒ“18j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'BianchiiƒrƒAƒ“ƒLj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'BH(ƒr[ƒGƒCƒ`)','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'BMC(ƒr[ƒGƒ€ƒV[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'BOMAiƒ{[ƒ}j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'CANYONiƒLƒƒƒjƒIƒ“j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'cerveloiƒT[ƒ”ƒFƒj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'CIPOLLINIiƒ`ƒbƒ|ƒŠ[ƒjj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'COLNAGOiƒRƒ‹ƒiƒSj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'CUBE BIKESiƒLƒ…[ƒuƒoƒCƒNƒXj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'DIAMOND BIKESiƒ_ƒCƒAƒ‚ƒ“ƒhƒoƒCƒNƒXj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'EDDYMERCKXiƒGƒfƒBƒƒ‹ƒNƒXj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'FACTORiƒtƒ@ƒNƒ^[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'FELTiƒtƒFƒ‹ƒgj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'FUJIiƒtƒWj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'GIANTiƒWƒƒƒCƒAƒ“ƒgj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'KhodaaBloomiƒR[ƒ_[ƒuƒ‹[ƒ€j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'KUOTAiƒNƒI[ƒ^j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'MERIDAiƒƒŠƒ_j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'PINARELLOiƒsƒiƒŒƒj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'RIDLEYiƒŠƒhƒŒ[j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'SCOTTiƒXƒRƒbƒgj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'SPECIALIZEDiƒXƒyƒVƒƒƒ‰ƒCƒYƒhj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'TREKiƒgƒŒƒbƒNj','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'WilieriƒEƒBƒŠƒG[ƒ‹j','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
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
INSERT INTO `movie_actor` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'ƒgƒ€Eƒnƒ“ƒNƒX',0,'2017/11/08','2017/11/08'),(2,'ƒgƒr[Eƒ}ƒOƒƒCƒA',0,'2017/11/08','2017/11/08'),(3,'ƒWƒF[ƒ€ƒYEƒ}ƒJƒ”ƒHƒC',0,'2017/11/08','2017/11/08'),(4,'ƒiƒ^ƒŠ[Eƒ|[ƒgƒ}ƒ“',0,'2017/11/08','2017/11/08'),(5,'ƒAƒ“EƒnƒTƒEƒFƒC',0,'2017/11/08','2017/11/08');
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
INSERT INTO `movie_main` VALUES (1,'ƒXƒpƒCƒ_[ƒ}ƒ“3',1,2,2007,155,'ƒXƒpƒCƒ_[ƒ}ƒ“‚Ì‰f‰æ‚Ì’†‚Å‚Íˆê”ÔD‚«',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN’a¶”é˜bA‚Î‚¿‚Ú‚±–Ê”’‚¢B',0,'2017-11-08 00:00:00','2020-03-23 09:45:36'),(3,'ƒŒƒIƒ“',1,4,1994,110,'ƒ}ƒ`ƒ‹ƒ_‚ª‚©‚í‚¢‚¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'ƒ_[ƒNƒiƒCƒgƒ‰ƒCƒWƒ“ƒO',1,5,2012,165,'DCƒRƒ~ƒbƒNŠæ’£‚ê',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'ƒxƒCƒr[ƒhƒ‰ƒCƒo[',1,NULL,2017,113,'‘±•Ò‚ª§ì‚³‚ê‚é‚»‚¤',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'ƒgƒ‰ƒ“ƒX',2,3,2013,101,'ƒ_ƒj[Eƒ{ƒCƒ‹ŠÄ“Â',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'ƒtƒBƒ‹ƒX',2,3,2013,97,'ƒXƒRƒbƒgƒ‰ƒ“ƒh‚ÌÅˆ«ŒY–',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'‰Ø—í‚È‚éƒMƒƒƒcƒr[',2,2,2013,143,'‹‰Øˆºà£',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'ƒuƒŠƒbƒWƒIƒuƒXƒpƒC',2,1,2015,144,'ƒAƒJƒfƒ~[•‰‰’j—DÜóÜ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'ƒ_Eƒ”ƒBƒ“ƒ`EƒR[ƒh',2,1,2006,174,'ƒIƒhƒŒƒCEƒgƒgƒD˜V‚¯‚½‚È‚ ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'ƒtƒHƒŒƒXƒgƒKƒ“ƒv',3,1,1994,142,'Œ¾‚í‚¸‚Æ’m‚ê‚½–¼Œ¾‚Ì•óŒÉ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'Š®‘S‚È‚éƒ`ƒFƒbƒNƒƒCƒg',3,2,2014,116,'ƒ{ƒr[ƒtƒBƒbƒVƒƒ[',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'‚ ‚Ì –l‚ç‚Í',3,2,2001,90,'á‚©‚è‚µƒfƒBƒJƒvƒŠƒI',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'ƒŒƒ~ƒ[ƒ‰ƒuƒ‹',3,5,2012,160,'‰Ì•”•ª‚ÍƒAƒeƒŒƒR‚Å‚Í‚ ‚è‚Ü‚¹‚ñ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'ƒOƒŠ[ƒ“ƒ}ƒCƒ‹',3,1,1999,189,'wƒVƒ‡[ƒVƒƒƒ“ƒN‚Ì‹ó‚Éx‚à‚¢‚¢‚Å‚·',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'ƒuƒ‰ƒbƒNƒXƒƒ“',4,4,2011,108,'‰ºè‚Èƒzƒ‰[‚æ‚è•|‚¢‚©‚à',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TVƒ€[ƒr[•Ò‚à‚Ç‚¤‚¼',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'ƒLƒƒƒŠ[',4,NULL,1976,98,'ƒXƒeƒB[ƒuƒ“EƒLƒ“ƒO‚Ìˆ—ì',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'ƒXƒvƒŠƒbƒg',4,3,2017,117,'ƒVƒƒƒ}ƒ‰ƒ“ì•i‚ğŒ©‚Ä‚¨‚­‚Æ‹g',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'ƒ~ƒXƒ^[ƒKƒ‰ƒX',4,3,2019,129,'ƒXƒvƒŠƒbƒg‚Ì‘±•Ò',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'ƒ}ƒCEƒCƒ“ƒ^[ƒ“',5,5,2015,121,'wƒvƒ‰ƒ_‚ğ’…‚½ˆ«–‚x‚à‚¨‚·‚·‚ß',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'ƒ^[ƒ~ƒiƒ‹',5,1,2004,128,'‹ó`‚ÉZ‚ñ‚Å‚İ‚½‚¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'ƒyƒlƒƒs',5,3,2008,104,'Œ»‘ã‚Ì‚¨‚Æ‚¬˜b',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'ƒAƒŠƒXƒCƒ“ƒƒ“ƒ_[ƒ‰ƒ“ƒh',5,5,2010,113,'‰f‘œ”ü‚·‚²‚¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'ƒLƒƒƒbƒc•ƒhƒbƒOƒX',5,2,2001,87,'Œ¢‚Í‚©‚í‚¢‚¢',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'‚Â‚®‚È‚¢',NULL,3,2007,130,'‰AŸT‚È‚É‚Í‚¨‚·‚·‚ß‚µ‚Ü‚¹‚ñ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'ƒvƒ‰ƒCƒh‚Æ•ÎŒ©',NULL,NULL,2005,135,'ƒRƒŠƒ“Eƒtƒ@[ƒX‚Ìƒhƒ‰ƒ}”Å‚à—Ç‚«',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'ƒOƒŒƒCƒeƒXƒgƒVƒ‡[ƒ}ƒ“',3,NULL,2017,105,'ŒÂl“I‚Éƒ‰Eƒ‰Eƒ‰ƒ“ƒh‰z‚¦',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'ƒrƒbƒO',5,1,1988,130,'‘f“G‚È‹C‚É‚È‚ê‚é',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'‚â‚½‚ç‹‰Ø‚È”o—Dw',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
INSERT INTO `music` VALUES (4,'S‘¾?','”C??',5,'”N‘ã”ä?‹v?“Iˆêñ‰ÌC“–”Nœk—¬sC?İˆË‘R—Lœk‘½lŠì?B',3,'https://www.youtube.com/embed/ZSWeurc1yMw','2018-03-19 15:12:14','2018-03-19 15:12:14',5),(9,'•Y—m?ŠC—ˆŠÅ?','ˆ¡ˆ¡',5,'',3,'https://www.youtube.com/embed/hNQohQBFnwI','2018-03-19 16:05:12','2018-03-19 16:05:12',2),(10,'á‚Ì‰Ø','’†“‡”ü‰Ã',5,'',6,'https://www.youtube.com/embed/mF5Qq2YheTg','2018-03-19 17:18:19','2019-03-28 15:26:31',2),(11,'MY ALL','à_è?',5,'',5,'https://www.youtube.com/embed/PKptgq8jTYw','2018-03-19 17:27:07','2018-03-19 17:27:07',1),(12,'Time after time `‰Ô•‘‚¤ŠX‚Å`','?–Ø–ƒˆß',5,'',4,'https://www.youtube.com/embed/Ep_W5rYXyi0','2018-03-19 17:28:57','2018-03-19 17:28:57',1),(13,'–²“Iêy“H','¼—²q',5,'',6,'https://www.youtube.com/embed/Vn6xGeMY9w8','2018-03-19 17:31:46','2018-03-19 17:31:46',1),(14,'big big world','Emilia',5,'',5,'https://www.youtube.com/embed/wpkS2DU_qMs','2018-03-19 17:33:04','2018-03-19 17:33:04',0);
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
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0ï¼šæœ‰åŠ¹ã€€1ï¼šç„¡åŠ¹',
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
INSERT INTO `penguin_main_kawamura` VALUES (1,'ƒRƒEƒeƒCƒyƒ“ƒMƒ“',1,'“ì‹É‘å—¤ü•Ó‚Ì’è’…•Xã‚É¶‘§@‘Ì‚Ì‘å‚«‚³No.1i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒRƒEƒeƒC_penguin.jpg','0','2019-12-03 15:08:00','2020-03-23 10:08:48'),(2,'ƒLƒ“ƒOƒyƒ“ƒMƒ“',1,'ˆŸ“ì‹É‚Ì“‡X‚É¶‘§i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒLƒ“ƒO_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(3,'ƒAƒfƒŠ[ƒyƒ“ƒMƒ“',2,'“ì‹É‘å—¤‚Ì‰ˆŠİˆæAü•Ó‚Ì“‡X‚É¶‘§@ICƒJ[ƒhSuica‚Ìƒ‚ƒfƒ‹‚É‚È‚Á‚½ƒyƒ“ƒMƒ“i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒAƒfƒŠ[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(4,'ƒWƒFƒ“ƒc[ƒyƒ“ƒMƒ“',2,'“ì‹É‘å—¤‚Ì•X‚Ì’£‚Á‚Ä‚¢‚È‚¢’nˆæAˆŸ“ì‹É‚Ì“‡X‚É¶‘§@—Bˆê‘«‚ÌF‚ªƒIƒŒƒ“ƒW‚Ìƒyƒ“ƒMƒ“@‰j‚¬‚Ì‘¬‚³No.1i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒWƒFƒ“ƒc[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(5,'ƒqƒQƒyƒ“ƒMƒ“',2,'“ì‹É”¼“‡‚É¶‘§@i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒqƒQ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(6,'ƒKƒ‰ƒpƒSƒXƒyƒ“ƒMƒ“',3,'ƒKƒ‰ƒpƒSƒX”“‡‚É¶‘§@ƒtƒ“ƒ{ƒ‹ƒgƒyƒ“ƒMƒ“‘®‚Ì’†‚Å‚­‚¿‚Î‚µ‚Ì×‚³No.1i“ú–{‚Å‚ÍŒ©‚ê‚È‚¢j','/penguinKawamura/ƒKƒ‰ƒpƒSƒX_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(7,'ƒP[ƒvƒyƒ“ƒMƒ“',3,'“ìƒAƒtƒŠƒJ‹¤˜a‘‚Ì‰ˆŠİ•”‚É¶‘§@ƒAƒtƒŠƒJ‚É¶‘§‚·‚éƒyƒ“ƒMƒ“‚ÍƒP[ƒvƒyƒ“ƒMƒ“‚¾‚¯i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒP[ƒv_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(8,'ƒtƒ“ƒ{ƒ‹ƒgƒyƒ“ƒMƒ“',3,'ƒtƒ“ƒ{ƒ‹ƒgŠC—¬‚ª—¬‚ê‚é“ìƒAƒƒŠƒJ¼•”‚É¶‘§@Š¦‚¢‚Ì‚ª‹êè@“ú–{‚Å”ˆç”No.1‚Ìƒyƒ“ƒMƒ“i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒtƒ“ƒ{ƒ‹ƒg_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(9,'ƒ}ƒ[ƒ‰ƒ“ƒyƒ“ƒMƒ“',3,'ƒ`ƒŠEƒAƒ‹ƒ[ƒ“ƒ`ƒ“EƒtƒH[ƒNƒ‰ƒ“ƒh”“‡‚É¶‘§@•v•w‚Ì’‡‚Ì—Ç‚³No.1i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒ}ƒ[ƒ‰ƒ“_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(10,'ƒtƒBƒˆƒ‹ƒhƒ‰ƒ“ƒhƒyƒ“ƒMƒ“',4,'ƒtƒBƒˆƒ‹ƒh’nˆæEƒI[ƒNƒ‰ƒ“ƒh”“‡EƒXƒ`ƒ…ƒ[ƒg“‡‚È‚Ç‚É¶‘§i“ú–{‚Å‚ÍŒ©‚ê‚È‚¢j','/penguinKawamura/ƒtƒBƒˆƒ‹ƒhƒ‰ƒ“ƒh_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(11,'ƒVƒ…ƒŒ[ƒ^[ƒyƒ“ƒMƒ“',4,'ƒoƒEƒ“ƒeƒB”“‡EƒI[ƒNƒ‰ƒ“ƒh”“‡Eƒ}ƒbƒRƒŠ[“‡‚È‚Ç‚É¶‘§i“ú–{‚Å‚ÍŒ©‚ê‚È‚¢j','/penguinKawamura/ƒVƒ…ƒŒ[ƒ^[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(12,'ƒXƒlƒA[ƒYƒyƒ“ƒMƒ“',4,'ƒXƒlƒA[ƒY“‡(ƒjƒ…[ƒW[ƒ‰ƒ“ƒh‚Ì“ì‚ÉˆÊ’u‚·‚é“‡)‚É¶‘§i“ú–{‚Å‚ÍŒ©‚ê‚È‚¢j','/penguinKawamura/ƒXƒlƒA[ƒY_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(13,'ƒ}ƒJƒƒjƒyƒ“ƒMƒ“',4,'ƒ`ƒŠ‚Ì“ì•”E‘å¼—m‚©‚çƒCƒ“ƒh—m‚É‚©‚¯‚Ä¶‘§@ƒyƒ“ƒMƒ“‚Ì’†‚ÅŒÂ‘Ì”No.1i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒ}ƒJƒƒj_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(14,'ƒƒCƒ„ƒ‹ƒyƒ“ƒMƒ“',4,'ƒI[ƒXƒgƒ‰ƒŠƒAEƒjƒ…[ƒW[ƒ‰ƒ“ƒhEƒ}ƒbƒRƒŠ[“‡‚É¶‘§i“ú–{‚Å‚ÍŒ©‚ê‚È‚¢j','/penguinKawamura/ƒƒCƒ„ƒ‹_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(15,'ƒCƒƒgƒrƒyƒ“ƒMƒ“',4,'ƒTƒEƒXƒVƒFƒgƒ‰ƒ“ƒh”“‡EƒLƒƒƒ“ƒxƒ‹“‡‚È‚Ç‚É¶‘§i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒCƒƒgƒr_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(16,'ƒLƒKƒVƒ‰ƒyƒ“ƒMƒ“',5,'ƒjƒ…[ƒW[ƒ‰ƒ“ƒh‚É¶‘§@ƒyƒ“ƒMƒ“—Ş‚Ì’†‚Å”‚Ì­‚È‚³No1i“ú–{‚Å‚ÍŒ©‚ê‚È‚¢j','/penguinKawamura/ƒLƒKƒVƒ‰_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(17,'ƒRƒKƒ^ƒyƒ“ƒMƒ“',6,'ƒjƒ…[ƒW[ƒ‰ƒ“ƒhEƒI[ƒXƒgƒ‰ƒŠƒA‚Ì“ìŠİ‚É¶‘§@‘Ì‚Ì¬‚³‚³No.1i“ú–{‚Ì…‘°ŠÙ‚ÅŒ©‚é–‚ªo—ˆ‚éj','/penguinKawamura/ƒRƒKƒ^_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(18,'ƒVƒƒcƒoƒTƒyƒ“ƒMƒ“',6,'ƒoƒ“ƒNƒX”¼“‡Eƒ‚ƒgƒiƒE“‡‚É¶‘§@i“ú–{‚Å‚ÍŒ©‚ê‚È‚¢j','/penguinKawamura/ƒVƒƒcƒoƒT_panguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00');
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
INSERT INTO `perfume_main_anzai` VALUES (1,'OMAJINAI™ƒyƒƒŠ',2002,'ƒpƒbƒpƒ‰[‰Í‡',NULL,NULL,'L“‡‘ã‚Ìƒfƒrƒ…[‹È','0','2019-10-29 00:00:00','2019-11-06 13:04:05'),(2,'”Ş•åW’†',2002,'ƒpƒbƒpƒ‰[‰Í‡',NULL,NULL,'L“‡‘ã‚Ì–¼‹È','0','2019-10-29 00:00:00','2019-11-06 10:34:05'),(3,'ƒXƒEƒB[ƒgƒh[ƒiƒbƒc',2003,'–Ø‚Ìq',1,NULL,'‘S‘ƒCƒ“ƒfƒB[ƒYƒfƒrƒ…[‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'ƒrƒ^ƒ~ƒ“ƒhƒƒbƒv',2004,'–Ø‚Ìq',1,NULL,'‚à‚¤‚â‚é–‚Ì‚È‚¢ƒAƒCƒhƒ‹‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'ƒ‚ƒmƒNƒ[ƒ€ƒGƒtƒFƒNƒg',2004,'–Ø‚Ìq',1,NULL,'‚à‚¤‚â‚é–‚Ì‚È‚¢ƒAƒCƒhƒ‹‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'ƒŠƒjƒAƒ‚[ƒ^[ƒK[ƒ‹',2005,'’†“cƒ„ƒXƒ^ƒJ',1,NULL,'ƒƒWƒƒ[ƒfƒrƒ…[‚Ì‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'ƒGƒŒƒNƒgƒEƒ[ƒ‹ƒh',2006,'’†“cƒ„ƒXƒ^ƒJ',1,NULL,'ƒ‰ƒCƒu‚Å‚Í‚İ‚ñ‚È‚Å·‚èã‚ª‚é','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'ƒp[ƒtƒFƒNƒgƒXƒ^[Eƒp[ƒtƒFƒNƒgƒXƒ^ƒCƒ‹',2006,'’†“cƒ„ƒXƒ^ƒJ',1,NULL,'“–”­”„‚³‚ê‚½ƒAƒ‹ƒoƒ€‚Ì—Bˆê‚ÌV‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'ƒ`ƒ‡ƒRƒŒƒCƒgEƒfƒBƒXƒR',2007,'’†“cƒ„ƒXƒ^ƒJ',2,NULL,'ƒoƒŒƒ“ƒ^ƒCƒ“’è”Ô‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Twinkle Snow Powdery Snow',2007,'’†“cƒ„ƒXƒ^ƒJ',2,NULL,'ƒ`ƒ‡ƒRƒŒƒCƒgƒfƒBƒXƒR‚Æˆê”­•\‚³‚ê‚½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(11,'ƒ|ƒŠƒŠƒYƒ€',2007,'’†“cƒ„ƒXƒ^ƒJ',2,1,'‚±‚Ì‹È‚Å”š”­“Iƒqƒbƒg','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(12,'SEVENTH HEAVEN',2007,'’†“cƒ„ƒXƒ^ƒJ',6,NULL,'‚½‚¾‚½‚¾‚©‚í‚¢‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(13,'Baby cruising Love',2008,'’†“cƒ„ƒXƒ^ƒJ',2,3,'‰f‰æuƒ‚ƒeƒLv‚Åg—p','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(14,'ƒ}ƒJƒƒj',2008,'’†“cƒ„ƒXƒ^ƒJ',2,NULL,'“~‚É‚¨ƒXƒXƒ‚Ìˆê‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(15,'GAME',2008,'’†“cƒ„ƒXƒ^ƒJ',2,NULL,'ƒAƒ‹ƒoƒ€‹ÈAƒ_ƒ“ƒX‚ª‚ß‚¿‚á‚­‚¿‚á‚©‚Á‚±‚¢‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(16,'ƒZƒ‰ƒ~ƒbƒNƒK[ƒ‹',2008,'’†“cƒ„ƒXƒ^ƒJ',2,2,'[–éƒhƒ‰ƒ}‚Åg‚í‚ê‚Ä‚¢‚½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(17,'ƒV[ƒNƒŒƒbƒgƒV[ƒNƒŒƒbƒg',2008,'’†“cƒ„ƒXƒ^ƒJ',2,1,'ƒAƒCƒXuƒsƒmv‚ÌCM‚¾‚Á‚½‹C‚ª‚·‚é','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(18,'Puppy love',2008,'’†“cƒ„ƒXƒ^ƒJ',2,NULL,'‚İ‚ñ‚È‚Åã‰ºãã','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(19,'edge',2008,'’†“cƒ„ƒXƒ^ƒJ',3,NULL,'‚©‚Á‚±‚¢‚¢‚ª‚ß‚¿‚á‚­‚¿‚á‹È‚ª’·‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(20,'love the world',2008,'’†“cƒ„ƒXƒ^ƒJ',3,NULL,'ƒ‚ƒmƒNƒ‚ÌPV‚ªaV','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(21,'Dream Fighter',2008,'’†“cƒ„ƒXƒ^ƒJ',3,NULL,'‰‚ß‚Ä‚Ì•“¹ŠÙ‚Å”­•\‚³‚ê‚½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(22,'ƒƒ“ƒ‹[ƒ€EƒfƒBƒXƒR',2009,'’†“cƒ„ƒXƒ^ƒJ',3,NULL,'V¶Šˆ‰‰‡ƒ\ƒ“ƒO','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(23,'I still love U',2009,'’†“cƒ„ƒXƒ^ƒJ',3,NULL,'‘«‚Â‚Ú‚µ‚È‚ª‚çPVB‚Á‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(24,'NIGHT FLIGHT',2009,'’†“cƒ„ƒXƒ^ƒJ',3,1,'‚±‚ê‚àuƒsƒmv‚ÌCM‚Ì‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(25,'ƒiƒ`ƒ…ƒ‰ƒ‹‚É—ö‚µ‚Ä',2010,'’†“cƒ„ƒXƒ^ƒJ',4,1,'ƒAƒpƒŒƒ‹‚ÌCM‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(26,'VOICE',2010,'’†“cƒ„ƒXƒ^ƒJ',4,1,'PV‚ÌÅŒã‚«‚ê‚¢‚É‚Í‚Ü‚é','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(27,'FAKE IT',2010,'’†“cƒ„ƒXƒ^ƒJ',6,NULL,'ƒ‰ƒCƒu‚ª‚Ô‚¿ã‚ª‚é‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(28,'‚Ë‚¥',2010,'’†“cƒ„ƒXƒ^ƒJ',5,1,'ƒAƒpƒŒƒ‹‚ÌCM‹ÈAƒ_ƒ“ƒX‚ÌƒXƒeƒbƒv‚ª“Æ“Á','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(29,'”÷‚©‚ÈƒJƒIƒŠ',2011,'’†“cƒ„ƒXƒ^ƒJ',5,1,'u•XŒ‹v‚ÌCM@‰Âˆ¤‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(30,'ƒŒ[ƒU[ƒr[ƒ€',2011,'’†“cƒ„ƒXƒ^ƒJ',5,1,'u•XŒ‹v‚ÌCM@‚©‚Á‚±‚¢‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(31,'GLITTER',2011,'’†“cƒ„ƒXƒ^ƒJ',5,1,'u•XŒ‹v‚ÌCM@‚©‚Á‚±‚¢‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(32,'ƒXƒpƒCƒX',2011,'’†“cƒ„ƒXƒ^ƒJ',5,2,'u•XŒ‹v‚ÌCM@‚©‚Á‚±‚¢‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(33,'MY COLOR',2011,'’†“cƒ„ƒXƒ^ƒJ',5,NULL,'¢ŠE‚Å‚àˆ¤‚³‚ê‚½ˆê‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(34,'ƒRƒ~ƒ…ƒjƒP[ƒVƒ‡ƒ“',2012,'’†“cƒ„ƒXƒ^ƒJ',NULL,1,'ƒvƒ‹ƒvƒ‹‚Â‚ñ‚Â‚ñ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(35,'Spring of Life',2012,'’†“cƒ„ƒXƒ^ƒJ',7,1,'ˆß‘•‚ªŒõ‚é','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(36,'Hurly Burly',2012,'’†“cƒ„ƒXƒ^ƒJ',10,1,'ƒ|ƒbƒv‚Èƒ_ƒ“ƒXƒiƒ“ƒo[','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(37,'Spending all my time',2012,'’†“cƒ„ƒXƒ^ƒJ',7,1,'ŠCŠOio‚·‚éÛ‚Éo‚µ‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(38,'‚¾‚¢‚¶‚å‚Î‚È‚¢',2013,'’†“cƒ„ƒXƒ^ƒJ',7,NULL,'‚Ì‚Á‚¿‚ªŒC‚ğ‚Æ‚Î‚µ‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(39,'–¢—ˆ‚Ìƒ~ƒ…[ƒWƒAƒ€',2013,'’†“cƒ„ƒXƒ^ƒJ',7,3,'‰f‰æuƒhƒ‰‚¦‚à‚ñv‚Ìå‘è‰Ì','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(40,'Magic of Love',2013,'’†“cƒ„ƒXƒ^ƒJ',7,1,'uƒsƒ…ƒŒƒOƒ~v‚ÌCM‹N—p','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(41,'Handy Man',2013,'’†“cƒ„ƒXƒ^ƒJ',7,NULL,'‚Ì‚Á‚¿‚ªŠCŠO‚Å·‘å‚ÉŠÔˆá‚¦‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(42,'‚Ó‚è‚©‚¦‚é‚Æ‚¢‚é‚æ',2013,'’†“cƒ„ƒXƒ^ƒJ',7,NULL,'—H—ì‚Ì‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(43,'Party Maker',2013,'’†“cƒ„ƒXƒ^ƒJ',7,NULL,'·‚èã‚ª‚é‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(44,'1mm',2013,'’†“cƒ„ƒXƒ^ƒJ',7,NULL,'ÅI“dÔ‚É—h‚ç‚ê‚Ä‚é','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(45,'Sweet Refrain',2013,'’†“cƒ„ƒXƒ^ƒJ',8,2,'’·àV‚Ü‚³‚İå‰‰ƒhƒ‰ƒ}‚Ìå‘è‰Ì','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(46,'—ö‚Í‘OŒXp¨',2013,'’†“cƒ„ƒXƒ^ƒJ',8,NULL,'‚Ü‚¦‚Ì‚ß‚è','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(47,'Cling Cling',2014,'’†“cƒ„ƒXƒ^ƒJ',8,1,'ƒVƒ“ƒOƒ‹‚È‚Ì‚ÉCD‚ª‚©‚È‚è‘å‚«‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(48,'‚¢‚¶‚í‚é‚Èƒnƒ[',2014,'’†“cƒ„ƒXƒ^ƒJ',NULL,NULL,'Cling@Cling@‚ÌƒJƒbƒvƒŠƒ“ƒO','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(49,'DISPLAY',2014,'’†“cƒ„ƒXƒ^ƒJ',10,1,'‚SKƒeƒŒƒr‚ÌCM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(50,'Hold Your Hand',2014,'’†“cƒ„ƒXƒ^ƒJ',8,2,'ƒtƒ@ƒ“‚Æì‚Á‚½PV‚ªˆóÛ“I','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(51,'Pick Me Up',2015,'’†“cƒ„ƒXƒ^ƒJ',8,1,'ˆÉ¨’O‚Æ‚ÌƒRƒ‰ƒ{','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(52,'Relax In The City',2015,'’†“cƒ„ƒXƒ^ƒJ',8,1,'ƒVƒ“ƒOƒ‹‚È‚Ì‚ÉCD‚ª‚©‚È‚è‘å‚«‚¢” ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(53,'TOKIMEKI LIGHTS',2015,'’†“cƒ„ƒXƒ^ƒJ',8,NULL,'D‚«‚È‹È‚¾‚ªˆóÛ‚ª”–‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(54,'STAR TRAIN',2015,'’†“cƒ„ƒXƒ^ƒJ',8,3,'15”N‚Ì‚·‚×‚Ä‚ğ‹l‚ß‚ñ‚¾‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(55,'FLASH',2016,'’†“cƒ„ƒXƒ^ƒJ',8,3,'‰f‰æu‚¿‚Í‚â‚Ó‚év‚Åg—p‚³‚ê‚½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(56,'STORY',2016,'’†“cƒ„ƒXƒ^ƒJ',8,1,'docomo‚ÌŠé‰æ‚Å4G‚ğg‚Á‚½‰‰o‚ª‚·‚²‚©‚Á‚½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(57,'Next Stage with YOU',2016,'’†“cƒ„ƒXƒ^ƒJ',8,1,'ƒxƒ“ƒcCM‚É‹N—p','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(58,'Miracle Worker',2016,'’†“cƒ„ƒXƒ^ƒJ',8,NULL,'‹È‚Ì“r’†‚Ìu‚¨‚±‚¹ƒ~ƒ‰ƒR[v‚ª“Á’¥“I','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(59,'Cosmic Explorer',2016,'’†“cƒ„ƒXƒ^ƒJ',8,NULL,'ƒAƒ‹ƒoƒ€‰‚ß‚Ì‹ÈB','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(60,'TOKYO GIRL',2017,'’†“cƒ„ƒXƒ^ƒJ',9,2,'‹g‚—R—¢qå‰‰ƒhƒ‰ƒ}‚Ìå‘è‰Ì','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(61,'•óÎ‚Ì‰J',2017,'’†“cƒ„ƒXƒ^ƒJ',9,1,'¢Ora2£ TV CMƒ\ƒ“ƒO','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(62,'Everyday',2017,'’†“cƒ„ƒXƒ^ƒJ',9,1,'upnasonicv‚Ìô‘ó‹@‚ÌCM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(63,'If you wanna',2017,'’†“cƒ„ƒXƒ^ƒJ',9,NULL,'ƒtƒ…[ƒ`ƒƒ[ƒx[ƒX‚ğæ‚è“ü‚ê‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(64,'–³ŒÀ–¢—ˆ',2018,'’†“cƒ„ƒXƒ^ƒJ',9,3,'‰f‰æu‚¿‚Í‚â‚Ó‚év‚Åg—p‚³‚ê‚½','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(65,'Let Me Know',2018,'’†“cƒ„ƒXƒ^ƒJ',9,NULL,'PV‚ª‰Âˆ¤‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(66,'“V‹ó',2018,'’†“cƒ„ƒXƒ^ƒJ',9,1,'docomo‚ÌCM‚Åg—pA2019”NÅ‰‚É”â˜I‚µ‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(67,'Tiny Baby',2018,'’†“cƒ„ƒXƒ^ƒJ',9,NULL,'ƒ‰ƒCƒu‰‰o‚ª‚·‚²‚¢','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(68,'Future Pop',2018,'’†“cƒ„ƒXƒ^ƒJ',9,NULL,'2019”Ng”’‚Å”â˜I‚µ‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(69,'ƒiƒiƒiƒiƒiƒCƒ',2019,'’†“cƒ„ƒXƒ^ƒJ',10,1,'—·‚ğƒe[ƒ}‚Æ‚µ‚½‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(70,'Challenger',2019,'’†“cƒ„ƒXƒ^ƒJ',10,NULL,'’†“cƒ„ƒXƒ^ƒJ‚Æ‚Ìo‰ï‚¢‚Ì‹È','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(72,'Perfume',2006,'',NULL,NULL,'','0','2019-11-06 14:01:10','2019-11-06 14:01:10');
/*!40000 ALTER TABLE `perfume_main_anzai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residents_main_sato`
--

DROP TABLE IF EXISTS `residents_main_sato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residents_main_sato` (
  `id` int(11) DEFAULT NULL,
  `residents_name` varchar(256) DEFAULT NULL,
  `animal_id` int(11) DEFAULT NULL,
  `sex_id` int(11) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residents_main_sato`
--

LOCK TABLES `residents_main_sato` WRITE;
/*!40000 ALTER TABLE `residents_main_sato` DISABLE KEYS */;
INSERT INTO `residents_main_sato` VALUES (1,'ƒnƒ“ƒi',1,2,'‘Sg‚ªÔ‚­AŠç‚ÉƒOƒŒ[‚Ì‚Ô‚¿–Í—l‚ª‚ ‚éB¨‚ÉƒsƒAƒX‚ğ•t‚¯‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(2,'ƒ‰ƒbƒL[',1,1,'‘Sg‚ª•ï‘Ñ‚ÅŠª‚©‚ê‚Ä‚¢‚ÄAŠç‚Í•ï‘Ñ‚ÌŒ„ŠÔ‚©‚ç•Ğ–Ú‚¾‚¯Œ©‚¦‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(3,'ƒqƒƒƒNƒp[',2,2,'—t‚Á‚Ï‚ª‚Â‚¢‚½‚İ‚©‚ñ‚Ì‚æ‚¤‚ÈŠçB”ç‚Ì‚Ô‚Â‚Ô‚ÂŠ´‚ªƒŠƒAƒ‹','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(4,'ƒWƒƒƒbƒN',2,1,'Šá‹¾‚ğ‚©‚¯‚Ä‚¨‚è•‚ÍƒX[ƒcB¶‰E‚Ì–Ú‚ÌF‚ªˆá‚¤','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(5,'ƒrƒX',3,1,'–Ú‚ªƒrƒX‚Ì‚æ‚¤‚É\šƒ}[ƒN‚É‚È‚Á‚Ä‚¢‚éBˆê”ÔD‚«‚ÈZ–¯','0','2020-05-28 00:00:00','2020-06-17 09:30:09'),(6,'ƒ_ƒ‹ƒ}ƒ“',3,1,'Ô‚¢–Ú‚Æ‰©F‚¢”û–Ñ‚ª“Á’¥“IB‹­‚»‚¤‚ÈˆóÛ','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(7,'ƒPƒ`ƒƒƒbƒv',4,2,'ƒgƒ}ƒg‚Ì‚æ‚¤‚É“ª‚É—t‚Á‚Ï‚ª‚Â‚¢‚Ä‚¨‚èA‘Sg‚ªÔ‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(8,'ƒs[ƒ^ƒ“',4,1,'‘Sg‚ª’ƒF‚­2‘©‚Ù‚Ç‘O”¯‚Ì‚æ‚¤‚È‚à‚Ì‚ª‚ ‚éB–Ú‚ª‘å‚«‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(9,'ƒNƒŠƒXƒ`[ƒk',5,2,'ƒsƒ“ƒN‚Æ”’‚Ì…‹Ê‚Ì“ª‹Ğ‚ğ”í‚Á‚½‚æ‚¤‚ÈŒ©‚½–ÚB–Ú‚ª‚Ï‚Á‚¿‚è‚µ‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(10,'ƒv[ƒXƒP',5,1,'Œã“ª•”‚É•‚‚«—Ö‚Ì‹ó‹CŒŠ‚Ì‚æ‚¤‚È‚à‚Ì‚ª‚ ‚éB‚Æ‚Ú‚¯‚½‚æ‚¤‚ÈŠç‚ª‚©‚í‚¢‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(11,'‚â‚æ‚¢',5,2,'‚Í‚É‚í‚Ì‚æ‚¤‚ÉŒû‚Æ–Ú‚ª‚Û‚Á‚©‚è‹ó‚¢‚Ä‚¢‚éB•\î‚É•Ï‰»‚ª‚È‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(12,'ƒhƒN',6,1,'–¼‚Ì’Ê‚èƒhƒNƒKƒGƒ‹‚Ì‚æ‚¤‚ÈF‚ğ‚µ‚Ä‚¢‚é‚ªŠç‚Í‚©‚í‚¢‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(13,'ƒtƒ‹ƒƒ^ƒ‹',6,1,'‘Sg–ÀÊ•¿B‚Ñ‚Á‚­‚è‚µ‚½‚æ‚¤‚È–Ú‚ğ‚µ‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(14,'‚½‚¢‚Ö‚¢‚½',7,1,'”û–Ñ‚ªŠC‘Û‚Ì‚æ‚¤‚É‘¾‚­A–Ú‚Íƒ^ƒŒ–Ú‚Å‚¢‚Â‚à•Â‚¶‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(15,'ƒ^ƒ“ƒ^ƒ“',7,2,'•‚¢•”•ª‚ªƒsƒ“ƒN‚É‚È‚Á‚½ƒpƒ“ƒ_‚Ì‚æ‚¤‚ÈŒ©‚½–Ú','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(16,'ƒpƒbƒ`',8,1,'–Ú‚ª~ˆóBŒp‚¬‚Í‚¬­‚ª‚ ‚è‚Ê‚¢‚®‚é‚İŠ´‚ª‚ ‚Á‚Ä‚©‚í‚¢‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(17,'‚İ‚·‚¸',8,2,'–Ú‚ªƒLƒ‰ƒLƒ‰‚ÅáÊ–Ñ‚ª’·‚¢Bƒsƒ“ƒN‚Æ…F‚ÌƒOƒ‰ƒf[ƒVƒ‡ƒ“‚ª‚«‚ê‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(18,'ƒpƒeƒB',9,2,'Šp‚ªä•‚Å“ª‚É¶ƒNƒŠ[ƒ€‚Ì‚æ‚¤‚È‚à‚Ì‚ªæ‚Á‚Ä‚¢‚é\r\n','0','2020-05-28 00:00:00','2020-06-17 09:30:41'),(19,'ƒlƒ‹ƒ\ƒ“',10,1,'Šp‚ªÈX‚Å‚¨‚µ‚á‚ê‚ÈŒ`‚ğ‚µ‚Ä‚¢‚éB”¼–Ú','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(20,'ƒWƒFƒVƒJ',10,2,'Šç‚Íƒsƒ“ƒN‚Å‰©F‚¢‘O”¯BƒsƒAƒX‚ğ•t‚¯‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(21,'ƒeƒB[ƒi',11,2,'Šç‚ÍƒeƒB[ƒ|ƒbƒg‚ğ–Í‚µ‚Ä‚¨‚èA’‚¬Œû‚ª•@‚Ì•”•ª‚É‚È‚Á‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(22,'ƒpƒ“ƒNƒX',11,1,'‘Sg‚ªÔ‚­A–Ú‚Â‚«‚ª‰s‚¢B–¼‚Ì’Ê‚èƒpƒ“ƒN‚È•µˆÍ‹C','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(23,'ƒ^ƒRƒ„',12,1,'Œ©‚½–Ú‚Æ–¼‘O‚©‚ç‚µ‚ÄŠ®‘S‚É‚½‚±Ä‚«B“ª‚É’Ü—k}‚ªh‚³‚Á‚Ä‚¢‚é','0','2020-05-28 00:00:00','2020-06-16 14:30:09'),(24,'ƒ^ƒRƒŠ[ƒi',12,2,'ƒsƒ“ƒNF‚Å‚Ù‚Á‚Ø‚ª‰©FB‚Ü‚Â‚°‚ÌƒJ[ƒ‹‹ï‡‚ª‚©‚í‚¢‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(25,'‚¤‚¸‚Ü‚«',13,2,'g‘Ì‚Íƒsƒ“ƒN‚Æ”’B‚Ù‚Á‚Ø‚ª‚¤‚¸‚Ü‚«–Í—l','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(26,'‚ä‚«‚İ',14,2,'…F‚Ì‚Ü‚ë”ûB”’‚­‚Û‚Á‚Ä‚è‚Æ‚µ‚½g‘Ì‚ª‚©‚í‚¢‚¢','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(27,'ƒWƒ…ƒyƒbƒeƒB',15,1,'ƒsƒGƒ‚Ì‚æ‚¤‚ÈŠç‚ğ‚µ‚Ä‚¢‚éB‘Ì‚ªƒJƒ‰ƒtƒ‹','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(28,'‚¿‚á‚¿‚á‚Ü‚é',15,1,'–Ú‚ªƒLƒ‰ƒLƒ‰‚Å‘O•‚ªŒ©‚¦‚éB‘‚ß‚È‚¢Šç','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(29,'ƒXƒp[ƒN',16,1,'“ª‚É—‹‚Ì–Í—l‚ª‚Â‚¢‚Ä‚¢‚éB‘Sg‚Í‡F','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(30,'ƒ~ƒ“ƒg',16,2,'–¼‚Ì’Ê‚èƒ~ƒ“ƒgFB‰ºáÊ–Ñ‚ªˆóÛ“I','0','2020-05-28 00:00:00','2020-05-28 00:00:00');
/*!40000 ALTER TABLE `residents_main_sato` ENABLE KEYS */;
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
INSERT INTO `resipe_main_ishikawa` VALUES (1,'ƒJƒŒ[','‚©‚ê[',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'ƒNƒŠ[ƒ€ƒVƒ`ƒ…[','‚­‚è[‚Ş‚µ‚¿‚ã[',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'“÷‚¶‚á‚ª','‚É‚­‚¶‚á‚ª',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'ƒ[ƒ‹ƒLƒƒƒxƒc','‚ë[‚é‚«‚á‚×‚Â',3,4,2,50,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'ƒ|ƒgƒt','‚Û‚Æ‚Ó',2,3,3,30,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'”’Øƒ~ƒ‹ƒtƒB[ƒ†','‚Í‚­‚³‚¢‚İ‚é‚Ó‚¡[‚ä',5,0,2,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'|“Ø','‚·‚Ô‚½',1,3,2,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'‰Ä–ìØƒOƒ‰ƒ^ƒ“','‚È‚Â‚â‚³‚¢‚®‚ç‚½‚ñ',7,8,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'‚İ‚¼‚ê“ç','‚İ‚¼‚ê‚È‚×',5,11,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'‚«‚ñ‚Ò‚ç','‚«‚ñ‚Ò‚ç',1,10,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'ƒs[ƒ}ƒ“‚Ì“÷‹l‚ß','‚Ò[‚Ü‚ñ‚Ì‚É‚­‚Ã‚ß',3,6,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'ƒnƒ“ƒo[ƒO','‚Í‚ñ‚Î[‚®',3,0,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'eq˜¥','‚¨‚â‚±‚Ç‚ñ',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(14,'â¡‚²‚Í‚ñ','‚½‚¯‚Ì‚±‚²‚Í‚ñ',12,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(15,'‹˜¥','‚¬‚ã‚¤‚Ç‚ñ',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(16,'‚©‚Ú‚¿‚á‚ÌÏ•¨','‚©‚Ú‚¿‚á‚Ì‚É‚à‚Ì',9,0,3,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(17,'“Ø`','‚Æ‚ñ‚¶‚é',1,3,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(18,'ŒI‚²”Ñ','‚­‚è‚²‚Í‚ñ',13,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(19,'ƒ|ƒeƒgƒTƒ‰ƒ_','‚Û‚Ä‚Æ‚³‚ç‚¾',2,3,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(20,'ƒiƒ|ƒŠƒ^ƒ“','‚È‚Û‚è‚½‚ñ',6,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(21,'ƒ‰ƒ^ƒgƒ…ƒ†','‚ç‚½‚Æ‚¡‚ä',7,8,3,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(22,'ƒrƒVƒ\ƒ[ƒY','‚Ñ‚µ‚»‚í[‚¸',2,0,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(23,'ƒgƒ}ƒgÏ','‚Æ‚Ü‚Æ‚É',3,7,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(24,'ƒ|ƒ‚ƒh[ƒ','‚Û‚à‚Ç[‚ë',7,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
INSERT INTO `sex_ito` VALUES (0,NULL,'0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'’j«','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'—«','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'’j—','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `sex_ito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sex_sato`
--

DROP TABLE IF EXISTS `sex_sato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sex_sato` (
  `id` int(11) DEFAULT NULL,
  `sex` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sex_sato`
--

LOCK TABLES `sex_sato` WRITE;
/*!40000 ALTER TABLE `sex_sato` DISABLE KEYS */;
INSERT INTO `sex_sato` VALUES (0,NULL,'0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(1,'’j','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(2,'—','0','2020-05-28 00:00:00','2020-05-28 00:00:00');
/*!40000 ALTER TABLE `sex_sato` ENABLE KEYS */;
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
INSERT INTO `team_color_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'Ô','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'ƒsƒ“ƒN','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'ƒIƒŒƒ“ƒW','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'‰©F','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'‰©—Î','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'…F','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'Â','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'—Î','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'”’','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'•','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'‡','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
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
INSERT INTO `team_main_matsuda` VALUES (1,'ƒTƒ“ƒtƒŒƒbƒ`ƒFL“‡',34,1,'²X–ØãÄ','3ƒoƒbƒN‚Ì—v','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'”ƒŒƒCƒ\ƒ‹',12,4,'’†‘ºq•ã','“S•Ç','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'FC“Œ‹',13,7,'º’J¬','Œ£g“IƒTƒCƒhƒoƒbƒN','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'‰Y˜aƒŒƒbƒY',11,1,'‹»‘TO','ƒS[ƒ‹‘O‚Ìd–l','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'ƒKƒ“ƒo‘åã',27,7,'‰““¡•Ûm','ƒpƒXƒR[ƒX360“x','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'ƒZƒŒƒbƒ\‘åã',27,2,'Š`’J—jˆê˜N','ƒ~ƒXƒ^[ƒ†[ƒeƒBƒŠƒeƒB','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'ƒxƒKƒ‹ƒ^å‘ä',4,3,'ÔèG•½','ƒxƒKƒ‹ƒ^‚ÌØ‚èD','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'‰¡•lFC',14,6,'’†‘ºr•ã','ƒŒƒWƒFƒ“ƒhƒŒƒtƒeƒB[','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'–¼ŒÃ‰®ƒOƒ‰ƒ“ƒpƒX',23,3,'‘Š”n—E‹I','ƒTƒ‰ƒuƒŒƒbƒgƒvƒŒƒCƒ„[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'ƒ”ƒBƒbƒZƒ‹_ŒË',28,9,'ƒAƒ“ƒhƒŒƒX@ƒCƒjƒGƒXƒ^','THE SOCCER','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'ìèƒtƒƒ“ƒ^[ƒŒ',14,6,'‰Æ’·º”','‹ZI”hƒŒƒtƒeƒB[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'ƒTƒKƒ“’¹²',31,6,'‚‹´Gl','ƒQ[ƒ€ƒƒCƒJ[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'Ã“ìƒxƒ‹ƒ}[ƒŒ',14,5,'R“c’¼‹P','•Ô‚Á‚Ä‚«‚½“VË','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'‰¡•lFEƒ}ƒŠƒmƒX',14,7,'’‡ì‹Pl','ƒnƒ}‚ÌƒXƒs[ƒhƒXƒ^[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'‘å•ªƒgƒŠƒj[ƒ^',44,6,'Šâ“c’q‹P','ƒgƒŠƒj[ƒ^‚ÌŠç','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'–kŠC“¹ƒRƒ“ƒTƒh[ƒŒD–y',1,1,'ƒ`ƒƒƒiƒeƒBƒbƒv','ƒ^ƒC‚ÌƒƒbƒV','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'´…ƒGƒXƒpƒ‹ƒX',22,3,'—§“c—IŒå','•œŒ ‚Ì¯','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'­“‡ƒAƒ“ƒgƒ‰[ƒY',8,1,'OŠ}Œ’“l','Ÿ¢‘ã‘åŒ^ƒ{ƒ‰ƒ“ƒ`','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
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
INSERT INTO `tieup_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'CM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'ƒhƒ‰ƒ}','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'‰f‰æ','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
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
INSERT INTO `tokyo_main_takehara` VALUES (1,'ç‘ã“c','/tokyoTakehara/chiyoda.jpg',5,64533,11.66,'‹ã’i‰º',784,6330721,'÷–ØŠó—Ñ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'’†‰›','/tokyoTakehara/chuo.png',1,163185,10.21,'V•x’¬',556,8219777,'á—Ñ³‹±','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'`','/tokyoTakehara/minato.png',3,258075,20.37,'‘å–å',902,3611975,'ŠÖª‹Î','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'Vh','/tokyoTakehara/shinjuku.png',2,347661,18.22,'Vh¼Œû',477,3263794,'ƒ‹[‘åÄ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'•¶‹','/tokyoTakehara/bunkyo.png',4,232801,11.29,'ŒãŠy‰€',544,1181450,'–ìX‘º^','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(6,'‘ä“Œ','/tokyoTakehara/taito.png',1,206816,10.11,'ã–ì',385,1376259,'“VŠC—SŠó','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(7,'–n“c','/tokyoTakehara/sumida.png',1,268192,13.77,'ó‘',350,589458,'‘å’|ˆê÷','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(8,']“Œ','/tokyoTakehara/koto.png',1,516636,40.16,'“Œ—z’¬',389,583708,'“cD','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(9,'•iì','/tokyoTakehara/shinagawa.png',3,407084,22.84,'‰º_–¾',427,1160600,'‰““¡Œ›ˆê','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(10,'–Ú•','/tokyoTakehara/meguro.png',3,286462,14.67,'’†–Ú•',537,1195400,'ò’J‚µ‚°‚é','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(11,'‘å“c','/tokyoTakehara/ota.png',3,737700,60.83,'Š—“c',395,627693,'•Ğ‹Ë‚Í‚¢‚è','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(12,'¢“c’J','/tokyoTakehara/setagaya.png',2,933708,58.05,'¢“c’J',506,690153,'’†ˆä‹Mˆê','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(13,'a’J','/tokyoTakehara/shibuya.png',2,233060,15.11,'a’J',703,4234271,'‹g‰i¬•S‡','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(14,'’†–ì','/tokyoTakehara/nakano.png',2,328215,15.59,'’†–ì',387,812547,'“c’†—T“ñ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(15,'™•À','/tokyoTakehara/suginami.png',2,582864,34.06,'“ìˆ¢²ƒ–’J',436,617023,'¼“c—´•½','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(16,'–L“‡','/tokyoTakehara/toshima.png',4,300512,13.01,'“Œ’r‘Ü',412,1147581,'R‰º’B˜Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(17,'–k','/tokyoTakehara/kita.png',4,352806,20.61,'‰¤q',344,657836,'ŒÃŠÚˆÉ’m˜Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(18,'rì','/tokyoTakehara/arakawa.png',4,217692,10.16,'rì“ñ’š–Ú',345,605586,'•Ğ‰ª’ß‘¾˜Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(19,'”Â‹´','/tokyoTakehara/itabashi.png',4,581066,32.22,'”Â‹´‹æ–ğŠ‘O',350,475214,'ˆîŠ_Œá˜Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(20,'—û”n','/tokyoTakehara/nerima.png',2,737906,48.08,'—û”n',395,435136,'ãŒËÊ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(21,'‘«—§','/tokyoTakehara/adachi.png',4,681309,53.25,'”~“‡',324,367663,'ƒr[ƒg‚½‚¯‚µ','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(22,'Š‹ü','/tokyoTakehara/katsushika.png',1,453522,34.8,'¼Vˆä‘åt¼',333,362640,'“ñ‹{˜a–ç','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(23,']ŒËì','/tokyoTakehara/edogawa.png',1,693519,49.9,'V¬Šâ',346,392703,'¼è‚µ‚°‚é','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
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
INSERT INTO `triathlon_main_mori` VALUES (1,'RS9s',1,1,800000,'/TriathlonMori/001.jpg','0','2020-03-11 00:00:00','2020-03-23 15:02:09'),(2,'RT9',2,1,410000,'/TriathlonMori/002.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'GALLIUM PRO',1,2,380000,'/TriathlonMori/003.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'E-119 TRI+',2,2,576000,'/TriathlonMori/004.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'OLTRE XR4',1,3,1780000,'/TriathlonMori/005.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'AQUILA CV',2,3,900000,'/TriathlonMori/006.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'G8 PRO',1,4,748000,'/TriathlonMori/007.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'AEROLIGHT',2,4,1050000,'/TriathlonMori/008.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'Timemachine Road 01',1,5,880000,'/TriathlonMori/009.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'Timemachine 01',2,5,870000,'/TriathlonMori/010.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'VIDE pro CT-RTV',1,6,500000,'/TriathlonMori/011.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'SWOOP CT-TT',2,6,418000,'/TriathlonMori/012.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'Ultomate CF Evo',1,7,899000,'/TriathlonMori/013.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'Speedmax CF SLX LTD',2,7,1109000,'/TriathlonMori/014.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'S5',1,8,1580000,'/TriathlonMori/015.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'P5X',2,8,2280000,'/TriathlonMori/016.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'RB1K \"THE ONE\"',1,9,720000,'/TriathlonMori/017.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'NKTT',2,9,990000,'/TriathlonMori/018.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'C64',1,10,738000,'/TriathlonMori/019.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'K.one',2,10,620000,'/TriathlonMori/020.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'LITENING C:68X SLT',1,11,1176000,'/TriathlonMori/021.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'AERIUM C:68 SLT',2,11,1387000,'/TriathlonMori/022.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'TRILLIANT',2,12,470000,'/TriathlonMori/023.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'CARBONADO',2,12,370000,'/TriathlonMori/024.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'525',1,13,466000,'/TriathlonMori/025.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'LUGANO68',2,13,278000,'/TriathlonMori/026.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(27,'O2 V.A.M',1,14,590000,'/TriathlonMori/027.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(28,'SLICK',2,14,680000,'/TriathlonMori/028.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(29,'FR FRD',1,15,1980000,'/TriathlonMori/029.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(30,'IA FRD',2,15,2480000,'/TriathlonMori/030.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(31,'TRANSONIC 1.1',1,16,340000,'/TriathlonMori/031.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(32,'NORCOM STRAIGHT 1.1',2,16,290000,'/TriathlonMori/032.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(33,'PROPEL ADVANCED SL',1,17,1300000,'/TriathlonMori/033.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(34,'TRINITY ADVANCE PRO 1',2,17,690000,'/TriathlonMori/034.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(35,'STRAUSS PRO',1,18,248000,'/TriathlonMori/035.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(36,'STRAUSS TRI',2,18,199000,'/TriathlonMori/036.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(37,'KHAN',1,19,365000,'/TriathlonMori/037.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(38,'KT05',2,19,460000,'/TriathlonMori/038.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(39,'SCULTURA 10K-E',1,20,1200000,'/TriathlonMori/039.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(40,'TIME WARP TRI 10K-E',2,20,1350000,'/TriathlonMori/040.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(41,'DOGMA F12',1,21,1300000,'/TriathlonMori/041.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(42,'BOLIDE TR+',2,21,1570000,'/TriathlonMori/042.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(43,'HELIUM SLX',1,22,365000,'/TriathlonMori/043.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(44,'DEAN',2,22,323000,'/TriathlonMori/044.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(45,'FOIL PREMIUM',1,23,1118000,'/TriathlonMori/045.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(46,'PLASMA RC',2,23,1190000,'/TriathlonMori/046.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(47,'S-Works VENGE',1,24,1375000,'/TriathlonMori/047.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(48,'S-Works Shiv',2,24,1404000,'/TriathlonMori/048.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(49,'Madone SLR 9',1,25,1281000,'/TriathlonMori/049.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(50,'Speed Concept',2,25,510000,'/TriathlonMori/050.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(51,'ZERO SLR',1,26,590000,'/TriathlonMori/051.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(52,'TURBINE',2,26,650000,'/TriathlonMori/052.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(53,'‚±‚¶‚ë‚¤',0,0,100,'/TriathlonMori/20200323150234372.jpg','0','2020-03-19 11:02:07','2020-03-23 15:02:34'),(54,'‚à‚à',1,8,9999999,NULL,'1','2020-03-23 09:12:05','2020-03-23 09:12:05'),(55,'‚à‚à',1,10,1,'/TriathlonMori/20200323150336788.jpg','0','2020-03-23 15:03:36','2020-03-23 15:03:36');
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
INSERT INTO `type_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'ƒ[ƒhƒoƒCƒN','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'ƒ^ƒCƒ€ƒgƒ‰ƒCƒAƒ‹ƒoƒCƒNiTT)','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
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
INSERT INTO `vegetable_ishikawa` VALUES (1,'‚É‚ñ‚¶‚ñ','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'‚¶‚á‚ª‚¢‚à','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'‚½‚Ü‚Ë‚¬','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'ƒLƒƒƒxƒc','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'”’Ø','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'ƒs[ƒ}ƒ“','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'ƒgƒ}ƒg','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'ƒiƒX','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'‚©‚Ú‚¿‚á','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'‚²‚Ú‚¤','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'‚¾‚¢‚±‚ñ','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'â¡','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'ŒI','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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

-- Dump completed on 2020-06-17 11:44:50
