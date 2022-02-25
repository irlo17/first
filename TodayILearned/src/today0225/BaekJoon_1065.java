package today0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_1065 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int total = 99; //한수 카운팅
		int num = 0;
		
		if(n<100) {
			System.out.println(n);
			
		if(n == 1000) {
			n=999;
		}//if
		}else {
			for(int i=100; i<=n; i++) {
				num = i;
				if((num/10%10)-(num%10) == (num/100) - (num/10%10)) {
					total++;
				}//if
			}//for
			System.out.println(total);
		}//if
	}//main()
}//class
