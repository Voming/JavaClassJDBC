package kh.mclass.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.EmpController;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpMenu {
	private Scanner sc = new Scanner(System.in);

	private EmpController controller = new EmpController();
	
	public void mainMenu() {
		while (true) {
			System.out.println("=====EMP====");
			Boolean exit = false;
			System.out.println("1. 조회");
			System.out.println("2. 추가");
			System.out.println("3. 삭제");
			System.out.print("메뉴를 고르세요 : ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				selectList();
				break;
			case "2":
				insert();
				break;
			case "3":
				delete();
				break;
			default:
				exit = true;
				break;
			}
			if (exit) {
				System.out.println("메인으로 돌아갑니다.");
				break;
			}
		}
	}

	public void selectList() {
		List<Emp> empList = controller.selectList();
		if (empList != null) {
			System.out.println("사원수 : " + empList.size());
			for (Emp emp : empList) {
				System.out.println(emp);
			}
		} else {
			System.out.println("오류로 못읽었음");
		}
	}

	public void insert() {
		System.out.println("추가할 값을 입력하세요");
//		int empno;
//		String ename;
//		String job;
//		int mgr;
//		Date hiredate;
//		double sal;
//		double comm;
//		int deptno;
		try {
			System.out.print("ename: ");
			String ename = sc.nextLine();
			System.out.print("job: ");
			String job = sc.nextLine();

			// System.out.print("hiredate: ");
			Date hiredate = null;
			// 날짜는 입력받지 않고 일단은 null

			System.out.print("empno(4자리 7로 시작?): ");
			String sempno = sc.nextLine();
			int empno = Integer.parseInt(sempno);
			System.out.print("mgr(4자리): ");
			String smgr = sc.nextLine();
			int mag = Integer.parseInt(smgr);
			System.out.print("deptno(10,20,30): ");
			String sdeptno = sc.nextLine();
			int deptno = Integer.parseInt(sdeptno);

			System.out.print("sal(5자리 숫자): ");
			String ssal = sc.nextLine();
			double sal = Double.parseDouble(ssal);
			System.out.print("comm(5자리 숫자): ");
			String scomm = sc.nextLine();
			double comm = Double.parseDouble(scomm);

			Emp emp = new Emp(empno, ename, job, mag, hiredate, sal, comm, deptno);
			System.out.print(emp);
			System.out.println("====확인");

			if (controller.insert(emp) > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		} catch (NumberFormatException e) {
			System.out.println("알맞은 자료형을 입력하세요");
		}
	}

	public void delete() {
		System.out.println("지울 사원의 이름을 입력하세요");
		System.out.print("ename: ");
		String ename = sc.nextLine();
		if (controller.delete(ename) > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

}
