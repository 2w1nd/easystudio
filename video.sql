/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : video

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 08/07/2021 16:21:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `years` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `poster` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES (1, '复仇者联盟', '1.mp4', '2020', 'poster_1.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (2, '蚁人2', '2.mp4', '2019', 'poster_2.jpg', 'back_2.jpg');
INSERT INTO `movie` VALUES (3, '蚁人', '1.mp4', '2019', 'poster_3.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (4, '复仇者联盟1', '1.mp4', '2015', 'poster_4.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (5, '美国队长:内战', '1.mp4', '2016', 'poster_5.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (6, '复仇者联盟2', '1.mp4', '2019', 'poster_6.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (7, '美国队长1', '1.mp4', '2011', 'poster_7.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (8, '奇异博士', '1.mp4', '2016', 'poster_8.jpg', 'back_2.jpg');
INSERT INTO `movie` VALUES (9, '银河护卫队2', '1.mp4', '2017', 'poster_9.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (10, '钢铁侠', '1.mp4', '2013', 'poster_10.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (11, '蜘蛛侠', '1.mp4', '2017', 'poster_11.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (12, '绿巨人', '1.mp4', '2008', 'poster_12.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (13, '雷神3', '1.mp4', '2017', 'poster_13.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (14, '雷神2', '1.mp4', '2013', 'poster_14.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (15, '雷神', '1.mp4', '2011', 'poster_15.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (16, '钢铁侠', '1.mp4', '2008', 'poster_16.jpg', 'back_1.jpg');
INSERT INTO `movie` VALUES (17, '蜘蛛侠:离家出走', '1.mp4', '2019', 'poster_17.jpg', 'back_1.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4a2cda9bdf8a4a8c9912319fbce00f9c', 'admin', 'abc123456', '123456789@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
