/*
Navicat MySQL Data Transfer

Source Server         : vm1
Source Server Version : 50719
Source Host           : 192.168.56.101:3306
Source Database       : archar

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-12-08 16:22:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
                        `id` bigint(20) NOT NULL,
                        `name` varchar(50) NOT NULL COMMENT '名字',
                        `age` int(3) unsigned DEFAULT NULL COMMENT '年龄',
                        `sex` tinyint(1) unsigned DEFAULT NULL COMMENT '性别(1-男，2-女)',
                        `birthday_time` timestamp NULL DEFAULT NULL COMMENT '生日',
                        `t` enum('1','2') DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
                            `id` bigint(20) NOT NULL,
                            `dict_code` varchar(100) NOT NULL COMMENT '字典code，唯一',
                            `dict_name` varchar(100) NOT NULL,
                            `parent_id` bigint(20) NOT NULL COMMENT '父节点id。root节点为0',
                            `sort` tinyint(7) DEFAULT NULL COMMENT '排序',
                            `create_time` datetime NOT NULL COMMENT '创建时间',
                            `update_time` datetime NOT NULL COMMENT '更新时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据字典表';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `id` bigint(20) NOT NULL,
                            `parent_id` bigint(20) NOT NULL COMMENT '父节点id（0是根节点）',
                            `menu_name` varchar(60) NOT NULL COMMENT '菜单名',
                            `menu_icon` varchar(128) DEFAULT NULL COMMENT '图标',
                            `menu_url` varchar(255) DEFAULT NULL COMMENT '地址',
                            `is_valid` tinyint(1) unsigned NOT NULL COMMENT '是否有效(1-有效，0-无效)',
                            `sort` tinyint(5) unsigned DEFAULT NULL COMMENT '排序',
                            `create_time` datetime NOT NULL COMMENT '创建时间',
                            `update_time` datetime NOT NULL COMMENT '更新时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单栏表';

-- ----------------------------
-- Table structure for sys_table_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_table_info`;
CREATE TABLE `sys_table_info` (
                                  `id` bigint(20) NOT NULL,
                                  `query_id` varchar(200) NOT NULL COMMENT '查询id',
                                  `colum` varchar(50) NOT NULL COMMENT '列名',
                                  `jdbc_type` varchar(100) NOT NULL COMMENT '数据库类型',
                                  `desc` varchar(255) DEFAULT NULL COMMENT '字段描述',
                                  `query_type` varchar(20) NOT NULL COMMENT '查询type',
                                  `query_code` varchar(255) DEFAULT NULL COMMENT 'query_type是枚举时会查询sys_dict的code',
                                  `is_quick_query` tinyint(2) NOT NULL COMMENT '是否快速查询（0-否，1-是）',
                                  `create_time` datetime NOT NULL COMMENT '创建时间',
                                  `update_time` datetime NOT NULL COMMENT '更新时间',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='表信息（前端列表展示和查询用）';
