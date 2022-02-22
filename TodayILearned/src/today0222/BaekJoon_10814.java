package today0222;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon_10814 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		StringTokenizer st = null;
		String[][] str = new String[t][2];
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			str[i][0] = st.nextToken();
			str[i][1] = st.nextToken();
		}//for-i 값 넣기
		
		//2차원 배열 정렬하기 - Arrays.sort(arr, Comparator)
		Arrays.sort(str, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				 return Integer.valueOf(o1[0]) - Integer.valueOf(o2[0]);
			}
		});
		
		for(int i=0; i<t; i++) {
				System.out.println(str[i][0] + ' ' + str[i][1]);
		}//for-i
		
	}//main()
}//class