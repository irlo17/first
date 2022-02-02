package today0202;
/*
	[문제] n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
*/
import java.util.Scanner;

public class BaekJoon_for8393 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int total = 0;
		for(int i=1; i<=n; i++) {
			total += i;
		}
		System.out.println(total);
	}

}
