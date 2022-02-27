package today0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1085 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.valueOf(st.nextToken());
		int y = Integer.valueOf(st.nextToken()); //(x,y) 현재 위치
		
		int w = Integer.valueOf(st.nextToken());
		int h = Integer.valueOf(st.nextToken()); //(w,h) 직사각형
		
		int min = Math.min(x,y);
		
		if(min>Math.min(w-x, h-y)) {
			min = Math.min(w-x, h-y);
		}//if
		
		System.out.println(min);
	}//main()
}//class
