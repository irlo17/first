package today0209;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public void modify(InfoVO vo) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {	//	JAVA -> SQL
			
			//	02. 연결 객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 성공");
			
			//	03. *SQL 문장 만들기*
			String sql = "UPDATE INFO_TEST SET name = ?, id = ?, gender = ?, age = ?, "
					+ "home = ?  WHERE tel = ? ";
			
			//	04.  SQL 전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getId());
			ps.setString(3, vo.getGender());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getHome());
			ps.setString(6, vo.getTel());
			
			//	05. 전송하기
			int result = ps.executeUpdate();
			System.out.println(result+"행을 수정");
			
		}finally {
			// 06. 닫기
			ps.close();
			con.close();
		}//t~f
		
	}//modify()
	
	public InfoVO searchById(String id) throws Exception {
		InfoVO vo = new InfoVO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		//2.연결 객체 얻어오기
		con = DriverManager.getConnection(url,user,pass);
		System.out.println("DB 연결 성공");
		
		//3. sql 문장
		String sql = "SELECT * FROM info_test WHERE id=?"; //CHAR는 자릿수만큼 공백 -> TRIM(id)사용
		
		//4. 전송객체 얻어오기 - PreparedStatement
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		//5. 전송 - executeQuery()
		rs = ps.executeQuery();
		
		//6. 결과처리
		if(rs.next()) {
			vo.setName(rs.getString("NAME"));
			vo.setId(rs.getString("ID"));
			vo.setTel(rs.getString("TEL"));
			vo.setGender(rs.getString("GENDER"));
			vo.setAge(rs.getInt("AGE"));
			vo.setHome(rs.getString("HOME"));
			
			System.out.println("검색성공");
		}
		}finally {
			//7. 닫기 - finally 구문으로 빼는 걸 권장
			rs.close();
			ps.close();
			con.close();
		}//t~f
		return vo;
		
	}//searchById()
	
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
	
	public int delete(String tel) throws Exception {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		// 2. 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("DB 연결 성공");
		
		// 3. SQL 문장 만들기
		String sql = "DELETE FROM info_test WHERE tel = ?";
		
		// 4. 전송객체 얻어오기
		ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		
		// 5. 전송
		result = ps.executeUpdate();
		System.out.println(result+"행이 삭제되었습니다.");
		} finally {
		// 6. 닫기
			ps.close();
			con.close();
		}//t~f
		return result;
	}

	public ArrayList<InfoVO> selectAll() throws Exception{// 전체 검색
		
		//쿼리 개수를 정확히 모르니까 ArrayList를 쓴다
		ArrayList<InfoVO> list = new ArrayList<InfoVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공");
	
			String sql = "SELECT* FROM info_test";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				InfoVO vo = new InfoVO();
				vo.setName(rs.getString("NAME"));
				vo.setId(rs.getString("ID"));
				vo.setTel(rs.getString("TEL"));
				vo.setGender(rs.getString("GENDER"));
				vo.setAge(rs.getInt("AGE"));
				vo.setHome(rs.getString("HOME"));
				list.add(vo);
				
			}//while
			
			}finally {
				rs.close();
				ps.close();
				con.close();
			}
		return list;
		
		
	}//selectAll()
}

