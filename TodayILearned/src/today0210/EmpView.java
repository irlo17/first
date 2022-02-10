package today0210;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmpView {

	// 화면 관련 멤버변수
	JFrame f;
	JTextField tfEmpno, tfEname, tfSal, tfJob, tfDeptno;
	JButton bInsert, bUpdate, bDelete, bSelectAll;
	JTextArea ta;
	
	EmpModelImpl em;
	
	// 멤버변수 객체 생성
	EmpView(){
		f = new JFrame("나의 연습");
		tfEmpno = new JTextField(10);
		tfEname = new JTextField(10);
		tfSal = new JTextField(10);
		tfJob = new JTextField(10);
		tfDeptno = new JTextField(10);
		bInsert = new JButton("입력");
		bUpdate = new JButton("수정");
		bDelete = new JButton("삭제");
		bSelectAll = new JButton("전체검색");
		ta = new JTextArea();
		
		try {
			em = new EmpModelImpl();
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	// 화면 구성
	void addLayout() {
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1,2));
		
			JPanel pNorth1 = new JPanel();
			pNorth1.setLayout(new GridLayout(5,2));
			pNorth1.add(new JLabel("사번"));		pNorth1.add(tfEmpno);
			pNorth1.add(new JLabel("사원명"));		pNorth1.add(tfEname);
			pNorth1.add(new JLabel("월급"));		pNorth1.add(tfSal);
			pNorth1.add(new JLabel("업무"));		pNorth1.add(tfJob);
			pNorth1.add(new JLabel("부서"));		pNorth1.add(tfDeptno);
			
			JPanel pNorth2 = new JPanel();
			pNorth2.setLayout(new GridLayout(4,1));
			pNorth2.add(bInsert);
			pNorth2.add(bUpdate);
			pNorth2.add(bDelete);
			pNorth2.add(bSelectAll);
		
		pNorth.add(pNorth1);
		pNorth.add(pNorth2);
		
		f.add(pNorth, BorderLayout.NORTH);
		f.add(new JScrollPane(ta), BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(200, 200, 600, 500);
		f.setVisible(true);
	}
	
	// ******************************************************************************
	// 버튼 및 텍스트필드 이벤트 관련
	void eventProc() {
		// 입력버튼이 눌렸을 때
		bInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(Integer.valueOf(tfEmpno.getText()));
				vo.setEname(tfEname.getText());
				vo.setSal(Integer.valueOf(tfSal.getText()));
				vo.setJob(tfJob.getText());
				vo.setDeptno(Integer.valueOf(tfDeptno.getText()));
				
				try {
					em.insert(vo);
					tfEmpty();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "입력실패"+e.getMessage());
				}
			}
		});//bInsert
		
		//	수정버튼이 눌렸을 때
		bUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpVO vo = new EmpVO();
				
				vo.setEmpno(Integer.valueOf(tfEmpno.getText()));
				vo.setEname(tfEname.getText());
				vo.setSal(Integer.valueOf(tfSal.getText()));
				vo.setJob(tfJob.getText());
				vo.setDeptno(Integer.valueOf(tfDeptno.getText()));
				
				try {
					em.modify(vo);
					tfEmpty();
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "수정실패"+ee.getMessage());
				}
			}
		});//bUpdate
		
		//	tfEmpno에서 엔터가 눌렸을 때로
		tfEmpno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seachbyEmpno();
			}
		});//tfEmpno
	
		// 삭제 버튼을 눌렀을 때
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					em.delete(Integer.valueOf(tfEmpno.getText()));
					tfEmpty();
					System.out.println("행 삭제 성공");
				} catch (Exception e1) {
					System.out.println("행 삭제 실패");
				}
			}
		});//bDelete
		
		//	전체검색 버튼을 눌렀을 때
		bSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seachAll();
				
			}
		});//bSelectAll
		
	}//eventProc()
	void seachbyEmpno() {
		
		//사용자가 입력한 사번을 받고 오라클에 있으면 그 결과를 받는다
		try {
			EmpVO result = em.selectByEmpno(Integer.valueOf(tfEmpno.getText()));
			//받은 결과를 화면에 찍는다
			tfEmpno.setText(Integer.toString(result.getEmpno())); //int -> String
			tfEname.setText(result.getEname());
			tfSal.setText(Integer.toString(result.getSal()));
			tfJob.setText(result.getJob());
			tfDeptno.setText(Integer.toString(result.getDeptno()));
			
			System.out.println("검색성공");
		}catch(Exception e){
			System.out.println("검색 실패: "+e.getMessage());
		}
		
	}
	
	void seachAll() {
		try {
			ta.setText("=======================검색결과===========================\n");
			
			ArrayList<EmpVO> result = em.selectAll();
			
			//향상된 for문 사용
			for(EmpVO vo : result) {
				ta.append(vo.toString());
			}//for
			
		} catch (Exception e) {
			System.out.println("검색 실패"+e.getMessage());
		}
	}
	void tfEmpty() {
		tfEmpno.setText(null);
		tfEname.setText(null);
		tfDeptno.setText(null);
		tfJob.setText(null);
		tfSal.setText(null);
	}//tfempty()
	
	public static void main(String[] args) {
		EmpView view = new EmpView();
		view.addLayout();
		view.eventProc();

	}

}
