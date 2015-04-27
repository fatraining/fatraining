-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E27 日 18:15
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
`id` int(11) NOT NULL COMMENT 'AUTO_INCERMENT',
  `title` varchar(50) DEFAULT NULL,
  `series` int(11) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `upDay` varchar(50) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `upUser` varchar(50) DEFAULT NULL,
  `nonStyle` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `like_game`
--

INSERT INTO `like_game` (`id`, `title`, `series`, `user`, `upDay`, `userId`, `upUser`, `nonStyle`, `del`) VALUES
(1, 'Fate/stay night', 1, '4/21', '4/21', 'ShirouEmiya', '1', 'Unlimited Blade Works', 'Sword'),
(2, 'Perusona3', 2, '4/22', '4/22', 'ShionAikawa', '2', 'Orpheus', 'Wild'),
(3, 'FAINALFANTASY7', 3, '4/22', '4/22', 'Cloud', '3', 'MeteorStrike', 'Soldier'),
(4, 'Fate/hollow', 1, NULL, '4/23', 'RinTosaka', '4', 'JewelrySword', 'Money'),
(5, 'LORD of VERMILION', 5, NULL, '4/24', 'Alma=Calma', '5', 'Bahamut', 'Arcana'),
(6, 'Perusona4', 2, NULL, '4/27', 'YuNarukami', '6', 'Izanagi', 'Wild');

-- --------------------------------------------------------

--
-- テーブルの構造 `like_series`
--

CREATE TABLE IF NOT EXISTS `like_series` (
`i` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `se` varchar(50) DEFAULT NULL,
  `u` varchar(50) DEFAULT NULL,
  `upD` varchar(50) DEFAULT NULL,
  `userI` varchar(50) DEFAULT NULL,
  `upU` varchar(50) DEFAULT NULL,
  `nonS` varchar(50) DEFAULT NULL,
  `d` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `like_series`
--

INSERT INTO `like_series` (`i`, `se`, `u`, `upD`, `userI`, `upU`, `nonS`, `d`) VALUES
(1, 'Fate', '4/21', '4/21', 'ShirouEmiya', '1', 'Unlimited Blade Works', 'Sword'),
(2, 'Perusona', '4/22', '4/22', 'ShionAikawa', '2', 'Orpheus', 'Wild'),
(3, 'FAINALFANTASY', '4/22', '4/22', 'Cloud', '3', 'MeteorStrike', 'Soldier'),
(4, NULL, '4/23', NULL, NULL, NULL, NULL, NULL),
(5, 'LORD of VERMILION', '4/24', NULL, NULL, NULL, NULL, NULL),
(6, 'Perusona', '4/27', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Indexes for table `like_game`
--
ALTER TABLE `like_game`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `like_series`
--
ALTER TABLE `like_series`
 ADD PRIMARY KEY (`i`);

 
-- AUTO_INCREMENT for table `like_game`
--
ALTER TABLE `like_game`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCERMENT',AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `like_series`
--
ALTER TABLE `like_series`
MODIFY `i` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=7;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
