package today;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BaekJoon_2455 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;	// 기차안 사람 수	
		int max = 0; 	// 최대 사람 수
		
		// 1번역(출발역) ~ 4번역(종착역) 총 4개의 역
		// 내릴 사람이 모두 내린 후 기차에 탄다
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1번역에서는 내린 사람이 없으므로 0+탑승한 승객의 수 -> 1번역에서 탑승한 승객의 수
		count = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
		max = count;
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			count -= Integer.parseInt(st.nextToken()); // 내린 사람의 수
			count += Integer.parseInt(st.nextToken()); // 탑승한 사람의 수
			if(count > max) max = count;
			
		}//for-i
		System.out.println(max);
	}

}
