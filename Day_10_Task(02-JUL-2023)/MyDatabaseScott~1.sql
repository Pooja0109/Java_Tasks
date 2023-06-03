--The queries Below Are In Random Order

--1
select * from emp;
desc emp;

--2
select distinct job from emp;

--3
select * from emp where job='MANAGER';

--4
select * from emp where hiredate<'01-01-81';

--5
select Empno, Ename, Job, Hiredate,TO_NUMBER(TO_CHAR(TO_DATE(Hiredate, 'DD-MM-YY'), 'YYYY'))-TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))
as experience  from emp where job='MANAGER';

--added experience column
alter table emp ADD (experience NUMBER);
update emp set experience = TO_NUMBER(TO_CHAR(TO_DATE(hiredate, 'DD-MM-YY'), 'YYYY'))-TO_NUMBER(TO_CHAR(sysdate, 'YYYY'));

--6
select empno, ename,mgr, sal,TO_NUMBER(TO_CHAR(TO_DATE(Hiredate, 'DD-MM-YY'), 'YYYY'))-TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))as experince from emp where mgr='7839';

--7
select * from emp where comm > sal;

--8
select empno, ename,mgr, sal,TO_NUMBER(TO_CHAR(TO_DATE(Hiredate, 'DD-MM-YY'), 'YYYY'))-TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))as experince from emp
where(sal/30)>100;

--9
select * from emp where deptno in(10,20);

--10
-- alternative query select * from emp where mgr IS NOT NULL;
select ename,job,sal,hiredate,mgr from emp where mgr in (select empno from emp) order by mgr;


--Practice select mgr,count(mgr) from emp group by mgr;

--11
select * from emp where deptno=20 and job='CLERK';

--12
select * from emp where ename='SMITH';

--13
select empno,ename,deptno from emp;

--14
select empno ,deptno from emp;

--15
select distinct deptno from emp;

--16
select empno,ename,sal,(sal+(sal*0.20))as sal_20 from emp where (sal+(sal*0.20)) >3000;

--17
select ename,to_char(sal,'$99,999.000') as sal,to_char((sal+(sal*0.15)),'$99,999.000')as sal_15 from emp;

--19
select empno,ename,sal from emp where job='MANAGER';

--20
--ERROR:select empno,ename,sal,comm,nvl2(comm,(sal+comm)*12,(sal*12)) as annual from emp where annual >=30000;
--using nested query
select empno,ename,sal,comm,annual from(
select empno,ename,sal,comm,nvl2(comm,(sal+comm)*12,(sal*12)) as annual from emp
)where annual >=30000;

--21
--method1:select distinct empno,ename,job,sal,hiredate from emp where empno in(select distinct empno from emp);
select COUNT(distinct empno)from emp;  --only 14 records in table and 14 distinct records in table therefore all employees are unique

--22
select empno,sal,comm from emp;

--23
select distinct job,deptno from emp;

--24
select * from emp where ename='BLAKE';

--25
select * from emp where job='CLERK';

--51
select * from emp where hiredate<'01-01-85' and sal >3000;

--50
select empno,ename,job,deptno from emp where job='CLERK' and deptno=10;

--49
--2nd half means july 1981,therefore:
select * from emp where hiredate >=to_date('01-06-1981','dd-mm-yyyy');

--48
select * from emp where experience>6.5;

--47
select empno,ename,sal,experience from emp where job='ANALYST';

--46
select empno,ename,sal,trunc((sal/30),2) as daily_sal from emp;

--45
select * from emp where hiredate >=to_date('1 April 1982','DD Month YYYY');

--44
select * from emp where sal>2500;

--43
select * from emp where hiredate<'01-01-84';

--42
select * from emp where job='SALESMAN';

--41
select * from emp where deptno=10;

--40
select * from emp where ename='MILLER';

--39
select distinct job,deptno from emp;

--26
select * from emp where hiredate>=to_date('01 may 1981','dd-mm-yyyy');

--27
select empno,ename,sal as salary from emp where sal<3500;

--28
select empno,ename,sal from emp where hiredate < to_date('1 April 1982','DD Month YYYY');

--29
select empno,ename,sal,hiredate from emp where experience >10;

--30
select * from emp where job='MANAGER';

--31
select * from emp where job='CLERK' and experience>8;

--32
select empno,ename,sal,job,annual,deptno,comm from(
select empno,ename,sal,job,comm,nvl2(comm,(sal+comm)*12,(sal*12)) as annual,deptno from emp
)
where annual<34000 and deptno=30 and job='SALESMAN' and comm>0 and comm<sal;

--33
select * from emp where job='SALESMAN' and comm>0;

--34
select * from emp where job='SALESMAN' and deptno=30 and comm>sal;

--36
select * from emp where ROWNUM <=5;

--37
select empno,ename,job,sal from emp;

--38
select distinct deptno from emp;
