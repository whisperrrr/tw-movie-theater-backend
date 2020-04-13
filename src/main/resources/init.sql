CREATE TABLE `movie` (
  `id` int NOT NULL,
  `title` varchar(12) DEFAULT NULL,
  `year` year DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `original_title` varchar(60) DEFAULT NULL,
  `directors` varchar(20) DEFAULT NULL,
  `genres` varchar(10) DEFAULT NULL,
  `content` text,
  `small` varchar(255) DEFAULT NULL,
  `median` varchar(255) DEFAULT NULL,
  `large` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `actor` (
  `id` int NOT NULL,
  `actor_name` varchar(25) NOT NULL,
  `small` varchar(255) DEFAULT NULL,
  `median` varchar(255) DEFAULT NULL,
  `large` varchar(255) DEFAULT NULL,
  KEY `id_idx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci