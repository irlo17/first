package today0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	[문제] 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
		알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
		입력으로 주어진 글자의 아스키 코드 값을 출력한다.
*/
public class BaekJoon_String11654 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char c = br.readLine().charAt(0);
		int a = Integer.valueOf(c);
		System.out.println(a);
		
		br.close();
	}//main()
}//class