/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : ihuishou

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2019-05-05 21:36:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_bank_card`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank_card`;
CREATE TABLE `tb_bank_card` (
  `card_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `card_bank` varchar(10) default NULL,
  `card_real_name` varchar(10) default NULL,
  `card_num` varchar(20) default NULL,
  PRIMARY KEY  (`card_id`),
  KEY `FK_user_card` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bank_card
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_brand`
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `brand_id` int(11) NOT NULL auto_increment,
  `brand_name` varchar(10) default NULL,
  PRIMARY KEY  (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand` VALUES ('1', 'iPhone');
INSERT INTO `tb_brand` VALUES ('2', '魅族');
INSERT INTO `tb_brand` VALUES ('3', '诺基亚');
INSERT INTO `tb_brand` VALUES ('4', 'LG');
INSERT INTO `tb_brand` VALUES ('5', '三星');
INSERT INTO `tb_brand` VALUES ('6', '华为');
INSERT INTO `tb_brand` VALUES ('7', '小米');
INSERT INTO `tb_brand` VALUES ('8', 'HTC');
INSERT INTO `tb_brand` VALUES ('9', '联想');

-- ----------------------------
-- Table structure for `tb_chit`
-- ----------------------------
DROP TABLE IF EXISTS `tb_chit`;
CREATE TABLE `tb_chit` (
  `chit_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `chit_name` varchar(10) default NULL,
  `chit_account` varchar(20) default NULL,
  PRIMARY KEY  (`chit_id`),
  KEY `FK_user_chit` (`user_id`),
  CONSTRAINT `FK_user_chit` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_chit
-- ----------------------------
INSERT INTO `tb_chit` VALUES ('1', '1', '崔Java', '123223432344234');
INSERT INTO `tb_chit` VALUES ('2', '1', '崔加瓦', '1234223432344234');
INSERT INTO `tb_chit` VALUES ('3', '1', '崔加瓦', '1234223432344234');
INSERT INTO `tb_chit` VALUES ('4', '1', '嘤嘤嘤', '131313131313131313');
INSERT INTO `tb_chit` VALUES ('5', '1', '嘤嘤嘤', '131313131313131313');
INSERT INTO `tb_chit` VALUES ('6', '1', '崔志凡', '131313131313131313');
INSERT INTO `tb_chit` VALUES ('7', '1', '崔志凡', '131313131313131313');
INSERT INTO `tb_chit` VALUES ('8', '1', '崔志凡', '131313131313131313');
INSERT INTO `tb_chit` VALUES ('9', '1', '崔志凡', '131313131313131313');
INSERT INTO `tb_chit` VALUES ('10', '1', '崔志凡', '131313131313131313');
INSERT INTO `tb_chit` VALUES ('11', '1', '崔志凡', '131313131313131313');

-- ----------------------------
-- Table structure for `tb_discount`
-- ----------------------------
DROP TABLE IF EXISTS `tb_discount`;
CREATE TABLE `tb_discount` (
  `discount_id` int(11) NOT NULL auto_increment,
  `type_id` int(11) default NULL,
  `info_id` int(11) default NULL,
  `discount_value` varchar(10) default NULL,
  PRIMARY KEY  (`discount_id`),
  KEY `FK_estimate_discount` (`info_id`),
  KEY `FK_type_discount` (`type_id`),
  CONSTRAINT `FK_estimate_discount` FOREIGN KEY (`info_id`) REFERENCES `tb_estimate_info` (`info_id`),
  CONSTRAINT `FK_type_discount` FOREIGN KEY (`type_id`) REFERENCES `tb_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_discount
-- ----------------------------
INSERT INTO `tb_discount` VALUES ('1', '1', '1', '0');
INSERT INTO `tb_discount` VALUES ('2', '1', '2', '25000');
INSERT INTO `tb_discount` VALUES ('3', '1', '3', '50000');
INSERT INTO `tb_discount` VALUES ('4', '1', '4', '75000');
INSERT INTO `tb_discount` VALUES ('5', '1', '5', '%0.99');
INSERT INTO `tb_discount` VALUES ('6', '1', '6', '%0.9');
INSERT INTO `tb_discount` VALUES ('7', '1', '7', '0');
INSERT INTO `tb_discount` VALUES ('8', '1', '8', '%0.9');
INSERT INTO `tb_discount` VALUES ('9', '1', '9', '%0.8');
INSERT INTO `tb_discount` VALUES ('10', '1', '10', '50000');
INSERT INTO `tb_discount` VALUES ('11', '1', '11', '20000');
INSERT INTO `tb_discount` VALUES ('12', '1', '12', '0');
INSERT INTO `tb_discount` VALUES ('13', '1', '13', '0');
INSERT INTO `tb_discount` VALUES ('14', '1', '14', '0');
INSERT INTO `tb_discount` VALUES ('15', '1', '15', '-5000');
INSERT INTO `tb_discount` VALUES ('16', '1', '16', '0');
INSERT INTO `tb_discount` VALUES ('17', '1', '17', '0');
INSERT INTO `tb_discount` VALUES ('18', '1', '18', '0');
INSERT INTO `tb_discount` VALUES ('19', '1', '19', '0');
INSERT INTO `tb_discount` VALUES ('20', '1', '20', '%0.8');
INSERT INTO `tb_discount` VALUES ('21', '1', '21', '%0.9');
INSERT INTO `tb_discount` VALUES ('22', '1', '22', '%0.9');
INSERT INTO `tb_discount` VALUES ('23', '1', '23', '%0.9');
INSERT INTO `tb_discount` VALUES ('24', '1', '24', '%0.9');
INSERT INTO `tb_discount` VALUES ('25', '1', '25', '%0.9');
INSERT INTO `tb_discount` VALUES ('26', '1', '26', '%0.9');
INSERT INTO `tb_discount` VALUES ('27', '1', '27', '%0.9');
INSERT INTO `tb_discount` VALUES ('28', '1', '28', '%0.9');
INSERT INTO `tb_discount` VALUES ('29', '1', '29', '%0.9');
INSERT INTO `tb_discount` VALUES ('30', '1', '30', '0');
INSERT INTO `tb_discount` VALUES ('31', '1', '31', '%0.95');
INSERT INTO `tb_discount` VALUES ('32', '1', '32', '%0.9');
INSERT INTO `tb_discount` VALUES ('33', '1', '33', '%0.7');
INSERT INTO `tb_discount` VALUES ('34', '1', '34', '0');
INSERT INTO `tb_discount` VALUES ('35', '1', '35', '%0.95');
INSERT INTO `tb_discount` VALUES ('36', '1', '36', '%0.9');
INSERT INTO `tb_discount` VALUES ('37', '1', '37', '%0.8');
INSERT INTO `tb_discount` VALUES ('38', '1', '38', '0');
INSERT INTO `tb_discount` VALUES ('39', '1', '39', '%0.95');
INSERT INTO `tb_discount` VALUES ('40', '1', '40', '%0.9');
INSERT INTO `tb_discount` VALUES ('41', '1', '41', '%0.8');
INSERT INTO `tb_discount` VALUES ('42', '1', '42', '0');
INSERT INTO `tb_discount` VALUES ('43', '1', '43', '%0.95');
INSERT INTO `tb_discount` VALUES ('44', '1', '44', '%0.9');
INSERT INTO `tb_discount` VALUES ('45', '1', '45', '%0.8');
INSERT INTO `tb_discount` VALUES ('46', '1', '46', '-1000');
INSERT INTO `tb_discount` VALUES ('47', '1', '47', '-500');
INSERT INTO `tb_discount` VALUES ('48', '1', '48', '-1000');
INSERT INTO `tb_discount` VALUES ('49', '1', '49', '-500');
INSERT INTO `tb_discount` VALUES ('50', '1', '50', '-1000');
INSERT INTO `tb_discount` VALUES ('51', '5', '51', '1');
INSERT INTO `tb_discount` VALUES ('52', '5', '52', '1');
INSERT INTO `tb_discount` VALUES ('53', '5', '53', '1');
INSERT INTO `tb_discount` VALUES ('54', '5', '15', '1');
INSERT INTO `tb_discount` VALUES ('55', '5', '16', '1');
INSERT INTO `tb_discount` VALUES ('56', '5', '54', '1');
INSERT INTO `tb_discount` VALUES ('57', '5', '19', '1');
INSERT INTO `tb_discount` VALUES ('58', '5', '20', '1');
INSERT INTO `tb_discount` VALUES ('59', '5', '22', '1');
INSERT INTO `tb_discount` VALUES ('60', '5', '23', '1');
INSERT INTO `tb_discount` VALUES ('61', '5', '24', '1');
INSERT INTO `tb_discount` VALUES ('62', '5', '25', '1');
INSERT INTO `tb_discount` VALUES ('63', '5', '26', '1');
INSERT INTO `tb_discount` VALUES ('64', '5', '27', '1');
INSERT INTO `tb_discount` VALUES ('65', '5', '29', '1');
INSERT INTO `tb_discount` VALUES ('66', '5', '30', '1');
INSERT INTO `tb_discount` VALUES ('67', '5', '31', '1');
INSERT INTO `tb_discount` VALUES ('68', '5', '32', '1');
INSERT INTO `tb_discount` VALUES ('69', '5', '33', '1');
INSERT INTO `tb_discount` VALUES ('70', '5', '34', '1');
INSERT INTO `tb_discount` VALUES ('71', '5', '35', '1');
INSERT INTO `tb_discount` VALUES ('72', '5', '36', '1');
INSERT INTO `tb_discount` VALUES ('73', '5', '37', '1');
INSERT INTO `tb_discount` VALUES ('74', '5', '38', '1');
INSERT INTO `tb_discount` VALUES ('75', '5', '39', '1');
INSERT INTO `tb_discount` VALUES ('76', '5', '40', '1');
INSERT INTO `tb_discount` VALUES ('77', '5', '41', '1');
INSERT INTO `tb_discount` VALUES ('78', '5', '42', '1');
INSERT INTO `tb_discount` VALUES ('79', '5', '43', '1');
INSERT INTO `tb_discount` VALUES ('80', '5', '44', '1');
INSERT INTO `tb_discount` VALUES ('81', '5', '45', '1');
INSERT INTO `tb_discount` VALUES ('82', '5', '46', '1');
INSERT INTO `tb_discount` VALUES ('83', '5', '47', '1');
INSERT INTO `tb_discount` VALUES ('84', '5', '48', '1');
INSERT INTO `tb_discount` VALUES ('85', '5', '49', '1');
INSERT INTO `tb_discount` VALUES ('86', '5', '50', '1');

-- ----------------------------
-- Table structure for `tb_estimate`
-- ----------------------------
DROP TABLE IF EXISTS `tb_estimate`;
CREATE TABLE `tb_estimate` (
  `estimate_id` int(11) NOT NULL auto_increment,
  `estimate_name` varchar(20) default NULL,
  `estimate_page` int(10) default NULL,
  PRIMARY KEY  (`estimate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_estimate
-- ----------------------------
INSERT INTO `tb_estimate` VALUES ('1', '版本', '1');
INSERT INTO `tb_estimate` VALUES ('2', '保修期', '1');
INSERT INTO `tb_estimate` VALUES ('3', '型号', '1');
INSERT INTO `tb_estimate` VALUES ('4', '机身内存', '1');
INSERT INTO `tb_estimate` VALUES ('5', '颜色', '1');
INSERT INTO `tb_estimate` VALUES ('6', '开机情况', '1');
INSERT INTO `tb_estimate` VALUES ('7', '功能情况（可多选或不选）', '2');
INSERT INTO `tb_estimate` VALUES ('8', '外观情况', '3');
INSERT INTO `tb_estimate` VALUES ('9', '触摸屏情况', '3');
INSERT INTO `tb_estimate` VALUES ('10', '显示情况', '3');
INSERT INTO `tb_estimate` VALUES ('11', '维修情况', '3');
INSERT INTO `tb_estimate` VALUES ('12', '配件', '3');

-- ----------------------------
-- Table structure for `tb_estimate_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_estimate_info`;
CREATE TABLE `tb_estimate_info` (
  `info_id` int(11) NOT NULL auto_increment,
  `estimate_id` int(11) default NULL,
  `info_name` varchar(20) default NULL,
  `info_text` varchar(255) default NULL,
  `info_info1` varchar(255) default NULL,
  `info_info2` varchar(255) default NULL,
  PRIMARY KEY  (`info_id`),
  KEY `FK_estimate_estimateInfo` (`estimate_id`),
  CONSTRAINT `FK_estimate_estimateInfo` FOREIGN KEY (`estimate_id`) REFERENCES `tb_estimate` (`estimate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_estimate_info
-- ----------------------------
INSERT INTO `tb_estimate_info` VALUES ('1', '1', '大陆行货', '内地购买，有“进网许可证”标签', null, null);
INSERT INTO `tb_estimate_info` VALUES ('2', '1', '香港行货', '香港购买，全球联保', null, null);
INSERT INTO `tb_estimate_info` VALUES ('3', '1', '水货无锁', '非大陆港行，其他地区', null, null);
INSERT INTO `tb_estimate_info` VALUES ('4', '1', '水货有锁', '国外发行机型，需用卡贴解锁后正常通话', null, null);
INSERT INTO `tb_estimate_info` VALUES ('5', '2', '保修一个月以上', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('6', '2', '保修一个月内或过保', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('7', '3', 'A1780', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('8', '3', 'A1660', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('9', '3', '其他型号', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('10', '4', '32G', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('11', '4', '128G', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('12', '4', '256G', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('13', '5', '红色', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('14', '5', '粉色', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('15', '5', '金色', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('16', '5', '白色', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('17', '5', '黑色', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('18', '5', '亮黑', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('19', '6', '开机正常', '开机正常，无死机重启现象', null, null);
INSERT INTO `tb_estimate_info` VALUES ('20', '6', '开机不正常', '开机不正常出现死机/重启/不开', null, null);
INSERT INTO `tb_estimate_info` VALUES ('21', '7', '有换机', '系统型号N开头（针对在保机器，2次以上按保修过保处理，含2次）', null, null);
INSERT INTO `tb_estimate_info` VALUES ('22', '7', '机身进水或受潮', '机身水标发红/机身受潮/机板发霉', null, null);
INSERT INTO `tb_estimate_info` VALUES ('23', '7', '按键接口机卡槽不正常', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('24', '7', '指纹功能不正常', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('25', '7', '蓝牙/WiFi功能不正常', '蓝牙/WiFi出现信号弱/不稳定/无法连接', null, null);
INSERT INTO `tb_estimate_info` VALUES ('26', '7', '照相机感光功能不正常', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('27', '7', '通话功能不正常', '信号时有时无/无信号/通话无声/杂音', null, null);
INSERT INTO `tb_estimate_info` VALUES ('28', '7', 'iCloud账号不能解除', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('29', '7', '机身有变形', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('30', '8', '全新机', '原封未拆/未使用（需提供身份证及购机发票，无法提供不回收）', null, null);
INSERT INTO `tb_estimate_info` VALUES ('31', '8', '95新', '外观完好无磕碰/掉漆/划痕', null, null);
INSERT INTO `tb_estimate_info` VALUES ('32', '8', '8-9新', '机身有明显划痕', null, null);
INSERT INTO `tb_estimate_info` VALUES ('33', '8', '6-7新', '机身有磕碰/破裂/掉漆及屏幕与机身分离情况', null, null);
INSERT INTO `tb_estimate_info` VALUES ('34', '9', '完好无破损', '触摸屏完好，无破损失灵现象', null, null);
INSERT INTO `tb_estimate_info` VALUES ('35', '9', '屏幕划痕/爆胶', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('36', '9', '碎角及裂痕', '触摸屏出现碎角/破裂', null, null);
INSERT INTO `tb_estimate_info` VALUES ('37', '9', '触摸失灵', '菊部失灵或整屏失灵', null, null);
INSERT INTO `tb_estimate_info` VALUES ('38', '10', '显示完好', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('39', '10', '显示有瑕疵', '显示屏在纯色（如纯白/纯蓝）背景下有色差，亮点', null, null);
INSERT INTO `tb_estimate_info` VALUES ('40', '10', '显示异常', '显示屏出现花屏/错乱/漏液/断线/严重发黄压伤/模糊等', null, null);
INSERT INTO `tb_estimate_info` VALUES ('41', '10', '显示屏损坏', '屏幕显示不全/不显示', null, null);
INSERT INTO `tb_estimate_info` VALUES ('42', '11', '无拆修', '手机完好无拆修', null, null);
INSERT INTO `tb_estimate_info` VALUES ('43', '11', '有拆无修', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('44', '11', '屏幕维修', '更换过手机屏幕', null, null);
INSERT INTO `tb_estimate_info` VALUES ('45', '11', '主板维修', '机身/主板进行拆卸维修', null, null);
INSERT INTO `tb_estimate_info` VALUES ('46', '12', '充电器', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('47', '12', '数据线', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('48', '12', '耳机', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('49', '12', '包装盒', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('50', '12', '保修卡', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('51', '1', '标准版', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('52', '1', '高级版', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('53', '1', '尊享版', null, null, null);
INSERT INTO `tb_estimate_info` VALUES ('54', '5', '其他颜色', null, null, null);

-- ----------------------------
-- Table structure for `tb_history`
-- ----------------------------
DROP TABLE IF EXISTS `tb_history`;
CREATE TABLE `tb_history` (
  `history_id` int(11) NOT NULL auto_increment,
  `type_id` int(11) default NULL,
  `history_money` int(11) default NULL,
  `history_time` date default NULL,
  PRIMARY KEY  (`history_id`),
  KEY `FK_type_history` (`type_id`),
  CONSTRAINT `FK_type_history` FOREIGN KEY (`type_id`) REFERENCES `tb_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_history
-- ----------------------------
INSERT INTO `tb_history` VALUES ('1', '1', '2745', '2018-11-01');
INSERT INTO `tb_history` VALUES ('2', '1', '2739', '2018-12-01');
INSERT INTO `tb_history` VALUES ('3', '1', '2591', '2019-01-01');
INSERT INTO `tb_history` VALUES ('4', '1', '2311', '2019-02-01');
INSERT INTO `tb_history` VALUES ('5', '1', '2312', '2019-03-01');
INSERT INTO `tb_history` VALUES ('6', '1', '2200', '2019-04-01');

-- ----------------------------
-- Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `order_id` varchar(20) NOT NULL,
  `user_id` int(11) default NULL,
  `order_price` int(11) default NULL,
  `order_user_name` varchar(10) default NULL,
  `order_user_tel` varchar(20) default NULL,
  `order_ad` varchar(255) default NULL,
  `order_ad_info` varchar(255) default NULL,
  `order_model` varchar(1) default NULL,
  `order_info` varchar(255) default NULL,
  `take_time1` varchar(20) default NULL,
  `take_time2` varchar(20) default NULL,
  `order_estimates` varchar(1000) default NULL,
  `post_company` varchar(20) default NULL,
  `post_code` varchar(50) default NULL,
  `order_status` int(11) default NULL,
  `order_create_time` datetime default NULL,
  `order_phone_type` int(11) default NULL,
  `order_info1` varchar(255) default NULL,
  `order_info2` varchar(255) default NULL,
  `order_info3` varchar(255) default NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FK_user_order` (`user_id`),
  CONSTRAINT `FK_user_order` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('01d389387a8c44f19dde', '1', '2000', null, null, null, null, null, null, null, null, 'QAQ', null, null, '1', '2019-04-25 00:00:00', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('01e45a70089e4f1987e2', '42', '2322', null, null, null, null, null, null, null, null, '大陆行货,保修一个月内或过保,A1780,256G,金色,开机正常,全新机,完好无破损,显示完好,无拆修,数据线,耳机,包装盒,保修卡', null, null, '0', '2019-04-26 17:07:08', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('07e871c71e114203ba1b', '1', '1880', '嘤嘤嘤', '18707194655', '3-37-414', '光谷智慧园21栋', 'y', '111-11111', '', '', '香港行货,保修一个月以上,A1780,128G,金色,开机正常,有换机,全新机,完好无破损,显示完好,无拆修,充电器', null, null, '1', '2019-04-27 18:44:32', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('0974579349d3402e86ff', '44', '1877', null, null, null, null, null, null, null, null, '香港行货,保修一个月以上,A1660,256G,金色,开机正常,全新机,屏幕划痕/爆胶,显示完好,有拆无修,充电器,耳机,包装盒,保修卡', null, null, '0', '2019-04-26 17:17:24', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('302d993b12fc437a8f60', '1', '1671', '崔Java', '18707194655', '13-180-1554', '光谷智慧园21栋', 'y', '咸鱼-11111', '12', '24', '香港行货,保修一个月以上,A1660,256G,金色,开机正常,有换机,全新机,屏幕划痕/爆胶,显示完好,有拆无修,充电器', null, null, '1', '2019-04-27 14:01:37', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('33b472f926864511a94d', '1', '1646', '崔Java', '18707194655', '13-180-1554', '光谷智慧园21栋', 'y', '咸鱼-12342234', '12：00', '16：00', '香港行货,保修一个月以上,A1660,256G,金色,开机不正常,全新机,完好无破损,显示完好,无拆修,充电器', null, null, '1', '2019-04-27 13:55:33', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('42124c4d3a2c49dfae97', '1', '903', '嘤嘤嘤', '18707194655', '29-362-3070', '111', 'y', '咸鱼-11111', '', '', '香港行货,保修一个月以上,其他型号,128G,红色,开机正常,有换机,iCloud账号不能解除,全新机,屏幕划痕/爆胶,显示异常,主板维修,保修卡', null, null, '1', '2019-04-27 15:24:38', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('435a05958d88419ebb0e', '1', '2166', '随便', '18707194655', '29-355-3031', '光谷智慧园21栋', 'y', '冰淇淋-11111', '', '', '大陆行货,保修一个月以上,A1780,256G,金色,开机正常,有换机,全新机,完好无破损,显示有瑕疵,无拆修,数据线,包装盒', null, null, '1', '2019-04-27 18:36:53', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('4927a8a9a08b424abc8d', '1', '1852', '崔Java', '18912342234', '26-322-2727', '光谷智慧园21栋', 'n', '2-阿哲-1111111111111111111', '', '', '大陆行货,保修一个月以上,A1780,256G,金色,开机正常,按键接口机卡槽不正常,机身有变形,全新机,屏幕划痕/爆胶,显示完好,有拆无修,耳机', null, null, '1', '2019-04-27 19:30:09', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('50ac9c3cd53b407e8641', '1', '901', '哲哥', '18912342234', '2-52-500', '光谷智慧园21栋', 'n', '2-阿哲-1111111111111111111', '', '', '香港行货,保修一个月以上,其他型号,128G,红色,开机正常,有换机,iCloud账号不能解除,全新机,屏幕划痕/爆胶,显示异常,主板维修,数据线', null, null, '1', '2019-04-26 21:17:07', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('512ba84e81ac4edc97f8', '1', '829', '崔Java', '18707194655', '2-52-500', '光谷智慧园21栋', 'y', '咸鱼-11111', '', '', '大陆行货,保修一个月内或过保,其他型号,128G,红色,开机不正常,有换机,全新机,屏幕划痕/爆胶,显示异常,主板维修,充电器,数据线,耳机,包装盒,保修卡', null, null, '1', '2019-04-27 18:30:37', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('5508cbd6f32b4a80a762', '1', '2285', '嘤嘤嘤', '18707194655', '3-37-409', '光谷智慧园21栋', 'y', '111-11111', '', '', '大陆行货,保修一个月以上,A1780,256G,金色,开机正常,有换机,全新机,完好无破损,显示完好,无拆修,耳机,包装盒', null, null, '1', '2019-04-27 19:22:45', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('65ad8f523c604982afa7', '1', '1407', '嘤嘤嘤', '18707194655', '9-121-3409', '光谷智慧园21栋', 'y', '咸鱼-11111', '', '', '大陆行货,保修一个月内或过保,A1780,256G,红色,开机正常,按键接口机卡槽不正常,全新机,屏幕划痕/爆胶,显示异常,主板维修,充电器,数据线,耳机,包装盒,保修卡', null, null, '1', '2019-05-04 14:29:54', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('74baf1d6b1254ff1b86f', '1', '903', '嘤嘤嘤', '18912342234', '3-37-409', '光谷智慧园21栋', 'n', '9-123456-1111111111111111111', '', '', '香港行货,保修一个月以上,其他型号,128G,红色,开机正常,有换机,iCloud账号不能解除,全新机,屏幕划痕/爆胶,显示异常,主板维修,保修卡', null, null, '1', '2019-04-27 15:25:40', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('806c8288b17c4cdb84a7', '41', '2079', null, null, null, null, null, null, null, null, '大陆行货,保修一个月内或过保,A1780,256G,金色,开机正常,全新机,屏幕划痕/爆胶,显示完好,有拆无修,充电器', null, null, '0', '2019-04-26 17:06:07', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('8ff0bedcc1054a8c8856', '1', '2099', '哲哥', '18912342234', '2-52-500', '光谷智慧园21栋', 'n', '2-阿哲-1111111111111111111', '', '', '大陆行货,保修一个月内或过保,A1780,256G,金色,开机正常,全新机,屏幕划痕/爆胶,显示完好,有拆无修,充电器,耳机,包装盒,保修卡', null, null, '1', '2019-04-26 17:18:23', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('95fcf3c2c17342c68cbb', '1', '903', '嘤嘤嘤', '18912342234', '3-37-409', '光谷智慧园21栋', 'n', '9-123456-1111111111111111111', '', '', '香港行货,保修一个月以上,其他型号,128G,红色,开机正常,有换机,iCloud账号不能解除,全新机,屏幕划痕/爆胶,显示异常,主板维修,保修卡', null, null, '1', '2019-04-27 15:25:42', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('a092b946f2c9475cad63', '1', '993', '哲哥', '18912342234', '2-52-500', '光谷智慧园21栋', 'n', '2-阿哲-1111111111111111111', '', '', '大陆行货,保修一个月以上,A1780,256G,金色,开机正常,有换机,机身进水或受潮,按键接口机卡槽不正常,指纹功能不正常,蓝牙/WiFi功能不正常,照相机感光功能不正常,通话功能不正常,iCloud账号不能解除,机身有变形,全新机,完好无破损,显示完好,无拆修,充电器,数据线,耳机,包装盒,保修卡', null, null, '1', '2019-04-26 16:10:14', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('a1d5806b64154a2d90d0', '41', '2079', null, null, null, null, null, null, null, null, '大陆行货,保修一个月内或过保,A1780,256G,金色,开机正常,全新机,屏幕划痕/爆胶,显示完好,有拆无修,充电器', null, null, '0', '2019-04-26 17:05:55', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('a825b99cc250423ca656', '1', '1671', '嘤嘤嘤', '18912342234', '6-77-705', '光谷智慧园21栋', 's', '1', '11', '12', '香港行货,保修一个月以上,A1660,256G,金色,开机正常,有换机,全新机,屏幕划痕/爆胶,显示完好,有拆无修,充电器', null, null, '1', '2019-04-27 19:31:54', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('b444e0d0357b49b8a4a5', '1', '1848', '嘤嘤嘤', '18707194655', '9-121-3409', '光谷智慧园21栋', 'y', '咸鱼-11111', '', '', '水货无锁,保修一个月以上,A1660,256G,金色,开机正常,全新机,完好无破损,显示完好,无拆修,耳机,包装盒,保修卡', null, null, '1', '2019-04-30 17:53:27', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('b63d4c2244114aae8378', '1', '1575', '不认识', '18707194655', '29-351-3004', '光谷智慧园21栋', 'y', '咸鱼-11111', '', '', '大陆行货,保修一个月内或过保,A1780,256G,金色,开机正常,全新机,屏幕划痕/爆胶,显示异常,主板维修,保修卡', null, null, '1', '2019-04-27 19:28:46', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('bf783c9244eb4d15b927', '1', '1273', '嘤嘤嘤', '18707194655', '3-37-409', '光谷智慧园21栋', 'y', '111-11111', '', '', '香港行货,保修一个月以上,A1660,32G,粉色,开机正常,机身进水或受潮,全新机,屏幕划痕/爆胶,显示完好,有拆无修,耳机', null, null, '1', '2019-04-29 18:06:19', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('d3e1f9a659a54cdca78e', '1', '2058', '不认识', '18707194655', '2-52-500', '光谷智慧园21栋', 'y', '咸鱼-11111', '', '', '大陆行货,保修一个月以上,A1780,256G,金色,开机正常,有换机,全新机,屏幕划痕/爆胶,显示完好,有拆无修,耳机', null, null, '1', '2019-04-27 18:49:35', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('e82ce83850b641ae9eb1', '1', '1075', '崔Java', '18707194655', '3-37-410', '光谷智慧园21栋', 'n', '3-123456-1111111111111111111', '11', '12', '大陆行货,保修一个月内或过保,A1780,128G,金色,开机正常,有换机,机身进水或受潮,按键接口机卡槽不正常,蓝牙/WiFi功能不正常,95新,屏幕划痕/爆胶,显示有瑕疵,屏幕维修,数据线,包装盒', null, null, '1', '2019-04-27 21:50:23', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('f26a9085f2f147ba91d7', '1', '1688', '崔Java', '18707194655', '6-77-707', '光谷智慧园21栋', 's', '1', '', '', '大陆行货,保修一个月内或过保,A1780,128G,红色,开机正常,有换机,全新机,屏幕划痕/爆胶,显示完好,有拆无修,充电器', null, null, '1', '2019-04-27 15:37:18', '1', null, null, null);
INSERT INTO `tb_order` VALUES ('test1', '0', '1000', '嘤嘤嘤', '18707194655', '3-36-398', '光谷智慧园21栋', 'n', '18-123456-1111111111111111111', '', '', null, null, null, '1', null, '1', null, null, null);
INSERT INTO `tb_order` VALUES ('test2', '0', '500', null, null, null, null, null, null, null, null, null, null, null, '0', null, '5', null, null, null);

-- ----------------------------
-- Table structure for `tb_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `type_id` int(11) NOT NULL auto_increment,
  `brand_id` int(11) default NULL,
  `type_name` varchar(20) default NULL,
  `type_money` int(11) default NULL,
  `type_pic` varchar(50) default NULL,
  `type_info1` varchar(255) default NULL,
  `type_info2` varchar(255) default NULL,
  PRIMARY KEY  (`type_id`),
  KEY `FK_brand_type` (`brand_id`),
  CONSTRAINT `FK_brand_type` FOREIGN KEY (`brand_id`) REFERENCES `tb_brand` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES ('1', '1', 'iPhone7', '250000', 'iphone7.jpg', null, null);
INSERT INTO `tb_type` VALUES ('2', '1', 'iPhone7 Plus', '300000', 'iphone7_plus.jpg', null, null);
INSERT INTO `tb_type` VALUES ('3', '1', 'iPhone6', '100000', 'iphone6.jpg', null, null);
INSERT INTO `tb_type` VALUES ('4', '1', 'iPhone6 Plus', '150000', 'iphone6_plus.jpg', null, null);
INSERT INTO `tb_type` VALUES ('5', '7', '小米手机5', '60000', 'xiaomi5.jpg', null, null);
INSERT INTO `tb_type` VALUES ('6', '7', '小米手机4S', '30000', 'xiaomi4s.jpg', null, null);

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(10) default NULL,
  `user_pwd` varchar(32) default NULL,
  `user_balance` int(11) default '0',
  `user_frozen` int(11) default '0',
  `user_frozen_otn` int(11) default '0',
  `user_email` varchar(20) default NULL,
  `join_time` datetime default NULL,
  `user_level` int(11) default NULL,
  `user_income` int(11) default '0',
  `user_phone` varchar(20) default NULL,
  `user_info1` varchar(255) default NULL,
  `user_info2` varchar(255) default NULL,
  `user_info3` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('0', '购物车', null, '0', '0', '0', '0', '2019-04-27 17:19:59', '0', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('1', '崔Java', '111111', '100933803', '140700', '0', '243975576@qq.com', '2019-04-25 09:28:44', '5', '100933803', '18707194655', null, null, null);
INSERT INTO `tb_user` VALUES ('41', null, null, null, null, null, null, null, '-1', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('42', null, null, null, null, null, null, null, '-1', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('43', null, null, null, null, null, null, null, '-1', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('44', null, null, null, null, null, null, null, '-1', null, null, null, null, null);

-- ----------------------------
-- Table structure for `tb_zbf`
-- ----------------------------
DROP TABLE IF EXISTS `tb_zbf`;
CREATE TABLE `tb_zbf` (
  `ZFB_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `ZFB_name` varchar(10) default NULL,
  `ZFB_num` varchar(50) default NULL,
  PRIMARY KEY  (`ZFB_id`),
  KEY `FK_user_ZFB` (`user_id`),
  CONSTRAINT `FK_user_ZFB` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zbf
-- ----------------------------
