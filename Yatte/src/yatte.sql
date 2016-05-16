-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016 年 5 朁E16 日 10:21
-- サーバのバージョン： 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yatte`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `yatte`
--

CREATE TABLE `yatte` (
  `No` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `toDo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `who` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `num` int(11) NOT NULL,
  `time` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `limit` datetime NOT NULL,
  `ex` varchar(2240) COLLATE utf8_unicode_ci NOT NULL,
  `flg` int(50) NOT NULL,
  `yattal` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- テーブルの構造 `yname`
--

CREATE TABLE `yname` (
  `no` int(20) NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `pass` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `yname`
--

INSERT INTO `yname` (`no`, `name`, `pass`) VALUES
(1, 'とさか', 'pass'),
(2, 'まきの', 'pass'),
(3, '三代目', 'pass'),
(4, 'ﾊﾗｻﾝ', 'pass'),
(5, 'ﾔﾏｻﾞｷ晴佳ﾊﾟﾝ祭り', 'pass');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `yatte`
--
ALTER TABLE `yatte`
  ADD PRIMARY KEY (`No`);

--
-- Indexes for table `yname`
--
ALTER TABLE `yname`
  ADD PRIMARY KEY (`no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `yname`
--
ALTER TABLE `yname`
  MODIFY `no` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
