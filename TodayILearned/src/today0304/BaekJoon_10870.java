package today0304;
/*
 * 	재귀함수
	피보나치 수 : 0과 1로 시작
	Fn = Fn-1 + Fn-2 (n ≥ 2)
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_10870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		System.out.println(function(n));
	}//main()
	
	public static int function(int n) {
		
		if(n==0 | n==1) return n;
		
		return function(n-2) + function(n-1);
		
	}//function()
}//class
