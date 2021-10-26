-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: reviewtwits
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `review_id` int NOT NULL,
  `user_uid` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK5l1i6na3ni469xrffqbi4oyx0` (`user_uid`),
  CONSTRAINT `FK5l1i6na3ni469xrffqbi4oyx0` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (5,'저도 환영해요~~~ㅋ','2021-10-25 18:03:40.796299',4,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(20,'오 정말 그렇군요','2021-10-26 01:30:54.270402',19,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(29,'안녕하세요','2021-10-26 02:04:58.104485',28,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(32,'gdgd','2021-10-26 02:16:35.576273',31,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(49,'ㅋㅋㅋ','2021-10-26 04:54:48.382451',45,'0RnfBxnfGxgvGMIx1PayKWfEZ573'),(50,'좋아보여욘','2021-10-26 04:54:52.647689',47,'0RnfBxnfGxgvGMIx1PayKWfEZ573'),(51,'ㅋㅋㅋㅋㅋ','2021-10-26 04:55:03.996175',43,'0RnfBxnfGxgvGMIx1PayKWfEZ573'),(53,'ㅇㅈㅋㅋ','2021-10-26 04:59:32.363144',52,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(62,'정말 좋네요!','2021-10-26 06:55:32.573410',57,'vFuTgbq205OwR04Fxg4zEPGLoJx1');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow` (
  `follow_id` int NOT NULL,
  `target_uid` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`follow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES (2,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(21,'vFuTgbq205OwR04Fxg4zEPGLoJx1','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(54,'vFuTgbq205OwR04Fxg4zEPGLoJx1','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(55,'ZdAkkoTzfkNChLRw8KQ2UvpgF0D2','vFuTgbq205OwR04Fxg4zEPGLoJx1');
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (63);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `income` int NOT NULL DEFAULT '0',
  `path` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `reviews` int NOT NULL DEFAULT '0',
  `sales` int NOT NULL DEFAULT '0',
  `view` int NOT NULL DEFAULT '0',
  `project_project_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKgswes41xwyx8ys9yktf96s3r6` (`project_project_id`),
  CONSTRAINT `FKgswes41xwyx8ys9yktf96s3r6` FOREIGN KEY (`project_project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `domain` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `user_uid` varchar(512) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKj78lf6i9dveht1q583ck4rkew` (`user_uid`),
  CONSTRAINT `FKj78lf6i9dveht1q583ck4rkew` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('127ic28bspxxchz1jdqr','shopping','www.test.com','쇼핑몰 전용!!','vFuTgbq205OwR04Fxg4zEPGLoJx1','#cd57ff','쇼핑몰'),('6t0kuxxlkzdi5k0fgwkr','game','www.diablo.com','디아블로 재밌겠다','vFuTgbq205OwR04Fxg4zEPGLoJx1','#cd57ff','블리자드 게임'),('fidms3x9gnw4vcvig65w','movie','http://localhost:3000','영화리뷰 관련하여 사용하는 사이트','vFuTgbq205OwR04Fxg4zEPGLoJx1','#fd6494','영화리뷰'),('nn0g6k62s0ijm6c1h03o','art','www.art.com','나는 정말 미술을 좋아한다 예술의 신인이다','vFuTgbq205OwR04Fxg4zEPGLoJx1','#37ba82','미술이 좋아'),('tcw3rcwhxpqqmtggdp7r','credit','www.pay.com','결제하는 프로젝트입니다','vFuTgbq205OwR04Fxg4zEPGLoJx1','#43f390','결제 전용');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `order_id` int NOT NULL,
  `domain_url` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `project_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_uid` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK8ix5msb4mh9mleeugy6x62rsj` (`user_uid`),
  CONSTRAINT `FK8ix5msb4mh9mleeugy6x62rsj` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (11,'/product/sofa','소파','Paid',1920000,'127ic28bspxxchz1jdqr','complete','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(12,'/product/sofa','소파','Paid',1920000,'127ic28bspxxchz1jdqr','complete','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(13,'/product/sofa','소파','Paid',1920000,'127ic28bspxxchz1jdqr','complete','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(14,'/product/sofa','소파','Paid',1920000,'127ic28bspxxchz1jdqr','complete','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(15,'/product/sofa','소파','Paid',1920000,'127ic28bspxxchz1jdqr','complete','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(17,'/product/sofa','소파','Paid',1920000,'127ic28bspxxchz1jdqr','complete','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(22,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(23,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(24,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(27,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','vFuTgbq205OwR04Fxg4zEPGLoJx1'),(30,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(33,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(34,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(35,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(38,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(41,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(44,'/product/mike','마이크','Paid',138000,'127ic28bspxxchz1jdqr','complete','4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(46,'/product/camera','카메라','Paid',153000,'127ic28bspxxchz1jdqr','complete','nnYwIfFf4gNNsbb8Y9gIg2KRVJz2'),(56,'/product/camera','카메라','Paid',153000,'127ic28bspxxchz1jdqr','complete','iGWWZx9nzHSlvFNb9BZP1LZIVBl1'),(58,'/product/camera','카메라','Paid',153000,'127ic28bspxxchz1jdqr','complete','iGWWZx9nzHSlvFNb9BZP1LZIVBl1'),(60,'/product/camera','카메라','Paid',153000,'127ic28bspxxchz1jdqr','complete','iGWWZx9nzHSlvFNb9BZP1LZIVBl1');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `review_id` int NOT NULL,
  `content` varchar(2048) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `emotion` double NOT NULL,
  `image_path` varchar(1024) DEFAULT NULL,
  `like_count` int NOT NULL DEFAULT '0',
  `path` varchar(255) DEFAULT NULL,
  `project_id` varchar(255) DEFAULT NULL,
  `review_type` int NOT NULL DEFAULT '0',
  `score` int NOT NULL,
  `user_uid` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FKfut2codnlg3xfpohmd06ogsts` (`user_uid`),
  CONSTRAINT `FKfut2codnlg3xfpohmd06ogsts` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (4,'환영해요!','2021-10-25 18:03:32.891198',0,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2Fwelcome.png?alt=media&token=d2dacf9d-fc0a-4ab6-8ed2-5b0b3eac2cfb',3,NULL,NULL,0,5,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(16,'ㅋㅇㄹㅇㅋㄹㅇ','2021-10-25 23:20:04.994250',0.452189564704895,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2Fsuper%20frog.png?alt=media&token=3003b491-5ac0-44aa-9160-a8cd55f42d66',0,'/product/sofa','127ic28bspxxchz1jdqr',1,5,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(18,'호에에','2021-10-26 01:29:01.056263',0,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F17c8d0918b148e2a4.gif?alt=media&token=64874f45-1d2d-4032-94f7-ac7783d0f9a9',0,NULL,NULL,0,1,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(19,'개인차는 있겠지만 저는 리클라이너를 접해본 이후 일반소파에 앉으면 뒤로 누워지지도 않고 괜히 좁은 느낌이라 불편하더라구요. 결국 가족들에게 설명과 설득을 통해 리클라이너 구매했습니다. 여러 브랜드와 제품을 검색해봤는데, 차후 as 문제 발생할 경우 대비해서 믿을수 있는 한샘 뉴프라임으로 결정했습니다. 리클라이너에 누워서 티비 보는거 정말 좋네요.','2021-10-26 01:30:42.535375',0.1135917603969574,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2Fapple.png?alt=media&token=e99f53d7-1ca6-4d45-a313-16533b1fc97e',0,'/product/sofa','127ic28bspxxchz1jdqr',1,5,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(26,'일단 아직 하루밖에 사용하지 못해 좋다 안 좋다 말하기 어렵지만 현재 친구들에게 실험해본 결과 기존 헤드셋 마이크와는 음질 차이가 확연히 난다고 하는 걸 보아 좀 더 써보면 확실히 파악할 수 있을 거 같습니다. 일단\n지금까진 만족입니다 :)','2021-10-26 02:02:18.330743',0.9799289107322693,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC1.png?alt=media&token=8c863332-e52b-4ec4-bccc-5be66852f864',0,'/product/mike','127ic28bspxxchz1jdqr',1,5,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(28,'온라인 상으로 대화를 할 일이 많아져 이번 기회에 마이크를 하나 장만하게 됐어요. 10만원이란 가격에 마이크를 왜 사냐고 하시는 의견도 꽤 들리더라구요. 이것보다 싼 마이크도 많지만 싼게 비지떡이라고 걱정도 돼서 결국 구매를 하였지요. 실사용을 해보니 정말 후회하지 않아요. 상대방이 들었을 때 늘 음질이 깨끗해서 잘 들린다고 하고 헤드셋을 썼을 때의 불편함이 없어서 편하게 말할 수 있어서 만족해요. 간단한 음질 설정만 맞추면 방송까지도 무난하게 사용 가능해요. 추천하는 제품입니다.\n','2021-10-26 02:04:46.060158',0.9748620986938477,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC2.png?alt=media&token=58cf7207-8e24-441e-964f-ad18598db56f',0,'/product/mike','127ic28bspxxchz1jdqr',1,5,'vFuTgbq205OwR04Fxg4zEPGLoJx1'),(31,'소리가 작게 들려서 증폭조절을 세심하게 해도 입 앞에다가 둬야 크게 들리네요ㅠ 그래도 비싼 값 하는거 같아요. 음질은 여태 마이크 중 가장 깔끔해요. 오주문건도 빠른 답변 주셔서 문제없이 원하던 물건 받았구요. 잘 쓰겠습니다.\n','2021-10-26 02:16:30.987690',0.9892745018005371,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC3.png?alt=media&token=14a4c8bc-d443-48a9-bafe-9284447779be',0,'/product/mike','127ic28bspxxchz1jdqr',1,5,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(36,'\n음질 좋다고 샀는데 이어폰보다 못하네요. 환불 불가능이니 잘 생각하고 사세요.','2021-10-26 02:18:38.630138',0.008465200662612915,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC10.PNG?alt=media&token=5ab33797-62e9-4faf-8eab-6e8b87a08f07',0,'/product/mike','127ic28bspxxchz1jdqr',1,1,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(37,'매우 후회스럽습니다. 설치를 잘했는지는 모르겠다만 마이크 인풋을 낮추면 녹음이 너무 작게되고 또 그렇다고 크게하면 희한한 소리가 다 섞여서 나오고 이어폰을 꼽았는데 오른쪽은 아예 소리가 나오지도 않습니다. 이어폰이 고장난 줄 알고 핸드폰에 꼽아봤지만 다 잘 들립니다.','2021-10-26 02:29:19.717609',0.010718435049057007,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC9.PNG?alt=media&token=6b6b8f13-e322-44b9-a8bb-51832c5ed348',0,'/product/mike','127ic28bspxxchz1jdqr',1,1,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(39,'무게를 견디지를 못해서 ㅡㅡ... 앞으로 넘어지고요 조립방법 따로 같이 보내주셔야 할 듯 하네요 방송해서 시청자 도움 받아서 조립했네요..\n','2021-10-26 04:19:56.947563',0.009362727403640747,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC8.png?alt=media&token=91257bf4-995a-4970-be0c-29ee8b107518',0,'/product/mike','127ic28bspxxchz1jdqr',1,2,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(40,'좋아요 잘 나와요. 근데 마이크가 너무 무거워서 거치대가 잘 못버티네요 ㅋ\n','2021-10-26 04:20:14.355239',0.8102508783340454,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC7.png?alt=media&token=a1084e2f-1ce7-4ffa-a896-f001169865e6',3,'/product/mike','127ic28bspxxchz1jdqr',1,2,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(42,'윈도우 10만 호환되서 업데이트하느라 고생했네용ㅋㅋ 장비가 많이 필요없어 간단해서 좁은 공간에 좋은거 같아용','2021-10-26 04:20:48.022505',0.9956924915313721,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC6.png?alt=media&token=84944950-d163-454e-b082-8930da5972be',1,'/product/mike','127ic28bspxxchz1jdqr',1,3,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(43,'내용물은 괜찮은데 박스가 죄다 부서지고 난리난 상태로 배송이 되어서 조~금 누가 사용하다가 보낸거 아닌가 싶을 정도라서 그렇네요. 아직 본체가 없어서 사용을 못해봤어요','2021-10-26 04:21:01.447451',0.05827689170837402,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC5.png?alt=media&token=6c845153-10a5-4729-9d76-5d093363a902',3,'/product/mike','127ic28bspxxchz1jdqr',1,3,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(45,'ufo mini 한 달 이상 써봤는데 음질은 좋다고 하지만 동굴에서 말하냐는 그런 하울링 현상이 좀 있었습니다.\n(방음 문제로 망 현재는 그냥 음질은 안좋아도 제 목소리 음량을 편히 말할 수 있는 헤드셋으로 바꾼 상태입니다. 그냥 게임 디코용으론 적당하구여 개인적인 생각으론 좀더 주고 ufo 블랙에디션 상위 제품으로 가는 걸 추천드립니당','2021-10-26 04:21:53.747777',0.6858899593353271,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%A7%88%EC%9D%B4%ED%81%AC4.png?alt=media&token=aec9c872-32ed-40b2-b25f-19b5d04aa555',6,'/product/mike','127ic28bspxxchz1jdqr',1,4,'4WDJ83ta4HYpmcAa6QMt9BlgTjX2'),(47,'노랑 노랑 너무 귀여워요 ㅎㅎ\n필카에 꽂혀서 갑자기 사게됬는데 넘 맘에들어용 \n폰 사진도 인화할 수 있어서 좋네용\n화질은 감안하고 구매했어요 그래두 만족해요!!','2021-10-26 04:33:33.862341',0.9848536252975464,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EC%BD%94%EB%8B%A5%ED%95%84%EB%A6%84%EC%B9%B4%EB%A9%94%EB%9D%BC1.PNG?alt=media&token=090fba38-f601-4e29-9d66-d09ce8fc06fb',4,'/product/camera','127ic28bspxxchz1jdqr',1,5,'nnYwIfFf4gNNsbb8Y9gIg2KRVJz2'),(52,'이 남자 날 닮았다','2021-10-26 04:55:51.020123',0,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EC%9D%B8%EC%8A%A4%ED%83%8013.PNG?alt=media&token=00738e2a-a8c3-4833-95bc-59764a4b2665',0,NULL,NULL,0,5,'0RnfBxnfGxgvGMIx1PayKWfEZ573'),(57,'얼굴은 초상권 때메 가리긴 했는데 지금 받자마자 프린터 해봤거든요. 근데 화질이 안 좋다는 후기 때메 걱정했는데 전 이 정도 화질 만족해요. 그리고 핸드폰에 있는 사진을 뽑을 수 잇다는게 정말 큰 메리트 인 것 같기두 하구요. 디자인도 너무 에쁘고 간편하게 사용할 수 있어 좋아요. 처음 사용해보고 와 진작에 살걸 이런 생각이 들 정도로 만족스럽네요. 단종 안되고 쭉 사용할 수 있도록 해주시면 너무 좋을 것 같아요. 앞으론 더 사진 많이 찍고 인화해서 추억으로 잘 간직해봐야겠어요. 좋은 상품 만들어주셔서 감사해요. 고장 안나고 잘 쓸 수 있길 바라며.','2021-10-26 05:25:15.852399',0.9954985976219177,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EC%BD%94%EB%8B%A5%ED%95%84%EB%A6%84%EC%B9%B4%EB%A9%94%EB%9D%BC2.PNG?alt=media&token=1da261e3-0b77-48d6-ae5c-4db2b7040cb2',0,'/product/camera','127ic28bspxxchz1jdqr',1,5,'iGWWZx9nzHSlvFNb9BZP1LZIVBl1'),(59,'작년부터 살까말까 하다가 샀는데.. 좀 화질이 생각보다 많이 아쉽네요.. ㅠㅠ 기대를 너무 했나봐요.. 카메라 뒷 화면도 화질이 너무 안좋아서 사진이 잘 찍혔는지 구분이 잘 안가는 정도.. 사진만 뽑으실 분이라면 그냥 포토프린터 추천해요~','2021-10-26 05:25:59.569339',0.010426700115203857,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EC%BD%94%EB%8B%A5%ED%95%84%EB%A6%84%EC%B9%B4%EB%A9%94%EB%9D%BC3.PNG?alt=media&token=bcc9202d-cbbb-461b-9ba1-3a0f4dcf2666',0,'/product/camera','127ic28bspxxchz1jdqr',1,4,'iGWWZx9nzHSlvFNb9BZP1LZIVBl1'),(61,'여자친구랑 200일 기념으로 여행 가서 추억 남기려고 샀는데 받자마자 포장 상태 확인해보니 저렇게 밑 바닥이 다 뜯겨진 채로 왔네요. 반품처리된 제품인지는 알 수 없겠지만 여행이 바로 다음 날이라 어ᄍᅠᆯ 수 없이 작동만 잘하는지 확인하고 쓰긴 했는데 톡톡 해도 답장도 없으시고 제품 상태를 떠나서 아무런 대응도 안하시는게 화가나네요. 지금 여행 다녀와서 톡톡 안보셔서 리뷰 쓰려고 구매확정 눌렀어요 후.. 아무 대응도 하지 않으시니 방법이 있나요 그냥 정말 너무 화나네요','2021-10-26 05:26:43.985436',0.0012402832508087158,'https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EC%BD%94%EB%8B%A5%ED%95%84%EB%A6%84%EC%B9%B4%EB%A9%94%EB%9D%BC9.PNG?alt=media&token=14701a7e-54b8-4026-b806-56061a4a8385',0,'/product/camera','127ic28bspxxchz1jdqr',1,1,'iGWWZx9nzHSlvFNb9BZP1LZIVBl1');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` varchar(512) NOT NULL,
  `age` int DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `profile_image` varchar(255) DEFAULT NULL,
  `grade` int NOT NULL DEFAULT '1',
  `review_reveal` int NOT NULL DEFAULT '1',
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UK_n4swgcf30j6bmtb4l4cjryuym` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0RnfBxnfGxgvGMIx1PayKWfEZ573',24,'2019-01-07',2,'이지원','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.jfif?alt=media&token=48e2dd96-d9df-42cd-946b-2cdc570640fc',0,0,NULL),('4WDJ83ta4HYpmcAa6QMt9BlgTjX2',26,'1996-07-28',1,'life','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2Fwelcome.png?alt=media&token=9cb6debc-8292-413d-812c-a8e3b04c47b4',1,1,NULL),('5jyaKYPMfTREyQvi2WysPte5JOK2',28,'2021-09-28',1,'파카','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2FIMG_7394.jpg?alt=media&token=dbeff699-b60a-4ac4-911f-3f47500f504f',0,0,NULL),('iGWWZx9nzHSlvFNb9BZP1LZIVBl1',33,'2016-02-02',1,'유공','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2FCropArea0002.png?alt=media&token=8220df48-38f8-4b06-9963-26ee5ba9dc2c',0,0,NULL),('nnYwIfFf4gNNsbb8Y9gIg2KRVJz2',11,'2019-02-05',2,'aaa','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2Fwink.png?alt=media&token=1c0804c1-fe23-4f01-8f49-1824b4765cc5',0,0,NULL),('vFuTgbq205OwR04Fxg4zEPGLoJx1',21,'2009-06-18',1,'훈장','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2Fwink.png?alt=media&token=90a70ffc-8ccd-43ed-884e-f5ee5a0a7f14',1,1,'안녕하세요훈장입니다'),('yt84vYmzLRZvKKxw9So5BGu8umU2',33,'2012-02-28',2,'박보영','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2Fimg.png?alt=media&token=559d2711-5875-44f3-9093-9ad7595b53bd',0,0,NULL),('ZdAkkoTzfkNChLRw8KQ2UvpgF0D2',22,'2017-01-12',1,'코물쥐','https://firebasestorage.googleapis.com/v0/b/reviewtwits.appspot.com/o/profile%2F20210117164956.1244189.jpg?alt=media&token=08cab354-798d-49bd-aba3-adb1bf3901a3',0,0,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-26 17:35:01
