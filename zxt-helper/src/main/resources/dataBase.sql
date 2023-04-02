DROP TABLE IF EXISTS `pro_stage`;

CREATE TABLE `pro_stage` (
  `staId` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `staName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `staDesc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDelete` char(2) COLLATE utf8_unicode_ci DEFAULT '1' COMMENT '是否删除？1、正常 0、删除',
  PRIMARY KEY (`staId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
insert  into `pro_stage`(`staId`,`staName`,`staDesc`,`creTime`,`updTime`,`isDelete`) values ('1','规划可研阶段',NULL,'2023-03-29 22:29:50','2023-03-29 22:29:50','1'),('2','工程设计阶段',NULL,'2023-03-29 22:30:06','2023-03-29 22:30:06','1'),('3','设备采购阶段',NULL,'2023-03-29 22:30:21','2023-03-29 22:30:21','1'),('4','设备制造阶段',NULL,'2023-03-29 22:30:33','2023-03-29 22:30:33','1'),('5','设备验收阶段',NULL,'2023-03-29 22:30:47','2023-03-29 22:30:47','1'),('6','设备安装阶段',NULL,'2023-03-29 22:30:53','2023-03-29 22:30:53','1'),('7','设备调试阶段',NULL,'2023-03-29 22:31:02','2023-03-29 22:31:02','1'),('8','竣工验收阶段',NULL,'2023-03-29 22:31:18','2023-03-29 22:31:18','1');


DROP TABLE IF EXISTS `supervision_rule`;

CREATE TABLE `supervision_rule` (
  `detailId` varchar(36) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ID',
  `ruleName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '细则名称',
  `staName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '阶段名称',
  `ruleTheme` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '细则主题',
  `ruleTitle` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '细则主标题',
  `keyPoint` varchar(500) COLLATE utf8_unicode_ci NOT NULL COMMENT '监督要点',
  `creTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `isDelete` char(2) COLLATE utf8_unicode_ci DEFAULT '1' COMMENT '1、正常 0、删除',
  `userId` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人ID',
  PRIMARY KEY (`detailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert  into `supervision_rule`(`detailId`,`ruleName`,`staName`,`ruleTheme`,`ruleTitle`,`keyPoint`,`creTime`,`updTime`,`isDelete`,`userId`) values
('1','变压器全过程技术监督精益化管理实施细则','规划可研阶段','电器设备性能','主接线','国台办:29日就美国会通过所谓“台湾保证实施法案”回应,我们敦促美国会恪守一个中国原则和中美三个联合公报规定,履行美国政府不支持“台独”的严肃承诺,立即停止审议有关议案。国台办:29日就美国会通过所谓“台湾保证实施法案”回应,我们敦促美国会恪守一个中国原则和中美三个联合公报规定,履行美国政府不支持“台独”的严肃承诺,立即停止审议有关议案。','2023-03-29 23:10:28','2023-03-29 23:10:28','1',NULL),
('2','电压互感器全过程技术监督精益化管理实施细则','工程设计阶段','电器设备性能','容量和台','监督要点测试数据','2023-03-29 23:10:28','2023-03-29 23:10:28','1',NULL),
('3','变压器全过程技术监督精益化管理实施细则','规划可研阶段','电器设备性能','主接线','国台办:29日就美国会通过所谓“台湾保证实施法案”回应,我们敦促美国会恪守一个中国原则和中美三个联合公报规定,履行美国政府不支持“台独”的严肃承诺,立即停止审议有关议案。国台办:29日就美国会通过所谓“台湾保证实施法案”回应,我们敦促美国会恪守一个中国原则和中美三个联合公报规定,履行美国政府不支持“台独”的严肃承诺,立即停止审议有关议案。','2023-03-30 09:15:51','2023-03-30 09:15:51','1',NULL);


create table `rules_regulation` (
	`ruRegId` int (8),
	`regName` varchar (765),
	`resName` varchar (765),
	`fileName` varchar (150),
	`ruRegUrl` varchar (3000),
	`pageNumber` int (4),
	`creTime` timestamp ,
	`updTime` timestamp ,
	`isDelete` char (6),
	`stageId` varchar (108),
	`userId` varchar (108),
	`markCode` varchar (108)
);
insert into `rules_regulation` (`ruRegId`, `regName`, `resName`, `fileName`, `ruRegUrl`, `pageNumber`, `creTime`, `updTime`, `isDelete`, `stageId`, `userId`, `markCode`) values('6','测试数据上传','14.国网江西省电力有限公司10kV及以下配电网工程成效后评价内容深度规定(试行).pdf','1680436969175.pdf','http://127.0.0.1:9000/test/14.%E5%9B%BD%E7%BD%91%E6%B1%9F%E8%A5%BF%E7%9C%81%E7%94%B5%E5%8A%9B%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B810kV%E5%8F%8A%E4%BB%A5%E4%B8%8B%E9%85%8D%E7%94%B5%E7%BD%91%E5%B7%A5%E7%A8%8B%E6%88%90%E6%95%88%E5%90%8E%E8%AF%84%E4%BB%B7%E5%86%85%E5%AE%B9%E6%B7%B1%E5%BA%A6%E8%A7%84%E5%AE%9A%28%E8%AF%95%E8%A1%8C%29.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20230402%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230402T120249Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=32a06b57e41eb27a48f01c4bfe2fe61f6fd64f65fac830e132f67fb4b3eee5bb','16','2023-04-02 20:02:49','2023-04-02 20:02:49','1',NULL,NULL,NULL);
insert into `rules_regulation` (`ruRegId`, `regName`, `resName`, `fileName`, `ruRegUrl`, `pageNumber`, `creTime`, `updTime`, `isDelete`, `stageId`, `userId`, `markCode`) values('7','测试数据上传','9.国网江西省电力有限公司三相组合式互感器检测指导手册.pdf','1680440130850.pdf','http://127.0.0.1:9000/test/9.%E5%9B%BD%E7%BD%91%E6%B1%9F%E8%A5%BF%E7%9C%81%E7%94%B5%E5%8A%9B%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8%E4%B8%89%E7%9B%B8%E7%BB%84%E5%90%88%E5%BC%8F%E4%BA%92%E6%84%9F%E5%99%A8%E6%A3%80%E6%B5%8B%E6%8C%87%E5%AF%BC%E6%89%8B%E5%86%8C.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20230402%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230402T125530Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=ccf49fa020ea5004b77fc8ae10ded0ca7706aab49bc513fb2239f31a6160b494','18','2023-04-02 20:55:30','2023-04-02 20:55:30','1',NULL,NULL,NULL);
