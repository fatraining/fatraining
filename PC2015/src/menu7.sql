-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E07 日 16:40
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
  `exhibition_year` int(8) DEFAULT NULL,
  `comment` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `registration_date` char(50) COLLATE utf8_bin DEFAULT NULL,
  `renewal_date` char(50) COLLATE utf8_bin DEFAULT NULL,
  `registration_userid` char(50) COLLATE utf8_bin DEFAULT NULL,
  `renewal_userid` char(50) COLLATE utf8_bin DEFAULT NULL,
  `control` int(50) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `movie`
--

INSERT INTO `movie` (`id`, `title`, `genreId`, `exhibition_year`, `comment`, `registration_date`, `renewal_date`, `registration_userid`, `renewal_userid`, `control`, `delete`) VALUES
(1, 'E.T.', 3, 1982, 'おうちカエル。。。。゛(ノ‥)ノｶｴﾙ…', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'アイアン・ジャイアント', 2, 2000, 'ヒーローΣΣ≡≡≡ｰ(ｰ´･ω･`)ｰ', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'あなたは私の婿になる', 7, 2009, 'なかなかに…\r\n(*｀Λ´*)｣ﾍﾞ､ﾍﾞﾂﾆｽｷｯﾃﾜｹｼﾞｬ…', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'エスター', 6, 2009, '（゜言゜）ｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞ', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'グリーンマイル', 8, 1999, '大好きすぎる( p′︵‵。)', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'ゲット・スマート', 4, 2008, 'ヽ(ﾟ∀ﾟ)ﾉ うぇ──────ぃ♪', NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'コンスタンティン', 6, 2005, 'キアヌちゃんが素敵すぎる(´•ω•｀♥)', NULL, NULL, NULL, NULL, NULL, NULL),
(8, '最高の人生の見つけ方', 8, 2008, '秘書ー（┘｀゜Д゜´）┘\r\n君の活躍を私は知っている！', NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'ジュマンジ', 3, 1996, '20年…。\r\n長かったよな…。', NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'スパイダーマン', 1, 2002, 'みんな知ってるちょーヒーロー！', NULL, NULL, NULL, NULL, NULL, NULL),
(11, '戦火の馬', 8, 2012, 'ｏ（・∀・ ）ｏ－－－－∈･^ミ┬┬~ ﾋﾋｨｰﾝ...', NULL, NULL, '', NULL, NULL, NULL),
(12, 'ダ・ヴィンチ・コード', 5, 2006, '芸術+宗教+ミステリー=傑作！', NULL, NULL, NULL, NULL, NULL, NULL),
(13, '第9地区', 3, 2010, 'B級だけどなぜか忘れられないドキュメンタリー風映画です。', NULL, NULL, NULL, NULL, NULL, NULL),
(14, 'タイタニック', 7, 1997, 'カレシ欲しくなる…', NULL, NULL, NULL, NULL, NULL, NULL),
(15, 'タイピスト', 7, 2013, '西洋の雰囲気大好き(っ*''''ω''''*c)', NULL, NULL, NULL, NULL, NULL, NULL),
(16, 'トランスフォーマー', 1, 2007, 'ヽ(ヽω・`)ﾍｰﾝ (´・ω/)ゞｼﾝ!! -=≡ ﾄｫｰ!!ヽ(•̀ω•́ )ゝ✧', NULL, NULL, NULL, NULL, NULL, NULL),
(17, 'ナイトミュージアム', 4, 2007, 'お猿さんお利口すぎる。', NULL, NULL, NULL, NULL, NULL, NULL),
(18, 'ハイド・アンド・シーク', 6, 2005, '(；ﾟДﾟ艸)', NULL, NULL, NULL, NULL, NULL, NULL),
(19, 'ハンガー・ゲーム', 1, 2012, '15歳で過酷なサバイバルゲームに投じられた主人公…。\r\n誰が生き残るのか、恋の行方は？', NULL, NULL, NULL, NULL, NULL, NULL),
(20, 'ファンタスティック・フォー', 1, 2005, 'ヽ( ▼∀▼)ﾉ ﾌｫｰ!!', NULL, NULL, NULL, NULL, NULL, NULL),
(21, 'ブラックスワン', 5, 2011, 'ダークです。', NULL, NULL, NULL, NULL, NULL, NULL),
(22, 'ミスト', 5, 2008, '最後の主人公をあんな感じで終わらせるのがなかなかない仕様で好きです。', NULL, NULL, NULL, NULL, NULL, NULL),
(23, 'ミセス・ダウト', 4, 1994, '家族の大切さを再認識できるハートフルコメディ', NULL, NULL, NULL, NULL, NULL, NULL),
(24, 'メアリー＆マックス', 2, 2011, 'いろいろと考えさせられる映画です。\r\n心に余裕があるときに見て欲しいです。', NULL, NULL, NULL, NULL, NULL, NULL),
(25, 'モンスターハウス', 2, 2007, 'なんか、やり切れません。\r\nおじいさんが素敵すぎる(・ω・`)', NULL, NULL, NULL, NULL, NULL, NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `movie_genre`
--

INSERT INTO `movie_genre` (`id`, `genre`, `registration_date`, `renewal_date`, `registration_userid`, `renewal_userid`, `control`, `delete`) VALUES
(0, '不明', NULL, NULL, NULL, NULL, NULL, NULL),
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
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
