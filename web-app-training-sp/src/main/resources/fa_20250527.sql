-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fa
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
-- Table structure for table `area_tahara`
--

DROP TABLE IF EXISTS `area_tahara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_tahara` (
  `id` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `del_flg` int(10) DEFAULT NULL,
  `create_date` varchar(30) DEFAULT NULL,
  `update_date` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_tahara`
--

LOCK TABLES `area_tahara` WRITE;
/*!40000 ALTER TABLE `area_tahara` DISABLE KEYS */;
INSERT INTO `area_tahara` VALUES (0,NULL,0,'20250508103000','20250508103000'),(1,'�k�C��',0,'20250508103000','20250508103000'),(2,'�X��',0,'20250508103000','20250508103000'),(3,'��茧',0,'20250508103000','20250508103000'),(4,'�{�錧',0,'20250508103000','20250508103000'),(5,'�H�c��',0,'20250508103000','20250508103000'),(6,'�R�`��',0,'20250508103000','20250508103000'),(7,'������',0,'20250508103000','20250508103000'),(8,'��錧',0,'20250508103000','20250508103000'),(9,'�Ȗ،�',0,'20250508103000','20250508103000'),(10,'�Q�n��',0,'20250508103000','20250508103000'),(11,'��ʌ�',0,'20250508103000','20250508103000'),(12,'��t��',0,'20250508103000','20250508103000'),(13,'�����s',0,'20250508103000','20250508103000'),(14,'�_�ސ쌧',0,'20250508103000','20250508103000'),(15,'�V����',0,'20250508103000','20250508103000'),(16,'�x�R��',0,'20250508103000','20250508103000'),(17,'�ΐ쌧',0,'20250508103000','20250508103000'),(18,'���䌧',0,'20250508103000','20250508103000'),(19,'�R����',0,'20250508103000','20250508103000'),(20,'���쌧',0,'20250508103000','20250508103000'),(21,'�򕌌�',0,'20250508103000','20250508103000'),(22,'�É���',0,'20250508103000','20250508103000'),(23,'���m��',0,'20250508103000','20250508103000'),(24,'�O�d��',0,'20250508103000','20250508103000'),(25,'���ꌧ',0,'20250508103000','20250508103000'),(26,'���s�{',0,'20250508103000','20250508103000'),(27,'���{',0,'20250508103000','20250508103000'),(28,'���Ɍ�',0,'20250508103000','20250508103000'),(29,'�ޗǌ�',0,'20250508103000','20250508103000'),(30,'�a�̎R��',0,'20250508103000','20250508103000'),(31,'���挧',0,'20250508103000','20250508103000'),(32,'������',0,'20250508103000','20250508103000'),(33,'���R��',0,'20250508103000','20250508103000'),(34,'�L����',0,'20250508103000','20250508103000'),(35,'�R����',0,'20250508103000','20250508103000'),(36,'������',0,'20250508103000','20250508103000'),(37,'���쌧',0,'20250508103000','20250508103000'),(38,'���m��',0,'20250508103000','20250508103000'),(39,'���m��',0,'20250508103000','20250508103000'),(40,'������',0,'20250508103000','20250508103000'),(41,'���ꌧ',0,'20250508103000','20250508103000'),(42,'���茧',0,'20250508103000','20250508103000'),(43,'�F�{��',0,'20250508103000','20250508103000'),(44,'�啪��',0,'20250508103000','20250508103000'),(45,'�{�茧',0,'20250508103000','20250508103000'),(46,'��������',0,'20250508103000','20250508103000'),(47,'���ꌧ',0,'20250508103000','20250508103000');
/*!40000 ALTER TABLE `area_tahara` ENABLE KEYS */;
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
INSERT INTO `artist` VALUES (1,'Zebrahead','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(2,'FLOW','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(3,'?�ĒÌ�?�t','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(4,'Anly','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(5,'fox capture plan','0','2018-05-23 01:27:00','2018-05-23 01:27:00');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author_nakano`
--

DROP TABLE IF EXISTS `author_nakano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author_nakano` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_nakano`
--

LOCK TABLES `author_nakano` WRITE;
/*!40000 ALTER TABLE `author_nakano` DISABLE KEYS */;
INSERT INTO `author_nakano` VALUES (0,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(1,'�{�� ����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(2,'���� ��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'�Ė� ����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'���� ��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(5,'�H�� ���V��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(6,'���� ��Y','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(7,'���� �v��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(8,'�� ����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(9,'�X ���O','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(10,'���� �@�g','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(11,'���� ��Y','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(12,'�V�� ��g','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(13,'���� �񑾘Y','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(14,'���� �����Y','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(15,'�I �єV','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
/*!40000 ALTER TABLE `author_nakano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_main_nakano`
--

DROP TABLE IF EXISTS `book_main_nakano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_main_nakano` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(256) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `classification_id` int(1) NOT NULL,
  `character_orthography_id` int(1) DEFAULT NULL,
  `first_appearance` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_main_nakano`
--

LOCK TABLES `book_main_nakano` WRITE;
/*!40000 ALTER TABLE `book_main_nakano` DISABLE KEYS */;
INSERT INTO `book_main_nakano` VALUES (1,'�k�J�j���}�P�Y�l',1,10,3,'','0','2024-05-07 00:00:00','2024-05-20 09:43:45'),(2,'���ꃁ���X',2,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'������',3,10,4,'�u�����V���v19�i�吳3�j�N4�`8��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'�R���L',4,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(5,'������',5,10,4,'�u�鍑���w�v1915�i�吳4�j�N11����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(6,'��͓S���̖�',1,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(7,'��y�͔L�ł���',3,10,4,'�u�z�g�g�M�X�v1905�i����38�j�N1���A2���A4���A6���A7���A10���A1906�i����39�j�N1���A3���A4���A8��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(8,'���\��',3,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(9,'��܂Ȃ�',1,10,4,'�u��薈���V���v��薈���V���ЁA1923�i�吳12�N�j4��8��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(10,'�l�Ԏ��i',2,10,4,'�u�W�]�v�}�����[�A1948�i���a23�j�N6�`8����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(11,'�퍞�ݑi��',2,10,4,'�u�������_�v1940�i���a15�j�N2��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(12,'�����̑��������X',1,10,4,'�u�C�[�n�g�����b�@�����̑��������X�v�����s�m�ˏo�ŕ��E���������ЁA1924�i�吳13�j�N12��1��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(13,'�w偂̎�',5,10,4,'�u�Ԃ����v1918�i�吳7�j�N7��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(14,'�E�G',6,10,4,'�u��@�n�����v��ЁA1925�i�吳14�j�N1��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(15,'�V�������',3,10,4,'�u�z�g�g�M�X�v1906�i����39�j�N4��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(16,'�h�O���E�}�O��',7,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(17,'����',3,10,4,'�u�V�����v1906�i����39�j�N9��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(18,'����L',8,10,1,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(19,'�悾���̐�',1,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(20,'�w�t�ƏC���x',1,10,3,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(21,'���P',9,10,3,'�u�����V�F�v1890�i����23�j�N1��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(22,'�w��̂�����',10,4,4,'�u�w��̂����߁v1872�i����5�j�N2��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(23,'���̎��̉��ɂ�',11,10,4,'�u���Ǝ��_�v1928�i���a3�j�N12��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(24,'��܂𔃂���',12,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(25,'���̖��O�Y',1,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(26,'���ɖi���� �u02 ���ɖi����v',13,10,3,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(27,'�����M',9,10,1,'�u�������_�@��O�\��N����j�v1916�i�吳5�j�N1��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(28,'�����',12,10,4,'�u�Ԃ����@������O����ꍆ�v1932�i���a7�j�N1����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(29,'�q�b�q��',14,10,3,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(30,'�y�����L',15,10,1,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
/*!40000 ALTER TABLE `book_main_nakano` ENABLE KEYS */;
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
-- Table structure for table `category_tahara`
--

DROP TABLE IF EXISTS `category_tahara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_tahara` (
  `id` int(4) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `del_flg` int(10) DEFAULT NULL,
  `create_date` varchar(30) DEFAULT NULL,
  `update_date` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_tahara`
--

LOCK TABLES `category_tahara` WRITE;
/*!40000 ALTER TABLE `category_tahara` DISABLE KEYS */;
INSERT INTO `category_tahara` VALUES (0,NULL,0,'20250508103000','20250508103000'),(1,'�t�ؗ�',0,'20250508103000','20250508103000'),(2,'�ʍؗ�',0,'20250508103000','20250508103000'),(3,'���ؗ�',0,'20250508103000','20250508103000');
/*!40000 ALTER TABLE `category_tahara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character_orthography_nakano`
--

DROP TABLE IF EXISTS `character_orthography_nakano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `character_orthography_nakano` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character_orthography_nakano`
--

LOCK TABLES `character_orthography_nakano` WRITE;
/*!40000 ALTER TABLE `character_orthography_nakano` DISABLE KEYS */;
INSERT INTO `character_orthography_nakano` VALUES (0,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(1,'����������','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(2,'�����V����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'�V��������','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'�V���V����','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
/*!40000 ALTER TABLE `character_orthography_nakano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classification_nakano`
--

DROP TABLE IF EXISTS `classification_nakano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classification_nakano` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification_nakano`
--

LOCK TABLES `classification_nakano` WRITE;
/*!40000 ALTER TABLE `classification_nakano` DISABLE KEYS */;
INSERT INTO `classification_nakano` VALUES (0,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(1,'���L','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(2,'�N�w','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'���j','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'�Љ�Ȋw','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(5,'���R�Ȋw','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(6,'�Z�p�D�H�w','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(7,'�Y��','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(8,'�|�p�D���p','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(9,'����','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(10,'���w?','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
/*!40000 ALTER TABLE `classification_nakano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_nakaniwa`
--

DROP TABLE IF EXISTS `country_nakaniwa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_nakaniwa` (
  `id` int(11) NOT NULL,
  `country_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_nakaniwa`
--

LOCK TABLES `country_nakaniwa` WRITE;
/*!40000 ALTER TABLE `country_nakaniwa` DISABLE KEYS */;
INSERT INTO `country_nakaniwa` VALUES (0,'','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(1,'���{','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(2,'�؍�','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(3,'�A�����J','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(4,'����','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(5,'�C�M���X','0','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `country_nakaniwa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drama_main_nakaniwa`
--

DROP TABLE IF EXISTS `drama_main_nakaniwa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drama_main_nakaniwa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drama_title` varchar(256) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `release_year` int(4) NOT NULL,
  `season` int(2) DEFAULT NULL,
  `summary` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drama_main_nakaniwa`
--

LOCK TABLES `drama_main_nakaniwa` WRITE;
/*!40000 ALTER TABLE `drama_main_nakaniwa` DISABLE KEYS */;
INSERT INTO `drama_main_nakaniwa` VALUES (1,'�Ԃ��j�q',1,1,2005,2,'���}�ȏ��q���������������w�Z�ɓ��w�B�΂�����܂���̐t���u�X�g�[���[�I','0','2024-05-21 16:52:55','2024-05-27 13:08:22'),(2,'���̕s����',1,2,2019,1,'�p���O���C�_�[���A���̂Ɋ������܂ꂽ�؍��̍����ߏ삪�k���N�ɕs�����B�^���̈��ɒ��n���郉�u�X�g�[���[�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(3,'������`�l��Y���N��',1,1,2018,1,'��N���A���c�n�C�}�[�ɐN����鏗����t�ƌ������Ƃ̒j���́A���̊�Ղ�`���������u�X�g�[���[�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(4,'�C�J�Q�[��',2,2,2021,1,'�������̃Q�[���ւ̏��ҏ󂪋��ɍ����Ă���l�X�̌��֓͂��B�Q���҂͖������̃T�o�C�o���Q�[���ɒ��ނ��ƂɁc�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(5,'�E�H�[�L���O�E�f�b�h',2,3,2010,11,'�]���r���͂т���A�����J�𕑑�ɁA�l�Ԃ��������ɂԂ��肠���Ȃ���������������ׂ�͍����Ă����B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(6,'�^���u�����O',3,1,2010,1,'�j�q�V�̑���ʂ��Đ������鍂�Z����������`���X�|���t�h���}�I','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(7,'�v���Y���E�u���C�N',4,3,2005,5,'�l�߂Ŏ��Y��鍐���ꂽ�Z�������邽�߂ɁA��l���͌Z�Ɠ����Y�����ɓ���A�E������B�X�������O�ȃA�N�V�����h���}�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(8,'�u���b�V���A�b�v���C�t',5,1,2023,1,'���}�ȏ������l������蒼���p��`���^�C���X���b�v�R���f�B�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(9,'�������񂸃��u',5,1,2018,3,'���e�Ȃ�33�΂̂�������Ƃ��̏�i�̂������񂪌J��L����V���o�̃R���f�B�����h���}�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(10,'�~�X�e���ƌ����܂�',6,1,2022,1,'�ς��҂̑�w��������܂����Ď����̓�������Ă����V���o�~�X�e���[�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(11,'���Ȃ��̔Ԃł�',6,1,2019,2,'�V���v�w�������z�����}���V�����ŁA�Ђ��Ȃ��Ƃ���u�����E�l�Q�[���v���n�܂�c�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(12,'�����ł��Ȃ�������',1,4,2022,1,'�N��L�����A�E�[�}���ƔN���j���̗��I���L�����ԈႢ�Ȃ��̃��u�R���f�B�I','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(13,'��������',1,4,2018,1,'��������10�N���̂�������r�Ɏv�������鈤�̊�Ղ̕���B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(14,'���[�r���O',4,2,2023,1,'���\�͂����q�������Ɣ閧���B���e�������A���肭�鈫�Ɗ댯�ɗ������������\�̓A�N�V�����h���}�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(15,'silent',1,1,2022,1,'���Ė{�C�ň������l�Ɖ��̂Ȃ����E�ŏo������A�؂Ȃ������������u�X�g�[���[�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(16,'ONE DAY',1,5,2024,1,'��w���ƌセ�ꂼ��̓�����ݎn�߂���l�����A���̌�����ʂȌ𗬂𑱂��Ă������ƂɂȂ�c�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(17,'HEARTSTOPPER',1,5,2022,1,'�w�Z�ŏo��A�F�B�ɂȂ������N��l�B�₪�Č݂��ɗF��ȏ�̊��������悤�ɂȂ�c�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(18,'DIVE!!',3,1,2021,1,'��������_�C�r���O�N���u�̑����̂��߂ɁA�򍞋��Z�ŃI�����s�b�N��ڎw�����Z�������̐t�h���}�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(19,'�G�~���[�A�p���֍s��',1,3,2020,3,'�V�J�S�Ŏd���ɗ��ł�����l�����v���������p���ŔO��̐E����ɓ���A���̊C�O�������J�n����B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(20,'�����s���Y',5,1,2022,2,'�s���Y��Ђɋ΂߂�R�̂��Ȃ��c�ƃ}�����A�s���Y�ɂ܂��l�X�ȃg���u���ɗ����������Ă����R���f�B�h���}�B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(21,'TRICK',6,1,2000,3,'���̓V�˃}�W�V�����Ƒ�w�����̃R���r�����팻�ۂ�g���b�N�ɗ����������Ă�������B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(22,'���A�������̊w�Z�́c',2,2,2022,1,'�ˑR�]���r�E�C���X�������������Z�ɕ����߂�ꂽ���k�������A�����c�邽�߂ɗ͂����킹�Đ키����B','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(23,'������͒p�������ɗ���',1,1,2016,1,'�v���ٗp��ōȂ��]�ƈ��Ƃ����_�񌋍��������l�̐V���o�Љ�h���u�R���f�B�I','0','2024-05-21 16:52:55','2024-05-21 16:52:55');
/*!40000 ALTER TABLE `drama_main_nakaniwa` ENABLE KEYS */;
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
-- Table structure for table `game_evaluation_toho`
--

DROP TABLE IF EXISTS `game_evaluation_toho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_evaluation_toho` (
  `id` int(11) DEFAULT NULL,
  `evaluation` varchar(256) DEFAULT NULL,
  `del_flg` varchar(256) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_evaluation_toho`
--

LOCK TABLES `game_evaluation_toho` WRITE;
/*!40000 ALTER TABLE `game_evaluation_toho` DISABLE KEYS */;
INSERT INTO `game_evaluation_toho` VALUES (0,'','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(1,'���|�I�ɍD�]','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(2,'���ɍD�]','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(3,'���D�]','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(4,'�^�ۗ��_','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(5,'���s�]','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(6,'���ɕs�]','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(7,'���|�I�ɕs�]','0','2024-05-13 00:00:00','2024-05-13 00:00:00');
/*!40000 ALTER TABLE `game_evaluation_toho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_main_toho`
--

DROP TABLE IF EXISTS `game_main_toho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_main_toho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_title` varchar(256) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `evaluation_id` int(11) DEFAULT NULL,
  `subject` int(11) DEFAULT NULL,
  `company` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(256) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_main_toho`
--

LOCK TABLES `game_main_toho` WRITE;
/*!40000 ALTER TABLE `game_main_toho` DISABLE KEYS */;
INSERT INTO `game_main_toho` VALUES (1,'Monster Hunter: World',1,2,4,'CAPCOM Co., Ltd.','��͂胂���n���͖ʔ����B����̎�t��ɓ�̌�������������ȊO�́c�B','0','2024-05-14 00:00:00','2024-05-23 15:39:04'),(2,'�I�[�o�[�E�H�b�`R 2',2,7,5,'Blizzard Entertainment, Inc.','�F�B�Ƃ��Ȃ�y�����B�`���b�g�����r���炵�����A�����������Ƃ͂Ȃ��B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(3,'Among Us',3,2,10,'Innersloth','10�l�W�߂Ă��炪�{�ԁB3�l�̃C���|�X�^�[�������o�����B','0','2024-05-14 00:00:00','2024-05-28 09:25:55'),(4,'CONTENT WARNING',4,2,4,'Landfall Publishing','�L�����͊ɂ����A�G�͗e�͂Ȃ��B�Q�[�����ŎB��������͌ォ��m�F�E�ۑ����鎖���o����B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(5,'CORE KEEPER',5,2,8,'Fireshine Games','�T���E��ƍD���ɂ������߁B������Ƃ��T���͈͂��L�������肵�ĒB����������B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(6,'DEEP ROCK GALACTIC',2,1,4,'Coffee Stain Publishing','�n��ōz�΂��@��h���[�t�ɂȂ��B�ܘ_�o�g��������B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(7,'Don�Lt Starve Together',5,1,6,'Klei Entertainment','�l�X�ȃL����������A�����𗘗p���Ȃ��琶���c��A����B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(8,'ERESYS',4,4,4,'Dragonis Games','�N�g�D���t�_�b���D���Ȑl�ɂ������߁B�������������̃A�o�^�[�̕����|���B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(9,'LETHAL COMPANY',6,1,4,'Zeekerss','�댯�Șf���̔p�i�����C�����Ɛ�m�B���̎����Ɋ��ҁB','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(10,'PALWORLD',5,2,32,'Pocketpair','���L���ȃ����X�^�[��J�������悤�I','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(11,'Glitch Busters: Stuck On You',2,2,4,'Skybound Games','���4�l�ł���������y�����B�L�����N�^�[�͉����A�Q�[�������ʔ����A�ō��B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(12,'Unrailed!',1,2,4,'Daedalic Entertainment','���͂��ă��[����~����Ԃ�i�߂Ă����A��̃}�b�v�����Ȃ����蓹�����鎖���K�v�B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(13,'Overcooked! 2',1,2,4,'Team17','4�l�ŋ��͂��ė���������B���̂���ȏ��ɓX���c�H','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(14,'The Sims? 4',7,2,1,'Electronic Arts','�l�I�ɉƑ��肪��Ԋy�����B�V�����ǂ�Ȑl���𑗂�̂��͂��Ȃ��̎w������B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(15,'Doki Doki Literature Club!',8,1,1,'Team Salvato','�Ƃɂ������_�I�Ɍ��C�Ȏ��ɂ���Ăق����B�q���C���S�������͓I�ȃQ�[���B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(16,'Castle CrashersR',9,1,4,'The Behemoth','4�l�ŋ��͂��Ȃ���i��ł������A�X�e�[�W�̍Ō�͕P����荇��PVP���N����B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(17,'Craftopia / �N���t�g�s�A',10,3,8,'Pocketpair','���������y�����Q�[���B�ǂ����Ă��f��Ő킢�����B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(18,'For The King',11,2,3,'Curve Games','3�l�ő��k���Ȃ�����̂��y�����B�G�����\�����A�����j�󂵂Ă��鎖������B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(19,'Human Fall Flat',12,2,8,'Curve Games','�����B�ӂɂ�ӂɂ�̃L�������撣���ăX�e�[�W��i��ł����B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(20,'Left 4 Dead',2,1,4,'Valve','�]���r�f��̐��E�ς�̌��o����Q�[���B�^���N�I�I','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(21,'Left 4 Dead 2',2,1,4,'Valve','���ҁB���͑O��̃L�������o�Ă���B��Փx���オ���Ă���悤�ȋC������B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(22,'Nine Parchments',13,3,4,'Frozenbyte','�����_���Ŏ�ɓ��閂�@����g���ăX�e�[�W��i�ށB���ʂɓ���B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(23,'Phasmophobia',6,1,4,'Kinetic Games','������O�̂悤�Ɏ��ʁB�|����̓X�^�[�g���̃g���b�N����o�Ă��Ȃ��B','0','2024-05-14 00:00:00','2024-05-14 00:00:00'),(24,'Raft',7,2,8,'Axolot Games','�C�ʂ̃S�~��������A�ė��p���Ȃ���T�o�C�o��������B�n���ɂ₳�����Q�[���B','0','2024-05-14 00:00:00','2024-05-27 16:56:47'),(25,'�A�X�g�������p�[�e�B�[',11,4,4,'Neverland Entertainment','PVP�̂���l���Q�[���̂悤�ȃV�X�e���B���������̗ǂ��l�łȂ��Əo���Ȃ��B','0','2024-05-14 00:00:00','2024-05-14 00:00:00');
/*!40000 ALTER TABLE `game_main_toho` ENABLE KEYS */;
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
INSERT INTO `genre` VALUES (0,'',0,'2025-04-01 00:','2025-04-01 00:'),(1,'�A�N�V����',0,'2025-04-01 00:','2025-04-01 00:'),(2,'�T�X�y���X',0,'2025-04-01 00:','2025-04-01 00:'),(3,'�q���[�}��',0,'2025-04-01 00:','2025-04-01 00:'),(4,'�z���[',0,'2025-04-01 00:','2025-04-01 00:'),(5,'�R���f�B',0,'2025-04-01 00:','2025-04-01 00:');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_nakaniwa`
--

DROP TABLE IF EXISTS `genre_nakaniwa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_nakaniwa` (
  `id` int(11) NOT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_nakaniwa`
--

LOCK TABLES `genre_nakaniwa` WRITE;
/*!40000 ALTER TABLE `genre_nakaniwa` DISABLE KEYS */;
INSERT INTO `genre_nakaniwa` VALUES (0,'','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(1,'����','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(2,'�z���[','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(3,'�X�|�[�c','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(4,'�A�N�V����','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(5,'�R���f�B','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(6,'�~�X�e���[','0','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `genre_nakaniwa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_toho`
--

DROP TABLE IF EXISTS `genre_toho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_toho` (
  `id` int(11) DEFAULT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(256) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_toho`
--

LOCK TABLES `genre_toho` WRITE;
/*!40000 ALTER TABLE `genre_toho` DISABLE KEYS */;
INSERT INTO `genre_toho` VALUES (0,'','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(1,'�A�N�V����','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(2,'�V���[�e�B���O','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(3,'�\�[�V�����f�B�_�N�V����','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(4,'�A�h�x���`���[�Q�[��','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(5,'�I�[�v�����[���h�T�o�C�o���N���t�g','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(6,'�T�o�C�o���z���[','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(7,'�V�~�����[�V�����Q�[��','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(8,'�r�W���A���m�x��','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(9,'�x���g�X�N���[���A�N�V�����Q�[��','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(10,'�n�b�N�A���h�X���b�V��','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(11,'���[�O���C�N�Q�[��','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(12,'�p�Y���Q�[��','0','2024-05-13 00:00:00','2024-05-13 00:00:00'),(13,'�A�N�V����RPG','0','2024-05-13 00:00:00','2024-05-13 00:00:00');
/*!40000 ALTER TABLE `genre_toho` ENABLE KEYS */;
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
INSERT INTO `movie_actor` VALUES (0,'',0,'2025-04-01 00:','2025-04-01 00:'),(1,'�g���E�n���N�X',0,'2025-04-01 00:','2025-04-01 00:'),(2,'�g�r�[�E�}�O���C�A',0,'2025-04-01 00:','2025-04-01 00:'),(3,'�W�F�[���Y�E�}�J���H�C',0,'2025-04-01 00:','2025-04-01 00:'),(4,'�i�^���[�E�|�[�g�}��',0,'2025-04-01 00:','2025-04-01 00:'),(5,'�A���E�n�T�E�F�C',0,'2025-04-01 00:','2025-04-01 00:');
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
INSERT INTO `movie_main` VALUES (1,'�X�p�C�_�[�}��3',1,2,2007,155,'�X�p�C�_�[�}���̉f��̒��ł͈�ԍD��',1,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN�a����b�A�΂��ڂ��ʔ����B',1,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(3,'���I��',4,4,1994,110,'�}�`���_�����킢��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(4,'�_�[�N�i�C�g���C�W���O',1,5,2012,165,'DC�R�~�b�N�撣��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(5,'�x�C�r�[�h���C�o�[',1,NULL,2017,113,'���҂����삳��邻��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(6,'�g�����X',2,3,2013,101,'�_�j�[�E�{�C���ē�',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(7,'�t�B���X',2,3,2013,97,'�X�R�b�g�����h�̍ň��Y��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(8,'�ؗ�Ȃ�M���c�r�[',2,2,2013,143,'���؈��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(9,'�u���b�W�I�u�X�p�C',2,1,2015,144,'�A�J�f�~�[�����j�D�܎��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(10,'�_�E���B���`�E�R�[�h',2,1,2006,174,'�I�h���C�E�g�g�D�V�����Ȃ�',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(11,'�t�H���X�g�K���v',3,1,1994,142,'���킸�ƒm�ꂽ�����̕��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(12,'���S�Ȃ�`�F�b�N���C�g',3,2,2014,116,'�{�r�[�t�B�b�V���[',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(13,'���̍��l���',3,2,2001,90,'�Ⴉ�肵�f�B�J�v���I',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(14,'���~�[���u��',3,5,2012,160,'�̕����̓A�e���R�ł͂���܂���',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(15,'�O���[���}�C��',3,1,1999,189,'�w�V���[�V�����N�̋�Ɂx�������ł�',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(16,'�u���b�N�X����',4,4,2011,108,'����ȃz���[���|������',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TV���[�r�[�҂��ǂ���',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(18,'�L�����[',4,NULL,1976,98,'�X�e�B�[�u���E�L���O�̏�����',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(19,'�X�v���b�g',4,3,2017,117,'�V���}������i�����Ă����Ƌg',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(20,'�~�X�^�[�K���X',4,3,2019,129,'�X�v���b�g�̑���',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(21,'�}�C�E�C���^�[��',5,5,2015,121,'�w�v���_�𒅂������x����������',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(22,'�^�[�~�i��',5,1,2004,128,'��`�ɏZ��ł݂���',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(23,'�y�l���s',5,3,2008,104,'����̂��Ƃ��b',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(24,'�A���X�C�������_�[�����h',5,5,2010,113,'�f����������',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(25,'�L���b�c���h�b�O�X',5,2,2001,87,'���͂��킢��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(26,'���Ȃ�',NULL,3,2007,130,'�A�T�Ȏ��ɂ͂������߂��܂���',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(27,'�v���C�h�ƕΌ�',NULL,NULL,2005,135,'�R�����E�t�@�[�X�̃h���}�ł��ǂ�',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(28,'�O���C�e�X�g�V���[�}��',3,NULL,2017,105,'�l�I�Ƀ��E���E�����h�z��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(29,'�r�b�O',5,1,1988,130,'�f�G�ȋC���ɂȂ��',0,'2025-04-01 00:00:00','2025-04-01 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'�₽�獋�؂Ȕo�D�w',0,'2025-04-01 00:00:00','2025-04-01 00:00:00');
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

--
-- Table structure for table `vegetable_main_tahara`
--

DROP TABLE IF EXISTS `vegetable_main_tahara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vegetable_main_tahara` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vegetable_name` varchar(20) DEFAULT NULL,
  `category_id` int(3) DEFAULT NULL,
  `origin_place` varchar(20) DEFAULT NULL,
  `production_volume` int(100) DEFAULT NULL,
  `area_id` int(10) DEFAULT NULL,
  `recommend` varchar(100) DEFAULT NULL,
  `del_flg` int(10) DEFAULT NULL,
  `create_date` varchar(30) DEFAULT NULL,
  `update_date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vegetable_main_tahara`
--

LOCK TABLES `vegetable_main_tahara` WRITE;
/*!40000 ALTER TABLE `vegetable_main_tahara` DISABLE KEYS */;
INSERT INTO `vegetable_main_tahara` VALUES (1,'�g�}�g',2,'�M�уA�����J',706000,43,NULL,0,'20250508103000','20250508103000'),(2,'�L���x�c',1,'���[���b�p',1434000,10,NULL,0,'20250508103000','20250508103000'),(3,'�_�C�R��',3,'�����E���A�W�A',1254000,12,NULL,0,'20250508103000','20250508103000'),(4,'���}�m�C��',3,'���{',170500,1,NULL,0,'20250508103000','20250508103000'),(5,'�g�E�����R�V',2,'�M�уA�����J',234700,1,NULL,0,'20250508103000','20250508103000'),(6,'�u���b�R���[',1,'���[���b�p',174500,1,NULL,0,'20250508103000','20250508103000'),(7,'�T�g�C��',3,'�C���h�E�M�уA�W�A',139500,11,NULL,0,'20250508103000','20250508103000'),(8,'�~�Y�i',1,'���{',43800,8,NULL,0,'20250508103000','20250508103000'),(9,'�`���Q���T�C',1,'�����E���A�W�A',41400,8,NULL,0,'20250508103000','20250508103000'),(10,'�^�}�l�M',1,'�����E���A�W�A',1357000,1,NULL,0,'20250508103000','20250508103000'),(11,'�i�X',2,'�C���h�E�M�уA�W�A',297000,39,NULL,0,'20250508103000','20250508103000'),(12,'�C�`�S',2,'�M�уA�����J',159200,9,NULL,0,'20250508103000','20250508103000'),(13,'�L���E��',2,'�C���h�E�M�уA�W�A',539200,45,NULL,0,'20250508103000','20250508103000'),(14,'�T�c�}�C��',3,'�M�уA�����J',687600,46,NULL,0,'20250508103000','20250508103000'),(15,'�V�����M�N',1,'���[���b�p',27400,27,NULL,0,'20250508103000','20250508103000'),(16,'�X�C�J',2,'�A�t���J',310900,43,NULL,0,'20250508103000','20250508103000'),(17,'�j���W��',3,'�����E���A�W�A',585900,1,NULL,0,'20250508103000','20250508103000'),(18,'�W���K�C��',3,'��A�����J',2205000,1,NULL,0,'20250508103000','20250508103000'),(19,'�S�{�E',3,'���[���b�p',126900,2,NULL,0,'20250508103000','20250508103000'),(20,'�s�[�}��',2,'�M�уA�����J',143100,8,NULL,0,'20250508103000','20250508103000'),(21,'�j��',1,'�����E���A�W�A',57000,39,NULL,0,'20250508103000','20250508103000'),(22,'�l�M',1,'�����E���A�W�A',441100,8,NULL,0,'20250508103000','20250508103000'),(23,'�n�N�T�C',1,'�����E���A�W�A',892300,8,NULL,0,'20250508103000','20250508103000'),(24,'���^�X',1,'���[���b�p',563900,20,NULL,0,'20250508103000','20250508103000'),(25,'�z�E�����\�E',1,'�����E���A�W�A',213900,10,NULL,0,'20250508103000','20250508103000'),(26,'�J�u',3,'���[���b�p',104800,12,NULL,0,'20250508103000','20250508103000'),(27,'�V���E�K',3,'�����E���A�W�A',44700,39,NULL,0,'20250508103000','20250508103000'),(28,'�J�{�`��',2,'�M�уA�����J',186600,1,NULL,0,'20250508103000','20250508103000'),(29,'�T���G���h�E',2,'�����E���A�W�A',19500,46,NULL,0,'20250508103000','20250508103000'),(30,'�R�}�c�i',1,'���{',121900,8,NULL,0,'20250508103000','20250508103000'),(32,'�e�X�g�Q',2,'�e�X�g�Q',1100100,30,'�e�X�g�Q',0,'2025-05-23 16:59:20.751','2025-05-23 16:59:20.751'),(33,'�e�X�g�R',3,'�e�X�g�R',1100100,42,'�e�X�g�R',0,'2025-05-23 16:59:51.31','2025-05-23 16:59:51.31'),(34,'�e�X�g4',2,'�e�X�g4',1100100,12,'�e�X�g4',0,'2025-05-26 09:43:17.112','2025-05-26 10:26:50.618'),(35,'�e�X�g5',1,'�e�X�g5',1100100,10,'�e�X�g5',0,'2025-05-26 10:08:54.115','2025-05-26 10:27:33.698');
/*!40000 ALTER TABLE `vegetable_main_tahara` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-27 12:00:21
