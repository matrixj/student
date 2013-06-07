/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : studentsystem

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2013-06-07 16:38:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `Did` int(11) NOT NULL,
  `Major` varchar(100) NOT NULL,
  `Grade` varchar(100) NOT NULL,
  `Class` varchar(100) NOT NULL,
  PRIMARY KEY (`Did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('2', 'math', '2010', '1');

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `Mid` int(11) NOT NULL AUTO_INCREMENT,
  `No` varchar(20) NOT NULL,
  `Suid` int(11) NOT NULL,
  `Tid` int(11) NOT NULL,
  `Score` decimal(5,2) NOT NULL,
  PRIMARY KEY (`Mid`),
  KEY `No_FK` (`No`),
  KEY `Suid_FK` (`Suid`),
  KEY `Tid_FK` (`Tid`),
  CONSTRAINT `Tid_FK` FOREIGN KEY (`Tid`) REFERENCES `teacher` (`Tid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `No_FK` FOREIGN KEY (`No`) REFERENCES `student` (`No`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Suid_FK` FOREIGN KEY (`Suid`) REFERENCES `subject` (`Suid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mark
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `No` varchar(20) NOT NULL,
  `Did` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Sex` varchar(5) DEFAULT NULL,
  `Password` varchar(16) NOT NULL,
  PRIMARY KEY (`No`),
  KEY `Did_FK` (`Did`),
  CONSTRAINT `Did_FK` FOREIGN KEY (`Did`) REFERENCES `department` (`Did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2', 'ben', 'm', '123');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `Suid` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`Suid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Tid` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Password` varchar(16) NOT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_subject
-- ----------------------------
DROP TABLE IF EXISTS `teacher_subject`;
CREATE TABLE `teacher_subject` (
  `Suid` int(11) NOT NULL,
  `Tid` int(11) NOT NULL,
  PRIMARY KEY (`Suid`,`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_subject
-- ----------------------------
