package kh.mclass.jdbc.view;

import java.util.Scanner;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			Boolean exit = false;
			System.out.println("1. EMP");
			System.out.println("2. DEPT");
			System.out.print("메뉴를 고르세요 : ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				new EmpMenu().mainMenu();
				break;
			case "2":
				new DeptMenu().mainMenu();
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
}
