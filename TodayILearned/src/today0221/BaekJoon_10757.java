package today0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BaekJoon_10757 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		/*
			long보다 더 큰 범위의 숫자는 BigInteger 사용 -> 문자열이다
			
			*사칙연산 불가능
			- 더하기 	-> add()
			- 빼기 	-> subtract()
			- 곱셈 	-> multiply()
			- 나눗셈 	-> divide()
			- 나머지 	-> remainder()
			
			*형변환
			.intValue()
			.toString() 등을 사용
			
			*두 수 비교 -> a.compareTo(b)
		*/
		System.out.println(a.add(b));
	}//main()
}//class
