package io.bytestream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
	OuputStream을 구현한 FileOutputStream을 이용한 예제
	
	*write ( int )
		- 0~255 사이의 정수를 인자로 받아 해당하는 바이트를 출력스트림에 쓴다
		- 인자로 정수형을 받지만, 실제로는 부호 없는 바이트로 전송
			(자바에서 정수형은 32bit이지만 그 중 8bit만 사용)
	
*/
public class OutputTest {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("a.txt");	//파일에다가 저장하는 통로 - 이름과 같은 파일이 생성됨
			
			for(int ch = 'A'; ch<='Z'; ch++) {	//0~9까지로 바꾸면 결과가 이상하게 나옴 - int는 java의 개념이기 때문
				
				fos.write(ch); 	//통로를 26번 지나간다 -> 비효율적 
				
			}//for-ch
			
			fos.close(); 	//close() 잊지말기!
			
		}catch(	IOException ex) {
			System.out.println("파일 전송 실패 : "+ex.toString()); 		//ex.toString() 예외의 내용이 나온다
		}//try~catch
		
	}//main

}//class
