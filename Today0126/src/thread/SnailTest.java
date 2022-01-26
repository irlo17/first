package thread;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

// Thread를 활용한 달팽이 경기
public class SnailTest extends Frame {

	Snail a, b, c;

	public SnailTest() {
		setSize(500, 500);
		setVisible(true);

		a = new Snail(this, 0, 50);
		b = new Snail(this, 0, 100);
		c = new Snail(this, 0, 200);
		
		//run() 호출
		new Thread(a).start();
		new Thread(b).start();
		new Thread(c).start();
		

	}// 생성자
	
	public void paint( Graphics g) {
		
		g.setColor(Color.blue);
		g.drawString("@__", a.x, a.y);
		
		g.setColor(Color.red);
		g.drawString("@__", b.x, b.y);
		
		g.setColor(Color.green);
		g.drawString("@__", c.x, c.y);
	}//paint()

	
	public static void main(String[] args) {
		SnailTest snail = new SnailTest();
		

	}// main

}// class-SnailTest

/*
	- 임의의 수를 speed 값으로 지정		
	- x 값을 위의 임의의 수를 더하기
	- 화면을 다시 그린다 (*) app.repaint() 이용
	- 임의의 수만큼 잠시 쓰레드를 블럭한다
	# 위의 작업을 반복한다
*/
class Snail implements Runnable {
	
	int x, y;
	int speed;
	Frame app;
	
	public Snail(Frame app, int x, int y) {
		
		this.app = app;
		this.x = x;
		this.y = y;
		
	}//생성자

	
	public void run() {
		boolean a = true;
		while(a) {
			speed = (int)(Math.random()*10);//0~9 임의의 수 
			x += speed;
			app.repaint();//이동한 만큼 화면에 표시됨
			
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}//t~c
		}//while-화면 끝까지 갈 수 있도록 반복문
	}//run()
		
}// class-Snail
