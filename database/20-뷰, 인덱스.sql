/*
    오라클에서 제공하는 유용한 객체들
    
    1. view
    2. index
*/

select * from exam;

-- 프로그래밍 언어 활용이라는 과목에 대한 결과
select * from exam where subject = '프로그래밍언어활용';
select * from exam where subject = '프로그래밍언어활용' and student = '피카츄';
select * from exam where subject = '프로그래밍언어활용' and type = '서술형';

-- 네트워크 프로그래밍 구현이라는 과목에 대한 결과
select * from exam where subject = '네트워크프로그래밍구현';
select * from exam where subject = '네트워크프로그래밍구현' and student = '피카츄';
select * from exam where subject = '네트워크프로그래밍구현' and type = '서술형';

-- 같이도 사용하지만, 나눠쓰는경우가 많다면 테이블을 분할할 수 없으니 가상의 테이블로 분리
-- create [or replace] view 이름 as 조회구문;
-- (주의) 사용자가 create view라는 권한을 가지고 있어야 만들 수 있다(resource에 포함되어있지 않음)
create view programming_exam as select * from exam where subject = '프로그래밍언어활용';

-- 권한 부여하는 코드(관리자)
grant create view to kh;

-- 만들어진 뷰는 테이블처럼 조회가 가능
select * from programming_exam;
select * from programming_exam where student = '피카츄';
select * from programming_exam where type = '서술형';

-- network_exam 이라는 이름을 '네트워크프로그래밍구현' 과목에 대해 조회할 수 있는 뷰 생성
create or replace view network_exam as select * from exam where subject = '네트워크프로그래밍구현';
select * from network_exam;
select student, count(*) from network_exam group by student;

-- basket_information 이라는 이름으로 장바구니 + 회원 + 아이템 정보를 합쳐서 조회할 수 있도록 뷰 생성
-- (주의) view는 결과집합에 중복된 컬럼명이 있으면 생성이 안된다.
create or replace view basket_information as
select
    C.*, I.*, B.item_quantity, B.add_time
    from basket B 
        inner join customer C on B.customer_id = C.customer_id
        inner join item I on B.item_no = I.item_no;
        
select * from basket_information;
select * from basket_information where customer_id = 'aaa';

/*
    INDEX(인덱스, 색인)
    = 데이터베이스 테이블의 컬럼에 설치하는 도구
    = 검색속도 향상
    = 유니크(Unique) 또는 기본키(Primary key)에는 인덱스가 자동 생성된다.
    
    1. 일반 인덱스 : create index 이름 on 테이블(컬럼)
    2. 유니크 인덱스 : create unique index 이름 on 테이블(컬럼)
*/

select * from product;

create index name_index on product(name);
create unique index no_index on product(no);

drop index name_index;

--index의 불균형을 재조정하는 명령
alter index name_index rebuild;

select * from user_indexes;
select table_name, index_name, blevel from user_indexes order by blevel desc;

delete product;
commit;