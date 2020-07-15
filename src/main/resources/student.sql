drop table if exists student;
CREATE TABLE student(
   id BIGINT(20) NOT NULL COMMENT '主键ID',
  name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
  address varchar(32) NULL DEFAULT NULL COMMENT '地址'
);