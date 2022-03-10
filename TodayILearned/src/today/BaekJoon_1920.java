package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1920 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine()); // n개

		/* (시간 초과)
		ArrayList<Integer> A = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			A.add(Integer.valueOf(st.nextToken()));
		} // n개의 정수를 배열 A에 넣기
		
		//배열 정렬
		
		int m = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.valueOf(st.nextToken());
			
			// 배열 A의 숫자 중에 num과 중복된 수가 있으면 1를 출력, 아니면 0을 출력
			if (Collections.frequency(A, num) >= 1) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			
		} // m개의 정수
		*/
		
		int A[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.valueOf(st.nextToken());
		}
		
		//배열은 반드시 정렬되어 있어야함
		Arrays.sort(A);
		
		int m = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			
			//찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력
			if(test(A,Integer.valueOf(st.nextToken())) >=0) {
				sb.append(1).append('\n');
			}else {
				sb.append(0).append('\n');
			}//if
		}//for
		System.out.println(sb);
		
		

	}// main()

	/*
	 * 이분 탐색법 (https://st-lab.tistory.com/261) 1) 중간 인덱스를 구한다. 2) 중간값과 num값을 비교한다.
	 * 3) 비교값에 따라 범위를 왼쪽, 오른쪽 혹은 값이 같은 경우는 해당 인덱스를 반환한다.
	 */

	/**
	 * @param A   (배열)
	 * @param num (배열의 값과 중복되는지 확인하는 값)
	 * @return
	 */
	public static int test(int[] A, int num) {
		int lo = 0; // 탐색 범위의 왼쪽 끝 인덱스
		int hi = A.length - 1; // 탐색 범위의 오른쪽 끝 인덱스 (0~배열의 끝이므로 -1을 해준다)

		// 왼쪽 끝과 오른쪽 끝이 같은 경우까지 탐색 -> lo <= hi 까지 반복
		while (lo <= hi) {

			// 1) 중간 인덱스 구하기
			int mid = (lo + hi) / 2;

			if (num < A[mid]) {
				// 2) num값이 중간 인덱스 값보다 작은 경우
				hi = mid - 1;

			} else if (num > A[mid]) {
				// num값이 중간 인덱스 값보다 클 경우
				lo = mid + 1;

			} else {
				// num값과 중간 인덱스 값이 같을 경우
				return mid;

			} // if
		} // while

		// 찾고자 하는 값이 존재하지 않는 경우
		return -1;

	}

}
