package if_test;

import java.util.Scanner;

public class BaekJoon_If2884 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		in.close();
		
		if(m>=45) {
			System.out.println(h+" "+(m-45));
		}else if(h<1) {
			System.out.println(23+" "+(m+60-45));
		}else {
			System.out.println((h-1)+" "+(m+60-45));
		}//if
			
	}//main()

}//class
