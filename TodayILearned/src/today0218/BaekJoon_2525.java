package today0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2525 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.valueOf(st.nextToken()); 
		int m = Integer.valueOf(st.nextToken()); // 현재 시간 h : 시, m : 분
		int t = Integer.valueOf(br.readLine()) + m; //요리 시간
		
		int hour = t / 60;
		int minute = t % 60;
		
		if( hour + h > 23) {
			h = hour + h -24;
		}else { 
			h = hour + h;
		}// 시
		
		System.out.println(h+" "+minute); // 현재시간 + 요리 시간
	}//main()
}//class
