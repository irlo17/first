package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_1094 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stick = 64;
		int count = 0;
		int x = Integer.valueOf(br.readLine());
		
		/*
			x = 23일 때,
			
			1) x=23 > s=16 => x-s = 7 
				x=7 s = 16 count=1

			2) x=7 > s=4 => x-s = 3
				x=3 s=4 count=2

			3) x=3 > s=2 => x-s = 1
				x=1 s=2 count=3

			4) x=1 >= s=1 x-s = 0
				x=0 s=1 count=4
		*/
		while( x > 0) {
			if(x<stick) {
				stick /= 2; 
			}else {
				x -= stick;
				count++;
			}//if
		}//while
		System.out.println(count);
	}//main()
}//class
