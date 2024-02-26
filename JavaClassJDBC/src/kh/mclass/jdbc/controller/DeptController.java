package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.modle.service.DeptService;
import kh.mclass.jdbc.modle.vo.Dept;


public class DeptController {
	private DeptService dao = new DeptService();

	public List<Dept> selectList() {
		return dao.selectList();
	}

	public int insertDept(Dept dept) {
		return dao.insertDept(dept);
	}

	public int deletDept(String dname) {
		return dao.deletDept(dname);
	}


}
