package today0301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1978 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		int count = t;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.valueOf(st.nextToken());
			
			if(n == 1 ) {
				count--;
			}else {
				for(int j=2; j<n-1; j++) {
					if(n%j == 0) {
						count--; //소수가 아니면 개수에서 빼주기
						break;
					}//if
				}//for-j
			}//if
		}//for-i
		System.out.println(count);
	}//main()
}//class
