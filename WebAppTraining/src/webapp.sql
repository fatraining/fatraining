-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016 年 7 朁E11 日 08:29
-- サーバのバージョン： 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `webapp`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `aquarium`
--

CREATE TABLE IF NOT EXISTS `aquarium` (
`id` int(11) NOT NULL,
  `aquariumAreaId` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `hours` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=30 ;

--
-- テーブルのデータのダンプ `aquarium`
--

INSERT INTO `aquarium` (`id`, `aquariumAreaId`, `name`, `price`, `hours`, `comment`, `area`) VALUES
(1, 1, '横浜・八景島シーパラダイス', 3000, '9：00～20：00(季節により変動)', 'アトラクションも楽しめる', NULL),
(2, 1, 'ヨコハマおもしろ水族館', 1400, '11：00〜20：00(※平日)\r\n', 'アルビノのオオグソクムシがいる', NULL),
(3, 2, 'サンシャイン水族館', 1600, '10：00〜18：00', '空飛ぶアシカが見られる', NULL),
(4, 3, '鴨川シーワールド', 2800, '9：00〜16：30(※平日)\r\n', '人工の砂浜「ウミガメの浜」でウミガメが産卵できるようになっている', NULL),
(23, 1, '魚人島', 1400, '00：00～24：00', 'ぎょじんだらけ', NULL),
(27, 6, 'グンマー帝国水族館', 1000, '10：00～21：00', 'ぐんまのやぼう', NULL),
(28, 4, 'さいたま水族館', 300, '9：30～17：00', 'さいたま市は、3画目が離れた「さ」を許さない。', NULL),
(29, 7, 'アクアワールド茨城県大洗水族館', 1800, '9：00～17：00', 'いばらぎ、じゃなくて、いばらき', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `aquariumarea`
--

CREATE TABLE IF NOT EXISTS `aquariumarea` (
`id` int(11) NOT NULL,
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=8 ;

--
-- テーブルのデータのダンプ `aquariumarea`
--

INSERT INTO `aquariumarea` (`id`, `area`) VALUES
(1, '神奈川県'),
(2, '東京都'),
(3, '千葉県'),
(4, '埼玉県'),
(5, '栃木県'),
(6, '群馬県'),
(7, '茨城県');

-- --------------------------------------------------------

--
-- テーブルの構造 `area`
--

CREATE TABLE IF NOT EXISTS `area` (
`id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- テーブルのデータのダンプ `area`
--

INSERT INTO `area` (`id`, `name`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '新宿', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(2, '新橋', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(3, '秋葉原', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0),
(4, '上野', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0),
(5, '渋谷', '2016-05-09 00:00:00', 'struts2', '2016-05-09 00:00:00', 'struts2', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `baseballplayer`
--

CREATE TABLE IF NOT EXISTS `baseballplayer` (
`ID` int(11) NOT NULL,
  `teamID` int(11) NOT NULL,
  `baseballplayer` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `target` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(20) CHARACTER SET ujis COLLATE ujis_bin DEFAULT NULL,
  `note` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `team` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=24 ;

--
-- テーブルのデータのダンプ `baseballplayer`
--

INSERT INTO `baseballplayer` (`ID`, `teamID`, `baseballplayer`, `comment`, `target`, `date`, `note`, `team`) VALUES
(1, 5, '新井貴浩', 'もちろん自分自身もうれしかったですけど、今日ここにたくさん詰めかけていただいたファンの皆さんの喜んでいる姿を見て、それが嬉しかったです。', NULL, '2016/04/26', '（2000安打となるヒットを打って）二塁ベースに立った時の心境は？\r\n', NULL),
(2, 9, '金村曉', '絶対に許さない。外国人の監督だから個人の記録は関係ないのでしょう。顔も見たくない。', 'ヒルマン監督', '2006/09/24', '2桁勝利がかかったシーズン最終登板、3点リードの5回裏2死満塁で交代を命じられ勝ち投手の権利が消滅したことについて。', NULL),
(4, 4, '佐伯貴弘', 'もらった祝儀袋の中身が図書券だった感じ。', NULL, '2005', '全試合で4番を打ち、打率.272/19本塁打/88打点を記録しながらも、契約更改にて1億3000万円の現状維持提示を受けて。', NULL),
(5, 3, '井端弘和', 'ショックで震えることってあるんですね。金額を見た瞬間、足がガタガタして10分間くらいは無言でした。', NULL, '2005', '契約更改にて、3500万円アップの年俸1億7500万円を提示され保留。', NULL),
(6, 3, '藤井淳志', 'アイドルじゃないんで。イメージはどうでもいいです。', NULL, '2009', '契約条件を保留することによるイメージ悪化について。', NULL),
(8, 13, '中村紀洋', '中村紀洋というブランドを考えて、近鉄で終わっていいのか。', NULL, '2002', 'FA権を取得した際に。', NULL),
(10, 1, '長嶋茂雄', '長嶋茂雄であり続けることは、結構苦労するんですよ。', NULL, NULL, NULL, NULL),
(11, 2, '江本孟紀', 'ベンチがアホやから野球がでけへん。', NULL, '1981/08/26', '翌日、発言の責任を取って現役引退を表明。', NULL),
(23, 3, 'あああああああ', 'ああああ\r\n\r\nふにゃああああああああああ', '', '', '', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `baseballteam`
--

CREATE TABLE IF NOT EXISTS `baseballteam` (
`ID` int(11) NOT NULL,
  `team` varchar(100) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=14 ;

--
-- テーブルのデータのダンプ `baseballteam`
--

INSERT INTO `baseballteam` (`ID`, `team`) VALUES
(1, '巨人'),
(2, '阪神'),
(3, '中日'),
(4, '横浜'),
(5, '広島'),
(6, 'ヤクルト'),
(7, 'オリックス'),
(8, 'ソフトバンク'),
(9, '日本ハム'),
(10, 'ロッテ'),
(11, '西武'),
(12, '楽天'),
(13, 'その他');

-- --------------------------------------------------------

--
-- テーブルの構造 `beerbrands`
--

CREATE TABLE IF NOT EXISTS `beerbrands` (
`ID` int(11) NOT NULL,
  `beerbrands` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `categories` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `countryID` int(11) NOT NULL,
  `country` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin AUTO_INCREMENT=15 ;

--
-- テーブルのデータのダンプ `beerbrands`
--

INSERT INTO `beerbrands` (`ID`, `beerbrands`, `categories`, `comment`, `countryID`, `country`) VALUES
(1, 'Guiness', 'Ale', '', 1, NULL),
(10, 'Mahou', 'Pilsner', '', 11, NULL),
(11, 'Alhambra', 'Pilsner', '', 11, NULL),
(12, 'Pils', 'Pilsner', '', 4, NULL),
(13, 'Helles', 'Lager hell', '', 4, NULL),
(14, 'ebis', 'Ale', 'aaa', 9, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `biketeam`
--

CREATE TABLE IF NOT EXISTS `biketeam` (
  `ID` int(10) NOT NULL,
  `TeamName` varchar(300) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `biketeam`
--

INSERT INTO `biketeam` (`ID`, `TeamName`) VALUES
(1, 'Aprilia Racing Team Gresini'),
(2, 'Aspar Team MotoGP'),
(3, 'Anvintia Racing'),
(4, 'Ducati Team'),
(5, 'Estrella Galicia 0,0 Marc VDS'),
(6, 'LCR Honda'),
(7, 'Monster Yamaha Tech3'),
(8, 'Movistar Yamaha MotoGP'),
(9, 'OCTO Pramac Yakhnich'),
(10, 'Repsol Honda Team'),
(11, 'Team SUZUKI ECSTAR'),
(12, 'Retirement'),
(13, 'Other');

-- --------------------------------------------------------

--
-- テーブルの構造 `birthplace`
--

CREATE TABLE IF NOT EXISTS `birthplace` (
`ID` int(11) NOT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=16 ;

--
-- テーブルのデータのダンプ `birthplace`
--

INSERT INTO `birthplace` (`ID`, `country`) VALUES
(1, 'Republic of Ireland'),
(2, 'London'),
(3, 'France'),
(4, 'Germany'),
(5, 'Italy'),
(6, 'Belgium'),
(7, 'United States'),
(8, 'Brazil'),
(9, '日本'),
(10, 'China'),
(11, 'Spain'),
(12, 'Mexico'),
(13, 'Thailand'),
(14, 'Korea'),
(15, 'Russia ');

-- --------------------------------------------------------

--
-- テーブルの構造 `catarea`
--

CREATE TABLE IF NOT EXISTS `catarea` (
`ID` int(11) NOT NULL,
  `prefecture` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- テーブルのデータのダンプ `catarea`
--

INSERT INTO `catarea` (`ID`, `prefecture`) VALUES
(1, '東京'),
(2, '神奈川'),
(3, '千葉'),
(4, '埼玉');

-- --------------------------------------------------------

--
-- テーブルの構造 `catcafe`
--

CREATE TABLE IF NOT EXISTS `catcafe` (
`ID` int(11) NOT NULL,
  `catcafename` varchar(100) COLLATE utf8_bin NOT NULL,
  `prefectureID` int(11) NOT NULL,
  `station` varchar(100) COLLATE utf8_bin NOT NULL,
  `hours` varchar(100) COLLATE utf8_bin NOT NULL,
  `closed` varchar(100) COLLATE utf8_bin NOT NULL,
  `comment` varchar(100) COLLATE utf8_bin NOT NULL,
  `prefecture` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=29 ;

--
-- テーブルのデータのダンプ `catcafe`
--

INSERT INTO `catcafe` (`ID`, `catcafename`, `prefectureID`, `station`, `hours`, `closed`, `comment`, `prefecture`) VALUES
(1, '猫まるカフェ 上野店', 1, '上野', '11:00～22:00', 'なし', '', NULL),
(2, '猫カフェ MoCHA 渋谷店', 1, '渋谷', '10:00～22:00', 'なし', '', NULL),
(3, 'Nyafe Melange', 1, '恵比寿', '12:00～20:00', 'なし', '', NULL),
(22, '猫カフェ きゃりこ 新宿店', 1, '新宿', '10:00～22:00', 'なし', '', NULL),
(23, 'Cat Cafe ねころび', 1, '池袋', '11:00～23:00', 'なし', '', NULL),
(24, 'ねこカフェクラブ', 1, '自由が丘', '11:00～19:00', 'なし', '', NULL),
(26, '猫カフェ れおん', 2, '石川町', '11:00～22:00', 'なし', '', NULL),
(28, '猫カフェ にゃんくる 鎌倉店', 2, '鎌倉', '11:00～20:00', 'なし', 'もふってきたよ', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `groupname`
--

CREATE TABLE IF NOT EXISTS `groupname` (
  `GroupID` varchar(2) NOT NULL,
  `GroupName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=sjis;

--
-- テーブルのデータのダンプ `groupname`
--

INSERT INTO `groupname` (`GroupID`, `GroupName`) VALUES
('A', 'アンジュルム'),
('C', '℃-ute'),
('CF', 'つばきファクトリー'),
('CG', 'カントリー・ガールズ'),
('H', 'Hollo!Ploject'),
('HK', 'ハロプロ研修生'),
('J', 'Juice=Juice'),
('KF', 'こぶしファクトリー'),
('M', 'モーニング娘。’16');

-- --------------------------------------------------------

--
-- テーブルの構造 `guitarinfo`
--

CREATE TABLE IF NOT EXISTS `guitarinfo` (
`id` int(11) NOT NULL,
  `guitarMakerId` int(11) NOT NULL,
  `typeName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) NOT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=27 ;

--
-- テーブルのデータのダンプ `guitarinfo`
--

INSERT INTO `guitarinfo` (`id`, `guitarMakerId`, `typeName`, `price`, `comment`, `name`) VALUES
(1, 1, 'Classic　Style-S', 241900, NULL, NULL),
(2, 1, 'Classic Style-T', 222700, NULL, NULL),
(3, 1, 'Classic Style-JM', 230900, NULL, NULL),
(4, 2, 'Reunion', 340000, NULL, NULL),
(5, 2, 'Ab''s24[6-strings]', 398000, NULL, NULL),
(6, 2, 'Ab''s24[6-strings]', 438000, NULL, NULL),
(7, 3, 'Arc-STD VS-100N', 490000, NULL, NULL),
(8, 3, 'Arc-Hollow', 510000, NULL, NULL),
(9, 3, 'DST Droptop Quilted Maple', 347000, NULL, NULL),
(10, 4, 'Masterfield MFA-FP', 285000, NULL, NULL),
(11, 4, 'Expert EEL-DE-7', 250000, NULL, NULL),
(12, 4, 'Expert EFL-FM', 275000, NULL, NULL),
(13, 5, 'MAROON CUSTOM 666 Limited Hight', 500000, NULL, NULL),
(14, 5, 'HISTA CUSTOM 666', 370000, NULL, NULL),
(15, 5, 'BORDER BC CUSTOM 666', 390000, NULL, NULL),
(16, 6, 'DS 496 HR SPL/AT NAT', 426800, NULL, NULL),
(17, 6, 'DS 499 M', 324000, NULL, NULL),
(18, 7, 'STV Classic Series', 320000, NULL, NULL),
(19, 7, 'STV-CS1', 399000, NULL, NULL),
(20, 8, 'MLS1-STD', 390000, NULL, NULL),
(21, 8, 'MJM2-WTW', 270000, NULL, NULL),
(22, 8, 'MST2-SP NJ', 265800, NULL, NULL),
(23, 9, 'HORIZON-CTM FR', 680000, NULL, NULL),
(24, 9, 'ANTELOPE-CTM', 735000, NULL, NULL),
(25, 9, 'AMOUS FR-CTM', 680000, NULL, NULL),
(26, 9, 'POTBELLY-TR', 520000, NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `guitarmaker`
--

CREATE TABLE IF NOT EXISTS `guitarmaker` (
`id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=10 ;

--
-- テーブルのデータのダンプ `guitarmaker`
--

INSERT INTO `guitarmaker` (`id`, `name`) VALUES
(1, 'sago'),
(2, 'Crews Maniac Sound'),
(3, 'T''s Guitars'),
(4, 'Fujigen'),
(5, 'dragonfly'),
(6, 'Sugi'),
(7, 'Vanzandt'),
(8, 'MOMOSE'),
(9, 'ESP');

-- --------------------------------------------------------

--
-- テーブルの構造 `iventcontents`
--

CREATE TABLE IF NOT EXISTS `iventcontents` (
`ID` int(11) NOT NULL,
  `GroupID` varchar(2) DEFAULT NULL,
  `Category` varchar(20) DEFAULT NULL,
  `IventName` varchar(100) DEFAULT NULL,
  `Place` varchar(100) DEFAULT NULL,
  `Day` datetime DEFAULT NULL,
  `Comment` varchar(100) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=sjis AUTO_INCREMENT=51 ;

--
-- テーブルのデータのダンプ `iventcontents`
--

INSERT INTO `iventcontents` (`ID`, `GroupID`, `Category`, `IventName`, `Place`, `Day`, `Comment`, `groupName`) VALUES
(8, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', 'さいたま市文化センター大ホール（埼玉）', '2016-04-23 13:00:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(9, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', 'さいたま市文化センター大ホール（埼玉）', '2016-04-23 16:30:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(10, 'A', '即売系', '21stシングル『次々続々／糸島Distance／恋ならとっくに始まってる』発売＆ミニライブ＆握手会', 'ヴィーナスフォート協会広場（東京）', '2016-04-27 17:30:00', '和田中西竹内勝田田村室田相川佐々木上國料', NULL),
(15, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', '結城市民文化センター アクロス (茨城)', '2016-05-15 15:00:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(16, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', '結城市民文化センター アクロス (茨城)', '2016-05-15 18:30:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(22, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', '富岡本店 店内イベントスペース（山形）', '2016-05-14 10:30:00', '尾形', NULL),
(23, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'エスパル郡山 1Fセンターコート（福島）', '2016-05-14 14:00:00', '尾形', NULL),
(26, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'アリオ川口 １Fセンターコート（埼玉)', '2016-05-14 19:30:00', '譜久村佐藤尾形野中', NULL),
(28, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'そごう横浜店 ２F 鐘の広場（神奈川）', '2016-05-14 18:30:00', '鈴木（香）飯窪小田牧野', NULL),
(29, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'タワーレコード グランツリー武蔵小杉 店内イベントスペース（神奈川）', '2016-05-14 16:00:00', '牧野', NULL),
(30, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'イオンモール新潟南 館内 イオンシネマ（新潟）', '2016-05-14 10:30:00', '飯窪', NULL),
(31, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', '金沢フォーラス 6F KUUGO スクエア（石川）', '2016-05-14 10:45:00', '野中', NULL),
(32, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'イオンモール高岡 1階セントラルコート（富山）', '2016-05-14 13:45:00', '野中', NULL),
(39, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'タワーレコード京都店（京都）', '2016-05-14 16:00:00', '工藤', NULL),
(40, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'ハロー！プロジェクトオフィシャルショップ大阪店（大阪）', '2016-05-14 10:00:00', '羽賀', NULL),
(43, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'HMV三宮VIVRE 店内イベントスペース（兵庫）', '2016-05-14 19:00:00', '生田石田工藤羽賀', NULL),
(44, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'アリオ倉敷 屋外イベントステージ（岡山）', '2016-05-14 14:30:00', '羽賀', NULL),
(46, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'ミュージックプラザインドウ ２Fイベントスペース（福岡）', '2016-05-14 10:15:00', '牧野', NULL),
(47, 'C', '個別系', '29thシングル 『何故 人は争うんだろう？/ Summer Wind/人生はSTEP！』 発売記念 個別握手会', 'ベルサール飯田橋駅前（東京）', '2016-05-15 10:30:00', '矢島中島鈴木（愛）岡井萩原', NULL),
(48, 'M', 'その他', '演劇女子部「続・11人いる！東の地平・西の永遠」', '京都劇場(京都)', '2016-06-11 15:00:00', '譜久村生田飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(49, 'CF', 'その他', '演劇女子部「続・11人いる！東の地平・西の永遠」', '京都劇場(京都)', '2016-06-11 15:00:00', '山岸小片岸本浅倉', NULL),
(50, 'HK', 'その他', '演劇女子部「続・11人いる！東の地平・西の永遠」', '京都劇場(京都)', '2016-06-11 15:00:00', '橋本高瀬', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `nail`
--

CREATE TABLE IF NOT EXISTS `nail` (
`ID` int(11) NOT NULL,
  `date` char(20) COLLATE utf8_bin NOT NULL,
  `KisetuID` char(2) COLLATE utf8_bin NOT NULL,
  `maincolor` char(20) COLLATE utf8_bin NOT NULL,
  `handmodel` char(20) COLLATE utf8_bin NOT NULL,
  `comment` varchar(300) COLLATE utf8_bin NOT NULL,
  `imageFileName` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=37 ;

--
-- テーブルのデータのダンプ `nail`
--

INSERT INTO `nail` (`ID`, `date`, `KisetuID`, `maincolor`, `handmodel`, `comment`, `imageFileName`) VALUES
(1, '2016/02/22', 'sp', 'オレンジ', 'ひとみさん', 'ハイキューネイル', '1.jpg'),
(2, '2016/04/21', 'sp', 'ホワイト', 'ひとみさん', 'おそ松さんネイル', '2.jpg'),
(3, '2016/08/06', 'su', 'グリーン', 'やよいさん', '夏パールネイル', '3.jpg'),
(4, '2016/07/18', 'su', 'ピンク', 'じぶん', '成人式ネイル\r\n着物に合わせて施術', '4.jpg'),
(5, '2016/10/22', 'au', 'グレー', 'じぶん', '秋冬ネイル', '5.jpg'),
(6, '2016/09/22', 'au', 'レッド', 'じぶん', 'ワインレッドの秋ネイル', '6.jpg'),
(7, '2016/02/22', 'wi', 'レッド', 'ひとみさん', 'バレンタインネイル', '7.jpg'),
(8, '2016/12/24', 'wi', 'ピンク', 'じぶん', 'クリスマスネイル', '8.jpg'),
(36, '2016/05/09', 'sp', 'ブルー', 'じぶん', 'ラメグラデネイル\r\n', '11695014_690307654434924_4673989754922144318_n.jpg');

-- --------------------------------------------------------

--
-- テーブルの構造 `operator`
--

CREATE TABLE IF NOT EXISTS `operator` (
  `ID` int(11) NOT NULL,
  `OperatorID` char(10) CHARACTER SET latin1 NOT NULL,
  `OperatorName` char(50) COLLATE utf8mb4_bin NOT NULL,
  `UserID` char(50) CHARACTER SET latin1 NOT NULL DEFAULT 'CURRENT_USER',
  `Date` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `operator`
--

INSERT INTO `operator` (`ID`, `OperatorID`, `OperatorName`, `UserID`, `Date`) VALUES
(0, 'S', 'SoftBank', 'CURRENT_USER', NULL),
(1, 'Y', 'Y!mobile', 'root@localhost', NULL),
(2, 'A', 'au', 'root@localhost', NULL),
(3, 'D', 'Docomo', 'root@localhost', NULL),
(4, 'F', 'SIMフリー', 'root@localhost', NULL),
(5, 'FT', 'FREETEL', 'root@localhost', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `phones`
--

CREATE TABLE IF NOT EXISTS `phones` (
`ID` int(11) NOT NULL,
  `OperatorID` char(11) CHARACTER SET latin1 NOT NULL,
  `PhonesName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Price` int(11) NOT NULL,
  `Size` char(11) CHARACTER SET latin1 NOT NULL,
  `Date` date NOT NULL,
  `Comment` text COLLATE utf8_bin NOT NULL,
  `operatorName` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=34 ;

--
-- テーブルのデータのダンプ `phones`
--

INSERT INTO `phones` (`ID`, `OperatorID`, `PhonesName`, `Price`, `Size`, `Date`, `Comment`, `operatorName`) VALUES
(1, 'Y', 'iPhone2', 13000, '4.5', '2013-03-25', 'てｓｔ', NULL),
(2, 'FT', 'MIYABI', 36000, '5.5', '2011-07-05', '', NULL),
(3, 'A', 'iPhone2', 74000, '4.5', '2014-10-24', '', NULL),
(4, 'D', 'Xperia Acco', 32000, '6', '2012-11-05', '', NULL),
(5, 'F', 'iPhone3', 120000, '3', '2015-07-15', '', NULL),
(6, 'S', 'HONEY By', 24000, '3.5', '2015-08-31', 'てｓ\r\n初めて買った機種', NULL),
(7, 'D', 'Galaxy', 56000, '5.5', '2016-04-01', 'test', NULL),
(8, 'F', 'GR5', 38000, '5.5', '2016-02-01', '', NULL),
(9, 'A', 'AQUOS PHONE', 87000, '6.4', '2014-07-08', '000', NULL),
(12, 'A', 'test', 11, '11.0', '2011-11-11', 'test', NULL),
(13, 'F', 'test', 45000, '4.0', '2015-00-06', '', NULL),
(32, 'F', 'High Five', 126000, '7.2', '2017-03-14', '', NULL),
(33, 'A', 'AQUOS PHONE', 72000, '5.5', '2015-02-20', '', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `player`
--

CREATE TABLE IF NOT EXISTS `player` (
`playerID` int(11) NOT NULL,
  `playername` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `teamID` int(11) DEFAULT NULL,
  `position` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `teamName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `imagePath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '画像へのパス'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=58 ;

--
-- テーブルのデータのダンプ `player`
--

INSERT INTO `player` (`playerID`, `playername`, `teamID`, `position`, `age`, `comment`, `teamName`, `imagePath`) VALUES
(1, '土井康平', 1, 'GK', 28, '', NULL, NULL),
(2, '谷口堅三', 1, 'FW', 28, '', NULL, NULL),
(3, '深井脩平', 2, 'DF', 23, '', NULL, NULL),
(4, '日高慶太', 2, 'MF', 26, '', NULL, NULL),
(5, '岡田大', 3, 'GK', 31, '', NULL, NULL),
(6, '渡辺匠', 3, 'MF', 34, '', NULL, NULL),
(7, '亀島周', 10, 'DF', 23, '', NULL, NULL),
(8, '前田俊介', 10, 'FW', 30, '', NULL, NULL),
(9, '宮城晃太', 13, 'MF', 23, '', NULL, NULL),
(10, 'パブロ', 13, 'FW', 20, '', NULL, NULL),
(11, '修行智仁', 11, 'GK', 32, '', NULL, NULL),
(12, 'パウリーニョ', 11, 'FW', 34, '', NULL, NULL),
(13, '鈴木義宜', 11, 'DF', 24, '', NULL, NULL),
(56, 'dorami', 6, 'DF', 5, 'オラァ！', NULL, '1462506571163.jpg'),
(57, 'みんなの友達', 10, 'FW', 0, '俺を玩具にしてんじゃねえぞ', NULL, '1462509120132.jpg');

-- --------------------------------------------------------

--
-- テーブルの構造 `restaurant`
--

CREATE TABLE IF NOT EXISTS `restaurant` (
`id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stars` smallint(6) DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- テーブルのデータのダンプ `restaurant`
--

INSERT INTO `restaurant` (`id`, `name`, `stars`, `comment`, `area_id`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '四文屋', 4, '安くて美味いです。アキバとかにもあります。隣のカレー屋がいつもいい匂いさせててつらい。', 1, '2015-12-05 08:24:51', 'struts2', '2016-04-27 15:47:39', 'Struts2', 1),
(2, 'てけてけ', 3, '割と安い。味はそこそこ。', 1, '2016-04-18 21:37:00', '豚野郎', '2016-04-18 21:37:00', '豚野郎', 0),
(3, '四文屋', 4, '安くて美味いです。\r\n新宿とかにもあります。\r\nなんか外人の店員が多い気がする。', 3, '2016-04-19 20:33:09', 'Struts2', '2016-04-19 20:33:09', 'Struts2', 0),
(5, '大衆居酒屋 いこい', 3, 'ハイボールが180円。でも食い物は別に安くない。ぶつ爆弾がうまかった。', 5, '2016-05-09 00:00:00', 'struts2', '2016-05-12 13:50:34', 'Struts2', 2);

-- --------------------------------------------------------

--
-- テーブルの構造 `rider`
--

CREATE TABLE IF NOT EXISTS `rider` (
`ID` int(10) NOT NULL,
  `Number` int(10) DEFAULT NULL,
  `RiderName` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `TeamID` int(10) DEFAULT NULL,
  `Country` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Age` int(10) DEFAULT NULL,
  `BirthDay` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Comment` varchar(500) CHARACTER SET latin1 NOT NULL,
  `teamName` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=29 ;

--
-- テーブルのデータのダンプ `rider`
--

INSERT INTO `rider` (`ID`, `Number`, `RiderName`, `TeamID`, `Country`, `Age`, `BirthDay`, `Comment`, `teamName`) VALUES
(1, 4, 'Andrea Dovizioso', 4, 'ITA', 30, '1986/3/23', '', NULL),
(2, 6, 'Stefan Bradl', 1, 'DEU', 26, '1989/11/29', '', NULL),
(3, 8, 'Hector Barbera', 3, 'ESP', 29, '1986/11/2', '', NULL),
(4, 9, 'Danilo Petrucci', 9, 'ITA', 25, '1990/10/24', '', NULL),
(5, 19, 'Alvaro Bautista', 1, 'ESP', 31, '1984/11/21', '', NULL),
(6, 25, 'Maverick Vinales', 11, 'ESP', 21, '1995/1/12', '', NULL),
(7, 26, 'Dani Pedrosa', 10, 'ESP', 30, '1985/9/29\r\n', '', NULL),
(8, 29, 'Andrea Iannone', 4, 'ITA', 26, '1989/8/9', '', NULL),
(10, 38, 'Bradley Smith', 7, 'GBR', 25, '1990/11/28', '', NULL),
(11, 41, 'Aleix Espargaro', 11, 'ESP', 26, '1989/7/30', '', NULL),
(12, 43, 'Jack Miller', 5, 'AUS', 21, '1995/1/18', '', NULL),
(13, 44, 'Pol Espargaro', 7, 'ESP', 24, '1991/6/10', '', NULL),
(14, 45, 'Scott Redding', 9, 'GBR', 23, '1993/1/4', '', NULL),
(15, 46, 'Valentino Rossi', 8, 'ITA', 37, '1979/2/16', '', NULL),
(16, 50, 'Eugene Laverty', 2, 'IRL', 29, '1986/6/3', '', NULL),
(17, 53, 'Tito Rabat', 5, 'ESP', 26, '1989/5/25', '', NULL),
(18, 68, 'Yonny Hernandez', 2, 'COL', 27, '1988/7/25', '', NULL),
(19, 76, 'Loris Baz', 3, 'FRA', 23, '1993/2/1', '', NULL),
(20, 93, 'Marc Maruquez', 10, 'ESP', 23, '1993/2/17', '', NULL),
(21, 99, 'Jorge Lorenzo', 8, 'ESP', 28, '1987/5/4', '', NULL),
(22, 27, 'Casey Stoner', 12, 'AUS', 30, '1985/10/16', '', NULL),
(27, 56, 'Shinya Nakano', 12, 'JPN', 38, '1977/10/10', '', NULL),
(28, 8, 'Guy Martin', 13, 'GBR', 34, '1981/11/4', 'Isle of Man TT Rider', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `sakearea`
--

CREATE TABLE IF NOT EXISTS `sakearea` (
`id` int(11) NOT NULL,
  `area` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- テーブルのデータのダンプ `sakearea`
--

INSERT INTO `sakearea` (`id`, `area`) VALUES
(1, '神泉町'),
(2, '道玄坂'),
(3, '円山町'),
(4, '渋谷'),
(5, '宇田川町'),
(6, '桜が丘');

-- --------------------------------------------------------

--
-- テーブルの構造 `sakeinfo`
--

CREATE TABLE IF NOT EXISTS `sakeinfo` (
`id` int(11) NOT NULL,
  `areaId` int(11) NOT NULL,
  `shopName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hours` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `recommend` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `priceHigh` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `priceLow` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `area` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=11 ;

--
-- テーブルのデータのダンプ `sakeinfo`
--

INSERT INTO `sakeinfo` (`id`, `areaId`, `shopName`, `hours`, `price`, `recommend`, `comment`, `priceHigh`, `priceLow`, `area`) VALUES
(1, 2, 'KURAND SAKE MARKET 渋谷店', '17:00-23:00', 3000, NULL, '日本酒時間無制限にて飲み放題', NULL, NULL, NULL),
(2, 1, '酒とさか菜', '17:30-24:00', 6000, NULL, 'なかなか飲めない珍しい日本酒をたくさん取り扱う', NULL, NULL, NULL),
(3, 4, 'sakeda', '18:00-24:00', 3000, NULL, 'リーズナブルで新鮮な魚、気の利いたおつまみと美味しい日本酒が飲める知る人ぞ知る人気の居酒屋', NULL, NULL, NULL),
(4, 3, '萬安', '17:30-23:00', 5000, NULL, '常時40種類の最高の状態で日本酒を管理', NULL, NULL, NULL),
(5, 5, 'うのさと', '17:00-23:30', 4000, NULL, '全国から厳選した地酒、焼酎を取り揃える', NULL, NULL, NULL),
(6, 4, '風ぐるま', '17:30-24:00', 3000, NULL, 'この道30年の店主が営む居酒屋', NULL, NULL, NULL),
(7, 2, '米心', '17:00-23:30', 4000, NULL, '新橋にある「野崎酒店」の姉妹店', NULL, NULL, NULL),
(8, 2, 'サカノチカ', '15:00-24:00', 3000, NULL, '日本酒メニューを日替わりで提供', NULL, NULL, NULL),
(9, 3, 'ぽつらぽつら', '18:00-24:00', 6000, NULL, '日本酒だけでなく国産のワインも充実', NULL, NULL, NULL),
(10, 6, '高太郎', '18:00-02:00', 6000, NULL, '食べログランキングトップ500入りを果たし予約困難な人気店', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `season`
--

CREATE TABLE IF NOT EXISTS `season` (
  `KisetuID` char(2) COLLATE utf8_bin NOT NULL,
  `Kisetu` char(1) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `season`
--

INSERT INTO `season` (`KisetuID`, `Kisetu`) VALUES
('sp', '春'),
('su', '夏'),
('au', '秋'),
('wi', '冬');

-- --------------------------------------------------------

--
-- テーブルの構造 `sim`
--

CREATE TABLE IF NOT EXISTS `sim` (
`ID` int(11) NOT NULL,
  `simService` varchar(20) NOT NULL,
  `charge` float NOT NULL,
  `GB` double(10,1) NOT NULL,
  `comment` text NOT NULL,
  `simOpeID` varchar(255) DEFAULT NULL,
  `SimOpeName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- テーブルのデータのダンプ `sim`
--

INSERT INTO `sim` (`ID`, `simService`, `charge`, `GB`, `comment`, `simOpeID`, `SimOpeName`) VALUES
(1, 'マイネオ Dプラン', 1600, 3.0, '音声通話付き3GBシムフリーでベストチョイス。サービス面（1GB無料プレゼント、パケットシェア、誰とでもデータ容量共有ができる、GBの繰越、自宅でMNP切替可能）が他の業者の良い所取りをしている。3GBは価格面で差がつきにくいので、サービス面で選ぼう。\r\n', '1', NULL),
(2, ' LTE・3G – ライトSプラン', 2150, 6.0, 'Wifiスポットが無料で利用できる。3日の通信速度制限（一定の通信料を越すと通信制限がかかる）がない。多少高くてもいいから、6GB使いたい人向け。', '2', NULL),
(3, '通話プラス LTE使い放題プラン', 2980, 100.0, 'LTEが使い放題のプランだが、3日間の通信制限がある。通信制限を超えると、制限後の速度も128kbpsとかなり遅くなる。', '3', NULL),
(4, 'マイネオ Aプラン', 1510, 3.0, 'mineoDとAの違いは、ドコモ回線かAU回線かの違い。現状、ドコモ回線よりも、AU回線の通信速度が早い。サービスはDプランには劣る。', '1', NULL),
(5, '通話SIMプラン', 1260, 1.0, '1GBで最安値を選びたいなら、DMM を選ぼう。一番安い。とはいえ、1GB以外のプランは他社との価格差が少ない。WiiMax持ちで、１GBで使うのが一番いいと思う。', '5', NULL),
(6, '音声通話みおふぉん', 1600, 3.0, 'これを選ぶなら、mioneを選ぼう。通信料は変わらないが、mioneはサービスが充実している。', '6', NULL),
(7, '3.1GBパック', 1600, 3.1, '差別化に失敗したかわいそうなSIM。100MBの違いなど、普通分からない。メリットは、楽天カフェ（渋谷）で即日発行できる。通信速度（200kb）を求めないなら、1250円プランがある。', '7', NULL),
(8, 'モバイル ONE – 音声対応SIM', 1600, 3.3, '一日の通信容量は110MB。1ヶ月で3.3GB使える。他には、スマートフォンで、電話番号が追加取得できる、050plus（月額300円）が無料で使える。', '8', NULL),
(9, '@nifty 音声通話対応SIMカード', 1600, 3.0, 'かけ放題サービス（月額1300円）がある以外、サービス面では他の業者に劣る。通話はラインかスカイプを使えばいいので、あえてこれを使う必要はないかな。', '9', NULL),
(10, '定額無制限プラン 音声通話プラス', 3736, 100.0, '定額無制限、通信制限なしのプラン。3日間10GBなど普通に使える。ネットフリックスやyoutubeをよく見る人にはいいかもしれない。でも、最大通信速度速度が遅いのが難点。後、値段が高い。', '10', NULL),
(11, 'データ＋音声通話プラン', 1680, 3.0, 'AU回線を借りているので、早い。参考サイトによれば、SIMフリーで一番早いとのこと。値段は他の3GBプランと変わらない。速度重視なら、これでいいかもしれない。', '11', NULL),
(12, '使ったぶ～んだけプラン', 800, 0.5, '音声通話SIMでおそらく最安値。サイトを見たが、会社名が不明だった。追加容量500MB毎に500円。2GB利用で月額2300円となるので、500MB以上利用するならやめとこう。', '12', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `simope`
--

CREATE TABLE IF NOT EXISTS `simope` (
  `ID` int(11) NOT NULL,
  `simOpeName` varchar(11) NOT NULL,
  `UserID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `simope`
--

INSERT INTO `simope` (`ID`, `simOpeName`, `UserID`) VALUES
(1, 'mineo', ''),
(2, 'BIGLOBE', ''),
(3, 'U-mobile', ''),
(5, 'DMMmobile', ''),
(6, 'IIJmio', ''),
(7, '楽天モバイル', ''),
(8, 'OCN', ''),
(9, '@nifty', ''),
(10, 'ぷららモバイルLTE', ''),
(11, 'UQ mobile', ''),
(12, '@モバイルくん。', '');

-- --------------------------------------------------------

--
-- テーブルの構造 `team`
--

CREATE TABLE IF NOT EXISTS `team` (
  `ID` int(11) NOT NULL,
  `teamname` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `team`
--

INSERT INTO `team` (`ID`, `teamname`) VALUES
(1, 'グルージャ盛岡'),
(2, 'ブラウブリッツ秋田'),
(3, '福島ユナイテッドFC'),
(4, '栃木S.C'),
(5, 'Y.S.C.C.横浜'),
(6, 'SC相模原'),
(7, 'AC長野パルセイロ'),
(8, 'カターレ富山'),
(9, '藤枝MYFC'),
(10, 'ガイナーレ鳥取'),
(11, '大分トリニータ'),
(12, '鹿児島ユナイテッドFC'),
(13, 'FC琉球'),
(14, 'FC東京U-23'),
(15, 'ガンバ大阪U-23'),
(16, 'セレッソ大阪U-23');
1111

--
-- テーブルの構造 `sneakers`
--

CREATE TABLE `sneakers` (
  `id` int(11) NOT NULL,
  `sneakersMakerId` int(11) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `series` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `maker` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `sneakers`
--

INSERT INTO `sneakers` (`id`, `sneakersMakerId`, `name`, `series`, `year`, `comment`, `maker`, `image`) VALUES
(1, 1, 'AIR HUARACHE', 'NIKE / AIR HUARACHE', 1991, '近年復刻し再び大流行。HUARACHEの語源はメキシコの履物"ハラッチ"から。', 'NIKE', 'assets/images/temp/air_huarache.jpg'),
(2, 2, 'DISC BLAZE', 'PUMA / DISC (TRINOMIC)', 1992, 'アッパーのディスクを回転させることでフィッティング。ハイテクスニーカーブームを牽引。', 'PUMA', 'assets/images/temp/disc_blaze.jpg'),
(3, 3, 'ZX8000', 'adidas / ZX (TORSION,EQUIPMENT)', 1989, 'ZXシリーズの最高傑作。', NULL, 'assets/images/temp/zx8000.jpg'),
(4, 4, 'INSTA PUMP FURY', 'Reebok / PUMP', 1994, 'ポンプで空気を送り込むことでフィッテング。ハイテクスニーカー界の屈指の人気作。', NULL, 'assets/images/temp/pump_fury.jpg'),
(5, 1, 'AIR MAX 1', 'NIKE / AIR MAX', 1987, '記念すべきAIR MAXシリーズ第1号。ハイテクスニーカー時代の幕開け。', NULL, 'assets/images/temp/air_max1.jpg'),
(6, 2, 'suede classic', '-', 1968, 'PUMA不朽の名作。1足以上持っておきたいクラシックスニーカー。', NULL, 'assets/images/temp/puma_suede.jpg'),
(7, 3, 'STAN SMITH', '-', 1973, '世界一売れたスニーカー。名前は同名テニスプレーヤーに由来。', NULL, 'assets/images/temp/stan_smith.jpg'),
(8, 1, 'AIR MAX 90', 'NIKE / AIR MAX', 1990, 'AIR MAXといったらこのモデルをイメージする人も多いはず。シリーズの代表作。', NULL, 'assets/images/temp/air_max90.jpg'),
(9, 5, 'ERA', '-', 1975, 'VANSの名作。スケーター向けのクラシックスニーカー。', NULL, 'assets/images/temp/era.jpg'),
(10, 1, 'AIR MAX 95', 'NIKE / AIR MAX', 1995, 'AIR MAXシリーズの中で根強い人気を誇る。', NULL, 'assets/images/temp/air_max95.jpg'),
(11, 7, 'ALL STAR Hi', 'CONVERSE / ALL STAR', 1917, '1917年発売。スニーカーの歴史はここから始まった。', NULL, 'assets/images/temp/allstar_hi.jpg'),
(12, 6, 'M996', '-', 1989, '歩き易い、履き易い、合わせ易い三拍子揃った美しいスニーカー。', NULL, 'assets/images/temp/nb_m996.jpg'),
(13, 7, 'ALL STAR OX', 'CONVERSE / ALL STAR', 1957, 'ALL STARのローカットモデル。CONVERSEといえばこれと言えるほど色褪せない名スニーカー。', NULL, 'assets/images/temp/allstar_ox.jpg'),
(14, 1, 'AIR FORCE 1', 'NIKE / AIR FORCE', 1982, 'スニーカーの王様。', NULL, 'assets/images/temp/airforce_1.jpg'),
(15, 1, 'CORTEZ', '-', 1972, 'NIKEのクラシックランニングシューズ。ナイロン製やレザー製などがある。読み方は「コルテッツ」', NULL, 'assets/images/temp/cortez.jpg'),
(16, 3, 'SUPERSTAR', '-', 1969, '「RUN DMC」が愛用。これを紐無しで履いている奴はかなりコアなHIPHOPファン。', NULL, 'assets/images/temp/superstar.jpg'),
(17, 5, 'OLD SKOOL', '-', 1978, '元はBMXライダーの為に作られたがスケーターから支持を集める。', NULL, 'assets/images/temp/oldskool.jpg'),
(18, 1, 'AIR HUARACHE LIGHT', 'NIKE / AIR HUARACHE', 1993, 'アッパー部分の網目が特徴。初代ハラチに劣らない人気作。', NULL, 'assets/images/temp/air_huarache_light.jpg'),
(19, 8, 'GEL-LYTE Ⅲ', 'ASICS / GEL', 1990, '国内最高メーカー"ASICS"の名作。海外からも高い評価。', NULL, 'assets/images/temp/gel_lyte3.jpg'),
(20, 4, 'VENTILATOR', '-', 1990, '機能性とデザイン性を兼ね備えたReebokのランニングシューズ。', NULL, 'assets/images/temp/ventilator.jpg'),
(21, 3, 'CAMPUS', '-', 1983, '「ビースティ・ボーイズ」が愛用したことで有名なadidasのローテクスニーカー。', NULL, 'assets/images/temp/campus.jpg'),
(22, 1, 'AIR ZOOM FRIGHT 96', 'NIKE / AIR ZOOM (FRIGHT)', 1996, '96年発売のハイテクバスケットボールシューズ。', NULL, 'assets/images/temp/air_zoom_fright.jpg'),
(23, 1, 'AIR MORE UPTEMPO', 'NIKE / AIR', 1996, 'サイドの「AIR」ロゴのインパクトが絶大。新作発売日に抽選でも買えないほどの人気作。', NULL, 'assets/images/temp/air_more_uptempo.jpg'),
(24, 1, 'AIR MAX 93', 'NIKE / AIR MAX (HUARACHE)', 1993, 'AIR MAXシリーズの93年モデル。270度のビジブルエアとハラチシステムが特徴。', NULL, 'assets/images/temp/air_max93.jpg'),
(25, 3, 'ZX500', 'adidas / ZX', 1984, 'adidasZXシリーズの第1号。当時のランニングシューズ界を牽引。', NULL, 'assets/images/temp/zx500.jpg'),
(26, 5, 'authentic', '-', 1966, 'VANS設立時に誕生。後のVANSの名作「ERA」の前身。ERAとの違いは履き口のパット部分。', NULL, 'assets/images/temp/authentic.jpg'),
(27, 3, 'ZX700', 'adidas / ZX', 1985, 'ZXシリーズの隠れた人気作。', NULL, 'assets/images/temp/zx700.jpg'),
(28, 6, 'M1400', '-', 1994, 'NBの最高傑作。元々高価格だがメイドインUSAだと更に高値。', NULL, 'assets/images/temp/nb_m1400.jpg\r\n'),
(29, 4, 'PUMP GRAPHLITE', 'Reebok / PUMP', 1992, '「INSTA PUNP FURY」のシューレース版。色鮮やかな配色が特徴。', NULL, 'assets/images/temp/pump_graphlite.jpg'),
(30, 3, 'GAZELLE	', '-', 1968, '細身のシルエットが特徴のadidasのクラシックスニーカー。読み方は「ガッツレー」', NULL, 'assets/images/temp/gazelle.jpg'),
(31, 2, 'R698	', 'PUMA / TRINOMIC', 1990, 'PUMAのクッションシステム「TRINOMIC」を搭載した。ミッドテクランニングシューズ。', NULL, 'assets/images/temp/r698.jpg'),
(42, 3, 'TORSION ALLEGRA', 'adidas / EQUIPMENT (TORSION)', 1992, 'adidasのクッション技術「TORSION」搭載。発売当時ランニングシューズにしてはデザインが近未来的と話題に。', NULL, 'assets/images/temp/torsion_allegra.jpg'),
(43, 5, 'SLIP ON', '-', 1979, '「靴紐なしで脱ぎ履きできる靴＝スリッポン」というように代名詞化しているがそのオリジナルモデルは79年にVANSが発売したこの「SLIP ON」', NULL, 'assets/images/temp/slipon.jpg');

--
-- テーブルの構造 `sneakersmaker`
--

CREATE TABLE `sneakersmaker` (
  `id` int(11) NOT NULL,
  `maker` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `sneakersmaker`
--

INSERT INTO `sneakersmaker` (`id`, `maker`) VALUES
(1, 'NIKE'),
(2, 'PUMA'),
(3, 'adidas'),
(4, 'Reebok'),
(5, 'VANS'),
(6, 'NEW BALANCE'),
(7, 'CONVERSE'),
(8, 'ASICS(ASICS Tiger)');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sneakersmaker`
--
ALTER TABLE `sneakersmaker`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`),
  ADD KEY `id_3` (`id`);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aquarium`
--
ALTER TABLE `aquarium`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `aquariumarea`
--
ALTER TABLE `aquariumarea`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `area`
--
ALTER TABLE `area`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `baseballplayer`
--
ALTER TABLE `baseballplayer`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `baseballteam`
--
ALTER TABLE `baseballteam`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `beerbrands`
--
ALTER TABLE `beerbrands`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `biketeam`
--
ALTER TABLE `biketeam`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `birthplace`
--
ALTER TABLE `birthplace`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `catarea`
--
ALTER TABLE `catarea`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `catcafe`
--
ALTER TABLE `catcafe`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `groupname`
--
ALTER TABLE `groupname`
 ADD PRIMARY KEY (`GroupID`);

--
-- Indexes for table `guitarinfo`
--
ALTER TABLE `guitarinfo`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guitarmaker`
--
ALTER TABLE `guitarmaker`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `iventcontents`
--
ALTER TABLE `iventcontents`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `nail`
--
ALTER TABLE `nail`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `operator`
--
ALTER TABLE `operator`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `phones`
--
ALTER TABLE `phones`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
 ADD PRIMARY KEY (`playerID`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
 ADD PRIMARY KEY (`id`), ADD KEY `FK965A4B3DF35C8430` (`area_id`);

--
-- Indexes for table `rider`
--
ALTER TABLE `rider`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sakearea`
--
ALTER TABLE `sakearea`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sakeinfo`
--
ALTER TABLE `sakeinfo`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sim`
--
ALTER TABLE `sim`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `simope`
--
ALTER TABLE `simope`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sneakers`
--
ALTER TABLE `sneakers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aquarium`
--
ALTER TABLE `aquarium`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `aquariumarea`
--
ALTER TABLE `aquariumarea`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `baseballplayer`
--
ALTER TABLE `baseballplayer`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `baseballteam`
--
ALTER TABLE `baseballteam`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `beerbrands`
--
ALTER TABLE `beerbrands`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `birthplace`
--
ALTER TABLE `birthplace`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `catarea`
--
ALTER TABLE `catarea`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `catcafe`
--
ALTER TABLE `catcafe`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `guitarinfo`
--
ALTER TABLE `guitarinfo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `guitarmaker`
--
ALTER TABLE `guitarmaker`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `iventcontents`
--
ALTER TABLE `iventcontents`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `nail`
--
ALTER TABLE `nail`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `phones`
--
ALTER TABLE `phones`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
MODIFY `playerID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `rider`
--
ALTER TABLE `rider`
MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `sakearea`
--
ALTER TABLE `sakearea`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `sakeinfo`
--
ALTER TABLE `sakeinfo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `sim`
--
ALTER TABLE `sim`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `sneakers`
--
ALTER TABLE `sneakers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `sneakersmaker`
--
ALTER TABLE `sneakersmaker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `restaurant`
--
ALTER TABLE `restaurant`
ADD CONSTRAINT `FK965A4B3DF35C8430` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
