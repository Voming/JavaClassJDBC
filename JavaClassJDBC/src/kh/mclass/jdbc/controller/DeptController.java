package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.modle.service.DeptService;
import kh.mclass.jdbc.modle.vo.Dept;

public class DeptController {
	private DeptService service = new DeptService();

	public List<Dept> selectList() {
		return service.selectList();
	}

	public int insert(Dept dept) {
		return service.insert(dept);
	}

	public int delete(String dname) {
		return service.delete(dname);
	}
}
