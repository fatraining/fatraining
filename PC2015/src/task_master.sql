-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E21 日 15:44
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
  `eat_food` int(50) NOT NULL,
  `entry_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_flg` int(50) NOT NULL,
  `delete_flg` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



-- --------------------------------------------------------

--
-- テーブルの構造 `eat_id`
--

CREATE TABLE IF NOT EXISTS `eat_id` (
`id` int(50) NOT NULL,
  `eatFood` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eatCalorｙ` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_flg` int(50) NOT NULL,
  `delete_flg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `eat_id`
--

INSERT INTO `eat_id` (`id`, `eatFood`, `eatCalorｙ`, `entry_day`, `renew_day`, `entry_userid`, `renew_userid`, `renew_flg`, `delete_flg`) VALUES
(1, 'カレー', '600kcal', '2015/04/20', '2015/04/20', 'Struts2', 'Struts2', 1, 1);

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
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `eat_id`
--
ALTER TABLE `eat_id`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
