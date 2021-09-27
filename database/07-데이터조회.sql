/*
    테이블 조회(Read)
    - 테이블에 들어있는 데이터를 "원하는 목적"에 맞게 조회하는 기법
    - 필터링, 정렬 , 분석(그룹, 통계), 오라클 제공 함수
*/
-- 샘플테이블 작성
drop table product;
drop sequence product_seq;

create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('과자','아이스크림','주류','사탕')),
price number,
made date,
expire date
);

insert into product values(1, '스크류바', '아이스크림', 1200, '2020-05-01', '2020-10-01');
insert into product values(2, '마이쮸', '사탕', 900, '2020-01-01', '2021-01-01');
insert into product values(3, '초코파이', '과자', 3000, '2020-01-01', '2021-01-01');
insert into product values(4, '맛동산', '과자', 2200, '2020-02-01', '2020-10-20');
insert into product values(5, '참이슬', '주류', 1000, '2020-01-05', '2020-04-05');
insert into product values(6, '처음처럼', '주류', 1000, '2020-03-15', '2020-08-15');
insert into product values(7, '바나나킥', '과자', 1500, '2020-05-03', '2020-06-03');
insert into product values(8, '빠삐코', '아이스크림', 1000, '2019-12-01', '2020-06-01');
insert into product values(9, '멘토스', '사탕', 1200, '2020-03-20', '2020-12-31');
insert into product values(10, '오레오', '과자', 2100, '2019-06-01', '2020-06-01');

commit;

-- 조회 구문의 형식
-- select 항목 from 대상(테이블) 

-- product 테이블의 모든 항목(*)을 조회
select * from product;

-- product 테이블의 이름(name)을 조회
select name from product;
 
-- product 테이블의 이름(name)과 가격(pridce)을 조회
select name,price from product;

-- product 테이블의 name, price에 별칭을 부여하여 조회
select name 이름, price 가격 from product;
select name "상품 이름" , price "판매 가격" from product;

/*
    행 필터링 조건 설정
    -데이터베이스에 10만개의 데이터가 있을 경우 다 보는 경우보다는 "목적"에 맞게 선택적으로 보는 것이 중요
    =select 항목 from 대상 where 필터식;

*/

-- 가격이 1000원인 상품을 조회
select * from product where price = 1000;

-- 번호가 7번인 상품을 조회
select * from product where no = 7;

-- 가격이 2000원 미만인 상품을 조회
select * from product where price < 2000;

-- 가격이 1000원 이상 2000원 이하인 상품을 조회
-- 오라클에서는 && , || 를 사용할 수 없다.(다른 의미의 기호)
-- && 대신에 and , || 대신에 or 이라고 사용한다.

-- a이상 b이하 라고 표현할 수 있지만 a와 b 사이 처럼 표현도 가능하다.

-- select * from product where price >= 1000 && price <= 2000;
select * from product where price>= 1000 and price <=2000;

select * from product where price between 1000 and 2000;

-- 가격이 1000원이 아닌 상품 조회
select * from product where price != 1000;
-- select * from product where price <> 1000;

/*
    문자열 조건
    = 오라클에서는 문자열도 숫자처럼 비교가 가능하다.
*/

-- 이름이 스크류바인 상품 정보를 조회
select * from product where name = '스크류바';

-- 아이스크림만 조회
select * from product where type = '아이스크림';

select * from product;


/*
유사검색 : 일부분만으로 검색하는 방법(instr 명령 사용 / like 연산자 사용)
like에서는 %를 "있어도 그만 없어도 그만"으로 처리한다
        = 시작한다는 의미는 뒤에 %를 붙이면 된다
        = 종료한다는 의미는 앞에 %를 붙이면 된다
        = 포함된다는 의미는 앞뒤에 %를 각각 붙이면 된다
instr()에서는 문자열의 시작점을 1로 본다.
        = 시작한다는 의미는 instr()의 결과가 1이란 소리이다.
        = 종료한다는 의미는 instr()의 결과가 (항목글자수 - 검색어글자수 + 1)란 소리이다.
        = 포함된다는 의미는 instr()의 결과가 0보다 크단 소리이다.
        
결론 : like는 시작검색 특화, 나머지는 instr()이 전반적으로 우수
*/

-- 이름이 '바'로 시작하는 상품 정보를 조회
select * from product where name like '바%';
select * from product where instr(name, '바') = 1;
select * from product where regexp_like(name, '바[가-힣]*');

-- 이름이 '바'로 끝나는 상품 정보를 조회
select * from product where name like '%바';
select * from product where instr(name, '바') = length(name) - length('바') + 1;
select * from product where regexp_like(name, '[가-힣].*?바');

-- 이름에 '바'가 포함된 상품 정보를 조회
select * from product where name like '%바%';
select * from product where instr(name, '바') > 0;
select * from product where regexp_like(name, '[가-힣]*바[가-힣]*');

/*
    날짜 조건
    = 문자열처럼 비교가 가능하지만 잘 사용하지 않는다
    = 날짜는 System.currentTimeMillis() 형태처럼 숫자로도 취급되어 계산이 가능하다.
    = extract() 명령을 이용하면 원하는 항목만 추출할 수도 있다.
*/

-- 2019년에 제조된 상품 정보를 조회
-- 1. 2019년 1월 1일 0시 0분 0초부터 2019년 12월 31일 23시 59분 59초까지
-- 2. 연도가 2019인 경우
-- 3. 날짜가 2019로 시작하는 경우

-- 1. 
-- select * from product where made >= 2019년1월1일0시0분0초 and made <= 2019년12월31일23시59분59초;
select * from product 
where made >= to_date('20190101000000', 'YYYYMMDDHH24MISS') 
and made <= to_date('20191231235959', 'YYYYMMDDHH24MISS');

select * from product 
where made between 
to_date('20190101000000', 'YYYYMMDDHH24MISS') and to_date('20191231235959', 'YYYYMMDDHH24MISS');

-- 2.
select * from product where extract(year from made) = 2019;

-- 3.
select * from product where made like '19%';
select * from product where instr(made, '19') = 1;


/*
    과제 : 다음에서 요구하는 데이터를 조회하시오.
    1. 유통기한이 2021년인 제품을 출력
    2. 여름(6,7,8)월에 생산된 과자 목록을 출력
    3. 과자와 사탕 중에서 유통기한이 1년 이하인 제품의 목록을 출력
    4. 최근 2년간 생산된 제품의 목록을 출력(730일 전부터 지금까지)
*/

-- 1. 유통기한이 2021년인 제품을 출력
--(1)
select * from product where expire between to_date
('20210101000000' , 'YYYYMMDDHH24MISS') and to_date('20211231235959', 'YYYYMMDDHH24MISS');

--(2)
select * from product where extract(year from expire) = 2021;

-- 2. 여름(6,7,8)월에 생산된 과자 목록을 출력
--(1)
select * from product where type = '과자' and extract(month from made) >= 06 
and extract(month from made) <=08;

--(2) any ()안에 조건이 true라도 만족하면?
select * from product where type in('과자') and extract(month from made) = ANY(06,07,08);


-- 3. 과자와 사탕 중에서 유통기한이 1년 이하인 제품의 목록을 출력
--(1)
select * from product where type between '과자' and '사탕' and (expire - made) <=365;

--(2)
select * from product where type in('과자','사탕') and (expire - made) <= 365;


-- 4. 최근 2년간 생산된 제품의 목록을 출력(730일 전부터 지금까지)
--(1)
select * from product where (sysdate - made) <= 730;

--(2)
select *from product where made+730 > sysdate;

commit;
