package today0128;

import java.io.*;
import java.net.*;

//network2.thread

public class Server extends Thread{	//독립적으로 반복문을 돌리기 위해

	public final static int PORT = 3333;
	protected ServerSocket listen;
	
	public Server() {
		try {
			listen = new ServerSocket(PORT);
			
		}catch(Exception ex) {
			System.out.println("Creating the ServerSocket.." + ex );
		}//t~c
	}//생성자
	
	public void run() {
		try {
			while(true) {
				Socket client = listen.accept(); //요청이 들어올 때마다 연결 상태를 새롭게 생성
				JuryThread cc = new JuryThread(client);
				System.out.println("클라이언트 입장 : "+ client);
				
			}//while
			
		}catch(IOException ex) {
			System.out.println("Creating the Socket.." +  ex );
		}//t~c
	}//run()
	
	public static void main(String[] args) {
		new Server();
		
	}//main
}//class-Server

class JuryThread extends Thread{
	Socket client;
	DataInputStream in;
	DataOutputStream out;
	
	public JuryThread(Socket s) {
		client  = s;
		try {
			//객체 생성
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());

		}catch(IOException ex) {
			
			try {
				client.close();
			}catch(IOException exc) {
				System.out.println("Error getting socket stream : " + exc);
			}//t~c -2
			return;
		}//t~c -1
		this.start();
	}//생성자

	public void run() {
		//클라이언트로부터 데이타를 읽어옴
		int[] a = new int[10];
		int[] b = new int[10];
		
		try {
			for(int i=0; i<a.length; i++) {
				a[i] = in.readInt();
			}//for-a[i]
			for(int i=0; i<b.length; i++) {
				b[i] = in.readInt();
			}//for-b[i]
			
		}catch(Exception ex) {
			ex.printStackTrace();	
		}//t~c
		
		
		//읽어 온 데이타를 계산
		int[] result = new int[10];
		for(int i=0; i<result.length; i++) {
			result[i] = a[i] + b[i];
		}//for-result[i]
		
		//게산 결과를 다시 클라이언트로 보냄
		try {
			for(int i=0; i<result.length; i++) {
				out.writeInt(result[i]);
			}//for-result[i]
			
		}catch(Exception ex) {
			ex.printStackTrace();	
		}//t~c
		
		
		try {
			in.close();
			out.close();
			client.close();
			
		}catch(Exception ex) {
			
		}//t~c
	}//run()
}//class - JuryThread
