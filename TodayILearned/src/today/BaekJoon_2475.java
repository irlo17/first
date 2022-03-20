package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2475 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		/*
		 *	고유번호 6자리
		 *		1~5번째 자리 : 00000~99999
		 *		6번째 자리(검증수) : 앞에 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지
		*/
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;	// 제곱한 수의 합
		
		for(int i=0; i<5; i++) {
			sum += Math.pow(Integer.valueOf(st.nextToken()), 2);	// 각각의 수를 제곱해서 합하기
		}//end of for-i
		
		System.out.println(sum%10);	// 검증수 출력
		
	}//end of main()
}//end of class
