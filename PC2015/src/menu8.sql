-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E28 日 03:27
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `ryouri`
--

INSERT INTO `ryouri` (`id`, `tyouri`, `ryouri`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(1, '煮る', '肉じゃが', '1月', '2月', '太郎', '次郎', 1, 1),
(2, '炒める', '野菜炒め', '３月', '４月', '三郎', '四郎', 2, 2);

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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `yasai`
--

INSERT INTO `yasai` (`id`, `yasai`, `tyouriId`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(1, 'じゃがいも', 1, '1/1', '1/2', 'あああ', 'いいい', 1, 1),
(2, 'きゃべつ', 2, '4/22', '4/22', 'あああ', 'いいいい', 2, 2);

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
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=77;
--
-- AUTO_INCREMENT for table `yasai`
--
ALTER TABLE `yasai`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=72;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
