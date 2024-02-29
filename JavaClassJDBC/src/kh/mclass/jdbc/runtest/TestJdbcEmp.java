package kh.mclass.jdbc.runtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Emp;

public class TestJdbcEmp {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		List<Emp> empList = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // lib, jar, class확인
			// jdbc:oracle:thin:@localhost:1521:XE", "scott", "TIGER"
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "TIGER");
			
			if(conn != null) {
				System.out.println("연결 완료");
			}else {
				System.out.println("연결 실패");
			}
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from emp");
			//이 위치에서 new 해서 list에 담아줌
			empList = new ArrayList<Emp>();
			while(rset.next()) {
				//emp생성
				Emp empa = new Emp();
				//emp 값 채우기
				empa.setEmpno(rset.getInt("empNo"));
				empa.setEname(rset.getString("ename"));
				empa.setJob(rset.getString("job"));
				empa.setMgr(rset.getInt("mgr"));
				empa.setHiredate(rset.getDate("hiredate"));
				empa.setSal(rset.getDouble("sal"));
				empa.setComm(rset.getInt("comm"));
				empa.setDeptno(rset.getInt("deptno"));
				//리스트에 emp 넣기
				empList.add(empa);
				
				//int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno
				/*Emp empa = new Emp( 
						rset.getInt("empno"),
						rset.getString("ename"),
						rset.getString("job"),
						rset.getInt("mgr"),
						rset.getDate("hiredate"),
						rset.getDouble("sal"),
						rset.getInt("comm"),
						rset.getInt("deptno")
						); */
				
				System.out.print("empno : " + rset.getInt("empno"));
				System.out.print(", ename : "+ rset.getString("ename"));
				System.out.print(", sal : "+ rset.getDouble("sal"));
				System.out.println();
			}
			System.out.println("다 읽었음");
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
		
		
		
		if(empList != null) {
			for(Emp emp : empList) {
				System.out.println(emp);
			}
		}else {
			System.out.println("오류로 못읽었음");
		}
	}

}
