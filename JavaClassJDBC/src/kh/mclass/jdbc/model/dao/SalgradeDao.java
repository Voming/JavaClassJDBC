package kh.mclass.jdbc.model.dao;

import static kh.mclass.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.modle.vo.Salgrade;

public class SalgradeDao {
//	private int grade;
//	private int losal;
//	private int hisal;

	public List<Salgrade> selectList(Connection conn) {
		String sql = "select * from salgrade";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Salgrade> list = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			list = new ArrayList<Salgrade>();
			while (rs.next()) {
				Salgrade sal = new Salgrade();

				sal.setGrade(rs.getInt("grade"));
				sal.setLosal(rs.getInt("losal"));
				sal.setHisal(rs.getInt("hisal"));

				list.add(sal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
	}

	public int insert(Connection conn, Salgrade sal) {
		String sql = "insert into salgrade values(?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, sal.getGrade());
			pstmt.setInt(2, sal.getLosal());
			pstmt.setInt(3, sal.getHisal());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt); // conn의 close 처리는 밖에서
		}
		return result;
	}

	public int delete(Connection conn, int grade) {
		String sql = "delete from salgrade where grade = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, grade);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt); // conn의 close 처리는 밖에서
		}
		return result;
	}

}
