package thread;
//[2] Runnable 인터페이스
public class RunnableTest {

	public static void main(String[] args) {
		MakeCar2 car1 = new MakeCar2("바퀴 만들기");
		Thread t1 = new Thread(car1);	//start()는 Thread 클래스에만 있어서 객체 생성 필요
		t1.start();
		
		//변수가 선언되고 한 번만 사용되는 것을 선호하지 않기 때문에 간략히 쓴다.
		new Thread(new MakeCar1("엔진 부착")).start();
	}//main

}//class-RunnableTest

class MakeCar2 implements Runnable{
	String work;
	
	MakeCar2(String work){
		this.work = work;
	}//생성자
	
	//오버라이딩 필수
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(work+" 작업 중");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}//t~c
			
		}//for
	}//run()
}//class-MakeCar2
