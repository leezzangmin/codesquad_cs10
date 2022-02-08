use mission2;
create table user(
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
CREATE PROCEDURE bb()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE (i <= 16) DO
    INSERT INTO PCseat VALUES ( i, FALSE );
    SET i = i + 1;
END WHILE;
END$$
DELIMITER ;
CALL bb();