/*
Navicat MySQL Data Transfer

Source Server         : 172.24.3.30
Source Server Version : 50548
Source Host           : 172.24.3.30:3306
Source Database       : oms

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2016-07-13 15:53:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `mail_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '邮箱ID',
  `type` int(1) NOT NULL DEFAULT '1' COMMENT '邮箱类型0：草稿1：申请2：审核3：加班到期提醒',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态1：有效0：无效',
  `content` longtext COLLATE utf8_unicode_ci NOT NULL,
  `receive_users` mediumtext COLLATE utf8_unicode_ci NOT NULL COMMENT '接收人',
  `copy_user` mediumtext COLLATE utf8_unicode_ci COMMENT '抄送人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  UNIQUE KEY `mail_id` (`mail_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES ('60', '1', '1', '我要加12小时', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 20:22:58', null, 'admin', null);
INSERT INTO `mail` VALUES ('61', '1', '1', 'ASDFGHJK;\'/\n\';LKHYR', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 20:27:01', null, 'user', null);
INSERT INTO `mail` VALUES ('62', '2', '1', 'asdhfgjjnbvcxz新年开始    名称数量', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com;test@baifendian.com', '2016-07-09 20:29:39', null, 'admin', null);
INSERT INTO `mail` VALUES ('63', '2', '1', '阿萨德 说着说着', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com;test@baifendian.com', '2016-07-09 20:32:01', null, 'admin', null);
INSERT INTO `mail` VALUES ('64', '2', '1', '阿萨德 说着说着', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com;test@baifendian.com', '2016-07-09 20:32:16', null, 'admin', null);
INSERT INTO `mail` VALUES ('65', '2', '1', '啥都吃v不能', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com;test@baifendian.com', '2016-07-09 20:33:36', null, 'admin', null);
INSERT INTO `mail` VALUES ('66', '2', '1', '123', 'wu.wang@baifendian.com', 'wu.wang@baifendian.com', '2016-07-09 20:37:36', null, 'admin', null);
INSERT INTO `mail` VALUES ('67', '2', '1', 'fdsafnhtgra', 'wu.wang@baifendian.com', 'wu.wang@baifendian.com', '2016-07-09 20:46:50', null, 'admin', null);
INSERT INTO `mail` VALUES ('68', '2', '1', '123', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com;test@baifendian.com', '2016-07-09 20:51:12', null, 'admin', null);
INSERT INTO `mail` VALUES ('70', '2', '1', 'fdsafdsafdsa', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com;test@baifendian.com', '2016-07-09 20:56:59', null, 'admin', null);
INSERT INTO `mail` VALUES ('71', '2', '1', '项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了项目太忙了', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com;test@baifendian.com', '2016-07-09 21:06:43', null, 'admin', null);
INSERT INTO `mail` VALUES ('72', '1', '1', 'erthj', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 21:10:13', null, 'user', null);
INSERT INTO `mail` VALUES ('73', '2', '1', 'ASDFHJ', 'wu.wang@baifendian.com;test@baifendian.com', 'test@baifendian.com', '2016-07-09 21:13:46', null, 'admin', null);
INSERT INTO `mail` VALUES ('74', '1', '1', 'asdfasdfsadfasdfsadf', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 22:02:49', null, 'admin', null);
INSERT INTO `mail` VALUES ('75', '1', '1', 'asdfsadfsadfs', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 22:03:46', null, 'admin', null);
INSERT INTO `mail` VALUES ('76', '2', '1', 'ASGJM,', 'test@baifendian.com', 'test@baifendian.com', '2016-07-09 22:42:44', null, 'admin', null);
INSERT INTO `mail` VALUES ('77', '1', '1', 'sdf', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 22:45:22', null, 'admin', null);
INSERT INTO `mail` VALUES ('86', '2', '1', 'fg', 'test@baifendian.com', 'test@baifendian.com', '2016-07-09 22:47:24', null, 'admin', null);
INSERT INTO `mail` VALUES ('87', '2', '1', 'fg', 'test@baifendian.com', 'test@baifendian.com', '2016-07-09 22:47:25', null, 'admin', null);
INSERT INTO `mail` VALUES ('88', '2', '1', 'ncv', 'test@baifendian.com', 'wu.wang@baifendian.com', '2016-07-09 22:47:37', null, 'admin', null);
INSERT INTO `mail` VALUES ('89', '1', '1', 'asdfsadfsadfsadf', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 22:55:07', null, 'admin', null);
INSERT INTO `mail` VALUES ('94', '2', '1', 'aa', 'wu.wang@baifendian.com;test@baifendian.com', 'wu.wang@baifendian.com', '2016-07-09 23:03:43', null, 'admin', null);
INSERT INTO `mail` VALUES ('95', '1', '1', 'awsdf', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 23:11:48', null, 'admin', null);
INSERT INTO `mail` VALUES ('96', '2', '1', 'etr', 'test@baifendian.com', 'test@baifendian.com', '2016-07-09 23:13:51', null, 'admin', null);
INSERT INTO `mail` VALUES ('97', '1', '1', 'c', 'mingyi.yu@baifendian.com', 'xinyi.zhu@baifendian.com', '2016-07-09 23:15:18', null, 'admin', null);
INSERT INTO `mail` VALUES ('98', '2', '1', 'asdf', 'test@baifendian.com', 'test@baifendian.com', '2016-07-09 23:16:22', null, 'admin', null);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `menu_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '菜单名',
  `menu_type` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '0 表示目录　1 表示菜单　2 表示按扭',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父亲节点id 没有为0',
  `res_key` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '权限代码',
  `res_url` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '链接',
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用 1启用 0不启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `res_key` (`res_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '首页', '1', '0', 'VIEW_HOME', '/home.do', '首页', '1', '2016-06-25 22:01:35', '2016-06-25 22:01:35', null, null);
INSERT INTO `menu` VALUES ('2', '个人管理', '1', '0', 'VIEW_PERSON', '/person.do', '个人管理', '1', '2016-06-25 22:01:35', '2016-06-25 22:01:35', null, null);
INSERT INTO `menu` VALUES ('3', '工时管理', '1', '0', 'VIEW_WORK', '/work.do', '工时管理', '1', '2016-06-25 22:01:35', '2016-06-25 22:01:35', null, null);
INSERT INTO `menu` VALUES ('4', '角色管理', '1', '0', 'VIEW_ROLE', '/role.do', '角色管理', '1', '2016-06-25 22:01:35', '2016-06-25 22:01:35', null, null);
INSERT INTO `menu` VALUES ('5', '审核管理', '1', '0', 'VIEW_AUDIT', '/audit.do', '审核管理', '1', '2016-06-25 22:01:35', '2016-06-25 22:01:35', null, null);
INSERT INTO `menu` VALUES ('6', '员工管理', '1', '0', 'VIEW_EMP', '/work/PageEmployeeCenter', '员工管理', '1', '2016-06-25 22:01:35', '2016-06-25 22:01:35', null, null);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `menu_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用 1启用 0不启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`menu_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('1', '1', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);
INSERT INTO `menu_role` VALUES ('1', '2', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);
INSERT INTO `menu_role` VALUES ('1', '3', '1', '2016-06-25 22:15:39', '2016-06-25 22:15:39', null, null);
INSERT INTO `menu_role` VALUES ('2', '1', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);
INSERT INTO `menu_role` VALUES ('2', '2', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);
INSERT INTO `menu_role` VALUES ('2', '3', '1', '2016-06-25 22:16:19', '2016-06-25 22:16:19', null, null);
INSERT INTO `menu_role` VALUES ('3', '1', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);
INSERT INTO `menu_role` VALUES ('3', '2', '1', '2016-06-25 22:16:49', '2016-06-25 22:16:49', null, null);
INSERT INTO `menu_role` VALUES ('3', '3', '1', '2016-06-25 22:16:57', '2016-06-25 22:16:57', null, null);
INSERT INTO `menu_role` VALUES ('4', '2', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);
INSERT INTO `menu_role` VALUES ('4', '3', '1', '2016-06-25 22:17:02', '2016-06-25 22:17:02', null, null);
INSERT INTO `menu_role` VALUES ('5', '1', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);
INSERT INTO `menu_role` VALUES ('5', '2', '1', '2016-06-25 22:17:14', '2016-06-25 22:17:14', null, null);
INSERT INTO `menu_role` VALUES ('5', '3', '1', '2016-06-25 22:17:21', '2016-06-25 22:17:21', null, null);
INSERT INTO `menu_role` VALUES ('6', '1', '1', '2016-06-25 22:17:44', '2016-06-25 22:17:44', null, null);
INSERT INTO `menu_role` VALUES ('6', '2', '1', '2016-06-25 22:01:14', '2016-06-25 22:01:14', null, null);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '角色名',
  `role_key` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '角色键',
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '1：有效0无效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_key` (`role_key`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'admin', 'ROLE_ADMIN', '负责授权', '1', '2016-06-25 22:00:55', '2016-06-25 22:00:55', null, null);
INSERT INTO `roles` VALUES ('2', 'HR', 'ROLE_HR', '浏览职工加班情况', '1', '2016-06-25 22:00:55', '2016-06-25 22:00:55', null, null);
INSERT INTO `roles` VALUES ('3', 'employee', 'ROLE_EMPLOYEE', '员工加班、调休、销假的申请和审核', '1', '2016-06-25 22:00:55', '2016-06-25 22:00:55', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '邮箱',
  `user_password` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `user_nickname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_realname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_time` datetime NOT NULL COMMENT '注册日期',
  `last_logintime` datetime NOT NULL COMMENT '最近登录日期',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 1：是 0：否',
  `to_bfd_time` datetime DEFAULT NULL COMMENT '入职日期',
  `remind_time` int(11) NOT NULL DEFAULT '30' COMMENT '提醒周期时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$L9R8YgdE9eo1ZGJv3aQjCuoY070X6yrdBeKrE1NAPF2JygG3HAEjS', 'admin', 'admin', '2016-06-25 08:44:18', '2016-07-11 11:56:09', '1', '2016-06-25 15:47:57', '180');
INSERT INTO `user` VALUES ('2', 'user', '$2a$10$hrddLw3d.JAUB5IqlmdSdu3JUk9oq0vN/SH7YLO4EU..I6wUhl1Oi', 'user', 'user', '2016-06-25 09:02:38', '2016-07-10 17:00:34', '1', '2016-06-25 15:47:57', '150');
INSERT INTO `user` VALUES ('9', 'wu.wang', '$2a$10$nK0MGofE2YkluKg3JFXSjOvIg3nNNzUivGBrktnhr5arlIXUMjhk2', 'wu.wang', 'wu.wang', '2016-06-30 10:57:44', '2016-07-10 17:12:41', '1', '2016-06-25 15:47:57', '170');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用 1启用 0不启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2016-06-25 22:00:32', '2016-07-09 12:25:41', null, 'user');
INSERT INTO `user_role` VALUES ('2', '2', '1', '2016-06-25 22:00:32', '2016-07-08 10:16:34', null, 'wu.wang');
INSERT INTO `user_role` VALUES ('9', '3', '1', '2016-06-30 10:57:44', '2016-06-30 10:57:44', 'sys', 'sys');

-- ----------------------------
-- Table structure for worktime
-- ----------------------------
DROP TABLE IF EXISTS `worktime`;
CREATE TABLE `worktime` (
  `worktime_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '工时id',
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '邮箱名',
  `worktime_begin` datetime NOT NULL COMMENT '开始时间',
  `worktime_end` datetime NOT NULL COMMENT '结束时间',
  `total` int(11) NOT NULL DEFAULT '0' COMMENT '共多少小时',
  `audit_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '审核人（一般为项目经理）',
  `audit_status` int(1) DEFAULT '0' COMMENT '0:申请中，1：审批通过，2：审批拒绝',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '工时类型0：加班；1：年假；2：调休；3：销假;',
  `isUsedCompletely` smallint(1) NOT NULL DEFAULT '-1' COMMENT '-1:未启用(调休的时候不使用该字段)；0:未被调休，1:部分被使用 2：完全被调休',
  `surplus_total` int(11) DEFAULT NULL COMMENT '剩余工时 （和type 结合使用与total相对）',
  `surplus_time_begin` datetime DEFAULT NULL COMMENT '使用剩余开始时间',
  `surplus_time_end` datetime DEFAULT NULL COMMENT '使用剩余结束时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '1:数据有效；0：无效',
  `mail_id` bigint(255) NOT NULL COMMENT '发送申请邮件id',
  `approve_mail_Id` bigint(255) DEFAULT NULL COMMENT '审批邮件id',
  `worktime_relation_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'worktime_relation工时关系表',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人',
  `update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`worktime_id`),
  UNIQUE KEY `worktime_id` (`worktime_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of worktime
-- ----------------------------
INSERT INTO `worktime` VALUES ('21', 'admin', '2016-07-09 08:22:27', '2016-07-09 20:22:27', '12', 'admin', '1', '0', '2', null, null, null, '1', '60', null, null, '2016-07-09 20:22:58', '2016-07-09 22:42:44', 'admin', 'admin');
INSERT INTO `worktime` VALUES ('22', 'user', '2016-07-09 08:26:04', '2016-07-09 21:26:04', '13', 'admin', '2', '0', '0', null, null, null, '1', '61', null, null, '2016-07-09 20:27:01', '2016-07-09 21:06:43', 'user', 'admin');
INSERT INTO `worktime` VALUES ('23', 'user', '2016-07-11 13:09:56', '2016-07-11 21:09:56', '8', 'admin', '1', '0', '0', null, null, null, '1', '72', null, null, '2016-07-09 21:10:13', '2016-07-09 21:13:46', 'user', 'admin');
INSERT INTO `worktime` VALUES ('24', 'admin', '2016-07-09 22:02:26', '2016-07-09 23:02:26', '1', 'admin', '2', '2', '0', null, null, null, '1', '74', null, null, '2016-07-09 22:02:49', '2016-07-09 22:47:25', 'admin', 'admin');
INSERT INTO `worktime` VALUES ('25', 'admin', '2016-07-09 01:03:06', '2016-07-09 13:03:06', '12', 'admin', '1', '2', '0', null, null, null, '1', '75', null, '8dfaed69445b498893321c167abaf778', '2016-07-09 22:03:46', '2016-07-09 22:42:44', 'admin', 'admin');
INSERT INTO `worktime` VALUES ('26', 'admin', '2016-07-10 07:44:59', '2016-07-10 22:44:59', '15', 'admin', '1', '0', '2', '3', '2016-07-10 19:44:59', '2016-07-10 22:44:59', '1', '77', null, null, '2016-07-09 22:45:22', '2016-07-09 23:16:22', 'admin', 'admin');
INSERT INTO `worktime` VALUES ('27', 'admin', '2016-07-09 02:54:15', '2016-07-09 14:54:15', '12', 'admin', '1', '2', '0', null, null, null, '1', '89', null, '756df9d31189446fa85db64adfb30aa7', '2016-07-09 22:55:07', '2016-07-09 23:03:43', 'admin', 'admin');
INSERT INTO `worktime` VALUES ('28', 'admin', '2016-07-24 08:11:27', '2016-07-24 23:11:27', '15', 'admin', '1', '0', '1', '14', '2016-07-24 09:11:27', '2016-07-24 23:11:27', '1', '95', null, null, '2016-07-09 23:11:48', '2016-07-09 23:16:22', 'admin', 'admin');
INSERT INTO `worktime` VALUES ('29', 'admin', '2016-07-25 08:15:02', '2016-07-25 12:15:02', '4', 'admin', '1', '2', '0', null, null, null, '1', '97', null, '1f528e1822c04fa395f56b57ced62b7e', '2016-07-09 23:15:18', '2016-07-09 23:16:22', 'admin', 'admin');

-- ----------------------------
-- Table structure for worktime_relation
-- ----------------------------
DROP TABLE IF EXISTS `worktime_relation`;
CREATE TABLE `worktime_relation` (
  `relation_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '关系id',
  `worktime_id` bigint(255) NOT NULL COMMENT '工时表id',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '工时类型0：调休 ；1：销假',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '1:数据有效；0：无效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人',
  `update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of worktime_relation
-- ----------------------------
INSERT INTO `worktime_relation` VALUES ('8dfaed69445b498893321c167abaf778', '21', '0', '1', '2016-07-09 22:42:44', null, 'admin', null);
INSERT INTO `worktime_relation` VALUES ('756df9d31189446fa85db64adfb30aa7', '26', '0', '1', '2016-07-09 23:03:53', null, 'admin', null);
INSERT INTO `worktime_relation` VALUES ('1f528e1822c04fa395f56b57ced62b7e', '26', '0', '1', '2016-07-09 23:16:22', null, 'admin', null);
INSERT INTO `worktime_relation` VALUES ('1f528e1822c04fa395f56b57ced62b7e', '28', '0', '1', '2016-07-09 23:16:22', null, 'admin', null);
