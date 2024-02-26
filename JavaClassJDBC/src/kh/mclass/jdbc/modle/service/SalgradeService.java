package kh.mclass.jdbc.modle.service;

import static kh.mclass.jdbc.common.JdbcTemplate.autoCommit;
import static kh.mclass.jdbc.common.JdbcTemplate.close;
import static kh.mclass.jdbc.common.JdbcTemplate.commit;
import static kh.mclass.jdbc.common.JdbcTemplate.getConnection;
import static kh.mclass.jdbc.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import kh.mclass.jdbc.model.dao.SalgradeDao;
import kh.mclass.jdbc.modle.vo.Salgrade;

public class SalgradeService {
	SalgradeDao dao = new SalgradeDao();

	public List<Salgrade> selectList() {
		List<Salgrade> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}

	public int insert(Salgrade sal) {
		int result = -1;
		Connection conn = getConnection();
		autoCommit(conn, false);
		result = dao.insert(conn, sal);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int delete(int grade) {
		int result = -1;
		Connection conn = getConnection();
		autoCommit(conn, false);
		result = dao.delete(conn, grade);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
