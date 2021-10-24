/*
    Q : 가장 비싼 상품의 이름을 조회
    - 필터링 조건에 집계함수를 사용할 수 없다.
    - 따라서 집계함수를 먼저 실행시키고 그 결과를 이용하여 필터링을 수행
*/

select name from product where price = max(price);

select * from product;
select * from product where price = 1000;

select max(price) from product;--1. 최대가격 집계
select * from product where price = 3000;--2. 1번에서 나온 결과를 이용하여 조회

select * from product 
where price = (select max(price) from product);

-- 가격이 제일 저렴한 상품의 이름을 출력
select name from product where price = (select min(price) from product);

-- 포인트가 가장 적은 회원의 숫자
select min(member_point) from member;
select count(*) from member where member_point = 100;

select count(*) from member where member_point = (select min(member_point) from member);
select count(*) "포인트가 적은 회원 수" from member 
where member_point = (select min(member_point) from member);

-- 가장 최근에 가입한 회원의 모든정보
select max(member_join) from member;
select * from member where member_join = (select max(member_join) from member);
