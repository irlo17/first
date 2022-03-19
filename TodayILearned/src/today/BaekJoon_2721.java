package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2721 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());	// 테스트 케이스 개수
		for(int i=0; i<t; i++) {
			int n = Integer.valueOf(br.readLine());
			int sum = 0;
			
			/*
				T(n) = T(n) = 1 + ... + n (1부터 n까지의 합)
				W(n) = Sum[k=1..n; k*T(k+1)]
				
				n = 3
				T(2) = 1 + 2 = 3
				T(3) = 1 + 2 + 3 = 6
				T(4) = 1 + 2 + 3 + 4 = 10
				T(n) = n(n+1)/2
				
				W(3) = 1*T(2) + 2*T(3) + 3*T(4) = 3 + 12 + 30 = 45
			*/
			
			for(int j=1; j<=n; j++) {
				/*
					int s = j+1;
					sum += j*s*(s+1)/2;
				*/
				sum += j*(j+1)*(j+2)/2;
			}//end of for-j
			System.out.println(sum);
		}//end of for-i
	}//end of main()
	/*
	public static int T(int n) {
		
		int sum = 0;
		
		for(int i=1; i<=n; i++) {
			sum += i;
		}//end of for-i
		return sum;
	}//end of T()
	*/
}//end of class
