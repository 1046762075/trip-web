/*
 Navicat Premium Data Transfer

 Source Server         : Nay
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : trip_db

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 08/10/2020 23:37:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `lr_id` int(11) NOT NULL AUTO_INCREMENT,
  `lr_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_date` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_for_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_for_words` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_for_reply` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_for_article_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_forumId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lr_hotel_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`lr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tp_admin
-- ----------------------------
DROP TABLE IF EXISTS `tp_admin`;
CREATE TABLE `tp_admin`  (
  `tp_aid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_aname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_aemail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_apwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tp_aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tp_admin
-- ----------------------------
INSERT INTO `tp_admin` VALUES (1, 'root', 'root@root.com', 'root');

-- ----------------------------
-- Table structure for tp_forum
-- ----------------------------
DROP TABLE IF EXISTS `tp_forum`;
CREATE TABLE `tp_forum`  (
  `tp_fid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_author_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_sub_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_issue_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_tag` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_tcontent` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`tp_fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tp_hotel
-- ----------------------------
DROP TABLE IF EXISTS `tp_hotel`;
CREATE TABLE `tp_hotel`  (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `local` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `people_num` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_size` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tp_hotel
-- ----------------------------
INSERT INTO `tp_hotel` VALUES (1, '馨逸时尚主题客栈', '长沙', '情侣', '单床', '18173516302', '2', '岳麓区天顶街道雷锋大道228号（青山路与雷锋大道交汇处，近湖南商务职业技术学院）', '10-15㎡', '180', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/2fffdbee15a8.png?Expires=4755767390&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=mYbvblWXAmqu%2B%2FtlPMGcFpwdLr8%3D', '<p>本店地理位置优越，交通便利，服务热情，欢迎入住！</p><p><br></p>');
INSERT INTO `tp_hotel` VALUES (2, '铭凤主题酒店', '长沙', '情侣', '单床', '18173516309', '2', '[世界之窗]开福区共和路洪西小区37栋2单元1楼', '12-18㎡', '156', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/27626c2457cd.png?Expires=4755767567&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=R3KMvx1GoG1s4OzrTwum2Y5yjlA%3D', '<p>酒店配套设置齐全，集餐饮、大堂吧、会议室、咖啡吧，健身房为一体。客房内设有中央空调，极速宽带、自助洗衣房、送餐服务、以及大型的地下停车场。欢迎入住</p>');
INSERT INTO `tp_hotel` VALUES (3, '港探号·爱享风尚酒店(南湖路地铁站店)', '长沙', '商务', '单床', '18173516309', '1', '[五一广场/贺龙]天心区南湖路44号（近建筑学校、邮电学校）', '10-15㎡', '210', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/3caa1a2d233c.png?Expires=4755768337&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=4yr%2FcmsgLRPWHiEJYBYPKYEMRIQ%3D', '<p>【地址位置】❤酒店位于繁华的天心区南湖路44号。 【交通便利*地铁站】❤南湖路地铁站1号出口85米。 【交通便利*公交车站】❤酒店对面有101(到火车站，机场）601·804·908.917 .360. 377. 239 .377，等等~ 【购物娱乐】❤酒店离五一广场，黄兴步行街，坡子街，地铁两个站即可到达。 【旅游观光】❤步行五分钟可到湘江风光带，过江即可到达岳麓山，离贺龙体育馆也只需要十分钟车程 。 【周边学校.医院】❤邮电学院. 长沙理工大学.雅礼中学. 南湖医院. 湖南省儿童医院 .五洲医院.等等~ 【酒店配套】❤酒店还有格调典雅、独具风格的茶餐厅，餐厅配有棋牌包厢，有饮品、菜肴、套餐。 （温馨提示：不可带宠物入住哦！）</p>');
INSERT INTO `tp_hotel` VALUES (4, '缘希艺术酒店', '长沙', '情侣', '单床', '18173516309', '2', '[泉塘/星城国际]长沙县远大路与东六路交汇处泉塘安置小区c区26栋28号（近中联重科、水利水电职业技术学院）', '10-15㎡', '140', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/fb8a189c1614.png?Expires=4755768599&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=kEkoEeo9iBqrVRanwN7qEGvqAG0%3D', '<p>地理位置优越，服务热情，欢迎入住！</p>');
INSERT INTO `tp_hotel` VALUES (5, '趣柯里酒店(五一路火车站地铁站店)', '长沙', '商务', '单双床', '18173516309', '2', '[长沙火车站]芙蓉区五一大道79号人健大厦1楼', '12-18㎡', '240', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/0b7c946b7bcf.png?Expires=4755768742&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=Xy7Kl3G3BK49F8xITp80rGUfAXo%3D', '<p>酒店位于长沙主干道五一大道，距离长沙火车站仅800米，袁家岭地铁站步行5分钟即到，紧邻长沙芙蓉广场、五一广场，交通便利。还专门为时尚情侣、居家旅行、商务出行等人群专门打造了各种类型的房型，情侣主题房、亲子房、女性专属房型等，同时还为住客提供各类生活服务，洗衣、餐饮、健身等。 酒店为您营造舒适怡人的住店体验、提供热情、温馨、诚挚的一站式服务，期待您的到来。</p>');
INSERT INTO `tp_hotel` VALUES (6, '漫·屋顶情景主题酒店', '长沙', '情侣', '单床', '18173516309', '2', '[汽车西站、达美]岳麓区枫林三路8号喜地大厦（距望城坡地铁站3口290米，维也纳国际酒店西站店旁）', '12-18㎡', '170', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/730cb2992633.png?Expires=4755768891&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=aESFPGXLSZbBL2AeO8DvbHi%2BqjA%3D', '<p>酒店位于枫林二路汽车西站附近，酒店房间以个性化主题风格为主，每间客房都有其独特的风，无论是想要浪漫，或是想要放松，再者是想要小清新等等风格，我们都可以满足您的要求，同时每间客房都配有饮用水1瓶/人/天，全天24小时热水、千兆WIFI高速上网，网络电视等，部分房间还有投影设备，不论是商务出行，情侣浪漫，还是度假旅游，或者是个人入住都可满足需求，酒店地处位置优越，交通四通八达，位于长沙汽车西站商圈，距离汽车西站只有50米，同时酒店附近还有大型生活超市步步高超市，同时枫林路也是一条繁华的街道，游玩，品尝当地的特色，聚餐，娱乐等都非常的方便，从酒店到达长沙市中心五一广场和黄兴路步行街也只有8公里左右的路程，距离银盆岭大桥也只有5公里左右的路程，同时酒店附近就是地铁入口以及公交站台，不论您去任何地方都非常的方便，酒店期待您的下榻。</p>');
INSERT INTO `tp_hotel` VALUES (7, '谊致人文酒店', '长沙', '商务', '单双床', '18173516309', '2', '[长沙火车站]雨花区万家丽中路一段358号上河国际商业广场A区4楼（距5号线高桥北站3号出口70米）', '12-18㎡', '120', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/114199541f0c.png?Expires=4755769293&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=y0nIYOfEngwOwNOeHb3CQHbiqcg%3D', '<p>酒店坐落在长沙市雨花区万家丽中路一段358号上河国际商业广场A栋，周围餐饮、娱乐等生活配套齐全，地理位置优越出行方便。楼下就是地铁5号线高桥北站3号出口，周边就是高桥大市场。</p>');
INSERT INTO `tp_hotel` VALUES (8, '哪家酒店(长沙高铁南站店)', '长沙', '商务', '单双床', '18173516309', '2', '[长沙南站]雨花区曲塘路恒大国际广场商业楼11栋（自助图书馆旁，距长沙南站1.5公里）', '12-18㎡', '166', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/f5c4ae8ed628.png?Expires=4755769641&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=3eLB6LvNLQhvwoFWC5JrNGOGiho%3D', '<p>【疫情期间配备】前台备免洗洗手液、进门鞋底消毒；客房备有杀菌洗手液、独立包装酒精消毒棉片；酌情为客提供口罩。 本店位于长沙南站商业片区，是一家以简约设计为主/注重体验品质的中高端酒店。地处长沙武广新城片区的核心地段，不仅坐拥高铁站枢纽和机场磁浮车站的绝好地理位置，而且距离长沙国际会展中心也较近车程不到10分钟，酒店同时提供【高铁站和地铁口接送服务】，门口亦有公交车站和4号线地铁口，出行十分的便利。酒店附近有大型商场：保利mall广场，吃本地美食国外美食/购物/看电影/KTV应有尽有。酒店拥有各种风格的房型，每种房型都是以“舒适/品质”为基础而做出的简约设计，设施配备均以客人体验为首而选择了品质高又好用的产品，均受客人的喜爱。还有一些小心思，等着您来发现哦！</p>');

-- ----------------------------
-- Table structure for tp_traffic
-- ----------------------------
DROP TABLE IF EXISTS `tp_traffic`;
CREATE TABLE `tp_traffic`  (
  `tp_Tid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_current` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_destination` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_current_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_arrive_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_tprice` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tp_Tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tp_traffic
-- ----------------------------
INSERT INTO `tp_traffic` VALUES (1, '火车', '长沙市', '郴州市', '2020-10-07 13:05:20', '2020-10-07 14:50:42', '154.0');
INSERT INTO `tp_traffic` VALUES (2, '飞机', '长沙市', '成都市', '2020-10-08 18:05:38', '2020-10-08 20:05:38', '450');
INSERT INTO `tp_traffic` VALUES (3, '火车', '郴州市', '长沙市', '2020-10-08 18:35:45', '2020-10-08 20:05:38', '135');
INSERT INTO `tp_traffic` VALUES (4, '飞机', '郴州市', '成都市', '2020-10-10 18:35:45', '2020-10-10 20:42:00', '489');

-- ----------------------------
-- Table structure for tp_user
-- ----------------------------
DROP TABLE IF EXISTS `tp_user`;
CREATE TABLE `tp_user`  (
  `tp_uid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_uname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_uemail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_upwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_age` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_gender` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_upic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_regdate` timestamp(0) NULL DEFAULT NULL,
  `tp_update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`tp_uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tp_user
-- ----------------------------
INSERT INTO `tp_user` VALUES (1, 'firenay', 'firenay@qq.com', '123', '19', '男', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/15e6c28b9b53.jpg?Expires=4755771258&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=dTvYPYywSYJ%2BXDWXHY0u8%2FB%2Fsj8%3D', '18173516309', '2020-10-08 20:26:23', '2020-10-08 23:34:21');

-- ----------------------------
-- Table structure for tp_viewpoint
-- ----------------------------
DROP TABLE IF EXISTS `tp_viewpoint`;
CREATE TABLE `tp_viewpoint`  (
  `tp_vid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_vname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_vtype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_vpic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_vphone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_level` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_zip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_opentime` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tp_creatTime` timestamp(0) NULL DEFAULT NULL,
  `tp_vcontent` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`tp_vid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tp_viewpoint
-- ----------------------------
INSERT INTO `tp_viewpoint` VALUES (1, '电影小镇', '华谊兄弟（长沙）电影小镇', '休闲', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/12c933a4e2bc.png?Expires=4755770003&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=q8m7%2BZx%2BZA9N2W07Vt35QJ4lV9c%3D', '18173516309', '3', '40', '长沙', '岳麓区坪塘街道星光路6号', '8:00-20:00', '2020-10-08 23:13:47', NULL);
INSERT INTO `tp_viewpoint` VALUES (2, '橘子洲景区', '橘子洲景区', '游玩', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/ffe43e669698.png?Expires=4755770138&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=wxjOpuAnVCGGjVVEMr9RSuqv4ho%3D', '18173516309', '2', '0', '长沙', '岳麓区橘子洲景区(地铁二号线橘子洲站下)', '0:00-24:00', '2020-10-08 23:16:43', NULL);
INSERT INTO `tp_viewpoint` VALUES (3, '长沙世界之窗', '长沙世界之窗', '游玩', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/4f4db5c52608.png?Expires=4755770293&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=naBcoBnGwn%2BWMRfvkk22roW40Dg%3D', '18173516309', '2', '167', '长沙', '开福区三一大道485号（近湖南广播电视台）', '夏季 周一至周日 08:30-06:00 冬季 周六,周日 08:30-23:00 周一至周五 08:30-22:00', '2020-10-08 23:18:22', NULL);
INSERT INTO `tp_viewpoint` VALUES (4, '贝拉小镇', '贝拉小镇', '休闲', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/426565001bd9.png?Expires=4755770412&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=%2FS7LQzrZPdVOXB%2B5Ynrl2eitwzY%3D', '18173516309', '3', '85', '长沙', '望城区金洲大道光明村贝拉路88号', '6:00-22:00', '2020-10-08 23:20:26', NULL);
INSERT INTO `tp_viewpoint` VALUES (5, '长沙星空蹦床减压馆', '长沙星空蹦床减压馆', '游玩', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/9dbc3658141a.png?Expires=4755770519&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=I0lN73RhiwcFWNcnf87QrNOiNMU%3D', '18173516309', '2', '38', '长沙', '开福区黄兴中路87号万代大酒店粉巢玩美空间二楼', '20:00-3:00', '2020-10-08 23:22:32', NULL);
INSERT INTO `tp_viewpoint` VALUES (6, '太平街', '太平街', '休闲', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/0b5e1e0a36aa.png?Expires=4755770609&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=6kqAkIwkXYBWgO2tkdN7svkjYqY%3D', '18173516309', '3', '120', '长沙', '天心区五一大道太平街路口（五一大道太平街路口）', '0:00-24:00', '2020-10-08 23:23:37', NULL);
INSERT INTO `tp_viewpoint` VALUES (7, '月亮岛', '月亮岛', '游玩', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/89e1705d1bbc.png?Expires=4755770723&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=wA%2Bq8B0rSnl7ylQtuh2xXpkuxlk%3D', '18173516309', '4', '96', '长沙', '望城区市区西北14公里的湘江西岸', '8:00-23:00', '2020-10-08 23:25:39', NULL);
INSERT INTO `tp_viewpoint` VALUES (8, '岳麓山风景名胜区', '岳麓山风景名胜区', '游玩', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/ce5b791765e8.png?Expires=4755770807&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=UIpS3TS2%2Fk5iDVGsMzi5DmZ%2B8gQ%3D', '18173516309', '3', '0', '长沙', '岳麓区登高路58号', '周一至周日 06:00-23:00', '2020-10-08 23:27:01', NULL);
INSERT INTO `tp_viewpoint` VALUES (9, '长沙生态动物园', '长沙生态动物园', '休闲', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/c30b4addb507.png?Expires=4755770933&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=782RqSr5GOJ3uf7aWQsQpbQgFSw%3D', '18173516309', '3', '130', '长沙', '天心区芙蓉南路四段729号', '周一 09:00-17:00', '2020-10-08 23:29:04', NULL);
INSERT INTO `tp_viewpoint` VALUES (10, '长沙海底世界', '长沙海底世界', '游玩', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/7bf4abefcbc1.png?Expires=4755771022&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=iIVwWuQh5SD%2BNH1EjBIHf3kfRKI%3D', '18173516309', '2', '75', '长沙', '开福区三一大道501号', '夏季 周一至周日 08:30-05:00 冬季 周一至周日 09:00-05:00', '2020-10-08 23:30:47', NULL);
INSERT INTO `tp_viewpoint` VALUES (11, '湘江欢乐城欢乐雪域', '湘江欢乐城欢乐雪域', '游玩', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/7a4245520c5b.png?Expires=4755771105&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=TnFGhNe930QyEHZpsI8bnung6rE%3D', '18173516309', '2', '170', '长沙', '岳麓区潭州大道二段168号', '0:00-24:00', '2020-10-08 23:32:03', NULL);
INSERT INTO `tp_viewpoint` VALUES (12, '汉服·潮拍网红公园', '汉服·潮拍网红公园', '休闲', 'http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/e51a4b8ed539.png?Expires=4755771203&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=sT%2FT9Gr0GYnqUeCXd88G8HJQMfc%3D', '18173516309', '2', '35', '长沙', '芙蓉区五一广场新世界百货供销大厦1902F', '0:00-24:00', '2020-10-08 23:33:27', NULL);

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words`  (
  `lw_id` int(11) NOT NULL AUTO_INCREMENT,
  `lw_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lw_date` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lw_content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lw_for_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lw_for_article_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lw_forumId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lw_hotel_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`lw_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
