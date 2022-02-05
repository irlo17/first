package today0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	[문제]세 개의 자연수 A, B, C가 주어질 때
	A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
	첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.
	째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다. 
	마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 
	각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
*/
public class BaekJoon_Arr2577 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine())*Integer.valueOf(br.readLine())*Integer.valueOf(br.readLine());
		String str = String.valueOf(n);
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<str.length(); j++) {
				if(i==(str.charAt(j)-'0')) {
					arr[i]++;
				}//if
			}//for-j
		}//for-i
		for(int j : arr) {
		System.out.println(j);
		}//for-j
	}//main()
}//class
