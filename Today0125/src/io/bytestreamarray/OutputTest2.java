package io.bytestreamarray;

import java.io.FileOutputStream;
import java.io.IOException;

/*
	<OuputStream을 구현한 FileOutputStream을 이용한 예제>
	
		* write ( int data )
	 		- 한 번에 한 바이트(8bit) 정도는 비효율
	 	
	 		- 데이터 전송 시 TCP 프로토콜을 주로 사용하는데, 이더넷 카드에서
	 	  		외부로 나가는 모든 TCP 세그먼트에는 라우팅, 에러 정정의 위한
	 	  		헤더 정보가 40byte 정도 붙는다
	 	  
 	  	* write ( byte[] data )
 	  		- 한 바이트씩 보다는 배열을 한 번에 전송하는 것이 효율적
 	  	
 		* write( byte[] data, int offset, int length )
*/
public class OutputTest2 {

	public static void main(String[] args) {

		
			
		try(	FileOutputStream fos = new FileOutputStream("b.txt");	){
			
			
			int numCount = 10;
			int charCount = 26;
			int i=0;
			byte[] data = new byte[numCount + charCount];	//36개의 배열
			
			for(i=0; i<numCount; i++) {
				data[i] = (byte)i;	//0~9는 글자가 깨져서 나온다
			}//for-numCount
			for(int ch ='A'; ch<='Z'; ch++, i++) {
				data[i] = (byte)ch;	//A~Z
			}//for-charCount
			
			fos.write(data);	//배열에 다 담은 다음 한 번에 보낸다 - 효율적

			fos.close();
		} catch (IOException ex) {
			System.out.println("파일전송 실패 : " + ex.toString());
		} // try~catch

	}// main

}// class
