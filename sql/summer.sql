/*
 Navicat MySQL Data Transfer

 Source Server         : li
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : summer

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 29/07/2019 11:25:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('li', 'li1234');

-- ----------------------------
-- Table structure for carport
-- ----------------------------
DROP TABLE IF EXISTS `carport`;
CREATE TABLE `carport`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cinfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `crent` double(255, 0) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carport
-- ----------------------------
INSERT INTO `carport` VALUES (1, 'images/雪佛兰新科鲁兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰新科鲁兹', 99, 1);
INSERT INTO `carport` VALUES (2, 'images/雪佛兰科鲁兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰科鲁兹', 100, 1);
INSERT INTO `carport` VALUES (3, 'images/大众朗逸.jpg', '三厢|1.6自动|乘坐5人', '大众朗逸', 100, 1);
INSERT INTO `carport` VALUES (4, 'images/别克英朗.jpg', '三厢|1.5自动|乘坐5人', '别克英朗', 112, 0);
INSERT INTO `carport` VALUES (5, 'images/别克昂科拉.jpg', 'SUV|1.4T自动|乘坐5人', '别克昂科拉', 130, 0);
INSERT INTO `carport` VALUES (6, 'images/宝沃BX5.jpg', 'SUV|1.4T自动|乘坐5人', '宝沃BX5', 144, 1);
INSERT INTO `carport` VALUES (7, 'images/起亚K5.jpg', '三厢|2.0自动|乘坐5人', '起亚K5', 163, 1);
INSERT INTO `carport` VALUES (8, 'images/路虎发现神行.jpg', 'SUV|2.0T自动|乘坐5人', '路虎发现神行', 713, 1);
INSERT INTO `carport` VALUES (9, 'images/大众朗逸.jpg', '三厢|1.6手动|乘坐5人', '大众朗逸', 89, 1);
INSERT INTO `carport` VALUES (16, 'images/雪佛兰科鲁兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰科鲁兹', 121, 1);
INSERT INTO `carport` VALUES (17, 'images/雪佛兰科沃兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰科沃兹', 121, 1);
INSERT INTO `carport` VALUES (18, 'images/沃尔沃S90.jpg', '三厢|2.0T自动|乘坐5人', '沃尔沃S90', 791, 1);
INSERT INTO `carport` VALUES (19, 'images/路虎揽胜极光.jpg', 'SUV|2.0T自动|乘坐5人', '路虎揽胜极光', 765, 1);
INSERT INTO `carport` VALUES (20, 'images/别克GL8.jpg', '7座|2.4自动|乘坐7人', '别克GL8', 494, 1);
INSERT INTO `carport` VALUES (21, 'images/大众速腾时尚版.jpg', '自动|5座', '大众速腾时尚版', 102, 1);
INSERT INTO `carport` VALUES (22, 'images/大众朗逸或同组车型.jpg', '自动|5座', '大众朗逸或同组车型', 102, 1);
INSERT INTO `carport` VALUES (23, 'images/宝马3系.jpg', '随机分配如宝马320Li', '宝马3系', 500, 1);

-- ----------------------------
-- Table structure for corder
-- ----------------------------
DROP TABLE IF EXISTS `corder`;
CREATE TABLE `corder`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `crent` double(255, 0) NULL DEFAULT NULL,
  `takeTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `getTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of corder
-- ----------------------------
INSERT INTO `corder` VALUES (21, 4, '别克英朗', '111@qq.com', 344, '2019-07-29 10:57', '2019-07-31 10:57', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111@qq.com', 'lil', '111111', '男', '1111111', '绍兴', 1);

SET FOREIGN_KEY_CHECKS = 1;
