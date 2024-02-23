package kh.mclass.jdbc.view;

import java.util.Scanner;

import kh.mclass.jdbc.controller.EmpController;

public class EmpMenu {
	private Scanner sc = new Scanner(System.in);

	private EmpController controller = new EmpController();

	public void mainMenu() {
		while (true) {
			Boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.print("1. 조회");
			System.out.print("2. 추가");
			System.out.print("3. 삭제");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				selectList();
				break;
			case "2":
				insertEmp();
				break;
			case "3":
				deletEmp();
				break;
			default:
				exit = true;
				break;
			}
			if (exit) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
	}

	public void selectList() {
		controller.selectList();
	}

	public void insertEmp() {
		controller.insertEmp();
	}

	public void deletEmp() {
		controller.deletEmp();
	}

}
