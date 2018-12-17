package com.wl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wl.pojo.PageInfo;
import com.wl.pojo.Students;
import com.wl.service.CouService;
import com.wl.service.StuService;
import com.wl.service.impl.CouServiceImpl;
import com.wl.service.impl.StuServiceImpl;

public class CouServlet extends HttpServlet {
	/**
	 * ���ҵ������ 
	 */
	CouService cs = new CouServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public CouServlet() {
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
	    //�����������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		//��ȡ��������
		String oper = request.getParameter("oper");
		if("allcou".equals(oper)){
			selAllCou(request,response);
		}else if("optCou".equals(oper)){
			optCourse(request,response);
		}if("out".equals(oper)){
			outLogin(request,response);
		}
		
	}
	
	/**
	 * �˳���¼
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	
	private void outLogin(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
			//��ȡsession����
			HttpSession hs = request.getSession();
		    //����session����
			hs.invalidate();
			//�ض���
			response.sendRedirect("/optCourse/login.jsp");
			return;
	}
   /**
    * ѡ��γ�
    * @param request
    * @param response
 * @throws IOException 
 * @throws ServletException 
    */
	private void optCourse(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//��ȡ�γ�id
		String couid = request.getParameter("couid");
		//��ȡѧ��id
		HttpSession hs = request.getSession();
		Students stu = (Students) hs.getAttribute("stu");
		//System.out.println(couid+":"+stu.getStuid());
		int index = cs.optCouService(couid,stu.getStuid());
		if(index!=0){
			//ѡ�γɹ�
			hs.setAttribute("optflag", 1);
		}else{
			//ѡ��ʧ��
			hs.setAttribute("optflag", 0);
		}
		//��õ�ǰ��Ҫ��Ϣ
		PageInfo ps = (PageInfo) hs.getAttribute("pageinfo"); 
		
		int pageSize=ps.getPageSize();
		int pageNumber=ps.getPageNumber();
		request.getRequestDispatcher("Course?oper=allcou&pageSize="+pageSize+"&pageNumber="+pageNumber).forward(request, response);
		return;
		
	}

	/**
	 * ��ѯ����ѡ����Ϣ
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void selAllCou(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int pageSize=10;
		String pageSizeStr=request.getParameter("pageSize");
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			 pageSize=Integer.parseInt(pageSizeStr);
		}
		int pageNumber=1;
		String pageNumberStr = request.getParameter("pageNumber");
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			 pageNumber = Integer.parseInt(pageNumberStr);
		}
		//��ȡ��¼ѧ������Ϣ
		HttpSession hsStu = request.getSession();
		Students stu = (Students) hsStu.getAttribute("stu");
		//��ȡ�γ�����
		String couname = request.getParameter("couname");
		//��ȡ�ν���ʦ��Ϣ
		String teacher = request.getParameter("teacher");
      
        PageInfo pageinfo = cs.pageInfoService(pageSize,pageNumber,stu.getStuid(),couname,teacher);
  
        if(pageinfo!=null){
        	HttpSession hs = request.getSession();
        	hs.setAttribute("pageinfo", pageinfo);
   
        	response.sendRedirect("/optCourse/course/optCou.jsp");
        	return;
        }
		
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
