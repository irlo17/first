package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1746 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.valueOf(st.nextToken());	// 1 ≤ E ≤ 15
		int S = Integer.valueOf(st.nextToken());		// 1 ≤ S ≤ 28
		int M = Integer.valueOf(st.nextToken());		// 1 ≤ M ≤ 19
		
		int e = 1;
		int s = 1;
		int m = 1;
		
		int year = 1;
		/*
			범위를 넘어가는 경우 1이 됨
			예 ) E S M -> 16 16 16 -> 1 16 16
			
			1년 -> 1 1 1로 표현
			15년 -> 15 15 15
			16년 -> 1 16 16
		*/ 
		boolean bo = true;
		while(bo) {
			if(e == E && s == S && m == M) break;
			
			e++;
			s++;
			m++;
			
			//범위를 벗어나면 1로 변한다
			if(e == 16) e = 1;
			if(s == 29) s = 1;
			if(m == 20) m = 1;
			
			year++;

		}//while 
		System.out.println(year);
	}
}
