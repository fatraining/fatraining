-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016 年 4 朁E14 日 12:45
-- サーバのバージョン： 10.1.8-MariaDB
-- PHP Version: 5.6.14

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK965A4B3DF35C8430` (`area_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `phones`
--
ALTER TABLE `phones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
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
