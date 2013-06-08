/*
MySQL Data Transfer
Source Host: localhost
Source Database: studentmanager
Target Host: localhost
Target Database: studentmanager
Date: 2013/6/8 19:18:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for department
-- ----------------------------
CREATE TABLE `department` (
  `Did` int(11) NOT NULL,
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
  `Suid` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY  (`Suid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
CREATE TABLE `teacher` (
  `Tid` int(11) NOT NULL,
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
  CONSTRAINT `FK_teacher_subject_tid` FOREIGN KEY (`Tid`) REFERENCES `teacher` (`Tid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_teacher_subject_suid` FOREIGN KEY (`Suid`) REFERENCES `subject` (`Suid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `department` VALUES ('2', 'math', '2010', '1');
INSERT INTO `student` VALUES ('1', '2', 'ben', 'm', '123');
