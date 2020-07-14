drop table if exists user;
CREATE TABLE `user`(
  `id` int NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
