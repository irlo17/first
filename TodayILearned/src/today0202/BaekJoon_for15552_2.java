package today0202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
	[문제]
	Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다. 
	BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
	
	첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다.
	다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.
	
	각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
	
	[풀이참고] https://st-lab.tistory.com/30
*/
public class BaekJoon_for15552_2 {

	public static void main(String[] args) {
		try {//예외처리 필수
			//콘솔에 입력을 받을 경우
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
/*
			파일에서 입력 받을 경우
		FileReader fr = new FileReader("파일이름")	;
		BufferedReader br1 = new BufferedReader(fr);
*/
		//String이 리턴값이기 때문에 형변환이 필수 -> 라인단위이다
			int t = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			
			for(int i=0; i<t; i++) {
				st = new StringTokenizer(br.readLine()," ");
				bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+"\n");
			}
			br.close();
			bw.flush();//버퍼를 비운다.
			bw.close();
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}//main()
}//class
