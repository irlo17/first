package today;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon_9655 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());	//돌의 개수
		
		/*
		 * 상근이부터 턴 시작 - 한 번에 돌은 1개 또는 3개 기져갈 수 있다
		 *  n=1 -> SK
		 *  n=2 -> CY
		 *  n=3 -> SK
		 *  n=4 -> CY
		 *  n=5 -> SK
		 *  ... 돌의 개수가 홀수일 때는 상근이가 이기고 짝수일 때는 창영이가 이김
		 */
		if(n%2==0) {
			bw.write("CY");
		}else {
			bw.write("SK");
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
