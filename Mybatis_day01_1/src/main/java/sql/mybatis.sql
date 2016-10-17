/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50713
Source Host           : 127.0.0.1:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-10-17 15:11:08
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id`         INT(11)      NOT NULL AUTO_INCREMENT,
  `name`       VARCHAR(32)  NOT NULL
  COMMENT '商品名称',
  `price`      FLOAT(10, 1) NOT NULL
  COMMENT '商品定价',
  `detail`     TEXT COMMENT '商品描述',
  `pic`        VARCHAR(64)           DEFAULT NULL
  COMMENT '商品图片',
  `createtime` DATETIME     NOT NULL
  COMMENT '生产日期',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '台式机', '3000.0', '该电脑质量非常好！！！！', NULL, '2015-02-03 13:22:53');
INSERT INTO `items` VALUES ('2', '笔记本', '6000.0', '笔记本性能好，质量好！！！！！', NULL, '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('3', '背包', '200.0', '名牌背包，容量大质量好！！！！', NULL, '2015-02-06 13:23:02');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `orders_id` INT(11) NOT NULL
  COMMENT '订单id',
  `items_id`  INT(11) NOT NULL
  COMMENT '商品id',
  `items_num` INT(11)          DEFAULT NULL
  COMMENT '商品购买数量',
  PRIMARY KEY (`id`),
  KEY `FK_orderdetail_1` (`orders_id`),
  KEY `FK_orderdetail_2` (`items_id`),
  CONSTRAINT `FK_orderdetail_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_orderdetail_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '3', '1', '1');
INSERT INTO `orderdetail` VALUES ('2', '3', '2', '3');
INSERT INTO `orderdetail` VALUES ('3', '4', '3', '4');
INSERT INTO `orderdetail` VALUES ('4', '4', '2', '3');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id`         INT(11)     NOT NULL AUTO_INCREMENT,
  `user_id`    INT(11)     NOT NULL
  COMMENT '下单用户id',
  `number`     VARCHAR(32) NOT NULL
  COMMENT '订单号',
  `createtime` DATETIME    NOT NULL
  COMMENT '创建订单时间',
  `note`       VARCHAR(100)         DEFAULT NULL
  COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_orders_1` (`user_id`),
  CONSTRAINT `FK_orders_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('3', '1', '1000010', '2015-02-04 13:22:35', NULL);
INSERT INTO `orders` VALUES ('4', '1', '1000011', '2015-02-03 13:22:41', NULL);
INSERT INTO `orders` VALUES ('5', '10', '1000012', '2015-02-12 16:13:23', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id`       INT(11)     NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL
  COMMENT '用户名称',
  `birthday` DATE                 DEFAULT NULL
  COMMENT '生日',
  `sex`      CHAR(1)              DEFAULT NULL
  COMMENT '性别',
  `address`  VARCHAR(256)         DEFAULT NULL
  COMMENT '地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 33
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王五', NULL, '2', NULL);
INSERT INTO `user` VALUES ('10', '张三', '2014-07-10', '1', '北京市');
INSERT INTO `user` VALUES ('16', '张小明', NULL, '1', '河南郑州');
INSERT INTO `user` VALUES ('22', '陈小明', NULL, '1', '河南郑州');
INSERT INTO `user` VALUES ('24', '张三丰', NULL, '1', '河南郑州');
INSERT INTO `user` VALUES ('25', '陈小明', NULL, '1', '河南郑州');
INSERT INTO `user` VALUES ('26', '王五', '2016-10-16', '1', '上海');
INSERT INTO `user` VALUES ('27', '张三', '2016-10-15', '1', '北京');
INSERT INTO `user` VALUES ('30', '李三', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('31', '李三', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('32', '李三', NULL, NULL, NULL);
