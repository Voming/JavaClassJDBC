package kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.SalgradeController;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeMenu {
	Scanner sc = new Scanner(System.in);
	SalgradeController controller = new SalgradeController();
	public void mainMenu() {
		while(true) {
			System.out.println("====SALGRADE====");
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
		List<Salgrade> saltList = controller.selectList();
		if (saltList != null) {
			System.out.println("임금 : " + saltList.size());
			for (Salgrade sal : saltList) {
				System.out.println(sal);
			}
		} else {
			System.out.println("오류로 못읽었음");
		}
	}

	public void insert() {
		System.out.println("추가할 값을 입력하세요");

		try {
//			private int grade;
//			private int losal;
//			private int hisal;
			System.out.print("grade : ");
			String sgrade = sc.nextLine();
			int grade = Integer.parseInt(sgrade);
			System.out.print("losal : ");
			String slosal = sc.nextLine();
			int losal = Integer.parseInt(slosal);
			System.out.print("hisal : ");
			String shisal = sc.nextLine();
			int hisal = Integer.parseInt(shisal);

			Salgrade sal  = new Salgrade(grade, losal, hisal);
			System.out.print(sal);
			System.out.println("====확인");

			if (controller.insert(sal) > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		} catch (NumberFormatException e) {
			System.out.println("알맞은 자료형을 입력하세요");
		}
	}

	public void delete() {
		System.out.println("지울 임금 grade 을 입력하세요");
		System.out.print("grade: ");
		String sgrade = sc.nextLine();
		int grade = Integer.parseInt(sgrade);
		if (controller.delete(grade) > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

}
