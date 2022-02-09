package today0209;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InfoTest {
	
	// 	멤버 변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfAge,tfGender, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
	
	Database db;
	
	//	멤버 변수 객체 생성
	public InfoTest() {
		f = new JFrame("DBTest"); 
		
		tfName = new JTextField(15);
		tfId = new JTextField(15);
		tfTel = new JTextField(15);
		tfGender = new JTextField(15);
		tfAge = new JTextField(15);
		tfHome = new JTextField(15);
		
		ta = new JTextArea();
		
		bAdd = new JButton("Add");
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
		
		try {
			db = new Database();
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}//생성자
	
	//	화면 붙이기
	void addLayout() {
		
		f.setLayout(new BorderLayout());
		
		JPanel pt = new JPanel();
		pt.setLayout(new GridLayout(6,2));
		
	//라벨을 이용해서 tf 이름 붙이기 CENTER = 0
		pt.add(new JLabel("Name", 0));
		pt.add(tfName);
		pt.add(new JLabel("Id", 0));
		pt.add(tfId);
		pt.add(new JLabel("Tel", 0));
		pt.add(tfTel);
		pt.add(new JLabel("Gender", 0));
		pt.add(tfGender);
		pt.add(new JLabel("Age", 0));
		pt.add(tfAge);
		pt.add(new JLabel("Home", 0));
		pt.add(tfHome);
		
		//	panel 붙이기 -> WEST
		f.add(pt, BorderLayout.WEST);
		
		f.add(ta, BorderLayout.CENTER);
		
		//버튼 붙이기
		JPanel pb = new JPanel();
		pb.setLayout(new GridLayout(1, 6));
		
		f.add(pb, BorderLayout.SOUTH);
		
		pb.add(bAdd);
		pb.add(bShow);
		pb.add(bSearch);
		pb.add(bDelete);
		pb.add(bCancel);
		pb.add(bExit);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 200, 800, 350);
		f.setVisible(true);
		
	}//addLayout()
	
	//	이벤트 처리
	void eventProc() {
		//Add 버튼이 눌렸을 때 SQL로 내용 보내기
		bAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//사용자의 입력값들을  InfoVO 멤버(통으로 만든다)로 지정
				InfoVO vo = new InfoVO();
				vo.setName(tfName.getText());
				vo.setId(tfId.getText());
				vo.setTel(tfTel.getText());
				vo.setGender(tfGender.getText());
				vo.setAge(Integer.valueOf(tfAge.getText()));
				vo.setHome(tfHome.getText());
				
				try {
					db.insert(vo);
					
					//입력하면 지워짐
					tfName.setText(null);
					tfId.setText(null);
					tfTel.setText(null);
					tfGender.setText(null);
					tfAge.setText(null);
					tfHome.setText(null);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "입력실패"+e1.getMessage());
				}//t~c
			}
		});
		
		//tfTel 입력하고 엔터치면 SQL에서 내용 가져오기
		tfTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tel = tfTel.getText();
				
				try {
				//사용자가 입력한 전화번호를 얻고 실제 오라클에서 전화번호가 있으면 그 결과를 받음
					InfoVO result = db.searchByTel(tel);

				//받은 결과를 화면에 찍는다
					tfName.setText(result.getName());
					tfId.setText(result.getId());
					tfTel.setText(result.getTel());
					tfGender.setText(result.getGender());
					tfAge.setText(Integer.toString(result.getAge()));
					tfHome.setText(result.getHome());
					
				} catch (Exception e1) {
					System.out.println("검색 실패: "+e1.getMessage());
				}
			}
		});
		
		//종료 버튼이 눌려졌을 때 프로그램 종료
		bExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}



	public static void main(String[] args) {
		InfoTest info = new InfoTest();
		info.eventProc();
		info.addLayout();

	}//main()
}//class
