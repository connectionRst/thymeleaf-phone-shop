/*
Navicat MySQL Data Transfer

Source Server         : cyf
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : phone_shop

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2023-10-31 21:22:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` varchar(32) NOT NULL COMMENT '地址ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `phone` varchar(255) NOT NULL COMMENT '收货人联系方式',
  `name` varchar(255) NOT NULL COMMENT '收货人名称',
  `province` varchar(20) NOT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `area` varchar(20) DEFAULT NULL COMMENT '县',
  `detail` varchar(60) DEFAULT NULL COMMENT '详细地址',
  `defaulted` int(11) DEFAULT '2' COMMENT '1=默认地址 2=非默认地址',
  `deleted` int(11) DEFAULT '0' COMMENT '0正常 1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('7da3dbc0f95f6d6e4fee96f00a7c0b8b', 'd193b6e8fa765440c16f8ffa01acbd00', '13726452983', '陈煜枫', '广东省', '广州市', '白云区', '12341231231', '1', '0');
INSERT INTO `t_address` VALUES ('8a45c3743e63c83595d53f462b160439', 'd193b6e8fa765440c16f8ffa01acbd00', '13726452853', '测试地址', '江西省', '景德镇市', '昌江区', '2', '2', '0');
INSERT INTO `t_address` VALUES ('d6be6f565784c9bfa709e3c00dd73bba', 'd193b6e8fa765440c16f8ffa01acbd00', '13725485697', 'zrq', '河北省', '石家庄市', '长安区', '1234', '2', '0');
INSERT INTO `t_address` VALUES ('dcff142e234c093b31cbd16da5b787c5', 'd193b6e8fa765440c16f8ffa01acbd00', '13726452525', '测试', '天津市', '天津市', '东丽区', '123123123', '2', '0');

-- ----------------------------
-- Table structure for t_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` varchar(32) NOT NULL COMMENT '轮播图Id',
  `good_id` varchar(255) DEFAULT NULL COMMENT '轮播图商品Id',
  `name` varchar(255) DEFAULT NULL COMMENT '轮播多名字',
  `selected` int(11) DEFAULT '1' COMMENT '是否选用 1=选用 2=不选',
  `img` varchar(255) DEFAULT NULL COMMENT '轮播图片',
  `deleted` int(11) DEFAULT '0' COMMENT '0正常 1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_banner
-- ----------------------------
INSERT INTO `t_banner` VALUES ('8457b4a4764f44609c0c3c869dd13534', '/good/getGoodDetail?goodId=087fa7251f9582fe59b42acfb6014545', '华为(HUAWEI)', '1', '/images/banner/897672c2-24e2-4780-9e86-2d9babc162ca.jpg', '0');
INSERT INTO `t_banner` VALUES ('f3a3c48f75c6af8b4c2e1e7c08ac7182', '/good/getGoodDetail?goodId=e5e64e3e41cb04e70177b85393593ffb', 'vivoX70 Pro', '1', '/images/banner/450de945-b56d-4100-818b-cc3a6dd4b17d.jpg', '0');

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` varchar(32) NOT NULL COMMENT '购物车Id',
  `good_id` varchar(32) DEFAULT NULL COMMENT '商品Id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户Id',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('b80f275889945672947dde43c25b2efd', '059ea96c6f168ef439c0b95e61b9ce00', 'd193b6e8fa765440c16f8ffa01acbd00', '2');
INSERT INTO `t_cart` VALUES ('c573cac013428b6a13a98d1dffebe63b', '07fd502872eb75bf6230ed2fdcd2d2ec', 'd193b6e8fa765440c16f8ffa01acbd00', '1');

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '收藏Id',
  `user_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '用户Id',
  `good_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '商品Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_collect
-- ----------------------------
INSERT INTO `t_collect` VALUES ('22734f7848b49d1b869482470a281411', 'd193b6e8fa765440c16f8ffa01acbd00', 'f0ec98f32c0f340eff4da2d08aff895a');
INSERT INTO `t_collect` VALUES ('2b180f08975a1b2d0040f853df875316', 'd193b6e8fa765440c16f8ffa01acbd00', '2e48e83346628b624fbb77d34987c03c');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '评价的用户',
  `good_id` varchar(32) DEFAULT NULL,
  `content` varchar(700) DEFAULT NULL COMMENT '评价的内容',
  `level` varchar(255) DEFAULT '' COMMENT '1=好评 2=中评 3=差评',
  `create_time` datetime DEFAULT NULL COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('89924ce6aee0aaf0fc3c597edbc43c0f', 'd193b6e8fa765440c16f8ffa01acbd00', '059ea96c6f168ef439c0b95e61b9ce00', '123', '1', '2022-02-10 12:54:41');
INSERT INTO `t_comment` VALUES ('10cf9a8b95d11046588e72c219b1efca', 'd193b6e8fa765440c16f8ffa01acbd00', '07fd502872eb75bf6230ed2fdcd2d2ec', '啊啊啊啊啊啊啊', '1', '2022-02-12 07:15:56');
INSERT INTO `t_comment` VALUES ('992d6df2e98183724f2892d64026f2f9', 'd193b6e8fa765440c16f8ffa01acbd00', '059ea96c6f168ef439c0b95e61b9ce00', 'hhhhhhhhhhhhhhh', '1', '2022-02-12 08:30:44');
INSERT INTO `t_comment` VALUES ('fdad3f1b87ef5104d2fd4800e4bee7be', 'd193b6e8fa765440c16f8ffa01acbd00', '32af9da4b03da3af7130b8930f23a31b', '真66666666666', '1', '2022-12-03 10:15:48');

-- ----------------------------
-- Table structure for t_good
-- ----------------------------
DROP TABLE IF EXISTS `t_good`;
CREATE TABLE `t_good` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `category_id` varchar(32) COLLATE utf8_bin DEFAULT '' COMMENT '商品分类id',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '礼品名称',
  `price` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '价值',
  `stock` int(11) DEFAULT '0' COMMENT '库存',
  `image` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `sku` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '规格',
  `remark` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `status` int(1) DEFAULT '1' COMMENT '1=上架中，2=下架中',
  `sales` int(11) DEFAULT '0' COMMENT '销量',
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='积分物品表';

-- ----------------------------
-- Records of t_good
-- ----------------------------
INSERT INTO `t_good` VALUES ('059ea96c6f168ef439c0b95e61b9ce00', '1020670a3f68535036f37bc21c7a99ae', 'iPhone13', '5999', '1', '/images/good/d7553589-5bf0-41e4-9186-348d7ef60d92.jpg', '128G 1200万像素', '苹果手机测试', '0', '0', '0');
INSERT INTO `t_good` VALUES ('07fd502872eb75bf6230ed2fdcd2d2ec', '6e72626d658ce3fa2256abb12447172d', '华为Mate 40E', '6069', '2', '/images/good/e1c483fb-44cd-42d2-9968-dc038e1b4d36.jpg', ' 4G 全网通 6.5英寸 8GB+128GB', '麒麟990E芯片，超感知徕卡影像，有线无线双超级快充，HarmonyOS全场景智慧体验，源于宇宙探索的星环美学,6.5英寸曲面屏舒适握持感', '0', '0', '0');
INSERT INTO `t_good` VALUES ('087fa7251f9582fe59b42acfb6014545', '6e72626d658ce3fa2256abb12447172d', '华为(HUAWEI)', '5399', '4', '/images/good/0ba28d51-e270-474e-88bb-de243d78a6b8.jpg', '4G全网通 8+128GB幻夜黑', '6400万高清四摄 66W超级快充 6.5英寸OLED大屏华为手机 标配无充', '0', '0', '0');
INSERT INTO `t_good` VALUES ('2e48e83346628b624fbb77d34987c03c', 'eca60a661fa7ae1b201ea34f3ef0099c', '小米12 Pro', '5399', '5', '/images/good/3344b777-685c-4d01-b03b-6df432cf34e7.jpg', '12GB+256GB 黑色 5G手机', '强到芯想事成的全新一代骁龙8，采用旗舰级4nm制程工艺，集成百亿级晶体管，搭载全新架构,性能更强,功耗更低', '0', '0', '0');
INSERT INTO `t_good` VALUES ('329d14f652cceaba0792a552e25cbb6a', 'ec60e1aa9a275d63ad9368ec1559d39d', 'vivo iQOO 9', '3499', '1', '/images/good/df980d1b-65da-423e-a9d4-6056444b6b6c.jpg', '12GB+256GB', '120W闪充 骁龙888 独立显示芯片 KPL官方赛事电竞手机 双模5G全网通iqoo8', '0', '0', '0');
INSERT INTO `t_good` VALUES ('32af9da4b03da3af7130b8930f23a31b', '62bc9165650dda7d1d30f8e3a5c1a602', 'OPPOReno7', '2599', '2', '/images/good/82b51a72-b4fc-4a00-bad7-6ad3029d0f41.jpg', '8GB 128GB 6400万像素', '前置索尼 IMX709 超感光猫眼镜头 高通骁龙778G 5G手机', '0', '0', '0');
INSERT INTO `t_good` VALUES ('814de5100f482177e4144fac4e46a190', '6e72626d658ce3fa2256abb12447172d', 'test', '100', '4', '/images/good/d185e0a7-8e23-4536-86f9-502276ee8e70.jpg', '128G', 'hhhhhh', '0', '0', '1');
INSERT INTO `t_good` VALUES ('a6b847b6f49ec332c14bb7bed559845a', 'ec60e1aa9a275d63ad9368ec1559d39d', 'vivo X70 Pro+', '5999', '2', '/images/good/aaf59613-ba02-45e2-ba34-7988657b7375.JPG', '12GB 256GB 5000万像素', '2K屏幕 IP68级防水 全四摄光学防抖', '0', '0', '0');
INSERT INTO `t_good` VALUES ('a6f69c83670967f34e222c56d71c7a53', '6e72626d658ce3fa2256abb12447172d', '华为P50系列', '6488', '6', '/images/good/96881156-d59c-47db-9678-cadaa0c6ea6c.jpg', '骁龙888 4G 8GB+256GB', '万象双环，设计美学新生。万象双环设计，将影像与艺术合二为一，汲取几何灵感，秩序中饱含诗意', '0', '0', '0');
INSERT INTO `t_good` VALUES ('c3aed79622a05262fb7dacbaebd2819d', 'bd09197230559bdebea7acc9c1a41d92', '荣耀60', '2699', '7', '/images/good/61963027-1446-4505-a943-8c2f370001fa.jpg', '10800万像素  8GB+128GB', '对称美学称眼也称手，荣耀60首次采用前后对称双曲面设计,屏幕曲率和后盖曲率完全一致,呈现出前后完美对称的双曲面形态', '1', '0', '0');
INSERT INTO `t_good` VALUES ('e5e64e3e41cb04e70177b85393593ffb', 'ec60e1aa9a275d63ad9368ec1559d39d', 'vivoX70 Pro', '3699.00', '2', '/images/good/2ee5945e-5ef1-4b67-b4f3-087363e82ce3.jpg', '5G手机 8GB+256GB 星云', '5nm旗舰芯片 专业影像芯片V1 蔡司光学镜头 120Hz高刷', '1', '0', '0');
INSERT INTO `t_good` VALUES ('f0ec98f32c0f340eff4da2d08aff895a', '0ed4204eb886828ce2153fb4600737a8', '三星Galaxy Note20 Ultra 5G', '5999', '16', '/images/good/56f48e54-903b-4107-a304-5cfd3157585e.jpg', '12GB+256GB 迷雾金', '这是Galaxy Note20Ultra 5G，惊艳设计强大性能，为Samsung Galaxy引入了新的标志性颜色迷雾金，优质的中性色调，雾面质感，时尚经典。', '1', '0', '0');

-- ----------------------------
-- Table structure for t_good_category
-- ----------------------------
DROP TABLE IF EXISTS `t_good_category`;
CREATE TABLE `t_good_category` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '帖子分类名称',
  `deleted` int(1) DEFAULT '0' COMMENT '0=未删除 1=删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='帖子分类表';

-- ----------------------------
-- Records of t_good_category
-- ----------------------------
INSERT INTO `t_good_category` VALUES ('0ed4204eb886828ce2153fb4600737a8', '三星', '0');
INSERT INTO `t_good_category` VALUES ('1020670a3f68535036f37bc21c7a99ae', '苹果', '0');
INSERT INTO `t_good_category` VALUES ('62bc9165650dda7d1d30f8e3a5c1a602', 'oppo', '0');
INSERT INTO `t_good_category` VALUES ('6e72626d658ce3fa2256abb12447172d', '华为', '0');
INSERT INTO `t_good_category` VALUES ('bd09197230559bdebea7acc9c1a41d92', '荣耀', '0');
INSERT INTO `t_good_category` VALUES ('ca3af09715543aba29e736b93fdf41f2', '嚯嚯嚯', '1');
INSERT INTO `t_good_category` VALUES ('ec60e1aa9a275d63ad9368ec1559d39d', 'vivo', '0');
INSERT INTO `t_good_category` VALUES ('eca60a661fa7ae1b201ea34f3ef0099c', '小米', '0');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(32) NOT NULL COMMENT '订单Id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户Id',
  `good_id` varchar(32) DEFAULT NULL COMMENT '用户Id',
  `total_price` varchar(32) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` varchar(32) DEFAULT NULL COMMENT '订单价格',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '1待发货 2 待收货 3待评价 4完成',
  `name` varchar(20) DEFAULT NULL COMMENT '订单收货人',
  `phone` varchar(20) DEFAULT NULL COMMENT '订单手机',
  `address` varchar(100) DEFAULT NULL COMMENT '订单地址',
  `create_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('2494fff82e01ed5c5401933bc60a87eb', 'd193b6e8fa765440c16f8ffa01acbd00', '2e48e83346628b624fbb77d34987c03c', '5399.0', '1', '5399', '1', '陈煜枫', '13726452983', '广东省广州市白云区12341231231', '2022-12-04 02:14:28');
INSERT INTO `t_order` VALUES ('61521561c764e51103901eab67e89dcf', 'd193b6e8fa765440c16f8ffa01acbd00', '32af9da4b03da3af7130b8930f23a31b', '2599.0', '1', '2599', '4', '陈煜枫', '13726452983', '广东省广州市白云区12341231231', '2022-12-03 10:14:34');
INSERT INTO `t_order` VALUES ('6fcf4e4eb2f60ad68bc3b4367a0e750f', 'd193b6e8fa765440c16f8ffa01acbd00', '32af9da4b03da3af7130b8930f23a31b', '2599.0', '1', '2599', '1', '测试地址', '13726452853', '江西省景德镇市昌江区2', '2022-02-12 05:12:32');
INSERT INTO `t_order` VALUES ('ad2c845b3c16c420f9d347c8026a3061', 'd193b6e8fa765440c16f8ffa01acbd00', 'f0ec98f32c0f340eff4da2d08aff895a', '5999.0', '1', '5999', '1', '陈煜枫', '13726452983', '广东省广州市白云区12341231231', '2022-12-03 10:14:34');
INSERT INTO `t_order` VALUES ('e3cea595988aa603414b3c5120b73b17', 'd193b6e8fa765440c16f8ffa01acbd00', '07fd502872eb75bf6230ed2fdcd2d2ec', '12138.0', '2', '6069', '1', '测试地址', '13726452853', '江西省景德镇市昌江区2', '2022-02-12 05:12:32');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名称',
  `phone` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '手机',
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码',
  `status` int(11) DEFAULT '1' COMMENT '1=正常，2=禁用',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '头像',
  `deleted` int(1) DEFAULT '0' COMMENT '0=未删除 1=已删除',
  `role_id` int(11) DEFAULT '1' COMMENT '1=普通用户 2=管理员',
  PRIMARY KEY (`id`),
  KEY `name_index` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('5c60cebf9a81c08e542ccfa46415327a', 'lgy1', '321', '123', '1', '/images/head/6dd5e703-8b8c-47f1-8f73-603016211cf7.jpg', '0', '1');
INSERT INTO `t_user` VALUES ('d193b6e8fa765440c16f8ffa01acbd00', 'zrq', '123', '123', '1', '/images/head/1ca18fa0-3b1d-4f7f-b0da-827ac35d2087.jpg', '0', '1');
INSERT INTO `t_user` VALUES ('db113badd1b2408b9b37e8d491a19f50', 'admin', '12580', '123', '1', '/images/head/logo.png', '0', '0');
