/*
Navicat MySQL Data Transfer

Source Server         : NovelData
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : novel

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-04-24 17:48:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bookrack`
-- ----------------------------
DROP TABLE IF EXISTS `bookrack`;
CREATE TABLE `bookrack` (
  `b_id` int(10) NOT NULL AUTO_INCREMENT,
  `ref_id` int(10) NOT NULL,
  `u_id` int(10) NOT NULL,
  `b_name` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookrack
-- ----------------------------

-- ----------------------------
-- Table structure for `boorack_novel_rel`
-- ----------------------------
DROP TABLE IF EXISTS `boorack_novel_rel`;
CREATE TABLE `boorack_novel_rel` (
  `rel_id` int(10) NOT NULL AUTO_INCREMENT,
  `b_id` int(10) NOT NULL,
  `n_id` int(10) NOT NULL,
  `u_id` int(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boorack_novel_rel
-- ----------------------------

-- ----------------------------
-- Table structure for `chapters`
-- ----------------------------
DROP TABLE IF EXISTS `chapters`;
CREATE TABLE `chapters` (
  `c_id` int(10) NOT NULL COMMENT '章节id',
  `n_id` int(10) NOT NULL COMMENT '小说id',
  `c_name` varchar(32) NOT NULL COMMENT '章节名称',
  `c_content` text NOT NULL COMMENT '章节内容',
  `c_words` int(7) NOT NULL COMMENT '章节字数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '章节创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '章节更新时间',
  `c_test01` varchar(32) DEFAULT NULL,
  `c_test02` varchar(32) DEFAULT NULL,
  `c_test03` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapters
-- ----------------------------

-- ----------------------------
-- Table structure for `novels`
-- ----------------------------
DROP TABLE IF EXISTS `novels`;
CREATE TABLE `novels` (
  `n_id` int(10) NOT NULL COMMENT '小说id',
  `n_name` varchar(32) NOT NULL COMMENT '小说名称',
  `n_author` varchar(32) NOT NULL COMMENT '小说作者',
  `n_type` varchar(32) NOT NULL COMMENT '小说类型',
  `n_intro` varchar(32) DEFAULT NULL COMMENT '小说简介',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '小说创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '小说更新时间',
  `n_test01` varchar(32) DEFAULT NULL,
  `n_test02` varchar(32) DEFAULT NULL,
  `n_test03` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of novels
-- ----------------------------

-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `r_id` int(10) NOT NULL COMMENT '书评id',
  `n_id` int(10) NOT NULL COMMENT '小说id',
  `u_id` int(10) NOT NULL COMMENT '用户id',
  `r_content` text NOT NULL COMMENT '书评内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '书评创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '书评更新时间',
  `r_test01` varchar(32) DEFAULT NULL,
  `r_test02` varchar(32) DEFAULT NULL,
  `r_test03` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `u_nickname` varchar(256) NOT NULL COMMENT '用户昵称',
  `u_name` varchar(256) NOT NULL COMMENT '用户名',
  `u_password` varchar(256) NOT NULL COMMENT '用户密码',
  `u_permission` int(2) NOT NULL DEFAULT '1' COMMENT '管理权限',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `u_test01` varchar(32) DEFAULT NULL,
  `u_test02` varchar(32) DEFAULT NULL,
  `u_test03` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('-98936534', '任洋', 'Michelle Jones', '810000198511191046', '0', '2020-04-02 16:10:00', '2020-04-02 16:10:00', null, null, null);
INSERT INTO `users` VALUES ('1', '234', '567', '89', '1', '2020-03-11 18:27:07', '2020-03-18 18:27:11', null, null, null);
INSERT INTO `users` VALUES ('2', '任洋', 'Michelle Jones', '810000198511191046', '0', '2020-04-02 16:10:14', '2020-04-02 16:10:14', null, null, null);
INSERT INTO `users` VALUES ('3', '任洋', 'Michelle Jones', '810000198511191046', '0', '2020-04-02 16:10:23', '2020-04-02 16:10:23', null, null, null);
INSERT INTO `users` VALUES ('4', '任洋', 'Michelle Jones', '810000198511191046', '0', '2020-04-02 16:10:51', '2020-04-02 16:10:51', null, null, null);
INSERT INTO `users` VALUES ('5', '任洋22', 'Michelle Jones', '810000198511191046', '0', '2020-04-02 16:12:14', '2020-04-02 16:12:14', null, null, null);
INSERT INTO `users` VALUES ('6', '潘刚', 'Donna Hall', '140000201507201015', '0', '2020-04-03 17:17:05', '2020-04-03 17:17:05', null, null, null);
INSERT INTO `users` VALUES ('7', '234', '少时诵诗书所所所所所所所', '89', '0', '2020-04-06 22:21:44', '2020-04-06 22:21:44', null, null, null);
INSERT INTO `users` VALUES ('11', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:25:14', '2020-04-06 22:25:14', null, null, null);
INSERT INTO `users` VALUES ('12', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:25:14', '2020-04-06 22:25:14', null, null, null);
INSERT INTO `users` VALUES ('13', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:30:06', '2020-04-06 22:30:06', null, null, null);
INSERT INTO `users` VALUES ('14', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:30:47', '2020-04-06 22:30:47', null, null, null);
INSERT INTO `users` VALUES ('15', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:31:14', '2020-04-06 22:31:14', null, null, null);
INSERT INTO `users` VALUES ('16', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:31:38', '2020-04-06 22:31:38', null, null, null);
INSERT INTO `users` VALUES ('17', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:31:38', '2020-04-06 22:31:38', null, null, null);
INSERT INTO `users` VALUES ('18', '234', '少时诵诗书所', '89', '0', '2020-04-06 22:32:07', '2020-04-06 22:32:07', null, null, null);
INSERT INTO `users` VALUES ('19', '234', '牛批', '89', '0', '2020-04-24 16:44:47', '2020-04-24 16:44:47', null, null, null);
