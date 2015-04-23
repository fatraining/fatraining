-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E23 日 07:39
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
  `control` int(50) DEFAULT NULL,
  `deleteflg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `ryouri`
--

INSERT INTO `ryouri` (`id`, `tyouri`, `ryouri`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(1, '煮る', '肉じゃが', '1月', '2月', '太郎', '次郎', 1, 1),
(2, '炒める', '野菜炒め', '３月', '４月', '三郎', '四郎', 2, 2),
(41, 'ｓｓｓｓｓｓｓｓｓｓ', 'ｚｚｚｚｚｚｚｚｚｚ', NULL, NULL, NULL, NULL, 0, 0),
(42, '', '', '2015/04/22 18:8:11', '2015/04/22 18:8:11', NULL, NULL, 0, NULL),
(43, '', '', '2015/04/22 18:8:15', '2015/04/22 18:8:15', NULL, NULL, 0, NULL),
(44, '', '', '2015/04/22 18:8:43', '2015/04/22 18:8:43', NULL, NULL, 0, NULL),
(45, '', '', '2015/04/22 18:10:27', '2015/04/22 18:10:27', NULL, NULL, 0, NULL),
(46, 'ああああ', 'ああああああああああ', '2015/04/22 18:10:37', '2015/04/22 18:10:37', NULL, NULL, 0, NULL),
(47, '', '', '2015/04/22 18:12:36', '2015/04/22 18:12:36', 'Struts2', NULL, 0, NULL),
(48, '煮る', '肉じゃが', '2015/04/22 18:16:48', '2015/04/22 18:16:48', 'Struts2', NULL, 0, 0),
(49, '', '', '2015/04/22 18:18:13', '2015/04/22 18:18:13', 'Struts2', NULL, 0, 0),
(50, '', '', '2015/04/22 18:24:41', '2015/04/22 18:24:41', 'Struts2', NULL, 0, 0),
(51, '', '', '2015/04/22 18:25:5', '2015/04/22 18:25:5', 'Struts2', NULL, 0, 0),
(52, '', '', '2015/04/22 19:51:36', '2015/04/22 19:51:36', NULL, NULL, 0, 0),
(53, '', '', '2015/04/22 19:53:32', '2015/04/22 19:53:32', 'Struts2', NULL, 0, 0),
(54, '', '', '2015/04/22 19:54:12', '2015/04/22 19:54:12', 'Struts2', NULL, 0, 0),
(55, 'hhhhhhhhhhh', 'llllllll', '2015/04/22 19:54:57', '2015/04/22 19:54:57', NULL, NULL, 0, 0),
(57, '', '', '2015/04/23 10:12:34', '2015/04/23 10:12:34', NULL, NULL, 0, 0),
(58, '', '', '2015/04/23 10:12:41', '2015/04/23 10:12:41', NULL, NULL, 0, 0),
(59, '', '', '2015/04/23 10:31:28', '2015/04/23 10:31:28', 'Struts2', NULL, 0, 0),
(60, '', '', '2015/04/23 10:33:10', '2015/04/23 10:33:10', 'Struts2', NULL, 0, 0),
(61, '', '', '2015/04/23 10:44:35', '2015/04/23 10:44:35', 'Struts2', NULL, 0, 0);

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
  `control` int(50) DEFAULT NULL,
  `deleteflg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `yasai`
--

INSERT INTO `yasai` (`id`, `yasai`, `tyouriId`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(1, 'じゃがいも', 1, '1/1', '1/2', 'あああ', 'いいい', 1, 1),
(2, 'きゃべつ', 2, '4/22', '4/22', 'あああ', 'いいいい', 2, 2),
(42, 'ああああああ', NULL, NULL, NULL, NULL, NULL, 0, 0),
(43, '', 0, '2015/04/22 18:8:11', '2015/04/22 18:8:11', NULL, NULL, 0, 0),
(44, '', 0, '2015/04/22 18:8:15', '2015/04/22 18:8:15', NULL, NULL, 0, 0),
(45, '', 0, '2015/04/22 18:8:43', '2015/04/22 18:8:43', NULL, NULL, 0, 0),
(46, '', 0, '2015/04/22 18:10:27', '2015/04/22 18:10:27', NULL, NULL, 0, 0),
(47, 'ああああああああ', 0, '2015/04/22 18:10:37', '2015/04/22 18:10:37', NULL, NULL, 0, 0),
(48, '', 0, '2015/04/22 18:12:36', '2015/04/22 18:12:36', 'Struts2', NULL, 0, 0),
(49, 'じゃがいも', 0, '2015/04/22 18:16:48', '2015/04/22 18:16:48', 'Struts2', NULL, 0, 0),
(50, '', 0, '2015/04/22 18:18:13', '2015/04/22 18:18:13', 'Struts2', NULL, 0, 0),
(51, 'じゃがいも', 0, '2015/04/22 18:24:41', '2015/04/22 18:24:41', 'Struts2', NULL, 0, 0),
(52, 'きゃべつ', 0, '2015/04/22 18:25:5', '2015/04/22 18:25:5', 'Struts2', NULL, 0, 0),
(53, 'じゃがいも', 0, '2015/04/22 19:51:36', '2015/04/22 19:51:36', NULL, NULL, 0, 0),
(54, 'aaaaaaaaaaa', 0, '2015/04/22 19:53:32', '2015/04/22 19:53:32', 'Struts2', NULL, 0, 0),
(55, '', 0, '2015/04/22 19:54:12', '2015/04/22 19:54:12', 'Struts2', NULL, 0, 0),
(56, 'aaaaaaaaaaaaaaaaaaaaaaa', 0, '2015/04/22 19:54:57', '2015/04/22 19:54:57', NULL, NULL, 0, 0),
(57, '', 0, '2015/04/23 10:12:34', '2015/04/23 10:12:34', NULL, NULL, 0, 0),
(58, 'あああああああああああ', 0, '2015/04/23 10:12:41', '2015/04/23 10:12:41', NULL, NULL, 0, 0),
(59, '', 0, '2015/04/23 10:31:28', '2015/04/23 10:31:28', 'Struts2', NULL, 0, 0),
(60, '', 0, '2015/04/23 10:33:10', '2015/04/23 10:33:10', 'Struts2', NULL, 0, 0),
(61, 'やさい', 0, '2015/04/23 10:44:35', '2015/04/23 10:44:35', 'Struts2', NULL, 0, 0);

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
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=66;
--
-- AUTO_INCREMENT for table `yasai`
--
ALTER TABLE `yasai`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=62;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
