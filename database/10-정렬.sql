/*
    정렬(Sort)
    - 데이터를 원하는 목적에 맞게 나열하는 작업
    - order by 항목 asc/desc
*/

-- 상품을 가격순으로 조회(price asc)
select * from product order by price asc;

-- 상품을 이름순으로 조회(name asc)
select * from product order by name asc;

-- 상품을 가격 -> 이름 -> 번호순으로 조회
select * from product order by price asc, name asc, no asc;
select * from product order by price desc, name asc, no asc;
select * from product order by price desc, name, no;

-- 2020년에 제조된 상품을 최신순으로 조회(정렬은 제일 마지막에 해야 한다)
-- select * from product order by made desc where extract(year from made) = 2020;--1
select * from product where extract(year from made) = 2020 order by made desc;--2