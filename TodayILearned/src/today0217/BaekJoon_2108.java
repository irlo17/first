package today0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//https://st-lab.tistory.com/108 최빈값 구하기...
public class BaekJoon_2108 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		int sum = 0;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<t; i++) {
			int a = Integer.valueOf(br.readLine());
			sum += a;
			arr.add(a);
		}//입력받은 수 배열에 넣기
		System.out.println(Math.round((double)sum/t)); // 산술평균
		Collections.sort(arr);
		
		boolean m = false;
		int mode_max = 0;
		int mode = 10000;
		for(int i=0; i<t; i++) {
			int jump = 0;
			int count = 1;
			int arr_i = arr.get(i);
			
			for(int j=i+1; j<t; j++) {
				if(arr_i != arr.get(j)) {
					break;
				}
				count++;
				jump++;
			}//for-j
			if(count > mode_max) {
				mode_max = count;
				mode = arr_i;
				m = true;
			}else if(count == mode_max & m==true){
				mode = arr_i;
				m = false;
			}
			i += jump;
		}
		
		

		
		System.out.println(arr.get((t/2))); //중앙값
		System.out.println(mode);//최빈값 중 두 번째로 작은 값을 출력한다.
		System.out.println(arr.get(t-1)-arr.get(0)); //최댓값 - 최솟값
		
	}//main()
}//class
