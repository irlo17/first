package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2875 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 2명의 여학생과 1명의 남학생이 팀을 결성해서 나가는 것이 원칙
		
		int n = Integer.valueOf(st.nextToken());	// 여학생의 수
		int m = Integer.valueOf(st.nextToken());	// 남학생의 수
		int k = Integer.valueOf(st.nextToken());	// 인턴쉽에 참여해야하는 인원 -> 대회에 참여하지 못함
		
		int team = 0; // 팀 
		
		while(n>=2 && m>=1 && n+m-3>=k) {
			n -= 2;
			m -= 1;
			team++;
		}
		
		System.out.println(team);
		
	}

}
