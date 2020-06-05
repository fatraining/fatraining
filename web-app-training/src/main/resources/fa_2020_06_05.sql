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
INSERT INTO `area_ito` VALUES (0,NULL,'0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(1,'東京都','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(2,'埼玉県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(3,'千葉県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(4,'神奈川県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(5,'兵庫県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(6,'愛知県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(7,'新潟県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(8,'大阪府','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(9,'奈良県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(10,'福岡県','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(11,'京都府','0','2020-03-24 00:00:00','2020-03-24 00:00:00'),(12,'北海道','0','2020-03-24 00:00:00','2020-03-24 00:00:00');
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
INSERT INTO `band_main_ito` VALUES (1,'Fear,and loathing in LasVegas',1,5,2008,'なんちゃらラスベガスで覚えれればOK/★Step Of Terror','0',NULL,NULL),(2,'a crowd of rebellion',1,7,2007,'曲調、音、声エモさがえぐい/★Never Say A Gain','0',NULL,NULL),(3,'crossfaith',1,8,2006,'ライブで友人が骨折した/★Blue','0',NULL,NULL),(4,'Coldrain',1,6,2007,'サウンドがかっこいい/★F.T.T.T','0',NULL,NULL),(6,'HEY-SMITH',1,8,2006,'スカパンクが最高/★Drug Free Japan','0',NULL,NULL),(7,'SiM',1,4,2004,'レゲエ要素あり/★RiOT','0',NULL,NULL),(8,'マキシマムザホルモン',3,1,1998,'ライブ中みんな偏差値低くなる/★「F」','0',NULL,NULL),(9,'Ailiph　Doepa',1,1,2010,'インフルエンザのときに見るようなMV多い/★MARS','0',NULL,NULL),(10,'04Limted Sazabys',1,6,2008,'曲の爽快感/★Knife','0',NULL,NULL),(11,'フレデリック',1,5,2009,'歌声もビジュも強い双子/★TOGENKYO','0',NULL,NULL),(12,'キュウソネコカミ',1,5,2009,'キャッチーで面白い/★メンヘラちゃん','0',NULL,NULL),(13,'ELLEGARDEN',1,3,1998,'復活歓喜/★サンタクロース','0',NULL,NULL),(14,'女王蜂',1,5,2009,'メンバー1人1人のビジュ強い/★金星','0',NULL,NULL),(15,'打首獄門同好会',3,NULL,2004,'Baが還暦に見えない、飯テロバンド/★島国DNA','0',NULL,NULL),(16,'凛として時雨',3,2,2002,'ツインボ×ドラムが最高/★nakano kill you','0',NULL,NULL),(17,'THE ORAL CIGARETTES',1,9,2010,'ダークな雰囲気かもしてる/★DIP-BAP','0',NULL,NULL),(18,'FACT',1,NULL,1999,'お面バンド/★error','0',NULL,NULL),(19,'MAN WITH A MISSIOM',1,1,2010,'狼バンド/★NEVER FXXKIN\' MIND THE RULES','0',NULL,NULL),(20,'The BONEZ',1,NULL,2012,'JESSEかっこいい/★Hello Monster','0',NULL,NULL),(21,'アルカラ',1,5,2002,'Voが首にタンバリン装備している（使わない）/★チクショー','0',NULL,NULL),(22,'ポルカドットスティングレイ',2,10,2015,'力強い女性Vo/★エレクトリック・パブリック','0',NULL,NULL),(23,'魔法少女になり隊',2,NULL,2014,'Voがしゃべれなくなる呪いをかけられていて可愛い/★ヒメサマスピリッツ','0',NULL,NULL),(24,'クリープハイプ',1,1,2001,'声が癖になる/★鬼','0',NULL,NULL),(25,'マカロニえんぴつ',1,4,2012,'朝方に聴いたらエモかった/★ワンドリンク別','0',NULL,NULL),(26,'サンボマスター',1,1,2000,'ライブで一番泣けるバンド/★ラブソング','0',NULL,NULL),(27,'そこに鳴る',3,8,2011,'ツインの重なり合いが良い/★掌で踊る','0',NULL,NULL),(28,'ヒステリックパニック',1,6,2012,'重くてキャッチーなサウンドで良い/★般若','0',NULL,NULL),(29,'ROTTENGRAFFTY',1,11,1999,'掛け合いがかっこ良い/★金色グラフティー','0',NULL,NULL),(30,'サカナクション',1,12,2005,'新宝島の動きが頭から離れない/★多分、風','0',NULL,NULL),(31,'夜の本気ダンス',1,NULL,2008,'着てるシャツがいつもおしゃれ/★with out you','0',NULL,NULL),(32,'Survive Said The Prophet',1,1,2011,'バンド名読みづらい/★found & lost','0',NULL,NULL),(33,'夕闇に誘いし漆黒の天使達',1,4,2015,'ブレイクダウンがおもしろいyoutuberバンド/★君に届かない声はイタリアにも届かない、故にミラノ風','0',NULL,NULL),(34,'Pay money To my Pain',1,1,2005,'もっと早く知っておけばよかったと思うバンド/★Sweetest vengeance','0',NULL,NULL),(35,'午前四時、朝焼けにツキ',1,7,2011,'メンバーが大きく変わっても曲がかっこいい/★因呶羅','0',NULL,NULL);
/*!40000 ALTER TABLE `band_main_ito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cd_main_kanayama`
--

DROP TABLE IF EXISTS `cd_main_kanayama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cd_main_kanayama` (
  `id` int(11) NOT NULL,
  `cd_title` varchar(252) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `artist_name` varchar(252) NOT NULL,
  `release_year` int(4) NOT NULL,
  `play_time` int(3) DEFAULT NULL,
  `comment` varchar(252) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cd_main_kanayama`
--

LOCK TABLES `cd_main_kanayama` WRITE;
/*!40000 ALTER TABLE `cd_main_kanayama` DISABLE KEYS */;
INSERT INTO `cd_main_kanayama` VALUES (1,'残響リファレンス',1,'ONE OK ROCK',2011,40,'Re:makeが入っているアルバムです。代表作です。','0','2020-05-19 00:00:00','2020-06-02 09:40:44'),(2,'絶対絶命',1,'RADWIMPS',2011,65,'君と羊と青が好きです。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'Schwarzenegger',1,'[Alexandros]',2012,57,'ボーカルがシュワちゃんが好きだからこのタイトルになったらしいです。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'period',1,'androp',2014,55,'13曲目のMissingのMVが切なくて好きです。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'心臓の居場所',1,'LEGO BIG MORL',2017,55,'あなたがいればいいのにのMVは吉沢亮さん出演で必見です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'ENTERTAINMENT',2,'SEKAI NO OWARI',2012,70,'今より尖ってる曲が多くて驚く人も多いと思います。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'GAME',2,'Parfume',2008,56,'ポリリズムの入っている、Parfumeの代表作です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'YANKEE',2,'米津玄師',2014,64,'アイネクライネが代表作で、MVは米津さんの手作りのアニメーションです。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'LEO',2,'家入レオ',2012,49,'当時17歳とは思えない綺麗な歌声と繊細な歌詞が引き立つ作品です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'Checkmate!',2,'安室奈美恵',2011,70,'全曲他のアーティストの方とコラボされていてとても豪華な1枚です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'÷(Deluxe)',3,'Ed Sheeran',2017,59,'shape of youを聞くと、とても踊りたくなります。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'Born This Way',3,'Lady GaGa',2011,100,'力強い歌声が印象的な、ガガの代表作です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'Avril Lavigne',3,'Avril Lavigne',2013,56,'ロックテイストな曲が多く、ロックとポップの融合を感じます。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'1',3,'Avicii',2013,73,'数年前、亡くなったことが今でも信じられません。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'1989',3,'Taylor Swift',1989,49,'聞いているだけで明るい気持ちになれるメロディーが印象的です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'紅蓮花',4,'LiSA',2019,17,'鬼滅の刃で一躍有名になった一曲です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'残酷な天使のテーゼ',4,'高橋洋子',1995,20,'エヴァを見たことがなくても知っている人の多い有名なアニソンです。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'青い栞',4,'Galileo Galilei',2011,17,'「あの花」のオープニングテーマとして知られている、GGの名曲です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'自由への進撃',4,'Linked Horizon',2013,15,'進撃の巨人のオープニングとして最も有名な紅蓮の弓矢が入っています。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(20,'打ち上げ花火',4,'DAOKO',2017,13,'映画の主題歌で、米津玄師さんとのコラボが話題になりました。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(21,'La La Land',5,'Various Artists',2016,46,'Someone In the Crowdを聞くと、映画のダンスシーンを鮮明に思い出します。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(22,'Phantom Of The Opera Original London Cast',5,'Various Artists',1986,101,'ミュージカル映画で最も好きなアルバムです。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(23,'魔女の宅急便',5,'久石譲',2004,37,'ドライブ中、海が見えると「海の見える街」を流します。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(24,'シンデレラ',5,'Various Artists',2005,60,'幼いころに何度も映画でみた、思い出の一枚です。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(25,'ハウルの動く城',5,'久石譲',2004,69,'人生のメリーゴーランドを聞くと、いつも空中散歩をするシーンを思い出します。','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(27,'空から降る一億の星',1,'plenty',2014,25,'切ない気分になる曲が多いアルバムです。','1','2020-06-02 09:52:48','2020-06-02 09:52:48'),(28,'RebelionStar',4,'Trickstar',2019,15,'あんさんぶるスターズ！','1','2020-06-02 15:50:35','2020-06-02 15:50:35');
/*!40000 ALTER TABLE `cd_main_kanayama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comic_main_yanai`
--

DROP TABLE IF EXISTS `comic_main_yanai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comic_main_yanai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comic_title` varchar(256) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `pubco_id` int(11) DEFAULT NULL,
  `volume` int(3) NOT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comic_main_yanai`
--

LOCK TABLES `comic_main_yanai` WRITE;
/*!40000 ALTER TABLE `comic_main_yanai` DISABLE KEYS */;
INSERT INTO `comic_main_yanai` VALUES (1,'HUNTER×HUNTER',1,1,36,'はやく続きが読みたい',0,'2020-05-20 12:00:00','2020-06-01 16:28:10'),(2,'幽遊白書',1,1,12,'終わり方がいい',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(3,'キングダム',5,3,57,'出てくる将軍がみんなかっこいい',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(4,'亜人',4,2,16,'もうちょいで終わりそう',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(5,'SLAM DUNK',2,1,20,'新装版だと区切りがよくていい',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(6,'ダイの大冒険',1,1,37,'めっちゃくちゃ王道',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(7,'銀河英雄伝説',4,1,17,'小説でも読みたくなった',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(8,'ドリフターズ',5,4,6,'面白いのにペースが遅すぎる',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(9,'波よ聞いてくれ',3,2,7,'一般人がラジオをやるコメディ漫画',0,'2020-05-20 12:00:00','2020-06-01 11:31:54'),(10,'海帝',5,3,5,'勉強になることが多い',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(11,'江戸城再建',6,3,2,'漫画本編だけでなくコラムが面白い',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(12,'インベスターZ',6,2,21,'株の世界がわかる',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(13,'サンクチュアリ',6,2,8,'内容が熱い',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(14,'王様達のヴァイキング',6,1,19,'手に汗握る展開が多い',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(15,'片喰と黄金',5,1,3,'出たばっかなのでこれから楽しみ',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(16,'ブルーピリオド',6,2,7,'美大生すごいなと思った',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(17,'荒川アンダーザブリッジ',3,4,15,'最後がよくわからなかった',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(18,'テガミバチ',1,1,20,'絵がきれい',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(19,'星を継ぐもの',4,3,4,'SF大作の漫画版',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(20,'DAYS',2,2,38,'主人公の成長が凄まじい',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(21,'バチバチ',2,4,16,'相撲漫画。兄弟子がかっこいい。',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(22,'バチバチBURST',2,4,12,'バチバチシリーズの第二部',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(23,'鮫島、最後の十五日',2,4,20,'作者が亡くなり未完のまま完結',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(24,'バクマン。',6,1,20,'漫画家は大変',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(25,'鋼の錬金術師',1,4,27,'初めて全巻かった漫画。',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(26,'進撃の巨人',1,2,31,'伏線がすごい！',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(27,'金色のガッシュ',1,3,33,'魔物の一人一人にストーリーがある',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(28,'GIANT KILLING',2,2,54,'監督が主人公の珍しいサッカー漫画',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(29,'ショート・ピース',6,3,1,'アオアシの作者の漫画。続巻希望',0,'2020-05-20 12:00:00','2020-05-20 12:00:00'),(30,'サラリーマン金太郎',6,1,30,'金ちゃんの人生が壮絶すぎる。',0,'2020-05-20 12:00:00','2020-05-20 12:00:00');
/*!40000 ALTER TABLE `comic_main_yanai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `container_ohkubo`
--

DROP TABLE IF EXISTS `container_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `container_ohkubo` (
  `id` int(11) NOT NULL,
  `container` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `container_ohkubo`
--

LOCK TABLES `container_ohkubo` WRITE;
/*!40000 ALTER TABLE `container_ohkubo` DISABLE KEYS */;
INSERT INTO `container_ohkubo` VALUES (0,NULL,'0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(1,'ペットボトル','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(2,'缶','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(3,'紙パック','0','2020-05-20 00:00:00','2020-05-20 00:00:00');
/*!40000 ALTER TABLE `container_ohkubo` ENABLE KEYS */;
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
-- Table structure for table `drink_main_ohkubo`
--

DROP TABLE IF EXISTS `drink_main_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drink_main_ohkubo` (
  `id` int(11) NOT NULL,
  `drink_name` varchar(256) NOT NULL,
  `maker_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `ml` int(11) DEFAULT NULL,
  `container_id` int(11) NOT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_main_ohkubo`
--

LOCK TABLES `drink_main_ohkubo` WRITE;
/*!40000 ALTER TABLE `drink_main_ohkubo` DISABLE KEYS */;
INSERT INTO `drink_main_ohkubo` VALUES (1,'コカ・コーラ',1,1,500,1,'一番メジャーな1','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'爽健美茶',1,2,600,1,'17種類の植物素材配合','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'CCレモン',2,1,500,1,'ビタミンCがたっぷり','0','2020-05-19 00:00:00','2020-06-04 13:40:00'),(4,'エメラルドマウンテン',3,3,190,2,'厳選された3%の高級豆を使用','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'BOSS贅沢微糖',2,3,185,2,'特別焙煎した厳選高級豆を中心にブレンド','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'コーヒー牛乳',4,4,500,3,'大人から子どもまで楽しめる4','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(7,'ファンタグレープ',1,1,500,1,'1958年に発売。日本で愛され続けているフレーバー','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(8,'おーいお茶',5,5,525,1,'独特の形状で光をカットし、鮮度を保つ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(9,'ポカリスエット',6,2,500,1,'体液に近い成分。体内に素早く吸収される','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(10,'綾鷹',1,5,525,1,'急須でいれたような味わい','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(11,'カルピスウォーター',7,2,500,1,'乳酸菌と酵母、発酵という自然製法が生みだす独自のおいしさ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(12,'いろはす',1,6,555,1,'厳選された全国7ヵ所で採水した水を使用','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(13,'CRAFTBOSS',2,3,500,1,'厳選した国産牛乳と北海道産の生クリームを合わせた優しいコク','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(14,'いちごオーレ',8,4,500,3,'甘みが強い国産のとちおとめだけを使用。ふんわりと香るミルク感が特徴','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(15,'カフェオーレ',8,4,500,3,'いつもかわらぬおいしさ。 癒しとやさしさを与えるロングセラー','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(16,'ペプシ',2,2,490,1,'口に入れた瞬間に感じる飲みごたえと飲み終わった後のキレのよさ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(17,'レッドブル',9,2,250,2,'翼を授ける','1','2020-05-19 00:00:00','2020-05-19 00:00:00'),(18,'モンスターエナジー',7,2,355,2,'独特の風味がしつつも刺激的でエナジーを感じる飲みごたえのある味','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(19,'生茶',10,5,525,1,'生茶葉のフレッシュなうまみに、鮮烈な5の香り','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(20,'南アルプスの天然水',2,6,550,1,'すっきりとキレがよく、さわやかな清涼感のある味わい','1','2020-05-19 00:00:00','2020-05-19 00:00:00'),(21,'ファンタ白桃',1,1,NULL,1,'500,おいしい,500,おいしい','0','2020-06-04 12:15:24','2020-06-04 12:15:24'),(22,'ファンタ白桃',1,1,NULL,1,'500,おいしい,500,おいしい,500,おいしい,500,おいしい','0','2020-06-04 12:15:34','2020-06-04 12:15:34'),(23,'ファンタ白桃',1,1,NULL,1,'500,おいしい,500,おいしい,500,おいしい,500,おいしい','1','2020-06-04 13:28:37','2020-06-04 13:28:37'),(24,'ファンタ白桃',1,1,NULL,1,'500,おいしい,500,おいしい,500,おいしい,500,おいしい','1','2020-06-04 13:30:23','2020-06-04 13:30:23'),(25,'ファンタ白桃',1,1,NULL,1,'500,おいしい,500,おいしい,500,おいしい,500,おいしい','1','2020-06-04 13:32:00','2020-06-04 13:32:00');
/*!40000 ALTER TABLE `drink_main_ohkubo` ENABLE KEYS */;
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
-- Table structure for table `genre_kanayama`
--

DROP TABLE IF EXISTS `genre_kanayama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_kanayama` (
  `id` int(11) NOT NULL,
  `genre` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_kanayama`
--

LOCK TABLES `genre_kanayama` WRITE;
/*!40000 ALTER TABLE `genre_kanayama` DISABLE KEYS */;
INSERT INTO `genre_kanayama` VALUES (0,NULL,'0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'Jrock','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'Jpop','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'洋楽','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'アニメ','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'サウンドトラック','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
/*!40000 ALTER TABLE `genre_kanayama` ENABLE KEYS */;
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
-- Table structure for table `genre_yanai`
--

DROP TABLE IF EXISTS `genre_yanai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_yanai` (
  `id` int(11) NOT NULL,
  `genre` varchar(256) NOT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_yanai`
--

LOCK TABLES `genre_yanai` WRITE;
/*!40000 ALTER TABLE `genre_yanai` DISABLE KEYS */;
INSERT INTO `genre_yanai` VALUES (0,' ','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(1,'バトル','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(2,'スポーツ','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(3,'日常、ギャグ','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(4,'SF','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(5,'歴史','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(6,'ヒューマンドラマ','0','2020-05-20 12:00:00','2020-05-20 12:00:00'),(7,'その他','0','2020-05-20 12:00:00','2020-05-20 12:00:00');
/*!40000 ALTER TABLE `genre_yanai` ENABLE KEYS */;
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
-- Table structure for table `maker_ohkubo`
--

DROP TABLE IF EXISTS `maker_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maker_ohkubo` (
  `id` int(11) NOT NULL,
  `maker` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maker_ohkubo`
--

LOCK TABLES `maker_ohkubo` WRITE;
/*!40000 ALTER TABLE `maker_ohkubo` DISABLE KEYS */;
INSERT INTO `maker_ohkubo` VALUES (0,NULL,'0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(1,'コカ・コーラ株式会社','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(2,'サントリー','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(3,'ジョージア','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(4,'雪印メグミルク','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(5,'伊藤園','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(6,'大塚製薬','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(7,'アサヒ飲料','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(8,'グリコ','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(9,'レッドブル','0','2020-05-20 00:00:00','2020-05-20 00:00:00'),(10,'キリン','0','2020-05-20 00:00:00','2020-05-20 00:00:00');
/*!40000 ALTER TABLE `maker_ohkubo` ENABLE KEYS */;
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
INSERT INTO `music` VALUES (4,'心太?','任??',5,'年代比?久?的一首歌，当年很流行，?在依然有很多人喜?。',3,'https://www.youtube.com/embed/ZSWeurc1yMw','2018-03-19 15:12:14','2018-03-19 15:12:14',5),(9,'漂洋?海来看?','娃娃',5,'',3,'https://www.youtube.com/embed/hNQohQBFnwI','2018-03-19 16:05:12','2018-03-19 16:05:12',2),(10,'雪の華','中島美嘉',5,'',6,'https://www.youtube.com/embed/mF5Qq2YheTg','2018-03-19 17:18:19','2019-03-28 15:26:31',2),(11,'MY ALL','濱崎?',5,'',5,'https://www.youtube.com/embed/PKptgq8jTYw','2018-03-19 17:27:07','2018-03-19 17:27:07',1),(12,'Time after time ～花舞う街で～','?木麻衣',5,'',4,'https://www.youtube.com/embed/Ep_W5rYXyi0','2018-03-19 17:28:57','2018-03-19 17:28:57',1),(13,'夢的點滴','松隆子',5,'',6,'https://www.youtube.com/embed/Vn6xGeMY9w8','2018-03-19 17:31:46','2018-03-19 17:31:46',1),(14,'big big world','Emilia',5,'',5,'https://www.youtube.com/embed/wpkS2DU_qMs','2018-03-19 17:33:04','2018-03-19 17:33:04',0);
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
INSERT INTO `sex_ito` VALUES (0,NULL,'0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(1,'男性','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(2,'女性','0','2018-03-01 00:00:00','2018-03-01 00:00:00'),(3,'男女','0','2018-03-01 00:00:00','2018-03-01 00:00:00');
/*!40000 ALTER TABLE `sex_ito` ENABLE KEYS */;
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
-- Table structure for table `type_ohkubo`
--

DROP TABLE IF EXISTS `type_ohkubo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_ohkubo` (
  `id` int(11) NOT NULL,
  `type` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_ohkubo`
--

LOCK TABLES `type_ohkubo` WRITE;
/*!40000 ALTER TABLE `type_ohkubo` DISABLE KEYS */;
INSERT INTO `type_ohkubo` VALUES (0,NULL,'0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(1,'炭酸飲料','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(2,'清涼飲料水','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(3,'コーヒー','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(4,'乳飲料','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(5,'緑茶','0','2020-05-19 00:00:00','2020-05-19 00:00:00'),(6,'ミネラルウォーター','0','2020-05-19 00:00:00','2020-05-19 00:00:00');
/*!40000 ALTER TABLE `type_ohkubo` ENABLE KEYS */;
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

-- Dump completed on 2020-06-05  9:52:27
