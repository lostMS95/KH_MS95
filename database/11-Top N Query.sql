/*
    Top N Query
    - 데이터를 원하는 개수, 범위만큼 끊어서 조회하는 구문 작성 방식
    - 사례 : Top 3, Top 100, 페이지네이션(Pagination)
    - rownum이 필요 : 결과집합의 데이터에 순서대로 부여되는 행번호(무조건 1부터 시작)
*/

select * from product;
select * from product order by price asc;

-- product 테이블에 rownum을 추가하여 조회
-- 문제점 : 항목이 먼저 해석되기 때문에 rownum이 부여된 상태로 정렬이 되어 의미가 없어진다.
select rownum, product.* from product;
select rownum, product.* from product order by price asc;

-- 1차 해결 : 서브쿼리를 이용하여 선 정렬 수행 후 rownum 부여
select rownum, TMP.* from (  
    select * from product order by price asc
)TMP;

-- Top 3
select rownum, TMP.* from (
    select * from product order by price asc
)TMP where rownum <= 3;

-- Q1 : 가격이 비싼제품 Top 5
select rownum, TMP.* from (
    select * from product order by price desc
)TMP where rownum <= 5;

-- Q2 : 가장 최근에 만든 제품 Top 3 / 가장 최근에 가입한 회원 3명
select rownum, TMP.* from (
    select * from product order by made desc
)TMP where rownum between 1 and 3;

select rownum, TMP.* from (
    select * from member order by member_join desc
)TMP where rownum between 1 and 3;

-- Q3 : 가격이 비싼제품 3등부터 5등까지
select rownum, TMP.* from (
    select * from product order by price desc
)TMP where rownum between 2 and 5;

-- 문제점 : ROWNUM을 부여하면서 조회할 경우 1부터 시작하는 경우만 조회할 수 있다.(중간조회가 불가능)

-- 2차 해결 : ROWNUM을 다 부여해놓고 나중에 조건으로 처리
-- select * from (2차결과) where rownum between 3 and 5;
-- rownum은 select를 할 때 생성되는 값이므로 원하는 값을 "별칭"으로 특정해줄 필요가 있다.
select * from (
    select rownum rn, TMP.* from (
        select * from product order by price desc
    )TMP
) where rn between 3 and 5;
