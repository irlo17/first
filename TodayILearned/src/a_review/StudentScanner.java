package a_review;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentScanner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("학생 수를 입력하세요 -> ");
		int students = input.nextInt(); 
/*
		[1] 입력한 학생 수와 학생의 점수(국,영,수)를 대입할 2차원 배열 선언
		
			학생수는 달라지지만 과목의 수는 정해져 있기 때문에 
			행은 students 열은 3으로 길이를 정함
		
*/
		
		int[][] score = new int[students][3];
		String[] subject = {"국어", "영어", "수학"};
	
		int i, j=0;		//for문에서 i는 행 j는 열 ->score[i][j]
		String n = null; //입력받을 점수 문자열 변수 초기화
		
		
		
/*
		
		[3] 입력받은 문자열 점수를 쪼개서 배열에 집어넣기
		
		[3-1] StringTokenizer 생성자
				- StringTokenizer(String str) 
				 	-> 띄어쓰기 기준으로 문자열을 분리
				
				- StringTokenizer(String str, String delim)
					-> 구분자(delim)를 기준으로 문자열을 분리
					
				- StringTokenizer(String str, String delim, boolean returnDelims)
					-> 구분자를 기준으로 문자열을 분리할 때 
						- 구분자도 토근으로 포함O(true)
						- 구분자도 토근으로 포함X(false) - 디폴트
					
		[3-2] String nextToken()
				- StringTokenizer에서 다음 토큰을 리턴한다
				
		[3-3] boolean hasMoreToken()
				- StringTokenizer에서 사용할 수 있는 토큰이 있는지 확인하는 메소드
				- 토큰이 존재하면 true, 존재하지 않는다면 false를 리턴한다
*/		
	
		
		// [2] 학생 수 만큼 따라 점수 입력받기 
		for(i=0; i<score.length; i++) {		
			System.out.print((i+1)+"번째 학생의 성적을 입력하세요.(국어/수학/영어) -> ");
			n = input.next();
			
			for(j=0; j<score[i].length; j++) {	//과목 수만큼 반복
				
				StringTokenizer sco = new StringTokenizer(n, "/"); // "/"을 기준으로 단어 쪼개기
				
				score[i][j] = Integer.parseInt(sco.nextToken());
			}//for-j
			
		}//for-i
		
		while(true) {
		
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("1.각 학생들의 총점과 평균/ 2.과목 별 총점과 평균 / 3. 종료");
		System.out.println();
		System.out.print("원하시는 결과의 숫자를 입력하세요 -> ");
		int num = input.nextInt();
		
		//총점과 평균 배열 변수 선언
		int[] total;
		double[] avg;
		
		switch(num) {
		case 1 :
			
			total = new int[students];
			avg = new double[students];
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println("[결과 1]"); // 각 학생들의 총점과 평균 구하기
			
			for(i=0; i<score.length; i++) {
				
				for(j=0; j<score[i].length; j++) {
					
					total[i] += score[i][j];	
					
					avg[i] = total[i]/3.;
					
				}//for-j
				System.out.println((i+1)+"번째 학생의 총점은 "+total[i]+"이고 평균은 "+avg[i]+"입니다.");
				
			}//for-i
			
			System.out.println();
			break;
			
		case 2 :
			
			total = new int[3]; 
			avg = new double[3];
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println("[결과 2]"); //과목 별로 총점과 평균 구하기
			
			
			for(j=0; j<3; j++) { //과목 별로 점수를 구하기 위해 for-j 안에 for-i를 작성
				
				for(i=0; i<students; i++) {
					
					total[j] += score[i][j];		
					avg[j] = total[j] / students*1.;
					
					
				}//for-i
				
				System.out.println(subject[j]+"과목 총점은 "+total[j]+"이고 평균은 "+avg[j]+"입니다.");
				System.out.println();
				
			}//for-j
			
				System.out.println();
				break;
				
		case 3  : break;
			
		}//switch
		
		System.out.print("다른 결과도 확인하시겠습니까?(Y or N) -> ");
		n = input.next();
		
		if(n.equals("Y") || n.equals("y")) { continue;}
		if(n.equals("N") || n.equals("n")) { System.out.println("종료되었습니다"); break;  }
		
	
		}//while
	}

}
