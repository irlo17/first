package z_info;

import java.util.Calendar;
import java.util.Scanner;

public class testyear {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("주민번호 입력");
		String id = input.next();
		
		String a = id.substring(8, 10);
		int aa = Integer.parseInt(a); 
		if(aa<=8) {		System.out.println("서울특별시");} 
		else if(aa<=12) {System.out.println("부산광역시");}
		else if(aa<=15){System.out.println("인천광역시");}
		else if(aa<=25){System.out.println("경기도");}
		
		else if(aa<=34){System.out.println("강원도");}
		else if(aa<=39){System.out.println("충천북도");}
		else if(aa<=41){System.out.println("대전광역시");}
		else {System.out.println("그 외 지역");}
	
		
		System.out.println("서울특별시");
		
	}

}
