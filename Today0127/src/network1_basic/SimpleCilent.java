package network1_basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleCilent {
	public final static int PORT = 5000; //상수 PORT와 HOST 선언 -> 여기로 서버와 연결됨
	public final static String HOST = "127.0.0.1";
	
	public static void main(String[] args) {
		
		//초기화
		Socket cilent = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		
		//콘솔 입력을 받기 위해
		Scanner input = new Scanner(System.in);
		
		try{
			
		// 1. 서버에 연결하기 위해 소켓 생성
			cilent = new Socket("127.0.0.1", PORT);
			
		// 2. 소켓의 입출력 스트림 얻기
			in = new DataInputStream(cilent.getInputStream());
			out = new DataOutputStream(cilent.getOutputStream());
		
		// 3. 키보드 입력 받아 서버에 전송
			System.out.print("뽀로로 (나) -> ");
			String msg = input.nextLine();
			out.writeUTF(msg);
			
		// 4. 서버로부터 응답을 받음
			String result = in.readUTF(); //응답을 받을 변수 선언 잊지말기
			System.out.println("펭수 (짝꿍) -> "+result);
			
		// 5. 입출력 스트림 닫음
			in.close();
			out.close();
			cilent.close();
			
		}catch(Exception ex){
			System.out.println("Error writing -> " +ex);
		}//t~c
		
	}//main
}//class-SimpleCilent
