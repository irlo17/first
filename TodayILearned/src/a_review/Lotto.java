package a_review;

public class Lotto {

	public static void main(String[] args) {
		
		// [1] 1~45까지 랜덤의 수를 추출해서 대입하기
		int[][] lotto = new int[5][6];
		
		for(int i=0; i<lotto.length; i++) { //5세트
			
			for(int j=0; j<lotto[i].length; j++) {	//세트 당 6개의 숫자
				
			lotto[i][j] = (int)(Math.random()*45)+1; //1~45까지 랜덤의 수를 추출해서 대입
		// [2] 중복 검사하기
			for(int s=0; s<j; s++) {
				
				if(lotto[i][j] == lotto[i][s]) {	//중복 값이 나온다면 j--로 돌아가서 다시 뽑기
					j--;
					break;
				}//if
				
			}//for-s
			
			}//for-j 6개 숫자 뽑기
			
		}//for-i 5세트 나오게 뽑기
		
		// [3] 정렬하기 
		for(int i =0; i<lotto.length; i++) { //행의 길이만큼 반복
			 
			for(int j=0; j<lotto[i].length; j++) { //열의 길이만큼 반복
				
				for(int s=j+1; s<lotto[i].length; s++) { //s=j+1로 하여 j를 기준으로 나머지 인덱스 값 비교
					
					if(lotto[i][j] > lotto[i][s]) { //인덱스 값을 비교하여 큰 값을 뒤로 보낸다
						
						int num = lotto[i][s];
						lotto[i][s] = lotto[i][j];
						lotto[i][j] = num;
					
					}//if-오름차순 정렬
				
				}//for-s
			}//for-j
			
		}//for-i
		
		// [4] 로또 출력하기
		for(int i=0; i<lotto.length; i++) {
			
			for(int j=0; j<lotto[i].length; j++) {
			
				System.out.print(lotto[i][j] + ",");
			
			}//for - j
			
			System.out.println(); 
		
		}//for - i
	
	}//main

}//class
