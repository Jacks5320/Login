# 基于SpringBoot的登录注册

简单实现登录注册功能，相比于master分支的程序，解决的注册用户名为空的问题。

## 开发环境

1. IDEA_2019.2.3
2. MySql_8.0.17
3. Java8
4. Maven3

## SQL

~~~sql
-- 创建数据库
CREATE DATABASE IF NOT EXISTS example CHARACTER SET utf8 ;

USE example;

CREATE TABLE USER(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(32) UNIQUE NOT NULL,
    password VARCHAR(32) NOT NULL
);
-- 添加数据
INSERT INTO USER VALUES
(1,"admin","111"),
(2,"manager","222"),
(3,"normal","333");

SELECT * FROM user;
~~~