package today0303;
/*
	[ 재귀 함수 ]
		- 특정 함수 내에서 자기 자신을 다시 호출하여 문제를 해결해나가는 함수
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_10872 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(function(Integer.valueOf(br.readLine())));
	}//main()
	public static int function(int num) {
		
		//재귀 종료조건이 있어야 한다.
		if(num <= 1) {
			return 1;
		}//if
		return num * function(num-1);
	}//function()
}//class
