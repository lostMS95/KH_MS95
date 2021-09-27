/*
    날짜 데이터 다루기
    - date : 일반적인 시각
    - timestamp : 정밀한 시각
    
    to_date() 시간형식
    - YYYY : 연도 4작리
    - MM : 월2자리
    - DD : 일 2자리
    - HH24 : 24시간방식 시간 2자리
    - MI : 분2자리 
    - SS : 초 2자리
*/

create table schedule(
schedule_no number,
schedule_name varchar2(300),
schedule_time date
);
create sequence schedule_seq;

-- 1. 시간은 문자열 형태로도 추가 할 수 있다.
-- 문제점 : 시간 표시 형식이 다른 운영체제 또는 데이터베이스에서는 오류가 발생
insert into schedule values (schedule_seq.nextval, '자바스터디', '2021-09-28');

-- 2. to_date() 라는 명령을 이용하여 문자열을 원하는 시간 형식으로 변환할 수 있다.
-- 사용법 : to_date('시간데이터', '시간형식')
insert into schedule values(schedule_seq.nextval, '딸내미100일', to_date('2021-10-03', 'YYYY-MM-DD'));

insert into schedule values(schedule_seq.nextval, '딸내미100일점심식사', to_date('2021-10-03 13:10:00', 'YYYY-MM-DD HH24:MI:SS'));

insert into schedule values(schedule_seq.nextval, '딸내미100일점심식사', to_date('2021년 10월 03일 13시 10분', 'YYYY년 MM월 DD일 HH24시 MI분 SS초'));
-- 날짜에만 있는 특수한 데이터
-- sysdate : 현재시각을 date 형태로 보관하는 내장객체
-- systimestamp : 현재시각을 timestamp 형태로 보관하는 내장객체
insert into schedule values(schedule_seq.nextval, '열심히공부하기' , sysdate);
commit;
select * from schedule;

/*
    문제 : 다음 요구사항에 맞게 테이블을 구현하고 데이터를 저장하세요.
    
    <요구사항>
    - 호텔 예약현황을 저장하고 싶다(hotel_reservation)
    - 저장할 항목 : 예약번호, 예약일자, 예약자이름, 예약숙소명, 입실예정일자, 퇴실예정일자
        - 예약번호(hotel_reservation_code)는 시퀀스로 자동부여되도록 설정하며 필수, 중복 불가
        - 예약일자(hotel_reservation_time)은 예약 데이터가 등록된 시점의 시간 정보로 추가
        - 예약자 이름(hotel_reservation_client)은 일반적인 이름 규약에 맞게 한글 기준으로 작성
        - 예약숙소명(hotel_name)은 한글 20자 이내로 작성
        - 입실예정일자(check_in_time)는 날짜 형태이며, 지정하지 않을 경우에는 현재시각으로 설정
        - 퇴실예정일자(check_out_time)는 반드시 지정되어야 한다
    
    <데이터>
    [예약번호 : 1] 홍길동 - 신라호텔 (2021-10-01 ~ 2021-10-05)
    [예약번호 : 2] 이몽룡 - 그랜드하얏트 ( ~ 2021-10-01)
    [예약번호 : 3] 이소룡 - 호텔캘리포니아 (2021-10-05 ~ 2021-10-06)
    [예약번호 : 4] 장보고 - 시그니엘 ( ~ 2021-10-10)
    [예약번호 : 5] 임꺽정 - 매리어트 (2021-10-20 ~ 2021-10-22)
*/

create table hotel_reservation(
hotel_reservation_code number not null unique,
hotel_reservation_time date default sysdate not null,
hotel_reservation_client varchar2(21) not null,
hotel_name varchar2(60) not null,
check_in_time date default sysdate not null,
check_out_time date not null
);

create sequence hotel_reservation_seq;

insert into hotel_reservation(hotel_reservation_code,hotel_reservation_client, hotel_name, check_in_time , check_out_time)
values(hotel_reservation_seq.nextval, '홍길동', '신라호텔', 
to_date('2021-10-01' , ' YYYY-MM-DD'), to_date('2021-10-05', 'YYYY-MM-DD'));

insert into hotel_reservation(hotel_reservation_code, hotel_reservation_client, hotel_name, check_out_time)
values(hotel_reservation_seq.nextval, '이몽룡', '그랜드하얏트', 
to_date('2021-10-01', 'YYYY-MM-DD'));

insert into hotel_reservation(hotel_reservation_code, hotel_reservation_client, hotel_name, check_in_time , check_out_time)
values(hotel_reservation_seq.nextval, '이소룡', '호탤캘리포니아', 
to_date('2021-10-05' , ' YYYY-MM-DD'), to_date('2021-10-06', 'YYYY-MM-DD'));

insert into hotel_reservation(hotel_reservation_code, hotel_reservation_client, hotel_name, check_out_time)
values(hotel_reservation_seq.nextval, '장보고', '시그니엘',
to_date('2021-10-10', 'YYYY-MM-DD'));


insert into hotel_reservation(hotel_reservation_code, hotel_reservation_client, hotel_name, check_in_time , check_out_time)
values(hotel_reservation_seq.nextval, '임꺽정', '매리어트', 
to_date('2021-10-20' , ' YYYY-MM-DD'), to_date('2021-10-22', 'YYYY-MM-DD'));

select * from hotel_reservation;

commit;

