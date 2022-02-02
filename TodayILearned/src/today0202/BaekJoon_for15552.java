package today0202;


/*
	[문제]
	Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다. 
	BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
	
	첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다.
	다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.
	
	각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
*/
import java.util.Scanner;
public class BaekJoon_for15552 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		int[] sum = new int[t];
		
		for(int i=0; i<t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			sum[i] = a + b;
		}//for-sum[i]
		in.close();
		for(int i=0; i<t; i++) {
			System.out.println(sum[i]);
		}//for-sum[i] 출력
	}//main()
}//class
