package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.modle.service.DeptService;
import kh.mclass.jdbc.modle.vo.Dept;

public class DeptController {
	private DeptService dao = new DeptService();

	public List<Dept> selectList() {
		return dao.selectList();
	}

	public int insert(Dept dept) {
		return dao.insert(dept);
	}

	public int delete(String dname) {
		return dao.delete(dname);
	}
}
