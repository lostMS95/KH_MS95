/*
    테이블 조인(Table Join)
    = 조회할 때 여러 테이블들을 합쳐서 조회하는 기술
    = 목적에 따라서 여러 종류의 join이 존재한다.
    = inner join 과 outer join을 구분하는 것을 목표로 진행
*/

select * from basket;

-- aaa란 회원의 장바구니 조회
select * from basket where customer_id = 'aaa';

-- basket과 item을 join
-- 연결된 항목끼리 이어서 join (INNER JOIN, 내부 조인)

select * from basket inner join item on basket.item_no = item.item_no;

-- basket과 customer를 join
select * from basket inner join customer on basket.customer_id = customer.customer_id;

-- basket과 customer, item을 join
select * 
from basket
    inner join customer on basket.customer_id = customer.customer_id
    inner join item on basket.item_no = item.item_no;
    
select * 
from basket B
    inner join customer C on B.customer_id = C.customer_id
    inner join item I on B.item_no = I.item_no;

-- follow와 client를 join (follow + client + client)
select * from follow;

select *
from follow
    inner join client on follow.who = client.client_id
    inner join client on follow.target = client.client_id;

-- 반복되는 테이블 이름 대신 별칭을 부여
select *
from follow F
    inner join client WHO on F.who = WHO.client_id
    inner join client TARGET on F.target = TARGET.client_id;
    
-- 와일드카드(*) 사용을 피하고 가급적 항목을 지정하고 별칭을 부여하여 조회
select * from follow;
select 
--    WHO.client_id "팔로워ID",
    WHO.client_nickname "팔로워닉네임",
--    TARGET.client_id "팔로위ID",
    TARGET.client_nickname "팔로위닉네임"
from follow F
    inner join client WHO on F.who = WHO.client_id
    inner join client TARGET on F.target = TARGET.client_id;
-- where 조건
-- group 조건
-- order by 정렬조건;

/*
    INNER JOIN은 테이블 사이의 연결된 데이터를 기준으로 해서 합치는 형태의 JOIN을 말한다.
        = 연결되지 않은 데이터는 JOIN의 결과에 포함되지 않는다(싱글은 안나온다)
        = customer + basket = customer inner join basket on 조건
    OUTER JOIN은 특정 테이블을 기준으로 해서 다른 테이블을 합치는 형태의 JOIN을 말한다.
        = "기준" 데이터는 모두 조회가 가능하다.
        = "기준"이 있으므로 조인에 방향이 생긴다
        = customer ← basket = customer left outer join basket on 조건
        = customer → basket = customer right outer join basket on 조건
        = customer ↔ basket = customer full outer join basket on 조건(자주 나오는 상황이 아님)
        = 연결된 데이터가 없어도 조회하고 싶을 때 사용
        = ex : 회원별 구매건수(그룹 쪽에서 많이 사용)
*/
insert into customer values('ccc', 'ccc', '테스트3', 2200);
commit;

select * from customer;
select * from item;
select * from basket;

-- 손님(customer)을 기준으로 장바구니(basket) 정보를 조회
select * from customer C left outer join basket B on C.customer_id = B.customer_id;
-- 참고용 inner join
select * from customer C inner join basket B on C.customer_id = B.customer_id;

-- ex : 내부조인과 외부조인을 사용하여 각각 손님별 장바구니 상품개수를 출력
-- select 손님정보, 장바구니상품개수 from 대상테이블;

-- 내부조인
select C.customer_nick, B.basket_code
from customer C inner join basket B on C.customer_id = B.customer_id;

select C.customer_nick, count(B.basket_code) "장바구니상품수"
from customer C inner join basket B on C.customer_id = B.customer_id
group by C.customer_nick;

-- 외부조인
select C.customer_nick, B.basket_code
from customer C left outer join basket B on C.customer_id = B.customer_id;

select C.customer_nick, count(B.basket_code) "장바구니상품수"
from customer C left outer join basket B on C.customer_id = B.customer_id
group by C.customer_nick;