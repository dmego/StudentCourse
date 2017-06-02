package cn.dmego.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dmego.dao.StudentDao;
import cn.dmego.domain.Student;

public class stuServlet extends HttpServlet {
	
	/**
	 * service判断方法
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String method = request.getParameter("method");
		if("addStu".equals(method)){
			addStu(request, response);
		}else if("list".equals(method)){
			list(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}
	}
	private void addStu(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		StudentDao studentdao = new StudentDao();
		String updateSno = request.getParameter("updateSno");
		System.out.println(updateSno);
		String Sno = request.getParameter("Sno");
		System.out.println(Sno);
		String Sname = request.getParameter("Sname");
		String Ssex = request.getParameter("Ssex");
		 int   Sage = Integer.parseInt(request.getParameter("Sage"));
		String Sdept = request.getParameter("Sdept");
		Student student = new  Student(Sno, Sname, Ssex, Sage, Sdept);
		if(!updateSno.equals("")){
			boolean flag = true;
			if(!Sno.equals(updateSno)){
				flag = studentdao.checkReg(Sno);
			}
			if(flag){
				//修改成功，写入数据库
				studentdao.updStudent(student,updateSno);
				response.sendRedirect("stuServlet?method=list&status=2");
			}else{
				//修改失败，跳回
				response.sendRedirect("addStu.jsp?status=2");
			}
		}else{
			boolean flag = studentdao.checkReg(Sno);
			System.out.println(flag);
			if(flag){
				// 新增学生
				studentdao.addStudent(student);
				response.sendRedirect("addStu.jsp?status=1");
			}else{
				//存在该学号的学生，新增失败
				response.sendRedirect("addStu.jsp?status=2");		
			}
		}
	}
	
	private void list(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		StudentDao studentDao = new StudentDao();
		String status = request.getParameter("status");
		List<Student> students = studentDao.list();
		request.setAttribute("students",students);
		if(status != null){ //请求转发到listStu页面
			request.getRequestDispatcher("listStu.jsp?status="+status).forward(request, response);
		}else{
			request.getRequestDispatcher("listStu.jsp").forward(request, response);
		}
	}
	
	private void update(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String Sno = request.getParameter("Sno");
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getBySno(Sno);
		request.setAttribute("student", student);
		request.getRequestDispatcher("addStu.jsp").forward(request, response);
		
	}
	
	private void delete(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String Sno = request.getParameter("Sno");
		StudentDao studentDao = new StudentDao();
		studentDao.delStudent(Sno);
		response.sendRedirect(request.getContextPath()+"/student/stuServlet?method=list&status=3");
	}

}
