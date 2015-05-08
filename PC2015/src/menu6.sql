-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 19:44
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
-- テーブルの構造 `like_game`
--

CREATE TABLE IF NOT EXISTS `like_game` (
`id` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `seriesId` int(11) DEFAULT NULL,
  `trump` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Origin` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updateDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addUserID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `upUserID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `another_flg` int(11) NOT NULL,
  `delete_flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `like_game`
--

INSERT INTO `like_game` (`id`, `title`, `seriesId`, `trump`, `Origin`, `addDate`, `updateDate`, `addUserID`, `upUserID`, `another_flg`, `delete_flg`) VALUES
(9, 'Fate/stay night', 20, 'ソード', '剣', '05/08', '05/08', 'sinozaki', 'sinozaki', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `like_series`
--

CREATE TABLE IF NOT EXISTS `like_series` (
`up_id` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `seriesNm` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updateDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addUserId` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `upUserId` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `another_flg` int(11) NOT NULL,
  `delete_flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `like_series`
--

INSERT INTO `like_series` (`up_id`, `seriesNm`, `addDate`, `updateDate`, `addUserId`, `upUserId`, `another_flg`, `delete_flg`) VALUES
(20, 'Fate/stay', '05/08', '05/08', 'sinozaki', 'sinozaki', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `like_game`
--
ALTER TABLE `like_game`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `like_series`
--
ALTER TABLE `like_series`
 ADD PRIMARY KEY (`up_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `like_game`
--
ALTER TABLE `like_game`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `like_series`
--
ALTER TABLE `like_series`
MODIFY `up_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
