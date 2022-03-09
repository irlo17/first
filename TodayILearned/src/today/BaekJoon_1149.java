package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1149 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int home[][] = new int[n][3]; // n개의 집, 3개의 색(빨,초,파) 가격
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			home[i][0] = Integer.valueOf(st.nextToken()); //빨
			home[i][1] = Integer.valueOf(st.nextToken()); //초
			home[i][2] = Integer.valueOf(st.nextToken()); //파
			
		}//for-i
		for(int i=1; i<n; i++) {
			// 색이 안겹치게 최소값을 누적
			home[i][0] += Math.min(home[i-1][1], home[i-1][2]);
			home[i][1] += Math.min(home[i-1][0], home[i-1][2]);
			home[i][2] += Math.min(home[i-1][0], home[i-1][1]);
			
		}//for-i
		System.out.println(Math.min(Math.min(home[n-1][0], home[n-1][1]),home[n-1][2]));
		
	}//main()
}//class
