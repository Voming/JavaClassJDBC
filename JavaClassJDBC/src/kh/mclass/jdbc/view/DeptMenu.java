package kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.DeptController;
import kh.mclass.jdbc.modle.vo.Dept;

public class DeptMenu {
	private Scanner sc = new Scanner(System.in);

	private DeptController controller = new DeptController();

	public void mainMenu() {
		while (true) {
			System.out.println("=====DEPT====");
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
		List<Dept> deptList = controller.selectList();
		if (deptList != null) {
			System.out.println("부서 수 : " + deptList.size());
			for (Dept dept : deptList) {
				System.out.println(dept);
			}
		} else {
			System.out.println("오류로 못읽었음");
		}
	}

	public void insert() {
		System.out.println("추가할 값을 입력하세요");

		try {
//			private int deptno;
//			private String dname;
//			private String loc;
			System.out.print("deptno : ");
			String sdeptno = sc.nextLine();
			int deptno = Integer.parseInt(sdeptno);
			System.out.print("dname: ");
			String dname = sc.nextLine();
			System.out.print("loc: ");
			String loc = sc.nextLine();

			Dept dept = new Dept(deptno, dname, loc);
			System.out.println(dept);
			System.out.println("====확인");

			if (controller.insert(dept) > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		} catch (NumberFormatException e) {
			System.out.println("알맞은 자료형을 입력하세요");
		}
	}

	public void delete() {
		System.out.println("지울 부서의 이름을 입력하세요");
		System.out.print("dname: ");
		String dname = sc.nextLine();
		if (controller.delete(dname) > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

}
