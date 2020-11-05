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