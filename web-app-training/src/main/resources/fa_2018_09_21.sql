-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 
-- サーバのバージョン： 10.1.34-MariaDB
-- PHP Version: 7.2.8

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
-- テーブルの構造 `body_izawa`
--

CREATE TABLE `body_izawa` (
  `id` int(2) DEFAULT NULL,
  `bodyname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `body_izawa`
--

INSERT INTO `body_izawa` (`id`, `bodyname`) VALUES
(0, NULL),
(1, '大胸筋'),
(2, '背筋'),
(3, '三頭筋'),
(4, '上腕二頭筋'),
(5, '上腕三頭筋'),
(6, 'その他');

-- --------------------------------------------------------

--
-- テーブルの構造 `brand_ito`
--

CREATE TABLE `brand_ito` (
  `brand_id` int(2) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `brand_ito`
--

INSERT INTO `brand_ito` (`brand_id`, `brand`, `del_flg`, `create_date`, `update_date`) VALUES
(1, '東芝', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(2, '日立', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(3, 'パナソニック', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(4, 'SONY', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(5, 'シャープ', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(0, '', '0', '2018-09-20 02:46:14', '2018-09-10 05:00:00');

-- --------------------------------------------------------

--
-- テーブルの構造 `category_ito`
--

CREATE TABLE `category_ito` (
  `category_id` int(2) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `category_ito`
--

INSERT INTO `category_ito` (`category_id`, `category`, `del_flg`, `create_date`, `update_date`) VALUES
(1, 'テレビ', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(2, '洗濯機', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(3, '冷蔵庫', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(4, '掃除機', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(5, 'エアコン', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(0, '', '0', '2018-09-20 02:46:43', '2018-09-10 05:00:00');

-- --------------------------------------------------------

--
-- テーブルの構造 `dorama_genre`
--

CREATE TABLE `dorama_genre` (
  `id` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` varchar(14) NOT NULL,
  `update_date` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `dorama_genre`
--

INSERT INTO `dorama_genre` (`id`, `genre`, `del_flg`, `create_date`, `update_date`) VALUES
(0, '', 0, '2017/11/08', '2017/11/08'),
(1, '学園', 0, '2017/11/08', '2017/11/08'),
(2, 'ラブストーリー', 0, '2017/11/08', '2017/11/08'),
(3, '刑事', 0, '2017/11/08', '2017/11/08'),
(4, 'コメディ', 0, '2017/11/08', '2017/11/08'),
(5, '医療', 0, '2017/11/08', '2017/11/08');

-- --------------------------------------------------------

--
-- テーブルの構造 `dorama_main`
--

CREATE TABLE `dorama_main` (
  `id` int(11) NOT NULL,
  `dorama_title` varchar(255) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `tvstation_id` int(11) DEFAULT NULL,
  `release_year` int(4) NOT NULL,
  `star` varchar(255) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `dorama_main`
--

INSERT INTO `dorama_main` (`id`, `dorama_title`, `genre_id`, `tvstation_id`, `release_year`, `star`, `del_flg`, `create_date`, `update_date`) VALUES
(2, '高校教師', 2, 4, 1993, '真田広之', 0, '2017-11-09 12:12:12', '2018-05-21 17:10:55'),
(3, 'ごくせん', 1, 2, 2002, '仲間由紀恵', 0, '2017-11-10 12:12:12', '2017-11-10 12:12:12'),
(4, 'オトナ高校', 1, 3, 2018, '三浦春馬', 0, '2017-11-11 12:12:12', '2017-11-11 12:12:12'),
(5, 'コンデラタロウ', 1, 1, 2017, '松井愛莉', 0, '2017-11-12 12:12:12', '2017-11-12 12:12:12'),
(6, 'やまとなでしこ', 2, 5, 2000, '松嶋菜々子', 0, '2017-11-13 12:12:12', '2017-11-13 12:12:12'),
(7, '太陽の季節', 2, 4, 2002, '滝沢秀明', 0, '2017-11-14 12:12:12', '2017-11-14 12:12:12'),
(8, 'おっさんずラブ', 2, 3, 2018, '田中圭', 0, '2017-11-15 12:12:12', '2017-11-15 12:12:12'),
(9, '運命に、似た恋', 2, 1, 2016, '原田知世', 0, '2017-11-16 12:12:12', '2017-11-16 12:12:12'),
(10, '僕だけのマドンナ', 2, 5, 2003, '滝沢秀明', 0, '2017-11-17 12:12:12', '2017-11-17 12:12:12'),
(11, '相棒', 3, 3, 2002, '水谷豊', 0, '2017-11-18 12:12:12', '2017-11-18 12:12:12'),
(12, '踊る大捜査線', 3, 5, 1997, '織田裕二', 0, '2017-11-19 12:12:12', '2017-11-19 12:12:12'),
(13, 'ケイゾク', 3, 4, 1999, '中谷美紀', 0, '2017-11-20 12:12:12', '2017-11-20 12:12:12'),
(14, 'デカワンコ', 3, 2, 2011, '多部未華子', 0, '2017-11-21 12:12:12', '2017-11-21 12:12:12'),
(15, '古畑任三郎', 3, 5, 1994, '田村正和', 0, '2017-11-22 12:12:12', '2017-11-22 12:12:12'),
(16, '明日があるさ', 4, 2, 2001, '浜田雅功', 0, '2017-11-23 12:12:12', '2017-11-23 12:12:12'),
(17, '不機嫌なジーン', 4, 5, 2005, '竹内結子', 0, '2017-11-24 12:12:12', '2017-11-24 12:12:12'),
(18, '奥さまは魔女', 4, 4, 2004, '米倉涼子', 0, '2017-11-25 12:12:12', '2017-11-25 12:12:12'),
(19, 'HomeSweetTokyo', 4, 1, 2017, '木村佳乃', 0, '2017-11-26 12:12:12', '2017-11-26 12:12:12'),
(20, '新宿スワン', 4, 3, 2007, '北村栄基', 0, '2017-11-27 12:12:12', '2017-11-27 12:12:12'),
(21, '医龍', 5, 5, 2006, '坂口憲二', 0, '2017-11-28 12:12:12', '2017-11-28 12:12:12'),
(22, '白い影', 5, 4, 2001, '中居正広', 0, '2017-11-29 12:12:12', '2017-11-29 12:12:12'),
(23, 'ナースマン', 5, 2, 2002, '松岡昌宏', 0, '2017-11-30 12:12:12', '2017-11-30 12:12:12'),
(24, 'ドクターX', 5, 3, 2012, '米倉涼子', 0, '2017-12-01 12:12:12', '2017-12-01 12:12:12'),
(25, '救命病棟24時', 5, 5, 1999, '江口洋介', 0, '2017-12-02 12:12:12', '2017-12-02 12:12:12'),
(26, '女王の教室', 1, 2, 2005, '天海祐希', 0, '2017-12-03 12:12:12', '2017-12-03 12:12:12'),
(27, '元カレ', 2, 4, 2003, '堂本剛', 0, '2017-12-04 12:12:12', '2017-12-04 12:12:12'),
(28, '事件だ事件だ', 3, 2, 2008, '小田和正', 0, '2018-05-21 16:25:14', '2018-05-21 16:25:14'),
(29, '僕の生きる道', 1, 5, 2003, '草彅剛', 0, '2018-05-22 09:37:27', '2018-05-22 09:37:27');

-- --------------------------------------------------------

--
-- テーブルの構造 `electronics_main_ito`
--

CREATE TABLE `electronics_main_ito` (
  `id` int(2) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `category_id` int(2) DEFAULT NULL,
  `brand_id` int(2) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `del_flg` varchar(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `electronics_main_ito`
--

INSERT INTO `electronics_main_ito` (`id`, `product_name`, `category_id`, `brand_id`, `release_year`, `price`, `comment`, `del_flg`, `create_date`, `update_date`) VALUES
(2, 'BRAVIA KJ-49X9000F', 1, 4, 2018, 139720, '4K液晶テレビ', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(3, 'VIERA TH-49EX750', 1, 3, 2017, 102494, 'ヘキサクロマドライブ搭載', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(4, 'AQUOS 4K NEXT LC-70XG35', 1, 5, 2015, 381290, '70インチのビッグサイズ', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(5, 'ヒートリサイクル 風アイロン ビッグドラム BD-SV110BL', 2, 2, 2017, 138888, '強力循環ポンプ', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(6, 'NA-VX9800L', 2, 3, 2017, 176800, 'スマホで洗濯機能付き', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(7, 'ZABOON AW-8V6', 2, 1, 2017, 72500, '浸透ザブーン洗浄', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(8, 'ES-P110-SL', 2, 5, 2017, 152700, 'クールなデザイン', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(9, '真空チルド R-XG5100H', 3, 2, 2017, 127460, '真空チルド採用', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(10, 'NR-F503HPX', 3, 3, 2017, 146000, '大容量化を実現', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(11, 'SJ-D14D', 3, 5, 2017, 28499, '安い', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(12, 'VEGETA GR-M470GW', 3, 1, 2018, 144360, '最新冷蔵庫', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(13, 'パワーブーストサイクロン PV-BEH900', 4, 2, 2017, 36800, 'コードレスクリーナー', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(14, 'トルネオ ヴイ コードレス VC-CL1400', 4, 1, 2017, 35900, 'ハイスピードDCモーター搭載', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(15, 'RACTIVE Air EC-AR2S', 4, 5, 2018, 31571, '業界最軽量', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(16, 'MC-PA100G', 4, 3, 2017, 29494, '普通', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(17, 'エオリア CS-228CF', 5, 3, 2018, 38300, '一番人気', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(18, '白くまくん RAS-AJ22H', 5, 2, 2018, 36480, '冷えそうなネーミングセンス', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(19, 'AY-H22DH', 5, 5, 2018, 36680, 'ただただ普通', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00'),
(20, '大清快 RAS-C225P', 5, 1, 2017, 44977, 'マジック洗浄熱交換器搭載', '0', '2018-09-10 05:00:00', '2018-09-10 05:00:00');

-- --------------------------------------------------------

--
-- テーブルの構造 `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` varchar(14) NOT NULL,
  `update_date` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `genre`
--

INSERT INTO `genre` (`id`, `genre`, `del_flg`, `create_date`, `update_date`) VALUES
(0, '', 0, '2017/11/08', '2017/11/08'),
(1, 'アクション', 0, '2017/11/08', '2017/11/08'),
(2, 'サスペンス', 0, '2017/11/08', '2017/11/08'),
(3, 'ヒューマン', 0, '2017/11/08', '2017/11/08'),
(4, 'ホラー', 0, '2017/11/08', '2017/11/08'),
(5, 'コメディ', 0, '2017/11/08', '2017/11/08');

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
-- テーブルの構造 `movie_actor`
--

CREATE TABLE `movie_actor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` varchar(14) NOT NULL,
  `update_date` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `movie_actor`
--

INSERT INTO `movie_actor` (`id`, `name`, `del_flg`, `create_date`, `update_date`) VALUES
(0, '', 0, '2017/11/08', '2017/11/08'),
(1, 'トム・ハンクス', 0, '2017/11/08', '2017/11/08'),
(2, 'トビー・マグワイア', 0, '2017/11/08', '2017/11/08'),
(3, 'ジェームズ・マカヴォイ', 0, '2017/11/08', '2017/11/08'),
(4, 'ナタリー・ポートマン', 0, '2017/11/08', '2017/11/08'),
(5, 'アン・ハサウェイ', 0, '2017/11/08', '2017/11/08');

-- --------------------------------------------------------

--
-- テーブルの構造 `movie_main`
--

CREATE TABLE `movie_main` (
  `id` int(11) NOT NULL,
  `movie_title` varchar(255) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `actor_id` int(11) DEFAULT NULL,
  `release_year` int(4) NOT NULL,
  `run_time` int(3) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `movie_main`
--

INSERT INTO `movie_main` (`id`, `movie_title`, `genre_id`, `actor_id`, `release_year`, `run_time`, `comment`, `del_flg`, `create_date`, `update_date`) VALUES
(1, 'スパイダーマン3', 1, 2, 2007, 156, 'アメイジング・ホームカミングより好き', 1, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(2, 'X-MEN FC', 1, 3, 2011, 132, 'X-MEN誕生秘話、ばちぼこ面白い。', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(3, 'レオン', 1, 4, 1994, 110, 'マチルダがかわいい', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(4, 'ダークナイトライジング', 1, 5, 2012, 165, 'DCコミック頑張れ', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(5, 'ベイビードライバー', 1, NULL, 2017, 113, '続編が制作されるそう', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(6, 'トランス', 2, 3, 2013, 101, 'ダニー・ボイル監督', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(7, 'フィルス', 2, 3, 2013, 97, 'スコットランドの最悪刑事', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(8, '華麗なるギャツビー', 2, 2, 2013, 143, '豪華絢爛', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(9, 'ブリッジオブスパイ', 2, 1, 2015, 144, 'アカデミー助演男優賞受賞', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(10, 'ダ・ヴィンチ・コード', 2, 1, 2006, 174, 'オドレイ・トトゥ老けたなあ', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(11, 'フォレストガンプ', 3, 1, 1994, 142, '言わずと知れた名言の宝庫', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(12, '完全なるチェックメイト', 3, 2, 2014, 116, 'ボビーフィッシャー', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(13, 'あの頃僕らは', 3, 2, 2001, 90, '若かりしディカプリオ', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(14, 'レミゼラブル', 3, 5, 2012, 160, '歌部分はアテレコではありません', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(15, 'グリーンマイル', 3, 1, 1999, 189, '『ショーシャンクの空に』もいいです', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(16, 'ブラックスワン', 4, 4, 2011, 108, '下手なホラーより怖いかも', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(17, 'IT', 4, NULL, 2017, 135, 'TVムービー編もどうぞ', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(18, 'キャリー', 4, NULL, 1976, 98, 'スティーブン・キングの処女作', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(19, 'スプリット', 4, 3, 2017, 117, 'シャマラン作品を見ておくと吉', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(20, 'glass', 4, 3, 2018, NULL, 'スプリットの続編', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(21, 'マイ・インターン', 5, 5, 2015, 121, '『プラダを着た悪魔』もおすすめ', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(22, 'ターミナル', 5, 1, 2004, 128, '空港に住んでみたい', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(23, 'ペネロピ', 5, 3, 2008, 104, '現代のおとぎ話', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(24, 'アリスインワンダーランド', 5, 5, 2010, 113, '映像美すごい', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(25, 'キャッツ＆ドッグス', 5, 2, 2001, 87, '犬はかわいい', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(26, 'つぐない', NULL, 3, 2007, 130, '陰鬱な時にはおすすめしません', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(27, 'プライドと偏見', NULL, NULL, 2005, 135, 'コリン・ファースのドラマ版も良き', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(28, 'グレイテストショーマン', 3, NULL, 2017, 105, '個人的にラ・ラ・ランド越え', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
(29, 'ビッグ', 5, 1, 1988, 130, '素敵な気持になれる', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00');

-- --------------------------------------------------------

--
-- テーブルの構造 `muscle_izawa`
--

CREATE TABLE `muscle_izawa` (
  `id` int(2) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `body` int(2) DEFAULT NULL,
  `com` varchar(255) DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `muscle_izawa`
--

INSERT INTO `muscle_izawa` (`id`, `photo`, `menu`, `body`, `com`, `del_flg`) VALUES
(1, '/izawaimage/Bench-press-1-2-289x300.png', 'バーベルベンチプレス', 1, '大胸筋トレーニングの王道とも言えるのが「筋トレBIG3」の一つであるバーベルベンチプレスです。肩甲骨を寄せ、顎をやや引いて行うのがポイントです。', 0),
(4, '/izawaimage/Dumbbell-bench-press-2-215x300.png', 'ダンベルプレス', 1, '自宅でのダンベルトレーニングのなかで、大胸筋を鍛えるのに最適な種目がダンベルプレスです。ベンチがない場合は、床の上で行っても効果を得ることが可能です。', 0),
(5, '/izawaimage/main-qimg-c200b655392c1a5c23e9ee1613bc8ce3-300x178.png', 'ダンベルフライ', 1, 'ダンベルプレスの仕上げとして効果的なのがダンベルフライです。腕を閉じたフィニッシュのポジションでやや腕を上に持ち上げる動きを加えるとさらに効果が高まります。', 0),
(6, '/izawaimage/Dumbbell-bent-arm-pullover-2-300x279.png', 'ベントアームダンベルプルオーバー', 1, '大胸筋に縦方向の刺激を加えるとともに、胸郭を広げる作用もあるのがベントアームプルオーバーで、大胸筋トレーニングの仕上げにも最適な種目です。広背筋狙いのプルオーバーと違い、肘を曲げるのがポイントです。', 0),
(7, '/izawaimage/300px-Dips-300x273.png', 'ディップス', 1, '自重トレーニング種目のなかでも、大胸筋下部に効果の高い種目がディップスです。特別な道具がなくても、椅子を二つ使うことで代用できます。', 0),
(8, '/izawaimage/17-01-15-09-14-15-858_deco-300x225.jpg', '懸垂', 2, '自重トレーニングで広背筋・僧帽筋を鍛えるスタンダードな種目が懸垂です。順手のノーマルグリップで行えば広背筋に、縦持ちのパラレルグリップで行えば僧帽筋に負荷がかかります。', 0),
(9, '/izawaimage/800px-Body-row-2-270x300.png', '斜め懸垂', 2, '懸垂ができない方におすすめなのが斜め懸垂です。自宅で行う場合は、テーブルの下に仰向けに入り、テーブルの縁を持って行うことで代用できます。', 0),
(10, '/izawaimage/Rear-deltoid-row-1-3-275x300.png', 'ダンベルローイング', 2, 'ダンベル筋トレで背筋トレーニングの基本となるのがダンベルローイングです。標準的なやり方だと僧帽筋を中心に効きますが、頭を低くし前方から引く軌道で行うと広背筋に負荷が強くかかります。', 0),
(11, '/izawaimage/Straight-arm-pullover-2-300x260.png', 'ストレートアームダンベルプルオーバー', 2, 'ダンベルプルオーバーは意識の仕方で大胸筋にも広背筋にも効果のあるダンベル筋トレです。肘を伸ばすとともに肘を内側に閉じ気味で動作を行うと広背筋に負荷が集まります。', 0),
(12, '/izawaimage/Barbell-rear-delt-row-1-288x300.png', 'デッドリフト', 2, 'ジムで行うバーベル筋トレで背筋に高負荷を加えられるのが「筋トレBIG3」の一つであるデッドリフトです。腰椎保護のため背中を丸めないように最大の注意を払ってください。なお、デッドリフトにかぎらず、背筋トレーニングで握力が先になくなってしまう人はリストストラップがとても有効です', 0),
(13, '/izawaimage/Reverse-grip-bent-over-rows-2-284x300.png', 'バーベルベントオーバーロー', 2, 'バーベルベントオーバーローは、デッドリフトとと並び代表的な背筋のバーベルトレーニングです。膝がつま先より前に出ないように注意し、胸を張り、背中をやや反らせて行ってください。', 0),
(14, '/izawaimage/17-01-16-18-08-14-691_deco-300x233.jpg', 'ワイドグリップ腕立て伏せ', 3, '通常の腕立て伏せより手幅を広く構えるワイドグリップでの腕立て伏せは三角筋に強い負荷がかかります。プッシュアップバーの使用がおすすめです。', 0),
(15, '/izawaimage/17-02-01-16-34-56-568_deco-300x225.jpg', 'ダンベルショルダープレス', 3, 'ダンベルでの三角筋トレーニングのベースとなる種目がダンベルショルダープレスです。三角筋全体に効果がありますが、特に前部と側部に効果的です。なお、肩関節保護のために、肘が体幹より後ろにならないように動作するのがポイントです。', 0),
(16, '/izawaimage/5ad150fc550d8093e0e3d6e42acc4716-300x288.jpg', 'ダンベルアップライトロー', 3, '三角筋は体幹の筋肉と連動しやすいので、上手く鍛えるのが難しい部位ですが、ダンベルアップライトローなら初心者でも比較的簡単に効かせることが可能です', 0),
(17, '/izawaimage/dubbellfrontraise-235x300.jpg', 'ダンベルフロントレイズ', 3, '三角筋前部を集中的に鍛えることのできるのがダンベルフロントレイズです。反動を使うと僧帽筋に刺激が逃げてしまうので注意してください。慣れるまでは左右交互に挙上するオルタネイト動作で行うことをおすすめします', 0),
(18, '/izawaimage/Dumbbell-lateral-raises-1-3-272x300.png', 'ダンベルサイドレイズ', 3, '三角筋中部を集中的に鍛えることのできるダンベル種目がダンベルサイドレイズです。反動を使わないことがポイントで、もし、膝の屈伸を使わないと挙上できないのであれば、その重量設定は重すぎます。', 0),
(19, '/izawaimage/Seated-military-shoulder-press-1-236x300.png', 'バーベルショルダープレス', 3, 'バーベルトレーニングで三角筋を鍛えるのスタンダードな種目がバーベルショルダープレスです。反動を使わずに、上げる時も下げる時もゆっくりと動作をするのが最大のポイントになります。', 0),
(20, '/izawaimage/Chin-ups-1-crop-300x235.png', 'リバース懸垂', 4, '手を逆手にするリバースグリップで行う懸垂は、自宅で上腕二頭筋を鍛えるのに最適な自重トレーニングです。手幅を拳一つ分ほどに狭めるとより効果的です。', 0),
(21, '/izawaimage/Alternating_bicep_curl_with_dumbbell_2.svg-crop-247x300.png', 'ダンベルカール', 4, '自宅でのダンベルトレーニングで上腕二頭筋に効果的なのがダンベルカールです。挙上するときに小指が上になるように旋回させると長頭(力こぶの高さ)に、逆方向に旋回させると短頭(力こぶの太さ)に効果があります。なお、アームブラスターと呼ばれるギアを併用すると、完全に反動をなくした状態で上腕二頭筋に負荷を爆発的に集中することができます。', 0),
(22, '/izawaimage/Bicep_hammer_curl_with_dumbbell_2.svg-crop-278x300.png', 'ダンベルハンマーカール', 4, '10ダンベルを縦にグリップして行うダンベルハンマーカールは、上腕二頭筋のなかでも長頭(外側)に効果的なやり方です。', 0),
(23, '/izawaimage/Wide_grip_standing_biceps_curl_with_barbell_2.svg-300x277.png', 'バーベルカール', 4, '上腕二頭筋を鍛えるスタンダードな種目がバーベルカールです。ただし、通常のバーベルでは上手くならないと手首を痛めがちなので、できれば曲線のついたWバーやEZバーを使うようにするとよいでしょう。', 0),
(24, '/izawaimage/Drag-curl-2-241x300.jpg', 'バーベルリバースカール', 4, 'バーベルリバースカールは上腕二頭筋の長頭と上腕筋、さらには前腕筋群にも効果的なバーベルトレーニングです。握力に自身のない方はリストストラップを併用することをおすすめします。', 0),
(25, '/izawaimage/Close_triceps_pushup_1.svg-300x153.png', 'ダイヤモンド腕立て伏せ', 5, '自宅で自重トレーニングで上腕三頭筋短頭を鍛えるのにおすすめなのが、両手でダイヤモンド型を作って行うナローグリップでの腕立て伏せです。肘をできる限り開かずに動作することで、上腕三頭筋への負荷が高まります。', 0),
(26, '/izawaimage/Standing-triceps-extension-2-1-horz-1-300x198.jpg', 'ダンベルフレンチプレス', 5, '自宅でのダンベルトレーニングのなかでも上腕三頭筋を集中的に鍛えられるのが、ダンベルフレンチプレス(別名ダンベルトライセプスエクステンション)です。肘をしっかりと固定し、上腕三頭筋だけで動作をするようにするのがポイントとなります。', 0),
(27, '/izawaimage/Dumbbell-incline-bench-press-1-crop-crop2-300x230.png', 'ダンベルトライセプスプレス', 5, 'ダンベルプレスとは逆方向にダンベルをグリップするダンベルトライセプスプレスは上腕三頭筋に負荷を集中させることが可能です。', 0),
(28, '/izawaimage/Rear-deltoid-row-1-crop-1-300x238.png', 'ダンベルキックバック', 5, '上腕三頭筋のなかでも長頭に効果的なのがダンベルキックバックです。腕を完全に伸ばせる重量設定で行うのが最大のポイントです。', 0),
(29, '/izawaimage/Close_grip_barbell_bench_press-2-300x209.png', 'ナローグリップベンチプレス', 5, 'ジムで上腕三頭筋を鍛える定番トレーニング種目がナローグリップベンチプレスです。通常のベンチプレスと違い、肩甲骨を寄せずに行うことで上腕三頭筋に刺激が集中します。', 0),
(30, '/izawaimage/cable-wrist-curl-231x300.png', 'リストカール', 6, '前腕筋の基本的な筋トレメニューがリストカールです。リストカールで前腕屈筋群を鍛えたら、バランスよくリバースリストカールで前腕伸筋群も鍛えるようにしましょう。また、縦方向の筋力を養うのにはリストハンマーで鍛える必要があります。', 0),
(31, '/izawaimage/Leg-raises-1-300x254.png', 'レッグレイズ', 6, '腹直筋下部に効果の高い腹筋運動がレッグレイズです。息を吐きながら脚を持ち上げていきましょう。また、負荷を逃がさないためと腰椎への負担をかけないために、セット中は足を床につけないように注意してください。', 0),
(32, '/izawaimage/Front-squat-to-bench-2-858x1024-crop-300x300.png', '自重スクワット', 6, '自宅で行う自重トレーニングとして最適な種目が自重スクワットです。胸を張り、背中を反らせたニーベントスタイルが動作の基本です。また、膝関節を痛めないために、膝がつま先より前にでないように気をつけてください。', 0),
(33, '/izawaimage/Barbell_squat_2.svg-1-250x300.png', 'バーベルスクワット', 6, 'バーベルトレーニングのなかで、もっとも基本的なトレーニング種目が「筋トレBIG3」の一つであるバーベルスクワットです。自重スクワット同様にニーベントスタイルを作り、やや斜め後方に腰を下ろしてください。', 0),
(37, NULL, 'バーベルベンチプレス＠やんべこうた食いしん坊', 6, '111', 1),
(38, '	\r\n/izawaimage/10yen.jpg', '乞食じゃないよ藤木だよ', 6, '10円をいただくために登録するが1日でサービス停止', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `music`
--

CREATE TABLE `music` (
  `id` int(11) UNSIGNED NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `author` varchar(255) CHARACTER SET utf8 DEFAULT 'unknown',
  `rating` int(11) DEFAULT '0',
  `comment` varchar(255) DEFAULT NULL,
  `category_id` int(11) UNSIGNED DEFAULT '0',
  `video_url` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `music`
--

INSERT INTO `music` (`id`, `title`, `author`, `rating`, `comment`, `category_id`, `video_url`, `create_date`, `update_date`, `version`) VALUES
(4, '心太软', '任贤齐', 5, '年代比较久远的一首歌，当年很流行，现在依然有很多人喜欢。', 3, 'https://www.youtube.com/embed/ZSWeurc1yMw', '2018-03-19 15:12:14', '2018-03-19 15:12:14', 5),
(9, '漂洋过海来看你', '娃娃', 5, '', 3, 'https://www.youtube.com/embed/hNQohQBFnwI', '2018-03-19 16:05:12', '2018-03-19 16:05:12', 2),
(10, '雪の華', '中島美嘉', 5, '', 5, 'https://www.youtube.com/embed/mF5Qq2YheTg', '2018-03-19 17:18:19', '2018-03-19 17:18:19', 1),
(11, 'MY ALL', '濱崎步', 5, '', 5, 'https://www.youtube.com/embed/PKptgq8jTYw', '2018-03-19 17:27:07', '2018-03-19 17:27:07', 1),
(12, 'Time after time ～花舞う街で～', '仓木麻衣', 5, '', 4, 'https://www.youtube.com/embed/Ep_W5rYXyi0', '2018-03-19 17:28:57', '2018-03-19 17:28:57', 1),
(13, '夢的點滴', '松隆子', 5, '', 6, 'https://www.youtube.com/embed/Vn6xGeMY9w8', '2018-03-19 17:31:46', '2018-03-19 17:31:46', 1),
(14, 'big big world', 'Emilia', 5, '', 5, 'https://www.youtube.com/embed/wpkS2DU_qMs', '2018-03-19 17:33:04', '2018-03-19 17:33:04', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `music_category`
--

CREATE TABLE `music_category` (
  `id` int(11) UNSIGNED NOT NULL,
  `category` varchar(255) NOT NULL DEFAULT '',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `delete_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `music_category`
--

INSERT INTO `music_category` (`id`, `category`, `create_date`, `update_date`, `is_delete`, `delete_date`, `version`) VALUES
(0, '', NULL, NULL, 0, NULL, 0),
(1, 'DJ', NULL, NULL, 0, NULL, 0),
(2, 'Light', NULL, NULL, 0, NULL, 0),
(3, 'China', NULL, NULL, 0, NULL, 0),
(4, 'ACG', NULL, NULL, 0, NULL, 0),
(5, 'Pop', NULL, NULL, 0, NULL, 0),
(6, 'Classical', NULL, NULL, 0, NULL, 0);

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

-- --------------------------------------------------------

--
-- テーブルの構造 `tv_station`
--

CREATE TABLE `tv_station` (
  `id` int(11) NOT NULL,
  `tv_station` varchar(255) NOT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `create_date` varchar(14) NOT NULL,
  `update_date` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `tv_station`
--

INSERT INTO `tv_station` (`id`, `tv_station`, `del_flg`, `create_date`, `update_date`) VALUES
(0, '', 0, '2017/11/08', '2017/11/08'),
(1, 'NHK', 0, '2017/11/08', '2017/11/08'),
(2, '日本テレビ', 0, '2017/11/08', '2017/11/08'),
(3, 'テレビ朝日', 0, '2017/11/08', '2017/11/08'),
(4, 'TBS', 0, '2017/11/08', '2017/11/08'),
(5, 'フジテレビ', 0, '2017/11/08', '2017/11/08');

-- --------------------------------------------------------

--
-- テーブルの構造 `user`
--

CREATE TABLE `user` (
  `id` int(11) UNSIGNED NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `password` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'Spring', 'Boot');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `body_izawa`
--
ALTER TABLE `body_izawa`
  ADD UNIQUE KEY `id` (`id`,`bodyname`);

--
-- Indexes for table `dorama_genre`
--
ALTER TABLE `dorama_genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dorama_main`
--
ALTER TABLE `dorama_main`
  ADD PRIMARY KEY (`id`),
  ADD KEY `genre_id` (`genre_id`),
  ADD KEY `tvstation_id` (`tvstation_id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `janru`
--
ALTER TABLE `janru`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movie_actor`
--
ALTER TABLE `movie_actor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movie_main`
--
ALTER TABLE `movie_main`
  ADD PRIMARY KEY (`id`),
  ADD KEY `genre_id` (`genre_id`),
  ADD KEY `actor_id` (`actor_id`);

--
-- Indexes for table `muscle_izawa`
--
ALTER TABLE `muscle_izawa`
  ADD UNIQUE KEY `id` (`id`,`photo`,`menu`,`body`,`com`,`del_flg`),
  ADD UNIQUE KEY `id_2` (`id`,`photo`,`menu`,`body`,`com`,`del_flg`);

--
-- Indexes for table `music`
--
ALTER TABLE `music`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_music_type` (`category_id`);

--
-- Indexes for table `music_category`
--
ALTER TABLE `music_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `music_kichise_main`
--
ALTER TABLE `music_kichise_main`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tv_station`
--
ALTER TABLE `tv_station`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `music`
--
ALTER TABLE `music`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `music_category`
--
ALTER TABLE `music_category`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `dorama_main`
--
ALTER TABLE `dorama_main`
  ADD CONSTRAINT `dorama_main_ibfk_1` FOREIGN KEY (`genre_id`) REFERENCES `dorama_genre` (`id`),
  ADD CONSTRAINT `dorama_main_ibfk_2` FOREIGN KEY (`tvstation_id`) REFERENCES `tv_station` (`id`);

--
-- テーブルの制約 `movie_main`
--
ALTER TABLE `movie_main`
  ADD CONSTRAINT `movie_main_ibfk_1` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `movie_main_ibfk_2` FOREIGN KEY (`actor_id`) REFERENCES `movie_actor` (`id`);

--
-- テーブルの制約 `music`
--
ALTER TABLE `music`
  ADD CONSTRAINT `fk_music_type` FOREIGN KEY (`category_id`) REFERENCES `music_category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
