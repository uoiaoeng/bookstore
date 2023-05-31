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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` varchar(45) CHARACTER SET latin1 NOT NULL COMMENT '主键',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '书名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `useful` tinyint(1) DEFAULT NULL COMMENT '是否可用 0不可用 1可用',
  `category` varchar(45) DEFAULT NULL COMMENT '书本的类别',
  `image_url` varchar(45) DEFAULT NULL COMMENT '书本图片的路径',
  `inventory` int(10) DEFAULT NULL COMMENT '书本的库存',
  `introduction` varchar(200) DEFAULT NULL COMMENT '书本的简介',
  `author` varchar(45) DEFAULT NULL COMMENT '书本作者的名字',
  `user_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '书籍创建者的id',
  `create_time` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书本表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('01','黑猫',20.30,1,'侦探','zentanp1.jpg',100,'黑猫 爱伦坡短篇小说集 爱伦坡的黑猫乌鸦暗黑故事集 以将死之人口吻向读者倾吐心声惊悚恐怖侦探悬疑推理小说畅销书','(美)埃德加·爱伦·坡','admin_id','2022-09-20 16:49:23'),('02','十宗罪',95.00,1,'侦探','zentanp2.jpg',100,'十宗罪正版全套7册蜘蛛著十宗罪123456集套装电视剧恐怖惊悚侦探悬疑鬼吹灯推理小说畅销书籍','蜘蛛','admin_id','2022-09-21 15:08:30'),('03','爱伦·坡暗黑故事全集',48.00,1,'侦探','zentanp3.jpg',100,'博集天卷 爱伦坡暗黑故事全集上下册全2册新版 悬疑小说侦探推理小说鼻祖、现代恐怖小说创始人完整收录独一无二的风格 正版','(美)埃德加·爱伦·坡','admin_id','2022-09-21 15:08:30'),('04','福尔摩斯探案全集',95.00,1,'侦探','zentanp4.jpg',100,'福尔摩斯探案集全集正版皮面珍藏版侦探悬疑推理笔记小说大侦探犯罪心理学畅销书原版原著全套破案柯南道尔刑侦类的书籍成人青少年','柯南','admin_id','2022-10-04 18:09:45'),('05','一战战史',32.80,1,'军事','junshi1.jpg',100,'全套3册 一战战史二战战史正版世界经典战役战争军事书籍二战历史书籍第一次世界大战第二次全史战争类书籍关于二战的书简史','韦斯特维尔','admin_id','2022-11-14 15:17:43'),('06','中国儿童军事百科全书',45.00,1,'军事','junshi2.jpg',100,'中国儿童军事百科全书正版动物植物太空兵器武器科普书籍世界枪械战争类绘本6-15岁小学生课外阅读军事知识和常识dk博物大百科全套','无','admin_id','2022-11-16 14:15:05'),('07','志愿军全战事',18.30,1,'军事','junshi3.jpg',100,'志愿军全战事 朝鲜战争中国人民解放军故事珍闻全记录丛书中国军事世界历史书籍战争38军长津湖战役抗美援朝战争史','无','admin_id','2022-11-18 16:21:06'),('08','孙子兵法与三十六计',98.00,1,'军事','junshi4.jpg',100,'孙子兵法三十六计正版全套孙武原著白话文注解译文36计孙膑吴子孙子兵书与三十六计小学生版青少年中华国学书局军事谋略书籍大全集','孙武等','admin_id','2022-11-15 18:34:12'),('09','曹操',68.00,1,'历史','lishi1.jpg',100,'全3册《曹操》易中天原著正版 长篇历史小说中国史 真实又与众不同的曹操传记 三部曲上中下全套3本 品三国演义读经典历史故事','易中天','admin_id','2022-11-15 18:33:33'),('10','不可不知的历史常识',11.80,1,'历史','lishi2.jpg',100,'不可不知的历史常识大全集//中国古代历史文化知识国学经典常识全知道正版书籍解读中外世界历史通俗历史知识读本','同辉','admin_id','2022-09-21 17:04:55'),('11','文明的故事:全11卷',844.00,1,'历史','lishi3.jpg',100,'文明的故事 11卷 15册 威尔·杜兰特 理想国经典馆 全球2000万家庭收藏的传世经典 人文 社科 历史 正版图书 理想国图书旗舰店','威尔· 杜兰特','admin_id','2022-11-18 17:30:43'),('12','中华上下五千年',95.00,1,'历史','lishi4.jpg',100,'中华上下五千年全套6册皮面精装原著精装版全集现代文中国历史书籍上下5000年历史故事史记古代通史青少年初中生小学生成人畅销书','文若愚','admin_id','2022-12-09 15:53:43'),('13','三体',38.00,1,'科幻','kehuan1.jpg',100,'三体(全套三册)雨果奖作品流浪地球作者刘慈欣作品三体1+三体2黑暗森林+三体3科幻畅销小说书籍','刘慈欣','admin_id','2022-12-09 15:53:43'),('14','刘慈欣少年科幻系列书',68.00,1,'科幻','kehuan2.jpg',100,'6册刘慈欣科幻小说全套少儿系列流浪地球正版书超新星纪元完整版全频带阻塞干扰中国版地球大炮微纪元中国太阳三体五六年级课外书','刘慈欣','admin_id','2022-12-09 15:53:43'),('15','流浪地球',169.00,1,'科幻','kehuan3.jpg',100,'13册正版虫系列科幻小说中国未来+深空+超脑+超维 银河雨果奖郝景芳王晋康等科幻小说未来篇异种入侵星际移民平行世界三体全集书籍','刘慈欣','admin_id','2022-12-09 15:53:43'),('16','B12星球之时空穿越纪事',186.00,1,'科幻','kehuan4.jpg',100,'现货正版 荷鲁斯之乱编年史+战锤40000 黑暗帝国盖伊·哈雷 风靡欧美30多年经典科幻大作战锤40k浙江科学技术出版社定制飞机盒包装','吕尚','admin_id','2022-12-09 15:53:43'),('17','宇宙',30.00,1,'魔幻','mohuan1.jpg',100,'【正版书籍 现货包邮】《宇宙》（雨果奖、普利策奖、艾美奖得主卡尔萨根经典作品）卡尔萨根著 陈冬尼译(套装共2册)附赠别册','卡尔·萨根','admin_id','2022-12-09 15:53:43'),('18','猎魔人套装7册',368.20,1,'魔幻','mohuan2.jpg',100,'套装8册猎魔人小说彩绘纸箱+金属书签一个 修订版精装波兰奇幻白狼崛起雨燕之塔湖中女士巫师3游戏原著小说独角兽书系','安杰伊·萨普科夫斯基','admin_id','2022-12-09 15:53:43'),('19','北欧神话',34.00,1,'魔幻','mohuan3.jpg',100,'【长幅拉页海报】北欧神话 精装版 茅盾著奥丁雷神洛基那冰与火的世界电影阴阳师王浣外国文学绘制魔幻小说书籍原版正版包邮矛盾','茅盾','admin_id','2022-12-09 15:53:43'),('20','我的世界：远航',24.50,1,'魔幻','mohuan4.jpg',100,'【官方正版】我的世界小说全套9册 末影龙沉船山破碎海岛失落的日记末地远航地下城奇厄教主的崛起中文版小说故事书初中生课外阅读','杰森·弗莱','admin_id','2022-12-09 15:53:43');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
