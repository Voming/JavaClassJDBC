package kh.mclass.jdbc.modle.dto;

import java.sql.Date;

// 사원 상세정보 보기
public class EmpDto {
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
	private String mgrEname;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	private String dname;
	// 실제 디비에 저장된 내용 이외에도 화면에 띄워질 정보가 들어갈 수 있음

}
