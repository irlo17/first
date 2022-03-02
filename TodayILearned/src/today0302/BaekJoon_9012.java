package today0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_9012 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		
		
		for(int i=0; i<t; i++) {
			String str = br.readLine();
			System.out.println(test(str));
		}//for-i
	}//main()
	public static String test(String str) {
		int count = 0;
		for(int j=0; j<str.length(); j++) {
			char ch = str.charAt(j);
			
			if (ch == '(') {
				count++;
			}else if(count == 0) {
				return "NO";
			}else {
				count--;
			}
		
		}//for-j
		if(count==0) {
			return "YES";
		}else {
			return "NO";
		}//if
		
	}//test()
}//class
