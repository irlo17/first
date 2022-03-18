package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_9501 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());	//테스트케이스 개수
		
		
		
		for(int i=0; i<t; i++) {

			//각 테스트케이스에 대해 목적지까지 갈 수 있는 우주선의 개수
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.valueOf(st.nextToken());	// 우주선의 개수
			int d = Integer.valueOf(st.nextToken());	// 목적지까지의 거리
			
			for(int j=0; j<n; j++) {
				
				st = new StringTokenizer(br.readLine());
				
				int v = Integer.valueOf(st.nextToken());	// 우주선의 최고 속도
				int f = Integer.valueOf(st.nextToken());	// 우주선의 연료양
				int c = Integer.valueOf(st.nextToken());	// 우주선의 연료소비율 = 단위시간당 소비하는 연료의 양
				
				//	연료양/연료소비율*최고 속도 >= 목적지까지의 거리
				
				if((double)f/c*v>=d) {
					count++;
				}
			}//end of for-j
			System.out.println(count);
		}//end of for-i
		
		
	}

}
