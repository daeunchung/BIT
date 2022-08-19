-- 롯데 e커머스 정다은 훈련생

-- 문제1) EMPLOYEES Table의 모든 자료를 출력하여라.
select * from employees;

-- 문제2) EMPLOYEES Table의 컬럼들을 모두 출력하라.
SHOW COLUMNS FROM mydb.employees;

-- 문제3) EMPLOYEES Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.
select employee_id, first_name, salary, job_id from employees;

-- 문제4) 모든 종업원의 급여를 $300증가 시키기 위해서 덧셈 연산자를 사용하고 결과에 SALARY+300을 디스플레이 합니다.
select employee_id, salary+300 AS 'SALARY+300' 
from employees;

-- 문제5) EMPLOYEES 테이블에서 사원번호, 이름, 급여, 보너스, 보너스 금액을 출력하여라. 
-- (참고로 보너스는 월급 + (월급*커미션))
select employee_id, first_name, salary, 
salary*commission_pct + salary AS '보너스', 
salary*commission_pct AS '보너스 금액'
from employees;

-- 문제6) EMPLOYEES 테이블에서 LAST_NAME을 이름으로 SALARY을 급여로 출력하여라.
select last_name AS '이름' , salary AS '급여'
from employees;

-- 문제7) EMPLOYEES 테이블에서 LAST_NAME을 Name으로 SALARY *12 를 Annual Salary(연봉)로 출력하여라
select last_name AS 'Name' , salary*12 AS 'Annual Salary(연봉)'
from employees;

-- 문제9) EMPLOYEES 테이블에서 이름과 업무를 연결하여 출력하여라.
select concat(last_name, job_id)
from employees;

-- 문제10) EMPLOYEES 테이블에서 이름과 업무를 "KING is a PRESIDENT" 형식으로 출력하여라. 
select concat(last_name, " is a ", job_id)
from employees;

-- 문제11) EMPLOYEES 테이블에서 이름과 연봉을 "KING: 1 Year salary = 60000" 형식으로 출력하여라.
select concat(last_name, ": 1 Year salary = ", salary)
from employees;
