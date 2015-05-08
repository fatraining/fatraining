-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 10:56
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
-- テーブルの構造 `table_color`
--

CREATE TABLE IF NOT EXISTS `table_color` (
`id` int(50) NOT NULL,
  `colorNm` char(50) DEFAULT NULL,
  `day` char(50) DEFAULT NULL,
  `new_day` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `new_userid` char(50) DEFAULT NULL,
  `time_stamp` int(50) DEFAULT NULL,
  `deleteFlg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `table_color`
--

INSERT INTO `table_color` (`id`, `colorNm`, `day`, `new_day`, `userid`, `new_userid`, `time_stamp`, `deleteFlg`) VALUES
(1, '青', '2015/05/08 17:54:37', '2015/05/08 17:54:37', 'Struts2', 'Struts2', 0, 0),
(2, '白', '2015/05/08 17:55:16', '2015/05/08 17:55:16', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_like`
--

CREATE TABLE IF NOT EXISTS `table_like` (
`id` int(50) NOT NULL,
  `name` char(50) DEFAULT NULL,
  `food` char(50) DEFAULT NULL,
  `drink` char(50) DEFAULT NULL,
  `color` int(50) DEFAULT NULL,
  `day` char(50) DEFAULT NULL,
  `new_day` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `new_userid` char(50) DEFAULT NULL,
  `time_stamp` int(50) DEFAULT NULL,
  `deleteFlg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `table_like`
--

INSERT INTO `table_like` (`id`, `name`, `food`, `drink`, `color`, `day`, `new_day`, `userid`, `new_userid`, `time_stamp`, `deleteFlg`) VALUES
(1, '橘', 'ピザ', '水', 1, '2015/05/08 17:54:37', '2015/05/08 17:54:37', 'Struts2', 'Struts2', 0, 0),
(2, '岡本', 'ケーキ', 'コーヒー', 2, '2015/05/08 17:55:16', '2015/05/08 17:55:16', 'Struts2', 'Struts2', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_color`
--
ALTER TABLE `table_color`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_like`
--
ALTER TABLE `table_like`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_color`
--
ALTER TABLE `table_color`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `table_like`
--
ALTER TABLE `table_like`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
