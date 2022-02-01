package if_test;

import java.util.Scanner;

public class BaekJoon_If14681 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		int y = in.nextInt();
		in.close();
		
		System.out.println((x>0 & y>0) ? 1 : (x<0 & y>0) ? 2 : (x<0 & y<0) ? 3 : 4);
	}//main

}//class
