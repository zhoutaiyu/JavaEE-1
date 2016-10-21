/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50713
Source Host           : 127.0.0.1:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-10-21 17:57:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `is_del` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '女装男装', null, '0');
INSERT INTO `category` VALUES ('2', '鞋靴箱包', null, '0');
INSERT INTO `category` VALUES ('3', '运动户外', null, '0');
INSERT INTO `category` VALUES ('4', '珠宝配饰', null, '0');
INSERT INTO `category` VALUES ('5', '手机数码', null, '0');
INSERT INTO `category` VALUES ('6', '家电办公', null, '0');
INSERT INTO `category` VALUES ('7', '护肤彩妆', null, '0');

-- ----------------------------
-- Table structure for categorysecond
-- ----------------------------
DROP TABLE IF EXISTS `categorysecond`;
CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cstime` datetime DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `is_del` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `FK936FCAF21DB1FD15` (`cid`),
  CONSTRAINT `FKh1rpx0qlb42dq81f2v1ow5oqh` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorysecond
-- ----------------------------
INSERT INTO `categorysecond` VALUES ('1', '男装', null, '1', '0');
INSERT INTO `categorysecond` VALUES ('2', '女装', null, '1', '0');
INSERT INTO `categorysecond` VALUES ('3', '手机', null, '6', '0');
INSERT INTO `categorysecond` VALUES ('4', '电脑', null, '6', '0');
INSERT INTO `categorysecond` VALUES ('5', '办公室', null, '6', '0');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `oiid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oiid`),
  KEY `FKE8B2AB6166C01961` (`oid`),
  KEY `FKE8B2AB6171DB7AE4` (`pid`),
  CONSTRAINT `FK3933auil4yrjm19ay5e6hqh5r` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `FKt46aaoxdwtns0rq58w0papv91` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('48', '1', '89.99', '5', '50');
INSERT INTO `orderitem` VALUES ('49', '3', '269.97', '7', '50');
INSERT INTO `orderitem` VALUES ('50', '1', '89.99', '1', '51');
INSERT INTO `orderitem` VALUES ('51', '1', '89.99', '7', '52');
INSERT INTO `orderitem` VALUES ('52', '1', '89.99', '13', '52');
INSERT INTO `orderitem` VALUES ('53', '5', '449.95', '7', '53');
INSERT INTO `orderitem` VALUES ('54', '1', '89.99', '3', '53');
INSERT INTO `orderitem` VALUES ('55', '1', '89.99', '7', '54');
INSERT INTO `orderitem` VALUES ('56', '5', '449.95', '14', '54');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `otime` datetime DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC3DF62E5AA3D9C7` (`uid`),
  CONSTRAINT `FKbdolj6vr67tqh6wgsl44mur9y` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('50', '359.96', '张三', '17854214643', '山东省', '2016-09-16 06:28:39', '1', '27');
INSERT INTO `orders` VALUES ('51', '89.99', '张三', '17854214643', '山东省', '2016-09-16 06:29:35', '1', '27');
INSERT INTO `orders` VALUES ('52', '179.98', '张三', '17854214643', '山东省', '2016-09-16 08:44:40', '1', '27');
INSERT INTO `orders` VALUES ('53', '539.94', '张三', '17854214643', '山东省', '2016-10-07 10:47:17', '1', '27');
INSERT INTO `orders` VALUES ('54', '539.94', '张三', '17854214643', '山东省', '2016-10-07 13:39:45', '1', '27');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdesc` mediumtext,
  `is_hot` tinyint(4) DEFAULT NULL,
  `ptime` datetime DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  `is_del` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKED8DCCEFB9B74E02` (`csid`),
  CONSTRAINT `FKcobqeq387r4s6we6iyulx1xf6` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '商品1', '99.99', '89.99', 'images/commodity/l.jpg', '商品1就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('2', '商品2', '99.99', '89.99', 'images/commodity/l.jpg', '商品2就是好', null, null, '1', '0');
INSERT INTO `product` VALUES ('3', '商品3', '99.99', '89.99', 'images/commodity/l.jpg', '商品3就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('4', '商品4', '99.99', '89.99', 'images/commodity/l.jpg', '商品4就是好', null, null, '1', '0');
INSERT INTO `product` VALUES ('5', '商品5', '99.99', '89.99', 'images/commodity/l.jpg', '商品5就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('6', '商品6', '99.99', '89.99', 'images/commodity/l.jpg', '商品6就是好', null, null, '1', '0');
INSERT INTO `product` VALUES ('7', '商品7', '99.99', '89.99', 'images/commodity/l.jpg', '商品7就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('8', '商品8', '99.99', '89.99', 'images/commodity/l.jpg', '商品8就是好', null, null, '1', '0');
INSERT INTO `product` VALUES ('9', '商品9', '99.99', '89.99', 'images/commodity/l.jpg', '商品9就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('10', '商品10', '99.99', '89.99', 'images/commodity/l.jpg', '商品10就是好', null, null, '2', '0');
INSERT INTO `product` VALUES ('11', '商品1', '99.99', '89.99', 'images/commodity/l.jpg', '商品1就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('12', '商品2', '99.99', '89.99', 'images/commodity/l.jpg', '商品2就是好', null, null, '2', '0');
INSERT INTO `product` VALUES ('13', '商品3', '99.99', '89.99', 'images/commodity/l.jpg', '商品3就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('14', '商品4', '99.99', '89.99', 'images/commodity/l.jpg', '商品4就是好', null, null, '3', '0');
INSERT INTO `product` VALUES ('15', '商品5', '99.99', '89.99', 'images/commodity/l.jpg', '商品5就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('16', '商品6', '99.99', '89.99', 'images/commodity/l.jpg', '商品6就是好', null, null, '4', '0');
INSERT INTO `product` VALUES ('17', '商品7', '99.99', '89.99', 'images/commodity/l.jpg', '商品7就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('18', '商品8', '99.99', '89.99', 'images/commodity/l.jpg', '商品8就是好', null, null, '1', '0');
INSERT INTO `product` VALUES ('19', '商品9', '99.99', '89.99', 'images/commodity/l.jpg', '商品9就是好', '1', null, '5', '0');
INSERT INTO `product` VALUES ('20', '商品10', '99.99', '89.99', 'images/commodity/l.jpg', '商品10就是好', null, null, '1', '0');
INSERT INTO `product` VALUES ('21', '商品11', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('22', '商品12', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '4', '0');
INSERT INTO `product` VALUES ('23', '商品13', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('24', '商品14', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '3', '0');
INSERT INTO `product` VALUES ('25', '商品15', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('26', '商品16', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('27', '商品17', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('28', '商品18', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('29', '商品19', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('30', '商品20', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('31', '商品21', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('32', '商品22', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('33', '商品13', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '0', null, '1', '0');
INSERT INTO `product` VALUES ('34', '商品12', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('35', '商品13', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('36', '商品14', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('37', '商品15', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('38', '商品16', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('39', '商品17', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('40', '商品18', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('41', '商品19', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('42', '商品20', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('43', '商品21', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('44', '商品22', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');
INSERT INTO `product` VALUES ('45', '商品13', '129.98', '119.98', 'images/commodity/l.jpg', '商品就是好', '1', null, '1', '0');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('27', 'zhangsan', '123456', '张三', 'zhangsan@shop.com', '17854214643', '山东省', '男 ', '1', '61E6F703BA2142559C7F0B394540011B0589785320264789B2F99F6A370D4288', null);
INSERT INTO `users` VALUES ('35', 'lisisi', '123456', '李四四', '1191863273@qq.com', '17854214649', '北京', '女', '1', '7F178CA170FA433EA96CEF884884963AD09F474FB16F4F19B9D6C5338CA82F25', '2016-09-04 13:26:49');
