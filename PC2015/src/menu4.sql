-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 05:23
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `band_account`
--

INSERT INTO `band_account` (`ID`, `NAME`, `SEX`, `AGE`, `SCHOOL`, `FAVORITE_SONG`, `PART`, `BAND_ID`, `ENTRY_DATE`, `RENEWAL_DATE`, `ENTRY_USERID`, `RENEWAL_USERID`, `EXCLUSION_FLG`, `DELETE_FLG`) VALUES
(1, '佐藤利夫', '男', '26', '早稲田大学', 'ストレンジカメレオン', 'ギター', 1, '2015/05/08 12:15:10', '2015/05/08 12:15:10', 'sato', 'sato', 0, 0),
(2, '山田太郎', '男', '17', '銀座第3高等学校', '鮮やかな殺人', 'ベース', 2, '2015/05/08 12:17:26', '2015/05/08 12:17:26', 'sato', 'sato', 0, 0),
(3, '木下キリン', '女', '15', 'さいたま芸術学校', 'Love/Hate', 'ドラム', 3, '2015/05/08 12:19:58', '2015/05/08 12:19:58', 'sato', 'sato', 0, 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `band_table`
--

INSERT INTO `band_table` (`ID`, `BAND_NAME`, `ENTRY_DATE`, `RENEWAL_DATE`, `ENTRY_USERID`, `RENEWAL_USERID`, `EXCLUSION_FLG`, `DELETE_FLG`) VALUES
(1, '砂糖と塩', '2015/05/08 12:15:10', '2015/05/08 12:15:10', 'sato', 'sato', 0, 0),
(2, '時雨', '2015/05/08 12:17:26', '2015/05/08 12:17:26', 'sato', 'sato', 0, 0),
(3, '芸術学校', '2015/05/08 12:19:58', '2015/05/08 12:19:58', 'sato', 'sato', 0, 0);

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
MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `band_table`
--
ALTER TABLE `band_table`
MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
