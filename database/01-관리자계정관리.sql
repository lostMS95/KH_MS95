-- 관리자 계정(SYSTEM)을 이용하여 다음 계정 작업 수행

-- 1. student / student 계정 생성
create user student identified by student;
CREATE USER student IDENTIFIED BY student;

-- 2. master / master 계정 생성
create user master identified by master;

-- 3. 위에서 만든 계정 비밀번호를 khacademy로 변경
alter user student identified by khacademy;
alter user master identified by khacademy;

-- 4. 계정 정보 조회
select * from dba_users;
select username from dba_users;

-- 5. master 계정 삭제
drop user master;