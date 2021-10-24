/*
    데이터 수정(Update)
    
    형식 : update 테이블이름 set 항목변경내용 [where 필터식]
*/

-- 스크류바의 가격을 1300원으로 변경
update product set price = 1300;--전체
update product set price = 1300 where name = '스크류바';
commit;
select * from product;

-- 스크류바의 가격을 100원 인상
-- update product set price += 100 where name = '스크류바';-- 안됨
-- update product set price =+ 100 where name = '스크류바';-- 됨(+100원으로 덮어쓰기)
update product set price = price  + 100 where name = '스크류바';

-- 7번 상품의 정보를 다음과 같이 변경
-- 이름 : 테라 , 분류 : 주류 , 가격 : 2200원
update product set name = '테라', type = '주류' , price = 2200 where no = 7;
select * from product;
rollback;

-- 멘토스의 가격을 10% 인상
update product set price = price * 1.1 where name = '멘토스';
update product set price = floor(price * 1.1) where name = '멘토스';
update product set price = floor(price * (100 + 10) / 100) where name = '멘토스';
select * from product;
rollback;

-- 오레오의 가격을 500원 할인
update product set price = price - 500 where name = '오레오';
select * from product;
rollback;

/*
    데이터 삭제(Delete)
    
    형식 : delete 테이블이름 [where 필터식]
    
    (주의) 삭제는 대부분 P.K 를 이용하여 진행된다.
*/

-- 전체 삭제
delete product;
select * from product;
rollback;

-- 아이스크림 삭제
delete product where type = '아이스크림';

-- 제일 비싼 상품 삭제
delete product where price = (select max(price) from product);