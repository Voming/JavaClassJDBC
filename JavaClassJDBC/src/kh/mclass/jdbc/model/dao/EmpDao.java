package kh.mclass.jdbc.model.dao;
//Data Access Object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.modle.vo.Emp;

public class EmpDao {
	public List<Emp> selectList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		List<Emp> empList = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // lib, jar, class확인
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "TIGER");

			if (conn != null) {
				System.out.println("연결 완료");
			} else {
				System.out.println("연결 실패");
			}

			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from emp");
			// 이 위치에서 new 해서 list에 담아줌
			empList = new ArrayList<Emp>();
			while (rset.next()) {
				// emp생성
				Emp emp = new Emp();
				// emp 값 채우기
				emp.setEmpno(rset.getInt("empNo"));
				emp.setEname(rset.getString("ename"));
				emp.setJob(rset.getString("job"));
				emp.setMgr(rset.getInt("mgr"));
				emp.setHiredate(rset.getDate("hiredate"));
				emp.setSal(rset.getDouble("sal"));
				emp.setComm(rset.getInt("comm"));
				emp.setDeptno(rset.getInt("deptno"));
				// 리스트에 emp 넣기
				empList.add(emp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
		return empList;
	}

	public int insertEmp(Emp emp) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // lib, jar, class확인
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "TIGER");

			if (conn != null) {
				System.out.println("연결 완료");
			} else {
				System.out.println("연결 실패");
			}

			stmt = conn.createStatement();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			String ss = sdf.format(new java.util.Date());

			// new java.util.Date()); //오늘 객체를 생성한다.

			java.sql.Date d = java.sql.Date.valueOf(ss);

			// java.sql.Date 형식으로 바꾼다.

			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) " + "values ("
					+ emp.getEmpno() + ", '" + emp.getEname() + "', '" + emp.getJob() + "', " + emp.getMgr() + ", "
					+ "SYSDATE, " + emp.getSal() + ", " + emp.getComm() + ", " + emp.getDeptno() + ")";
			System.out.println(sql);
			result = stmt.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public void deletEmp() {

	}
}
