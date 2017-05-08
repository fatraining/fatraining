-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017 年 4 朁E20 日 10:07
-- サーバのバージョン： 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webapp_sp`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `restaurant`
--

CREATE TABLE `restaurant` (
  `id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stars` smallint(6) DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `restaurant_area_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `restaurant`
--

INSERT INTO `restaurant` (`id`, `name`, `stars`, `comment`, `restaurant_area_id`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '四文屋', 4, '安くて美味いです。アキバとかにもあります。隣のカレー屋がいつもいい匂いさせててつらい。', 1, '2015-12-05 08:24:51', 'struts2', '2016-04-27 15:47:39', 'Struts2', 1),
(2, 'てけてけ', 3, '割と安い。味はそこそこ。', 1, '2016-04-18 21:37:00', '豚野郎', '2016-04-18 21:37:00', '豚野郎', 0),
(3, '四文屋', 4, '安くて美味いです。\r\n新宿とかにもあります。\r\nなんか外人の店員が多い気がする。', 3, '2016-04-19 20:33:09', 'Struts2', '2016-04-19 20:33:09', 'Struts2', 0),
(5, '大衆居酒屋 いこい', 3, 'ハイボールが180円。でも食い物は別に安くない。ぶつ爆弾がうまかった。', 5, '2016-05-09 00:00:00', 'struts2', '2016-05-12 13:50:34', 'Struts2', 2),
(6, '肉屋の台所', 4, '焼肉食べ放題＋飲み放題で4000円とか。\r\n飲み放題は自分でドリンク作れる。\r\n焼き場がせめー。', 1, '2016-05-16 13:26:48', 'Struts2', '2016-05-16 13:32:36', 'Struts2', 1);

-- --------------------------------------------------------

--
-- テーブルの構造 `restaurant_area`
--

CREATE TABLE `restaurant_area` (
  `id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `restaurant_area`
--

INSERT INTO `restaurant_area` (`id`, `name`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '新宿', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(2, '新橋', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(3, '秋葉原', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0),
(4, '上野', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0),
(5, '渋谷', '2016-05-09 00:00:00', 'struts2', '2016-05-09 00:00:00', 'struts2', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK965A4B3DF35C8430` (`restaurant_area_id`);

--
-- Indexes for table `restaurant_area`
--
ALTER TABLE `restaurant_area`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `restaurant_area`
--
ALTER TABLE `restaurant_area`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `FK965A4B3DF35C8430` FOREIGN KEY (`restaurant_area_id`) REFERENCES `restaurant_area` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
