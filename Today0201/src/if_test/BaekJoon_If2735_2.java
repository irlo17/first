package if_test;

import java.util.Scanner;

public class BaekJoon_If2735_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int y = in.nextInt();
		in.close();
		
		System.out.println((y%4==0)?((y%400==0)?"1":(y%100==0)?"0" :"1"):"0");
	}

}
