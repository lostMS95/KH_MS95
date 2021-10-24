/*
    Group Query
    - 그룹별로 데이터를 조회할 필요가 있을 경우 사용
    - ex : Product 테이블에서 상품분류별 개수/합계/평균/최대/최소 와 같은 작업을 할 때 사용
    - ex : 월별, 일별, 연도별, ...
    - 집계 함수들을 이용하여 그룹별로 구분하여 정보를 획득하는 것이 목표
    - 어떤 조건으로 그룹을 지을 것인지 명시해야 한다.
    
    - 형식 : group by 항목 [having 항목조건]
*/

select * from product;

select distinct type from product;--타입을 중복제거해서 출력(추가계산이 불가능)
select type from product group by type;--타입별로 묶어서 타입명을 출력(추가계산이 가능)

select type, count(*) from product group by type;--타입별 개수
select type, sum(price) from product group by type;--타입별 합계

select type, count(*) from product group by type order by count(*) desc;--타입별 개수를 많은 순서로 정렬
select type, count(*) "개수" from product group by type order by "개수" desc;--타입별 개수를 많은 순서로 정렬

select type, sum(price) from product group by type order by sum(price) desc;--타입별 합계를 큰순서부터 정렬
select type, sum(price) "합계" from product group by type order by "합계" desc;--타입별 합계를 큰순서부터 정렬

select type, max(made) from product group by type;
select type, max(made) "제조일자" from product group by type order by "제조일자" desc;

/*
    구글 스프레드시트를 참고하여 테이블을 구성하고 그룹 쿼리를 작성하여 실행하세요.
    https://docs.google.com/spreadsheets/d/1VFopsxOPNjKTsMKtXvV8zQwrrCdULCFz9uMUe4GPm9M/edit?usp=sharing

    1. 학생별 평균점수를 구하여 출력				
    2. 과목별 평균점수를 구하여 출력				
    3. 평가유형별 평균점수를 구하여 출력				
    4. 학생별 최고, 최저점을 구하여 출력				
    5. 과목별 최고, 최저점을 구하여 출력				
    6. 유형별 최고, 최저점을 구하여 출력				
    7. 과목별 60점 미만 학생의 수를 구하여 출력				
    8. 과목별 90점 이상 학생의 수를 구하여 출력				
    9. 평균이 높은 학생을 3등까지만 출력				
*/

-- 테이블 생성
create table exam(
exam_id number primary key,
student varchar(21) not null,
subject varchar2(60) not null,
type varchar2(60) not null,
score number(3) not null check(score between 1 and 100)
);
create sequence exam_seq;

-- 데이터 추가
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '프로그래밍언어활용', '서술형', 55);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '프로그래밍언어활용', '문제해결시나리오', 95);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '네트워크프로그래밍구현', '서술형', 60);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '네트워크프로그래밍구현', '평가자체크리스트', 51);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '프로그래밍언어활용', '서술형', 80);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '프로그래밍언어활용', '문제해결시나리오', 52);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '네트워크프로그래밍구현', '서술형', 58);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '네트워크프로그래밍구현', '평가자체크리스트', 80);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '프로그래밍언어활용', '서술형', 54);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '프로그래밍언어활용', '문제해결시나리오', 81);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '네트워크프로그래밍구현', '서술형', 44);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '네트워크프로그래밍구현', '평가자체크리스트', 76);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '프로그래밍언어활용', '서술형', 100);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '프로그래밍언어활용', '문제해결시나리오', 60);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '네트워크프로그래밍구현', '서술형', 51);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '네트워크프로그래밍구현', '평가자체크리스트', 72);
commit;

select * from exam;

--1. 학생별 평균점수를 구하여 출력				
select student "학생", avg(score) "평균" from exam group by student;
select student "학생", avg(score) "평균" from exam group by student order by "평균" desc;

--2. 과목별 평균점수를 구하여 출력				
select subject "과목", avg(score) "평균" from exam group by subject;
select subject "과목", avg(score) "평균" from exam group by subject order by "평균" desc;

--3. 평가유형별 평균점수를 구하여 출력				
select type "유형", avg(score) "평균" from exam group by type;
select type "유형", avg(score) "평균" from exam group by type order by "평균" desc;

-- 추가 : 과목, 유형별 평균 출력
select subject "과목", type "유형", avg(score) "평균" from exam group by subject, type;
select subject "과목", type "유형", avg(score) "평균" from exam group by subject, type order by "평균" desc;
select subject "과목", type "유형", avg(score) "평균" from exam group by subject, type order by "과목" asc, "유형" asc;

--4. 학생별 최고, 최저점을 구하여 출력	
select student "이름", max(score) "최고점", min(score) "최저점", max(score) - min(score) "차이" from exam group by student;
select student "이름", max(score) "최고점", min(score) "최저점", max(score) - min(score) "차이" from exam group by student order by "차이" desc;

--5. 과목별 최고, 최저점을 구하여 출력	
select subject "과목", max(score) "최고점", min(score) "최저점", max(score) - min(score) "차이" from exam group by subject;
select subject "과목", max(score) "최고점", min(score) "최저점", max(score) - min(score) "차이" from exam group by subject order by "차이" desc;

--6. 유형별 최고, 최저점을 구하여 출력	
select type "유형", max(score) "최고점", min(score) "최저점", max(score) - min(score) "차이" from exam group by type;
select type "유형", max(score) "최고점", min(score) "최저점", max(score) - min(score) "차이" from exam group by type order by "차이" desc;

--7. 과목별 60점 미만 학생의 수를 구하여 출력		
select subject "과목", count(*) "인원수" from exam group by subject;--과목별 응시 인원수
select subject "과목", count(*) "인원수" from exam where score < 60 group by subject;--과목별 60점 미만 인원수

--8. 과목별 90점 이상 학생의 수를 구하여 출력				
select subject "과목", count(*) "인원수" from exam group by subject;--과목별 응시 인원수
select subject "과목", count(*) "인원수" from exam where score >= 90 group by subject;--과목별 90점 이상 인원수

-- 9. 평균이 높은 학생을 3등까지만 출력		
select * from (
    select rownum "순위", TMP.* from (
        select student "학생", avg(score) "평균" from exam group by student order by "평균" desc
    )TMP
) where "순위" between 1 and 3;

-- 추가 : 점수대별(10점단위) 학생 분포 현황
select floor(score / 10), count(*) from exam group by floor(score / 10);
select trunc(score / 10), count(*) from exam group by trunc(score / 10);

select trunc(score / 10) "점수구간", count(*) "인원수" from exam group by trunc(score / 10);
select trunc(score / 10) || '0' "점수구간", count(*) "인원수" from exam group by trunc(score / 10);
select trunc(score / 10) || '0' "점수구간", count(*) "인원수" from exam group by trunc(score / 10) order by "인원수" desc;
select trunc(score / 10) || '0' "점수구간", count(*) "인원수" from exam group by trunc(score / 10) order by "점수구간" asc;
select to_number(trunc(score / 10) || '0') "점수구간", count(*) "인원수" from exam group by trunc(score / 10) order by "점수구간" asc;

-- 그룹 조건
-- 1. 전체 평균이 70점 미만인 학생만 조회
select student, avg(score) from exam group by student;
-- select student, avg(score) from exam where score < 70 group by student;--말이 안되는 코드(데이터 필터링)
select student, avg(score) from exam group by student having avg(score) < 70;--정상 코드(그룹 필터링)
select student, avg(score) from exam group by student having avg(score) < 70 order by avg(score) asc;
select student "이름", avg(score) "평균" from exam group by student having avg(score) < 70 order by "평균" asc;