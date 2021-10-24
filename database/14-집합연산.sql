/*
    집합연산
    = 서로 다른 집합 사이의 합집합, 교집합, 차집합 등을 구하는 과정
    = 연산을 위해서는 2개의 서로 다른 결과집합이 필요
    = 두 집합의 컬럼이 같아야 한다
    
    - UNION ALL : 중복을 따지지 않고 합집합 처리
    - UNION : 중복을 제거하고 합집합 처리
    - INTERSECT : 교집합 처리
    - MINUS : 차집합 처리
*/

-- 차이를 만들기 위한 추가 구문
insert into exam values(exam_seq.nextval, '피카츄', 'SQL활용', '사례연구', 75);
insert into exam values(exam_seq.nextval, '파이리', '데이터입출력구현', '포트폴리오', 88);
commit;

select subject from exam where student = '피카츄';--첫 번째 집합(피카츄가 응시한 과목)
select subject from exam where student = '파이리';--두 번째 집합(파이리가 응시한 과목)

-- 합집합(UNION ALL / UNION) : 파이리랑 피카츄가 응시한 모든 과목
select subject from exam where student = '피카츄'
union all
select subject from exam where student = '파이리';

select subject from exam where student = '피카츄'
union
select subject from exam where student = '파이리';

-- 교집합(INTERSECT) : 파이리와 피카츄가 둘 다 응시한 과목
select subject from exam where student = '피카츄'
intersect
select subject from exam where student = '파이리';

-- 차집합(MINUS) : 피카츄만 응시한 과목
select subject from exam where student = '피카츄'
minus
select subject from exam where student = '파이리';

select subject from exam 
where student = '피카츄' and subject not in(select subject from exam where student = '파이리');