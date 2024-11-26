-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 26, 2024 at 03:51 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lockerusu`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `NIP` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`NIP`, `nama`, `email`, `password`) VALUES
('1231402001', 'Brisbane', 'brisbane@gmail.com', 'brisbane123');

-- --------------------------------------------------------

--
-- Table structure for table `locker`
--

CREATE TABLE `locker` (
  `id` int NOT NULL,
  `nim` varchar(20) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `waktu_sisa` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `locker`
--

INSERT INTO `locker` (`id`, `nim`, `status`, `waktu_sisa`) VALUES
(1, NULL, 0, NULL),
(2, NULL, 0, NULL),
(3, NULL, 0, NULL),
(4, NULL, 0, NULL),
(5, NULL, 0, NULL),
(6, NULL, 0, NULL),
(7, NULL, 0, NULL),
(8, NULL, 0, NULL),
(9, NULL, 0, NULL),
(10, NULL, 0, NULL),
(11, NULL, 0, NULL),
(12, NULL, 0, NULL),
(13, NULL, 0, NULL),
(14, NULL, 0, NULL),
(15, NULL, 0, NULL),
(16, NULL, 0, NULL),
(17, NULL, 0, NULL),
(18, NULL, 0, NULL),
(19, NULL, 0, NULL),
(20, NULL, 0, NULL),
(21, NULL, 0, NULL),
(22, NULL, 0, NULL),
(23, NULL, 0, NULL),
(24, NULL, 0, NULL),
(25, NULL, 0, NULL),
(26, NULL, 0, NULL),
(27, NULL, 0, NULL),
(28, NULL, 0, NULL),
(29, NULL, 0, NULL),
(30, NULL, 0, NULL),
(31, NULL, 0, NULL),
(32, NULL, 0, NULL),
(33, NULL, 0, NULL),
(34, NULL, 0, NULL),
(35, NULL, 0, NULL),
(36, NULL, 0, NULL),
(37, NULL, 0, NULL),
(38, NULL, 0, NULL),
(39, NULL, 0, NULL),
(40, NULL, 0, NULL),
(41, NULL, 0, NULL),
(42, NULL, 0, NULL),
(43, NULL, 0, NULL),
(44, NULL, 0, NULL),
(45, NULL, 0, NULL),
(46, NULL, 0, NULL),
(47, NULL, 0, NULL),
(48, NULL, 0, NULL),
(49, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `locker_history`
--

CREATE TABLE `locker_history` (
  `id` int NOT NULL,
  `NIM_user` varchar(9) NOT NULL,
  `locker_id` int NOT NULL,
  `durasi` time NOT NULL,
  `waktu_mulai` timestamp NOT NULL,
  `waktu_selesai` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `locker_history`
--

INSERT INTO `locker_history` (`id`, `NIM_user`, `locker_id`, `durasi`, `waktu_mulai`, `waktu_selesai`) VALUES
(1, '231402003', 1, '00:01:00', '2024-11-25 11:36:55', '2024-11-25 11:37:55'),
(3, '231402003', 1, '00:01:00', '2024-11-25 14:27:57', '2024-11-25 14:28:57'),
(4, '231402003', 1, '00:01:00', '2024-11-26 02:23:17', '2024-11-26 02:24:17'),
(5, '231402003', 1, '00:01:00', '2024-11-26 02:26:06', '2024-11-26 02:27:06'),
(6, '231402003', 1, '00:01:00', '2024-11-26 03:04:11', '2024-11-26 03:05:11'),
(7, '231402003', 1, '00:01:00', '2024-11-26 03:08:17', '2024-11-26 03:09:17'),
(8, '231402003', 1, '00:01:00', '2024-11-26 03:10:26', '2024-11-26 03:11:26'),
(9, '231402003', 1, '00:01:00', '2024-11-26 03:17:12', '2024-11-26 03:18:12'),
(11, '231402003', 1, '00:01:00', '2024-11-26 03:20:30', '2024-11-26 03:21:30'),
(12, '231402117', 40, '00:02:00', '2024-11-26 03:20:42', '2024-11-26 03:22:42'),
(14, '231402001', 1, '00:01:00', '2024-11-26 03:29:01', '2024-11-26 03:30:01');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `NIM` varchar(9) NOT NULL,
  `nama` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`NIM`, `nama`, `password`, `email`) VALUES
('231402003', 'Putera Nami Shiddieqy', 'nami1234', 'puteranami1150@gmail.com'),
('231402117', 'Abyan Khairi', 'Aabyan123', 'Abyan@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`NIP`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `locker`
--
ALTER TABLE `locker`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `locker_history`
--
ALTER TABLE `locker_history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `NIM_user` (`NIM_user`),
  ADD KEY `IDLocker` (`locker_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`NIM`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `locker`
--
ALTER TABLE `locker`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `locker_history`
--
ALTER TABLE `locker_history`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `locker_history`
--
ALTER TABLE `locker_history`
  ADD CONSTRAINT `IDLocker` FOREIGN KEY (`locker_id`) REFERENCES `locker` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
