package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1292 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		
		int[] arr = new int[b+1];
		int count = 1;
		int sum = 0;
		for(int i=1; i<=b; i++) {
			for(int j=0; j<i; j++) {
				
				if( b < count) {
					break;
				}else {
					arr[count++] = i;
				}
			}//for-j
		}//for-i
		
		for(int i=a; i<=b; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
