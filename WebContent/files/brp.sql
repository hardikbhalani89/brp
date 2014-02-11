/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50123
Source Host           : localhost:3306
Source Database       : brp

Target Server Type    : MYSQL
Target Server Version : 50123
File Encoding         : 65001

Date: 2014-02-11 21:25:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rolemaster`
-- ----------------------------
DROP TABLE IF EXISTS `rolemaster`;
CREATE TABLE `rolemaster` (
  `id` int(11) NOT NULL DEFAULT '0',
  `role` varchar(10) DEFAULT NULL,
  `lastupdatedate` time DEFAULT NULL,
  `lastupdateip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rolemaster
-- ----------------------------

-- ----------------------------
-- Table structure for `usermaster`
-- ----------------------------
DROP TABLE IF EXISTS `usermaster`;
CREATE TABLE `usermaster` (
  `id` int(11) NOT NULL DEFAULT '0',
  `roleid` int(11) DEFAULT NULL,
  `firstname` varchar(15) DEFAULT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `mobileno` varchar(15) DEFAULT NULL,
  `altmobile` varchar(15) DEFAULT NULL,
  `profilepic` varchar(255) DEFAULT NULL,
  `lastupdatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `lastupdateip` varchar(20) DEFAULT NULL,
  `deviceid` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of usermaster
-- ----------------------------
