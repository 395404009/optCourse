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
        //������������ʽ
		request.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		response.setContentType("text/html;charset=utf-8");
		//��ȡ��������
		String oper = request.getParameter("oper");
//		System.out.println("oper="+oper);
		//������������
		if("login".equals(oper)){
			checkStuLogin(request,response);
		}if("reg".equals(oper)){
			stuReg(request,response);
		}
		
		//��Ӧ��������
		
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
	 * ѧ��ע��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void stuReg(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//���ע����Ϣ
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
				//ע��ɹ�
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
	 *���ѧ����¼
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void checkStuLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//���ѧ����Ϣ
		String stuname = request.getParameter("stuname");
		String stupwd = request.getParameter("stupwd");
		String code = request.getParameter("code");
		
		//��ȡsession�е�codeSession
		HttpSession hs = request.getSession();
		String codeSession = (String) hs.getAttribute("code");
		
//		System.out.println(stuname+":"+stupwd);
		//��������
		    //���service�����
		    Students stu = ss.checkStuLoginService(stuname,stupwd,code,codeSession);
		    if(stu.getLogin().equals(StuService.SUCCESS)){
		    	
		    	hs.setAttribute("stu", stu);
		    	//�ض�����ҳ��
		    	response.sendRedirect("/optCourse/main/main.jsp");
		    	return;
		    }else{
		    	//����ת��������ҳ��
		    	request.setAttribute("stu", stu);
		    	request.getRequestDispatcher("/login.jsp").forward(request, response);
		    	return;
		    }
		    
		
	}

}
