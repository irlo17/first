package today0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 입력받은 값 오름차순 정렬 -> 2750번보다 범위가 크기 때문에 Arrays.sort()는 시간 초과
public class BaekJoon_2751 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.valueOf(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<t; i++) {
			arr.add(Integer.valueOf(br.readLine()));
		}
		
		Collections.sort(arr);
		
		for(int a : arr) {
			sb.append(a).append('\n');
		}
		System.out.println(sb);
		br.close();
	}//main()
}//class
