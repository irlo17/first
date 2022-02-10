package today0210;

public class EmpVO {
	int empno;
	String ename;
	int sal;
	String job;
	int deptno;
	
	
	
	
	public EmpVO() {
	}
	public EmpVO(int empno, String ename, int sal, String job, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.job = job;
		this.deptno = deptno;
	}
	
	public String toString() {
		return empno +"\t" + ename +"\t"+sal+"\t"+job+"\t"+deptno+"\n\n";
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}
