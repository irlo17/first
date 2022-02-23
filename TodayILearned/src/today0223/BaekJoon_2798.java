package today0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2798 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		int[] arr = new int[n];
		int sum = 0;
		int max = 0;
		
			st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}//for-n장의 카드를 배열에 넣기
		
		for(int a=0; a<n-2; a++) {
			for(int b=a+1; b<n-1; b++) {
				for(int c=b+1; c<n; c++) {
					sum = arr[a] + arr[b] + arr[c];
					if(sum<=m && sum>max) {
						max = sum;
					}//if
				}//for-c
			}//for-b
		}//for-a
		
		System.out.println(max);
	}//main()
}//class
