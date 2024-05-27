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
INSERT INTO `artist` VALUES (1,'Zebrahead','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(2,'FLOW','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(3,'?ｽﾄ津鯉ｿｽ?ｽt','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(4,'Anly','0','2018-05-23 01:27:00','2018-05-23 01:27:00'),(5,'fox capture plan','0','2018-05-23 01:27:00','2018-05-23 01:27:00');
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
INSERT INTO `author_nakano` VALUES (0,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(1,'宮沢 賢治','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(2,'太宰 治','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'夏目 漱石','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'中島 敦','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(5,'芥川 竜之介','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(6,'梶井 基次郎','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(7,'夢野 久作','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(8,'鴨 長明','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(9,'森 鴎外','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(10,'福沢 諭吉','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(11,'梶井 基次郎','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(12,'新美 南吉','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(13,'萩原 朔太郎','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(14,'高村 光太郎','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(15,'紀 貫之','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
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
INSERT INTO `book_main_nakano` VALUES (1,'〔雨ニモマケズ〕',1,10,3,'','0','2024-05-07 00:00:00','2024-05-20 09:43:45'),(2,'走れメロス',2,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'こころ',3,10,4,'「朝日新聞」19（大正3）年4〜8月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'山月記',4,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(5,'羅生門',5,10,4,'「帝国文学」1915（大正4）年11月号','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(6,'銀河鉄道の夜',1,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(7,'吾輩は猫である',3,10,4,'「ホトトギス」1905（明治38）年1月、2月、4月、6月、7月、10月、1906（明治39）年1月、3月、4月、8月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(8,'夢十夜',3,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(9,'やまなし',1,10,4,'「岩手毎日新聞」岩手毎日新聞社、1923（大正12年）4月8日','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(10,'人間失格',2,10,4,'「展望」筑摩書房、1948（昭和23）年6〜8月号','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(11,'駈込み訴え',2,10,4,'「中央公論」1940（昭和15）年2月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(12,'注文の多い料理店',1,10,4,'「イーハトヴ童話　注文の多い料理店」盛岡市杜陵出版部・東京光原社、1924（大正13）年12月1日','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(13,'蜘蛛の糸',5,10,4,'「赤い鳥」1918（大正7）年7月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(14,'檸檬',6,10,4,'「青空　創刊号」青空社、1925（大正14）年1月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(15,'坊っちゃん',3,10,4,'「ホトトギス」1906（明治39）年4月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(16,'ドグラ・マグラ',7,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(17,'草枕',3,10,4,'「新小説」1906（明治39）年9月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(18,'方丈記',8,10,1,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(19,'よだかの星',1,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(20,'『春と修羅』',1,10,3,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(21,'舞姫',9,10,3,'「國民之友」1890（明治23）年1月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(22,'学問のすすめ',10,4,4,'「学問のすすめ」1872（明治5）年2月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(23,'桜の樹の下には',11,10,4,'「詩と詩論」1928（昭和3）年12月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(24,'手袋を買いに',12,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(25,'風の又三郎',1,10,4,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(26,'月に吠える 「02 月に吠える」',13,10,3,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(27,'高瀬舟',9,10,1,'「中央公論　第三十一年第一號」1916（大正5）年1月','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(28,'ごん狐',12,10,4,'「赤い鳥　復刊第三巻第一号」1932（昭和7）年1月号','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(29,'智恵子抄',14,10,3,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(30,'土佐日記',15,10,1,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
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
INSERT INTO `cat_main_hayashichika` VALUES (2,'アメリカンショートヘアー',1,2,1,'脚が大きく、尻尾は長い','0','2024-05-07 09:00:00','2024-05-16 14:01:59'),(3,'スコティッシュフォールド',3,2,2,'突然変異で折れ耳に','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(4,'マンチカン',3,2,2,'脚の長さから毛柄まで多種多様に存在する','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(5,'ラグドール',2,4,1,'大きいぬいぐるみ','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(6,'サイベリアン',2,4,10,'水も怖がらないたくましさ','0','2024-05-07 09:00:00','2024-05-16 08:46:22'),(7,'ミヌエット',3,2,1,'人懐っこい小型猫','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(8,'ノルウェージャンフォレストキャット',2,4,8,'ゴージャスな長毛に隠れた筋肉','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(9,'ブリティッシュショートヘアー',1,2,2,'脚は短くてもプライドは高い','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(10,'ベンガル',1,4,1,'野性的な見た目だけど甘えん坊','0','2024-05-07 09:00:00','2024-05-16 13:47:22'),(11,'メインクーン',2,4,1,'世界一大きい猫','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(12,'エキゾチックショートヘア',1,1,1,'低い鼻と短い脚','0','2024-05-07 09:00:00','2024-05-14 10:45:03'),(13,'ペルシャ',2,1,2,'見た目も中身も上品','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(14,'ロシアンブルー',1,3,10,'犬っぽいけど猫らしさも十分ある','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(15,'セルカークレックス',3,2,1,'羊の皮をかぶった猫','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(16,'ラガマフィン',2,4,1,'たくましいけど一番愛されたい','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(17,'デボンレックス',1,3,2,'小顔なのに目と耳は大きい','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(18,'スフィンクス',1,3,4,'ほぼ無毛','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(19,'ソマリ',2,3,2,'キツネのような猫','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(20,'シャルトリュー',1,2,9,'がっしり体格に細い四肢','0','2024-05-07 09:00:00','2024-05-14 11:44:34'),(21,'トイボブ',1,1,10,'世界一小さい猫','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(22,'シンガプーラ',1,2,5,'小さくても筋肉質、人間大好き','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(23,'ジャパニーズボブテイル',3,3,7,'鍵しっぽと大人っぽい性格で日本代表','0','2024-05-07 09:00:00','2024-05-16 15:10:41'),(24,'ピクシーボブ',3,4,1,'鳴き方に個性有！','0','2024-05-07 09:00:00','2024-05-15 10:18:14'),(25,'ハイランダー',3,4,1,'外向きカールの耳','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(26,'シャム',1,6,6,'ポイントカラーとサファイアブルーは純血の証','0','2024-05-07 09:00:00','2024-05-16 15:43:09'),(32,'アビシニアン',1,3,3,'エレガントなわんぱく甘えん坊','0','2024-05-15 10:17:56','2024-05-15 10:17:56');
/*!40000 ALTER TABLE `cat_main_hayashichika` ENABLE KEYS */;
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
INSERT INTO `character_orthography_nakano` VALUES (0,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(1,'旧字旧仮名','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(2,'旧字新仮名','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'新字旧仮名','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'新字新仮名','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
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
INSERT INTO `classification_nakano` VALUES (0,'','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(1,'総記','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(2,'哲学','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(3,'歴史','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(4,'社会科学','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(5,'自然科学','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(6,'技術．工学','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(7,'産業','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(8,'芸術．美術','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(9,'言語','0','2024-05-07 00:00:00','2024-05-07 00:00:00'),(10,'文学?','0','2024-05-07 00:00:00','2024-05-07 00:00:00');
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
INSERT INTO `country_nakaniwa` VALUES (0,'','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(1,'日本','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(2,'韓国','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(3,'アメリカ','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(4,'中国','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(5,'イギリス','0','0000-00-00 00:00:00','0000-00-00 00:00:00');
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
INSERT INTO `drama_main_nakaniwa` VALUES (1,'花より男子',1,1,2005,2,'平凡な女子高生が超金持ち学校に入学。笑いあり涙ありの青春ラブストーリー！','0','2024-05-21 16:52:55','2024-05-27 13:08:22'),(2,'愛の不時着',1,2,2019,1,'パラグライダー中、事故に巻き込まれた韓国の財閥令嬢が北朝鮮に不時着。真実の愛に着地するラブストーリー。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(3,'大恋愛〜僕を忘れる君と',1,1,2018,1,'若年性アルツハイマーに侵される女性医師と元小説家の男性の、愛の奇跡を描く純愛ラブストーリー。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(4,'イカゲーム',2,2,2021,1,'ある日謎のゲームへの招待状が金に困っている人々の元へ届く。参加者は命がけのサバイバルゲームに挑むことに…。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(5,'ウォーキング・デッド',2,3,2010,11,'ゾンビがはびこるアメリカを舞台に、人間たちが時にぶつありあいながらも生き抜くすべを模索していく。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(6,'タンブリング',3,1,2010,1,'男子新体操を通じて成長する高校生をたちを描くスポ根青春ドラマ！','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(7,'プリズン・ブレイク',4,3,2005,5,'冤罪で死刑を宣告された兄を助けるために、主人公は兄と同じ刑務所に入り、脱獄する。スリリングなアクションドラマ。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(8,'ブラッシュアップライフ',5,1,2023,1,'平凡な女性が人生をやり直す姿を描くタイムスリップコメディ。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(9,'おっさんずラブ',5,1,2018,3,'モテない33歳のおっさんとその上司のおっさんが繰り広げる新感覚のコメディ恋愛ドラマ。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(10,'ミステリと言う勿れ',6,1,2022,1,'変わり者の大学生が喋りまくって事件の謎を解いていく新感覚ミステリー。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(11,'あなたの番です',6,1,2019,2,'新婚夫婦が引っ越したマンションで、ひょんなことから「交換殺人ゲーム」が始まり…。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(12,'恋愛できない私たち',1,4,2022,1,'年上キャリアウーマンと年下男性の恋！胸キュン間違いなしのラブコメディ！','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(13,'愛される花',1,4,2018,1,'初恋から10年ものあいだ一途に思い続ける愛の奇跡の物語。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(14,'ムービング',4,2,2023,1,'超能力を持つ子供たちと秘密を隠す親たちが、迫りくる悪と危険に立ち向かう超能力アクションドラマ。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(15,'silent',1,1,2022,1,'かつて本気で愛した人と音のない世界で出会い直す、切なくも温かいラブストーリー。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(16,'ONE DAY',1,5,2024,1,'大学卒業後それぞれの道を歩み始めた二人だが、その後も特別な交流を続けていくことになる…。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(17,'HEARTSTOPPER',1,5,2022,1,'学校で出会い、友達になった少年二人。やがて互いに友情以上の感情を抱くようになり…。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(18,'DIVE!!',3,1,2021,1,'所属するダイビングクラブの存続のために、飛込競技でオリンピックを目指す高校生たちの青春ドラマ。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(19,'エミリー、パリへ行く',1,3,2020,3,'シカゴで仕事に励んでいた主人公が思いがけずパリで念願の職を手に入れ、夢の海外生活を開始する。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(20,'正直不動産',5,1,2022,2,'不動産会社に勤める嘘のつけない営業マンが、不動産にまつわる様々なトラブルに立ち向かっていくコメディドラマ。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(21,'TRICK',6,1,2000,3,'自称天才マジシャンと大学教授のコンビが超常現象やトリックに立ち向かっていく物語。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(22,'今、私たちの学校は…',2,2,2022,1,'突然ゾンビウイルスが蔓延した高校に閉じ込められた生徒たちが、生き残るために力を合わせて戦う物語。','0','2024-05-21 16:52:55','2024-05-21 16:52:55'),(23,'逃げるは恥だが役に立つ',1,1,2016,1,'夫が雇用主で妻が従業員という契約結婚をする二人の新感覚社会派ラブコメディ！','0','2024-05-21 16:52:55','2024-05-21 16:52:55');
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
INSERT INTO `from_hayashichika` VALUES (0,'','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(1,'アメリカ','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(2,'イギリス','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(3,'エジプト','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(4,'カナダ','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(5,'シンガポール','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(6,'タイ','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(7,'日本','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(8,'ノルウェー','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(9,'フランス','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(10,'ロシア','0','2024-05-07 09:00:00','2024-05-07 09:00:00');
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
INSERT INTO `genre` VALUES (0,'',0,'2017/11/08','2017/11/08'),(1,'アクション',0,'2017/11/08','2017/11/08'),(2,'サスペンス',0,'2017/11/08','2017/11/08'),(3,'ヒューマン',0,'2017/11/08','2017/11/08'),(4,'ホラー',0,'2017/11/08','2017/11/08'),(5,'コメディ',0,'2017/11/08','2017/11/08');
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
INSERT INTO `genre_nakaniwa` VALUES (0,'','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(1,'恋愛','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(2,'ホラー','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(3,'スポーツ','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(4,'アクション','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(5,'コメディ','0','0000-00-00 00:00:00','0000-00-00 00:00:00'),(6,'ミステリー','0','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `genre_nakaniwa` ENABLE KEYS */;
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
INSERT INTO `movie_main` VALUES (1,'スパイダーマン3',1,2,2007,155,'スパイダーマンの映画の中では一番好き',1,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(2,'X-MEN FC',1,3,2011,132,'X-MEN誕生秘話、ばちぼこ面白い。',1,'2017-11-08 00:00:00','2021-05-27 15:33:27'),(3,'レオン',4,4,1994,110,'マチルダがかわいい',0,'2017-11-08 00:00:00','2024-05-20 15:46:09'),(4,'ダークナイトライジング',1,5,2012,165,'DCコミック頑張れ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(5,'ベイビードライバー',1,NULL,2017,113,'続編が制作されるそう',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(6,'トランス',2,3,2013,101,'ダニー・ボイル監督',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(7,'フィルス',2,3,2013,97,'スコットランドの最悪刑事',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(8,'華麗なるギャツビー',2,2,2013,143,'豪華絢爛',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(9,'ブリッジオブスパイ',2,1,2015,144,'アカデミー助演男優賞受賞',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(10,'ダ・ヴィンチ・コード',2,1,2006,174,'オドレイ・トトゥ老けたなあ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(11,'フォレストガンプ',3,1,1994,142,'言わずと知れた名言の宝庫',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(12,'完全なるチェックメイト',3,2,2014,116,'ボビーフィッシャー',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(13,'あの頃僕らは',3,2,2001,90,'若かりしディカプリオ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(14,'レミゼラブル',3,5,2012,160,'歌部分はアテレコではありません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(15,'グリーンマイル',3,1,1999,189,'『ショーシャンクの空に』もいいです',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(16,'ブラックスワン',4,4,2011,108,'下手なホラーより怖いかも',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(17,'IT chapter1',4,NULL,2017,135,'TVムービー編もどうぞ',0,'2017-11-08 00:00:00','2024-05-14 10:53:46'),(18,'キャリー',4,NULL,1976,98,'スティーブン・キングの処女作',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(19,'スプリット',4,3,2017,117,'シャマラン作品を見ておくと吉',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(20,'ミスターガラス',4,3,2019,129,'スプリットの続編',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(21,'マイ・インターン',5,5,2015,121,'『プラダを着た悪魔』もおすすめ',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(22,'ターミナル',5,1,2004,128,'空港に住んでみたい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(23,'ペネロピ',5,3,2008,104,'現代のおとぎ話',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(24,'アリスインワンダーランド',5,5,2010,113,'映像美すごい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(25,'キャッツ＆ドッグス',5,2,2001,87,'犬はかわいい',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(26,'つぐない',NULL,3,2007,130,'陰鬱な時にはおすすめしません',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(27,'プライドと偏見',NULL,NULL,2005,135,'コリン・ファースのドラマ版も良き',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(28,'グレイテストショーマン',3,NULL,2017,105,'個人的にラ・ラ・ランド越え',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(29,'ビッグ',5,1,1988,130,'素敵な気持になれる',0,'2017-11-08 00:00:00','2017-11-08 00:00:00'),(30,'IT chapter2',4,3,2019,NULL,'やたら豪華な俳優陣',0,'2017-11-08 00:00:00','2017-11-08 00:00:00');
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
INSERT INTO `size_hayashichika` VALUES (0,'','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(1,'コビー','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(2,'セミコビー','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(3,'フォーリン','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(4,'セミフォーリン','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(5,'ロング＆サブスタンシャル','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(6,'オリエンタル','0','2024-05-07 09:00:00','2024-05-07 09:00:00');
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
INSERT INTO `type_hayashichika` VALUES (0,'','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(1,'短毛','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(2,'長毛','0','2024-05-07 09:00:00','2024-05-07 09:00:00'),(3,'短毛・長毛','0','2024-05-07 09:00:00','2024-05-07 09:00:00');
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

-- Dump completed on 2024-05-27 15:23:31
