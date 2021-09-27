/*
    회원 테이블 만들기
    
    다음 요구사항에 맞게 회원테이블을 구현
    
    <요구사항>
    - 테이블 이름은 "member"로 설정
    - 구성 항목 : 아이디, 비밀번호, 닉네임, 이메일, 전화번호, 생년월일, 가입일자, 포인트, 등급
        - 아이디(member_id) : 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.
        - 비밀번호(member_pw) : 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.
        - 닉네임(member_nick) : 한글 10글자 이내로 설정.
        - 생년월일(member_birth) : YYYY-MM-DD 형태의 데이터
        - 이메일(member_email) : 50byte 이내로 저장되며, 선택 입력 사항
        - 전화번호(member_phone) : 010-XXXX-XXXX 형태이며, 선택 입력 사항
        - 가입일자(member_join) : 반드시 저장시점의 시각으로 설정
        - 포인트(member_point) : 가입 시 기본적으로 100point를 지급
        - 등급(member_grade) : 가입 시 기본적으로 '준회원'으로 설정되며 준회원, 정회원, 우수회원, 관리자 중에서 설정 가능
*/

-- 문제에 대한 풀이
drop table member;
create table member(
member_id varchar2(20) not null unique,
member_pw varchar2(16) not null,
member_nick varchar2(30) not null unique,
member_birth date not null,
member_email varchar2(50),
member_phone char(13),
member_join date default sysdate not null,
member_point number default 100 not null check(member_point >= 0),
member_grade varchar2(12) default '준회원' not null check(member_grade in ('준회원', '정회원', '우수회원', '관리자'))
);

insert into member(member_id, member_pw,member_nick,member_birth,member_email,member_phone)
values('rmsdn0415', 'oracle' , 'lostms' , to_date('1995-04-15', 'YYYY-MM-DD'), null,null);

insert into member(member_id, member_pw,member_nick,member_birth)
values('rmsdn323', 'oracle' , 'lostms95' , to_date('1995-04-15', 'YYYY-MM-DD'));

commit;

select * from member;

-- 추가 조건 설정
-- 1. 대표 항목 설정(PRIMARY KEY) : 테이블 컬럼의 대표
--      = 단 하나만 설정이 가능하며 기본적으로 not null + unique 설정이 되어 있다
--      = not null + unique 항목 중 가장 범용성이 좋은 항목으로 선정
-- 2. 정규표현식 조건 설정
--      = regexp_like() 함수 사용
--      = regexp_like(항목, '정규표현식')
--      = check 안에 사용하여 해당 항목이 검사되도록 구현
--      = 데이터 추가 시 속도가 느려짐

CREATE TABLE member(
member_id varchar2(20) primary key check(regexp_like(member_id, '^[a-z][a-z0-9-_]{4,19}$')),
member_pw varchar2(16) not null check(regexp_like(member_pw, '^[a-zA-Z0-9-_!@#$]{8,16}$')),
member_nick varchar2(30) not null unique check(regexp_like(member_nick, '^[ㄱ-ㅎㅏ-ㅣ가-힣0-9]{1,10}$')),
member_birth date not null, 
member_email varchar2(50),
member_phone char(13) check(regexp_like(member_phone, '^010-[0-9]{4}-[0-9]{4}$')),
member_join date default sysdate not null,
member_point number default 100 not null check(member_point >=0),
member_grade varchar2(12) default '준회원' not null check(member_grade in('준회원','정회원','우수회원','관리자')) 
);

insert into member(member_id, member_pw, member_nick, member_birth, member_email, member_phone)
values('testuser3', 'testuser3', 'ㅋㅋㅋ1234', to_date('1999-01-10', 'YYYY-MM-DD'), null, '010-1234-1234');

select * from member;

commit;