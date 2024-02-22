package kh.mclass.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbcRun {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			// 1. DriverManager에 해당 DBMS Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 드라이버 이름은 OJDBC 버전에 따라 달라짐

			// 2. 해당 Driver로부터 Connection instance 획득
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", // URL
					"system", // username +) 계정마다 권한도 존재함(Oracel system이 결정) , 대소문자 구분 안함
					"oracle"); // password // 반드시 소문자 구분함

			if (conn != null) {
				System.out.println("연결 성공");

				// 3. 해당 Driver로부터 Connection instance 획득
				stmt = conn.createStatement();

				// 4. Statement method를 이용하여 SQL문 실행
				String query = "SELECT ID, LAST_NAME FROM EMP"; // 대소문자 구분하지 않음
				int result = stmt.executeUpdate("UPDATE EMP SET LAST_NAME = 'KIM' WHERE ID = '10000");

				// 5. 실행결과를 ResultSet 혹은 int형 변수로 받아서 처리
				rset = stmt.executeQuery(query); // 6. Statement method를 이용하여 SQL문 실행
				// executeQuery : 리턴형 ResultSet , 조회/읽기(어떠한 범위 받기)
				// updateQuery : 리턴형 int , 추가/삭제/수정(성공여부:성공 1, 실패 0, 수정/삭제: 몇 개)

				while (rset.next()) { // database는 1번부터 시작함
					System.out.println(rset.getString("ID") + "\t" + rset.getString(2));
				}

			} else {
				System.out.println("연결 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 기본자료형 제외하고 close() 해줘야함
			// 7. ResultSet 사용한 경우 반납처리
			try {
				if (rset != null) rset.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
