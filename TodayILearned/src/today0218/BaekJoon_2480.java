package today0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2480 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());
		
		int max = a;
		if(b>max) {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		
		if(a==b & b==c) {
			System.out.println(10000+a*1000);
		}else if(a==b | a ==c){
			System.out.println(1000+a*100);
		} else if(b==c) {
			System.out.println(1000+b*100);
		} else {
			System.out.println(max*100);
		}
		
	}//main()
}//class
