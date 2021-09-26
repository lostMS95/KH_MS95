--현재 계정 테이블 목록
SELECT * FROM TAB;


-- 포켓몬스터 정보를 저장하기 위한 테이블을 생성
CREATE TABLE monster(
monster_no number(3),
monster_name varchar2(24),
monster_type varchar2(9)
);

-- 만든 테이블을 삭제
DROP TABLE monster;

-- 데이터를 다루는 작업은 데이터베이스를 이용하는 핵심 이유 중 하나
-- 데이터 추가(Create), 데이터 조회(Read), 데이터 수정(Update), 데이터 삭제(Delete) = CRUD
-- 만들어진 테이블에 데이터 추가
-- insert into monster(컬럼명) values(데이터);
insert into monster(monster_no, monster_name, monster_type) values(1, '이상해씨', '풀');
insert into monster(monster_no, monster_name, monster_type) values(2, '이상해풀', '풀');
insert into monster(monster_no, monster_name, monster_type) values(3, '이상해꽃', '풀');

-- 형식 순서 또는 개수를 바꿔서 넣을 수도 있다
insert into monster(monster_name, monster_no, monster_type) values('이상해씨', 1, '풀');
insert into monster(monster_name, monster_no, monster_type) values('이상해풀', 2, '풀');
insert into monster(monster_name, monster_no, monster_type) values('이상해꽃', 3, '풀');

-- 형식을 알려주지 않으면 "테이블에 작성된 컬럼 순서대로 전부 추가"하겠다는 의미
insert into monster values(1, '이상해씨', '풀');
insert into monster values(2, '이상해풀', '풀');
insert into monster values(3, '이상해꽃', '풀');

-- 데이터가 잘 들어가있는지 조회
select * from monster;

-- 잘 안보일 경우 컬럼의 표시 크기를 변경(SQL 커맨드라인 켤때마다)
column monster_no format 999;
column monster_name format a10;
column monster_type format a10;

-- 데이터베이스는 "다수의 사용자가 데이터를 관리"할 수 있도록 구성된 저장소
-- 각자의 사용자가 동시에 접근해서 데이터를 추가, 조회, 수정, 삭제할 수 있다.
-- 이 중에서 추가(C), 수정(U), 삭제(D)는 문제의 소지가 있다.
-- 이런 상황을 방지하기 위해서 DBMS에서는 "2단계 저장구조"를 가진다
-- 1차적으로 작업한 내용을 트랜잭션(Transaction)이라고 부르고, 작업을 마치면 트랜잭션을 저장/취소할 수 있다.
-- 최종 저장 : commit , 최종 취소 : rollback
commit;
rollback;

/*
	다음 요구사항에 맞는 테이블을 KH계정에 생성
	
	<메뉴(Menu) 정보>
	- 메뉴이름은 한글 10글자 이내로 작성된다.
	- 메뉴가격은 가장 비싼게 100만원이다.
	- 메뉴종류는 식사/안주/음료/디저트 중 하나가 저장된다.
*/
create table menu(
menu_name varchar2(30),
menu_price number(7),
menu_type varchar2(9)
);

insert into menu(menu_name, menu_price, menu_type)
values('아메리카노', 3000, '음료');

insert into menu(menu_name, menu_price, menu_type)
values('카페라떼', 3500, '음료');

insert into menu(menu_name, menu_price, menu_type)
values('카푸치노', 3500, '음료');

insert into menu(menu_name, menu_price, menu_type)
values('카페모카', 4000, '음료');

insert into menu(menu_name, menu_price, menu_type)
values('바닐라라떼', 4000, '음료');

insert into menu(menu_name, menu_price, menu_type)
values('헤이즐넛라떼', 4000, '음료');

commit;

select * from menu;

/*
	문제
	
	다음 요구사항에 맞게 주어진 데이터를 저장할 수 있도록 SQL 명령을 작성하세요
	
	[요구사항]
	- 테이블 이름은 EPL로 한다
	- 순위(EPL_RANK)는 1위부터 20위까지 존재한다
	- 이름(CLUB_NAME)은 한글 12글자까지 저장할 수 있다
	- 경기수(GAME_TOTAL)는 최대 36경기이다
	- 승리(GAME_VICTORY)와 무승부(GAME_DRAW), 패배(GAME_DEFEAT)는 경기수를 넘을 수 없다
	- 승점(VICTORY_POINT)은 최대 108점까지 획득할 수 있다
	- ERD 설계 및 테이블 생성 후 데이터를 추가하고 조회까지 수행하세요
	
	[데이터]
	- 순위 : 1 , 이름 : 첼시 , 경기수 : 5 , 승리 : 4 , 무승부 : 1 , 패배 : 0 , 승점 : 13
	- 순위 : 2 , 이름 : 리버풀 , 경기수 : 5 , 승리 : 4 , 무승부 : 1 , 패배 : 0 , 승점 : 13
	- 순위 : 3 , 이름 : 맨유 , 경기수 : 5 , 승리 : 4 , 무승부 : 1 , 패배 : 0 , 승점 : 13
	- 순위 : 4 , 이름 : 브라이턴 , 경기수 : 5 , 승리 : 4 , 무승부 : 0 , 패배 : 1 , 승점 : 12
	- 순위 : 5 , 이름 : 맨시티 , 경기수 : 5 , 승리 : 3 , 무승부 : 1 , 패배 : 1 , 승점 : 10
 */

-- 테이블 생성 구문
create table epl(
club_name varchar2(36),
epl_rank number(2),
game_total number(2),
game_victory number(2),
game_draw number(2),
game_defeat number(2),
victory_point number(3)
);

-- 데이터 추가 구문
insert into epl(epl_rank, club_name, game_total, game_victory, game_draw, game_defeat, victory_point)
values(1, '첼시', 5, 4, 1, 0, 13);

insert into epl(epl_rank, club_name, game_total, game_victory, game_draw, game_defeat, victory_point)
values(2, '리버풀', 5, 4, 1, 0, 13);

insert into epl(epl_rank, club_name, game_total, game_victory, game_draw, game_defeat, victory_point)
values(3, '맨유', 5, 4, 1, 0, 13);

insert into epl(epl_rank, club_name, game_total, game_victory, game_draw, game_defeat, victory_point)
values(4, '브라이턴', 5, 4, 0, 1, 12);

insert into epl(epl_rank, club_name, game_total, game_victory, game_draw, game_defeat, victory_point)
values(5, '맨시티', 5, 3, 1, 1, 10);

commit;

-- 기존에 만든 monster 테이블에 고유번호 발급기(시퀀스, Sequence)를 적용시켜 데이터를 추가
-- 기존의 데이터는 삭제하고 진행
truncate table monster;

-- monster 테이블 용 시퀀스(Sequence) 생성 
create sequence monster_seq 
-- minvalue 1 
-- maxvalue 가장큰숫자(38자리) 
-- start with 1 
-- increment by 1
-- cache 20 / nocache;

-- 시퀀스 정보확인
select * from user_sequences;

-- 시퀀스 삭제
drop sequence monster_seq;

-- 만들어진 시퀀스를 이용하여 번호를 생성해가며 데이터를 추가
-- 번호 생성 명령 : monster_seq.nextval
insert into monster(monster_no, monster_name, monster_type) 
values(monster_seq.nextval, '이상해씨', '풀');

insert into monster(monster_no, monster_name, monster_type) 
values(monster_seq.nextval, '이상해풀', '풀');

insert into monster(monster_no, monster_name, monster_type) 
values(monster_seq.nextval, '이상해꽃', '풀');

commit;

select * from monster;

/*
	멜론 음원차트를 데이터베이스 테이블로 구현

	- 테이블이름 : chart
	- 항목 : 음원고유번호, 순위, 제목, 가수이름, 앨범이름, 좋아요
	- 요구사항 : 음원고유번호는 sequence를 사용하여 부여(chart_seq)
	
	1위부터 10위까지의 정보를 저장한 뒤 출력하도록 구현
 */