package today0203;

import java.util.Scanner;

/*
	[문제] 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
			하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
			
	첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
	
	첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
*/
public class BaekJoon_for2439 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			for (int b = n - 1; b > i; b--) {
				System.out.print(" ");
			}//for-b 공백 개수
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}//for-j 별 개수
			System.out.println();
		} // for-i
		in.close();
	}//main()
}//class
