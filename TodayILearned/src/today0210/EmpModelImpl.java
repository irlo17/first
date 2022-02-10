package today0210;

import java.sql.*;
import java.util.*;

public class EmpModelImpl implements EmpModel{
	
	/*
	  	생성자 함수 
	 	1. DB 연동 - 드라이버 등록
	*/
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String pass = "tiger";
	
	//01. 드라이버 메모리에 로딩
	public EmpModelImpl() throws Exception{
		Class.forName(driver);
	}


	/*-------------------------------------------------------
	* insert() :  입력한 값 받아서 데이타베이스에 추가
		0. 연결객체 얻어오기
		1. sql문 만들기 ( insert 구문 )
		2. PreparedStatement 객체 생성 
		3. PreparedStatement에 인자 지정
		4. sql문 전송 ( executeUpdate() 이용 )
		5. PreparedStatement 닫기
		6. 연결 닫기
	*/
	public void insert( EmpVO r ) throws SQLException{	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO emp(empno, ename, sal, job, deptno) "
									+ "	VALUES(?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, r.getEmpno());
			ps.setString(2, r.getEname());
			ps.setInt(3, r.getSal());
			ps.setString(4, r.getJob());
			ps.setInt(5, r.getDeptno());
			
			int result = ps.executeUpdate();
			System.out.println(result + "행 입력");
			
		}finally {
			con.close();
			ps.close();
		}//t~f
	}


	/*-------------------------------------------------------
	* modify() : 화면 입력값 받아서 수정
		0. 연결객체 얻어오기
		1. sql문 만들기 ( update 구문 )
		2. PreparedStatement 객체 생성 ( 또는 Statement )
		3. PreparedStatement에 인자 지정
		4. sql문 전송 ( executeUpdate() 이용 )
		5. PreparedStatement 닫기
		6. 연결 닫기
	*/
	public void modify( EmpVO r ) throws SQLException{	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 성공");
			
			String sql = "UPDATE emp SET ename=?, sal=?, job=?, deptno=? WHERE empno=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, r.getEname());
			ps.setInt(2, r.getSal());
			ps.setString(3, r.getJob());
			ps.setInt(4, r.getDeptno());
			ps.setInt(5, r.getEmpno());
			
			int result = ps.executeUpdate();
			System.out.println(result+"행 수정");
			
		}finally {
			con.close();
			ps.close();
		}
	}

	
	/*-------------------------------------------------------
	* selectByEmpno() :  입력받은 사번을 받아서 해당 레코드 검색
		0. 연결객체 얻어오기
		1. sql문 만들기 ( select 구문 )
		2. PreparedStatement 객체 얻기 ( Statement  가능 )
		4. sql문 전송 ( executeQuery() 이용 )
		5. 결과집합(ResultSet)에서 값을 읽어서 EmpVO에 저장
		6. ResultSet/ PreparedStatement 닫기
		7. 연결 닫기
		8. EmpVO 객체 리턴
	*/	
	public EmpVO selectByEmpno( int empno ) throws SQLException{
		EmpVO vo = new EmpVO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("DB 연결 성공");
		
		String sql = "SELECT* FROM emp WHERE empno=?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, empno);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			vo.setEmpno(rs.getInt("EMPNO"));
			vo.setEname(rs.getString("ENAME"));
			vo.setSal(rs.getInt("SAL"));
			vo.setJob(rs.getString("JOB"));
			vo.setDeptno(rs.getInt("DEPTNO"));
			
			System.out.println("검색 성공");
			
		}//if
		
		}finally {
			rs.close();
			ps.close();
			con.close();
		}
		
		return vo;	
	}
	
	/*--------------------------------------------------------
	* delete() : 사원번호 값을 받아 해당 레코드 삭제
		0. 연결객체 얻어오기
		1. sql문 만들기 ( delete 구문 )
		2. PreparedStatement 객체 얻기
		3. sql문 전송 ( executeUpdate() 이용 )
		4. PreparedStatement 닫기
		5. 연결 닫기
	*/
	public int delete( int empno ) throws SQLException{
		int resultCnt = 0;		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 성공");
			
			String sql = "DELETE FROM emp WHERE empno = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, empno);
			
			ps.executeUpdate();
			
		}finally {
			ps.close();
			con.close();
		}
		
		return resultCnt;
	}
	
	/*-------------------------------------------------------
	* selectAll() :  전체 레코드 검색
		0. 연결객체 얻어오기
		1. sql문 만들기 ( select 구문 )
		2. PreparedStatement 객체 얻기 ( Statement  가능 )
		4. sql문 전송 ( executeQuery() 이용 )
		5. 결과집합(ResultSet)에서 값을 읽어서 ArrayList에 저장
		6. ResultSet/ PreparedStatement 닫기
		7. 연결 닫기
		8. ArrayList 객체 리턴
	*/	
	public ArrayList<EmpVO> selectAll() throws SQLException{
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO vo = new EmpVO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 성공");
			
			String sql = "SELECT * FROM emp";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			//몇 개가 넘어올지 모르니까
			while(rs.next()) {
				vo.setEmpno(rs.getInt("EMPNO"));
				vo.setEname(rs.getString("ENAME"));
				vo.setSal(rs.getInt("SAL"));
				vo.setJob(rs.getString("JOB"));
				vo.setDeptno(rs.getInt("DEPTNO"));
				list.add(vo);
			}//while
			
		}finally {
			rs.close();
			ps.close();
			con.close();
		}//t~f
		
		return list;
	}

}