/*
    듀얼 테이블(dual table)
    - 작업을 수행하다보면 테이블이 없거나 처리가 어려운 경우가 발생
    - ex : 임시 계산 , 여기서 조금 저기서 조금 가져와서 보여줘야 하는 경우
    - 듀얼 테이블은 만드는것이 아니라 내장되어 있는 테이블
*/

select * from dual;

-- 1234 + 5678 의 결과를 출력
select 1234 + 5678 from dual;

/*
    단일 행 함수(Single-Row Function) : 하나의 입력으로 하나의 결과가 나오는 함수
*/

-- 문자열 덧셈
select concat('안녕','하세요') from dual;
select '안녕' || '하세요' from dual;

select * from product where name like concat('바', '%');
select * from product where name like '%' || '바' || '%';

-- 영문자 변환
select upper('Hello') from dual;
select lower('Hello') from dual;

select * from product where name = '바나나킥';
select * from product where lower(name) = lower('바나나킥');
select * from product where upper(name) = upper('바나나킥');

select initcap('hello java') "결과" from dual;

-- 문자열 자르기
select substr('ABCDEFG', 2) "결과" from dual;-- 2번째부터 잘라내라
select substr('ABCDEFG', 2, 3) "결과" from dual;-- 2번째부터 3글자 잘라내라

-- 문자열 치환
select replace('오늘 점심은 치킨이다!', '치킨', '중국집') from dual;

-- NVL : null을 치환
select nvl(null, 'hello') from dual;
select nvl('hi', 'hello') from dual;

select * from member;
select 
    member_id, member_pw, member_nick, member_birth, 
    nvl(member_email, '없음') "member_email", nvl(member_phone, '없음') "member_phone",
    member_join, member_point, member_grade
from member;

-- 문자열 길이 계산
select length('ABCDEFG') "길이" from dual;


/*
    집계 함수 : 주어진 데이터를 취합하여 결과를 만들어내는 함수
    (ex) 가장 비싼 상품의 가격, 모든 회원의 포인트 합계
    
    - 최대, 최소, 합계, 평균, 개수
*/

select * from product;
select max(price) "최대가격" from product;
select min(price) "최소가격" from product;
select sum(price) "합계" from product;
select avg(price) "평균" from product;

select count(price) "개수" from product;
select count(distinct price) "개수" from product;
select count(member_email) "회원수" from member;

select count(*) "개수" from product;
select count(*) "회원수" from member;

select * from member;