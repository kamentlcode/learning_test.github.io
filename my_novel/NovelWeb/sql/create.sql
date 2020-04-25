  --  用户表
  DROP TABLE IF EXISTS `users`;
  CREATE TABLE `users` (
    `id` varchar(32) NOT NULL COMMENT 'id',
    `name` varchar(255) NOT NULL COMMENT '名称',
    `file_count` int(11) DEFAULT '0' COMMENT '文件数量',
    `memo` varchar(255) NOT NULL COMMENT '备注',
    `creater` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
    `creatTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='普通合伙人相关文件';
  
  
    --  用户表
  DROP TABLE IF EXISTS `users`;
  CREATE TABLE `users` (
    `id` varchar(32) NOT NULL COMMENT 'id',
    `gp_id` varchar(32) DEFAULT NULL COMMENT '普通合伙人id',
    `name` varchar(255) NOT NULL COMMENT '名称',
    `file_count` int(11) DEFAULT '0' COMMENT '文件数量',
    `memo` varchar(255) NOT NULL COMMENT '备注',
    `creater` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
    `creatTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='普通合伙人相关文件';