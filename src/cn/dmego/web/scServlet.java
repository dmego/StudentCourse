package cn.dmego.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dmego.dao.SCDao;
import cn.dmego.domain.SC;


public class scServlet extends HttpServlet {
	/**
	 * service判断方法
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String method = request.getParameter("method");
		if("addSC".equals(method)){
			addSC(request, response);
		}else if("list".equals(method)){
			list(request, response);
		}else if("submit".equals(method)){
			submit(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}
	}
	
	private void addSC(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		SCDao scdao = new SCDao();
		String Sno = request.getParameter("Sno");
		String Cno = request.getParameter("Cno");
		int Grade = 0;
		String XKLB = request.getParameter("XKLB");
		SC sc = new SC(Sno, Cno, Grade, XKLB) ;
		boolean flag = scdao.checkReg(Sno,Cno);
		System.out.println(flag);
		if(flag){
			// 选课
			scdao.addSC(sc);
			response.sendRedirect("addSC.jsp?status=1");
		}else{
			//选课失败
			response.sendRedirect("addSC.jsp?status=2");		
		}	
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		SCDao scdao = new SCDao();
		SC sc = null;
		String Sno = request.getParameter("Sno");
		String Cno = request.getParameter("Cno");
		int Grade = Integer.parseInt(request.getParameter("Grade"));
		String XKLB  = request.getParameter("XKLB");
		sc = new SC(Sno, Cno, Grade, XKLB);
		scdao.submitGrade(sc);
		response.sendRedirect("scServlet?method=list&status=2");
	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		SCDao scdao = new SCDao();
		String Sno = request.getParameter("Sno");
		String Cno = request.getParameter("Cno");
		SC sc = scdao.getBySnoCno(Sno, Cno);
		request.setAttribute("sc", sc);
		request.getRequestDispatcher("updSC.jsp").forward(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		SCDao scDao = new SCDao();
		String status = request.getParameter("status");
		List<SC> scs = scDao.list();
		request.setAttribute("scs",scs);
		if(status != null){ //请求转发到listSC页面
			request.getRequestDispatcher("listSC.jsp?status="+status).forward(request, response);
		}else{
			request.getRequestDispatcher("listSC.jsp").forward(request, response);
		}
	}


}
