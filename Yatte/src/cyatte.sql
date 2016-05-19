-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016 年 5 朁E19 日 07:51
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
-- テーブルの構造 `cyatte`
--

CREATE TABLE `cyatte` (
  `No` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `who` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `time` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ex` varchar(2240) COLLATE utf8_unicode_ci NOT NULL,
  `yattal` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `flg` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `cyatte`
--

INSERT INTO `cyatte` (`No`, `name`, `who`, `time`, `ex`, `yattal`, `flg`) VALUES
(18, 'とさか', 'みんな', '2016-05-19 14:46:31', 'てst@とさか', '<button class=zlbtn btn-danger btn-lgzl ID=zlyattalzl onclick=yattal(18)>いいね !0</button>', 0),
(19, 'とさか', 'みんな', '2016-05-19 14:46:35', 'あああ@とさか', '<button class=zlbtn btn-danger btn-lgzl ID=zlyattalzl onclick=yattal(19)>いいね !0</button>', 0),
(20, 'とさか', 'みんな', '2016-05-19 14:46:45', 'test@とさか', '<button class=zlbtn btn-danger btn-lgzl ID=zlyattalzl onclick=yattal(20)>いいね !0</button>', 0),
(21, 'とさか', 'みんな', '2016-05-19 14:47:18', 'test@とさか', '<button class=zlbtn btn-danger btn-lgzl ID=zlyattalzl onclick=yattal(21)>いいね !0</button>', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cyatte`
--
ALTER TABLE `cyatte`
  ADD PRIMARY KEY (`No`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
