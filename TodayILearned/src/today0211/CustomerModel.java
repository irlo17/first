package today0211;	

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CustomerModel implements CustomerDao{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String pass = "tiger";
	
	
	public CustomerModel() throws Exception{
	 	// 1. 드라이버로딩
		Class.forName(driver);
		
	}
	
	public void insertCustomer(Customer vo) throws Exception{
		// 2. Connection 연결객체 얻어오기
		// 3. sql 문장 만들기
		// 4. sql 전송객체 (PreparedStatement)		
		// 5. sql 전송
		// 6. 닫기 
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연동 성공");
			
			String sql = "INSERT INTO MEMBER(TEL, NAME, SUB_TEL, ADDRESS, EMAIL)"
					+ "		 VALUES (?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCustTel1());
			ps.setString(2, vo.getCustName());
			ps.setString(3, vo.getCustTel2());
			ps.setString(4, vo.getCustAddr());
			ps.setString(5, vo.getCustEmail());
			
			int result = ps.executeUpdate();
			System.out.println(result + "행 입력");
		}finally {
			try {
				ps.close();
				con.close();
			}catch(Exception e) {
			}
		}
	}
	
	public Customer selectByTel(String tel) throws Exception{
		Customer vo = new Customer();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연동 성공");
			
			String sql = "SELECT * FROM member WHERE TEL = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo.setCustAddr(rs.getString("ADDRESS"));
				vo.setCustEmail(rs.getString("EMAIL"));
				vo.setCustName(rs.getString("NAME"));
				vo.setCustTel1(tel);
				vo.setCustTel2(rs.getString("SUB_TEL"));
			}
			
		}finally {
			try {
			rs.close();
			ps.close();
			con.close();
			}catch(Exception e) {
			}
		}
		
		return vo;
		
	}
	
	public int updateCustomer(Customer vo) throws Exception{
		
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연동 성공");
			
			String sql = "UPDATE member SET NAME =?, SUB_TEL=?, "
					+ "		ADDRESS=?, EMAIL=? WHERE TEL =?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCustName());
			ps.setString(2, vo.getCustTel2());
			ps.setString(3, vo.getCustAddr());
			ps.setString(4, vo.getCustEmail());
			ps.setString(5, vo.getCustTel1());
			
			result = ps.executeUpdate();
			System.out.println(result + "행 수정");
			
		}finally {
			try {
				ps.close();
				con.close();
			}catch(Exception e) {
			}
		}
		
		return result;
	}
}