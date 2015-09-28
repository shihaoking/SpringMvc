/*
Navicat MySQL Data Transfer

Source Server         : tenxcloud.net
Source Server Version : 50173
Source Host           : mycentos-2-jinshihao.tenxcloud.net:46875
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-09-27 14:29:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) NOT NULL,
  `alert_date` datetime NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('4', '去上班', '2015-09-17 15:12:12', '这是一个上班提醒', '2015-09-17 15:12:13', '2015-09-17 15:12:13', '1');
INSERT INTO `schedule` VALUES ('7', '看新闻', '2015-09-17 15:13:26', '这是一个日常提醒', '2015-09-17 15:13:27', '2015-09-17 15:13:27', '1');
INSERT INTO `schedule` VALUES ('8', '看新闻', '2015-09-17 15:13:48', '这是一个日常提醒', '2015-09-17 15:13:48', '2015-09-17 15:13:48', '1');
INSERT INTO `schedule` VALUES ('10', '写周报', '3915-10-27 00:00:00', '一定要记得写！！', '2015-09-26 10:03:26', '2015-09-26 10:03:26', '1');
INSERT INTO `schedule` VALUES ('11', '写周报', '3915-10-27 14:00:00', '一定要记得写！！', '2015-09-27 00:08:28', '2015-09-27 00:08:28', '1');
INSERT INTO `schedule` VALUES ('12', '写周报', '3915-10-27 14:00:00', '一定要记得写！！', '2015-09-27 00:09:03', '2015-09-27 00:09:03', '1');
INSERT INTO `schedule` VALUES ('13', '写周报', '3915-10-27 14:00:00', '一定要记得写！！', '2015-09-27 00:12:57', '2015-09-27 00:12:57', '1');
