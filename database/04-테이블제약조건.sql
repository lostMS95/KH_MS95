/*
    테이블 제약조건
    - 테이블에 데이터 추가와 관련된 제약을 설정하는 것을 말한다
    - 원치 않는 데이터를 차단하여 데이터의 신뢰도를 높인다

    1. NOT NULL 제약조건
    2. UNIQUE 제약조건
    3. CHECK 제약조건
    4. DEFAULT 제약조건
    5. PRIMARY KEY 제약조건
    6. FOREIGN KYE 제약조건
*/

-- 예시 : 직원 급여 테이블
CREATE TABLE emp(
emp_no number,
emp_name varchar2(21),
emp_dept varchar2(42),
emp_salary number
);
create sequence emp_seq;

--예시 : 쓰레기같은 데이터 추가
insert into emp(emp_no, emp_name, emp_dept, emp_salary) values (null, null, null, null);

insert into emp(emp_no , emp_name, emp_dept,emp_salary) values (1,'피카츄','개발',10000);
insert into emp(emp_no , emp_name, emp_dept,emp_salary) values (2,'라이츄','알아서뭐하게',10000);
insert into emp(emp_no , emp_name, emp_dept,emp_salary) values (3,'파이리','영업',5000000);

rollback;
select * from emp;

-- 테이블을 삭제하고 제약조건을 추가하여 재생성
-- emp_no는 null 불가 중복불가
-- emp_name은 null 불가
-- emp_dept는 기본값 '인사'부서이고, '인사', '개발', '영업' 중 하나만 가능
-- emp_salary는 기본값 0이고, 0이상인 경우만 가능
DROP TABLE emp;
CREATE TABLE emp(
emp_no number not null unique,
emp_name varchar2(21) not null,
emp_dept varchar2(42) default '인사' check(emp_dept in ('인사','개발','영업')),
emp_salary number default 0 check(emp_salary >= 0)
);

select * from emp;

-- 기본값이 부여되는지를 확인하기 위한 구문을 작성
-- 1. null로 설정한다고 하는 경우 기본값이 적용되지 않는다(사용자의 의지를 존중)
insert into emp values (5,'꼬부기', null, null);
-- 2. 추가하는 항목에서 제외할 경우 기본값이 적용된다.
insert into emp (emp_no, emp_name) values(6,'어니부기');

commit;

/*
    [문제]
    
    다음 요구사항에 맞는 테이블을 구현하고 데이터를 추가해보세요
    
    <요구사항>
    - 상품(Product) 정보를 보관할 수 있는 테이블을 구현
    - 보관할 항목 : 상품번호, 상품이름, 상품분류, 판매가, 재고수량
    - 상품번호(product_code)는 시퀀스를 이용하여 부여되는 고유번호
    - 상품이름(product_name)은 한글 20자 이내로 등록되며 필수항목
    - 상품분류(product_type)는 다음 중에서만 허용하며 필수항목
        - 생활용품, 가전제품, 식료품, 애견용품
    - 판매가(product_price)는 0 이상으로 설정 가능하며 설정하지 않으면 0원으로 자동설정
    - 재고수량(product_stock)은 판매가와 동일하게 처리

    <데이터>
    - 1번 상품 : 고무장갑(생활용품), 판매가 2500원. 재고 30개
    - 2번 상품 : 푸라면(식료품), 판매가 1300원. 재고 100개
    - 3번 상품 : 드럼세탁기(가전제품), 판매가 500000원, 재고 3개
    - 4번 상품 : 개껌(애견용품), 판매가 500원. 재고 250개
*/

CREATE TABLE product(
product_code number not null unique,
product_name varchar2(60) not null,
product_type varchar2(12) not null check(product_type in('생활용품','가전제품','식료품','애견용품')),
product_price number default 0 check(product_price >=0),
product_stock number default 0 check(product_stock >=0)
);

create sequence product_seq;

insert into product values(product_seq.nextval , '고무장갑', '생활용품', 2500, 30);
insert into product values(product_seq.nextval , '푸라면', '식료품', 1300, 100);
insert into product values(product_seq.nextval , '드럼세탁기', '가전제품', 500000, 3);
insert into product values(product_seq.nextval , '개껌', '애견용품', 500, 250);

select * from product;

commit;