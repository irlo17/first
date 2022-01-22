package a_review;

/*
문제 : 8의 숫자 세기
1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?
8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
(※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 합니다)
결과 : 4000
*/
public class Eight_Count {

	public static void main(String[] args) {
		System.out.println("1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?");
		int total = 0; //8이 나올 때마다 숫자가 하나씩 올라가는 변수 선언
			
		for(int i=1; i<=10000; i++) {
			int num = i;
			while (num != 0) {
				int na = num %10;
				if(na==8) {
					total++;
				}//if - (na==8)
				num = num / 10; 
			}//while - (num != 0)
			}//for - i
				System.out.println("답 : "+total+"번");
	}//method - main

}
