package today;

/*
	6층 1~12호 10번째 손님 => 10%6층
	30층 1~50호 72번째 손님 => 72%30층
	
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_10250 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.valueOf(st.nextToken()); //h층
			int w = Integer.valueOf(st.nextToken()); //w호
			int n = Integer.valueOf(st.nextToken()); //n번째 손님
			
			int x,y = 0;
			if(n%h == 0) {
				y = h;
				x = n/h;
			}else {
				y = n%h; 
				x = (n/h+1);
			}
			
			if(x<10) {
				System.out.println(y+"0"+x);
			}else {
				System.out.println(y+""+x);
			}//if
		}//for-i
	}//main()
}//class
