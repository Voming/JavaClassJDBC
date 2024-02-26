package kh.mclass.jdbc.modle.service;

import static kh.mclass.jdbc.common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import kh.mclass.jdbc.model.dao.DeptDao;
import kh.mclass.jdbc.modle.vo.Dept;

public class DeptService {
	//connection 객체/close
	// conn -commit/ rollback
	
	private DeptDao dao = new DeptDao();

	public List<Dept> selectList() {
		Connection conn = null;
		conn = getConnection();
		return dao.selectList();
	}

	public int insertDept(Dept dept) {
		return dao.insertDept(dept);
	}

	public int deletDept(String dname) {
		return dao.deletDept(dname);
	}
}
