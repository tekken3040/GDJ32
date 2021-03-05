-- 1. 사원정보 테이블(emp)에서 입사일자가 1982년 1월 1일 이후에 입사한 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하십시오.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE hiredate >= '82-01-01';

-- 2. 사원정보 테이블(emp)에서 사원번호가 7902,7788,7566인 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자를 출력하십시오.

SELECT empno,ename,job,sal,hiredate
FROM emp
WHERE empno IN (7902,7788,7566);

--3. 사원정보 테이블(emp)에서 입사일자가 82년도에 입사한 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하십시오.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE hiredate LIKE '1982%';

-- 주의사항) NLS 날짜 포맷이 년도가 4자리로 설정된 경우는 위와 같이 하시고 2자리로 설정된 경우는 "82%" 로 검색하시면 됩니다. SQL developer로 작성할 경우 주의사항을 아래의 동영상에서 참고하시면 되겠습니다.
-- : https://drive.google.com/file/d/1NQ5n57PVrkLVJ45BCxLMelJvAjWE-o47/view?usp=sharing

-- 4. 사원정보 테이블(emp)에서 보너스가 없는(NULL) 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하십시오.

SELECT empno,ename,job,sal,comm,deptno
FROM emp
WHERE comm IS NULL;
?
-- 5. 사원정보 테이블(emp)에서 급여가 1100이상이고 JOB이 Manager인 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하십시오.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE sal >= 1100 AND job = 'MANAGER';

-- 6. 사원정보 테이블(emp)에서 급여가 1100이상이거나 JOB이 Manager인 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하십시오.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE sal >= 1100 OR job = 'MANAGER';
?
-- 7. 사원정보 테이블(emp)에서 급여가 JOB이 Manager,Clear,Analyst가 아닌 사원의 정보를  사원번호, 성명, 담당업무, 급여, 부서번호를 출력하십시오.
?
SELECT empno,ename,job,sal,deptno
FROM emp
WHERE job NOT IN ('MANAGER','CLERK','ANALYST');

-- 8. 업무가 PRESIDENT이고 급여가 1500이상이거나 업무가 SALESMAN인 사원의 정보를 사원번호, 이름, 업무, 급여를 출력하십시오.

SELECT empno,ename,job,sal
FROM emp
WHERE job = 'SALESMAN' OR job = 'PRESIDENT' AND sal >= 1500;

-- 9. 업무가 PRESIDENT또는 SALESMAN이고 급여가 1500이상인 사원의 정보를 사원번호, 이름, 업무, 급여를 출력하십시오.

SELECT empno,ename,job,sal
FROM emp
WHERE (job = 'SALESMAN' OR job = 'PRESIDENT') AND sal >= 1500;

-- 10. 사원정보 테이블(emp)에서 입사일자 순으로 정렬하여 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하십시오.

SELECT hiredate,empno,ename,job,sal,deptno
FROM emp
ORDER BY hiredate;

-- 11. 사원정보 테이블(emp)에서 가장 최근에 입사한 순으로 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하십시오.

SELECT hiredate,empno,ename,job,sal, deptno
FROM emp
ORDER BY hiredate DESC;

-- 12. 사원정보 테이블(emp)에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여 사원번호, 성명, 업무, 부서번호, 급여를 출력하십시오.

SELECT deptno,sal,empno,ename,job
FROM emp
ORDER BY deptno, sal DESC;

-- 13. 사원정보 테이블(emp)에서 첫번째 정렬은 부서번호로 두번째 정렬은 업무로 세번째 정렬은 급여가 많은 순으로 정렬하여 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하십시오.

SELECT deptno,job,sal,empno,ename,hiredate
FROM emp
ORDER BY deptno,job,sal DESC;
