drop table if exists student;
CREATE TABLE `student`(
  `id` int NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
);