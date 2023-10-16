-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: charity_network
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auction_product`
--

DROP TABLE IF EXISTS `auction_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auction_product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `current_price` decimal(10,2) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `auction_product_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `auction_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction_product`
--

LOCK TABLES `auction_product` WRITE;
/*!40000 ALTER TABLE `auction_product` DISABLE KEYS */;
INSERT INTO `auction_product` VALUES (1,3,1,60000000.00,'2023-09-12 01:41:51'),(4,1,1,65000000.00,'2023-09-12 02:15:35'),(5,4,1,70000000.00,'2023-09-12 02:15:47'),(6,2,1,80000000.00,'2023-09-12 02:15:58'),(7,5,1,81000000.00,'2023-09-12 02:16:10'),(8,3,1,100000.00,'2023-10-13 03:51:46'),(9,3,1,64000000.00,'2023-10-13 03:52:29'),(10,1,16,15000.00,'2023-10-13 23:01:26'),(11,1,16,20000.00,'2023-10-13 23:01:30');
/*!40000 ALTER TABLE `auction_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Thiết bị điện tử',NULL),(2,'Thời trang',NULL),(3,'Thể thao',NULL),(4,'Nhạc cụ',NULL),(5,'Đồ cổ',NULL),(6,'Nghệ thuật',NULL),(7,'Sách',NULL);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hashtags`
--

DROP TABLE IF EXISTS `hashtags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hashtags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hashtag_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hashtags`
--

LOCK TABLES `hashtags` WRITE;
/*!40000 ALTER TABLE `hashtags` DISABLE KEYS */;
/*!40000 ALTER TABLE `hashtags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `type` varchar(50) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `notifications_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_comment`
--

DROP TABLE IF EXISTS `post_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `post_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `post_comment_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_comment`
--

LOCK TABLES `post_comment` WRITE;
/*!40000 ALTER TABLE `post_comment` DISABLE KEYS */;
INSERT INTO `post_comment` VALUES (1,7,1,'Hay!!!','2023-09-06 10:35:20','2023-09-06 10:35:20'),(2,9,1,'Nội dung hay@@@','2023-09-06 10:35:20','2023-09-06 10:35:20'),(3,1,1,'Comment!!!','2023-09-06 10:35:20','2023-09-06 10:35:20'),(4,14,1,'new comment!!!','2023-09-08 09:28:03',NULL),(5,14,1,'hÃº hÃº','2023-09-08 09:29:29',NULL),(6,3,1,'test tiếng việt','2023-09-08 09:57:57',NULL),(7,3,1,'vài giây tới','2023-09-08 09:58:10',NULL),(8,14,2,'ahihi','2023-09-09 04:10:24',NULL),(9,7,1,'tuyệt vời!!','2023-09-09 11:03:44',NULL),(10,7,18,'test bình luận','2023-09-09 11:38:43',NULL),(11,3,1,'hello','2023-09-09 14:03:34',NULL),(12,7,18,'hi','2023-09-10 03:22:57',NULL),(13,3,2,'hi','2023-09-10 03:43:21',NULL),(14,3,2,'new comment','2023-09-10 03:44:24',NULL),(15,3,2,'xin chào','2023-09-10 04:17:15',NULL),(16,3,2,'test','2023-09-10 04:48:36',NULL),(17,3,2,'kiểm tra','2023-09-10 04:49:30',NULL),(18,3,18,'xin chào','2023-09-10 09:32:01',NULL),(19,3,15,'hi','2023-09-10 09:39:46',NULL),(20,3,15,'test','2023-09-10 09:41:07',NULL),(21,3,18,'hi','2023-09-10 10:00:50',NULL),(22,14,23,'hi','2023-10-13 22:52:39',NULL),(23,14,1,'hi','2023-10-13 22:59:06',NULL);
/*!40000 ALTER TABLE `post_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_comment_like`
--

DROP TABLE IF EXISTS `post_comment_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_comment_like` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `comment_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_comment_like` (`user_id`,`comment_id`),
  KEY `post_id` (`post_id`),
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `post_comment_like_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `post_comment_like_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `post_comment_like_ibfk_3` FOREIGN KEY (`comment_id`) REFERENCES `post_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_comment_like`
--

LOCK TABLES `post_comment_like` WRITE;
/*!40000 ALTER TABLE `post_comment_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_comment_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_hashtags`
--

DROP TABLE IF EXISTS `post_hashtags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_hashtags` (
  `post_id` int NOT NULL,
  `hashtag_id` int NOT NULL,
  KEY `post_id` (`post_id`),
  KEY `hashtag_id` (`hashtag_id`),
  CONSTRAINT `post_hashtags_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `post_hashtags_ibfk_2` FOREIGN KEY (`hashtag_id`) REFERENCES `hashtags` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_hashtags`
--

LOCK TABLES `post_hashtags` WRITE;
/*!40000 ALTER TABLE `post_hashtags` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_hashtags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_like`
--

DROP TABLE IF EXISTS `post_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_like` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_post_like` (`user_id`,`post_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `post_like_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `post_like_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_like`
--

LOCK TABLES `post_like` WRITE;
/*!40000 ALTER TABLE `post_like` DISABLE KEYS */;
INSERT INTO `post_like` VALUES (1,1,1,'2023-09-08 11:03:17'),(6,3,3,NULL),(10,7,1,NULL),(11,3,18,'2023-09-09 10:51:58'),(13,3,13,'2023-09-09 10:59:39'),(14,7,18,'2023-09-10 03:19:50'),(15,3,1,'2023-09-12 08:22:41'),(16,3,2,'2023-09-12 09:03:00'),(17,14,23,'2023-10-13 22:52:32'),(18,14,1,'2023-10-13 22:58:58');
/*!40000 ALTER TABLE `post_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_reply`
--

DROP TABLE IF EXISTS `post_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_reply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `comment_id` int NOT NULL,
  `reply_id` int DEFAULT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  KEY `comment_id` (`comment_id`),
  KEY `reply_id` (`reply_id`),
  CONSTRAINT `post_reply_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `post_reply_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `post_reply_ibfk_3` FOREIGN KEY (`comment_id`) REFERENCES `post_comment` (`id`),
  CONSTRAINT `post_reply_ibfk_4` FOREIGN KEY (`reply_id`) REFERENCES `post_reply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_reply`
--

LOCK TABLES `post_reply` WRITE;
/*!40000 ALTER TABLE `post_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_reply_like`
--

DROP TABLE IF EXISTS `post_reply_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_reply_like` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `comment_id` int NOT NULL,
  `reply_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_reply_like` (`user_id`,`reply_id`),
  KEY `post_id` (`post_id`),
  KEY `comment_id` (`comment_id`),
  KEY `reply_id` (`reply_id`),
  CONSTRAINT `post_reply_like_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `post_reply_like_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `post_reply_like_ibfk_3` FOREIGN KEY (`comment_id`) REFERENCES `post_comment` (`id`),
  CONSTRAINT `post_reply_like_ibfk_4` FOREIGN KEY (`reply_id`) REFERENCES `post_reply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_reply_like`
--

LOCK TABLES `post_reply_like` WRITE;
/*!40000 ALTER TABLE `post_reply_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_reply_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,1,'Bài viết mới','Đây là nội dung của bài viết mới',NULL,'2023-09-01 08:53:30','2023-09-06 10:23:06'),(2,2,'Chia sẻ từ thiện','Đây là nội dung của bài viết mới',NULL,'2023-09-06 08:53:30','2023-09-06 08:53:30'),(3,2,'Giúp đỡ người nghèo','Đây là nội dung của bài viết mới',NULL,'2023-09-06 08:53:30','2023-09-06 08:53:30'),(4,2,'Hành động tốt','Đây là nội dung của bài viết mới',NULL,'2023-09-06 08:53:30','2023-09-06 08:53:30'),(11,14,'fdfd','dfd',NULL,'2023-09-08 05:06:49',NULL),(12,3,'Giúp đỡ trẻ em miền núi','giúp đỡ',NULL,NULL,'2023-09-12 08:09:02'),(13,3,'chia sẻ giúp đỡ mọi người','share',NULL,NULL,'2023-09-12 08:09:32'),(14,3,'Chia sẻ yêu thương','Giúp đỡ mọi người',NULL,NULL,'2023-09-12 08:08:07'),(15,3,'Hiến máu nhân đạo','Một giọt máu cho đi một cuộc đời ở lại',NULL,NULL,'2023-09-12 08:08:31'),(16,3,'Bài viết với nội dung từ thiện','nội dung từ thiện',NULL,NULL,'2023-09-12 08:07:39'),(18,3,'Chia sẻ yêu thương','chia sẻ',NULL,NULL,'2023-09-10 09:22:03'),(22,14,'Giúp đỡ trẻ em nghèo','Các em nghèo được giúp đỡ',NULL,'2023-09-12 08:25:56',NULL),(23,14,'Đăng bài 123','nội dung',NULL,NULL,'2023-10-13 22:52:16'),(24,14,'bài viết mới','update',NULL,NULL,'2023-10-13 22:59:42');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `category_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `starting_price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,1,'iphone 14','điện thoại mạ vàng',50000000.00,1,'https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg',_binary ''),(2,1,1,'iphone 13','điện thoại mạ vàng1',55000000.00,1,'https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg',_binary ''),(3,1,1,'iphone 12','điện thoại mạ vàng2',20000000.00,1,'https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg',_binary ''),(4,1,1,'iphone 11','điện thoại mạ vàng3',10000000.00,1,'https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg',_binary ''),(5,1,1,'iphone 14','điện thoại mạ vàng4',50000000.00,1,'https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg',_binary ''),(6,3,3,'Áo messi','áo số 10 của messsi',50000.50,1,'https://res.cloudinary.com/dmjcqxek3/image/upload/v1694505629/g9idwp2e0zr6cod2yrej.jpg',NULL),(8,3,3,'Áo Ronaldo','Áo Ronaldo mặc thi đấu',50000.00,1,'https://res.cloudinary.com/dmjcqxek3/image/upload/v1694506391/pepa7jaheb5oerh2neie.jpg',NULL),(11,3,3,'ảnh mới','ảnh mới',10000.00,5,'https://res.cloudinary.com/dmjcqxek3/image/upload/v1694508648/hrdjopzubst30lgrqoep.png',NULL),(12,3,5,'Đồ cổ Trung Quốc','Gốm sứ đời nhà Thanh',20000000.00,2,'https://res.cloudinary.com/dmjcqxek3/image/upload/v1694495161/l4svmkp853n2dkbo0szv.jpg',NULL),(13,3,5,'Đỉnh đồng','Đồ cổ gia truyền',10000000.00,1,'https://res.cloudinary.com/dmjcqxek3/image/upload/v1694495203/maogyxa4xcgav1o1cick.jpg',NULL),(16,14,5,'mũ vua','đồ cổ',10000.00,1,'https://res.cloudinary.com/dmjcqxek3/image/upload/v1697238022/yo3454jhyajcqy1ystgy.jpg',NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `reason` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `reports_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `id` int NOT NULL AUTO_INCREMENT,
  `auction_product_id` int NOT NULL,
  `winner_id` int NOT NULL,
  `product_id` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `status` varchar(50) DEFAULT (_utf8mb4'Chưa thanh toán'),
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_results` (`winner_id`,`auction_product_id`,`product_id`),
  KEY `product_id` (`product_id`),
  KEY `auction_product_id` (`auction_product_id`),
  CONSTRAINT `results_ibfk_1` FOREIGN KEY (`winner_id`) REFERENCES `users` (`id`),
  CONSTRAINT `results_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `results_ibfk_3` FOREIGN KEY (`auction_product_id`) REFERENCES `auction_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (1,7,5,1,81000000.00,NULL,'2023-10-13 05:22:15'),(2,11,1,16,20000.00,NULL,'2023-10-13 23:02:01');
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `avatar` varchar(255) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `user_role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Kiên','Phạm Trung','phamtrungkien9a4@gmail.com','0585870021','user1','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLbj8rUXCxf1cjqTqDknU77Ym-aOcv22ULU5nEG_F39A&s',_binary '','ROLE_USER'),(2,'Kiên','Phạm Trung','2051052067kien@ou.edu.vn','0585870021','user2','$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLbj8rUXCxf1cjqTqDknU77Ym-aOcv22ULU5nEG_F39A&s',_binary '','ROLE_USER'),(3,'Kiên','Phạm Trung Kiên','phamtrungkien9a4@gmail.com','0585870021','admin','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLbj8rUXCxf1cjqTqDknU77Ym-aOcv22ULU5nEG_F39A&s',_binary '','ROLE_ADMIN'),(4,'dsd','sds','df@gmail.com','12345657','dfdf','$2a$10$Jbm.4kMC5JK2C.0ILAZ0suca5GfdV59rKnwsjCYHiOQjCnPriMp56','https://res.cloudinary.com/dmjcqxek3/image/upload/v1693025863/tjxpfce3karx93qafftg.png',NULL,'ROLE_USER'),(5,'postman','test','abc@gmail.com','012345678','testApi','$2a$10$rK6L/azL1/nybqI/qzp.VuPFX57P2OpYPIla6yM1cf5Ni8CrvvRnC','https://res.cloudinary.com/dmjcqxek3/image/upload/v1693716168/tswcnfs6e0jcvyetx9el.png',NULL,'ROLE_USER'),(7,'Đặng ','User','dang@gmail.com','01243456','dang123','$2a$10$XQi3Qvfy0d7vfK0OH9NA6OrxOZwUbp3RvRFgUGoc5zQRJonu.fKAi','https://res.cloudinary.com/dmjcqxek3/image/upload/v1693732729/k15zyh9lj7l7qekr4cde.jpg',NULL,'ROLE_USER'),(9,'Phạm','Kiên','2051052067kien@ou.edu.vn','0585870021','kiendz102','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','https://res.cloudinary.com/dmjcqxek3/image/upload/v1667872652/cld-sample.jpg',_binary '','ROLE_USER'),(14,'Phạm','Kiên','2051052067kien@ou.edu.vn','0585870021','test','$2a$10$EGPvTy0l4ioX/s6PDv5tve30k61H4gJ3enemDDczloYlv4OzCnq0e','https://res.cloudinary.com/dmjcqxek3/image/upload/v1693717737/dzqgtschfjjemyw1xjco.png',_binary '','ROLE_USER'),(15,'Trung Kiên','Phạm','2051052067kien@ou.edu.vn','0585870021','kien1234','$2a$10$RCY8O6x4nT7KgiNKbm3kIOlS6X2dzHNzuNPjxKD/93PjVHGRpeaa2','https://res.cloudinary.com/dmjcqxek3/image/upload/v1697237417/ycpxzig3glc0wkbqxl2z.jpg',_binary '','ROLE_USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-16 16:11:11
