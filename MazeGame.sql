SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `MazeGame` DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci;
USE `MazeGame`;

DROP TABLE IF EXISTS `Winners`;
CREATE TABLE `Winners` (
  `id` int UNSIGNED NOT NULL,
  `playerName` varchar(64) COLLATE utf8mb3_spanish_ci NOT NULL,
  `mazeName` varchar(64) COLLATE utf8mb3_spanish_ci NOT NULL,
  `time` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

ALTER TABLE `Winners`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `Winners`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
COMMIT;
