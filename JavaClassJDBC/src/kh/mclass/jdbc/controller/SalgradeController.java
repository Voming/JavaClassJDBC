package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeController {
	SalgradeService service = new SalgradeService();

	public Salgrade selectOne(int grade) {
		Salgrade result  = null;
		result = service.selectOne(grade);
		return result;
	}

	
	public List<Salgrade> selectList() {
		List<Salgrade> resultList = null;
		resultList = service.selectList();
		return resultList;
	}

	public int insert(Salgrade sal) {
		int result = 0;
		result = service.insert(sal);
		return result;
	}

	public int delete(int grade) {
		int result = 0;
		result = service.delete(grade);
		return result;
	}
}
