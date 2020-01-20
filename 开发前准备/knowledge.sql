/*
 Navicat Premium Data Transfer

 Source Server         : myMacMysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : knowledge

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 20/01/2020 14:57:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `admin_id` varchar(100) NOT NULL,
  `admin_username` varchar(200) NOT NULL,
  `admin_password` varchar(100) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_username` (`admin_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
BEGIN;
INSERT INTO `admins` VALUES ('1', 'admin', '$2a$10$IsfDQiar0XRC92OKuah1zuIuqNgAnOn5Arb2oUEPxH/I.raG4b05e');
COMMIT;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `comment_id` varchar(100) NOT NULL,
  `comment_content` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `video_id` varchar(100) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `COMMENTS_ON_VIDEO_KEY` (`video_id`),
  KEY `COMMENTS_ON_USER_KEY` (`user_id`),
  CONSTRAINT `COMMENTS_ON_USER_KEY` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `COMMENTS_ON_VIDEO_KEY` FOREIGN KEY (`video_id`) REFERENCES `videos` (`video_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
BEGIN;
INSERT INTO `comments` VALUES ('044ba731-9f11-428a-8ebe-c0cf11ae4b58', '水评论，加经验。水评论，加经验。', '2020-01-19 11:07:54', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('09c4bfe7-d25b-46ac-b900-afef43d5decf', '很好，下次一定买咸鱼，嘿嘿嘿', '2020-01-19 11:00:10', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('2829c00e-0779-4aef-850f-459e693bfd7c', '很好，下次一定买', '2020-01-19 10:37:10', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('2ed65705-d754-461a-b953-38500ccd9f40', '水评论，加经验。', '2020-01-19 11:07:41', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('313b033e-4219-4f4d-8531-2fee33edd5fb', '水评论，加经验。', '2020-01-19 11:07:39', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('4bf65249-7c03-4c38-a1f4-1f91d51f3b11', '下次再来', '2020-01-19 09:15:38', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff1', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('5275c536-b65d-4dd7-a3b6-afbdd89c2ee7', '水评论，加经验。', '2020-01-19 11:07:45', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('649225e7-1bd9-4885-95f1-a122ad8ea9c7', '水评论，加经验。', '2020-01-19 11:07:46', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('766f3682-b7be-43e1-8f61-6f08718241d4', '下次一定', '2020-01-19 09:06:50', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff1', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('7cf191b3-cf7e-4d08-a22f-239849d345aa', '--', '2020-01-20 05:45:13', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff1', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('8688b681-3127-439a-b940-b40ba37ce8a0', '水评论，加经验。', '2020-01-19 11:07:43', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('ae240662-315e-4f00-b8cf-189089fae0ce', '水评论，加经验。', '2020-01-19 11:07:49', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('d3b900d2-0286-4ee5-b78f-708329bc3721', '	 水评论，加经验。', '2020-01-19 11:12:56', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff1', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('d88801d1-52b0-45c3-b21e-826ff29aeb97', '水评论，加经验。', '2020-01-19 11:13:07', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff1', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('dd035935-4735-4a64-8807-f2a1ffc30b95', '水评论，加经验。', '2020-01-19 11:07:44', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('f6528bd6-ad8a-4beb-8e43-13c8d196027b', '水评论，加经验。水评论，加经验。水评论，加经验。', '2020-01-19 11:07:56', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff0', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
INSERT INTO `comments` VALUES ('f6fd370b-c720-4ed7-ba39-2c502a59e46d', '水评论，加经验。', '2020-01-19 11:13:02', 'f413d17b-68a5-4e36-979f-55a3c0ac3ff1', '3e5856e7-524f-477e-ba72-2489b1fc2f0a');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` varchar(100) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(64) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('3e5856e7-524f-477e-ba72-2489b1fc2f0a', '下次一定', '$2a$10$Gug3Q55W0cG/RiYfmrnuZOLaoxM2xJbIKfDVRZBzRNQu9US0yG26m', '2278765105@qq.com', '2020-01-19 07:57:14', NULL);
COMMIT;

-- ----------------------------
-- Table structure for videos
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `video_id` varchar(100) NOT NULL,
  `video_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video_title` varchar(100) NOT NULL,
  `video_des` text NOT NULL,
  `video_image` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `admin_id` varchar(100) NOT NULL,
  PRIMARY KEY (`video_id`),
  KEY `BIDEOS_ON_ADMIN_KEY` (`admin_id`),
  CONSTRAINT `BIDEOS_ON_ADMIN_KEY` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videos
-- ----------------------------
BEGIN;
INSERT INTO `videos` VALUES ('f413d17b-68a5-4e36-979f-55a3c0ac3ff0', 'https://v-cdn.zjol.com.cn/280443.mp4', '资源111', '这是一个资源文件，描述也只是一个测试，不用在意那么多没用的。', 'http://a1.att.hudong.com/60/38/01200000194369136323385641912.jpg', '2020-01-19 10:34:32', NULL, '1');
INSERT INTO `videos` VALUES ('f413d17b-68a5-4e36-979f-55a3c0ac3ff1', 'https://v-cdn.zjol.com.cn/280443.mp4', '下次一定', '下次一定,下次一定,下次一定,下次一定.', 'http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg', '2020-01-19 15:01:57', NULL, '1');
INSERT INTO `videos` VALUES ('f413d17b-68a5-4e36-979f-55a3c0ac3ff3', 'http://strliu.oss-cn-shenzhen.aliyuncs.com/knowledge/ea671954-5108-49e5-b276-3927ed8910921-1%20%E5%85%B3%E4%BA%8E%E8%BF%99%E9%97%A8%E8%AF%BE%E7%A8%8B%EF%BC%8C%E4%BD%A0%E6%83%B3%E4%BA%86%E8%A7%A3%E7%9A%84%E9%83%BD%E5%9C%A8%E8%BF%99%E9%87%8C.mp4973fbb87-267a-4380-8354-b6d6771eef89WebRTC%E4%BB%8B%E7%BB%8D.mp4f1895cc1-26c2-4cc1-8c19-18d3d6c22467home-bg.jpgc806255c-9f69-4df1-8131-737da04c1d9e1-1%20%E5%85%B3%E4%BA%8E%E8%BF%99%E9%97%A8%E8%AF%BE%E7%A8%8B%EF%BC%8C%E4%BD%A0%E6%83%B3%E4%BA%86%E8%A7%A3%E7%9A%84%E9%83%BD%E5%9C%A8%E8%BF%99%E9%87%8C.mp4?Expires=1579487576&OSSAccessKeyId=LTAI4FpC4mSZ1Ujs4UWnTvfV&Signature=aNHR7pP8nSMHh%2BtWNr0A9JGZuZA%3D', '开始学习前端知识', '这是学习视频', 'http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg', '2020-01-19 00:35:59', '2020-01-19 16:43:41', '1');
INSERT INTO `videos` VALUES ('f413d17b-68a5-4e36-979f-55a3c0ac3ff4', 'http://strliu.oss-cn-shenzhen.aliyuncs.com/knowledge/ea671954-5108-49e5-b276-3927ed8910921-1%20%E5%85%B3%E4%BA%8E%E8%BF%99%E9%97%A8%E8%AF%BE%E7%A8%8B%EF%BC%8C%E4%BD%A0%E6%83%B3%E4%BA%86%E8%A7%A3%E7%9A%84%E9%83%BD%E5%9C%A8%E8%BF%99%E9%87%8C.mp4973fbb87-267a-4380-8354-b6d6771eef89WebRTC%E4%BB%8B%E7%BB%8D.mp4', '学习webrtc', 'webrtc实战课程介绍', 'http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg', '2020-01-20 00:39:22', '2020-01-19 16:45:14', '1');
INSERT INTO `videos` VALUES ('f413d17b-68a5-4e36-979f-55a3c0ac3ff5', 'http://strliu.oss-cn-shenzhen.aliyuncs.com/knowledge/ea671954-5108-49e5-b276-3927ed8910921-1%20%E5%85%B3%E4%BA%8E%E8%BF%99%E9%97%A8%E8%AF%BE%E7%A8%8B%EF%BC%8C%E4%BD%A0%E6%83%B3%E4%BA%86%E8%A7%A3%E7%9A%84%E9%83%BD%E5%9C%A8%E8%BF%99%E9%87%8C.mp4', '不能浪费啊，这也是几十m', '花了我几十m流量的视频，真的不能浪费，浪费就可惜了', 'http://a1.att.hudong.com/60/38/01200000194369136323385641912.jpg', '2020-01-20 00:42:08', NULL, '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
