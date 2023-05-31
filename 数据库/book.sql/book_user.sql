-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: book
-- ------------------------------------------------------
-- Server version	5.7.1-m11-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(45) CHARACTER SET latin1 NOT NULL COMMENT '用户的唯一标识符',
  `username` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '用户的密码',
  `age` int(10) DEFAULT NULL COMMENT '用户年龄',
  `sex` varchar(10) DEFAULT '男' COMMENT '用户性别',
  `role` int(10) DEFAULT '0' COMMENT '用户的角色 0普通用户 1管理员 2超级管理员  默认为0',
  `store_id` varchar(45) DEFAULT NULL COMMENT '用户旗下的商店id',
  `telephone` varchar(45) DEFAULT NULL COMMENT '用户的手机号',
  `email` varchar(45) DEFAULT NULL COMMENT '用户的邮箱地址',
  `like_book_id` varchar(1000) DEFAULT NULL COMMENT '收藏的书本id',
  `create_time` varchar(45) DEFAULT NULL COMMENT '用户的创建时间 YYYY-MM-DD hh:mm:ss',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0acf6cc74b4e5cbaa921a0f3ee3886ee','admin2','123',18,'男',0,NULL,NULL,NULL,NULL,'2022-12-08 20:32:40'),('1ce5baa592c131f6b2baf3e9e0fa05a1','admin1','123',18,'男',0,NULL,NULL,'',NULL,'2023-05-16 16:34:47'),('30acd0b94036da7ff6507651cb18e6f2','admin3','123',18,'男',0,NULL,NULL,'1@qq.com',NULL,'2023-05-16 16:58:18'),('41cdff78e3df107f52678d7452508486','admin4','1111',20,'男',0,NULL,NULL,'',NULL,'2022-12-08 20:37:56'),('admin_id','admin','123',18,'男',2,NULL,NULL,NULL,'05,13,14,04,02,','2022-12-09 15:29:37');
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

-- Dump completed on 2023-05-31 12:14:27
