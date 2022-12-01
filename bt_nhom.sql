-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 01, 2022 lúc 04:53 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bt_nhom`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` varchar(8) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `type`) VALUES
('AD01', 'admin01', 'admin01', 'admin'),
('AD02', 'admin02', 'admin02', 'admin'),
('U01', 'user01', 'user01', 'user'),
('U02', 'user02', 'user02', 'user'),
('U03', 'user03', 'user03', 'user'),
('U04', 'user04', 'user04', 'user'),
('U05', 'user05', 'user05', 'user'),
('U06', 'user06', 'user06', 'user');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `gv`
--

CREATE TABLE `gv` (
  `id` varchar(8) NOT NULL,
  `name` text NOT NULL,
  `age` int(11) NOT NULL,
  `lesson` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `gv`
--

INSERT INTO `gv` (`id`, `name`, `age`, `lesson`) VALUES
('AD01', 'GV1', 30, 'Công nghệ web'),
('AD02', 'GV02', 35, 'Lập trình mạng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sv`
--

CREATE TABLE `sv` (
  `id` varchar(8) NOT NULL,
  `name` text NOT NULL,
  `age` int(11) NOT NULL,
  `idgv` varchar(8) NOT NULL,
  `diem` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sv`
--

INSERT INTO `sv` (`id`, `name`, `age`, `idgv`, `diem`) VALUES
('U01', 'user01', 20, 'AD01', 0),
('U02', 'user02', 21, 'AD02', 0),
('U03', 'user03', 22, 'AD02', 0),
('U04', 'user04', 20, 'AD01', 0),
('U05', 'user05', 21, 'AD02', 0),
('U06', 'user06', 20, 'AD02', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `gv`
--
ALTER TABLE `gv`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sv`
--
ALTER TABLE `sv`
  ADD PRIMARY KEY (`id`,`idgv`),
  ADD KEY `idgv` (`idgv`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `gv`
--
ALTER TABLE `gv`
  ADD CONSTRAINT `gv_ibfk_1` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Các ràng buộc cho bảng `sv`
--
ALTER TABLE `sv`
  ADD CONSTRAINT `sv_ibfk_1` FOREIGN KEY (`id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `sv_ibfk_2` FOREIGN KEY (`idgv`) REFERENCES `gv` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
