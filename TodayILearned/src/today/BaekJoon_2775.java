package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2775 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		
		int[][] sum = new int[15][15]; //[0층~14층][1호~14호]
		for(int i=0; i<15; i++) {
			sum[0][i] = i; //0층 i호는 i명이 산다
			sum[i][1] = 1; // 0~14층 의 1호는 다 1명이 산다
		}//for-i
		
		/*
			1층 2호 = 1층 1호 + 0층 2호 
			1층 3호 = 1층 2호 + 0층 3호
			
			k=1층부터 n은 2호부터 시작 ( n=0일 때는 고려하지 않음 n=1은 1호 )
		*/
		
		for(int i=1; i<15; i++) {
			for(int j=2; j<15; j++) {
				sum[i][j] = sum[i][j-1] + sum[i-1][j];
			}//for-j
		}//for-i
		
		for(int i=0; i<t; i++) {
			int k = Integer.valueOf(br.readLine());
			int n = Integer.valueOf(br.readLine());
			System.out.println(sum[k][n]);
		}//for
	}//main()
}//class
