use patentsys;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  serialnumber varchar(20) UNIQUE NOT NULL COMMENT '编号',
  username varchar(20) NOT NULL COMMENT '姓名',
  password varchar(64) NOT NULL COMMENT '密码',
  phone varchar(64) NOT NULL COMMENT '手机',
  sex varchar(10) NOT NULL COMMENT '性别 1男 2女 3保密',
  createTime DATE NOT NULL COMMENT '创建时间',
  editTime DATE DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user VALUES ('1', 'US85426987','twc', '123456', '13555588888', '1', current_date() , current_date());
INSERT INTO user VALUES ('2', 'US78541238','twc2', '123456', '13555588888', '2', current_date(), current_date());
INSERT INTO user VALUES ('3', 'US54456238', 'twc3', '123456', '13555588888', '3', current_date(), current_date());
INSERT INTO user VALUES ('4', 'US48484138', 'twc4', '123456', '13555588888', '1', current_date(), current_date());
INSERT INTO user VALUES ('5', 'US98556238', 'twc5', '123456', '13555588888', '2', current_date(), current_date());

DROP TABLE IF EXISTS author;

CREATE TABLE author (
  id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  serialnumber varchar(20) UNIQUE NOT NULL COMMENT '编号',
  name varchar(20) NOT NULL COMMENT '姓名',
  phone varchar (64) NOT NULL COMMENT '手机号码',
  address varchar(64) NOT NULL COMMENT '地址',
  userId varchar(64) NOT NULL COMMENT '管理员ID',
  createTime DATE NOT NULL COMMENT '创建时间',
  editTime DATE NOT NULL COMMENT '修改时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS patent;

CREATE TABLE patent (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  serialnumber varchar(20) UNIQUE NOT NULL COMMENT '编号',
  name varchar(64) NOT NULL COMMENT '专利名字',
  type varchar(16) NOT NULL COMMENT '专利类型 1发明专利 2实用新型专利 3外观设计专利',
  state varchar(16) NOT NULL COMMENT '专利状态 1专利申请尚未授权 2专利申请撤回 3专利权有效',
  authorId varchar(32) NOT NULL COMMENT '作者ID',
  createTime DATE NOT NULL COMMENT '创建时间',
  editTime DATE NOT NULL COMMENT '修改时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS file;

CREATE TABLE file (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  fileName varchar(200) UNIQUE NOT NULL COMMENT '文件名称',
  filePath varchar(200) NOT NULL COMMENT '文件路径',
  fileSize INT NOT NULL COMMENT '文件大小',
  userId varchar(64) NOT NULL COMMENT '管理员ID',
  canShare  NOT NULL COMMENT '是否共享',
  createTime DATE NOT NULL COMMENT '创建时间',
  editTime DATE NOT NULL COMMENT '修改时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

