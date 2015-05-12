-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 5 朁E08 日 17:56
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
  `control` int(50) NOT NULL,
  `deleteflg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `movie`
--

INSERT INTO `movie` (`id`, `title`, `genreId`, `exhibition_year`, `comment`, `registration_date`, `renewal_date`, `registration_userid`, `renewal_userid`, `control`, `deleteflg`) VALUES
(1, 'E.T.', 3, 1982, 'おうちカエル。。。。゛(ノ‥)ノｶｴﾙ…', '2014/07/29 10:27:17', '2014/06/29 10:27:17', 'frog', 'frog', 0, 0),
(2, 'アイアン・ジャイアント', 2, 2000, 'ヒーローΣΣ≡≡≡ｰ(ｰ´･ω･`)ｰ', '2007/09/10 16:27:17', '2007/09/10 16:27:17', 'atom', 'atom', 0, 0),
(3, 'あなたは私の婿になる', 7, 2009, 'なかなかに…\r\n(*｀Λ´*)｣ﾍﾞ､ﾍﾞﾂﾆｽｷｯﾃﾜｹｼﾞｬ…', '2012/03/02 19:23:45', '2012/03/02 19:23:45', 'queen', 'queen', 0, 0),
(4, 'エスター', 6, 2009, '（゜言゜）ｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞ', '2009/08/12 22:54:36', '2009/08/12 22:54:36', '戯言', '戯言', 0, 0),
(5, 'グリーンマイル', 8, 1999, '大好きすぎる( p′︵‵。)', '2000/12/13 17:48:27', '2000/12/13 17:48:27', 'アル', 'アル', 0, 0),
(6, 'ゲット・スマート', 4, 2008, 'ヽ(ﾟ∀ﾟ)ﾉ うぇ──────ぃ♪', '2008/07/26 21:58:02', '2008/07/26 21:58:02', 'mosomoso', 'mosomoso', 0, 0),
(7, 'コンスタンティン', 6, 2005, 'キアヌちゃんが素敵すぎる(´•ω•｀♥)', '2006/10/02 21:42:54', '2006/10/02 21:42:54', 'Dy', 'Dy', 0, 0),
(8, '最高の人生の見つけ方', 8, 2008, '秘書ー（┘｀゜Д゜´）┘\r\n君の活躍を私は知っている！', '2009/01/02 16:21:19', '2009/01/02 16:21:19', 'ポン吉', 'ポン吉', 0, 0),
(9, 'ジュマンジ', 3, 1996, '20年…。\r\n長かったよな…。', '1997/04/02 18:46:13', '1997/04/02 18:46:13', '蘭子', '蘭子', 0, 0),
(10, 'スパイダーマン', 1, 2002, 'みんな知ってるちょーヒーロー！', '2002/09/07 22:32:41', '2002/09/07 22:32:41', 'クマゴロー', 'クマゴロー', 0, 0),
(11, '戦火の馬', 8, 2012, 'ｏ（・∀・ ）ｏ－－－－∈･^ミ┬┬~ ﾋﾋｨｰﾝ...', '2012/11/14 21:41:56', '2012/11/14 21:41:56', 'Aniki', 'Aniki', 0, 0),
(12, 'ダ・ヴィンチ・コード', 5, 2006, '芸術+宗教+ミステリー=傑作！', '2006/12/08 00:10:21', '2006/12/08 00:10:21', 'puku', 'puku', 0, 0),
(13, '第9地区', 3, 2010, 'B級だけどなぜか忘れられないドキュメンタリー風映画です。', '2013/08/17 19:31:49', '2013/08/17 19:31:49', '現場', '現場', 0, 0),
(14, 'タイタニック', 7, 1997, 'カレシ欲しくなる…', '2002/09/21 23:23:56', '2002/09/21 23:23:56', 'ひよこ', 'ひよこ', 0, 0),
(15, 'タイピスト', 7, 2013, '西洋の雰囲気大好き(っ*''''ω''''*c)', '2013/01/18 17:34:01', '2013/01/18 17:34:01', 'みこ', 'みこ', 0, 0),
(16, 'トランスフォーマー', 1, 2007, 'ヽ(ヽω・`)ﾍｰﾝ (´・ω/)ゞｼﾝ!! -=≡ ﾄｫｰ!!ヽ(•̀ω•́ )ゝ✧', '2007/07/30 20:27:29', '2007/07/30 20:27:29', '柚子', '柚子', 0, 0),
(17, 'ナイトミュージアム', 4, 2007, 'お猿さんお利口すぎる。', '2008/10/24 19:37:41', '2008/10/24 19:37:41', 'バブル', 'バブル', 0, 0),
(18, 'ハイド・アンド・シーク', 6, 2005, '(；ﾟДﾟ艸)', '2006/08/17 05:45:21', '2006/08/17 05:45:21', 'pocota', 'pocota', 0, 0),
(19, 'ハンガー・ゲーム', 1, 2012, '15歳で過酷なサバイバルゲームに投じられた主人公…。\r\n誰が生き残るのか、恋の行方は？', '2014/12/29 03:21:36', '2014/12/29 03:21:36', 'kennkenn', 'kennkenn', 0, 0),
(20, 'ファンタスティック・フォー', 1, 2005, 'ヽ( ▼∀▼)ﾉ ﾌｫｰ!!', '2008/11/03 21:07:14', '2008/11/03 21:07:14', '( ﾟДﾟ)', '( ﾟДﾟ)', 0, 0),
(21, 'ブラックスワン', 5, 2011, 'ダークです。', '2014/04/11 14:55:23', '2014/04/11 14:55:23', 'nivo', 'nivo', 0, 0),
(22, 'ミスト', 5, 2008, '最後の主人公をあんな感じで終わらせるのがなかなかない仕様で好きです。', '2015/08/21 08:13:37', '2015/08/21 08:13:37', 'トロンボー', 'トロンボー', 0, 0),
(23, 'ミセス・ダウト', 4, 1994, '家族の大切さを再認識できるハートフルコメディ', '2013/06/07 10:20:24', '2013/06/07 10:20:24', 'つくつく', 'つくつく', 0, 0),
(24, 'メアリー＆マックス', 2, 2011, 'いろいろと考えさせられる映画です。\r\n心に余裕があるときに見て欲しいです。', '2012/02/05 21:39:57', '2012/02/05 21:39:57', 'mary', 'mary', 0, 0),
(25, 'モンスターハウス', 2, 2007, 'なんか、やり切れません。\r\nおじいさんが素敵すぎる(・ω・`)', '2009/10/29 21:49:42', '2009/10/29 21:49:42', 'koro', 'koro', 0, 0);

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
  `renewal_userid` char(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `movie_genre`
--

INSERT INTO `movie_genre` (`id`, `genre`, `registration_date`, `renewal_date`, `registration_userid`, `renewal_userid`) VALUES
(0, '', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(1, 'アクション', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(2, 'アニメ', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(3, 'SF・ファンタジー', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(4, 'コメディ', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(5, 'サスペンス', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(6, 'ホラー', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(7, '恋愛', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美'),
(8, 'その他', '1998/01/01 00:34:01', '1998/01/01 00:34:01', '瑠美', '瑠美');

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
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
