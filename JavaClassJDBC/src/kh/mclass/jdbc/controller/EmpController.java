package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.dao.EmpDao;
import kh.mclass.jdbc.modle.vo.Emp;

public class EmpController {
	private EmpDao dao = new EmpDao();

	public List<Emp> selectList() {
		return dao.selectList();
	}

	public int insertEmp(Emp emp) {
		return dao.insertEmp(emp);
	}

	public void deletEmp() {

	}

}
