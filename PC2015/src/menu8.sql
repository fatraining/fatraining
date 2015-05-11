-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E11 日 12:47
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
-- テーブルの構造 `ryouri`
--

CREATE TABLE IF NOT EXISTS `ryouri` (
`id` int(50) NOT NULL,
  `tyouri` varchar(50) DEFAULT NULL,
  `ryouri` varchar(50) DEFAULT NULL,
  `date_entry` varchar(50) DEFAULT NULL,
  `date_up` varchar(50) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `userId_up` varchar(50) DEFAULT NULL,
  `control` int(50) NOT NULL,
  `deleteflg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `ryouri`
--

INSERT INTO `ryouri` (`id`, `tyouri`, `ryouri`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(138, '野菜', '野菜', '2015/05/08 15:51:2', NULL, 'Struts2', NULL, 0, 0),
(139, '煮る', '肉じゃが', '2015/05/08 15:51:45', NULL, 'Struts2', NULL, 0, 0),
(140, '炒める', '野菜炒め', '2015/05/08 15:52:21', NULL, 'Struts2', NULL, 0, 0),
(144, 'a1', 'a1', '2015/05/11 19:44:9', NULL, NULL, NULL, 0, 0),
(145, 'a2', 'a2', '2015/05/11 19:44:17', NULL, NULL, NULL, 0, 0),
(146, 'a3', 'a3', '2015/05/11 19:44:25', NULL, NULL, NULL, 0, 0),
(147, 'a4', 'a4', '2015/05/11 19:44:32', NULL, NULL, NULL, 0, 0),
(148, 'a5', 'a5', '2015/05/11 19:44:49', NULL, NULL, NULL, 0, 0),
(149, 'a6', 'a6', '2015/05/11 19:44:55', NULL, NULL, NULL, 0, 0),
(150, 'a7', 'a7', '2015/05/11 19:45:7', NULL, NULL, NULL, 0, 0),
(151, 'a8', 'a8', '2015/05/11 19:45:15', NULL, NULL, NULL, 0, 0),
(152, 'a9', 'a9', '2015/05/11 19:45:23', NULL, NULL, NULL, 0, 0),
(153, 'a10', 'a10', '2015/05/11 19:45:31', NULL, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `yasai`
--

CREATE TABLE IF NOT EXISTS `yasai` (
`id` int(50) NOT NULL,
  `yasai` varchar(50) DEFAULT NULL,
  `tyouriId` int(50) DEFAULT NULL,
  `date_entry` varchar(50) DEFAULT NULL,
  `date_up` varchar(50) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `userId_up` varchar(50) DEFAULT NULL,
  `control` int(50) NOT NULL,
  `deleteflg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `yasai`
--

INSERT INTO `yasai` (`id`, `yasai`, `tyouriId`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(133, '野菜', 138, '2015/05/08 15:51:2', NULL, 'Struts2', NULL, 0, 0),
(134, 'じゃがいも', 139, '2015/05/08 15:51:45', NULL, 'Struts2', NULL, 0, 0),
(135, 'きゃべつ', 140, '2015/05/08 15:52:21', NULL, 'Struts2', NULL, 0, 0),
(139, 'a1', 144, '2015/05/11 19:44:9', NULL, NULL, NULL, 0, 0),
(140, 'a2', 145, '2015/05/11 19:44:17', NULL, NULL, NULL, 0, 0),
(141, 'a3', 146, '2015/05/11 19:44:25', NULL, NULL, NULL, 0, 0),
(142, 'a4', 147, '2015/05/11 19:44:32', NULL, NULL, NULL, 0, 0),
(143, 'a5', 148, '2015/05/11 19:44:49', NULL, NULL, NULL, 0, 0),
(144, 'a6', 149, '2015/05/11 19:44:55', NULL, NULL, NULL, 0, 0),
(145, 'a7', 150, '2015/05/11 19:45:7', NULL, NULL, NULL, 0, 0),
(146, 'a8', 151, '2015/05/11 19:45:15', NULL, NULL, NULL, 0, 0),
(147, 'a9', 152, '2015/05/11 19:45:23', NULL, NULL, NULL, 0, 0),
(148, 'a10', 153, '2015/05/11 19:45:31', NULL, NULL, NULL, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ryouri`
--
ALTER TABLE `ryouri`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `yasai`
--
ALTER TABLE `yasai`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ryouri`
--
ALTER TABLE `ryouri`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=154;
--
-- AUTO_INCREMENT for table `yasai`
--
ALTER TABLE `yasai`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=149;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
