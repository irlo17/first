package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_16486 {

	// 운동장 한 바퀴 둘레의 길이 구하기
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d1 = Integer.valueOf(br.readLine());	// c의 가로의 길이
		int d2 = Integer.valueOf(br.readLine());	// a와 b의 반지름의 길이
		
		double pi = 3.141592;	//이 문제에서는 π (원주율)의 값을 3.141592라고 한다.
		System.out.println(d1*2.0 + d2*2*pi);
		
	}

}
