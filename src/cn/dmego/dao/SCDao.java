package cn.dmego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.dmego.domain.SC;
import cn.dmego.domain.eletiveBean;
import cn.dmego.domain.studyBean;
import cn.dmego.utils.JDBCUtils;

public class SCDao {
	public void addSC(SC sc){
		String sql = "insert into sc values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sc.getSno());
			ps.setString(2, sc.getCno());
			ps.setInt(3, sc.getGrade());
			ps.setString(4, sc.getXKLB());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	public void submitGrade(SC sc){
		String sql = "update sc set Grade=? where Sno =? and Cno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sc.getGrade());
			ps.setString(2, sc.getSno());
			ps.setString(3, sc.getCno());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}	
	}
	
	public boolean checkReg(String Sno,String Cno) {
		String sql = "select Sno,Cno from sc";
		boolean flag = true;
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn(); // 连接数据库
			state = conn.createStatement(); // 创建传输器对象
			rs = state.executeQuery(sql); // 执行查询操作
			while(rs.next()) { // 如果有结果，是认为通过了验证
				if (Sno.equals(rs.getString("Sno")) && Cno.equals(rs.getString("Cno"))) {
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
	
	public SC getBySnoCno(String Sno,String Cno) {
		// TODO Auto-generated method stub
		String sql = "select * from sc where Sno=? and Cno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SC sc = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Sno);
			ps.setString(2, Cno);
			rs = ps.executeQuery();
			while(rs.next()){
				sc = new SC(rs.getString("Sno"),rs.getString("Cno"),rs.getInt("Grade"), rs.getString("XKLB")); 
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}		
		return sc;
	}
	public List<SC> list() {
		// TODO Auto-generated method stub
		String sql = "select * from sc";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<SC> scs = new ArrayList<SC>();
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			SC sc;
			while(rs.next()){
				sc = new SC(rs.getString("Sno"),
				rs.getString("Cno"), rs.getInt("Grade"),rs.getString("XKLB"));
				scs.add(sc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,stat,conn);
		}
		return scs;
	}
	
	public List<studyBean> studyInfo(String Sno){
		String sql = "select C.Cno,Cname,Ccredit,Semester,Grade from course C "
				+ "join SC on  C.Cno=SC.Cno "
				+ "join Student S on S.Sno=SC.Sno where SC.sno = "+Sno;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<studyBean> studybeans = new ArrayList<studyBean>();
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			studyBean sBean = null;
			while(rs.next()){
				sBean = new studyBean(rs.getString("Cno"),
				rs.getString("Cname"), rs.getInt("Ccredit"), rs.getInt("Semester"), rs.getInt("Grade"));
				studybeans.add(sBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,stat,conn);
		}
		return studybeans;
	}
	
	public List<eletiveBean> eletiveInfo(String Cno){
		String sql = "select S.Sno,Sname,Sdept,Grade from student S "
				+ "join SC on  S.Sno=SC.Sno where SC.cno = "+Cno;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<eletiveBean> eletivebeans = new ArrayList<eletiveBean>();
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			eletiveBean eBean = null;
			while(rs.next()){
				eBean = new eletiveBean(rs.getString("Sno"),
				rs.getString("Sname"), rs.getString("Sdept"),rs.getInt("Grade"));
				eletivebeans.add(eBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,stat,conn);
		}
		return eletivebeans;
	}
	
}
