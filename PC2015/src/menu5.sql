-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E23 日 05:36
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
  `personality` char(50) NOT NULL,
  `interest` char(50) NOT NULL,
  `day` char(50) NOT NULL,
  `newday` char(50) NOT NULL,
  `userid` char(50) NOT NULL,
  `newuserid` char(50) NOT NULL,
  `delete` int(11) NOT NULL,
  `flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_character`
--

INSERT INTO `user_character` (`id`, `personality`, `interest`, `day`, `newday`, `userid`, `newuserid`, `delete`, `flg`) VALUES
(1, '優しい', '読書', NULL, NULL, NULL, NULL, 0, 0),
(2, '明るい', 'カラオケ', NULL, NULL, NULL, NULL, 0, 0),
(3, '穏やか', 'ゲーム', NULL, NULL, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
`id` int(11) NOT NULL,
  `phonenumber` int(11) NOT NULL,
  `zipcode` int(11) NOT NULL,
  `dwelling` char(50) NOT NULL,
  `name` char(50) NOT NULL,
  `personality2` int(11) NOT NULL,
  `day` char(50) NOT NULL,
  `newday` char(50) NOT NULL,
  `userid` char(50) NOT NULL,
  `newuserid` char(50) NOT NULL,
  `delete` int(11) NOT NULL,
  `flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_profile`
--

INSERT INTO `user_profile` (`id`, `phonenumber`, `zipcode`, `dwelling`, `name`, `personality2`, `day`, `newday`, `userid`, `newuserid`, `delete`, `flg`) VALUES
(1, 2, 3, '千葉', '田中', 1, NULL, NULL, NULL, NULL, 0, 0),
(2, 1, 2, '東京', '佐藤', 3, NULL, NULL, NULL, NULL, 0, 0),
(3, 3, 1, '埼玉', '大木', 2, NULL, NULL, NULL, NULL, 0, 0);

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
