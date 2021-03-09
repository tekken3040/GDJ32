SELECT DEPTNO, COUNT(*)"COUNT(*)", AVG(sal), MIN(sal), MAX(sal), SUM(sal)
FROM EMP GROUP BY DEPTNO
ORDER BY SUM(sal) DESC;

SELECT DEPTNO, JOB, COUNT(*)"COUNT(*)", AVG(sal), SUM(sal)
FROM EMP GROUP BY DEPTNO, JOB;

SELECT JOB, DEPTNO, COUNT(*)"COUNT(*)", AVG(sal), SUM(sal)
FROM EMP GROUP BY JOB, DEPTNO;

SELECT DEPTNO, COUNT(*)"COUNT(*)", SUM(sal)
FROM EMP GROUP BY DEPTNO
HAVING COUNT(*) > 4;

SELECT e.empno, e.ename, e.JOB, e.sal, s.grade, s.losal, s.hisal
FROM SALGRADE s, EMP e
WHERE e.sal BETWEEN s.losal AND s.hisal AND e.deptno = 10;

select * from ALL_TABLES WHERE TABLE_NAME='emp';

SELECT EMPNO"사원번호", ENAME"사원명"
FROM EMP WHERE DEPTNO=30
ORDER BY EMPNO ASC;
