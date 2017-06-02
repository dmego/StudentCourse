package cn.dmego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.dmego.domain.Course;
import cn.dmego.utils.JDBCUtils;

public class CourseDao {
	public void addCourse(Course course){
		String sql = "insert into course values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getCno());
			ps.setString(2, course.getCname());
			ps.setInt(3, course.getCcredit());
			ps.setInt(4, course.getSemester());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	public void delCourse(String Cno){
		String sql = "delete from course where Cno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Cno);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	public void updCourse(Course course,String updateCno){
		String sql = "update course set Cno =?,Cname =?,Ccredit= ?,Semester=? where Cno= ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,course.getCno());
			ps.setString(2, course.getCname());
			ps.setInt(3, course.getCcredit());
			ps.setInt(4, course.getSemester());
			ps.setString(5, updateCno);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	public boolean checkReg(String Cno) {
		String sql = "select Cno from course";
		boolean flag = true;
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn(); // 连接数据库
			state = conn.createStatement(); // 创建传输器对象
			rs = state.executeQuery(sql); // 执行查询操作
			while(rs.next()) { // 如果有结果，是认为通过了验证
				if (Cno.equals(rs.getString("Cno"))) {
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
	
	public Course getByCno(String Cno) {
		// TODO Auto-generated method stub
		String sql = "select * from course where Cno= "+Cno;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Course course = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				course = new Course(rs.getString("Cno"),rs.getString("Cname"),rs.getInt("Ccredit"), rs.getInt("Semester"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}		
		return course;
	}
	public List<Course> list() {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<Course> courses = new ArrayList<Course>();
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			Course course;
			while(rs.next()){
				course = new Course(rs.getString("Cno"),
				rs.getString("Cname"), rs.getInt("Ccredit"),rs.getInt("Semester"));
				courses.add(course);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,stat,conn);
		}
		return courses;
	}
}
