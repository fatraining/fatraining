-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E21 日 18:56
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
  `genre` varchar(50) DEFAULT NULL,
  `signup` varchar(50) DEFAULT NULL,
  `update` varchar(50) DEFAULT NULL,
  `signupUSERID` varchar(50) DEFAULT NULL,
  `updateUSERID` varchar(50) DEFAULT NULL,
  `exclusiveFLG` int(50) DEFAULT NULL,
  `deleteFLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `story`
--

INSERT INTO `story` (`id`, `title`, `genre`, `signup`, `update`, `signupUSERID`, `updateUSERID`, `exclusiveFLG`, `deleteFLG`) VALUES
(1, '黒い家', '1', NULL, NULL, NULL, NULL, NULL, NULL),
(2, '火車', '3', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'となりの魔王', '2', NULL, NULL, NULL, NULL, NULL, NULL),
(4, '殺人鬼', '1', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'なろう作家とメガミ様', '2', NULL, NULL, NULL, NULL, NULL, NULL),
(6, '悪の教典', '3', NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `story`
--
ALTER TABLE `story`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
