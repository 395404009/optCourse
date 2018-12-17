package com.wl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wl.pojo.Courses;
import com.wl.pojo.Students;
import com.wl.service.SelCouService;
import com.wl.service.impl.SelCouServiceImpl;

public class SelCouServlet extends HttpServlet {
    /**
     * 获取业务层对象
     */
	SelCouService scs = new SelCouServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public SelCouServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		//获取请求数据
		String oper = request.getParameter("oper");
		if("selcou".equals(oper)){
			SelCouServlet(request,response);
		}else if("delete".equals(oper)){
			DelCouServlet(request,response);
		}
		
	}
 
	/**
	 * 删除本人指定课程的信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void DelCouServlet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//获取课程的id
		String couid = request.getParameter("couid");
		//获取session对象
		HttpSession hs = request.getSession();
		//获取登录学生的信息
		Students stu = (Students) hs.getAttribute("stu");
		//调用业务层方法
		int index = scs.delCouByCouid(stu.getStuid(),couid);
		if(index!=0){
			hs.setAttribute("delIndex", index);
			response.sendRedirect("/optCourse/selCou?oper=selcou");
			return;
		}
		
	}

	/**
	 * 查询本人所有选课
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void SelCouServlet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession hs = request.getSession();
		Students stu = (Students) hs.getAttribute("stu");
		
		//处理请求数据
		
		List<Courses> list=scs.selCourseByStu(stu);
		if(list.size()!=0){
			hs.setAttribute("optcou", 1);
			hs.setAttribute("courses", list);
		}else{
			hs.setAttribute("optcou", 0);
		}
		
		//响应处理结果
		response.sendRedirect("/optCourse/course/selCou.jsp");
		return;
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
