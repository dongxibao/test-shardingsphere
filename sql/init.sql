-- schema.sql
create database `order_db1` default character set utf8mb4 collate utf8mb4_general_ci;
create database `order_db2` default character set utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS order_db1.t_order_1;
CREATE TABLE order_db1.t_order_1(
    order_id bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '订单id' ,
    user_id bigint(20)    COMMENT '用户id' ,
    price decimal(10,2)    COMMENT '价格' ,
    status varchar(64)    COMMENT '订单状态' ,
    PRIMARY KEY (order_id)
)  COMMENT = '订单表';

DROP TABLE IF EXISTS order_db1.t_order_2;
CREATE TABLE order_db1.t_order_2(
    order_id bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '订单id' ,
    user_id bigint(20)    COMMENT '用户id' ,
    price decimal(10,2)    COMMENT '价格' ,
    status varchar(64)    COMMENT '订单状态' ,
    PRIMARY KEY (order_id)
)  COMMENT = '订单表';

DROP TABLE IF EXISTS order_db1.t_dict;
CREATE TABLE order_db1.t_dict(
    dict_id bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    dict_type VARCHAR(255)    COMMENT '字典类型' ,
    dict_code VARCHAR(255)    COMMENT '字典编码' ,
    dict_name VARCHAR(255)    COMMENT '字典名称' ,
    PRIMARY KEY (dict_id)
)  COMMENT = '字典表';

---------------------------------------------------------------
DROP TABLE IF EXISTS order_db2.t_order_1;
CREATE TABLE order_db2.t_order_1(
    order_id bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '订单id' ,
    user_id bigint(20)    COMMENT '用户id' ,
    price decimal(10,2)    COMMENT '价格' ,
    status varchar(64)    COMMENT '订单状态' ,
    PRIMARY KEY (order_id)
)  COMMENT = '订单表';

DROP TABLE IF EXISTS order_db2.t_order_2;
CREATE TABLE order_db2.t_order_2(
    order_id bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '订单id' ,
    user_id bigint(20)    COMMENT '用户id' ,
    price decimal(10,2)    COMMENT '价格' ,
    status varchar(64)    COMMENT '订单状态' ,
    PRIMARY KEY (order_id)
)  COMMENT = '订单表';
DROP TABLE IF EXISTS order_db2.t_user;
CREATE TABLE order_db2.t_user(
    user_id bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '用户id' ,
    user_name VARCHAR(255)    COMMENT '用户名' ,
    phone VARCHAR(255)    COMMENT '手机号' ,
    PRIMARY KEY (user_id)
)  COMMENT = '用户';
DROP TABLE IF EXISTS order_db2.t_dict;
CREATE TABLE order_db2.t_dict(
    dict_id bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    dict_type VARCHAR(255)    COMMENT '字典类型' ,
    dict_code VARCHAR(255)    COMMENT '字典编码' ,
    dict_name VARCHAR(255)    COMMENT '字典名称' ,
    PRIMARY KEY (dict_id)
)  COMMENT = '字典表';

