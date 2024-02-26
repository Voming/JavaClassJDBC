package kh.mclass.jdbc.model.dao;

//import static kh.mclass.jdbc.common.JdbcTemplate.*;
import static kh.mclass.jdbc.common.JdbcTemplate.close;
import static kh.mclass.jdbc.common.JdbcTemplate.getConnection;
//static과 .*을 적으면 해당 클래스의 멤버 변수, 메소드를 의미함
//단, static일 경우만 가능함
//extends 에도 찾을 수 없고 기본 제공 메소드가 아니라면 import static을 찾아야함
//기울어진 메소드
//마치 extends한 효과

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.modle.vo.Dept;


public class DeptDao {
//	private int deptno;
//	private String dname;
//	private String loc;
	public List<Dept> selectList() {
		String sql = "select * from dept";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> result = null;
		try {
			conn = getConnection(); // 연결 부분을 메소드 호출로 간단하게 구현
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<Dept>();
			
			while(rs.next()) {
				Dept vo = new Dept();
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public int insertDept(Dept dept) {
		String sql = "insert into dept values(51, 'KH', 'Seoul')";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = getConnection(); // 연결 부분을 메소드 호출로 간단하게 구현
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public int deletDept(String dname) {
		
	}
}
