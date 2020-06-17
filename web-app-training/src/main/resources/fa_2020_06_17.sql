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
INSERT INTO `album_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'Perfume�`Complete Best','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'GAME','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'JPN','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'Perfume Global Compilation','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'LOVE THE WORLD','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'LEVEL3','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'COSMIC EXPLORER','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'Future Pop','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Perfume The Best �gP Cubed�h','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
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
INSERT INTO `animal_sato` VALUES (0,NULL,'0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(1,'��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(2,'�L','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(3,'�y���M��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(4,'�A�q��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(5,'������','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(6,'�J�G��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(7,'�F','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(8,'���F','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(9,'�T�C','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(10,'��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(11,'��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(12,'�^�R','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(13,'��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(14,'�n���X�^�[','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(15,'�r','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(16,'���X','0','2020-05-28 00:00:00','2020-05-28 00:00:00');
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
INSERT INTO `area_ito` VALUES (0,NULL,'0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(1,'�����s','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(2,'��ʌ�','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(3,'��t��','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(4,'�_�ސ쌧','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(5,'���Ɍ�','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(6,'���m��','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(7,'�V����','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(8,'���{','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(9,'�ޗǌ�','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(10,'������','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(11,'���s�{','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(12,'�k�C��','0','2020-03-24 00:00:00','2020-03-24 00:00:00');
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
INSERT INTO `artist` VALUES (1,'Zebrahead','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(2,'FLOW','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(3,'�ĒÌ��t','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(4,'Anly','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(5,'fox capture plan','0','2018-05-23 01:27:00','2018-05-23 01:27:00');
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
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0：有効　1：無効',
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
INSERT INTO `attribute_kawamura` VALUES (0,NULL,'0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(1,'�G���y���[�y���M����','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(2,'�A�f���[�y���M����','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(3,'�t���{���g�y���M����','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(4,'�}�J���j�y���M����','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(5,'�L�����y���M����','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(6,'�R�K�^�y���M����','0','2019-12-03 15:19:00','2019-12-03 15:19:00');
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
INSERT INTO `band_main_ito` VALUES (1,'Fear,and loathing in LasVegas',1,5,2008,'�Ȃ񂿂�烉�X�x�K�X�Ŋo������OK/��Step Of Terror','0',NULL,NULL),(2,'a crowd of rebellion',1,7,2007,'�Ȓ��A���A���G������������/��Never Say A Gain','0',NULL,NULL),(3,'crossfaith',1,8,2006,'���C�u�ŗF�l�����܂���/��Blue','0',NULL,NULL),(4,'Coldrain',1,6,2007,'�T�E���h������������/��F.T.T.T','0',NULL,NULL),(6,'HEY-SMITH',1,8,2006,'�X�J�p���N���ō�/��Drug Free Japan','0',NULL,NULL),(7,'SiM',1,4,2004,'���Q�G�v�f����/��RiOT','0',NULL,NULL),(8,'�}�L�V�}���U�z������',3,1,1998,'���C�u���݂�ȕ΍��l�Ⴍ�Ȃ�/���uF�v','0',NULL,NULL),(9,'Ailiph�@Doepa',1,1,2010,'�C���t���G���U�̂Ƃ��Ɍ���悤��MV����/��MARS','0',NULL,NULL),(10,'04Limted Sazabys',1,6,2008,'�Ȃ̑u����/��Knife','0',NULL,NULL),(11,'�t���f���b�N',1,5,2009,'�̐����r�W���������o�q/��TOGENKYO','0',NULL,NULL),(12,'�L���E�\�l�R�J�~',1,5,2009,'�L���b�`�[�Ŗʔ���/�������w�������','0',NULL,NULL),(13,'ELLEGARDEN',1,3,1998,'��������/���T���^�N���[�X','0',NULL,NULL),(14,'�����I',1,5,2009,'�����o�[1�l1�l�̃r�W������/������','0',NULL,NULL),(15,'�Ŏ񍖖哯�D��',3,NULL,2004,'Ba���җ�Ɍ����Ȃ��A�уe���o���h/������DNA','0',NULL,NULL),(16,'�z�Ƃ��Ď��J',3,2,2002,'�c�C���{�~�h�������ō�/��nakano kill you','0',NULL,NULL),(17,'THE ORAL CIGARETTES',1,9,2010,'�_�[�N�ȕ��͋C�������Ă�/��DIP-BAP','0',NULL,NULL),(18,'FACT',1,NULL,1999,'���ʃo���h/��error','0',NULL,NULL),(19,'MAN WITH A MISSIOM',1,1,2010,'�T�o���h/��NEVER FXXKIN\' MIND THE RULES','0',NULL,NULL),(20,'The BONEZ',1,NULL,2012,'JESSE����������/��Hello Monster','0',NULL,NULL),(21,'�A���J��',1,5,2002,'Vo����Ƀ^���o�����������Ă���i�g��Ȃ��j/���`�N�V���[','0',NULL,NULL),(22,'�|���J�h�b�g�X�e�B���O���C',2,10,2015,'�͋�������Vo/���G���N�g���b�N�E�p�u���b�N','0',NULL,NULL),(23,'���@�����ɂȂ��',2,NULL,2014,'Vo������ׂ�Ȃ��Ȃ�􂢂��������Ă��ĉ���/���q���T�}�X�s���b�c','0',NULL,NULL),(24,'�N���[�v�n�C�v',1,1,2001,'�����ȂɂȂ�/���S','0',NULL,NULL),(25,'�}�J���j����҂�',1,4,2012,'�����ɒ�������G��������/�������h�����N��','0',NULL,NULL),(26,'�T���{�}�X�^�[',1,1,2000,'���C�u�ň�ԋ�����o���h/�����u�\���O','0',NULL,NULL),(27,'�����ɖ�',3,8,2011,'�c�C���̏d�Ȃ荇�����ǂ�/�����ŗx��','0',NULL,NULL),(28,'�q�X�e���b�N�p�j�b�N',1,6,2012,'�d���ăL���b�`�[�ȃT�E���h�ŗǂ�/���ʎ�','0',NULL,NULL),(29,'ROTTENGRAFFTY',1,11,1999,'�|���������������ǂ�/�����F�O���t�e�B�[','0',NULL,NULL),(30,'�T�J�i�N�V����',1,12,2005,'�V�󓇂̓����������痣��Ȃ�/�������A��','0',NULL,NULL),(31,'��̖{�C�_���X',1,NULL,2008,'���Ă�V���c�������������/��with out you','0',NULL,NULL),(32,'Survive Said The Prophet',1,1,2011,'�o���h���ǂ݂Â炢/��found & lost','0',NULL,NULL),(33,'�[�łɗU���������̓V�g�B',1,4,2015,'�u���C�N�_�E�����������낢youtuber�o���h/���N�ɓ͂��Ȃ����̓C�^���A�ɂ��͂��Ȃ��A�̂Ƀ~���m��','0',NULL,NULL),(34,'Pay money To my Pain',1,1,2005,'�����Ƒ����m���Ă����΂悩�����Ǝv���o���h/��Sweetest vengeance','0',NULL,NULL),(35,'�ߑO�l���A���Ă��Ƀc�L',1,7,2011,'�����o�[���傫���ς���Ă��Ȃ�����������/������','0',NULL,NULL);
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
INSERT INTO `genre` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'�A�N�V����',0,'2017/11/08','2017/11/08'),(2,'�T�X�y���X',0,'2017/11/08','2017/11/08'),(3,'�q���[�}��',0,'2017/11/08','2017/11/08'),(4,'�z���[',0,'2017/11/08','2017/11/08'),(5,'�R���f�B',0,'2017/11/08','2017/11/08');
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
INSERT INTO `genre_ishikawa` VALUES (0,NULL,'0','2020-03-24 11:40:38','2020-03-24 11:40:41'),(1,'��H','0','2020-03-24 11:40:58','2020-03-24 11:41:01'),(2,'���','0','2020-03-24 11:41:18','2020-03-24 11:41:21'),(3,'����','0','2020-03-24 11:41:36','2020-03-24 11:41:39');
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
INSERT INTO `genre_kataoka` VALUES (0,' ','0','2020-03-24 02:37:07','2018-09-17 06:00:00'),(1,'������Y','0','2020-03-24 02:39:42','2018-09-17 06:00:00'),(2,'���R��Y','0','2020-03-24 02:39:08','2020-03-23 17:00:00');
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
INSERT INTO `heritage_main_kataoka` VALUES (1,1,'/heritageKataoka/horyuji.jpeg\r\n','�@�����n��̕���������',29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,NULL,'0','2018-09-30 21:01:17','2018-09-17 06:00:00'),(2,1,'/heritageKataoka/himejijyo.jpeg\r\n','�P�H��',28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,NULL,'0','2018-09-30 21:01:35','2018-09-17 06:00:00'),(3,1,'/heritageKataoka/kyoto.jpeg\r\n','�Ós���s�̕������i���s�s�A�F���s�A��Îs�j',26,25,NULL,NULL,NULL,NULL,NULL,NULL,1994,NULL,'0','2018-09-30 21:01:52','2018-09-17 06:00:00'),(4,1,'/heritageKataoka/shirakawago.jpeg\r\n','���싽�E�܉ӎR�̍�������W��',21,16,NULL,NULL,NULL,NULL,NULL,NULL,1995,NULL,'0','2018-09-30 21:02:06','2018-09-17 06:00:00'),(5,1,'/heritageKataoka/genbakudomu.jpeg\r\n','�����h�[��',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1996,'���̐��E��Y','0','2018-09-30 21:02:15','2018-09-17 06:00:00'),(6,1,'/heritageKataoka/itsukushima.jpeg\r\n','�����_��',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1996,NULL,'0','2018-09-30 21:02:20','2018-09-17 06:00:00'),(7,1,'/heritageKataoka/nara.jpeg\r\n','�Ós�ޗǂ̕�����',29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1998,NULL,'0','2018-09-30 21:02:25','2018-09-17 06:00:00'),(8,1,'/heritageKataoka/nikkoTemple.jpeg\r\n','�����̎Ў�',9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1999,NULL,'0','2018-09-30 21:02:30','2018-09-17 06:00:00'),(9,1,'/heritageKataoka/ryukyuKingdum.jpeg\r\n','���������̃O�X�N�y�ъ֘A��Y�Q',47,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2000,NULL,'0','2018-09-30 21:02:41','2018-09-17 06:00:00'),(10,1,'/heritageKataoka/mtKi.jpeg\r\n','�I�ɎR�n�̗��ƎQ�w��',30,29,24,NULL,NULL,NULL,NULL,NULL,2004,'�����I�i�ρA2016�N�Ɍy���ȕύX','0','2018-09-30 21:02:50','2018-09-17 06:00:00'),(11,1,'/heritageKataoka/iwamiginzan.jpeg\r\n','�Ό���R��ՂƂ��̕����I�i��',32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2007,'�����I�i�ρA�Y�ƈ�Y�A2010�N�̌y���ȕύX','0','2018-09-30 21:02:59','2018-09-17 06:00:00'),(12,1,'/heritageKataoka/hiraizumi.jpeg\r\n','����\�����y�i��y�j��\�����z�E�뉀�y�эl�Êw�I��ՌQ�\',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2011,NULL,'0','2018-09-30 21:03:15','2018-09-17 06:00:00'),(13,1,'/heritageKataoka/mtFuji.jpeg\r\n','�x�m�R�\�M�̑Ώۂƌ|�p�̌���',22,19,NULL,NULL,NULL,NULL,NULL,NULL,2013,NULL,'0','2018-09-30 21:03:10','2018-09-17 06:00:00'),(14,1,'/heritageKataoka/tomiokaseisijyo.jpeg\r\n','�x��������ƌ��Y�ƈ�Y�Q',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2014,'�Y�ƈ�Y�A�ߑ㉻��Y','0','2018-09-30 21:03:20','2018-09-17 06:00:00'),(15,1,'/heritageKataoka/meijiRevol.jpg\r\n\r\n','�������{�̎Y�Ɗv����Y ���S�E���|�A���D�A�ΒY�Y��',35,40,41,42,43,46,3,22,2015,'�Y�ƈ�Y�A�ߑ㉻��Y�A�ғ���Y','0','2018-09-30 21:09:12','2018-09-17 06:00:00'),(16,1,'/heritageKataoka/luColuvu.jpeg\r\n','���E�R���r���W�G�̌��z��i-�ߑ㌚�z�^���ւ̌����ȍv��-',13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2016,'���㌚�z�A�������z���鐢�E��Y','0','2018-09-30 21:03:30','2018-09-17 06:00:00'),(17,1,'/heritageKataoka/okinoshima.jpeg\r\n','�u�_�h�铇�v�@���E���m���Ɗ֘A��Y�Q',40,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2017,NULL,'0','2018-09-30 21:03:34','2018-09-17 06:00:00'),(18,1,'/heritageKataoka/nagasaki.jpeg\r\n','����ƓV���n���̐����L���V�^���֘A��Y',42,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2018,NULL,'0','2018-09-30 21:03:39','2018-09-17 06:00:00'),(19,2,'/heritageKataoka/yakushima.jpeg\r\n','���v��',46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,'���v�����������A���v���������R���ۑS�n��','0','2018-09-30 21:03:46','2018-09-17 06:00:00'),(20,2,'/heritageKataoka/mtSirakami.jpeg\r\n','���_�R�n',2,5,NULL,NULL,NULL,NULL,NULL,NULL,1993,'���_�R�n���R���ۑS�n��A','0','2018-09-30 21:03:52','2018-09-17 06:00:00'),(21,2,'/heritageKataoka/siretoko.jpeg\r\n','�m��',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2005,'�m�����������A�����ʊx�������R���ۑS�n��','0','2018-09-30 21:03:57','2018-09-17 06:00:00'),(22,2,'/heritageKataoka/ogasawara.jpg\r\n\r\n','���}������',13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2011,'���}�����������A�연�����������R���ۑS�n��','0','2018-09-30 21:08:48','2018-09-17 06:00:00');
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
INSERT INTO `hometown_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'�k�C��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'�X��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'��茧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'�{�錧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'�H�c��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'�R�`��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'������','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'��錧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'�Ȗ،�','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'�Q�n��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'��ʌ�','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'��t��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'�����s','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'�_�ސ쌧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'�V����','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'�x�R��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'�ΐ쌧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'���䌧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(19,'�R����','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(20,'���쌧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(21,'�򕌌�','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(22,'�É���','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(23,'���m��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(24,'�O�d��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(25,'���ꌧ','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(26,'���s�{','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(27,'���{','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(28,'���Ɍ�','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(29,'�ޗǌ�','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(30,'�a�̎R��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(31,'���挧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(32,'������','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(33,'���R��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(34,'�L����','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(35,'�R����','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(36,'������','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(37,'���쌧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(38,'���Q��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(39,'���m��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(40,'������','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(41,'���ꌧ','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(42,'���茧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(43,'�F�{��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(44,'�啪��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(45,'�{�茧','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(46,'��������','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(47,'���ꌧ','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
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
INSERT INTO `location_kataoka` VALUES (0,'','0','2018-09-26 23:49:26','2018-09-17 06:00:00'),(1,'�k�C��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(2,'�X��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(3,'��茧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(4,'�{�錧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(5,'�H�c��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(6,'�R�`��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(7,'������','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(8,'��錧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(9,'�Ȗ،�','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(10,'�Q�n��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(11,'��ʌ�','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(12,'��t��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(13,'�����s','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(14,'�_�ސ쌧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(15,'�V����','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(16,'�x�R��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(17,'�ΐ쌧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(18,'���䌧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(19,'�R����','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(20,'���쌧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(21,'�򕌌�','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(22,'�É���','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(23,'���m��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(24,'�O�d��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(25,'���ꌧ','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(26,'���s�{','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(27,'���{','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(28,'���Ɍ�','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(29,'�ޗǌ�','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(30,'�a�̎R��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(31,'���挧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(32,'������','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(33,'���R��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(34,'�L����','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(35,'�R����','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(36,'������','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(37,'���쌧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(38,'���Q��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(39,'���m��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(40,'������','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(41,'���ꌧ','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(42,'���茧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(43,'�F�{��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(44,'�啪��','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(45,'�{�茧','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(46,'��������','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(47,'���ꌧ','0','2018-09-17 06:00:00','2018-09-17 06:00:00');
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
INSERT INTO `location_takehara` VALUES (0,'','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(1,'�铌','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'�鐼','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'���','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'��k','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'���ޖ���','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
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
INSERT INTO `maker_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'ANCHOR�i�A���J�[�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'ARGON18(�A���S��18�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'Bianchi�i�r�A���L�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'BH(�r�[�G�C�`)','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'BMC(�r�[�G���V�[�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'BOMA�i�{�[�}�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'CANYON�i�L���j�I���j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'cervelo�i�T�[���F���j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'CIPOLLINI�i�`�b�|���[�j�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'COLNAGO�i�R���i�S�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'CUBE BIKES�i�L���[�u�o�C�N�X�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'DIAMOND BIKES�i�_�C�A�����h�o�C�N�X�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'EDDYMERCKX�i�G�f�B�����N�X�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'FACTOR�i�t�@�N�^�[�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'FELT�i�t�F���g�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'FUJI�i�t�W�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'GIANT�i�W���C�A���g�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'KhodaaBloom�i�R�[�_�[�u���[���j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'KUOTA�i�N�I�[�^�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'MERIDA�i�����_�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'PINARELLO�i�s�i�����j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'RIDLEY�i���h���[�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'SCOTT�i�X�R�b�g�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'SPECIALIZED�i�X�y�V�����C�Y�h�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'TREK�i�g���b�N�j','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'Wilier�i�E�B���G�[���j','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
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
INSERT INTO `movie_actor` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'�g���E�n���N�X',0,'2017/11/08','2017/11/08'),(2,'�g�r�[�E�}�O���C�A',0,'2017/11/08','2017/11/08'),(3,'�W�F�[���Y�E�}�J���H�C',0,'2017/11/08','2017/11/08'),(4,'�i�^���[�E�|�[�g�}��',0,'2017/11/08','2017/11/08'),(5,'�A���E�n�T�E�F�C',0,'2017/11/08','2017/11/08');
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
INSERT INTO `movie_main` VALUES (1,'�X�p�C�_�[�}��3',1,2,2007,155,'�X�p�C�_�[�}���̉f��̒��ł͈�ԍD��',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN�a����b�A�΂��ڂ��ʔ����B',0,'2017-11-08 00:00:00','2020-03-23 09:45:36'),(3,'���I��',1,4,1994,110,'�}�`���_�����킢��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'�_�[�N�i�C�g���C�W���O',1,5,2012,165,'DC�R�~�b�N�撣��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'�x�C�r�[�h���C�o�[',1,NULL,2017,113,'���҂����삳��邻��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'�g�����X',2,3,2013,101,'�_�j�[�E�{�C���ē�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'�t�B���X',2,3,2013,97,'�X�R�b�g�����h�̍ň��Y��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'�ؗ�Ȃ�M���c�r�[',2,2,2013,143,'���؈��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'�u���b�W�I�u�X�p�C',2,1,2015,144,'�A�J�f�~�[�����j�D�܎��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'�_�E���B���`�E�R�[�h',2,1,2006,174,'�I�h���C�E�g�g�D�V�����Ȃ�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'�t�H���X�g�K���v',3,1,1994,142,'���킸�ƒm�ꂽ�����̕��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'���S�Ȃ�`�F�b�N���C�g',3,2,2014,116,'�{�r�[�t�B�b�V���[',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'���̍��l���',3,2,2001,90,'�Ⴉ�肵�f�B�J�v���I',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'���~�[���u��',3,5,2012,160,'�̕����̓A�e���R�ł͂���܂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'�O���[���}�C��',3,1,1999,189,'�w�V���[�V�����N�̋�Ɂx�������ł�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'�u���b�N�X����',4,4,2011,108,'����ȃz���[���|������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TV���[�r�[�҂��ǂ���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'�L�����[',4,NULL,1976,98,'�X�e�B�[�u���E�L���O�̏�����',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'�X�v���b�g',4,3,2017,117,'�V���}������i�����Ă����Ƌg',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'�~�X�^�[�K���X',4,3,2019,129,'�X�v���b�g�̑���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'�}�C�E�C���^�[��',5,5,2015,121,'�w�v���_�𒅂������x����������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'�^�[�~�i��',5,1,2004,128,'��`�ɏZ��ł݂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'�y�l���s',5,3,2008,104,'����̂��Ƃ��b',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'�A���X�C�������_�[�����h',5,5,2010,113,'�f����������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'�L���b�c���h�b�O�X',5,2,2001,87,'���͂��킢��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'���Ȃ�',NULL,3,2007,130,'�A�T�Ȏ��ɂ͂������߂��܂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'�v���C�h�ƕΌ�',NULL,NULL,2005,135,'�R�����E�t�@�[�X�̃h���}�ł��ǂ�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'�O���C�e�X�g�V���[�}��',3,NULL,2017,105,'�l�I�Ƀ��E���E�����h�z��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'�r�b�O',5,1,1988,130,'�f�G�ȋC���ɂȂ��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'�₽�獋�؂Ȕo�D�w',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
INSERT INTO `music` VALUES (4,'�S��?','�C??',5,'�N���?�v?�I���́C���N�k���s�C?�݈ˑR�L�k���l��?�B',3,'https://www.youtube.com/embed/ZSWeurc1yMw','2018-03-19 15:12:14','2018-03-19 15:12:14',5),(9,'�Y�m?�C����?','����',5,'',3,'https://www.youtube.com/embed/hNQohQBFnwI','2018-03-19 16:05:12','2018-03-19 16:05:12',2),(10,'��̉�','��������',5,'',6,'https://www.youtube.com/embed/mF5Qq2YheTg','2018-03-19 17:18:19','2019-03-28 15:26:31',2),(11,'MY ALL','�_��?',5,'',5,'https://www.youtube.com/embed/PKptgq8jTYw','2018-03-19 17:27:07','2018-03-19 17:27:07',1),(12,'Time after time �`�ԕ����X�Ł`','?�ؖ���',5,'',4,'https://www.youtube.com/embed/Ep_W5rYXyi0','2018-03-19 17:28:57','2018-03-19 17:28:57',1),(13,'���I�y�H','�����q',5,'',6,'https://www.youtube.com/embed/Vn6xGeMY9w8','2018-03-19 17:31:46','2018-03-19 17:31:46',1),(14,'big big world','Emilia',5,'',5,'https://www.youtube.com/embed/wpkS2DU_qMs','2018-03-19 17:33:04','2018-03-19 17:33:04',0);
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
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0：有効　1：無効',
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
INSERT INTO `penguin_main_kawamura` VALUES (1,'�R�E�e�C�y���M��',1,'��ɑ嗤���ӂ̒蒅�X��ɐ����@�̂̑傫��No.1�i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�R�E�e�C_penguin.jpg','0','2019-12-03 15:08:00','2020-03-23 10:08:48'),(2,'�L���O�y���M��',1,'����ɂ̓��X�ɐ����i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�L���O_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(3,'�A�f���[�y���M��',2,'��ɑ嗤�̉��݈�A���ӂ̓��X�ɐ����@IC�J�[�hSuica�̃��f���ɂȂ����y���M���i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�A�f���[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(4,'�W�F���c�[�y���M��',2,'��ɑ嗤�̕X�̒����Ă��Ȃ��n��A����ɂ̓��X�ɐ����@�B�ꑫ�̐F���I�����W�̃y���M���@�j���̑���No.1�i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�W�F���c�[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(5,'�q�Q�y���M��',2,'��ɔ����ɐ����@�i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�q�Q_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(6,'�K���p�S�X�y���M��',3,'�K���p�S�X�����ɐ����@�t���{���g�y���M�����̒��ł����΂��ׂ̍�No.1�i���{�ł͌���Ȃ��j','/penguinKawamura/�K���p�S�X_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(7,'�P�[�v�y���M��',3,'��A�t���J���a���̉��ݕ��ɐ����@�A�t���J�ɐ�������y���M���̓P�[�v�y���M�������i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�P�[�v_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(8,'�t���{���g�y���M��',3,'�t���{���g�C����������A�����J�����ɐ����@�����̂����@���{�Ŏ��琔No.1�̃y���M���i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�t���{���g_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(9,'�}�[�����y���M��',3,'�`���E�A���[���`���E�t�H�[�N�����h�����ɐ����@�v�w�̒��̗ǂ�No.1�i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�}�[����_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(10,'�t�B�����h�����h�y���M��',4,'�t�B�����h�n��E�I�[�N�����h�����E�X�`�����[�g���Ȃǂɐ����i���{�ł͌���Ȃ��j','/penguinKawamura/�t�B�����h�����h_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(11,'�V�����[�^�[�y���M��',4,'�o�E���e�B�����E�I�[�N�����h�����E�}�b�R���[���Ȃǂɐ����i���{�ł͌���Ȃ��j','/penguinKawamura/�V�����[�^�[_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(12,'�X�l�A�[�Y�y���M��',4,'�X�l�A�[�Y��(�j���[�W�[�����h�̓�Ɉʒu���铇)�ɐ����i���{�ł͌���Ȃ��j','/penguinKawamura/�X�l�A�[�Y_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(13,'�}�J���j�y���M��',4,'�`���̓암�E�吼�m����C���h�m�ɂ����Đ����@�y���M���̒��Ō̐�No.1�i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�}�J���j_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(14,'���C�����y���M��',4,'�I�[�X�g�����A�E�j���[�W�[�����h�E�}�b�R���[���ɐ����i���{�ł͌���Ȃ��j','/penguinKawamura/���C����_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(15,'�C���g�r�y���M��',4,'�T�E�X�V�F�g�����h�����E�L�����x�����Ȃǂɐ����i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�C���g�r_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(16,'�L�K�V���y���M��',5,'�j���[�W�[�����h�ɐ����@�y���M���ނ̒��Ő��̏��Ȃ�No1�i���{�ł͌���Ȃ��j','/penguinKawamura/�L�K�V��_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(17,'�R�K�^�y���M��',6,'�j���[�W�[�����h�E�I�[�X�g�����A�̓�݂ɐ����@�̂̏�����No.1�i���{�̐����قŌ��鎖���o����j','/penguinKawamura/�R�K�^_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(18,'�V���c�o�T�y���M��',6,'�o���N�X�����E���g�i�E���ɐ����@�i���{�ł͌���Ȃ��j','/penguinKawamura/�V���c�o�T_panguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00');
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
INSERT INTO `perfume_main_anzai` VALUES (1,'OMAJINAI���y����',2002,'�p�b�p���[�͍�',NULL,NULL,'�L������̃f�r���[��','0','2019-10-29 00:00:00','2019-11-06 13:04:05'),(2,'�ގ���W��',2002,'�p�b�p���[�͍�',NULL,NULL,'�L������̖���','0','2019-10-29 00:00:00','2019-11-06 10:34:05'),(3,'�X�E�B�[�g�h�[�i�b�c',2003,'�؂̎q',1,NULL,'�S���C���f�B�[�Y�f�r���[��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'�r�^�~���h���b�v',2004,'�؂̎q',1,NULL,'������鎖�̂Ȃ��A�C�h����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'���m�N���[���G�t�F�N�g',2004,'�؂̎q',1,NULL,'������鎖�̂Ȃ��A�C�h����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'���j�A���[�^�[�K�[��',2005,'���c���X�^�J',1,NULL,'���W���[�f�r���[�̋�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'�G���N�g���E���[���h',2006,'���c���X�^�J',1,NULL,'���C�u�ł݂͂�ȂŐ���オ��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'�p�[�t�F�N�g�X�^�[�E�p�[�t�F�N�g�X�^�C��',2006,'���c���X�^�J',1,NULL,'�����������ꂽ�A���o���̗B��̐V��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'�`���R���C�g�E�f�B�X�R',2007,'���c���X�^�J',2,NULL,'�o�����^�C����ԋ�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Twinkle Snow Powdery Snow',2007,'���c���X�^�J',2,NULL,'�`���R���C�g�f�B�X�R�ƈꏏ���\���ꂽ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(11,'�|�����Y��',2007,'���c���X�^�J',2,1,'���̋ȂŔ����I�q�b�g','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(12,'SEVENTH HEAVEN',2007,'���c���X�^�J',6,NULL,'�����������킢��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(13,'Baby cruising Love',2008,'���c���X�^�J',2,3,'�f��u���e�L�v�Ŏg�p','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(14,'�}�J���j',2008,'���c���X�^�J',2,NULL,'�~�ɂ��X�X���̈��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(15,'GAME',2008,'���c���X�^�J',2,NULL,'�A���o���ȁA�_���X���߂��Ⴍ���Ⴉ��������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(16,'�Z���~�b�N�K�[��',2008,'���c���X�^�J',2,2,'�[��h���}�Ŏg���Ă���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(17,'�V�[�N���b�g�V�[�N���b�g',2008,'���c���X�^�J',2,1,'�A�C�X�u�s�m�v��CM�������C������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(18,'Puppy love',2008,'���c���X�^�J',2,NULL,'�݂�Ȃŏ㉺���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(19,'edge',2008,'���c���X�^�J',3,NULL,'�������������߂��Ⴍ����Ȃ�����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(20,'love the world',2008,'���c���X�^�J',3,NULL,'���m�N����PV���a�V','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(21,'Dream Fighter',2008,'���c���X�^�J',3,NULL,'���߂Ă̕����قŔ��\���ꂽ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(22,'�������[���E�f�B�X�R',2009,'���c���X�^�J',3,NULL,'�V���������\���O','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(23,'I still love U',2009,'���c���X�^�J',3,NULL,'���ڂ��Ȃ���PV�B������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(24,'NIGHT FLIGHT',2009,'���c���X�^�J',3,1,'������u�s�m�v��CM�̋�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(25,'�i�`�������ɗ�����',2010,'���c���X�^�J',4,1,'�A�p������CM��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(26,'VOICE',2010,'���c���X�^�J',4,1,'PV�̍Ōカ�ꂢ�ɂ͂܂�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(27,'FAKE IT',2010,'���c���X�^�J',6,NULL,'���C�u���Ԃ��オ���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(28,'�˂�',2010,'���c���X�^�J',5,1,'�A�p������CM�ȁA�_���X�̃X�e�b�v���Ɠ�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(29,'�����ȃJ�I��',2011,'���c���X�^�J',5,1,'�u�X���v��CM�@����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(30,'���[�U�[�r�[��',2011,'���c���X�^�J',5,1,'�u�X���v��CM�@����������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(31,'GLITTER',2011,'���c���X�^�J',5,1,'�u�X���v��CM�@����������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(32,'�X�p�C�X',2011,'���c���X�^�J',5,2,'�u�X���v��CM�@����������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(33,'MY COLOR',2011,'���c���X�^�J',5,NULL,'���E�ł������ꂽ���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(34,'�R�~���j�P�[�V����',2012,'���c���X�^�J',NULL,1,'�v���v�����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(35,'Spring of Life',2012,'���c���X�^�J',7,1,'�ߑ�������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(36,'Hurly Burly',2012,'���c���X�^�J',10,1,'�|�b�v�ȃ_���X�i���o�[','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(37,'Spending all my time',2012,'���c���X�^�J',7,1,'�C�O�i�o����ۂɏo������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(38,'��������΂Ȃ�',2013,'���c���X�^�J',7,NULL,'�̂������C���Ƃ΂�����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(39,'�����̃~���[�W�A��',2013,'���c���X�^�J',7,3,'�f��u�h��������v�̎���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(40,'Magic of Love',2013,'���c���X�^�J',7,1,'�u�s�����O�~�v��CM�N�p','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(41,'Handy Man',2013,'���c���X�^�J',7,NULL,'�̂������C�O�Ő���ɊԈႦ����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(42,'�ӂ肩����Ƃ����',2013,'���c���X�^�J',7,NULL,'�H��̋�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(43,'Party Maker',2013,'���c���X�^�J',7,NULL,'����オ���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(44,'1mm',2013,'���c���X�^�J',7,NULL,'�ŏI�d�Ԃɗh���Ă�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(45,'Sweet Refrain',2013,'���c���X�^�J',8,2,'���V�܂��ݎ剉�h���}�̎���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(46,'���͑O�X�p��',2013,'���c���X�^�J',8,NULL,'�܂��̂߂�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(47,'Cling Cling',2014,'���c���X�^�J',8,1,'�V���O���Ȃ̂�CD�����Ȃ�傫��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(48,'�������ȃn���[',2014,'���c���X�^�J',NULL,NULL,'Cling�@Cling�@�̃J�b�v�����O','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(49,'DISPLAY',2014,'���c���X�^�J',10,1,'�SK�e���r��CM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(50,'Hold Your Hand',2014,'���c���X�^�J',8,2,'�t�@���ƍ����PV����ۓI','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(51,'Pick Me Up',2015,'���c���X�^�J',8,1,'�ɐ��O�Ƃ̃R���{','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(52,'Relax In The City',2015,'���c���X�^�J',8,1,'�V���O���Ȃ̂�CD�����Ȃ�傫����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(53,'TOKIMEKI LIGHTS',2015,'���c���X�^�J',8,NULL,'�D���ȋȂ�����ۂ�����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(54,'STAR TRAIN',2015,'���c���X�^�J',8,3,'15�N�̂��ׂĂ��l�ߍ��񂾋�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(55,'FLASH',2016,'���c���X�^�J',8,3,'�f��u���͂�ӂ�v�Ŏg�p���ꂽ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(56,'STORY',2016,'���c���X�^�J',8,1,'docomo�̊���4G���g�������o������������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(57,'Next Stage with YOU',2016,'���c���X�^�J',8,1,'�x���cCM�ɋN�p','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(58,'Miracle Worker',2016,'���c���X�^�J',8,NULL,'�Ȃ̓r���́u�������~���R�[�v�������I','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(59,'Cosmic Explorer',2016,'���c���X�^�J',8,NULL,'�A���o�����߂̋ȁB','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(60,'TOKYO GIRL',2017,'���c���X�^�J',9,2,'�g���R���q�剉�h���}�̎���','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(61,'��΂̉J',2017,'���c���X�^�J',9,1,'�Ora2� TV CM�\���O','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(62,'Everyday',2017,'���c���X�^�J',9,1,'�upnasonic�v�̐���@��CM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(63,'If you wanna',2017,'���c���X�^�J',9,NULL,'�t���[�`���[�x�[�X�������ꂽ��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(64,'��������',2018,'���c���X�^�J',9,3,'�f��u���͂�ӂ�v�Ŏg�p���ꂽ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(65,'Let Me Know',2018,'���c���X�^�J',9,NULL,'PV������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(66,'�V��',2018,'���c���X�^�J',9,1,'docomo��CM�Ŏg�p�A2019�N�ŏ��ɔ�I������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(67,'Tiny Baby',2018,'���c���X�^�J',9,NULL,'���C�u���o��������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(68,'Future Pop',2018,'���c���X�^�J',9,NULL,'2019�N�g���Ŕ�I������','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(69,'�i�i�i�i�i�C��',2019,'���c���X�^�J',10,1,'�����e�[�}�Ƃ�����','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(70,'Challenger',2019,'���c���X�^�J',10,NULL,'���c���X�^�J�Ƃ̏o��̋�','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(72,'Perfume',2006,'',NULL,NULL,'','0','2019-11-06 14:01:10','2019-11-06 14:01:10');
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
INSERT INTO `residents_main_sato` VALUES (1,'�n���i',1,2,'�S�g���Ԃ��A��ɃO���[�̂Ԃ��͗l������B���Ƀs�A�X��t���Ă���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(2,'���b�L�[',1,1,'�S�g����тŊ�����Ă��āA��͕�т̌��Ԃ���Жڂ��������Ă���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(3,'�q���N�p�[',2,2,'�t���ς������݂���̂悤�Ȋ�B��̂ԂԂ������A��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(4,'�W���b�N',2,1,'�ዾ�������Ă��蕞�̓X�[�c�B���E�̖ڂ̐F���Ⴄ','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(5,'�r�X',3,1,'�ڂ��r�X�̂悤�ɏ\���}�[�N�ɂȂ��Ă���B��ԍD���ȏZ��','0','2020-05-28 00:00:00','2020-06-17 09:30:09'),(6,'�_���}��',3,1,'�Ԃ��ڂƉ��F�����т������I�B�������Ȉ��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(7,'�P�`���b�v',4,2,'�g�}�g�̂悤�ɓ��ɗt���ς����Ă���A�S�g���Ԃ�','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(8,'�s�[�^��',4,1,'�S�g�����F��2���قǑO���̂悤�Ȃ��̂�����B�ڂ��傫��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(9,'�N���X�`�[�k',5,2,'�s���N�Ɣ��̐��ʂ̓��Ђ������悤�Ȍ����ځB�ڂ��ς����肵�Ă���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(10,'�v�[�X�P',5,1,'�㓪���ɕ����ւ̋�C���̂悤�Ȃ��̂�����B�Ƃڂ����悤�Ȋ炪���킢��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(11,'��悢',5,2,'�͂ɂ�̂悤�Ɍ��Ɩڂ��ۂ�����󂢂Ă���B�\��ɕω����Ȃ�','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(12,'�h�N',6,1,'���̒ʂ�h�N�K�G���̂悤�ȐF�����Ă��邪��͂��킢��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(13,'�t�����^��',6,1,'�S�g���ʕ��B�т����肵���悤�Ȗڂ����Ă���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(14,'�����ւ���',7,1,'���т��C�ۂ̂悤�ɑ����A�ڂ̓^���ڂł������Ă���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(15,'�^���^��',7,2,'�����������s���N�ɂȂ����p���_�̂悤�Ȍ�����','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(16,'�p�b�`',8,1,'�ڂ��~��B�p���͂���������ʂ�����݊��������Ă��킢��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(17,'�݂���',8,2,'�ڂ��L���L�����ʖт������B�s���N�Ɛ��F�̃O���f�[�V���������ꂢ','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(18,'�p�e�B',9,2,'�p��䕂œ��ɐ��N���[���̂悤�Ȃ��̂�����Ă���\r\n','0','2020-05-28 00:00:00','2020-06-17 09:30:41'),(19,'�l���\��',10,1,'�p���ȁX�ł������Ȍ`�����Ă���B����','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(20,'�W�F�V�J',10,2,'��̓s���N�ŉ��F���O���B�s�A�X��t���Ă���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(21,'�e�B�[�i',11,2,'��̓e�B�[�|�b�g��͂��Ă���A���������@�̕����ɂȂ��Ă���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(22,'�p���N�X',11,1,'�S�g���Ԃ��A�ڂ����s���B���̒ʂ�p���N�ȕ��͋C','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(23,'�^�R��',12,1,'�����ڂƖ��O���炵�Ċ��S�ɂ����Ă��B���ɒܗk�}���h�����Ă���','0','2020-05-28 00:00:00','2020-06-16 14:30:09'),(24,'�^�R���[�i',12,2,'�s���N�F�łق��؂����F�B�܂��̃J�[��������킢��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(25,'�����܂�',13,2,'�g�̂̓s���N�Ɣ��B�ق��؂������܂��͗l','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(26,'�䂫��',14,2,'���F�̂܂���B�����ۂ��Ă�Ƃ����g�̂����킢��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(27,'�W���y�b�e�B',15,1,'�s�G���̂悤�Ȋ�����Ă���B�̂��J���t��','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(28,'���Ⴟ��܂�',15,1,'�ڂ��L���L���őO����������B���߂Ȃ���','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(29,'�X�p�[�N',16,1,'���ɗ��̖͗l�����Ă���B�S�g�͎��F','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(30,'�~���g',16,2,'���̒ʂ�~���g�F�B���ʖт���ۓI','0','2020-05-28 00:00:00','2020-05-28 00:00:00');
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
INSERT INTO `resipe_main_ishikawa` VALUES (1,'�J���[','����[',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'�N���[���V�`���[','����[�ނ�����[',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'�����Ⴊ','�ɂ����Ⴊ',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'���[���L���x�c','��[�邫��ׂ�',3,4,2,50,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'�|�g�t','�ۂƂ�',2,3,3,30,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'���؃~���t�B�[��','�͂������݂�ӂ��[��',5,0,2,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'�|��','���Ԃ�',1,3,2,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'�Ė�؃O���^��','�Ȃ₳�����炽��',7,8,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'�݂����','�݂���Ȃ�',5,11,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'����҂�','����҂�',1,10,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'�s�[�}���̓��l��','�ҁ[�܂�̂ɂ��Â�',3,6,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'�n���o�[�O','�͂�΁[��',3,0,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'�e�q��','���₱�ǂ�',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(14,'⡂��͂�','�����̂����͂�',12,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(15,'����','���イ�ǂ�',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(16,'���ڂ���̎ϕ�','���ڂ���̂ɂ���',9,0,3,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(17,'�؏`','�Ƃ񂶂�',1,3,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(18,'�I����','���育�͂�',13,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(19,'�|�e�g�T���_','�ۂĂƂ��炾',2,3,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(20,'�i�|���^��','�Ȃۂ肽��',6,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(21,'���^�g����','�炽�Ƃ���',7,8,3,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(22,'�r�V�\���[�Y','�т�����[��',2,0,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(23,'�g�}�g��','�Ƃ܂Ƃ�',3,7,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(24,'�|���h�[��','�ۂ��ǁ[��',7,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
INSERT INTO `sex_ito` VALUES (0,NULL,'0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'�j��','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'����','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'�j��','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
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
INSERT INTO `sex_sato` VALUES (0,NULL,'0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(1,'�j','0','2020-05-28 00:00:00','2020-05-28 00:00:00'),(2,'��','0','2020-05-28 00:00:00','2020-05-28 00:00:00');
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
INSERT INTO `team_color_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'�s���N','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'�I�����W','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'���F','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'����','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'���F','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'��','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
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
INSERT INTO `team_main_matsuda` VALUES (1,'�T���t���b�`�F�L��',34,1,'���X����','3�o�b�N�̗v','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'�����C�\��',12,4,'�����q��','�S��','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'FC����',13,7,'���J��','���g�I�T�C�h�o�b�N','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'�Y�a���b�Y',11,1,'�����T�O','�S�[���O�̎d���l','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'�K���o���',27,7,'�����ېm','�p�X�R�[�X360�x','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'�Z���b�\���',27,2,'�`�J�j��N','�~�X�^�[���[�e�B���e�B','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'�x�K���^���',4,3,'�ԍ�G��','�x�K���^�̐؂�D','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'���lFC',14,6,'�����r��','���W�F���h���t�e�B�[','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'���É��O�����p�X',23,3,'���n�E�I','�T���u���b�g�v���C���[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'���B�b�Z���_��',28,9,'�A���h���X�@�C�j�G�X�^','THE SOCCER','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'���t�����^�[��',14,6,'�ƒ�����','�Z�I�h���t�e�B�[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'�T�K������',31,6,'�����G�l','�Q�[�����C�J�[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'�Ó�x���}�[��',14,5,'�R�c���P','�Ԃ��Ă����V��','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'���lF�E�}���m�X',14,7,'����P�l','�n�}�̃X�s�[�h�X�^�[','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'�啪�g���j�[�^',44,6,'��c�q�P','�g���j�[�^�̊�','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'�k�C���R���T�h�[���D�y',1,1,'�`���i�e�B�b�v','�^�C�̃��b�V','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'�����G�X�p���X',22,3,'���c�I��','�����̐�','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'�����A���g���[�Y',8,1,'�O�}���l','�������^�{�����`','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
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
INSERT INTO `tieup_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'CM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'�h���}','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'�f��','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
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
INSERT INTO `tokyo_main_takehara` VALUES (1,'���c','/tokyoTakehara/chiyoda.jpg',5,64533,11.66,'��i��',784,6330721,'���؊��','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'����','/tokyoTakehara/chuo.png',1,163185,10.21,'�V�x��',556,8219777,'��ѐ���','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'�`','/tokyoTakehara/minato.png',3,258075,20.37,'���',902,3611975,'�֍���','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'�V�h','/tokyoTakehara/shinjuku.png',2,347661,18.22,'�V�h����',477,3263794,'���[���','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'����','/tokyoTakehara/bunkyo.png',4,232801,11.29,'��y��',544,1181450,'��X���^','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(6,'�䓌','/tokyoTakehara/taito.png',1,206816,10.11,'���',385,1376259,'�V�C�S��','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(7,'�n�c','/tokyoTakehara/sumida.png',1,268192,13.77,'��',350,589458,'��|���','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(8,'�]��','/tokyoTakehara/koto.png',1,516636,40.16,'���z��',389,583708,'���c���D','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(9,'�i��','/tokyoTakehara/shinagawa.png',3,407084,22.84,'���_��',427,1160600,'��������','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(10,'�ڍ�','/tokyoTakehara/meguro.png',3,286462,14.67,'���ڍ�',537,1195400,'��J������','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(11,'��c','/tokyoTakehara/ota.png',3,737700,60.83,'���c',395,627693,'�Ћ˂͂���','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(12,'���c�J','/tokyoTakehara/setagaya.png',2,933708,58.05,'���c�J',506,690153,'����M��','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(13,'�a�J','/tokyoTakehara/shibuya.png',2,233060,15.11,'�a�J',703,4234271,'�g�i���S��','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(14,'����','/tokyoTakehara/nakano.png',2,328215,15.59,'����',387,812547,'�c���T��','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(15,'����','/tokyoTakehara/suginami.png',2,582864,34.06,'�숢�����J',436,617023,'���c����','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(16,'�L��','/tokyoTakehara/toshima.png',4,300512,13.01,'���r��',412,1147581,'�R���B�Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(17,'�k','/tokyoTakehara/kita.png',4,352806,20.61,'���q',344,657836,'�Êڈɒm�Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(18,'�r��','/tokyoTakehara/arakawa.png',4,217692,10.16,'�r��񒚖�',345,605586,'�Љ��ߑ��Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(19,'��','/tokyoTakehara/itabashi.png',4,581066,32.22,'��������O',350,475214,'��_��Y','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(20,'���n','/tokyoTakehara/nerima.png',2,737906,48.08,'���n',395,435136,'��ˍ�','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(21,'����','/tokyoTakehara/adachi.png',4,681309,53.25,'�~��',324,367663,'�r�[�g������','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(22,'����','/tokyoTakehara/katsushika.png',1,453522,34.8,'���V���t��',333,362640,'��{�a��','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(23,'�]�ː�','/tokyoTakehara/edogawa.png',1,693519,49.9,'�V����',346,392703,'���肵����','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
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
INSERT INTO `triathlon_main_mori` VALUES (1,'RS9s',1,1,800000,'/TriathlonMori/001.jpg','0','2020-03-11 00:00:00','2020-03-23 15:02:09'),(2,'RT9',2,1,410000,'/TriathlonMori/002.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'GALLIUM PRO',1,2,380000,'/TriathlonMori/003.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'E-119 TRI+',2,2,576000,'/TriathlonMori/004.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'OLTRE XR4',1,3,1780000,'/TriathlonMori/005.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'AQUILA CV',2,3,900000,'/TriathlonMori/006.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'G8 PRO',1,4,748000,'/TriathlonMori/007.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'AEROLIGHT',2,4,1050000,'/TriathlonMori/008.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'Timemachine Road 01',1,5,880000,'/TriathlonMori/009.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'Timemachine 01',2,5,870000,'/TriathlonMori/010.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'VIDE pro CT-RTV',1,6,500000,'/TriathlonMori/011.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'SWOOP CT-TT',2,6,418000,'/TriathlonMori/012.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'Ultomate CF Evo',1,7,899000,'/TriathlonMori/013.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'Speedmax CF SLX LTD',2,7,1109000,'/TriathlonMori/014.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'S5',1,8,1580000,'/TriathlonMori/015.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'P5X',2,8,2280000,'/TriathlonMori/016.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'RB1K \"THE ONE\"',1,9,720000,'/TriathlonMori/017.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'NKTT',2,9,990000,'/TriathlonMori/018.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'C64',1,10,738000,'/TriathlonMori/019.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'K.one',2,10,620000,'/TriathlonMori/020.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'LITENING C:68X SLT',1,11,1176000,'/TriathlonMori/021.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'AERIUM C:68 SLT',2,11,1387000,'/TriathlonMori/022.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'TRILLIANT',2,12,470000,'/TriathlonMori/023.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'CARBONADO',2,12,370000,'/TriathlonMori/024.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'525',1,13,466000,'/TriathlonMori/025.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'LUGANO68',2,13,278000,'/TriathlonMori/026.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(27,'O2 V.A.M',1,14,590000,'/TriathlonMori/027.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(28,'SLICK',2,14,680000,'/TriathlonMori/028.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(29,'FR FRD',1,15,1980000,'/TriathlonMori/029.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(30,'IA FRD',2,15,2480000,'/TriathlonMori/030.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(31,'TRANSONIC 1.1',1,16,340000,'/TriathlonMori/031.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(32,'NORCOM STRAIGHT 1.1',2,16,290000,'/TriathlonMori/032.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(33,'PROPEL ADVANCED SL',1,17,1300000,'/TriathlonMori/033.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(34,'TRINITY ADVANCE PRO 1',2,17,690000,'/TriathlonMori/034.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(35,'STRAUSS PRO',1,18,248000,'/TriathlonMori/035.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(36,'STRAUSS TRI',2,18,199000,'/TriathlonMori/036.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(37,'KHAN',1,19,365000,'/TriathlonMori/037.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(38,'KT05',2,19,460000,'/TriathlonMori/038.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(39,'SCULTURA 10K-E',1,20,1200000,'/TriathlonMori/039.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(40,'TIME WARP TRI 10K-E',2,20,1350000,'/TriathlonMori/040.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(41,'DOGMA F12',1,21,1300000,'/TriathlonMori/041.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(42,'BOLIDE TR+',2,21,1570000,'/TriathlonMori/042.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(43,'HELIUM SLX',1,22,365000,'/TriathlonMori/043.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(44,'DEAN',2,22,323000,'/TriathlonMori/044.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(45,'FOIL PREMIUM',1,23,1118000,'/TriathlonMori/045.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(46,'PLASMA RC',2,23,1190000,'/TriathlonMori/046.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(47,'S-Works VENGE',1,24,1375000,'/TriathlonMori/047.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(48,'S-Works Shiv',2,24,1404000,'/TriathlonMori/048.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(49,'Madone SLR 9',1,25,1281000,'/TriathlonMori/049.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(50,'Speed Concept',2,25,510000,'/TriathlonMori/050.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(51,'ZERO SLR',1,26,590000,'/TriathlonMori/051.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(52,'TURBINE',2,26,650000,'/TriathlonMori/052.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(53,'�����낤',0,0,100,'/TriathlonMori/20200323150234372.jpg','0','2020-03-19 11:02:07','2020-03-23 15:02:34'),(54,'����',1,8,9999999,NULL,'1','2020-03-23 09:12:05','2020-03-23 09:12:05'),(55,'����',1,10,1,'/TriathlonMori/20200323150336788.jpg','0','2020-03-23 15:03:36','2020-03-23 15:03:36');
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
INSERT INTO `type_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'���[�h�o�C�N','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'�^�C���g���C�A���o�C�N�iTT)','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
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
INSERT INTO `vegetable_ishikawa` VALUES (1,'�ɂ񂶂�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'���Ⴊ����','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'���܂˂�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'�L���x�c','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'����','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'�s�[�}��','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'�g�}�g','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'�i�X','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'���ڂ���','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'���ڂ�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'��������','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'�I','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
