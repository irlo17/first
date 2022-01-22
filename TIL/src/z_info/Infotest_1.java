package z_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.*;


public class Infotest_1 {
	//------------------------
	// [1] 멤버변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
	JTextArea ta;
	JButton  bAdd, bShow, bSearch, bDelete, bCancel, bExit;
	
	
	//------------------------
	// [2] 멤버변수 객체 생성
	Infotest_1(){
		f = new JFrame("DBTest");
		
		tfName = new JTextField(15); //평균적으로 알파벳이 15
		tfId = new JTextField(15);
		tfTel = new JTextField(15);
		tfSex = new JTextField(15);
		tfAge = new JTextField(15);
		tfHome = new JTextField(15);
		
		
		ta = new JTextArea();

		bAdd = new JButton("Add");
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
		
	}
	
	//------------------------
	// [3] 화면 붙이기
	void addLayout(){
		
		f.setLayout(new BorderLayout());
		
		//WEST
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2));
		
		//JLabel(String text, int horizontalAlignment) - CENTER는 '0'
		p1.add(new JLabel("Name", 0));
		p1.add(tfName);
		p1.add(new JLabel("ID", 0));
		p1.add(tfId);
		p1.add(new JLabel("Tel", 0));
		p1.add(tfTel);
		p1.add(new JLabel("Sex", 0));
		p1.add(tfSex);
		p1.add(new JLabel("Age", 0));
		p1.add(tfAge);
		p1.add(new JLabel("Home", 0));
		p1.add(tfHome);
		
		
		f.add(p1, BorderLayout.WEST);
		
		
		f.add(ta, BorderLayout.CENTER);
		
		//버튼 영역
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 6));
		
		f.add(p2, BorderLayout.SOUTH);
		
		p2.add(bAdd);
		p2.add(bShow);
		p2.add(bSearch);
		p2.add(bDelete);
		p2.add(bCancel);
		p2.add(bExit);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 200, 800, 350);
		f.setVisible(true);
	}
	
	//-----------------------
	// [4] 이벤트 처리
	void eventProc() {
		
	}
	
	public static void main(String[] args) {
		Infotest_1 info = new Infotest_1();
		info.addLayout();
		info.eventProc();
	}

}
