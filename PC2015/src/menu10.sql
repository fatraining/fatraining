-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E07 日 11:47
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
-- テーブルの構造 `eat_detail`
--

CREATE TABLE IF NOT EXISTS `eat_detail` (
`id` int(50) NOT NULL,
  `eat_year` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eat_month` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eat_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eat_hour` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `food_id` int(50) NOT NULL,
  `entry_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_flg` int(50) NOT NULL,
  `delete_flg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `eat_detail`
--

INSERT INTO `eat_detail` (`id`, `eat_year`, `eat_month`, `eat_day`, `eat_hour`, `food_id`, `entry_day`, `renew_day`, `entry_userid`, `renew_userid`, `renew_flg`, `delete_flg`) VALUES
(1, '2015', '5', '4', 'PM', 1, '2015/05/07 11:42:12', '2015/05/07 11:42:12', 'Struts2', 'Struts2', 0, 0),
(2, '2015', '5', '6', 'PM', 2, '2015/05/07 11:43:21', '2015/05/07 11:43:21', 'Struts2', 'Struts2', 0, 0),
(3, '2015', '5', '7', 'AM', 3, '2015/05/07 11:44:4', '2015/05/07 11:44:4', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `eat_id`
--

CREATE TABLE IF NOT EXISTS `eat_id` (
`id` int(50) NOT NULL,
  `eatFood` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eatCalory` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_flg` int(50) NOT NULL,
  `delete_flg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `eat_id`
--

INSERT INTO `eat_id` (`id`, `eatFood`, `eatCalory`, `entry_day`, `renew_day`, `entry_userid`, `renew_userid`, `renew_flg`, `delete_flg`) VALUES
(1, '焼肉', '1000kcal', '2015/05/07 11:42:12', '2015/05/07 11:42:12', 'Struts2', 'Struts2', 0, 0),
(2, '焼鳥', '500kcal', '2015/05/07 11:43:21', '2015/05/07 11:43:21', 'Struts2', 'Struts2', 0, 0),
(3, 'パン', '200kcal', '2015/05/07 11:44:4', '2015/05/07 11:44:4', 'Struts2', 'Struts2', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `eat_detail`
--
ALTER TABLE `eat_detail`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `eat_id`
--
ALTER TABLE `eat_id`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `eat_detail`
--
ALTER TABLE `eat_detail`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `eat_id`
--
ALTER TABLE `eat_id`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
