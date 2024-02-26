package kh.mclass.jdbc.view;

import java.util.Scanner;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
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
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
	}
}
