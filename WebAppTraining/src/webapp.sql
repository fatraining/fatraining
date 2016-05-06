-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016 年 5 朁E06 日 08:43
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
(32, 'F', 'High Five', 126000, '7.2', '2017-03-14', '', NULL),
(33, 'A', 'AQUOS PHONE', 72000, '5.5', '2015-02-20', '', NULL);

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
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
