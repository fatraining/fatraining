-- MySQL dump 10.16  Distrib 10.1.38-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fa
-- ------------------------------------------------------
-- Server version	10.1.38-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

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
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
INSERT INTO `genre_ishikawa` VALUES (1,'主食','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'主菜','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'副菜','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(1,'主食','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'主菜','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'副菜','0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_kataoka`
--

LOCK TABLES `genre_kataoka` WRITE;
/*!40000 ALTER TABLE `genre_kataoka` DISABLE KEYS */;
INSERT INTO `genre_kataoka` VALUES (0,'','0','2018-09-26 23:49:48','2018-09-17 06:00:00'),(1,'文化遺産','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(2,'自然遺産','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(0,'','0','2018-09-26 23:49:48','2018-09-17 06:00:00'),(1,'文化遺産','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(2,'自然遺産','0','2018-09-17 06:00:00','2018-09-17 06:00:00');
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
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
-- Table structure for table `location_kataoka`
--

DROP TABLE IF EXISTS `location_kataoka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_kataoka` (
  `id` int(2) NOT NULL,
  `location` varchar(20) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
INSERT INTO `movie_main` VALUES (1,'スパイダーマン3',1,2,2007,155,'スパイダーマンの映画の中では一番好き',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN誕生秘話、ばちぼこ面白い。',0,'2017-11-08 00:00:00','2019-01-22 13:58:25'),(3,'レオン',1,4,1994,110,'マチルダがかわいい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(4,'ダークナイトライジング',1,5,2012,165,'DCコミック頑張れ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'ベイビードライバー',1,NULL,2017,113,'続編が制作されるそう',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'トランス',2,3,2013,101,'ダニー・ボイル監督',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'フィルス',2,3,2013,97,'スコットランドの最悪刑事',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'華麗なるギャツビー',2,2,2013,143,'豪華絢爛',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'ブリッジオブスパイ',2,1,2015,144,'アカデミー助演男優賞受賞',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'ダ・ヴィンチ・コード',2,1,2006,174,'オドレイ・トトゥ老けたなあ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'フォレストガンプ',3,1,1994,142,'言わずと知れた名言の宝庫',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'完全なるチェックメイト',3,2,2014,116,'ボビーフィッシャー',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'あの頃僕らは',3,2,2001,90,'若かりしディカプリオ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'レミゼラブル',3,5,2012,160,'歌部分はアテレコではありません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'グリーンマイル',3,1,1999,189,'『ショーシャンクの空に』もいいです',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'ブラックスワン',4,4,2011,108,'下手なホラーより怖いかも',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TVムービー編もどうぞ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(18,'キャリー',4,NULL,1976,98,'スティーブン・キングの処女作',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'スプリット',4,3,2017,117,'シャマラン作品を見ておくと吉',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'ミスターガラス',4,3,2019,129,'スプリットの続編',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'マイ・インターン',5,5,2015,121,'『プラダを着た悪魔』もおすすめ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'ターミナル',5,1,2004,128,'空港に住んでみたい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'ペネロピ',5,3,2008,104,'現代のおとぎ話',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'アリスインワンダーランド',5,5,2010,113,'映像美すごい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'キャッツ＆ドッグス',5,2,2001,87,'犬はかわいい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'つぐない',NULL,3,2007,130,'陰鬱な時にはおすすめしません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'プライドと偏見',NULL,NULL,2005,135,'コリン・ファースのドラマ版も良き',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'グレイテストショーマン',3,NULL,2017,105,'個人的にラ・ラ・ランド越え',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'ビッグ',5,1,1988,130,'素敵な気持になれる',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'やたら豪華な俳優陣',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
  `rating` int(11) DEFAULT '0',
  `comment` varchar(255) DEFAULT NULL,
  `category_id` int(11) unsigned DEFAULT '0',
  `video_url` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '0',
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
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `delete_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '0',
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
INSERT INTO `player_main_shiono` VALUES (1,'セルヒオ・アグエロ',1,1,'1988.06.02','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(2,'リオネル・メッシ',1,2,'1987.06.24','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(3,'アンヘル・ディ・マリア',1,3,'1988.02.14','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(4,'パウロ・ディバラ',1,4,'1993.11.15','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(5,'ジャンルイジ・ブッフォン',2,3,'1978.01.28','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(6,'ラヒーム・スターリング',3,1,'1994.12.08','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(7,'ハリー・ケイン',3,5,'1993.07.28','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(8,'モハメド・サラー',4,6,'1992.06.15','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(9,'ルカ・モドリッチ',5,7,'1985.09.09','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(10,'ダビド・デ・ヘア',6,8,'1990.11.07','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(11,'セルヒオ・ラモス',6,7,'1986.03.30','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(12,'ジェラール・ピケ',6,2,'1987.02.02','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(13,'イスコ',6,7,'1992.04.21','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(14,'ダビド・シルバ',6,1,'1986.01.08','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(15,'フェルナンド・トーレス',6,9,'1984.03.20','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(16,'マヌエル・ノイアー',7,10,'1986.03.27','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(17,'テア・シュテーゲン',7,2,'1992.04.30','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(18,'マッツ・フンメルス',7,10,'1988.12.16','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(19,'トニ・クロース',7,7,'1990.01.04','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(20,'リロイ・サネ',7,1,'1996.01.11','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(21,'メスト・エジル',7,11,'1988.10.15','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(22,'マルコ・ロイス',7,12,'1989.05.31','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(23,'ラファエル・ヴァラン',8,7,'1993.04.25','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(24,'ポール・ポグバ',8,8,'1993.03.19','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(25,'フランク・リベリ',8,10,'1983.04.07','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(26,'カリム・ベンゼマ',8,7,'1987.12.19','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(27,'キリアン・ムバッペ',8,3,'1998.12.20','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(28,'アントワーヌ・グリエーズマン',8,13,'1991.03.21','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(29,'ティボー・クルトワ',9,7,'1992.05.11','GK','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(30,'ビンセント・コンパニ',9,1,'1986.04.10','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(31,'ヤン・フェルトンゲン',9,5,'1987.04.24','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(32,'ケビン・デ・ブルイネ',9,1,'1991.06.28','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(33,'エデン・アザール',9,14,'1991.01.07','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(34,'ロメル・ルカク',9,8,'1993.05.13','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(35,'ドリース・メルテンス',9,15,'1987.05.06','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(36,'ベルナルド・シウバ',10,1,'1994.08.10','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(37,'クリスティアーノ・ロナウド',10,4,'1985.02.05','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(38,'ソン・フンミン',11,5,'1992.07.08','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(39,'長友佑都',12,16,'1986.09.12','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(40,'長谷部誠',12,17,'1984.01.18','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(41,'香川真司',12,18,'1989.03.17','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(42,'本田圭佑',12,19,'1986.06.13','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(43,'大迫勇也',12,20,'1990.05.18','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(44,'ルイス・スアレス',13,2,'1987.01.24','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(45,'エジソン・カバーニ',13,3,'1987.02.14','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(46,'マルセロ',14,7,'1988.05.12','DF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(47,'ウィリアン',14,14,'1988.08.09','MF','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(48,'コウチーニョ',14,2,'1992.06.12','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(49,'ネイマール',14,3,'1992.02.05','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00'),(50,'サディオ・マネ',15,6,'1992.04.10','FW','0','2019-05-17 15:05:00','2019-05-17 15:05:00');
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
INSERT INTO `yuru_data_yokoyama` VALUES (1,'さんかくやまベェ',1,1,'150万歳とされている','/YuruYokoyama/001.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(2,'メロン熊',1,1,'畑いじりが趣味','/YuruYokoyama/002.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(3,'むすび丸',4,1,'伊達政宗公の兜の飾りがチャームポイント','/YuruYokoyama/003.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(4,'独眼竜ねこまさむね',4,1,'奥州のはしゃ','/YuruYokoyama/004.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(5,'ハネトン',2,1,'ねぶた踊りが得意','/YuruYokoyama/005.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(6,'たか丸くん',2,1,'調子に乗りやすい','/YuruYokoyama/006.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(7,'しわまろくん',3,1,'ガールフレンドがいる','/YuruYokoyama/007.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(8,'サーモンくん&みやこちゃん',3,1,'11月11日(鮭の日)うまれ','/YuruYokoyama/008.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(9,'スポまる',5,1,'走るスピードが速いため、たてがみがなびいている','/YuruYokoyama/009.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(10,'ニャンパチ',5,1,'ふわふわな肉球','/YuruYokoyama/010.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(11,'はながたベニちゃん',6,1,'「～ベニ」がつく話し方','/YuruYokoyama/011.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(12,'ももりん',7,1,'「もも」と「リンゴ」から「ももりん」と名付られた','/YuruYokoyama/012.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(13,'カブトン',7,1,'常に前向きでチャレンジ精神が旺盛','/YuruYokoyama/013.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(14,'新宿あわわ',13,1,'きれい好き','/YuruYokoyama/014.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(15,'稲城なしのすけ',13,1,'梨型メカ','/YuruYokoyama/015.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(16,'横浜みどりアップ葉っぴー',14,1,'体重88g（葉っぱだけに）','/YuruYokoyama/016.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(17,'かわさきミュートン',14,1,'尊敬する人 : 坂本九さん','/YuruYokoyama/017.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(18,'さがみん',14,1,'人懐っこくてピュア','/YuruYokoyama/018.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(19,'つなが竜ヌゥ',11,1,'\"見沼田んぼ\"の主の子孫','/YuruYokoyama/019.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(20,'ちはなちゃん',12,1,'おっとりしている','/YuruYokoyama/020.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(21,'ねば～る君',8,1,'こねればこねる程味が出る','/YuruYokoyama/021.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(22,'ミヤリー',9,1,'上から目線で毒舌','/YuruYokoyama/022.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(23,'ぐんまちゃん',10,1,'特技 : 変身','/YuruYokoyama/023.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(24,'笹だるま',15,1,'「幸せトルネード」','/YuruYokoyama/024.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(25,'アルクマ',20,NULL,'信州に出没する､大変珍しいクマ','/YuruYokoyama/025.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(26,'とりもっちゃん',19,1,'40歳（酉年）','/YuruYokoyama/026.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(27,'はち丸&かなえっち',23,1,'風呂敷の中にかなえっちが入ってる','/YuruYokoyama/027.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(28,'オカザえもん',23,1,'拙者、オカザえもんと申しますでござる～','/YuruYokoyama/028.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(29,'うーたん',21,1,'特別住民票を持っている','/YuruYokoyama/029.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(30,'ゴーちゃん',24,1,'伯父上は織田信長','/YuruYokoyama/030.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(31,'しずみぃ',22,1,'10歳（小学校4年生）','/YuruYokoyama/031.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(32,'出世大名家康くん',22,1,'浜名湖うなぎのちょんまげ','/YuruYokoyama/032.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(33,'市立探偵ペロリッチ',16,1,'惚れっぽいが時には義理堅い','/YuruYokoyama/033.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(34,'かなりん',17,1,'特技 : 足じゃんけん','/YuruYokoyama/034.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(35,'朝倉ゆめまる',18,1,'一乗谷朝倉氏遺跡に住む妖精','/YuruYokoyama/035.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(36,'ゆめまるくん',27,1,'額にある「C」の前髪は中央区の「C」を表している','/YuruYokoyama/036.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(37,'かもめん',28,1,'くちぐせ : 「〇〇もめ」','/YuruYokoyama/037.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(38,'時のわらし',28,1,'明石の時間を守り続ける\"時の妖精\"','/YuruYokoyama/038.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(39,'にしきょう・たけにょん',26,1,'少し内股な足がチャームポイント','/YuruYokoyama/039.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(40,'ひこにゃん',25,1,'1日3回、彦根城天守前広場や彦根城博物館に登場','/YuruYokoyama/040.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(41,'おおつ光ルくん\n（おおつひかるくん）',25,1,'衣食住が足りすぎて運動不足','/YuruYokoyama/041.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(42,'せんとくん',29,1,'平城遷都1300年祭をアピールするため誕生','/YuruYokoyama/042.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(43,'しかまろくん',29,1,'のんびり屋','/YuruYokoyama/043.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(44,'きいちゃん',30,1,'紀州犬をモチーフにした元気いっぱいのマスコット','/YuruYokoyama/044.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(45,'たけちゃま',34,1,'恥ずかしがり屋で、公ではささやいて家臣に代弁させる','/YuruYokoyama/045.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(46,'はっさくん',34,1,'因島のことになると熱くなる','/YuruYokoyama/046.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(47,'ミコロ?ハコロ',33,1,'特技 : ころころすること','/YuruYokoyama/047.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(48,'SUGO！USAGI?イーくん',31,1,'実は3つ子で、他にのんびり屋の「ナーくん」と、しっかり者の「バーくん」がいる','/YuruYokoyama/048.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(49,'しまねっこ',32,1,'最近食べすぎで少し動きが鈍い','/YuruYokoyama/049.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(50,'おおちゃん',35,1,'ロマンチスト、熱血な一面も','/YuruYokoyama/050.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(51,'うっち～',35,1,'天真爛漫、ドジっ子','/YuruYokoyama/051.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(52,'ほっくん',35,1,'水平線に沈む夕日と「豊」の文字を表現','/YuruYokoyama/052.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(53,'すだちくん',36,1,'愛くるしい笑顔','/YuruYokoyama/053.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(54,'ときたま',37,1,'正式名称 : 常磐 玉吾','/YuruYokoyama/054.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(55,'しまぼう',38,1,'足は短いけど、高くジャンプすることができる','/YuruYokoyama/055.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(56,'いまばり バリィさん',38,1,'焼き鳥のまち今治（いまばり）生まれ今治育ちのトリ','/YuruYokoyama/056.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(57,'ケーちゃん',39,1,'頭の上に乗っているのは県花「やまもも」がチャームーポイント','/YuruYokoyama/057.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(58,'しんじょう君',39,1,'須崎市の新荘川で、最後に確認されたニホンカワウソ','/YuruYokoyama/058.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(59,'ふくおか官兵衛くん',40,1,'倹約好き（たまに大盤振る舞いする）','/YuruYokoyama/059.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(60,'プチボザウルス',40,1,'友達 : 環境戦士アースマン','/YuruYokoyama/060.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(61,'はんしゃろん',41,1,'\"反射炉\"の守り神','/YuruYokoyama/061.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(62,'さるくちゃん',42,1,'顔にひらがなで、「さ」「る」「く」の3文字が入っている','/YuruYokoyama/062.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(63,'くまモン',43,1,'やんちゃで好奇心いっぱい','/YuruYokoyama/063.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(64,'たかもん',44,1,'「サル」と「山」のしたたかな使い分け','/YuruYokoyama/064.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(65,'ミッシちゃん',45,1,'宮崎の青島という島に住んでいる妖精','/YuruYokoyama/065.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(66,'サクラエンジェルちゃん',46,1,'特技 : ジャンプと投げキッス','/YuruYokoyama/066.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(67,'だちびんくん',47,1,'頭からいろいろな物が出せる（お菓子など）','/YuruYokoyama/067.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(68,'なんじぃ',47,1,'相棒の白ヤギ\"ヤッギー\"と一緒に南城市の青い海でよく遊んでいるよ♪','/YuruYokoyama/068.png','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(69,'ハリーホーク',NULL,3,'福岡ソフトバンクホークスのマスコット','/YuruYokoyama/069.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(70,'レオ',NULL,3,'埼玉西武ライオンズのマスコット','/YuruYokoyama/070.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(71,'ジャビット君',NULL,3,' 読売ジャイアンツのマスコット','/YuruYokoyama/071.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(72,'トラッキー',NULL,3,'阪神タイガースのマスコット','/YuruYokoyama/072.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(73,'ドアラ',NULL,3,'中日ドラゴンズのマスコット。荒ぶる有袋類。 ','/YuruYokoyama/073.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(74,'つば九郎',NULL,3,'東京ヤクルトスワローズのマスコット。畜ペン。','/YuruYokoyama/074.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(75,'かんぽくん',NULL,2,'株式会社かんぽ生命保険所属','/YuruYokoyama/075.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(76,'あらびき星人ソップリン',NULL,2,'プリマハム株式会社所属','/YuruYokoyama/076.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(77,'ふなっしー',12,1,'本名 : ﾌﾅﾃﾞｨｳｽ4世/船田梨男','/YuruYokoyama/077.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(78,'ずーしーほっきー',1,1,'可愛さよりキモさが売りです','/YuruYokoyama/078.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(79,'ちぃたん☆',13,1,'秋葉原出身のコツメカワウソの妖精','/YuruYokoyama/079.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(80,'パッチョ',NULL,2,'東京ガス所属','/YuruYokoyama/080.gif','0','2019-04-15 00:00:00','2019-04-15 00:00:00'),(81,'電パッチョ',NULL,2,'東京ガス所属','/YuruYokoyama/081.jpg','0','2019-04-15 00:00:00','2019-04-15 00:00:00');
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

-- Dump completed on 2019-06-04 11:06:23
