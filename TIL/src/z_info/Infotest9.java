package z_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Infotest9 {
	//------------------------
	// [1] 멤버변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
	JTextArea ta;
	JButton  bAdd, bShow, bSearch, bDelete, bCancel, bExit;
	
	
	//------------------------
	// [2] 멤버변수 객체 생성
	Infotest9(){
		f = new JFrame("DBTest");
		
		tfName = new JTextField(15); //평균적으로 알파벳이 15
		tfId = new JTextField(15);
		tfTel = new JTextField(15);
		tfSex = new JTextField(15);
		tfAge = new JTextField(15);
		tfHome = new JTextField(15);
		
		
		ta = new JTextArea();

		bAdd = new JButton("Add", new ImageIcon("src/z_info/icon/1.png"));
		bAdd.setRolloverIcon(new ImageIcon("src/z_info/icon/2.png"));
		//bAdd.setPressedIcon(new ImageIcon("src/z_info/icon/3.jpg"));
		bAdd.setToolTipText("정보를 입력합니다.");
		
		bShow = new JButton("Show", new ImageIcon("src/z_info/icon/2.png"));
		bSearch = new JButton("Search", new ImageIcon("src/z_info/icon/3.png"));
		bDelete = new JButton("Delete", new ImageIcon("src/z_info/icon/4.png"));
		bCancel = new JButton("Cancel", new ImageIcon("src/z_info/icon/5.png"));
		bExit = new JButton("Exit", new ImageIcon("src/z_info/icon/6.png"));
		
	}
	
	//------------------------
	// [3] 화면 붙이기
	void addLayout(){
		
		f.setLayout(new BorderLayout());
		
		//WEST
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2));
		
		//JLabel(String text, int horizontalAlignment) - CENTER는 '0'
		p1.add(new JLabel("Name", new ImageIcon("src/z_info/icon/1.png"), 0));
		p1.add(tfName);
		p1.add(new JLabel("ID", new ImageIcon("src/z_info/icon/2.png"), 0));
		p1.add(tfId);
		p1.add(new JLabel("Tel", new ImageIcon("src/z_info/icon/3.png"), 0));
		p1.add(tfTel);
		p1.add(new JLabel("Sex", new ImageIcon("src/z_info/icon/4.png"), 0));
		p1.add(tfSex);
		p1.add(new JLabel("Age", new ImageIcon("src/z_info/icon/5.png"), 0));
		p1.add(tfAge);
		p1.add(new JLabel("Home", new ImageIcon("src/z_info/icon/6.png"), 0));
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
		//주민번호 입력창 (tfId)에서 엔터 쳤을 때 ('-' 넣기)
		tfId.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String id = tfId.getText(); //변수에 내용을 저장해야함! 아니면 날라감 
				
				//ta.setText(id); -> 저장한 내용이 ta 저장됨
				
				//성별을 구해서 tfSex에 저장
				char sex = id.charAt(7);
				if(sex=='1' | sex =='3') {tfSex.setText("남성");} //end of if - 남성
				if(sex=='2' | sex =='4') {tfSex.setText("여성");} //end of if - 여성
				
				
				//출신지를 구해서 tfHome 저장
				String area = id.substring(8,10);
				int home = Integer.parseInt(area);
				if(home<=8) {tfHome.setText("서울특별시");} 
				else if(home<=12) {tfHome.setText("부산광역시");}
				else if(home<=15){tfHome.setText("인천광역시");}
				else if(home<=25){tfHome.setText("경기도");}
				else if(home<=34){tfHome.setText("강원도");}
				else if(home<=39){tfHome.setText("충천북도");}
				else if(home<=41){tfHome.setText("대전광역시");}
				else {tfHome.setText("그 외 지역");}
				
				//나이를 구해서 tfAge 저장 String으로
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);

				String a = id.substring(0, 2);
				int birthYear = Integer.parseInt(a); 
				int age = 0;
	
				if(sex=='1' | sex =='2') {age = year - (birthYear +1900)+1;}
				if(sex=='3' | sex =='4') {age = year - (birthYear +2000)+1;}
				
				
				tfAge.setText(String.valueOf(age));
				
			}		
		});
		
		//취소 버튼이 눌러졌을 때 화면상으로 입력한 내용 삭제하기 (공간에 공백으로 덮어버리는 것)
		bCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
			tfName.setText("");
			tfId.setText("");
			tfTel.setText("");
			tfSex.setText("");
			tfAge.setText("");
			tfHome.setText("");
			ta.setText("");
			}		
		});
		
		//종료 버튼이 눌려졌을 때 프로그램 종료함
		bExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //숫자는 의미없다 
			}		
		});

	}
	
	public static void main(String[] args) {
		Infotest9 info = new Infotest9();
		info.addLayout();
		info.eventProc();
	}

}
