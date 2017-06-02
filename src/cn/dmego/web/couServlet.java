package cn.dmego.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dmego.dao.CourseDao;
import cn.dmego.dao.StudentDao;
import cn.dmego.domain.Course;
import cn.dmego.domain.Student;

public class couServlet extends HttpServlet {
	/**
	 * service判断方法
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String method = request.getParameter("method");
		if("addCou".equals(method)){
			addCou(request, response);
		}else if("list".equals(method)){
			list(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}
	}
	private void addCou(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		CourseDao coursedao = new CourseDao();
		String updateCno = request.getParameter("updateCno");
		System.out.println(updateCno);
		String Cno = request.getParameter("Cno");
		System.out.println(Cno);
		String Cname = request.getParameter("Cname");
		int Ccredit = Integer.parseInt(request.getParameter("Ccredit"));
		int Semester = Integer.parseInt(request.getParameter("Semester"));
		Course course = new Course(Cno, Cname, Ccredit, Semester);
		if(!updateCno.equals("")){
			boolean flag = true;
			if(!Cno.equals(updateCno)){
				flag = coursedao.checkReg(Cno);
			}
			if(flag){
				//修改成功，写入数据库
				coursedao.updCourse(course, updateCno);
				response.sendRedirect("couServlet?method=list&status=2");
			}else{
				//修改失败，跳回
				response.sendRedirect("addCou.jsp?status=2");
			}
		}else{
			boolean flag = coursedao.checkReg(Cno);
			System.out.println(flag);
			if(flag){
				//新增课程
				coursedao.addCourse(course);
				response.sendRedirect("addCou.jsp?status=1");
			}else{
				//存在该课程号的课程，新增失败
				response.sendRedirect("addCou.jsp?status=2");		
			}
		}
	}
	
	private void list(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		CourseDao coursedao = new CourseDao();
		String status = request.getParameter("status");
		List<Course> courses = coursedao.list();
		request.setAttribute("courses",courses);
		if(status != null){ //请求转发到listCou页面
			request.getRequestDispatcher("listCou.jsp?status="+status).forward(request, response);
		}else{
			request.getRequestDispatcher("listCou.jsp").forward(request, response);
		}
	}
	
	private void update(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String Cno = request.getParameter("Cno");
		CourseDao coursedao = new CourseDao();
		Course course = coursedao.getByCno(Cno);
		request.setAttribute("course", course);
		request.getRequestDispatcher("addCou.jsp").forward(request, response);
		
	}
	
	private void delete(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String Cno = request.getParameter("Cno");
		CourseDao coursedao = new CourseDao();
		coursedao.delCourse(Cno);
		response.sendRedirect(request.getContextPath()+"/course/couServlet?method=list&status=3");
	}

	

}
