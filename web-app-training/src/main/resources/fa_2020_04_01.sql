-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fa
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `age_saito`
--

DROP TABLE IF EXISTS `age_saito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `age_saito` (
  `age_id` int(1) NOT NULL,
  `age` varchar(3) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`age_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `age_saito`
--

LOCK TABLES `age_saito` WRITE;
/*!40000 ALTER TABLE `age_saito` DISABLE KEYS */;
INSERT INTO `age_saito` VALUES (0,'','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(1,'昭和','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(2,'平成','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(3,'令和','0','2020-01-30 00:00:00','2020-01-30 00:00:00');
/*!40000 ALTER TABLE `age_saito` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `album_anzai` VALUES (0,'','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(1,'Perfume～Complete Best','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(2,'GAME','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(3,'⊿','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(4,'JPN','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(5,'Perfume Global Compilation','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(6,'LOVE THE WORLD','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(7,'LEVEL3','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(8,'COSMIC EXPLORER','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(9,'Future Pop','0','2019-10-29 00:00:00','2019-10-29 00:00:00'),(10,'Perfume The Best “P Cubed”','0','2019-10-29 00:00:00','2019-10-29 00:00:00');
/*!40000 ALTER TABLE `album_anzai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album_kawada`
--

DROP TABLE IF EXISTS `album_kawada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album_kawada` (
  `album_id` int(11) NOT NULL,
  `album` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album_kawada`
--

LOCK TABLES `album_kawada` WRITE;
/*!40000 ALTER TABLE `album_kawada` DISABLE KEYS */;
INSERT INTO `album_kawada` VALUES (0,NULL,'0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(1,'CAVU','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(2,'eureka','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(3,'monolith','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(4,'sonor','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(5,'SOIL','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(6,'TOY','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(7,'YON','0','2019-12-04 17:26:00','2019-12-04 17:26:00');
/*!40000 ALTER TABLE `album_kawada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_uriu`
--

DROP TABLE IF EXISTS `animal_uriu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal_uriu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `animal` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` int(11) NOT NULL,
  `update_date` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_uriu`
--

LOCK TABLES `animal_uriu` WRITE;
/*!40000 ALTER TABLE `animal_uriu` DISABLE KEYS */;
INSERT INTO `animal_uriu` VALUES (0,NULL,'0',2019,2019),(1,'イヌ','0',2019,2019),(2,'ネコ','0',2019,2019),(3,'ウシ','0',2019,2019),(4,'ウサギ','0',2019,2019),(5,'カエル','0',2019,2019),(6,'ネズミ','0',2019,2019),(7,'オオカミ','0',2019,2019),(8,'クマ','0',2019,2019),(9,'ヒツジ','0',2019,2019),(10,'アヒル','0',2019,2019),(11,'ワシ','0',2019,2019),(12,'ペンギン','0',2019,2019),(13,'リス','0',2019,2019),(14,'コアラ','0',2019,2019),(15,'ゾウ','0',2019,2019),(16,'トリ','0',2019,2019),(17,'コグマ','0',2019,2019);
/*!40000 ALTER TABLE `animal_uriu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anime_main_nagatake`
--

DROP TABLE IF EXISTS `anime_main_nagatake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anime_main_nagatake` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anime_title` varchar(256) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `studio_id` int(11) DEFAULT NULL,
  `release_year` int(4) NOT NULL,
  `voiceactor_id` int(50) DEFAULT NULL,
  `source_id` int(10) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anime_main_nagatake`
--

LOCK TABLES `anime_main_nagatake` WRITE;
/*!40000 ALTER TABLE `anime_main_nagatake` DISABLE KEYS */;
INSERT INTO `anime_main_nagatake` VALUES (1,'ドラゴンボール',3,1,1986,1,2,'日本だけでなく海外でも大人気の作品','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(2,'ワンピース',3,1,1999,2,2,'知らない人はいないであろう超大作','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(3,'ソードアートオンライン',1,2,2012,3,5,'ゲームが好きな人はハマるかも！！','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(4,'日常',6,10,2011,4,6,'日常系アニメ…です。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(5,'がっこうぐらし',8,12,2015,5,3,'日常系のほのぼのアニメです。(ジャンルは要チェック)','0','2019-09-13 00:00:00','2019-09-27 15:12:48'),(6,'魔法少女まどかマギカ',3,8,2011,6,1,'魔法少女が魔女と戦う話ですが内容は女児向けのアニメではありません。伏線が沢山あったりと何度も見れる面白い内容になっています。','0','2019-09-13 00:00:00','2019-09-27 15:16:50'),(7,'CLANNAD',10,10,2007,7,7,'私の見た作品で一番感動する作品でした。一言で表すなら「人生」です。','0','2019-09-13 00:00:00','2019-09-30 13:04:12'),(8,'Fate/stay nigtht(ubw)',3,11,2014,8,7,'迫力の戦闘シーン。最高峰の映像です。\r\nストーリーもよく構成されています。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(9,'あの日見た花の名前を僕たちはまだ知らない',10,2,2011,9,1,'突然現れた少女が昔亡くなった友達で…　\r\nとっても感動します。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(10,'幼女戦記',9,13,2017,6,6,'戦争に小さな女の子が出向くが…\r\n迫力のあるシーンが特徴的です。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(11,'コードギアス反逆のルルーシュ',2,9,2008,10,1,'ロボット系のアニメですが苦手な人でも見れる\r\nくらい、ストーリーが面白いです','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(12,'のんのんびより',6,14,2013,11,6,'田舎暮らしのほのぼの系です。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(13,'僕のヒーローアカデミア',3,5,2016,12,2,'とにかく熱い作品！！ジャンプならではの作品','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(14,'マクロスF',2,15,2008,7,1,'戦闘中に流れる歌がかっこいい！','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(15,'とある魔術の禁書目録',1,3,2008,13,6,'超能力を持った人がいる世界での物語','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(16,'Charlotte',10,6,2015,14,1,'超能力系の話ですが、とっても感動します','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(17,'NEW GAME!',6,4,2016,15,3,'これを見たらゲームの見方が変わるかも？','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(18,'Re:ゼロから始める異世界生活',1,7,2016,16,6,'一大ブームを引き起こした作品。ループ系のダークファンタジーです。','0','2019-09-13 00:00:00','2019-09-27 15:21:12'),(19,'涼宮ハルヒの憂鬱',1,10,2006,17,6,'ハルヒを中心に起きる非日常的な物語。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(20,'この素晴らしい世界に祝福を！',4,16,2016,18,6,'ファンタジーでギャグアニメです。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(21,'working！！',6,2,2010,10,8,'ファミレスで働いてみたくなります。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(22,'這いよれ！ニャル子さん',1,17,2012,19,9,'日常系のSFギャグ系です。ニャル子さんがかわいい','0','2019-09-13 00:00:00','2019-09-27 15:10:16'),(23,'ガールズ＆パンツァー',9,18,2012,20,1,'戦車で戦う姿は迫力満点。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(24,'マクロス7',2,19,1994,21,1,'戦場に出て戦闘をせずに歌い続ける主人公の生きざまが見どころです。','0','2019-09-13 00:00:00','2019-09-30 13:01:21'),(25,'グリザイアの果実',3,20,2014,22,7,'重たい内容が多く、見ていて悲しくなるようなものが多いです。ですが、その分よく物語が構成されていてとても面白いです。','0','2019-09-13 00:00:00','2019-09-27 15:12:17'),(26,'シュタインズゲート',1,7,2011,23,4,'タイムマシンで過去を変える話です。','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(27,'あそびあそばせ',4,12,2018,24,10,'このアニメより面白いものを見たことがないです','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(28,'火ノ丸相撲',7,22,2018,25,2,'相撲に興味を持つくらい面白い作品です','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(29,'ダンジョンに出会いを求めるのは間違っているだろうか',1,3,2017,3,9,'ファンタジー好きな人はとってもおススメ！','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(30,'物語シリーズ',3,8,2009,26,11,'独特な世界観に惹かれること間違いなし！！','0','2019-09-13 00:00:00','2019-09-27 09:50:07'),(31,'ご注文はうさぎですか？',6,7,2014,5,3,'癒し系のアニメです。心がぴょんぴょんします。','0','2019-09-27 11:48:01','2019-09-27 11:48:01'),(32,'中二病でも恋がしたい！',5,10,2012,10,12,'高校生になった主人公が中学生の頃の黒歴史を持っていて...\r\n中二病だった人や中二病のままの人が集まって起こるラブコメです。','0','2019-09-27 12:02:00','2019-09-27 15:08:41');
/*!40000 ALTER TABLE `anime_main_nagatake` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_ito`
--

LOCK TABLES `area_ito` WRITE;
/*!40000 ALTER TABLE `area_ito` DISABLE KEYS */;
INSERT INTO `area_ito` VALUES (0,NULL,'0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(1,'東京都','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(2,'埼玉県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(3,'千葉県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(4,'神奈川県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(5,'兵庫県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(6,'愛知県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(7,'新潟県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(8,'大阪府','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(9,'奈良県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(10,'福岡県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(11,'京都府','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(12,'北海道','0','2020-03-24 00:00:00','2020-03-24 00:00:00');
/*!40000 ALTER TABLE `area_ito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_kurihara`
--

DROP TABLE IF EXISTS `area_kurihara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_kurihara` (
  `id` int(11) NOT NULL,
  `area` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_kurihara`
--

LOCK TABLES `area_kurihara` WRITE;
/*!40000 ALTER TABLE `area_kurihara` DISABLE KEYS */;
INSERT INTO `area_kurihara` VALUES (0,NULL,0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(1,'北海道',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(2,'東北',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(3,'関東',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(4,'北陸',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(5,'中央高地',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(6,'東海',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(7,'近畿',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(8,'中国',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(9,'四国',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(10,'九州',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(11,'離島',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(12,'外国',0,'2019-05-08 00:00:00','2019-05-08 00:00:00');
/*!40000 ALTER TABLE `area_kurihara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_okabe`
--

DROP TABLE IF EXISTS `area_okabe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_okabe` (
  `id` int(11) NOT NULL,
  `area` varchar(50) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_okabe`
--

LOCK TABLES `area_okabe` WRITE;
/*!40000 ALTER TABLE `area_okabe` DISABLE KEYS */;
INSERT INTO `area_okabe` VALUES (0,NULL,'0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(1,'北海道','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(2,'青森県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(3,'岩手県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(4,'宮城県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(5,'秋田県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(6,'山形県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(7,'福島県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(8,'茨城県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(9,'栃木県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(10,'群馬県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(11,'埼玉県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(12,'千葉県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(13,'東京都','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(14,'神奈川県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(15,'新潟県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(16,'富山県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(17,'石川県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(18,'福井県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(19,'山梨県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(20,'長野県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(21,'岐阜県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(22,'静岡県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(23,'愛知県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(24,'三重県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(25,'滋賀県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(26,'京都府','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(27,'大阪府','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(28,'兵庫県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(29,'奈良県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(30,'和歌山県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(31,'鳥取県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(32,'島根県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(33,'岡山県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(34,'広島県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(35,'山口県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(36,'徳島県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(37,'香川県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(38,'愛媛県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(39,'高知県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(40,'福岡県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(41,'佐賀県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(42,'長崎県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(43,'熊本県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(44,'大分県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(45,'宮崎県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(46,'鹿児島県','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(47,'沖縄県','0','2019-05-16 15:24:00','2019-05-16 15:24:00');
/*!40000 ALTER TABLE `area_okabe` ENABLE KEYS */;
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
INSERT INTO `attribute_kawamura` VALUES (0,NULL,'0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(1,'エンペラーペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(2,'アデリーペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(3,'フンボルトペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(4,'マカロニペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(5,'キンメペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00'),(6,'コガタペンギン属','0','2019-12-03 15:19:00','2019-12-03 15:19:00');
/*!40000 ALTER TABLE `attribute_kawamura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author_miyamoto`
--

DROP TABLE IF EXISTS `author_miyamoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author_miyamoto` (
  `author_id` int(11) NOT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_miyamoto`
--

LOCK TABLES `author_miyamoto` WRITE;
/*!40000 ALTER TABLE `author_miyamoto` DISABLE KEYS */;
INSERT INTO `author_miyamoto` VALUES (0,'','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(1,'夏目漱石','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(2,'芥川龍之介','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(3,'森鴎外','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(4,'東野圭吾','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(5,'三浦しをん','0','2019-05-08 00:00:00','2019-05-08 00:00:00');
/*!40000 ALTER TABLE `author_miyamoto` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_main_ito`
--

LOCK TABLES `band_main_ito` WRITE;
/*!40000 ALTER TABLE `band_main_ito` DISABLE KEYS */;
INSERT INTO `band_main_ito` VALUES (1,'Fear,and loathing in LasVegas',1,5,2008,'なんちゃらラスベガスで覚えれればOK/★Step Of Terror','0',NULL,NULL),(2,'a crowd of rebellion',1,7,2007,'曲調、音、声エモさがえぐい/★Never Say A Gain','0',NULL,NULL),(3,'crossfaith',1,8,2006,'ライブで友人が骨折した/★Blue','0',NULL,NULL),(4,'Coldrain',1,6,2007,'サウンドがかっこいい/★F.T.T.T','0',NULL,NULL),(6,'HEY-SMITH',1,8,2006,'スカパンクが最高/★Drug Free Japan','0',NULL,NULL),(7,'SiM',1,4,2004,'レゲエ要素あり/★RiOT','0',NULL,NULL),(8,'マキシマムザホルモン',3,1,1998,'ライブ中みんな偏差値低くなる/★「F」','0',NULL,NULL),(9,'Ailiph　Doepa',1,1,2010,'インフルエンザのときに見るようなMV多い/★MARS','0',NULL,NULL),(10,'04Limted Sazabys',1,6,2008,'曲の爽快感/★Knife','0',NULL,NULL),(11,'フレデリック',1,5,2009,'歌声もビジュも強い双子/★TOGENKYO','0',NULL,NULL),(12,'キュウソネコカミ',1,5,2009,'キャッチーで面白い/★メンヘラちゃん','0',NULL,NULL),(13,'ELLEGARDEN',1,3,1998,'復活歓喜/★サンタクロース','0',NULL,NULL),(14,'女王蜂',1,5,2009,'メンバー1人1人のビジュ強い/★金星','0',NULL,NULL),(15,'打首獄門同好会',3,NULL,2004,'Baが還暦に見えない、飯テロバンド/★島国DNA','0',NULL,NULL),(16,'凛として時雨',3,2,2002,'ツインボ×ドラムが最高/★nakano kill you','0',NULL,NULL),(17,'THE ORAL CIGARETTES',1,9,2010,'ダークな雰囲気かもしてる/★DIP-BAP','0',NULL,NULL),(18,'FACT',1,NULL,1999,'お面バンド/★error','0',NULL,NULL),(19,'MAN WITH A MISSIOM',1,1,2010,'狼バンド/★NEVER FXXKIN\' MIND THE RULES','0',NULL,NULL),(20,'The BONEZ',1,NULL,2012,'JESSEかっこいい/★Hello Monster','0',NULL,NULL),(21,'アルカラ',1,5,2002,'Voが首にタンバリン装備している（使わない）/★チクショー','0',NULL,NULL),(22,'ポルカドットスティングレイ',2,10,2015,'力強い女性Vo/★エレクトリック・パブリック','0',NULL,NULL),(23,'魔法少女になり隊',2,NULL,2014,'Voがしゃべれなくなる呪いをかけられていて可愛い/★ヒメサマスピリッツ','0',NULL,NULL),(24,'クリープハイプ',1,1,2001,'声が癖になる/★鬼','0',NULL,NULL),(25,'マカロニえんぴつ',1,4,2012,'朝方に聴いたらエモかった/★ワンドリンク別','0',NULL,NULL),(26,'サンボマスター',1,1,2000,'ライブで一番泣けるバンド/★ラブソング','0',NULL,NULL),(27,'そこに鳴る',3,8,2011,'ツインの重なり合いが良い/★掌で踊る','0',NULL,NULL),(28,'ヒステリックパニック',1,6,2012,'重くてキャッチーなサウンドで良い/★般若','0',NULL,NULL),(29,'ROTTENGRAFFTY',1,11,1999,'掛け合いがかっこ良い/★金色グラフティー','0',NULL,NULL),(30,'サカナクション',1,12,2005,'新宝島の動きが頭から離れない/★多分、風','0',NULL,NULL),(31,'夜の本気ダンス',1,NULL,2008,'着てるシャツがいつもおしゃれ/★with out you','0',NULL,NULL),(32,'Survive Said The Prophet',1,1,2011,'バンド名読みづらい/★found & lost','0',NULL,NULL),(33,'夕闇に誘いし漆黒の天使達',1,4,2015,'ブレイクダウンがおもしろいyoutuberバンド/★君に届かない声はイタリアにも届かない、故にミラノ風','0',NULL,NULL),(34,'Pay money To my Pain',1,1,2005,'もっと早く知っておけばよかったと思うバンド/★Sweetest vengeance','0',NULL,NULL),(35,'午前四時、朝焼けにツキ',1,7,2011,'メンバーが大きく変わっても曲がかっこいい/★因呶羅','0',NULL,NULL);
/*!40000 ALTER TABLE `band_main_ito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band_main_sasaki`
--

DROP TABLE IF EXISTS `band_main_sasaki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `band_main_sasaki` (
  `id` int(2) DEFAULT NULL,
  `photo` varchar(256) DEFAULT NULL,
  `band_name` varchar(256) DEFAULT NULL,
  `member_id` int(2) DEFAULT NULL,
  `birthplace_id` int(2) DEFAULT NULL,
  `formation_year` int(4) DEFAULT NULL,
  `release_num` int(2) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_main_sasaki`
--

LOCK TABLES `band_main_sasaki` WRITE;
/*!40000 ALTER TABLE `band_main_sasaki` DISABLE KEYS */;
INSERT INTO `band_main_sasaki` VALUES (1,'/bandimage/han.jpg','ハンブレッダーズ',4,8,2009,3,'そろそろ売れてくるであろうバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'/bandimage/floor.jpg','The Floor',4,1,2012,5,'ポップなサウンドが特徴.','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'/bandimage/fom.jpg','FOMARE',3,2,2014,2,'結成してから売れるまでが早い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'/bandimage/num.jpg','NUMBER GIAL',4,12,1995,6,'2002年に解散したが17年ぶりに再結成。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'/bandimage/mo.jpg','モーモールルギャバン',3,9,2005,9,'パン一ドラムボーカル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(6,'/bandimage/jyo.jpg','JYOCHO',5,9,2016,4,'ギターのテクニックが物凄い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(7,'/bandimage/maka.jpg','マカロニえんぴつ',4,5,2012,5,'ポップな曲からかっこいい曲まで良曲揃い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(8,'/bandimage/hel.jpg','Helsinki Lambda Club',3,3,2013,5,'ゆったりとした落ち着く音楽。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(9,'/bandimage/zoo.jpg','ズーカラデル',3,1,2015,2,'初MVを投稿してわずか数ヶ月でCM曲。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(10,'/bandimage/fin.jpg','FINLANDS',2,5,2012,6,'若い女性らしからぬかっこよさがある。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(11,'/bandimage/sum.jpg','sumika',4,5,2013,8,'前バンドのbanbiから大出世。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(12,'/bandimage/sup.jpg','SUPER BEAVER',4,4,2005,10,'ライブのMCがダサかっこいい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(13,'/bandimage/was.jpg','忘れらんねえよ',1,11,2008,7,'36歳にしてメンバーが一人になってしまう。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(14,'/bandimage/qoo.jpg','QOOLAND',4,4,2011,9,'ボスハンドタッピングという奏法が特徴。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(15,'/bandimage/nev.jpg','never young beach',4,4,2014,3,'ボーカルの兄が高橋一生。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(16,'/bandimage/sex.jpg','セックスマシーン',4,7,1998,7,'ジーンズがダメージを受けすぎている。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(17,'/bandimage/toco.jpg','toconoma',4,4,2008,5,'高テクニックのインストバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(18,'/bandimage/suc.jpg','Suck a Stew Dry',5,4,2010,5,'現在はTHURSDAYS YOUTHというバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(19,'/bandimage/su-.jpg','四星球',4,10,2002,7,'ライブで使う小道具は全て手作り。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(20,'/bandimage/sak.jpg','SAKEROCK',5,6,2000,14,'バナナマンのライブBGMなどを担当する。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(21,'/bandimage/nec.jpg','ネクライトーキー',5,8,2017,1,'ほとんどコンテンポラリーな生活。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(22,'/bandimage/pop.jpg','ポップしなないで',2,4,2015,2,'優花さんおすすめのバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(23,'/bandimage/ao.jpg','藍坊主',4,5,2000,14,'歌ほんとうまい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(24,'/bandimage/bak.jpg','爆弾ジョニー',5,1,2010,4,'アニメ「ピンポン」のOP。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(25,'/bandimage/sakana.jpg','サカナクション',5,1,2005,8,'言わずと知れたかっこよさ。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(26,'/bandimage/s.jpg','さしすせそズ',4,8,2013,2,'パルプンテ山田とイケダーマン池田が脱退。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(27,'/bandimage/mint.jpg','MINT mate box',3,4,2017,2,'ベースかわいい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(28,'/bandimage/fujiki.jpg','藤木さん',1,4,1995,0,'明日も競艇に全てを賭ける。','0','2019-04-05 09:23:18','2019-04-05 09:28:59'),(29,'/bandimage/friends.jpg','石原さん',1,4,2019,1,'フレンズの件に関してはほとんど桜井さんが悪い。','0','2019-04-05 09:24:50','2019-04-05 09:28:38'),(1,'/bandimage/han.jpg','ハンブレッダーズ',4,8,2009,3,'そろそろ売れてくるであろうバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'/bandimage/floor.jpg','The Floor',4,1,2012,5,'ポップなサウンドが特徴.','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'/bandimage/fom.jpg','FOMARE',3,2,2014,2,'結成してから売れるまでが早い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'/bandimage/num.jpg','NUMBER GIAL',4,12,1995,6,'2002年に解散したが17年ぶりに再結成。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'/bandimage/mo.jpg','モーモールルギャバン',3,9,2005,9,'パン一ドラムボーカル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(6,'/bandimage/jyo.jpg','JYOCHO',5,9,2016,4,'ギターのテクニックが物凄い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(7,'/bandimage/maka.jpg','マカロニえんぴつ',4,5,2012,5,'ポップな曲からかっこいい曲まで良曲揃い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(8,'/bandimage/hel.jpg','Helsinki Lambda Club',3,3,2013,5,'ゆったりとした落ち着く音楽。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(9,'/bandimage/zoo.jpg','ズーカラデル',3,1,2015,2,'初MVを投稿してわずか数ヶ月でCM曲。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(10,'/bandimage/fin.jpg','FINLANDS',2,5,2012,6,'若い女性らしからぬかっこよさがある。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(11,'/bandimage/sum.jpg','sumika',4,5,2013,8,'前バンドのbanbiから大出世。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(12,'/bandimage/sup.jpg','SUPER BEAVER',4,4,2005,10,'ライブのMCがダサかっこいい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(13,'/bandimage/was.jpg','忘れらんねえよ',1,11,2008,7,'36歳にしてメンバーが一人になってしまう。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(14,'/bandimage/qoo.jpg','QOOLAND',4,4,2011,9,'ボスハンドタッピングという奏法が特徴。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(15,'/bandimage/nev.jpg','never young beach',4,4,2014,3,'ボーカルの兄が高橋一生。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(16,'/bandimage/sex.jpg','セックスマシーン',4,7,1998,7,'ジーンズがダメージを受けすぎている。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(17,'/bandimage/toco.jpg','toconoma',4,4,2008,5,'高テクニックのインストバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(18,'/bandimage/suc.jpg','Suck a Stew Dry',5,4,2010,5,'現在はTHURSDAYS YOUTHというバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(19,'/bandimage/su-.jpg','四星球',4,10,2002,7,'ライブで使う小道具は全て手作り。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(20,'/bandimage/sak.jpg','SAKEROCK',5,6,2000,14,'バナナマンのライブBGMなどを担当する。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(21,'/bandimage/nec.jpg','ネクライトーキー',5,8,2017,1,'ほとんどコンテンポラリーな生活。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(22,'/bandimage/pop.jpg','ポップしなないで',2,4,2015,2,'優花さんおすすめのバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(23,'/bandimage/ao.jpg','藍坊主',4,5,2000,14,'歌ほんとうまい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(24,'/bandimage/bak.jpg','爆弾ジョニー',5,1,2010,4,'アニメ「ピンポン」のOP。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(25,'/bandimage/sakana.jpg','サカナクション',5,1,2005,8,'言わずと知れたかっこよさ。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(26,'/bandimage/s.jpg','さしすせそズ',4,8,2013,2,'パルプンテ山田とイケダーマン池田が脱退。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(27,'/bandimage/mint.jpg','MINT mate box',3,4,2017,2,'ベースかわいい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(28,'/bandimage/fujiki.jpg','藤木さん',1,4,1995,0,'明日も競艇に全てを賭ける。','0','2019-04-05 09:23:18','2019-04-05 09:28:59'),(29,'/bandimage/friends.jpg','石原さん',1,4,2019,1,'フレンズの件に関してはほとんど桜井さんが悪い。','0','2019-04-05 09:24:50','2019-04-05 09:28:38');
/*!40000 ALTER TABLE `band_main_sasaki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band_main_taneichi`
--

DROP TABLE IF EXISTS `band_main_taneichi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `band_main_taneichi` (
  `id` int(10) NOT NULL,
  `band_name` varchar(100) NOT NULL,
  `member` int(2) DEFAULT NULL,
  `band_year` int(4) DEFAULT NULL,
  `band_sex` int(2) DEFAULT NULL,
  `genre_id` int(2) DEFAULT NULL,
  `comment` varchar(300) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_main_taneichi`
--

LOCK TABLES `band_main_taneichi` WRITE;
/*!40000 ALTER TABLE `band_main_taneichi` DISABLE KEYS */;
INSERT INTO `band_main_taneichi` VALUES (1,'クリープハイプ',4,2001,1,3,'個人的にNo.1バンド。サイコー\r\n♪「手と手」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(2,'King Gnu',4,2017,1,2,'ボーカルが髭面。いわゆるシティポップ。読み方は\"キングヌー\"\r\n♪「Tokyo Rendez-Vous」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(3,'Wienners',4,2008,3,1,'ボーカルが変人。曲調早めで元気がでる\r\n♪「Justice 4」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(4,'saucy dog',3,2013,1,1,'田舎の道とか夜の丘とか海沿いとかで聴きたい\r\n♪「コンタクトケース」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(5,'yonige',2,2013,2,3,'アボカド投げちゃう系\r\n♪「最愛の恋人たち」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(6,'ドミコ',2,2011,1,1,'野外で酒飲みながら聴きたい\r\n♪「ロースト・ビーチ・ベイベー」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(7,'Awsome City Club',5,2013,3,2,'THE・シティポップ\r\n♪「青春の胸さわぎ」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(8,'chelmico',2,2014,2,4,'女２人のラップユニット\r\n♪「ママレードボーイ」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(9,'Hump Back',3,2012,2,1,'THE・ガールズバンド\r\n♪「チープマンデー」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(10,'とけた電球',4,2012,1,1,'リズムに中毒性\r\n♪「強がり」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(11,'SUNNY CAR WASH',3,2016,1,3,'声高い 良い\r\n♪「キルミー」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(12,'ハルカミライ',4,2012,1,1,'えもい\r\n♪「春はあけぼの」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(13,'SIX LOUNGE',3,2012,1,1,'あつい\r\n♪「くだらない」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(14,'TETO',4,2016,1,1,'めちゃくちゃ早口 カラオケで歌うのは不可能 ボーカルは多多分エラ呼吸\r\n♪「Pain Pain Pain」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(15,'FOMARE',3,2014,1,1,'王道\r\n♪「23:12」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(16,'DENIMS',4,2012,1,1,'よこのり 野外フェス必須\r\n♪「ゆるりゆらり」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(17,'ハンブレッターズ',3,2009,1,1,'全員芋男\r\n♪「スクールマジシャンガール」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(18,'銀杏BOYS',1,2003,1,5,'激エモバンド 聞いてほしい\r\nBOYSっていってるけど峯田一人 俳優業すんな\r\n♪「二十九、三十」（クリープハイプカバー）','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(19,'マカロニえんぴつ',4,2012,1,1,'青春を感じたいならこれ いまきてる\r\n♪「メイビーネイビー」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(20,'フレンズ',5,2015,3,2,'いろんなバンドの人たちの寄せ集め\r\n大人なシティポップ\r\n♪「夏のSAYにしてゴメンネ♡」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(21,'ナードマグネット',4,2006,1,1,'電車でききたい\r\n♪「Mixtape」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(22,'忘れらんねえよ',1,2008,1,5,'柴田がおもろい ライブが楽しいよ\r\n♪「寝てらんねえよ」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(23,'Brian the Sun',4,2007,1,1,'ベースがかっこいいです\r\n♪「キャラメルパンケーキ」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(24,'KOTORI',4,2014,1,1,'若者に戻りたいときにどうぞ\r\n♪「6月」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(25,'Creepy Nuts',2,2013,1,4,'ラップ聴きたいときに聴く R-指定のユニット\r\n♪「合法的トビ方ノススメ」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(26,'TENDOUJI',4,2014,1,1,'海外映画のドライブシーンで使われそう\r\n♪「Sonic Boom」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(27,'カネコアヤノ',1,2012,2,2,'シンガーソングライター 程よいぶす\r\n♪「コンビニ」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(28,'andymori',3,2007,1,3,'解散してしまって一番悲しいバンド\r\n聴くと泣く\r\n♪「ユートピア」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(29,'さよならポエジー',2,2012,1,1,'夕方とか朝方とかに聴く\r\n♪「二束三文」','0','2019-05-24 15:10:11','2019-05-24 15:10:11'),(30,'きのこ帝国',4,2007,2,1,'ふとした日常のときに聴くと良き\r\n♪「ありふれた言葉」','0','2019-05-24 15:10:11','2019-05-24 15:10:11');
/*!40000 ALTER TABLE `band_main_taneichi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band_sex_taneichi`
--

DROP TABLE IF EXISTS `band_sex_taneichi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `band_sex_taneichi` (
  `id` int(2) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_sex_taneichi`
--

LOCK TABLES `band_sex_taneichi` WRITE;
/*!40000 ALTER TABLE `band_sex_taneichi` DISABLE KEYS */;
INSERT INTO `band_sex_taneichi` VALUES (0,'','0','2019-05-24 16:51:00','2019-05-24 16:51:00'),(1,'男性ボーカル','0','2019-05-24 15:54:42','2019-05-24 15:54:42'),(2,'女性ボーカル','0','2019-05-24 15:54:42','2019-05-24 15:54:42'),(3,'男女ツインボーカル','0','2019-05-24 15:54:42','2019-05-24 15:54:42');
/*!40000 ALTER TABLE `band_sex_taneichi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `birthplace_sasaki`
--

DROP TABLE IF EXISTS `birthplace_sasaki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `birthplace_sasaki` (
  `id` int(2) NOT NULL,
  `birthplace` varchar(4) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `birthplace_sasaki`
--

LOCK TABLES `birthplace_sasaki` WRITE;
/*!40000 ALTER TABLE `birthplace_sasaki` DISABLE KEYS */;
INSERT INTO `birthplace_sasaki` VALUES (0,' ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'北海道','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'群馬','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'千葉','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'東京','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'神奈川','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(6,'埼玉','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(7,'兵庫','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(8,'大阪','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(9,'京都','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(10,'徳島','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(11,'熊本','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(12,'福岡','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `birthplace_sasaki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `body_izawa`
--

DROP TABLE IF EXISTS `body_izawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `body_izawa` (
  `id` int(2) DEFAULT NULL,
  `bodyname` varchar(255) DEFAULT NULL,
  UNIQUE KEY `id` (`id`,`bodyname`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_izawa`
--

LOCK TABLES `body_izawa` WRITE;
/*!40000 ALTER TABLE `body_izawa` DISABLE KEYS */;
INSERT INTO `body_izawa` VALUES (0,NULL),(1,'大胸筋'),(2,'背筋'),(3,'三頭筋'),(4,'上腕二頭筋'),(5,'上腕三頭筋'),(6,'その他');
/*!40000 ALTER TABLE `body_izawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_main_miyamoto`
--

DROP TABLE IF EXISTS `book_main_miyamoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_main_miyamoto` (
  `no` int(10) DEFAULT NULL,
  `id` int(3) NOT NULL,
  `book_title` varchar(256) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `page` int(4) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_main_miyamoto`
--

LOCK TABLES `book_main_miyamoto` WRITE;
/*!40000 ALTER TABLE `book_main_miyamoto` DISABLE KEYS */;
INSERT INTO `book_main_miyamoto` VALUES (1,1,'吾輩は猫である',1,1,1905,746,'オチが謎','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(2,2,'坊ちゃん',2,1,1906,216,'スラスラ読める','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(3,3,'こころ',2,1,1914,348,'読んだはずですが忘れました','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(4,4,'羅生門',3,2,1915,301,'教科書に載ってる部分しか知りません','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(5,5,'鼻',3,2,1916,256,'読んだことないです','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(6,6,'地獄変',3,2,1918,NULL,'知りません','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(7,7,'舞姫',3,3,1890,NULL,'見たことないです','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(8,8,'青年',2,3,1910,NULL,'被りそうなタイトルだと思います','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(9,9,'雁',3,3,1911,NULL,'聞いたこともないです','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(10,10,'高瀬舟',2,3,1916,NULL,'存じません','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(11,11,'眠りの森',2,4,1989,328,'存じ上げません','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(12,12,'どちらかが彼女を殺した',2,4,1996,355,'わかりません','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(13,13,'悪意',2,4,1996,365,'聞いたことがあるかもしれません','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(14,14,'私が彼を殺した',2,4,1999,431,'聞いたことはあるかもしれません','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(15,15,'嘘をもうひとつだけ',2,4,2000,269,'見たことはあるかもしれません','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(16,16,'赤い指',2,4,2006,320,'息子がいいキャラしていました','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(17,17,'新参者',2,4,2009,416,'読んだ気がしますが、忘れました','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(18,18,'麒麟の翼',2,4,2011,384,'知らないです','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(19,19,'祈りの幕が下がる時',2,4,2013,448,'どこかで聞いた気がします','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(20,20,'探偵ガリレオ',2,4,1998,336,'有名らしいですが、読んだことありません','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(21,21,'予知夢',2,4,2000,272,'たまに見ます','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(22,22,'容疑者Xの献身',2,4,2005,400,'救いのない話でした','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(23,23,'秘密の花園',2,5,2002,278,'読んでみたいです','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(24,24,'ロマンス小説の七日間',2,5,2003,283,'面白そうです','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(25,25,'私が語りはじめた彼は',2,5,2004,297,'楽しそうです','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(26,26,'風が強く吹いている',2,5,2006,670,'台風でしょう','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(27,27,'光',2,5,2008,374,'凄まじく被りそうなタイトルだと思います','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(28,28,'舟を編む',2,5,2011,259,'途中まで読んで図書館に返しました','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(29,29,'政と源',2,5,2013,304,'内容が想像できません','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(30,30,'ののはな通信',2,5,2018,456,'雑誌のようなタイトルです','0','2019-05-08 00:00:00','2019-05-08 00:00:00'),(NULL,31,'foo',3,3,1946,236,'weabduaw','1','2019-05-22 14:29:41','2019-05-22 14:29:41');
/*!40000 ALTER TABLE `book_main_miyamoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_main_uchiyama`
--

DROP TABLE IF EXISTS `book_main_uchiyama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_main_uchiyama` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `writer_id` int(11) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `comment` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flg` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_main_uchiyama`
--

LOCK TABLES `book_main_uchiyama` WRITE;
/*!40000 ALTER TABLE `book_main_uchiyama` DISABLE KEYS */;
INSERT INTO `book_main_uchiyama` VALUES (1,'はつ恋',1,1,1860,'悲しい話です。\r\nツルゲーネフの半自伝的小説らしい。','0','2019-09-17 00:00:00','2019-09-20 15:22:31'),(2,'クロイツェル・ソナタ',1,2,1889,'老人が語る夫婦関係、人生の回顧。\r\nタイトルはヴェートーベン,ヴァイオリンソナタ第9番より。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(3,'ガラスの街',1,3,1985,'「そもそもの始まりは間違い電話だった」\r\n探偵の仕事を請け負うことになってしまったミステリー作家の悲劇。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(4,'町でいちばんの美女',4,4,1972,'ちょっと狂った短編集。\r\nアル中の詩人なら共感しやすいかもしれません。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(5,'死をポケットに入れて',3,4,1999,'作家ブコウスキー晩年の日記、エッセイ。\r\n口汚い。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(6,'ウインドアイ',4,5,2011,'短編集です。読むべき。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(7,'ぼくが電話をかけている場所',1,6,1983,'最高の短編集。\r\n「僕が電話をかけていた場所」という似た名前の小説がある。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(8,'死んでいるかしら',3,7,1997,'アメリカ文学翻訳家のエッセイ。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(9,'しあわせの理由',2,8,2003,'「12歳の誕生日をすぎてまもなく、ぼくはいつもしあわせな気分でいるようになった」\r\nちゃんと面白いSF短編集です。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(10,'道化師の蝶',4,9,2012,'芥川賞受賞作\r\n小説ってこんなことが出来るんだ。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(11,'ドグラ・マグラ',4,10,1935,'日本探偵小説三大奇書の一つ。\r\n「…ブウウーーーンンンーーンンン………。」','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(12,'時計仕掛けのオレンジ',4,11,1962,'映画が有名。「ホラーショー！」','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(13,'虐殺器官',2,12,2007,'ホラーやサスペンスみたいなタイトルだけれどSFです。\r\n映像化作品も有名','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(14,'断片的なものの社会学',3,13,2015,'社会学者の書いた「解釈できない出来事」をめぐるエッセイ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(15,'美味い豆腐の話',3,14,1933,'同著者のグルメなエッセイが青空文庫で沢山読めます。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(16,'ナイン・ストーリーズ',1,15,1953,'J・D・サリンジャーの自薦短編集。\r\n「笑い男」等を収録。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(17,'レモン畑の吸血鬼',1,16,2016,'熟年吸血鬼夫婦の倦怠期、お国の為に蚕に変えられた女工達…ちょっとファンタジックな短編集。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(18,'銀河ヒッチハイク・ガイド',2,17,1979,'ラジオドラマが原作。日本語で楽しむ場合は、映画がつまらないので小説を読む必要がある。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(19,'機龍警察',2,18,2010,'2010年代警察小説の最高峰','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(20,'脂肪の塊',1,19,1880,'ちょっと思想的だけれど、読みやすくて面白い。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(21,'ユートピア',4,20,1516,'ユートピア(理想郷)という語はこの作品に出る国名であり、著者の造語。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(22,'タイムマシン',2,21,1895,'タイムマシンという概念を導入した初期の作品。この作品の地球の未来は大変なことになっています…。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(23,'断食芸人',1,22,1924,'断食芸という芸が19世紀後半から20世紀後半にかけてサーカスで実際に行われていたようです。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(24,'外套',1,23,1842,'かのドストエフスキーすらこの作品から影響を受けたと語ったらしい。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(25,'紙の動物園',2,24,2015,'中国系アメリカ人の書くSF小説。中国文学を読もう。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(26,'見えない都市',4,25,1972,'多くの人は好まない内容かもしれない。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(27,'西瓜糖の日々',1,26,2002,'西瓜糖世界のお話です。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(28,'結婚式のメンバー',1,27,1946,'12歳の少女の繊細な心理描写。村上春樹訳で話題になった。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(29,'女生徒',4,28,1939,'当時19歳の女性読者が太宰治に送った日記を題材に書かれた小説。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(30,'文字渦',2,9,2018,'プログラマーにも読んでほしい。','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(41,'wqq',0,0,NULL,'','0','2019-09-24 10:27:46','2019-09-24 10:27:46');
/*!40000 ALTER TABLE `book_main_uchiyama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boowy_main_waki`
--

DROP TABLE IF EXISTS `boowy_main_waki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boowy_main_waki` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `release_date` varchar(10) DEFAULT NULL,
  `genre_id` int(2) DEFAULT NULL,
  `length` varchar(5) DEFAULT NULL,
  `songwriter_id` int(2) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boowy_main_waki`
--

LOCK TABLES `boowy_main_waki` WRITE;
/*!40000 ALTER TABLE `boowy_main_waki` DISABLE KEYS */;
INSERT INTO `boowy_main_waki` VALUES (1,'ホンキー・トンキー・クレイジー','1985/6/1',2,'3:35',2,'ファースト・シングル。ライブの最後に流れるとテンションが上がるやつ。','0','2019-12-04','2019-12-04 00:00:00'),(2,'BAD FEELING','1985/8/22',1,'4:31',2,'セカンド・シングル。聞くとGOOD FEELINGになるよ。','0','2019-12-04','2019-12-04 00:00:00'),(3,'わがままジュリエット','1986/2/1',2,'4:34',2,'ミュージックビデオの女の子がかわいい。ヒムロックはずっとかっこいい。','0','2019-12-04','2019-12-04 00:00:00'),(4,'B・BLUE','1986/9/29',1,'3:57',2,'最初の曲名は「TRUE BLUE」だったけど、マドンナが同じ曲名で先にリリースしちゃったから変更された。','0','2019-12-04','2019-12-04 00:00:00'),(5,'ONLY YOU','1987/4/6',1,'4:11',2,'カラオケで合いの手入れるのが定番。','0','2019-12-04','2019-12-04 00:00:00'),(6,'Marionette-マリオネット-','1987/7/22',1,'3:37',2,'アニメーションで仕上げたミュージックビデオがダサい。でもそこがいい。','0','2019-12-04','2019-12-04 00:00:00'),(7,'季節が君だけを変える','1987/10/26',2,'4:06',1,'事実上最後のシングル曲。','0','2019-12-04','2019-12-04 00:00:00'),(8,'DAKARA','1988/2/3',1,'3:51',3,'初期の曲。改名前の「氷室狂介」名義で作詞。','0','2019-12-04','2019-12-04 00:00:00'),(9,'INSTANT VOVE','1988/3/25',1,'3:22',3,'乾いた恋愛感情をテーマにした曲。インスタントラーメン的な。','0','2019-12-04','2019-12-04 00:00:00'),(10,'OH! MY JULLY Part Ⅰ','1988/3/25',2,'4:06',3,'「ジュリー」は当時ヒムロックが飼っていたうさぎの名前。','0','2019-12-04','2019-12-04 00:00:00'),(11,'MY HONEY','1988/4/25',2,'5:03',3,'上目づかいが可愛すぎるからやめてほしいやつ。','0','2019-12-04','2019-12-04 00:00:00'),(12,'FUNNY-BOY','1988/4/25',1,'4:30',4,'ヒムロックが19歳の時に作った曲。生きてるだけじゃNO！','0','2019-12-04','2019-12-04 00:00:00'),(13,'IMAGE DOWN','1982/3/21',1,'3:03',3,'気が付けば口ずさんでいる曲1位。','0','2019-12-04','2019-12-04 00:00:00'),(14,'NO N.Y.','1982/3/21',1,'3:31',5,'女神のような顔で花をちぎるやつ。','0','2019-12-04','2019-12-04 00:00:00'),(15,'ON MY BEAT','1982/3/21',1,'2:19',3,'やたらと計算するのは棺桶に近くなってからでも十分できるらしい。','0','2019-12-04','2019-12-04 00:00:00'),(16,'LONDON GAME','1983/9/25',1,'3:28',3,'ロンドンゲームがどんなゲームなのかは不明。','0','2019-12-04','2019-12-04 00:00:00'),(17,'DREAMIN\'','1985/6/21',1,'4:05',6,'夢を見ている奴らに贈る曲。','0','2019-12-04','2019-12-04 00:00:00'),(18,'ハイウェイに乗る前に','1985/6/21',1,'3:44',7,'高速道路を走るときにかけたい曲1位。','0','2019-12-04','2019-12-04 00:00:00'),(19,'CLOUDY HEART','1985/6/21',2,'4:29',2,'地味に歌うのが難しい曲1位。','0','2019-12-04','2019-12-04 00:00:00'),(20,'JUSTY','1986/3/1',1,'3:57',2,'謎な歌詞が多いBOOWYの曲の中でも、特に謎な歌詞。','0','2019-12-04','2019-12-04 00:00:00'),(21,'DRAMATIC?DRASTIC!','1986/11/8',1,'4:17',8,'仮タイトルは「トーキング・ヘッズは3時のおやつ」。','0','2019-12-04','2019-12-04 00:00:00'),(22,'SUPER-CALIFRAGILISTIC-EXPIARI-DOUCIOUS','1986/11/8',1,'3:00',7,'絶対曲名覚えられないやつ。曲の間奏でモーツァルトが流れたりするやつ。','0','2019-12-04','2019-12-04 00:00:00'),(33,'test001update','2019/12/18',1,'03:00',2,'コメントupdate','1','2019-12-24','2019-12-24 13:50:35');
/*!40000 ALTER TABLE `boowy_main_waki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand_main_kambara`
--

DROP TABLE IF EXISTS `brand_main_kambara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand_main_kambara` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(256) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `designer` varchar(256) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand_main_kambara`
--

LOCK TABLES `brand_main_kambara` WRITE;
/*!40000 ALTER TABLE `brand_main_kambara` DISABLE KEYS */;
INSERT INTO `brand_main_kambara` VALUES (1,'GUCCI',1,'グッチオ・グッチ',1921,4,'緑×赤×緑が特徴！','0','2019-09-18 00:00:00','2019-09-24 10:34:01'),(2,'CHANEL',1,'ココ・シャネル',1909,4,'古い価値観にとらわれない女性像がポリシー','0','2019-09-18 00:00:00','2019-09-24 09:15:36'),(3,'LOUIS VUITTON',1,'ルイ・ヴィトン',1854,3,'スーツケース職人が創始したブランド','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(4,'HERMES',1,'ティエリー・エルメス',1837,3,'人名が由来','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(5,'off-white',4,'ヴァージル・アブロー',2014,2,'ラグジュアリーなストリート系ファッション','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(6,'balenciaga',5,'クリストバル・バレンシアガ',2013,8,'パリのエレガンスを体現','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(7,'PRADA',1,'マリオ・プラダ',1975,4,'日常を贅沢に飾るがコンセプト','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(8,'BURBERRY',3,'トーマス・バーバリー',1856,9,'トレンチコートが有名','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(9,'COACH',1,'カーン夫妻',1941,2,'Cが特徴的','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(10,'Dior',1,'クリスチャン・ディオール',1946,3,'香水が有名','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(11,'YVESSAINT LAURENT',1,'イヴ・サン＝ローラン',1936,3,'モードの帝王','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(12,'FENDI',1,'エドアルド・フェンディ',1925,4,'LOUIS VUITTONのグループ会社','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(13,'BOTTEGA VENETA',1,'ミケーレ・タッデイ',1966,4,'細長い革素材を用いたイントレチャートが有名','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(14,'MARNI',3,'コンスエロ・カスティリオーニ',1994,4,'温かみのある雰囲気が特徴','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(15,'CELINE',1,'セリーヌ・ヴィピアナ',1945,3,'オーダーメイドの革製子供靴専門店が始まり','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(16,'JIL SANDER',1,'ジル・サンダー',1968,6,'ドイツ語（標準）では、「ハイデマリー・イリーネ“イル”ザンダー」と発音される。','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(17,'LOEWE',3,'エンリケ・ロエベ・レスベルグ',1846,9,'ルイヴィトングループ','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(18,'DOLCE&GABBANA',3,'ドメニコ・ドルチェ',1985,4,'スターをスターらしく見せる','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(19,'POLO',4,'ラルフ・ローレン',1968,2,'馬のマークが特徴','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(20,'Hender Scheme',3,'柏崎亮',2015,1,'定番スニーカーを革で作る','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(21,'Maison Martin Margiela',3,'マルタン・マルジェラ',1988,3,'コンセプトによってグループを作りナンバリングしている。','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(22,'Acne Studios',3,'ジョニー・ヨハンセン',1996,5,'デニムが代表的アイテム','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(23,'graphpaper',3,'南貴之',2015,1,'素材感・仕立てが抜群に良い','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(24,'Levis',4,'リーヴァイ・ストラウス',2007,2,'ジーンズブランド','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(25,'NEAT',3,'西野大士',2015,1,'一癖も二癖もあるパンツブランド','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(26,'NEEDLES',3,'清水慶三',1989,1,'蝶のロゴが有名','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(27,'THE NORTH FACE',2,'ダグラス・トンプキンス',1966,2,'ブランド名は山岳で登山が難しい北側のことを指している。','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(28,'patagonia',2,'イヴォン・シュイナード',1953,2,'デザインの理念は、フランスの飛行家が語るデザイン美学に導かれている。','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(29,'SUPREME',4,'ジェームズ・ジェピア',1994,2,'ブランドのトレードマークである赤地にFutura字体の白い文字というボックスロゴ','0','2019-09-18 00:00:00','2019-09-18 00:00:00');
/*!40000 ALTER TABLE `brand_main_kambara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `castle_main_minami`
--

DROP TABLE IF EXISTS `castle_main_minami`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `castle_main_minami` (
  `id` int(3) NOT NULL,
  `castle_name` varchar(100) NOT NULL,
  `cashu_name` varchar(50) DEFAULT NULL,
  `prefecture_id` int(2) NOT NULL,
  `castle_year` int(4) DEFAULT NULL,
  `tenshu_id` int(1) DEFAULT NULL,
  `comment` varchar(300) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `castle_main_minami`
--

LOCK TABLES `castle_main_minami` WRITE;
/*!40000 ALTER TABLE `castle_main_minami` DISABLE KEYS */;
INSERT INTO `castle_main_minami` VALUES (1,'会津若松城','葦名直盛',6,1384,1,'維新や白虎隊が好きな人必見','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(2,'江戸城','徳川家康',12,1457,2,'なんかもう皇居すごすぎ','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(3,'小田原城','北条氏康',13,1582,1,'再建されたばかりだが見応えあり','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(4,'石垣三城','豊臣秀吉',13,1566,2,'駅から城跡まで2km歩く','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(5,'武田氏館','武田信虎',14,1519,2,'武田好きなら行かないと話にならない','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(6,'甲府城','羽柴秀勝',14,1590,2,'城壁と門構えが素晴らしい','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(7,'上田城','真田昌幸',15,1583,1,'真田好きは必見だが、桜シーズンはやめておけ','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(8,'松本城','石川数正',15,1590,1,'国宝5城の一つ。大天守からの景色凄い','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(9,'高島城','日根野高吉',15,1598,1,'水堀に囲まれてて茶色い天守が特徴','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(10,'高岡城','前田利長',16,1609,2,'現在は高岡古城公園としてある。内堀は残っている','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(11,'金沢城','前田利家',17,1580,1,'なまこ壁と鉛瓦が特徴の青白い城','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(12,'丸岡城','柴田勝豊',18,1576,1,'豪雪に耐えるための石瓦が特徴','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(13,'岐阜城','斎藤道三',19,1200,1,'険しい山の頂にあるため城につく前に疲れる','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(14,'岩村城','遠山氏',19,1580,2,'女城主伝説がある城','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(15,'山中城','北条氏康',20,1560,1,'敷地が広く発掘跡がすごいある','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(16,'浜松城','徳川家康',20,1570,1,'若き徳川家康の居城として利用されていた','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(17,'犬山城','織田信康',21,1537,1,'国宝の一つ。当時のままだから階段が急できつい','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(18,'名古屋城','徳川幕府',21,1609,1,'城内にエレベータがある。完全に観光資料館','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(19,'清須城','織田信長',21,1405,1,'清須会議の舞台の城','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(20,'小牧山城','織田信長',21,1563,1,'小牧長久手の戦いが学べる','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(21,'彦根城','井伊直政',23,1622,1,'井伊家の城とひこにゃんに会える','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(22,'二条城','徳川家康',24,1603,1,'修学旅行で行く人多そうな城','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(23,'大阪城','豊臣秀吉',25,1584,1,'立派過ぎてさすが秀吉様のお城','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(24,'姫路城','赤松貞範',26,1346,1,'世界文化遺産に登録されている','0','2019-05-16 00:00:00','2019-05-16 00:00:00');
/*!40000 ALTER TABLE `castle_main_minami` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_kawanaka`
--

DROP TABLE IF EXISTS `category_kawanaka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_kawanaka` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_kawanaka`
--

LOCK TABLES `category_kawanaka` WRITE;
/*!40000 ALTER TABLE `category_kawanaka` DISABLE KEYS */;
INSERT INTO `category_kawanaka` VALUES (0,NULL,'0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(1,'哺乳類','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(2,'鳥類','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(3,'爬虫類','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(4,'両生類','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(5,'魚介類','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(6,'植物','0','2019-10-28 00:00:00','2019-10-28 00:00:00');
/*!40000 ALTER TABLE `category_kawanaka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_kurimoto`
--

DROP TABLE IF EXISTS `category_kurimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_kurimoto` (
  `id` int(11) NOT NULL,
  `category_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_kurimoto`
--

LOCK TABLES `category_kurimoto` WRITE;
/*!40000 ALTER TABLE `category_kurimoto` DISABLE KEYS */;
INSERT INTO `category_kurimoto` VALUES (0,NULL,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(1,'サラダ・スープ','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(2,'前菜・おつまみ','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(3,'パン','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(4,'イタリアの味','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(5,'ピザ','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(6,'パスタ','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(7,'ドリア','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(8,'米料理','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(9,'肉料理','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(10,'デザート','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(11,'ドリンクバー','0','2019-08-09 00:00:00','2019-08-09 00:00:00');
/*!40000 ALTER TABLE `category_kurimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cd_name_sahota`
--

DROP TABLE IF EXISTS `cd_name_sahota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cd_name_sahota` (
  `NO` int(11) DEFAULT NULL,
  `name_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cd_name_sahota`
--

LOCK TABLES `cd_name_sahota` WRITE;
/*!40000 ALTER TABLE `cd_name_sahota` DISABLE KEYS */;
INSERT INTO `cd_name_sahota` VALUES (1,0,NULL,'0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(2,1,'もしもし原宿','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(3,2,'ぱみゅぱみゅレボリューション','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(4,3,'なんだこれくしょん','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(5,4,'ピカピカふぁんたじん','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(6,5,'KPP BEST','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(7,6,'じゃぱみゅ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(8,7,'つけまつける','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(9,8,'CANDY CANDY','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(10,9,'ファッションモンスター','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(11,10,'キミに100パーセント/ふりそでーしょん','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(12,11,'にんじゃりばんばん','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(13,12,'インベーダーインベーダー','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(14,13,'もったいないとらんど','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(15,14,'ゆめのはじまりんりん','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(16,15,'ファミリーパーティー','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(17,16,'きらきらキラー','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(18,17,'もんだいガール','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(19,18,'Crazy Party Night ～ぱんぷきんの逆襲～','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(20,19,'最＆高','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(21,20,'Crazy Crazy/原宿いやほい','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(22,21,'良すた','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(23,22,'きみのみかた','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(24,23,'きみがいいねくれたら','0','2019-06-11 12:00:00','2019-06-11 12:00:00');
/*!40000 ALTER TABLE `cd_name_sahota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cd_type_sahota`
--

DROP TABLE IF EXISTS `cd_type_sahota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cd_type_sahota` (
  `NO` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `cd_type` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cd_type_sahota`
--

LOCK TABLES `cd_type_sahota` WRITE;
/*!40000 ALTER TABLE `cd_type_sahota` DISABLE KEYS */;
INSERT INTO `cd_type_sahota` VALUES (1,0,NULL,'0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(2,1,'アルバム','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(3,2,'シングル','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(4,3,'デジタルシングル','0','2019-06-11 12:00:00','2019-06-11 12:00:00');
/*!40000 ALTER TABLE `cd_type_sahota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `champion_main_tiba`
--

DROP TABLE IF EXISTS `champion_main_tiba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `champion_main_tiba` (
  `id` int(11) NOT NULL,
  `champion_name` varchar(256) NOT NULL,
  `class_id` int(20) DEFAULT NULL,
  `country_id` int(20) DEFAULT NULL,
  `achievement` varchar(20) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `champion_main_tiba`
--

LOCK TABLES `champion_main_tiba` WRITE;
/*!40000 ALTER TABLE `champion_main_tiba` DISABLE KEYS */;
INSERT INTO `champion_main_tiba` VALUES (1,'ノックアウト・CP・フレッシュマート',0,0,'17戦１７勝0負け','タイのプロボクサー。現WBA世界ミニマム級王者。ポンサクレック・ウォンジョンカムなど多くの世界王者を輩出したウィラット・ワチララタナウォンがプロモーター兼会長を務め、ピヤラット・ワチララタナウォンがプロモーターを務めるペッインディー所属。','0','2018-03-01 00:00:00','2018-03-00 00:00:00'),(2,'カルロス・カニサレス',1,1,'２２戦２１勝1分','ベネズエラのWBA世界Lフライ級チャンピオン。オーソドックスなスタイルで最高のスタミナと体幹を活かし、無敗の現役ボクサー。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'アーテム・ダラキアン',2,2,'１８戦１８勝','ウクライナのプロボクサー。アゼルバイジャンバクー出身。現WBA世界フライ級王者。K2プロモーションズ所属。ガードを上げて攻防分離の状況を作るより、極力身体に触れさせずに自分のパンチだけを当てるボクシングスタイル','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'カリッド・ヤファイ',3,3,'２５戦２５勝','イギリスのプロボクサー。バーミンガム出身。現WBA世界スーパーフライ級王者。エディー・ハーンのマッチルーム・スポルト所属。背骨が直角に曲がるほどのスウェーバック、背面を完全に相手に見せるほどの深いダッキング、比較的リードブロー打たない変則型ボクシングスタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'井上　尚弥',4,4,'１８戦１８勝','日本のプロボクサー。神奈川県座間市出身。大橋ボクシングジム所属。広告代理店・マネジメントは株式会社セカンドキャリア。弟は同じプロボクサーの井上拓真。相手がガードしていても、 ガードの上からパンチを叩き込んでダウンを奪う軽量級離れしたパワーを誇る。オーソドックスボクシングスタイル','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(6,'ダニー・ローマン',5,5,'３０戦２７勝2負け１分','アメリカ合衆国のプロボクサー。カリフォルニア州ロサンゼルス出身。現WBA世界スーパーバンタム級王者。トンプソン・ボクシングとエディー・ハーンのマッチルーム・スポーツ所属。ジャブとフックのスイッチを得意とするオーソドックスボクシングスタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(7,'レオ・サンタ・クルス',6,6,'３８戦３６勝1負け１分','メキシコのプロボクサー。元IBF世界バンタム級王者。元WBC世界スーパーバンタム級王者。現WBA世界フェザー級スーパー王者。世界3階級制覇王者。オーソドックスボクシングスタイル','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(8,'アンドリュー・カンシオ',7,7,'18戦１７勝１分','アメリカ合衆国のプロボクサー。WBAインターコンチネンタルスーパーフェザー級王座、第43代WBA世界スーパーフェザー級王座。\r\n体格はウェルター級並み、ガードが非常に硬くカウンターを得意とするオーソドックスボクシングスタイル。\r\n','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(9,'ワシル・ロマチェンコ',8,8,'１４戦１３勝１負け','ウクライナのプロボクサー。オデッサ州ビルホルド・ドニストロフスキー出身。元WBO世界フェザー級王者。元WBO世界スーパーフェザー級王者。現WBAスーパー・WBO世界ライト級統一王者。世界最速の3階級制覇王者。\r\nプレッシャーをかけ手数を多く出して多彩なテクニックを武器に試合を組み立てる。特にコンビネーションを交えたボディ攻撃が巧い。\r\nボクシングスタイルはサウスポー。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(10,'キリル・レリック',9,9,'２１戦１９勝２負け','ベラルーシのプロボクサー。第三シードのWBA世界スーパーライト級チャンピオン。\r\n動体視力がよく、独特のリズムのステップやウィービングを持ちリーチが非常に長いオーソドックスボクシングスタイル。\r\n','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(11,'マニー・パッキャオ',10,10,'７０戦６１勝７負け2分','フィリピンのプロボクサー、政治家、フィリピンプロバスケットボールリーグのバスケットボール選手兼ヘッドコーチ。\r\n元WBC世界フライ級王者。元IBF世界スーパーバンタム級王者。元WBC世界スーパーフェザー級王者。元WBC世界ライト級王者。元WBO世界ウェルター級王者。元WBC世界スーパーウェルター級王者。現WBA世界ウェルター級王者。史上2人目の6階級制覇王者。\r\nスピードとスタミナに優れリングを縦横無尽に動いて手数で圧倒する試合スタイル。サウスポースタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(12,'ジュリア・ウィリアムズ',11,11,'２５戦２２勝１負け１分１無効試合','アメリカのプロボクサー。ペンシルバニア州フィラデルフィア出身。\r\nWBCアメリカ大陸スーパーウェルター級王座。\r\n一撃で相手を仕留めるパンチ力を持つ本格派のファイター。\r\nオーソドックスボクシングスタイル。\r\n','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(13,'ブライアン・カルロス・カスターノ',12,12,'１６戦１５勝１分','アルゼンチンのプロボクサー。ブエノスアイレス州イシドロ・カサノバ出身。現WBA世界スーパーウェルター級王者。\r\nオーソドックスボクシングスタイル。\r\n','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(14,'サウル・アルバレス',13,13,'５５戦５２勝1負け２分','メキシコのプロボクサー。元WBA・WBC世界スーパーウェルター級王者。元WBO世界スーパーウェルター級王者。現WBAスーパー・WBC・IBF世界ミドル級王者。世界3階級制覇王者。\r\nオーソドックスボクシングスタイル。\r\n','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(15,'ロブ・プラント',14,14,'１６戦１４勝1負け1分','アメリカ合衆国のプロボクサー。WBA世界ミドル級王者。\r\n右ボクサーファイタースタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(16,'カラム・スミス',15,15,'１７戦１7勝','イギリスのプロボクサー。リヴァプール出身。元WBO世界スーパーウェルター級王者。\r\nオーソドックスボクシングスタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(17,'ディミトリー・ビボル',16,16,'１５戦１５勝','ロシアのプロボクサー。キルギストクマク出身。現WBA世界ライトヘビー級王者。\r\n誰がみてもわかりやすい、速いの・上手いの・強いの・3拍子揃ったエリートボクシングです。重量級なのにとにかく速いオーソドックスコンビネーション型スタイル','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(18,'ベイバット・シュメノフ',17,17,'２０戦１８勝２負け','カザフスタンのプロボクサー。南カザフスタン州シムケント出身。元WBA世界ライトヘビー級スーパー王者。現WBA世界クルーザー級王者。世界2階級制覇王者。右のフックを武器にバックボーンである空手を感じさせる独特のオーソドックスボクシングスタイル。\r\n','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(19,'デニス・レべデフ',18,18,'３４戦３１勝２負け','ロシアのプロボクサー。ベルゴロド州スタールイ・オスコル出身。現WBA世界クルーザー級休養王者。元IBF世界クルーザー級王者。ロシアのプロボクサーの多くが国外に拠点を移す一方、レベデフはロシアを活動拠点としている。パワフルなファイトを展開し強烈なフックで仕留める選手。サウスポースタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(20,'マニュエルチャー',19,19,'３５戦３１勝４負け','ドイツのプロボクサー。WBCバルチックヘビー級王座、WBAインターナショナルヘビー級王座、WBA世界ヘビー級王者。\r\nムエタイのドイツ王者でガードが固くスピードのあるボクサー。\r\nオーソドックスボクシングスタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(21,'アンソニー・ジョシュア',20,20,'２２戦２２勝','イギリスのプロボクサー。イングランド・ワトフォード出身。現WBAスーパー・IBF・WBO世界ヘビー級統一王者。ロンドンオリンピックスーパーヘビー級金メダリスト。距離を詰めながらの右ストレートを武器にし、一発が重いボクサー。オーソドックスボクシングスタイル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `champion_main_tiba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_tiba`
--

DROP TABLE IF EXISTS `class_tiba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_tiba` (
  `id` int(20) NOT NULL,
  `class` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_tiba`
--

LOCK TABLES `class_tiba` WRITE;
/*!40000 ALTER TABLE `class_tiba` DISABLE KEYS */;
INSERT INTO `class_tiba` VALUES (0,'','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'ミニマム',' ','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'ライトフライ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'ライト','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'スーパーフライ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'バンダム','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(6,'スーパーバンダム','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(7,'フェザー','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(8,'スーパーフェザー','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(9,'ラト','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(10,'スーパーライト','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(11,'ウェルダー','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(12,'スーパーウェルダー','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(13,'ミドル','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(14,'スーパーミドル','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(15,'ライトヘビー','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(16,'クルーザー','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(17,'ヘビー','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `class_tiba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coach_nagashima`
--

DROP TABLE IF EXISTS `coach_nagashima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coach_nagashima` (
  `coach_id` int(11) NOT NULL,
  `country` varchar(50) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach_nagashima`
--

LOCK TABLES `coach_nagashima` WRITE;
/*!40000 ALTER TABLE `coach_nagashima` DISABLE KEYS */;
INSERT INTO `coach_nagashima` VALUES (0,NULL,'0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(1,'日本','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(2,'スペイン','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(3,'スウェーデン','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(4,'オーストラリア','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(5,'韓国','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(6,'セルビア','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(7,'イングランド','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(8,'イタリア','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(9,'アルゼンチン','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(10,'北朝鮮','0','2019-12-04 00:00:00','2019-12-04 00:00:00');
/*!40000 ALTER TABLE `coach_nagashima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color_nakai`
--

DROP TABLE IF EXISTS `color_nakai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color_nakai` (
  `color_id` int(11) NOT NULL,
  `color` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_nakai`
--

LOCK TABLES `color_nakai` WRITE;
/*!40000 ALTER TABLE `color_nakai` DISABLE KEYS */;
INSERT INTO `color_nakai` VALUES (0,NULL,'0','2018-10-15 00:00:00','2018-10-15 00:00:00'),(1,'白','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(2,'黄','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(3,'オレンジ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(4,'ピンク','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(5,'赤','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(6,'青','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(7,'紫','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(8,'緑','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(9,'その他','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(0,NULL,'0','2018-10-15 00:00:00','2018-10-15 00:00:00'),(1,'白','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(2,'黄','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(3,'オレンジ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(4,'ピンク','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(5,'赤','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(6,'青','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(7,'紫','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(8,'緑','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(9,'その他','0','2018-10-09 00:00:00','2018-10-09 00:00:00');
/*!40000 ALTER TABLE `color_nakai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_fujimoto`
--

DROP TABLE IF EXISTS `company_fujimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_fujimoto` (
  `id` int(11) NOT NULL,
  `company` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_fujimoto`
--

LOCK TABLES `company_fujimoto` WRITE;
/*!40000 ALTER TABLE `company_fujimoto` DISABLE KEYS */;
INSERT INTO `company_fujimoto` VALUES (0,'','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(1,'Seagull','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(2,'Anuenue','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(3,'Headway','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(4,'Taylor','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(5,'MARTIN','0','2019-05-20 10:27:00','2019-05-20 10:27:00');
/*!40000 ALTER TABLE `company_fujimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_tiba`
--

DROP TABLE IF EXISTS `country_tiba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_tiba` (
  `id` int(20) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_tiba`
--

LOCK TABLES `country_tiba` WRITE;
/*!40000 ALTER TABLE `country_tiba` DISABLE KEYS */;
INSERT INTO `country_tiba` VALUES (0,'','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'タイ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'ベネズエラ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'ウクライナ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'イギリス','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'日本','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(6,'アメリカ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(7,'メキシコ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(8,'アメリカ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(9,'ウクライナ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(10,'ベラルーシ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(11,'フィリピン','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(12,'アメリカ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(13,'アルゼンチン','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(14,'メキシコ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(15,'アメリカ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(16,'イギリス','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(17,'ロシア','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(18,'カザフスタン','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(19,'ロシア','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(20,'レバノン','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(21,'イギリス','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `country_tiba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cr_main_kawanaka`
--

DROP TABLE IF EXISTS `cr_main_kawanaka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cr_main_kawanaka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(256) DEFAULT NULL,
  `name` varchar(256) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `distribution_id` int(11) DEFAULT NULL,
  `cause` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cr_main_kawanaka`
--

LOCK TABLES `cr_main_kawanaka` WRITE;
/*!40000 ALTER TABLE `cr_main_kawanaka` DISABLE KEYS */;
INSERT INTO `cr_main_kawanaka` VALUES (1,'/CrKawanaka/201911061651583.jpg','センカクモグラ',1,9,'持ち込まれたヤギによる森林領域の減少','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(2,'/CrKawanaka/201911071134970.jpg','ダイトウオオコウモリ',1,9,'生存地域の開発により減少','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(3,'/CrKawanaka/201911071030040.jpg','エラブオオコウモリ',1,8,'生存競争と主な生息地の火山噴火','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(4,'/CrKawanaka/201911071032286.gif','クロアカコウモリ',1,8,'韓国や台湾に分布していて日本にもともと個体数がいない。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(5,'/CrKawanaka/201911071136116.jpg','ヤンバルホオヒゲコウモリ',1,9,'開発による樹洞の減少により減少','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(6,'/CrKawanaka/201911071050522.jpg','セスジネズミ',1,9,'持ち込まれたヤギによる森林領域の減少','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(7,'/CrKawanaka/201911071051890.jpg','オキナワトゲネズミ',1,9,'猫や犬、マングースによる捕食の為','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(8,'/CrKawanaka/201911071136879.jpg','ツシマヤマネコ',1,8,'生息環境の悪化や交通事故などで生息数減少','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(9,'/CrKawanaka/201911071053595.jpg','イリオモテヤマネコ',1,9,'交通事故や飼い猫との間で猫免疫不全ウイルス感染症等の伝染病、生息域内での競合により減少','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(10,'/CrKawanaka/201911071054268.jpg','ラッコ',1,1,'毛皮目的による乱獲と海洋環境の変化や食料源をめぐる人間等の競合のため減少。水族館で見られるのもわずか10頭のみ。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(11,'/CrKawanaka/201911071056403.jpg','ニホンアシカ',1,12,'貝塚からも骨が出てくるほどの付き合いだが乱獲により減少。1974年以降の捕獲例がなくEXに分類されるかCRに分類されるか議論されている。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(12,'/CrKawanaka/201911071058346.jpeg','ジュゴン',1,9,'外から持ち込まれた動植物（アカギ、ヤギ）による在来植生の破壊、クマネズミとの餌資源の競合により減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(13,'/CrKawanaka/201911071058582.jpg','ハクガン',2,12,'乱獲によって減少していたが1993年」より国際共同計画として白眼復元計画が実行され飛来数は増加傾向になっている。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(14,'/CrKawanaka/201911071059697.jpg','シジュウカラガン',2,10,'毛皮目的で放たれた狐による捕食の為減少','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(15,'/CrKawanaka/201911071100807.jpg','アカガシラカラスバト',2,3,'外から持ち込まれた動植物（アカギ、ヤギ）による在来植生の破壊、クマネズミとの餌資源の競合により減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(16,'/CrKawanaka/201911071101595.jpg','オガサワラヒメミズナギドリ',2,3,'外来ネズミによる捕食の為減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(17,'/CrKawanaka/201911071102680.jpg','クロコシジロウミツバメ',2,2,'オオミズナギドリとの生存競争（同じく地面に巣穴をほるためクロコシジロウミツバメが巣穴を掘れなくなってしまった）の為減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(18,'/CrKawanaka/201911071103065.jpg','コウノトリ',2,12,'田園での農薬使用により餌となるカエルやどじょうが減少したため。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(19,'/CrKawanaka/201911071104827.jpg','チシマウガラス',2,1,'人による繁殖地の侵略、大セグロカモメによる卵や雛の捕食により減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(20,'/CrKawanaka/201911071115909.jpg','オオヨシゴイ',2,12,'湿地開発は河川改修などによる生息地の破壊、農薬汚染により減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(21,'/CrKawanaka/201911071115337.jpg','トキ',2,12,'羽毛を取るために乱獲され激減、その後森林伐採、農薬の多用による餌の減少、山間部の水田の消失などにより減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(22,'/CrKawanaka/201911071116850.jpg','ヤンバルクイナ',2,9,'ノネコとマングースによる捕食。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(23,'/CrKawanaka/201911071116976.jpg','ヘラシギ',2,12,'干潟の減少、狩猟の影響により減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(24,'/CrKawanaka/201911071118424.jpg','カラフトアオアシシギ',2,12,'干潟の減少により。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(25,'/CrKawanaka/201911061652177.jpg','エトピリカ',2,1,'餌不足や漁網に引っかかる被害により減少、日本以外では絶滅の恐れはない。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(26,'/CrKawanaka/201911071117788.jpg','ウミスズメ',2,1,'繁殖地でのネズミ類やカラス類による捕食、漁業による混獲等により減少。1997年のナホトカ号重油流出事故において400羽弱が漂着死骸として発見されている。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(27,'/CrKawanaka/201911071119887.jpg','ウミガラス',2,1,'オオセグロカモメやハシブトガラスによる卵や雛の捕食によって減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(28,'/CrKawanaka/201911071120715.jpg','カンムリワシ',2,9,'開発により森林、雑木林がなくなり繁殖地が減少、交通事故での死亡件数も増加していることが要因。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(29,'/CrKawanaka/201911071121526.jpg','キンメフクロウ',2,1,'森林の減少による。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(30,'/CrKawanaka/201911071122613.jpg','ワシミミズク',2,1,'もともと日本には迷い込んできたもので個体数が少ない。海外では低懸念。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(31,'/CrKawanaka/201911071123229.jpg','シマフクロウ',2,1,'とても繊細で人間が近づくだけでも育児放棄してしまう日本最大のフクロウ。開発による生息地の破壊、水質汚染、漁業との競合交通事故などが減少の要因。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(32,'/CrKawanaka/201911071124922.jpg','ミユビゲラ',2,1,'森林領域の減少のため','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(33,'/CrKawanaka/201911071124865.jpg','ノグチゲラ',2,9,'1960年から80年代にかけて森林伐採や農地開発、ダムの建設等により天然林が極度に減少したため。ノネコ、マングース等による捕食の為。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(34,'/CrKawanaka/201911071125149.jpg','チゴモズ',2,12,'元々個体数が少なく東京都や埼玉では宅地化により生息地が消失、樹林と草地が組み合わされた環境が減少もしくは悪化している可能性が考えられている。海外では低懸念。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(35,'/CrKawanaka/201911071126694.jpg','オガサワラカワラヒワ',2,3,'外来ネズミによる捕食の為減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(36,'/CrKawanaka/201911071126065.jpg','シマアオジ',2,1,'渡りの中継地である中国での乱獲で減少。中国では捕獲や市場での売買が禁止されているが今でも違法な捕獲や闇市での摘発が後を絶たない。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(37,'/CrKawanaka/201911071127716.jpg','マダラトカゲモドキ',3,9,'ノイヌ、ノネコ、ウシガエル、マングースアドによる捕食によって激減。海外ではENに指定されている。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(38,'/CrKawanaka/201911071128672.jpg','イヘヤトカゲモドキ',3,9,'個体数がそもそも少なく生態は不明。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(39,'/CrKawanaka/201911071129956.jpg','クメトカゲモドキ',3,9,'林道建設や農地開発による生息地の破壊により生息数が減少し、ペット用の採集も懸念されている','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(40,'/CrKawanaka/201911071130345.jpg','ミヤコカナヘビ',3,9,'イタチなどによる捕食、ペット目的での乱獲による減少も懸念されている。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(41,'/CrKawanaka/201911071130694.jpg','キクザトサワヘビ',3,9,'森林開発による生息域の減少、水質汚染、観賞用の乱獲によって減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(42,'/CrKawanaka/201911071131518.jpg','アベサンショウウオ',4,5,'農地開発や道路建設、ゴルフ場開発などによる生息地の破壊、ごみの不法投棄、外来生物による捕食、マニアによる採集などにより減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(43,'/CrKawanaka/201911071132554.jpg','ミカワサンショウウオ',4,4,'分布が限定的。森林伐採による生息地破壊、道路建設や土地造成による土砂の流入、マニアの採集により減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(44,'/CrKawanaka/201911071133695.jpg','アマクササンショウウオ',4,8,'分布が限定的。開発に伴う生息地の減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(45,'/CrKawanaka/201911071133030.jpg','ツクバハコネサンショウウオ',4,3,'分布が限定的で砂防堤防や林道建設による生息地の分断化、砂防堤防建設による要請の生息地破壊、マニアの採集により減少。','0','2019-10-28 00:00:00','2019-10-28 00:00:00');
/*!40000 ALTER TABLE `cr_main_kawanaka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deck_okugawa`
--

DROP TABLE IF EXISTS `deck_okugawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deck_okugawa` (
  `id` int(11) NOT NULL,
  `deck_attribute` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deck_okugawa`
--

LOCK TABLES `deck_okugawa` WRITE;
/*!40000 ALTER TABLE `deck_okugawa` DISABLE KEYS */;
INSERT INTO `deck_okugawa` VALUES (0,NULL,'0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(1,'炎','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(2,'水','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(3,'地','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(4,'風','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(5,'光','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(6,'闇','0','2019-06-10 12:00:00','2019-06-10 12:00:00');
/*!40000 ALTER TABLE `deck_okugawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribution_kawanaka`
--

DROP TABLE IF EXISTS `distribution_kawanaka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distribution_kawanaka` (
  `distribution_id` int(11) NOT NULL AUTO_INCREMENT,
  `distribution` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`distribution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribution_kawanaka`
--

LOCK TABLES `distribution_kawanaka` WRITE;
/*!40000 ALTER TABLE `distribution_kawanaka` DISABLE KEYS */;
INSERT INTO `distribution_kawanaka` VALUES (0,NULL,'0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(1,'北海道地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(2,'東北地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(3,'関東地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(4,'中部地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(5,'近畿地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(6,'中国地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(7,'四国地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(8,'九州地方','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(9,'沖縄','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(10,'東日本','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(11,'西日本','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(12,'日本全域','0','2019-10-28 00:00:00','2019-10-28 00:00:00'),(13,'情報不十分','0','2019-10-28 00:00:00','2019-10-28 00:00:00');
/*!40000 ALTER TABLE `distribution_kawanaka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district_uezu`
--

DROP TABLE IF EXISTS `district_uezu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district_uezu` (
  `id` int(11) NOT NULL,
  `district` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district_uezu`
--

LOCK TABLES `district_uezu` WRITE;
/*!40000 ALTER TABLE `district_uezu` DISABLE KEYS */;
INSERT INTO `district_uezu` VALUES (0,NULL,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(1,'東地区','0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(2,'中地区','0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(3,'西地区','0','2019-05-21 00:00:00','2019-05-21 00:00:00');
/*!40000 ALTER TABLE `district_uezu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fa`
--

DROP TABLE IF EXISTS `fa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fa` (
  `id` int(10) NOT NULL,
  `band_name` varchar(100) NOT NULL,
  `member` int(2) DEFAULT NULL,
  `band_year` int(4) DEFAULT NULL,
  `band_sex` int(2) DEFAULT NULL,
  `genre_id` int(2) DEFAULT NULL,
  `comment` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fa`
--

LOCK TABLES `fa` WRITE;
/*!40000 ALTER TABLE `fa` DISABLE KEYS */;
/*!40000 ALTER TABLE `fa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feature_sakuma`
--

DROP TABLE IF EXISTS `feature_sakuma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feature_sakuma` (
  `id` int(1) NOT NULL,
  `feature_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feature_sakuma`
--

LOCK TABLES `feature_sakuma` WRITE;
/*!40000 ALTER TABLE `feature_sakuma` DISABLE KEYS */;
INSERT INTO `feature_sakuma` VALUES (0,NULL,NULL,'2019-07-08 11:00:00','2019-07-08 11:00:00'),(1,'回復','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(2,'攻撃','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(3,'前進','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(4,'先手','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(5,'追撃','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(6,'突撃','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(7,'爆発力','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(8,'妨害','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(9,'ポーク','0','2019-07-08 11:00:00','2019-07-08 11:00:00');
/*!40000 ALTER TABLE `feature_sakuma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_actor_akata`
--

DROP TABLE IF EXISTS `film_actor_akata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_actor_akata` (
  `id` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_actor_akata`
--

LOCK TABLES `film_actor_akata` WRITE;
/*!40000 ALTER TABLE `film_actor_akata` DISABLE KEYS */;
INSERT INTO `film_actor_akata` VALUES (0,NULL,'0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(1,'ルーク・ウィルソン','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(2,'ジェイソン・シュワルツマン','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(3,'ジーン・ハックマン','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(4,'ビル・マーレイ','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(5,'ジェフ・ダニエルズ','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(6,'オーウェン・ウィルソン','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(7,'ジョージ・クルーニー','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(8,'ジャレッド・ギルマン','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(9,'レイフ・ファインズ','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(10,'コーユー・ランキン','0','2019-12-05 00:00:00','2019-12-05 00:00:00');
/*!40000 ALTER TABLE `film_actor_akata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_genre_akata`
--

DROP TABLE IF EXISTS `film_genre_akata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_genre_akata` (
  `id` int(10) NOT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_genre_akata`
--

LOCK TABLES `film_genre_akata` WRITE;
/*!40000 ALTER TABLE `film_genre_akata` DISABLE KEYS */;
INSERT INTO `film_genre_akata` VALUES (0,NULL,'0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(1,'コメディ','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(2,'アドベンチャー','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(3,'アニメーション','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(4,'ロマンス','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(5,'クライム','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(6,'ドラマ','0','2019-12-05 00:00:00','2019-12-05 00:00:00');
/*!40000 ALTER TABLE `film_genre_akata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_main_akata`
--

DROP TABLE IF EXISTS `film_main_akata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_main_akata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `film_title` varchar(100) NOT NULL,
  `genre_id` int(10) NOT NULL,
  `actor_id` int(10) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `run_time` int(3) DEFAULT NULL,
  `recommend` varchar(10) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `genre_id` (`genre_id`),
  KEY `actor_id` (`actor_id`),
  CONSTRAINT `film_main_akata_ibfk_1` FOREIGN KEY (`genre_id`) REFERENCES `film_genre_akata` (`id`),
  CONSTRAINT `film_main_akata_ibfk_2` FOREIGN KEY (`actor_id`) REFERENCES `film_actor_akata` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_main_akata`
--

LOCK TABLES `film_main_akata` WRITE;
/*!40000 ALTER TABLE `film_main_akata` DISABLE KEYS */;
INSERT INTO `film_main_akata` VALUES (1,'アンソニーのハッピー・モーテル',1,1,1996,91,'★★★★★★★☆☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(2,'天才マックスの世界',1,2,1998,93,'★★★★★★★☆☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(3,'ザ・ロイヤルテネンバウムズ',1,3,2001,109,'★★★★★★★★☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(4,'ライフ・アクアティック',2,4,2004,118,'★★★★★★★☆☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(5,'イカとクジラ',6,5,2005,81,'★★★★★★★☆☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(6,'ダージリン急行',2,6,2007,91,'★★★★★★★☆☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(7,'ファンタスティックMr.FOX',3,7,2009,87,'★★★★★★★★☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(8,'ムーンライズ・キングダム',4,8,2012,94,'★★★★★★★★☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(9,'マイ・ファニー・レディ',6,6,2014,93,'★★★★★★☆☆☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(10,'グランド・ブダペスト・ホテル',5,9,2014,100,'★★★★★★★★☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(11,'犬ヶ島',3,10,2018,105,'★★★★★★★★☆☆','0','2019-12-05 00:00:00','2019-12-05 00:00:00'),(12,'The French Dispatch',6,NULL,2020,NULL,'','1','2019-12-13 17:49:44','2019-12-13 17:49:44');
/*!40000 ALTER TABLE `film_main_akata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flower_main_nakai`
--

DROP TABLE IF EXISTS `flower_main_nakai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flower_main_nakai` (
  `id` int(11) NOT NULL,
  `flower_image` varchar(256) DEFAULT NULL,
  `flower_name` varchar(256) NOT NULL,
  `month_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  `country` varchar(256) DEFAULT NULL,
  `word` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flower_main_nakai`
--

LOCK TABLES `flower_main_nakai` WRITE;
/*!40000 ALTER TABLE `flower_main_nakai` DISABLE KEYS */;
INSERT INTO `flower_main_nakai` VALUES (1,'/FlowerNakai/ume.jpg','梅（ウメ）',1,1,'中国','高潔、澄んだ心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(2,'/FlowerNakai/sazanka.jpg','山茶花（サザンカ）',1,4,'日本','素直、飾らない心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(3,'/FlowerNakai/cyclamen.jpg','シクラメン',2,7,'トルコ','清純、はにかみ、思慮深い','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(4,'/FlowerNakai/fukujuso.jpg','福寿草（フクジュソウ）',2,2,'日本','幸せを招く','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(5,'/FlowerNakai/momo.jpg','桃（モモ）',3,4,'中国','チャーミング、私はあなたの虜','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(6,'/FlowerNakai/boke.jpg','木瓜（ボケ）',3,5,'中国','平凡','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(7,'/FlowerNakai/sakura.jpg','桜（サクラ）',4,4,'日本','高尚、教養、心の美','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(8,'/FlowerNakai/fuji.jpg','藤（フジ）',4,7,'日本','恋に酔う','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(9,'/FlowerNakai/carnation.jpg','カーネーション',5,5,'地中海沿岸から西アジア','純愛','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(10,'/FlowerNakai/ayame.jpg','菖蒲（アヤメ）',5,6,'ユーラシア大陸','気品漂う','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(11,'/FlowerNakai/gakuajisai.jpg','額紫陽花（ガクアジサイ）',6,7,'日本','謙虚','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(12,'/FlowerNakai/shirotsumekusa.jpg','シロツメクサ（クローバー）',6,1,'ヨーロッパ','約束','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(13,'/FlowerNakai/hozuki.jpg','鬼灯（ホオヅキ）',7,3,'東南アジア','笑顔','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(14,'/FlowerNakai/kikyo.jpg','桔梗（キキョウ）',7,6,'日本','不屈の心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(15,'/FlowerNakai/himawari.jpg','向日葵（ヒマワリ）',8,2,'北米','栄光','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(16,'/FlowerNakai/hibisucus.jpg','ハイビスカス',8,5,'不明','繊細な美','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(17,'/FlowerNakai/kiku.jpg','菊（キク）',9,2,'中国','信頼','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(18,'/FlowerNakai/manjusyage.jpg','曼珠沙華（マンジュシャゲ）',9,5,'中国','感謝','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(19,'/FlowerNakai/kinmokusei.jpg','金木犀（キンモクセイ）',10,2,'中国','変わらぬ魅力','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(20,'/FlowerNakai/susuki.jpg','薄（ススキ）',10,8,'中国','秋風に想いを乗せて','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(21,'/FlowerNakai/marygold.jpg','マリーゴールド',11,3,'メキシコ','嫉妬、絶望、悲しみ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(22,'/FlowerNakai/bara.jpg','薔薇（バラ）',11,4,'不明','しとやか、上品、可愛い人','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(23,'/FlowerNakai/nanten.jpg','南天（ナンテン）',12,1,'中国','ますます幸せ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(24,'/FlowerNakai/poinsettia.jpg','ポインセチア',12,5,'メキシコ','祝福','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(25,NULL,'山法師（ヤマボウシ）',5,8,'日本、中国、朝鮮半島','友情','0','2018-10-16 09:29:34','2018-10-16 09:29:34'),(1,'/FlowerNakai/ume.jpg','梅（ウメ）',1,1,'中国','高潔、澄んだ心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(2,'/FlowerNakai/sazanka.jpg','山茶花（サザンカ）',1,4,'日本','素直、飾らない心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(3,'/FlowerNakai/cyclamen.jpg','シクラメン',2,7,'トルコ','清純、はにかみ、思慮深い','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(4,'/FlowerNakai/fukujuso.jpg','福寿草（フクジュソウ）',2,2,'日本','幸せを招く','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(5,'/FlowerNakai/momo.jpg','桃（モモ）',3,4,'中国','チャーミング、私はあなたの虜','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(6,'/FlowerNakai/boke.jpg','木瓜（ボケ）',3,5,'中国','平凡','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(7,'/FlowerNakai/sakura.jpg','桜（サクラ）',4,4,'日本','高尚、教養、心の美','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(8,'/FlowerNakai/fuji.jpg','藤（フジ）',4,7,'日本','恋に酔う','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(9,'/FlowerNakai/carnation.jpg','カーネーション',5,5,'地中海沿岸から西アジア','純愛','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(10,'/FlowerNakai/ayame.jpg','菖蒲（アヤメ）',5,6,'ユーラシア大陸','気品漂う','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(11,'/FlowerNakai/gakuajisai.jpg','額紫陽花（ガクアジサイ）',6,7,'日本','謙虚','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(12,'/FlowerNakai/shirotsumekusa.jpg','シロツメクサ（クローバー）',6,1,'ヨーロッパ','約束','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(13,'/FlowerNakai/hozuki.jpg','鬼灯（ホオヅキ）',7,3,'東南アジア','笑顔','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(14,'/FlowerNakai/kikyo.jpg','桔梗（キキョウ）',7,6,'日本','不屈の心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(15,'/FlowerNakai/himawari.jpg','向日葵（ヒマワリ）',8,2,'北米','栄光','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(16,'/FlowerNakai/hibisucus.jpg','ハイビスカス',8,5,'不明','繊細な美','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(17,'/FlowerNakai/kiku.jpg','菊（キク）',9,2,'中国','信頼','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(18,'/FlowerNakai/manjusyage.jpg','曼珠沙華（マンジュシャゲ）',9,5,'中国','感謝','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(19,'/FlowerNakai/kinmokusei.jpg','金木犀（キンモクセイ）',10,2,'中国','変わらぬ魅力','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(20,'/FlowerNakai/susuki.jpg','薄（ススキ）',10,8,'中国','秋風に想いを乗せて','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(21,'/FlowerNakai/marygold.jpg','マリーゴールド',11,3,'メキシコ','嫉妬、絶望、悲しみ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(22,'/FlowerNakai/bara.jpg','薔薇（バラ）',11,4,'不明','しとやか、上品、可愛い人','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(23,'/FlowerNakai/nanten.jpg','南天（ナンテン）',12,1,'中国','ますます幸せ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(24,'/FlowerNakai/poinsettia.jpg','ポインセチア',12,5,'メキシコ','祝福','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(25,NULL,'山法師（ヤマボウシ）',5,8,'日本、中国、朝鮮半島','友情','0','2018-10-16 09:29:34','2018-10-16 09:29:34');
/*!40000 ALTER TABLE `flower_main_nakai` ENABLE KEYS */;
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
-- Table structure for table `genre_kambara`
--

DROP TABLE IF EXISTS `genre_kambara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_kambara` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_kambara`
--

LOCK TABLES `genre_kambara` WRITE;
/*!40000 ALTER TABLE `genre_kambara` DISABLE KEYS */;
INSERT INTO `genre_kambara` VALUES (0,NULL,'0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(1,'ハイブランド','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(2,'アウトドア','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(3,'セレクトブランド','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(4,'ストリート','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(5,'ラグジュアリーブランド','0','2019-09-18 00:00:00','2019-09-18 00:00:00');
/*!40000 ALTER TABLE `genre_kambara` ENABLE KEYS */;
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
INSERT INTO `genre_kataoka` VALUES (0,' ','0','2020-03-24 02:37:07','2018-09-17 06:00:00'),(1,'文化遺産','0','2020-03-24 02:39:42','2018-09-17 06:00:00'),(2,'自然遺産','0','2020-03-24 02:39:08','2020-03-23 17:00:00');
/*!40000 ALTER TABLE `genre_kataoka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_kurihara`
--

DROP TABLE IF EXISTS `genre_kurihara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_kurihara` (
  `id` int(11) NOT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_kurihara`
--

LOCK TABLES `genre_kurihara` WRITE;
/*!40000 ALTER TABLE `genre_kurihara` DISABLE KEYS */;
INSERT INTO `genre_kurihara` VALUES (0,NULL,0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(1,'家',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(2,'家（大）',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(3,'城',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(4,'軍事施設',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(5,'工業施設',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(6,'商業施設',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(7,'医療・公共施設',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(8,'群市町村',0,'2019-05-08 00:00:00','2019-05-08 00:00:00');
/*!40000 ALTER TABLE `genre_kurihara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_miyamoto`
--

DROP TABLE IF EXISTS `genre_miyamoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_miyamoto` (
  `genre_id` int(11) NOT NULL,
  `genre_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_miyamoto`
--

LOCK TABLES `genre_miyamoto` WRITE;
/*!40000 ALTER TABLE `genre_miyamoto` DISABLE KEYS */;
INSERT INTO `genre_miyamoto` VALUES (0,'','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(1,'風刺','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(2,'長編小説','0','2019-05-07 00:00:00','2019-05-07 00:00:00'),(3,'短編小説','0','2019-05-07 00:00:00','2019-05-07 00:00:00');
/*!40000 ALTER TABLE `genre_miyamoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_nagatake`
--

DROP TABLE IF EXISTS `genre_nagatake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_nagatake` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_nagatake`
--

LOCK TABLES `genre_nagatake` WRITE;
/*!40000 ALTER TABLE `genre_nagatake` DISABLE KEYS */;
INSERT INTO `genre_nagatake` VALUES (0,NULL,'0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(1,'SF/ファンタジー','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(2,'ロボット/メカ','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(3,'アクション/バトル','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(4,'コメディ/ギャグ','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(5,'恋愛ラブコメ','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(6,'日常/ほのぼの','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(7,'スポーツ/競技','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(8,'ホラー/サスペンス/推理','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(9,'戦争/ミリタリー','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(10,'感動','0','2019-09-13 00:00:00','2019-09-13 00:00:00');
/*!40000 ALTER TABLE `genre_nagatake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_okudaira`
--

DROP TABLE IF EXISTS `genre_okudaira`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_okudaira` (
  `id` int(11) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_okudaira`
--

LOCK TABLES `genre_okudaira` WRITE;
/*!40000 ALTER TABLE `genre_okudaira` DISABLE KEYS */;
INSERT INTO `genre_okudaira` VALUES (1,'純文学','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(2,'ミステリ','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(3,'ホラー','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(4,'経済小説','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(5,'SF','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(0,'','0','2019-11-01 00:00:00','2019-11-01 00:00:00');
/*!40000 ALTER TABLE `genre_okudaira` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_sako`
--

DROP TABLE IF EXISTS `genre_sako`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_sako` (
  `genre_id` int(11) DEFAULT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_sako`
--

LOCK TABLES `genre_sako` WRITE;
/*!40000 ALTER TABLE `genre_sako` DISABLE KEYS */;
INSERT INTO `genre_sako` VALUES (1,'アイスクリーム',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(2,'アイスミルク',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(3,'ラクトアイス',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(1,'アイスクリーム',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(2,'アイスミルク',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(3,'ラクトアイス',0,'2018-10-16 00:00:00','2018-10-16 00:00:00');
/*!40000 ALTER TABLE `genre_sako` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_taneichi`
--

DROP TABLE IF EXISTS `genre_taneichi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_taneichi` (
  `id` int(2) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_taneichi`
--

LOCK TABLES `genre_taneichi` WRITE;
/*!40000 ALTER TABLE `genre_taneichi` DISABLE KEYS */;
INSERT INTO `genre_taneichi` VALUES (0,'','0','2019-05-24 16:50:00','2019-05-24 16:50:00'),(1,'ロック','0','0019-05-24 16:01:18','2019-05-24 16:01:18'),(2,'ポップ','0','2019-05-24 16:01:18','2019-05-24 16:01:18'),(3,'オルタナティヴ','0','2019-05-24 16:01:18','2019-05-24 16:01:18'),(4,'ヒップホップ','0','2019-05-24 16:01:18','2019-05-24 16:01:18'),(5,'パンク','0','2019-05-24 16:01:18','2019-05-24 16:01:18');
/*!40000 ALTER TABLE `genre_taneichi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_uchiyama`
--

DROP TABLE IF EXISTS `genre_uchiyama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_uchiyama` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genre` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flg` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_uchiyama`
--

LOCK TABLES `genre_uchiyama` WRITE;
/*!40000 ALTER TABLE `genre_uchiyama` DISABLE KEYS */;
INSERT INTO `genre_uchiyama` VALUES (0,NULL,'0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(1,'文学','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(2,'SF','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(3,'エッセイ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(4,'不明','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(5,'その他','0','2019-09-17 00:00:00','2019-09-17 00:00:00');
/*!40000 ALTER TABLE `genre_uchiyama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_waki`
--

DROP TABLE IF EXISTS `genre_waki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_waki` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `genre` varchar(10) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_waki`
--

LOCK TABLES `genre_waki` WRITE;
/*!40000 ALTER TABLE `genre_waki` DISABLE KEYS */;
INSERT INTO `genre_waki` VALUES (0,NULL,'0','2019-12-05','2019-12-05'),(1,'ロック','0','2019-12-04','2019-12-04'),(2,'バラード','0','2019-12-04','2019-12-04');
/*!40000 ALTER TABLE `genre_waki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guiter_main_fujimoto`
--

DROP TABLE IF EXISTS `guiter_main_fujimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guiter_main_fujimoto` (
  `id` int(11) NOT NULL,
  `aco_name` varchar(256) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `wood_id` int(11) DEFAULT NULL,
  `price_int` int(8) DEFAULT NULL,
  `color_name` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guiter_main_fujimoto`
--

LOCK TABLES `guiter_main_fujimoto` WRITE;
/*!40000 ALTER TABLE `guiter_main_fujimoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `guiter_main_fujimoto` ENABLE KEYS */;
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
INSERT INTO `heritage_main_kataoka` VALUES (1,1,'/heritageKataoka/horyuji.jpeg\r\n','法隆寺地域の仏教建造物',29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,NULL,'0','2018-09-30 21:01:17','2018-09-17 06:00:00'),(2,1,'/heritageKataoka/himejijyo.jpeg\r\n','姫路城',28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,NULL,'0','2018-09-30 21:01:35','2018-09-17 06:00:00'),(3,1,'/heritageKataoka/kyoto.jpeg\r\n','古都京都の文化財（京都市、宇治市、大津市）',26,25,NULL,NULL,NULL,NULL,NULL,NULL,1994,NULL,'0','2018-09-30 21:01:52','2018-09-17 06:00:00'),(4,1,'/heritageKataoka/shirakawago.jpeg\r\n','白川郷・五箇山の合掌造り集落',21,16,NULL,NULL,NULL,NULL,NULL,NULL,1995,NULL,'0','2018-09-30 21:02:06','2018-09-17 06:00:00'),(5,1,'/heritageKataoka/genbakudomu.jpeg\r\n','原爆ドーム',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1996,'負の世界遺産','0','2018-09-30 21:02:15','2018-09-17 06:00:00'),(6,1,'/heritageKataoka/itsukushima.jpeg\r\n','厳島神社',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1996,NULL,'0','2018-09-30 21:02:20','2018-09-17 06:00:00'),(7,1,'/heritageKataoka/nara.jpeg\r\n','古都奈良の文化財',29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1998,NULL,'0','2018-09-30 21:02:25','2018-09-17 06:00:00'),(8,1,'/heritageKataoka/nikkoTemple.jpeg\r\n','日光の社寺',9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1999,NULL,'0','2018-09-30 21:02:30','2018-09-17 06:00:00'),(9,1,'/heritageKataoka/ryukyuKingdum.jpeg\r\n','琉球王国のグスク及び関連遺産群',47,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2000,NULL,'0','2018-09-30 21:02:41','2018-09-17 06:00:00'),(10,1,'/heritageKataoka/mtKi.jpeg\r\n','紀伊山地の霊場と参詣道',30,29,24,NULL,NULL,NULL,NULL,NULL,2004,'文化的景観、2016年に軽微な変更','0','2018-09-30 21:02:50','2018-09-17 06:00:00'),(11,1,'/heritageKataoka/iwamiginzan.jpeg\r\n','石見銀山遺跡とその文化的景観',32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2007,'文化的景観、産業遺産、2010年の軽微な変更','0','2018-09-30 21:02:59','2018-09-17 06:00:00'),(12,1,'/heritageKataoka/hiraizumi.jpeg\r\n','平泉―仏国土（浄土）を表す建築・庭園及び考古学的遺跡群―',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2011,NULL,'0','2018-09-30 21:03:15','2018-09-17 06:00:00'),(13,1,'/heritageKataoka/mtFuji.jpeg\r\n','富士山―信仰の対象と芸術の源泉',22,19,NULL,NULL,NULL,NULL,NULL,NULL,2013,NULL,'0','2018-09-30 21:03:10','2018-09-17 06:00:00'),(14,1,'/heritageKataoka/tomiokaseisijyo.jpeg\r\n','富岡製糸場と絹産業遺産群',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2014,'産業遺産、近代化遺産','0','2018-09-30 21:03:20','2018-09-17 06:00:00'),(15,1,'/heritageKataoka/meijiRevol.jpg\r\n\r\n','明治日本の産業革命遺産 製鉄・製鋼、造船、石炭産業',35,40,41,42,43,46,3,22,2015,'産業遺産、近代化遺産、稼働遺産','0','2018-09-30 21:09:12','2018-09-17 06:00:00'),(16,1,'/heritageKataoka/luColuvu.jpeg\r\n','ル・コルビュジエの建築作品-近代建築運動への顕著な貢献-',13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2016,'現代建築、国境を越える世界遺産','0','2018-09-30 21:03:30','2018-09-17 06:00:00'),(17,1,'/heritageKataoka/okinoshima.jpeg\r\n','「神宿る島」宗像・沖ノ島と関連遺産群',40,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2017,NULL,'0','2018-09-30 21:03:34','2018-09-17 06:00:00'),(18,1,'/heritageKataoka/nagasaki.jpeg\r\n','長崎と天草地方の潜伏キリシタン関連遺産',42,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2018,NULL,'0','2018-09-30 21:03:39','2018-09-17 06:00:00'),(19,2,'/heritageKataoka/yakushima.jpeg\r\n','屋久島',46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1993,'屋久島国立公園、屋久島原生自然環境保全地域','0','2018-09-30 21:03:46','2018-09-17 06:00:00'),(20,2,'/heritageKataoka/mtSirakami.jpeg\r\n','白神山地',2,5,NULL,NULL,NULL,NULL,NULL,NULL,1993,'白神山地自然環境保全地域、','0','2018-09-30 21:03:52','2018-09-17 06:00:00'),(21,2,'/heritageKataoka/siretoko.jpeg\r\n','知床',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2005,'知床国立公園、遠音別岳原生自然環境保全地域','0','2018-09-30 21:03:57','2018-09-17 06:00:00'),(22,2,'/heritageKataoka/ogasawara.jpg\r\n\r\n','小笠原諸島',13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2011,'小笠原国立公園、南硫黄島原生自然環境保全地域','0','2018-09-30 21:08:48','2018-09-17 06:00:00');
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
INSERT INTO `hometown_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'北海道','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'青森県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'岩手県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'宮城県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'秋田県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'山形県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'福島県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'茨城県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'栃木県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'群馬県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'埼玉県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'千葉県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'東京都','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'神奈川県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'新潟県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'富山県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'石川県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'福井県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(19,'山梨県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(20,'長野県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(21,'岐阜県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(22,'静岡県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(23,'愛知県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(24,'三重県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(25,'滋賀県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(26,'京都府','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(27,'大阪府','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(28,'兵庫県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(29,'奈良県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(30,'和歌山県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(31,'鳥取県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(32,'島根県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(33,'岡山県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(34,'広島県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(35,'山口県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(36,'徳島県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(37,'香川県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(38,'愛媛県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(39,'高知県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(40,'福岡県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(41,'佐賀県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(42,'長崎県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(43,'熊本県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(44,'大分県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(45,'宮崎県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(46,'鹿児島県','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(47,'沖縄県','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
/*!40000 ALTER TABLE `hometown_matsuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icecream_main_sako`
--

DROP TABLE IF EXISTS `icecream_main_sako`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icecream_main_sako` (
  `id` int(25) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `genre_id` int(25) DEFAULT NULL,
  `photo` varchar(256) DEFAULT NULL,
  `maker_id` int(25) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icecream_main_sako`
--

LOCK TABLES `icecream_main_sako` WRITE;
/*!40000 ALTER TABLE `icecream_main_sako` DISABLE KEYS */;
INSERT INTO `icecream_main_sako` VALUES (1,'チョコモナカジャンボ',2,'/icecreamSako/janbomonaka.jpg',1,'真ん中にパリパリのチョコ！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(2,'ピノ',1,'/icecreamSako/pino.jpg',1,'箱を開けるわくわく感',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(3,'パルム',1,'/icecreamSako/parm.jpg',1,'アイスの王道！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(4,'ザクレープ',2,'/icecreamSako/thecreap.jpg',1,'生地もおいしい',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(5,'チーズスティック',1,'/icecreamSako/cheesestick.jpg',1,'まるでチーズケーキ！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(6,'MOW',1,'/icecreamSako/mow.jpg',1,'ミルク感',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(7,'パピコ',4,'/icecreamSako/papico.jpg',2,'半分こできて良き',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(8,'アイスの実',4,'/icecreamSako/icenomi.jpg',2,'かわいいしおいしい◎',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(9,'ジャイアントコーン',2,'/icecreamSako/giantcone.jpg',2,'食べ応えもおいしさも抜群',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(10,'panapp',3,'/icecreamSako/panapp.jpg',2,'にこちゃん以外も出るよ',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(11,'スーパーカップ',3,'/icecreamSako/supercup.jpg',3,'コスパ最強',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(12,'ガリガリ君(ソーダ)',4,'/icecreamSako/gerigerikun.jpg',4,'ロングセラー商品',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(13,'雪見だいふく',2,'/icecreamSako/yukimidaihuku.jpg',5,'冬になったら食べたくなる！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(14,'爽',3,'/icecreamSako/sou.jpg',4,'シャープなキレのあるおいしさ',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(15,'モナ王',2,'/icecreamSako/monaou.jpg',5,'パリッとしてる',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(16,'あいすまんじゅう',1,'/icecreamSako/icemanjyu.jpg',6,'あんこ好きにはたまらない♪',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(17,'SACRE',4,'/icecreamSako/sacre.jpg',7,'夏になったら食べたくなる！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(18,'あずきバー',4,'/icecreamSako/azukibar.jpg',8,'家族みんなだいすき！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(19,'ハーゲンダッツ(ミルク)',1,'/icecreamSako/haagendazs.jpg',9,'頑張った日のご褒美♪',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(20,'ガツンと、みかん',4,'/icecreamSako/mikan.jpg',4,'まるごとみかん！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(21,'coolish',3,'/icecreamSako/coolish.jpg',5,'食べやすい',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(22,'test',1,'/icecreamSako/201904021459217.jpg',1,'test',1,'2019-04-02 14:59:48','2019-04-02 14:59:48');
/*!40000 ALTER TABLE `icecream_main_sako` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idol_main_shintaku`
--

DROP TABLE IF EXISTS `idol_main_shintaku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idol_main_shintaku` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `age` int(2) DEFAULT NULL,
  `type_id` int(10) DEFAULT NULL,
  `unit_id` int(10) DEFAULT NULL,
  `song` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idol_main_shintaku`
--

LOCK TABLES `idol_main_shintaku` WRITE;
/*!40000 ALTER TABLE `idol_main_shintaku` DISABLE KEYS */;
INSERT INTO `idol_main_shintaku` VALUES (1,'双葉杏',17,1,9,'あんずのうた','全人類の推し','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(2,'渋谷凛',15,2,1,'Never say never','絶世の美女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(3,'安部菜々',NULL,1,17,'メルヘンデビュー','永遠の17歳(実年齢は+10歳)','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(4,'一ノ瀬志希',18,1,7,'秘密のトワレ','アヤシイ科学実験が趣味','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(5,'赤城みりあ',11,3,22,'Romantic Now','みりあベンツ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(6,'佐藤心',26,3,17,NULL,'過剰なぶりっ子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(7,'輿水幸子',14,1,NULL,'To my darling...','自信過剰','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(8,'白坂小梅',13,2,NULL,'小さな恋の密室事件','ホラー好きで霊感が強く、色々見える(らしい)','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(9,'有浦柑奈',19,1,NULL,NULL,'ラブ＆ピース','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(10,'並木芽衣子',22,3,NULL,NULL,'帽子好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(11,'西園寺琴歌',17,1,NULL,NULL,'育ちの良いお嬢様','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(12,'大槻唯',17,3,13,'Radio Happy','おちゃらけたりさぼり気味','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(13,'松尾千鶴',15,2,NULL,NULL,'礼儀は正しいものの愛想はまったくない','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(14,'今井加奈',16,1,11,NULL,'ザ・お上りさん','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(15,'小早川紗枝',15,1,5,'花簪HANAKANZASHI','こんちきちん','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(16,'市原仁奈',9,3,22,'みんなのきもち','「〇〇の気持ちになるですよ」が決まり文句','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(17,'小日向美穂',17,1,NULL,'Naked Romance','とても恥ずかしがり屋','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(18,'北条加蓮',16,2,NULL,'薄荷 -ハッカ-','オールドスタイルのキャラクター','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(19,'南条光',14,3,22,NULL,'特撮好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(20,'安斎都',16,1,NULL,NULL,'探偵に憧れている','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(21,'難波笑美',17,3,NULL,NULL,'ステレオタイプの大阪人','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(22,'ヘレン',24,2,NULL,NULL,'自らを世界レベルと称する自信家','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(23,'五十嵐響子',15,1,NULL,'恋のHamburg♪','料理上手','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(24,'佐久間まゆ',16,1,NULL,'エヴリデイドリーム','ヤンデレ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(25,'西島櫂',19,3,NULL,NULL,'水泳に打ち込むスイマー','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(26,'脇山珠美',16,2,2,NULL,'剣道女子高生','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(27,'池袋晶葉',14,1,NULL,NULL,'ロボット製作をする凄腕の技術者','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(28,'野々村そら',15,3,NULL,NULL,'性格はとにかくポジティブで底抜けに明るい','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(29,'榊原里美',17,1,NULL,NULL,'おっとり系のブラコン','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(30,'古澤頼子',17,2,NULL,NULL,'ポーカーフェイス','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(31,'藤原肇',16,2,6,NULL,'祖父譲りの頑固な性格','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(32,'櫻井桃華',12,1,22,'ラヴィアンローズ','他人を顎で使う傲慢なお嬢様','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(33,'浜川愛結奈',22,3,NULL,NULL,'自立心が強い','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(34,'島村卯月',17,1,1,'S(mile)ING！','メインキャラのためいつでもセンター','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(35,'浜口あやめ',15,3,2,NULL,'忍者好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(36,'ライラ',16,2,NULL,NULL,'外国出身アイドルの中でも特に日本語が怪しい','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(37,'藤居朋',19,2,15,NULL,'占い依存症','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(38,'井村雪菜',17,1,15,NULL,'化粧で化けるタイプ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(39,'久川颯',14,2,21,NULL,'熱心にアイドルを目指す快活な性格の自信家','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(40,'上田鈴帆',14,3,NULL,NULL,'芸人にしか見えない','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(41,'緒方智恵理',16,1,9,'風色メロディ','彼女への誹謗中傷は気を付けましょう','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(42,'柊志乃',31,2,NULL,NULL,'ワイン好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(43,'奥山沙織',19,1,NULL,NULL,'田舎臭が漂う風貌','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(44,'ナターリア',14,3,NULL,NULL,'一部のプロデューサーから人気が高い','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(45,'吉岡沙紀',17,2,NULL,NULL,'ストリート系少女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(46,'乙倉悠貴',13,1,NULL,'追い風Running','運動が好きな健康優良児','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(47,'久川凪',14,3,21,NULL,'淡々としていてナレーション気味な口調','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(48,'栗原ネネ',15,1,NULL,NULL,'健康志向が強い悪気のないお節介','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(49,'日野茜',17,3,14,'熱血乙女A','元気っ子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(50,'速水奏',17,2,16,'Hotel Moonside','リーダー的存在','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(51,'日下部若葉',20,1,22,NULL,'20歳に見えない幼児体型','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(52,'工藤忍',16,1,NULL,NULL,'努力のアイドル','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(53,'姫川友紀',20,3,14,'気持ちいいよね 一等賞！','野球娘','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(54,'結城晴',12,2,NULL,NULL,'ボーイッシュ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(55,'服部瞳子',25,2,NULL,NULL,'昔、一度デビューしたことがあるらしい','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(56,'黒崎ちとせ',19,1,20,NULL,'自称・吸血鬼の末裔','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(57,'星輝子',15,3,10,'毒茸伝説','「キノコは親友」と豪語する大のキノコ好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(58,'古賀小春',12,1,22,NULL,'お姫様になりたい女の子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(59,'大和亜季',21,2,NULL,NULL,'アイドル界の自衛官','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(60,'堀裕子',16,3,3,'ミラクルテレパシー','超能力好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(61,'二宮飛鳥',14,2,18,'共鳴世界の存在論','14歳の正真正銘・中二病','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(62,'白菊ほたる',13,1,NULL,'谷の底で咲く花は','不幸体質','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(63,'椎名法子',13,1,11,NULL,'ドーナッツ大好きっ子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(64,'槇原志保',19,3,NULL,NULL,'元ウェイトレス','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(65,'前川みく',15,1,NULL,'おねだり Shall We～？','猫好きで一貫した猫キャラで通している','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(66,'松山久美子',21,3,NULL,NULL,'自分の魅力を引き出すことに熱心','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(67,'瀬名詩織',19,2,NULL,NULL,'不思議な雰囲気を持つ令嬢','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(68,'新田美波',19,2,NULL,'ヴィーナスシンドローム','優等生的キャラクター','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(69,'的場梨沙',12,3,22,NULL,'マセガキ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(70,'水本ゆかり',15,1,11,NULL,'正統派清楚系アイドル','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(71,'西川保奈美',16,2,NULL,NULL,'歌姫になるための意識が高い','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(72,'八神マキノ',18,2,NULL,NULL,'何事にも「論理」を求める性格','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(73,'本田未央',15,3,1,'ミツボシ☆☆★','某界隈から毎週日曜にネタにされている','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(74,'柳瀬美由紀',14,1,22,NULL,'歳不相応に幼い印象','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(75,'真鍋いつき',22,3,NULL,NULL,'汗っかき','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(76,'成宮由愛',13,2,22,NULL,'内気で人見知り','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(77,'三好紗南',14,3,NULL,NULL,'ゲーマー','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(78,'三村かな子',17,1,9,'ショコラ・ティアラ','むちむち','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(79,'東郷あい',23,2,NULL,NULL,'イケメン枠','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(80,'森久保乃々',14,2,10,NULL,'「むーりぃー」が口癖','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(81,'沢田麻理菜',26,3,NULL,NULL,'健康的なナイスバディを持つお姉さん','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(82,'横山千佳',9,1,22,NULL,'魔法少女に憧れている','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(83,'向井拓海',18,3,NULL,NULL,'不良娘','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(84,'橘ありす',12,2,22,'in fact','無愛想がかわいい','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(85,'村上巴',13,3,NULL,'おんなの道は星の道','義理堅い','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(86,'宮本フレデリカ',19,1,7,'き・ま・ぐ・れ Cafe au lait!','変なフランス語を必殺技のように使う','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(87,'多田李衣菜',17,2,8,'Twilight Sky','ロック好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(88,'メアリー・コクラン',11,3,22,NULL,'自信家で背伸びしたがり','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(89,'高峰のあ',24,2,NULL,NULL,'表情に乏しい','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(90,'鷹富士茄子',20,2,NULL,NULL,'ナスじゃないよ、カコだよ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(91,'土屋亜子',15,3,4,NULL,'お金のためにアイドル活動をする銭ゲバ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(92,'棟方愛海',14,1,NULL,NULL,'「やわらかいもの」にただならぬ興味を抱く','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(93,'斉藤洋子',20,3,NULL,NULL,'健康と美肌が自慢の元気っ子キャラ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(94,'望月聖',13,2,NULL,NULL,'聖なる乙女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(95,'高橋礼子',31,2,NULL,NULL,'デレステ最年長の1人','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(96,'財前時子',21,3,NULL,NULL,'女王様タイプのキャラクター','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(97,'冴島清美',15,3,NULL,NULL,'かなりの正義感の強さ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(98,'持田亜里沙',21,1,NULL,NULL,'お姉さんキャラ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(99,'首藤葵',13,3,NULL,NULL,'地元でローカルアイドルをやっていた','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(100,'高垣楓',25,2,16,'こいかぜ','泣きぼくろがチャームポイント','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(101,'砂塚あきら',15,2,NULL,NULL,'ファッションとSNSが趣味の現代っ子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(102,'相馬夏美',25,3,NULL,NULL,'元CA','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(103,'桃井あずき',15,1,NULL,NULL,'セクシーさに自身がある','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(104,'篠原礼',27,2,NULL,NULL,'実は怖がり','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(105,'和久井留美',26,2,NULL,NULL,'秘書をやっていたがヤケになって辞めた','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(106,'片桐早苗',28,3,3,NULL,'前職は警察官の異色アイドル','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(107,'柳清良',23,1,NULL,NULL,'白衣の天使','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(108,'塩見周子',18,2,5,'青の一番星','自由奔放でノリが軽い','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(109,'仙崎恵磨',21,3,NULL,NULL,'パワフルでボーイッシュなキャラ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(110,'遊佐こずえ',11,1,22,NULL,'独特な世界観を持つ少女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(111,'高森藍子',16,3,NULL,'お散歩カメラ','カメラおばさん','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(112,'佐城雪美',10,2,22,NULL,'とても寡黙な少女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(113,'佐々木千枝',11,2,22,NULL,'クール系アイドルでは貴重なロリコンホイホイ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(114,'村松さくら',15,1,4,NULL,'運営から人柱扱いを受けている(らしい)','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(115,'小松伊吹',19,3,NULL,NULL,'ストリート系のギャル','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(116,'三船美優',26,2,NULL,NULL,'デレステの中でも特に落ち着いた大人の女性','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(117,'楊菲菲',15,1,NULL,NULL,'ffdy','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(118,'鷺沢文香',19,2,NULL,'Bright Blue','根暗','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(119,'イヴ・サンタクロース',19,3,NULL,NULL,'謎の存在','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(120,'小室千奈美',19,2,NULL,NULL,'上から目線で高飛車','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(121,'ケイト',20,2,NULL,NULL,'そばかすが特徴的なイギリス人','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(122,'相葉夕美',18,3,NULL,'lilac time','お花畑','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(123,'小関麗奈',13,3,22,NULL,'自称・世界的アイドル(予定)','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(124,'松原早耶',18,1,NULL,NULL,'頑張ることが苦手な女の子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(125,'愛野渚',18,3,NULL,NULL,'バスケ部員','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(126,'福山舞',10,1,22,NULL,'礼儀の正しい優等生','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(127,'藤本里奈',18,1,13,NULL,'自分の頭の悪さを自虐している','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(128,'黒川千秋',20,2,NULL,NULL,'正統派美少女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(129,'木村夏樹',18,3,8,'Rockin\' Emotion','男勝りな口調や態度','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(130,'間中美里',20,1,11,NULL,'掴みどころのない楽天家','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(131,'キャシー・グラハム',15,3,NULL,NULL,'アメリカ出身の外国人','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(132,'水野翠',18,2,NULL,NULL,'弓道少女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(133,'桐生つかさ',18,2,NULL,NULL,'高校生ながらアパレル系の社長の経歴を持つ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(134,'兵頭レナ',27,1,NULL,NULL,'負けず嫌い','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(135,'喜多日菜子',15,3,NULL,NULL,'白馬の王子様が現れるのを妄想している','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(136,'原田美世',20,1,NULL,NULL,'バイクと車が好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(137,'北川真尋',17,3,NULL,NULL,'眼鏡キャラでは初の体育会系','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(138,'桐野アヤ',19,2,NULL,NULL,'男勝りで粗暴','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(139,'喜多見柚',15,3,NULL,NULL,'明るい現代っ子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(140,'江上椿',19,1,NULL,NULL,'写真を撮ることは好きでも撮られるのは嫌い','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(141,'太田優',21,1,NULL,NULL,'歳のわりにお気楽','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(142,'衛藤美紗希',22,3,19,NULL,'元OL','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(143,'大沼くるみ',13,1,22,NULL,'ドジで泣き虫などんくさいタイプ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(144,'木場真奈美',25,2,NULL,NULL,'何でもできるすごい人','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(145,'岸部彩華',19,2,19,NULL,'キャバ嬢のような風貌','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(146,'中野有香',18,1,11,'恋色エナジー','押忍！！！','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(147,'神崎蘭子',14,2,18,'華蕾夢ミル狂詩曲～魂ノ導～','重度の中二病を患っている','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(148,'杉坂海',18,3,15,NULL,'言動がガサツ・男っぽい','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(149,'水木聖來',23,2,NULL,NULL,'犬好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(150,'相原雪乃',22,1,NULL,NULL,'ぽっちゃり','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(151,'城ヶ崎美嘉',17,3,13,'TOKIMEKIエスカレート','カリスマJK','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(152,'川嶋瑞樹',28,2,NULL,NULL,'元・女子アナ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(153,'大西由里子',20,1,NULL,NULL,'ガチ腐女子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(154,'丹羽仁美',18,1,NULL,NULL,'歴女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(155,'諸星きらり',17,3,NULL,'ましゅまろ☆キッス','巨人','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(156,'神谷奈緒',17,2,NULL,'2nd SIDE','正統派ツンデレ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(157,'矢口美羽',14,3,NULL,NULL,'礼儀正しい頑張り屋さん','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(158,'早坂美玲',14,1,10,NULL,'アクの強いファッションで否応なく目につく','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(159,'上条春菜',18,2,12,NULL,'赤メガネ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(160,'夢見りあむ',19,3,NULL,NULL,'ザコメンタル','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(161,'城ヶ崎莉嘉',12,3,NULL,'DOKIDOKIリズム','見た目はギャルでも中身は子供','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(162,'岡崎泰葉',16,2,NULL,NULL,'闇を感じる完璧主義者','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(163,'大石泉',15,2,4,NULL,'IQ150以上と噂されるほど頭脳明晰','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(164,'道明寺歌鈴',17,1,2,NULL,'ドジでノロマな巫女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(165,'梅木音葉',19,2,NULL,NULL,'絶対音感を持つ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(166,'海老原菜帆',17,3,NULL,NULL,'かなり馴れ馴れしい','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(167,'及川雫',16,3,3,NULL,'実家の牧場宣伝のためにアイドルになった','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(168,'氏家むつみ',13,2,NULL,NULL,'文学少女','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(169,'松本沙理奈',22,2,NULL,NULL,'実はグラビアアイドルを目指している','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(170,'赤西瑛梨華',16,1,NULL,NULL,'芸人志向強め','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(171,'浅野風香',16,1,NULL,NULL,'臆病なメガネ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(172,'十時愛梨',18,3,NULL,'アップルパイ・プリンセス','天然ボケ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(173,'伊集院惠',21,2,NULL,NULL,'新しい体験をすることが好きなミーハー','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(174,'辻野あかり',15,1,NULL,NULL,'なんJ民に踊らされた田舎っ子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(175,'依田芳乃',16,3,6,NULL,'純和風女子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(176,'月宮雅',18,1,19,NULL,'甘やかされて育ったママっ子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(177,'松永涼',18,2,NULL,NULL,'サバサバした姉御肌のイケメン女子','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(178,'龍崎薫',9,3,22,NULL,'パッション部門のロリコンホイホイ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(179,'関裕美',14,1,NULL,'楽園','おでこを出した髪型がチャームポイント','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(180,'荒木比奈',20,2,12,NULL,'風貌はいかにも冴えないオタク','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(181,'涼宮星花',19,1,NULL,NULL,'浮世離れで天然ボケなお嬢様','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(182,'若林智香',17,3,NULL,NULL,'チアガール','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(183,'アナスタシア',15,2,NULL,'You\'re star shine on me','日本語は少し苦手','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(184,'綾瀬穂乃香',17,2,NULL,NULL,'気負いすぎる生真面目さん','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(185,'白雪千夜',17,1,20,NULL,'万事に無関心な雰囲気','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(186,'浅利七海',14,2,NULL,NULL,'舌足らずな独特な喋り方が特徴的','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(187,'大原みちる',15,1,NULL,NULL,'無類のパン好き','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(188,'相川千夏',23,2,NULL,NULL,'見た目に反して意外とアクティブ','0','2019-06-10 12:00:00','2019-06-10 12:00:00');
/*!40000 ALTER TABLE `idol_main_shintaku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jojo_appearance_shirasaka`
--

DROP TABLE IF EXISTS `jojo_appearance_shirasaka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jojo_appearance_shirasaka` (
  `appearance_id` int(11) NOT NULL,
  `appearance` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`appearance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jojo_appearance_shirasaka`
--

LOCK TABLES `jojo_appearance_shirasaka` WRITE;
/*!40000 ALTER TABLE `jojo_appearance_shirasaka` DISABLE KEYS */;
INSERT INTO `jojo_appearance_shirasaka` VALUES (0,NULL,NULL,'2019-05-10 10:30:00','2019-05-10 10:30:00'),(1,'第5部','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(2,'第4部','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(3,'第3部','0','2019-05-10 10:30:00','2019-05-10 10:30:00');
/*!40000 ALTER TABLE `jojo_appearance_shirasaka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jojo_main_shirasaka`
--

DROP TABLE IF EXISTS `jojo_main_shirasaka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jojo_main_shirasaka` (
  `stand_id` int(11) NOT NULL,
  `stand_name` varchar(256) DEFAULT NULL,
  `stand_user_name` varchar(256) DEFAULT NULL,
  `sex_id` int(11) DEFAULT NULL,
  `ability` varchar(256) DEFAULT NULL,
  `appearance_id` int(1) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`stand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jojo_main_shirasaka`
--

LOCK TABLES `jojo_main_shirasaka` WRITE;
/*!40000 ALTER TABLE `jojo_main_shirasaka` DISABLE KEYS */;
INSERT INTO `jojo_main_shirasaka` VALUES (1,'ゴールド・エクスペリエンス','ジョルノ・ジョバァーナ',1,'触れた物質に生命を与える。',1,'父親は時間を止められるし、本人は命を操作できるし。まさにチート。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(2,'スティッキー・フィンガー','ブローノ・ブチャラティ',1,'殴った相手にジッパーを取り付ける。',1,'相手をバラバラにしたり、瞬間移動したりできるの便利。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(3,'エアロスミス','ナランチャ・ギルガ',1,'二酸化炭素排出量から敵の位置を特定し、戦闘機で攻撃する。',1,'物語の中で割とキーパーソンのような立ち位置にいます。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(4,'ムーディ・ブルース','レオーネ・アバッキオ',1,'人やスタンドの過去をリプレイできる。',1,'この能力を持っているのがアバッキオでよかったと思えます。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(5,'セックス・ピストルズ','グイード・ミスタ',1,'6体で協力して弾丸を操作する。',1,'一見強そうですが、日本では銃が使えないので国外のみ有効です。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(6,'スパイス・ガール','トリッシュ・ウナ',2,'どんな物質も柔らかく出来る。',1,'能力はさておき、スタンド自信に自我があるっていう激熱展開が好きです。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(7,'パープル・ヘイズ','パンナコッタ・フーゴ',1,'両拳のカプセルに仕込まれた殺人ウイルスで攻撃する。',1,'フーッ、フーッてスタンドが狂気じみている感じが好きです。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(8,'キング・クリムゾン','ディアボロ',1,'時間を消し去ることが出来る。また未来を予知する「エピタフ」の能力も備わっている。',1,'あー、また時間系の能力ね。強い強い。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(9,'クレイジー・ダイヤモンド','東方仗助',1,'高速パンチが打てるスタンドで、壊れた物をもとの形に戻すことが出来る。',2,'世界一やさしい能力と言われていました。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(10,'ザ・ハンド','虹村億泰',1,'右手でつかんだものを空間ごと削り取れる。',2,'いや、強すぎでしょ。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(11,'エコーズ','広瀬康一',1,'ACT1～ACT３と姿を変え、それぞれで能力が異なる。最終形態ACT３では殴った物体を重くできる。',2,'第5部でも少し登場したほど、人気のキャラ。僕も好き。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(12,'ヘブンズ・ドアー','岸部露伴',1,'自信の書いた絵を相手に見せることで、相手を本にすることが出来る。本にされた相手には性格などの情報が記載されていて、文章を書き込めばその通りに行動させることが出来る。',2,'有名な「だが断る」の人。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(13,'アース・ウィンド・アンド・ファイヤー','ヌ・ミキタカゾ・ンシ',3,'自分の力以上のものや複雑な機械などを除いて、なんにでも返信できる。',2,'宇宙人かもしれないしそうじゃないかもしれない人。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(14,'ハイウェイ・スター','噴上裕也',1,'部屋を作り出し、そこに入り込んだ人のにおいを覚えて追跡する能力。追い付かれた者は、体内に侵入され養分を吸い取られる。',2,'岸部露伴に「だが断る」を言わせた人。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(15,'キラー・クイーン','吉良吉影',1,'触れた物を爆弾に変える能力。スイッチを使った起爆型にもできる。',2,'言葉の言い回しで謎にブチ切れるという謎個性が好きです。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(16,'スター・プラチナ','空条承太郎',1,'けた外れのスピードとパワー、正確性を持つスタンド。途中から時も止められるようになった。',3,'有名な「オラオラオラァ」の連呼の人。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(17,'ハーミット・パープル','ジョセフ・ジョースター',1,'念写を行うことが出来る。戦闘向きではない。',3,'第2部から続投。承太郎のおじいちゃんで、東方仗助のパパ','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(18,'マジシャンズ・レッド','モハメド・アヴドゥル',1,'鉄さえも溶かせる灼熱の炎を操れる。',3,'マジで最強だと思ったスタンド。トリッシュのスタンドを目覚めさせてくれてありがとう。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(19,'ハイエロファント・グリーン','花京院典明',1,'人型のスタンドで、ひも状に姿を変えることが出来る。',3,'「レロレロレロ」といってサクランボをなめるシーンは有名。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(20,'シルバー・チャリオッツ','ジャン＝ピエール・ポルナレフ',1,'切れ味の鋭いレイピアを操る中世騎士のようなスタンド。',3,'第5部にも少し登場します。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(21,'ザ・フール','イギー',3,'砂を操ることが出来るスタンド。',3,'生意気なくそ犬だったのに、なぜか最後はすごく悲しい。','0','2019-05-10 10:30:00','2019-05-10 10:30:00'),(22,'ザ・ワールド','DIO',1,'高いスピードと高いパワーを持ち、9秒間時間を止めることもできる。',3,'初代チートキャラ。その後のストーリーにも大きな影響を与えます。','0','2019-05-10 10:30:00','2019-05-10 10:30:00');
/*!40000 ALTER TABLE `jojo_main_shirasaka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jojo_sex_shirasaka`
--

DROP TABLE IF EXISTS `jojo_sex_shirasaka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jojo_sex_shirasaka` (
  `sex_id` int(11) NOT NULL,
  `sex` varchar(256) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`sex_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jojo_sex_shirasaka`
--

LOCK TABLES `jojo_sex_shirasaka` WRITE;
/*!40000 ALTER TABLE `jojo_sex_shirasaka` DISABLE KEYS */;
INSERT INTO `jojo_sex_shirasaka` VALUES (0,NULL,NULL,'2019-05-10 10:30:00','2019-05-10 10:30:00'),(1,'男性',0,'2019-05-10 10:30:00','2019-05-10 10:30:00'),(2,'女性',0,'2019-05-10 10:30:00','2019-05-10 10:30:00'),(3,'不明',0,'2019-05-10 10:30:00','2019-05-10 10:30:00');
/*!40000 ALTER TABLE `jojo_sex_shirasaka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kyary_main_sahota`
--

DROP TABLE IF EXISTS `kyary_main_sahota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kyary_main_sahota` (
  `NO` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `song_title` varchar(256) DEFAULT NULL,
  `name_id` int(11) DEFAULT NULL,
  `type_id` int(4) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `song_time` varchar(5) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kyary_main_sahota`
--

LOCK TABLES `kyary_main_sahota` WRITE;
/*!40000 ALTER TABLE `kyary_main_sahota` DISABLE KEYS */;
INSERT INTO `kyary_main_sahota` VALUES (1,1,'きゃりーのマーチ',1,1,2011,'1:07','導入歌','0','2019-06-11 12:00:00','2019-06-20 11:21:55'),(2,2,'チェリーボンボン',1,1,2011,'3:38','海外で人気がある','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(3,3,'PONPONPON',1,1,2011,'4:02','デビュー曲','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(4,4,'ちょうどいいの',1,1,2011,'3:19','ヒミツのアイテム','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(5,5,'ピンポンがなんない',1,1,2011,'4:44','シチュー','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(6,6,'jelly',1,1,2011,'4:32','CAPSULEのカバー','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(7,7,'PONPONPON extended',1,1,2011,'6:01','デビュー曲','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(8,8,'ぱみゅぱみゅレボリューション',2,1,2012,'1:00','導入歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(9,9,'つけまつける',2,1,2012,'4:21','豆しぱみゅぱみゅCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(10,10,'PONPONPON',2,1,2012,'4:02','バンタンCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(11,11,'みんなのうた',2,1,2012,'5:03','手を上げる','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(12,12,'きゃりーANAN',2,1,2012,'3:18','求人情報サービス「an」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(13,13,'CANDY CANDY',2,1,2012,'3:51','グリコ「BREO」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(14,14,'Drinker',2,1,2012,'4:17','お酒','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(15,15,'おねだり44℃',2,1,2012,'3:39','ケンタッキー「クラッシャーズ」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(16,16,'スキすぎてキレそう',2,1,2012,'5:19','キレそう','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(17,17,'ぎりぎりセーフ',2,1,2012,'3:13','間に合った','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(18,18,'おやすみ',2,1,2012,'4:42','おやすみ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(19,19,'ちゃんちゃかちゃんちゃん',2,1,2012,'4:46','初期ライブのアンコール曲','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(20,20,'なんだこれくしょん',3,1,2013,'0:47','導入歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(21,21,'にんじゃりばんばん',3,1,2013,'4:26','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(22,22,'きみのみかた',22,3,2019,'3:04','「クオリティーファースト」CMソング','0','2019-06-19 15:34:22','2019-06-11 12:00:00'),(23,23,'きみがいいねくれたら',23,3,2019,'3:43','テレビドラマ「向かいのバズる家族」主題歌','0','2019-06-19 15:21:22','2019-06-11 12:00:00'),(24,24,'インベーダーインベーダー',3,1,2013,'4:11','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(25,25,'み',3,1,2013,'4:11','グリコ「アイスの実」キャンペーンソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(26,26,'ファッションモンスター',3,1,2013,'4:37','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(27,27,'さいごのアイスクリーム',3,1,2013,'4:10','いちご味','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(28,28,'のりことのりお',3,1,2013,'3:17','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(29,29,'ふりそでーしょん',3,1,2013,'4:05','はたち','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(30,30,'くらくら',3,1,2013,'2:49','ケンタッキー「クラッシャーズ」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(31,31,'おとななこども',3,1,2013,'5:31','「SUZUKI MRワゴン」 CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(32,32,'ピカピカふぁんたじん',4,1,2014,'1:12','導入歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(33,33,'きらきらキラー',4,1,2014,'4:16','L.U.C.K','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(34,34,'ゆめのはじまりんりん-album mix-',4,1,2014,'4:04','CHINTAI CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(35,35,'もったいないとらんど',4,1,2014,'4:01','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(36,36,'シリアスひとみ',4,1,2014,'5:18','ひとみシリアス','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(37,37,'do do pi do',4,1,2014,'4:39','CAPSULEのカバー','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(38,38,'ファミリーパーティー -album mix-',4,1,2014,'3:39','『映画クレヨンしんちゃん　ガチンコ！逆襲のロボとーちゃん』主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(39,39,'Ring a Bell',4,1,2014,'4:09','英語','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(40,40,'トーキョーハイウェイ',4,1,2014,'5:09','サイバーナビPV','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(41,41,'こいこいこい',4,1,2014,'3:17','グリコ「アイスの実」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(42,42,'すんごいオーラ -album mix-',4,1,2014,'3:40','「サンスターOra2」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(43,43,'エクスプローラー',4,1,2014,'4:03','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(44,44,'ピカピカふぁんたミックス',4,1,2014,'1:18','itunes store限定','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(45,45,'KPP ON STAGE',5,1,2016,'0:55','導入歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(46,46,'PONPONPON',5,1,2016,'4:02','バンタンCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(47,47,'チェリーボンボン',5,1,2016,'3:38','海外で人気がある','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(48,48,'つけまつける',5,1,2016,'4:21','つけまつげ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(49,49,'きゃりーANAN',5,1,2016,'3:18','求人情報サービス「an」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(50,50,'CANDY CANDY',5,1,2016,'3:51','グリコ「BREO」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(51,51,'ファッションモンスター',5,1,2016,'4:37','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(52,52,'キミに100パーセント',5,1,2016,'3:20','「クレヨンしんちゃん」オープニングテーマ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(53,53,'ふりそでーしょん',5,1,2016,'4:05','はたち','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(54,54,'ファミリーパーティー -album mix-',5,1,2016,'3:39','『映画クレヨンしんちゃん　ガチンコ！逆襲のロボとーちゃん』主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(55,55,'Super Scooter Happy',5,1,2016,'5:54','トマト達','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(56,56,'ゆめのはじまりんりん-album mix-',5,1,2016,'4:04','CHINTAI CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(57,57,'にんじゃりばんばん',5,1,2016,'4:26','にんじゃ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(58,58,'もったいないとらんど',5,1,2016,'4:01','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(59,59,'5iVE YEARS MONSTER',5,1,2016,'2:53','5周年記念','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(60,60,'きらきらキラー',5,1,2016,'4:16','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(61,61,'インベーダーインベーダー',5,1,2016,'4:11','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(62,62,'完全形態',5,1,2016,'3:39','「AQUOS　４K」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(63,63,'トーキョーハイウェイ',5,1,2016,'5:09','サイバーナビPV','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(64,64,'Crazy Party Night ～ぱんぷきんの逆襲～',5,1,2016,'4:14','コカコーラCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(65,65,'No No No',5,1,2016,'4:08','グリコ「アイスの実」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(66,66,'もんだいガール',5,1,2016,'4:36','ドラマ「問題のあるレストラン」主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(67,67,'コスメティックコースター',5,1,2016,'3:25','USJ KPP XR ride','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(68,68,'最＆高',5,1,2016,'3:32','b','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(69,69,'バーチャルぱみゅぱみゅ',6,1,2018,'1:40','導入歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(70,70,'キズナミ',6,1,2018,'3:48','映画「モンスターストライク THE MOVIE ソラノカナタ」主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(71,71,'原宿いやほい',6,1,2018,'3:41','原宿','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(72,72,'音ノ国',6,1,2018,'4:03','奏で','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(73,73,'きみのみかた',6,1,2018,'3:04','「クオリティーファースト」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(74,74,'ちゃみ ちゃみ ちゃーみん',6,1,2018,'4:36','ちゃみ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(75,75,'演歌ナトリウム',6,1,2018,'2:49','さいさい','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(76,76,'恋ノ花',6,1,2018,'4:39','CAPSULEのカバー','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(77,77,'とどけぱんち',6,1,2018,'2:58','グリコ「アイスの実」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(78,78,'最＆高(Japamyu Edit)',6,1,2018,'4:33','b','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(79,79,'つけまつける',7,2,2012,'4:21','つけまつげ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(80,80,'きゃりーANAN',7,2,2012,'3:18','求人情報サービス「an」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(81,81,'チェリーボンボン extended mix',7,2,2012,'5:02','海外で人気がある','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(82,82,'CANDY CANDY',8,2,2012,'3:51','グリコ「BREO」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(83,83,'でもでもまだまだ',8,2,2012,'4:12','有馬記念予告動画','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(84,84,'ちょうどいいの Extended Mix',8,2,2012,'4:24','ヒミツのアイテム','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(85,85,'ファッションモンスター',9,2,2012,'4:37','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(86,86,'100%のじぶんに',9,2,2012,'3:27','「SUZUKI MRワゴン」 CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(87,87,'つけまつける-extended mix-',9,2,2012,'4:56','つけまつげ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(88,88,'キミに100パーセント',10,2,2013,'3:20','「クレヨンしんちゃん」オープニングテーマ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(89,89,'ふりそでーしょん',10,2,2013,'4:05','はたち','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(90,90,'CANDY CANDY(Etended Mix)',10,2,2013,'5:16','グリコ「BREO」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(91,91,'にんじゃりばんばん',11,2,2013,'4:26','にんじゃ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(92,92,'Unite Unite',11,2,2013,'3:13','ファンに人気','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(93,93,'みんなのうた-extended mix-',11,2,2013,'5:47','手を上げる','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(94,94,'インベーダーインベーダー',12,2,2013,'4:11','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(95,95,'Point of view',12,2,2013,'3:35','「アゲるテレビ」オープニングテーマ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(96,96,'ファッションモンスター',12,2,2013,'4:55','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(97,97,'もったいないとらんど',13,2,2013,'4:01','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(98,98,'すんごいオーラ',13,2,2013,'2:56','「サンスターOra2」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(99,99,'にんじゃりばんばん -extended mix-',13,2,2013,'5:43','にんじゃ','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(100,100,'もったいないとらんど -instrumental-',13,2,2013,'4:01','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(101,101,'すんごいオーラ -instrumental-',13,2,2013,'2:56','「サンスターOra2」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(102,102,'ゆめのはじまりんりん',14,2,2014,'3:21','CHINTAI CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(103,103,'スローモ',14,2,2014,'3:33','「ALOOK」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(104,104,'もったいないとらんど -extended mix-',14,2,2014,'4:50','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(105,105,'ゆめのはじまりんりん -instrumental-',14,2,2014,'3:21','CHINTAI CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(106,106,'スローモ -instrumental-',14,2,2014,'3:34','「ALOOK」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(107,107,'ファミリーパーティー',15,2,2014,'3:35','『映画クレヨンしんちゃん　ガチンコ！逆襲のロボとーちゃん』主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(108,108,'Scanty Skimpy',15,2,2014,'3:38','聞いたことない','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(109,109,'インベーダーインベーダー -extended mix-',15,2,2014,'5:28','ジ―ユーCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(110,110,'ファミリーパーティー -instrumental-',15,2,2014,'3:36','『映画クレヨンしんちゃん　ガチンコ！逆襲のロボとーちゃん』主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(111,111,'Scanty Skimpy -instrumental-',15,2,2014,'3:38','聞いたことない','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(112,112,'きらきらキラー',16,2,2014,'4:16','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(113,113,'きらきらキラー -extended mix-',16,2,2014,'5:11','au TVCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(114,114,'もんだいガール',17,2,2015,'4:36','ドラマ「問題のあるレストラン」主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(115,115,'KISEKAE',17,2,2015,'4:06','ニンテンドー３DS　CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(116,116,'MY ROOM',17,2,2015,'4:34','CHINTAI CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(117,117,'CANDY CANDY -remix-',17,2,2015,'4:31','グリコ「BREO」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(118,118,'もんだいガール -instrumental-',17,2,2015,'4:36','ドラマ「問題のあるレストラン」主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(119,119,'KISEKAE -instrumental-',17,2,2015,'4:06','ニンテンドー３DS　CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(120,120,'MY ROOM -instrumental-',17,2,2015,'4:34','CHINTAI CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(121,121,'Crazy Party Night ～ぱんぷきんの逆襲～',18,2,2015,'4:14','コカコーラCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(122,122,'No No No',18,2,2015,'4:08','グリコ「アイスの実」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(123,123,'おしえてダンスフロア',18,2,2015,'3:05','SHARP AQUOS 4K CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(124,124,'きまま',18,2,2015,'3:15','「とびだせどうぶつの森」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(125,125,'Crazy Party Night ～ぱんぷきんの逆襲～ -instrumental-',18,2,2015,'4:14','コカコーラCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(126,126,'No No No -instrumental-',18,2,2015,'4:08','グリコ「アイスの実」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(127,127,'おしえてダンスフロア -instrumental-',18,2,2015,'3:05','SHARP AQUOS 4K CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(128,128,'きまま -instrumental-',18,2,2015,'3:15','「とびだせどうぶつの森」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(129,129,'最&高',19,2,2016,'3:32','b','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(130,130,'コスメティックコースター',19,2,2016,'3:25','USJ KPP XR ride','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(131,131,'もんだいガール -extended mix-',19,2,2016,'5:29','ドラマ「問題のあるレストラン」主題歌','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(132,132,'最&高 -instrumental-',19,2,2016,'3:32','b','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(133,133,'コスメティックコースター instrumental-',19,2,2016,'3:25','USJ KPP XR ride','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(134,134,'Crazy Crazy',20,2,2017,'3:46','feat.Charli XCX','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(135,135,'Crazy Crazy -remix-',20,2,2017,'4:43','feat.Charli XCX','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(136,136,'原宿いやほい',20,2,2017,'3:41','原宿','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(137,137,'原宿いやほい -extended mix-',20,2,2017,'5:38','原宿','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(138,138,'良すた',21,2,2017,'2:58','イオンイースターキャンペーンCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(139,139,'とどけぱんち',21,2,2017,'2:56','グリコ「アイスの実」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(140,140,'最&高 -extended mix-',21,2,2017,'4:24','b','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(141,141,'良すた -instrumental-',21,2,2017,'2:58','イオンイースターキャンペーンCMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(142,142,'とどけぱんち -instrumental-',21,2,2017,'2:56','グリコ「アイスの実」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(143,143,'きみのみかた',22,3,2018,'3:04','「クオリティーファースト」CMソング','0','2019-06-11 12:00:00','2019-06-11 12:00:00'),(NULL,160,'あああ',0,0,NULL,NULL,'','0','2019-06-19 16:03:01',NULL),(NULL,161,'かか',0,2,NULL,'','','0','2019-06-19 16:25:57','2019-06-19 16:50:44'),(NULL,162,'pp',0,0,NULL,NULL,'','0','2019-06-19 16:55:57','2019-06-19 16:55:57');
/*!40000 ALTER TABLE `kyary_main_sahota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `league_uezu`
--

DROP TABLE IF EXISTS `league_uezu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `league_uezu` (
  `id` int(11) NOT NULL,
  `league` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `league_uezu`
--

LOCK TABLES `league_uezu` WRITE;
/*!40000 ALTER TABLE `league_uezu` DISABLE KEYS */;
INSERT INTO `league_uezu` VALUES (0,NULL,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(1,'アメリカンリーグ','0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(2,'ナショナルリーグ','0','2019-05-21 00:00:00','2019-05-21 00:00:00');
/*!40000 ALTER TABLE `league_uezu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `live_main_kawada`
--

DROP TABLE IF EXISTS `live_main_kawada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `live_main_kawada` (
  `id` int(11) NOT NULL,
  `album_id` int(11) NOT NULL,
  `song_title` varchar(256) NOT NULL,
  `percent` int(3) DEFAULT NULL,
  `style_id` int(11) NOT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `live_main_kawada`
--

LOCK TABLES `live_main_kawada` WRITE;
/*!40000 ALTER TABLE `live_main_kawada` DISABLE KEYS */;
INSERT INTO `live_main_kawada` VALUES (1,3,'monolith',97,1,'曲中、歌詞の一部をライブ会場名に変えて観客を盛り上げる','0','2019-12-04 14:09:00','2019-12-11 16:58:18'),(2,1,'fiction',93,2,'イントロ流れ出した瞬間にサークルが無数に出来上がる','0','2019-12-04 14:09:00','2019-12-11 17:08:53'),(3,1,'swim',76,2,'Aメロは平泳ぎ、Bメロでクロールのモーションをしがち','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(4,3,'midnight crusing',67,2,'ライブ会場に星が降って降ってつもります','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(5,5,'Squll',54,2,'悩みがある時にMCを聞くと泣ける','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(6,2,'Warp',52,2,'みんな楽しそうにサークル作り出す','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(7,4,'Remember',51,1,'最後によくやる曲、左回り','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(8,3,'Chicken race',45,4,'RYU-TAのMCで曲に入る、','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(9,1,'Terminal',44,2,'最近あまりやらなくなってきた','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(10,6,'escape',44,2,'モッシュ激しめ','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(11,2,'climb',39,2,'イントロでサークル出来がち、モッシュ定番','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(12,2,'Latter',34,5,'激しさ薄め、比較的落ち着いて聴ける','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(13,2,'mahoroba',33,2,'イントロがかっこいい','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(14,5,'My HERO',33,1,'サビ左回り、終盤GENのラップ','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(15,5,'message',28,5,'比較的序盤に演奏する曲','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(16,2,'Feel',28,2,'MCからの演奏が多い','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(17,5,'kitchen',26,4,'最近chicken raceに変わって歌われることが多い','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(18,5,'Alien',25,2,'照明が赤基準だと尚かっこよさが目立つ','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(19,1,'me?',23,5,'激しさ薄め','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(20,2,'drops',23,4,'ポップな曲調','0','2019-12-04 14:09:00','2019-12-04 14:09:00'),(21,1,'Buster call',22,1,'GENの歌い出しからの切り替わりサビ演奏でテンションが上がる','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(22,4,'nem…',22,2,'zzz','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(23,4,'hello',22,5,'地蔵で聞いていたくなる','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(24,1,'knife',21,2,'即モッシュ','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(25,2,'Horizon',22,3,'珍しい曲調、静かに聞いていたい。','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(26,2,'Night on',20,2,'RYU-TAの歌声も聴ける','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(27,7,'labyrinth',17,2,'比較的ライブではやらない','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(28,5,'Now here,Nowhere',15,2,'歌詞内言葉遊びが可愛い','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(29,1,'medley',15,4,'ドラムがかっこいい','0','2019-12-04 17:25:00','2019-12-04 17:25:00'),(30,6,'Galapagos',15,1,'ダサさがかっこいい','0','2019-12-04 17:25:00','2019-12-04 17:25:00');
/*!40000 ALTER TABLE `live_main_kawada` ENABLE KEYS */;
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
INSERT INTO `location_kataoka` VALUES (0,'','0','2018-09-26 23:49:26','2018-09-17 06:00:00'),(1,'北海道','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(2,'青森県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(3,'岩手県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(4,'宮城県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(5,'秋田県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(6,'山形県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(7,'福島県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(8,'茨城県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(9,'栃木県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(10,'群馬県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(11,'埼玉県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(12,'千葉県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(13,'東京都','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(14,'神奈川県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(15,'新潟県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(16,'富山県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(17,'石川県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(18,'福井県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(19,'山梨県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(20,'長野県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(21,'岐阜県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(22,'静岡県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(23,'愛知県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(24,'三重県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(25,'滋賀県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(26,'京都府','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(27,'大阪府','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(28,'兵庫県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(29,'奈良県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(30,'和歌山県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(31,'鳥取県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(32,'島根県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(33,'岡山県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(34,'広島県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(35,'山口県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(36,'徳島県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(37,'香川県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(38,'愛媛県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(39,'高知県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(40,'福岡県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(41,'佐賀県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(42,'長崎県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(43,'熊本県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(44,'大分県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(45,'宮崎県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(46,'鹿児島県','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(47,'沖縄県','0','2018-09-17 06:00:00','2018-09-17 06:00:00');
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
INSERT INTO `location_takehara` VALUES (0,'','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(1,'城東','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'城西','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'城南','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'城北','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'分類無し','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
/*!40000 ALTER TABLE `location_takehara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `made_country_kambara`
--

DROP TABLE IF EXISTS `made_country_kambara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `made_country_kambara` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `made_country_kambara`
--

LOCK TABLES `made_country_kambara` WRITE;
/*!40000 ALTER TABLE `made_country_kambara` DISABLE KEYS */;
INSERT INTO `made_country_kambara` VALUES (0,NULL,'0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(1,'日本','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(2,'アメリカ','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(3,'フランス','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(4,'イタリア','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(5,'スウェーデン','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(6,'ドイツ','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(7,'ベトナム','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(8,'スペイン','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(9,'イギリス','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(10,'ベルギー','0','2019-09-18 00:00:00','2019-09-18 00:00:00');
/*!40000 ALTER TABLE `made_country_kambara` ENABLE KEYS */;
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
-- Table structure for table `maker_sako`
--

DROP TABLE IF EXISTS `maker_sako`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maker_sako` (
  `maker_id` int(11) DEFAULT NULL,
  `maker` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maker_sako`
--

LOCK TABLES `maker_sako` WRITE;
/*!40000 ALTER TABLE `maker_sako` DISABLE KEYS */;
INSERT INTO `maker_sako` VALUES (1,'森永製菓',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(2,'glico',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(3,'meiji',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(4,'AKAGI',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(5,'LOTTE',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(6,'丸永製菓',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(7,'FUTABA',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(8,'井村屋',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(9,'ハーゲンダッツ',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(0,'',0,'2018-10-19 00:00:00','2018-10-19 00:00:00');
/*!40000 ALTER TABLE `maker_sako` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mcu_main_hayashi`
--

DROP TABLE IF EXISTS `mcu_main_hayashi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mcu_main_hayashi` (
  `id` int(11) NOT NULL,
  `character_name` varchar(256) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `sex_id` int(11) DEFAULT NULL,
  `appearance_year` int(4) NOT NULL,
  `appearance_time` int(3) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mcu_main_hayashi`
--

LOCK TABLES `mcu_main_hayashi` WRITE;
/*!40000 ALTER TABLE `mcu_main_hayashi` DISABLE KEYS */;
INSERT INTO `mcu_main_hayashi` VALUES (1,'アイアンマン',1,1,2008,9,'地球を救った偉大なIT野郎','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(2,'キャプテン・アメリカ',1,1,2011,8,'ムジョルニアを持てる正義の堅物','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(3,'スパイダーマン',1,1,2016,4,'トニーの弟子、NEXTアイアンマン','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(4,'ソー',7,1,2011,7,'最高にクールバカな神様','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(5,'ハルク',1,1,2008,6,'昔は暴れん坊','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(6,'ブラック・ウィドウ',1,2,2010,7,'ラックスの人','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(7,'ドクター・ストレンジ',1,1,2016,4,'高慢な魔法使い','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(8,'スター・ロード',8,1,2014,4,'おまぬけダンサー賞金稼ぎ','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(9,'グルート',5,3,2014,4,'可愛い木','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(10,'ロケット',4,1,0,4,'最高なアライグマ','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(11,'ガモーラ',6,2,2014,4,'気高い戦士で優しい姉','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(12,'ドラックス',6,1,2014,4,'頭が足りないお父さん','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(13,'マンティス',6,2,2017,3,'天然を超えた天然','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(14,'ネビュラ',6,2,2014,4,'素直になれない妹','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(15,'ブラックパンサー',1,1,2016,4,'ワカンダフォーエバー','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(16,'シュリ',1,2,2018,2,'ワカンダ産のIT娘','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(17,'ウィンター・ソルジャー',1,1,2014,6,'アダマンチウムの左腕','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(18,'スカーレット・ウィッチ',1,2,2015,4,'マジで美人','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(19,'ファルコン',1,1,2014,5,'羽が印象的なNEXTキャプテン','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(20,'サノス',6,1,2014,6,'曲がった正義の悪い奴','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(21,'オコエ',1,2,2018,2,'忠実なワカンダの女戦士','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(22,'ウォ―マシン',1,1,2010,6,'アイアンマン風なやつ','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(23,'ヴィジョン',2,3,2015,7,'ジャービスマン','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(24,'ロキ',7,1,2012,6,'憎めない嘘つき','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(25,'ウォン',1,1,2016,3,'可愛い中国系魔法使い','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(26,'アントマン',1,1,2015,5,'子供思いのおっちょこちょいパパ','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(27,'ワスプ',1,2,2018,2,'キャリアウーマン','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(28,'ハンク・ピム',1,1,2015,3,'ピム粒子の開発者、強情おじさん','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(29,'ジャネット',1,2,2018,2,'ハンクの嫁、元ワスプ','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(30,'ゴースト',1,2,2018,1,'体がおかしくなってしまった人','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(31,'ビル・フォスター',1,1,2018,1,'ゴーストを手伝うおじさん','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(32,'キャシー',1,2,2015,3,'アントマンの子供、かわいい','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(33,'ルイス',1,1,2015,2,'アントマンの友達、話が長い','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(34,'マギー',1,2,2015,2,'アントマンの元嫁','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(35,'キャプテン・マーベル',1,2,2019,2,'最後に出てきた最強','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(36,'グース',6,3,2019,1,'ネコよりのクラーケン','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(37,'ロナン',6,1,2014,2,'復習に燃えるクリー人','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(38,'カエシリウス',1,1,2016,1,'ヴォルデモート','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(39,'エンシェント・ワン',1,2,2016,2,'優しき魔法使いの偉大なる母','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(40,'キルモンガー',1,1,2018,1,'復習にとりつかれたワカンダ人','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(41,'ヴァルキリー',7,2,2017,3,'故郷を捨てた女戦士','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(42,'ヘイムダル',7,1,2011,3,'アスガルドの門番','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(43,'ヘラ',7,2,2017,1,'死の神、ムジョルニアを壊した','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(44,'オーディン',7,1,2011,3,'ロキ、ソーのパパ','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(45,'ホーガン',7,1,2011,2,'浅野忠信が演じたアスガルド人','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(46,'コーグ',6,1,2017,2,'劇中でfortniteしてたね','0','2019-05-29 12:00:00','2019-05-29 12:00:00');
/*!40000 ALTER TABLE `mcu_main_hayashi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_sasaki`
--

DROP TABLE IF EXISTS `member_sasaki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_sasaki` (
  `id` int(2) NOT NULL,
  `member` varchar(2) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_sasaki`
--

LOCK TABLES `member_sasaki` WRITE;
/*!40000 ALTER TABLE `member_sasaki` DISABLE KEYS */;
INSERT INTO `member_sasaki` VALUES (0,' ','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'1','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'2','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'3','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'4','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'5','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `member_sasaki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mlb_main_uezu`
--

DROP TABLE IF EXISTS `mlb_main_uezu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mlb_main_uezu` (
  `id` int(11) NOT NULL,
  `team_name` varchar(256) NOT NULL,
  `founding_year` int(4) DEFAULT NULL,
  `membership_year` int(4) DEFAULT NULL,
  `headquarters` varchar(256) NOT NULL,
  `league_id` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mlb_main_uezu`
--

LOCK TABLES `mlb_main_uezu` WRITE;
/*!40000 ALTER TABLE `mlb_main_uezu` DISABLE KEYS */;
INSERT INTO `mlb_main_uezu` VALUES (1,'Baltimore Orioles (BAL)/ボルチモア・オリオールズ',1894,1901,'メリーランド州ボルチモア/オリオールパーク・アット・カムデンヤーズ',1,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(2,'Boston Red Sox (BOS)/ボストン・レッドソックス',1901,1901,'マサチューセッツ州ボストン/フェンウェイ・パーク',1,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(3,'New York Yankees (NYY)/ニューヨーク・ヤンキース',1901,1901,'ニューヨーク州ニューヨーク・ブロンクス/ヤンキー・スタジアム',1,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(4,'Tampa Bay Rays (TB)/タンパベイ・レイズ',1998,1998,'フロリダ州セントピーターズバーグ/トロピカーナ・フィールド',1,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(5,'Toronto Blue Jays (TOR)/トロント・ブルージェイズ',1977,1977,'オンタリオ州トロント/ロジャーズ・センター',1,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(6,'Chicago White Sox (CWS)/シカゴ・ホワイトソックス',1894,1901,'イリノイ州シカゴ/ギャランティード・レート・フィールド',1,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(7,'Cleveland Indians (CLE)/クリーブランド・インディアンズ',1894,1901,'オハイオ州クリーブランド/プログレッシブ・フィールド',1,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(8,'Detroit Tigers (DET)/デトロイト・タイガース',1894,1901,'ミシガン州デトロイト/コメリカ・パーク',1,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(9,'Kansas City Royals (KC)/カンザスシティ・ロイヤルズ',1969,1969,'ミズーリ州カンザスシティ/カウフマン・スタジアム',1,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(10,'Minnesota Twins (MIN)/ミネソタ・ツインズ',1894,1901,'ミネソタ州ミネアポリス/ターゲット・フィールド',1,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(11,'Houston Astros (HOU)/ヒューストン・アストロズ',1962,2013,'テキサス州ヒューストン/ミニッツメイド・パーク',1,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(12,'Los Angeles Angels of Anaheim (LAA)/ロサンゼルス・エンゼルス・オブ・アナハイム',1961,1961,'カリフォルニア州アナハイム/エンゼル・スタジアム・オブ・アナハイム',1,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(13,'Oakland Athletics (OAK)/オークランド・アスレチックス',1901,1901,'カリフォルニア州オークランド/オークランド・アラメダ・カウンティ・コロシアム',1,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(14,'Seattle Mariners (SEA)/シアトル・マリナーズ',1977,1977,'ワシントン州シアトル/T-モバイル・パーク',1,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(15,'Texas Rangers (TEX)/テキサス・レンジャーズ',1961,1961,'テキサス州アーリントン/グローブライフ・パーク・イン・アーリントン',1,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(16,'Atlanta Braves (ATL)/アトランタ・ブレーブス',1871,1876,'ジョージア州カンバーランド/サントラスト・パーク',2,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(17,'Miami Marlins (MIA)/マイアミ・マーリンズ',1993,1993,'フロリダ州マイアミ/マーリンズ・パーク',2,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(18,'New York Mets (NYM)/ニューヨーク・メッツ',1962,1962,'ニューヨーク州ニューヨーク・クイーンズ/シティ・フィールド',2,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(19,'Philadelphia Phillies (PHI)/フィラデルフィア・フィリーズ',1883,1883,'ペンシルベニア州フィラデルフィア/シチズンズ・バンク・パーク',2,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(20,'Washington Nationals (WSH)/ワシントン・ナショナルズ',1969,1969,'ワシントンD.C./ナショナルズ・パーク',2,1,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(21,'Chicago Cubs (CHC)/シカゴ・カブス',1870,1876,'イリノイ州シカゴ/リグレー・フィールド',2,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(22,'Cincinnati Reds (CIN)/シンシナティ・レッズ',1882,1890,'オハイオ州シンシナティ/グレート・アメリカン・ボール・パーク',2,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(23,'Milwaukee Brewers (MIL)/ミルウォーキー・ブルワーズ',1969,1998,'ウィスコンシン州ミルウォーキー/ミラー・パーク',2,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(24,'Pittsburgh Pirates (PIT)/ピッツバーグ・パイレーツ',1882,1887,'ペンシルベニア州ピッツバーグ/PNCパーク',2,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(25,'St. Louis Cardinals (STL)/セントルイス・カージナルス',1882,1892,'ミズーリ州セントルイス/ブッシュ・スタジアム',2,2,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(26,'Arizona Diamondbacks (ARI)/アリゾナ・ダイヤモンドバックス',1998,1998,'アリゾナ州フェニックス/チェイス・フィールド',2,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(27,'Colorado Rockies (COL)/コロラド・ロッキーズ',1993,1993,'コロラド州デンバー/クアーズ・フィールド',2,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(28,'Los Angeles Dodgers (LAD)/ロサンゼルス・ドジャース',1883,1890,'カリフォルニア州ロサンゼルス/ドジャー・スタジアム',2,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(29,'San Diego Padres (SD)/サンディエゴ・パドレス',1969,1969,'カリフォルニア州サンディエゴ/ペトコ・パーク',2,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00'),(30,'San Francisco Giants (SF)/サンフランシスコ・ジャイアンツ',1883,1883,'カリフォルニア州サンフランシスコ/オラクル・パーク',2,3,'0','2019-05-21 00:00:00','2019-05-21 00:00:00');
/*!40000 ALTER TABLE `mlb_main_uezu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobile_legends_main_sakuma`
--

DROP TABLE IF EXISTS `mobile_legends_main_sakuma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mobile_legends_main_sakuma` (
  `id` int(2) NOT NULL,
  `mobale_chara` varchar(256) NOT NULL,
  `type1_id` int(1) DEFAULT NULL,
  `type2_id` int(1) DEFAULT NULL,
  `feature1_id` int(1) DEFAULT NULL,
  `feature2_id` int(1) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile_legends_main_sakuma`
--

LOCK TABLES `mobile_legends_main_sakuma` WRITE;
/*!40000 ALTER TABLE `mobile_legends_main_sakuma` DISABLE KEYS */;
INSERT INTO `mobile_legends_main_sakuma` VALUES (0,'アウラド',5,NULL,3,7,'序盤からソウルスナッチを稼げていれば、終盤の場面で敵チームの後衛をULTで狙い撃ちすることが可能。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(1,'アリス',6,NULL,6,1,'序盤からミニオンを倒して得たブラッドオーブを回収して得られる永久バフが強力。','0','2019-07-09 15:00:00','2019-07-24 10:50:15'),(2,'アルカード',5,1,6,2,'スキル攻撃後に通常攻撃を行うと、付近の敵ヒーローとの間合いを一気に詰めて強化攻撃を行うといった追撃・追跡性能に優れている。\r\nそして見た目はD◯Cの某キャラクターに似ている。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(3,'アルゴス',5,NULL,6,7,'ULTは、一定時間自身が無敵になるという効果を持っている。無敵状態で敵に攻撃を与えた分だけ、無敵状態解除後の体力が回復する。一部に調整が入ったが、未だに玄人ヒーローである。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(4,'アルファ',5,NULL,6,2,'ベータという相棒とともに戦う。 \r\n固定ダメージをパッシブに持つ珍しいヒーローの1人で、減速、回復、吹き飛ばしなど、できることが多い器用な存在。 ','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(5,'アンジェラ',2,NULL,1,9,'ULTを使用せれば選んだ味方一人に憑依し、シールドと自身のパッシブ効果を与えられるのが強力。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(6,'イスンシン',4,NULL,5,9,'ハンターとして遠距離も得意であるが、敵と密着状態になることで通常攻撃が高火力/減速効果付きの近距離特化型となる。ULTによる場所を問わない攻撃もあり、全てのレンジに対応できる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(7,'ヴェル',6,NULL,8,9,'スキルレベルが上がると、2つのスキルから状況に応じて選択する特殊なヒーローである。ULTはダメージ増加か、範囲コントロールが選択できる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(8,'ヴェルス',6,NULL,7,9,'全てのスキルが広範囲かつCC能力に優れ、少人数のチームファイトから集団戦において強さを誇る。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(9,'ウラノス',3,NULL,1,9,'恐らく現段階で一番硬いタンクである。スキル調整が入り、ブリンクができることとULTに減速効果や自身への回復などが付与された。\r\n余談だが、友人が使用した時、1試合に受けたダメージが33万になっていた。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(10,'エウドラ',6,NULL,7,5,'スキルが目標にむかって放たれるので初心者でも扱いやすいヒーロー。特にULTが高火力。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(11,'エスタス',2,NULL,1,9,'ランキングやマッチングでは見ることが少なく、乱闘では大活躍するサポート。回復能力が高い。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(12,'エスメラルダ',6,3,1,9,'自身に大量のシールドを展開しながら敵に大ダメージを与えることができ、さらに魔法ダメージなので対策されづらい。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(13,'エレシル',4,NULL,5,NULL,'最大の特徴は「移動しながら攻撃が可能」というもの。敵の移動速度を80％も下げるスキルも相まって、自身だけでなく、味方全体が敵に追いつくアシストもできる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(14,'オーロラ',6,NULL,8,7,'オーロラの最大の特徴は5回目のスキルヒット時にCC能力を付与するパッシブ能力。敵を氷塊にして、一時的に一切の行動を封じる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(15,'オデット',6,NULL,7,9,'集団戦において強力なヒーロー。ULTは、自身を中心とした広範囲のドーム型フィールドを発生させ、その範囲内にいる敵に深刻なダメージを与えることができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(16,'カーディアン',3,NULL,1,9,'パッシブ効果も強力で吸収効果を持たない相手ならカウンターで倒せてしまうことがある。\r\nまた、ULTも強力で近くにいるだけで味方の被ダメを軽減することができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(17,'ガイ',3,NULL,4,8,'敵をスタンさせたり、壁に押し付けて攻撃を仕掛けることができる。敵を弾いて自陣タワーに強制的に連れ込んでタワーを利用した攻撃をすれば、HPが満タンの敵でもキルをとることが出来る。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(18,'カグラ',6,NULL,2,5,'攻撃と移動両方こなせる高いスキル効果を持ち、特に自身の状態異常を解除できる【羅生傘】は強力。\r\nそして日本語版CVは花澤香菜である。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(19,'カチャ',5,2,4,NULL,'強力な拘束効果を持つULTで敵を自陣に引きずり出すことができ、【スキルオーダーサークル】でミニオンを比較的早く処理することが可能。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(20,'カティタ',6,NULL,7,6,'多彩な移動スキルで敵を翻弄。\r\nパッシブのHP回復とULTの無敵状態などにより耐久もある。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(21,'ガトートカチャ',3,NULL,8,2,'パッシブによる防御力バフが強力で、ULTで敵陣に突っ込み、【金剛不破】でヘイト集め味方と共に敵を殲滅するのが得意。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(22,'カリナ',1,6,6,5,'キルをすることでスキルの冷却時間が短縮されるためサベージ(5人連続キル)を狙いやすい。またパッシブスキルに固定ダメージを持つため、タンクも溶かすことが出来る。\r\nセリナの姉でもある。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(23,'ガレック',3,NULL,4,8,'パッシブスキルと【ナチュラルパワー】の行動制限無効が強力で、メイジタイプには無類の強さを誇る。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(24,'キャリー',4,NULL,5,7,'パッシブの効果でモンスターを早く倒すことと、敵に最大HPに応じた固定ダメージを与えられるので序盤からダメージを出すことができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(25,'グィネヴィア',5,6,6,7,'【サイコアタック】で敵を複数吹き飛ばすことができ、その後逃げ足も速い。【サイコキネシス】の恩恵でスキル回転も早い。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(26,'グールド',6,NULL,2,9,'パッシブの効果でULTを当て続けれれば、敵に大ダメージを与えることが可能。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(27,'クッフラー',3,NULL,8,2,'スキルの効果で相手の移動スキルを封じれるのが極めて強力。さらに自身に防御バフをつけながら自身の最大HPに基づく魔法ダメージを出せるので火力も申し分ない。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(28,'クラウド',4,NULL,5,7,'パッシブの効果とデモンハントのパッシブスキルの相性が良く、序盤から効率よく育つことができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(29,'クリント',4,NULL,7,9,'誰よりもスキルを使用する必要のあるヒーロー。スキル使用後の通常攻撃１発の射程と威力が上がり、貫通効果も付与される。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(30,'グレンジャー',4,NULL,5,7,'武器が6発までの弾丸を充填でき、6発目は必ずクリティカルヒットとなる。攻撃速度はないが、その分火力が出るヒーローであり、ULTは長距離射程のバズーカ。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(31,'悟空',5,NULL,6,3,'分身を作り高火力を出すキャラクター。タワーへの攻撃速度が早く、放っておくと、バックドアされる可能性がある。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(32,'ゴセン',1,6,6,7,'パッシブスキルによるダメージ比例回復＆高火力。【シャドーキル】やULTで柔軟に動ける。LOLのザヤに近い技を持つ。\r\nそしてイケメンである。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(33,'サイクロプス',6,NULL,2,9,'ULTは単体を拘束することに長けたスキル。発動条件が非常に楽で、敵ヒーローがULTの広い射程内に入った瞬間にスキルを使うだけで確実に当てることができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(34,'ザスク',6,NULL,3,9,'ULTに調整が入り、かなり強化された。【ナイトメア】を召喚することで、タワーなどのターゲットを取れるため、タワー折りが強い。また、','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(35,'サナ',6,NULL,9,8,'サナの特徴的なULTであるULTの継続ダメージを与えながら相手を追い回す幽霊(敵ヒーローのコピー)を作りだす能力。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(36,'ジェイソン',3,NULL,8,2,'まさにトランスフォーマー。ULTで車に変化し、他レーンのカバーをカ敵に衝突すればスタン、その直後に継続的なダメージを与える。\r\nオデッソンは有名で、オデットのULTとの相性が良い。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(37,'ジミー',4,6,2,9,'ハンターの強力な通常攻撃に魔法攻撃力が加味され、敵は対策しにくい。\r\nまた、移動速度も速く、長い射程で敵を牽制するのも得意。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(38,'シュウ',5,NULL,6,8,'制限効果の高いULTを持ち、【瞬歩】によるシールド＆物理貫通と行動制限無効を駆使して一気に間合いを詰めて攻撃できる。\r\n唯一、格ゲーのような演出が入る。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(39,'嫦娥',6,NULL,5,9,'スキル調整が大幅に入ったヒーロー。ULTが特に強くなり、4秒間に自身の移動速度＋20％。その間は前方に向けて30個の飛星を乱射する。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(40,'子龍',5,1,6,2,'前方の敵を子龍の背後に移動させる事ができる能力を持つ。敵にとって不利な位置に持ち込み、子竜が最も得意とする近距離戦を強いる事ができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(41,'セイバー',1,NULL,6,8,'ULTを使うことで敵を約2秒間行動不能にさせることができる。そのため、動きの捉えずらいヒーローが相手であっても、効果範囲に入った瞬間に使用するだけで確定で拘束する事ができ、カウンターとして活躍する。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(42,'星夢',6,NULL,2,9,'イビルの力でULTを使った時のイビルインパクト連発による殲滅力。\r\nグローリーの力を使ったときは無敵状態となる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(43,'セリナ',1,6,5,7,'【アビスアロウ】による長時間スタン\r\nパッシブの追加ダメージで序盤から高火力。\r\n【アビストラップ】は罠としても索敵にも使える。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(44,'ディアス',5,NULL,6,7,'編集していた中で一番新しいヒーロー。ULTで減速だけでなく、防御力-75%を与えられるため、超高火力になる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(45,'ディガー',2,NULL,8,9,'スキルが一新して、【オート爆弾アラーム】で序盤に的に大量にダメージを与えることができ、使い勝手が良くなった。他のサポートスキルも集団戦やガンクに非常に有用である。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(46,'ティグラル',3,NULL,8,2,'敵を自分の方へ引き寄せ、スタンさせるスキルを持つ。うまく使いこなせれば集団戦におけるイニシエーターとして優秀。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(47,'ディスラー',5,NULL,2,7,'序盤から終盤まで耐久力と安定した火力がある。ULTはエリア内にいるヒーローを処刑台に繋げ、行動が制限される。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(48,'デームス',5,NULL,5,7,'パッシブと回転の早いスキルによってモンスターを手早く倒し早く育つことができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(49,'ナタリア',1,NULL,6,7,'ブッシュ(草むら)に入ると、姿を隠すステルス状態になる。その性能を活かすことで敵ジャングルを荒らすことが出来る他、ハンターやメイジなどを一方的に倒すことが可能である。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(50,'ナナ',6,2,9,8,'敵ヒーローを変身させるスキルを持ち、強力な範囲攻撃のULTを持つメイジ属性の強いサポートヒーロー。\r\nパッシブが強化され、致命的なダメージを受けても2秒間無敵状態となり、移動速度が70%アップする。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(51,'ハーリー',6,NULL,7,9,'【エスケープ】を駆使して戦場を自在に動き回り、単体キルに特化したULTで敵を奇襲するのが得意。\r\nメイジではあるが、動きはアサシン。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(52,'ハカート',1,NULL,6,7,'瞬間火力の高さと、ダメージを受けた時に敵を沈黙状態にさせるのが強力。対アサシンに対しても強い。また、ULTで敵の視界を奪うことができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(53,'バターン',5,NULL,6,7,'ULTがゴムゴムのガトリングを彷彿させる。【デストロイアタック】を使用し、敵を4秒間閉じ込めた後のULTが強力。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(54,'ハナビ',4,NULL,1,5,'パッシブスキルに物理吸収を持ち、シールドを得ることで移動速度バフと妨害効果を無効にできる。\r\nULTによる範囲攻撃で複数ヒーローにバインドを与えることができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(55,'隼',1,NULL,6,7,'【四方影】を駆使して戦場を駆け巡り一対一の状況を作ることができれば、ULTで敵を一方的に倒すことが可能。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(56,'ハリス',6,NULL,6,7,'【時空跳躍】で移動＋シールド付与でメイジとは思えない高耐久＆追撃。\r\nULTによるCD短縮でスキルをバンバン打てる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(57,'バルモンド',5,3,6,1,'ただのファイターではなく、タンクでもあるヒーロー。ファイターとしての火力、タンクとしての耐久力を誇る。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(58,'半蔵',1,NULL,5,7,'【霊魄喰奪】が発動すれば、モンスターを一瞬で狩ることができ、敵陣のバフモンスターを奪うことができる。またULTで幽体離脱が出来、本体が攻撃されない限りは死なず、敵を一方的に追うことができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(59,'ヒルダ',5,3,1,2,'ブッシュ（草むら）に隠れているとHP回復と5秒間HP上限10％分を吸収する強力なシールドを得る事が出来る。そのためリコールせず、留まり続けることが出来る。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(60,'ファーサ',6,NULL,2,9,'ULTは広範囲を攻撃でき、さらにスキルで地形を無視した移動が可能となるヒーロー。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(61,'ファニー',1,NULL,6,5,'使いこなすと環境をぶっ壊すOPヒーローである。立体機動装置を持ち、戦場を縦横無尽に動けるだけでなく、捉えることができない。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(62,'フランコ',3,NULL,4,NULL,'【アイアンフック】で遠くのヒーロー・ミニオン・モンスターを1体だけ引き寄せる能力を持つ。また、非戦闘時は移動速度が上がるパッシブを持つ。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(63,'ブルーノ',4,NULL,5,NULL,'スキル回りが早く、スキルを多用することで本領を発揮するヒーロー。【ボレーショット】使用後、地面に残ったボールを回収することで、冷却時間が大幅短縮されるという能力を持つ。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(64,'フレイヤ',5,NULL,6,7,'近接特化型のヒーロー。他の近接型とは異なり、ストレートな火力では勝負せず、自身の防御を固めつつスタンを与え、有利な状況を生み出す戦闘スタイル。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(65,'ベイン',5,NULL,3,NULL,'最近リメイクが入り、スキルが一新された。様々なレンジで戦うことができ、回復を持つため比較的安定した戦いができる。ULTは魚群を召喚し、敵にもタワーにもダメージが入る。\r\n昔の見た目は骸骨だったのにタコにされた。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(66,'ヘラクレス',3,NULL,1,9,'スキルが魔法ダメージである点と、その火力の高さで、魔法防御力の低い敵に十分なダメージを与えることができる。またULTが味方の移動速度を上げる道を作る。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(67,'マーティス',5,NULL,5,7,'相手の行動を制限したり、状態異常無効の移動スキルで敵を翻弄。\r\nULTによる集団連続キルができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(68,'マイシータール',5,NULL,4,8,'【ホーリーハルバード】で敵を引き寄せてULTを使用することで敵を逃すことなく倒すことが強力。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(69,'マイヤ',4,NULL,5,NULL,'通常攻撃力強化や単体攻撃に優れるスキルがあり、ステルスを使えばターゲットに取られなくなるため、特にハンター同士の殴り合いでは優位に立ちやすい。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(70,'マファセス',2,6,4,8,'2019年の特定の日にログインすることで無料で貰えることができたヒーロー。 ULTはエリア内にいるヒーローが死んだ場合、即座に復活することができ、最大10秒動くことができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(71,'ミノタウロス',3,2,8,NULL,'ダメージを受けて凶暴状態になるとステータスが強化される。\r\n凶暴状態でのスキル効果が高く、ULTで範囲打ち上げを持つ。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(72,'メタルヘッド',5,NULL,6,7,'【ワイルドキャスト】による敵または味方を「投げる」能力が特徴。投げる事で、味方を前方へ移動させて追跡・追撃・逃げの手助け、または敵を自陣へと投げ込み孤立させるなど、位置的有利を築く。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(73,'モスコブ',4,NULL,3,7,'通常攻撃は貫通するため、ミニオン処理が早く、常に複数の敵に攻撃することができる。また、【デススピア】は敵に吹き飛ばし効果を与える。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(74,'ライラ',4,NULL,5,NULL,'大器晩成型のヒーローであり、スキルレベルがMAXになると、射程距離が他のハンターよりも長くなり、射程距離限界地点の敵に対しては威力が30%上がる。',NULL,'2019-07-09 15:00:00','2019-07-09 15:00:00'),(75,'ラインロック',5,NULL,3,7,'ULTの移動速度＆防御バフによる汎用性の高さ。\r\nパッシブスキルはHP30%以下の敵に通常攻撃がクリティカルヒットする。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(76,'ラズリー',4,1,5,7,'最大の特徴である「射程距離」を活かして、敵の攻撃が当たらず自分だけが攻撃できる距離を保つことで一方的な攻撃をすることが可能である。\r\nハーリーの義理の姉でもある。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(77,'ラファエル',2,NULL,1,NULL,'エスタスと同じく、ランキングやマッチングではほぼ見られず、乱闘で大活躍するヒーロー。味方の回復だけでなく、移動速度アップをスキルに持つ。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(78,'ラプラプ',5,1,6,7,'ULTはスタンと十分なダメージを与えられるスキル。その攻撃範囲と距離はファイターとしては恵まれていて、近接戦から逃れようとする敵を捕らえる、もしくは仕留めることができる。特に重剣モードの際は、総合火力が段違い。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(79,'ランスロット',1,NULL,6,7,'彼はモバレジェ公式に愛されるスキン王である。パッシブにより敵に追加ダメージを与え、スキルの瞬間火力も高い。また、ULTを使うタイミングにより、CC無効となる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(80,'ルビー',5,NULL,8,NULL,'パッシブによりスキル吸収が付与されているため、敵をスキルでコントロールしながら、HPを吸収して高い耐久力を持つ。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(81,'ロイン',3,2,8,3,'世界一可愛いタンクである。ULTは前方の広範囲の敵を減速させ、直後にスタンを与えるという、優秀なCCスキルを持つ。強力な効果でありながらも、射程が長いため、比較的安全な位置から当てることが可能。\r\nまた、バリアを駆使するヒーローであり、遠距離攻撃を防いだり、味方にバリア能力を付与してサポートすることができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(82,'ロジャー',5,4,5,7,'最大の特徴は、戦況に応じて、近接特化のファイター(狼)と遠距離特化のハンター(人間)にロールチェンジすることができる。','0','2019-07-09 15:00:00','2019-07-09 15:00:00'),(85,'ラカン',2,NULL,0,NULL,'League of Legendsのキャラ','0','2019-07-23 17:00:40','2019-07-23 17:00:40'),(86,'カミール001',5,3,0,NULL,'League of Legendsのキャラ','0','2019-07-23 17:02:33','2019-07-23 17:15:25'),(87,'イレリア００２',0,NULL,0,NULL,'League of Legendsのキャラ','0','2019-07-23 17:03:25','2019-07-23 17:12:34'),(88,'ザヤ',1,NULL,2,7,'League of Legendsのキャラ','0','2019-07-24 10:10:04','2019-07-24 10:10:04'),(89,'test',0,NULL,0,NULL,NULL,'1','2019-07-24 10:12:10','2019-07-24 10:12:10');
/*!40000 ALTER TABLE `mobile_legends_main_sakuma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `month_nakai`
--

DROP TABLE IF EXISTS `month_nakai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `month_nakai` (
  `month_id` int(11) NOT NULL,
  `month` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `month_nakai`
--

LOCK TABLES `month_nakai` WRITE;
/*!40000 ALTER TABLE `month_nakai` DISABLE KEYS */;
INSERT INTO `month_nakai` VALUES (0,NULL,'0','2018-10-15 00:00:00','2018-10-15 00:00:00'),(1,'1月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(2,'2月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(3,'3月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(4,'4月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(5,'5月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(6,'6月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(7,'7月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(8,'8月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(9,'9月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(10,'10月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(11,'11月','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(12,'12月','0','2018-10-09 00:00:00','2018-10-09 00:00:00');
/*!40000 ALTER TABLE `month_nakai` ENABLE KEYS */;
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
INSERT INTO `movie_main` VALUES (1,'スパイダーマン3',1,2,2007,155,'スパイダーマンの映画の中では一番好き',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN誕生秘話、ばちぼこ面白い。',0,'2017-11-08 00:00:00','2020-03-23 09:45:36'),(3,'レオン',1,4,1994,110,'マチルダがかわいい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'ダークナイトライジング',1,5,2012,165,'DCコミック頑張れ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'ベイビードライバー',1,NULL,2017,113,'続編が制作されるそう',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'トランス',2,3,2013,101,'ダニー・ボイル監督',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'フィルス',2,3,2013,97,'スコットランドの最悪刑事',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'華麗なるギャツビー',2,2,2013,143,'豪華絢爛',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'ブリッジオブスパイ',2,1,2015,144,'アカデミー助演男優賞受賞',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'ダ・ヴィンチ・コード',2,1,2006,174,'オドレイ・トトゥ老けたなあ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'フォレストガンプ',3,1,1994,142,'言わずと知れた名言の宝庫',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'完全なるチェックメイト',3,2,2014,116,'ボビーフィッシャー',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'あの頃僕らは',3,2,2001,90,'若かりしディカプリオ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'レミゼラブル',3,5,2012,160,'歌部分はアテレコではありません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'グリーンマイル',3,1,1999,189,'『ショーシャンクの空に』もいいです',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'ブラックスワン',4,4,2011,108,'下手なホラーより怖いかも',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TVムービー編もどうぞ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'キャリー',4,NULL,1976,98,'スティーブン・キングの処女作',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'スプリット',4,3,2017,117,'シャマラン作品を見ておくと吉',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'ミスターガラス',4,3,2019,129,'スプリットの続編',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'マイ・インターン',5,5,2015,121,'『プラダを着た悪魔』もおすすめ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'ターミナル',5,1,2004,128,'空港に住んでみたい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'ペネロピ',5,3,2008,104,'現代のおとぎ話',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'アリスインワンダーランド',5,5,2010,113,'映像美すごい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'キャッツ＆ドッグス',5,2,2001,87,'犬はかわいい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'つぐない',NULL,3,2007,130,'陰鬱な時にはおすすめしません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'プライドと偏見',NULL,NULL,2005,135,'コリン・ファースのドラマ版も良き',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'グレイテストショーマン',3,NULL,2017,105,'個人的にラ・ラ・ランド越え',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'ビッグ',5,1,1988,130,'素敵な気持になれる',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'やたら豪華な俳優陣',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
/*!40000 ALTER TABLE `movie_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muscle_izawa`
--

DROP TABLE IF EXISTS `muscle_izawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muscle_izawa` (
  `id` int(2) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `body` int(2) DEFAULT NULL,
  `com` varchar(255) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  UNIQUE KEY `id` (`id`,`photo`,`menu`,`body`,`com`,`del_flg`),
  UNIQUE KEY `id_2` (`id`,`photo`,`menu`,`body`,`com`,`del_flg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muscle_izawa`
--

LOCK TABLES `muscle_izawa` WRITE;
/*!40000 ALTER TABLE `muscle_izawa` DISABLE KEYS */;
INSERT INTO `muscle_izawa` VALUES (1,'/izawaimage/Bench-press-1-2-289x300.png','バーベルベンチプレス',1,'大胸筋トレーニングの王道とも言えるのが「筋トレBIG3」の一つであるバーベルベンチプレスです。肩甲骨を寄せ、顎をやや引いて行うのがポイントです。',0),(4,'/izawaimage/Dumbbell-bench-press-2-215x300.png','ダンベルプレス',1,'自宅でのダンベルトレーニングのなかで、大胸筋を鍛えるのに最適な種目がダンベルプレスです。ベンチがない場合は、床の上で行っても効果を得ることが可能です。',0),(5,'/izawaimage/main-qimg-c200b655392c1a5c23e9ee1613bc8ce3-300x178.png','ダンベルフライ',1,'ダンベルプレスの仕上げとして効果的なのがダンベルフライです。腕を閉じたフィニッシュのポジションでやや腕を上に持ち上げる動きを加えるとさらに効果が高まります。',0),(6,'/izawaimage/Dumbbell-bent-arm-pullover-2-300x279.png','ベントアームダンベルプルオーバー',1,'大胸筋に縦方向の刺激を加えるとともに、胸郭を広げる作用もあるのがベントアームプルオーバーで、大胸筋トレーニングの仕上げにも最適な種目です。広背筋狙いのプルオーバーと違い、肘を曲げるのがポイントです。',0),(7,'/izawaimage/300px-Dips-300x273.png','ディップス',1,'自重トレーニング種目のなかでも、大胸筋下部に効果の高い種目がディップスです。特別な道具がなくても、椅子を二つ使うことで代用できます。',0),(8,'/izawaimage/17-01-15-09-14-15-858_deco-300x225.jpg','懸垂',2,'自重トレーニングで広背筋・僧帽筋を鍛えるスタンダードな種目が懸垂です。順手のノーマルグリップで行えば広背筋に、縦持ちのパラレルグリップで行えば僧帽筋に負荷がかかります。',0),(9,'/izawaimage/800px-Body-row-2-270x300.png','斜め懸垂',2,'懸垂ができない方におすすめなのが斜め懸垂です。自宅で行う場合は、テーブルの下に仰向けに入り、テーブルの縁を持って行うことで代用できます。',0),(10,'/izawaimage/Rear-deltoid-row-1-3-275x300.png','ダンベルローイング',2,'ダンベル筋トレで背筋トレーニングの基本となるのがダンベルローイングです。標準的なやり方だと僧帽筋を中心に効きますが、頭を低くし前方から引く軌道で行うと広背筋に負荷が強くかかります。',0),(11,'/izawaimage/Straight-arm-pullover-2-300x260.png','ストレートアームダンベルプルオーバー',2,'ダンベルプルオーバーは意識の仕方で大胸筋にも広背筋にも効果のあるダンベル筋トレです。肘を伸ばすとともに肘を内側に閉じ気味で動作を行うと広背筋に負荷が集まります。',0),(12,'/izawaimage/Barbell-rear-delt-row-1-288x300.png','デッドリフト',2,'ジムで行うバーベル筋トレで背筋に高負荷を加えられるのが「筋トレBIG3」の一つであるデッドリフトです。腰椎保護のため背中を丸めないように最大の注意を払ってください。なお、デッドリフトにかぎらず、背筋トレーニングで握力が先になくなってしまう人はリストストラップがとても有効です',0),(13,'/izawaimage/Reverse-grip-bent-over-rows-2-284x300.png','バーベルベントオーバーロー',2,'バーベルベントオーバーローは、デッドリフトとと並び代表的な背筋のバーベルトレーニングです。膝がつま先より前に出ないように注意し、胸を張り、背中をやや反らせて行ってください。',0),(14,'/izawaimage/17-01-16-18-08-14-691_deco-300x233.jpg','ワイドグリップ腕立て伏せ',3,'通常の腕立て伏せより手幅を広く構えるワイドグリップでの腕立て伏せは三角筋に強い負荷がかかります。プッシュアップバーの使用がおすすめです。',0),(15,'/izawaimage/17-02-01-16-34-56-568_deco-300x225.jpg','ダンベルショルダープレス',3,'ダンベルでの三角筋トレーニングのベースとなる種目がダンベルショルダープレスです。三角筋全体に効果がありますが、特に前部と側部に効果的です。なお、肩関節保護のために、肘が体幹より後ろにならないように動作するのがポイントです。',0),(16,'/izawaimage/5ad150fc550d8093e0e3d6e42acc4716-300x288.jpg','ダンベルアップライトロー',3,'三角筋は体幹の筋肉と連動しやすいので、上手く鍛えるのが難しい部位ですが、ダンベルアップライトローなら初心者でも比較的簡単に効かせることが可能です',0),(17,'/izawaimage/dubbellfrontraise-235x300.jpg','ダンベルフロントレイズ',3,'三角筋前部を集中的に鍛えることのできるのがダンベルフロントレイズです。反動を使うと僧帽筋に刺激が逃げてしまうので注意してください。慣れるまでは左右交互に挙上するオルタネイト動作で行うことをおすすめします',0),(18,'/izawaimage/Dumbbell-lateral-raises-1-3-272x300.png','ダンベルサイドレイズ',3,'三角筋中部を集中的に鍛えることのできるダンベル種目がダンベルサイドレイズです。反動を使わないことがポイントで、もし、膝の屈伸を使わないと挙上できないのであれば、その重量設定は重すぎます。',0),(19,'/izawaimage/Seated-military-shoulder-press-1-236x300.png','バーベルショルダープレス',3,'バーベルトレーニングで三角筋を鍛えるのスタンダードな種目がバーベルショルダープレスです。反動を使わずに、上げる時も下げる時もゆっくりと動作をするのが最大のポイントになります。',0),(20,'/izawaimage/Chin-ups-1-crop-300x235.png','リバース懸垂',4,'手を逆手にするリバースグリップで行う懸垂は、自宅で上腕二頭筋を鍛えるのに最適な自重トレーニングです。手幅を拳一つ分ほどに狭めるとより効果的です。',0),(21,'/izawaimage/Alternating_bicep_curl_with_dumbbell_2.svg-crop-247x300.png','ダンベルカール',4,'自宅でのダンベルトレーニングで上腕二頭筋に効果的なのがダンベルカールです。挙上するときに小指が上になるように旋回させると長頭(力こぶの高さ)に、逆方向に旋回させると短頭(力こぶの太さ)に効果があります。なお、アームブラスターと呼ばれるギアを併用すると、完全に反動をなくした状態で上腕二頭筋に負荷を爆発的に集中することができます。',0),(22,'/izawaimage/Bicep_hammer_curl_with_dumbbell_2.svg-crop-278x300.png','ダンベルハンマーカール',4,'10ダンベルを縦にグリップして行うダンベルハンマーカールは、上腕二頭筋のなかでも長頭(外側)に効果的なやり方です。',0),(23,'/izawaimage/Wide_grip_standing_biceps_curl_with_barbell_2.svg-300x277.png','バーベルカール',4,'上腕二頭筋を鍛えるスタンダードな種目がバーベルカールです。ただし、通常のバーベルでは上手くならないと手首を痛めがちなので、できれば曲線のついたWバーやEZバーを使うようにするとよいでしょう。',0),(24,'/izawaimage/Drag-curl-2-241x300.jpg','バーベルリバースカール',4,'バーベルリバースカールは上腕二頭筋の長頭と上腕筋、さらには前腕筋群にも効果的なバーベルトレーニングです。握力に自身のない方はリストストラップを併用することをおすすめします。',0),(25,'/izawaimage/Close_triceps_pushup_1.svg-300x153.png','ダイヤモンド腕立て伏せ',5,'自宅で自重トレーニングで上腕三頭筋短頭を鍛えるのにおすすめなのが、両手でダイヤモンド型を作って行うナローグリップでの腕立て伏せです。肘をできる限り開かずに動作することで、上腕三頭筋への負荷が高まります。',0),(26,'/izawaimage/Standing-triceps-extension-2-1-horz-1-300x198.jpg','ダンベルフレンチプレス',5,'自宅でのダンベルトレーニングのなかでも上腕三頭筋を集中的に鍛えられるのが、ダンベルフレンチプレス(別名ダンベルトライセプスエクステンション)です。肘をしっかりと固定し、上腕三頭筋だけで動作をするようにするのがポイントとなります。',0),(27,'/izawaimage/Dumbbell-incline-bench-press-1-crop-crop2-300x230.png','ダンベルトライセプスプレス',5,'ダンベルプレスとは逆方向にダンベルをグリップするダンベルトライセプスプレスは上腕三頭筋に負荷を集中させることが可能です。',0),(28,'/izawaimage/Rear-deltoid-row-1-crop-1-300x238.png','ダンベルキックバック',5,'上腕三頭筋のなかでも長頭に効果的なのがダンベルキックバックです。腕を完全に伸ばせる重量設定で行うのが最大のポイントです。',0),(29,'/izawaimage/Close_grip_barbell_bench_press-2-300x209.png','ナローグリップベンチプレス',5,'ジムで上腕三頭筋を鍛える定番トレーニング種目がナローグリップベンチプレスです。通常のベンチプレスと違い、肩甲骨を寄せずに行うことで上腕三頭筋に刺激が集中します。',0),(30,'/izawaimage/cable-wrist-curl-231x300.png','リストカール',6,'前腕筋の基本的な筋トレメニューがリストカールです。リストカールで前腕屈筋群を鍛えたら、バランスよくリバースリストカールで前腕伸筋群も鍛えるようにしましょう。また、縦方向の筋力を養うのにはリストハンマーで鍛える必要があります。',0),(31,'/izawaimage/Leg-raises-1-300x254.png','レッグレイズ',6,'腹直筋下部に効果の高い腹筋運動がレッグレイズです。息を吐きながら脚を持ち上げていきましょう。また、負荷を逃がさないためと腰椎への負担をかけないために、セット中は足を床につけないように注意してください。',0),(32,'/izawaimage/Front-squat-to-bench-2-858x1024-crop-300x300.png','自重スクワット',6,'自宅で行う自重トレーニングとして最適な種目が自重スクワットです。胸を張り、背中を反らせたニーベントスタイルが動作の基本です。また、膝関節を痛めないために、膝がつま先より前にでないように気をつけてください。',0),(33,'/izawaimage/Barbell_squat_2.svg-1-250x300.png','バーベルスクワット',6,'バーベルトレーニングのなかで、もっとも基本的なトレーニング種目が「筋トレBIG3」の一つであるバーベルスクワットです。自重スクワット同様にニーベントスタイルを作り、やや斜め後方に腰を下ろしてください。',0),(37,NULL,'バーベルベンチプレス＠やんべこうた食いしん坊',6,'111',1),(38,'	\r\n/izawaimage/10yen.jpg','乞食じゃないよ藤木だよ',6,'10円をいただくために登録するが1日でサービス停止',0),(39,NULL,'腹直筋トレーニング',6,'お腹の筋肉を鍛えます',1);
/*!40000 ALTER TABLE `muscle_izawa` ENABLE KEYS */;
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
INSERT INTO `music` VALUES (4,'心太软','任贤齐',5,'年代比较久远的一首歌，当年很流行，现在依然有很多人喜欢。',3,'https://www.youtube.com/embed/ZSWeurc1yMw','2018-03-19 15:12:14','2018-03-19 15:12:14',5),(9,'漂洋过海来看你','娃娃',5,'',3,'https://www.youtube.com/embed/hNQohQBFnwI','2018-03-19 16:05:12','2018-03-19 16:05:12',2),(10,'雪の華','中島美嘉',5,'',6,'https://www.youtube.com/embed/mF5Qq2YheTg','2018-03-19 17:18:19','2019-03-28 15:26:31',2),(11,'MY ALL','濱崎步',5,'',5,'https://www.youtube.com/embed/PKptgq8jTYw','2018-03-19 17:27:07','2018-03-19 17:27:07',1),(12,'Time after time ～花舞う街で～','仓木麻衣',5,'',4,'https://www.youtube.com/embed/Ep_W5rYXyi0','2018-03-19 17:28:57','2018-03-19 17:28:57',1),(13,'夢的點滴','松隆子',5,'',6,'https://www.youtube.com/embed/Vn6xGeMY9w8','2018-03-19 17:31:46','2018-03-19 17:31:46',1),(14,'big big world','Emilia',5,'',5,'https://www.youtube.com/embed/wpkS2DU_qMs','2018-03-19 17:33:04','2018-03-19 17:33:04',0);
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
-- Table structure for table `national_shiono`
--

DROP TABLE IF EXISTS `national_shiono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `national_shiono` (
  `id` int(11) DEFAULT NULL,
  `national` varchar(30) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `national_shiono`
--

LOCK TABLES `national_shiono` WRITE;
/*!40000 ALTER TABLE `national_shiono` DISABLE KEYS */;
INSERT INTO `national_shiono` VALUES (1,'アルゼンチン','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(2,'イタリア','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(3,'イングランド','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(4,'エジプト','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(5,'クロアチア','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(6,'スペイン','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(7,'ドイツ','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(8,'フランス','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(9,'ベルギー','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(10,'ポルトガル','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(11,'韓国','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(12,'日本','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(13,'ウルグアイ','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(14,'ブラジル','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(15,'セネガル','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(0,'','0','2019-05-17 15:05:00','2019-05-17 15:05:00');
/*!40000 ALTER TABLE `national_shiono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novel_main_okudaira`
--

DROP TABLE IF EXISTS `novel_main_okudaira`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `novel_main_okudaira` (
  `id` int(11) DEFAULT NULL,
  `novel_title` varchar(255) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `writer_id` int(11) DEFAULT NULL,
  `publication_year` int(4) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novel_main_okudaira`
--

LOCK TABLES `novel_main_okudaira` WRITE;
/*!40000 ALTER TABLE `novel_main_okudaira` DISABLE KEYS */;
INSERT INTO `novel_main_okudaira` VALUES (1,'人間失格',1,1,1948,'太宰が通ったというBarに行ってみたら、意外と若い女性や外国の方が多くてびっくり。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(2,'走れメロス',1,1,1946,'友情とは美しいものですね。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(3,'痴人の愛',1,2,1947,'年若い女性に振り回される男の話。自分の周りにはいてほしくないタイプの女性です。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(4,'刺青',1,2,1911,'耽美的ですね。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(5,'高野聖',1,3,1908,'擬古文が難しくてなかなか読めません．．．','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(6,'外科室',1,3,1895,'麻酔を拒む夫人の話。覚醒状態で外科手術を受けるなんて拷問に近いですね。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(7,'檸檬',1,4,1925,'全体に退廃的な空気が漂っていて、個人的には好みです。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(8,'桜の樹の下には',1,4,1928,'桜の樹の下に屍体が埋まっているというのは妖しくも美しい感性だと思います。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(9,'十角館の殺人',2,5,1987,'たった一行の台詞ですべてがひっくり返るような構成は見事です。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(10,'時計館の殺人',2,5,1994,'「時計館」というだけあって、時間が鍵となる秀逸なトリックです。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(11,'暗黒館の殺人',2,5,2004,'読みたいけど全四巻はちょっと長いです。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(12,'霧越邸殺人事件',2,5,1995,'雪深い場所に建つ洋館を舞台に、北原白秋の詩に沿って起こる連続殺人。美しいミステリです。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(13,'姑獲鳥の夏',2,6,1994,'レンガ本と揶揄されるくらい分厚い本ですが、意外と読みやすいのでおすすめ。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(14,'魍魎の匣',2,6,1995,'京極夏彦の最高傑作との呼び声高い作品です。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(15,'屍人荘の殺人',2,7,2017,'一瞬、綾辻さんの新作かと思いましたが、違うんですね。今度映画化するみたいです。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(16,'Another',3,5,2009,'ホラーの設定にミステリの要素を足したような作品。映画やアニメにもなっているみたいです。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(17,'眼球奇譚',3,5,1998,'ちょっとグロテスクな短編集。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(18,'殺戮に至る病',3,8,1992,'面白いという話は聞くものの未読。早く読まねば。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(19,'残穢',3,9,2012,'余談ですが、作者の小野さんはミステリ作家の綾辻さんの奥様。家ではどんな会話をするんでしょうか。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(20,'黒い家',3,10,1997,'本当に怖いのは生きた人間だという話。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(21,'海賊と呼ばれた男',4,11,2012,'映画になってましたね。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(22,'下町ロケット',4,12,2010,'ドラマになってましたね。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(23,'七つの会議',4,12,2012,'映画にもドラマにもなってましたね。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(24,'日本沈没',5,13,1973,'センセーショナルなタイトルだと思います。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(25,'新世界より',5,10,2008,'タイトルは聞いたことがありますが、SFはほとんど読まないです。','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(26,'桜桃',1,1,1948,'この作品にちなんで太宰の忌日を桜桃忌と呼ぶそうです。','0','2019-11-08 14:03:02','2019-11-08 14:03:02');
/*!40000 ALTER TABLE `novel_main_okudaira` ENABLE KEYS */;
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
-- Table structure for table `player_main_shiono`
--

DROP TABLE IF EXISTS `player_main_shiono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_main_shiono` (
  `id` int(11) DEFAULT NULL,
  `player_name` varchar(30) DEFAULT NULL,
  `national_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `birth_day` varchar(10) DEFAULT NULL,
  `position_name` varchar(5) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_main_shiono`
--

LOCK TABLES `player_main_shiono` WRITE;
/*!40000 ALTER TABLE `player_main_shiono` DISABLE KEYS */;
INSERT INTO `player_main_shiono` VALUES (1,'セルヒオ・アグエロ',1,1,'1988.06.02','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(2,'リオネル・メッシ',1,2,'1987.06.24','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(3,'アンヘル・ディ・マリア',1,3,'1988.02.14','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(4,'パウロ・ディバラ',1,4,'1993.11.15','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(5,'ジャンルイジ・ブッフォン',2,3,'1978.01.28','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(6,'ラヒーム・スターリング',3,1,'1994.12.08','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(7,'ハリー・ケイン',3,5,'1993.07.28','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(8,'モハメド・サラー',4,6,'1992.06.15','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(9,'ルカ・モドリッチ',5,7,'1985.09.09','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(10,'ダビド・デ・ヘア',6,8,'1990.11.07','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(11,'セルヒオ・ラモス',6,7,'1986.03.30','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(12,'ジェラール・ピケ',6,2,'1987.02.02','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(13,'イスコ',6,7,'1992.04.21','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(14,'ダビド・シルバ',6,1,'1986.01.08','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(15,'フェルナンド・トーレス',6,9,'1984.03.20','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(16,'マヌエル・ノイアー',7,10,'1986.03.27','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(17,'テア・シュテーゲン',7,2,'1992.04.30','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(18,'マッツ・フンメルス',7,10,'1988.12.16','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(19,'トニ・クロース',7,7,'1990.01.04','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(20,'リロイ・サネ',7,1,'1996.01.11','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(21,'メスト・エジル',7,11,'1988.10.15','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(22,'マルコ・ロイス',7,12,'1989.05.31','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(23,'ラファエル・ヴァラン',8,7,'1993.04.25','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(24,'ポール・ポグバ',8,8,'1993.03.19','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(25,'フランク・リベリ',8,10,'1983.04.07','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(26,'カリム・ベンゼマ',8,7,'1987.12.19','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(27,'キリアン・ムバッペ',8,3,'1998.12.20','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(28,'アントワーヌ・グリエーズマン',8,13,'1991.03.21','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(29,'ティボー・クルトワ',9,7,'1992.05.11','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(30,'ビンセント・コンパニ',9,1,'1986.04.10','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(31,'ヤン・フェルトンゲン',9,5,'1987.04.24','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(32,'ケビン・デ・ブルイネ',9,1,'1991.06.28','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(33,'エデン・アザール',9,14,'1991.01.07','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(34,'ロメル・ルカク',9,8,'1993.05.13','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(35,'ドリース・メルテンス',9,15,'1987.05.06','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(36,'ベルナルド・シウバ',10,1,'1994.08.10','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(37,'クリスティアーノ・ロナウド',10,4,'1985.02.05','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(38,'ソン・フンミン',11,5,'1992.07.08','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(39,'長友佑都',12,16,'1986.09.12','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(40,'長谷部誠',12,17,'1984.01.18','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(41,'香川真司',12,18,'1989.03.17','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(42,'本田圭佑',12,19,'1986.06.13','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(43,'大迫勇也',12,20,'1990.05.18','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(44,'ルイス・スアレス',13,2,'1987.01.24','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(45,'エジソン・カバーニ',13,3,'1987.02.14','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(46,'マルセロ',14,7,'1988.05.12','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(47,'ウィリアン',14,14,'1988.08.09','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(48,'コウチーニョ',14,2,'1992.06.12','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(49,'ネイマール',14,3,'1992.02.05','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(50,'サディオ・マネ',15,6,'1992.04.10','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(53,'レナト・サンチェス',0,0,'','','1','2019-06-18 11:28:40','2019-06-18 11:28:40'),(54,'レナト・サンチェス',0,0,'','','1','2019-06-18 11:41:36','2019-06-18 11:41:36');
/*!40000 ALTER TABLE `player_main_shiono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prefecture_minami`
--

DROP TABLE IF EXISTS `prefecture_minami`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prefecture_minami` (
  `id` int(10) NOT NULL,
  `prefecture` varchar(100) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prefecture_minami`
--

LOCK TABLES `prefecture_minami` WRITE;
/*!40000 ALTER TABLE `prefecture_minami` DISABLE KEYS */;
INSERT INTO `prefecture_minami` VALUES (0,NULL,'0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(1,'北海道','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(2,'青森','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(3,'岩手','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(4,'宮城','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(5,'山形','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(6,'福島','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(7,'茨城','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(8,'栃木','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(9,'群馬','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(10,'埼玉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(11,'千葉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(12,'東京','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(13,'神奈川','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(14,'山梨','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(15,'長野','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(16,'富山','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(17,'石川','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(18,'福井','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(19,'岐阜','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(20,'静岡','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(21,'愛知','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(22,'三重','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(23,'滋賀','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(24,'京都','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(25,'大阪','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(26,'兵庫','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(27,'奈良','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(28,'和歌山','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(29,'鳥取','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(30,'島根','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(31,'岡山','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(32,'広島','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(33,'山口','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(34,'徳島','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(35,'香川','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(36,'愛媛','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(37,'高知','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(38,'福岡','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(39,'佐賀','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(40,'長崎','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(41,'熊本','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(42,'大分','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(43,'宮崎','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(44,'鹿児島','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(45,'沖縄','0','2019-05-16 00:00:00','2019-05-16 00:00:00');
/*!40000 ALTER TABLE `prefecture_minami` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_kurimoto`
--

DROP TABLE IF EXISTS `price_kurimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_kurimoto` (
  `id` int(11) NOT NULL,
  `price_name` varchar(11) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_kurimoto`
--

LOCK TABLES `price_kurimoto` WRITE;
/*!40000 ALTER TABLE `price_kurimoto` DISABLE KEYS */;
INSERT INTO `price_kurimoto` VALUES (0,NULL,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(1,'給料日前','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(2,'お財布安心','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(3,'金銭的余裕','0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(4,'贅沢三昧','0','2019-08-09 00:00:00','2019-08-09 00:00:00');
/*!40000 ALTER TABLE `price_kurimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quality_okabe`
--

DROP TABLE IF EXISTS `quality_okabe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quality_okabe` (
  `id` int(11) NOT NULL,
  `quality` varchar(50) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quality_okabe`
--

LOCK TABLES `quality_okabe` WRITE;
/*!40000 ALTER TABLE `quality_okabe` DISABLE KEYS */;
INSERT INTO `quality_okabe` VALUES (0,NULL,'0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(1,'単純温泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(2,'二酸化炭素泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(3,'炭酸水素泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(4,'塩化物泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(5,'硫酸塩泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(6,'含鉄泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(7,'含アルミニウム泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(8,'硫黄泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(9,'酸性泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(10,'放射能泉','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(11,'混合','0','2019-05-16 00:00:00','2019-05-16 00:00:00');
/*!40000 ALTER TABLE `quality_okabe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region_nagashima`
--

DROP TABLE IF EXISTS `region_nagashima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region_nagashima` (
  `region_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region_nagashima`
--

LOCK TABLES `region_nagashima` WRITE;
/*!40000 ALTER TABLE `region_nagashima` DISABLE KEYS */;
INSERT INTO `region_nagashima` VALUES (0,NULL,'0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(1,'北海道、東北','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(2,'関東','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(3,'中部','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(4,'関西','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(5,'中国、四国','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(6,'九州、沖縄','0','2019-12-04 00:00:00','2019-12-04 00:00:00');
/*!40000 ALTER TABLE `region_nagashima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residents_main_uriu`
--

DROP TABLE IF EXISTS `residents_main_uriu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residents_main_uriu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `animal_id` int(11) DEFAULT NULL,
  `phrase` varchar(256) DEFAULT NULL,
  `motto` varchar(256) DEFAULT NULL,
  `birthday` varchar(256) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residents_main_uriu`
--

LOCK TABLES `residents_main_uriu` WRITE;
/*!40000 ALTER TABLE `residents_main_uriu` DISABLE KEYS */;
INSERT INTO `residents_main_uriu` VALUES (1,'たぬきち',NULL,NULL,'だなも','あきんどは損していつか倉がたつ','6/13','tanukichi.gif','0','2019-08-07 00:00:00','2019-08-23 09:09:03'),(2,'とたけけ',NULL,NULL,NULL,'けけも歩けば棒に当たる','4/2','/residentsUriu/totakeke.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(3,'みしらぬネコ',NULL,NULL,NULL,'猫に鰹節','7/19','/residentsUriu/mishiranuneko.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(4,'えきいんさん',NULL,NULL,NULL,'去る者は追わず','2/20','/residentsUriu/ekiinsan.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(5,'ぺりこ',NULL,NULL,NULL,'当日の消印は有効','11/14','/residentsUriu/periko.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(6,'ぺりお',NULL,NULL,NULL,'会えないときは手紙で話そう','11/3','/residentsUriu/perio.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(7,'つねきち',NULL,NULL,NULL,'生き馬の目を抜く','10/14','/residentsUriu/tsunekichi.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(8,'ラッキー',1,1,'らしいよ','賭けには幸運、恋には不運','1/8','/residentsUriu/rakkii.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(9,'キャラメル',5,1,'ワン','中くらいの幸せが一番良い','5/11','/residentsUriu/kyarameru.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(10,'ベーグル',5,1,'グー','ヒゲのない夫にヒゲのある妻','10/11','/residentsUriu/beeguru.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(11,'たま',6,2,'ふんっ','起きて半畳、寝て一畳','6/12','/residentsUriu/tama.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(12,'キャビア',5,2,'だニ','女心は猫の目','10/4','/residentsUriu/kyabia.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(13,'ブーケ',4,2,'チェキ','美貌は結婚まで、知恵は死ぬまで','8/14','/residentsUriu/buuke.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(14,'カルピ',4,3,'だモー','言わぬ事は聞こえぬ','5/24','/residentsUriu/karupi.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(15,'マーサ',4,4,'ラン','親しき仲にも礼儀あり','11/9','/residentsUriu/maasa.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(16,'モモチ',2,4,'ニンニン','忍びざるの心','1/7','/residentsUriu/momochi.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(17,'リリアン',4,4,'みたいな','可愛い子には旅をさせよ','5/23','/residentsUriu/ririan.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(18,'レイニー',5,5,'でちゅ','雨ふって地固まる','7/22','/residentsUriu/reinii.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(19,'クワトロ',1,5,'にゃむ','カエルのいない池の水はよくない','12/8','/residentsUriu/kuwatoro.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(20,'ピース',2,6,'チュー','目で目は見えぬ','12/5','/residentsUriu/piisu.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(21,'とめ',5,6,'だべ','無い時のしんぼうある時のけんやく','8/5','/residentsUriu/tome.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(22,'ロボ',3,7,'のな','見えてる村へは案内無用','1/29','/residentsUriu/robo.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(23,'ツンドラ',6,7,'なのだわ','香りは人を酔わせる','4/28','/residentsUriu/tsundora.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(24,'タンタン',4,8,'わぉ','熱烈歓迎','6/27','/residentsUriu/tantan.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(25,'チャウヤン',3,8,'アルヨ','チリも積もれば山となる','12/22','/residentsUriu/chauyan.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(26,'クロー',3,8,'ワォー','若いときの苦労は買うてもせよ','10/19','/residentsUriu/kuroo.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(27,'メリヤス',5,9,'なのね','羊をなくしてから庭にサク','2/19','/residentsUriu/meriyasu.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(28,'のりっぺ',4,10,'だッピ','やせの大食い','7/29','/residentsUriu/norippe.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(29,'ピータン',2,10,'だね','アヒルに山の芋','7/19','/residentsUriu/piitan.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(30,'アンデス',6,11,'カラカラ','同じ羽色の鳥は集まる','1/23','/residentsUriu/andes.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(31,'アポロ',3,11,'だワイ','能ある鷹は爪を隠す','12/4','/residentsUriu/aporo.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(32,'ビス',1,12,'ペンペン','ネジが緩む','5/8','/residentsUriu/bisu.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(33,'オーロラ',5,12,'だジョー','渡る世間に鬼は無い','5/6','/residentsUriu/orora.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(34,'ももこ',4,13,'なのよ','桃栗3年柿8年','8/30','/residentsUriu/momoko.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(35,'ララミー',5,13,'ったら','読書をしない者は目がないに等しい','9/10','/residentsUriu/raramii.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(36,'リッキー',1,13,'でしゅ','赤子のからわらい','8/25','/residentsUriu/rikkii.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(37,'レベッカ',6,13,'つんっ','絵を見ておのれを知る','6/28','/residentsUriu/rebekka.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(38,'ミント',6,13,'うっふん','色とりどりの世界','5/16','/residentsUriu/minto.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(39,'シルエット',6,13,'ふふん','女心と南風','12/3','/residentsUriu/shiruetto.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(40,'スパーク',3,13,'ピカッ','刺激のある人生を','12/9','/residentsUriu/supaku.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(41,'シドニー',5,14,'だコアラ','朝焼けは雨、夕焼けは晴れ','9/12','/residentsUriu/shidoni.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(42,'ユーカリ',6,14,'アラ','食わず嫌い','12/20','/residentsUriu/yuukari.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(43,'オパール',6,15,'ヨン','象に乗ってバッタ取り','4/29','/residentsUriu/oparu.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(44,'エレフィン',6,15,'ルン','終わり良ければすべて良し','4/22','/residentsUriu/elefin.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(45,'ツバクロ',2,16,'でおます','出たとこ勝負','12/17','/residentsUriu/tsubakuro.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(46,'うずまき',5,16,'キョン','あばたもエクボ','11/7','/residentsUriu/uzumaki.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(47,'ポンチョ',2,17,'モン','どんぶり勘定','4/11','/residentsUriu/poncho.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(48,'グルミン',4,17,'キュン','ヤマガラのくるみ回す','9/15','/residentsUriu/gurumin.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(49,'メープル',5,17,'だベア','クマも腹減りゃ踊れない','9/6','/residentsUriu/meepuru.gif','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(52,'てすと２',1,5,'てすと','てすと\r\n','8/21','kuwatoro.gif','1','2019-08-21 16:31:09','2019-08-21 16:31:09');
/*!40000 ALTER TABLE `residents_main_uriu` ENABLE KEYS */;
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
-- Table structure for table `rider_main_saito`
--

DROP TABLE IF EXISTS `rider_main_saito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rider_main_saito` (
  `rider_id` int(3) NOT NULL,
  `rider_name` varchar(256) NOT NULL,
  `age_id` int(1) NOT NULL,
  `actor` varchar(256) NOT NULL,
  `serif` varchar(256) NOT NULL,
  `img` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rider_main_saito`
--

LOCK TABLES `rider_main_saito` WRITE;
/*!40000 ALTER TABLE `rider_main_saito` DISABLE KEYS */;
INSERT INTO `rider_main_saito` VALUES (1,'仮面ライダー1号',1,'藤岡 弘','俺は本郷猛、仮面ライダー第1号だ！','/RiderSaito/001.png','0','2020-01-30 00:00:00','2020-02-06 15:51:48'),(2,'仮面ライダーV3',1,'宮内 洋','仮面ライダー、俺を改造人間にしてくれ！！','/RiderSaito/002.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(3,'仮面ライダーX',1,'速水 亮','アポロ、チェンジ！','/RiderSaito/003.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(4,'仮面ライダーアマゾン',1,'岡崎 徹','人間嫌いだ','/RiderSaito/004.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(5,'仮面ライダーストロンガー',1,'荒木 茂','天が呼ぶ地が呼ぶ人が呼ぶ','/RiderSaito/005.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(6,'スカイライダー',1,'村上 弘明','空を、、、？俺は空を飛んでいる、、、？空を飛べるんだ！！','/RiderSaito/006.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(7,'仮面ライダースーパー1',1,'高杉 俊价','人類の未来を宇宙に賭けていました','/RiderSaito/007.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(8,'仮面ライダーZX',1,'菅田 俊','仮面ライダーは死なん','/RiderSaito/008.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(9,'仮面ライダーブラック',1,'倉田 てつを','人間をなんだと思ってるんだ！','/RiderSaito/009.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(10,'仮面ライダーブラックRX',1,'倉田 てつを','俺は太陽の子！仮面ライダーブラァーック、アールエーックス！！','/RiderSaito/010.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(11,'仮面ライダークウガ',2,'オダギリジョー','だから見ててください、俺の、変身！！','/RiderSaito/011.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(12,'仮面ライダーアギト',2,'賀集 利樹','俺は戦う！人間のために！アギトのために！','/RiderSaito/012.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(13,'仮面ライダー龍騎',2,'須賀 貴匡','しゃあっ！','/RiderSaito/013.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(14,'仮面ライダー555',2,'半田 健人','俺には夢はない。だが、夢を守ることはできる。','/RiderSaito/014.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(15,'仮面ライダー剣',2,'椿 隆之','俺は運命と戦う、そして勝ってみせる','/RiderSaito/015.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(16,'仮面ライダー響鬼',2,'細川 茂樹','鍛えてますから','/RiderSaito/016.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(17,'仮面ライダーカブト',2,'水嶋 ヒロ','天の道を往き、総てを司る男！','/RiderSaito/017.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(18,'仮面ライダー電王',2,'佐藤 健','俺、参上！','/RiderSaito/018.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(19,'仮面ライダーキバ',2,'瀬戸 康史','いくよ、キバット！','/RiderSaito/019.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(20,'仮面ライダーディケイド',2,'井上 正大','通りすがりの仮面ライダーだ','/RiderSaito/020.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(21,'仮面ライダーW',2,'桐山 連/菅田 将暉','さあ、お前の罪を数えろ！','/RiderSaito/021.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(22,'仮面ライダーオーズ/OOO',2,'渡部 秀','手が届くのに手を伸ばさなかったら、死ぬほど後悔する。それがいやだから手を伸ばすんだ！','/RiderSaito/022.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(23,'仮面ライダーフォーゼ',2,'福士 蒼汰','宇宙キター！','/RiderSaito/023.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(24,'仮面ライダーウィザード',2,'白石 隼也','さぁ、ショータイムだ！','/RiderSaito/024.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(25,'仮面ライダー鎧武',2,'佐野 岳','ここからは俺のステージだ！','/RiderSaito/025.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(26,'仮面ライダードライブ',2,'竹内 涼真','ひとっ走り付き合えよ','/RiderSaito/026.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(27,'仮面ライダーゴースト',2,'西銘 駿','命燃やすぜ！','/RiderSaito/027.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(28,'仮面ライダーエグゼイド',2,'飯島 寛騎','患者の運命は俺が変える！','/RiderSaito/028.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(29,'仮面ライダービルド',2,'犬飼 貴丈','さあ、実験を始めようか','/RiderSaito/029.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(30,'仮面ライダージオウ',2,'奥野 壮','俺は仮面ライダーの王になる！','/RiderSaito/030.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(31,'仮面ライダーゼロワン',3,'高橋 文哉','お前を止められるのはただ一人、、、俺だ！','/RiderSaito/031.png','0','2020-01-30 00:00:00','2020-01-30 00:00:00'),(32,'仮面ライダーSEINA',2,'甲斐 聖奈','外人と結婚したい',NULL,'1','2020-02-06 17:25:21','2020-02-06 17:25:21');
/*!40000 ALTER TABLE `rider_main_saito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ringo_cd_title_takizawa`
--

DROP TABLE IF EXISTS `ringo_cd_title_takizawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ringo_cd_title_takizawa` (
  `id` int(11) NOT NULL,
  `cd_title` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ringo_cd_title_takizawa`
--

LOCK TABLES `ringo_cd_title_takizawa` WRITE;
/*!40000 ALTER TABLE `ringo_cd_title_takizawa` DISABLE KEYS */;
INSERT INTO `ringo_cd_title_takizawa` VALUES (0,NULL,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(1,'幸福論','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(2,'歌舞伎町の女王','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(3,'ここでキスして。','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(4,'無罪モラトリアム','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(5,'本能','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(6,'ギブス','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(7,'罪と罰','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(8,'勝訴ストリップ','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(9,'真夜中は純潔','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(10,'唄ひ手冥利〜其ノ壱〜','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(11,'茎 (STEM) 〜大名遊ビ編〜','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(12,'加爾基 精液 栗ノ花','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(13,'りんごのうた','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(14,'この世の限り','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(15,'ありあまる富','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(16,'カーネーション','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(17,'いろひにほへと/孤独のあかつき','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(18,'NIPPON','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(19,'至上の人生','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(20,'長く短い祭/神様、仏様','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(21,'平成風俗','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(22,'私と放電','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(23,'三文ゴシップ','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(24,'浮き名','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(25,'蜜月抄','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(26,'逆輸入～港湾局～','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(27,'日出処','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(28,'逆輸入～航空局～','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(29,'アダムとイブの林檎','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(30,'三毒史','0','2019-08-14 00:00:00','2019-08-14 00:00:00');
/*!40000 ALTER TABLE `ringo_cd_title_takizawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ringo_main_takizawa`
--

DROP TABLE IF EXISTS `ringo_main_takizawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ringo_main_takizawa` (
  `id` int(11) NOT NULL,
  `song_title` varchar(256) NOT NULL,
  `cd_title_id` int(11) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `song_image_id` int(11) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ringo_main_takizawa`
--

LOCK TABLES `ringo_main_takizawa` WRITE;
/*!40000 ALTER TABLE `ringo_main_takizawa` DISABLE KEYS */;
INSERT INTO `ringo_main_takizawa` VALUES (1,'幸福論',1,1998,1,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(2,'すべりだい',1,1998,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(3,'時が暴走する',1,1998,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(4,'歌舞伎町の女王',2,1998,4,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(5,'ここでキスして。',3,1999,1,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(6,'正しい街',4,1999,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(7,'丸の内サディスティック',4,1999,4,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(8,'幸福論（悦楽編）',4,1999,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(9,'茜さす帰路照らされど…',4,1999,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(10,'シドと白昼夢',4,1999,1,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(11,'積木遊び',4,1999,4,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(12,'同じ夜',4,1999,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(13,'警告',4,1999,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(14,'モルヒネ',4,1999,1,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(15,'本能',5,1999,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(16,'あおぞら',5,1999,1,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(17,'輪廻ハイライト',5,1999,4,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(18,'ギブス',6,2000,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(19,'罪と罰',7,2000,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(20,'君ノ瞳ニ恋シテル',7,2000,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(21,'17',7,2000,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(22,'虚言症',8,2000,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(23,'浴室',8,2000,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(24,'弁解ドビュッシー',8,2000,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(25,'闇に降る雨',8,2000,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(26,'アイデンティティ',8,2000,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(27,'ストイシズム',8,2000,1,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(28,'月に負け犬',8,2000,2,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(29,'サカナ',8,2000,4,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(30,'病床パブリック',8,2000,3,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(31,'依存症',8,2000,2,'0','2019-08-14 00:00:00','2019-08-26 11:20:20'),(32,'獣ゆく細道',30,2018,4,'1','2019-08-26 10:30:38','2019-08-26 10:30:57');
/*!40000 ALTER TABLE `ringo_main_takizawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ringo_song_image_takizawa`
--

DROP TABLE IF EXISTS `ringo_song_image_takizawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ringo_song_image_takizawa` (
  `id` int(11) NOT NULL,
  `song_image` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ringo_song_image_takizawa`
--

LOCK TABLES `ringo_song_image_takizawa` WRITE;
/*!40000 ALTER TABLE `ringo_song_image_takizawa` DISABLE KEYS */;
INSERT INTO `ringo_song_image_takizawa` VALUES (0,NULL,'0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(1,'ふわふわ','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(2,'感傷的','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(3,'アドレナリン出したい','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(4,'高飛車','0','2019-08-14 00:00:00','2019-08-14 00:00:00'),(5,'ミュージカルの主人公','0','2019-08-14 00:00:00','2019-08-14 00:00:00');
/*!40000 ALTER TABLE `ringo_song_image_takizawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruins_main_kurihara`
--

DROP TABLE IF EXISTS `ruins_main_kurihara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruins_main_kurihara` (
  `id` int(11) NOT NULL,
  `ruins_name` varchar(256) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `since` varchar(256) DEFAULT NULL,
  `backstory` varchar(256) DEFAULT NULL,
  `rem` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruins_main_kurihara`
--

LOCK TABLES `ruins_main_kurihara` WRITE;
/*!40000 ALTER TABLE `ruins_main_kurihara` DISABLE KEYS */;
INSERT INTO `ruins_main_kurihara` VALUES (1,'端島炭鉱',8,10,'1970年代～','かつて明治から昭和にかけて海底炭鉱により栄えていた。最盛期は東京都以上の人口を有していた。炭鉱の閉山により人々が離れてゆき、無人島と化した。島全体が軍艦のような形をしているため、軍艦島とも呼ばれている。','人気観光スポット。島丸ごと廃墟。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(2,'甲賀ファミリーランド',6,7,'1985年～','総面積は東京ドームの約26倍であり、当時は県内最大の遊園地として栄えており、県外からの来る人々も多かった。しかし、立地が悪く、経営難に陥ったため、1985年に閉鎖された。','運営がゴルフ倶楽部であり、ゴルフ場に隣接している。広いのは広いが、スッカスカである。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(3,'鬼怒川廃墟ホテル群',6,3,'バブル崩壊後～','バブル時代には旅行先として温泉ホテルが人気だった。しかし、バブル崩壊やレジャー施設の多様化も相まって、温泉業界は大打撃を受けた。鬼怒川の温泉ホテル群も、その当時は巨大な温泉街として繁盛していたが、今では廃墟マニアしか寄り付かなくなっている。','ここに限った話ではないが、私有地であるため、勝手に侵入すると違法になる。地域のイメージにかかわるが、今のところ取り壊しの予定は無いらしい。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(4,'由良要塞友ヶ島地区',4,11,'第二次世界大戦後～','明治時代から終戦まで一般人完全立ち入り禁止となっていた幻の島。当時は地図上でも白く塗りつぶされており、完全に極秘であった。現在は多くの砲台が良好な状態で残されている。','映画、雑誌などの撮影場所としても使用される。ラピュタっぽいとのことで有名。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(5,'西洋館',2,3,'昭和中期ごろ～','小松製作所や日産の創始者である竹内明太郎の別荘。炭鉱への食糧供給と、近代的な農業の試験として竹内農場が設置されると、それに伴い、竹内は別荘を建てた。それが西洋館である。農場が経営難になり竹内がいなくなった後も、農場の管理人が管理をし、家のない家族を無償で住まわせたりなどしたという。','現在は屋根も床もほとんど残っていない。心霊スポットとしても有名',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(6,'高田牧場',2,7,'バブル崩壊後～','かつては養豚場であった。その豪勢な佇まいから武家屋敷とも呼ばれる。中はいつかの建物で構成されている。心霊、オカルトに関するうわさが後を絶たないが、すべて真偽は不明である。牧場をたたんだ後、ボーイスカウトの実習場として使われたり、酒造会社に売却されたりした。バブル崩壊とともに放置され今に至る。','井戸が二つあり、二つ目の井戸を見つけると呪われるなどのうわさがある。敷地内に竹が生えている。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(7,'洲原村診療所',7,6,'1950年代～','健全ﾅﾙ国民ﾉ診療所とも呼ばれる。明治時代に建てられた建築物であると思われる。県立の診療所であったそうだ。','薬瓶が盗まれたり、老朽化して傾いてきていたり、時間とともに変わっていくのも廃墟の魅力ですね。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(8,'恵山モンテローザ',6,1,'1990年代後半～','バブル時代に約300億円を投資して作られたレジャー施設。元からあったホテルを買い取り、一帯を巨大テーマパークにする計画だったそうな。豪華な装飾や建造物、金閣寺を模倣した「金龍閣」などもあり、まさにバブルといったものだった。しかし、程なくしてバブルは崩壊し、わずか10年という短い期間で経営を終了した。','函館の湾を一望できる。ちょっと行きたい。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(9,'天神山城',3,3,'1970年代～','天文年間に藤田重利が建築したといわれる。1970年、観光目的として本丸跡に模擬二重櫓が建設されたが、採算が合わずに倒産。以降廃墟化した。','ハリボテの天守閣',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(10,'ミランダ城',3,12,'1991年～','1866年イギリスの建築家によって建築される。1907年、40年もの歳月を超えて完成する。第二次世界大戦中はドイツ軍によって占領されるも、取り壊されることなく終戦を迎える。その後はベルギー国鉄によって孤児院の子供たちの休暇の場として使用される。','2016年に撤去され、今は残っていない。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(11,'後頭湾村',8,12,'2002年～','80年代には、その付近でも最も裕福な村であった。しかし、交通の便が悪く、90年代には別の地域への移住計画が始まる。2002年には正式に廃村となった。現在は隣の村と合併している。','村が自然に還ったような光景。「世界一美しい無人村」と言われる。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(12,'旧陸軍造兵工場',4,11,'昭和30年ごろ～','第一次世界大戦中から毒ガスを開発していた旧陸軍は、昭和初期大久野島で生活していた住民を強制移住させると、毒ガス製造所を開設した。戦時中に毒ガスを秘密裏に製造していたため、島は「毒ガス島」とも呼ばれている。','ウサギが多いため、ウサギ島ともいわれる',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(13,'高子沼グリーンランド',6,2,'1999年～','当時県内最大の遊園地であったが、多くの死者が出たことや施設の老朽化に伴い、閉鎖された。現在は心霊スポットとなっている。','死者が出たことに関してはあくまで噂',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(14,'逢坂医院',7,9,'？','1921建てられた逢坂医院は、当時この地域唯一の医療機関であったため住民から大切にされていた。現在も荒らされることなく保存状態は良好であり、徳島県の近代化遺産の一つとして記載されている。','あったかい気持ちになるね',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(15,'松尾鉱山生活学園',7,2,'1969年～','鉱山町にあった学校。最盛期には1万人を超える人口がいた街も、鉱山の閉鎖とともに廃墟と化し、同時に学校も廃校となった。','もう鉱山町シリーズ見飽きた',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(16,'セントラリア',8,12,'1960年代以降～','19世紀後半から石炭鉱業で栄えた街だったが、1962年代に起こった坑内火災の影響によってゴーストタウン化した。かつては良質な無煙炭の産地として栄えた。火災により、ピーク時には地表温度が70度以上にまで達した。2002年に郵便公社によってZIPコードが抹消された。','サイレントヒルのモデル。現在もまだ燃えている。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(17,'祭壇廃墟',1,11,'1980年代後半～','元々住んでいた老夫婦が海に身を投げ自殺してから廃屋である。それから約10年後に何者かによって祭壇が作られた。幽霊が出るとのうわさ。','意味不明な祭壇怖い。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(18,'プリピャチ遊園地',6,12,'1981年代後半～','チェルノブイリ原子力発電所で働く人々のために作られた町、プリピャチ。様々な施設がそろっており、恵まれた環境であったが、事故により2日にして無人の空間となった。この遊園地は一度も開園することなく廃園になった。','某アニメのエンディングにこの遊園地と思しき絵が登場している。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(19,'マンセル要塞',4,12,'第二次世界大戦終戦後～','第二次世界大戦中にイギリス軍によって建てられた海上の要塞であった。一時は300人程度のイギリス人が駐留していたようだが、終戦とともに放置され廃墟化した。','珍しい海上の廃墟',0,'2019-05-08 00:00:00','2019-05-08 00:00:00'),(20,'広島平和記念碑',7,8,'1945年～','元は広島県物産陳列館として建てられた建造物だった。当時は広島県産業奨励館と呼ばれていた。しかし、開戦後、行政機関・統制組合の事務所となり、1945年8月6日の原爆投下により廃墟となった。現在は原爆ドームと呼ばれている。','二度と悲劇が起こらないようにと「負の世界遺産」と呼ばれている。',0,'2019-05-08 00:00:00','2019-05-08 00:00:00');
/*!40000 ALTER TABLE `ruins_main_kurihara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saizeriya_menu_main_kurimoto`
--

DROP TABLE IF EXISTS `saizeriya_menu_main_kurimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saizeriya_menu_main_kurimoto` (
  `id` int(11) NOT NULL,
  `menu_name` varchar(256) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `price_id` int(11) DEFAULT NULL,
  `teika` int(11) DEFAULT NULL,
  `calories` int(11) DEFAULT NULL,
  `sodium` double DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saizeriya_menu_main_kurimoto`
--

LOCK TABLES `saizeriya_menu_main_kurimoto` WRITE;
/*!40000 ALTER TABLE `saizeriya_menu_main_kurimoto` DISABLE KEYS */;
INSERT INTO `saizeriya_menu_main_kurimoto` VALUES (1,'彩りイタリアンサラダ　レギュラーサイズ',1,2,349,257,1.7,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(2,'彩りイタリアンサラダ　Lサイズ',1,3,499,385,2.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(3,'チキンとブロッコリーのサラダ　レギュラーサイズ',1,2,349,182,1.7,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(4,'チキンとブロッコリーのサラダ　Lサイズ',1,3,499,274,2.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(5,'わかめとオクラのサラダ　レギュラーサイズ',1,2,349,143,3,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(6,'わかめとオクラのサラダ　Lサイズ',1,3,499,214,4.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(7,'小エビのサラダ　レギュラーサイズ',1,2,349,126,1.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(8,'小エビのサラダ　Lサイズ',1,3,499,189,2.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(9,'レンズ豆とスペルト小麦のミネストローネ',1,1,299,244,1.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(10,'冷たいパンプキンスープ',1,1,149,105,0.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(11,'コーンクリームスープ',1,1,149,142,1.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(12,'エスカルゴのオーブン焼き',2,2,399,256,1.6,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(13,'チョリソー（辛味ソーセージ）',2,2,399,393,2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(14,'ムール貝のガーリック焼き',2,2,399,164,1.3,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(15,'野菜ソースのグリルソーセージ',2,2,399,570,3.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(16,'ポップコーンシュリンプ',2,1,299,215,1.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(17,'フリウリ風フリコ',2,1,299,299,0.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(18,'辛味チキン',2,1,299,374,2.2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(19,'削りたてペコリーノチーズ',2,1,100,59,0.6,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(20,'柔らか青豆の温サラダ',2,1,199,213,0.8,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(21,'ほうれん草のソテー',2,1,199,123,1.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(22,'キャベツとアンチョビのソテー',2,1,199,80,1.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(23,'ミニキュウリのミックスピクルス',2,1,199,59,1.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(24,'ガーリックトースト',3,1,189,252,1.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(25,'ミニフィセル',3,1,169,188,1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(26,'プチフォッカ',3,1,139,214,0.8,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(27,'セットプチフォッカ',3,1,79,107,0.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(28,'フォッカチオ',3,1,119,214,0.8,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(29,'シナモンフォッカチオ',3,1,169,246,0.8,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(30,'熟成ミラノサラミ',4,1,299,95,1.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(31,'フレッシュチーズとトマトのサラダ',4,1,299,200,0.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(32,'プロシュート',4,2,399,162,1.8,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(33,'バッファローモッツァレラのピザ',5,3,499,575,2.3,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(34,'マルゲリータピザ',5,2,399,568,2.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(35,'パンチェッタのピザ',5,2,399,646,2.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(36,'野菜ときのこのピザ',5,2,399,610,2.7,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(37,'アンチョビのピザ',5,2,399,543,4.7,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(38,'たっぷりコーンのピザ',5,2,399,669,2.8,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(39,'たらこクリームのピザ',5,2,399,615,3.3,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(40,'アーリオ・オーリオ',6,1,299,457,1.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(41,'ペペロンチーノ',6,1,299,457,1.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(42,'ミートソースボロニア風',6,2,399,552,2.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(43,'半熟卵のミートソースボロニア風',6,3,468,642,2.7,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(44,'タラコソースシシリー風',6,2,399,550,2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(45,'パルマ風スパゲッティ（トマト味）',6,2,399,671,2.6,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(46,'キャベツのペペロンチーノ',6,2,399,587,1.6,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(47,'たっぷり小エビとムール貝のオーロラソース',6,3,699,693,3.2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(48,'イカの墨入りスパゲッティ',6,3,499,579,2.2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(49,'カルボナーラ',6,3,499,737,2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(50,'アラビアータ',6,2,399,601,2.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(51,'エビとズッキーニのトロフィエ',6,2,399,496,2.3,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(52,'ミラノ風ドリア',7,1,299,542,2.7,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(53,'半熟卵のミラノ風ドリア',7,2,368,632,2.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(54,'セットプチフォッカ付きミラノ風ドリア',7,2,378,649,3.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(55,'いろどり野菜のミラノ風ドリア',7,2,399,590,3.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(56,'エビとイカのドリア',7,3,499,624,2.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(57,'ほうれん草のグラタン',7,2,399,521,1.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(58,'シーフードグラタン',7,3,499,537,2.2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(59,'シーフードパエリア',8,3,599,595,3.6,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(60,'エビと野菜のトマトクリームリゾット',8,2,399,311,2.3,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(61,'ハヤシ＆ターメリックライス',8,3,499,676,3.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(62,'半熟卵のハヤシ＆ターメリックライス',8,3,568,766,41,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(63,'ミックスグリル',9,3,599,823,3.8,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(64,'ハンバーグステーキ',9,2,399,514,2.3,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(65,'ディアボラ風ハンバーグ',9,3,499,585,2.6,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(66,'デミグラスソースのハンバーグ',9,3,499,628,3.6,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(67,'イタリアンハンバーグ',9,3,499,633,2.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(68,'焼肉とハンバーグの盛合せ',9,3,599,709,3.4,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(69,'ライス',9,1,169,303,0,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(70,'ラージライス',9,1,219,454,0,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(71,'スモールライス',9,1,119,151,0,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(72,'リブステーキ',9,4,999,621,1.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(73,'若鶏のディアボラ風',9,3,499,541,2.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(74,'柔らかチキンのチーズ焼き',9,3,499,588,2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(75,'パンチェッタと若鶏のディアボラ風',9,3,599,663,2.5,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(76,'ティラミス　クラシコ',10,1,299,229,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(77,'プリンとティラミス　クラシコの盛合せ',10,3,499,445,0.2,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(78,'とろけるティラミス＆コーヒーゼリー',10,2,399,284,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(79,'ブラッドオレンジのパンナコッタ',10,2,399,200,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(80,'アマレーナ',10,1,199,127,0,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(81,'プリンとアマレーナの盛合せ',10,2,399,343,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(82,'トリフアイスクリーム',10,2,369,164,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(83,'ミルクジェラート',10,1,199,100,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(84,'シチリア産レモンのソルベ',10,1,199,127,0,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(85,'イタリアンプリン',10,1,249,216,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(86,'コーヒーゼリー（ミルクアイスのせ）',10,1,299,162,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(87,'チョコレートケーキ',10,1,299,166,0.1,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(88,'ミルクアイスのせシナモンフォッカチオ',10,2,319,346,0.9,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(89,'セットドリンクバー',11,1,190,NULL,NULL,'0','2019-08-09 00:00:00','2019-08-09 00:00:00'),(90,'単品ドリンクバー',11,1,280,NULL,NULL,'0','2019-08-09 00:00:00','2019-08-09 00:00:00');
/*!40000 ALTER TABLE `saizeriya_menu_main_kurimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series_okugawa`
--

DROP TABLE IF EXISTS `series_okugawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `series_okugawa` (
  `id` int(11) NOT NULL,
  `series_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series_okugawa`
--

LOCK TABLES `series_okugawa` WRITE;
/*!40000 ALTER TABLE `series_okugawa` DISABLE KEYS */;
INSERT INTO `series_okugawa` VALUES (0,NULL,'0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(1,'遊戯王デュエルモンスターズ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(2,'遊戯王デュエルモンスターズGX','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(3,'遊戯王5D\'s','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(4,'遊戯王ZEXAL','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(5,'遊戯王ARC-V','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(6,'遊戯王VRAINS','0','2019-06-10 12:00:00','2019-06-10 12:00:00');
/*!40000 ALTER TABLE `series_okugawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sex_hayashi`
--

DROP TABLE IF EXISTS `sex_hayashi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sex_hayashi` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sex_hayashi`
--

LOCK TABLES `sex_hayashi` WRITE;
/*!40000 ALTER TABLE `sex_hayashi` DISABLE KEYS */;
INSERT INTO `sex_hayashi` VALUES (0,NULL,'0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(1,'男','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(2,'女','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(3,'不明','0','2019-05-29 12:00:00','2019-05-29 12:00:00');
/*!40000 ALTER TABLE `sex_hayashi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sex_it`
--

DROP TABLE IF EXISTS `sex_it`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sex_it` (
  `id` int(11) DEFAULT NULL,
  `sex` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sex_it`
--

LOCK TABLES `sex_it` WRITE;
/*!40000 ALTER TABLE `sex_it` DISABLE KEYS */;
/*!40000 ALTER TABLE `sex_it` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sex_ito`
--

LOCK TABLES `sex_ito` WRITE;
/*!40000 ALTER TABLE `sex_ito` DISABLE KEYS */;
INSERT INTO `sex_ito` VALUES (0,NULL,'0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'男性','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'女性','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'男女','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `sex_ito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songwriter_waki`
--

DROP TABLE IF EXISTS `songwriter_waki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `songwriter_waki` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `songwriter` varchar(20) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songwriter_waki`
--

LOCK TABLES `songwriter_waki` WRITE;
/*!40000 ALTER TABLE `songwriter_waki` DISABLE KEYS */;
INSERT INTO `songwriter_waki` VALUES (0,NULL,'0','2019-12-05','2019-12-05'),(1,'BOOWY','0','2019-12-04','2019-12-04'),(2,'氷室京介','0','2019-12-04','2019-12-04'),(3,'氷室狂介','0','2019-12-04','2019-12-04'),(4,'氷室狂介 高橋信 松井恒松','0','2019-12-04','2019-12-04'),(5,'深沢和明','0','2019-12-04','2019-12-04'),(6,'布袋寅泰 松井五郎','0','2019-12-04','2019-12-04'),(7,'氷室京介 松井五郎','0','2019-12-04','2019-12-04'),(8,'高橋まこと','0','2019-12-04','2019-12-04');
/*!40000 ALTER TABLE `songwriter_waki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `source_nagatake`
--

DROP TABLE IF EXISTS `source_nagatake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `source_nagatake` (
  `source_id` int(11) NOT NULL AUTO_INCREMENT,
  `source` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `source_nagatake`
--

LOCK TABLES `source_nagatake` WRITE;
/*!40000 ALTER TABLE `source_nagatake` DISABLE KEYS */;
INSERT INTO `source_nagatake` VALUES (0,NULL,NULL,'2019-09-18 00:00:00','2019-09-18 00:00:00'),(1,'アニメオリジナル','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(2,'週刊少年ジャンプ','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(3,'まんがタイムきらら','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(4,'xBox360','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(5,'電撃文庫','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(6,'KADOKAWA','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(7,'PCゲーム','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(8,'ヤングガンガン','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(9,'GA文庫','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(10,'ヤングアニマル','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(11,'講談社BOX','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(12,'KAエスマ文庫','0','2019-09-27 15:02:00','2019-09-27 15:03:00');
/*!40000 ALTER TABLE `source_nagatake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spa_main_okabe`
--

DROP TABLE IF EXISTS `spa_main_okabe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spa_main_okabe` (
  `id` int(3) NOT NULL,
  `spa_name` varchar(30) DEFAULT NULL,
  `area_id` int(3) DEFAULT NULL,
  `quality_id` int(3) DEFAULT NULL,
  `features` varchar(50) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spa_main_okabe`
--

LOCK TABLES `spa_main_okabe` WRITE;
/*!40000 ALTER TABLE `spa_main_okabe` DISABLE KEYS */;
INSERT INTO `spa_main_okabe` VALUES (1,'草津温泉',10,9,'東の横綱。温泉の自然湧出量は日本一。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(2,'別府八湯温泉',44,11,'繁華街に広がる交通アクセスの良い温泉地。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(3,'下呂温泉',21,1,'「日本三名泉のひとつ」と称された天下の名泉。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(4,'指宿温泉',46,4,'指宿温泉、摺ヶ浜温泉などの温泉群からなり、県内有数の観光地。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(5,'道後温泉',38,1,'日本三古湯のひとつ。夏目漱石の小説「坊ちゃん」にも登場した。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(6,'有馬温泉',28,6,'日本書紀にも記されている日本三大古湯に数えられる有名な温泉地。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(7,'登別温泉',1,8,'泉源が多い温泉地。噴煙を上げている地獄谷。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(8,'和倉温泉',17,4,'能登半島に広がる和倉温泉は、豊富な塩分を含む「海の温泉」。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(9,'由布院温泉',44,1,'由布岳の山麓にある人気温泉地。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(10,'城崎温泉',28,4,'1400年以上の歴史をもつ温泉。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(11,'黒川温泉',43,8,'「疵湯(きずゆ)」とよばれ、切り傷に特効があるとされた湯治場。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(12,'飛騨高山温泉',21,8,'ナトリウム・塩化物・炭酸水素塩素などの泉質を持つ温泉郷。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(13,'伊香保温泉',10,5,'湯治場として名高く、病気の治療や健康増進のために訪れる人も多い。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(14,'山代温泉',17,11,'ふたつの総湯を中心とした街並み「湯の曲輪(ゆのがわ)」が特徴。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(15,'玉造温泉',32,5,'2016年の温泉総選挙で、最高賞とされる環境大臣賞を獲得。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(16,'月岡温泉',15,4,'鮮やかなエメラルドグリーンの温泉は全国でも屈指の美肌の湯。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(17,'箱根湯本温泉',14,1,'箱根の玄関口と呼ばれ、箱根温泉郷のなかでも一番古い温泉地。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(18,'鳴子温泉',4,11,'多彩な泉質を楽しめ、5ヶ所の温泉地からなる一大温泉郷。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(19,'塩原温泉',9,11,'古くから文人墨客に愛され、尾崎紅葉「金色夜叉」の舞台にもなった温泉郷。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(20,'山中温泉',17,5,'松尾芭蕉も称賛した日本三大名湯のひとつ。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(21,'鬼怒川温泉',9,1,'関東を代表する箱根と並ぶ、 東京の奥座敷と呼ばれている。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(22,'乳頭温泉郷',5,11,'乳頭山麓に点在する七湯を総称し、十種類以上の源泉がある。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(23,'蔵王温泉',6,9,'湯煙と硫黄の香りに包まれる温泉。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(24,'奥飛騨温泉郷',21,11,'5つの温泉地で形成される、露天風呂天国。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(25,'あわら温泉',18,4,'「関西の奥座敷」として発展し、多くの文人墨客、天皇陛下にまで愛される温泉地。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(26,'銀山温泉',6,8,'大正末期から昭和初期に建てられた洋風木造多層の旅館が並ぶ。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(27,'秋保温泉',4,4,'「名取の御湯」と称され「日本三御湯」のひとつとして全国的にも知られる。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(28,'熱海温泉',22,4,'平均温度は約63度と、全国屈指の高温泉リゾート。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(29,'雲仙温泉',42,6,'硫黄を含んだ強い酸性泉で温泉療法が盛んなヨーロッパでも見られない温泉。','0','2019-05-16 15:24:00','2019-05-16 15:24:00'),(30,'板室温泉',9,1,'那須連山の西端、湯川に沿った板室渓谷に囲まれた静かな療養温泉地。','0','2019-05-16 15:24:00','2019-05-16 15:24:00');
/*!40000 ALTER TABLE `spa_main_okabe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studio_nagatake`
--

DROP TABLE IF EXISTS `studio_nagatake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studio_nagatake` (
  `studio_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`studio_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studio_nagatake`
--

LOCK TABLES `studio_nagatake` WRITE;
/*!40000 ALTER TABLE `studio_nagatake` DISABLE KEYS */;
INSERT INTO `studio_nagatake` VALUES (0,NULL,NULL,'2019-09-25 14:11:00','2019-09-25 14:12:00'),(1,'東映アニメーション','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(2,'A-1Pictures','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(3,'J.C.STAFF','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(4,'動画工房','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(5,'ボンズ','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(6,'P.A.WORKS','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(7,'WHITEFOX','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(8,'シャフト','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(9,'SUNRISE','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(10,'京都アニメーション','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(11,'ufotable','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(12,'スタジオ雲雀','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(13,'NUT','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(14,'SILVER LINK.','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(15,'サテライト','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(16,'Deeｎ','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(17,'XEBEC','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(18,'アクタス','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(19,'葦プロダクション','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(20,'エイトビット','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(21,'キングレコード','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(22,'GONZO','0','2019-09-13 00:00:00','2019-09-13 00:00:00');
/*!40000 ALTER TABLE `studio_nagatake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style_kawada`
--

DROP TABLE IF EXISTS `style_kawada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `style_kawada` (
  `style_id` int(11) NOT NULL,
  `style` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`style_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style_kawada`
--

LOCK TABLES `style_kawada` WRITE;
/*!40000 ALTER TABLE `style_kawada` DISABLE KEYS */;
INSERT INTO `style_kawada` VALUES (0,NULL,'0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(1,'左回り多め','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(2,'モッシュ多め','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(3,'おとなしめの曲','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(4,'みんなでワイワイ楽しむ','0','2019-12-04 14:14:00','2019-12-04 14:14:00'),(5,'サークルはあまり発生しない','0','2019-12-04 14:14:00','2019-12-04 14:14:00');
/*!40000 ALTER TABLE `style_kawada` ENABLE KEYS */;
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
INSERT INTO `team_color_matsuda` VALUES (0,NULL,'0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(1,'赤','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'ピンク','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'オレンジ','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'黄色','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'黄緑','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'水色','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'青','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'緑','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'白','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'黒','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'紫','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
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
INSERT INTO `team_main_matsuda` VALUES (1,'サンフレッチェ広島',34,1,'佐々木翔','3バックの要','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(2,'柏レイソル',12,4,'中村航輔','鉄壁','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(3,'FC東京',13,7,'室谷成','献身的サイドバック','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(4,'浦和レッズ',11,1,'興梠慎三','ゴール前の仕事人','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(5,'ガンバ大阪',27,7,'遠藤保仁','パスコース360度','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(6,'セレッソ大阪',27,2,'柿谷曜一朗','ミスターユーティリティ','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(7,'ベガルタ仙台',4,3,'赤崎秀平','ベガルタの切り札','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(8,'横浜FC',14,6,'中村俊輔','レジェンドレフティー','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(9,'名古屋グランパス',23,3,'相馬勇紀','サラブレットプレイヤー','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(10,'ヴィッセル神戸',28,9,'アンドレス　イニエスタ','THE SOCCER','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(11,'川崎フロンターレ',14,6,'家長昭博','技巧派レフティー','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(12,'サガン鳥栖',31,6,'高橋秀人','ゲームメイカー','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(13,'湘南ベルマーレ',14,5,'山田直輝','返ってきた天才','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(14,'横浜F・マリノス',14,7,'仲川輝人','ハマのスピードスター','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(15,'大分トリニータ',44,6,'岩田智輝','トリニータの顔','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(16,'北海道コンサドーレ札幌',1,1,'チャナティップ','タイのメッシ','1','2020-03-25 00:00:00','2020-03-25 00:00:00'),(17,'清水エスパルス',22,3,'立田悠悟','復権の星','0','2020-03-25 00:00:00','2020-03-25 00:00:00'),(18,'鹿島アントラーズ',8,1,'三笠健斗','次世代大型ボランチ','0','2020-03-25 00:00:00','2020-03-25 00:00:00');
/*!40000 ALTER TABLE `team_main_matsuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_main_nagashima`
--

DROP TABLE IF EXISTS `team_main_nagashima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_main_nagashima` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `region_id` int(11) DEFAULT NULL,
  `coach_id` int(11) DEFAULT NULL,
  `founded_year` int(4) DEFAULT NULL COMMENT 'yyyy',
  `titles` int(2) DEFAULT NULL,
  `player` varchar(50) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_main_nagashima`
--

LOCK TABLES `team_main_nagashima` WRITE;
/*!40000 ALTER TABLE `team_main_nagashima` DISABLE KEYS */;
INSERT INTO `team_main_nagashima` VALUES (1,'鹿島アントラーズ',2,1,1991,20,'上田綺世','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(2,'横浜Fマリノス',2,4,1991,7,'中川輝人','0','2019-12-04 00:00:00','2019-12-12 17:33:08'),(3,'FC東京',2,1,1999,3,'橋本挙人','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(4,'コンサドーレ札幌',1,6,1996,0,'鈴木武蔵','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(5,'川崎フロンターレ',2,1,1997,3,'中村憲剛','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(6,'ベガルタ仙台',1,1,1996,0,'長沢駿','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(7,'松本山雅FC',1,1,2010,NULL,'田中隼磨','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(8,'ジュビロ磐田',3,1,1992,7,'ジェイ','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(9,'名古屋グランパス',3,1,1991,3,'ジョー','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(10,'清水エスパルス',3,4,1991,2,'金子翔太','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(11,'湘南ベルマーレ',2,5,1992,2,'梅崎司','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(12,'ヴィッセル神戸',4,3,1995,0,'イニエスタ','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(13,'ガンバ大阪',4,1,1991,9,'小野瀬康介','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(14,'セレッソ大阪',4,3,1993,2,'柿谷曜一朗','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(15,'サガン鳥栖',6,3,1999,0,'クエンカ','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(16,'浦和レッズ',2,1,1991,8,'興梠慎三','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(17,'サンフレッチェ広島',5,1,1991,3,'大迫敬介','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(18,'大分トリニータ',6,1,1999,1,'オナイウ阿道','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(19,'柏レイソル',2,2,1992,4,'オルンガ','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(20,'横浜FC',2,2,2001,0,'中村俊輔','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(21,'大宮アルディージャ',2,1,1999,0,'大前元紀','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(22,'徳島ヴォルティス',5,3,2005,0,'河田篤秀','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(23,'ヴァンフォーレ甲府',3,1,1999,0,'ピーターウタカ','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(24,'モンテディオ山形',1,1,1999,0,'櫛引政敏','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(25,'水戸ホリーホック',2,1,2000,0,'小川航基','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(26,'京都サンガF.C.',4,1,1994,1,'小屋松知哉','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(27,'ファジアーノ岡山',5,1,2007,0,'イヨンジェ','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(28,'アルビレックス新潟',3,1,1999,0,'レオナルド','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(29,'ツエーゲン金沢',3,1,2013,0,'垣田祐暉','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(30,'V・ファーレン長崎',6,1,2009,0,'畑潤基','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(31,'東京ヴェルディ',2,7,1991,7,'小池純輝','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(32,'FC琉球',6,1,2013,0,'小野伸二','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(33,'レノファ山口FC',5,1,2013,0,'工藤壮人','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(34,'アビスパ福岡',6,8,1995,0,'城後寿','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(35,'ジェフユナイテッド千葉',2,9,1991,2,'佐藤寿人','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(36,'FC町田ゼルビア',2,1,2009,0,'ロメロフランク','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(37,'愛媛FC  ',5,1,2006,0,'神谷優太','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(38,'栃木SC',2,1,2007,0,'大黒将志','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(39,'鹿児島ユナイッテッドFC',6,10,2015,0,'ハンヨンテ','0','2019-12-04 00:00:00','2019-12-04 00:00:00'),(40,'FC岐阜',3,1,2007,0,'前田遼一','0','2019-12-04 00:00:00','2019-12-04 00:00:00');
/*!40000 ALTER TABLE `team_main_nagashima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_shiono`
--

DROP TABLE IF EXISTS `team_shiono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_shiono` (
  `id` int(11) DEFAULT NULL,
  `team` varchar(30) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_shiono`
--

LOCK TABLES `team_shiono` WRITE;
/*!40000 ALTER TABLE `team_shiono` DISABLE KEYS */;
INSERT INTO `team_shiono` VALUES (1,'マンチェスター・シティ','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(2,'バルセロナ','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(3,'パリサンジェルマン','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(4,'ユベントス','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(5,'トットナム','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(6,'リバプール','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(7,'レアル・マドリード','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(8,'マンチェスター・ユナイテッド','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(9,'サガン鳥栖','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(10,'バイエルン・ミュンヘン','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(11,'アーセナル','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(12,'ドルトムント','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(13,'アトレティコ・マドリード','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(14,'チェルシー','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(15,'ナポリ','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(16,'ガラタサライ','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(17,'フランクフルト','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(18,'ベシクタシュ','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(19,'メルボルン・ビクトリー','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(20,'ブレーメン','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(0,'','0','2019-05-17 15:05:00','2019-05-17 15:05:00');
/*!40000 ALTER TABLE `team_shiono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenshu_minami`
--

DROP TABLE IF EXISTS `tenshu_minami`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenshu_minami` (
  `id` int(10) NOT NULL,
  `tenshu` varchar(10) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenshu_minami`
--

LOCK TABLES `tenshu_minami` WRITE;
/*!40000 ALTER TABLE `tenshu_minami` DISABLE KEYS */;
INSERT INTO `tenshu_minami` VALUES (0,NULL,'0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(1,'あり','0','2019-05-16 00:00:00','2019-05-16 00:00:00'),(2,'なし','0','2019-05-16 00:00:00','2019-05-16 00:00:00');
/*!40000 ALTER TABLE `tenshu_minami` ENABLE KEYS */;
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
INSERT INTO `triathlon_main_mori` VALUES (1,'RS9s',1,1,800000,'/TriathlonMori/001.jpg','0','2020-03-11 00:00:00','2020-03-23 15:02:09'),(2,'RT9',2,1,410000,'/TriathlonMori/002.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(3,'GALLIUM PRO',1,2,380000,'/TriathlonMori/003.jpg','1','2020-03-11 00:00:00','2020-03-11 00:00:00'),(4,'E-119 TRI+',2,2,576000,'/TriathlonMori/004.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(5,'OLTRE XR4',1,3,1780000,'/TriathlonMori/005.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(6,'AQUILA CV',2,3,900000,'/TriathlonMori/006.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(7,'G8 PRO',1,4,748000,'/TriathlonMori/007.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(8,'AEROLIGHT',2,4,1050000,'/TriathlonMori/008.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(9,'Timemachine Road 01',1,5,880000,'/TriathlonMori/009.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(10,'Timemachine 01',2,5,870000,'/TriathlonMori/010.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(11,'VIDE pro CT-RTV',1,6,500000,'/TriathlonMori/011.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(12,'SWOOP CT-TT',2,6,418000,'/TriathlonMori/012.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(13,'Ultomate CF Evo',1,7,899000,'/TriathlonMori/013.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(14,'Speedmax CF SLX LTD',2,7,1109000,'/TriathlonMori/014.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(15,'S5',1,8,1580000,'/TriathlonMori/015.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(16,'P5X',2,8,2280000,'/TriathlonMori/016.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(17,'RB1K \"THE ONE\"',1,9,720000,'/TriathlonMori/017.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(18,'NKTT',2,9,990000,'/TriathlonMori/018.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(19,'C64',1,10,738000,'/TriathlonMori/019.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(20,'K.one',2,10,620000,'/TriathlonMori/020.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(21,'LITENING C:68X SLT',1,11,1176000,'/TriathlonMori/021.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(22,'AERIUM C:68 SLT',2,11,1387000,'/TriathlonMori/022.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(23,'TRILLIANT',2,12,470000,'/TriathlonMori/023.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(24,'CARBONADO',2,12,370000,'/TriathlonMori/024.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(25,'525',1,13,466000,'/TriathlonMori/025.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(26,'LUGANO68',2,13,278000,'/TriathlonMori/026.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(27,'O2 V.A.M',1,14,590000,'/TriathlonMori/027.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(28,'SLICK',2,14,680000,'/TriathlonMori/028.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(29,'FR FRD',1,15,1980000,'/TriathlonMori/029.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(30,'IA FRD',2,15,2480000,'/TriathlonMori/030.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(31,'TRANSONIC 1.1',1,16,340000,'/TriathlonMori/031.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(32,'NORCOM STRAIGHT 1.1',2,16,290000,'/TriathlonMori/032.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(33,'PROPEL ADVANCED SL',1,17,1300000,'/TriathlonMori/033.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(34,'TRINITY ADVANCE PRO 1',2,17,690000,'/TriathlonMori/034.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(35,'STRAUSS PRO',1,18,248000,'/TriathlonMori/035.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(36,'STRAUSS TRI',2,18,199000,'/TriathlonMori/036.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(37,'KHAN',1,19,365000,'/TriathlonMori/037.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(38,'KT05',2,19,460000,'/TriathlonMori/038.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(39,'SCULTURA 10K-E',1,20,1200000,'/TriathlonMori/039.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(40,'TIME WARP TRI 10K-E',2,20,1350000,'/TriathlonMori/040.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(41,'DOGMA F12',1,21,1300000,'/TriathlonMori/041.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(42,'BOLIDE TR+',2,21,1570000,'/TriathlonMori/042.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(43,'HELIUM SLX',1,22,365000,'/TriathlonMori/043.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(44,'DEAN',2,22,323000,'/TriathlonMori/044.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(45,'FOIL PREMIUM',1,23,1118000,'/TriathlonMori/045.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(46,'PLASMA RC',2,23,1190000,'/TriathlonMori/046.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(47,'S-Works VENGE',1,24,1375000,'/TriathlonMori/047.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(48,'S-Works Shiv',2,24,1404000,'/TriathlonMori/048.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(49,'Madone SLR 9',1,25,1281000,'/TriathlonMori/049.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(50,'Speed Concept',2,25,510000,'/TriathlonMori/050.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(51,'ZERO SLR',1,26,590000,'/TriathlonMori/051.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(52,'TURBINE',2,26,650000,'/TriathlonMori/052.jpg','0','2020-03-11 00:00:00','2020-03-11 00:00:00'),(53,'こじろう',0,0,100,'/TriathlonMori/20200323150234372.jpg','0','2020-03-19 11:02:07','2020-03-23 15:02:34'),(54,'もも',1,8,9999999,NULL,'1','2020-03-23 09:12:05','2020-03-23 09:12:05'),(55,'もも',1,10,1,'/TriathlonMori/20200323150336788.jpg','0','2020-03-23 15:03:36','2020-03-23 15:03:36');
/*!40000 ALTER TABLE `triathlon_main_mori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_hayashi`
--

DROP TABLE IF EXISTS `type_hayashi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_hayashi` (
  `id` int(11) NOT NULL,
  `type` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_hayashi`
--

LOCK TABLES `type_hayashi` WRITE;
/*!40000 ALTER TABLE `type_hayashi` DISABLE KEYS */;
INSERT INTO `type_hayashi` VALUES (0,NULL,'0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(1,'人間','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(2,'機械','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(3,'AI','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(4,'動物','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(5,'植物','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(6,'異星人','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(7,'神','0','2019-05-29 12:00:00','2019-05-29 12:00:00'),(8,'その他','0','2019-05-29 12:00:00','2019-05-29 12:00:00');
/*!40000 ALTER TABLE `type_hayashi` ENABLE KEYS */;
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
-- Table structure for table `type_sakuma`
--

DROP TABLE IF EXISTS `type_sakuma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_sakuma` (
  `id` int(1) NOT NULL,
  `type_name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_sakuma`
--

LOCK TABLES `type_sakuma` WRITE;
/*!40000 ALTER TABLE `type_sakuma` DISABLE KEYS */;
INSERT INTO `type_sakuma` VALUES (0,NULL,NULL,'2019-07-08 11:00:00','2019-07-08 11:00:00'),(1,'アサシン','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(2,'サポート','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(3,'タンク','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(4,'ハンター','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(5,'ファイター','0','2019-07-08 11:00:00','2019-07-08 11:00:00'),(6,'メイジ','0','2019-07-08 11:00:00','2019-07-08 11:00:00');
/*!40000 ALTER TABLE `type_sakuma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_shintaku`
--

DROP TABLE IF EXISTS `type_shintaku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_shintaku` (
  `id` int(11) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_shintaku`
--

LOCK TABLES `type_shintaku` WRITE;
/*!40000 ALTER TABLE `type_shintaku` DISABLE KEYS */;
INSERT INTO `type_shintaku` VALUES (0,NULL,'0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(1,'キュート','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(2,'クール','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(3,'パッション','0','2019-06-10 12:00:00','2019-06-10 12:00:00');
/*!40000 ALTER TABLE `type_shintaku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_uriu`
--

DROP TABLE IF EXISTS `type_uriu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_uriu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_uriu`
--

LOCK TABLES `type_uriu` WRITE;
/*!40000 ALTER TABLE `type_uriu` DISABLE KEYS */;
INSERT INTO `type_uriu` VALUES (0,NULL,'0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(1,'ボク','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(2,'おいら','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(3,'オレ','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(4,'アタイ','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(5,'わたし','0','2019-08-07 00:00:00','2019-08-07 00:00:00'),(6,'あたし','0','2019-08-07 00:00:00','2019-08-07 00:00:00');
/*!40000 ALTER TABLE `type_uriu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_shintaku`
--

DROP TABLE IF EXISTS `unit_shintaku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit_shintaku` (
  `id` int(11) NOT NULL,
  `unit` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_shintaku`
--

LOCK TABLES `unit_shintaku` WRITE;
/*!40000 ALTER TABLE `unit_shintaku` DISABLE KEYS */;
INSERT INTO `unit_shintaku` VALUES (0,NULL,'0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(1,'ニュージェネレーション','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(2,'可惜夜月','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(3,'セクシーギルティ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(4,'ニューウェーブ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(5,'羽衣小町','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(6,'山紫水明','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(7,'レイジー・レイジー','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(8,'ロック・ザ・ビート','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(9,'CANDY ISLAND','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(10,'individuals','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(11,'イエローリリー','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(12,'サイバーグラス','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(13,'セクシーギャルズ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(14,'チアフルボンバーズ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(15,'ハートウォーマー','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(16,'ミステリアスアイズ','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(17,'しゅがしゅが☆み～ん','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(18,'ダークイルミネイト','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(19,'ガールズ・パワー','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(20,'VelvetRose','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(21,'miroir','0','2019-06-10 12:00:00','2019-06-10 12:00:00'),(22,'L.M.B.G','0','2019-06-10 12:00:00','2019-06-10 12:00:00');
/*!40000 ALTER TABLE `unit_shintaku` ENABLE KEYS */;
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
-- Table structure for table `voiceactor_nagatake`
--

DROP TABLE IF EXISTS `voiceactor_nagatake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voiceactor_nagatake` (
  `voiceactor_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`voiceactor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voiceactor_nagatake`
--

LOCK TABLES `voiceactor_nagatake` WRITE;
/*!40000 ALTER TABLE `voiceactor_nagatake` DISABLE KEYS */;
INSERT INTO `voiceactor_nagatake` VALUES (0,NULL,NULL,'2019-09-18 00:00:00','2019-09-18 00:00:00'),(1,'野沢雅子','0','2019-09-18 00:00:00','2019-09-18 00:00:00'),(2,'田中真弓','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(3,'松岡禎丞','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(4,'本多真梨子','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(5,'水瀬いのり','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(6,'悠木碧','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(7,'中村悠一','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(8,'杉山紀彰','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(9,'村上虹郎','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(10,'福山潤','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(11,'小岩井ことり','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(12,'山下大輝','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(13,'阿部敦','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(14,'内山昂輝','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(15,'高田憂希','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(16,'小林裕介','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(17,'平野綾','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(18,'福島潤','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(19,'阿澄佳奈','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(20,'渕上舞','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(21,'林延年','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(22,'櫻井孝宏','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(23,'宮野真守','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(24,'木野日菜','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(25,'江口拓也','0','2019-09-13 00:00:00','2019-09-13 00:00:00'),(26,'神谷浩史','0','2019-09-13 00:00:00','2019-09-13 00:00:00');
/*!40000 ALTER TABLE `voiceactor_nagatake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wood_fujimoto`
--

DROP TABLE IF EXISTS `wood_fujimoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wood_fujimoto` (
  `id` int(11) DEFAULT NULL,
  `wood` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wood_fujimoto`
--

LOCK TABLES `wood_fujimoto` WRITE;
/*!40000 ALTER TABLE `wood_fujimoto` DISABLE KEYS */;
INSERT INTO `wood_fujimoto` VALUES (0,'','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(1,'スプルース','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(2,'マホガニー','0','2019-05-20 10:27:00','2019-05-20 10:27:00'),(3,'その他','0','2019-05-20 10:27:00','2019-05-20 10:27:00');
/*!40000 ALTER TABLE `wood_fujimoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writer_okudaira`
--

DROP TABLE IF EXISTS `writer_okudaira`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `writer_okudaira` (
  `id` int(11) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `del_flg` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writer_okudaira`
--

LOCK TABLES `writer_okudaira` WRITE;
/*!40000 ALTER TABLE `writer_okudaira` DISABLE KEYS */;
INSERT INTO `writer_okudaira` VALUES (1,'太宰治','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(2,'谷崎潤一郎','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(3,'泉鏡花','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(4,'梶井基次郎','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(5,'綾辻行人','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(6,'京極夏彦','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(7,'今村昌弘','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(8,'我孫子武丸','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(9,'小野不由美','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(10,'貴志祐介','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(11,'百田尚樹','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(12,'池井戸潤','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(13,'小松左京','0','2019-11-01 00:00:00','2019-11-01 00:00:00'),(0,'','0','2019-11-01 00:00:00','2019-11-01 00:00:00');
/*!40000 ALTER TABLE `writer_okudaira` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writer_uchiyama`
--

DROP TABLE IF EXISTS `writer_uchiyama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `writer_uchiyama` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flg` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writer_uchiyama`
--

LOCK TABLES `writer_uchiyama` WRITE;
/*!40000 ALTER TABLE `writer_uchiyama` DISABLE KEYS */;
INSERT INTO `writer_uchiyama` VALUES (0,NULL,NULL,'0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(1,'イワン・ツルゲーネフ','ロシア','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(2,'レフ・ニコラエヴィチ・トルストイ','ロシア','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(3,'ポール・オースター','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(4,'チャールズ・ブコウスキー','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(5,'ブライアン・エヴンソン','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(6,'レイモンド・カーヴァー','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(7,'柴田元幸','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(8,'グレッグ・イーガン','オーストラリア','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(9,'円城塔','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(10,'夢野久作','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(11,'アンソニー・バージェス','イギリス','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(12,'伊藤計劃','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(13,'岸政彦','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(14,'北大路魯山人','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(15,'ジェローム・ディヴィッド・サリンジャー','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(16,'カレン・ラッセル','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(17,'ダグラス・アダムズ','イギリス','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(18,'月村了衛','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(19,'ギ・ド・モーパッサン','フランス','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(20,'トマス・モア','イングランド王国','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(21,'ハーバート・ジョージ・ウェルズ','イギリス','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(22,'フランツ・カフカ','オーストリア','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(23,'ニコライ・ゴーゴリ','ロシア','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(24,'ケン・リュウ','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(25,'イタロ・カルヴィーノ','イタリア','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(26,'リチャード・ブローディガン','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(27,'カーソン・マッカラーズ','アメリカ','0','2019-09-17 00:00:00','2019-09-17 00:00:00'),(28,'太宰治','日本','0','2019-09-17 00:00:00','2019-09-17 00:00:00');
/*!40000 ALTER TABLE `writer_uchiyama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yugioh_main_okugawa`
--

DROP TABLE IF EXISTS `yugioh_main_okugawa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yugioh_main_okugawa` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `series_id` int(11) NOT NULL,
  `deck_id` int(11) DEFAULT NULL,
  `summons` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yugioh_main_okugawa`
--

LOCK TABLES `yugioh_main_okugawa` WRITE;
/*!40000 ALTER TABLE `yugioh_main_okugawa` DISABLE KEYS */;
INSERT INTO `yugioh_main_okugawa` VALUES (1,'武藤 遊戯',1,6,'アドバンス','王様','0','2019-06-10 12:00:00','2019-06-18 13:00:22'),(2,'海馬 瀬人',1,5,'アドバンス','かっこいい。社長。','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(3,'城之内 克也',1,3,'アドバンス','凡骨デュエリスト','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(4,'真崎 杏子',1,NULL,NULL,'ネタバレ女','0','2019-06-10 12:00:00','2019-06-18 11:53:39'),(5,'本田 ヒロト',1,NULL,NULL,'空気','0','2019-06-10 12:00:00','2019-06-18 11:53:45'),(6,'獏良 了',1,6,'アドバンス','闇サトシ','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(7,'御伽 龍児',1,3,'アドバンス','ダイスロール','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(8,'孔雀 舞',1,4,'アドバンス','大人の女性','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(9,'インゼクター羽蛾',1,3,'アドバンス','虫野郎','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(10,'ダイナソー竜崎',1,3,'アドバンス','エースぱくられ男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(11,'梶木 漁太',1,2,'アドバンス','漁師','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(12,'キース・ハワード',1,6,'アドバンス','トムに負ける男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(13,'ペガサス・J・クロフォード',1,6,'儀式','ﾃﾞｰｽ','0','2019-06-10 12:00:00','2019-06-18 11:38:25'),(14,'マリク・イシュタール',1,6,'アドバンス','ｦｰ','0','2019-06-10 12:00:00','2019-06-18 11:38:39'),(15,'遊城 十代',2,5,'融合','闇落ち主人公','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(16,'万城目 準',2,6,'融合','万城目サンダー','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(17,'天上院 明日香',2,5,'儀式','美','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(18,'丸藤 翔',2,3,'融合','弟','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(19,'三沢 大地',2,2,'アドバンス','公式に空気扱いされる男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(20,'ティラノ剣山',2,3,'アドバンス','語尾ザウルス','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(21,'丸藤 亮',2,5,'融合','かっこいい。リスペクト。','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(22,'エド・フェニックス',2,6,'融合','オサレ','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(23,'天上院 吹雪',2,6,'アドバンス','闇が深い','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(24,'クロノス・デ・メディチ',2,3,'融合','愛され教諭','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(25,'斎王 琢磨',2,5,'アドバンス','子安','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(26,'ヨハン・アンデルセン',2,5,'アドバンス','会話のドッジボール','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(27,'オースチン・オブライエン',2,1,'アドバンス','マリオ','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(28,'ジム・クロコダイル・クック',2,3,'融合','ワニ男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(29,'アモン・ガラム',2,2,'アドバンス','マッスル1','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(30,'プロフェッサー・コブラ',2,6,'アドバンス','マッスル2','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(31,'カイバーマン',2,5,'融合','粉砕玉砕大喝采','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(32,'不動 遊星',3,4,'シンクロ','個人的歴代最高主人公','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(33,'ジャック・アトラス',3,6,'シンクロ','キング','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(34,'クロウ・ホーガン',3,6,'シンクロ','インチキ男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(35,'十六夜 アキ',3,1,'シンクロ','ドS','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(36,'龍亞',3,3,'シンクロ','兄貴','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(37,'龍可',3,5,'シンクロ','他力本願うなぎ','0','2019-06-10 12:00:00','2019-06-18 11:20:43'),(38,'レクス・ゴドウィン',3,6,'アドバンス','筋肉ダルマ','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(39,'イェーガー',3,6,'アドバンス','道化','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(40,'牛尾 哲',3,3,'シンクロ','頼りになる','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(41,'ルドガー・ゴドウィン',3,6,'アドバンス','死のダンス','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(42,'ディマク',3,6,'アドバンス','サル','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(43,'鬼柳 京介',3,6,'シンクロ','満足','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(44,'カーリー渚',3,6,'アドバンス','個人的にヒロイン','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(45,'ミスティ・ローラ',3,6,'アドバンス','ブラコン','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(46,'ボマー',3,6,'アドバンス','巨人','0','2019-06-10 12:00:00','2019-06-18 11:26:31'),(47,'ドラガン',3,3,'シンクロ','脳筋','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(48,'ブレイブ',3,6,'シンクロ','子供好き','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(49,'ハラルド',3,5,'シンクロ','まるで意味が分からんぞ','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(50,'シェリー・ルブラン',3,4,'シンクロ','カード出して','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(51,'ブルーノ',3,5,'シンクロ','つらい','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(52,'アポリア',3,5,'アドバンス','手のひら','0','2019-06-10 12:00:00','2019-06-18 13:01:46'),(53,'パラドックス',3,6,'アドバンス','田村','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(54,'ゾーン',3,5,'アドバンス','未来人','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(55,'九十九 遊馬',4,5,'エクシーズ','カットビング','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(56,'観月 小鳥',4,5,'エクシーズ','まじ(代行)天使','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(57,'神代 凌牙',4,2,'エクシーズ','元不良','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(58,'天城 カイト',4,5,'エクシーズ','すぐハルト','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(59,'ゴーシュ',4,3,'エクシーズ','いいノリしてる人','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(60,'ドロワ',4,6,'エクシーズ','そんな覚えてない','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(61,'バイロン・アークライト',4,5,'エクシーズ','お父様','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(62,'クリストファー・アークライト',4,5,'エクシーズ','長男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(63,'トーマス・アークライト',4,6,'エクシーズ','次男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(64,'ミハエル・アークライト',4,3,'エクシーズ','三男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(65,'ドルベ',4,5,'エクシーズ','無能','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(66,'ギラグ',4,3,'エクシーズ','女にやさしい','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(67,'アリト',4,1,'エクシーズ','いいやつだった','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(68,'ミザエル',4,5,'エクシーズ','タキオン厨','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(69,'ベクター',4,6,'エクシーズ','ZEXALの8割','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(70,'メラグ',4,2,'エクシーズ','センス高い','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(71,'ドン・サウザンド',4,5,'エクシーズ','絶対許されない男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(72,'榊 遊矢',5,6,'ペンデュラム','メンヘラ主人公','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(73,'ユート',5,6,'エクシーズ','腹パン男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(74,'ユーゴ',5,4,'シンクロ','融合じゃない人','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(75,'ユーリ',5,6,'融合','ねっとり','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(76,'柊 柚子',5,5,'融合','ストロング','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(77,'セレナ',5,6,'融合','脳筋女','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(78,'リン',5,4,'シンクロ','足蹴り女','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(79,'黒咲 瑠璃',5,4,'エクシーズ','兄が面白い','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(80,'赤馬 零児',5,6,'ペンデュラム','有能','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(81,'権現坂 昇',5,3,'シンクロ','いいやつ','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(82,'紫雲院 素良',5,6,'融合','顔芸','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(83,'沢渡 シンゴ',5,4,'ペンデュラム','なんだかんだ人気','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(84,'黒咲 隼',5,6,'エクシーズ','愛され男','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(85,'風魔 月影',5,6,'アドバンス','邪魔しに参った','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(86,'デニス・マックフィールド',5,5,'ペンデュラム','裏しかない','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(87,'志島 北斗',5,5,'エクシーズ','中の人が良い','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(88,'光津 真澄',5,3,'融合','友情の人','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(89,'刀堂 刃',5,3,'シンクロ','リアルファイトで負けた人','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(90,'シンジ・ウェーバー',5,4,'シンクロ','イキリ','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(91,'徳松 長次郎',5,6,'シンクロ','いい人','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(92,'藤木 遊作',6,6,'リンク','勝率高い人','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(93,'穂村 尊',6,1,'リンク','環境','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(94,'財前 葵',6,5,'リンク','後半でやっとヒロイン','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(95,'鬼塚 豪',6,3,'リンク','カリスマ()','0','2019-06-10 12:00:00','2019-06-18 11:54:44'),(96,'財前 晃',6,6,'リンク','お兄様','0','2019-06-10 12:00:00','2019-06-18 13:06:38'),(97,'道順 健碁',6,4,'リンク','お母さん孝行','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(98,'別所 エマ',6,6,'リンク','ゴーストおばさん','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(99,'鴻上 了見',6,6,'リンク','かっこいい。良い。推す。','0','2019-06-10 12:00:00','2019-06-11 13:00:00'),(100,'スペクター',6,3,'リンク','ママ大好き','0','2019-06-10 12:00:00','2019-06-18 11:32:05');
/*!40000 ALTER TABLE `yugioh_main_okugawa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuru_belong_yokoyama`
--

DROP TABLE IF EXISTS `yuru_belong_yokoyama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuru_belong_yokoyama` (
  `belong_id` int(11) NOT NULL,
  `belong` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuru_belong_yokoyama`
--

LOCK TABLES `yuru_belong_yokoyama` WRITE;
/*!40000 ALTER TABLE `yuru_belong_yokoyama` DISABLE KEYS */;
INSERT INTO `yuru_belong_yokoyama` VALUES (1,'ご当地','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(2,'企業','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(3,'その他','0','2019-04-12 00:00:00','2019-04-12 00:00:00');
/*!40000 ALTER TABLE `yuru_belong_yokoyama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuru_data_yokoyama`
--

DROP TABLE IF EXISTS `yuru_data_yokoyama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuru_data_yokoyama` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `from_id` int(11) DEFAULT NULL,
  `belong_id` int(11) DEFAULT NULL,
  `point` varchar(256) DEFAULT NULL,
  `img` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuru_data_yokoyama`
--

LOCK TABLES `yuru_data_yokoyama` WRITE;
/*!40000 ALTER TABLE `yuru_data_yokoyama` DISABLE KEYS */;
INSERT INTO `yuru_data_yokoyama` VALUES (1,'さんかくやまベェ',1,1,'150万歳とされている','/YuruYokoyama/001.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(2,'メロン熊',1,1,'畑いじりが趣味','/YuruYokoyama/002.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(3,'むすび丸',4,1,'伊達政宗公の兜の飾りがチャームポイント','/YuruYokoyama/003.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(4,'独眼竜ねこまさむね',4,1,'奥州のはしゃ','/YuruYokoyama/004.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(5,'ハネトン',2,1,'ねぶた踊りが得意','/YuruYokoyama/005.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(6,'たか丸くん',2,1,'調子に乗りやすい','/YuruYokoyama/006.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(7,'しわまろくん',3,1,'ガールフレンドがいる','/YuruYokoyama/007.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(8,'サーモンくん&みやこちゃん',3,1,'11月11日(鮭の日)うまれ','/YuruYokoyama/008.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(9,'スポまる',5,1,'走るスピードが速いため、たてがみがなびいている','/YuruYokoyama/009.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(10,'ニャンパチ',5,1,'ふわふわな肉球','/YuruYokoyama/010.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(11,'はながたベニちゃん',6,1,'「～ベニ」がつく話し方','/YuruYokoyama/011.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(12,'ももりん',7,1,'「もも」と「リンゴ」から「ももりん」と名付られた','/YuruYokoyama/012.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(13,'カブトン',7,1,'常に前向きでチャレンジ精神が旺盛','/YuruYokoyama/013.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(14,'新宿あわわ',13,1,'きれい好き','/YuruYokoyama/014.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(15,'稲城なしのすけ',13,1,'梨型メカ','/YuruYokoyama/015.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(16,'横浜みどりアップ葉っぴー',14,1,'体重88g（葉っぱだけに）','/YuruYokoyama/016.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(17,'かわさきミュートン',14,1,'尊敬する人 : 坂本九さん','/YuruYokoyama/017.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(18,'さがみん',14,1,'人懐っこくてピュア','/YuruYokoyama/018.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(19,'つなが竜ヌゥ',11,1,'\"見沼田んぼ\"の主の子孫','/YuruYokoyama/019.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(20,'ちはなちゃん',12,1,'おっとりしている','/YuruYokoyama/020.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(21,'ねば～る君',8,1,'こねればこねる程味が出る','/YuruYokoyama/021.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(22,'ミヤリー',9,1,'上から目線で毒舌','/YuruYokoyama/022.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(23,'ぐんまちゃん',10,1,'特技 : 変身','/YuruYokoyama/023.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(24,'笹だるま',15,1,'「幸せトルネード」','/YuruYokoyama/024.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(25,'アルクマ',20,NULL,'信州に出没する､大変珍しいクマ','/YuruYokoyama/025.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(26,'とりもっちゃん',19,1,'40歳（酉年）','/YuruYokoyama/026.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(27,'はち丸&かなえっち',23,1,'風呂敷の中にかなえっちが入ってる','/YuruYokoyama/027.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(28,'オカザえもん',23,1,'拙者、オカザえもんと申しますでござる～','/YuruYokoyama/028.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(29,'うーたん',21,1,'特別住民票を持っている','/YuruYokoyama/029.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(30,'ゴーちゃん',24,1,'伯父上は織田信長','/YuruYokoyama/030.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(31,'しずみぃ',22,1,'10歳（小学校4年生）','/YuruYokoyama/031.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(32,'出世大名家康くん',22,1,'浜名湖うなぎのちょんまげ','/YuruYokoyama/032.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(33,'市立探偵ペロリッチ',16,1,'惚れっぽいが時には義理堅い','/YuruYokoyama/033.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(34,'かなりん',17,1,'特技 : 足じゃんけん','/YuruYokoyama/034.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(35,'朝倉ゆめまる',18,1,'一乗谷朝倉氏遺跡に住む妖精','/YuruYokoyama/035.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(36,'ゆめまるくん',27,1,'額にある「C」の前髪は中央区の「C」を表している','/YuruYokoyama/036.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(37,'かもめん',28,1,'くちぐせ : 「〇〇もめ」','/YuruYokoyama/037.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(38,'時のわらし',28,1,'明石の時間を守り続ける\"時の妖精\"','/YuruYokoyama/038.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(39,'にしきょう・たけにょん',26,1,'少し内股な足がチャームポイント','/YuruYokoyama/039.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(40,'ひこにゃん',25,1,'1日3回、彦根城天守前広場や彦根城博物館に登場','/YuruYokoyama/040.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(41,'おおつ光ルくん\n（おおつひかるくん）',25,1,'衣食住が足りすぎて運動不足','/YuruYokoyama/041.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(42,'せんとくん',29,1,'平城遷都1300年祭をアピールするため誕生','/YuruYokoyama/042.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(43,'しかまろくん',29,1,'のんびり屋','/YuruYokoyama/043.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(44,'きいちゃん',30,1,'紀州犬をモチーフにした元気いっぱいのマスコット','/YuruYokoyama/044.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(45,'たけちゃま',34,1,'恥ずかしがり屋で、公ではささやいて家臣に代弁させる','/YuruYokoyama/045.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(46,'はっさくん',34,1,'因島のことになると熱くなる','/YuruYokoyama/046.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(47,'ミコロ?ハコロ',33,1,'特技 : ころころすること','/YuruYokoyama/047.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(48,'SUGO！USAGI?イーくん',31,1,'実は3つ子で、他にのんびり屋の「ナーくん」と、しっかり者の「バーくん」がいる','/YuruYokoyama/048.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(49,'しまねっこ',32,1,'最近食べすぎで少し動きが鈍い','/YuruYokoyama/049.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(50,'おおちゃん',35,1,'ロマンチスト、熱血な一面も','/YuruYokoyama/050.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(51,'うっち～',35,1,'天真爛漫、ドジっ子','/YuruYokoyama/051.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(52,'ほっくん',35,1,'水平線に沈む夕日と「豊」の文字を表現','/YuruYokoyama/052.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(53,'すだちくん',36,1,'愛くるしい笑顔','/YuruYokoyama/053.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(54,'ときたま',37,1,'正式名称 : 常磐 玉吾','/YuruYokoyama/054.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(55,'しまぼう',38,1,'足は短いけど、高くジャンプすることができる','/YuruYokoyama/055.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(56,'いまばり バリィさん',38,1,'焼き鳥のまち今治（いまばり）生まれ今治育ちのトリ','/YuruYokoyama/056.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(57,'ケーちゃん',39,1,'頭の上に乗っているのは県花「やまもも」がチャームーポイント','/YuruYokoyama/057.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(58,'しんじょう君',39,1,'須崎市の新荘川で、最後に確認されたニホンカワウソ','/YuruYokoyama/058.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(59,'ふくおか官兵衛くん',40,1,'倹約好き（たまに大盤振る舞いする）','/YuruYokoyama/059.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(60,'プチボザウルス',40,1,'友達 : 環境戦士アースマン','/YuruYokoyama/060.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(61,'はんしゃろん',41,1,'\"反射炉\"の守り神','/YuruYokoyama/061.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(62,'さるくちゃん',42,1,'顔にひらがなで、「さ」「る」「く」の3文字が入っている','/YuruYokoyama/062.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(63,'くまモン',43,1,'やんちゃで好奇心いっぱい','/YuruYokoyama/063.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(64,'たかもん',44,1,'「サル」と「山」のしたたかな使い分け','/YuruYokoyama/064.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(65,'ミッシちゃん',45,1,'宮崎の青島という島に住んでいる妖精','/YuruYokoyama/065.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(66,'サクラエンジェルちゃん',46,1,'特技 : ジャンプと投げキッス','/YuruYokoyama/066.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(67,'だちびんくん',47,1,'頭からいろいろな物が出せる（お菓子など）','/YuruYokoyama/067.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(68,'なんじぃ',47,1,'相棒の白ヤギ\"ヤッギー\"と一緒に南城市の青い海でよく遊んでいるよ♪','/YuruYokoyama/068.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(69,'ハリーホーク',NULL,3,'福岡ソフトバンクホークスのマスコット','/YuruYokoyama/069.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(70,'レオ',NULL,3,'埼玉西武ライオンズのマスコット','/YuruYokoyama/070.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(71,'ジャビット君',NULL,3,' 読売ジャイアンツのマスコット','/YuruYokoyama/071.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(72,'トラッキー',NULL,3,'阪神タイガースのマスコット','/YuruYokoyama/072.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(73,'ドアラ',NULL,3,'中日ドラゴンズのマスコット。荒ぶる有袋類。 ','/YuruYokoyama/073.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(74,'つば九郎',NULL,3,'東京ヤクルトスワローズのマスコット。畜ペン。','/YuruYokoyama/074.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(75,'かんぽくん',NULL,2,'株式会社かんぽ生命保険所属','/YuruYokoyama/075.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(76,'あらびき星人ソップリン',NULL,2,'プリマハム株式会社所属','/YuruYokoyama/076.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(77,'ふなっしー',12,1,'本名 : ﾌﾅﾃﾞｨｳｽ4世/船田梨男','/YuruYokoyama/077.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(78,'ずーしーほっきー',1,1,'可愛さよりキモさが売りです','/YuruYokoyama/078.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(79,'ちぃたん☆',13,1,'秋葉原出身のコツメカワウソの妖精','/YuruYokoyama/079.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(80,'パッチョ',NULL,2,'東京ガス所属','/YuruYokoyama/080.gif','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(81,'電パッチョ',NULL,2,'東京ガス所属','/YuruYokoyama/081.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(82,'あ',1,1,'',NULL,'1','2019-12-11 17:51:36','2019-12-11 17:51:36');
/*!40000 ALTER TABLE `yuru_data_yokoyama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuru_from_yokoyama`
--

DROP TABLE IF EXISTS `yuru_from_yokoyama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuru_from_yokoyama` (
  `from_id` int(11) NOT NULL,
  `place` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuru_from_yokoyama`
--

LOCK TABLES `yuru_from_yokoyama` WRITE;
/*!40000 ALTER TABLE `yuru_from_yokoyama` DISABLE KEYS */;
INSERT INTO `yuru_from_yokoyama` VALUES (1,'北海道','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(2,'青森県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(3,'岩手県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(4,'宮城県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(5,'秋田県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(6,'山形県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(7,'福島県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(8,'茨城県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(9,'栃木県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(10,'群馬県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(11,'埼玉県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(12,'千葉県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(13,'東京都','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(14,'神奈川県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(15,'新潟県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(16,'富山県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(17,'石川県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(18,'福井県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(19,'山梨県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(20,'長野県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(21,'岐阜県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(22,'静岡県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(23,'愛知県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(24,'三重県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(25,'滋賀県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(26,'京都府','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(27,'大阪府','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(28,'兵庫県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(29,'奈良県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(30,'和歌山県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(31,'鳥取県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(32,'島根県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(33,'岡山県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(34,'広島県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(35,'山口県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(36,'徳島県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(37,'香川県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(38,'愛媛県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(39,'高知県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(40,'福岡県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(41,'佐賀県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(42,'長崎県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(43,'熊本県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(44,'大分県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(45,'宮崎県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(46,'鹿児島県','0','2019-04-12 00:00:00','2019-04-12 00:00:00'),(47,'沖縄県','0','2019-04-12 00:00:00','2019-04-12 00:00:00');
/*!40000 ALTER TABLE `yuru_from_yokoyama` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-01 15:32:41
