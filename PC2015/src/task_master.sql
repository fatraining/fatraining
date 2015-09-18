-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 9 朁E18 日 11:00
-- サーバのバージョン： 5.6.21
-- PHP Version: 5.5.19

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
-- テーブルの構造 `band_account`
--

CREATE TABLE IF NOT EXISTS `band_account` (
`ID` int(50) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `SEX` varchar(50) DEFAULT NULL,
  `AGE` varchar(50) DEFAULT NULL,
  `SCHOOL` varchar(50) DEFAULT NULL,
  `FAVORITE_SONG` varchar(50) DEFAULT NULL,
  `PART` varchar(50) DEFAULT NULL,
  `BAND_ID` int(50) DEFAULT NULL,
  `ENTRY_DATE` varchar(50) DEFAULT NULL,
  `RENEWAL_DATE` varchar(50) DEFAULT NULL,
  `ENTRY_USERID` varchar(50) DEFAULT NULL,
  `RENEWAL_USERID` varchar(50) DEFAULT NULL,
  `EXCLUSION_FLG` int(50) DEFAULT NULL,
  `DELETE_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `band_account`
--

INSERT INTO `band_account` (`ID`, `NAME`, `SEX`, `AGE`, `SCHOOL`, `FAVORITE_SONG`, `PART`, `BAND_ID`, `ENTRY_DATE`, `RENEWAL_DATE`, `ENTRY_USERID`, `RENEWAL_USERID`, `EXCLUSION_FLG`, `DELETE_FLG`) VALUES
(1, '佐藤敏夫', '男', '20', '銀座大学', '二月の兵隊', 'ギター', 1, '2015/05/08 15:48:33', '2015/05/08 15:48:33', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `band_table`
--

CREATE TABLE IF NOT EXISTS `band_table` (
`ID` int(50) NOT NULL,
  `BAND_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ENTRY_DATE` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `RENEWAL_DATE` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ENTRY_USERID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `RENEWAL_USERID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSION_FLG` int(50) DEFAULT NULL,
  `DELETE_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `band_table`
--

INSERT INTO `band_table` (`ID`, `BAND_NAME`, `ENTRY_DATE`, `RENEWAL_DATE`, `ENTRY_USERID`, `RENEWAL_USERID`, `EXCLUSION_FLG`, `DELETE_FLG`) VALUES
(1, '砂糖と塩', '2015/05/08 15:48:33', '2015/05/08 15:48:33', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `eat_detail`
--

CREATE TABLE IF NOT EXISTS `eat_detail` (
`id` int(50) NOT NULL,
  `eat_year` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eat_month` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eat_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eat_hour` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `food_id` int(50) NOT NULL,
  `entry_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_flg` int(50) NOT NULL,
  `delete_flg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `eat_detail`
--

INSERT INTO `eat_detail` (`id`, `eat_year`, `eat_month`, `eat_day`, `eat_hour`, `food_id`, `entry_day`, `renew_day`, `entry_userid`, `renew_userid`, `renew_flg`, `delete_flg`) VALUES
(1, '2015', '1', '1', 'AM', 1, '2015/05/08 18:0:29', '2015/05/08 18:0:29', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `eat_id`
--

CREATE TABLE IF NOT EXISTS `eat_id` (
`id` int(50) NOT NULL,
  `eatFood` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eatCalory` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_day` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entry_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_userid` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renew_flg` int(50) NOT NULL,
  `delete_flg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `eat_id`
--

INSERT INTO `eat_id` (`id`, `eatFood`, `eatCalory`, `entry_day`, `renew_day`, `entry_userid`, `renew_userid`, `renew_flg`, `delete_flg`) VALUES
(1, 'お餅', '350kcal', '2015/05/08 18:0:29', '2015/05/08 18:0:29', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `genre`
--

CREATE TABLE IF NOT EXISTS `genre` (
`id` int(50) NOT NULL,
  `genreNm` char(50) DEFAULT NULL,
  `record_date` char(50) DEFAULT NULL,
  `reset_date` char(50) DEFAULT NULL,
  `entry_userId` char(50) DEFAULT NULL,
  `record_userId` char(50) DEFAULT NULL,
  `exclusive_FLG` int(50) DEFAULT NULL,
  `delete_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `genre`
--

INSERT INTO `genre` (`id`, `genreNm`, `record_date`, `reset_date`, `entry_userId`, `record_userId`, `exclusive_FLG`, `delete_FLG`) VALUES
(1, '焼き菓子', '2015/05/08 15:52:42', '2015/05/08 15:52:42', 'testUser', 'testUser', 0, 0),
(2, '冷菓', '2015/05/08 15:52:42', '2015/05/08 15:52:42', 'testUser', 'testUser', 0, 0),
(3, 'チョコレート菓子', '2015/05/08 15:52:42', '2015/05/08 15:52:42', 'testUser', 'testUser', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `like_game`
--

CREATE TABLE IF NOT EXISTS `like_game` (
`id` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `seriesId` int(11) DEFAULT NULL,
  `trump` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Origin` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updateDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addUserID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `upUserID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `another_flg` int(11) NOT NULL,
  `delete_flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `like_game`
--

INSERT INTO `like_game` (`id`, `title`, `seriesId`, `trump`, `Origin`, `addDate`, `updateDate`, `addUserID`, `upUserID`, `another_flg`, `delete_flg`) VALUES
(18, 'Fate/stay night', 29, 'Unlimited Blade Works', 'Swrod', '05/08', '05/08', 'Struts2', 'Struts2', 0, 0),
(19, 'Fate/hollow  ataraxia ', 30, 'Angra Mainyu', 'Evil', '05/13', '05/13', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `like_series`
--

CREATE TABLE IF NOT EXISTS `like_series` (
`up_id` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `seriesNm` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updateDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `addUserId` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `upUserId` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `another_flg` int(11) NOT NULL,
  `delete_flg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `like_series`
--

INSERT INTO `like_series` (`up_id`, `seriesNm`, `addDate`, `updateDate`, `addUserId`, `upUserId`, `another_flg`, `delete_flg`) VALUES
(29, 'Fate', '05/08', '05/08', 'Struts2', 'Struts2', 0, 0),
(30, 'Fate', '05/13', '05/13', 'Struts2', 'Struts2', 0, 0);

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

-- --------------------------------------------------------

--
-- テーブルの構造 `ryouri`
--

CREATE TABLE IF NOT EXISTS `ryouri` (
`id` int(50) NOT NULL,
  `tyouri` varchar(50) DEFAULT NULL,
  `ryouri` varchar(50) DEFAULT NULL,
  `date_entry` varchar(50) DEFAULT NULL,
  `date_up` varchar(50) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `userId_up` varchar(50) DEFAULT NULL,
  `control` int(50) NOT NULL,
  `deleteflg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `ryouri`
--

INSERT INTO `ryouri` (`id`, `tyouri`, `ryouri`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(138, '野菜', '野菜', '2015/05/08 15:51:2', NULL, 'Struts2', NULL, 0, 0),
(139, '煮る', '肉じゃが', '2015/05/08 15:51:45', NULL, 'Struts2', NULL, 0, 0),
(140, '炒める', '野菜炒め', '2015/05/08 15:52:21', NULL, 'Struts2', NULL, 0, 0),
(144, 'a1', 'a1', '2015/05/11 19:44:9', NULL, 'Struts2', NULL, 0, 0),
(145, 'a2', 'a2', '2015/05/11 19:44:17', NULL, 'Struts2', NULL, 0, 0),
(146, 'a3', 'a3', '2015/05/11 19:44:25', NULL, 'Struts2', NULL, 0, 0),
(147, 'a4', 'a4', '2015/05/11 19:44:32', NULL, 'Struts2', NULL, 0, 0),
(148, 'a5', 'a5', '2015/05/11 19:44:49', NULL, 'Struts2', NULL, 0, 0),
(149, 'a6', 'a6', '2015/05/11 19:44:55', NULL, 'Struts2', NULL, 0, 0),
(150, 'a7', 'a7', '2015/05/11 19:45:7', NULL, 'Struts2', NULL, 0, 0),
(151, 'a8', 'a8', '2015/05/11 19:45:15', NULL, 'Struts2', NULL, 0, 0),
(152, 'a9', 'a9', '2015/05/11 19:45:23', NULL, 'Struts2', NULL, 0, 0),
(153, 'a10', 'a10', '2015/05/11 19:45:31', NULL, 'Struts2', NULL, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `story`
--

CREATE TABLE IF NOT EXISTS `story` (
`id` int(50) NOT NULL COMMENT 'AUTO_INCREMENT',
  `title` varchar(50) DEFAULT NULL,
  `genre_id` varchar(50) DEFAULT NULL,
  `signup` varchar(50) DEFAULT NULL,
  `updateDate` varchar(50) DEFAULT NULL,
  `signupUSERID` varchar(50) DEFAULT NULL,
  `updateUSERID` varchar(50) DEFAULT NULL,
  `exclusiveFLG` int(50) DEFAULT NULL,
  `deleteFLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `story`
--

INSERT INTO `story` (`id`, `title`, `genre_id`, `signup`, `updateDate`, `signupUSERID`, `updateUSERID`, `exclusiveFLG`, `deleteFLG`) VALUES
(17, '黒い家', '14', '2015/05/07 17:22:52', '2015/05/07 17:22:52', NULL, NULL, 0, 0),
(18, 'ああああ', '15', '2015/05/07 17:23:23', '2015/05/07 17:23:23', 'dsf', 'dsf', 0, 0),
(19, '黒い家', '16', '2015/09/16 10:36:32', '2015/09/16 10:36:32', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `sweets`
--

CREATE TABLE IF NOT EXISTS `sweets` (
`id` int(50) NOT NULL,
  `name` char(50) DEFAULT NULL,
  `genre_id` int(50) DEFAULT NULL,
  `record_date` char(50) DEFAULT NULL,
  `reset_date` char(50) DEFAULT NULL,
  `entry_userId` char(50) DEFAULT NULL,
  `record_userId` char(50) DEFAULT NULL,
  `exclusive_FLG` int(50) DEFAULT NULL,
  `delete_FLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `sweets`
--

INSERT INTO `sweets` (`id`, `name`, `genre_id`, `record_date`, `reset_date`, `entry_userId`, `record_userId`, `exclusive_FLG`, `delete_FLG`) VALUES
(15, 'クッキー', 1, '2015/05/08 16:41:54', '2015/05/08 16:41:54', 'hokari', 'hokari', 0, 0),
(16, 'ガレット', 1, '2015/05/08 16:42:1', '2015/05/08 16:42:1', 'hokari', 'hokari', 0, 0),
(17, 'トリュフ', 3, '2015/05/11 15:58:29', '2015/05/11 15:58:29', 'Struts2', 'Struts2', 0, 0),
(18, 'プリン', 2, '2015/05/11 15:58:38', '2015/05/11 15:58:38', 'Struts2', 'Struts2', 0, 0),
(19, 'スコーン', 1, '2015/05/11 15:58:52', '2015/05/11 15:58:52', 'Struts2', 'Struts2', 0, 0),
(20, 'ババロア', 2, '2015/05/11 15:59:1', '2015/05/11 15:59:1', 'Struts2', 'Struts2', 0, 0),
(21, 'バウムクーヘン', 1, '2015/05/11 15:59:32', '2015/05/11 15:59:32', 'Struts2', 'Struts2', 0, 0),
(22, 'ガトーショコラ', 3, '2015/05/11 15:59:46', '2015/05/11 15:59:46', 'Struts2', 'Struts2', 0, 0),
(23, '羊羹', 2, '2015/05/11 15:59:55', '2015/05/11 15:59:55', 'Struts2', 'Struts2', 0, 0),
(24, 'マドレーヌ', 1, '2015/05/11 16:0:11', '2015/05/11 16:0:11', 'Struts2', 'Struts2', 0, 0),
(25, '生チョコ', 3, '2015/05/11 16:0:53', '2015/05/11 16:0:53', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_busyo`
--

CREATE TABLE IF NOT EXISTS `table_busyo` (
`id` int(11) NOT NULL,
  `busyo` char(80) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `day_entry` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `day_up` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userId` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userId_up` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `control` int(11) NOT NULL,
  `deleteflg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `table_busyo`
--

INSERT INTO `table_busyo` (`id`, `busyo`, `day_entry`, `day_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(1, '技術部', '2015/09/17 9:10:34', '2015/09/17 9:10:34', 'Struts2', 'Struts2', 0, 0),
(2, '営業部', '2015/09/17 10:10:30', '2015/09/17 10:10:30', 'Struts2', 'Struts2', 0, 0),
(3, '技術部', '2015/09/17 10:12:23', '2015/09/17 10:12:23', 'Struts2', 'Struts2', 0, 0),
(4, '技術部', '2015/09/17 10:13:39', '2015/09/17 10:13:39', 'Struts2', 'Struts2', 0, 0),
(5, '技術部', '2015/09/17 10:16:58', '2015/09/17 10:16:58', 'Struts2', 'Struts2', 0, 0),
(6, '技術部', '2015/09/17 10:18:0', '2015/09/17 10:18:0', 'Struts2', 'Struts2', 0, 0),
(7, '技術部', '2015/09/17 10:18:51', '2015/09/17 10:18:51', 'Struts2', 'Struts2', 0, 0),
(8, '技術部', '2015/09/17 10:19:43', '2015/09/17 10:19:43', 'Struts2', 'Struts2', 0, 0),
(9, '技術部', '2015/09/17 10:20:51', '2015/09/17 10:20:51', 'Struts2', 'Struts2', 0, 0),
(10, '技術部', '2015/09/17 10:21:37', '2015/09/17 10:21:37', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_color`
--

CREATE TABLE IF NOT EXISTS `table_color` (
`id` int(50) NOT NULL,
  `colorNm` char(50) DEFAULT NULL,
  `day` char(50) DEFAULT NULL,
  `new_day` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `new_userid` char(50) DEFAULT NULL,
  `time_stamp` int(50) DEFAULT NULL,
  `deleteFlg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `table_color`
--

INSERT INTO `table_color` (`id`, `colorNm`, `day`, `new_day`, `userid`, `new_userid`, `time_stamp`, `deleteFlg`) VALUES
(1, '青', '2015/05/08 17:54:37', '2015/05/08 17:54:37', 'Struts2', 'Struts2', 0, 0),
(2, '白', '2015/05/08 17:55:16', '2015/05/08 17:55:16', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_hobby`
--

CREATE TABLE IF NOT EXISTS `table_hobby` (
`id` int(11) NOT NULL,
  `hobby` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dbflg` int(11) DEFAULT NULL,
  `deleteflg` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `table_hobby`
--

INSERT INTO `table_hobby` (`id`, `hobby`, `day`, `new_day`, `userid`, `new_userid`, `dbflg`, `deleteflg`) VALUES
(1, '書道', '2015/05/08 18:7:44', '2015/05/08 18:7:44', 'Struts2', 'Struts2', 0, 0),
(2, 'サッカー', '2015/05/08 18:8:6', '2015/05/08 18:8:6', 'Struts2', 'Struts2', 0, 0),
(3, 'サッカー', '2015/05/08 18:8:26', '2015/05/08 18:8:26', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_kaisya`
--

CREATE TABLE IF NOT EXISTS `table_kaisya` (
`id` int(11) NOT NULL,
  `syamei` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` char(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nyusyabi` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `busyo_id` int(11) NOT NULL,
  `comment` char(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `day_entry` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `day_up` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userId` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userId_up` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `control` int(11) NOT NULL,
  `deleteflg` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `table_kaisya`
--

INSERT INTO `table_kaisya` (`id`, `syamei`, `name`, `nyusyabi`, `busyo_id`, `comment`, `day_entry`, `day_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(1, 'フューチャー・アンティークス', '武政　奈津美', '2015年4月1日', 1, 'メニュー１担当', '2015/09/17 9:10:34', '2015/09/17 9:10:34', 'Struts2', 'Struts2', 0, 0),
(2, 'フューチャー・アンティークス', '帆刈　優実', '2015年4月1日', 2, 'メニュー２担当', '2015/09/17 10:10:30', '2015/09/17 10:10:30', 'Struts2', 'Struts2', 0, 0),
(3, 'フューチャー・アンティークス', '河野　慶子', '2015年4月1日', 3, 'メニュー３担当', '2015/09/17 10:12:23', '2015/09/17 10:12:23', 'Struts2', 'Struts2', 0, 0),
(4, 'フューチャー・アンティークス', '佐藤　大樹', '2015年4月1日', 4, 'メニュー４担当', '2015/09/17 10:13:39', '2015/09/17 10:13:39', 'Struts2', 'Struts2', 0, 0),
(5, 'フューチャー・アンティークス', '大野　舞', '2015年4月1日', 5, '小動物担当(｢・ω・)｢ｶﾞｵｰ', '2015/09/17 10:16:58', '2015/09/17 10:16:58', 'Struts2', 'Struts2', 0, 0),
(6, 'フューチャー・アンティークス', '篠崎　春佳', '2015年4月1日', 6, 'メニュー６担当', '2015/09/17 10:18:0', '2015/09/17 10:18:0', 'Struts2', 'Struts2', 0, 0),
(7, 'フューチャー・アンティークス', '牛山　奈々美', '2015年4月1日', 7, 'メニュー７担当', '2015/09/17 10:18:51', '2015/09/17 10:18:51', 'Struts2', 'Struts2', 0, 0),
(8, 'フューチャー・アンティークス', '吉田　会友子', '2015年4月1日', 8, 'メニュー８担当', '2015/09/17 10:19:43', '2015/09/17 10:19:43', 'Struts2', 'Struts2', 0, 0),
(9, 'フューチャー・アンティークス', '江口　優花', '2015年4月1日', 9, 'メニュー９担当', '2015/09/17 10:20:51', '2015/09/17 10:20:51', 'Struts2', 'Struts2', 0, 0),
(10, 'フューチャー・アンティークス', '横山　万里子', '2015年4月1日', 10, 'メニュー１０担当', '2015/09/17 10:21:37', '2015/09/17 10:21:37', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_like`
--

CREATE TABLE IF NOT EXISTS `table_like` (
`id` int(50) NOT NULL,
  `name` char(50) DEFAULT NULL,
  `food` char(50) DEFAULT NULL,
  `drink` char(50) DEFAULT NULL,
  `color` int(50) DEFAULT NULL,
  `day` char(50) DEFAULT NULL,
  `new_day` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `new_userid` char(50) DEFAULT NULL,
  `time_stamp` int(50) DEFAULT NULL,
  `deleteFlg` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `table_like`
--

INSERT INTO `table_like` (`id`, `name`, `food`, `drink`, `color`, `day`, `new_day`, `userid`, `new_userid`, `time_stamp`, `deleteFlg`) VALUES
(1, '橘', 'ピザ', '水', 1, '2015/05/08 17:54:37', '2015/05/08 17:54:37', 'Struts2', 'Struts2', 0, 0),
(2, '岡本', 'ケーキ', 'コーヒー', 2, '2015/05/08 17:55:16', '2015/05/08 17:55:16', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `table_profile`
--

CREATE TABLE IF NOT EXISTS `table_profile` (
`id` int(11) NOT NULL,
  `name` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `personality` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hobby_id` int(11) DEFAULT NULL,
  `day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_day` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_userid` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dbflg` int(11) DEFAULT NULL,
  `deleteflg` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `table_profile`
--

INSERT INTO `table_profile` (`id`, `name`, `personality`, `home`, `birthday`, `hobby_id`, `day`, `new_day`, `userid`, `new_userid`, `dbflg`, `deleteflg`) VALUES
(1, '真斗', '大人しい', '京都', '12', 1, '2015/05/08 18:7:44', '2015/05/08 18:7:44', 'Struts2', 'Struts2', 0, 0),
(2, '音也', '元気', '東京', '4', 2, '2015/05/08 18:8:6', '2015/05/08 18:8:6', 'Struts2', 'Struts2', 0, 0),
(3, '翔', '男気', '名古屋', '6', 3, '2015/05/08 18:8:26', '2015/05/08 18:8:26', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `tb_genre`
--

CREATE TABLE IF NOT EXISTS `tb_genre` (
`id` int(50) NOT NULL COMMENT 'AUTO_INCREMENT',
  `genre` varchar(50) DEFAULT NULL,
  `signup` varchar(50) DEFAULT NULL,
  `updateDate` varchar(50) DEFAULT NULL,
  `signupUSERID` varchar(50) DEFAULT NULL,
  `updateUSERID` varchar(50) DEFAULT NULL,
  `exclusiveFLG` int(50) DEFAULT NULL,
  `deleteFLG` int(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `tb_genre`
--

INSERT INTO `tb_genre` (`id`, `genre`, `signup`, `updateDate`, `signupUSERID`, `updateUSERID`, `exclusiveFLG`, `deleteFLG`) VALUES
(14, 'ホラー', '2015/05/07 17:22:52', '2015/05/07 17:22:52', NULL, NULL, 0, 0),
(15, 'いいいい', '2015/05/07 17:23:23', '2015/05/07 17:23:23', 'dsf', 'dsf', 0, 0),
(16, 'ホラー', '2015/09/16 10:36:32', '2015/09/16 10:36:32', 'Struts2', 'Struts2', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `user_character`
--

CREATE TABLE IF NOT EXISTS `user_character` (
`id` int(11) NOT NULL,
  `personality` char(50) DEFAULT NULL,
  `interest` char(50) DEFAULT NULL,
  `day` char(50) DEFAULT NULL,
  `newday` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `newuserid` char(50) DEFAULT NULL,
  `deleteFlg` int(11) DEFAULT NULL,
  `flg` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_character`
--

INSERT INTO `user_character` (`id`, `personality`, `interest`, `day`, `newday`, `userid`, `newuserid`, `deleteFlg`, `flg`) VALUES
(9, '穏やか', 'けん玉', '2015/05/08 16:49:50', '2015/05/08 16:49:50', NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
`id` int(11) NOT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  `dwelling` char(50) DEFAULT NULL,
  `name` char(50) DEFAULT NULL,
  `personality2` int(11) NOT NULL,
  `day` char(50) DEFAULT NULL,
  `newday` char(50) DEFAULT NULL,
  `userid` char(50) DEFAULT NULL,
  `newuserid` char(50) DEFAULT NULL,
  `deleteFlg` int(11) DEFAULT NULL,
  `flg` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_profile`
--

INSERT INTO `user_profile` (`id`, `phonenumber`, `zipcode`, `dwelling`, `name`, `personality2`, `day`, `newday`, `userid`, `newuserid`, `deleteFlg`, `flg`) VALUES
(7, 124551334, 1111234, '千葉県印旛郡栄町矢口', '田中進', 9, '2015/05/08 16:49:50', '2015/05/08 16:49:50', NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `yasai`
--

CREATE TABLE IF NOT EXISTS `yasai` (
`id` int(50) NOT NULL,
  `yasai` varchar(50) DEFAULT NULL,
  `tyouriId` int(50) DEFAULT NULL,
  `date_entry` varchar(50) DEFAULT NULL,
  `date_up` varchar(50) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `userId_up` varchar(50) DEFAULT NULL,
  `control` int(50) NOT NULL,
  `deleteflg` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `yasai`
--

INSERT INTO `yasai` (`id`, `yasai`, `tyouriId`, `date_entry`, `date_up`, `userId`, `userId_up`, `control`, `deleteflg`) VALUES
(133, '野菜', 138, '2015/05/08 15:51:2', NULL, 'Struts2', NULL, 0, 0),
(134, 'じゃがいも', 139, '2015/05/08 15:51:45', NULL, 'Struts2', NULL, 0, 0),
(135, 'きゃべつ', 140, '2015/05/08 15:52:21', NULL, 'Struts2', NULL, 0, 0),
(139, 'a1', 144, '2015/05/11 19:44:9', NULL, 'Struts2', NULL, 0, 0),
(140, 'a2', 145, '2015/05/11 19:44:17', NULL, 'Struts2', NULL, 0, 0),
(141, 'a3', 146, '2015/05/11 19:44:25', NULL, 'Struts2', NULL, 0, 0),
(142, 'a4', 147, '2015/05/11 19:44:32', NULL, 'Struts2', NULL, 0, 0),
(143, 'a5', 148, '2015/05/11 19:44:49', NULL, 'Struts2', NULL, 0, 0),
(144, 'a6', 149, '2015/05/11 19:44:55', NULL, 'Struts2', NULL, 0, 0),
(145, 'a7', 150, '2015/05/11 19:45:7', NULL, 'Struts2', NULL, 0, 0),
(146, 'a8', 151, '2015/05/11 19:45:15', NULL, 'Struts2', NULL, 0, 0),
(147, 'a9', 152, '2015/05/11 19:45:23', NULL, 'Struts2', NULL, 0, 0),
(148, 'a10', 153, '2015/05/11 19:45:31', NULL, 'Struts2', NULL, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `band_account`
--
ALTER TABLE `band_account`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `band_table`
--
ALTER TABLE `band_table`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `eat_detail`
--
ALTER TABLE `eat_detail`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `eat_id`
--
ALTER TABLE `eat_id`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
 ADD PRIMARY KEY (`id`);

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
-- Indexes for table `ryouri`
--
ALTER TABLE `ryouri`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `story`
--
ALTER TABLE `story`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sweets`
--
ALTER TABLE `sweets`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_busyo`
--
ALTER TABLE `table_busyo`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_color`
--
ALTER TABLE `table_color`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_hobby`
--
ALTER TABLE `table_hobby`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_kaisya`
--
ALTER TABLE `table_kaisya`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_like`
--
ALTER TABLE `table_like`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_profile`
--
ALTER TABLE `table_profile`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_genre`
--
ALTER TABLE `tb_genre`
 ADD PRIMARY KEY (`id`);

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
-- Indexes for table `yasai`
--
ALTER TABLE `yasai`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `band_account`
--
ALTER TABLE `band_account`
MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `band_table`
--
ALTER TABLE `band_table`
MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `eat_detail`
--
ALTER TABLE `eat_detail`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `eat_id`
--
ALTER TABLE `eat_id`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `like_game`
--
ALTER TABLE `like_game`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `like_series`
--
ALTER TABLE `like_series`
MODIFY `up_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `ryouri`
--
ALTER TABLE `ryouri`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=154;
--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `sweets`
--
ALTER TABLE `sweets`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `table_busyo`
--
ALTER TABLE `table_busyo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `table_color`
--
ALTER TABLE `table_color`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `table_hobby`
--
ALTER TABLE `table_hobby`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `table_kaisya`
--
ALTER TABLE `table_kaisya`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `table_like`
--
ALTER TABLE `table_like`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `table_profile`
--
ALTER TABLE `table_profile`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_genre`
--
ALTER TABLE `tb_genre`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `user_character`
--
ALTER TABLE `user_character`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `yasai`
--
ALTER TABLE `yasai`
MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=149;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
