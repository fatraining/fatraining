-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015 年 10 朁E13 日 11:35
-- サーバのバージョン： 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

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
-- テーブルの構造 `company`
--

CREATE TABLE IF NOT EXISTS `company` (
  `id` smallint(3) NOT NULL,
  `name` char(20) NOT NULL,
  `prefecture` char(5) NOT NULL,
  `phonenumber` char(11) NOT NULL,
  `registeredperson` char(20) NOT NULL,
  `registrationdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateby` char(20) NOT NULL,
  `updatedate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `e_flag` bigint(11) unsigned NOT NULL,
  `d_flag` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `company`
--

INSERT INTO `company` (`id`, `name`, `prefecture`, `phonenumber`, `registeredperson`, `registrationdate`, `updateby`, `updatedate`, `e_flag`, `d_flag`) VALUES
(1, '佐藤株式会社', '東京都', '0344556633', '高橋', '1900-01-02 00:00:00', '高橋', '1900-02-24 00:00:00', 0, 0),
(2, '鈴木株式会社', '神奈川県', '0358575588', '福田', '1900-02-03 00:00:00', '福田', '1901-11-07 00:00:00', 0, 0),
(3, '田中株式会社', '千葉県', '0854654345', '長野', '1900-02-24 00:00:00', '長野', '1902-05-26 00:00:00', 0, 0),
(4, 'a1', '静岡県', '0123456789', 'Struts2', '2015-10-13 14:05:32', 'Struts2', '2015-10-13 14:05:32', 0, 0),
(5, 'a2', '埼玉県', '0123456790', 'Struts2', '2015-10-13 14:07:45', 'Struts2', '2015-10-13 14:07:45', 0, 0),
(6, 'a3', '東京都', '0123456791', 'Struts2', '2015-10-13 14:09:18', 'Struts2', '2015-10-13 14:09:18', 0, 0),
(7, 'a4', '神奈川県', '0123456792', 'Struts2', '2015-10-13 14:10:45', 'Struts2', '2015-10-13 14:10:45', 0, 0),
(8, 'a5', '千葉県', '0123456793', 'Struts2', '2015-10-13 14:12:05', 'Struts2', '2015-10-13 14:12:05', 0, 0),
(9, 'a6', '静岡県', '0123456794', 'Struts2', '2015-10-13 14:13:44', 'Struts2', '2015-10-13 14:13:44', 0, 0),
(10, 'a7', '埼玉県', '0123456795', 'Struts2', '2015-10-13 14:15:05', 'Struts2', '2015-10-13 14:15:05', 0, 0),
(11, 'a8', '東京都', '0123456796', 'Struts2', '2015-10-13 14:16:38', 'Struts2', '2015-10-13 14:16:38', 0, 0),
(12, 'a9', '神奈川県', '0123456797', 'Struts2', '2015-10-13 14:18:37', 'Struts2', '2015-10-13 14:18:37', 0, 0),
(13, 'a10', '千葉県', '0123456798', 'Struts2', '2015-10-13 14:19:41', 'Struts2', '2015-10-13 14:19:41', 0, 0);

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
-- テーブルの構造 `gamecompany`
--

CREATE TABLE `gamecompany` (
  `ID` int(2) NOT NULL,
  `CompanyName` varchar(15) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `gamecompany`
--

INSERT INTO `gamecompany` (`ID`, `CompanyName`) VALUES
(1, '任天堂'),
(2, 'カプコン'),
(3, 'アトラス'),
(4, 'コーエーテクモ'),
(5, 'コナミ'),
(6, 'スパイク・チュンソフト'),
(7, 'セガ'),
(8, 'ソニー'),
(9, 'スクウェア・エニックス'),
(10, 'タカラトミー'),
(11, '日本一ソフトウェア'),
(12, '日本マイクロソフト'),
(13, 'バンダイナムコ'),
(14, 'マーベラス'),
(15, 'レベルファイブ');

-- --------------------------------------------------------

--
-- テーブルの構造 `gametitle`
--

CREATE TABLE `gametitle` (
  `ID` int(10) NOT NULL,
  `Name` varchar(30) COLLATE utf8_bin NOT NULL,
  `CompanyID` int(2) NOT NULL,
  `Genre` varchar(15) COLLATE utf8_bin NOT NULL,
  `Hardware` varchar(10) COLLATE utf8_bin NOT NULL,
  `Comment` text COLLATE utf8_bin NOT NULL,
  `RegistrationUserID` varchar(20) COLLATE utf8_bin NOT NULL,
  `RegistrationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `gametitle`
--

INSERT INTO `gametitle` (`ID`, `Name`, `CompanyID`, `Genre`, `Hardware`, `Comment`, `RegistrationUserID`, `RegistrationDate`) VALUES
(1, 'かまいたちの夜', 6, 'サウンドノベル', 'SFC', '２のほうが好き', '', '2015-11-24 07:07:29'),
(2, '星のカービィ　スーパーデラックス', 1, 'アクション', 'SFC', 'はるかぜとともに', '', '2015-11-24 07:07:29'),
(3, 'バルーンファイト', 1, 'アクション', 'FC', 'あに　ゆるさん', '', '2015-11-24 07:07:29'),
(9, 'ぼくのなつやすみ', 8, 'アドベンチャー', 'PS', 'おもいで', '', '2015-11-24 07:07:29'),
(15, '牧場物語3 ハートに火をつけて', 14, 'シミュレーション', 'PS2', 'いそげ', 'Struts2', '2015-11-27 03:06:01');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- テーブルの構造 `registration_name`
--
-- for conflict

CREATE TABLE IF NOT EXISTS `registration_name` (
  `id` int(11) NOT NULL,
  `registration_number` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `competition_number` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registered_person` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registration_date` datetime DEFAULT NULL,
  `update_by` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `e_flag` int(2) DEFAULT NULL,
  `d_flag` int(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `registration_name`
--

INSERT INTO `registration_name` (`id`, `registration_number`, `name`, `competition_number`, `registered_person`, `registration_date`, `update_by`, `update_date`, `e_flag`, `d_flag`) VALUES
(1, '1', '中野', '2', '中野', '2015-11-01 00:00:00', '中野', '2015-12-15 00:00:00', 1, 1),
(2, '2', '太田', '1', '太田', '2015-11-01 00:00:00', '太田', '2015-12-15 00:00:00', 0, 0),
(3, '3', '大原', '3', '大原', '2015-11-03 00:00:00', '大原', '2015-10-17 00:00:00', 0, 1);

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
-- テーブルの構造 `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `id` smallint(3) NOT NULL,
  `name` char(20) NOT NULL,
  `prefecture` char(5) NOT NULL,
  `phonenumber` char(11) NOT NULL,
  `companyID` smallint(3) NOT NULL,
  `registeredperson` char(20) NOT NULL,
  `registrationdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateby` char(20) NOT NULL,
  `updatedate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `e_flag` bigint(11) unsigned NOT NULL,
  `d_flag` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `staff`
--

INSERT INTO `staff` (`id`, `name`, `prefecture`, `phonenumber`, `companyID`, `registeredperson`, `registrationdate`, `updateby`, `updatedate`, `e_flag`, `d_flag`) VALUES
(1, '鈴木', '埼玉県', '08076546543', 2, '鈴木', '1900-11-28 00:00:00', '鈴木', '1901-03-19 00:00:00', 0, 0),
(2, '田中', '神奈川県', '09034521345', 3, '田中', '1900-11-28 00:00:00', '田中', '1901-07-08 00:00:00', 0, 0),
(3, '佐藤', '静岡県', '08045676543', 1, '佐藤', '1900-11-29 00:00:00', '佐藤', '1901-10-27 00:00:00', 0, 0),
(4, 'a1', '東京都', '098765432', 4, 'Struts2', '2015-10-13 14:05:32', 'Struts2', '2015-10-13 14:05:32', 0, 0),
(5, 'a2', '静岡県', '0987654322', 5, 'Struts2', '2015-10-13 14:07:45', 'Struts2', '2015-10-13 14:07:45', 0, 0),
(6, 'a3', '埼玉県', '0987654323', 6, 'Struts2', '2015-10-13 14:09:18', 'Struts2', '2015-10-13 14:09:18', 0, 0),
(7, 'a4', '神奈川県', '0987654324', 7, 'Struts2', '2015-10-13 14:10:45', 'Struts2', '2015-10-13 14:10:45', 0, 0),
(8, 'a5', '静岡県', '0987654325', 8, 'Struts2', '2015-10-13 14:12:05', 'Struts2', '2015-10-13 14:12:05', 0, 0),
(9, 'a6', '東京都', '0987654326', 9, 'Struts2', '2015-10-13 14:13:44', 'Struts2', '2015-10-13 14:13:44', 0, 0),
(10, 'a7', '静岡県', '0987654327', 10, 'Struts2', '2015-10-13 14:15:05', 'Struts2', '2015-10-13 14:15:05', 0, 0),
(11, 'a8', '埼玉県', '0987654328', 11, 'Struts2', '2015-10-13 14:16:38', 'Struts2', '2015-10-13 14:16:38', 0, 0),
(12, 'a9', '神奈川県', '0987654329', 12, 'Struts2', '2015-10-13 14:18:37', 'Struts2', '2015-10-13 14:18:37', 0, 0),
(13, 'a10', '静岡県', '0987654330', 13, 'Struts2', '2015-10-13 14:19:41', 'Struts2', '2015-10-13 14:19:41', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `sport_event`
--

CREATE TABLE IF NOT EXISTS `sport_event` (
  `id` int(11) NOT NULL,
  `competition_number` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sport` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registered_person` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registration_date` datetime DEFAULT NULL,
  `update_by` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `e_flag` int(2) DEFAULT NULL,
  `d_flag` int(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `sport_event`
--

INSERT INTO `sport_event` (`id`, `competition_number`, `sport`, `registered_person`, `registration_date`, `update_by`, `update_date`, `e_flag`, `d_flag`) VALUES
(1, '1', 'テニス', '小泉', '2015-03-15 00:00:00', '小泉', '2015-07-10 00:00:00', 1, 1),
(2, '2', 'サッカー', '高橋', '2015-06-10 00:00:00', '高橋', '2015-09-20 00:00:00', 1, 0),
(3, '3', '野球', '青木', '2015-08-15 00:00:00', '青木', '2015-12-10 00:00:00', 1, 0);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_character`
--

INSERT INTO `user_character` (`id`, `personality`, `interest`, `day`, `newday`, `userid`, `newuserid`, `deleteFlg`, `flg`) VALUES
(1, '???', '???', '2015/10/06 14:36:59', '2015/10/06 14:36:59', 'Struts2', 'Struts2', 0, 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_profile`
--

INSERT INTO `user_profile` (`id`, `phonenumber`, `zipcode`, `dwelling`, `name`, `personality2`, `day`, `newday`, `userid`, `newuserid`, `deleteFlg`, `flg`) VALUES
(1, 124551334, 1111234, '??????????', '???', 1, '2015/10/06 14:36:59', '2015/10/06 14:36:59', 'Struts2', 'Struts2', 0, 0);

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
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `gamecompany`
--
ALTER TABLE `gamecompany`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `gametitle`
--
ALTER TABLE `gametitle`
  ADD PRIMARY KEY (`ID`);

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
-- Indexes for table `registration_name`
--
ALTER TABLE `registration_name`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ryouri`
--
ALTER TABLE `ryouri`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sport_event`
--
ALTER TABLE `sport_event`
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
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` smallint(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
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
-- AUTO_INCREMENT for table `gamecompany`
--
ALTER TABLE `gamecompany`
  MODIFY `ID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `gametitle`
--
ALTER TABLE `gametitle`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
  
--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `like_game`
--
ALTER TABLE `like_game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT';
--
-- AUTO_INCREMENT for table `like_series`
--
ALTER TABLE `like_series`
  MODIFY `up_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT';
--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `registration_name`
--
ALTER TABLE `registration_name`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `ryouri`
--
ALTER TABLE `ryouri`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=154;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` smallint(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `sport_event`
--
ALTER TABLE `sport_event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT';
--
-- AUTO_INCREMENT for table `sweets`
--
ALTER TABLE `sweets`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `table_busyo`
--
ALTER TABLE `table_busyo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `table_color`
--
ALTER TABLE `table_color`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `table_hobby`
--
ALTER TABLE `table_hobby`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `table_kaisya`
--
ALTER TABLE `table_kaisya`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `table_like`
--
ALTER TABLE `table_like`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `table_profile`
--
ALTER TABLE `table_profile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_genre`
--
ALTER TABLE `tb_genre`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT';
--
-- AUTO_INCREMENT for table `user_character`
--
ALTER TABLE `user_character`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `yasai`
--
ALTER TABLE `yasai`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=149;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
