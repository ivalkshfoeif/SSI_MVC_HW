 ## Setup
 
```SQL

-- create
CREATE TABLE EMPLOYEE (
  EmpId INTEGER PRIMARY KEY,
  FullName TEXT NOT NULL,
  ManagerId INTEGER NOT NULL,
  DateOfJoining DATE NOT NULL
);

CREATE TABLE SALARY (
  EmpId INTEGER PRIMARY KEY,
  Project TEXT NOT NULL,
  Salary INTEGER NOT NULL
);


-- insert
INSERT INTO EMPLOYEE VALUES (121, 'Jon Snow', 321, '2014-01-31');
INSERT INTO EMPLOYEE VALUES (321, 'Night King', 986, '2015-01-30');
INSERT INTO EMPLOYEE VALUES (421, 'Arya Stark', 876, '2016-11-27');
INSERT INTO EMPLOYEE VALUES (521, 'Sansa Stark', 876, '2017-12-02');
INSERT INTO EMPLOYEE VALUES (522, 'Sansa Stark2', 876, '2017-12-02');

INSERT INTO SALARY VALUES (121, 'P1', 8000);
INSERT INTO SALARY VALUES (321, 'P2', 1000);
INSERT INTO SALARY VALUES (421, 'P1', 12000);
INSERT INTO SALARY VALUES (721, 'P3', 6000);

-- fetch
SELECT * FROM EMPLOYEE;
SELECT * FROM SALARY;

```

### Result

```
Output:

EmpId	FullName	ManagerId	DateOfJoining
121	Jon Snow	321	2014-01-31
321	Night King	986	2015-01-30
421	Arya Stark	876	2016-11-27
521	Sansa Stark	876	2017-12-02
522	Sansa Stark2	876	2017-12-02
EmpId	Project	Salary
121	P1	8000
321	P2	1000
421	P1	12000
721	P3	6000
```

1.

```SQl
SELECT * FROM
```

```

```

## Question

1.

```SQl
SELECT count(*) as count, Project FROM SALARY WHERE Project = 'P1' GROUP BY Project;
```

```
count	Project
2	P1
```

2.

```SQl
SELECT FullName FROM EMPLOYEE JOIN SALARY ON EMPLOYEE.EmpId = SALARY.EmpId WHERE SALARY.Salary >= 5000 AND SALARY.Salary <= 10000;
```

```
FullName
Jon Snow
```


3.

```SQl
SELECT count(*) as employee_count, Project FROM EMPLOYEE JOIN SALARY ON EMPLOYEE.EmpId = SALARY.EmpId GROUP BY Project ORDER BY employee_count DESC;

```

```
employee_count	Project
2	P1
1	P2
```

4.

```SQl
SELECT Project FROM EMPLOYEE JOIN SALARY ON EMPLOYEE.EmpId = SALARY.EmpId GROUP BY Project HAVING count(*) > 1;
```

```
Project
P1
```

5.

```SQl
SELECT FullName, COALESCE(Salary, 0) as Salary FROM EMPLOYEE LEFT JOIN SALARY ON EMPLOYEE.EmpId = SALARY.EmpId;
```

```
FullName	Salary
Jon Snow	8000
Night King	1000
Arya Stark	12000
Sansa Stark	0
Sansa Stark2	0
```

6.

```SQl
SELECT A.FullName as Employee_Name, B.FullName as Manager_Name FROM EMPLOYEE as A JOIN EMPLOYEE as B ON A.ManagerId = B.EmpId;
```

```
Employee_Name	Manager_Name
Jon Snow	Night King
```

7.

```SQl
SELECT FullName FROM EMPLOYEE GROUP BY FullName HAVING count(*) > 1;
```

```
FullName
Sansa Stark
```

8.

```SQl
SELECT FullName FROM EMPLOYEE LEFT JOIN SALARY ON EMPLOYEE.EmpId = SALARY.EmpId WHERE SALARY.Salary is NULL;
```

```
FullName
Sansa Stark
Sansa Stark
```

9.

```SQl
SELECT CURRENT_TIMESTAMP;
SELECT DateOfJoining FROM EMPLOYEE;
```

```
CURRENT_TIMESTAMP
2023-06-17 08:42:05
DateOfJoining
2014-01-31
2015-01-30
2016-11-27
2017-12-02
2017-12-02
```


10.

```SQl
SELECT FullName FROM EMPLOYEE WHERE YEAR(DateOfJoining) = 2016;
```

```
FullName
Arya Stark
```


11.

```SQl
SELECT FullName, Salary FROM EMPLOYEE JOIN SALARY ON EMPLOYEE.EmpId = SALARY.EmpId WHERE MONTH(DateOfJoining) = 1;
```

```
FullName	Salary
Jon Snow	8000
Night King	1000
```