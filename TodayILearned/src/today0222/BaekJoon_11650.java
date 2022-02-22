package today0222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon_11650 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		StringTokenizer st = null;
		int[][] arr = new int[t][2];
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] =Integer.valueOf(st.nextToken());
			arr[i][1] =Integer.valueOf(st.nextToken());
		}//for-i 값 넣기
		
		//2차원 배열 정렬하기 - Arrays.sort(arr, Comparator)
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) { 
					return o1[1] - o2[1]; 
				}else { 
					return o1[0] - o2[0]; 
				}//if

			}
		});//Arrays
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			sb.append(arr[i][0] + " "+arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}//main()
}//class
