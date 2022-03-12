package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1267 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());	// 통화의 개수
		
		int y = 0;		// 영식 요금제 - 30초마다 10원씩 
		int m = 0;		// 민식 요금제 - 60초마다 15원씩 
		int time = 0;	// 통화 시간
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			time = Integer.valueOf(st.nextToken());
			
			y += ((time/30)+1)*10;
			m += ((time/60)+1)*15;
		}// 총 통화 시간
		
		if(y < m) {
			System.out.println("Y"+" "+y);
		}else if(y == m){
			System.out.println("Y"+" "+"M"+" "+y);
			
		}else {
			System.out.println("M"+" "+m);
		}
		
		br.close();
	}

}
