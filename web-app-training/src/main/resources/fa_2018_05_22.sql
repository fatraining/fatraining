-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018 年 5 朁E22 日 08:47
-- サーバのバージョン： 10.1.32-MariaDB
-- PHP Version: 7.2.5

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
(1, 'スパイダーマン3', 1, 2, 2007, 156, 'アメイジング・ホームカミングより好き', 0, '2017-11-08 00:00:00', '2017-11-08 00:00:00'),
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
