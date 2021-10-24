/*
    Primary key(기본키, 고유키)
    = 테이블의 컬럼을 대표하는 역할
    = 테이블에 1개만 설정되어야 한다
    = UNIQUE와 다르게 하나만 설정되고, NOT NULL 까지 포함되어 있다
*/

-- ex : 학생정보를 저장(학년, 반, 번호, 이름)
-- 1. 학번이라는 고유항목을 만들어서 기본키로 관리
-- 2. 학년 + 반 + 번호를 조합해서 기본키로 관리(복합키 = composite key)
drop table student;
create table student(
grade number(1),
class number(1),
no number(2),
name varchar2(21),
primary key(grade, class, no)
-- unique(grade, class, no)
);

insert into student(grade, class, no, name) values(1, 1, 1, '피카츄');
insert into student(grade, class, no, name) values(1, 1, 2, '라이츄');
insert into student(grade, class, no, name) values(2, 2, 5, '파이리');
insert into student(grade, class, no, name) values(2, 2, 5, '꼬부기');-- 기본키(복합키) 위반 (무결성 조건 위반)