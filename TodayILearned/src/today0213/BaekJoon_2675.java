package today0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	[문제]문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 
	즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. 
	S에는 QR Code "alphanumeric" 문자만 들어있다.

	QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
	
	첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 
	문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 
*/
public class BaekJoon_2675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int a=0; a<t; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.valueOf(st.nextToken());
			String s = st.nextToken();
			for(int b=0; b<s.length(); b++) {
				for(int c=0; c<r; c++) {
					sb.append(s.charAt(b));
				}//for-c
			}//for-b
			System.out.println(sb);
			sb.setLength(0); //sb의 값 삭제
		}//for-a
	}//main()
}//class
