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
INSERT INTO `band_main_sasaki` VALUES (1,'/bandimage/han.jpg','ハンブレッダーズ',4,8,2009,3,'そろそろ売れてくるであろうバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'/bandimage/floor.jpg','The Floor',4,1,2012,5,'ポップなサウンドが特徴.','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'/bandimage/fom.jpg','FOMARE',3,2,2014,2,'結成してから売れるまでが早い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(4,'/bandimage/num.jpg','NUMBER GIAL',4,12,1995,6,'2002年に解散したが17年ぶりに再結成。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(5,'/bandimage/mo.jpg','モーモールルギャバン',3,9,2005,9,'パン一ドラムボーカル。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(6,'/bandimage/jyo.jpg','JYOCHO',5,9,2016,4,'ギターのテクニックが物凄い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(7,'/bandimage/maka.jpg','マカロニえんぴつ',4,5,2012,5,'ポップな曲からかっこいい曲まで良曲揃い。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(8,'/bandimage/hel.jpg','Helsinki Lambda Club',3,3,2013,5,'ゆったりとした落ち着く音楽。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(9,'/bandimage/zoo.jpg','ズーカラデル',3,1,2015,2,'初MVを投稿してわずか数ヶ月でCM曲。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(10,'/bandimage/fin.jpg','FINLANDS',2,5,2012,6,'若い女性らしからぬかっこよさがある。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(11,'/bandimage/sum.jpg','sumika',4,5,2013,8,'前バンドのbanbiから大出世。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(12,'/bandimage/sup.jpg','SUPER BEAVER',4,4,2005,10,'ライブのMCがダサかっこいい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(13,'/bandimage/was.jpg','忘れらんねえよ',1,11,2008,7,'36歳にしてメンバーが一人になってしまう。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(14,'/bandimage/qoo.jpg','QOOLAND',4,4,2011,9,'ボスハンドタッピングという奏法が特徴。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(15,'/bandimage/nev.jpg','never young beach',4,4,2014,3,'ボーカルの兄が高橋一生。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(16,'/bandimage/sex.jpg','セックスマシーン',4,7,1998,7,'ジーンズがダメージを受けすぎている。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(17,'/bandimage/toco.jpg','toconoma',4,4,2008,5,'高テクニックのインストバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(18,'/bandimage/suc.jpg','Suck a Stew Dry',5,4,2010,5,'現在はTHURSDAYS YOUTHというバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(19,'/bandimage/su-.jpg','四星球',4,10,2002,7,'ライブで使う小道具は全て手作り。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(20,'/bandimage/sak.jpg','SAKEROCK',5,6,2000,14,'バナナマンのライブBGMなどを担当する。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(21,'/bandimage/nec.jpg','ネクライトーキー',5,8,2017,1,'ほとんどコンテンポラリーな生活。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(22,'/bandimage/pop.jpg','ポップしなないで',2,4,2015,2,'優花さんおすすめのバンド。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(23,'/bandimage/ao.jpg','藍坊主',4,5,2000,14,'歌ほんとうまい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(24,'/bandimage/bak.jpg','爆弾ジョニー',5,1,2010,4,'アニメ「ピンポン」のOP。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(25,'/bandimage/sakana.jpg','サカナクション',5,1,2005,8,'言わずと知れたかっこよさ。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(26,'/bandimage/s.jpg','さしすせそズ',4,8,2013,2,'パルプンテ山田とイケダーマン池田が脱退。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(27,'/bandimage/mint.jpg','MINT mate box',3,4,2017,2,'ベースかわいい。','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(28,'/bandimage/fujiki.jpg','藤木さん',1,4,1995,0,'明日も競艇に全てを賭ける。','0','2019-04-05 09:23:18','2019-04-05 09:28:59'),(29,'/bandimage/friends.jpg','石原さん',1,4,2019,1,'フレンズの件に関してはほとんど桜井さんが悪い。','0','2019-04-05 09:24:50','2019-04-05 09:28:38');
/*!40000 ALTER TABLE `band_main_sasaki` ENABLE KEYS */;
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
INSERT INTO `color_nakai` VALUES (0,NULL,'0','2018-10-15 00:00:00','2018-10-15 00:00:00'),(1,'白','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(2,'黄','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(3,'オレンジ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(4,'ピンク','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(5,'赤','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(6,'青','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(7,'紫','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(8,'緑','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(9,'その他','0','2018-10-09 00:00:00','2018-10-09 00:00:00');
/*!40000 ALTER TABLE `color_nakai` ENABLE KEYS */;
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
INSERT INTO `flower_main_nakai` VALUES (1,'/FlowerNakai/ume.jpg','梅（ウメ）',1,1,'中国','高潔、澄んだ心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(2,'/FlowerNakai/sazanka.jpg','山茶花（サザンカ）',1,4,'日本','素直、飾らない心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(3,'/FlowerNakai/cyclamen.jpg','シクラメン',2,7,'トルコ','清純、はにかみ、思慮深い','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(4,'/FlowerNakai/fukujuso.jpg','福寿草（フクジュソウ）',2,2,'日本','幸せを招く','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(5,'/FlowerNakai/momo.jpg','桃（モモ）',3,4,'中国','チャーミング、私はあなたの虜','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(6,'/FlowerNakai/boke.jpg','木瓜（ボケ）',3,5,'中国','平凡','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(7,'/FlowerNakai/sakura.jpg','桜（サクラ）',4,4,'日本','高尚、教養、心の美','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(8,'/FlowerNakai/fuji.jpg','藤（フジ）',4,7,'日本','恋に酔う','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(9,'/FlowerNakai/carnation.jpg','カーネーション',5,5,'地中海沿岸から西アジア','純愛','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(10,'/FlowerNakai/ayame.jpg','菖蒲（アヤメ）',5,6,'ユーラシア大陸','気品漂う','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(11,'/FlowerNakai/gakuajisai.jpg','額紫陽花（ガクアジサイ）',6,7,'日本','謙虚','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(12,'/FlowerNakai/shirotsumekusa.jpg','シロツメクサ（クローバー）',6,1,'ヨーロッパ','約束','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(13,'/FlowerNakai/hozuki.jpg','鬼灯（ホオヅキ）',7,3,'東南アジア','笑顔','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(14,'/FlowerNakai/kikyo.jpg','桔梗（キキョウ）',7,6,'日本','不屈の心','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(15,'/FlowerNakai/himawari.jpg','向日葵（ヒマワリ）',8,2,'北米','栄光','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(16,'/FlowerNakai/hibisucus.jpg','ハイビスカス',8,5,'不明','繊細な美','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(17,'/FlowerNakai/kiku.jpg','菊（キク）',9,2,'中国','信頼','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(18,'/FlowerNakai/manjusyage.jpg','曼珠沙華（マンジュシャゲ）',9,5,'中国','感謝','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(19,'/FlowerNakai/kinmokusei.jpg','金木犀（キンモクセイ）',10,2,'中国','変わらぬ魅力','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(20,'/FlowerNakai/susuki.jpg','薄（ススキ）',10,8,'中国','秋風に想いを乗せて','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(21,'/FlowerNakai/marygold.jpg','マリーゴールド',11,3,'メキシコ','嫉妬、絶望、悲しみ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(22,'/FlowerNakai/bara.jpg','薔薇（バラ）',11,4,'不明','しとやか、上品、可愛い人','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(23,'/FlowerNakai/nanten.jpg','南天（ナンテン）',12,1,'中国','ますます幸せ','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(24,'/FlowerNakai/poinsettia.jpg','ポインセチア',12,5,'メキシコ','祝福','0','2018-10-09 00:00:00','2018-10-09 00:00:00'),(25,NULL,'山法師（ヤマボウシ）',5,8,'日本、中国、朝鮮半島','友情','0','2018-10-16 09:29:34','2018-10-16 09:29:34');
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
INSERT INTO `genre_ishikawa` VALUES (1,'主食','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(2,'主菜','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(3,'副菜','0','2018-10-10 00:00:00','2018-10-10 00:00:00'),(0,'','0','2018-10-10 00:00:00','2018-10-10 00:00:00');
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
INSERT INTO `genre_kataoka` VALUES (0,'','0','2018-09-26 23:49:48','2018-09-17 06:00:00'),(1,'文化遺産','0','2018-09-17 06:00:00','2018-09-17 06:00:00'),(2,'自然遺産','0','2018-09-17 06:00:00','2018-09-17 06:00:00');
/*!40000 ALTER TABLE `genre_kataoka` ENABLE KEYS */;
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
INSERT INTO `genre_sako` VALUES (1,'アイスクリーム',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(2,'アイスミルク',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(3,'ラクトアイス',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(4,'氷菓',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(0,'',0,'2018-10-19 00:00:00','2018-10-19 00:00:00');
/*!40000 ALTER TABLE `genre_sako` ENABLE KEYS */;
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
INSERT INTO `tokyo_main_takehara` VALUES (1,'千代田',NULL,5,64533,11.66,'九段下',784,6330721,'樹木希林','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(2,'中央',NULL,1,163185,10.21,'新富町',556,8219777,'若林正恭','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(3,'港',NULL,3,258075,20.37,'大門',902,3611975,'関根勤','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(4,'新宿',NULL,2,347661,18.22,'新宿西口',477,3263794,'ルー大柴','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(5,'文京',NULL,4,232801,11.29,'後楽園',544,1181450,'野々村真','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(6,'台東',NULL,1,206816,10.11,'上野',385,1376259,'天海祐希','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(7,'墨田',NULL,1,268192,13.77,'浅草',350,589458,'大竹一樹','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(8,'江東',NULL,1,516636,40.16,'東陽町',389,583708,'持田香織','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(9,'品川',NULL,3,407084,22.84,'下神明',427,1160600,'遠藤憲一','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(10,'目黒',NULL,3,286462,14.67,'中目黒',537,1195400,'泉谷しげる','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(11,'大田',NULL,3,737700,60.83,'蒲田',395,627693,'片桐はいり','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(12,'世田谷',NULL,2,933708,58.05,'世田谷',506,690153,'中井貴一','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(13,'渋谷',NULL,2,233060,15.11,'渋谷',703,4234271,'吉永小百合','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(14,'中野',NULL,2,328215,15.59,'中野',387,812547,'田中裕二','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(15,'杉並',NULL,2,582864,34.06,'南阿佐ヶ谷',436,617023,'松田龍平','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(16,'豊島',NULL,4,300512,13.01,'東池袋',412,1147581,'山下達郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(17,'北',NULL,4,352806,20.61,'王子',344,657836,'古舘伊知郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(18,'荒川',NULL,4,217692,10.16,'荒川二丁目',345,605586,'片岡鶴太郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(19,'板橋',NULL,4,581066,32.22,'板橋区役所前',350,475214,'稲垣吾郎','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(20,'練馬',NULL,2,737906,48.08,'練馬',395,435136,'上戸彩','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(21,'足立',NULL,4,681309,53.25,'梅島',324,367663,'ビートたけし','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(22,'葛飾',NULL,1,453522,34.8,'西新井大師西',333,362640,'二宮和也','0','2019-05-20 00:00:00','2019-05-20 00:00:00'),(23,'江戸川',NULL,1,693519,49.9,'新小岩',346,392703,'松崎しげる','0','2019-05-20 00:00:00','2019-05-20 00:00:00');
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

-- Dump completed on 2019-05-21 11:06:34
