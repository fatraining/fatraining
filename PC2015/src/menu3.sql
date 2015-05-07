-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E07 日 19:21
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
-- テーブルの構造 `story`
--

CREATE TABLE IF NOT EXISTS `story` (
`id` int(50) NOT NULL COMMENT 'AUTO_INCREMENT',
  `title` varchar(50) DEFAULT NULL,
  `genre_id` varchar(50) DEFAULT NULL,
  `signup` varchar(50) DEFAULT NULL,
  `updateDate` varchar(50) DEFAULT NULL,
  `signupUSERID` varchar(50) DEFAULT NULL,
  `updateUSERID` varchar(50) DEFAULT NULL,
  `exclusiveFLG` int(50) DEFAULT NULL,
  `deleteFLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `story`
--

INSERT INTO `story` (`id`, `title`, `genre_id`, `signup`, `updateDate`, `signupUSERID`, `updateUSERID`, `exclusiveFLG`, `deleteFLG`) VALUES
(17, '黒い家', '14', '2015/05/07 17:22:52', '2015/05/07 17:22:52', NULL, NULL, 0, 0),
(18, 'ああああ', '15', '2015/05/07 17:23:23', '2015/05/07 17:23:23', 'dsf', 'dsf', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `tb_genre`
--

CREATE TABLE IF NOT EXISTS `tb_genre` (
`id` int(50) NOT NULL COMMENT 'AUTO_INCREMENT',
  `genre` varchar(50) DEFAULT NULL,
  `signup` varchar(50) DEFAULT NULL,
  `updateDate` varchar(50) DEFAULT NULL,
  `signupUSERID` varchar(50) DEFAULT NULL,
  `updateUSERID` varchar(50) DEFAULT NULL,
  `exclusiveFLG` int(50) DEFAULT NULL,
  `deleteFLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `tb_genre`
--

INSERT INTO `tb_genre` (`id`, `genre`, `signup`, `updateDate`, `signupUSERID`, `updateUSERID`, `exclusiveFLG`, `deleteFLG`) VALUES
(14, 'ホラー', '2015/05/07 17:22:52', '2015/05/07 17:22:52', NULL, NULL, 0, 0),
(15, 'いいいい', '2015/05/07 17:23:23', '2015/05/07 17:23:23', 'dsf', 'dsf', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `story`
--
ALTER TABLE `story`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_genre`
--
ALTER TABLE `tb_genre`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `tb_genre`
--
ALTER TABLE `tb_genre`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
