package today0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2588 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.valueOf(br.readLine());
		String b =br.readLine();
		
		int b3 = Integer.valueOf(b.charAt(2))-'0';
		int b2 = Integer.valueOf(b.charAt(1))-'0';
		int b1 = Integer.valueOf(b.charAt(0))-'0';

		System.out.println(a*b3);
		System.out.println(a*b2);
		System.out.println(a*b1);
		System.out.println(a*Integer.valueOf(b));
		
		br.close();
	}
}
