package a_review;

import java.util.Scanner;

public class ForExample {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		System.out.println("1) 자연수 n을 입력하세요.");
		System.out.print("n = ");
		n = input.nextInt();
		for(int i=0; i<n; i++) {
			for(int b=1; b<n-i; b++) {
				System.out.print(" "+" ");
				}//for - b(blank)
			for(int j=0; j<=i; j++) {
					System.out.print((j+1)+" ");
				}//for - j 숫자 출력
			System.out.println(); //for -b,j는 이어서 출력 그다음 개행
		}//for - i 
		
//-------------------------------------------------------------------------------
		
		System.out.println("2) 자연수 n을 입력하세요.");
		System.out.print("n = ");
		n = input.nextInt();
		int num = 0; //숫자가 하나씩 증가하면서 출력됨
		for(int i=0; i<n; i++) {
			for(int b=0; b<i; b++) {
				System.out.print(" "+" ");
			}//for - b(blank)
			for(int j=0; j<n-i; j++) {
				num++;
				System.out.print(num + " ");
			}
			System.out.println();
		}//for - i
		
//-----------------------------------------------------------------------------
		System.out.println("3) 자연수 n(n<=6)을 입력하세요");
		System.out.print("n = ");
		n = input.nextInt();
		char ch = 'A';
		num = 0;
		for(int i=0; i<n; i++) {
			for(int c=0; c<n-i; c++) {
				System.out.print(ch+" ");
				ch++;
			}//for - c 알파벳 출력
			for(int j=0; j<i; j++) {
				System.out.print(num+" ");
				num++;
			}//for - j 숫자 출력 0부터 출력한다
			System.out.println();
		}//for - i
		input.close();
	}//method - main

}//class
