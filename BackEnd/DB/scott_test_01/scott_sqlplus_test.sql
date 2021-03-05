-- 참고로 전체적인 실행 흐름 입장에서 올바른 실행을 하려면 아래의 명령들을 
-- 가급적 SQL prompt 모드에서 실행하시기 바랍니다. 

-- SQL 명령 편집/실행 테스트
-- 아래의 명령은 다음과 같은 오류 발생

SELECT empno,ename,jb,dept
FROM emp;

SQL 오류: ORA-00904: "DEPT": invalid identifier
00904. 00000 -  "%s: invalid identifier"

-- sql plus 명령(C(Change)) 적용하여 jb를 job으로 대응
c/jb/job

-- a(append) 명령어를 사용하여 dept를 dept"no"로 치환
a no

-- 실행(execution) 명령 "/" 실행
/

--------------------------------------------------------------

Microsoft Windows [Version 6.1.7601]

javateam@421-T C:\Users\javateam
$ sqlplus  scott/tiger

SQL*Plus: Release 11.2.0.2.0 Production on 금 5월 8 08:42:53 2020

Copyright (c) 1982, 2014, Oracle.  All rights reserved.


Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL> SELECT empno,ename,jb,dept
  2  FRom emp;
SELECT empno,ename,jb,dept
                      *
ERROR at line 1:
ORA-00904: "DEPT": invalid identifier


SQL> c/jb/job
  1* SELECT empno,ename,job,dept
SQL> a no
  1* SELECT empno,ename,job,deptno
SQL> /

     EMPNO ENAME                JOB                    DEPTNO
---------- -------------------- ------------------ ----------
      7839 KING                 PRESIDENT                  10
      7698 BLAKE                MANAGER                    30
      7782 CLARK                MANAGER                    10
      7566 JONES                MANAGER                    20
      7654 MARTIN               SALESMAN                   30
      7499 ALLEN                SALESMAN                   30
      7844 TURNER               SALESMAN                   30
      7900 JAMES                CLERK                      30
      7521 WARD                 SALESMAN                   30
      7902 FORD                 ANALYST                    20
      7369 SMITH                CLERK                      20

     EMPNO ENAME                JOB                    DEPTNO
---------- -------------------- ------------------ ----------
      7788 SCOTT                ANALYST                    20
      7876 ADAMS                CLERK                      20
      7934 MILLER               CLERK                      10

14 rows selected.

-----------------------------------------------------------------------

-- 파일 편집/실행 명령 테스트


SQL> SELECT e.empno,e.ename,e.job,e.sal,d.dname,d.loc
  2  FROM dept d,emp e
  3  WHERE d.deptno = e.deptno;

     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7839 KING                 PRESIDENT                5000
ACCOUNTING                   NEW YORK

      7698 BLAKE                MANAGER                  2850
SALES                        CHICAGO

      7782 CLARK                MANAGER                  2450
ACCOUNTING                   NEW YORK


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7566 JONES                MANAGER                  2975
RESEARCH                     DALLAS

      7654 MARTIN               SALESMAN                 1250
SALES                        CHICAGO

      7499 ALLEN                SALESMAN                 1600
SALES                        CHICAGO


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7844 TURNER               SALESMAN                 1500
SALES                        CHICAGO

      7900 JAMES                CLERK                     950
SALES                        CHICAGO

      7521 WARD                 SALESMAN                 1250
SALES                        CHICAGO


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7902 FORD                 ANALYST                  3000
RESEARCH                     DALLAS

      7369 SMITH                CLERK                     800
RESEARCH                     DALLAS

      7788 SCOTT                ANALYST                  3000
RESEARCH                     DALLAS


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7876 ADAMS                CLERK                    1100
RESEARCH                     DALLAS

      7934 MILLER               CLERK                    1300
ACCOUNTING                   NEW YORK


14 rows selected.

SQL> save emp_dept
Created file emp_dept.sql

-- 참고로 아래의 명령을 입력하면 기본적인 편집기(가령, Windows라면 노트패드 등)이 자동 실행된다.
SQL> ed emp_dept

SQL> @emp_dept

     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7839 KING                 PRESIDENT                5000
ACCOUNTING                   NEW YORK

      7698 BLAKE                MANAGER                  2850
SALES                        CHICAGO

      7782 CLARK                MANAGER                  2450
ACCOUNTING                   NEW YORK


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7566 JONES                MANAGER                  2975
RESEARCH                     DALLAS

      7654 MARTIN               SALESMAN                 1250
SALES                        CHICAGO

      7499 ALLEN                SALESMAN                 1600
SALES                        CHICAGO


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7844 TURNER               SALESMAN                 1500
SALES                        CHICAGO

      7900 JAMES                CLERK                     950
SALES                        CHICAGO

      7521 WARD                 SALESMAN                 1250
SALES                        CHICAGO


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7902 FORD                 ANALYST                  3000
RESEARCH                     DALLAS

      7369 SMITH                CLERK                     800
RESEARCH                     DALLAS

      7788 SCOTT                ANALYST                  3000
RESEARCH                     DALLAS


     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
DNAME                        LOC
---------------------------- --------------------------
      7876 ADAMS                CLERK                    1100
RESEARCH                     DALLAS

      7934 MILLER               CLERK                    1300
ACCOUNTING                   NEW YORK


14 rows selected.

-----------------------------------------------------------------------

-- SQL Plus 환경 설정 테스트


SQL> SET HEADING OFF
SQL> SET COLSEP '**'
SQL> SELECT * FROM emp;

      7839**KING                **PRESIDENT         **          **81/11/17
      5000**          **        10

      7698**BLAKE               **MANAGER           **      7839**81/05/01
      2850**          **        30

      7782**CLARK               **MANAGER           **      7839**81/01/09
      2450**          **        10

      7566**JONES               **MANAGER           **      7839**81/04/02
      2975**          **        20

      7654**MARTIN              **SALESMAN          **      7698**81/09/28

      1250**      1400**        30

      7499**ALLEN               **SALESMAN          **      7698**81/02/20
      1600**       300**        30

      7844**TURNER              **SALESMAN          **      7698**81/09/08
      1500**         0**        30

      7900**JAMES               **CLERK             **      7698**81/12/03
       950**          **        30

      7521**WARD                **SALESMAN          **      7698**81/02/22
      1250**       500**        30


      7902**FORD                **ANALYST           **      7566**81/12/03
      3000**          **        20

      7369**SMITH               **CLERK             **      7902**80/12/17
       800**          **        20

      7788**SCOTT               **ANALYST           **      7566**82/12/09
      3000**          **        20

      7876**ADAMS               **CLERK             **      7788**83/01/12
      1100**          **        20


      7934**MILLER              **CLERK             **      7782**82/01/23
      1300**          **        10


14 rows selected.

-------------------------------------------------------------------------------

-- SQL Plus 열(Column) 명령 테스트


SQL> COL ename HEADING '사원의|이름' FORMAT a15
SQL> COL ename HEA '사원의|이름' FOR a15
SQL> COL sal JUS LEFT FOR $999,990.00
SQL> COL mgr FOR 9999999999 NUL 'No manager'
SQL> SELECT empno, ename, mgr, sal, deptno
  2  FROM emp
  3  WHERE deptno = 10;

      7839**KING           **No manager **   $5,000.00**        10
      7782**CLARK          **       7839**   $2,450.00**        10
      7934**MILLER         **       7782**   $1,300.00**        10

-----------------------------------------------------------------------------

-- SQL*Plus를 이용하여 보고서 작성


SQL> SET PAGESIZE 42
SQL> SET LINESIZE 54
SQL> SET FEEDBACK OFF
SQL> TTITLE '사원의 업무별|보고서 양식'
SQL> BTITLE 'GOOD BY'
SQL> COLUMN job HEADING 'Job|Category' FORMAT A20
SQL> COLUMN ename HEADING 'Employee' FORMAT A20
SQL> COLUMN sal HEADING 'Salary' FORMAT $999,990.00
SQL> BREAK ON job SKIP 1 ON REPORT
SQL> COMPUTE SUM OF sal ON job REPORT
SQL> SPOOL salary
SQL> SELECT job, ename, sal
  2  FROM emp
  3  ORDER BY job,ename,sal DESC;

금 5월  08                                   page    1
                    사원의 업무별
                     보고서 양식

ANALYST             **FORD
   $3,000.00

                    **SCOTT
   $3,000.00

**********************
------------

sum                 **
   $6,000.00


CLERK               **ADAMS
   $1,100.00

                    **JAMES
     $950.00

                    **MILLER
   $1,300.00

                    **SMITH
     $800.00

**********************
------------

sum                 **
   $4,150.00


MANAGER             **BLAKE
   $2,850.00

                    **CLARK
                       GOOD BY

금 5월  08                                   page    2
                    사원의 업무별
                     보고서 양식

   $2,450.00

MANAGER             **JONES
   $2,975.00

**********************
------------

sum                 **
   $8,275.00


PRESIDENT           **KING
   $5,000.00

**********************
------------

sum                 **
   $5,000.00


SALESMAN            **ALLEN
   $1,600.00

                    **MARTIN
   $1,250.00

                    **TURNER
   $1,500.00

                    **WARD
   $1,250.00

**********************
------------
                       GOOD BY

금 5월  08                                   page    3
                    사원의 업무별
                     보고서 양식


sum                 **
   $5,600.00


                    **
------------

sum                 **
  $29,025.00

                       GOOD BY
-------------------------------------------------------------------

-- BREAK 명령


SQL> BREAK ON job SKIP 1 ON REPORT
SQL> SELECT job, ename, sal
  2  FROM emp
  3  ORDER BY job,ename,sal DESC;

금 5월  08                                   page    1
                    사원의 업무별
                     보고서 양식

ANALYST             **FORD
   $3,000.00

                    **SCOTT
   $3,000.00

**********************
------------

sum                 **
   $6,000.00


CLERK               **ADAMS
   $1,100.00

                    **JAMES
     $950.00

                    **MILLER
   $1,300.00

                    **SMITH
     $800.00

**********************
------------

sum                 **
   $4,150.00


MANAGER             **BLAKE
   $2,850.00

                    **CLARK
                       GOOD BY

금 5월  08                                   page    2
                    사원의 업무별
                     보고서 양식

   $2,450.00

MANAGER             **JONES
   $2,975.00

**********************
------------

sum                 **
   $8,275.00


PRESIDENT           **KING
   $5,000.00

**********************
------------

sum                 **
   $5,000.00


SALESMAN            **ALLEN
   $1,600.00

                    **MARTIN
   $1,250.00

                    **TURNER
   $1,500.00

                    **WARD
   $1,250.00

**********************
------------
                       GOOD BY

금 5월  08                                   page    3
                    사원의 업무별
                     보고서 양식


sum                 **
   $5,600.00


                    **
------------

sum                 **
  $29,025.00


                       GOOD BY
