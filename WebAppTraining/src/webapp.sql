-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017 年 7 朁E06 日 07:55
-- サーバのバージョン： 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webapp`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `geinins`
--

CREATE TABLE `geinins` (
  `id` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `work` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `geinins`
--

INSERT INTO `geinins` (`id`, `image`, `name`, `work`) VALUES
(1, '01.jpg', 'さらば青春の光', '「ROCK」「ジャックと豆の木」'),
(2, '02.jpg', '相席スタート', '「ちょうどいいブス」「ジェームスとマサコ」'),
(8, '08.jpg', '囲碁将棋', '「銭湯のタオル」'),
(12, '12.jpg', 'インポッシブル', '「無敵マン」'),
(20, '20.jpg', 'からし蓮根', '「デート」'),
(21, '21.jpg', '学天即', '「旅行」'),
(25, '25.jpg', '空気階段', '「証拠」'),
(26, '26.jpg', 'クロスバー直撃', '「取り調べ」'),
(33, '33.jpg', 'さや香', '「金魚」'),
(37, '37.jpg', 'ジェラードン', '「握手会」'),
(41, '41.jpg', 'スーパーマラドーナ', '「ミナミの帝王」'),
(42, '42.jpg', 'ダイアン', '「銀行の税関」「ドライブスルー」'),
(43, '43.jpg', '天竺鼠', '「寿司」'),
(44, '44.jpg', 'Dr.ハインリッヒ', '「島の後輩」'),
(45, '45.jpg', 'ななまがり', '「バッティングセンター」「清水圭の息子」'),
(46, '46.jpg', 'ペコリーノ', '「コンテンポラリー・エロ」'),
(47, '47.jpg', 'マヂカルラブリー', '「ベランダ」'),
(48, '48.jpg', '魔人無骨', '「焼きそばの屋台」'),
(49, '49.jpg', 'ZAZY', '「絹江おばあちゃん」「中華屋さん」'),
(50, '50.jpg', '真空ジェシカ', '「論理クイズ」「コンビニ」'),
(51, '51.jpg', 'じぐざぐ', NULL),
(52, '52.jpg', '車海老のダンス', NULL),
(53, '53.jpg', 'サンシャイン池崎', '「イタコ」「記憶喪失」'),
(54, '54.jpg', 'Aマッソ', '「思い出」「棒なんやねん」'),
(55, '55.jpg', 'バッドナイス', NULL),
(56, '56.jpg', '四千頭身', '「大陸を発見」'),
(57, '57.jpg', 'にゃんこスター', '「リズム縄跳びの発表会」'),
(60, '60.jpg', 'モグライダー', '「トンカツ」「落語」'),
(61, '61.jpg', 'カナメストーン', '「復讐」'),
(62, '62.jpg', 'パーパー', '「お金貸して」「幼馴染のレストラン」'),
(63, '63.jpg', 'ガクヅケ', '「団子買いたい」「デビルマン」'),
(64, '64.jpg', 'かが屋', '「大富豪」「くら寿司」'),
(70, '70.jpg', 'アイデンティティ', '「野沢雅子がLUSHの店員」'),
(71, '71.jpg', '宮下草薙', '「先輩にハワイに連れてってもらう」'),
(72, '72.jpg', 'さすらいラビー', '「アメリカのアニメ」'),
(73, '73.jpg', 'サツマカワRPG', '「ショートコント」「FLASH」'),
(80, '80.jpg', 'ハリウッドザコシショウ', '「誇張モノマネ」'),
(81, '81.jpg', '錦鯉', '「ニュース」'),
(82, '82.jpg', 'ウメ', '「紙コント　悪モノ」'),
(84, '84.png', 'せつこ', '「二の腕パンパンおじさん」'),
(85, '85.jpg', 'ローズヒップファニーファニー', '「お寿司屋さん」'),
(86, '86.jpg', 'ひみつスナイパー健', NULL),
(87, '87.jpg', '村民代表南川', '「インリン・オブ・ジョイトイ」'),
(88, '88.jpg', 'ママタルト', NULL),
(89, '89.jpg', '虹の黄昏', '「和田アキ子」'),
(90, '90.jpg', '田中上野', '「犬も歩けば棒に当たる」'),
(91, '91.jpg', '東京ホテイソン', '「動物園の飼育員」「水族館」'),
(92, '92.jpg', 'フランスピアノ', '「喫茶店」「電車」'),
(95, '95.jpg', 'バスターキートン', '「ラーメン屋」'),
(96, '96.jpg', 'マリオネットブラザーズ', '「野球漫画」'),
(97, '97.jpg', 'ぺこぱ', NULL),
(100, '100.jpg', 'Mr.ドーナツ伝説 咳暁夫', NULL),
(101, '101.jpg', 'シャララ', '「算数」'),
(102, '102.jpg', 'シンクロニシティ', '「面接」'),
(103, '103.jpg', '街裏ぴんく', '「ホイップクリーム」'),
(107, '99.jpg', 'ヤーレンズ', '「病院」');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `geinins`
--
ALTER TABLE `geinins`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `geinins`
--
ALTER TABLE `geinins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


--
-- テーブルの構造 `aquarium`
--

CREATE TABLE `aquarium` (
  `id` int(11) NOT NULL,
  `aquariumAreaId` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `hours` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `aquarium`
--

INSERT INTO `aquarium` (`id`, `aquariumAreaId`, `name`, `price`, `hours`, `comment`, `area`) VALUES
(1, 1, '横浜・八景島シーパラダイス', 3000, '9：00～20：00(季節により変動)', 'アトラクションも楽しめる', NULL),
(2, 1, 'ヨコハマおもしろ水族館', 1400, '11：00〜20：00(※平日)\r\n', 'アルビノのオオグソクムシがいる', NULL),
(3, 2, 'サンシャイン水族館', 1600, '10：00〜18：00', '空飛ぶアシカが見られる', NULL),
(4, 3, '鴨川シーワールド', 2800, '9：00〜16：30(※平日)\r\n', '人工の砂浜「ウミガメの浜」でウミガメが産卵できるようになっている', NULL),
(23, 1, '魚人島', 1400, '00：00～24：00', 'ぎょじんだらけ', NULL),
(27, 6, 'グンマー帝国水族館', 1000, '10：00～21：00', 'ぐんまのやぼう', NULL),
(28, 4, 'さいたま水族館', 300, '9：30～17：00', 'さいたま市は、3画目が離れた「さ」を許さない。', NULL),
(29, 7, 'アクアワールド茨城県大洗水族館', 1800, '9：00～17：00', 'いばらぎ、じゃなくて、いばらき', NULL),
(30, 1, 'あ', 500, 'あ', 'あ', NULL),
(1, 1, '横浜・八景島シーパラダイス', 3000, '9：00～20：00(季節により変動)', 'アトラクションも楽しめる', NULL),
(2, 1, 'ヨコハマおもしろ水族館', 1400, '11：00〜20：00(※平日)\r\n', 'アルビノのオオグソクムシがいる', NULL),
(3, 2, 'サンシャイン水族館', 1600, '10：00〜18：00', '空飛ぶアシカが見られる', NULL),
(4, 3, '鴨川シーワールド', 2800, '9：00〜16：30(※平日)\r\n', '人工の砂浜「ウミガメの浜」でウミガメが産卵できるようになっている', NULL),
(23, 1, '魚人島', 1400, '00：00～24：00', 'ぎょじんだらけ', NULL),
(27, 6, 'グンマー帝国水族館', 1000, '10：00～21：00', 'ぐんまのやぼう', NULL),
(28, 4, 'さいたま水族館', 300, '9：30～17：00', 'さいたま市は、3画目が離れた「さ」を許さない。', NULL),
(29, 7, 'アクアワールド茨城県大洗水族館', 1800, '9：00～17：00', 'いばらぎ、じゃなくて、いばらき', NULL),
(30, 1, 'あ', 500, 'あ', 'あ', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `aquariumarea`
--

CREATE TABLE `aquariumarea` (
  `id` int(11) NOT NULL,
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `aquariumarea`
--

INSERT INTO `aquariumarea` (`id`, `area`) VALUES
(1, '神奈川県'),
(2, '東京都'),
(3, '千葉県'),
(4, '埼玉県'),
(5, '栃木県'),
(6, '群馬県'),
(7, '茨城県');

-- --------------------------------------------------------

--
-- テーブルの構造 `area`
--

CREATE TABLE `area` (
  `id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `area`
--

INSERT INTO `area` (`id`, `name`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '新宿', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(2, '新橋', '2015-12-05 08:20:03', 'struts2', '2015-12-05 08:20:03', 'struts2', 0),
(3, '秋葉原', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0),
(4, '上野', '2015-12-05 08:22:03', 'struts2', '2015-12-05 08:22:03', 'struts2', 0),
(5, '渋谷', '2016-05-09 00:00:00', 'struts2', '2016-05-09 00:00:00', 'struts2', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `baseballplayer`
--

CREATE TABLE `baseballplayer` (
  `ID` int(11) NOT NULL,
  `teamID` int(11) NOT NULL,
  `baseballplayer` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `target` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(20) CHARACTER SET ujis COLLATE ujis_bin DEFAULT NULL,
  `note` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `team` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `baseballplayer`
--

INSERT INTO `baseballplayer` (`ID`, `teamID`, `baseballplayer`, `comment`, `target`, `date`, `note`, `team`) VALUES
(1, 5, '新井貴浩', 'もちろん自分自身もうれしかったですけど、今日ここにたくさん詰めかけていただいたファンの皆さんの喜んでいる姿を見て、それが嬉しかったです。', NULL, '2016/04/26', '（2000安打となるヒットを打って）二塁ベースに立った時の心境は？\r\n', NULL),
(2, 9, '金村曉', '絶対に許さない。外国人の監督だから個人の記録は関係ないのでしょう。顔も見たくない。', 'ヒルマン監督', '2006/09/24', '2桁勝利がかかったシーズン最終登板、3点リードの5回裏2死満塁で交代を命じられ勝ち投手の権利が消滅したことについて。', NULL),
(4, 4, '佐伯貴弘', 'もらった祝儀袋の中身が図書券だった感じ。', NULL, '2005', '全試合で4番を打ち、打率.272/19本塁打/88打点を記録しながらも、契約更改にて1億3000万円の現状維持提示を受けて。', NULL),
(5, 3, '井端弘和', 'ショックで震えることってあるんですね。金額を見た瞬間、足がガタガタして10分間くらいは無言でした。', NULL, '2005', '契約更改にて、3500万円アップの年俸1億7500万円を提示され保留。', NULL),
(6, 3, '藤井淳志', 'アイドルじゃないんで。イメージはどうでもいいです。', NULL, '2009', '契約条件を保留することによるイメージ悪化について。', NULL),
(8, 13, '中村紀洋', '中村紀洋というブランドを考えて、近鉄で終わっていいのか。', NULL, '2002', 'FA権を取得した際に。', NULL),
(10, 1, '長嶋茂雄', '長嶋茂雄であり続けることは、結構苦労するんですよ。', NULL, NULL, NULL, NULL),
(11, 2, '江本孟紀', 'ベンチがアホやから野球がでけへん。', NULL, '1981/08/26', '翌日、発言の責任を取って現役引退を表明。', NULL),
(23, 3, 'あああああああ', 'ああああ\r\n\r\nふにゃああああああああああ', '', '', '', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `baseballteam`
--

CREATE TABLE `baseballteam` (
  `ID` int(11) NOT NULL,
  `team` varchar(100) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `baseballteam`
--

INSERT INTO `baseballteam` (`ID`, `team`) VALUES
(1, '巨人'),
(2, '阪神'),
(3, '中日'),
(4, '横浜'),
(5, '広島'),
(6, 'ヤクルト'),
(7, 'オリックス'),
(8, 'ソフトバンク'),
(9, '日本ハム'),
(10, 'ロッテ'),
(11, '西武'),
(12, '楽天'),
(13, 'その他');

-- --------------------------------------------------------

--
-- テーブルの構造 `beerbrands`
--

CREATE TABLE `beerbrands` (
  `ID` int(11) NOT NULL,
  `beerbrands` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `categories` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `countryID` int(11) NOT NULL,
  `country` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `beerbrands`
--

INSERT INTO `beerbrands` (`ID`, `beerbrands`, `categories`, `comment`, `countryID`, `country`) VALUES
(1, 'Guiness', 'Ale', '', 1, NULL),
(10, 'Mahou', 'Pilsner', '', 11, NULL),
(11, 'Alhambra', 'Pilsner', '', 11, NULL),
(12, 'Pils', 'Pilsner', '', 4, NULL),
(13, 'Helles', 'Lager hell', '', 4, NULL),
(14, 'ebis', 'Ale', 'aaa', 9, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `biketeam`
--

CREATE TABLE `biketeam` (
  `ID` int(10) NOT NULL,
  `TeamName` varchar(300) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `biketeam`
--

INSERT INTO `biketeam` (`ID`, `TeamName`) VALUES
(1, 'Aprilia Racing Team Gresini'),
(2, 'Aspar Team MotoGP'),
(3, 'Anvintia Racing'),
(4, 'Ducati Team'),
(5, 'Estrella Galicia 0,0 Marc VDS'),
(6, 'LCR Honda'),
(7, 'Monster Yamaha Tech3'),
(8, 'Movistar Yamaha MotoGP'),
(9, 'OCTO Pramac Yakhnich'),
(10, 'Repsol Honda Team'),
(11, 'Team SUZUKI ECSTAR'),
(12, 'Retirement'),
(13, 'Other');

-- --------------------------------------------------------

--
-- テーブルの構造 `birthplace`
--

CREATE TABLE `birthplace` (
  `ID` int(11) NOT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `birthplace`
--

INSERT INTO `birthplace` (`ID`, `country`) VALUES
(1, 'Republic of Ireland'),
(2, 'London'),
(3, 'France'),
(4, 'Germany'),
(5, 'Italy'),
(6, 'Belgium'),
(7, 'United States'),
(8, 'Brazil'),
(9, '日本'),
(10, 'China'),
(11, 'Spain'),
(12, 'Mexico'),
(13, 'Thailand'),
(14, 'Korea'),
(15, 'Russia ');

-- --------------------------------------------------------

--
-- テーブルの構造 `catarea`
--

CREATE TABLE `catarea` (
  `ID` int(11) NOT NULL,
  `prefecture` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `catarea`
--

INSERT INTO `catarea` (`ID`, `prefecture`) VALUES
(1, '東京'),
(2, '神奈川'),
(3, '千葉'),
(4, '埼玉');

-- --------------------------------------------------------

--
-- テーブルの構造 `catcafe`
--

CREATE TABLE `catcafe` (
  `ID` int(11) NOT NULL,
  `catcafename` varchar(100) COLLATE utf8_bin NOT NULL,
  `prefectureID` int(11) NOT NULL,
  `station` varchar(100) COLLATE utf8_bin NOT NULL,
  `hours` varchar(100) COLLATE utf8_bin NOT NULL,
  `closed` varchar(100) COLLATE utf8_bin NOT NULL,
  `comment` varchar(100) COLLATE utf8_bin NOT NULL,
  `prefecture` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `catcafe`
--

INSERT INTO `catcafe` (`ID`, `catcafename`, `prefectureID`, `station`, `hours`, `closed`, `comment`, `prefecture`) VALUES
(1, '猫まるカフェ 上野店', 1, '上野', '11:00～22:00', 'なし', '', NULL),
(2, '猫カフェ MoCHA 渋谷店', 1, '渋谷', '10:00～22:00', 'なし', '', NULL),
(3, 'Nyafe Melange', 1, '恵比寿', '12:00～20:00', 'なし', '', NULL),
(22, '猫カフェ きゃりこ 新宿店', 1, '新宿', '10:00～22:00', 'なし', '', NULL),
(23, 'Cat Cafe ねころび', 1, '池袋', '11:00～23:00', 'なし', '', NULL),
(24, 'ねこカフェクラブ', 1, '自由が丘', '11:00～19:00', 'なし', '', NULL),
(26, '猫カフェ れおん', 2, '石川町', '11:00～22:00', 'なし', '', NULL),
(28, '猫カフェ にゃんくる 鎌倉店', 2, '鎌倉', '11:00～20:00', 'なし', 'もふってきたよ', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `catfrom`
--

CREATE TABLE `catfrom` (
  `id` int(11) NOT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `catfrom`
--

INSERT INTO `catfrom` (`id`, `country`) VALUES
(1, 'アメリカ'),
(2, 'イギリス'),
(3, '日本'),
(4, 'ノルウェー'),
(5, 'ロシア');

-- --------------------------------------------------------

--
-- テーブルの構造 `catinfo`
--

CREATE TABLE `catinfo` (
  `id` int(11) NOT NULL,
  `fromid` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `catinfo`
--

INSERT INTO `catinfo` (`id`, `fromid`, `name`, `comment`, `country`) VALUES
(1, 1, 'マンチカン', '足が短い・穏やかで人懐っこい', NULL),
(2, 2, 'スコティッシュフォールド', '耳が折れている・穏やかで人懐っこい', NULL),
(3, 1, 'ラグドール', '毛がふんわりとしていて瞳がブルー・大らかで人懐っこい', NULL),
(4, 1, 'メインクーン', 'ワイルドなルックス・温和で優しい', NULL),
(5, 5, 'ロシアンブルー', '毛がグレー・とても大人しい', NULL),
(6, 1, 'エキゾチックショートヘア', '大きな目につぶれたような鼻・従順かつ好奇心が強い', NULL),
(7, 1, 'アメリカンショートヘア', '毛の模様が美しい・好奇心が強い', NULL),
(8, 4, 'ノルウェージャンフォレストキャット', '毛並みが豪華・穏やかで我慢強い', NULL),
(9, 2, 'ソマリ', '毛並みが美しい・活発で人懐っこい', NULL),
(10, 1, 'ベンガル', '毛の模様が豹のよう・大人しく温厚', NULL),
(11, 3, '日本猫', '毛と尻尾が短い・警戒心が強い', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `chocolate`
--

CREATE TABLE `chocolate` (
  `id` int(11) NOT NULL,
  `countryid` int(11) DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `shopname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chef` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- テーブルの構造 `copy`
--

CREATE TABLE `copy` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `image_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `appearance` int(11) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `delete_flag` tinyint(1) DEFAULT NULL,
  `exclusive_flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

--
-- テーブルのデータのダンプ `copy`
--

INSERT INTO `copy` (`id`, `name`, `image_path`, `appearance`, `title_id`, `create_date`, `create_user`, `update_date`, `update_user`, `delete_flag`, `exclusive_flag`) VALUES
(1, 'ファイア', 'fire.jpg_20170420152411.jpeg', 8, 1, '2017-04-17 00:00:00', 'struts2', '2017-04-20 15:24:11', 'ログインしろよ豚野郎！', 0, 0),
(2, 'ボム', 'bomb.jpg_20170420115757.jpeg', 9, 2, '2017-04-17 00:00:00', 'struts2', '2017-04-20 11:57:57', 'struts2', 0, 0),
(3, 'ビーム', 'Nodata.jpg', 8, 1, '2017-04-20 17:00:05', 'struts2', '2017-04-20 17:00:05', 'struts2', 0, 0),
(4, 'カッター', 'Nodata.jpg', 10, 1, '2017-04-20 17:00:48', 'struts2', '2017-04-20 17:00:48', 'struts2', 0, 0),
(5, 'レーザー', 'Nodata.jpg', 3, 1, '2017-04-20 17:01:08', 'struts2', '2017-04-20 17:01:08', 'struts2', 0, 0),
(6, 'バーニング', 'Nodata.jpg', 6, 1, '2017-04-20 17:01:48', 'struts2', '2017-04-20 17:01:48', 'struts2', 0, 0),
(7, 'アイス', 'Nodata.jpg', 10, 1, '2017-04-20 17:02:34', 'struts2', '2017-04-20 17:02:34', 'struts2', 0, 0),
(8, 'フリーズ', 'Nodata.jpg', 2, 1, '2017-04-20 17:03:11', 'struts2', '2017-04-20 17:03:11', 'struts2', 0, 0),
(9, 'スパーク', 'Nodata.jpg', 10, 1, '2017-04-20 17:04:06', 'struts2', '2017-04-20 17:04:06', 'struts2', 0, 0),
(10, 'ニードル', 'Nodata.jpg', 8, 1, '2017-04-20 17:04:49', 'struts2', '2017-04-20 17:04:49', 'struts2', 0, 0),
(11, 'ストーン', 'Nodata.jpg', 10, 1, '2017-04-20 17:05:44', 'struts2', '2017-04-20 17:05:44', 'struts2', 0, 0),
(12, 'ホイール', 'Nodata.jpg', 7, 1, '2017-04-20 17:06:18', 'struts2', '2017-04-20 17:06:18', 'struts2', 0, 0),
(13, 'ハイジャンプ', 'Nodata.jpg', 3, 1, '0000-00-00 00:00:00', 'struts2', '2017-04-20 17:06:45', 'struts2', 0, 0),
(14, 'トルネイド', 'Nodata.jpg', 5, 1, '2017-04-20 17:07:31', 'struts2', '2017-04-20 17:07:31', 'struts2', 0, 0),
(15, 'ボール', 'Nodata.jpg', 1, 1, '2017-04-20 17:08:05', 'struts2', '2017-04-20 17:08:05', 'struts2', 0, 0),
(16, 'バックドロップ', 'Nodata.jpg', 1, 1, '2017-04-20 17:08:26', 'struts2', '2017-04-20 17:08:26', 'struts2', 0, 0),
(17, 'スロウ', 'Nodata.jpg', 3, 1, '2017-04-20 17:09:00', 'struts2', '2017-04-20 17:09:00', 'struts2', 0, 0),
(18, 'ソード', 'Nodata.jpg', 7, 1, '2017-04-20 17:09:38', 'struts2', '2017-04-20 17:09:38', 'struts2', 0, 0),
(19, 'パラソル', 'Nodata.jpg', 9, 1, '2017-04-20 17:10:11', 'struts2', '2017-04-20 17:17:21', 'struts2', 0, 0),
(20, 'ハンマー', 'Nodata.jpg', 7, 1, '2017-04-20 17:10:46', 'struts2', '2017-04-20 17:10:46', 'struts2', 0, 0),
(21, 'ユーフォー', 'Nodata.jpg', 4, 1, '2017-04-20 17:11:59', 'struts2', '2017-04-20 17:11:59', 'struts2', 0, 0),
(22, 'マイク', 'Nodata.jpg', 5, 1, '2017-04-20 17:12:31', 'struts2', '2017-04-20 17:12:31', 'struts2', 0, 0),
(23, 'ライト', 'Nodata.jpg', 1, 1, '2017-04-20 17:12:56', 'struts2', '2017-04-20 17:12:56', 'struts2', 0, 0),
(24, 'スリープ', 'Nodata.jpg', 6, 1, '2017-04-20 17:13:39', 'struts2', '2017-04-20 17:13:39', 'struts2', 0, 0),
(25, 'クラッシュ', 'Nodata.jpg', 6, 1, '2017-04-20 17:14:24', 'struts2', '2017-04-20 17:14:24', 'struts2', 0, 0),
(26, 'ニンジャ', 'Nodata.jpg', 5, 2, '2017-04-20 17:15:17', 'struts2', '2017-04-20 17:15:17', 'struts2', 0, 0),
(27, 'ウィング', 'Nodata.jpg', 3, 2, '2017-04-20 17:15:54', 'struts2', '2017-04-20 17:15:54', 'struts2', 0, 0),
(28, 'ヨーヨー', 'Nodata.jpg', 1, 2, '2017-04-20 17:17:11', 'struts2', '2017-04-20 17:17:11', 'struts2', 0, 0),
(29, 'プラズマ', 'Nodata.jpg', 2, 2, '2017-04-20 17:17:46', 'struts2', '2017-04-20 17:17:46', 'struts2', 0, 0),
(30, 'ミラー', 'Nodata.jpg', 2, 2, '2017-04-20 17:18:10', 'struts2', '2017-04-20 17:18:10', 'struts2', 0, 0),
(31, 'ファイター', 'Nodata.jpg', 6, 2, '2017-04-20 17:18:50', 'struts2', '2017-04-20 17:18:50', 'struts2', 0, 0),
(32, 'スープレックス', 'Nodata.jpg', 1, 2, '2017-04-20 17:19:18', 'struts2', '2017-04-20 17:19:18', 'struts2', 0, 0),
(33, 'ジェット', 'Nodata.jpg', 2, 2, '2017-04-20 17:19:28', 'struts2', '2017-04-20 17:19:28', 'struts2', 0, 0),
(34, 'コピー', 'Nodata.jpg', 1, 2, '2017-04-20 17:19:42', 'struts2', '2017-04-20 17:19:42', 'struts2', 0, 0),
(35, 'コック', 'Nodata.jpg', 2, 2, '2017-04-20 17:20:10', 'struts2', '2017-04-20 17:20:10', 'struts2', 0, 0),
(36, 'ペイント', 'Nodata.jpg', 1, 2, '2017-04-20 17:20:32', 'struts2', '2017-04-20 17:20:32', 'struts2', 0, 0),
(37, 'クリーン', 'Nodata.jpg', 1, 4, '2017-04-20 17:20:51', 'struts2', '2017-04-20 17:20:51', 'struts2', 0, 0),
(38, 'エンジェル', 'Nodata.jpg', 2, 6, '2017-04-20 17:21:19', 'struts2', '2017-04-20 17:21:19', 'struts2', 0, 0),
(39, 'ミサイル', 'Nodata.jpg', 2, 6, '2017-04-20 17:21:38', 'struts2', '2017-04-20 17:21:38', 'struts2', 0, 0),
(40, 'スマブラ', 'Nodata.jpg', 1, 6, '2017-04-20 17:21:53', 'struts2', '2017-04-20 17:21:53', 'struts2', 0, 0),
(41, 'マジック', 'Nodata.jpg', 2, 6, '2017-04-20 17:22:11', 'struts2', '2017-04-20 17:22:11', 'struts2', 0, 0),
(42, 'ミニマム', 'Nodata.jpg', 1, 6, '2017-04-20 17:22:38', 'struts2', '2017-04-20 17:22:38', 'struts2', 0, 0),
(43, 'バルーン', 'Nodata.jpg', 1, 7, '2017-04-20 17:22:48', 'struts2', '2017-04-20 17:22:48', 'struts2', 0, 0),
(44, 'アニマル', 'Nodata.jpg', 1, 8, '2017-04-20 17:23:20', 'struts2', '2017-04-20 17:23:20', 'struts2', 0, 0),
(45, 'バブル', 'Nodata.jpg', 1, 8, '2017-04-20 17:23:31', 'struts2', '2017-04-20 17:23:31', 'struts2', 0, 0),
(46, 'メタル', 'Nodata.jpg', 1, 8, '2017-04-20 17:23:42', 'struts2', '2017-04-20 17:23:42', 'struts2', 0, 0),
(47, 'ゴースト', 'Nodata.jpg', 1, 8, '2017-04-20 17:24:02', 'struts2', '2017-04-20 17:24:02', 'struts2', 0, 0),
(48, 'リーフ', 'Nodata.jpg', 3, 9, '2017-04-20 17:24:21', 'struts2', '2017-04-20 17:24:21', 'struts2', 0, 0),
(49, 'ウィップ', 'Nodata.jpg', 3, 9, '2017-04-20 17:24:40', 'struts2', '2017-04-20 17:24:40', 'struts2', 0, 0),
(50, 'ウォーター', 'Nodata.jpg', 1, 9, '2017-04-20 17:24:59', 'struts2', '2017-04-20 17:24:59', 'struts2', 0, 0),
(51, 'スピア', 'Nodata.jpg', 2, 9, '2017-04-20 17:25:20', 'struts2', '2017-04-20 17:25:20', 'struts2', 0, 0),
(52, 'ビートル', 'Nodata.jpg', 1, 10, '2017-04-20 17:25:41', 'struts2', '2017-04-20 17:25:41', 'struts2', 0, 0),
(53, 'ベル', 'Nodata.jpg', 1, 10, '2017-04-20 17:25:58', 'struts2', '2017-04-21 10:34:43', 'struts2', 0, 0),
(54, 'サーカス', 'Nodata.jpg', 2, 10, '2017-04-20 17:26:18', 'struts2', '2017-04-20 17:26:18', 'struts2', 0, 0),
(55, 'スナイパー', 'Nodata.jpg', 2, 10, '2017-04-20 17:26:37', 'struts2', '2017-04-20 17:26:37', 'struts2', 0, 0),
(56, 'ポイズン', 'Nodata.jpg', 1, 11, '2017-04-20 17:26:53', 'struts2', '2017-04-20 17:26:53', 'struts2', 0, 0),
(57, 'ドクター', 'Nodata.jpg', 1, 11, '2017-04-20 17:27:01', 'struts2', '2017-04-20 17:27:01', 'struts2', 0, 0),
(58, 'エスパー', 'Nodata.jpg', 1, 11, '2017-04-20 17:27:12', 'struts2', '2017-04-20 17:27:12', 'struts2', 0, 0),
(59, 'スターロッド', 'Nodata.jpg', 1, 1, '2017-04-21 09:59:04', 'struts2', '2017-04-21 10:17:16', 'struts2', 0, 0),
(60, 'マスター', 'Nodata.jpg', 1, 6, '2017-04-21 09:59:51', 'ログインしろよ豚野郎！', '2017-04-21 09:59:51', 'ログインしろよ豚野郎！', 0, 0),
(61, '虹の剣', 'Nodata.jpg', 1, 3, '2017-04-21 10:16:33', 'struts2', '2017-04-21 10:16:33', 'struts2', 0, 0),
(62, 'ラブラブステッキ', 'Nodata.jpg', 1, 4, '2017-04-21 10:16:49', 'struts2', '2017-04-21 10:16:49', 'struts2', 0, 0),
(63, 'トリプルスター', 'Nodata.jpg', 1, 8, '2017-04-21 10:17:04', 'struts2', '2017-04-21 10:17:04', 'struts2', 0, 0),
(64, 'ああああ', 'Nodata.jpg', 1, 1, '2017-04-21 12:25:32', 'struts2', '2017-04-21 12:25:32', 'struts2', 1, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `country`
--

CREATE TABLE `country` (
  `ID` int(10) NOT NULL,
  `countryName` varchar(20) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `country`
--

INSERT INTO `country` (`ID`, `countryName`) VALUES
(1, '日本'),
(2, 'ドイツ'),
(3, 'アメリカ');

-- --------------------------------------------------------

--
-- テーブルの構造 `drama`
--

CREATE TABLE `drama` (
  `id` int(11) NOT NULL,
  `dramaGenreId` int(11) DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `cast` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `tvStation` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `genre` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `drama`
--

INSERT INTO `drama` (`id`, `dramaGenreId`, `name`, `cast`, `tvStation`, `comment`, `genre`) VALUES
(1, 2, '冬のソナタ', 'ペ・ヨンジュン', 'KBS', '日本での韓流ブームの火付け役!', NULL),
(2, 1, '宮～love in palace～', 'ユン・ウネ', 'MBC', 'ラブコメの女王、ウネちゃん主演！現代版王宮ラブスーリー', NULL),
(3, 3, 'IRIS-アイリス-', 'イ・ビョンホン', 'KBS', '我らがBIGBANGのTOPさんも出演！', NULL),
(4, 1, '華麗なる遺産', 'イ・スンギ', 'SBS', '韓国ドラマのあるある詰まってます', NULL),
(5, 4, '天国の階段', 'チェ・ジウ', 'SBS', 'ド定番記憶喪失と血のつながらない兄', NULL),
(6, 7, 'トンイ', 'ハン・ヒョジュ', 'MBC', '歴史なんてわからなくても韓国ドラマは楽しめる', NULL),
(7, 5, 'ミス・リプリー', 'パク・ユチョン', 'MBC', 'シリアスな演技のユチョンも素敵', NULL),
(8, 6, '製パン王 キム・タック', 'ユン・シユン', 'KBS', '瞬間最高視聴率58％、どんだけテレビ見てるん韓国民', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `dramagenre`
--

CREATE TABLE `dramagenre` (
  `id` int(11) DEFAULT NULL,
  `genre` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `dramagenre`
--

INSERT INTO `dramagenre` (`id`, `genre`) VALUES
(1, 'ラブコメ'),
(2, '正統派ラブストーリー'),
(3, 'サスペンス'),
(4, 'ドロドロ'),
(5, '復讐劇'),
(6, 'ヒューマンドラマ'),
(7, '時代劇');

-- --------------------------------------------------------

--
-- テーブルの構造 `eventarea`
--

CREATE TABLE `eventarea` (
  `ID` int(11) NOT NULL,
  `area` varchar(5) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `eventarea`
--

INSERT INTO `eventarea` (`ID`, `area`) VALUES
(1, '東京'),
(2, '神奈川'),
(3, '埼玉'),
(4, '千葉');

-- --------------------------------------------------------

--
-- テーブルの構造 `eventstage`
--

CREATE TABLE `eventstage` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `station` varchar(10) DEFAULT NULL,
  `record` varchar(5) DEFAULT NULL,
  `comment` varchar(40) DEFAULT NULL,
  `areaID` int(11) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `eventstage`
--

INSERT INTO `eventstage` (`ID`, `name`, `station`, `record`, `comment`, `areaID`, `area`) VALUES
(1, 'ららぽーと豊洲', '豊洲', 'HMV', '安定の豊洲！ステージ前が階段になっていて見やすい。観客が多くても比較的見れる。', 1, NULL),
(2, 'ららぽーと横浜', '鴨居', 'HMV', 'いわゆる横浜エリアではないので注意。ステージがへこんでいるので微妙に見づらい。', 2, NULL),
(3, 'ららぽーと新三郷', '新三郷', 'etc', 'IKEAとコストコもある一大商業ゾーン。ステージは低めだが人が少なければ快適。', 3, NULL),
(4, 'ららぽーと柏の葉', '柏の葉キャンパス', 'HMV', '広場が広く全て階段なのでライブは絶対に見える。おすすめ会場！', 4, NULL),
(5, 'ららぽーと立川立飛', '立飛', 'TW', '広場は広いがステージは低くて狭い。基本人が少なくて見やすいかも。', 1, NULL),
(6, 'サンシャイン噴水広場', '池袋', 'SN', 'イベント広場の代表！室内で、上からでも見えて快適。色々なイベントが開催される。', 1, NULL),
(7, 'ラゾーナ川崎', '川崎', 'HMV', '広場面積がおそらく最大！とにかく広い！ステージも低くないので遠くからでも見える。', 2, NULL),
(8, 'ダイバーシティ東京', '東京テレポート', 'TW', 'ガンダム立像でお馴染み。高いステージか階段を使うので遠くからでも確実に見える。', 1, NULL),
(9, '大宮ステラタウン', '土呂', 'etc', '徒歩12分かシャトルバスなので交通は良くない。ステージは低めだが意外と見やすい。', 3, NULL),
(10, '昭島モリタウン', '昭島', 'SN', 'ステージが高いのでほぼ確実に見える。屋根もあるので雨天でも安心。おすすめ会場！', 1, NULL),
(11, 'ヴィーナスフォート', '青海', 'TW', '教会広場の名の通り厳かで綺麗。室内なので人混みになるがステージが高いので安心。', 1, NULL),
(15, 'イクスピアリ', '舞浜', 'SN', '夢の国はもうすぐそこ！Dストアの前にあるステージはまるでパーク内のよう。', 4, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `guraburu_character_info`
--

CREATE TABLE `guraburu_character_info` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SEX` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ATTRIBUTE` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RACEID` int(11) DEFAULT NULL,
  `COMMENT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `REGISTERDDATA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `RACENAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATAURL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `guraburu_character_info`
--

INSERT INTO `guraburu_character_info` (`ID`, `NAME`, `SEX`, `ATTRIBUTE`, `RACEID`, `COMMENT`, `REGISTERDDATA`, `RACENAME`, `DATAURL`) VALUES
(1, 'アンチラ', '女性', '風', 2, '例の返金騒動事件の元凶', '2017-08-22 06:45:33', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040071000_01_full.png'),
(2, 'フィーナ', '女性', '風', 1, '超カワ', '2017-08-22 03:15:07', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=ssr3040061000_01.png'),
(3, 'パーシヴァル', '男性', '火', 1, 'パー様', '2017-08-15 08:44:08', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040050000_01full.png'),
(4, 'コルワ', '女性', '風', 2, '全属性バッファー（元）', '2017-08-15 08:49:45', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040081000_01_full.png'),
(5, 'ゾーイ(水着ver)', '女性', '闇', 5, 'コンジャクション', '2017-08-16 03:10:32', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040092000_01_full.png'),
(6, 'ヴェイン', '男性', '水', 1, NULL, '2017-08-15 02:47:12', NULL, NULL),
(7, 'ロザミア', '女性', '光', 1, '仮面女子', '2017-08-22 03:41:53', NULL, ''),
(8, 'リルル', '女性', '水', 4, NULL, '2017-08-15 02:48:31', NULL, NULL),
(9, 'ラスティナ', '女性', '土', 3, NULL, '2017-08-15 02:49:15', NULL, NULL),
(10, 'バザラガ', '男性', '闇', 3, NULL, '2017-08-16 03:19:25', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040029000_02fulll.png'),
(11, 'セルエル', '男性', '光', 2, NULL, '2017-08-16 03:19:25', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040013000_01full.png'),
(12, 'ガウェイン', '男性', '風', 1, NULL, '2017-08-16 03:19:25', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040000000_02full.png'),
(13, 'ユーステス', '男性', '土', 2, NULL, '2017-08-16 03:19:25', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040069000_01_full.png'),
(14, 'ユエル', '女性', '火', 2, NULL, '2017-08-16 03:19:25', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040006000_03.png'),
(15, 'マキラ', '女性', '土', 4, '', '2017-08-22 08:17:26', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040107000_02_full.png'),
(16, 'オクトー', '男性', '土', 3, '', '2017-08-21 06:03:33', NULL, NULL),
(17, 'サラーサ', '女性', '土', 3, NULL, '2017-08-16 07:40:08', NULL, NULL),
(18, 'アニラ', '女性', '火', 3, 'saf', '2017-08-21 05:13:17', NULL, NULL),
(19, 'オイゲン', '男性', '土', 1, '', '2017-08-21 03:43:21', NULL, NULL),
(20, 'ロゼッタ', '女性', '風', 5, '', '2017-08-21 08:44:30', NULL, ''),
(22, 'アギエルバ', '男性', '火', 3, '', '2017-08-21 05:08:49', NULL, NULL),
(23, 'ジャンヌダルク（闇堕ち）', '女性', '闇', 1, '闇堕ち', '2017-08-21 06:34:37', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040080000_01_full.png'),
(34, 'ヴィーラ', '女性', '闇', 1, '', '2017-08-21 06:35:26', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040043000_03full.png'),
(35, 'オーキス', '女性', '闇', 5, '', '2017-08-21 06:55:58', NULL, 'http://gbf-wiki.com/index.php?plugin=attach&refer=img&openfile=3040111000_01_full.png');


-- --------------------------------------------------------

--
-- テーブルの構造 `guraburu_race`
--

CREATE TABLE `guraburu_race` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `guraburu_race`
--

INSERT INTO `guraburu_race` (`ID`, `NAME`) VALUES
(1, 'ヒューマン'),
(2, 'エルーン'),
(3, 'ドラフ'),
(4, 'ハーヴィン'),
(5, '不明'),
(6, '未入力');


-- --------------------------------------------------------

--
-- テーブルの構造 `groupname`
--

CREATE TABLE `groupname` (
  `GroupID` varchar(2) NOT NULL,
  `GroupName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=sjis;

--
-- テーブルのデータのダンプ `groupname`
--

INSERT INTO `groupname` (`GroupID`, `GroupName`) VALUES
('A', 'アンジュルム'),
('C', '℃-ute'),
('CF', 'つばきファクトリー'),
('CG', 'カントリー・ガールズ'),
('H', 'Hollo!Ploject'),
('HK', 'ハロプロ研修生'),
('J', 'Juice=Juice'),
('KF', 'こぶしファクトリー'),
('M', 'モーニング娘。’16');

-- --------------------------------------------------------

--
-- テーブルの構造 `guitarinfo`
--

CREATE TABLE `guitarinfo` (
  `id` int(11) NOT NULL,
  `guitarMakerId` int(11) NOT NULL,
  `typeName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) NOT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `guitarinfo`
--

INSERT INTO `guitarinfo` (`id`, `guitarMakerId`, `typeName`, `price`, `comment`, `name`) VALUES
(1, 1, 'Classic　Style-S', 241900, NULL, NULL),
(2, 1, 'Classic Style-T', 222700, NULL, NULL),
(3, 1, 'Classic Style-JM', 230900, NULL, NULL),
(4, 2, 'Reunion', 340000, NULL, NULL),
(5, 2, 'Ab''s24[6-strings]', 398000, NULL, NULL),
(6, 2, 'Ab''s24[6-strings]', 438000, NULL, NULL),
(7, 3, 'Arc-STD VS-100N', 490000, NULL, NULL),
(8, 3, 'Arc-Hollow', 510000, NULL, NULL),
(9, 3, 'DST Droptop Quilted Maple', 347000, NULL, NULL),
(10, 4, 'Masterfield MFA-FP', 285000, NULL, NULL),
(11, 4, 'Expert EEL-DE-7', 250000, NULL, NULL),
(12, 4, 'Expert EFL-FM', 275000, NULL, NULL),
(13, 5, 'MAROON CUSTOM 666 Limited Hight', 500000, NULL, NULL),
(14, 5, 'HISTA CUSTOM 666', 370000, NULL, NULL),
(15, 5, 'BORDER BC CUSTOM 666', 390000, NULL, NULL),
(16, 6, 'DS 496 HR SPL/AT NAT', 426800, NULL, NULL),
(17, 6, 'DS 499 M', 324000, NULL, NULL),
(18, 7, 'STV Classic Series', 320000, NULL, NULL),
(19, 7, 'STV-CS1', 399000, NULL, NULL),
(20, 8, 'MLS1-STD', 390000, NULL, NULL),
(21, 8, 'MJM2-WTW', 270000, NULL, NULL),
(22, 8, 'MST2-SP NJ', 265800, NULL, NULL),
(23, 9, 'HORIZON-CTM FR', 680000, NULL, NULL),
(24, 9, 'ANTELOPE-CTM', 735000, NULL, NULL),
(25, 9, 'AMOUS FR-CTM', 680000, NULL, NULL),
(26, 9, 'POTBELLY-TR', 520000, NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `guitarmaker`
--

CREATE TABLE `guitarmaker` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `guitarmaker`
--

INSERT INTO `guitarmaker` (`id`, `name`) VALUES
(1, 'sago'),
(2, 'Crews Maniac Sound'),
(3, 'T''s Guitars'),
(4, 'Fujigen'),
(5, 'dragonfly'),
(6, 'Sugi'),
(7, 'Vanzandt'),
(8, 'MOMOSE'),
(9, 'ESP');

-- --------------------------------------------------------

--
-- テーブルの構造 `iventcontents`
--

CREATE TABLE `iventcontents` (
  `ID` int(11) NOT NULL,
  `GroupID` varchar(2) DEFAULT NULL,
  `Category` varchar(20) DEFAULT NULL,
  `IventName` varchar(100) DEFAULT NULL,
  `Place` varchar(100) DEFAULT NULL,
  `Day` datetime DEFAULT NULL,
  `Comment` varchar(100) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=sjis;

--
-- テーブルのデータのダンプ `iventcontents`
--

INSERT INTO `iventcontents` (`ID`, `GroupID`, `Category`, `IventName`, `Place`, `Day`, `Comment`, `groupName`) VALUES
(8, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', 'さいたま市文化センター大ホール（埼玉）', '2016-04-23 13:00:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(9, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', 'さいたま市文化センター大ホール（埼玉）', '2016-04-23 16:30:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(10, 'A', '即売系', '21stシングル『次々続々／糸島Distance／恋ならとっくに始まってる』発売＆ミニライブ＆握手会', 'ヴィーナスフォート協会広場（東京）', '2016-04-27 17:30:00', '和田中西竹内勝田田村室田相川佐々木上國料', NULL),
(15, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', '結城市民文化センター アクロス (茨城)', '2016-05-15 15:00:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(16, 'M', 'コンサート', 'コンサートツアー春〜EMOTION IN MOTION〜', '結城市民文化センター アクロス (茨城)', '2016-05-15 18:30:00', '譜久村生田鈴木（香）飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(22, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', '富岡本店 店内イベントスペース（山形）', '2016-05-14 10:30:00', '尾形', NULL),
(23, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'エスパル郡山 1Fセンターコート（福島）', '2016-05-14 14:00:00', '尾形', NULL),
(26, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'アリオ川口 １Fセンターコート（埼玉)', '2016-05-14 19:30:00', '譜久村佐藤尾形野中', NULL),
(28, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'そごう横浜店 ２F 鐘の広場（神奈川）', '2016-05-14 18:30:00', '鈴木（香）飯窪小田牧野', NULL),
(29, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'タワーレコード グランツリー武蔵小杉 店内イベントスペース（神奈川）', '2016-05-14 16:00:00', '牧野', NULL),
(30, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'イオンモール新潟南 館内 イオンシネマ（新潟）', '2016-05-14 10:30:00', '飯窪', NULL),
(31, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', '金沢フォーラス 6F KUUGO スクエア（石川）', '2016-05-14 10:45:00', '野中', NULL),
(32, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'イオンモール高岡 1階セントラルコート（富山）', '2016-05-14 13:45:00', '野中', NULL),
(39, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'タワーレコード京都店（京都）', '2016-05-14 16:00:00', '工藤', NULL),
(40, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'ハロー！プロジェクトオフィシャルショップ大阪店（大阪）', '2016-05-14 10:00:00', '羽賀', NULL),
(43, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'HMV三宮VIVRE 店内イベントスペース（兵庫）', '2016-05-14 19:00:00', '生田石田工藤羽賀', NULL),
(44, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'アリオ倉敷 屋外イベントステージ（岡山）', '2016-05-14 14:30:00', '羽賀', NULL),
(46, 'M', '即売系', '『泡沫サタデーナイト!／The Vision／Tokyoという片隅』発売記念 握手会', 'ミュージックプラザインドウ ２Fイベントスペース（福岡）', '2016-05-14 10:15:00', '牧野', NULL),
(47, 'C', '個別系', '29thシングル 『何故 人は争うんだろう？/ Summer Wind/人生はSTEP！』 発売記念 個別握手会', 'ベルサール飯田橋駅前（東京）', '2016-05-15 10:30:00', '矢島中島鈴木（愛）岡井萩原', NULL),
(48, 'M', 'その他', '演劇女子部「続・11人いる！東の地平・西の永遠」', '京都劇場(京都)', '2016-06-11 15:00:00', '譜久村生田飯窪石田佐藤工藤小田尾形野中牧野羽賀', NULL),
(49, 'CF', 'その他', '演劇女子部「続・11人いる！東の地平・西の永遠」', '京都劇場(京都)', '2016-06-11 15:00:00', '山岸小片岸本浅倉', NULL),
(50, 'HK', 'その他', '演劇女子部「続・11人いる！東の地平・西の永遠」', '京都劇場(京都)', '2016-06-11 15:00:00', '橋本高瀬', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `maiwaifu`
--

CREATE TABLE `maiwaifu` (
  `id` int(11) NOT NULL,
  `maiwaifuAreaId` int(11) DEFAULT NULL,
  `image` varchar(300) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `genre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `comment` varchar(300) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `maiwaifu`
--

INSERT INTO `maiwaifu` (`id`, `maiwaifuAreaId`, `image`, `name`, `genre`, `age`, `comment`, `area`) VALUES
(1, 1, 'assets/images/girls/ramu.jpg', 'ラム', 'cute', 'unknown', '『うる星やつら』\r\nうる星（ラム星、アニメでは鬼星）から地球侵略のためにやってきた鬼型宇宙人の娘。 \r\n語尾に「だっちゃ」または「～っちゃ」を付けて話すのが特徴。 世代を超えて絶大な人気を誇っておりほかのキャラに浮ついていてもラムちゃんの姿を見ると「なんだかんだ言ってもやっぱりラムちゃんだわ～～～」となるヲタクも少なくはない。', NULL),
(2, 2, 'assets/images/girls/fujiko.jpg', '峰不二子', 'sexy', 'unknown', '『ルパン三世』\r\n身長167cm、バスト99.9、ウェスト55.5、ヒップ88.8センチのボイン悪女。 \r\nルパン同様、正体は不明で、ルパンからは「謎の女スパイ」とも評されている。\r\n金持ちの財産目当てに結婚や婚約したことは幾度となくあり、金さえもっていれば容姿にはあまり拘らない様子。 \r\nボン・キュ・ボンの代表でライダースーツ姿はかっこエロ良い。\r\n\r\n', NULL),
(3, 4, 'assets/images/girls/bluerose.jpg', 'ブルーローズ', 'hero', 'teens', '『TIGER&BUNNY』\r\nヒーロー界のスーパーアイドル。タイタンインダストリー所属。 スポンサーはペプシ。\r\n正体はカリーナ・ライル。 \r\n女王様キャラで売り出し中だが、本来は快活で元気な女子高生。スポンサーの思惑から様々なキャラ作りを要求される事を本心では嫌っている。NEXTとしての特殊能力は「氷を操ること」。 そんな彼女の決め台詞は、 \r\n「私の氷はちょっぴりCOLD、アナタの悪事を完全HOLD！」', NULL),
(4, 5, 'assets/images/girls/ryuko.JPG', '纏流子', 'cool', 'teens', '『キルラキル』\r\n殺された父の仇を探すために、鬼龍院皐月が支配する本能字学園へとやって来たスケバン転校生。 \r\n赤いメッシュが前髪に入った髪をしており、ぶっきらぼうな性格だが、根はやさしく情に厚い少女。 普段は「鮮血（制服）」を丈の短いセーラー服として着、スカートをサスペンダーで吊っている。 \r\n戦闘時には変形し鋼の服となる「鮮血」だが、露出が増えたその恰好は痴女同然。男勝りな彼女でも恥ずかしがる赤面モノである。（かわいい。）', NULL),
(5, 5, 'assets/images/girls/satsuki.jpg', '鬼龍院皐月', 'cool', 'teens', '『キルラキル』\r\n本能字学園を武力と恐怖で支配している生徒会長。 母親は学園の理事長にして世界のアパレル産業の70％を支配しているREVOCS社のCEO鬼龍院羅暁。つまりはお嬢様でもある。 \r\n衆前に姿を見せる時は学園の頂上から眩しく光り輝き、地上に降り立つ際は謎の布階段が登場する。 その性格は王者らしく峻厳苛烈で威風堂々。愛刀「縛斬（ばくざん）」を常に帯刀し、生徒とその家族をあらゆる力で掌握している。普段はおっぱいのついたイケメンだが、たまに見せる照れた表情は可愛い。\r\n\r\n', NULL),
(6, 2, 'assets/images/girls/shampoo.jpg', 'シャンプー', 'cute', 'teens', '『らんま1/2』\r\n中国奥地の村で暮らす武闘民族・女傑族の娘。恋愛に関しては非常に冷徹で、恋敵の抹殺すら厭わないという過激な面も持つため、恋敵には敵意剥き出しで、殺す気満々。アプローチは大胆かつ積極的。\r\n恋愛が絡まなければ誰にでも愛想が良い。CVの佐久間レイの喋る「いい加減な中国語」が大ハマリした事もこのキャラクターの人気の一因。', NULL),
(8, 1, 'assets/images/girls/lanka.jpg', 'ランカ・リー', 'cute', 'teens', '『マクロスF』\r\n妖怪緑女。よくわからないモンスターを飼っていた。', NULL),
(9, 1, 'assets/images/girls/mikumo.jpg', '美雲・ギンヌメール', 'beauty', 'teens', '『マクロスΔ』\r\n戦術音楽ユニット「ワルキューレ」のメンバー。 \r\n歌に対して人一倍真摯な姿勢を見せ、危機的状況に陥っても決して歌う事を諦めないチームのエースボーカル。 \r\n年齢、経歴、素性といったプロフィールの一切が不明だが、そのミステリアスさに惚れたファンも多く、身内からも「ミステリアスクイーン」と呼ばれている。 \r\n脱ぎたがりで考え込むシーンでは大体まっぱ。百合百合しさは満点。', NULL),
(10, 1, 'assets/images/girls/fureia.jpg', 'フレイア・ヴィオン', 'cute', '14', '『マクロスΔ』\r\n戦術音楽ユニットワルキューレに憧れる14歳の少女。 \r\n銀河辺境の惑星の王政国家である「ウィンダミア王国出身であり、なまり口調で喋る田舎娘。 \r\n天真爛漫な性格で、一度決めた事を曲げない芯の強さを持ち、「ごりごり」など擬音で物事を表現する癖がある。 \r\n初見「卵食べたらひよこさんがかわいそぉだよぉ～～＞＜」ってタイプの養殖女かと思ったが、本当に天然のいなかっぺらしい。', NULL),
(11, 2, 'assets/images/girls/sazae.JPG', 'フグ田サザエ', 'married woman', 'eternal 24', '『サザエさん』\r\nお魚咥えたどら猫を裸足で追っかける程のおっちょこちょい。独特の髪型（連載開始期に流行ったパーマ）をしている。性格は子供っぽく（というのか子供そのもの）元気で明るく嘘が全然つけないお人好しで、サッカーや野球等をカツオたちとやり合うほど快活なお姉さん。そのため身内は勿論、近隣や町内な人達からも大変好かれるいる。\r\n日本の良き嫁代表。\r\n', NULL),
(12, 5, 'assets/images/girls/mako.JPG', '満艦飾マコ', 'mako', 'teens', '『キルラキル』\r\n主人公の纏流子が転校してきた本能字学園の2年甲組の女子生徒。明るく常にテンションが高く、極度のマイペース・ド天然思考で、いわゆるアホの子。 \r\n朝から悪事を働く弟をプロレス技で制裁し、授業が始まればすぐさま早弁を掻っ込んで居眠りするなど、非常に元気で破天荒。 \r\n妄想や思い込みが激しく、自分一人で突っ走って慌てふためいていることも多い。 \r\nしかし、その思考もまた、どこかズレている。アホの子かわいい。\r\n', NULL),
(13, 6, 'assets/images/girls/marisa.JPG', '霧雨魔理沙', 'cute', 'unknown', '『東方Project』\r\n「弾幕は火力」をモットーとする普通の魔法使い。上海アリス幻樂団製作の同人ゲーム『東方Project』のキャラクター。 種族は人間で職業は魔法使い。魔法使いの宿命として、人々の生活から離れて暮らしている少女。基本的に、頭は切れるが、それを自分の生活に生かしていない。服装は基本的に全作品共通だが、デザインやカラーリングが作品によって多少異なっている。本人曰く魔法使いっぽい恰好を意識して選んでいるらしい。まあ何はともかく全部似合うし可愛い。', NULL),
(14, 2, 'assets/images/girls/ranma.jpg', '早乙女乱馬', 'otokonoko', '16', '『らんま1/2』\r\n無差別格闘早乙女流二代目 \r\n元祖無差別格闘流後継者候補（他に候補がいないので実質後継者）。 呪泉郷の呪いで水を被ると女の子に変身する。一度で二度美味しいみたいな設定である。（タグに女体化って書かなくて済むね！）お湯を被ると元に戻る。苦手なものは猫とギャンブル（考えがすぐ顔に出るため）。得意なものはスポーツ全般と料理。 アニメでは好物がお好み焼き、たこ焼き。他にパフェという甘党の一面もある。 ', NULL),
(15, 6, 'assets/images/girls/inori.JPG', '楪いのり', 'mysterious', 'unknown', '『ギルティクラウン』\r\nウェブアーティスト「EGOIST」のボーカルで、集の憧れの歌手で歌姫でもある。 \r\n無表情でミステリアスな雰囲気が漂い、出生不明。歌うことで自分の感情を解放する。 \r\n桜満集の『王の能力』によって出てくるヴォイドは剣である。 無口な美人。妖狐×僕のカルタちゃんに近しいものがある。基本露出度は高い。', NULL),
(16, 2, 'assets/images/girls/makishima.jpg', '巻島裕介', 'makichan', 'teens', '『弱虫ペダル』\r\n\r\n\r\n\r\nショ。\r\n\r\n\r\n\r\n', NULL),
(17, 2, 'assets/images/girls/ririchiyo.jpg', '白鬼院凜々蝶', 'cute', '15', '『妖狐×僕SS』\r\n鬼の先祖返り。 \r\n一人称は「僕」。ツンしゅん(ツンの後に落ち込む)なぶきっちょ系真心娘。 \r\n専属SSは御狐神双熾。人前で口を開くと、事あるごとに悪態をついてしまうという悪癖を持つ少女。 ニーハイ姿は控えめに言っても天使。', NULL),
(18, 2, 'assets/images/girls/karuta.jpg', '髏々宮カルタ', 'cute', '15', '『妖狐×僕SS』\r\nがしゃどくろの先祖返り。 \r\n青鬼院蜻蛉の専属SS。cv.花澤香菜。しかし、蜻蛉自身とは、あまり深い交流や関わりはない様子。 cv.花澤香菜。\r\n物静かで口数が少ない大食い少女。食べることが大好きで、登場時には高確率で何かしら口にしている。 cv.花澤香菜。膜が貼ったようにぼんやりとした雰囲気を持ち、しばしばエキセントリックな行動をとるため、周囲からは変わり者だと思われがちだが、解りづらいだけで、実は行動には全てきちんと理由がある。cv.花澤香菜。 \r\n頭で物事を考えるよりも、第六感で判断するタイプ。 \r\n考えるよりも深い部分(本能)で何が正しいか解っている。', NULL),
(19, 6, 'assets/images/girls/raimu.jpg', 'ライム', 'cute', 'unknown', '『セイバーマリオネット』\r\n乙女回路を持つ速度特化型セイバーマリオネット。廃棄されたジャポネス資料館の地下に眠っていた。外見年齢は中学1年生程度で精神は幼いが、銃弾発射を視認した後で回避したり、車をゴミのように薙ぎ倒して走り回るなど戦闘能力は高い。一人称は「ボク」。 あかほりさとる曰く「素直すぎて罪作り」。 幼稚園児のときこの娘に一目ぼれしてヲタクへの道に転がり落ちたといった人もいるらしい。', NULL),
(20, 7, 'assets/images/girls/maria.jpg', 'マリア', 'sexy', 'unknown', '『荒川アンダーザブリッジ』\r\nマリア様。\r\n一見、穏やかで優しそうなお姉さんに見えるのだが、実際は人を苛めるのが大好きなサディスト。 女性に対しては温厚でお姉さんのような存在だが、男性に対して（特にシスター）は笑顔で毒舌を吐く荒川の女帝と化す。 動物にはやさしい。荒川の「牧場」兼「河川敷セコム」係。「貴方の足が蟻さんを踏んでしまったらどう落し前つけてくれるの？」 でキャラソンデビュー。', NULL),
(21, 7, 'assets/images/girls/nino.jpg', 'ニノ', 'cute', 'unknown', '『荒川アンダーザブリッジ』\r\n荒川河川敷に住み、自らを金星人と名乗る謎のホームレス少女。 \r\nリクルート（リク/市ノ宮行）の恋人。　星に想いを寄せられている。 \r\n名前の由来は、彼女が着用しているジャージのゼッケン2-3から村長が付けたと思われる。 \r\n物忘れが激しく、１日会わないと恋人のリクルートの顔も忘れる。 \r\n夢遊病の気があり、睡眠中快適な場所を求め彷徨う事もあり危ない。 \r\nその為シスターが睡眠中の彼女にだけ合気道を仕込んだ。常識が通じない美人だが、ミステリアスな女性が好きな人はハマるかもしれない。', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `maiwaifuarea`
--

CREATE TABLE `maiwaifuarea` (
  `id` int(11) NOT NULL,
  `area` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `maiwaifuarea`
--

INSERT INTO `maiwaifuarea` (`id`, `area`) VALUES
(1, '宇宙'),
(2, '現代'),
(3, '戦国'),
(4, 'シュテルンビルト'),
(5, '本能寺学園'),
(6, 'その他'),
(7, '荒川');

-- --------------------------------------------------------

--
-- テーブルの構造 `megane`
--

CREATE TABLE `megane` (
  `id` int(100) NOT NULL,
  `meganeAreaID` int(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `kingaku` int(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `gazou` varchar(255) DEFAULT NULL,
  `syousai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `megane`
--

INSERT INTO `megane` (`id`, `meganeAreaID`, `name`, `color`, `kingaku`, `area`, `link`, `gazou`, `syousai`) VALUES
(1, 3, 'レイバン', 'ブラック', 24000, NULL, 'http://japan.ray-ban.com/sunglasses/wayfarer/clv', NULL, 'あぁ詳細かぁ'),
(3, 1, 'カメマンネン', 'ゴールド', 30000, '[value-6]', 'http://kamemannen.com/', NULL, '来年で100周年のメガネ業界で1番古いブランドのやばいやつ！勝って損は無い！買え！'),
(5, 2, 'パラサイト', 'ブラック', 54000, NULL, 'http://www.megane-murata1961.com/parasite-top.html', 'megane5.jpg', '奇抜なメガネといえばここ☆私も欲しい、、、');

-- --------------------------------------------------------

--
-- テーブルの構造 `meganearea`
--

CREATE TABLE `meganearea` (
  `id` int(100) DEFAULT NULL,
  `area` varchar(200) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `meganearea`
--

INSERT INTO `meganearea` (`id`, `area`) VALUES
(1, '丸'),
(2, 'その他'),
(3, '四角みたいなやつ');

-- --------------------------------------------------------

--
-- テーブルの構造 `nail`
--

CREATE TABLE `nail` (
  `ID` int(11) NOT NULL,
  `date` char(20) COLLATE utf8_bin NOT NULL,
  `KisetuID` char(2) COLLATE utf8_bin NOT NULL,
  `maincolor` char(20) COLLATE utf8_bin NOT NULL,
  `handmodel` char(20) COLLATE utf8_bin NOT NULL,
  `comment` varchar(300) COLLATE utf8_bin NOT NULL,
  `imageFileName` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `nail`
--

INSERT INTO `nail` (`ID`, `date`, `KisetuID`, `maincolor`, `handmodel`, `comment`, `imageFileName`) VALUES
(1, '2016/02/22', 'sp', 'オレンジ', 'ひとみさん', 'ハイキューネイル', '1.jpg'),
(2, '2016/04/21', 'sp', 'ホワイト', 'ひとみさん', 'おそ松さんネイル', '2.jpg'),
(3, '2016/08/06', 'su', 'グリーン', 'やよいさん', '夏パールネイル', '3.jpg'),
(4, '2016/07/18', 'su', 'ピンク', 'じぶん', '成人式ネイル\r\n着物に合わせて施術', '4.jpg'),
(5, '2016/10/22', 'au', 'グレー', 'じぶん', '秋冬ネイル', '5.jpg'),
(6, '2016/09/22', 'au', 'レッド', 'じぶん', 'ワインレッドの秋ネイル', '6.jpg'),
(7, '2016/02/22', 'wi', 'レッド', 'ひとみさん', 'バレンタインネイル', '7.jpg'),
(8, '2016/12/24', 'wi', 'ピンク', 'じぶん', 'クリスマスネイル', '8.jpg'),
(36, '2016/05/09', 'sp', 'ブルー', 'じぶん', 'ラメグラデネイル\r\n', '11695014_690307654434924_4673989754922144318_n.jpg');

-- --------------------------------------------------------

--
-- テーブルの構造 `norris`
--

CREATE TABLE `norris` (
  `id` int(5) NOT NULL,
  `iine` int(255) DEFAULT NULL,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  `year` int(5) NOT NULL,
  `seriesId` int(5) NOT NULL,
  `comment` varchar(60) COLLATE utf8_bin NOT NULL,
  `series` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `norris`
--

INSERT INTO `norris` (`id`, `iine`, `name`, `year`, `seriesId`, `comment`, `series`) VALUES
(1, 10, '地獄のヒーロー!!!', 1111, 1, '地獄のヒーローシリーズ第一作!!!', NULL),
(2, 0, 'デルタ・フォース', 1986, 3, 'デルタ・フォースシリーズ第一作', NULL),
(3, 2, '炎のテキサスレンジャー', 1993, 2, 'テレビドラマシリーズ', NULL),
(4, 14, '野獣捜査線', 1985, 0, '全米初登場1位', NULL),
(5, 0, '地獄のコマンド', 1985, 0, '全米初登場1位', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `norrisseries`
--

CREATE TABLE `norrisseries` (
  `id` int(5) NOT NULL,
  `series` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `norrisseries`
--

INSERT INTO `norrisseries` (`id`, `series`) VALUES
(0, 'なし'),
(1, '地獄のヒーロー'),
(2, '炎のテキサスレンジャー'),
(3, 'デルタ・フォース');

-- --------------------------------------------------------

--
-- テーブルの構造 `onsen`
--

CREATE TABLE `onsen` (
  `id` int(100) NOT NULL,
  `onsenAreaId` int(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `effect` varchar(100) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `onsen`
--

INSERT INTO `onsen` (`id`, `onsenAreaId`, `name`, `effect`, `comment`, `area`, `link`) VALUES
(3, 6, '草津温泉', '皮膚病', '日本一の豊富な湯量と、強力な殺菌力を誇ります。', NULL, 'http://sainokawara.com/'),
(4, 6, '伊香保温泉', '切り傷、火傷、慢性皮膚病、美肌効果', '伊香保温泉は草津温泉と並び、群馬県を代表する温泉地。', NULL, 'http://www.ikaho-kankou.com/'),
(5, 5, '鬼怒川温泉', '神経痛、筋肉痛、関節痛、五十肩、運動麻痺、関節のこわばり、うちみ、くじき、慢性消化器病、痔疾冷え性、病後回復期、健康増進', '江戸時代、日光を詣でる僧侶や大名だけが入ることを許されていた由緒正しい温泉です。', NULL, 'http://www.nikko-kankou.org/spot/51/'),
(6, 2, '湯河原温泉', '切り傷、火傷、慢性皮膚病、虚弱児童、慢性婦人病', '豊かな自然に囲まれた湯河原温泉は、山海の幸に恵まれているため、さまざまなグルメが楽しめます。', NULL, 'http://www.yugawara.or.jp/'),
(7, 5, '那須温泉', '神経痛、筋肉痛、関節痛、五十肩、運動麻痺、関節のこわばり、うちみ、くじき、慢性消化器病、痔疾、冷え性、病後回復期、健康増進', '那須温泉には1300年続く「鹿の湯」があり、かつて傷を負った鹿がこの湯に入って傷を癒したと言われています。', NULL, 'http://www.nasuonsen.com/'),
(8, 3, '養老渓谷温泉', '切り傷、火傷、慢性皮膚病、美肌効果', '老渓谷温泉は、こげ茶色をした「黒湯」と呼ばれる珍しい泉質の温泉です。', NULL, 'http://www.yorokeikoku.com/'),
(9, 3, '鴨川温泉', '切り傷、火傷、慢性皮膚病、虚弱児童、慢性婦人病', '泉質は単純硫黄冷鉱泉です。', NULL, 'http://www.kamogawa-hotel.info/'),
(10, 7, '袋田温泉', '神経痛、筋肉痛、関節痛、五十肩、運動麻痺、関節のこわばり、うちみ、くじき、慢性消化器病、痔疾、冷え性、病後回復期、健康増進', '久慈川の支流、滝川のほとりにある歴史を誇る温泉地です。', NULL, 'http://www.town.daigo.ibaraki.jp/page/page000016.html'),
(11, 4, '名栗温泉', '痛風、動脈硬化症、高血圧症、慢性胆のう炎、胆石症、慢性皮膚病、慢性婦人病', '名栗温泉は鎌倉時代（約800年前）に猟師に発見されたと伝えられている古湯。', NULL, 'http://www.rurubu.com/onsen/detail.aspx?ID=SP301430'),
(12, 1, '板橋温泉', '切り傷、火傷、慢性皮膚病、虚弱児童、慢性婦人病', '東京都板橋区（旧国武蔵国）にある温泉。', NULL, 'http://www.rurubu.com/season/special/higaeriyu/detail.aspx?SozaiNo=130028');

-- --------------------------------------------------------

--
-- テーブルの構造 `onsenarea`
--

CREATE TABLE `onsenarea` (
  `id` int(100) NOT NULL,
  `area` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `onsenarea`
--

INSERT INTO `onsenarea` (`id`, `area`) VALUES
(1, '東京都'),
(2, '神奈川県'),
(3, '千葉県'),
(4, '埼玉県'),
(5, '栃木県'),
(6, '群馬県'),
(7, '茨城県');

-- --------------------------------------------------------

--
-- テーブルの構造 `operator`
--

CREATE TABLE `operator` (
  `ID` int(11) NOT NULL,
  `OperatorID` char(10) CHARACTER SET latin1 NOT NULL,
  `OperatorName` char(50) COLLATE utf8mb4_bin NOT NULL,
  `UserID` char(50) CHARACTER SET latin1 NOT NULL DEFAULT 'CURRENT_USER',
  `Date` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `operator`
--

INSERT INTO `operator` (`ID`, `OperatorID`, `OperatorName`, `UserID`, `Date`) VALUES
(0, 'S', 'SoftBank', 'CURRENT_USER', NULL),
(1, 'Y', 'Y!mobile', 'root@localhost', NULL),
(2, 'A', 'au', 'root@localhost', NULL),
(3, 'D', 'Docomo', 'root@localhost', NULL),
(4, 'F', 'SIMフリー', 'root@localhost', NULL),
(5, 'FT', 'FREETEL', 'root@localhost', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `ozakialbum`
--

CREATE TABLE `ozakialbum` (
  `id` int(11) NOT NULL,
  `albumName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `ozakialbum`
--

INSERT INTO `ozakialbum` (`id`, `albumName`) VALUES
(1, '十七歳の地図'),
(2, '回帰線'),
(3, '壊れた扉から'),
(4, '街路樹'),
(5, '誕生'),
(6, '放熱への証');

-- --------------------------------------------------------

--
-- テーブルの構造 `ozakisong`
--

CREATE TABLE `ozakisong` (
  `id` int(11) NOT NULL,
  `songName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `albumId` int(11) DEFAULT NULL,
  `songWriting` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lyrics` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `albumName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `ozakisong`
--

INSERT INTO `ozakisong` (`id`, `songName`, `albumId`, `songWriting`, `age`, `lyrics`, `albumName`) VALUES
(1, '街の風景', 1, '尾崎豊、尾崎豊', '1983.12.1', '街の風に引き裂かれ　舞い上がった夢くずが...', NULL),
(2, 'はじまりさえ歌えない', 1, '尾崎豊、尾崎豊', '1983.12.1', 'ふと目を閉じればアスファルトの道端に...', NULL),
(3, 'I LOVE YOU', 1, '尾崎豊、尾崎豊', '1983.12.1', 'I love you　今だけは悲しい歌聞きたくないよ...', NULL),
(4, 'ハイスクール Rock\'n\'Roll', 1, '尾崎豊、尾崎豊', '1983.12.1', 'Oh！朝は目覚めても昨日の疲れひきずったまま...', NULL),
(5, '15の夜', 1, '尾崎豊、尾崎豊', '1983.12.1', '落書きの教科書と外ばかり見てる俺...', NULL),
(6, '十七歳の地図', 1, '尾崎豊、尾崎豊', '1983.12.1', '十七のしゃがれたブルースを聞きながら...', NULL),
(7, '愛の消えた街', 1, '尾崎豊、尾崎豊', '1983.12.1', '道端に倒れた様に眠る人がいるよ...', NULL),
(8, 'OH MY LITTLE GIRL', 1, '尾崎豊、尾崎豊', '1983.12.1', 'こんなにも騒がしい街並みに　たたずむ君は...', NULL),
(9, '傷つけた人々へ', 1, '尾崎豊、尾崎豊', '1983.12.1', 'どれだけ言葉費し　君に話したろう...', NULL),
(10, '僕が僕であるために', 1, '尾崎豊、尾崎豊', '1983.12.1', '心すれちがう悲しい生き様に...', NULL),
(11, 'Scrambling Rock\'n\'Roll', 2, '尾崎豊、尾崎豊', '1985.3.21', '俺達何かを求めてわめく　うるさいRock\'n\'Roll Band...', NULL),
(12, 'Bow!', 2, '尾崎豊、尾崎豊', '1985.3.21', '否が応でも社会に飲み込まれてしまうものさ...', NULL),
(13, 'Scrap Alley', 2, '尾崎豊、尾崎豊', '1985.3.21', '二人で中古の車に乗り込み　ハイウェイを飛ばすおまえは...', NULL),
(14, 'ダンスホール', 2, '尾崎豊、尾崎豊', '1985.3.21', NULL, NULL),
(15, '卒業', 2, '尾崎豊、尾崎豊', '1985.3.21', NULL, NULL),
(16, '存在', 2, '尾崎豊、尾崎豊', '1985.3.21', NULL, NULL),
(17, '坂の下に見えたあの街に', 2, '尾崎豊、尾崎豊', '1985.3.21', NULL, NULL),
(18, '群衆の中の猫', 2, '尾崎豊、尾崎豊', '1985.3.21', NULL, NULL),
(19, 'Teenage Blue', 2, '尾崎豊、尾崎豊', '1985.3.21', NULL, NULL),
(20, 'シェリー', 2, '尾崎豊、尾崎豊', '1985.3.21', NULL, NULL),
(21, '路上のルール', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(22, '失くした1/2', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(23, 'Forget-me-not', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(24, '彼', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(25, '米軍キャンプ', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(26, 'Freeze Moon', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(27, 'Driving All Night', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(28, 'ドーナツ・ショップ', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(29, '誰かのクラクション', 3, '尾崎豊、尾崎豊', '1985.11.28', NULL, NULL),
(30, '核 (CORE)', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(31, '・ISM', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(32, 'LIFE', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(33, '時', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(34, 'COLD WIND', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(35, '紙切れとバイブル', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(36, '遠い空', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(37, '理由', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(38, '街路樹', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(39, 'LOVE WAY', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(40, 'KISS', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(41, '黄昏ゆく街で', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(42, 'ロザーナ', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(43, 'RED SHOES STORY', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(44, '銃声の証明', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(45, 'LONELY ROSE', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(46, '置き去りの愛', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(47, 'COOKIE', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(48, '永遠の胸', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(49, 'FIRE', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(50, 'レガリテート', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(51, '虹', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(52, '禁猟区', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(53, 'COLD JAIL NIGHT', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(54, '音のない部屋', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(55, '風の迷路', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(56, 'きっと忘れない', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(57, 'MARRIAGE', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(58, '誕生', 5, '尾崎豊、尾崎豊', '1990.11.15', NULL, NULL),
(59, '汚れた絆', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(60, '自由への扉', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(61, 'Get it down', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(62, '優しい陽射し', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(63, '贖罪', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(64, 'ふたつの心', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(65, '原色の孤独', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(66, '太陽の瞳', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(67, 'Monday morning', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(68, '闇の告白', 6, '尾崎豊、尾崎豊', '1992.5.10', '何ひとつ語れずに　うずくまる人々の　命が今日またひとつ...', NULL),
(69, 'Mama, say good-bye', 6, '尾崎豊、尾崎豊', '1992.5.10', NULL, NULL),
(70, '太陽の破片', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL),
(71, '街角の風の中', 4, '尾崎豊、尾崎豊', '1988.9.1', NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `phones`
--

CREATE TABLE `phones` (
  `ID` int(11) NOT NULL,
  `OperatorID` char(11) CHARACTER SET latin1 NOT NULL,
  `PhonesName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Price` int(11) NOT NULL,
  `Size` char(11) CHARACTER SET latin1 NOT NULL,
  `Date` date NOT NULL,
  `Comment` text COLLATE utf8_bin NOT NULL,
  `operatorName` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `phones`
--

INSERT INTO `phones` (`ID`, `OperatorID`, `PhonesName`, `Price`, `Size`, `Date`, `Comment`, `operatorName`) VALUES
(1, 'Y', 'iPhone2', 13000, '4.5', '2013-03-25', 'てｓｔ', NULL),
(2, 'FT', 'MIYABI', 36000, '5.5', '2011-07-05', '', NULL),
(3, 'A', 'iPhone2', 74000, '4.5', '2014-10-24', '', NULL),
(4, 'D', 'Xperia Acco', 32000, '6', '2012-11-05', '', NULL),
(5, 'F', 'iPhone3', 120000, '3', '2015-07-15', '', NULL),
(6, 'S', 'HONEY By', 24000, '3.5', '2015-08-31', 'てｓ\r\n初めて買った機種', NULL),
(7, 'D', 'Galaxy', 56000, '5.5', '2016-04-01', 'test', NULL),
(8, 'F', 'GR5', 38000, '5.5', '2016-02-01', '', NULL),
(9, 'A', 'AQUOS PHONE', 87000, '6.4', '2014-07-08', '000', NULL),
(12, 'A', 'test', 11, '11.0', '2011-11-11', 'test', NULL),
(13, 'F', 'test', 45000, '4.0', '2015-00-06', '', NULL),
(32, 'F', 'High Five', 126000, '7.2', '2017-03-14', '', NULL),
(33, 'A', 'AQUOS PHONE', 72000, '5.5', '2015-02-20', '', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `player`
--

CREATE TABLE `player` (
  `playerID` int(11) NOT NULL,
  `playername` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `teamID` int(11) DEFAULT NULL,
  `position` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `teamName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `imagePath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '画像へのパス'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `player`
--

INSERT INTO `player` (`playerID`, `playername`, `teamID`, `position`, `age`, `comment`, `teamName`, `imagePath`) VALUES
(1, '土井康平', 1, 'GK', 28, '', NULL, NULL),
(2, '谷口堅三', 1, 'FW', 28, '', NULL, NULL),
(3, '深井脩平', 2, 'DF', 23, '', NULL, NULL),
(4, '日高慶太', 2, 'MF', 26, '', NULL, NULL),
(5, '岡田大', 3, 'GK', 31, '', NULL, NULL),
(6, '渡辺匠', 3, 'MF', 34, '', NULL, NULL),
(7, '亀島周', 10, 'DF', 23, '', NULL, NULL),
(8, '前田俊介', 10, 'FW', 30, '', NULL, NULL),
(9, '宮城晃太', 13, 'MF', 23, '', NULL, NULL),
(10, 'パブロ', 13, 'FW', 20, '', NULL, NULL),
(11, '修行智仁', 11, 'GK', 32, '', NULL, NULL),
(12, 'パウリーニョ', 11, 'FW', 34, '', NULL, NULL),
(13, '鈴木義宜', 11, 'DF', 24, '', NULL, NULL),
(56, 'dorami', 6, 'DF', 5, 'オラァ！', NULL, '1462506571163.jpg');

-- --------------------------------------------------------

--
-- テーブルの構造 `potatomaker`
--

CREATE TABLE `potatomaker` (
  `id` int(11) NOT NULL,
  `makerName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `potatomaker`
--

INSERT INTO `potatomaker` (`id`, `makerName`) VALUES
(1, '湖池屋'),
(2, 'カルビー'),
(3, 'プリングルズ'),
(4, 'ヤマザキナビスコ'),
(5, '山芳食品'),
(6, 'ハウス食品'),
(10, 'その他');

-- --------------------------------------------------------

--
-- テーブルの構造 `potatoproduct`
--

CREATE TABLE `potatoproduct` (
  `id` int(11) NOT NULL,
  `makerId` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `volume` int(4) NOT NULL,
  `price` int(5) NOT NULL,
  `comment` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `makerName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `potatoproduct`
--

INSERT INTO `potatoproduct` (`id`, `makerId`, `name`, `type`, `volume`, `price`, `comment`, `makerName`) VALUES
(24, 1, 'ポテトチップスのりしお', '通常販売', 60, 120, '王道の味。\r\nこれが最強のポテチと巷で噂になっている。', NULL),
(25, 3, 'プリングルズうましお味', '通常販売', 110, 223, '海外産スナック菓子。\r\nひげのおじちゃんがトレードマーク', NULL),
(26, 4, 'チップスターSうすしお', '通常販売', 50, 120, '筒状日本代表。\r\n食べたその日から味の虜になりました', NULL),
(27, 5, 'わさビーフ', '通常販売', 55, 120, 'わさび味のポテチ。\r\nちなみにマスコットの名前はわさっち（Twitter応募）', NULL),
(28, 6, 'オーザックあっさり塩', '通常販売', 60, 120, 'よくコラボするやつ。\r\nほかのポテチと比べてカスが落ちやすい', NULL),
(29, 2, '堅あげポテト 飛騨みそ味', '地域限定', 120, 600, '中部（岐阜）限定の堅あげ。\r\n15g×8袋なのでお土産にどうぞ', NULL),
(30, 2, 'ピザポテト', '通常販売', 63, 190, '厚切り+チーズがウリ。\r\n2017年6月現在、公式サイトがやかましい', NULL),
(31, 2, '夏ポテト対馬の浜御塩', '期間限定', 65, 135, '夏季限定のポテチ。\r\n実は女性がターゲット', NULL),
(32, 10, 'The world''s most exclusive potato chips', 'その他', 20, 6100, '名前の通り世界で一番高価なポテチ\r\n中身は5枚のみで世界一ビールと合うポテチである', NULL);

-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- テーブルの構造 `galgamemaker`
--

CREATE TABLE `galgamemaker` (
  `id` int(11) NOT NULL,
  `makerName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `galgamemaker`
--

INSERT INTO `galgamemaker` (`id`, `makerName`) VALUES
(1, 'PULLTOP'),
(2, 'Key'),
(3, 'ニトロプラス'),
(4, 'オーガスト'),
(5, 'Leaf'),
(6, 'ライアーソフト'),
(7, 'TYPE-MOON'),
(8, 'フロントウイング'),
(9, '戯画'),
(10, 'ケロQ/枕'),
(11, 'Navel'),
(12, 'あかべぇそふとつぅ'),
(13, 'その他');

-- --------------------------------------------------------

--
-- テーブルの構造 `galgameproduct`
--

CREATE TABLE `galgameproduct` (
  `id` int(11) NOT NULL,
  `makerId` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(4) NOT NULL,
  `score` int(3) NOT NULL,
  `comment` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `makerName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `galgameproduct`
--

INSERT INTO `galgameproduct` (`id`, `makerId`, `name`, `year`, `score`, `comment`, `makerName`) VALUES
(1, 1, '遥かに仰ぎ、麗しの', 2006, 84, 'かにしの。風祭みやび。2006年びしょげー大賞、健速乙', NULL),
(2, 1, 'この大空に翼を広げて', 2012, 90, 'ころげて。望月天音。2012年びしょげー大賞、五行なずな　IS　GOD', NULL),
(3, 2, 'Kanon', 1999, 84, 'かのん。月宮あゆ。業界に蔓延る奇声ヒロインのはしり、うぐぅ', NULL),
(4, 2, 'AIR', 2000, 89, 'えあー。神尾観鈴。にはは……', NULL),
(5, 2, 'CLANNAD', 2004, 94, 'くらなど。古河渚。これよりテキスト量あるゲームある？ってくらいに超大作', NULL),
(6, 2, 'リトルバスターズ！', 2007, 85, 'りとばす。棗鈴。最後の√なければ駄作、最後の√のおかげで良作', NULL),
(7, 3, 'Phantom-phantom_of_inferno-', 2000, 85, 'ふぁんとむ。キャル・ディヴェンス。虚淵氏ねって言いたくなる', NULL),
(8, 3, '装甲悪鬼村正', 2010, 92, 'むらまさ。足利茶々丸。熱血イケメン主人公が多い中かなり珍しい根暗おっさん主人公、だがそれがいい', NULL),
(9, 3, 'CHAOS;HEAD', 2008, 80, 'かおへ。咲畑梨深。科学ADVシリーズ第一弾だけど科学感あらず', NULL),
(10, 3, 'STEINS;GATE', 2009, 91, 'しゅたげ。牧瀬紅莉栖。システムが斬新（めんどくさいともいう）な名作、知名度も高い', NULL),
(11, 4, '月は東に日は西に', 2003, 75, 'はにはに。天ヶ崎美琴。未プレイ、べっかんこうの絵はすき', NULL),
(12, 4, '夜明け前より瑠璃色な', 2005, 80, 'けよりな。フィーナ・ハム・アーシュライト。キャベツ・・・うっ頭が', NULL),
(13, 5, 'ToHeart', 1997, 78, '東鳩。HMX-12”マルチ”。この頃の葉鍵が後の業界に与えた影響は計り知れず、もう20年前ってマジ？', NULL),
(14, 5, 'WHITE_ALBUM2', 2010, 91, 'ほわるば２。冬馬かずさ。丸戸作品にしては珍しい、主人公が真面目系クズ', NULL),
(15, 7, 'Fate/Stay_Night', 2003, 94, 'ふぁて。遠坂凛。ザ・厨二、数々のメディア展開と派生作品でもはや業界の顔にまでなってそう', NULL),
(16, 7, '月姫', 1999, 88, 'つきひめ。琥珀。リメイクまだ？', NULL),
(19, 8, 'グリザイアの果実', 2011, 90, 'ぐりかじ。周防天音。主人公強すぎンゴねぇ……', NULL),
(20, 9, 'パルフェ', 2005, 93, 'ぱるふぇ。花鳥玲愛。ストンピングはもはや伝説', NULL),
(21, 9, 'この青空に約束を-', 2006, 89, 'こんにゃく。羽山海巳。KONoaozoraNiYAKUsokuwo→こんにゃく', NULL),
(22, 9, 'BALDR_FORCE', 2002, 84, 'ばるど。バチェラ。ゲームパートの出来のよさに定評のあるバルドシリーズの第一弾', NULL),
(23, 10, 'モエかん', 2003, 75, 'もえかん。リニア。すかぢ神', NULL),
(24, 10, 'サクラノ詩', 2015, 98, 'さくらのうた。夏目藍。2015年びしょげー大賞、10年以上待たせた価値のある名作', NULL),
(25, 11, '俺たちに翼はない', 2009, 87, 'おれつば。玉泉日和子。この業界で日常系書かせたら王雀孫の右に出るものはいない', NULL),
(26, 11, '月に寄りそう乙女の作法', 2014, 90, 'つり乙。桜小路ルナ。2014年びしょげー大賞。やっぱり”王雀孫”なんだよなぁ……', NULL),
(27, 12, '車輪の国、向日葵の少女', 2005, 93, 'しゃりん。日向夏咲。この頃のるーすは本当に天才だった……どうして……', NULL),
(28, 13, 'CROSS†CHANNEL', 2003, 97, 'くろちゃん。山辺美希。本編の短さの割に内容の濃さが半端じゃない、考察サイトで二度楽しめる', NULL),
(29, 13, '家族計画', 2001, 92, 'かけい。高屋敷茉莉。鬼才、田中ロミオにしては珍しく大衆受けを狙えそうな作品', NULL),
(30, 13, '水夏', 2001, 85, 'すいか。名無しの少女。サーカスはダ・カーポのが有名だけどこっちのがすき', NULL),
(31, 5, '痕', 1996, 85, 'きずあと。柏木千鶴。あなたを殺します（直球）', NULL),
(32, 13, 'Ever17-the_out_of_infinity-', 2002, 93, 'えばーせぶんてぃーん。小町つぐみ。導入から中盤は冗長、後半は神', NULL),
(33, 13, '黄昏のシンセミア', 2010, 90, 'シンセミア。皆神さくや。2010年びしょげー大賞、ジャコス行くの！？', NULL),
(34, 13, 'ひぐらしのなく頃に', 2002, 83, 'ひぐらし。古手梨花。竜騎士は死んだ！もういない！', NULL),
(35, 13, 'ゴア・スクリーミング・ショウ', 2006, 86, 'ごあすく。ユカ。グロ注意、中身もさることながらデンカレの曲もめっちゃいい', NULL),
(36, 13, 'ノラと皇女と野良猫ハート', 2016, 76, 'ノラとと。パトリシア・オブ・エンド。日常パート・パトリシア√はいい、それ以外は……', NULL),
(37, 6, '黄雷のガクトゥーン', 2012, 90, 'ガクトゥーン。ネオン・スカラ・スミリヤ。人を選ぶスチパンシリーズで最も大衆受けする作品だと思う', NULL),
(38, 13, 'Dies_irae～acta_est_fabula～', 2010, 93, 'でぃえすいれ。マルグリット･ブルイユ。ザ・厨二その2、完成版発売まで色々あったけど出てみればめっちゃよかったのでそれだけに騒動でケチがついたのが惜しい', NULL);
--
-- Indexes for dumped tables
--

--
-- Indexes for table `galgameproduct`
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
  `area_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `restaurant`
--

INSERT INTO `restaurant` (`id`, `name`, `stars`, `comment`, `area_id`, `create_date`, `create_user`, `update_date`, `update_user`, `version`) VALUES
(1, '四文屋', 4, '安くて美味いです。アキバとかにもあります。隣のカレー屋がいつもいい匂いさせててつらい。', 1, '2015-12-05 08:24:51', 'struts2', '2017-06-05 16:54:05', 'struts2', 6),
(2, 'てけてけ', 3, '割と安い。味はそこそこ。', 1, '2016-04-18 21:37:00', '豚野郎', '2016-04-18 21:37:00', '豚野郎', 0),
(3, '四文屋', 4, '安くて美味いです。\r\n新宿とかにもあります。\r\nなんか外人の店員が多い気がする。', 3, '2016-04-19 20:33:09', 'Struts2', '2016-04-19 20:33:09', 'Struts2', 0),
(5, '大衆居酒屋 いこい', 3, 'ハイボールが180円。でも食い物は別に安くない。ぶつ爆弾がうまかった。', 5, '2016-05-09 00:00:00', 'struts2', '2016-05-12 13:50:34', 'Struts2', 2);

-- --------------------------------------------------------

--
-- テーブルの構造 `rider`
--

CREATE TABLE `rider` (
  `ID` int(10) NOT NULL,
  `Number` int(10) DEFAULT NULL,
  `RiderName` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `TeamID` int(10) DEFAULT NULL,
  `Country` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Age` int(10) DEFAULT NULL,
  `BirthDay` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Comment` varchar(500) CHARACTER SET latin1 NOT NULL,
  `teamName` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `rider`
--

INSERT INTO `rider` (`ID`, `Number`, `RiderName`, `TeamID`, `Country`, `Age`, `BirthDay`, `Comment`, `teamName`) VALUES
(1, 4, 'Andrea Dovizioso', 4, 'ITA', 30, '1986/3/23', '', NULL),
(2, 6, 'Stefan Bradl', 1, 'DEU', 26, '1989/11/29', '', NULL),
(3, 8, 'Hector Barbera', 3, 'ESP', 29, '1986/11/2', '', NULL),
(4, 9, 'Danilo Petrucci', 9, 'ITA', 25, '1990/10/24', '', NULL),
(5, 19, 'Alvaro Bautista', 1, 'ESP', 31, '1984/11/21', '', NULL),
(6, 25, 'Maverick Vinales', 11, 'ESP', 21, '1995/1/12', '', NULL),
(7, 26, 'Dani Pedrosa', 10, 'ESP', 30, '1985/9/29\r\n', '', NULL),
(8, 29, 'Andrea Iannone', 4, 'ITA', 26, '1989/8/9', '', NULL),
(10, 38, 'Bradley Smith', 7, 'GBR', 25, '1990/11/28', '', NULL),
(11, 41, 'Aleix Espargaro', 11, 'ESP', 26, '1989/7/30', '', NULL),
(12, 43, 'Jack Miller', 5, 'AUS', 21, '1995/1/18', '', NULL),
(13, 44, 'Pol Espargaro', 7, 'ESP', 24, '1991/6/10', '', NULL),
(14, 45, 'Scott Redding', 9, 'GBR', 23, '1993/1/4', '', NULL),
(15, 46, 'Valentino Rossi', 8, 'ITA', 37, '1979/2/16', '', NULL),
(16, 50, 'Eugene Laverty', 2, 'IRL', 29, '1986/6/3', '', NULL),
(17, 53, 'Tito Rabat', 5, 'ESP', 26, '1989/5/25', '', NULL),
(18, 68, 'Yonny Hernandez', 2, 'COL', 27, '1988/7/25', '', NULL),
(19, 76, 'Loris Baz', 3, 'FRA', 23, '1993/2/1', '', NULL),
(20, 93, 'Marc Maruquez', 10, 'ESP', 23, '1993/2/17', '', NULL),
(21, 99, 'Jorge Lorenzo', 8, 'ESP', 28, '1987/5/4', '', NULL),
(22, 27, 'Casey Stoner', 12, 'AUS', 30, '1985/10/16', '', NULL),
(27, 56, 'Shinya Nakano', 12, 'JPN', 38, '1977/10/10', '', NULL),
(28, 8, 'Guy Martin', 13, 'GBR', 34, '1981/11/4', 'Isle of Man TT Rider', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `sakearea`
--

CREATE TABLE `sakearea` (
  `id` int(11) NOT NULL,
  `area` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `sakearea`
--

INSERT INTO `sakearea` (`id`, `area`) VALUES
(1, '神泉町'),
(2, '道玄坂'),
(3, '円山町'),
(4, '渋谷'),
(5, '宇田川町'),
(6, '桜が丘');

-- --------------------------------------------------------

--
-- テーブルの構造 `sakeinfo`
--

CREATE TABLE `sakeinfo` (
  `id` int(11) NOT NULL,
  `areaId` int(11) NOT NULL,
  `shopName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hours` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `recommend` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `priceHigh` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `priceLow` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `area` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `sakeinfo`
--

INSERT INTO `sakeinfo` (`id`, `areaId`, `shopName`, `hours`, `price`, `recommend`, `comment`, `priceHigh`, `priceLow`, `area`) VALUES
(1, 2, 'KURAND SAKE MARKET 渋谷店', '17:00-23:00', 3000, NULL, '日本酒時間無制限にて飲み放題', NULL, NULL, NULL),
(2, 1, '酒とさか菜', '17:30-24:00', 6000, NULL, 'なかなか飲めない珍しい日本酒をたくさん取り扱う', NULL, NULL, NULL),
(3, 4, 'sakeda', '18:00-24:00', 3000, NULL, 'リーズナブルで新鮮な魚、気の利いたおつまみと美味しい日本酒が飲める知る人ぞ知る人気の居酒屋', NULL, NULL, NULL),
(4, 3, '萬安', '17:30-23:00', 5000, NULL, '常時40種類の最高の状態で日本酒を管理', NULL, NULL, NULL),
(5, 5, 'うのさと', '17:00-23:30', 4000, NULL, '全国から厳選した地酒、焼酎を取り揃える', NULL, NULL, NULL),
(6, 4, '風ぐるま', '17:30-24:00', 3000, NULL, 'この道30年の店主が営む居酒屋', NULL, NULL, NULL),
(8, 2, 'サカノチカ', '15:00-24:00', 3000, NULL, '日本酒メニューを日替わりで提供', NULL, NULL, NULL),
(9, 3, 'ぽつらぽつら', '18:00-24:00', 6000, NULL, '日本酒だけでなく国産のワインも充実', NULL, NULL, NULL),
(10, 6, '高太郎', '18:00-02:00', 6000, NULL, '食べログランキングトップ500入りを果たし予約困難な人気店', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `season`
--

CREATE TABLE `season` (
  `KisetuID` char(2) COLLATE utf8_bin NOT NULL,
  `Kisetu` char(1) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `season`
--

INSERT INTO `season` (`KisetuID`, `Kisetu`) VALUES
('sp', '春'),
('su', '夏'),
('au', '秋'),
('wi', '冬');

-- --------------------------------------------------------

--
-- テーブルの構造 `ship`
--

CREATE TABLE `ship` (
  `shipID` int(10) NOT NULL,
  `shipName` varchar(20) DEFAULT NULL,
  `countryID` int(10) DEFAULT NULL,
  `shipClass` varchar(20) DEFAULT NULL,
  `year` int(10) DEFAULT NULL,
  `comment` varchar(300) DEFAULT NULL,
  `countryName` varchar(300) CHARACTER SET utf8mb4 DEFAULT NULL,
  `imagePath` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '画像へのパス'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `ship`
--

INSERT INTO `ship` (`shipID`, `shipName`, `countryID`, `shipClass`, `year`, `comment`, `countryName`, `imagePath`) VALUES
(9, 'ビスマルク', 2, '戦艦', 1940, 'ドイツが初めて建造した超弩級戦艦。<br />排水量は協定破りの４１７００トンとまさに弩級。<br />スペックとは裏腹にそこまでの戦績は残さず沈没してしまった。<br />ハイル〇トラー‼', NULL, '3bismarck.jpg_20160822115137.jpeg'),
(10, 'アイオワ', 3, '戦艦', 1943, 'アメリカを代表する戦艦であるアイオワは排水量48000トンを誇る（協定守る気あんの？）<br />しかし、艦隊決戦の機械がなく専ら空母のお守となかなかの宝の持ち腐れっぷりである。<br />（別にアメリカが嫌いなわけではないよ）', NULL, '87797b67fd44e80bf66f631adcfafbdb80bdaff81456287050.jpg_20160822115733.jpeg'),
(11, '大和', 1, '戦艦', 1920, '日本が誇る戦艦大和<br />この名を知らないものはいないであろう（知らないとかモグリなん？）<br />排水量は64000トンとまさに化け物級であり、46㎝3連装砲は他国ではマネの出来なかった<br />日本の英知の結晶である。（俺は長門の方が好きだけどね‼）', NULL, 'o-YAMATO-facebook.jpg_20160822120139.jpeg'),
(12, '赤城', 1, '空母', 1927, '日本の空母と言えば赤城を置いてほかにはいないだろう（言い過ぎ、私は信濃が好き）<br />初期段階では三段甲板だった。<br />下段が大型機の発艦、中段は小型機の発艦と20連装砲を2基、最上段は着艦と、英空母フィーリアスに倣っている。<br />1935年に通常の平甲板型となった。', NULL, '227FIX.jpg_20160822120752.jpeg'),
(13, 'グラーフ・ツェッペリン', 2, '空母', 1936, 'ドイツ空母の代表格？であり、初の空母だったため建造に2年かかったという。（作り上げたとは言ってない）<br />圧縮空気式のカタパルトや対空用の10.5㎝連装砲、対水上用の15㎝連装砲など飛ばす以外にも<br />充実した装備を持ち合わせている。<br />9割完成したところで建造中止（潜水艦を優先、Uボートつえええ）', NULL, '144898301930025529180_zeppeli7.jpg_20160822121618.jpeg'),
(14, 'ミッドウェイ', 3, '空母', 1945, 'アメリカ空母といえばミッドウェイの名が出てくるのは仕方がないね。<br />1940年から計画されたにも関わらず、完成は戦後の1945年。<br />今までの空母とは一線を画すため、艦種記号はCVにBIGを追加されCVBとなった。<br />1973年より横須賀を母港とし活動していたが、1991年湾岸戦争に参加後退役した。<br />（2番艦の名はルーズベルト‼かっこ良いよね‼）', NULL, 'USS_Midway_CVA-41.jpg_20160822122401.jpeg'),
(15, '古鷹', 1, '巡洋艦', 1926, '私が知っている中で最も美しくカッコイイと評判の古鷹。<br />英米の新型巡洋艦を凌駕する偵察巡洋艦、全てにおいての軽量化に成功。<br />しかし奇抜な設計ゆえに居住性は最悪だったとか（居住性大事‼よくわかんだね‼）<br />1939年に近代化改修され、艦容は青葉に似ている。<br />サボ島沖夜戦で沈没。', NULL, '14_0.11[1].29 ｸﾅﾂ・・｢･・JPG.jpg_20160822123050.jpeg'),
(16, 'プリンツ・オイゲン', 2, '巡洋艦', 1939, 'ドイツ最後の重巡洋艦<br />20.3㎝砲8門、水線部装甲70㎜、最大32ノットと十分な攻防性能を追求したがために<br />基準排水量14050トンを大幅に上回った艦。（頭おかしいね‼）<br />かなりの性能を誇るプリンツあバルト海で活動し生き残った（すごいよね）<br />しかし、戦後アメリカへ引き渡され核実験の標的艦となり沈没', NULL, 'img_0.jpg_20160822123825.jpeg'),
(17, 'クリーブランド', 3, '巡洋艦', 1942, 'ロンドン条約が失効したため自由な設計・建造できるようになり計画された軽巡洋艦<br />ブルックリンの後期型から流用<br />対空特化の巡洋艦である（アメリカの巡洋艦はあまり興味がないんだ、すまない）', NULL, 'uss_columbia.jpg_20160822124520.jpeg'),
(18, '島風', 1, '駆逐艦', 1941, '「おっそーい‼」でも有名なあの島風である<br />なんといっても凄いのはその速力であり、なんと40ノット（早すぎー‼）<br />通常時は75000馬力だが短時間なら79240馬力を発生できた（もはや追いつけないよね）<br />しかし、サイズと排水量が高く大型駆逐艦のため一隻しか建造することが出来なかった（ボッチ...）<br />魚雷発射管は5連装魚雷と日本の駆逐艦としては唯一の例である。', NULL, 'b4cb3f1b.jpg_20160822125209.jpeg'),
(19, 'Z1', 2, '駆逐艦', 1938, 'Z1とも呼ばれるが、1936型駆逐艦とも呼ばれているドイツの駆逐艦<br />1940年ノルウェー海軍と英海軍との交戦で5隻が沈没（6隻建造したから1隻しか怒らず）<br />1940年に建造されたZ3は改良型である', NULL, 'ea23fd40-s.jpg_20160822125815.jpeg'),
(20, 'フレッチャー', 3, '駆逐艦', 1942, 'アイオワに随伴可能な艦隊型駆逐艦として計画され建造されたのがこのフレッチャーである<br />2100トン級の大型駆逐艦', NULL, 'img_3.jpg_20160822130204.jpeg'),
(21, 'aaaaaaaaaaaaaaaaaaaa', 3, '駆逐艦', 1000, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', NULL, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `sim`
--

CREATE TABLE `sim` (
  `ID` int(11) NOT NULL,
  `simService` varchar(20) NOT NULL,
  `charge` float NOT NULL,
  `GB` double(10,1) NOT NULL,
  `comment` text NOT NULL,
  `simOpeID` varchar(255) DEFAULT NULL,
  `SimOpeName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `sim`
--

INSERT INTO `sim` (`ID`, `simService`, `charge`, `GB`, `comment`, `simOpeID`, `SimOpeName`) VALUES
(1, 'マイネオ Dプラン', 1600, 3.0, '音声通話付き3GBシムフリーでベストチョイス。サービス面（1GB無料プレゼント、パケットシェア、誰とでもデータ容量共有ができる、GBの繰越、自宅でMNP切替可能）が他の業者の良い所取りをしている。3GBは価格面で差がつきにくいので、サービス面で選ぼう。\r\n', '1', NULL),
(2, ' LTE・3G – ライトSプラン', 2150, 6.0, 'Wifiスポットが無料で利用できる。3日の通信速度制限（一定の通信料を越すと通信制限がかかる）がない。多少高くてもいいから、6GB使いたい人向け。', '2', NULL),
(3, '通話プラス LTE使い放題プラン', 2980, 100.0, 'LTEが使い放題のプランだが、3日間の通信制限がある。通信制限を超えると、制限後の速度も128kbpsとかなり遅くなる。', '3', NULL),
(4, 'マイネオ Aプラン', 1510, 3.0, 'mineoDとAの違いは、ドコモ回線かAU回線かの違い。現状、ドコモ回線よりも、AU回線の通信速度が早い。サービスはDプランには劣る。', '1', NULL),
(5, '通話SIMプラン', 1260, 1.0, '1GBで最安値を選びたいなら、DMM を選ぼう。一番安い。とはいえ、1GB以外のプランは他社との価格差が少ない。WiiMax持ちで、１GBで使うのが一番いいと思う。', '5', NULL),
(6, '音声通話みおふぉん', 1600, 3.0, 'これを選ぶなら、mioneを選ぼう。通信料は変わらないが、mioneはサービスが充実している。', '6', NULL),
(7, '3.1GBパック', 1600, 3.1, '差別化に失敗したかわいそうなSIM。100MBの違いなど、普通分からない。メリットは、楽天カフェ（渋谷）で即日発行できる。通信速度（200kb）を求めないなら、1250円プランがある。', '7', NULL),
(8, 'モバイル ONE – 音声対応SIM', 1600, 3.3, '一日の通信容量は110MB。1ヶ月で3.3GB使える。他には、スマートフォンで、電話番号が追加取得できる、050plus（月額300円）が無料で使える。', '8', NULL),
(9, '@nifty 音声通話対応SIMカード', 1600, 3.0, 'かけ放題サービス（月額1300円）がある以外、サービス面では他の業者に劣る。通話はラインかスカイプを使えばいいので、あえてこれを使う必要はないかな。', '9', NULL),
(10, '定額無制限プラン 音声通話プラス', 3736, 100.0, '定額無制限、通信制限なしのプラン。3日間10GBなど普通に使える。ネットフリックスやyoutubeをよく見る人にはいいかもしれない。でも、最大通信速度速度が遅いのが難点。後、値段が高い。', '10', NULL),
(11, 'データ＋音声通話プラン', 1680, 3.0, 'AU回線を借りているので、早い。参考サイトによれば、SIMフリーで一番早いとのこと。値段は他の3GBプランと変わらない。速度重視なら、これでいいかもしれない。', '11', NULL),
(12, '使ったぶ～んだけプラン', 800, 0.5, '音声通話SIMでおそらく最安値。サイトを見たが、会社名が不明だった。追加容量500MB毎に500円。2GB利用で月額2300円となるので、500MB以上利用するならやめとこう。', '12', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `simope`
--

CREATE TABLE `simope` (
  `ID` int(11) NOT NULL,
  `simOpeName` varchar(11) NOT NULL,
  `UserID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `simope`
--

INSERT INTO `simope` (`ID`, `simOpeName`, `UserID`) VALUES
(1, 'mineo', ''),
(2, 'BIGLOBE', ''),
(3, 'U-mobile', ''),
(5, 'DMMmobile', ''),
(6, 'IIJmio', ''),
(7, '楽天モバイル', ''),
(8, 'OCN', ''),
(9, '@nifty', ''),
(10, 'ぷららモバイルLTE', ''),
(11, 'UQ mobile', ''),
(12, '@モバイルくん。', '');

-- --------------------------------------------------------

--
-- テーブルの構造 `skylineage`
--

CREATE TABLE `skylineage` (
  `id` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `skylineage`
--

INSERT INTO `skylineage` (`id`, `age`) VALUES
(1, 1950),
(2, 1960),
(3, 1970),
(4, 1980),
(5, 1990),
(6, 2000),
(7, 2010);

-- --------------------------------------------------------

--
-- テーブルの構造 `skylinedata`
--

CREATE TABLE `skylinedata` (
  `id` int(11) NOT NULL,
  `date` int(11) NOT NULL,
  `model` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nickname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ageid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `skylinedata`
--

INSERT INTO `skylinedata` (`id`, `date`, `model`, `nickname`, `ageid`) VALUES
(1, 1957, 'ALSI型', 'プリンス スカイライン', 1),
(2, 1963, 'S50型', '羊の皮を着た狼', 2),
(3, 1968, 'C10型', '愛のスカイライン', 2),
(4, 1972, 'C110型', 'ケンとメリーのスカイライン', 3),
(5, 1977, 'C210型', 'SKYLINE JAPAN', 3),
(6, 1981, 'R30型', 'ニューマン・スカイライン', 4),
(7, 1985, 'R31型', '都市工学-7thスカイライン', 4),
(8, 1989, 'R32型', '超感覚スカイライン', 4),
(9, 1993, 'R33型', '日本のグランドツーリングカーGT9', 5),
(10, 1998, 'R34型', 'DRIVING BODY', 5),
(11, 2001, 'V35型', 'THE PREMIUM SPORTS', 6),
(12, 2006, 'V36型', '日本のクルマに、ときめきが帰ってくる', 6);

-- --------------------------------------------------------

--
-- テーブルの構造 `sneakers`
--

CREATE TABLE `sneakers` (
  `id` int(11) NOT NULL,
  `sneakersMakerId` int(11) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `series` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `maker` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `sneakers`
--

INSERT INTO `sneakers` (`id`, `sneakersMakerId`, `name`, `series`, `year`, `comment`, `maker`, `image`) VALUES
(1, 1, 'AIR HUARACHE', 'NIKE / AIR HUARACHE', 1991, '近年復刻し再び大流行。HUARACHEの語源はメキシコの履物"ハラッチ"から。', 'NIKE', 'assets/images/temp/air_huarache.jpg'),
(2, 2, 'DISC BLAZE', 'PUMA / DISC (TRINOMIC)', 1992, 'アッパーのディスクを回転させることでフィッティング。ハイテクスニーカーブームを牽引。', 'PUMA', 'assets/images/temp/disc_blaze.jpg'),
(3, 3, 'ZX8000', 'adidas / ZX (TORSION,EQUIPMENT)', 1989, 'ZXシリーズの最高傑作。', NULL, 'assets/images/temp/zx8000.jpg'),
(4, 4, 'INSTA PUMP FURY', 'Reebok / PUMP', 1994, 'ポンプで空気を送り込むことでフィッテング。ハイテクスニーカー界の屈指の人気作。', NULL, 'assets/images/temp/pump_fury.jpg'),
(5, 1, 'AIR MAX 1', 'NIKE / AIR MAX', 1987, '記念すべきAIR MAXシリーズ第1号。ハイテクスニーカー時代の幕開け。', NULL, 'assets/images/temp/air_max1.jpg'),
(6, 2, 'suede classic', '-', 1968, 'PUMA不朽の名作。1足以上持っておきたいクラシックスニーカー。', NULL, 'assets/images/temp/puma_suede.jpg'),
(7, 3, 'STAN SMITH', '-', 1973, '世界一売れたスニーカー。名前は同名テニスプレーヤーに由来。', NULL, 'assets/images/temp/stan_smith.jpg'),
(8, 1, 'AIR MAX 90', 'NIKE / AIR MAX', 1990, 'AIR MAXといったらこのモデルをイメージする人も多いはず。シリーズの代表作。', NULL, 'assets/images/temp/air_max90.jpg'),
(9, 5, 'ERA', '-', 1975, 'VANSの名作。スケーター向けのクラシックスニーカー。', NULL, 'assets/images/temp/era.jpg'),
(10, 1, 'AIR MAX 95', 'NIKE / AIR MAX', 1995, 'AIR MAXシリーズの中で根強い人気を誇る。', NULL, 'assets/images/temp/air_max95.jpg'),
(11, 7, 'ALL STAR Hi', 'CONVERSE / ALL STAR', 1917, '1917年発売。スニーカーの歴史はここから始まった。', NULL, 'assets/images/temp/allstar_hi.jpg'),
(12, 6, 'M996', '-', 1989, '歩き易い、履き易い、合わせ易い三拍子揃った美しいスニーカー。', NULL, 'assets/images/temp/nb_m996.jpg'),
(13, 7, 'ALL STAR OX', 'CONVERSE / ALL STAR', 1957, 'ALL STARのローカットモデル。CONVERSEといえばこれと言えるほど色褪せない名スニーカー。', NULL, 'assets/images/temp/allstar_ox.jpg'),
(14, 1, 'AIR FORCE 1', 'NIKE / AIR FORCE', 1982, 'スニーカーの王様。', NULL, 'assets/images/temp/airforce_1.jpg'),
(15, 1, 'CORTEZ', '-', 1972, 'NIKEのクラシックランニングシューズ。ナイロン製やレザー製などがある。読み方は「コルテッツ」', NULL, 'assets/images/temp/cortez.jpg'),
(16, 3, 'SUPERSTAR', '-', 1969, '「RUN DMC」が愛用。これを紐無しで履いている奴はかなりコアなHIPHOPファン。', NULL, 'assets/images/temp/superstar.jpg'),
(17, 5, 'OLD SKOOL', '-', 1978, '元はBMXライダーの為に作られたがスケーターから支持を集める。', NULL, 'assets/images/temp/oldskool.jpg'),
(18, 1, 'AIR HUARACHE LIGHT', 'NIKE / AIR HUARACHE', 1993, 'アッパー部分の網目が特徴。初代ハラチに劣らない人気作。', NULL, 'assets/images/temp/air_huarache_light.jpg'),
(19, 8, 'GEL-LYTE Ⅲ', 'ASICS / GEL', 1990, '国内最高メーカー"ASICS"の名作。海外からも高い評価。', NULL, 'assets/images/temp/gel_lyte3.jpg'),
(20, 4, 'VENTILATOR', '-', 1990, '機能性とデザイン性を兼ね備えたReebokのランニングシューズ。', NULL, 'assets/images/temp/ventilator.jpg'),
(21, 3, 'CAMPUS', '-', 1983, '「ビースティ・ボーイズ」が愛用したことで有名なadidasのローテクスニーカー。', NULL, 'assets/images/temp/campus.jpg'),
(22, 1, 'AIR ZOOM FRIGHT 96', 'NIKE / AIR ZOOM (FRIGHT)', 1996, '96年発売のハイテクバスケットボールシューズ。', NULL, 'assets/images/temp/air_zoom_fright.jpg'),
(23, 1, 'AIR MORE UPTEMPO', 'NIKE / AIR', 1996, 'サイドの「AIR」ロゴのインパクトが絶大。新作発売日に抽選でも買えないほどの人気作。', NULL, 'assets/images/temp/air_more_uptempo.jpg'),
(24, 1, 'AIR MAX 93', 'NIKE / AIR MAX (HUARACHE)', 1993, 'AIR MAXシリーズの93年モデル。270度のビジブルエアとハラチシステムが特徴。', NULL, 'assets/images/temp/air_max93.jpg'),
(25, 3, 'ZX500', 'adidas / ZX', 1984, 'adidasZXシリーズの第1号。当時のランニングシューズ界を牽引。', NULL, 'assets/images/temp/zx500.jpg'),
(26, 5, 'authentic', '-', 1966, 'VANS設立時に誕生。後のVANSの名作「ERA」の前身。ERAとの違いは履き口のパット部分。', NULL, 'assets/images/temp/authentic.jpg'),
(27, 3, 'ZX700', 'adidas / ZX', 1985, 'ZXシリーズの隠れた人気作。', NULL, 'assets/images/temp/zx700.jpg'),
(28, 6, 'M1400', '-', 1994, 'NBの最高傑作。元々高価格だがメイドインUSAだと更に高値。', NULL, 'assets/images/temp/nb_m1400.jpg\r\n'),
(29, 4, 'PUMP GRAPHLITE', 'Reebok / PUMP', 1992, '「INSTA PUNP FURY」のシューレース版。色鮮やかな配色が特徴。', NULL, 'assets/images/temp/pump_graphlite.jpg'),
(30, 3, 'GAZELLE	', '-', 1968, '細身のシルエットが特徴のadidasのクラシックスニーカー。読み方は「ガッツレー」', NULL, 'assets/images/temp/gazelle.jpg'),
(31, 2, 'R698	', 'PUMA / TRINOMIC', 1990, 'PUMAのクッションシステム「TRINOMIC」を搭載した。ミッドテクランニングシューズ。', NULL, 'assets/images/temp/r698.jpg'),
(42, 3, 'TORSION ALLEGRA', 'adidas / EQUIPMENT (TORSION)', 1992, 'adidasのクッション技術「TORSION」搭載。発売当時ランニングシューズにしてはデザインが近未来的と話題に。', NULL, 'assets/images/temp/torsion_allegra.jpg'),
(43, 5, 'SLIP ON', '-', 1979, '「靴紐なしで脱ぎ履きできる靴＝スリッポン」というように代名詞化しているがそのオリジナルモデルは79年にVANSが発売したこの「SLIP ON」', NULL, 'assets/images/temp/slipon.jpg');

-- --------------------------------------------------------

--
-- テーブルの構造 `sneakersmaker`
--

CREATE TABLE `sneakersmaker` (
  `id` int(11) NOT NULL,
  `maker` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `sneakersmaker`
--

INSERT INTO `sneakersmaker` (`id`, `maker`) VALUES
(1, 'NIKE'),
(2, 'PUMA'),
(3, 'adidas'),
(4, 'Reebok'),
(5, 'VANS'),
(6, 'NEW BALANCE'),
(7, 'CONVERSE'),
(8, 'ASICS(ASICS Tiger)');

-- --------------------------------------------------------

--
-- テーブルの構造 `tabaco`
--

CREATE TABLE `tabaco` (
  `id` int(11) NOT NULL,
  `tabacoAreaId` int(11) DEFAULT NULL,
  `namephoto` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nicotine` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- テーブルのデータのダンプ `tabaco`
--

INSERT INTO `tabaco` (`id`, `tabacoAreaId`, `namephoto`, `name`, `tar`, `nicotine`, `price`, `comment`, `area`) VALUES
(1, 1, 'm-2920.jpg', 'マールボロ', '12mg', '1mg', '460円', '男のたばこ', NULL),
(2, 2, 'A5165_I1.jpg', 'セブンスター', '14mg', '1.2mg', '460円', 'チャコールフィルター', NULL),
(3, 1, 'm-4145.jpg', 'アイスブラスト・メガ・８・ボックス', '8mg', '0.6mg', '460円', '日本最大級のメガカプセル', NULL),
(4, 2, 'm-1626.jpg', 'メンソール･5･ボックス', '5mg', '0.5mg', '460円', '少し甘いメンソールらしい', NULL),
(5, 3, 'm-1023.jpg', 'メビウス', '10mg', '0.8mg', '440円', '迷ったらこれ！！！', NULL),
(6, 3, 'm-1688.jpg', 'プレミアムメンソール・オプション５', '5mg', '0.5mg', '440円', 'カプセルつぶすと香りが豊か', NULL),
(7, 4, 'm-1200.jpg', 'キャスターホワイト・５', '5mg', '0.4mg', '420円', 'バニラの香りが心地いい？', NULL),
(8, 4, 'm-1197.jpg', 'キャビン・レッド・8・ボックス', '8mg', '0.7mg', '420円', 'キャビンといえばこれでしょ！！！', NULL),
(9, 5, 'l-2563.jpg', 'ｋｓ・ボックス', '12mg', '1mg', '420円', 'ほんの少しチョコレートの味した？', NULL),
(10, 5, 'l-4328.jpg', 'アイス・ミント・5mg100ボックス', '5mg', '0.3mg', '420円', 'ラークがチョコだからチョコミントの味？？', NULL),
(11, 1, '240_320.jpg', 'なにこいつ', '2000mg', '2000mg', '20000円', 'なにこいつ', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `tabacoarea`
--

CREATE TABLE `tabacoarea` (
  `id` int(11) NOT NULL,
  `area` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `tabacoarea`
--

INSERT INTO `tabacoarea` (`id`, `area`) VALUES
(1, 'マルボロ'),
(2, 'セブンスター'),
(3, 'メビウス'),
(4, 'ウィンストン'),
(5, 'ラーク');

-- --------------------------------------------------------

--
-- テーブルの構造 `team`
--

CREATE TABLE `team` (
  `ID` int(11) NOT NULL,
  `teamname` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `team`
--

INSERT INTO `team` (`ID`, `teamname`) VALUES
(1, 'グルージャ盛岡'),
(2, 'ブラウブリッツ秋田'),
(3, '福島ユナイテッドFC'),
(4, '栃木S.C'),
(5, 'Y.S.C.C.横浜'),
(6, 'SC相模原'),
(7, 'AC長野パルセイロ'),
(8, 'カターレ富山'),
(9, '藤枝MYFC'),
(10, 'ガイナーレ鳥取'),
(11, '大分トリニータ'),
(12, '鹿児島ユナイテッドFC'),
(13, 'FC琉球'),
(14, 'FC東京U-23'),
(15, 'ガンバ大阪U-23'),
(16, 'セレッソ大阪U-23');

-- --------------------------------------------------------

--
-- テーブルの構造 `ths`
--

CREATE TABLE `ths` (
  `id` int(11) NOT NULL,
  `thssubjectID` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `level` varchar(10) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `subject` varchar(10) DEFAULT NULL,
  `link` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `ths`
--

INSERT INTO `ths` (`id`, `thssubjectID`, `name`, `level`, `comment`, `subject`, `link`) VALUES
(1, 1, '今井宏', '普通', '予備校界の大物講師。ズバリ的を射たフシギなほどわかる授業、心地よいスピード感と豊富な話題、あふれる知識で、受講生を魅了する。「何でこんなによく理解できるの？」という驚きでいっぱい。生徒の充実感は200%。成績アップはもちろん、英語にとどまらない話題豊富な授業内容に、君の見識が広がること間違いナシ。（東進HP引用）', NULL, 'http://www.toshin.com/teacher/detail.php?teacher_id=1'),
(2, 1, '安河内哲也', '基礎', '「基礎から偏差値アップ」「有名大突破！」という超人気講座の名前どおり、数えきれないほどの受験生の偏差値を大改造、難関大へと送り込んでいる！授業は「英語が楽しくなる」と全レベルの受験生に大評判。（東進HP引用）', NULL, 'http://www.toshin.com/teacher/detail.php?teacher_id=8'),
(3, 2, '志田晶', '応用', '東大、京大をはじめとする難関大合格へ受講者を導いた数学科実力講師は、わかりやすさを徹底的に追求する。「数学的な考え方」を身につける授業で、今まで何気なく使っていた公式や解法の一つ一つが、意味を伴った強力な武器となる。（東進HP引用）', NULL, 'http://www.toshin.com/teacher/detail.php?teacher_id=61'),
(4, 3, '林修', '応用', '入試問題を研究し尽くした講義は、東大受験生から大絶賛。正統的解法の徹底追求で、分析的かつシステマティックに得点力、そして「考える力」を増強させてくれる。先生の博識に支えられたトークも人気で受講生に大きな勇気を与える。「いつやるか、今でしょ！」の名セリフはあまりにも有名。（東進HP引用）', NULL, 'http://www.toshin.com/teacher/detail.php?teacher_id=26'),
(5, 2, '大吉巧馬', '普通', 'インパクトのある明解かつ丁寧な講義で、数多くの受験生を救ってきた救世主。どんな生徒でも「わからない」から「わかる」に大変貌させ、知的好奇心を刺激する講義を展開。毎年多くの受験生を第一志望校へと導く。公式や定理の暗記では終わらない本質をついた講義で、数学のおもしろさが発見できる!!（東進HP引用）', NULL, 'http://www.toshin.com/teacher/detail.php?teacher_id=66'),
(7, 3, '板野博行', '普通', 'ムダがなく、誰が聞いてもわかる授業を展開すること。受験指導のプロとして受験生を鍛え上げること。そして何よりもやる気にさせること。そのためのノウハウを惜しまず、全力で皆さんに提供します。（東進HP引用）', NULL, 'http://www.toshin.com/teacher/detail.php?teacher_id=19');

-- --------------------------------------------------------

--
-- テーブルの構造 `thssubject`
--

CREATE TABLE `thssubject` (
  `id` int(11) NOT NULL,
  `subject` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `thssubject`
--

INSERT INTO `thssubject` (`id`, `subject`) VALUES
(1, '英語'),
(2, '数学'),
(3, '国語');

-- --------------------------------------------------------

--
-- テーブルの構造 `title`
--

CREATE TABLE `title` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `delete_flag` tinyint(1) DEFAULT NULL,
  `exclusive_flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `title`
--

INSERT INTO `title` (`id`, `name`, `release_date`, `create_date`, `create_user`, `update_date`, `update_user`, `delete_flag`, `exclusive_flag`) VALUES
(1, '夢の泉の物語', '1993-03-23', '2017-04-17 00:00:00', 'struts2', NULL, NULL, 0, 0),
(2, 'スーパーデラックス', '1996-03-21', '2017-04-17 00:00:00', 'struts2', NULL, NULL, 0, 0),
(3, '星のカービィ2', '1995-03-21', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(4, '星のカービィ3', '1998-03-27', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(5, '星のカービィ64', '2000-03-24', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(6, '鏡の大迷宮', '2004-04-15', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(7, 'タッチ！カービィ', '2005-03-24', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(8, '参上！ドロッチェ団', '2006-11-02', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(9, '星のカービィWii', '2011-10-27', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(10, 'トリプルデラックス', '2014-01-11', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0),
(11, 'ロボボプラネット', '2016-04-28', '2017-04-20 00:00:00', 'struts2', NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `yokai`
--

CREATE TABLE `yokai` (
  `id` int(11) NOT NULL,
  `yokaifromId` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `link` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `yokaifrom` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `yokai`
--

INSERT INTO `yokai` (`id`, `yokaifromId`, `name`, `type`, `comment`, `link`, `yokaifrom`) VALUES
(1, 1, '鬼太郎', '無害', 'ゲゲゲの鬼太郎', NULL, NULL),
(2, 1, '鬼太郎', '無害', 'かつて地上を支配していた幽霊族の唯一の末裔（原作「地獄篇」とアニメ第3作地獄篇のみ、幽霊族の父と人間の母との混血）。\r\n\r\n幽霊族とは人間が一般に考えている幽霊（人間の死霊）ではなく、人類誕生以前に栄えていた種族であり、糧を求めて地上をさまよう姿を目撃した人間が幽霊と誤認した。争いを好まない性格でそれ故に人類が発生、繁殖すると共に迫害され森の奥へ、次いで地下へと追いやられ衰退していった。「続ゲゲゲの鬼太郎」の目玉おやじの話によると、紀元前3800年頃には鬼太郎父子の先祖は幽霊族の帝位に就いていたという。\r', 'https://www.bing.com/images/search?q=%e9%ac%bc%e5%a4%aa%e9%83%8e&view=detailv2&&id=2A1D93261224761651AB5458CF651D8FD4BDDFAC&selectedIndex=16&ccid=YZ1rBimt&simid=608042236381563449&thid=OIP.M619d6b0629adc14c578d0f341b22dcc1o0&ajaxhist=0', NULL),
(3, 1, '猫娘', '無害', '普段は人間の少女の姿だが、ネズミ（ねずみ男を含む）や魚を見たり怒ったりして興奮すると、眼が金色に染まり、裂けた口に鋭い牙をむきだした猫の形相になる。魚、鰹節、ネズミが大好物[1]。鬼太郎・目玉おやじ・ねずみ男同様に、水木しげるが創作したキャラクターでありつつ妖怪としても認知されている。鬼太郎にしおらしい恋心を抱いている。アニメ第5作から「ゲゲゲの鬼太郎」と「ビビビのねずみ男」に対して「ニャニャニャのネコ娘」という通称ができた。', 'https://www.bing.com/images/search?q=%e7%8c%ab%e5%a8%98&view=detailv2&&id=66BDDDF7506BAE5AEEE881BBB84269FDBD95661F&selectedIndex=22&ccid=14Xq34lH&simid=608009311151456707&thid=OIP.Md785eadf89472c326d664a43d5f60657o0&ajaxhist=0', NULL),
(4, 1, 'オカリナ', '無害', 'すごくブサイク', 'https://www.bing.com/images/search?q=%E3%82%AA%E3%82%AB%E3%83%AA%E3%83%8A%20%E8%8A%B8%E4%BA%BA&qs=AS&form=QBIR&pq=%E3%82%AA%E3%82%AB%E3%83%AA%E3%83%8A&sc=8-4&sp=1&sk=', NULL),
(5, 2, 'バックベアード', '危険', '西洋妖怪の総大将。アメリカの妖怪で、黒い球体に巨大な一つ目と多数の触手を備えた姿をしている。その巨大な目を見るだけで強力な催眠術にかかり、ベアードの言いなりになってしまう。他にも、目眩を引き起こしたり、強烈な眼光で目を眩ませたり、', 'https://www.bing.com/images/search?q=%E3%83%90%E3%83%83%E3%82%AF%E3%83%99%E3%82%A2%E3%83%BC%E3%83%89&qs=n&form=QBIDMH&pq=%E3%83%90%E3%83%83%E3%82%AF%E3%83%99%E3%82%A2%E3%83%BC%E3%83%89&sc=8-7&sp=-1&sk=', NULL),
(6, 2, 'ゾンビ', '危険', '　一般的なゾンビは、上記の通り動きが緩慢だが、大抵の場合、個体数が非常に多く、上記のように凶暴化しているため、生者を見付けると群れをなして襲い掛かる。ただし、知性を備えた個体は少なく、大体は原始的かつ物理的な方法で、生者を追いかける。 \r\n 　嗅覚に関しては、自分たちの腐敗臭のために機能していないことが多いが、視覚や聴覚は生きている可能性が高く、音や光が原因で近寄ってきたり、音や光を発する道具で気を散らすことが出来るケースも多い。 ', 'https://www.bing.com/images/search?q=%E3%82%BE%E3%83%B3%E3%83%93&qs=n&form=QBIR&pq=%E3%82%BE%E3%83%B3%E3%83%93&sc=8-3&sp=-1&sk=', NULL),
(7, 3, 'ドラゴン', '危険', 'ドラゴンは鱗に覆われた爬虫類を思わせる体、鋭い爪と牙を具え、しばしば口や鼻から炎や毒の息を吐く[8][9]。典型的なドラゴンは有翼で空を飛ぶことができるが、地を這う大蛇（サーペント）のような怪物もドラゴンに分類され、とくにゲルマン系の伝説ではしばしば地下の洞穴をすみかとしている。体色は緑色、黄金色、真紅、漆黒、濃青色[† 3]、白色[† 4]などさまざまである[10][† 5]。ドラゴンは炎を吐き、蛇の尾、鳥の翼と魚の鱗を有するハイブリッドな動物であり、四大元素を体現する存在でもあった。', 'https://www.bing.com/images/search?q=%E3%83%89%E3%83%A9%E3%82%B4%E3%83%B3&qs=n&form=QBIR&pq=%E3%83%89%E3%83%A9%E3%82%B4%E3%83%B3&sc=8-4&sp=-1&sk=', NULL),
(8, 4, 'キョンシー', '無害', 'もともと中国においては、人が死んで埋葬する前に室内に安置しておくと、夜になって突然動きだし、人を驚かすことがあると昔から言われていた。それが僵尸（殭屍）である。「僵」という漢字は死体（＝尸）が硬直すると言う意味で、動いても、人に知られたり、何かの拍子ですぐまた元のように体がこわばることから名付けられた[1]。', 'https://www.bing.com/images/search?q=%E3%82%AD%E3%83%A7%E3%83%B3%E3%82%B7%E3%83%BC&qs=n&form=QBIR&pq=%E3%82%AD%E3%83%A7%E3%83%B3%E3%82%B7%E3%83%BC&sc=8-5&sp=-1&sk=', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `yokaifrom`
--

CREATE TABLE `yokaifrom` (
  `id` int(10) NOT NULL,
  `yokaifrom` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- テーブルのデータのダンプ `yokaifrom`
--

INSERT INTO `yokaifrom` (`id`, `yokaifrom`) VALUES
(1, '日本'),
(2, 'アメリカ'),
(3, 'ヨーロッパ'),
(4, 'その他');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `catfrom`
--
ALTER TABLE `catfrom`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `catinfo`
--
ALTER TABLE `catinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chocolate`
--
ALTER TABLE `chocolate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `copy`
--
ALTER TABLE `copy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2EAF756D106BE4` (`title_id`);

--
-- Indexes for table `eventstage`
--
ALTER TABLE `eventstage`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `maiwaifu`
--
ALTER TABLE `maiwaifu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `maiwaifuarea`
--
ALTER TABLE `maiwaifuarea`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `megane`
--
ALTER TABLE `megane`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nail`
--
ALTER TABLE `nail`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `norris`
--
ALTER TABLE `norris`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ozakialbum`
--
ALTER TABLE `ozakialbum`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ozakisong`
--
ALTER TABLE `ozakisong`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `potatomaker`
--
ALTER TABLE `potatomaker`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `potatoproduct`
--
ALTER TABLE `potatoproduct`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `galgamemaker`
--
ALTER TABLE `galgamemaker`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `galgameproduct`
--
ALTER TABLE `galgameproduct`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `guraburu_character_info`
--
ALTER TABLE `guraburu_character_info`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `skylineage`
--
ALTER TABLE `skylineage`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skylinedata`
--
ALTER TABLE `skylinedata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabaco`
--
ALTER TABLE `tabaco`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabacoarea`
--
ALTER TABLE `tabacoarea`
  ADD UNIQUE KEY `ID` (`id`);

--
-- Indexes for table `title`
--
ALTER TABLE `title`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `catinfo`
--
ALTER TABLE `catinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `chocolate`
--
ALTER TABLE `chocolate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `copy`
--
ALTER TABLE `copy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT for table `eventstage`
--
ALTER TABLE `eventstage`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `maiwaifu`
--
ALTER TABLE `maiwaifu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `maiwaifuarea`
--
ALTER TABLE `maiwaifuarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `megane`
--
ALTER TABLE `megane`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;
--
-- AUTO_INCREMENT for table `nail`
--
ALTER TABLE `nail`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `norris`
--
ALTER TABLE `norris`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `ozakisong`
--
ALTER TABLE `ozakisong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;
--
-- AUTO_INCREMENT for table `potatoproduct`
--
ALTER TABLE `potatoproduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `galgameproduct`
--
ALTER TABLE `galgameproduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `skylinedata`
--
ALTER TABLE `skylinedata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `tabaco`
--
ALTER TABLE `tabaco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `guraburu_character_info`
--
ALTER TABLE `guraburu_character_info`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

  --
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `FK2EAF756D106BE4` FOREIGN KEY (`title_id`) REFERENCES `title` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
