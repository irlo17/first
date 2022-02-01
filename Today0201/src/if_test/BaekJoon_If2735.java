package if_test;

import java.util.Scanner;

public class BaekJoon_If2735 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();

		if (year % 4 == 0) {
			if (year % 100 != 0 | year % 400 == 0){
				System.out.println(1);// 윤년O
			}else {
				System.out.println(0);
			}//if 100의 배수X or 400의 배수O
		} else { // 윤년X
			System.out.println(0);
		}
		in.close();
	}// main
}// class
