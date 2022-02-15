package today0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BaekJoon_2750 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		int[] arr = new int[t];
		
		for(int i=0; i<t; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}//
		Arrays.sort(arr);
			
		for(int i=0; i<t; i++) {
			System.out.println(arr[i]);
		}
		
		br.close();
	}

}
