docker -v
docker pull mysql:5.7
docker images
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=lcm12345 -d -p 3307:3307 mysql:5.7
docker ps -a
docker stop mysql-container
docker start mysql-container
docker restart mysql-container

docker exec -it mysql-container bash
mysql -u root -p #lcm12345
show databases;

-- https://www.44bits.io/ko/post/setup_linux_locale_on_ubuntu_and_debian_container#%EB%A1%9C%EC%BC%80%EC%9D%BC-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-%EC%96%B8%EC%96%B4-%EC%A7%80%EC%97%AD-%EC%BD%94%EB%93%9C%EC%85%8B
locale
docker exec -it -e LC_ALL=C.UTF-8 mysql-container bash

apt-get install apt
apt update
apt install nano
nano /etc/mysql/mysql.conf.d/mysqld.cnf
'''

[client]
default-character-set = utf8mb4

[mysqld]
init-connect = 'SET collation_connection = utf8mb4_unicode_ci'
init-connect = 'SET NAMES utf8mb4'
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci
default_time_zone='+09:00'

[mysql]
default-character-set = utf8mb4

[mysqldump]
default-character-set = utf8mb4
''' https://gist.github.com/ksundong/7f695db1486d1ab28f854d3f0d1dcf66

service mysql restart
create database zzangmin;
use zzangmin;  -- 접속권한 설정해야함
CREATE DATABASE db_name;
CREATE USER 'user'@'ip' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON db_name.* TO 'user'@'ip';
FLUSH PRIVILEGES;


mysql> create table user_log(
    -> nickname varchar(64),
    -> money dec(10,2),
    -> last_visit datetime);

insert into user_log values("asdf",1,"2020-10-11");
delete from user_log;


DELIMITER $$ 
CREATE PROCEDURE aa()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE A VARCHAR(64) DEFAULT 'zzang';
    WHILE (i <= 1000000) DO

        SET A = concat("zzang_",LEFT(UUID(), 7));
        INSERT INTO user_log VALUES ( A, FLOOR(1 + rand() * 100000 ), FROM_UNIXTIME(FLOOR(unix_timestamp('2022-01-07 00:00:00')+(RAND()*(unix_timestamp('2022-02-07 00:00:00')-unix_timestamp('2010-01-01 00:00:00'))))) ); -- ⓓ 테이블에 i값 넣어주기
        SET i = i + 1; -
        SET A = 'zzang';
    END WHILE;
END$$
DELIMITER ;
SET AUTOCOMMIT = FALSE;
CALL aa();
SET AUTOCOMMIT = TRUE;

http://www.gnujava.com/board/article_view.jsp?article_no=1062&menu_cd=25&board_no=12&table_cd=EPAR05&table_no=05
https://blog.edit.kr/entry/mysql-%EB%AC%B8%EC%9E%90%EC%97%B4-%ED%95%A9%EC%B9%98%EA%B8%B0
https://foxtrotin.tistory.com/281