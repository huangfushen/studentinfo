/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : db_student

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2018-03-21 23:15:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_admin`
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES ('1', 'admin', '1', '2018-03-17 14:24:09');

-- ----------------------------
-- Table structure for `s_class`
-- ----------------------------
DROP TABLE IF EXISTS `s_class`;
CREATE TABLE `s_class` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `info` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_class
-- ----------------------------
INSERT INTO `s_class` VALUES ('2', '软件一班', '这是软件一班。');
INSERT INTO `s_class` VALUES ('6', '的撒旦', '的撒旦');
INSERT INTO `s_class` VALUES ('7', '奋斗的公司的', '');
INSERT INTO `s_class` VALUES ('9', '大撒333', '');

-- ----------------------------
-- Table structure for `s_student`
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `classId` int(5) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_foreign` (`classId`),
  CONSTRAINT `class_foreign` FOREIGN KEY (`classId`) REFERENCES `s_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES ('1', '张三', '2', '1', '女');
INSERT INTO `s_student` VALUES ('3', '李四', '6', '11', '女');
INSERT INTO `s_student` VALUES ('4', '王麻子', '7', '1', '保密');

-- ----------------------------
-- Table structure for `s_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `s_teacher`;
CREATE TABLE `s_teacher` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `title` varchar(32) NOT NULL,
  `age` int(5) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_teacher
-- ----------------------------
INSERT INTO `s_teacher` VALUES ('3', '张三', '男', '教授', '35', '1');
INSERT INTO `s_teacher` VALUES ('4', '李四', '男', '博导', '58', '222');
INSERT INTO `s_teacher` VALUES ('5', '王麻子', '男', '讲师', '28', '000000');
