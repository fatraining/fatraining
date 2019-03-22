-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: fa
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB

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
-- Table structure for table `cat_main_nihonyanagi`
--

DROP TABLE IF EXISTS `cat_main_nihonyanagi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_main_nihonyanagi` (
  `id` int(3) NOT NULL,
  `cat_name` varchar(256) NOT NULL,
  `hair_id` int(3) DEFAULT NULL,
  `size_id` int(3) DEFAULT NULL,
  `character_id` int(3) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_main_nihonyanagi`
--

LOCK TABLES `cat_main_nihonyanagi` WRITE;
/*!40000 ALTER TABLE `cat_main_nihonyanagi` DISABLE KEYS */;
INSERT INTO `cat_main_nihonyanagi` VALUES (1,'スコティッシュフォールド',3,2,1,'折れ耳は骨が弱いことが多いので注意','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(2,'マンチカン',3,2,1,'短足かわいい','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(3,'ノルウェージャンフォレストキャット',2,1,2,'大きくて穏やかでかわいい。飼いたい。','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(4,'ベンガル',1,2,3,'見た目ワイルドな甘えん坊','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(5,'メインクーン',2,1,2,'穏やかな巨人。ノルとよく似ている','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(6,'ブリティッシュショートヘア',1,2,4,'約3年かけて大人になる。がっちり','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(7,'ペルシャ',2,2,2,'とっても上品でおとなしい猫','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(8,'エキゾチックショートヘア',1,2,2,'ペルシャより少し活発','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(9,'チンチラペルシャ',2,2,2,'ペルシャより少しふわふわ','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(10,'ラグドール',2,1,2,'ぬいぐるみの意。抱っこ大好き','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(11,'アメリカンショートヘア',1,2,5,'活発だけど警戒心も強い','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(12,'ミヌエット',3,3,3,'人懐っこい','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(13,'ロシアンブルー',1,2,4,'猫らしい猫。やきもち焼きなところも','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(14,'サイベリアン',2,1,2,'大柄で賢く身体能力の高いエリート','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(15,'シンガプーラ',1,3,3,'世界一小さい猫','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(16,'アビシニアン',1,3,3,'優雅な見た目で甘えん坊','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(17,'ラガマフィン',2,1,3,'抱っこも大好き。とってもおだやか','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(18,'ソマリ',2,3,1,'甘えたがりないたずらっ子','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(19,'トンキニーズ',1,2,1,'いつまでの子猫のような性格','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(20,'セルカークレックス',3,1,2,'羊の皮をかぶった猫','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(21,'シャルトリュー',1,1,2,'ほほえみ猫','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(22,'スコティッシュストレート',3,2,2,'耳の折れていないスコ','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(23,'ラパーマ',3,2,1,'犬のように従順で愛情深い','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(24,'キンカロー',3,3,1,'一人でいるより誰かと一緒がいい','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(25,'ヒマラヤン',2,2,2,'さりげなくいつもそばにいてくれる','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(26,'シャム',1,2,4,'よくしゃべる猫','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(27,'アメリカンカール',3,3,1,'耳がくるんと後ろに巻いている','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(28,'エジプシャンマウ',1,2,5,'リードをつけて散歩もできる','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(29,'エキゾッチクロングヘア',2,2,2,'ぶさかわ','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(30,'オリエンタルショートヘア',1,2,3,'しなやかで美しくとても寂しがり','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(34,'ジャパニーズボブテイル',1,2,4,'日本ネコの中でも尻尾が特徴的','0','2019-03-20 15:28:25','2019-03-20 15:28:25'),(36,'スフィンクス',1,2,1,'毛のないネコ。人見知りはしない。','0','2019-03-20 16:28:16','2019-03-20 16:28:16'),(38,'ボンベイ',1,2,3,'まるで某劇団のロゴのよう','0','2019-03-22 09:17:18','2019-03-22 09:17:18'),(39,'ジバニャン',1,3,1,'ネコの地縛霊のこと','0','2019-03-22 10:23:54','2019-03-22 10:23:54');
/*!40000 ALTER TABLE `cat_main_nihonyanagi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character_nihonyanagi`
--

DROP TABLE IF EXISTS `character_nihonyanagi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `character_nihonyanagi` (
  `id` int(3) NOT NULL,
  `cat_character` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character_nihonyanagi`
--

LOCK TABLES `character_nihonyanagi` WRITE;
/*!40000 ALTER TABLE `character_nihonyanagi` DISABLE KEYS */;
INSERT INTO `character_nihonyanagi` VALUES (0,NULL,NULL,'0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(1,'好奇心旺盛','人見知りせず狩りもする','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(2,'穏やか','あまり怒らず子供の相手もこなす','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(3,'甘えん坊','構ってもらいたがる','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(4,'自立','適度な距離を好む','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(5,'慎重','知らない人を警戒する','0','2019-03-12 00:00:00','2019-03-12 00:00:00');
/*!40000 ALTER TABLE `character_nihonyanagi` ENABLE KEYS */;
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
-- Table structure for table `hair_nihonyanagi`
--

DROP TABLE IF EXISTS `hair_nihonyanagi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hair_nihonyanagi` (
  `id` int(3) NOT NULL,
  `hair` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hair_nihonyanagi`
--

LOCK TABLES `hair_nihonyanagi` WRITE;
/*!40000 ALTER TABLE `hair_nihonyanagi` DISABLE KEYS */;
INSERT INTO `hair_nihonyanagi` VALUES (0,NULL,'0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(1,'短毛','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(2,'長毛','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(3,'短毛/長毛','0','2019-03-12 00:00:00','2019-03-12 00:00:00');
/*!40000 ALTER TABLE `hair_nihonyanagi` ENABLE KEYS */;
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
INSERT INTO `icecream_main_sako` VALUES (1,'チョコモナカジャンボ',2,'/icecreamSako/janbomonaka.jpg',1,'真ん中にパリパリのチョコ！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(2,'ピノ',1,'/icecreamSako/pino.jpg',1,'箱を開けるわくわく感',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(3,'パルム',1,'/icecreamSako/parm.jpg',1,'アイスの王道！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(4,'ザクレープ',2,'/icecreamSako/thecreap.jpg',1,'生地もおいしい',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(5,'チーズスティック',1,'/icecreamSako/cheesestick.jpg',1,'まるでチーズケーキ！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(6,'MOW',1,'/icecreamSako/mow.jpg',1,'ミルク感',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(7,'パピコ',4,'/icecreamSako/papico.jpg',2,'半分こできて良き',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(8,'アイスの実',4,'/icecreamSako/icenomi.jpg',2,'かわいいしおいしい◎',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(9,'ジャイアントコーン',2,'/icecreamSako/giantcone.jpg',2,'食べ応えもおいしさも抜群',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(10,'panapp',3,'/icecreamSako/panapp.jpg',2,'にこちゃん以外も出るよ',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(11,'スーパーカップ',3,'/icecreamSako/supercup.jpg',3,'コスパ最強',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(12,'ガリガリ君(ソーダ)',4,'/icecreamSako/gerigerikun.jpg',4,'ロングセラー商品',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(13,'雪見だいふく',2,'/icecreamSako/yukimidaihuku.jpg',5,'冬になったら食べたくなる！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(14,'爽',3,'/icecreamSako/sou.jpg',4,'シャープなキレのあるおいしさ',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(15,'モナ王',2,'/icecreamSako/monaou.jpg',5,'パリッとしてる',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(16,'あいすまんじゅう',1,'/icecreamSako/icemanjyu.jpg',6,'あんこ好きにはたまらない♪',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(17,'SACRE',4,'/icecreamSako/sacre.jpg',7,'夏になったら食べたくなる！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(18,'あずきバー',4,'/icecreamSako/azukibar.jpg',8,'家族みんなだいすき！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(19,'ハーゲンダッツ(ミルク)',1,'/icecreamSako/haagendazs.jpg',9,'頑張った日のご褒美♪',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(20,'ガツンと、みかん',4,'/icecreamSako/mikan.jpg',4,'まるごとみかん！',0,'2018-10-16 00:00:00','2018-10-16 00:00:00'),(21,'coolish',3,'/icecreamSako/coolish.jpg',5,'食べやすい',0,'2018-10-16 00:00:00','2018-10-16 00:00:00');
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
INSERT INTO `music` VALUES (4,'心太软','任贤齐',5,'年代比较久远的一首歌，当年很流行，现在依然有很多人喜欢。',3,'https://www.youtube.com/embed/ZSWeurc1yMw','2018-03-19 15:12:14','2018-03-19 15:12:14',5),(9,'漂洋过海来看你','娃娃',5,'',3,'https://www.youtube.com/embed/hNQohQBFnwI','2018-03-19 16:05:12','2018-03-19 16:05:12',2),(10,'雪の華','中島美嘉',5,'',5,'https://www.youtube.com/embed/mF5Qq2YheTg','2018-03-19 17:18:19','2018-03-19 17:18:19',1),(11,'MY ALL','濱崎步',5,'',5,'https://www.youtube.com/embed/PKptgq8jTYw','2018-03-19 17:27:07','2018-03-19 17:27:07',1),(12,'Time after time ～花舞う街で～','仓木麻衣',5,'',4,'https://www.youtube.com/embed/Ep_W5rYXyi0','2018-03-19 17:28:57','2018-03-19 17:28:57',1),(13,'夢的點滴','松隆子',5,'',6,'https://www.youtube.com/embed/Vn6xGeMY9w8','2018-03-19 17:31:46','2018-03-19 17:31:46',1),(14,'big big world','Emilia',5,'',5,'https://www.youtube.com/embed/wpkS2DU_qMs','2018-03-19 17:33:04','2018-03-19 17:33:04',0);
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
-- Table structure for table `size_nihonyanagi`
--

DROP TABLE IF EXISTS `size_nihonyanagi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size_nihonyanagi` (
  `id` int(3) NOT NULL,
  `size` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size_nihonyanagi`
--

LOCK TABLES `size_nihonyanagi` WRITE;
/*!40000 ALTER TABLE `size_nihonyanagi` DISABLE KEYS */;
INSERT INTO `size_nihonyanagi` VALUES (0,NULL,'0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(1,'大型','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(2,'中型','0','2019-03-12 00:00:00','2019-03-12 00:00:00'),(3,'小型','0','2019-03-12 00:00:00','2019-03-12 00:00:00');
/*!40000 ALTER TABLE `size_nihonyanagi` ENABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 10:56:06
