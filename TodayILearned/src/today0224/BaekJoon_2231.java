package today0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2231 {

	public static void main(String[] args) throws Exception{
		int n = Integer.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		int m = 0;
		for(int i=0; i<n; i++) { // 모든 수를 대입해서 찾기
			
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum += num%10;  //한자리씩 더하기
				num /= 10; //나누기 
			}//while
			
			if( i + sum == n) {
				m = i;
				break;
			}//if
			}//for
		System.out.println(m);
	}//main
}//class
