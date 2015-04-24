-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E24 日 08:18
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
  `colorNm` varchar(50) DEFAULT NULL,
  `taste` varchar(50) DEFAULT NULL,
  `date_of_registration` char(50) DEFAULT NULL,
  `update_date` char(50) DEFAULT NULL,
  `registration_userid` char(50) DEFAULT NULL,
  `update_userid` char(50) DEFAULT NULL,
  `time_stamp` int(50) DEFAULT NULL,
  `deleteflg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `table_color`
--

INSERT INTO `table_color` (`id`, `colorNm`, `taste`, `date_of_registration`, `update_date`, `registration_userid`, `update_userid`, `time_stamp`, `deleteflg`) VALUES
(1, '赤', '映画鑑賞', NULL, NULL, NULL, NULL, NULL, NULL),
(2, '青', '読書', NULL, NULL, NULL, NULL, NULL, NULL),
(3, '黄色', '買い物', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'オレンジ', 'カラオケ', NULL, NULL, NULL, NULL, NULL, NULL),
(5, '緑', '散歩', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_like`
--

CREATE TABLE IF NOT EXISTS `table_like` (
`id` int(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `food` varchar(50) DEFAULT NULL,
  `drink` varchar(50) DEFAULT NULL,
  `date_of_registration` char(50) DEFAULT NULL,
  `update_date` char(50) DEFAULT NULL,
  `registration_userid` char(50) DEFAULT NULL,
  `update_userid` char(50) DEFAULT NULL,
  `time_stamp` int(50) DEFAULT NULL,
  `deleteflg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `table_like`
--

INSERT INTO `table_like` (`id`, `name`, `food`, `drink`, `date_of_registration`, `update_date`, `registration_userid`, `update_userid`, `time_stamp`, `deleteflg`) VALUES
(1, '林', 'ピザ', 'コーラ', NULL, NULL, NULL, NULL, NULL, NULL),
(2, '瀬守', 'カレー', '水', NULL, NULL, NULL, NULL, NULL, NULL),
(3, '田中', 'サンドイッチ', 'オレンジジュース', NULL, NULL, NULL, NULL, NULL, NULL),
(4, '岡田', '煮物', 'お茶', NULL, NULL, NULL, NULL, NULL, NULL),
(5, '橘', 'ピザ', 'レモネード', NULL, NULL, NULL, NULL, NULL, NULL);

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
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `table_like`
--
ALTER TABLE `table_like`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
