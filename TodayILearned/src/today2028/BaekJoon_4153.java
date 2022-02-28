package today2028;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_4153 { 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean stop = false;
		int[] abc = new int[3];
		while(!stop) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			abc[0] = Integer.valueOf(st.nextToken());
			abc[1] = Integer.valueOf(st.nextToken());
			abc[2] = Integer.valueOf(st.nextToken());
				
			Arrays.sort(abc);
			
			if(abc[0]!=0 & abc[1]!=0 & abc[2]!=0) {
				double diagonal = Math.pow(abc[2], 2);
				
				if(diagonal == Math.pow(abc[0], 2) + Math.pow(abc[1], 2)) {
					System.out.println("right");
				}else {
					System.out.println("wrong");
				}//if
				
			}else {
				stop = true;
			}//if
		}//while
	}//main()
}//class
