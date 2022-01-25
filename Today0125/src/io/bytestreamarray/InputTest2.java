package io.bytestreamarray;

import java.io.FileInputStream;
import java.io.IOException;

/*
	<InputStream을 구현한 FileInputStream을 이용한 예>
	
		*int read ( byte[] data )
			- 한 번에 한 바이트만 읽는 것이 비효율적이기 때문에 여러 개의 바이트를 읽음
			- 읽는 바이트 수를 리턴
			
			- 더 이상 읽을 바이트가 없으면 -1 리턴
				( -1은 배열에 저장되지 않는다 )
				
		*int read( byte[] data, int offset, int length )
		
		[ 참고 ] 주의할 점
			- 네트워크에서 1024 바이트를 읽으려고 시도했지만 실제로 512 바이트만 읽고 
				나머지는 수신 중인 경우, 나중에 모두 도착하겠지만, 현재는 사용할 수 없는 데이터가 된다
				
			int read = 0;
			int bytesToRead = 1024;
			byte[] data = new byte[ bytesToRead ];
			while ( read < bytesToRead ) {
				
				read += in.read( data, read, bytesToRead - read );	
			}//while
			
			- 스트림이 닫히지 않았지만 읽을 데이터가 없으면 -1이 아니라 0을 리턴한다
				( 이런 경우 프로그램은 실행되지 않고 블럭 된다 )
				
		[ 참고 ] available()
			- 읽을 수 있는 바이트 수를 리턴하여 읽을 수 있는 바이트가 준비되지 않았을 때,
				읽기를 멈추고 싶을 경우에 사용한다
			
			- read( byte[] data, int offset, int length )에서 length가 0이면
				스트럼의 끝을 모르기 때문에 -1이 아닌 0을 리턴하므로 이런 경우에 사용한다
*/

public class InputTest2 {

	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("b.txt")){
			
			byte[] result = new byte[1024];	
			
			int cnt = fis.read(result);	//***변수로 받지 않고 인자로 넣는다***
										//읽어서 저장할 변수를 인자로 넣으면 읽는다 - 단 한 번 읽음
			fis.close();
			
			for(int i=0; i<cnt; i++) {
				
				if(i<10) {
					System.out.print(result[i]);
				}else {
					System.out.print((char)result[i]);	//알파벳으로 바꾸기 위해 캐스팅
				
				}//if	결과 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ
				
			}//for-i
			
		}catch(IOException ex) {
			
		}//try~catch
	}

}
