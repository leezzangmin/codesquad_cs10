use mission2;
create table mission2(
    userKey int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    startTime datetime NOT NULL,
    endTime datetime default NULL,
    selectedPC INT(10) NOT NULL
);

create table PCseat(
    seatNumber int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    isUsing BOOLEAN default FALSE
);

DELIMITER $$
CREATE PROCEDURE bb() -- ⓐ myFunction이라는 이름의 프로시져
BEGIN
    DECLARE i INT DEFAULT 1; -- ⓑ i변수 선언, defalt값으로 1설정
    WHILE (i <= 16) DO -- ⓒ for문 작성(i가 1000000이 될 때까지 반복)
    INSERT INTO PCseat VALUES ( i, FALSE );
    SET i = i + 1; -- ⓔ i값에 1더해주고 WHILE문 처음으로 이동
END WHILE;
END$$
DELIMITER ; -- ⓕ구분 기호를 다시 ;로 바꿔주기
CALL bb();