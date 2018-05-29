-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018 年 5 朁E29 日 08:55
-- サーバのバージョン： 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fa`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `artist`
--

CREATE TABLE `artist` (
  `id` int(11) NOT NULL,
  `artist` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `artist`
--

INSERT INTO `artist` (`id`, `artist`, `del_flg`, `create_date`, `update_date`) VALUES
(1, 'Zebrahead', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(2, 'FLOW', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(3, '米津玄師', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(4, 'Anly', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(5, 'fox capture plan', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00');

-- --------------------------------------------------------

--
-- テーブルの構造 `janru`
--

CREATE TABLE `janru` (
  `id` int(11) NOT NULL,
  `janru` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `janru`
--

INSERT INTO `janru` (`id`, `janru`, `del_flg`, `create_date`, `update_date`) VALUES
(1, 'ロック・ポップス', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(2, 'ジャズ', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(3, 'ゲーム・アニメ', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(4, 'EDM・ダンスミュージック', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00');

-- --------------------------------------------------------

--
-- テーブルの構造 `music_kichise_main`
--

CREATE TABLE `music_kichise_main` (
  `id` int(11) NOT NULL,
  `music_title` varchar(256) DEFAULT NULL,
  `artist_id` int(11) DEFAULT NULL,
  `janru_id` int(11) DEFAULT NULL,
  `country` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `music_kichise_main`
--

INSERT INTO `music_kichise_main` (`id`, `music_title`, `artist_id`, `janru_id`, `country`, `comment`, `del_flg`, `create_date`, `update_date`) VALUES
(1, 'All for None and None for All', 1, 1, 'USA', NULL, '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(2, 'anthem', 1, 1, 'USA', NULL, '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(3, 'Wanna Be', 1, 1, 'USA', 'スパイスガールズのカバー曲', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(4, 'Out of Control', 1, 1, 'USA', 'PVが一番かっこいい', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(5, 'rescue me', 1, 1, 'USA', '若干メタルテイストなロック', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(6, 'Check', 1, 1, 'USA', '新ボーカル加入後のシングル曲', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(7, 'E Generation', 1, 1, 'USA', NULL, '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(8, 'Playmate of the Year', 1, 1, 'USA', 'zebrahead初期の代表曲', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(9, '風ノ唄', 2, 3, 'JPN', 'テイルズオブゼスティリアクロス OP', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(10, 'Go!!!', 2, 1, 'JPN', 'ナルト OP', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(11, 'BURN', 2, 3, 'JPN', 'tales of zestiria 主題歌', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(12, '愛愛愛に撃たれてバイバイバイ', 2, 1, 'JPN', NULL, '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(13, 'Steppin’ out', 2, 3, 'JPN', 'デュラララ!!×2 結', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(14, 'ブレイブルー', 2, 3, 'JPN', 'エウレカセブンAO OP', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(15, 'ピースサイン', 3, 3, 'JPN', '僕のヒーローアカデミア OP', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(16, 'orion', 3, 2, 'JPN', '3月のライオン ED', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(17, 'ナンバーナイン', 3, 2, 'JPN', NULL, '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(18, 'LOSER', 3, 1, 'JPN', 'HONDAのCM', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(19, 'カラノココロ', 4, 3, 'JPN', 'ナルト OP', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(20, 'Beautiful', 4, 3, 'JPN', '七つの大罪 OP', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(21, 'Venus', 4, 3, 'JPN', '科捜研の女 主題歌', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(22, 'Don’t give it up! feat.Gabrielle Aplin', 4, 1, 'JPN', '僕のヤバイ妻　OP', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00'),
(23, '太陽に笑え', 4, 1, 'JPN', 'サイレーン刑事×彼女×完全悪女 主題歌', '0', '2018-05-23 01:27:00', '2018-05-23 01:27:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `janru`
--
ALTER TABLE `janru`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `music_kichise_main`
--
ALTER TABLE `music_kichise_main`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
