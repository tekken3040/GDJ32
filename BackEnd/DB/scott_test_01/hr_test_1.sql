SELECT MANAGER_ID, FIRST_NAME, SALARY FROM EMPLOYEES
order BY MANAGER_ID, SALARY asc;

SELECT e.last_name AS 이름,
NVL(d.department_name, 'WAITING') AS 부서
FROM EMPLOYEES e, DEPARTMENTS d
WHERE e.department_id = d.department_id(+);

SELECT e.last_name AS 이름,
NVL(d.department_name, 'WAITING') AS 부서
FROM EMPLOYEES e LEFT OUTER JOIN DEPARTMENTS d
ON e.department_id = d.department_id;

SELECT NVL(e.last_name, 'NONE') AS 이름,
d.department_name AS 부서
FROM EMPLOYEES e, DEPARTMENTS d
WHERE e.department_id(+) = d.department_id;

SELECT NVL(e.last_name, 'NONE') AS 이름,
d.department_name AS 부서
FROM EMPLOYEES e RIGHT OUTER JOIN DEPARTMENTS d
ON e.department_id = d.department_id;

SELECT e.FIRST_NAME || ' ' || e.last_name "이름"
FROM EMPLOYEES e, DEPARTMENTS d, LOCATIONS l
WHERE e.department_id = d.department_id
AND d.LOCATION_ID = l.LOCATION_ID
AND l.city = 'Oxford'
ORDER BY FIRST_NAME ASC;

SELECT DISTINCT e.employee_id, (e.FIRST_NAME || ' ' || e.last_name) AS 이름
FROM EMPLOYEES e, JOB_HISTORY j
WHERE e.employee_id = j.employee_id
AND j.start_date < '2002/01/01';

SELECT * from EMPLOYEES WHERE COLS;
select * from user_tables;
select * from ALL_TABLES WHERE TABLE_NAME='employees';
COMMIT;

SELECT e.FIRST_NAME || ' ' || e.last_name "사원명", e.JOB_ID"부서아이디", j.START_DATE"업무 시작일", j.END_DATE"업무 종료일"
FROM EMPLOYEES e, JOB_HISTORY j
WHERE e.employee_id = j.employee_id
AND e.employee_id = 101
AND e.JOB_ID = 'AC_ACCOUNT';

SELECT COLUMN_NAME"Name", NULLABLE"Null?", DATA_TYPE"Type" from ALL_TAB_COLUMNS WHERE TABLE_NAME='EMPLOYEES';
DESC EMPLOYEES;