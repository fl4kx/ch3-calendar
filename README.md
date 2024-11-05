# Calendar 일정 관리

일정을 관리하는 어플리케이션 입니다.

### API 명세서

![API](https://github.com/user-attachments/assets/62c4cd88-c14e-4a8c-a942-0e3e750e3ce5)

### ERD

![ERD](https://github.com/user-attachments/assets/1b8331cc-6e0d-4dad-9500-b848d6b05299)

### SQL

#### 테이블 생성

CREATE TABLE SCHEDULES (id INTEGER, author VARCHAR(20), title VARCHAR(50), registration_date DATE, modified_date DATE);

#### 일정 생성

INSERT 
INTO SCHEDULES 
VALUES (0, 'hyeon', '일정1' ,20241101, 20241101);

#### 전체 일정 조회

SELECT author,
       title,
       registration_date,
       modified_date
FROM SCHEDULES;

#### 일정 조회

SELECT id, 
FROM SCHEDULES;

#### 일정 수정

UPDATE SCHEDULES
SET title = '변경된 일정1'
WHERE id = 0;

#### 일정 삭제

DELETE
FROM SCHEDULES
WHERE id = 0;
