/*
MySQL Data Transfer
Source Host: localhost
Source Database: studentmanager
Target Host: localhost
Target Database: studentmanager
Date: 2013/6/14 12:24:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for department
-- ----------------------------
CREATE TABLE `department` (
  `Did` int(11) NOT NULL auto_increment,
  `Major` varchar(100) NOT NULL,
  `Grade` varchar(100) NOT NULL,
  `Class` varchar(100) NOT NULL,
  PRIMARY KEY  (`Did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mark
-- ----------------------------
CREATE TABLE `mark` (
  `Mid` int(11) NOT NULL auto_increment,
  `No` varchar(20) NOT NULL,
  `Suid` int(11) NOT NULL,
  `Tid` int(11) NOT NULL,
  `Score` decimal(5,2) NOT NULL,
  PRIMARY KEY  (`Mid`),
  KEY `No_FK` (`No`),
  KEY `Suid_FK` (`Suid`),
  KEY `Tid_FK` (`Tid`),
  CONSTRAINT `No_FK` FOREIGN KEY (`No`) REFERENCES `student` (`No`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Suid_FK` FOREIGN KEY (`Suid`) REFERENCES `subject` (`Suid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Tid_FK` FOREIGN KEY (`Tid`) REFERENCES `teacher` (`Tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE `student` (
  `No` varchar(20) NOT NULL,
  `Did` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Sex` varchar(5) default NULL,
  `Password` varchar(16) NOT NULL,
  PRIMARY KEY  (`No`),
  KEY `Did_FK` (`Did`),
  CONSTRAINT `Did_FK` FOREIGN KEY (`Did`) REFERENCES `department` (`Did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
CREATE TABLE `subject` (
  `Suid` int(11) NOT NULL auto_increment,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY  (`Suid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
CREATE TABLE `teacher` (
  `Tid` int(11) NOT NULL auto_increment,
  `Name` varchar(100) NOT NULL,
  `Password` varchar(16) NOT NULL,
  PRIMARY KEY  (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher_subject
-- ----------------------------
CREATE TABLE `teacher_subject` (
  `Suid` int(11) NOT NULL,
  `Tid` int(11) NOT NULL,
  PRIMARY KEY  (`Suid`,`Tid`),
  KEY `FK_teacher_subject_tid` (`Tid`),
  CONSTRAINT `FK_teacher_subject_suid` FOREIGN KEY (`Suid`) REFERENCES `subject` (`Suid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_teacher_subject_tid` FOREIGN KEY (`Tid`) REFERENCES `teacher` (`Tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `department` VALUES ('2', 'math', '2010', '1');
INSERT INTO `department` VALUES ('3', 'math', '2010', '2');
INSERT INTO `department` VALUES ('4', '软件工程', '2009', '1');
INSERT INTO `department` VALUES ('5', '软件工程', '2010', '1');
INSERT INTO `mark` VALUES ('1', '1', '1', '1', '60.00');
INSERT INTO `mark` VALUES ('2', '2', '1', '1', '61.00');
INSERT INTO `mark` VALUES ('3', '2', '2', '2', '90.00');
INSERT INTO `student` VALUES ('1', '2', 'ben', 'm', '123');
INSERT INTO `student` VALUES ('2', '3', 'fuck', 'm', '123');
INSERT INTO `student` VALUES ('3', '2', 'ben2', 'm', '123');
INSERT INTO `student` VALUES ('4', '2', 'ben3', 'm', '123');
INSERT INTO `subject` VALUES ('1', 'jsp');
INSERT INTO `subject` VALUES ('2', '高数');
INSERT INTO `subject` VALUES ('3', 'C#');
INSERT INTO `subject` VALUES ('4', 'C语言');
INSERT INTO `subject` VALUES ('5', '软件工程');
INSERT INTO `teacher` VALUES ('1', '朱凯', '123456');
INSERT INTO `teacher` VALUES ('2', '财爷', '123');
INSERT INTO `teacher_subject` VALUES ('1', '1');
INSERT INTO `teacher_subject` VALUES ('5', '1');
INSERT INTO `teacher_subject` VALUES ('2', '2');
