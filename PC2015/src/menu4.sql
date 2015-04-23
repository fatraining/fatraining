-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E23 日 07:44
-- サーバのバージョン： 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `task_master`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `band_account`
--

CREATE TABLE IF NOT EXISTS `band_account` (
`ID` int(50) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `SEX` varchar(50) DEFAULT NULL,
  `AGE` varchar(50) DEFAULT NULL,
  `SCHOOL` varchar(50) DEFAULT NULL,
  `FAVORITE_SONG` varchar(50) DEFAULT NULL,
  `PART` varchar(50) DEFAULT NULL,
  `BAND_ID` int(50) DEFAULT NULL,
  `ENTRY_DATE` varchar(50) DEFAULT NULL,
  `RENEWAL_DATE` varchar(50) DEFAULT NULL,
  `ENTRY_USERID` varchar(50) DEFAULT NULL,
  `RENEWAL_USERID` varchar(50) DEFAULT NULL,
  `EXCLUSION_FLG` int(50) DEFAULT NULL,
  `DELETE_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `band_account`
--

INSERT INTO `band_account` (`ID`, `NAME`, `SEX`, `AGE`, `SCHOOL`, `FAVORITE_SONG`, `PART`, `BAND_ID`, `ENTRY_DATE`, `RENEWAL_DATE`, `ENTRY_USERID`, `RENEWAL_USERID`, `EXCLUSION_FLG`, `DELETE_FLG`) VALUES
(1, '佐藤大樹', '男', '22', '城西大学', '二月の兵隊', 'ギター', 1, 'value-9', 'value-10', 'value-11', 'value-12', 0, 0),
(2, '山田', '男', '20', '銀座第23高校', '君が代', 'コーラス', 2, 'value-9', 'value-10', 'value-11', 'value-12', 0, 0),
(5, 'ダビデ', '男', '99', '美術館', 'レクイエム', 'ピアノ', 5, '2015/04/22 14:34:4', '2015/04/22 14:34:4', NULL, NULL, 0, 0),
(10, 'ｖｖｖｖ', 'あああ', '21', 'da', 'fs', 'fvs', 10, '2015/04/22 19:42:44', '2015/04/22 19:42:44', 'Struts2', 'Struts2', 0, 0),
(11, '田中さん', '女', '29', 'モンスターがハンターな学校', '戦闘曲B', '双剣', 11, '2015/04/23 10:26:28', '2015/04/23 10:26:28', 'tanaka', 'tanaka', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `band_table`
--

CREATE TABLE IF NOT EXISTS `band_table` (
`ID` int(50) NOT NULL,
  `BAND_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ENTRY_DATE` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `RENEWAL_DATE` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ENTRY_USERID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `RENEWAL_USERID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSION_FLG` int(50) DEFAULT NULL,
  `DELETE_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `band_table`
--

INSERT INTO `band_table` (`ID`, `BAND_NAME`, `ENTRY_DATE`, `RENEWAL_DATE`, `ENTRY_USERID`, `RENEWAL_USERID`, `EXCLUSION_FLG`, `DELETE_FLG`) VALUES
(1, '砂糖と塩', 'value-3', 'value-4', 'value-5', 'value-6', 0, 0),
(2, '時雨', '[value-3]', '[value-4]', '[value-5]', '[value-6]', 0, 0),
(3, 'da', NULL, NULL, NULL, NULL, NULL, NULL),
(5, '時雨', NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'ｖｖｖｖ', NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'こんがり焼けました', NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `band_account`
--
ALTER TABLE `band_account`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `band_table`
--
ALTER TABLE `band_table`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `band_account`
--
ALTER TABLE `band_account`
MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `band_table`
--
ALTER TABLE `band_table`
MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
