package cn.dmego.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dmego.dao.CourseDao;
import cn.dmego.dao.SCDao;
import cn.dmego.dao.StudentDao;
import cn.dmego.domain.Course;
import cn.dmego.domain.Student;
import cn.dmego.domain.eletiveBean;
import cn.dmego.domain.studyBean;

public class infoServlet extends HttpServlet {
	/**
	 * service判断方法
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String method = request.getParameter("method");
		if("select".equals(method)){
			select(request, response);
		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		SCDao scdao = new SCDao();
		CourseDao coursedao = new CourseDao();
		StudentDao studentdao = new StudentDao();
		int infoSelect = Integer.parseInt(request.getParameter("selectInfo"));
		System.out.println(infoSelect);
		String SnoOrCno = request.getParameter("SnoOrCno");
		if(infoSelect == 1){
			Student student = studentdao.getBySno(SnoOrCno);
			request.setAttribute("student", student);
			request.getRequestDispatcher("stuInfo.jsp").forward(request, response);
		}else if(infoSelect == 2){
			List<studyBean>studybeans = scdao.studyInfo(SnoOrCno);
			request.setAttribute("studybeans", studybeans);
			request.getRequestDispatcher("studyInfo.jsp").forward(request, response);
		}else if(infoSelect == 3){
			Course course = coursedao.getByCno(SnoOrCno);
			request.setAttribute("course", course);
			request.getRequestDispatcher("couInfo.jsp").forward(request, response);
		}else if(infoSelect == 4){
			List<eletiveBean> eletivebeans = scdao.eletiveInfo(SnoOrCno);
			request.setAttribute("eletivebeans", eletivebeans);
			request.getRequestDispatcher("eletiveInfo.jsp").forward(request, response);
		}else if(infoSelect == 0){
			request.getRequestDispatcher("infoSelect.jsp&status=1").forward(request, response);
		}
	}
}
