package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.modle.service.SalgradeService;
import kh.mclass.jdbc.modle.vo.Salgrade;

public class SalgradeController {
	SalgradeService service = new SalgradeService();

	public List<Salgrade> selectList() {
		return service.selectList();
	}

	public int insert(Salgrade sal) {
		return service.insert(sal);
	}

	public int delete(int grade) {
		return service.delete(grade);
	}
}
