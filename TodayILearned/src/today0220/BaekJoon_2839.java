package today0220;
/*
	[문제] 3킬로그램 봉지와 5킬로그램 봉지가 있다. 최대한 적은 봉지로 정확히 n킬로그램을 배달해야 한다.
			봉지의 개수를 구하는 프로그램을 작성하라.
			단 정확하게 n킬로그램을 만들 수 없다면 -1을 출력한다
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2839 {

	public static void main(String[] args) throws Exception{
		int n = Integer.valueOf((new BufferedReader(new InputStreamReader(System.in))).readLine());
		
		if(n==4 | n ==7) {
			System.out.println(-1);
		}else if(n%5==0) {
			System.out.println(n/5);
		}else if(n%5==3 | n%5==1) {
			System.out.println(n/5+1);
		}else if(n%5==2 | n%5==4){
			System.out.println(n/5+2);
		}else {
			System.out.println(-1);
		}//if
		
	}//main()
}//class
