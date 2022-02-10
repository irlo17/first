package today0210;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpModel {
	
	public void insert( EmpVO r ) throws SQLException;
	public void modify( EmpVO r ) throws SQLException;
	public EmpVO selectByEmpno( int empno ) throws SQLException;
	public int delete( int empno ) throws SQLException;
	public ArrayList<EmpVO> selectAll() throws SQLException;
}
