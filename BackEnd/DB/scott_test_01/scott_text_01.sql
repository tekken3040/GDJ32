-- 1. ������� ���̺�(emp)���� �Ի����ڰ� 1982�� 1�� 1�� ���Ŀ� �Ի��� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����Ͻʽÿ�.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE hiredate >= '82-01-01';

-- 2. ������� ���̺�(emp)���� �����ȣ�� 7902,7788,7566�� ����� ������  �����ȣ, ����, ������, �޿�, �Ի����ڸ� ����Ͻʽÿ�.

SELECT empno,ename,job,sal,hiredate
FROM emp
WHERE empno IN (7902,7788,7566);

--3. ������� ���̺�(emp)���� �Ի����ڰ� 82�⵵�� �Ի��� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����Ͻʽÿ�.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE hiredate LIKE '1982%';

-- ���ǻ���) NLS ��¥ ������ �⵵�� 4�ڸ��� ������ ���� ���� ���� �Ͻð� 2�ڸ��� ������ ���� "82%" �� �˻��Ͻø� �˴ϴ�. SQL developer�� �ۼ��� ��� ���ǻ����� �Ʒ��� �����󿡼� �����Ͻø� �ǰڽ��ϴ�.
-- : https://drive.google.com/file/d/1NQ5n57PVrkLVJ45BCxLMelJvAjWE-o47/view?usp=sharing

-- 4. ������� ���̺�(emp)���� ���ʽ��� ����(NULL) ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����Ͻʽÿ�.

SELECT empno,ename,job,sal,comm,deptno
FROM emp
WHERE comm IS NULL;
?
-- 5. ������� ���̺�(emp)���� �޿��� 1100�̻��̰� JOB�� Manager�� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����Ͻʽÿ�.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE sal >= 1100 AND job = 'MANAGER';

-- 6. ������� ���̺�(emp)���� �޿��� 1100�̻��̰ų� JOB�� Manager�� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����Ͻʽÿ�.

SELECT empno,ename,job,sal,hiredate,deptno
FROM emp
WHERE sal >= 1100 OR job = 'MANAGER';
?
-- 7. ������� ���̺�(emp)���� �޿��� JOB�� Manager,Clear,Analyst�� �ƴ� ����� ������  �����ȣ, ����, ������, �޿�, �μ���ȣ�� ����Ͻʽÿ�.
?
SELECT empno,ename,job,sal,deptno
FROM emp
WHERE job NOT IN ('MANAGER','CLERK','ANALYST');

-- 8. ������ PRESIDENT�̰� �޿��� 1500�̻��̰ų� ������ SALESMAN�� ����� ������ �����ȣ, �̸�, ����, �޿��� ����Ͻʽÿ�.

SELECT empno,ename,job,sal
FROM emp
WHERE job = 'SALESMAN' OR job = 'PRESIDENT' AND sal >= 1500;

-- 9. ������ PRESIDENT�Ǵ� SALESMAN�̰� �޿��� 1500�̻��� ����� ������ �����ȣ, �̸�, ����, �޿��� ����Ͻʽÿ�.

SELECT empno,ename,job,sal
FROM emp
WHERE (job = 'SALESMAN' OR job = 'PRESIDENT') AND sal >= 1500;

-- 10. ������� ���̺�(emp)���� �Ի����� ������ �����Ͽ� �����ȣ, �̸�, ����, �޿�, �Ի�����,�μ���ȣ�� ����Ͻʽÿ�.

SELECT hiredate,empno,ename,job,sal,deptno
FROM emp
ORDER BY hiredate;

-- 11. ������� ���̺�(emp)���� ���� �ֱٿ� �Ի��� ������ �����ȣ, �̸�, ����, �޿�, �Ի�����,�μ���ȣ�� ����Ͻʽÿ�.

SELECT hiredate,empno,ename,job,sal, deptno
FROM emp
ORDER BY hiredate DESC;

-- 12. ������� ���̺�(emp)���� �μ���ȣ�� ������ �� �μ���ȣ�� ���� ��� �޿��� ���� ������ �����Ͽ� �����ȣ, ����, ����, �μ���ȣ, �޿��� ����Ͻʽÿ�.

SELECT deptno,sal,empno,ename,job
FROM emp
ORDER BY deptno, sal DESC;

-- 13. ������� ���̺�(emp)���� ù��° ������ �μ���ȣ�� �ι�° ������ ������ ����° ������ �޿��� ���� ������ �����Ͽ� �����ȣ, ����, �Ի�����, �μ���ȣ, ����, �޿��� ����Ͻʽÿ�.

SELECT deptno,job,sal,empno,ename,hiredate
FROM emp
ORDER BY deptno,job,sal DESC;
