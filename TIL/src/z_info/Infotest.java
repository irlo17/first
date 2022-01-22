package z_info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Infotest {
	//------------------------
	// [1] 멤버변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
	JTextArea ta;
	JButton  bAdd, bShow, bSearch, bDelete, bCancel, bExit;
	
	
	//------------------------
	// [2] 멤버변수 객체 생성
	Infotest(){
		f = new JFrame("DBTest");
		
		//TextField -> TextField의 이름은 라벨로 붙힌다
		tfName = new JTextField(15); //평균적으로 알파벳이 15개 들어간다(크기)
		tfId = new JTextField(15);
		tfTel = new JTextField(15);
		tfSex = new JTextField(15);
		tfAge = new JTextField(15);
		tfHome = new JTextField(15);
		
		//
		ta = new JTextArea();
		
		/* 버튼에 이미지 붙이는 코드
		 	
		bAdd = new JButton("Add", new ImageIcon("src/z_info/icon/1.png"));
		bAdd.setRolloverIcon(new ImageIcon("src/z_info/icon/2.png"));
		bAdd.setPressedIcon(new ImageIcon("src/z_info/icon/3.jpg"));
		bAdd.setToolTipText("정보를 입력합니다."); - 참고
		*/

		//Button
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
		/*
		 	FlowLayout : 가운데를 중심으로 배치
		 	BorderLayout : 가운데를 중심으로 동, 서, 남, 북으로 배치 - CENTER도 있다
		 	GridLayout(행, 열) : 행과 열로 배치한다 -0을 기입하면 auto다
		 	BoxLayout : 한칸(행)에 하나씩 차지하도록 배치
		*/
		f.setLayout(new BorderLayout()); 
		
		//TextField - WEST
		//Panel 생성
		JPanel tfWest = new JPanel();
		
	/* 	2행 2열로 만들기
	 	12
	 	34 - 순으로 들어감 따라서 라벨과 텍스트필드를 번갈아 놔야한다
	 */
		tfWest.setLayout(new GridLayout(6,2));
		
	/*
	 	라벨에 이미지 넣기 - 같은 패키지안에 폴더 생성해서 이미지 넣어두기
	 	JLabel(String text, Icon icon, int horizontalAlignment)
		tfWest.add(new JLabel("Name", new ImageIcon("src/z_info/icon/1.png"), 0));
		
		정렬하기
		JLabel(String text, int horizontalAlignment) - CENTER는 '0'
		
	*/
		tfWest.add(new JLabel("Name", 0));
		tfWest.add(tfName);
		tfWest.add(new JLabel("ID", 0));
		tfWest.add(tfId);
		tfWest.add(new JLabel("Tel", 0));
		tfWest.add(tfTel);
		tfWest.add(new JLabel("Sex", 0));
		tfWest.add(tfSex);
		tfWest.add(new JLabel("Age", 0));
		tfWest.add(tfAge);
		tfWest.add(new JLabel("Home", 0));
		tfWest.add(tfHome);
		
		f.add(tfWest, BorderLayout.WEST); //텍스트 필드 WEST 위치 
		
		//TextArea 위치 정하기
		f.add(ta, BorderLayout.CENTER);
		
		//버튼 영역
		JPanel bsouth = new JPanel();
		bsouth.setLayout(new GridLayout(1, 6));
		
		f.add(bsouth, BorderLayout.SOUTH);
		
		bsouth.add(bAdd);
		bsouth.add(bShow);
		bsouth.add(bSearch);
		bsouth.add(bDelete);
		bsouth.add(bCancel);
		bsouth.add(bExit);
		
		//버튼에 색 입히기
		bAdd.setBackground(new Color(255,128,0));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창에 x를 누르면 프레임 종료
		f.setBounds(100, 200, 800, 350); //GUI의 위치와 사이즈 설정
		f.setVisible(true); //프레임이 보이도록 해줌
	}
	
	//-----------------------
	// [4] 이벤트 처리
	void eventProc() {
		//주민번호 입력창-tfId 에서 엔터를 쳤을떼 내용 나오기
		tfId.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
			String id = tfId.getText();//변수에 내용을 저장해야함! 아니면 날라간다
			
			//ta.setText(id); -> 저장한 내용이 ta 저장됨

			//성별을 구해서 tfSex에 저장
			char ch =  id.charAt(7);
			if(ch=='1' || ch == '3') {tfSex.setText("남성");}
			if(ch=='2' || ch == '4') {tfSex.setText("여성");}
			
			//출신지를 구해서 tfHome 저장
			int home = Integer.parseInt(id.substring(8, 10));
			if(home<=8) {tfHome.setText("서울특별시");} 
			else if(home<=12) {tfHome.setText("부산광역시");}
			else if(home<=15){tfHome.setText("인천광역시");}
			else if(home<=25){tfHome.setText("경기도");}
			else if(home<=34){tfHome.setText("강원도");}
			else if(home<=39){tfHome.setText("충천북도");}
			else if(home<=41){tfHome.setText("대전광역시");}
			else {tfHome.setText("그 외 지역");}
			
			//나이를 구해서 tfAge 저장
			int birthYear = Integer.parseInt(id.substring(0, 2));
			int age = 0;
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			if(ch=='1' || ch == '2') {age = year - (birthYear + 1900)+1;} //1900년대생
			if(ch=='3' || ch == '4') {age = year - (birthYear + 2000)+1;}//2000년대생
		
			tfAge.setText(String.valueOf(age)); // int -> String으로 바꿔줘야함
			
			}//end of actionPerformed
		});//end of tfId 
		
		//취소 버튼이 눌려졌을 때 화면상으로 입력한 내용 삭제하기
		bCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
			//공간을 공백으로 덮어버리는 것
			tfName.setText("");
			tfId.setText("");
			tfTel.setText("");
			tfSex.setText("");
			tfAge.setText("");
			tfHome.setText("");
			ta.setText("");
			}		
		});//end of bCancel
		
		//종료 버튼이 눌렸을 때 프로그램 종료함
		bExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //숫자는 의미없다 -> 창닫힘 + 프로그램 종료
			}		
		}); //end of bExit
		
	}//end of eventProc
	
	public static void main(String[] args) {
		Infotest info = new Infotest();
		info.addLayout();
		info.eventProc();
	}//end of main

}//end of Infotest
