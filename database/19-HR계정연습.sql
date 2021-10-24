/*
    HR 계정 조회 실습
    
    1. 모든 대륙(REGIONS)에 있는 국가(COUNTRIES) 정보를 같이 조회하여 출력
    2. 국가(COUNTRIES)에 존재하는 지역(LOCATIONS) 정보를 같이 조회하여 출력
    3. 모든 지역(LOCATIONS)에 존재하는 부서(DEPARTMENT) 정보를 같이 조회하여 출력
*/

-- 1.
select 
    R.region_id,
    R.region_name,
    C.country_id,
    C.country_name
from regions R
    inner join countries C on R.region_id = C.region_id;
    
select 
    R.*,
    C.country_id,
    C.country_name
from regions R
    inner join countries C on R.region_id = C.region_id;
    
-- 2.
select
    C.*,
    L.city
from countries C
    inner join locations L on L.country_id = C.country_id;
    
-- 3.
select
    L.city,
    D.department_name
from locations L
    inner join departments D on D.location_id = L.location_id;
    
/*
	다음 제시된 상황에 맞게 INNER JOIN과 OUTER JOIN을 사용하여 결과를 출력해보세요
	
	1. 나라(Countries)별로 존재하는 관리지역(Locations)의 개수를 구하여 출력하세요.
	2. 지역(Locations)별로 근무하는 작업자(Employees) 수를 구하여 출력하세요.
	3. 2001년부터 2005년 사이에 고용된 작업자(Employees) 명단을 출력하세요.
	4. 부서(Departments)별 작업자(Employees) 의 연봉 최고액, 최저액, 평균을 출력하세요.
	5. 모든 작업자(Employees)의 이름, 급여, 직책명, 소속부서명을 출력하세요.
	6. 작업자(Employees) 중에서 가장 임금이 높은 인원을 1위부터 5위까지 출력하세요.
	7. 대륙(Regions)별 부서(Department) 개수를 구하여 출력하세요.
	8. 대륙(Regions)별 작업자(Employees) 수를 구하여 출력하세요.
	9. 가장 오래 근무한 작업자(Employees) 3명을 부서명과 함께 출력하세요.
	10. 직종(Jobs)별 작업자(Employees)의 최소, 최대, 평균 임금을 출력하세요.
	11. 작업자(Employees) 중에서 휴대폰 번호가 650으로 시작하는 인원의 정보를 출력하세요.
	12. 작업자(Employees) 중에서 관리직원(manager_id)이 없는 인원의 목록을 출력하세요.
		= 인터넷에서 데이터가 없는 경우에 대한 조건 설정을 검색하세요
	13. 작업자(Employees)가 가장 많은 부서(Departments) 3개를 인원수 순서대로 출력하세요.
	14. 근무 이력(Job_History)에 저장된 데이터 중 가장 오랜 기간 근무한 작업자(Employees) 의 이름을 출력하세요.
	15. 근무 이력(Job_History)에 저장된 데이터 중 가장 오랜 기간 근무한 작업자(Employees)  Top 3 정보를 출력하세요.
	16. 직종(Jobs)별 작업자(Employees) 수를 구하여 출력하세요. 
	17. 가장 오래 일한 작업자(Employees) 10명의 정보를 출력하세요.(9번과 동일..pass)
	18. 나라(Countries)별 작업자(Employees) 수를 구하여 출력하세요.
 */
    
-- 1. 나라(Countries)별로 존재하는 관리지역(Locations)의 개수를 구하여 출력하세요.
select * from countries C inner join locations L on C.country_id = L.country_id;

select C.country_name, count(*) 
from countries C inner join locations L on C.country_id = L.country_id
group by C.country_name;

select * from countries C left outer join locations L on C.country_id = L.country_id;
select C.country_name, L.location_id from countries C left outer join locations L on C.country_id = L.country_id;

select C.country_name, count(*) 
from countries C left outer join locations L on C.country_id = L.country_id
group by C.country_name;

select C.country_name, count(L.location_id) 
from countries C inner join locations L on C.country_id = L.country_id
group by C.country_name;

-- 최종 결론 : 지역이 없는 국가 정보를 보여주기 위해 국가를 기준으로 OUTER JOIN 수행
select C.country_name, count(L.location_id) 
from countries C left outer join locations L on C.country_id = L.country_id
group by C.country_name;

-- 2. 지역(Locations)별로 근무하는 작업자(Employees) 수를 구하여 출력하세요.
-- 최대 이슈 : 작업자가 없는 지역을 보여주면 OUTER JOIN , 안보여주면 INNER JOIN

select L.location_id, D.department_id, E.employee_id from 
    locations L 
        inner join departments D on L.location_id = D.location_id
        inner join employees E on D.department_id = E.department_id;
        
select L.location_id, D.department_id, E.employee_id from 
    locations L 
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.department_id;
        
select L.location_id "지역", count(E.employee_id) "인원수" from 
    locations L 
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.department_id
    group by L.location_id
    order by "인원수" desc;
    
-- 최종 결과
select L.city "지역", count(E.employee_id) "인원수" from 
    locations L 
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.department_id
    group by L.city
    order by "인원수" desc;

-- 3. 2001년부터 2005년 사이에 입사한 작업자(Employees) 명단을 출력하세요.
select employee_id, hire_date from employees;

select employee_id, hire_date from employees 
    where extract(year from hire_date) between 2001 and 2005;

select employee_id, hire_date from employees 
    where extract(year from hire_date) >= 2001 and extract(year from hire_date) <= 2005;

select employee_id, hire_date from employees 
    where hire_date >= to_date('20010101000000', 'YYYYMMDDHH24MISS') 
        and hire_date <= to_date('20051231235959', 'YYYYMMDDHH24MISS');

select employee_id, hire_date from employees 
    where to_char(hire_date, 'YYYY') in ('2001', '2002', '2003', '2004', '2005');

select employee_id, hire_date from employees 
    where regexp_like(to_char(hire_date, 'YYYY'), '200[1-5]');
    
-- 최종 결론
select E.first_name, E.last_name, E.hire_date from employees E
    where extract(year from hire_date) between 2001 and 2005
    order by hire_date asc;
    
-- 추가 : 작업자의 부서명까지 출력(Departments 와 조인. 부서가 없는 작업자가 있다면 OUTER_JOIN)
select E.first_name, E.last_name, E.hire_date, D.department_name 
    from employees E
        left outer join departments D on E.department_id = D.department_id
    where extract(year from hire_date) between 2001 and 2005
    order by hire_date asc;

-- 4. 부서(Departments)별 작업자(Employees) 의 연봉 최고액, 최저액, 평균을 출력하세요.
-- 작업자가 없는 부서가 있다면 부서를 기준으로 OUTER JOIN 수행, 아니면 INNER JOIN
-- (주의) 부서에 작업자가 있든 없든 수행되어야 하므로 부서 기준 OUTER JOIN 수행
select D.department_id, max(E.salary), min(E.salary), avg(E.salary)
    from departments D
        left outer join employees E on D.department_id = E.department_id
    group by D.department_id;
    
select 
        D.department_id "부서명", 
        nvl(max(E.salary), 0) "최대급여", 
        nvl(min(E.salary), 0) "최소급여", 
        nvl(avg(E.salary), 0) "평균급여"
    from departments D
        left outer join employees E on D.department_id = E.department_id
    group by D.department_id;

-- 최종 결론
select 
        D.department_id "부서명", 
        to_char(nvl(max(E.salary), 0), '9,999,999,990.00') "최대급여", 
        to_char(nvl(min(E.salary), 0), '9,999,999,990.00') "최소급여", 
        to_char(nvl(avg(E.salary), 0), '9,999,999,990.00') "평균급여"
    from departments D
        left outer join employees E on D.department_id = E.department_id
    group by D.department_id;

-- 5. 모든 작업자(Employees)의 이름, 급여, 직책명, 소속부서명을 출력하세요.
-- 작업자 테이블에는 이름, 급여, 직책번호, 부서번호밖에 없다.
-- 직원을 조회하며 부가 정보를 outer join으로 붙여서 사용
select 
        E.first_name, E.last_name, E.salary, E.job_id, E.department_id 
    from 
        employees E;

-- JOBS 테이블을 합쳐서 직책명을 조회하도록 수정
select 
        E.first_name, E.last_name, E.salary, j.job_title, E.department_id 
    from 
        employees E
            left outer join jobs J on E.job_id = J.job_id;
            
-- 최종 결론 : DEPARTMENTS 테이블을 합쳐서 부서명을 조회하도록 수정
select 
        E.first_name, E.last_name, E.salary, j.job_title, D.department_name
    from 
        employees E
            left outer join jobs J on E.job_id = J.job_id
            left outer join departments D on E.department_id = D.department_id;
            
-- 자주 사용하는 내용이라면 VIEW(뷰)라는 형태로 구문을 보관시킬 수 있다.
-- create view 뷰이름 as 보관할구문;
create view employees_jobs_departments as 
select 
        E.first_name, E.last_name, E.salary, j.job_title, D.department_name 
    from 
        employees E
            left outer join jobs J on E.job_id = J.job_id
            left outer join departments D on E.department_id = D.department_id;

select * from employees_jobs_departments where salary between 10000 and 20000;

-- 6. 작업자(Employees) 중에서 가장 임금이 높은 인원을 1위부터 5위까지 출력하세요.
select * from (
    select rownum rn, TMP.* from (
        select * from employees order by salary desc
    )TMP
) where rn between 1 and 5;

-- 7. 대륙(Regions)별 부서(Department) 개수를 구하여 출력하세요.
select 
        R.region_id, D.department_id 
    from regions R
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id;

select 
        R.region_id, count(D.department_id)
    from regions R
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
    group by R.region_id;
    
-- 최종 결론
select 
        R.region_name "대륙이름", 
        count(D.department_id) "부서개수"
    from regions R
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
    group by R.region_name
    order by "부서개수" desc;

-- 8. 대륙(Regions)별 작업자(Employees) 수를 구하여 출력하세요.
select 
        R.region_name "대륙이름", 
        count(E.employee_id) "작업자수"
    from regions R
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.department_id
    group by R.region_name
    order by "작업자수" desc;

-- 9. 가장 오래 근무한 작업자(Employees) 3명을 부서명과 함께 출력하세요.
-- 오래 근무했다 = 입사일이 가장 빠르다 = 현재와 입사일의 차가 가장 크다
select * from (
    select rownum rn, TMP.* from (
        select * from employees order by hire_date asc
    )TMP
) where rn between 1 and 3;

select * from (
    select rownum rn, TMP.* from (
        select * from employees order by sysdate-hire_date desc
    )TMP
) where rn between 1 and 3;

-- 최종 결론 : 위의 결과에 부서명 추가(JOIN)
select * from (
    select rownum rn, TMP.* from (
        select 
                E.first_name, E.last_name, E.hire_date, qD.department_name
            from 
                employees E
                    left outer join departments D on E.department_id = D.department_id
                order by sysdate-hire_date desc
    )TMP
) where rn between 1 and 3;

-- 10. 직종(Jobs)별 작업자(Employees)의 최소, 최대, 평균 임금을 출력하세요.
select * from jobs;
select job_title, min_salary, max_salary, (min_salary+max_salary) / 2 from jobs;

select 
        J.job_id, E.employee_id, salary
    from jobs J
        left outer join employees E on J.job_id = E.job_id;

-- 최종 결론
select 
        J.job_title, 
        max(E.salary) "최대급여", 
        min(E.salary) "최소급여", 
        avg(E.salary) "평균급여",
        count(E.employee_id) "인원수"
    from jobs J
        left outer join employees E on J.job_id = E.job_id
    group by J.job_title;
        
-- 11. 작업자(Employees) 중에서 휴대폰 번호가 650으로 시작하는 인원의 정보를 출력하세요.
select * from employees where phone_number like '650%';
select * from employees where instr(phone_number, '650') = 1;
select * from employees where regexp_like(phone_number, '^650');

-- 12. 작업자(Employees) 중에서 관리직원(manager_id)이 없는 인원의 목록을 출력하세요.
-- 	= 인터넷에서 데이터가 없는 경우에 대한 조건 설정을 검색하세요
--     = null 검사 = is null
select employee_id, manager_id from employees where manager_id is null;--잘못된 명령
select employee_id, manager_id from employees where manager_id is null;--올바른 명령
-- 최종 결론
select * from employees where manager_id is null;

-- 추가수업 : 직원별로 부하직원 숫자를 카운트하여 출력
select 
    E1.employee_id "직원번호", E2.employee_id "부하직원번호"
from
    employees E1 
        left outer join employees E2 on E1.employee_id = E2.manager_id;
        
select 
    E1.employee_id "직원번호", 
    count(E2.employee_id) "부하직원수"
from
    employees E1 
        left outer join employees E2 on E1.employee_id = E2.manager_id
    group by E1.employee_id
--    order by "직원번호" asc;
    order by "부하직원수" desc;

-- 13. 작업자(Employees)가 가장 많은 부서(Departments) 3개를 인원수 순서대로 출력하세요.
select * from departments;

select * from departments D left outer join employees E on D.department_id = E.department_id;

select 
        D.department_id, E.employee_id 
    from 
        departments D 
            left outer join employees E on D.department_id = E.department_id;

select 
        D.department_id, count(E.employee_id) 
    from 
        departments D 
            left outer join employees E on D.department_id = E.department_id
    group by D.department_id;
    
select 
        D.department_id, 
        D.department_name,
        count(E.employee_id) "인원수"
    from 
        departments D 
            left outer join employees E on D.department_id = E.department_id
    group by D.department_id, D.department_name
    order by "인원수" desc;
    
-- 최종 결론
select * from (
    select rownum rn, TMP.* from (
        select 
                D.department_id, 
                D.department_name,
                count(E.employee_id) "인원수"
            from 
                departments D 
                    left outer join employees E on D.department_id = E.department_id
            group by D.department_id, D.department_name
            order by "인원수" desc
    )TMP
) where rn between 1 and 3;

-- (참고) 질문에 대한 답변
-- 만약 부서인원수가 같아서 공동 순위가 있다면 ---> rank() 를 사용
-- rank()는 집계함수
-- over()는 집계함수를 매 row마다 계산하여 출력하도록 만들어주는 분석함수
--      over() 안에는 partition by 정보와 order by 정보를 작성할 수 있다.
--      partition by는 순위를 계산할 소그룹 정보를 설정하며, 안주면 전체에서 순위를 계산
--      order by는 순위를 측정할 정렬기준을 의미. 
select * from (
    select 
            D.department_id,
            count(E.employee_id),
            rank() over(order by count(E.employee_id) desc) "순위"
        from 
            departments D 
                left outer join employees E on D.department_id = E.department_id
        group by D.department_id
) where "순위" between 1 and 3;

-- 14. 근무 이력(Job_History)에 저장된 데이터 중 가장 오랜 기간 근무한 작업자(Employees) 의 이름을 출력하세요.
-- 오랜 기간 = (end_date - start_date)가 가장 큰 데이터
select * from job_history;

select H.*, H.end_date - H.start_date "근무일수" from job_history H;

select H.*, H.end_date - H.start_date "근무일수" from job_history H order by "근무일수" desc;

-- 여러개의 결과가 나와도 처리가 가능
select * from (
    select rownum rn, TMP.* from(
        select E.* , H.end_date - H.start_date "근무일수" 
            from job_history H 
                inner join employees E on E.employee_id = H.employee_id
            order by "근무일수" desc
    )TMP
) where rn = 1;

-- 1개일 때만 작동가능한 구문
select * from employees where employee_id = (
    select employee_id from job_history 
        where (end_date - start_date) = (select max(end_date - start_date) from job_history)
);

-- 15. 근무 이력(Job_History)에 저장된 데이터 중 가장 오랜 기간 근무한 작업자(Employees)  Top 3 정보를 출력하세요.
select * from (
    select rownum rn, TMP.* from(
        select E.* , H.end_date - H.start_date "근무일수" 
            from job_history H 
                inner join employees E on E.employee_id = H.employee_id
            order by "근무일수" desc
    )TMP
) where rn between 1 and 3;

-- 16. 직종(Jobs)별 작업자(Employees) 수를 구하여 출력하세요. 
select J.job_id, E.employee_id from jobs J left outer join employees E on J.job_id = E.job_id;

select 
        J.job_id "부서", 
        count(E.employee_id) "인원수"
    from jobs J 
        left outer join employees E on J.job_id = E.job_id
    group by J.job_id
    order by "인원수" desc;

-- (추가) rank()를 같이 표시
select 
        J.job_id "부서", 
        count(E.employee_id) "인원수",
        rank() over(order by count(E.employee_id) desc) "순위"
    from jobs J 
        left outer join employees E on J.job_id = E.job_id
    group by J.job_id
    order by "인원수" desc;

-- 17. 가장 오래 일한 작업자(Employees) 10명의 정보를 출력하세요.(9번과 동일하여 pass)
-- 18. 나라(Countries)별 작업자(Employees) 수를 구하여 출력하세요.   
-- select 나라의기본키, 작업자의기본키 from 나라 ← 지역 ← 부서 ← 작업자
select 
        C.country_id, E.employee_id 
    from countries C
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.employee_id;
        
select 
        C.country_id, 
        count(E.employee_id) 
    from countries C
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.department_id
    group by C.country_id;
    
select 
        C.country_id "국가코드", 
        C.country_name "국가명",
        count(E.employee_id) "작업자수"
    from countries C
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.department_id
    group by C.country_id, C.country_name
    order by "작업자수" desc;