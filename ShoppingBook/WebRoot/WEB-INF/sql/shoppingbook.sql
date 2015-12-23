/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : shoppingbook
Target Host     : localhost:3306
Target Database : shoppingbook
Date: 2011-05-12 09:10:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `Name` varchar(20) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('admin', '123');

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `superTypeId` int(11) DEFAULT NULL,
  `subTypeId` int(11) DEFAULT NULL,
  `bookName` varchar(200) DEFAULT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `introduce` text,
  `price` float DEFAULT NULL,
  `nowPrice` float DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `publisher` varchar(40) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `inTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `newBooks` int(11) DEFAULT NULL,
  `saleBooks` int(11) DEFAULT NULL,
  `hostBooks` int(11) DEFAULT NULL,
  `specialBooks` int(11) DEFAULT NULL,
  `bookNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  KEY `subTypeId` (`subTypeId`),
  KEY `superTypeId` (`superTypeId`),
  CONSTRAINT `tb_book_ibfk_1` FOREIGN KEY (`subTypeId`) REFERENCES `tb_subtype` (`subTypeId`),
  CONSTRAINT `tb_book_ibfk_2` FOREIGN KEY (`superTypeId`) REFERENCES `tb_supertype` (`superTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('1', '1', '1', '皇帝柠檬2', '200907046', '《皇帝与柠檬经济学中的人性》讲述了：皇帝和柠檬有什么关系？如果我们把皇帝和大臣之间的关系看作一种交易，皇帝和大臣的关系就是柠檬市场，由于信息的不对称而引发种种问题。现实中许多我们认为很抽象很感性的事物，实际上都有其理性的根源....', '25', '16.8', 'images/book1.jpg', '320', '文学出版社', '布鲁斯', '2011-05-12 08:54:57', '1', '1', '0', '0', '120');
INSERT INTO `tb_book` VALUES ('2', '1', '1', '我们的杜拉拉2', '200907047', '《我们的杜拉拉》收录了李可独家访谈，柳传志、徐静蕾、姚晨、赵赵、郎平以及千万读者感动热评，杜拉拉经典语录....', '36', '22.4', 'images/book5.jpg', '230', '新华出版社', '爱死布鲁斯', '2011-05-12 08:54:57', '0', '1', '0', '1', '120');
INSERT INTO `tb_book` VALUES ('3', '1', '1', '佐藤可士和的超整理术2', '200907048', '《佐藤可士和的超整理术》：如果说原研哉奠定了无印良品的设计哲学的话,那佐藤可士和就创造了UNIQLO优衣库的视觉精神,而现在UNIQLO已经成为了一个新的日本设计象征....', '56', '49.8', 'images/book3.jpg', '412', '新华出版社', '桑德勒', '2011-05-12 08:54:57', '0', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('4', '1', '1', 'EnglishBook2', '200907049', 'This is the Asian adaptation of N. Gregory Mankiw s market leading textbook Principles of Economics. While maintaining all the strengths of the original book, Professor Euston Quah and Dr. Peter Wilson have provided materials and examples that are most relevant to students in Asia.', '39', '37.4', 'images/book9.jpg', '502', '新华出版社', '希特勒桑德勒', '2011-05-12 08:54:57', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('5', '1', '1', '郎咸平说', '9787531723951', '在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势', '25', '13.6', 'images/2.jpg', '128', '北方文艺出版社', '郎咸平', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('6', '1', '1', '郎咸平说234', '97875317239511', '在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势', '25', '13.6', 'images/3.jpg', '128', '北方文艺出版社', '郎咸平', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('7', '1', '1', '郎咸平说6767', '97875317239512', '在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势', '25', '13.6', 'images/4.jpg', '128', '北方文艺出版社', '郎咸平', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('8', '1', '1', '郎咸平说897', '97875317239514', '在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势', '34', '23.6', 'images/5.jpg', '128', '北方文艺出版社', '郎咸平', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('9', '1', '1', '郎咸平说455', '97875317239517', '在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势', '39', '37.6', 'images/6.jpg', '128', '北方文艺出版社', '郎咸平', '2011-05-12 08:54:58', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('10', '1', '1', '晚间西红柿减肥', '9787531723950', '本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦', '22', '11.6', 'images/1.jpg', '128', '北方文艺出版社', '（日）唐泽明　著，周晓晗　译', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('11', '1', '1', '晚间西红柿', '9787531723987', '本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士”--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦', '54', '46.6', 'images/7.jpg', '128', '北方文艺出版社', '（日）唐泽明　著，周晓晗　译', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('12', '1', '1', '西红柿', '97875317239657', '本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士”--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦', '34', '26.6', 'images/8.jpg', '128', '北方文艺出版社', '（日）唐泽明　著，周晓晗　译', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');
INSERT INTO `tb_book` VALUES ('13', '1', '1', '西红柿平', '978753176657', '本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，日本第一的西红柿博士”--唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦', '44', '36.6', 'images/9.jpg', '128', '北方文艺出版社', '（日）唐泽明　著，周晓晗　译', '2011-05-12 09:04:05', '1', '1', '1', '1', '120');

-- ----------------------------
-- Table structure for tb_inform
-- ----------------------------
DROP TABLE IF EXISTS `tb_inform`;
CREATE TABLE `tb_inform` (
  `informId` int(11) NOT NULL AUTO_INCREMENT,
  `informTitle` varchar(30) DEFAULT NULL,
  `informContent` varchar(30) DEFAULT NULL,
  `informTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`informId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_inform
-- ----------------------------

-- ----------------------------
-- Table structure for tb_note
-- ----------------------------
DROP TABLE IF EXISTS `tb_note`;
CREATE TABLE `tb_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `content` varchar(50) NOT NULL,
  `ly_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `imgs` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_note
-- ----------------------------

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `realName` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `orderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderitem`;
CREATE TABLE `tb_orderitem` (
  `orderItemId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  `bookName` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `bookNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItemId`),
  KEY `orderId` (`orderId`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `tb_orderitem_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `tb_order` (`orderId`),
  CONSTRAINT `tb_orderitem_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `tb_book` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for tb_subtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_subtype`;
CREATE TABLE `tb_subtype` (
  `subTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `superTypeId` int(11) DEFAULT NULL,
  `subTypeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`subTypeId`),
  KEY `superTypeId` (`superTypeId`),
  CONSTRAINT `tb_subtype_ibfk_1` FOREIGN KEY (`superTypeId`) REFERENCES `tb_supertype` (`superTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_subtype
-- ----------------------------
INSERT INTO `tb_subtype` VALUES ('1', '1', '程序设计');
INSERT INTO `tb_subtype` VALUES ('2', '1', '网络技术');
INSERT INTO `tb_subtype` VALUES ('3', '1', '计算机基础');
INSERT INTO `tb_subtype` VALUES ('4', '2', '中国文学');
INSERT INTO `tb_subtype` VALUES ('5', '2', '外国文学');
INSERT INTO `tb_subtype` VALUES ('6', '3', '油画');
INSERT INTO `tb_subtype` VALUES ('7', '3', '水彩');
INSERT INTO `tb_subtype` VALUES ('8', '3', '雕刻');

-- ----------------------------
-- Table structure for tb_supertype
-- ----------------------------
DROP TABLE IF EXISTS `tb_supertype`;
CREATE TABLE `tb_supertype` (
  `superTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`superTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_supertype
-- ----------------------------
INSERT INTO `tb_supertype` VALUES ('1', 'IT技术');
INSERT INTO `tb_supertype` VALUES ('2', '文学');
INSERT INTO `tb_supertype` VALUES ('3', '艺术');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(50) NOT NULL,
  `trueName` varchar(40) NOT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `mphone` varchar(15) DEFAULT NULL,
  `question` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL,
  `img` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT '1000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
