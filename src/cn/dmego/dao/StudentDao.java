package cn.dmego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.dmego.domain.Student;
import cn.dmego.utils.JDBCUtils;

public class StudentDao {
	public void addStudent(Student student){
		String sql = "insert into student values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getSno());
			ps.setString(2, student.getSname());
			ps.setString(3, student.getSsex());
			ps.setInt(4, student.getSage());
			ps.setString(5, student.getSdept());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	public void delStudent(String Sno){
		String sql = "delete from student where Sno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Sno);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	public void updStudent(Student student,String updateSno){
		String sql = "update student set Sno =?,Sname=?,Ssex=?,Sage=?,Sdept=? where Sno =?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getSno());
			ps.setString(2, student.getSname());
			ps.setString(3, student.getSsex());
			ps.setInt(4, student.getSage());
			ps.setString(5, student.getSdept());
			ps.setString(6, updateSno);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
		
	}
	public boolean checkReg(String Sno) {
		String sql = "select Sno from student";
		boolean flag = true;
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn(); // 连接数据库
			state = conn.createStatement(); // 创建传输器对象
			rs = state.executeQuery(sql); // 执行查询操作
			while(rs.next()) { // 如果有结果，是认为通过了验证
				if (Sno.equals(rs.getString("Sno"))) {
					flag = false; 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, state, conn); // 关闭数据库的连接
		}
		return flag;
	}
	
	public Student getBySno(String Sno) {
		// TODO Auto-generated method stub
		String sql = "select * from student where Sno="+Sno;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Student student = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				student = new Student(rs.getString("Sno"),rs.getString("Sname"),rs.getString("Ssex"), rs.getInt("Sage"),rs.getString("Sdept")); 
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}		
		return student;
	}
	public List<Student> list() {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<Student>();
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			Student student;
			while(rs.next()){
				student = new Student(rs.getString("Sno"),
				rs.getString("Sname"), rs.getString("Ssex"),rs.getInt("Sage"),rs.getString("Sdept"));
				students.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,stat,conn);
		}
		return students;
	}
	
}
