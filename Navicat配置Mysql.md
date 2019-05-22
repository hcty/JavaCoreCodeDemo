## Navicat配置Mysql

####  修改加密规则 

ALTER USER 'root'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE NEVER;  

#### 更新一下用户的密码 

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';   

#### 刷新权限

FLUSH PRIVILEGES;   

#### 再重置下密码

ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';  

