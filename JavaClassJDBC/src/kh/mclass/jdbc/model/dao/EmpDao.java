package kh.mclass.jdbc.model.dao;
//Data Access Object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public int insertEmp_(Emp emp) {
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

	public int insertEmp(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;   //PreparedStatement
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // lib, jar, class확인
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "TIGER");

			if (conn != null) {
				System.out.println("연결 완료");
			} else {
				System.out.println("연결 실패");
			}

			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ "values (?,?,?,?,SYSDATE,?,?,?)";   // PreparedStatement는 ?로 받을 값을 미리 표현
 
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setDouble(5, emp.getSal());
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptno());
			
			result = pstmt.executeUpdate();   //여기 () 에는 sql을 넣지 않음

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
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
