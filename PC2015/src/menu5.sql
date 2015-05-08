-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 17:10
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
-- テーブルの構造 `user_character`
--

CREATE TABLE IF NOT EXISTS `user_character` (
`id` int(11) NOT NULL,
  `personality` char(50) DEFAULT NULL,
  `interest` char(50) DEFAULT NULL,
  `day` char(50) DEFAULT NULL,
  `newday` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `newuserid` char(50) DEFAULT NULL,
  `deleteFlg` int(11) DEFAULT NULL,
  `flg` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_character`
--

INSERT INTO `user_character` (`id`, `personality`, `interest`, `day`, `newday`, `userid`, `newuserid`, `deleteFlg`, `flg`) VALUES
(9, '穏やか', 'けん玉', '2015/05/08 16:49:50', '2015/05/08 16:49:50', NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
`id` int(11) NOT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  `dwelling` char(50) DEFAULT NULL,
  `name` char(50) DEFAULT NULL,
  `personality2` int(11) NOT NULL,
  `day` char(50) DEFAULT NULL,
  `newday` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `newuserid` char(50) DEFAULT NULL,
  `deleteFlg` int(11) DEFAULT NULL,
  `flg` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_profile`
--

INSERT INTO `user_profile` (`id`, `phonenumber`, `zipcode`, `dwelling`, `name`, `personality2`, `day`, `newday`, `userid`, `newuserid`, `deleteFlg`, `flg`) VALUES
(7, 124551334, 1111234, '千葉県印旛郡栄町矢口', '田中進', 9, '2015/05/08 16:49:50', '2015/05/08 16:49:50', NULL, NULL, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_character`
--
ALTER TABLE `user_character`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_profile`
--
ALTER TABLE `user_profile`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_character`
--
ALTER TABLE `user_character`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
