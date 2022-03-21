package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2502 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.valueOf(st.nextToken());	//	할머니가 넘어온 날
		int K = Integer.valueOf(st.nextToken());	//	D일에 호랑이에게 떡을 준 개수
		
		int arr[] = new int[D];
		/*
		 
		 *	1일 	K = 2 = A = arr[0]
		 *	2일	K = 7 = B = arr[1]
		 *	3일 	K = 9 = A + B
		 *	4일 	K = 16 = ( A + B ) + B = A + 2*B
		 *	5일 	K = 25 =  (( A + B ) + B) + (A + B) = 2*A + 3*B
		 *	6일 	K = 41 =  ((( A + B ) + B) + (A + B)) + (( A + B ) + B) = 3*A + 5*B
		 *
		 *	1부터 다 찾아보기...?	
		*/
		
		for(int i=1; i<K; i++) {
			for(int j=i+1; j<K; j++) {
				arr[0] = i;
				arr[1] = j;
				
				for(int k=2; k<D; k++) {
					arr[k] = arr[k-2] + arr[k-1];
				}//end of for-k
				if(arr[D-1] == K) {
					System.out.println(arr[0]);
					System.out.println(arr[1]);
					System.exit(0);
				}
			}//end of for-j
		}//end of for-i
	}//end of main()
}
