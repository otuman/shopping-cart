-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2018 at 05:56 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopping_cart`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `username` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `role_id`, `username`, `password`, `enabled`) VALUES
(1, 1, 'otoman@hotmail.com', '12345', 1),
(2, 1, 'test@hotmail.com', '12345', 1);

-- --------------------------------------------------------

--
-- Table structure for table `attributes`
--

CREATE TABLE `attributes` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `parent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `parent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE `media` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `size` int(11) NOT NULL,
  `src` text COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `absolutePath` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `media`
--

INSERT INTO `media` (`id`, `title`, `description`, `size`, `src`, `type`, `absolutePath`) VALUES
(1, 'otuman_godfrey_nkomanya.png', '', 1461688, '/shopping-cart/resources/uploads/products/otuman_godfrey_nkomanya.png', 'image/png', 'F:\\Projects\\javaee\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\shopping-cart\\resources\\uploads\\products\\otuman_godfrey_nkomanya.png'),
(2, 'otuman_godfrey_nkomanya.png', '', 1461688, '/shopping-cart/resources/uploads/products/otuman_godfrey_nkomanya.png', 'image/png', 'F:\\Projects\\javaee\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\shopping-cart\\resources\\uploads\\products\\otuman_godfrey_nkomanya.png');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `price` float NOT NULL,
  `quantity` int(11) NOT NULL,
  `created_on` datetime NOT NULL,
  `updated_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`, `quantity`, `created_on`, `updated_on`) VALUES
(1, 'Test', 'Thank you so much', 45, 2, '2017-12-20 16:22:14', '2017-12-20 16:22:14'),
(2, 'Test', 'Thank you so much', 45, 2, '2017-12-20 16:23:12', '2017-12-20 16:23:12'),
(3, 'Test', 'Thank you so much', 45, 2, '2017-12-20 16:23:20', '2017-12-20 16:23:20'),
(4, 'In hendrerit gravida rutrum quisque', '2wwwc dggdgff ghffgjtg', 12, 232, '2018-02-19 11:51:21', '2018-02-19 11:51:21'),
(5, 'In hendrerit gravida rutrum quisque', '2wwwc dggdgff ghffgjtg', 12, 232, '2018-02-19 11:53:16', '2018-02-19 11:53:16');

-- --------------------------------------------------------

--
-- Table structure for table `product_media`
--

CREATE TABLE `product_media` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `media_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product_media`
--

INSERT INTO `product_media` (`id`, `product_id`, `media_id`) VALUES
(1, 5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `display_name` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `created_on` datetime NOT NULL,
  `update_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`, `display_name`, `created_on`, `update_on`) VALUES
(1, 'ROLE_USER', 'USER', '2017-12-14 10:00:00', '2017-12-14 10:00:00'),
(2, 'ROLE_ADMIN', 'ADMIN', '2017-12-14 10:00:00', '2017-12-14 10:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `username` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `first_name` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `created_on` datetime NOT NULL,
  `updated_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `role_id`, `username`, `password`, `enabled`, `first_name`, `last_name`, `created_on`, `updated_on`) VALUES
(1, 1, 'otomang@hotmail.com', '$2a$10$U7UVzwzqLA5HiyKhLhg2sOj94mUiJmu8dK2fOPmcmbWjPSWQVtgBi', 1, 'Otoman', 'Nkomanya', '2018-02-18 22:56:51', '2018-02-18 22:56:51'),
(2, 1, 'taylorjohn@gmail.com', '$2a$10$RCerdSDrBGu.H5qY1BTF9OyWR89rlNIs4vZ8UHHpU0X5YRf1/yzWe', 1, 'Taylor', 'John', '2018-02-18 23:10:17', '2018-02-18 23:10:17'),
(3, 1, 'hayma@gmail.com', '$2a$10$G0R2mMxUASkzkT2bd9oqJOg8bQj2PbBn3FdwsXWODxo.bNUQ1I9YK', 1, 'Hayma', 'Joy', '2018-02-18 23:12:38', '2018-02-18 23:12:38'),
(4, 1, 'assante@hotmail.com', '$2a$10$M7HLoI.Uxi8AxAQMZOnT5.PjmEi9vtCwE7B9XyNAiIy6J2AJ/IAcG', 1, 'Otoman', 'Nkomanya', '2018-02-18 23:15:41', '2018-02-18 23:15:41'),
(5, 1, 'assantqe@hotmail.com', '$2a$10$Msxlg5jLFMiat73MHfb8x.piVKklfdREnujKYB9XeYH3Rp2OcZ3KO', 1, 'Otoman', 'Nkomanya', '2018-02-18 23:21:56', '2018-02-18 23:21:56'),
(6, 1, 'joelygw@hotmail.com', '$2a$10$IgwKbZShzZkXHYftrAcwaON6UMjJiK3Qgij8VSurXnfHaYUqTkIWa', 1, 'Das', 'Las', '2018-02-18 23:24:08', '2018-02-18 23:24:08'),
(7, 1, 'haymda@gmail.com', '$2a$10$xfBXWSTZFk8Dich7nWZeAeHgpsT3jWnoGGJzmtuOJBJpsTLg9kLfq', 1, 'Hayma', 'Joy', '2018-02-18 23:28:20', '2018-02-18 23:28:20'),
(8, 1, 'oeoeoe@hfdhh.com', '$2a$10$GbdHwpS6lTq4QTRIB3g7Z.bgvAh2/612TvOhIIhmEY8DtLADmZ4MO', 1, 'asa', 'aasassa', '2018-02-18 23:44:30', '2018-02-18 23:44:30'),
(9, 1, 'oeoeowwe@hfdhh.com', '$2a$10$RQDmNr6xZtGD1ZXjpAf3ieAoMJ2fSppcMliUexni4Ap59cKFqADZK', 1, 'asa', 'aasassa', '2018-02-18 23:53:34', '2018-02-18 23:53:34'),
(10, 1, 'oeoeowswe@hfdhh.com', '$2a$10$bmDweZcoW4o7wRyz6tuzguobK7RnDVRIG31jgsCxLJsSBsJ13JVpa', 1, 'asa', 'aasassa', '2018-02-18 23:58:52', '2018-02-18 23:58:52'),
(11, 1, 'oeoeowssswe@hfdhh.com', '$2a$10$LYa.cHUZxcWmSg6Zvad3QOhs5IW2.BmZ/TnseXZlB1vAbEZt9vbp2', 1, 'asa', 'aasassa', '2018-02-19 00:02:43', '2018-02-19 00:02:43'),
(12, 1, 'oeqoeowssswe@hfdhh.com', '$2a$10$1kMlO0lcG2YpGu36BxZgLOlgGs5W9gQgBPWAOqkSOttaaSN7b5flS', 1, 'asa', 'aasassa', '2018-02-19 00:08:44', '2018-02-19 00:08:44');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_media`
--
ALTER TABLE `product_media`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product_media`
--
ALTER TABLE `product_media`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
