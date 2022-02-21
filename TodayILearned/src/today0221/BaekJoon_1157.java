package today0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_1157 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase(); //입력받은 문자열 다 대문자로 바꾸기
		
		int[] arr = new int[26]; //많이 사용되는 문자를 찾기 위해 알파벳 개수만큼의 길이를 가진 배열 생성
		
		
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-'A']++;
		}//for-알파벳 중복 찾기
		
		int max = 0;
		char ch = ' ';
		
		for(int i=0; i<26; i++) {
			if(max == arr[i]) {
				ch = '?';
			}//가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력
			
			if(max<arr[i]) {
				max = arr[i];
				ch = (char) ((char)i + 'A');
			}//if - max를 찾아서 인덱스 번호와 'A'를 더해서 알파벳으로 표현
			
		}//최대값 인덱스 찾기
		
		System.out.println(ch);
	}//main()
}//class
