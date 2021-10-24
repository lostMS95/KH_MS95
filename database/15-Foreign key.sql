/*
    외래키(Foreign Key)와 테이블 분할 및 연결
*/

-- (ex) 장바구니 구현
-- 장바구니란 회원이 상품을 보관하는 것
-- 개체(Entity) : 회원(customer), 상품(item)
-- 관계(Relation) : 보관한다

create table customer(
customer_id varchar2(20) primary key,
customer_pw varchar2(16) not null,
customer_nick varchar2(30) not null unique,
customer_point number
);
create table item(
item_no number primary key,
item_name varchar2(60) not null,
item_price number
);

insert into customer values('aaa', 'aaa', '테스트1', 500);
insert into customer values('bbb', 'bbb', '테스트2', 2000);
insert into item values(1, '헤드셋', 50000);
insert into item values(2, '노트북', 2000000);
commit;

-- 외래키를 설정하지 않고 장바구니를 생성
-- 문제점 : 존재하지 않는 회원이나 존재하지 않는 상품도 등록이 가능하다
-- 해결책 : 추가 시 대상 테이블에 존재하는지 확인하고 추가하도록 설정(외래키 설정)
create table basket(
basket_code number primary key,
customer_id varchar2(20) not null,
item_no number not null,
item_quantity number,
add_time date
);
create sequence basket_seq;

-- 외래키를 설정하여 테이블을 재생성
-- 생성법 : 컬럼명 우측에 references 테이블명(항목명) [옵션] 형태로 작성
drop table basket;
create table basket(
basket_code number primary key,
customer_id references customer(customer_id),
item_no references item(item_no),
item_quantity number,
add_time date
);

insert into basket values(basket_seq.nextval, 'aaa', 1, 1, sysdate);
insert into basket values(basket_seq.nextval, 'aaa', 2, 1, sysdate);
insert into basket values(basket_seq.nextval, 'bbb', 1, 1, sysdate);
insert into basket values(basket_seq.nextval, 'ddd', 5, 2, sysdate);--존재하지 않는 회원과 상품
commit;

select * from basket;

-- 찜(Wishlist) 테이블
-- 한명의 손님이 하나의 상품을 한번만 좋아요 할 수 있다.
-- 손님이 탈퇴하면 찜내역은 사라져야 한다(on delete cascade).
-- 상품이 삭제되면 찜내역은 사라져야 한다(on delete cascade).
drop table wishlist;
create table wishlist(
customer_id references customer(customer_id) on delete cascade,
item_no references item(item_no) on delete cascade,
primary key(customer_id, item_no)
);

insert into wishlist values('aaa', 1);--모두 존재해서 됨
insert into wishlist values('aaa', 5);--5번 상품이 없어서 안됨
insert into wishlist values('abc', 1);--abc 회원이 없어서 안됨

-- 결제(Payment) 테이블
-- 한명의 손님이 하나의 상품을 여러 번 결제할 수 있다. 복합키 사용 불가. 따라서 기본키 추가 생성
-- 손님이 탈퇴한다고 해서 결제내역까지 사라지는것은 안된다(on delete set null)
-- 상품이 삭제된다고 해서 결제내역까지 사라지는것은 안된다(on delete set null)
-- (주의) not null 항목에는 적용이 불가
drop table payment;
create table payment(
payment_code number primary key,
customer references customer(customer_id) on delete set null,
item references item(item_no) on delete set null,
payment_type char(6) not null check(payment_type in ('카드', '현금')),
payment_amount number not null check(payment_amount >= 0),
payment_time date default sysdate not null
);

-- 외래키는 추가도 문제지만 삭제도 고려해야 한다.
-- (ex) 회원이 탈퇴하면 장바구니는 어떻게? 찜내역은? 구매내역은?
--      외래키에 옵션을 지정하여 해결해야 한다
--      옵션 미지정 : 연결된 자식 항목(child record)이 있을 경우 부모 키는 삭제가 불가
--      on delete cascade : 부모 키를 삭제하면 연결된 자식 항목은 자동 삭제(ex : 탈퇴한 회원의 찜내역)
--      on delete set null : 부모 키를 삭제하면 연결된 자식 항목이 null로 변경(ex : 탈퇴한 회원의 게시글)

-- (ex) SNS Follow System 구현
-- Follow란 회원이 다른 회원을 관심회원으로 설정
-- 개체(Entity) : 회원(client) - 아이디, 비밀번호, 닉네임
-- 관계(Relation) : 팔로우 - 누가 누구를 팔로우했는지에 대한 정보

create table client(
client_id varchar2(20) primary key,
client_pw varchar2(16) not null,
client_nickname varchar2(30) not null unique
);

drop table follow;
create table follow(
who references client(client_id) not null,
target references client(client_id) not null,
primary key(who, target)
);

create table follow(
who references client(client_id) on delete cascade not null,
target references client(client_id) on delete cascade not null,
primary key(who, target)
);

-- 동일 유저 follow 방지조건
-- 테이블 생성시에는 다른 컬럼 참조 불가하므로 생성 후에 별도로 제약조건을 추가
-- 제약조건명 : same_user , 제약조건 : check(who != target)
alter table follow drop constraint same_user_block;
alter table follow add constraint same_user_block check(who != target);

insert into client values('aaa', 'aaa', '테스트유저1');
insert into client values('bbb', 'bbb', '테스트유저2');
insert into client values('ccc', 'ccc', '테스트유저3');

/*
aaa → ccc
ccc → aaa
bbb → aaa
bbb → ccc
*/
insert into follow values('aaa', 'ccc');
insert into follow values('ccc', 'aaa');
insert into follow values('bbb', 'aaa');
insert into follow values('bbb', 'ccc');
insert into follow values('ccc', 'ccc');--same_user_block 조건에 의해서 차단

commit;

select * from client;
select * from follow;

delete client where client_id='aaa';