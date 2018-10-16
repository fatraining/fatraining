-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 
-- サーバのバージョン： 10.1.36-MariaDB
-- PHP Version: 7.2.10

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

--
-- Table structure for table `magazine_genre_kawamae`
--

CREATE TABLE `magazine_genre_kawamae`
(
  `id` int(11)  NOT NULL PRIMARY KEY,
  `genre` varchar(256) NOT NULL ,
  `del_flg` varchar(1),
  `create_date` datetime NOT NULL ,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
--
-- Table structure for table `magazine_main_kawamae`
--

CREATE TABLE `magazine_main_kawamae` (
  `id` int(11)  NOT NULL PRIMARY KEY,
  `magazine_name` varchar(256) NOT NULL,
  `genre_id` int(11)  , 
  `saled_number` int(11),
  `del_flg` varchar(1),
  `create_date` datetime NOT NULL ,
  `update_date` datetime NOT NULL ,
  FOREIGN KEY  (genre_id)
  REFERENCES magazine_genre_kawamae(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `magazine_genre_kawamae`
--

INSERT INTO `magazine_genre_kawamae` (`id`, `genre`, `del_flg`, `create_date`, `update_date`) VALUES
( 0,'','0','2018/10/01 00:00','2018/10/01 00:00'),
( 1,'映画','0','2018/10/01 00:00','2018/10/01 00:00'),
( 2,'音楽','0','2018/10/01 00:00','2018/10/01 00:00'),
( 3,'スポーツ','0','2018/10/01 00:00','2018/10/01 00:00'),
( 4,'ゲーム','0','2018/10/01 00:00','2018/10/01 00:00');
--
-- Dumping data for table `magazine_main_kawamae`
--

INSERT INTO `magazine_main_kawamae` (`id`, `magazine_name`, `genre_id`, `saled_number`, `del_flg`, `create_date`, `update_date`) VALUES
( 1,'ニューズウィーク',1,10000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 2,'映画秘宝',1,50000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 3,'CUT',1,2000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 4,'SCREEN',1,800000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 5,'B-PASS',2,2000000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 6,'jazzlife',2,10000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 7,'カラオケファン',2,50000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 8,'ナンバー',3,2000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 9,'週刊ゴルフ',3,800000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 10,'auto suport',3,2000000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 11,'ファミ通',4,800000,'0','2018/10/01 00:00','2018/10/01 00:00'),
( 12,'PlayStation',4,2000000,'0','2018/10/01 00:00','2018/10/01 00:00');

--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
