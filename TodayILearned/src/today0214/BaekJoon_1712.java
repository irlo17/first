package today0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1712 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.valueOf(st.nextToken()); //고정 비용
		int b = Integer.valueOf(st.nextToken()); //가변 비용
		int c = Integer.valueOf(st.nextToken()); //노트북 가격
		
		//손익분기점 찾기
		if(c<=b) {
			System.out.println("-1");
		}else {
			int x = a / (c-b);
			System.out.println(x+1);
		}//if
		br.close();
	}//main()
}//class
