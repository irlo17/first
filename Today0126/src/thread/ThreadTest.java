package thread;
//[1] Thread 클래스 상속

public class ThreadTest {

	public static void main(String[] args) {
		MakeCar1 car1 = new MakeCar1("바퀴 만들기");
		// car1.run();  start() -> run() 호출
		car1.start();
		
		MakeCar1 car2 = new MakeCar1("엔진 부착");
		car2.start();
		
		System.out.println("프로그램 종료"); //위에 2개의 Thread가 호출되는 과정에서 먼저 실행됨
		
		//제어권이 총 3개

	}//main

}//class-ThreadTest


class MakeCar1 extends Thread{
	String work;
	
	MakeCar1(String work){
		this.work = work;
	}//생성자

	
	//Thread에 run() 오버라이딩
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(work+" 작업 중");
			
			try {
				Thread.sleep(500); 	//지정된 시간동안 현재 Thread를 일시 정지 -> 실행 대기 상태로 돌아감
								  	//예외 처리 필수!
			}catch(InterruptedException e) {	
				e.printStackTrace();
			}//t~c
		}//for-i
	}//run()
	
}//class-MakeCar1
