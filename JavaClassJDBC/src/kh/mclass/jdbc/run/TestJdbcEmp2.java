package kh.mclass.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbcEmp2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "TIGER");

			if (conn != null)
				System.out.println("연결완료");
			else
				System.out.println("연결 실패");

			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from dept");

			while (rset.next()) {
				System.out.print("DEPTNO : " + rset.getInt("DEPTNO"));
				System.out.print(", DNAME : " + rset.getString("DNAME"));
				System.out.println();
			}
			System.out.println("조회 완료");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
