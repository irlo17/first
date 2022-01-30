package today0130;

import java.util.Scanner;

/*
	[문제] 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
	첫째 줄에 다음 세 가지 중 하나를 출력한다.

	A가 B보다 큰 경우에는 '>'를 출력한다.
	A가 B보다 작은 경우에는 '<'를 출력한다.
	A와 B가 같은 경우에는 '=='를 출력한다.
	
	[제한]-10,000 ≤ A, B ≤ 10,000
*/
public class BaekJoon_If1330 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();
		
		if(a>b) System.out.println(">");
		else if(a==b)System.out.println("==");
		else System.out.println("<");
	}

}
