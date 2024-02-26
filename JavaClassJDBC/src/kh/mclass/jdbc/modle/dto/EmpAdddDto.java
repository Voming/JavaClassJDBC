package kh.mclass.jdbc.modle.dto;

import java.sql.Date;

public class EmpAdddDto {
//	SQL> desc emp;
//	 이름          널?      유형
//	 ------------- -------- ----------------------------
//	 EMPNO                  NUMBER(4)
//	 ENAME                  VARCHAR2(10)
//	 JOB                    VARCHAR2(9)
//	 MGR                    NUMBER(4)
//	 HIREDATE               DATE
//	 SAL                    NUMBER(7,2)
//	 COMM                   NUMBER(7,2)
//	 DEPTNO                 NUMBER(2)

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
//	private double sal;
//	private double comm;
//	private int deptno;
	// 필수 항목들만 남기고 사용자들에게 입력 받는 DTO도 존재할 수 있음

}
