package today0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2869 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken()); //낮에 달팽이 올라간 거리
		int b = Integer.valueOf(st.nextToken()); //밤에 떨러진 거리
		int v = Integer.valueOf(st.nextToken()); //나무의 총 길이
		
		if(((v-b)%(a-b)) == 0) {
			System.out.println((v-b)/(a-b));
		}else {
			System.out.println((v-b)/(a-b)+1);
		}
		
	}//main()
}//class
