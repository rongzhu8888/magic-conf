
CREATE DATABASE `magic_conf` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use magic_conf;

-- ----------------------------
-- Table structure for conn_test
-- ----------------------------
DROP TABLE IF EXISTS `conn_test`;
CREATE TABLE `conn_test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mc_app
-- ----------------------------
DROP TABLE IF EXISTS `mc_app`;
CREATE TABLE `mc_app` (
  `app_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '应用ID',
  `app_code` varchar(100) NOT NULL DEFAULT '' COMMENT '应用代号',
  `app_name` varchar(200) NOT NULL DEFAULT '' COMMENT '应用名称',
  `group_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '分组id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='应用表';

-- ----------------------------
-- Table structure for mc_app_version
-- ----------------------------
DROP TABLE IF EXISTS `mc_app_version`;
CREATE TABLE `mc_app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '应用ID',
  `version_no` varchar(10) NOT NULL DEFAULT '' COMMENT '应用版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx_version` (`app_id`,`version_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用版本表';

-- ----------------------------
-- Table structure for mc_config_file
-- ----------------------------
DROP TABLE IF EXISTS `mc_config_file`;
CREATE TABLE `mc_config_file` (
  `config_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) NOT NULL DEFAULT '' COMMENT '文件名',
  `file_content` text NOT NULL COMMENT '文件内容',
  `app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '应用ID',
  `app_version` varchar(10) NOT NULL DEFAULT '' COMMENT '应用版本号',
  `profile_id` varchar(50) NOT NULL DEFAULT '' COMMENT '环境ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL DEFAULT '' COMMENT '创建用户',
  PRIMARY KEY (`config_id`),
  UNIQUE KEY `udx_file` (`file_name`,`app_id`,`app_version`,`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用配置文件表';

-- ----------------------------
-- Table structure for mc_config_file_his
-- ----------------------------
DROP TABLE IF EXISTS `mc_config_file_his`;
CREATE TABLE `mc_config_file_his` (
  `config_id` bigint(20) NOT NULL,
  `file_name` varchar(100) NOT NULL DEFAULT '' COMMENT '文件名',
  `file_content` text NOT NULL COMMENT '文件内容(新）',
  `file_content_last` text NOT NULL COMMENT '文件内容（旧）',
  `app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '应用ID',
  `app_version` varchar(10) NOT NULL DEFAULT '' COMMENT '应用版本号',
  `profile_id` varchar(50) NOT NULL DEFAULT '' COMMENT '环境ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL DEFAULT '' COMMENT '创建用户',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用配置文件历史表';

-- ----------------------------
-- Table structure for mc_config_item
-- ----------------------------
DROP TABLE IF EXISTS `mc_config_item`;
CREATE TABLE `mc_config_item` (
  `config_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_key` varchar(200) NOT NULL DEFAULT '' COMMENT '配置项KEY',
  `item_value` varchar(1024) NOT NULL DEFAULT '' COMMENT '配置项值',
  `app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '应用ID',
  `app_version` varchar(10) NOT NULL DEFAULT '' COMMENT '应用版本号',
  `profile_id` varchar(50) NOT NULL COMMENT '环境ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL DEFAULT '' COMMENT '创建用户',
  PRIMARY KEY (`config_id`),
  UNIQUE KEY `udx_item` (`item_key`,`app_id`,`app_version`,`profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='应用配置项表';

-- ----------------------------
-- Table structure for mc_config_item_his
-- ----------------------------
DROP TABLE IF EXISTS `mc_config_item_his`;
CREATE TABLE `mc_config_item_his` (
  `config_id` bigint(20) NOT NULL,
  `item_key` varchar(200) NOT NULL DEFAULT '' COMMENT '配置项KEY',
  `item_value` varchar(1024) NOT NULL DEFAULT '' COMMENT '配置项值(新）',
  `item_value_last` varchar(1024) NOT NULL DEFAULT '' COMMENT '配置项值（旧）',
  `app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '应用ID',
  `app_version` varchar(10) NOT NULL DEFAULT '' COMMENT '应用版本号',
  `profile_id` varchar(50) NOT NULL COMMENT '环境ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL DEFAULT '' COMMENT '创建用户',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用配置项历史表';

-- ----------------------------
-- Table structure for mc_group
-- ----------------------------
DROP TABLE IF EXISTS `mc_group`;
CREATE TABLE `mc_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '应用分组ID',
  `group_name` varchar(100) NOT NULL DEFAULT '' COMMENT '应用分组名',
  `parent_group_id` bigint(20) NOT NULL DEFAULT '0',
  `sort_value` smallint(6) NOT NULL DEFAULT '0' COMMENT '分组排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='应用分组表';

-- ----------------------------
-- Table structure for mc_profile
-- ----------------------------
DROP TABLE IF EXISTS `mc_profile`;
CREATE TABLE `mc_profile` (
  `profile_id` varchar(50) NOT NULL DEFAULT '' COMMENT '环境ID',
  `profile_name` varchar(50) NOT NULL DEFAULT '' COMMENT '环境名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='环境表';

-- ----------------------------
-- Table structure for mc_role
-- ----------------------------
DROP TABLE IF EXISTS `mc_role`;
CREATE TABLE `mc_role` (
  `role_id` varchar(100) NOT NULL DEFAULT '' COMMENT '角色ID',
  `role_name` varchar(100) NOT NULL DEFAULT '' COMMENT '角色名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for mc_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `mc_role_permission`;
CREATE TABLE `mc_role_permission` (
  `id` bigint(20) NOT NULL,
  `role_id` varchar(100) NOT NULL DEFAULT '' COMMENT '角色ID',
  `profile_id` varchar(50) NOT NULL DEFAULT '' COMMENT '环境ID',
  `read_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '当前角色在对该环境的配置是否可读：0-否 1-是',
  `write_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '当前角色在对该环境的配置是否可写 0-否 1-是',
  UNIQUE KEY `udx_permission` (`role_id`,`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色对环境读写权限表';

-- ----------------------------
-- Table structure for mc_user
-- ----------------------------
DROP TABLE IF EXISTS `mc_user`;
CREATE TABLE `mc_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `telephone` varchar(50) NOT NULL DEFAULT '' COMMENT '电话',
  `email` varchar(200) NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `password` varchar(200) NOT NULL DEFAULT '' COMMENT '登录密码',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否管理员',
  `is_locked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否锁定',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `token` varchar(36) NOT NULL DEFAULT '' COMMENT '认证token',
  PRIMARY KEY (`user_id`),
  KEY `idx_token` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000002 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for mc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mc_user_role`;
CREATE TABLE `mc_user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '应用ID',
  `role_id` varchar(100) NOT NULL DEFAULT '' COMMENT '角色ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx_user_role` (`user_id`,`app_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';