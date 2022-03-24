package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_10886 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int count = 0;
		for(int i=0; i<n; i++) {
			if(Integer.valueOf(br.readLine()) == 1) {
				count++; 	// 준희가 귀엽다
			}else {
				count--;	//	준희가 안귀엽다
			}
		}
		
		if(count>0) {
			System.out.println("Junhee is cute!");
		}else {
			System.out.println("Junhee is not cute!");
		}
	}

}
