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
INSERT INTO `album_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'Perfume〜Complete Best','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'GAME','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'��','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'JPN','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'Perfume Global Compilation','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'LOVE THE WORLD','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'LEVEL3','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'COSMIC EXPLORER','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'Future Pop','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Perfume The Best “P Cubed”','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
/*!40000 ALTER TABLE `album_anzai` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anime_main_watanabe`
--

LOCK TABLES `anime_main_watanabe` WRITE;
/*!40000 ALTER TABLE `anime_main_watanabe` DISABLE KEYS */;
INSERT INTO `anime_main_watanabe` VALUES (1,'Fate/Zero',1,2,2011,13,'2期','oath sign','0','2022-05-11 10:03:00','2022-05-19 13:40:06'),(2,'Fate/stay night[Unlimited Blade Works]',1,3,2014,26,'なし','ideal white','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(3,'鬼滅の刃　竈門炭治郎　立志編',1,1,2019,26,'2期、劇場アニメ','紅蓮華','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(4,'魔法少女まどか☆マギカ',2,4,2011,12,'なし','コネクト','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(5,'化物語',2,2,2009,15,'偽物語、猫物語など','staple stable','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(6,'ニセコイ',2,1,2014,23,'2期','CLICK','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(7,'ワールドトリガー',3,1,2014,73,'2期、3期','GIRIGIRI','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(8,'トリコ',3,1,2011,147,'なし','ガツガツ!!','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(9,'Kanon',3,3,2002,14,'2期','florescence','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(10,'あの日見た花の名前を僕たちはまだ知らない。',4,4,2011,11,'なし','青い栞','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(11,'ソードアート・オンライン',4,2,2012,26,'2期、3期','crossing field','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(12,'四月は君の嘘',4,1,2014,23,'なし','光るなら','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(13,'冴えない彼女の育てかた',4,2,2015,13,'2期、劇場アニメ','君色シグナル','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(14,'かぐや様は告らせたい〜天才たちの恋愛頭脳戦〜',4,1,2019,12,'2期、3期','ラブ・ドラマティック feat.伊原立花','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(15,'呪術廻戦',5,1,2020,24,'劇場アニメ、2期','廻廻奇譚','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(16,'ゾンビランドサガ',5,4,2018,12,'2期','徒花ネクロマンシー','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(17,'賭ケグルイ',5,1,2017,12,'2期、3期','Deal with the devil','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(18,'DEATH NOTE',6,1,2006,37,'なし','the WORLD','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(19,'魔法科高校の劣等生',6,2,2014,26,'2期、3期、4期','Rising Hope','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(20,'ノーゲーム・ノーライフ',6,2,2014,12,'なし','This game','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(21,'オーバーロード',6,2,2015,13,'2期、3期、4期、劇場アニメ','Clattanoia','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(22,'ワンパンマン',6,1,2015,12,'2期','THE HERO !! 〜怒れる拳に火をつけろ〜','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(23,'宇宙よりも遠い場所',6,4,2018,13,'なし','The Girls Are Alright!','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(24,'涼宮ハルヒの憂鬱',7,2,2006,14,'2期','冒険でしょでしょ？','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(25,'CLANNAD -クラナド-',7,3,2007,24,'2期','メグメル','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(26,'けいおん!',7,1,2009,14,'2期','Cagayake!GIRLS','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(27,'日常',7,1,2011,26,'なし','ヒャダインのカカカタ☆カタオモイ-C','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(28,'氷菓',7,2,2012,23,'なし','優しさの理由','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(29,'響けユーフォニアム',7,2,2015,13,'2期、劇場アニメ','DREAM SOLISTER','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(30,'ヴァイオレット・エヴァーガーデン',7,2,2018,14,'劇場アニメ','Sincerely','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(31,'true tears',8,3,2008,13,'なし','リフレクティア','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(32,'Angel Beats!',8,4,2010,15,'なし','My Soul, Your Beats!','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(33,'凪のあすから',8,4,2013,26,'なし','lull〜そして僕らは〜','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(34,'Charlotte',8,4,2015,14,'なし','Bravely You','0','2022-05-11 10:03:00','2022-05-11 10:03:00'),(35,'劇場版 Fate/stay night ［Heaven\'s Feel］ I. presage flower',1,3,2017,1,'劇場版第２章、第３章','花の唄','0','2022-05-18 15:04:15','2022-05-19 09:24:32'),(37,'SHIROBAKO',8,4,2014,26,'劇場版','COLORFUL BOX','0','2022-05-18 15:56:59','2022-05-18 15:56:59');
/*!40000 ALTER TABLE `anime_main_watanabe` ENABLE KEYS */;
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
INSERT INTO `artist` VALUES (1,'Zebrahead','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(2,'FLOW','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(3,'米津玄師','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(4,'Anly','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(5,'fox capture plan','0','2018-05-23 01:27:00','2018-05-23 01:27:00');
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
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0�ｼ壽怏蜉ｹ縲�1�ｼ夂┌蜉ｹ',
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
INSERT INTO `attribute_kawamura` VALUES (0,NULL,'0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(1,'エンペラーペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(2,'アデリーペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(3,'フンボルトペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(4,'マカロニペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(5,'キンメペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(6,'コガタペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00');
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
INSERT INTO `broadcast_station_ige` VALUES (0,NULL,'0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(1,'NHK総合','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(2,'日本テレビ','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'テレビ朝日','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'TBS','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'フジテレビ','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(6,'テレビ東京','0','2021-05-18 12:00:00','2021-05-18 12:00:00');
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
INSERT INTO `company_umehara` VALUES (0,NULL,NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'ANYCOLOR株式会社','https://www.anycolor.co.jp/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'カバー株式会社','https://cover-corp.com/',NULL,NULL,2016,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'株式会社岩本町芸能社','https://rbc-geino.com/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'ななし株式会社','https://774.co.jp/',NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'その他',NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'未所属',NULL,NULL,NULL,NULL,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_watanabe`
--

LOCK TABLES `company_watanabe` WRITE;
/*!40000 ALTER TABLE `company_watanabe` DISABLE KEYS */;
INSERT INTO `company_watanabe` VALUES (0,NULL,'0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(1,'ufotable','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(2,'シャフト','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(3,'東映アニメーション','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(4,'A-1 Pictures','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(5,'MAPPA','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(6,'マッドハウス','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(7,'京都アニメーション','0','2022-05-11 10:04:00','2022-05-11 10:04:00'),(8,'P.A.WORKS','0','2022-05-11 10:04:00','2022-05-11 10:04:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contents_umehara`
--

LOCK TABLES `contents_umehara` WRITE;
/*!40000 ALTER TABLE `contents_umehara` DISABLE KEYS */;
INSERT INTO `contents_umehara` VALUES (0,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'ゲーム','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'歌','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'作業','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'雑談','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'ゲーム・歌','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'ゲーム・作業','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'ゲーム・雑談','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(8,'歌・作業','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(9,'歌・雑談','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(10,'作業・雑談','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(11,'ゲーム・歌・作業','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(12,'ゲーム・歌・雑談','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(13,'歌・雑談・作業','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(14,'ゲーム・歌・雑談・作業','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
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
INSERT INTO `dog_country_kanno` VALUES (0,NULL,'0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(1,'メキシコ','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(2,'イギリス','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'ドイツ','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'イタリア','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'オーストラリア','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(6,'日本','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(7,'フランス','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(8,'中国','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(9,'アメリカ','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(10,'コンゴ','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(11,'ロシア','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(12,'スイス','0','2020-05-21 00:00:00','2020-05-21 00:00:00');
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
INSERT INTO `dog_main_kanno` VALUES (1,'ゴールデン・レトリーバー',2,4,'温厚で賢くフレンドリー。セラピー犬などに向く犬種','/dogKanno/20200605152150187.jpg','0','2020-05-21 00:00:00','2020-06-05 15:21:50'),(2,'ラブラドール・レトリーバー',2,4,'泳ぐことが得意。盲導犬としても活躍する。','Lab.png','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'ヨークシャー・テリア',2,1,'気品あふれる性格。毛が長く様々なカットスタイルが楽しめる。','yorkey.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'ポメラニアン',3,1,'好奇心が強く勇敢。SNSで風に吹かれる動画が話題になった。','pome.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'柴犬',6,2,'誠実な性格が世界中で人気を呼んでいる。','shiba.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(6,'パピヨン',7,2,'なでられることを好む。飾り毛がかわいい。','papi.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(7,'ボーダーコリー',2,3,'抜群の運動神経。牧羊犬として用いられてきた。','border.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(8,'キャバリア・キング・チャールズ・スパニエル',2,2,'明るく陽気。寂しがりやな一面も。','cavalier.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(9,'ドーベルマン',3,4,'利口で警戒心が強く、警察犬などとして活躍する。','doberman.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(10,'トイプードル',7,2,'フレンドリーかつ毛が抜けにくいため、介護施設などでのセラピー犬に向いている。','toypoo.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(11,'ミニチュア・ダックスフンド',3,2,'甘えん坊。胴長短足のルックスで愛されている。','dachs.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(12,'シェットランド・シープドッグ',2,2,'責任感が強く用心深いが愛想のよい犬種。','sheltie.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(13,'スコティッシュ・テリア',2,2,'活発で首領犬らしい荒っぽさも持つ。','scottish.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(14,'イタリアン・グレーハウンド',4,2,'穏やかな性格。スタイル抜群でよく走る。','italian.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(15,'秋田犬',6,4,'天然記念物に登録されている。冬の寒さに強い。','akitainu.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(16,'ジャック・ラッセル・テリア',5,2,'昔キツネ狩りをしていたため動くものに俊敏に反応する。','jack.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(17,'ミニチュア・シュナウザー',3,2,'協調性があり、飼い主に徹底的に尽くす。','schnauzer.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(18,'アメリカン・コッカー・スパニエル',9,3,'陽気な性格。毛質が絹糸のように柔らかい。','american.jpg','0','2020-05-21 00:00:00','2020-06-08 13:30:10'),(19,'バセンジー',10,3,'利口で人類にとって理想の犬といわれている。','basenji.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(20,'ブルドッグ',2,3,'厳つい見た目の割に優しい性格をしている。','bull.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(21,'シベリアン・ハスキー',9,4,'仲間意識が強い。犬ぞりを牽引するカッコいい犬。','husky.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(22,'バーニーズ・マウンテン・ドッグ',12,4,'やんちゃで甘えん坊。眉毛があるような顔立ちをしている。','bernese.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(23,'セント・バーナード',12,5,'この犬が主役のベートーベンというコメディ映画があります。','st.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(24,'グレート・ピレニーズ',7,5,'愛情深く優雅な雰囲気を持っている。','grate.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(25,'ボルゾイ',11,4,'オオカミの狩猟をしていた。体高が大きくスレンダーなからだつき。','borzoi.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(26,'シェパード',3,4,'訓練向き、ショー向きなどのタイプ別に性格が異なるがいずれも冷静さをもっている。','shepherd.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(27,'甲斐犬',6,3,'秋田犬につぐ二番目の天然記念物。しつこくしても怒らない。','kai.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(28,'チャウ・チャウ',8,3,'番犬に向いている。ブルーブラックの舌が特徴。','chow.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(29,'チワワ',1,1,'献身的で甘え上手。警戒心が強く割と吠える。','chihuahua.png','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(30,'パグ',8,2,'ぶさカワ代表。人懐こく番犬には向かない。','pug.jpg','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(31,'北海道犬',6,3,'某CMでお父さん役に起用され、注目を集めた。','/dogKanno/20200605141724403.jpg','0','2020-06-05 14:17:24','2020-06-05 16:28:41');
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
INSERT INTO `dog_size_kanno` VALUES (0,NULL,'0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(1,'超小型','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(2,'小型','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(3,'中型','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(4,'大型','0','2020-05-21 00:00:00','2020-05-21 00:00:00'),(5,'超大型','0','2020-05-21 00:00:00','2020-05-21 00:00:00');
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
INSERT INTO `drama_main_ige` VALUES (1,'絶対零度',1,5,'2020冬','月','1期は上戸彩、それ以降は沢村一樹主演の刑事ドラマ。','0','2021-05-18 12:00:00','2021-05-27 15:43:25'),(2,'病院の治し方',2,6,'2020冬','月','倒産危機から奇跡の復活を遂げた病院の実話がモデル、主演は小泉孝太郎。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'やめるときも、すこやかなるときも',3,2,'2020冬','月','同名小説を藤ヶ谷太輔主演で実写化。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'10の秘密',4,5,'2020冬','火','主演は向井理。様々な秘密に翻弄される。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'恋はつづくよどこまでも',3,4,'2020冬','火','漫画の実写化。佐藤健、上白石萌音が出演し、『恋つづ』の愛称でもおなじみ。','0','2021-05-18 12:00:00','2021-05-31 10:40:10'),(6,'SEDAI WARS',5,4,'2020冬','水','近未来の日本が舞台。山田裕貴主演。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(7,'知らなくていいコト',5,2,'2020冬','水','お仕事系ヒューマンドラマ。週刊編集部を舞台に記者の主人公を吉高由里子が演じる。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(8,'僕はどこから',4,6,'2020冬','水','同名漫画を中島裕翔主演で実写化。特殊能力をもつ主人公の青春サスペンス。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(9,'DASADA',6,2,'2020冬','木','秋元康の企画。日向坂46が主演を務める学園ドラマ。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(10,'来世ではちゃんとします',3,6,'2020冬','木','内田理央主演のラブコメディ。漫画の実写化。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(11,'ケイジとケンジ',1,3,'2020冬','木','桐谷健太と東出昌大がダブル主演の完全オリジナルストーリー。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(12,'アライブがん専門医のカルテ',2,5,'2020冬','木','がんに立ち向かう2人の女医のメディカルヒューマンドラマ。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(13,'ランチ合コン探偵',3,2,'2020冬','木','主演は地上波連ドラ初主演の山本美月。謎を解いていく。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(14,'ゆるキャン△',7,6,'2020冬','金','ソロキャンプをする女子高校生達のゆるやかな日常描く。福原遥主演。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(15,'駐在刑事2',1,6,'2020冬','金','寺島進演じる\"駐在さん\"が町の平和を守るために奮闘する。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(16,'病室で念仏を唱えないでください',2,4,'2020冬','金','僧侶で救急救命医という主人公が葛藤する姿を描く、医療ヒューマンドラマ','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(17,'女子高校生の無駄遣い',6,3,'2020冬','金','漫画の実写化。女子高校生達の日常を描くコメディ。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(18,'トップナイフ',2,2,'2020冬','土','手術の天才が集う病院の脳神経外科が舞台。主演は天海祐希。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(19,'テセウスの船',8,4,'2020冬','日','竹内涼真演じる主人公が、父親の事件を解決するためタイムスリップする。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(20,'SUITS2',NULL,5,'2020春','月','全米の大ヒットドラマのシーズン２。敏腕弁護士と天才助手で問題を解決していく。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(21,'正しいロックバンドの作り方',NULL,2,'2020春','火','不器用でダメダメだけど愛すべき4人がトップレベルの音楽フェスを目指す物語。藤井流星、神山智洋主演。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(22,'探偵・由利麟太郎',4,5,'2020春','火','地上波初主演の吉川晃司と志尊淳がバディとなり、京都の奇怪な世界を現代風に解釈してく。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(23,'ハケンの品格',5,2,'2020春','水','2007年に放送されたお仕事ドラマの続編。働くことの本質に迫る。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(24,'レンタルなんもしない人',NULL,6,'2020春','木','増田貴久主演。Twitterで話題となったレンタルなんもしない人をモデルにドラマ化。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(25,'BG〜身辺警護人〜',11,3,'2020春','木','木村拓哉主演。民間ボディーガードの姿を描くシリーズ作。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(26,'MIU404',1,4,'2020春','金','綾野剛と星野源ダブル主演、野木亜紀子が脚本の人気作。機動捜査隊の物語。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(27,'未満警察',1,2,'2020春','土','中島健人、平野紫耀がダブル主演。韓国の人気映画を日本版にリメイク。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(28,'DIVER−特殊潜入班−',1,5,'2020夏','火','福士蒼汰が初のダークヒーロー役。悪の組織に潜入して事件解決していく。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(29,'私の家政夫ナギサさん',3,4,'2020夏','火','家事ができないキャリアウーマンの主人公がおじさん家政夫を雇うことから始まるラブコメ。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(30,'私たちはどうかしている',8,2,'2020夏','水','老舗和菓子店を舞台に、浜辺美波と横浜流星演じる2人の恋模様を描きつつ事件に迫るラブミステリー。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(31,'アンサングシンデレラ',2,5,'2020夏','木','石原さとみ主演。病院薬剤師が奮闘しながら患者と向き合う姿を描く。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(32,'彼女が成仏できない理由',NULL,1,'2020夏','土','外国人留学生と幽霊が織りなすちょっと切ないラブコメディ。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(33,'親バカ青春白書',9,2,'2020夏','日','娘を溺愛するあまり同じ大学へ入学した父（ムロツヨシ）と娘（永野芽郁）の絆を描くホームコメディ。','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(38,'恋はDeepに',3,2,'2021春','水','石原さとみと綾野剛','0','2021-05-27 16:37:53','2021-05-27 16:38:20');
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
INSERT INTO `drink_category_yoshimoto` VALUES (0,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'水','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'緑茶','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'麦茶','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'紅茶','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'コーヒー','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'ココア','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'果汁飲料','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'炭酸飲料','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'スポーツ飲料','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'ノンアルコール','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'ビール','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'ワイン','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'酎ハイ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'ウィスキー','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'焼酎','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'牛乳','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'豆乳','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
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
INSERT INTO `drink_main_yoshimoto` VALUES (1,'コカ・コーラ　ゼロ',8,2,'/DrinkImageYoshimoto/coke.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'おーいお茶',2,3,'/DrinkImageYoshimoto/20200602141508665.jpg','0','2020-05-19 00:00:00','2020-06-02 14:15:08'),(3,'ザ・プレミアム・モルツ',11,1,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'アサヒスーパードライ',11,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'ミルクココア',6,16,'/DrinkImageYoshimoto/20200602141621489.jpg','0','2020-05-19 00:00:00','2020-06-02 14:16:21'),(6,'明治おいしい牛乳',16,11,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'梅よろし',7,7,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'コバラサポート',8,NULL,'/DrinkImageYoshimoto/kobara.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'アクエリアス',9,2,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'REAL　GOLD',8,2,'/DrinkImageYoshimoto/gold.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'いろはす　もも',1,2,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'トロピカーナ　マルチビタミン',7,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'信州韃靼そば茶',NULL,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'健康ミネラルむぎ茶',3,3,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'ウェルチ　グレープ',7,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'ミウ',1,7,'/DrinkImageYoshimoto/miu.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'キリンレモン',8,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'カルピスウォーター',NULL,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'メグミルク',16,15,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(20,'調整豆乳',17,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(21,'豆乳飲料　ソーダ',17,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(22,'氷結ストロング　巨峰スパークリング',13,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(23,'プレミアムボス　アロマロースト',5,1,'/DrinkImageYoshimoto/boss.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(24,'午後の紅茶　おいしい無糖',4,6,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(25,'王様の涙（赤）',12,NULL,'/DrinkImageYoshimoto/king.jpg','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(26,'のんある気分　レモンサワーテイスト',10,1,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(27,'バンホーテン　ミルク　ココア',6,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(29,'いいとも',15,NULL,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(30,'三ツ矢サイダー',8,5,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(31,'トロピカーナ 100%オレンジ',7,6,NULL,'0','2020-05-29 15:28:29','2020-06-01 13:03:03'),(32,'Suntory Whisky 角瓶',14,1,NULL,'1','2020-06-01 11:50:00','2020-06-01 11:50:00'),(33,'ポカリスウェット',9,NULL,'/DrinkImageYoshimoto/20200602141840669.jpg','0','2020-06-01 12:02:34','2020-06-02 14:18:40');
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
INSERT INTO `drink_maker_yoshimoto` VALUES (0,'','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'サントリー','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'コカ・コーラ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'伊藤園','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'ヤクルト','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'アサヒ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'キリン','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'ダイドー','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'サッポロ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'カゴメ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'小岩井','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'明治','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'日清','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'よつ葉','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'トンボ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'雪印','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'森永','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'味の素','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'ネスレ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'サンガリア','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
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
INSERT INTO `forms_umehara` VALUES (0,NULL,'0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(1,'生配信','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'動画投稿','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'ショート動画','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'生配信・動画投稿','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'生配信・ショート動画','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'動画投稿・ショート動画','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'生配信・動画投稿・ショート動画','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
/*!40000 ALTER TABLE `forms_umehara` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_genre_miura`
--

LOCK TABLES `game_genre_miura` WRITE;
/*!40000 ALTER TABLE `game_genre_miura` DISABLE KEYS */;
INSERT INTO `game_genre_miura` VALUES (1,0,NULL,'0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(2,1,'RPG','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(3,2,'オープンワールド','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(4,3,'MOBA','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(5,4,'SRPG','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(6,5,'MMORPG','0','2022-05-18 00:00:00','2022-05-18 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_main_miura`
--

LOCK TABLES `game_main_miura` WRITE;
/*!40000 ALTER TABLE `game_main_miura` DISABLE KEYS */;
INSERT INTO `game_main_miura` VALUES (1,1,'ファイナルファンタジー1',1,6,1987,'歴史の始まり','1','2022-05-18 00:00:00','2022-05-31 10:22:40'),(2,2,'ファイナルファンタジー2',1,6,1988,'ウボア---','1','2022-05-18 00:00:00','2022-05-18 00:00:00'),(4,4,'ファイナルファンタジー4',1,1,1991,'ゴルベーザ四天王','0','2022-05-18 00:00:00','2022-06-01 09:09:40'),(5,5,'ファイナルファンタジー5',1,1,1992,'チョコボが目立つ','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(6,6,'ファイナルファンタジー6',1,1,1994,'先日600万円のフィギュアが作成された','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(7,7,'ファイナルファンタジー7',1,2,1997,'リメイクで知名度上昇中','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(8,8,'ファイナルファンタジー8',1,2,1999,'ガンブレード','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(9,9,'ファイナルファンタジー9',1,2,2000,'原点回帰がテーマ、言わずもがな名作','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(10,10,'ファイナルファンタジー10',1,8,2001,'シリーズの中で一番の知名度？','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(11,11,'ファイナルファンタジー11',5,8,2002,'初のオンライン型','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(12,12,'ファイナルファンタジー12',1,8,2006,'グラフィックの進化が凄い','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(13,13,'ファイナルファンタジー13',1,3,2009,'PS３初期作品、私は好き','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(14,14,'ファイナルファンタジー14',5,5,2010,'今も覇権のMMO','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(15,15,'ファイナルファンタジー15',1,4,2016,'シナリオ以外面白い','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(16,16,'ドラゴンクエスト1',1,6,1986,'伝説の始まり','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(17,17,'ドラゴンクエスト2',1,6,1987,'正直よく知らない','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(18,18,'ドラゴンクエスト3',1,6,1988,'HD-2Dリメイクが出ます','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(19,19,'ドラゴンクエスト4',1,6,1990,'いつか自分でやりたい','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(20,20,'ドラゴンクエスト5',1,1,1992,'私はビアンカ派','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(21,21,'ドラゴンクエスト6',1,1,1995,'バーバラのHP増やしてください','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(22,22,'ドラゴンクエスト7',1,2,2000,'話が重いし長い','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(23,23,'ドラゴンクエスト8',1,8,2004,'今ではスマホでできる作品','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(24,24,'ドラゴンクエスト9',1,7,2009,'初めてのドラクエはこれでした','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(25,25,'ドラゴンクエスト10',5,5,2013,'あまり知らない','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(26,26,'ドラゴンクエスト11',1,4,2017,'ボリュームがかなりあった','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(27,27,'Skyrim',2,3,2011,'次回作出るまでは生きる','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(28,28,'Fallout4',2,4,2015,'現実にならないよう祈るばかり','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(29,29,'League_of _Legends',3,5,2009,'eスポーツとして盛り上がっている','0','2022-05-18 00:00:00','2022-05-18 00:00:00'),(30,30,'タクティクスオウガ',4,1,1995,'リメイクが出るという噂がある','0','2022-05-18 00:00:00','2022-05-18 00:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'アクション',0,'2017/11/08','2017/11/08'),(2,'サスペンス',0,'2017/11/08','2017/11/08'),(3,'ヒューマン',0,'2017/11/08','2017/11/08'),(4,'ホラー',0,'2017/11/08','2017/11/08'),(5,'コメディ',0,'2017/11/08','2017/11/08');
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
INSERT INTO `genre_ige` VALUES (0,NULL,'0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(1,'刑事','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(2,'医療','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(3,'恋愛','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(4,'サスペンス','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(5,'社会派','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(6,'学園','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(7,'人間ドラマ','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(8,'ミステリー','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(9,'コメディ','0','2021-05-18 12:00:00','2021-05-18 12:00:00'),(11,'アクション','0','2021-05-18 12:00:00','2021-05-18 12:00:00');
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
INSERT INTO `genre_ishikawa` VALUES (0,NULL,'0','2020-03-24 11:40:38','2020-03-24 11:40:41'),(1,'主食','0','2020-03-24 11:40:58','2020-03-24 11:41:01'),(2,'主菜','0','2020-03-24 11:41:18','2020-03-24 11:41:21'),(3,'副菜','0','2020-03-24 11:41:36','2020-03-24 11:41:39');
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
INSERT INTO `location_takehara` VALUES (0,'','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(1,'城東','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'城西','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'城南','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'城北','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'分類無し','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
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
INSERT INTO `maker_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'ANCHOR（アンカー）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'ARGON18(アルゴン18）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'Bianchi（ビアンキ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'BH(ビーエイチ)','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'BMC(ビーエムシー）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'BOMA（ボーマ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'CANYON（キャニオン）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'cervelo（サーヴェロ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'CIPOLLINI（チッポリーニ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'COLNAGO（コルナゴ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'CUBE BIKES（キューブバイクス）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'DIAMOND BIKES（ダイアモンドバイクス）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'EDDYMERCKX（エディメルクス）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'FACTOR（ファクター）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'FELT（フェルト）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'FUJI（フジ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'GIANT（ジャイアント）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'KhodaaBloom（コーダーブルーム）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'KUOTA（クオータ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'MERIDA（メリダ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'PINARELLO（ピナレロ）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'RIDLEY（リドレー）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'SCOTT（スコット）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'SPECIALIZED（スペシャライズド）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'TREK（トレック）','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'Wilier（ウィリエール）','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
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
INSERT INTO `movie_actor` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'トム・ハンクス',0,'2017/11/08','2017/11/08'),(2,'トビー・マグワイア',0,'2017/11/08','2017/11/08'),(3,'ジェームズ・マカヴォイ',0,'2017/11/08','2017/11/08'),(4,'ナタリー・ポートマン',0,'2017/11/08','2017/11/08'),(5,'アン・ハサウェイ',0,'2017/11/08','2017/11/08');
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
INSERT INTO `movie_main` VALUES (1,'スパイダーマン3',1,2,2007,155,'スパイダーマンの映画の中では一番好き',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN誕生秘話、ばちぼこ面白い。',0,'2017-11-08 00:00:00','2021-05-27 15:33:27'),(3,'レオン',1,4,1994,110,'マチルダがかわいい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'ダークナイトライジング',1,5,2012,165,'DCコミック頑張れ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'ベイビードライバー',1,NULL,2017,113,'続編が制作されるそう',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'トランス',2,3,2013,101,'ダニー・ボイル監督',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'フィルス',2,3,2013,97,'スコットランドの最悪刑事',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'華麗なるギャツビー',2,2,2013,143,'豪華絢爛',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'ブリッジオブスパイ',2,1,2015,144,'アカデミー助演男優賞受賞',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'ダ・ヴィンチ・コード',2,1,2006,174,'オドレイ・トトゥ老けたなあ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'フォレストガンプ',3,1,1994,142,'言わずと知れた名言の宝庫',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'完全なるチェックメイト',3,2,2014,116,'ボビーフィッシャー',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'あの頃僕らは',3,2,2001,90,'若かりしディカプリオ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'レミゼラブル',3,5,2012,160,'歌部分はアテレコではありません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'グリーンマイル',3,1,1999,189,'『ショーシャンクの空に』もいいです',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'ブラックスワン',4,4,2011,108,'下手なホラーより怖いかも',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TVムービー編もどうぞ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'キャリー',4,NULL,1976,98,'スティーブン・キングの処女作',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'スプリット',4,3,2017,117,'シャマラン作品を見ておくと吉',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'ミスターガラス',4,3,2019,129,'スプリットの続編',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'マイ・インターン',5,5,2015,121,'『プラダを着た悪魔』もおすすめ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'ターミナル',5,1,2004,128,'空港に住んでみたい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'ペネロピ',5,3,2008,104,'現代のおとぎ話',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'アリスインワンダーランド',5,5,2010,113,'映像美すごい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'キャッツ＆ドッグス',5,2,2001,87,'犬はかわいい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'つぐない',NULL,3,2007,130,'陰鬱な時にはおすすめしません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'プライドと偏見',NULL,NULL,2005,135,'コリン・ファースのドラマ版も良き',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'グレイテストショーマン',3,NULL,2017,105,'個人的にラ・ラ・ランド越え',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'ビッグ',5,1,1988,130,'素敵な気持になれる',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'やたら豪華な俳優陣',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
INSERT INTO `music` VALUES (4,'心太?','任??',5,'年代比?久?的一首歌，当年很流行，?在依然有很多人喜?。',3,'https://www.youtube.com/embed/ZSWeurc1yMw','2018-03-19 15:12:14','2018-03-19 15:12:14',5),(9,'漂洋?海来看?','娃娃',5,'',3,'https://www.youtube.com/embed/hNQohQBFnwI','2018-03-19 16:05:12','2018-03-19 16:05:12',2),(10,'雪の華','中島美嘉',5,'',6,'https://www.youtube.com/embed/mF5Qq2YheTg','2018-03-19 17:18:19','2019-03-28 15:26:31',2),(11,'MY ALL','濱崎?',5,'',5,'https://www.youtube.com/embed/PKptgq8jTYw','2018-03-19 17:27:07','2018-03-19 17:27:07',1),(12,'Time after time 〜花舞う街で〜','?木麻衣',5,'',4,'https://www.youtube.com/embed/Ep_W5rYXyi0','2018-03-19 17:28:57','2018-03-19 17:28:57',1),(13,'夢的點滴','松隆子',5,'',6,'https://www.youtube.com/embed/Vn6xGeMY9w8','2018-03-19 17:31:46','2018-03-19 17:31:46',1),(14,'big big world','Emilia',5,'',5,'https://www.youtube.com/embed/wpkS2DU_qMs','2018-03-19 17:33:04','2018-03-19 17:33:04',0);
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
INSERT INTO `nbaplayers_main_takahashi` VALUES (1,NULL,'レブロン・ジェームス',3,23,206,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,NULL,'ステフィン・カリー',1,21,191,86,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,NULL,'ケビン・デュラント',3,2,208,108,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,NULL,'ヤニス・アンテトクンポ',4,10,211,109,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,NULL,'クワイ・レナード',3,22,201,104,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(6,NULL,'二コラ・ヨキッチ',5,16,213,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(7,NULL,'ジェームズ・ハーデン',2,2,196,99,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(8,NULL,'ジョエル・エンビード',5,4,213,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(9,NULL,'ルカ・ドンチッチ',1,26,201,98,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(10,NULL,'デイミアン・リラード',1,19,188,88,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(11,NULL,'アンソニー・デイビス',4,23,208,114,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(12,NULL,'ジミー・バトラー',3,13,201,104,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(13,NULL,'カイリー・アービング',1,2,188,87,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(14,NULL,'ザイオン・ウィリアムソン',4,29,198,128,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(15,NULL,'ジェイソン・テイタム',3,1,203,94,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(16,NULL,'ブラッドリー・ビール',2,15,191,93,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(17,NULL,'クリス・ポール',1,24,183,79,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(18,NULL,'クレイ・トンプソン',2,21,198,97,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(19,NULL,'ジュリアス・ランドル',4,3,203,113,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(20,NULL,'デビン・ブッカー',2,24,196,95,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(21,NULL,'ドノバン・ミッチェル',2,20,185,97,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(22,NULL,'ポール・ジョージ',2,22,203,99,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(23,NULL,'カール・アンソニータウンズ',5,17,211,112,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(24,NULL,'ラッセル・ウエストブルック',1,15,191,90,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(25,NULL,'ルディ・ゴベア',5,20,216,110,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(26,NULL,'ザック・ラビーン',2,6,198,90,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(27,NULL,'トレイ・ヤング',1,11,185,81,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(28,NULL,'シェイ・ギルジャス=アレクサンダー',2,18,196,81,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(29,NULL,'ディアロン・フォックス',1,25,191,79,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(30,NULL,'バム・アデバヨ',5,13,206,115,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(31,NULL,'ベン・シモンズ',1,4,208,105,'','1','2021-06-08 15:26:54','2021-06-08 15:26:54'),(32,NULL,'八村塁',4,15,203,103,'','0','2021-06-09 14:05:57','2021-06-09 14:05:57');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `original_watanabe`
--

LOCK TABLES `original_watanabe` WRITE;
/*!40000 ALTER TABLE `original_watanabe` DISABLE KEYS */;
INSERT INTO `original_watanabe` VALUES (0,NULL,'0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(1,'漫画','0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(2,'小説','0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(3,'ゲーム','0','2022-05-11 10:05:00','2022-05-11 10:05:00'),(4,'オリジナル','0','2022-05-11 10:05:00','2022-05-11 10:05:00');
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
  `del_flg` varchar(1) DEFAULT NULL COMMENT '0�ｼ壽怏蜉ｹ縲�1�ｼ夂┌蜉ｹ',
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
INSERT INTO `penguin_main_kawamura` VALUES (1,'コウテイペンギン',1,'南極大陸周辺の定着氷上に生息　体の大きさNo.1（日本の水族館で見る事が出来る）','/penguinKawamura/コウテイ_penguin.jpg','0','2019-12-03 15:08:00','2020-03-23 10:08:48'),(2,'キングペンギン',1,'亜南極の島々に生息（日本の水族館で見る事が出来る）','/penguinKawamura/キング_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(3,'アデリーペンギン',2,'南極大陸の沿岸域、周辺の島々に生息　ICカードSuicaのモデルになったペンギン（日本の水族館で見る事が出来る）','/penguinKawamura/アデリー_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(4,'ジェンツーペンギン',2,'南極大陸の氷の張っていない地域、亜南極の島々に生息　唯一足の色がオレンジのペンギン　泳ぎの速さNo.1（日本の水族館で見る事が出来る）','/penguinKawamura/ジェンツー_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(5,'ヒゲペンギン',2,'南極半島に生息　（日本の水族館で見る事が出来る）','/penguinKawamura/ヒゲ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(6,'ガラパゴスペンギン',3,'ガラパゴス諸島に生息　フンボルトペンギン属の中でくちばしの細さNo.1（日本では見れない）','/penguinKawamura/ガラパゴス_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(7,'ケープペンギン',3,'南アフリカ共和国の沿岸部に生息　アフリカに生息するペンギンはケープペンギンだけ（日本の水族館で見る事が出来る）','/penguinKawamura/ケープ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(8,'フンボルトペンギン',3,'フンボルト海流が流れる南アメリカ西部に生息　寒いのが苦手　日本で飼育数No.1のペンギン（日本の水族館で見る事が出来る）','/penguinKawamura/フンボルト_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(9,'マゼランペンギン',3,'チリ・アルゼンチン・フォークランド諸島に生息　夫婦の仲の良さNo.1（日本の水族館で見る事が出来る）','/penguinKawamura/マゼラン_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(10,'フィヨルドランドペンギン',4,'フィヨルド地域・オークランド諸島・スチュワート島などに生息（日本では見れない）','/penguinKawamura/フィヨルドランド_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(11,'シュレーターペンギン',4,'バウンティ諸島・オークランド諸島・マッコリー島などに生息（日本では見れない）','/penguinKawamura/シュレーター_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(12,'スネアーズペンギン',4,'スネアーズ島(ニュージーランドの南に位置する島)に生息（日本では見れない）','/penguinKawamura/スネアーズ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(13,'マカロニペンギン',4,'チリの南部・大西洋からインド洋にかけて生息　ペンギンの中で個体数No.1（日本の水族館で見る事が出来る）','/penguinKawamura/マカロニ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(14,'ロイヤルペンギン',4,'オーストラリア・ニュージーランド・マッコリー島に生息（日本では見れない）','/penguinKawamura/ロイヤル_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(15,'イワトビペンギン',4,'サウスシェトランド諸島・キャンベル島などに生息（日本の水族館で見る事が出来る）','/penguinKawamura/イワトビ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(16,'キガシラペンギン',5,'ニュージーランドに生息　ペンギン類の中で数の少なさNo1（日本では見れない）','/penguinKawamura/キガシラ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(17,'コガタペンギン',6,'ニュージーランド・オーストラリアの南岸に生息　体の小ささNo.1（日本の水族館で見る事が出来る）','/penguinKawamura/コガタ_penguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00'),(18,'シロツバサペンギン',6,'バンクス半島・モトナウ島に生息　（日本では見れない）','/penguinKawamura/シロツバサ_panguin.jpg','0','2019-12-03 15:08:00','2019-12-03 15:08:00');
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
INSERT INTO `perfume_main_anzai` VALUES (1,'OMAJINAI☆ペロリ',2002,'パッパラー河合',NULL,NULL,'広島時代のデビュー曲','0','2019-10-29 00:00:00','2019-11-06 13:04:05'),(2,'彼氏募集中',2002,'パッパラー河合',NULL,NULL,'広島時代の名曲','0','2019-10-29 00:00:00','2019-11-06 10:34:05'),(3,'スウィートドーナッツ',2003,'木の子',1,NULL,'全国インディーズデビュー曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'ビタミンドロップ',2004,'木の子',1,NULL,'もうやる事のないアイドル曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'モノクロームエフェクト',2004,'木の子',1,NULL,'もうやる事のないアイドル曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'リニアモーターガール',2005,'中田ヤスタカ',1,NULL,'メジャーデビューの曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'エレクトロ・ワールド',2006,'中田ヤスタカ',1,NULL,'ライブではみんなで盛り上がる','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'パーフェクトスター・パーフェクトスタイル',2006,'中田ヤスタカ',1,NULL,'当時発売されたアルバムの唯一の新曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'チョコレイト・ディスコ',2007,'中田ヤスタカ',2,NULL,'バレンタイン定番曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Twinkle Snow Powdery Snow',2007,'中田ヤスタカ',2,NULL,'チョコレイトディスコと一緒発表された','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(11,'ポリリズム',2007,'中田ヤスタカ',2,1,'この曲で爆発的ヒット','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(12,'SEVENTH HEAVEN',2007,'中田ヤスタカ',6,NULL,'ただただかわいい','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(13,'Baby cruising Love',2008,'中田ヤスタカ',2,3,'映画「モテキ」で使用','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(14,'マカロニ',2008,'中田ヤスタカ',2,NULL,'冬におススメの一曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(15,'GAME',2008,'中田ヤスタカ',2,NULL,'アルバム曲、ダンスがめちゃくちゃかっこいい','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(16,'セラミックガール',2008,'中田ヤスタカ',2,2,'深夜ドラマで使われていた','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(17,'シークレットシークレット',2008,'中田ヤスタカ',2,1,'アイス「ピノ」のCMだった気がする','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(18,'Puppy love',2008,'中田ヤスタカ',2,NULL,'みんなで上下上上','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(19,'edge',2008,'中田ヤスタカ',3,NULL,'かっこいいがめちゃくちゃ曲が長い','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(20,'love the world',2008,'中田ヤスタカ',3,NULL,'モノクロのPVが斬新','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(21,'Dream Fighter',2008,'中田ヤスタカ',3,NULL,'初めての武道館で発表された','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(22,'ワンルーム・ディスコ',2009,'中田ヤスタカ',3,NULL,'新生活応援ソング','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(23,'I still love U',2009,'中田ヤスタカ',3,NULL,'足つぼしながらPV撮った曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(24,'NIGHT FLIGHT',2009,'中田ヤスタカ',3,1,'これも「ピノ」のCMの曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(25,'ナチュラルに恋して',2010,'中田ヤスタカ',4,1,'アパレルのCM曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(26,'VOICE',2010,'中田ヤスタカ',4,1,'PVの最後きれいにはまる','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(27,'FAKE IT',2010,'中田ヤスタカ',6,NULL,'ライブがぶち上がる曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(28,'ねぇ',2010,'中田ヤスタカ',5,1,'アパレルのCM曲、ダンスのステップが独特','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(29,'微かなカオリ',2011,'中田ヤスタカ',5,1,'「氷結」のCM　可愛い','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(30,'レーザービーム',2011,'中田ヤスタカ',5,1,'「氷結」のCM　かっこいい','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(31,'GLITTER',2011,'中田ヤスタカ',5,1,'「氷結」のCM　かっこいい','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(32,'スパイス',2011,'中田ヤスタカ',5,2,'「氷結」のCM　かっこいい','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(33,'MY COLOR',2011,'中田ヤスタカ',5,NULL,'世界でも愛された一曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(34,'コミュニケーション',2012,'中田ヤスタカ',NULL,1,'プルプルつんつん','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(35,'Spring of Life',2012,'中田ヤスタカ',7,1,'衣装が光る','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(36,'Hurly Burly',2012,'中田ヤスタカ',10,1,'ポップなダンスナンバー','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(37,'Spending all my time',2012,'中田ヤスタカ',7,1,'海外進出する際に出した曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(38,'だいじょばない',2013,'中田ヤスタカ',7,NULL,'のっちが靴をとばした曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(39,'未来のミュージアム',2013,'中田ヤスタカ',7,3,'映画「ドラえもん」の主題歌','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(40,'Magic of Love',2013,'中田ヤスタカ',7,1,'「ピュレグミ」のCM起用','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(41,'Handy Man',2013,'中田ヤスタカ',7,NULL,'のっちが海外で盛大に間違えた曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(42,'ふりかえるといるよ',2013,'中田ヤスタカ',7,NULL,'幽霊の曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(43,'Party Maker',2013,'中田ヤスタカ',7,NULL,'盛り上がる曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(44,'1mm',2013,'中田ヤスタカ',7,NULL,'最終電車に揺られてる','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(45,'Sweet Refrain',2013,'中田ヤスタカ',8,2,'長澤まさみ主演ドラマの主題歌','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(46,'恋は前傾姿勢',2013,'中田ヤスタカ',8,NULL,'まえのめり','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(47,'Cling Cling',2014,'中田ヤスタカ',8,1,'シングルなのにCDがかなり大きい','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(48,'いじわるなハロー',2014,'中田ヤスタカ',NULL,NULL,'Cling　Cling　のカップリング','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(49,'DISPLAY',2014,'中田ヤスタカ',10,1,'４KテレビのCM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(50,'Hold Your Hand',2014,'中田ヤスタカ',8,2,'ファンと作ったPVが印象的','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(51,'Pick Me Up',2015,'中田ヤスタカ',8,1,'伊勢丹とのコラボ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(52,'Relax In The City',2015,'中田ヤスタカ',8,1,'シングルなのにCDがかなり大きい箱','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(53,'TOKIMEKI LIGHTS',2015,'中田ヤスタカ',8,NULL,'好きな曲だが印象が薄い','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(54,'STAR TRAIN',2015,'中田ヤスタカ',8,3,'15年のすべてを詰め込んだ曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(55,'FLASH',2016,'中田ヤスタカ',8,3,'映画「ちはやふる」で使用された','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(56,'STORY',2016,'中田ヤスタカ',8,1,'docomoの企画で4Gを使った演出がすごかった','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(57,'Next Stage with YOU',2016,'中田ヤスタカ',8,1,'ベンツCMに起用','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(58,'Miracle Worker',2016,'中田ヤスタカ',8,NULL,'曲の途中の「おこせミラコー」が特徴的','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(59,'Cosmic Explorer',2016,'中田ヤスタカ',8,NULL,'アルバム初めの曲。','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(60,'TOKYO GIRL',2017,'中田ヤスタカ',9,2,'吉高由里子主演ドラマの主題歌','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(61,'宝石の雨',2017,'中田ヤスタカ',9,1,'｢Ora2｣ TV CMソング','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(62,'Everyday',2017,'中田ヤスタカ',9,1,'「pnasonic」の洗濯機のCM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(63,'If you wanna',2017,'中田ヤスタカ',9,NULL,'フューチャーベースを取り入れた曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(64,'無限未来',2018,'中田ヤスタカ',9,3,'映画「ちはやふる」で使用された','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(65,'Let Me Know',2018,'中田ヤスタカ',9,NULL,'PVが可愛い','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(66,'天空',2018,'中田ヤスタカ',9,1,'docomoのCMで使用、2019年最初に披露した曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(67,'Tiny Baby',2018,'中田ヤスタカ',9,NULL,'ライブ演出がすごい','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(68,'Future Pop',2018,'中田ヤスタカ',9,NULL,'2019年紅白で披露した曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(69,'ナナナナナイロ',2019,'中田ヤスタカ',10,1,'旅をテーマとした曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(70,'Challenger',2019,'中田ヤスタカ',10,NULL,'中田ヤスタカとの出会いの曲','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(72,'Perfume',2006,'',NULL,NULL,'','0','2019-11-06 14:01:10','2019-11-06 14:01:10');
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
INSERT INTO `player_bt_kuramoto` VALUES (0,NULL,0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(1,'右投・右打',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(2,'右投・左打',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(3,'右投・両打',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(4,'左投・右打',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(5,'左投・左打',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(6,'左投・両打',0,'2021-05-19 00:00:00','2021-05-19 00:00:00');
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
INSERT INTO `player_main_kuramoto` VALUES (3,'三嶋一輝',1,3,9,9,'福岡県',0,'2021-05-19 00:00:00','2021-06-02 11:27:40'),(4,'山崎康晃',1,1,28,7,'東京都',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(5,'濱口遥大',1,5,26,5,'佐賀県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(6,'平田真吾',1,1,31,8,'山口県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(7,'三上朋也',1,1,32,8,'岐阜県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(8,'F.ロメロ',1,1,26,1,'ドミニカ共和国',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(9,'M..ピープルズ',1,1,29,2,'アメリカ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(10,'砂田毅樹',1,5,25,8,'北海道',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(11,'E.エスコバー',1,5,29,5,'ベネズエラ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(12,'国吉佑樹',1,1,29,12,'大阪府',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(13,'中川虎大',1,1,21,4,'和歌山県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(14,'高城俊人',2,1,28,10,'福岡県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(15,'嶺井博希',2,1,29,8,'沖縄県',1,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(16,'中井大介',3,1,31,14,'三重県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(17,'牧秀吾',3,1,23,1,'長野県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(18,'大和',3,1,33,16,'鹿児島県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(19,'田中俊太',3,2,27,4,'神奈川県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(20,'宮崎敏郎',3,1,32,9,'佐賀県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(21,'知野直人',3,1,22,3,'新潟県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(22,'山下幸輝',3,2,28,7,'千葉県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(23,'N.ソト',3,1,32,4,'プエルトリコ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(24,'桑原将志',4,1,27,10,'大阪府',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(25,'佐野恵太',4,2,26,5,'岡山県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(26,'神里和毅',4,2,27,4,'沖縄県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(27,'T.オースティン',4,1,29,2,'アメリカ',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(28,'乙坂智',4,2,27,10,'神奈川県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(29,'関根大気',4,5,25,8,'愛知県',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(30,'今永昇太',1,5,27,6,'福岡県',0,'2021-06-01 15:31:56','2021-06-01 15:31:56'),(31,'楠本泰史',4,2,25,4,'大阪府',0,'2021-06-01 15:37:26','2021-06-01 15:37:26');
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
INSERT INTO `player_position_kuramoto` VALUES (0,NULL,0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(1,'投手',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(2,'捕手',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(3,'内野手',0,'2021-05-19 00:00:00','2021-05-19 00:00:00'),(4,'外野手',0,'2021-05-19 00:00:00','2021-05-19 00:00:00');
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
INSERT INTO `position_takahashi` VALUES (0,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(1,'ポイントガード','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,'シューティングガード','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,'スモールフォワード','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,'パワーフォワード','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,'センター','0','2021-05-18 00:00:00','2021-05-18 00:00:00');
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
INSERT INTO `resipe_main_ishikawa` VALUES (1,'カレー','かれー',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'クリームシチュー','くりーむしちゅー',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'肉じゃが','にくじゃが',1,2,1,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'ロールキャベツ','ろーるきゃべつ',3,4,2,50,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'ポトフ','ぽとふ',2,3,3,30,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'白菜ミルフィーユ','はくさいみるふぃーゆ',5,0,2,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'酢豚','すぶた',1,3,2,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'夏野菜グラタン','なつやさいぐらたん',7,8,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'みぞれ鍋','みぞれなべ',5,11,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'きんぴら','きんぴら',1,10,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'ピーマンの肉詰め','ぴーまんのにくづめ',3,6,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'ハンバーグ','はんばーぐ',3,0,2,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'親子丼','おやこどん',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(14,'筍ごはん','たけのこごはん',12,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(15,'牛丼','ぎゅうどん',3,0,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(16,'かぼちゃの煮物','かぼちゃのにもの',9,0,3,25,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(17,'豚汁','とんじる',1,3,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(18,'栗ご飯','くりごはん',13,0,1,90,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(19,'ポテトサラダ','ぽてとさらだ',2,3,3,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(20,'ナポリタン','なぽりたん',6,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(21,'ラタトュユ','らたとぃゆ',7,8,3,40,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(22,'ビシソワーズ','びしそわーず',2,0,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(23,'トマト煮','とまとに',3,7,3,20,'0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(24,'ポモドーロ','ぽもどーろ',7,8,1,15,'0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
INSERT INTO `team_takahashi` VALUES (0,NULL,'0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(1,'ボストン・セルティックス','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(2,'ブルックリン・ネッツ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(3,'ニューヨーク・ニックス','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(4,'フィラデルフィア・セブンティシクサーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(5,'トロント・ラプターズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(6,'シカゴ・ブルズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(7,'クリーブラント・キャバリアーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(8,'デトロイト・ピストンズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(9,'インディアナ・ペイサーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(10,'ミルウォーキー・バックス','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(11,'アトランタ・ホークス','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(12,'シャーロット・ホーネッツ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(13,'マイアミ・ヒート','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(14,'オーランド・マジック','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(15,'ワシントン・ウィザーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(16,'デンバー・ナゲッツ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(17,'ミネソタ・ティンバーウルブズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(18,'オクラホマシティ・サンダー','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(19,'ポートランド・トレイルブレイザーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(20,'ユタ・ジャズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(21,'ゴールデンステイト・ウォリアーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(22,'ロサンゼルス・クリッパーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(23,'ロサンゼルス・レイカーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(24,'フェニックス・サンズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(25,'サクラメント・キングス','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(26,'ダラス・マーベリックス','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(27,'ヒューストン・ロケッツ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(28,'メンフィス・グリズリーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(29,'ニューオーリンズ・ペリカンズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00'),(30,'サンアントニオ・スパーズ','0','2021-05-18 00:00:00','2021-05-18 00:00:00');
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
INSERT INTO `tieup_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'CM','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'ドラマ','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'映画','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
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
INSERT INTO `tokyo_main_takehara` VALUES (1,'千代田','/tokyoTakehara/chiyoda.jpg',5,64533,11.66,'九段下',784,6330721,'樹木希林','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'中央','/tokyoTakehara/chuo.png',1,163185,10.21,'新富町',556,8219777,'若林正恭','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'港','/tokyoTakehara/minato.png',3,258075,20.37,'大門',902,3611975,'関根勤','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'新宿','/tokyoTakehara/shinjuku.png',2,347661,18.22,'新宿西口',477,3263794,'ルー大柴','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'文京','/tokyoTakehara/bunkyo.png',4,232801,11.29,'後楽園',544,1181450,'野々村真','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(6,'台東','/tokyoTakehara/taito.png',1,206816,10.11,'上野',385,1376259,'天海祐希','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(7,'墨田','/tokyoTakehara/sumida.png',1,268192,13.77,'浅草',350,589458,'大竹一樹','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(8,'江東','/tokyoTakehara/koto.png',1,516636,40.16,'東陽町',389,583708,'持田香織','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(9,'品川','/tokyoTakehara/shinagawa.png',3,407084,22.84,'下神明',427,1160600,'遠藤憲一','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(10,'目黒','/tokyoTakehara/meguro.png',3,286462,14.67,'中目黒',537,1195400,'泉谷しげる','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(11,'大田','/tokyoTakehara/ota.png',3,737700,60.83,'蒲田',395,627693,'片桐はいり','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(12,'世田谷','/tokyoTakehara/setagaya.png',2,933708,58.05,'世田谷',506,690153,'中井貴一','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(13,'渋谷','/tokyoTakehara/shibuya.png',2,233060,15.11,'渋谷',703,4234271,'吉永小百合','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(14,'中野','/tokyoTakehara/nakano.png',2,328215,15.59,'中野',387,812547,'田中裕二','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(15,'杉並','/tokyoTakehara/suginami.png',2,582864,34.06,'南阿佐ヶ谷',436,617023,'松田龍平','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(16,'豊島','/tokyoTakehara/toshima.png',4,300512,13.01,'東池袋',412,1147581,'山下達郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(17,'北','/tokyoTakehara/kita.png',4,352806,20.61,'王子',344,657836,'古舘伊知郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(18,'荒川','/tokyoTakehara/arakawa.png',4,217692,10.16,'荒川二丁目',345,605586,'片岡鶴太郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(19,'板橋','/tokyoTakehara/itabashi.png',4,581066,32.22,'板橋区役所前',350,475214,'稲垣吾郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(20,'練馬','/tokyoTakehara/nerima.png',2,737906,48.08,'練馬',395,435136,'上戸彩','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(21,'足立','/tokyoTakehara/adachi.png',4,681309,53.25,'梅島',324,367663,'ビートたけし','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(22,'葛飾','/tokyoTakehara/katsushika.png',1,453522,34.8,'西新井大師西',333,362640,'二宮和也','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(23,'江戸川','/tokyoTakehara/edogawa.png',1,693519,49.9,'新小岩',346,392703,'松崎しげる','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
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
INSERT INTO `triathlon_main_mori` VALUES (1,'RS9s',1,1,800000,'/TriathlonMori/001.jpg','0','2020-03-11 00:00:00','2020-03-23 15:02:09'),(2,'RT9',2,1,410000,'/TriathlonMori/002.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'GALLIUM PRO',1,2,380000,'/TriathlonMori/003.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'E-119 TRI+',2,2,576000,'/TriathlonMori/004.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'OLTRE XR4',1,3,1780000,'/TriathlonMori/005.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'AQUILA CV',2,3,900000,'/TriathlonMori/006.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'G8 PRO',1,4,748000,'/TriathlonMori/007.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'AEROLIGHT',2,4,1050000,'/TriathlonMori/008.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'Timemachine Road 01',1,5,880000,'/TriathlonMori/009.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'Timemachine 01',2,5,870000,'/TriathlonMori/010.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'VIDE pro CT-RTV',1,6,500000,'/TriathlonMori/011.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'SWOOP CT-TT',2,6,418000,'/TriathlonMori/012.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'Ultomate CF Evo',1,7,899000,'/TriathlonMori/013.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'Speedmax CF SLX LTD',2,7,1109000,'/TriathlonMori/014.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'S5',1,8,1580000,'/TriathlonMori/015.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'P5X',2,8,2280000,'/TriathlonMori/016.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'RB1K \"THE ONE\"',1,9,720000,'/TriathlonMori/017.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'NKTT',2,9,990000,'/TriathlonMori/018.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'C64',1,10,738000,'/TriathlonMori/019.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'K.one',2,10,620000,'/TriathlonMori/020.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'LITENING C:68X SLT',1,11,1176000,'/TriathlonMori/021.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'AERIUM C:68 SLT',2,11,1387000,'/TriathlonMori/022.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'TRILLIANT',2,12,470000,'/TriathlonMori/023.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'CARBONADO',2,12,370000,'/TriathlonMori/024.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'525',1,13,466000,'/TriathlonMori/025.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'LUGANO68',2,13,278000,'/TriathlonMori/026.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(27,'O2 V.A.M',1,14,590000,'/TriathlonMori/027.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(28,'SLICK',2,14,680000,'/TriathlonMori/028.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(29,'FR FRD',1,15,1980000,'/TriathlonMori/029.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(30,'IA FRD',2,15,2480000,'/TriathlonMori/030.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(31,'TRANSONIC 1.1',1,16,340000,'/TriathlonMori/031.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(32,'NORCOM STRAIGHT 1.1',2,16,290000,'/TriathlonMori/032.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(33,'PROPEL ADVANCED SL',1,17,1300000,'/TriathlonMori/033.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(34,'TRINITY ADVANCE PRO 1',2,17,690000,'/TriathlonMori/034.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(35,'STRAUSS PRO',1,18,248000,'/TriathlonMori/035.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(36,'STRAUSS TRI',2,18,199000,'/TriathlonMori/036.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(37,'KHAN',1,19,365000,'/TriathlonMori/037.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(38,'KT05',2,19,460000,'/TriathlonMori/038.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(39,'SCULTURA 10K-E',1,20,1200000,'/TriathlonMori/039.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(40,'TIME WARP TRI 10K-E',2,20,1350000,'/TriathlonMori/040.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(41,'DOGMA F12',1,21,1300000,'/TriathlonMori/041.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(42,'BOLIDE TR+',2,21,1570000,'/TriathlonMori/042.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(43,'HELIUM SLX',1,22,365000,'/TriathlonMori/043.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(44,'DEAN',2,22,323000,'/TriathlonMori/044.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(45,'FOIL PREMIUM',1,23,1118000,'/TriathlonMori/045.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(46,'PLASMA RC',2,23,1190000,'/TriathlonMori/046.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(47,'S-Works VENGE',1,24,1375000,'/TriathlonMori/047.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(48,'S-Works Shiv',2,24,1404000,'/TriathlonMori/048.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(49,'Madone SLR 9',1,25,1281000,'/TriathlonMori/049.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(50,'Speed Concept',2,25,510000,'/TriathlonMori/050.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(51,'ZERO SLR',1,26,590000,'/TriathlonMori/051.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(52,'TURBINE',2,26,650000,'/TriathlonMori/052.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(53,'こじろう',0,0,100,'/TriathlonMori/20200323150234372.jpg','0','2020-03-19 11:02:07','2020-03-23 15:02:34'),(54,'もも',1,8,9999999,NULL,'1','2020-03-23 09:12:05','2020-03-23 09:12:05'),(55,'もも',1,10,1,'/TriathlonMori/20200323150336788.jpg','0','2020-03-23 15:03:36','2020-03-23 15:03:36');
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
INSERT INTO `type_mori` VALUES (0,NULL,'0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(1,'ロードバイク','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(2,'タイムトライアルバイク（TT)','0','2020-03-11 00:00:00','2020-03-11 00:00:00');
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
INSERT INTO `vegetable_ishikawa` VALUES (1,'にんじん','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'じゃがいも','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'たまねぎ','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(4,'キャベツ','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(5,'白菜','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(6,'ピーマン','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(7,'トマト','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(8,'ナス','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(9,'かぼちゃ','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(10,'ごぼう','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(11,'だいこん','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(12,'筍','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(13,'栗','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
INSERT INTO `vtuber_main_umehara` VALUES (1,'月ノ美兎',1,1,1,862000,'https://www.youtube.com/channel/UCD-miitqNY3nyukJ4Fnf4_A','2018-02-01 00:00:00','生放送を中心にYoutubeで活動している、バーチャル世界の学級委員に所属の女子高生。','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(2,'兎田ぺこら',2,1,1,1930000,'https://www.youtube.com/channel/UC1DCedRgGHBdm81E1llLhOQ/','2019-07-03 00:00:00','ホロライブ3期生','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(3,'剣持刀矢',1,1,1,630000,'https://www.youtube.com/channel/UCv1fFr156jc65EMiLbaLImw','2018-03-06 00:00:00','一人称が「わし」','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(4,'宝鐘マリン',2,1,1,1910000,'https://www.youtube.com/channel/UCCzUftO8KOVkV4wQG1vkUvg/','2019-07-22 00:00:00','ホロライブ三期生','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(5,'戌神ころね',2,1,1,1810000,'https://www.youtube.com/channel/UChAnqc_AY5_I3Px5dig3X1Q/','2019-03-25 00:00:00','ホロライブ所属','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(6,'葛葉',1,1,1,1270000,'https://www.youtube.com/channel/UCSFCh5NL4qXrAy9u-u2lX3g/','2018-03-05 00:00:00','石油王に求婚され養われることを目標にしている。','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(7,'大空スバル',2,1,1,1310000,'https://www.youtube.com/channel/UCvzGlP9oQwU--Y0r9id_jnA/','2018-08-22 00:00:00','総合格闘技部とe-sports部のマネージャー','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(8,'さくらみこ',2,1,1,1440000,'https://www.youtube.com/channel/UC-hM6YJuNYVAmUWxeIr9FeA/','2018-04-25 00:00:00','ホロライブ所属のエリート巫女アイドル','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(9,'叶',1,1,1,994000,'https://www.youtube.com/channel/UCspv01oxUFf_MTSipURRhkA/','2018-05-01 00:00:00','にじさんじ所属ライバー','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(10,'キズナアイ',4,1,1,3090000,'https://www.youtube.com/channel/UC4YaOt1yT-ZeyB0OmxHgolA/','2016-10-19 00:00:00','活動休止中','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(11,'湊あくあ',2,1,1,1620000,'https://www.youtube.com/channel/UC1opHUrw8rvnsadT-iGp7Cg/','2018-08-01 00:00:00','ホロライブ所属すーぱーあいどるゲーマーメイド','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(12,'白上フブキ',2,1,1,1870000,'https://www.youtube.com/channel/UCdn5BQ06XqgXoAxIhbqw5Rg/','2018-05-24 00:00:00','狐(FOX)のバーチャル狐として活動','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(13,'しぐれうい',5,1,1,725000,'https://www.youtube.com/channel/UCt30jJgChL8qeT9VPadidSw/','2018-09-16 00:00:00','イラストレーター','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(14,'戌亥とこ',1,1,1,606000,'https://www.youtube.com/channel/UCXRlIK3Cw_TJIQC5kSJJQMg/','2019-03-19 00:00:00','ゲームに歌に雑談に、いろんな事をしている','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(15,'白銀ノエル',2,1,1,1480000,'https://www.youtube.com/channel/UCdyqAaZDKHXg4Ahi7VENThQ/','2019-07-26 00:00:00','おっとりしているが、なんでも筋力でどうにかする物騒な面を持つ ゆるふわ脳筋女騎士','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(16,'星街すいせい',2,1,1,1450000,'https://www.youtube.com/channel/UC5CwaMl1eIgY8h02uZw7u8A/','2018-03-18 00:00:00','アイドルVtuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(17,'夢月ロア',1,1,1,353000,'https://www.youtube.com/channel/UCCVwhI5trmaSxfcze_Ovzfw/','2019-01-15 00:00:00','にじさんじ所属 ','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(18,'本間ひまわり',1,1,1,692000,'https://www.youtube.com/channel/UC0g1AE0DOjBYnLhkgoRWN1w/','2018-07-02 00:00:00','ほぼ毎日ゲーム配信をしている。','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(19,'輝夜月',4,1,1,914000,'https://www.youtube.com/channel/UCQYADFw7xEJ9oZSM5ZbqyBw/','2017-12-05 00:00:00','【オフィシャルHP】http://www.kaguyaluna.jp/','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(20,'富士葵',4,1,1,343000,'https://www.youtube.com/c/Aoich/','2017-10-25 00:00:00','2022/04/20　ニューシングルリリース','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(21,'鈴鹿詩子',1,1,1,531000,'https://www.youtube.com/channel/UCwokZsOK_uEre70XayaFnzA/','2018-03-06 00:00:00','歌のお姉さんで腐女子で婚活中の26歳','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(22,'社築',1,1,1,611000,'https://www.youtube.com/channel/UCKMYISTJAQ8xTplUPHiABlA/','2018-05-25 00:00:00','ただのオタク','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(23,'天音かなた',2,1,1,1190000,'https://www.youtube.com/channel/UCZlDXzGoo7d44bwdNObFacg/','2019-12-04 00:00:00','ホロライブ4期生','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(24,'不知火フレア',2,1,1,877000,'https://www.youtube.com/channel/UCvInZx9h3jC2JzsIzoOebWg/','2019-07-26 00:00:00','ホロライブ三期生','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(25,'でびでび・でびる',1,1,1,481000,'https://www.youtube.com/channel/UCjlmCrq4TP1I4xguOtJ-31w/','2019-01-31 00:00:00','にじさんじ所属おそろしいあくまのちゃんねるどうがとはいしんをする','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(26,'GawrGura',2,1,1,3940000,'https://www.youtube.com/channel/UCoSrY_IQQVpmIRZ9Xf-y93g/','2020-07-16 00:00:00','ホロライブENに所属','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(27,'犬山たまき',4,1,1,823000,'https://www.youtube.com/channel/UC8NZiqKx6fsDT3AVcMiVFyA/','2017-06-30 00:00:00','漫画家 佃煮のりおが個人運営しているバーチャルYouTuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(28,'星川サラ',1,1,1,765000,'https://www.youtube.com/channel/UC9V3Y3_uzU5e-usObb6IE1w/','2019-09-25 00:00:00','お喋りとゲームと歌がだいすき','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(29,'大神ミオ',2,1,1,982000,'https://www.youtube.com/channel/UCp-5t9SrOQwXMU7iIjQfARg/','2018-12-01 00:00:00','ホロライブ所属のVtuber','0','2022-05-06 10:00:00','2022-05-06 10:00:00'),(30,'笹木咲',1,1,1,731000,'https://www.youtube.com/channel/UCoztvTULBYd3WmStqYeoHcA/','2018-07-02 00:00:00','ゲームだいすき','0','2022-05-06 10:00:00','2022-05-06 10:00:00');
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

-- Dump completed on 2022-06-01 13:59:11
