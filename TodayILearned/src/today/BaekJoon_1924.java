package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1924 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 2007년 1월 1일 월요일
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.valueOf(st.nextToken());	// x월
		int y = Integer.valueOf(st.nextToken());	// y일
		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String day[] = { "SUN","MON","TUE","WED","THU","FRI","SAT"};
		int total = 0;
		
		for(int i=0; i<x; i++) {
			total += month[i];	// x월의 전달까지 날짜를 합한다
		}//for
		total += y;
		System.out.println(day[(total%7)]);	//x월 y일 요일 구하기
		br.close();
	}

}
