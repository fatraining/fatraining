-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 16:22
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
-- テーブルの構造 `like_game`
--

CREATE TABLE IF NOT EXISTS `like_game` (
`id` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `title` varchar(50) DEFAULT NULL,
  `series` int(11) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `upDay` varchar(50) DEFAULT NULL,
  `userID` varchar(50) DEFAULT NULL,
  `upUser` varchar(50) DEFAULT NULL,
  `nonStyle` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  `another_flg` int(11) NOT NULL,
  `delete_flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- テーブルの構造 `like_series`
--

CREATE TABLE IF NOT EXISTS `like_series` (
`up_id` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `se` varchar(50) DEFAULT NULL,
  `us` varchar(50) DEFAULT NULL,
  `upD` varchar(50) DEFAULT NULL,
  `userI` varchar(50) DEFAULT NULL,
  `upU` varchar(50) DEFAULT NULL,
  `nonS` varchar(50) DEFAULT NULL,
  `de` varchar(50) DEFAULT NULL,
  `an_flg` int(11) NOT NULL,
  `del_flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `like_game`
--
ALTER TABLE `like_game`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `like_series`
--
ALTER TABLE `like_series`
 ADD PRIMARY KEY (`up_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `like_game`
--
ALTER TABLE `like_game`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `like_series`
--
ALTER TABLE `like_series`
MODIFY `up_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
