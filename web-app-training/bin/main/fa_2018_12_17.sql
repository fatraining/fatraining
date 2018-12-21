-- MySQL dump 10.16  Distrib 10.1.37 -MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: fa
-- -----------------------------------------------------
-- Server version	10.1.37 -MariaDB

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
-- Table structure for table `themepark_iwase`
--

DROP TABLE IF EXISTS `themepark_iwase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `themepark_iwase` (
  `id` int(2) NOT NULL,
  `themepark` varchar(256) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` varchar(14) NOT NULL,
  `update_date` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themepark_iwase`
--

LOCK TABLES `themepark_iwase` WRITE;
/*!40000 ALTER TABLE `themeoark_iwase` DISABLE KEYS */;
INSERT INTO `themepark` VALUES
	(1,'ワールドバザール',0,'2018/12/11','2018/12/11'),
	(2,'アドベンチャーランド',0,'2018/12/11','2018/12/11'),
	(3,'ウエスタンランド',0,'2018/12/11','2018/12/11'),
	(4,'クリッターカントリー',0,'2018/12/11','2018/12/11'),
	(5,'ファンタジーランド',0,'2018/12/11','2018/12/11'),
	(6,'トゥーンタウン',0,'2018/12/11','2018/12/11'),
	(7,'トゥモローランド',0,'2018/12/11','2018/12/11');
/*!40000 ALTER TABLE `themepark_iwase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attraction_main_iwase`
--
--

DROP TABLE IF EXISTS `attraction_main_iwase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attraction_main_iwase` (
  `id` int(11) NOT NULL,
  `attraction_name` varchar(256) NOT NULL,
  `themepark_id` int(2) NOT NULL,
  `open_date` int(20) NOT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `themepark_id` (`themepark_id`),
  CONSTRAINT `attraction_main_iwase_ibfk_1` FOREIGN KEY (`themepark_id`) REFERENCES `themepark` (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attraction_main`
--

LOCK TABLES `attraction_main_iwase` WRITE;
/*!40000 ALTER TABLE `themeoark` DISABLE KEYS */;
INSERT INTO `attraction_main_iwase` VALUES
( 1,'ペニーアーケード',1,'1983/04/01','古き良きアメリカのゲーム場。',0,'2018/12/11','2018/12/11')
, ( 2,'オムニバス',1,'1983/04/01','2階建てバスに乗ってプラザを一周。',0,'2018/12/11','2018/12/11')
, ( 3,'カリブの海賊',2,'1983/04/01','冒険とスリルに満ちた船旅に出発！そこにはキャプテン・ジャック・スパロウも。',0,'2018/12/11','2018/12/11')
, ( 4,'ジャングルクルーズ：ワイルドライフ・エクスペディション',2,'1983/04/01','ゆかいな船長と一緒に、野生の動物たちが住む神秘的なジャングルを探検！',0,'2018/12/11','2018/12/11')
, ( 5,'ウエスタンリバー鉄道',2,'1983/04/01','蒸気機関車に乗ってアメリカ西部をめぐる旅へ出発。',0,'2018/12/11','2018/12/11')
, ( 6,'スイスファミリー・ツリーハウス',2,'1993/07/01','無人島にたどり着いたロビンソン一家が暮らした大きな木の家を散策。',0,'2018/12/11','2018/12/11')
, ( 7,'魅惑のチキルーム：スティッチ・プレゼンツ"アロハ・エ・コモ・マイ！"',2,'2008/07/01','鳥たちが繰り広げる魅惑のショーに、いたずら好きのスティッチが！',0,'2018/12/11','2018/12/11')
, ( 8,'ウエスタンランド・シューティングギャラリー',3,'1983/04/01','西部一のガンマンをめざして射撃の腕試し！',0,'2018/12/11','2018/12/11')
, ( 9,'カントリーベア・シアター',3,'1983/04/01','個性あふれるゆかいなクマたちのにぎやかなコンサート。',0,'2018/12/11','2018/12/11')
, ( 10,'蒸気船マークトウェイン号',3,'1983/04/01','優雅な蒸気船でアメリカ河を一周。',0,'2018/12/11','2018/12/11')
, ( 11,'ビックサンダー・マウンテン',3,'1987/07/01','鉱山列車が、荒野を急旋回、急降下しながら大爆走！',0,'2018/12/11','2018/12/11')
, ( 12,'トムソーヤ島いかだ',3,'1983/04/01','アメリカ河を渡り、楽しい冒険に満ちたトムソーヤ島へ。',0,'2018/12/11','2018/12/11')
, ( 13,'スプラッシュ・マウンテン',4,'1989/07/01','丸太のボートでスリル満点の旅へ！',0,'2018/12/11','2018/12/11')
, ( 14,'ビーバーブラザーズのカヌー探検',4,'1983/04/01','みんなでカヌーをこいで出発！',0,'2018/12/11','2018/12/11')
, ( 15,'ピーターパン空の旅',5,'1983/04/01','空飛ぶ海賊船に乗って、ネバーランドへ。',0,'2018/12/11','2018/12/11')
, ( 16,'白雪姫と七人のこびと',5,'1983/04/01','トロッコに乗って冒険に出発。暗い森の中には恐ろしい魔女が…。',0,'2018/12/11','2018/12/11')
, ( 17,'シンデレラのフェアリーテイル・ホール',5,'2011/04/01','お城の中は、あこがれのシンデレラの世界！玉座やガラスの靴が見られます。',0,'2018/12/11','2018/12/11')
, ( 18,'ミッキーのフィルハ―マジック',5,'2011/01/01','ミッキーが指揮するコンサートが、ドナルドのせいで予想外の展開に！',0,'2018/12/11','2018/12/11')
, ( 19,'ピノキオの冒険旅行',5,'1983/04/01','トロッコに乗って、冒険の旅へ出発！',0,'2018/12/11','2018/12/11')
, ( 20,'空飛ぶダンボ',5,'1983/04/01','ダンボの背中に乗って大空へ。',0,'2018/12/11','2018/12/11')
, ( 21,'キャッスルカルーセル',5,'1983/04/01','バンドオルガンの美しい音色に合わせて走る白馬たち。',0,'2018/12/11','2018/12/11')
, ( 22,'ホーンテッドマンション',5,'1983/04/01','999の幽霊たちが住んでいる館。',0,'2018/12/11','2018/12/11')
, ( 23,'イッツ・ア・スモールワールド',5,'1983/04/01','世界中の子どもたちの歌声に包まれる、世界で一番幸せな船旅。',0,'2018/12/11','2018/12/11')
, ( 24,'アリスのティーパーティー',5,'1986/03/01','くるくる回るティーカップ。ふしぎの国のお茶会へようこそ！',0,'2018/12/11','2018/12/11')
, ( 25,'プーさんのハニーハント',5,'2000/09/01','ハニーポットに乗って、プーさんの大好きなはちみつを探しにいこう！',0,'2018/12/11','2018/12/11')
, ( 26,'ロジャーラビットのカートゥーンスピン',6,'1996/04/01','スピンするキャブに乗って、ロジャーラビットたちを助けに行こう！',0,'2018/12/11','2018/12/11')
, ( 27,'ミニーの家',6,'1996/04/01','おしゃれで料理が大好きなミニーのお部屋が見られるよ！',0,'2018/12/11','2018/12/11')
, ( 28,'チップとデールのツリーハウス',6,'1996/04/01','チップとデールのお家が見られるよ！',0,'2018/12/11','2018/12/11')
, ( 29,'ガジェットのゴーコースター',6,'1996/04/01','トゥーンタウンの天才発明家、ガジェットがつくったドングリのコースター。',0,'2018/12/11','2018/12/11')
, ( 30,'ドナルドのボート',6,'1996/04/01','トゥーンレイクに浮かんでいるのはドナルドの船「ミス・デイジー号」。船内のコントロールパネルを操作すると、ホーンが鳴ったり、ランプが光ったり。まるで船長になったような気分！',0,'2018/12/11','2018/12/11')
, ( 31,'グーフィーのペイント&プレイハウス',6,'2012/08/01','ペンキ噴射装置を使って、グーフィーの部屋を楽しく模様替え！',0,'2018/12/11','2018/12/11')
, ( 32,'トゥーンパーク',6,'1996/04/01','ミッキーが子どもたちのためにつくった彫刻で楽しく遊ぼう！',0,'2018/12/11','2018/12/11')
, ( 33,'スティッチ・エンカウンター',7,'2015/07/01','いたずら好きのスティッチと、ユーモアたっぷりのおしゃべりを楽しもう！',0,'2018/12/11','2018/12/11')
, ( 34,'モンスターズ・インク"ライド&ゴージーク！"',7,'2009/04/01','トラムに乗って、フラッシュライトでゆかいなモンスターたちを見つけよう！',0,'2018/12/11','2018/12/11')
, ( 35,'スターツアーズ：ザ・アドベンチャーズ・コンティニュー',7,'2013/05/01','スタースピーダー1000に乗って、スリリングで予測不能な冒険の旅へ。',0,'2018/12/11','2018/12/11')
, ( 36,'スぺース・マウンテン',7,'1983/04/01','銀河系や流星群の間をハイスピードで駆け抜けるスリリングな宇宙旅行。',0,'2018/12/11','2018/12/11')
, ( 37,'バズライトイヤーのアストロブラスター',7,'2004/04/01','スペースクルーザーに乗って、光線銃で悪の帝王ザーグたちをやっつけろ！',0,'2018/12/11','2018/12/11');
/*!40000 ALTER TABLE `attraction_main` ENABLE KEYS */;
UNLOCK TABLES;
--
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-09 16:27:19
