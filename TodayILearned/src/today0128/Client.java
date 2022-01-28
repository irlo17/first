package today0128;
//network2.thread

import java.io.*;
import java.net.*;

public class Client {
	public final static int PORT = 3333;
	static int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static int b[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	public static void main(String[] args) {
		Socket c1 = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		// 서버로부터 얻어온 결과를 넣을 배열 초기화
		int result[] = new int[10];

		try {
			// 소켓 객체 생성
			c1 = new Socket("127.0.0.1", PORT);

			// 입력 스트림 객체 생성
			dis = new DataInputStream(c1.getInputStream());

			// 출력 스트림 객체 생성
			dos = new DataOutputStream(c1.getOutputStream());
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		} // t~c

		try {
			// 1. a 배열을 서버에 전송 -> 배열이니까 for문을 이용
			for (int i = 0; i < a.length; i++) {
				dos.writeInt(a[i]);
			} // for->a[i]

			// 2. b 배열을 서버에 전송
			for (int i = 0; i < b.length; i++) {
				dos.writeInt(b[i]);
			} // for->b[i]

		} catch (Exception ex) {
			System.out.println("error writing to server.." + ex);
		} // t~c

		try {
			// 서버에서 읽어와서 result 배열에 저장
			for (int i = 0; i < result.length; i++) {
				result[i] = a[i] + b[i];
			} // for-result[i]
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// 결과를 화면에 출력
		System.out.println("The sum of the two arrays : ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		} // for-result[i]

		try {
			// 소켓, 입출력 스트림 닫기
			c1.close();
			dis.close();
			dos.close();

		} catch (Exception ex) {
			System.out.println("Error close.... " + ex);
		} // t~c

	}// main
}// class Client
