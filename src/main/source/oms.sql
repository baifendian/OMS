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
-- Table structure for t_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `t_vehicle`;
CREATE TABLE `t_vehicle` (
  `vehicle_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆ID',
  `vehicle_number` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '车号',
  `create_id` int(11) NOT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL  COMMENT '创建日期',
  `contact_man` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '联系人',
  `contact_phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系电话',
  `category` int(11) NOT NULL COMMENT '车辆分类：1,大巴，2公交，3地铁',
  `vehicle_company` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '车主单位',
  `line_rel_id` int(11) NOT NULL COMMENT '线路',
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_vehicle
-- ----------------------------
INSERT INTO `t_vehicle` VALUES ('1', '湘a72957', '1', '2016-04-25 00:00:00', '赵司机', '18646611544', '1', '湖南长运', '1');
INSERT INTO `t_vehicle` VALUES ('2', '沪b74595', '1', '2016-03-24 00:00:00', '薛司机', '13663962347', '1', '上海长运', '2');
INSERT INTO `t_vehicle` VALUES ('3', '赣c61397', '1', '2016-06-01 00:00:00', '徐司机', '13754721088', '1', '江西长运', '1');
INSERT INTO `t_vehicle` VALUES ('4', '豫a57454', '1', '2016-05-20 00:00:00', '林司机', '13609989629', '1', '河南长运', '5');
INSERT INTO `t_vehicle` VALUES ('5', '豫d18692', '2', '2016-01-09 00:00:00', '赵司机', '18834468535', '1', '河南长运', '6');
INSERT INTO `t_vehicle` VALUES ('6', '京b68838', '2', '2016-04-28 00:00:00', '薛司机', '18839564422', '2', '北京长运', '5');
INSERT INTO `t_vehicle` VALUES ('7', '沪b59356', '2', '2016-03-21 00:00:00', '徐司机', '18595399047', '2', '上海长运', '5');
INSERT INTO `t_vehicle` VALUES ('8', '粤c27175', '2', '2016-05-11 00:00:00', '李司机', '13741189838', '2', '广东长运', '6');
INSERT INTO `t_vehicle` VALUES ('9', '粤c57123', '3', '2016-02-14 00:00:00', '刘司机', '13796443047', '3', '广东长运', '7');
INSERT INTO `t_vehicle` VALUES ('10', '京b73587', '3', '2016-05-11 00:00:00', '王司机', '18538202945', '3', '北京长运', '7');
INSERT INTO `t_vehicle` VALUES ('11', '赣a87816', '3', '2016-01-29 00:00:00', '刘司机', '18503836442', '3', '江西长运', '9');
INSERT INTO `t_vehicle` VALUES ('12', '粤a91386', '3', '2016-05-27 00:00:00', '王司机', '18822818823', '3', '广东长运', '10');
INSERT INTO `t_vehicle` VALUES ('13', '粤d36481', '1', '2016-05-03 00:00:00', '薛司机', '13691283422', '1', '广东长运', '10');
INSERT INTO `t_vehicle` VALUES ('14', '沪d15723', '1', '2016-04-14 00:00:00', '林司机', '18832188169', '1', '上海长运', '10');
INSERT INTO `t_vehicle` VALUES ('15', '京a43181', '2', '2016-05-20 00:00:00', '薛司机', '18675512665', '2', '北京长运', '11');
INSERT INTO `t_vehicle` VALUES ('16', '湘a75398', '2', '2016-05-02 00:00:00', '林司机', '13666785939', '2', '湖南长运', '12');
INSERT INTO `t_vehicle` VALUES ('17', '豫b91876', '2', '2016-03-24 00:00:00', '赵司机', '13627314427', '2', '河南长运', '13');
INSERT INTO `t_vehicle` VALUES ('18', '豫c39815', '2', '2016-05-28 00:00:00', '蒋司机', '15088779498', '2', '河南长运', '12');
INSERT INTO `t_vehicle` VALUES ('19', '鄂d15829', '2', '2016-05-03 00:00:00', '王司机', '18627617940', '2', '湖北长运', '13');
INSERT INTO `t_vehicle` VALUES ('20', '粤c46227', '1', '2016-06-02 00:00:00', '钟司机', '18587435096', '1', '广东长运', '15');
INSERT INTO `t_vehicle` VALUES ('21', '鄂b73266', '1', '2016-01-14 00:00:00', '蒋司机', '18846707308', '1', '湖北长运', '17');
INSERT INTO `t_vehicle` VALUES ('22', '湘c25225', '1', '2016-05-13 00:00:00', '吴司机', '13656950105', '1', '湖南长运', '16');
INSERT INTO `t_vehicle` VALUES ('23', '鄂b56833', '2', '2016-03-22 00:00:00', '蒋司机', '13769690280', '2', '湖北长运', '15');
INSERT INTO `t_vehicle` VALUES ('24', '赣d46546', '2', '2016-03-14 00:00:00', '蒋司机', '18829430236', '2', '江西长运', '17');
INSERT INTO `t_vehicle` VALUES ('25', '豫c63318', '2', '2016-05-19 00:00:00', '蒋司机', '15057189866', '2', '河南长运', '16');
INSERT INTO `t_vehicle` VALUES ('26', '豫a27113', '1', '2016-02-22 00:00:00', '刘司机', '15060852651', '1', '河南长运', '20');
INSERT INTO `t_vehicle` VALUES ('27', '豫b31914', '1', '2016-02-07 00:00:00', '李司机', '18587704173', '1', '河南长运', '19');
INSERT INTO `t_vehicle` VALUES ('28', '鄂d83598', '1', '2016-05-28 00:00:00', '吴司机', '15083824937', '1', '湖北长运', '18');
INSERT INTO `t_vehicle` VALUES ('29', '鄂c82778', '2', '2016-03-30 00:00:00', '王司机', '13706238087', '2', '湖北长运', '20');
INSERT INTO `t_vehicle` VALUES ('30', '湘c12838', '1', '2016-03-10 00:00:00', '王司机', '18897859808', '1', '湖南长运', '19');
INSERT INTO `t_vehicle` VALUES ('31', '鄂d49813', '2', '2016-06-01 00:00:00', '郑司机', '18653930705', '2', '湖北长运', '1');
INSERT INTO `t_vehicle` VALUES ('32', '湘a94112', '1', '2016-03-17 00:00:00', '郑司机', '18585819493', '1', '湖南长运', '15');
INSERT INTO `t_vehicle` VALUES ('33', '赣a15899', '3', '2016-03-18 00:00:00', '吴司机', '18635964723', '2', '江西长运', '15');
INSERT INTO `t_vehicle` VALUES ('34', '粤d23132', '2', '2016-02-29 00:00:00', '徐司机', '13778523709', '1', '广东长运', '13');
INSERT INTO `t_vehicle` VALUES ('35', '粤a31723', '2', '2016-04-27 00:00:00', '王司机', '18540919395', '2', '广东长运', '9');
INSERT INTO `t_vehicle` VALUES ('36', '豫b26265', '2', '2016-04-21 00:00:00', '吴司机', '18530885418', '2', '河南长运', '1');
INSERT INTO `t_vehicle` VALUES ('37', '豫a94214', '1', '2016-01-08 00:00:00', '刘司机', '18628440260', '1', '河南长运', '2');
INSERT INTO `t_vehicle` VALUES ('38', '鄂a26579', '1', '2016-02-22 00:00:00', '吴司机', '18805097879', '1', '湖北长运', '9');
INSERT INTO `t_vehicle` VALUES ('39', '赣a37125', '2', '2016-01-09 00:00:00', '杨司机', '18676426273', '2', '江西长运', '12');
INSERT INTO `t_vehicle` VALUES ('40', '粤b82413', '2', '2016-05-17 00:00:00', '薛司机', '18536717634', '1', '广东长运', '10');
INSERT INTO `t_vehicle` VALUES ('41', '沪c61844', '1', '2016-04-28 00:00:00', '蒋司机', '18666703568', '1', '上海长运', '17');
INSERT INTO `t_vehicle` VALUES ('42', '豫d67336', '2', '2016-03-25 00:00:00', '薛司机', '13727285980', '2', '河南长运', '11');
INSERT INTO `t_vehicle` VALUES ('43', '粤a38478', '2', '2016-05-22 00:00:00', '徐司机', '13637609209', '1', '广东长运', '16');
INSERT INTO `t_vehicle` VALUES ('44', '赣c31928', '3', '2016-01-28 00:00:00', '吴司机', '13629581533', '1', '江西长运', '6');
INSERT INTO `t_vehicle` VALUES ('45', '赣a14639', '3', '2016-01-25 00:00:00', '郑司机', '18575237471', '1', '江西长运', '11');
INSERT INTO `t_vehicle` VALUES ('46', '京b79835', '2', '2016-04-11 00:00:00', '蒋司机', '15097677113', '2', '北京长运', '5');
INSERT INTO `t_vehicle` VALUES ('47', '京a78762', '2', '2016-03-10 00:00:00', '吴司机', '13726719267', '1', '北京长运', '16');
INSERT INTO `t_vehicle` VALUES ('48', '湘c48832', '3', '2016-01-06 00:00:00', '赵司机', '18562990872', '1', '湖南长运', '10');
INSERT INTO `t_vehicle` VALUES ('49', '豫d55523', '1', '2016-01-20 00:00:00', '杨司机', '18507897493', '1', '河南长运', '13');
INSERT INTO `t_vehicle` VALUES ('50', '鄂b12881', '1', '2016-02-04 00:00:00', '徐司机', '18568006725', '2', '湖北长运', '5');
INSERT INTO `t_vehicle` VALUES ('51', '豫c86619', '1', '2016-04-13 00:00:00', '郑司机', '18589354283', '1', '河南长运', '20');
INSERT INTO `t_vehicle` VALUES ('52', '鄂c87521', '3', '2016-04-20 00:00:00', '吴司机', '13764018069', '1', '湖北长运', '6');
INSERT INTO `t_vehicle` VALUES ('53', '湘b56221', '1', '2016-02-10 00:00:00', '薛司机', '18899843298', '2', '湖南长运', '1');
INSERT INTO `t_vehicle` VALUES ('54', '湘a79214', '1', '2016-04-15 00:00:00', '蒋司机', '15006297787', '1', '湖南长运', '1');
INSERT INTO `t_vehicle` VALUES ('55', '豫d78237', '1', '2016-02-17 00:00:00', '林司机', '15095931595', '2', '河南长运', '18');
INSERT INTO `t_vehicle` VALUES ('56', '豫d14317', '2', '2016-06-02 00:00:00', '赵司机', '13643418922', '2', '河南长运', '17');
INSERT INTO `t_vehicle` VALUES ('57', '沪a21931', '1', '2016-01-23 00:00:00', '薛司机', '13650997367', '1', '上海长运', '6');
INSERT INTO `t_vehicle` VALUES ('58', '湘a71478', '2', '2016-04-28 00:00:00', '徐司机', '15076462975', '2', '湖南长运', '5');
INSERT INTO `t_vehicle` VALUES ('59', '沪a81385', '2', '2016-03-21 00:00:00', '林司机', '18655506823', '2', '上海长运', '7');
INSERT INTO `t_vehicle` VALUES ('60', '沪d47187', '2', '2016-01-25 00:00:00', '刘司机', '18526334344', '1', '上海长运', '17');
INSERT INTO `t_vehicle` VALUES ('61', '湘a91559', '1', '2016-03-09 00:00:00', '李司机', '15028520210', '2', '湖南长运', '15');
INSERT INTO `t_vehicle` VALUES ('62', '沪c16335', '3', '2016-05-26 00:00:00', '林司机', '18601788213', '2', '上海长运', '1');
INSERT INTO `t_vehicle` VALUES ('63', '沪a91739', '2', '2016-04-30 00:00:00', '刘司机', '18831633214', '1', '上海长运', '19');
INSERT INTO `t_vehicle` VALUES ('64', '湘c74454', '1', '2016-02-14 00:00:00', '李司机', '18661007813', '1', '湖南长运', '17');
INSERT INTO `t_vehicle` VALUES ('65', '湘a13554', '1', '2016-05-04 00:00:00', '林司机', '13695220206', '2', '湖南长运', '4');
INSERT INTO `t_vehicle` VALUES ('66', '京c73829', '2', '2016-05-20 00:00:00', '吴司机', '13652059857', '2', '北京长运', '4');
INSERT INTO `t_vehicle` VALUES ('67', '豫c92175', '2', '2016-05-07 00:00:00', '郑司机', '13717851913', '1', '河南长运', '10');
INSERT INTO `t_vehicle` VALUES ('68', '粤c92893', '1', '2016-05-19 00:00:00', '赵司机', '13640812626', '1', '广东长运', '20');
INSERT INTO `t_vehicle` VALUES ('69', '鄂c11361', '3', '2016-03-08 00:00:00', '杨司机', '13668272361', '2', '湖北长运', '14');
INSERT INTO `t_vehicle` VALUES ('70', '粤c78442', '2', '2016-03-16 00:00:00', '薛司机', '13726115692', '1', '广东长运', '8');
INSERT INTO `t_vehicle` VALUES ('71', '鄂a56661', '1', '2016-02-19 00:00:00', '蒋司机', '15030261834', '1', '湖北长运', '18');
INSERT INTO `t_vehicle` VALUES ('72', '鄂b39359', '3', '2016-02-18 00:00:00', '蒋司机', '13733840989', '1', '湖北长运', '17');
INSERT INTO `t_vehicle` VALUES ('73', '粤b63699', '1', '2016-01-08 00:00:00', '钟司机', '15025757083', '2', '广东长运', '3');
INSERT INTO `t_vehicle` VALUES ('74', '京c33476', '2', '2016-06-03 00:00:00', '薛司机', '18838284884', '1', '北京长运', '16');
INSERT INTO `t_vehicle` VALUES ('75', '鄂c55717', '3', '2016-02-08 00:00:00', '杨司机', '13710326395', '2', '湖北长运', '17');
INSERT INTO `t_vehicle` VALUES ('76', '湘d59428', '3', '2016-04-25 00:00:00', '杨司机', '18695000946', '1', '湖南长运', '11');
INSERT INTO `t_vehicle` VALUES ('77', '粤d98349', '3', '2016-06-03 00:00:00', '李司机', '13756383853', '2', '广东长运', '16');
INSERT INTO `t_vehicle` VALUES ('78', '京a72277', '1', '2016-04-20 00:00:00', '吴司机', '18868394087', '2', '北京长运', '19');
INSERT INTO `t_vehicle` VALUES ('79', '粤c44971', '2', '2016-02-25 00:00:00', '王司机', '18631170889', '1', '广东长运', '7');
INSERT INTO `t_vehicle` VALUES ('80', '粤c23111', '3', '2016-03-04 00:00:00', '林司机', '15056264231', '1', '广东长运', '17');

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
