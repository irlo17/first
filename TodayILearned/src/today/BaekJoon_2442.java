package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2442 {
	
	// 별찍기
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int count=1; // 별 개수
		
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>i; j--) {
				System.out.print(" ");
			}//end of for-j (공백)
			for(int s=0; s<count; s++) {
				System.out.print("*");
			}//end of for-s (별찍기)
			count += 2;
			System.out.println();
		}//end of for-i
		
		
	}

}
