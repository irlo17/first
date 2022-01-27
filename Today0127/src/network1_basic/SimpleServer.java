package network1_basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public final static int PORT = 5000;

	public static void main(String[] args) {

		ServerSocket server = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		Socket cilentSocket = null;

		try {
			// 1. 서버 소켓 생성
			server = new ServerSocket(PORT);
			System.out.println("SimpleServer started");

			// 2. 클라이언트 접속시에 소켓 생성 ( 클라이언트가 오기 전까지 블록 상태)
			// accept() -> 연결 요청이 들어왔을 때 요청을 받아들림
			cilentSocket = server.accept();

			// 3. 소켓의 입출력 스트림 얻기
			in = new DataInputStream(cilentSocket.getInputStream());
			out = new DataOutputStream(cilentSocket.getOutputStream());

			// 4. 데이터 전송
			String line = in.readUTF();
			System.out.println("뽀로로 (짝꿍) -> " + line); // we received
			if (line.compareTo("안녕") == 0) { // line.equals("안녕");
				out.writeUTF("안녕! 노는게 제일 좋아?");
			} else {
				out.writeUTF("인사말이 아닙니다...");
			} // if

			// 5. 소켓닫기
			in.close();
			out.close();
			cilentSocket.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} // t~c

	}//main
}//SimpleServer
