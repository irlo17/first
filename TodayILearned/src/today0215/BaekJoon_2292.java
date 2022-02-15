package today0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2292 {

	public static void main(String[] args) throws Exception{
		int s =Integer.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine().toString());
		int num = 1;
		int x = 1;
		if(s !=1) {
			while(num<s){
				if(num<s & s<=num+(6*x)) {
					System.out.println(x+1);
					break;
				}else {
					num = num+(6*x);
					x++;
				}//if
			}//while
		}else {
			System.out.println(x); //1을 잊지말자...
		}//if
	}//main()
}//class
