-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 4 朁E23 日 14:35
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
-- テーブルの構造 `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
`id` int(50) NOT NULL,
  `title` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `genreId` int(50) DEFAULT NULL,
  `exhibition_year` int(50) DEFAULT NULL,
  `registration_date` char(50) COLLATE utf8_bin DEFAULT NULL,
  `renewal_date` char(50) COLLATE utf8_bin DEFAULT NULL,
  `registration_userid` char(50) COLLATE utf8_bin DEFAULT NULL,
  `renewal_userid` char(50) COLLATE utf8_bin DEFAULT NULL,
  `control``` int(50) DEFAULT NULL,
  `control` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `movie`
--

INSERT INTO `movie` (`id`, `title`, `genreId`, `exhibition_year`, `registration_date`, `renewal_date`, `registration_userid`, `renewal_userid`, `control``, `control`) VALUES
(1, 'E.T.', 3, 1980, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'アイアン・ジャイアント', 2, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'あなたは私の婿になる', 7, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'エスター', 6, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'グリーンマイル', 8, 1990, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'ゲット・スマート', 4, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'コンスタンティン', 6, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(8, '最高の人生の見つけ方', 8, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'ジュマンジ', 3, 1980, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'スパイダーマン', 1, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(11, '戦火の馬', 8, 2010, NULL, NULL, NULL, NULL, NULL, NULL),
(12, 'ダ・ヴィンチ・コード', 5, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(13, '第9地区', 3, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(14, 'タイタニック', 7, 1990, NULL, NULL, NULL, NULL, NULL, NULL),
(15, 'タイピスト', 7, 2010, NULL, NULL, NULL, NULL, NULL, NULL),
(16, 'トランスフォーマー', 1, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(17, 'ナイトミュージアム', 4, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(18, 'ハイド・アンド・シーク', 6, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(19, 'ハンガー・ゲーム', 1, 2010, NULL, NULL, NULL, NULL, NULL, NULL),
(20, 'ファンタスティック・フォー', 1, 1990, NULL, NULL, NULL, NULL, NULL, NULL),
(21, 'ブラックスワン', 5, 2010, NULL, NULL, NULL, NULL, NULL, NULL),
(22, 'ミスト', 5, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(23, 'ミセス・ダウト', 4, 1990, NULL, NULL, NULL, NULL, NULL, NULL),
(24, 'メアリー＆マックス', 2, 2000, NULL, NULL, NULL, NULL, NULL, NULL),
(25, 'モンスターハウス', 2, 2000, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `movie_genre`
--

CREATE TABLE IF NOT EXISTS `movie_genre` (
`id` int(50) NOT NULL,
  `genre` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `registration_date` char(50) COLLATE utf8_bin DEFAULT NULL,
  `renewal_date` char(50) COLLATE utf8_bin DEFAULT NULL,
  `registration_userid` char(50) COLLATE utf8_bin DEFAULT NULL,
  `renewal_userid` char(50) COLLATE utf8_bin DEFAULT NULL,
  `control` int(50) DEFAULT NULL,
  `delete` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `movie_genre`
--

INSERT INTO `movie_genre` (`id`, `genre`, `registration_date`, `renewal_date`, `registration_userid`, `renewal_userid`, `control`, `delete`) VALUES
(1, 'アクション', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'アニメ', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'SF・ファンタジー', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'コメディ', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'サスペンス', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'ホラー', NULL, NULL, NULL, NULL, NULL, NULL),
(7, '恋愛', NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'その他', NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movie_genre`
--
ALTER TABLE `movie_genre`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `movie_genre`
--
ALTER TABLE `movie_genre`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
