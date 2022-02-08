package today0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	[문제] N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
		첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
		입력으로 주어진 숫자 N개의 합을 출력한다.
*/
public class BaekJoon_String11720 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		
		int sum = 0;
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			sum += str.charAt(i)-'0'; //charAt()은 아스키코드 값을 반환 -> -48 또는 -'0'을 해줘야함 
		}
		System.out.println(sum);
		
		br.close();
	}//main()
}//class
