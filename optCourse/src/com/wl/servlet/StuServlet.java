package com.wl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wl.pojo.Students;
import com.wl.service.StuService;
import com.wl.service.impl.StuServiceImpl;

public class StuServlet extends HttpServlet {

	StuService ss = (StuService) new StuServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public StuServlet() {
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
        //设置请求编码格式
		request.setCharacterEncoding("utf-8");
		//设置响应编码格式
		response.setContentType("text/html;charset=utf-8");
		//获取请求数据
		String oper = request.getParameter("oper");
//		System.out.println("oper="+oper);
		//处理请求数据
		if("login".equals(oper)){
			checkStuLogin(request,response);
		}if("reg".equals(oper)){
			stuReg(request,response);
		}
		
		//响应处理数据
		
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

		 doGet(request, response);
	}
	

	/**
	 * 学生注册
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void stuReg(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//获得注册信息
		String stuid=request.getParameter("stuid");
		String stuname=request.getParameter("stuname");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String stuinstitute = request.getParameter("stuinstitute");
		System.out.println(stuid+":"+stuname+":"+pwd+":"+sex+":"+stuinstitute);
		Students student = ss.regSelService(stuid);
		System.out.println("student="+student);
		HttpSession hs = request.getSession();
		if(student==null){
			int index=ss.regStuService(stuid,stuname,pwd,sex,stuinstitute);
			if(index!=0){
				//注册成功
				hs.setAttribute("reg", "success");	
			}else{
				hs.setAttribute("reg", "flase");		
			}
			response.sendRedirect("course/Reg.jsp");
		    return;
			
		}else{
			hs.setAttribute("reg", "exist");
			response.sendRedirect("course/Reg.jsp");
		    return;
		}
		
		
	}

	
	/**
	 *检查学生登录
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void checkStuLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//获得学生信息
		String stuname = request.getParameter("stuname");
		String stupwd = request.getParameter("stupwd");
		String code = request.getParameter("code");
		
		//获取session中的codeSession
		HttpSession hs = request.getSession();
		String codeSession = (String) hs.getAttribute("code");
		
//		System.out.println(stuname+":"+stupwd);
		//处理数据
		    //获得service层对象
		    Students stu = ss.checkStuLoginService(stuname,stupwd,code,codeSession);
		    if(stu.getLogin().equals(StuService.SUCCESS)){
		    	
		    	hs.setAttribute("stu", stu);
		    	//重定向到主页面
		    	response.sendRedirect("/optCourse/main/main.jsp");
		    	return;
		    }else{
		    	//请求转发到登入页面
		    	request.setAttribute("stu", stu);
		    	request.getRequestDispatcher("/login.jsp").forward(request, response);
		    	return;
		    }
		    
		
	}

}
