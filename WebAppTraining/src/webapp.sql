-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016 年 5 朁E13 日 03:37
-- サーバのバージョン： 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webapp`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `area`
--

CREATE TABLE `area` (
  `id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `area`
--

INSERT INTO `area` (`id`, `name`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '新宿', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(2, '新橋', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(3, '秋葉原', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0),
(4, '上野', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `biketeam`
--

CREATE TABLE `biketeam` (
  `ID` int(10) NOT NULL,
  `TeamName` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- テーブルの構造 `catarea`
--

CREATE TABLE `catarea` (
  `ID` int(11) NOT NULL,
  `prefecture` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

CREATE TABLE `catcafe` (
  `ID` int(11) NOT NULL,
  `catcafename` varchar(100) COLLATE utf8_bin NOT NULL,
  `prefectureID` int(11) NOT NULL,
  `station` varchar(100) COLLATE utf8_bin NOT NULL,
  `hours` varchar(100) COLLATE utf8_bin NOT NULL,
  `closed` varchar(100) COLLATE utf8_bin NOT NULL,
  `comment` varchar(100) COLLATE utf8_bin NOT NULL,
  `prefecture` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
-- テーブルの構造 `operator`
--

CREATE TABLE `operator` (
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

CREATE TABLE `phones` (
  `ID` int(11) NOT NULL,
  `OperatorID` char(11) CHARACTER SET latin1 NOT NULL,
  `PhonesName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Price` int(11) NOT NULL,
  `Size` char(11) CHARACTER SET latin1 NOT NULL,
  `Date` date NOT NULL,
  `Comment` text COLLATE utf8_bin NOT NULL,
  `operatorName` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
(27, 'FT', '3.14159265358979323846264', 3, '3.1415', '2016-02-29', 'pi', NULL),
(32, 'F', 'High Five', 126000, '7.2', '2017-03-14', '', NULL),
(33, 'A', 'AQUOS PHONE', 72000, '5.5', '2015-02-20', '', NULL),
(34, 'A', 'Galaxy', 56000, '5.5', '2016-04-02', '', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `player`
--

CREATE TABLE `player` (
  `playerID` int(11) NOT NULL,
  `playername` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `teamID` int(11) DEFAULT NULL,
  `position` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `teamName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `imagePath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '画像へのパス'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

CREATE TABLE `restaurant` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `restaurant`
--

INSERT INTO `restaurant` (`id`, `name`, `stars`, `comment`, `area_id`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '四文屋', 4, '安くて美味いのでオススメです。アキバとかにもあります。', 1, '2015-12-05 08:24:51', 'struts2', '2015-12-05 08:24:51', 'struts2', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `rider`
--

CREATE TABLE `rider` (
  `ID` int(10) NOT NULL,
  `Number` int(10) DEFAULT NULL,
  `RiderName` varchar(100) DEFAULT NULL,
  `TeamID` int(10) DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  `Age` int(10) DEFAULT NULL,
  `BirthDay` varchar(100) DEFAULT NULL,
  `Comment` varchar(500) NOT NULL,
  `teamName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- テーブルの構造 `sim`
--

CREATE TABLE `sim` (
  `ID` int(11) NOT NULL,
  `simService` varchar(20) NOT NULL,
  `charge` float NOT NULL,
  `GB` double(10,1) NOT NULL,
  `comment` text NOT NULL,
  `simOpeID` varchar(255) DEFAULT NULL,
  `SimOpeName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `simope` (
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

CREATE TABLE `team` (
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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `biketeam`
--
ALTER TABLE `biketeam`
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK965A4B3DF35C8430` (`area_id`);

--
-- Indexes for table `rider`
--
ALTER TABLE `rider`
  ADD PRIMARY KEY (`ID`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `catarea`
--
ALTER TABLE `catarea`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `catcafe`
--
ALTER TABLE `catcafe`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `phones`
--
ALTER TABLE `phones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `playerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `rider`
--
ALTER TABLE `rider`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `sim`
--
ALTER TABLE `sim`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
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
