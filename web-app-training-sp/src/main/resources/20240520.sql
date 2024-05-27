-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fa1
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

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
-- Table structure for table `cat_main_hayashichika`
--

DROP TABLE IF EXISTS `cat_main_hayashichika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_main_hayashichika` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(256) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL,
  `from_id` int(11) DEFAULT NULL,
  `point` varchar(256) DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_main_hayashichika`
--

LOCK TABLES `cat_main_hayashichika` WRITE;
/*!40000 ALTER TABLE `cat_main_hayashichika` DISABLE KEYS */;
INSERT INTO `cat_main_hayashichika` VALUES (2,'�A�����J���V���[�g�w�A�[',1,2,1,'�r���傫���A�K���͒���','0','2024-05-07 09:00:00','2024-05-16 14:01:59'),(3,'�X�R�e�B�b�V���t�H�[���h',3,2,2,'�ˑR�ψقŐ܂ꎨ��','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(4,'�}���`�J��',3,2,2,'�r�̒�������ѕ��܂ő��푽�l�ɑ��݂���','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(5,'���O�h�[��',2,4,1,'�傫���ʂ������','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(6,'�T�C�x���A��',2,4,10,'�����|����Ȃ������܂���','0','2024-05-07 09:00:00','2024-05-16 08:46:22'),(7,'�~�k�G�b�g',3,2,1,'�l�����������^�L','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(8,'�m���E�F�[�W�����t�H���X�g�L���b�g',2,4,8,'�S�[�W���X�Ȓ��тɉB�ꂽ�ؓ�','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(9,'�u���e�B�b�V���V���[�g�w�A�[',1,2,2,'�r�͒Z���Ă��v���C�h�͍���','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(10,'�x���K��',1,4,1,'�쐫�I�Ȍ����ڂ����ǊÂ���V','0','2024-05-07 09:00:00','2024-05-16 13:47:22'),(11,'���C���N�[��',2,4,1,'���E��傫���L','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(12,'�G�L�]�`�b�N�V���[�g�w�A',1,1,1,'�Ⴂ�@�ƒZ���r','0','2024-05-07 09:00:00','2024-05-14 10:45:03'),(13,'�y���V��',2,1,2,'�����ڂ����g����i','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(14,'���V�A���u���[',1,3,10,'�����ۂ����ǔL�炵�����\������','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(15,'�Z���J�[�N���b�N�X',3,2,1,'�r�̔�����Ԃ����L','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(16,'���K�}�t�B��',2,4,1,'�����܂������ǈ�Ԉ����ꂽ��','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(17,'�f�{�����b�N�X',1,3,2,'����Ȃ̂ɖڂƎ��͑傫��','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(18,'�X�t�B���N�X',1,3,4,'�قږ���','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(19,'�\�}��',2,3,2,'�L�c�l�̂悤�ȔL','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(20,'�V�����g�����[',1,2,9,'��������̊i�ɍׂ��l��','0','2024-05-07 09:00:00','2024-05-14 11:44:34'),(21,'�g�C�{�u',1,1,10,'���E�ꏬ�����L','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(22,'�V���K�v�[��',1,2,5,'�������Ă��ؓ����A�l�ԑ�D��','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(23,'�W���p�j�[�Y�{�u�e�C��',3,3,7,'�������ۂƑ�l���ۂ����i�œ��{��\','0','2024-05-07 09:00:00','2024-05-16 15:10:41'),(24,'�s�N�V�[�{�u',3,4,1,'�����Ɍ��L�I','0','2024-05-07 09:00:00','2024-05-15 10:18:14'),(25,'�n�C�����_�[',3,4,1,'�O�����J�[���̎�','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(26,'�V����',1,6,6,'�|�C���g�J���[�ƃT�t�@�C�A�u���[�͏����̏�','0','2024-05-07 09:00:00','2024-05-16 15:43:09'),(32,'�A�r�V�j�A��',1,3,3,'�G���K���g�Ȃ��ς��Â���V','0','2024-05-15 10:17:56','2024-05-15 10:17:56');
/*!40000 ALTER TABLE `cat_main_hayashichika` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `from_hayashichika`
--

DROP TABLE IF EXISTS `from_hayashichika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `from_hayashichika` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from` varchar(256) DEFAULT 'NULL',
  `del_flag` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `from_hayashichika`
--

LOCK TABLES `from_hayashichika` WRITE;
/*!40000 ALTER TABLE `from_hayashichika` DISABLE KEYS */;
INSERT INTO `from_hayashichika` VALUES (0,'','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(1,'�A�����J','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(2,'�C�M���X','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(3,'�G�W�v�g','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(4,'�J�i�_','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(5,'�V���K�|�[��','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(6,'�^�C','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(7,'���{','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(8,'�m���E�F�[','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(9,'�t�����X','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(10,'���V�A','0','2024-05-07 09:00:00','2024-05-07 09:00:00');
/*!40000 ALTER TABLE `from_hayashichika` ENABLE KEYS */;
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
-- Table structure for table `idol`
--

DROP TABLE IF EXISTS `idol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idol` (
  `id` int(11) NOT NULL,
  `idol` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idol`
--

LOCK TABLES `idol` WRITE;
/*!40000 ALTER TABLE `idol` DISABLE KEYS */;
INSERT INTO `idol` VALUES (0,'','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(1,'TWICE','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(2,'Le Sserafim','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(3,'IVE','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(4,'NewJeans','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(5,'IU','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(6,'ITZY','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(7,'NiziU','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(8,'NMIXX','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(9,'STAYC','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(10,'Cherry Bullet','0','2023-05-16 15:00:00','2023-05-17 15:00:00');
/*!40000 ALTER TABLE `idol` ENABLE KEYS */;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_main`
--

LOCK TABLES `movie_main` WRITE;
/*!40000 ALTER TABLE `movie_main` DISABLE KEYS */;
INSERT INTO `movie_main` VALUES (1,'�X�p�C�_�[�}��3',1,2,2007,155,'�X�p�C�_�[�}���̉f��̒��ł͈�ԍD��',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN�a����b�A�΂��ڂ��ʔ����B',0,'2017-11-08 00:00:00','2021-05-27 15:33:27'),(3,'���I��',1,4,1994,110,'�}�`���_�����킢��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'�_�[�N�i�C�g���C�W���O',1,5,2012,165,'DC�R�~�b�N�撣��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'�x�C�r�[�h���C�o�[',1,NULL,2017,113,'���҂����삳��邻��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'�g�����X',2,3,2013,101,'�_�j�[�E�{�C���ē�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'�t�B���X',2,3,2013,97,'�X�R�b�g�����h�̍ň��Y��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'�ؗ�Ȃ�M���c�r�[',2,2,2013,143,'���؈��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'�u���b�W�I�u�X�p�C',2,1,2015,144,'�A�J�f�~�[�����j�D�܎��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'�_�E���B���`�E�R�[�h',2,1,2006,174,'�I�h���C�E�g�g�D�V�����Ȃ�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'�t�H���X�g�K���v',3,1,1994,142,'���킸�ƒm�ꂽ�����̕��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'���S�Ȃ�`�F�b�N���C�g',3,2,2014,116,'�{�r�[�t�B�b�V���[',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'���̍��l���',3,2,2001,90,'�Ⴉ�肵�f�B�J�v���I',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'���~�[���u��',3,5,2012,160,'�̕����̓A�e���R�ł͂���܂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'�O���[���}�C��',3,1,1999,189,'�w�V���[�V�����N�̋�Ɂx�������ł�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'�u���b�N�X����',4,4,2011,108,'����ȃz���[���|������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TV���[�r�[�҂��ǂ���',0,'2017-11-08 00:00:00','2024-05-14 10:53:46'),(18,'�L�����[',4,NULL,1976,98,'�X�e�B�[�u���E�L���O�̏�����',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'�X�v���b�g',4,3,2017,117,'�V���}������i�����Ă����Ƌg',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'�~�X�^�[�K���X',4,3,2019,129,'�X�v���b�g�̑���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'�}�C�E�C���^�[��',5,5,2015,121,'�w�v���_�𒅂������x����������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'�^�[�~�i��',5,1,2004,128,'��`�ɏZ��ł݂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'�y�l���s',5,3,2008,104,'����̂��Ƃ��b',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'�A���X�C�������_�[�����h',5,5,2010,113,'�f����������',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'�L���b�c���h�b�O�X',5,2,2001,87,'���͂��킢��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'���Ȃ�',NULL,3,2007,130,'�A�T�Ȏ��ɂ͂������߂��܂���',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'�v���C�h�ƕΌ�',NULL,NULL,2005,135,'�R�����E�t�@�[�X�̃h���}�ł��ǂ�',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'�O���C�e�X�g�V���[�}��',3,NULL,2017,105,'�l�I�Ƀ��E���E�����h�z��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'�r�b�O',5,1,1988,130,'�f�G�ȋC���ɂȂ��',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'�₽�獋�؂Ȕo�D�w',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
-- Table structure for table `office`
--

DROP TABLE IF EXISTS `office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `office` (
  `id` int(11) NOT NULL,
  `office` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office`
--

LOCK TABLES `office` WRITE;
/*!40000 ALTER TABLE `office` DISABLE KEYS */;
INSERT INTO `office` VALUES (0,'','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(1,'JYP','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(2,'HYBE','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(3,'ADOR','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(4,'EDAM','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(5,'High Up','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(6,'FNC','0','2023-05-16 15:00:00','2023-05-17 15:00:00'),(7,'STARSHIP','0','2023-05-16 15:00:00','2023-05-17 15:00:00');
/*!40000 ALTER TABLE `office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size_hayashichika`
--

DROP TABLE IF EXISTS `size_hayashichika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size_hayashichika` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(256) DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size_hayashichika`
--

LOCK TABLES `size_hayashichika` WRITE;
/*!40000 ALTER TABLE `size_hayashichika` DISABLE KEYS */;
INSERT INTO `size_hayashichika` VALUES (0,'','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(1,'�R�r�[','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(2,'�Z�~�R�r�[','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(3,'�t�H�[����','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(4,'�Z�~�t�H�[����','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(5,'�����O���T�u�X�^���V����','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(6,'�I���G���^��','0','2024-05-07 09:00:00','2024-05-07 09:00:00');
/*!40000 ALTER TABLE `size_hayashichika` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_hayashichika`
--

DROP TABLE IF EXISTS `type_hayashichika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_hayashichika` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(256) DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_hayashichika`
--

LOCK TABLES `type_hayashichika` WRITE;
/*!40000 ALTER TABLE `type_hayashichika` DISABLE KEYS */;
INSERT INTO `type_hayashichika` VALUES (0,'','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(1,'�Z��','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(2,'����','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(3,'�Z�сE����','0','2024-05-07 09:00:00','2024-05-07 09:00:00');
/*!40000 ALTER TABLE `type_hayashichika` ENABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20 10:27:22
