package today0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	[문제]자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
*/
public class BaekJoon_for2741 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.valueOf(br.readLine());
			br.close();
			for(int i=1; i<=n; i++) {
				System.out.println(i);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}//t~c
	}//main()
}//class
