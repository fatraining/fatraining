-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E23 日 04:11
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
-- テーブルの構造 `table_hobby`
--

CREATE TABLE IF NOT EXISTS `table_hobby` (
`id` int(11) NOT NULL,
  `hobby` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time_stamp` int(11) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `table_hobby`
--

INSERT INTO `table_hobby` (`id`, `hobby`, `day`, `new_day`, `userid`, `new_userid`, `time_stamp`, `delete`) VALUES
(1, '書道', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'サッカー', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_profile`
--

CREATE TABLE IF NOT EXISTS `table_profile` (
`id` int(11) NOT NULL,
  `name` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `personality` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` int(11) DEFAULT NULL,
  `day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time_stamp` int(11) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `table_profile`
--

INSERT INTO `table_profile` (`id`, `name`, `personality`, `home`, `birthday`, `day`, `new_day`, `userid`, `new_userid`, `time_stamp`, `delete`) VALUES
(1, 'まさと', 'おとなしい', '京都', 12, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'おとや', '元気', '東京', 4, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_hobby`
--
ALTER TABLE `table_hobby`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_profile`
--
ALTER TABLE `table_profile`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_hobby`
--
ALTER TABLE `table_hobby`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `table_profile`
--
ALTER TABLE `table_profile`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
