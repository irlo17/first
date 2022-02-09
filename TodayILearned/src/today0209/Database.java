package today0209;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String pass = "tiger";
	
	public Database() throws ClassNotFoundException {
		//	01. 드라이버 메모리에 로딩
		Class.forName(driver);
		
	}//Database()
	
	public void insert(InfoVO vo) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {	//	JAVA -> SQL
			
			//	02. 연결 객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 성공");
			
			//	03. *SQL 문장 만들기*
			String sql = "INSERT INTO info_test(name, id, tel, gender, age, home)   "
					+ "  VALUES (?, ?, ?, ?, ?, ?)";
			
			//	04.  SQL 전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getId());
			ps.setString(3, vo.getTel());
			ps.setString(4, vo.getGender());
			ps.setInt(5, vo.getAge());
			ps.setString(6, vo.getHome());
			
			//	05. 전송하기
			int result = ps.executeUpdate();
			System.out.println(result+"행을 실행");
			
		}finally {
			// 06. 닫기
			ps.close();
			con.close();
		}//t~f
		
	}//insert()
	
	public InfoVO searchByTel(String tel) throws Exception{
		InfoVO vo = new InfoVO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//	02. 연결 객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공");
			
			//	03. *SQL 문장 만들기*
			String sql = "SELECT * FROM info_test WHERE tel = ?";
			
			//	04.  SQL 전송객체 얻어오기
			ps = con.prepareStatement(sql);
			
			ps.setString(1, tel);
			
			//	05. 전송하기
			rs = ps.executeQuery();
			
			//06. 결과처리
			if(rs.next()) {
				vo.setName(rs.getString("NAME"));
				vo.setId(rs.getString("ID"));
				vo.setTel(rs.getString("TEL"));
				vo.setGender(rs.getString("GENDER"));
				vo.setAge(rs.getInt("AGE"));
				vo.setHome(rs.getString("HOME"));
			}
			System.out.println("검색성공");
		}finally {
			rs.close();
			ps.close();
			con.close();
		}
		
		return vo;
	}//searchByTel()
}
