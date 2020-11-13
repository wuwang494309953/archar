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
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;