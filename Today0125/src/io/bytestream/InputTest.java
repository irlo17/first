package io.bytestream;

/*
	InputStream을 구현한 FileInputStream을 이용한 예
	
	*int read()
		- 한 바이트를 읽고 이를 0~255 사이의 값을 리턴하지만 4byte의 int형으로 리턴
		- 리턴되는 값은 0~255 부호 없는 바이트지만 형변환 과정에서 -128 ~ 127의 부호 있는 바이트가 된다
		
		- 데이터를 읽어들이기 전까지 기다리므로 다음 부분을 실행할 수 없다
			-> 쓰레드 적용 필요
			
		- 더 이상 읽을 바이트가 없으면 -1 리턴
		
	[참고]
		int i = b>=0 ? b : 256 + b;
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputTest {

	public static void main(String[] args) {

		try {

			FileInputStream fis = new FileInputStream("a.txt");

			while (true) { // 하나씩 넘어오니까 반복문으로 받아주기

				int data = fis.read(); // 넘어오는 자료 읽어주기(받아주기)

				if (data == -1) { // 파일이 다 넘어오면 -1이 나온다 -> End of File == -1
					break; // 다 넘어왔으면 break;
				} // if

				System.out.print((char)data);	// int형으로 받았으니까 char 캐스팅
												//결과 ABCDEFGHIJKLMNOPQRSTUVWXYZ
			}
				fis.close();	//close()!필수!

		} catch	(FileNotFoundException ex) {
			System.out.println("읽으려는 파일이 존재하지 않습니다.");
				
		} catch (IOException ex) {
			System.out.println("파일 입출력시 예외 발생 : "+ex.getMessage());
		}
	}

}
