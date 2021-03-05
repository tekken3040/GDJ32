-- Compute

BREAK ON job SKIP 1 ON REPORT
COMPUTE SUM OF sal ON job REPORT

-- TTITLE과 BTITLE 명령

TTITLE '사원의 업무별|보고서 양식'
BTITLE 'GOOD BY'

------------------------------------
-- 치환 변수(&, && 등)
------------------------------------
-- EMP 테이블에서 부서번호를 입력받아 동적 조회할 수 있는 SELECT문장을 작성하십시오.
-- 참고로 SQL Developer에서 실행하면 변수를 입력할 수 있는 팝업이 뜹니다.
-- 치환 변수에 해당되는 변수 dept_no에 10을 입력해봅니다.
SELECT empno,ename,job,hiredate,deptno
FROM emp
WHERE deptno = &dept_no;

-- 실행결과)
SQL> SELECT empno,ename,job,hiredate,deptno
  2  FROM emp
  3  WHERE deptno = &dept_no;
Enter value for dept_no: 10
old   3: WHERE deptno = &dept_no
new   3: WHERE deptno = 10

     EMPNO ENAME                JOB                HIREDATE     DEPTNO

---------- -------------------- ------------------ -------- ----------

      7839 KING                 PRESIDENT          81/11/17         10

      7782 CLARK                MANAGER            81/01/09         10

      7934 MILLER               CLERK              82/01/23         10
      

-- 참고) SET VERIFY ON/OFF명령어를 이용하여 
-- SQL 명령어나 PL/SQL에서 &를 이용한 치환 변수등을 사용할 때 
-- 치환되기 전/후의 자세한 값을 보일 건지의 여부를 결정 한다. 기본값은 ON 이다.

set verify off
select &list
from &tab
where rownum < 3;
list의 값을 입력하십시오: ename
tab의 값을 입력하십시오: emp

-- 실행결과 예시)
ENAME     
----------
KING
BLAKE

set verify on;
select &list
from &tab
where rownum < 3;
list의 값을 입력하십시오: ename

-- 실행 결과 예시)
ENAME     
----------
KING
BLAKE

이전:select &list
from &tab
where rownum < 3
신규:select ename
from emp
where rownum < 3

ENAME     
----------
KING
BLAKE

-- EMP 테이블에서 이름을 입력받아 동적 조회할 수 있는 SELECT문장을 작성하십시오.
-- scott을 입력해봅니다.

SELECT empno,ename,job,hiredate,sal,deptno
FROM emp
WHERE UPPER(ename) = UPPER('&name');

-- 실행 결과)
SQL> set verify on;
SQL> SELECT empno,ename,job,hiredate,sal,deptno
  2  FROM emp
  3  WHERE UPPER(ename) = UPPER('&name');
Enter value for name: scott
old   3: WHERE UPPER(ename) = UPPER('&name')
new   3: WHERE UPPER(ename) = UPPER('scott')

     EMPNO ENAME                JOB                HIREDATE        SAL

---------- -------------------- ------------------ -------- ----------

    DEPTNO
----------
      7788 SCOTT                ANALYST            82/12/09       3000

        20


