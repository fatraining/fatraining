-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 17:08
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
-- テーブルの構造 `genre`
--

CREATE TABLE IF NOT EXISTS `genre` (
`id` int(50) NOT NULL,
  `genreNm` char(50) DEFAULT NULL,
  `record_date` char(50) DEFAULT NULL,
  `reset_date` char(50) DEFAULT NULL,
  `entry_userId` char(50) DEFAULT NULL,
  `record_userId` char(50) DEFAULT NULL,
  `exclusive_FLG` int(50) DEFAULT NULL,
  `delete_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `genre`
--

INSERT INTO `genre` (`id`, `genreNm`, `record_date`, `reset_date`, `entry_userId`, `record_userId`, `exclusive_FLG`, `delete_FLG`) VALUES
(1, '焼き菓子', '2015/05/08 15:52:42', '2015/05/08 15:52:42', 'testUser', 'testUser', 0, 0),
(2, '冷菓', '2015/05/08 15:52:42', '2015/05/08 15:52:42', 'testUser', 'testUser', 0, 0),
(3, 'チョコレート菓子', '2015/05/08 15:52:42', '2015/05/08 15:52:42', 'testUser', 'testUser', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `sweets`
--

CREATE TABLE IF NOT EXISTS `sweets` (
`id` int(50) NOT NULL,
  `name` char(50) DEFAULT NULL,
  `genre_id` int(50) DEFAULT NULL,
  `record_date` char(50) DEFAULT NULL,
  `reset_date` char(50) DEFAULT NULL,
  `entry_userId` char(50) DEFAULT NULL,
  `record_userId` char(50) DEFAULT NULL,
  `exclusive_FLG` int(50) DEFAULT NULL,
  `delete_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `sweets`
--

INSERT INTO `sweets` (`id`, `name`, `genre_id`, `record_date`, `reset_date`, `entry_userId`, `record_userId`, `exclusive_FLG`, `delete_FLG`) VALUES
(15, 'クッキー', 1, '2015/05/08 16:41:54', '2015/05/08 16:41:54', 'hokari', 'hokari', 0, 0),
(16, 'ガレット', 1, '2015/05/08 16:42:1', '2015/05/08 16:42:1', 'hokari', 'hokari', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sweets`
--
ALTER TABLE `sweets`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `sweets`
--
ALTER TABLE `sweets`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
