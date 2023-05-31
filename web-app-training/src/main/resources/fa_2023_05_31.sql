-- MariaDB dump 10.19  Distrib 10.4.28-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fa
-- ------------------------------------------------------
-- Server version	10.4.28-MariaDB

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
-- Table structure for table `ammo_hagiwara`
--

DROP TABLE IF EXISTS `ammo_hagiwara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ammo_hagiwara` (
  `ammo_id` int(11) NOT NULL AUTO_INCREMENT,
  `ammo` varchar(255) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`ammo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ammo_hagiwara`
--

LOCK TABLES `ammo_hagiwara` WRITE;
/*!40000 ALTER TABLE `ammo_hagiwara` DISABLE KEYS */;
INSERT INTO `ammo_hagiwara` VALUES (1,'',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(2,'Light',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(3,'Heaby',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(4,'Energy',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(5,'SGShells',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(6,'Sniper',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(7,'Etrnal',0,'2023-05-16 15:00:00','2023-05-16 15:00:00');
/*!40000 ALTER TABLE `ammo_hagiwara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anime_main_watanabe`
--

DROP TABLE IF EXISTS `anime_main_watanabe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anime_main_watanabe` (
  `id` int(11) NOT NULL,
  `anime_title` varchar(256) NOT NULL,
  `company_id` int(11) DEFAULT NULL,
  `original_id` int(11) DEFAULT NULL,
  `release_year` int(4) NOT NULL,
  `episode` int(3) NOT NULL,
  `sequel` varchar(256) DEFAULT NULL,
  `op` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anime_main_watanabe`
--

LOCK TABLES `anime_main_watanabe` WRITE;
/*!40000 ALTER TABLE `anime_main_watanabe` DISABLE KEYS */;
INSERT INTO `anime_main_watanabe` VALUES (1,'Fate/Zero',1,2,2011,13,'2��','oath sign','0','2022-05-11 10:03:00','2022-05-19 13:40:06'),(2,'Fate/stay night[Unlimited Blade Works]',1,3,2014,26,'�Ȃ�','ideal white','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(3,'�S�ł̐n�@�}��Y���Y�@���u��',1,1,2019,26,'2���A����A�j��','�g�@��','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(4,'���@�����܂ǂ����}�M�J',2,4,2011,12,'�Ȃ�','�R�l�N�g','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(5,'������',2,2,2009,15,'�U����A�L����Ȃ�','staple stable','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(6,'�j�Z�R�C',2,1,2014,23,'2��','CLICK','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(7,'���[���h�g���K�[',3,1,2014,73,'2���A3��','GIRIGIRI','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(8,'�g���R',3,1,2011,147,'�Ȃ�','�K�c�K�c!!','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(9,'Kanon',3,3,2002,14,'2��','florescence','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(10,'���̓������Ԃ̖��O��l�����͂܂��m��Ȃ��B',4,4,2011,11,'�Ȃ�','���x','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(11,'�\�[�h�A�[�g�E�I�����C��',4,2,2012,26,'2���A3��','crossing field','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(12,'�l���͌N�̉R',4,1,2014,23,'�Ȃ�','����Ȃ�','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(13,'�Ⴆ�Ȃ��ޏ��̈�Ă���',4,2,2015,13,'2���A����A�j��','�N�F�V�O�i��','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(14,'������l�͍��点�����`�V�˂����̗������]��`',4,1,2019,12,'2���A3��','���u�E�h���}�e�B�b�N feat.�Ɍ�����','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(15,'��p����',5,1,2020,24,'����A�j���A2��','�����','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(16,'�]���r�����h�T�K',5,4,2018,12,'2��','�k�ԃl�N���}���V�[','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(17,'�q�P�O���C',5,1,2017,12,'2���A3��','Deal with the devil','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(18,'DEATH NOTE',6,1,2006,37,'�Ȃ�','the WORLD','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(19,'���@�ȍ��Z�̗򓙐�',6,2,2014,26,'2���A3���A4��','Rising Hope','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(20,'�m�[�Q�[���E�m�[���C�t',6,2,2014,12,'�Ȃ�','This game','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(21,'�I�[�o�[���[�h',6,2,2015,13,'2���A3���A4���A����A�j��','Clattanoia','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(22,'�����p���}��',6,1,2015,12,'2��','THE HERO !! �`�{��錝�ɉ΂�����`','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(23,'�F�����������ꏊ',6,4,2018,13,'�Ȃ�','The Girls Are Alright!','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(24,'���{�n���q�̗J�T',7,2,2006,14,'2��','�`���ł���ł���H','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(25,'CLANNAD -�N���i�h-',7,3,2007,24,'2��','���O����','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(26,'��������!',7,1,2009,14,'2��','Cagayake!GIRLS','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(27,'����',7,1,2011,26,'�Ȃ�','�q���_�C���̃J�J�J�^���J�^�I���C-C','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(28,'�X��',7,2,2012,23,'�Ȃ�','�D�����̗��R','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(29,'�������[�t�H�j�A��',7,2,2015,13,'2���A����A�j��','DREAM SOLISTER','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(30,'���@�C�I���b�g�E�G���@�[�K�[�f��',7,2,2018,14,'����A�j��','Sincerely','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(31,'true tears',8,3,2008,13,'�Ȃ�','���t���N�e�B�A','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(32,'Angel Beats!',8,4,2010,15,'�Ȃ�','My Soul, Your Beats!','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(33,'��̂�������',8,4,2013,26,'�Ȃ�','lull�`�����Ėl��́`','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(34,'Charlotte',8,4,2015,14,'�Ȃ�','Bravely You','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(35,'����� Fate/stay night �mHeaven\'s Feel�n I. presage flower',1,3,2017,1,'����ő�Q�́A��R��','�Ԃ̉S','0','2022-05-18 15:04:15','2022-05-19 09:24:32'),(37,'SHIROBAKO',8,4,2014,26,'�����','COLORFUL BOX','0','2022-05-18 15:56:59','2022-05-18 15:56:59');
/*!40000 ALTER TABLE `anime_main_watanabe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apex_main_hagiwara`
--

DROP TABLE IF EXISTS `apex_main_hagiwara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apex_main_hagiwara` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `kind_id` int(11) DEFAULT NULL,
  `ammo_id` int(11) DEFAULT NULL,
  `damage` int(11) DEFAULT NULL,
  `dps` int(11) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apex_main_hagiwara`
--

LOCK TABLES `apex_main_hagiwara` WRITE;
/*!40000 ALTER TABLE `apex_main_hagiwara` DISABLE KEYS */;
INSERT INTO `apex_main_hagiwara` VALUES (2,'VK-47�t���b�g���C��',2,3,18,190,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(3,'�n�{�b�N���C�t��',2,4,18,198,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(4,'R-301�J�[�r��',2,2,14,182,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(5,'�l���V�X',2,4,17,196,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(6,'�v���E���[�o�[�X�gPDW',3,3,15,210,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(7,'�{���gSMG',3,4,17,221,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(8,'R-99SMG',3,2,11,198,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(9,'�I���^�l�[�^�[SMG',3,2,16,176,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(10,'C.A.R,SMG',3,3,13,208,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(11,'M600�X�s�b�g�t�@�C�A',4,2,18,162,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(12,'L-STAR',4,7,16,205,0,'2023-05-16 15:00:00','2023-05-25 11:44:12'),(13,'�f�B�{�[�V����',4,4,15,128,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(14,'�����y�[�WLMG',4,3,26,168,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(15,'�N���[�o�[.50',5,7,140,140,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(16,'�`���[�W���C�t��',5,6,90,90,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(17,'�Z���`�l��',5,6,70,70,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(18,'�����O�{�EDMR',5,6,55,110,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(19,'�s�[�X�L�[�p�[',6,5,9,99,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(20,'���U���r�[�N',6,5,15,135,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(21,'�}�X�e�B�t',6,5,11,88,0,'2023-05-16 15:00:00','2023-05-25 09:02:12'),(22,'EVA-8�I�[�g',6,5,6,126,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(23,'�E�B���O�}��',7,6,45,135,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(24,'RE-45�I�[�g',7,2,12,156,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(25,'P2020',7,2,18,126,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(26,'�g���v���e�C�N',8,4,69,138,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(27,'G7�X�J�E�g',8,2,32,144,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(28,'3030���s�[�^�[',8,3,42,126,0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(29,'�{�Z�b�N�{�E',8,7,60,60,0,'2023-05-16 15:00:00','2023-05-25 09:00:57'),(30,'�w�����b�N�o�[�X�gAR',2,7,23,169,0,'2023-05-25 11:40:06','2023-05-25 11:43:23');
/*!40000 ALTER TABLE `apex_main_hagiwara` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `broadcast_station_ige`
--

LOCK TABLES `broadcast_station_ige` WRITE;
/*!40000 ALTER TABLE `broadcast_station_ige` DISABLE KEYS */;
INSERT INTO `broadcast_station_ige` VALUES (0,NULL,'0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(1,'NHK����','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(2,'���{�e���r','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'�e���r����','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'TBS','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'�t�W�e���r','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(6,'�e���r����','0','2021-05-18 12:00:00','2021-05-18 12:00:00');
/*!40000 ALTER TABLE `broadcast_station_ige` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_tanamachi`
--

DROP TABLE IF EXISTS `class_tanamachi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_tanamachi` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(256) NOT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_tanamachi`
--

LOCK TABLES `class_tanamachi` WRITE;
/*!40000 ALTER TABLE `class_tanamachi` DISABLE KEYS */;
INSERT INTO `class_tanamachi` VALUES (1,'�A�T���g',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(2,'�X�J�[�~�b�V���[',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(3,'�R���g���[���[',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(4,'���R��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(5,'�T�|�[�g',0,'2023-05-16 14:58:00','2023-05-16 14:58:00');
/*!40000 ALTER TABLE `class_tanamachi` ENABLE KEYS */;
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
  `company_image` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_umehara`
--

LOCK TABLES `company_umehara` WRITE;
/*!40000 ALTER TABLE `company_umehara` DISABLE KEYS */;
INSERT INTO `company_umehara` VALUES (0,NULL,NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00',NULL),(1,'ANYCOLOR�������','https://www.anycolor.co.jp/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/ANYCOLOR�������.jpg'),(2,'�J�o�[�������','https://cover-corp.com/',NULL,NULL,2016,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�J�o�[�������.jpg'),(3,'������Њ�{���|�\��','https://rbc-geino.com/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/������Њ�{���|�\��.jpg'),(4,'�ȂȂ��������','https://774.co.jp/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�ȂȂ��������.jpg'),(5,'���̑�',NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���̑�.jpg'),(6,'������',NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/������.jpg');
/*!40000 ALTER TABLE `company_umehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_watanabe`
--

DROP TABLE IF EXISTS `company_watanabe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_watanabe` (
  `id` int(11) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_watanabe`
--

LOCK TABLES `company_watanabe` WRITE;
/*!40000 ALTER TABLE `company_watanabe` DISABLE KEYS */;
INSERT INTO `company_watanabe` VALUES (0,NULL,'0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(1,'ufotable','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(2,'�V���t�g','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(3,'���f�A�j���[�V����','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(4,'A-1 Pictures','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(5,'MAPPA','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(6,'�}�b�h�n�E�X','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(7,'���s�A�j���[�V����','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(8,'P.A.WORKS','0','2022-05-11 10:04:00','2022-05-11 10:04:00');
/*!40000 ALTER TABLE `company_watanabe` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contents_umehara`
--

LOCK TABLES `contents_umehara` WRITE;
/*!40000 ALTER TABLE `contents_umehara` DISABLE KEYS */;
INSERT INTO `contents_umehara` VALUES (0,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'�Q�[��','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'��','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'���','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'�G�k','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'�Q�[���E��','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'�Q�[���E���','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'�Q�[���E�G�k','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(8,'�́E���','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(9,'�́E�G�k','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(10,'��ƁE�G�k','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(11,'�Q�[���E�́E���','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(12,'�Q�[���E�́E�G�k','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(13,'�́E�G�k�E���','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(14,'�Q�[���E�́E�G�k�E���','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog_country_kanno`
--

LOCK TABLES `dog_country_kanno` WRITE;
/*!40000 ALTER TABLE `dog_country_kanno` DISABLE KEYS */;
INSERT INTO `dog_country_kanno` VALUES (0,NULL,'0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(1,'���L�V�R','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(2,'�C�M���X','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'�h�C�c','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'�C�^���A','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'�I�[�X�g�����A','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(6,'���{','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(7,'�t�����X','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(8,'����','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(9,'�A�����J','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(10,'�R���S','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(11,'���V�A','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(12,'�X�C�X','0','2020-05-21 00:00:00','2020-05-21 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog_main_kanno`
--

LOCK TABLES `dog_main_kanno` WRITE;
/*!40000 ALTER TABLE `dog_main_kanno` DISABLE KEYS */;
INSERT INTO `dog_main_kanno` VALUES (1,'�S�[���f���E���g���[�o�[',2,4,'�����Ō����t�����h���[�B�Z���s�[���ȂǂɌ�������','/dogKanno/20200605152150187.jpg','1','2020-05-21 00:00:00','2020-06-05 15:21:50'),(2,'���u���h�[���E���g���[�o�[',2,4,'�j�����Ƃ����ӁB�ӓ����Ƃ��Ă����􂷂�B','Lab.png','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'���[�N�V���[�E�e���A',2,1,'�C�i���ӂ�鐫�i�B�т������l�X�ȃJ�b�g�X�^�C�����y���߂�B','yorkey.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'�|�����j�A��',3,1,'�D��S�������E���BSNS�ŕ��ɐ�����铮�悪�b��ɂȂ����B','pome.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'�Č�',6,2,'�����Ȑ��i�����E���Ől�C���Ă�ł���B','shiba.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(6,'�p�s����',7,2,'�Ȃł��邱�Ƃ��D�ށB����т����킢���B','papi.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(7,'�{�[�_�[�R���[',2,3,'���Q�̉^���_�o�B�q�r���Ƃ��ėp�����Ă����B','border.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(8,'�L���o���A�E�L���O�E�`���[���Y�E�X�p�j�G��',2,2,'���邭�z�C�B�₵�����Ȉ�ʂ��B','cavalier.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(9,'�h�[�x���}��',3,4,'�����Ōx���S�������A�x�@���ȂǂƂ��Ċ��􂷂�B','doberman.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(10,'�g�C�v�[�h��',7,2,'�t�����h���[���т������ɂ������߁A���{�݂Ȃǂł̃Z���s�[���Ɍ����Ă���B','toypoo.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(11,'�~�j�`���A�E�_�b�N�X�t���h',3,2,'�Â���V�B�����Z���̃��b�N�X�ň�����Ă���B','dachs.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(12,'�V�F�b�g�����h�E�V�[�v�h�b�O',2,2,'�ӔC���������p�S�[�������z�̂悢����B','sheltie.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(13,'�X�R�e�B�b�V���E�e���A',2,2,'�����Ŏ�̌��炵���r���ۂ������B','scottish.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(14,'�C�^���A���E�O���[�n�E���h',4,2,'���₩�Ȑ��i�B�X�^�C�����Q�ł悭����B','italian.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(15,'�H�c��',6,4,'�V�R�L�O���ɓo�^����Ă���B�~�̊����ɋ����B','akitainu.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(16,'�W���b�N�E���b�Z���E�e���A',5,2,'�̃L�c�l�������Ă������ߓ������̂ɏr�q�ɔ�������B','jack.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(17,'�~�j�`���A�E�V���i�E�U�[',3,2,'������������A������ɓO��I�ɐs�����B','schnauzer.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(18,'�A�����J���E�R�b�J�[�E�X�p�j�G��',9,3,'�z�C�Ȑ��i�B�ю��������̂悤�ɏ_�炩���B','american.jpg','0','2020-05-21 00:00:00','2020-06-08 13:30:10'),(19,'�o�Z���W�[',10,3,'�����Ől�ނɂƂ��ė��z�̌��Ƃ����Ă���B','basenji.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(20,'�u���h�b�O',2,3,'���������ڂ̊��ɗD�������i�����Ă���B','bull.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(21,'�V�x���A���E�n�X�L�[',9,4,'���Ԉӎ��������B���������������J�b�R�������B','husky.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(22,'�o�[�j�[�Y�E�}�E���e���E�h�b�O',12,4,'��񂿂�ŊÂ���V�B���т�����悤�Ȋ痧�������Ă���B','bernese.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(23,'�Z���g�E�o�[�i�[�h',12,5,'���̌�������̃x�[�g�[�x���Ƃ����R���f�B�f�悪����܂��B','st.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(24,'�O���[�g�E�s���j�[�Y',7,5,'����[���D��ȕ��͋C�������Ă���B','grate.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(25,'�{���]�C',11,4,'�I�I�J�~�̎�����Ă����B�̍����傫���X�����_�[�Ȃ��炾���B','borzoi.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(26,'�V�F�p�[�h',3,4,'�P�������A�V���[�����Ȃǂ̃^�C�v�ʂɐ��i���قȂ邪���������Â��������Ă���B','shepherd.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(27,'�b�㌢',6,3,'�H�c���ɂ���Ԗڂ̓V�R�L�O���B���������Ă��{��Ȃ��B','kai.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(28,'�`���E�E�`���E',8,3,'�Ԍ��Ɍ����Ă���B�u���[�u���b�N�̐オ�����B','chow.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(29,'�`����',1,1,'���g�I�ŊÂ����B�x���S���������Ɩi����B','chihuahua.png','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(30,'�p�O',8,2,'�Ԃ��J����\�B�l�������Ԍ��ɂ͌����Ȃ��B','pug.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(31,'�k�C����',6,3,'�^CM�ł���������ɋN�p����A���ڂ��W�߂��B','/dogKanno/20200605141724403.jpg','0','2020-06-05 14:17:24','2020-06-05 16:28:41');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog_size_kanno`
--

LOCK TABLES `dog_size_kanno` WRITE;
/*!40000 ALTER TABLE `dog_size_kanno` DISABLE KEYS */;
INSERT INTO `dog_size_kanno` VALUES (0,NULL,'0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(1,'�����^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(2,'���^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'���^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'��^','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'����^','0','2020-05-21 00:00:00','2020-05-21 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drama_main_ige`
--

LOCK TABLES `drama_main_ige` WRITE;
/*!40000 ALTER TABLE `drama_main_ige` DISABLE KEYS */;
INSERT INTO `drama_main_ige` VALUES (1,'��Η�x',1,5,'2020�~','��','1���͏�ˍʁA����ȍ~�͑򑺈���剉�̌Y���h���}�B','0','2021-05-18 12:00:00','2021-05-27 15:43:25'),(2,'�a�@�̎�����',2,6,'2020�~','��','�|�Y��@�����Ղ̕����𐋂����a�@�̎��b�����f���A�剉�͏���F���Y�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'��߂�Ƃ����A�����₩�Ȃ�Ƃ���',3,2,'2020�~','��','���������𓡃��J����剉�Ŏ��ʉ��B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'10�̔閧',4,5,'2020�~','��','�剉�͌��䗝�B�l�X�Ȕ閧�ɖ|�M�����B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'���͂Â���ǂ��܂ł�',3,4,'2020�~','��','����̎��ʉ��B�������A�㔒�ΖG�����o�����A�w���Áx�̈��̂ł����Ȃ��݁B','0','2021-05-18 12:00:00','2021-05-31 10:40:10'),(6,'SEDAI WARS',5,4,'2020�~','��','�ߖ����̓��{������B�R�c�T�M�剉�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(7,'�m��Ȃ��Ă����R�g',5,2,'2020�~','��','���d���n�q���[�}���h���}�B�T���ҏW���𕑑�ɋL�҂̎�l�����g���R���q��������B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(8,'�l�͂ǂ�����',4,6,'2020�~','��','��������𒆓��T�Ď剉�Ŏ��ʉ��B����\�͂�����l���̐t�T�X�y���X�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(9,'DASADA',6,2,'2020�~','��','�H���N�̊��B������46���剉�𖱂߂�w���h���}�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(10,'�����ł͂����Ƃ��܂�',3,6,'2020�~','��','���c�����剉�̃��u�R���f�B�B����̎��ʉ��B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(11,'�P�C�W�ƃP���W',1,3,'2020�~','��','�˒J�����Ɠ��o���傪�_�u���剉�̊��S�I���W�i���X�g�[���[�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(12,'�A���C�u�������̃J���e',2,5,'2020�~','��','����ɗ���������2�l�̏���̃��f�B�J���q���[�}���h���}�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(13,'�����`���R���T��',3,2,'2020�~','��','�剉�͒n��g�A�h�����剉�̎R�{�����B��������Ă����B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(14,'���L������',7,6,'2020�~','��','�\���L�����v�����鏗�q���Z���B�̂��₩�ȓ���`���B�����y�剉�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(15,'���݌Y��2',1,6,'2020�~','��','�����i������\"���݂���\"�����̕��a����邽�߂ɕ�������B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(16,'�a���ŔO���������Ȃ��ł�������',2,4,'2020�~','��','�m���ŋ~�}�~����Ƃ�����l������������p��`���A��Ãq���[�}���h���}','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(17,'���q���Z���̖��ʌ���',6,3,'2020�~','��','����̎��ʉ��B���q���Z���B�̓����`���R���f�B�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(18,'�g�b�v�i�C�t',2,2,'2020�~','�y','��p�̓V�˂��W���a�@�̔]�_�o�O�Ȃ�����B�剉�͓V�C�S��B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(19,'�e�Z�E�X�̑D',8,4,'2020�~','��','�|�����^�������l�����A���e�̎������������邽�߃^�C���X���b�v����B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(20,'SUITS2',NULL,5,'2020�t','��','�S�Ă̑�q�b�g�h���}�̃V�[�Y���Q�B�q�r�ٌ�m�ƓV�ˏ���Ŗ����������Ă����B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(21,'���������b�N�o���h�̍���',NULL,2,'2020�t','��','�s��p�Ń_���_�������ǈ����ׂ�4�l���g�b�v���x���̉��y�t�F�X��ڎw������B���䗬���A�_�R�q�m�剉�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(22,'�T��E�R���ّ��Y',4,5,'2020�t','��','�n��g���剉�̋g��W�i�Ǝu���~���o�f�B�ƂȂ�A���s�̊���Ȑ��E�����㕗�ɉ��߂��Ă��B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(23,'�n�P���̕i�i',5,2,'2020�t','��','2007�N�ɕ������ꂽ���d���h���}�̑��ҁB�������Ƃ̖{���ɔ���B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(24,'�����^���Ȃ�����Ȃ��l',NULL,6,'2020�t','��','���c�M�v�剉�BTwitter�Řb��ƂȂ��������^���Ȃ�����Ȃ��l�����f���Ƀh���}���B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(25,'BG�`�g�ӌx��l�`',11,3,'2020�t','��','�ؑ���Ǝ剉�B���ԃ{�f�B�[�K�[�h�̎p��`���V���[�Y��B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(26,'MIU404',1,4,'2020�t','��','���썄�Ɛ��쌹�_�u���剉�A��؈��I�q���r�{�̐l�C��B�@���{�����̕���B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(27,'�����x�@',1,2,'2020�t','�y','�������l�A���쎇�s���_�u���剉�B�؍��̐l�C�f�����{�łɃ����C�N�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(28,'DIVER�|��������ǁ|',1,5,'2020��','��','���m���������̃_�[�N�q�[���[���B���̑g�D�ɐ������Ď����������Ă����B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(29,'���̉Ɛ��v�i�M�T����',3,4,'2020��','��','�Ǝ����ł��Ȃ��L�����A�E�[�}���̎�l������������Ɛ��v���ق����Ƃ���n�܂郉�u�R���B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(30,'�������͂ǂ������Ă���',8,2,'2020��','��','�V�ܘa�َq�X�𕑑�ɁA�l�Ӕ��g�Ɖ��l����������2�l�̗��͗l��`�������ɔ��郉�u�~�X�e���[�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(31,'�A���T���O�V���f����',2,5,'2020��','��','�Ό����Ƃݎ剉�B�a�@��܎t���������Ȃ��犳�҂ƌ��������p��`���B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(32,'�ޏ��������ł��Ȃ����R',NULL,1,'2020��','�y','�O���l���w���ƗH�삪�D��Ȃ�������Ɛ؂Ȃ����u�R���f�B�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(33,'�e�o�J�t����',9,2,'2020��','��','����M�����邠�܂蓯����w�֓��w�������i�����c���V�j�Ɩ��i�i����j���J��`���z�[���R���f�B�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(38,'����Deep��',3,2,'2021�t','��','�Ό����Ƃ݂ƈ��썄','0','2021-05-27 16:37:53','2021-05-27 16:38:20');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_category_yoshimoto`
--

LOCK TABLES `drink_category_yoshimoto` WRITE;
/*!40000 ALTER TABLE `drink_category_yoshimoto` DISABLE KEYS */;
INSERT INTO `drink_category_yoshimoto` VALUES (0,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'�Β�','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'�g��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'�R�[�q�[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'�R�R�A','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'�ʏ`����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'�Y�_����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'�X�|�[�c����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'�m���A���R�[��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'�r�[��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'���C��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'���n�C','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'�E�B�X�L�[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'�Ē�','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'����','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_main_yoshimoto`
--

LOCK TABLES `drink_main_yoshimoto` WRITE;
/*!40000 ALTER TABLE `drink_main_yoshimoto` DISABLE KEYS */;
INSERT INTO `drink_main_yoshimoto` VALUES (1,'�R�J�E�R�[���@�[��',8,2,'/DrinkImageYoshimoto/coke.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'���[������',2,3,'/DrinkImageYoshimoto/20200602141508665.jpg','0','2020-05-19 00:00:00','2020-06-02 14:15:08'),(3,'�U�E�v���~�A���E�����c',11,1,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'�A�T�q�X�[�p�[�h���C',11,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'�~���N�R�R�A',6,16,'/DrinkImageYoshimoto/20200602141621489.jpg','0','2020-05-19 00:00:00','2020-06-02 14:16:21'),(6,'����������������',16,11,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'�~��낵',7,7,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'�R�o���T�|�[�g',8,NULL,'/DrinkImageYoshimoto/kobara.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'�A�N�G���A�X',9,2,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'REAL�@GOLD',8,2,'/DrinkImageYoshimoto/gold.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'����͂��@����',1,2,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'�g���s�J�[�i�@�}���`�r�^�~��',7,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'�M�B���؂��Β�',NULL,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'���N�~�l�����ނ���',3,3,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'�E�F���`�@�O���[�v',7,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'�~�E',1,7,'/DrinkImageYoshimoto/miu.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'�L����������',8,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'�J���s�X�E�H�[�^�[',NULL,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'���O�~���N',16,15,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(20,'��������',17,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(21,'���������@�\�[�_',17,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(22,'�X���X�g�����O�@����X�p�[�N�����O',13,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(23,'�v���~�A���{�X�@�A���}���[�X�g',5,1,'/DrinkImageYoshimoto/boss.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(24,'�ߌ�̍g���@������������',4,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(25,'���l�̗܁i�ԁj',12,NULL,'/DrinkImageYoshimoto/king.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(26,'�̂񂠂�C���@�������T���[�e�C�X�g',10,1,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(27,'�o���z�[�e���@�~���N�@�R�R�A',6,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(29,'�����Ƃ�',15,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(30,'�O�c��T�C�_�[',8,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(31,'�g���s�J�[�i 100%�I�����W',7,6,NULL,'0','2020-05-29 15:28:29','2020-06-01 13:03:03'),(32,'Suntory Whisky �p�r',14,1,NULL,'1','2020-06-01 11:50:00','2020-06-01 11:50:00'),(33,'�|�J���X�E�F�b�g',9,NULL,'/DrinkImageYoshimoto/20200602141840669.jpg','0','2020-06-01 12:02:34','2020-06-02 14:18:40');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_maker_yoshimoto`
--

LOCK TABLES `drink_maker_yoshimoto` WRITE;
/*!40000 ALTER TABLE `drink_maker_yoshimoto` DISABLE KEYS */;
INSERT INTO `drink_maker_yoshimoto` VALUES (0,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'�T���g���[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'�R�J�E�R�[��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'�ɓ���','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'���N���g','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'�A�T�q','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'�L����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'�_�C�h�[','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'�T�b�|��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'�J�S��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'�����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'����','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'��t','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'�g���{','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'���','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'�X�i','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'���̑f','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'�l�X��','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'�T���K���A','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
/*!40000 ALTER TABLE `drink_maker_yoshimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `element_shirase`
--

DROP TABLE IF EXISTS `element_shirase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `element_shirase` (
  `id` int(11) NOT NULL,
  `element` varchar(256) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element_shirase`
--

LOCK TABLES `element_shirase` WRITE;
/*!40000 ALTER TABLE `element_shirase` DISABLE KEYS */;
INSERT INTO `element_shirase` VALUES (0,'',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(1,'��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(2,'��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(3,'��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(4,'�X',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(5,'��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00');
/*!40000 ALTER TABLE `element_shirase` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forms_umehara`
--

LOCK TABLES `forms_umehara` WRITE;
/*!40000 ALTER TABLE `forms_umehara` DISABLE KEYS */;
INSERT INTO `forms_umehara` VALUES (0,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'���z�M','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'���擊�e','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'�V���[�g����','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'���z�M�E���擊�e','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'���z�M�E�V���[�g����','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'���擊�e�E�V���[�g����','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'���z�M�E���擊�e�E�V���[�g����','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
/*!40000 ALTER TABLE `forms_umehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `from_tanamachi`
--

DROP TABLE IF EXISTS `from_tanamachi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `from_tanamachi` (
  `from_id` int(11) NOT NULL AUTO_INCREMENT,
  `from` varchar(256) NOT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`from_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `from_tanamachi`
--

LOCK TABLES `from_tanamachi` WRITE;
/*!40000 ALTER TABLE `from_tanamachi` DISABLE KEYS */;
INSERT INTO `from_tanamachi` VALUES (1,'�Ȃ�',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(2,'�s��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(3,'�v�T�}�e',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(4,'�{���A�X',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(5,'�Ԃ�',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(6,'�O���b�h�A�C�A��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(7,'�W���C��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(8,'�^���X',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(9,'�\���X',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(10,'�T���{',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(11,'�^�C�t�H��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(12,'�A���W�F���A',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(13,'�p�S�X',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(14,'�K�C�A',0,'2023-05-16 14:58:00','2023-05-16 14:58:00');
/*!40000 ALTER TABLE `from_tanamachi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_genre_miura`
--

DROP TABLE IF EXISTS `game_genre_miura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_genre_miura` (
  `NO` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_genre_miura`
--

LOCK TABLES `game_genre_miura` WRITE;
/*!40000 ALTER TABLE `game_genre_miura` DISABLE KEYS */;
INSERT INTO `game_genre_miura` VALUES (1,0,NULL,'0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(2,1,'RPG','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(3,2,'�I�[�v�����[���h','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(4,3,'MOBA','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(5,4,'SRPG','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(6,5,'MMORPG','0','2022-05-18 00:00:00','2022-05-18 00:00:00');
/*!40000 ALTER TABLE `game_genre_miura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_hard_miura`
--

DROP TABLE IF EXISTS `game_hard_miura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_hard_miura` (
  `NO` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `hard` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_hard_miura`
--

LOCK TABLES `game_hard_miura` WRITE;
/*!40000 ALTER TABLE `game_hard_miura` DISABLE KEYS */;
INSERT INTO `game_hard_miura` VALUES (1,0,NULL,'0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(2,1,'SFC','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(3,2,'PS1','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(4,3,'PS3','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(5,4,'PS4','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(6,5,'PC','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(7,6,'FC','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(8,7,'DS','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(9,8,'PS2','0','2022-05-18 00:00:00','2022-05-18 00:00:00');
/*!40000 ALTER TABLE `game_hard_miura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_main_miura`
--

DROP TABLE IF EXISTS `game_main_miura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_main_miura` (
  `NO` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `game_title` varchar(256) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `hard_id` int(11) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_main_miura`
--

LOCK TABLES `game_main_miura` WRITE;
/*!40000 ALTER TABLE `game_main_miura` DISABLE KEYS */;
INSERT INTO `game_main_miura` VALUES (1,1,'�t�@�C�i���t�@���^�W�[1',1,6,1987,'���j�̎n�܂�','1','2022-05-18 00:00:00','2022-05-31 10:22:40'),(2,2,'�t�@�C�i���t�@���^�W�[2',1,6,1988,'�E�{�A---','1','2022-05-18 00:00:00','2022-05-18 00:00:00'),(4,4,'�t�@�C�i���t�@���^�W�[4',1,1,1991,'�S���x�[�U�l�V��','0','2022-05-18 00:00:00','2022-06-01 09:09:40'),(5,5,'�t�@�C�i���t�@���^�W�[5',1,1,1992,'�`���R�{���ڗ���','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(6,6,'�t�@�C�i���t�@���^�W�[6',1,1,1994,'���600���~�̃t�B�M���A���쐬���ꂽ','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(7,7,'�t�@�C�i���t�@���^�W�[7',1,2,1997,'�����C�N�Œm���x�㏸��','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(8,8,'�t�@�C�i���t�@���^�W�[8',1,2,1999,'�K���u���[�h','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(9,9,'�t�@�C�i���t�@���^�W�[9',1,2,2000,'���_��A���e�[�}�A���킸�����Ȗ���','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(10,10,'�t�@�C�i���t�@���^�W�[10',1,8,2001,'�V���[�Y�̒��ň�Ԃ̒m���x�H','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(11,11,'�t�@�C�i���t�@���^�W�[11',5,8,2002,'���̃I�����C���^','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(12,12,'�t�@�C�i���t�@���^�W�[12',1,8,2006,'�O���t�B�b�N�̐i��������','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(13,13,'�t�@�C�i���t�@���^�W�[13',1,3,2009,'PS�R������i�A���͍D��','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(14,14,'�t�@�C�i���t�@���^�W�[14',5,5,2010,'�����e����MMO','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(15,15,'�t�@�C�i���t�@���^�W�[15',1,4,2016,'�V�i���I�ȊO�ʔ���','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(16,16,'�h���S���N�G�X�g1',1,6,1986,'�`���̎n�܂�','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(17,17,'�h���S���N�G�X�g2',1,6,1987,'�����悭�m��Ȃ�','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(18,18,'�h���S���N�G�X�g3',1,6,1988,'HD-2D�����C�N���o�܂�','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(19,19,'�h���S���N�G�X�g4',1,6,1990,'���������ł�肽��','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(20,20,'�h���S���N�G�X�g5',1,1,1992,'���̓r�A���J�h','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(21,21,'�h���S���N�G�X�g6',1,1,1995,'�o�[�o����HP���₵�Ă�������','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(22,22,'�h���S���N�G�X�g7',1,2,2000,'�b���d��������','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(23,23,'�h���S���N�G�X�g8',1,8,2004,'���ł̓X�}�z�łł����i','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(24,24,'�h���S���N�G�X�g9',1,7,2009,'���߂Ẵh���N�G�͂���ł���','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(25,25,'�h���S���N�G�X�g10',5,5,2013,'���܂�m��Ȃ�','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(26,26,'�h���S���N�G�X�g11',1,4,2017,'�{�����[�������Ȃ肠����','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(27,27,'Skyrim',2,3,2011,'�����o��܂ł͐�����','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(28,28,'Fallout4',2,4,2015,'�����ɂȂ�Ȃ��悤�F��΂���','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(29,29,'League_of _Legends',3,5,2009,'e�X�|�[�c�Ƃ��Đ���オ���Ă���','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(30,30,'�^�N�e�B�N�X�I�E�K',4,1,1995,'�����C�N���o��Ƃ����\������','0','2022-05-18 00:00:00','2022-05-18 00:00:00');
/*!40000 ALTER TABLE `game_main_miura` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_ige`
--

LOCK TABLES `genre_ige` WRITE;
/*!40000 ALTER TABLE `genre_ige` DISABLE KEYS */;
INSERT INTO `genre_ige` VALUES (0,NULL,'0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(1,'�Y��','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(2,'���','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'����','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'�T�X�y���X','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'�Љ�h','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(6,'�w��','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(7,'�l�ԃh���}','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(8,'�~�X�e���[','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(9,'�R���f�B','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(11,'�A�N�V����','0','2021-05-18 12:00:00','2021-05-18 12:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
-- Table structure for table `genre_shirase`
--

DROP TABLE IF EXISTS `genre_shirase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_shirase` (
  `id` int(11) NOT NULL,
  `genre` varchar(256) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_shirase`
--

LOCK TABLES `genre_shirase` WRITE;
/*!40000 ALTER TABLE `genre_shirase` DISABLE KEYS */;
INSERT INTO `genre_shirase` VALUES (0,'',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(1,'�򗳎�',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(2,'�b����',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(3,'�C����',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(4,'������',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(5,'��b��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(6,'�嗳��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(7,'�b�k��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(8,'���p��',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(9,'������',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(10,'�×���',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(11,'�H�H�H',0,'2023-05-16 00:00:00','2023-05-16 00:00:00');
/*!40000 ALTER TABLE `genre_shirase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legend_main_tanamachi`
--

DROP TABLE IF EXISTS `legend_main_tanamachi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legend_main_tanamachi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `legend_name` varchar(256) NOT NULL,
  `real_name` varchar(256) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `from_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `ultimate_ability` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legend_main_tanamachi`
--

LOCK TABLES `legend_main_tanamachi` WRITE;
/*!40000 ALTER TABLE `legend_main_tanamachi` DISABLE KEYS */;
INSERT INTO `legend_main_tanamachi` VALUES (7,'�W�u�����^��','�}�R�A�E�W�u�����^��',32,5,5,'�h�q����',1,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(8,'�j���[�L���b�X��','�W���N�\���E�E�B���A���Y',41,6,5,'�L���b�X���E�H�[��',0,'2023-05-16 14:58:00','2023-05-26 12:01:40'),(9,'�o���X�e�B�b�N','�I�[�K�X�g�E�����S�����[�E�u�����N�}��',63,14,1,'�e���y�X�g',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(10,'�o���K���[��','�A�j�[�^�E�E�B���A���Y',40,6,1,'���[�����O�T���_�[',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(11,'�p�X�t�@�C���_�[','�p�X�t�@�C���_�[',77,3,2,'�W�b�v���C���K��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(12,'�q���[�Y','�E�H���^�[�E�t�B�b�c���C�E�W���j�A',55,7,1,'�}�U�[���[�h',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(13,'�u���b�h�n�E���h','�u���b�h�n�E���h',40,8,4,'�n���e�B���O�r�[�X�g',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(14,'�z���C�]��','�}���[�E�\�}�[�Y���m',39,9,2,'�u���b�N�z�[��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(15,'�}�b�h�}�M�[','�}�[�K���b�g�E�R�[�q��',56,10,1,'���b�J�[�{�[��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(16,'�~���[�W��','�G���I�b�g�E�E�B�b�g',32,5,2,'�p�[�e�B�[���C�t',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(17,'���C�t���C��','�A�W�F�C�E�`�F',26,3,5,'�P�A�p�b�P�[�W',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(18,'�����p�[�g','�������E�p���[�N',23,14,3,'�~�j�K���u�V�[���v',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(19,'���C�X','���l�C�E�z�[�v�E�u���W�[',34,11,2,'�f�B�����V�������t�g',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(20,'�����i���g','�J���u�E�N���X',359,2,1,'�f�X�g�[�e��',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(21,'���[�o','���[�o�E�A���h���[�f',36,1,5,'�u���b�N�}�[�P�b�g�u�e�B�b�N',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(22,'���b�g�\��','�i�^���[�E�p�P�b�g',24,5,3,'�C���^�[�Z�v�^�[�p�C����',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(23,'���@���L���[','�����J�C��',31,12,2,'�X�J�C�n�C�_�C�u',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(24,'���@���e�[�W','�V�I�}��\"�}�[��\"�R���g�����X',19,13,4,'�X�i�C�p�[�̃}�[�N',0,'2023-05-16 14:58:00','2023-05-16 14:58:00'),(27,'�A�b�V��','�A�V�����C�E���[�h���m',122,2,1,'�t�F�[�Y�e�B�A',0,'2023-05-25 11:37:56','2023-05-25 11:37:56'),(28,'�I�N�^��','�I�N�^�r�I�E�V���o',26,3,2,'�W�����v�p�b�h',0,'2023-05-25 11:41:44','2023-05-25 11:41:44'),(29,'�J�^���X�g','�g���b�T�E�N���X�^���E�X�~�X',30,4,3,'�t�F���o���P�[�h',0,'2023-05-25 11:43:12','2023-05-25 11:43:12'),(30,'�N���v�g','�p�N�E�e�W����',24,14,4,'�h���[��EMP',0,'2023-05-25 11:44:32','2023-05-25 11:44:32'),(31,'�R�[�X�e�B�b�N','�A���N�T���_�[�E�m�b�N�X',50,14,3,'Nox�K�X�O���l�[�h',0,'2023-05-25 11:45:52','2023-05-25 11:45:52');
/*!40000 ALTER TABLE `legend_main_tanamachi` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
-- Table structure for table `monster_main_shirase`
--

DROP TABLE IF EXISTS `monster_main_shirase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monster_main_shirase` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `name_en` varchar(256) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `material` varchar(256) NOT NULL,
  `element_id` int(11) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monster_main_shirase`
--

LOCK TABLES `monster_main_shirase` WRITE;
/*!40000 ALTER TABLE `monster_main_shirase` DISABLE KEYS */;
INSERT INTO `monster_main_shirase` VALUES (1,'�A�I�A�V��','Arzuros',5,'�F�b',1,8,0,'2023-05-16 00:00:00','2023-05-29 15:47:22'),(2,'�A�P�m�V����','Aknosom',4,'�P��',2,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(3,'�A�}�c�}�K�c�`','Amatsu',10,'����',3,8,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(4,'�A���W���i�t','Anjanath',2,'�؊{��',2,15,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(5,'�C���F���J�[�i','Velkhana',10,'�u��',1,16,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(6,'�C�\�l�~�N�j','Somnacanth',3,'�l����',3,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(7,'�C�\�l�~�N�j����','Aurora Somnacanth',3,'�X�l����',1,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(8,'�C�u�V�}�L�q�R','Wind Serpent Ibushi',10,'���_��',5,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(9,'�E���N�X�X','Lagombi',5,'���e�b',1,8,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(10,'�G�X�s�i�X','Espinas',1,'����',4,4,0,'2023-05-16 00:00:00','2023-05-30 14:39:29'),(11,'�G�X�s�i�X����','Flaming Espinas',1,'������',2,4,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(12,'�I�I�i�Y�`','Chameleos',10,'����',1,3,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(13,'���ٍ����I�I�i�Y�`','Risen Chameleos',10,'����',1,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(14,'�I�T�C�Y�`','Great Izuchi',4,'��ꌗ�',3,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(15,'�I���~�h��','Almudron',3,'�D����',1,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(16,'�I���~�h������','Magma Almudron',3,'�n����',2,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(17,'�K�C�A�f����','Gaismagorm',10,'������',3,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(18,'�K�����S����','Garangolm',2,'���Z�b',3,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(19,'�N�V�����_�I��','Kushala Daora',10,'�|��',3,3,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(20,'���ٍ����N�V�����_�I��','Risen Kushala Daora',10,'�|��',3,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(21,'�N�������b�N','Kulu Ya Ku',4,'�~��',2,15,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(22,'�S�A�E�}�K��','Gore Magala',11,'���I��',1,11,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(23,'�V���K���}�K��','Shagaru Magala',10,'�V����',1,11,0,'2023-05-16 00:00:00','2023-05-29 09:28:37'),(24,'���ٍ����V���K���}�K��','Risen Shagaru Magala',10,'�V����',1,18,0,'2023-05-16 00:00:00','2023-05-29 09:29:14'),(25,'�W�����g�h�X','Juratodus',3,'�D����',3,15,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(26,'�V���E�O���M�U�~','Shogun Ceanataur',7,'���I',3,3,0,'2023-05-16 00:00:00','2023-05-30 08:28:36'),(27,'�W���I�E�K','Zinogre',6,'���T��',4,8,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(28,'�Z�����M�I�X','Seregios',1,'��n��',3,12,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(29,'�_�C�~���E�U�U�~','Daimyo Hermitaur',7,'���I',3,3,0,'2023-05-16 00:00:00','2023-05-30 08:27:47'),(30,'�^�}�~�c�l','Mizutsune',3,'�A�ϗ�',3,13,0,'2023-05-16 00:00:00','2023-05-30 14:40:30'),(31,'�^�}�~�c�l�󏭎�','Violet Mizutsune',3,'���ϗ�',4,18,0,'2023-05-16 00:00:00','2023-05-30 14:40:40'),(32,'�f�B�A�u���X','Diablos',1,'�p��',4,1,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(33,'�e�B�K���b�N�X','Tigrex',1,'����',3,6,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(34,'�e�I�E�e�X�J�g��','Teostra',10,'����',2,3,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(35,'���ٍ����e�I�E�e�X�J�g��','Risen Teostra',10,'����',2,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(36,'�h�X�o�M�B','Great Baggi',4,'���痳',1,9,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(37,'�h�X�t���M�B','Great Wroggi',4,'�ŋ痳',4,8,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(38,'�g�r�J�K�`','Tobi Kadachi',6,'�򗋗�',2,15,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(39,'�i���K�N���K','Nargacuga',1,'�v��',3,7,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(40,'�i���K�N���K�󏭎�','Lucent Nargacuga',1,'���v��',4,10,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(41,'�i���n�^�^�q��','Thuder Serpent Narwa',10,'���_��',5,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(42,'�S���̕����i���n�^�^�q��','Narwa the Allmother',10,'���_��',5,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(43,'�o�T�����X','Basarios',1,'�◳',5,1,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(44,'�o�[���M�E�X','Bazelgeuse',1,'���ؗ�',3,15,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(45,'�g�@����o�[���M�E�X','Seething Bazelgeuse',1,'���ؗ�',4,16,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(46,'����q�s�̃o���t�@���N','Crimson Glow Valstrax',10,'�V�a��',1,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(47,'���ٍ����o���t�@���N','Risen Crimson Glow Valstrax',10,'�V�a��',1,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(48,'�r�V���e���S','Bishaten',5,'�V��b',4,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(49,'�r�V���e���S����','Blood Orange Bishaten',5,'��V��b',2,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(50,'�v�P�v�P','Pukei-Pukei',4,'�ŗd��',3,15,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(51,'�t���t��','Khezu',1,'�����',1,1,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(52,'�x���I���X','Barioth',1,'�X�嗳',1,9,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(53,'�{���{���X','Barroth',2,'�y����',2,9,0,'2023-05-16 00:00:00','2023-05-30 08:29:17'),(54,'�}�K�C�}�K�h','Magnamalo',6,'���՗�',2,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(55,'���l���߂��}�K�C�}�K�h','Scorned Magnamalo',6,'���՗�',2,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(56,'�����E�[�i','Malzeno',10,'�݋◴',5,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(57,'���c�J�_�L','Rakuna-Kadaki',8,'�ܒw�',4,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(58,'���c�J�_�L����','Pyre Rakuna-Kadaki',8,'���ܒw�',2,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(59,'���c�~���h�E','Tetranadon',9,'�͓��^',3,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(60,'���[�W����','Rajang',5,'�����q',4,6,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(61,'���V�������[�W����','Furiou Rajang',5,'�����q',4,7,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(62,'���C�[�N�X','Astalos',1,'�d��',4,13,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(63,'�����O���g��','Volvidan',5,'�ԍb�b',2,8,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(64,'���I���C�A','Rathian',1,'���Η�',5,1,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(65,'���I���C�A�󏭎�','Gold Rathian',1,'���Η�',3,2,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(66,'���I���E�X','Rathalos',1,'�Η�',5,1,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(67,'���I���E�X�󏭎�','Silver Rathalos',1,'��Η�',2,2,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(68,'���i�K����','Lunagaron',6,'�X�T��',1,18,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(69,'���A���h���X','Royal Ludroth',3,'���b',1,9,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(70,'�k�V�E�A�I�A�V��','Apex Arzuros',5,'�F�b',1,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(71,'�k�V�E�W���I�E�K','Apex Zinogre',6,'���T��',4,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(72,'�k�V�E�f�B�A�u���X','Apex Diablos',1,'�p��',4,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(73,'�k�V�E���I���C�A','Apex Rathian',1,'���Η�',5,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(74,'�k�V�E���I���E�X','Apex Rathalos',1,'�Η�',5,17,0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(86,'�ǉ�o','addo',NULL,'����o',NULL,NULL,1,'2023-05-30 14:07:34','2023-05-30 14:07:34'),(87,'�ǉ�p','',NULL,'����p',NULL,NULL,1,'2023-05-30 14:28:04','2023-05-30 14:33:35'),(88,'�ǉ�q','',NULL,'����q',NULL,NULL,0,'2023-05-30 14:34:16','2023-05-30 14:34:16');
/*!40000 ALTER TABLE `monster_main_shirase` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_main`
--

LOCK TABLES `movie_main` WRITE;
/*!40000 ALTER TABLE `movie_main` DISABLE KEYS */;
INSERT INTO `movie_main` VALUES (1,'�X�p�C�_�[�}��3',1,2,2007,155,'�X�p�C�_�[�}���̉f��̒��ł͈�ԍD��',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN�a����b�A�΂��ڂ��ʔ����B',0,'2017-11-08 00:00:00','2021-05-27 15:33:27'),(3,'���I��',1,4,1994,110,'�}�`���_�����킢��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'�_�[�N�i�C�g���C�W���O',1,5,2012,165,'DC�R�~�b�N�撣��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'�x�C�r�[�h���C�o�[',1,NULL,2017,113,'���҂����삳��邻��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'�g�����X',2,3,2013,101,'�_�j�[�E�{�C���ē�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'�t�B���X',2,3,2013,97,'�X�R�b�g�����h�̍ň��Y��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'�ؗ�Ȃ�M���c�r�[',2,2,2013,143,'���؈��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'�u���b�W�I�u�X�p�C',2,1,2015,144,'�A�J�f�~�[�����j�D�܎��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'�_�E���B���`�E�R�[�h',2,1,2006,174,'�I�h���C�E�g�g�D�V�����Ȃ�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'�t�H���X�g�K���v',3,1,1994,142,'���킸�ƒm�ꂽ�����̕��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'���S�Ȃ�`�F�b�N���C�g',3,2,2014,116,'�{�r�[�t�B�b�V���[',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'���̍��l���',3,2,2001,90,'�Ⴉ�肵�f�B�J�v���I',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'���~�[���u��',3,5,2012,160,'�̕����̓A�e���R�ł͂���܂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'�O���[���}�C��',3,1,1999,189,'�w�V���[�V�����N�̋�Ɂx�������ł�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'�u���b�N�X����',4,4,2011,108,'����ȃz���[���|������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TV���[�r�[�҂��ǂ���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'�L�����[',4,NULL,1976,98,'�X�e�B�[�u���E�L���O�̏�����',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'�X�v���b�g',4,3,2017,117,'�V���}������i�����Ă����Ƌg',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'�~�X�^�[�K���X',4,3,2019,129,'�X�v���b�g�̑���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'�}�C�E�C���^�[��',5,5,2015,121,'�w�v���_�𒅂������x����������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'�^�[�~�i��',5,1,2004,128,'��`�ɏZ��ł݂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'�y�l���s',5,3,2008,104,'����̂��Ƃ��b',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'�A���X�C�������_�[�����h',5,5,2010,113,'�f����������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'�L���b�c���h�b�O�X',5,2,2001,87,'���͂��킢��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'���Ȃ�',NULL,3,2007,130,'�A�T�Ȏ��ɂ͂������߂��܂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'�v���C�h�ƕΌ�',NULL,NULL,2005,135,'�R�����E�t�@�[�X�̃h���}�ł��ǂ�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'�O���C�e�X�g�V���[�}��',3,NULL,2017,105,'�l�I�Ƀ��E���E�����h�z��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'�r�b�O',5,1,1988,130,'�f�G�ȋC���ɂȂ��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'�₽�獋�؂Ȕo�D�w',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'unknown',
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nbaplayers_main_takahashi`
--

LOCK TABLES `nbaplayers_main_takahashi` WRITE;
/*!40000 ALTER TABLE `nbaplayers_main_takahashi` DISABLE KEYS */;
INSERT INTO `nbaplayers_main_takahashi` VALUES (1,NULL,'���u�����E�W�F�[���X',3,23,206,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,NULL,'�X�e�t�B���E�J���[',1,21,191,86,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,NULL,'�P�r���E�f�������g',3,2,208,108,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,NULL,'���j�X�E�A���e�g�N���|',4,10,211,109,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,NULL,'�N���C�E���i�[�h',3,22,201,104,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(6,NULL,'��R���E���L�b�`',5,16,213,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(7,NULL,'�W�F�[���Y�E�n�[�f��',2,2,196,99,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(8,NULL,'�W���G���E�G���r�[�h',5,4,213,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(9,NULL,'���J�E�h���`�b�`',1,26,201,98,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(10,NULL,'�f�C�~�A���E�����[�h',1,19,188,88,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(11,NULL,'�A���\�j�[�E�f�C�r�X',4,23,208,114,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(12,NULL,'�W�~�[�E�o�g���[',3,13,201,104,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(13,NULL,'�J�C���[�E�A�[�r���O',1,2,188,87,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(14,NULL,'�U�C�I���E�E�B���A���\��',4,29,198,128,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(15,NULL,'�W�F�C�\���E�e�C�^��',3,1,203,94,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(16,NULL,'�u���b�h���[�E�r�[��',2,15,191,93,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(17,NULL,'�N���X�E�|�[��',1,24,183,79,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(18,NULL,'�N���C�E�g���v�\��',2,21,198,97,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(19,NULL,'�W�����A�X�E�����h��',4,3,203,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(20,NULL,'�f�r���E�u�b�J�[',2,24,196,95,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(21,NULL,'�h�m�o���E�~�b�`�F��',2,20,185,97,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(22,NULL,'�|�[���E�W���[�W',2,22,203,99,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(23,NULL,'�J�[���E�A���\�j�[�^�E���Y',5,17,211,112,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(24,NULL,'���b�Z���E�E�G�X�g�u���b�N',1,15,191,90,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(25,NULL,'���f�B�E�S�x�A',5,20,216,110,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(26,NULL,'�U�b�N�E���r�[��',2,6,198,90,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(27,NULL,'�g���C�E�����O',1,11,185,81,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(28,NULL,'�V�F�C�E�M���W���X=�A���N�T���_�[',2,18,196,81,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(29,NULL,'�f�B�A�����E�t�H�b�N�X',1,25,191,79,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(30,NULL,'�o���E�A�f�o��',5,13,206,115,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(31,NULL,'�x���E�V�����Y',1,4,208,105,'','1','2021-06-08 15:26:54','2021-06-08 15:26:54'),(32,NULL,'������',4,15,203,103,'','0','2021-06-09 14:05:57','2021-06-09 14:05:57');
/*!40000 ALTER TABLE `nbaplayers_main_takahashi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `original_watanabe`
--

DROP TABLE IF EXISTS `original_watanabe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `original_watanabe` (
  `id` int(11) NOT NULL,
  `original` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `original_watanabe`
--

LOCK TABLES `original_watanabe` WRITE;
/*!40000 ALTER TABLE `original_watanabe` DISABLE KEYS */;
INSERT INTO `original_watanabe` VALUES (0,NULL,'0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(1,'����','0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(2,'����','0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(3,'�Q�[��','0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(4,'�I���W�i��','0','2022-05-11 10:05:00','2022-05-11 10:05:00');
/*!40000 ALTER TABLE `original_watanabe` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_bt_kuramoto`
--

LOCK TABLES `player_bt_kuramoto` WRITE;
/*!40000 ALTER TABLE `player_bt_kuramoto` DISABLE KEYS */;
INSERT INTO `player_bt_kuramoto` VALUES (0,NULL,0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(1,'�E���E�E��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(2,'�E���E����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(3,'�E���E����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(4,'�����E�E��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(5,'�����E����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(6,'�����E����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_main_kuramoto`
--

LOCK TABLES `player_main_kuramoto` WRITE;
/*!40000 ALTER TABLE `player_main_kuramoto` DISABLE KEYS */;
INSERT INTO `player_main_kuramoto` VALUES (3,'�O����P',1,3,9,9,'������',0,'2021-05-19 00:00:00','2021-06-02 11:27:40'),(4,'�R��N�W',1,1,28,7,'�����s',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(5,'�_���y��',1,5,26,5,'���ꌧ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(6,'���c�^��',1,1,31,8,'�R����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(7,'�O�����',1,1,32,8,'�򕌌�',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(8,'F.������',1,1,26,1,'�h�~�j�J���a��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(9,'M..�s�[�v���Y',1,1,29,2,'�A�����J',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(10,'���c�B��',1,5,25,8,'�k�C��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(11,'E.�G�X�R�o�[',1,5,29,5,'�x�l�Y�G��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(12,'���g�C��',1,1,29,12,'���{',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(13,'����Ց�',1,1,21,4,'�a�̎R��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(14,'����r�l',2,1,28,10,'������',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(15,'��䔎��',2,1,29,8,'���ꌧ',1,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(16,'������',3,1,31,14,'�O�d��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(17,'�q�G��',3,1,23,1,'���쌧',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(18,'��a',3,1,33,16,'��������',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(19,'�c���r��',3,2,27,4,'�_�ސ쌧',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(20,'�{��q�Y',3,1,32,9,'���ꌧ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(21,'�m�쒼�l',3,1,22,3,'�V����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(22,'�R���K�P',3,2,28,7,'��t��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(23,'N.�\�g',3,1,32,4,'�v�G���g���R',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(24,'�K�����u',4,1,27,10,'���{',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(25,'����b��',4,2,26,5,'���R��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(26,'�_���a�B',4,2,27,4,'���ꌧ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(27,'T.�I�[�X�e�B��',4,1,29,2,'�A�����J',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(28,'����q',4,2,27,10,'�_�ސ쌧',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(29,'�֍���C',4,5,25,8,'���m��',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(30,'���i����',1,5,27,6,'������',0,'2021-06-01 15:31:56','2021-06-01 15:31:56'),(31,'��{�׎j',4,2,25,4,'���{',0,'2021-06-01 15:37:26','2021-06-01 15:37:26');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_position_kuramoto`
--

LOCK TABLES `player_position_kuramoto` WRITE;
/*!40000 ALTER TABLE `player_position_kuramoto` DISABLE KEYS */;
INSERT INTO `player_position_kuramoto` VALUES (0,NULL,0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(1,'����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(2,'�ߎ�',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(3,'�����',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(4,'�O���',0,'2021-05-19 00:00:00','2021-05-19 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_takahashi`
--

LOCK TABLES `position_takahashi` WRITE;
/*!40000 ALTER TABLE `position_takahashi` DISABLE KEYS */;
INSERT INTO `position_takahashi` VALUES (0,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(1,'�|�C���g�K�[�h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,'�V���[�e�B���O�K�[�h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,'�X���[���t�H���[�h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,'�p���[�t�H���[�h','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,'�Z���^�[','0','2021-05-18 00:00:00','2021-05-18 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
-- Table structure for table `shottype_hiratsuka`
--

DROP TABLE IF EXISTS `shottype_hiratsuka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shottype_hiratsuka` (
  `id` int(11) NOT NULL,
  `shottype` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shottype_hiratsuka`
--

LOCK TABLES `shottype_hiratsuka` WRITE;
/*!40000 ALTER TABLE `shottype_hiratsuka` DISABLE KEYS */;
INSERT INTO `shottype_hiratsuka` VALUES (0,'','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(1,'�t���I�[�g','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(2,'�Z�~�I�[�g','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(3,'�o�[�X�g','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(4,'���̑��i�P���A�{���g�A�N�V�����A���o�[�A�N�V�������j','0','2022-05-16 00:00:00','2022-05-16 00:00:00');
/*!40000 ALTER TABLE `shottype_hiratsuka` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_takahashi`
--

LOCK TABLES `team_takahashi` WRITE;
/*!40000 ALTER TABLE `team_takahashi` DISABLE KEYS */;
INSERT INTO `team_takahashi` VALUES (0,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(1,'�{�X�g���E�Z���e�B�b�N�X','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,'�u���b�N�����E�l�b�c','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,'�j���[���[�N�E�j�b�N�X','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,'�t�B���f���t�B�A�E�Z�u���e�B�V�N�T�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,'�g�����g�E���v�^�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(6,'�V�J�S�E�u���Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(7,'�N���[�u�����g�E�L���o���A�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(8,'�f�g���C�g�E�s�X�g���Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(9,'�C���f�B�A�i�E�y�C�T�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(10,'�~���E�H�[�L�[�E�o�b�N�X','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(11,'�A�g�����^�E�z�[�N�X','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(12,'�V���[���b�g�E�z�[�l�b�c','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(13,'�}�C�A�~�E�q�[�g','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(14,'�I�[�����h�E�}�W�b�N','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(15,'���V���g���E�E�B�U�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(16,'�f���o�[�E�i�Q�b�c','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(17,'�~�l�\�^�E�e�B���o�[�E���u�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(18,'�I�N���z�}�V�e�B�E�T���_�[','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(19,'�|�[�g�����h�E�g���C���u���C�U�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(20,'���^�E�W���Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(21,'�S�[���f���X�e�C�g�E�E�H���A�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(22,'���T���[���X�E�N���b�p�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(23,'���T���[���X�E���C�J�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(24,'�t�F�j�b�N�X�E�T���Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(25,'�T�N�������g�E�L���O�X','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(26,'�_���X�E�}�[�x���b�N�X','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(27,'�q���[�X�g���E���P�b�c','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(28,'�����t�B�X�E�O���Y���[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(29,'�j���[�I�[�����Y�E�y���J���Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(30,'�T���A���g�j�I�E�X�p�[�Y','0','2021-05-18 00:00:00','2021-05-18 00:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
-- Table structure for table `title_shirase`
--

DROP TABLE IF EXISTS `title_shirase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `title_shirase` (
  `id` int(11) NOT NULL,
  `title` varchar(256) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title_shirase`
--

LOCK TABLES `title_shirase` WRITE;
/*!40000 ALTER TABLE `title_shirase` DISABLE KEYS */;
INSERT INTO `title_shirase` VALUES (0,'',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(1,'MH',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(2,'MHG',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(3,'MH2',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(4,'MHF',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(5,'MHP',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(6,'MHP2',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(7,'MHP2G',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(8,'MHP3',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(9,'MH3',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(10,'MH3G',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(11,'MH4',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(12,'MH4G',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(13,'MHX',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(14,'MHXX',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(15,'MHW',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(16,'MHWI',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(17,'MHRise',0,'2023-05-16 00:00:00','2023-05-16 00:00:00'),(18,'MHRiseSB',0,'2023-05-16 00:00:00','2023-05-16 00:00:00');
/*!40000 ALTER TABLE `title_shirase` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vegetable_ishikawa`
--

LOCK TABLES `vegetable_ishikawa` WRITE;
/*!40000 ALTER TABLE `vegetable_ishikawa` DISABLE KEYS */;
INSERT INTO `vegetable_ishikawa` VALUES (1,'�ɂ񂶂�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'���Ⴊ����','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'���܂˂�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'�L���x�c','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'����','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'�s�[�}��','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'�g�}�g','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'�i�X','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'���ڂ���','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'���ڂ�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'��������','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'�','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'�I','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
  `image` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vtuber_main_umehara`
--

LOCK TABLES `vtuber_main_umehara` WRITE;
/*!40000 ALTER TABLE `vtuber_main_umehara` DISABLE KEYS */;
INSERT INTO `vtuber_main_umehara` VALUES (1,'���m���e',1,1,1,862000,'https://www.youtube.com/channel/UCD-miitqNY3nyukJ4Fnf4_A','2018-02-01 00:00:00','�������𒆐S��Youtube�Ŋ������Ă���A�o�[�`�������E�̊w���ψ��ɏ����̏��q�����B','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���m���e.jpg'),(2,'�e�c�؂���',2,1,1,1930000,'https://www.youtube.com/channel/UC1DCedRgGHBdm81E1llLhOQ/','2019-07-03 00:00:00','�z�����C�u3����','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�e�c�؂���.jpg'),(3,'��������',1,1,1,630000,'https://www.youtube.com/channel/UCv1fFr156jc65EMiLbaLImw','2018-03-06 00:00:00','��l�̂��u�킵�v','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/��������.jpg'),(4,'����}����',2,1,1,1910000,'https://www.youtube.com/channel/UCCzUftO8KOVkV4wQG1vkUvg/','2019-07-22 00:00:00','�z�����C�u�O����','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/����}����.jpg'),(5,'���_�����',2,1,1,1810000,'https://www.youtube.com/channel/UChAnqc_AY5_I3Px5dig3X1Q/','2019-03-25 00:00:00','�z�����C�u����','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���_�����.jpg'),(6,'���t',1,1,1,1270000,'https://www.youtube.com/channel/UCSFCh5NL4qXrAy9u-u2lX3g/','2018-03-05 00:00:00','�Ζ����ɋ�������{���邱�Ƃ�ڕW�ɂ��Ă���B','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���t.jpg'),(7,'���X�o��',2,1,1,1310000,'https://www.youtube.com/channel/UCvzGlP9oQwU--Y0r9id_jnA/','2018-08-22 00:00:00','�����i���Z����e-sports���̃}�l�[�W���[','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���X�o��.jpg'),(8,'������݂�',2,1,1,1440000,'https://www.youtube.com/channel/UC-hM6YJuNYVAmUWxeIr9FeA/','2018-04-25 00:00:00','�z�����C�u�����̃G���[�g�ޏ��A�C�h��','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/������݂�.jpg'),(9,'��',1,1,1,994000,'https://www.youtube.com/channel/UCspv01oxUFf_MTSipURRhkA/','2018-05-01 00:00:00','�ɂ����񂶏������C�o�[','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/��.jpg'),(10,'�L�Y�i�A�C',4,1,1,3090000,'https://www.youtube.com/channel/UC4YaOt1yT-ZeyB0OmxHgolA/','2016-10-19 00:00:00','�����x�~��','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�L�Y�i�A�C.jpg'),(11,'��������',2,1,1,1620000,'https://www.youtube.com/channel/UC1opHUrw8rvnsadT-iGp7Cg/','2018-08-01 00:00:00','�z�����C�u�������[�ρ[�����ǂ�Q�[�}�[���C�h','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/��������.jpg'),(12,'����t�u�L',2,1,1,1870000,'https://www.youtube.com/channel/UCdn5BQ06XqgXoAxIhbqw5Rg/','2018-05-24 00:00:00','��(FOX)�̃o�[�`�����ςƂ��Ċ���','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/����t�u�L.jpg'),(13,'�����ꂤ��',5,1,1,725000,'https://www.youtube.com/channel/UCt30jJgChL8qeT9VPadidSw/','2018-09-16 00:00:00','�C���X�g���[�^�[','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�����ꂤ��.jpg'),(14,'����Ƃ�',1,1,1,606000,'https://www.youtube.com/channel/UCXRlIK3Cw_TJIQC5kSJJQMg/','2019-03-19 00:00:00','�Q�[���ɉ̂ɎG�k�ɁA�����Ȏ������Ă���','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/����Ƃ�.jpg'),(15,'����m�G��',2,1,1,1480000,'https://www.youtube.com/channel/UCdyqAaZDKHXg4Ahi7VENThQ/','2019-07-26 00:00:00','�����Ƃ肵�Ă��邪�A�Ȃ�ł��ؗ͂łǂ��ɂ����镨���Ȗʂ����� ���ӂ�]�؏��R�m','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/����m�G��.jpg'),(16,'���X��������',2,1,1,1450000,'https://www.youtube.com/channel/UC5CwaMl1eIgY8h02uZw7u8A/','2018-03-18 00:00:00','�A�C�h��Vtuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���X��������.jpg'),(17,'�������A',1,1,1,353000,'https://www.youtube.com/channel/UCCVwhI5trmaSxfcze_Ovzfw/','2019-01-15 00:00:00','�ɂ����񂶏��� ','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�������A.jpg'),(18,'�{�ԂЂ܂��',1,1,1,692000,'https://www.youtube.com/channel/UC0g1AE0DOjBYnLhkgoRWN1w/','2018-07-02 00:00:00','�قږ����Q�[���z�M�����Ă���B','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�{�ԂЂ܂��.jpg'),(19,'�P�錎',4,1,1,914000,'https://www.youtube.com/channel/UCQYADFw7xEJ9oZSM5ZbqyBw/','2017-12-05 00:00:00','�y�I�t�B�V����HP�zhttp://www.kaguyaluna.jp/','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�P�錎.jpg'),(20,'�x�m��',4,1,1,343000,'https://www.youtube.com/c/Aoich/','2017-10-25 00:00:00','2022/04/20�@�j���[�V���O�������[�X','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�x�m��.jpg'),(21,'�鎭���q',1,1,1,531000,'https://www.youtube.com/channel/UCwokZsOK_uEre70XayaFnzA/','2018-03-06 00:00:00','�̂̂��o����ŕ����q�ō�������26��','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�鎭���q.jpg'),(22,'�Вz',1,1,1,611000,'https://www.youtube.com/channel/UCKMYISTJAQ8xTplUPHiABlA/','2018-05-25 00:00:00','�����̃I�^�N','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�Вz.jpg'),(23,'�V�����Ȃ�',2,1,1,1190000,'https://www.youtube.com/channel/UCZlDXzGoo7d44bwdNObFacg/','2019-12-04 00:00:00','�z�����C�u4����','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�V�����Ȃ�.jpg'),(24,'�s�m�΃t���A',2,1,1,877000,'https://www.youtube.com/channel/UCvInZx9h3jC2JzsIzoOebWg/','2019-07-26 00:00:00','�z�����C�u�O����','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�s�m�΃t���A.jpg'),(25,'�łтłсE�łт�',1,1,1,481000,'https://www.youtube.com/channel/UCjlmCrq4TP1I4xguOtJ-31w/','2019-01-31 00:00:00','�ɂ����񂶏��������낵�������܂̂����˂�ǂ����Ƃ͂����������','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/�łтłсE�łт�.jpg'),(26,'GawrGura',2,1,1,3940000,'https://www.youtube.com/channel/UCoSrY_IQQVpmIRZ9Xf-y93g/','2020-07-16 00:00:00','�z�����C�uEN�ɏ���','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/GawrGura.jpg'),(27,'���R���܂�',4,1,1,823000,'https://www.youtube.com/channel/UC8NZiqKx6fsDT3AVcMiVFyA/','2017-06-30 00:00:00','����� �ώς̂肨���l�^�c���Ă���o�[�`����YouTuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���R���܂�.jpg'),(28,'����T��',1,1,1,765000,'https://www.youtube.com/channel/UC9V3Y3_uzU5e-usObb6IE1w/','2019-09-25 00:00:00','������ƃQ�[���Ɖ̂���������','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/����T��.jpg'),(29,'��_�~�I',2,1,1,982000,'https://www.youtube.com/channel/UCp-5t9SrOQwXMU7iIjQfARg/','2018-12-01 00:00:00','�z�����C�u������Vtuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/��_�~�I.jpg'),(30,'���؍�',1,1,1,731000,'https://www.youtube.com/channel/UCoztvTULBYd3WmStqYeoHcA/','2018-07-02 00:00:00','�Q�[����������','0','2022-05-06 10:00:00','2022-05-06 10:00:00','/VtuberUmehara/���؍�.jpg');
/*!40000 ALTER TABLE `vtuber_main_umehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapon_kind_hagiwara`
--

DROP TABLE IF EXISTS `weapon_kind_hagiwara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weapon_kind_hagiwara` (
  `kind_id` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(255) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapon_kind_hagiwara`
--

LOCK TABLES `weapon_kind_hagiwara` WRITE;
/*!40000 ALTER TABLE `weapon_kind_hagiwara` DISABLE KEYS */;
INSERT INTO `weapon_kind_hagiwara` VALUES (1,'',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(2,'AR',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(3,'SMG',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(4,'LMG',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(5,'SR',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(6,'SG',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(7,'HG',0,'2023-05-16 15:00:00','2023-05-16 15:00:00'),(8,'DMR',0,'2023-05-16 15:00:00','2023-05-16 15:00:00');
/*!40000 ALTER TABLE `weapon_kind_hagiwara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapon_main_hiratsuka`
--

DROP TABLE IF EXISTS `weapon_main_hiratsuka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weapon_main_hiratsuka` (
  `id` int(11) NOT NULL,
  `weaponname` varchar(256) NOT NULL,
  `weapontype_id` int(11) NOT NULL,
  `cost` int(11) NOT NULL,
  `headdamage` int(3) DEFAULT NULL,
  `bodydamage` int(3) DEFAULT NULL,
  `legdamage` int(3) DEFAULT NULL,
  `rate` double(11,5) DEFAULT NULL,
  `shottype_id` int(11) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapon_main_hiratsuka`
--

LOCK TABLES `weapon_main_hiratsuka` WRITE;
/*!40000 ALTER TABLE `weapon_main_hiratsuka` DISABLE KEYS */;
INSERT INTO `weapon_main_hiratsuka` VALUES (2,'�t���b�g���C��',1,400,32,18,14,10.00000,1,'0','2022-05-16 00:00:00','2022-06-02 16:17:17'),(3,'�w�����b�N',1,450,35,20,15,7.33000,3,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(4,'R-301',1,600,25,14,11,13.50000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(5,'�f�B���H�\�V����',2,450,32,16,12,15.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(6,'�X�s�b�g�t�@�C�A',2,0,27,18,15,9.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(7,'L-�X�^�[',2,600,30,17,14,10.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(8,'�����y�[�W',2,500,39,26,22,5.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(9,'EVA-8',3,150,81,54,54,2.10000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(10,'�s�[�X�L�[�p�[',3,350,121,99,77,0.91000,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(11,'�}�X�e�B�t',3,350,144,112,112,1.20000,2,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(12,'���U���r�[�N',3,0,69,45,42,2.20000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(13,'�I���^�l�[�^�[',4,400,24,16,13,10.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(14,'R-99',4,450,17,11,9,18.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(15,'�v���E���[',4,400,23,14,12,11.63000,3,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(16,'�{���g',4,0,26,17,14,12.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(17,'CAR',4,550,20,13,10,15.50000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(18,'�����O�{�EDMR',5,300,118,55,44,1.30000,2,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(19,'�N���[�o�[',5,0,435,145,116,0.41600,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(20,'�Z���`�l��',5,400,140,70,63,0.62500,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(21,'�`���[�W���C�t��',5,600,116,90,90,0.65400,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(22,'P2020',6,0,27,18,14,7.00000,2,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(23,'RE-45',6,150,18,12,11,13.00000,1,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(24,'�E�B���O�}��',6,500,97,45,41,2.60000,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(25,'G7�X�J�E�g',7,0,63,36,27,4.00000,2,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(26,'�g���v���e�C�N',7,500,138,69,63,1.30000,2,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(27,'30-30���s�[�^�[',7,400,74,42,36,2.31000,2,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(28,'�{�Z�b�N',7,500,105,60,54,1.12400,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(29,'�t���O�O���l�[�h',8,75,100,100,100,1.66600,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(30,'�e���~�b�g�O���l�[�h',8,75,25,25,25,0.58800,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(31,'�A�[�N�X�^�[',8,125,70,70,70,2.00000,4,'0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(32,'�n�{�b�N',1,400,32,18,14,11.00000,1,'0','2022-06-02 10:24:15','2022-06-02 10:24:15');
/*!40000 ALTER TABLE `weapon_main_hiratsuka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapontype_hiratsuka`
--

DROP TABLE IF EXISTS `weapontype_hiratsuka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weapontype_hiratsuka` (
  `id` int(11) NOT NULL,
  `weapontype` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapontype_hiratsuka`
--

LOCK TABLES `weapontype_hiratsuka` WRITE;
/*!40000 ALTER TABLE `weapontype_hiratsuka` DISABLE KEYS */;
INSERT INTO `weapontype_hiratsuka` VALUES (0,'','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(1,'�A�T���g���C�t��','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(2,'���C�g�}�V���K��','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(3,'�V���b�g�K��','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(4,'�T�u�}�V���K��','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(5,'�X�i�C�p�[���C�t��','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(6,'�n���h�K��','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(7,'�}�[�N�X�}��','0','2022-05-16 00:00:00','2022-05-16 00:00:00'),(8,'���̑��i�O���l�[�h�j','0','2022-05-16 00:00:00','2022-05-16 00:00:00');
/*!40000 ALTER TABLE `weapontype_hiratsuka` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-31  9:53:20
