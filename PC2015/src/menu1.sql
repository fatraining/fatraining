-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 09:12
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
-- テーブルの構造 `table_profile`
--

CREATE TABLE IF NOT EXISTS `table_profile` (
`id` int(11) NOT NULL,
  `name` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `personality` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` int(11) DEFAULT NULL,
  `hobby_id` int(11) DEFAULT NULL,
  `day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time_stamp` int(11) NOT NULL,
  `delete` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `table_profile`
--

INSERT INTO `table_profile` (`id`, `name`, `personality`, `home`, `birthday`, `hobby_id`, `day`, `new_day`, `userid`, `new_userid`, `time_stamp`, `delete`) VALUES
(1, '真斗', '大人しい', '京都', 12, 1, '03/04', '09/24', 'uuu', 'fff', 0, 0),
(2, '音也', '元気', '東京', 4, 2, '11/15', '03/07', 'ddd', 'ttt', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_profile`
--
ALTER TABLE `table_profile`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_profile`
--
ALTER TABLE `table_profile`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
