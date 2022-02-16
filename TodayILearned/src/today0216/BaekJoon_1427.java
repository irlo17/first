package today0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BaekJoon_1427 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<str.length(); i++) {
			arr.add(Integer.valueOf((str.charAt(i)-'0')));
		}//for
		
		Collections.sort(arr, Collections.reverseOrder());
		
		for(int a : arr) {
			sb.append(a);
		}//for
		System.out.print(sb);
		
	}//main()
}//class
