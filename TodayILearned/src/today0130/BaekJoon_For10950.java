package today0130;
import java.util.Scanner;
/*
	[문제] 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	
	첫째 줄에 테스트 케이스의 개수 T가 주어진다.

	각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
	
	예제 입력				예제 출력
	5					
	1 1					2
	2 3					5
	3 4					7
	9 8					17
	5 2					7
*/
public class BaekJoon_For10950 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int t = input.nextInt();
		
		int[] a = new int[t];
		int[] b = new int[t];
		
		for(int i = 0; i<t; i++) {
			a[i] = input.nextInt();
			b[i] = input.nextInt();
		}//for-i 정수 A와 B 입력받기
		
		int[] result = new int[t];
		for(int i=0; i<t; i++) {
			result[i] = a[i] + b[i];
			System.out.println(result[i]);
		}//for-i  A+B 결과 출력하기 
		input.close();
	}//main
}//class
