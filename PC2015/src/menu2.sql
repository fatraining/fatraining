-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E23 日 08:06
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
  `delete_FLG` int(50) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `genre`
--

INSERT INTO `genre` (`id`, `genreNm`, `record_date`, `reset_date`, `entry_userId`, `record_userId`, `exclusive_FLG`, `delete_FLG`, `genre`) VALUES
(1, '焼き菓子', NULL, NULL, NULL, NULL, 0, 0, NULL),
(2, '冷菓', NULL, NULL, NULL, NULL, 0, 0, NULL),
(3, 'チョコレート菓子', NULL, NULL, NULL, NULL, 0, 0, NULL);

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
  `delete_FLG` int(50) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `sweets`
--

INSERT INTO `sweets` (`id`, `name`, `genre_id`, `record_date`, `reset_date`, `entry_userId`, `record_userId`, `exclusive_FLG`, `delete_FLG`, `genre`) VALUES
(30, 'クッキー', 1, '2015/05/07 19:11:49', '2015/05/07 19:11:49', NULL, NULL, 0, 0, NULL),
(31, 'トリュフ', 3, '2015/05/07 19:12:26', '2015/05/07 19:12:26', NULL, NULL, 0, 0, NULL),
(32, 'プリン', 2, '2015/05/07 19:12:43', '2015/05/07 19:12:43', NULL, NULL, 0, 0, NULL),
(33, 'スコーン', 1, '2015/05/07 19:12:57', '2015/05/07 19:12:57', NULL, NULL, 0, 0, NULL),
(34, 'ババロア', 2, '2015/05/07 19:13:15', '2015/05/07 19:13:15', NULL, NULL, 0, 0, NULL),
(35, '羊羹', 2, '2015/05/07 19:13:25', '2015/05/07 19:13:25', NULL, NULL, 0, 0, NULL),
(36, 'バウムクーヘン', 1, '2015/05/07 19:13:36', '2015/05/07 19:13:36', NULL, NULL, 0, 0, NULL),
(37, 'ゼリー', 2, '2015/05/07 19:13:45', '2015/05/07 19:13:45', NULL, NULL, 0, 0, NULL),
(38, 'ガトーショコラ', 3, '2015/05/07 19:13:56', '2015/05/07 19:13:56', NULL, NULL, 0, 0, NULL),
(39, '生チョコ', 3, '2015/05/07 19:14:8', '2015/05/07 19:14:8', NULL, NULL, 0, 0, NULL),
(40, 'マドレーヌ', 1, '2015/05/07 19:16:2', '2015/05/07 19:16:2', NULL, NULL, 0, 0, NULL);

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
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `sweets`
--
ALTER TABLE `sweets`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
