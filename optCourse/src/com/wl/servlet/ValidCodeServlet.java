package com.wl.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidCodeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ValidCodeServlet() {
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
		//����һ��ͼƬ
				//��λ:����
				BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
				
				//͸���Ĳ���
				//�򻭰��ϻ�����֮ǰ���������û���.
				Graphics2D gra = image.createGraphics();
				
				gra.setColor(Color.WHITE);
				//���ĸ����꿪ʼ���, ����������,��������
				gra.fillRect(0, 0, 200, 100);
				
				List<Integer> randList = new ArrayList<Integer>();
				Random random =new Random();
				for (int i = 0 ;i<4;i++) {
					randList.add(random.nextInt(10));
				}
				//��������
				gra.setFont(new Font("����",Font.ITALIC|Font.BOLD,40));
				Color[] colors = new Color[]{Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN,Color.PINK,Color.GRAY};
				for (int i = 0; i < randList.size(); i++) {
					gra.setColor(colors[random.nextInt(colors.length)]);
					gra.drawString(randList.get(i)+"", i*40, 70+(random.nextInt(21)-10));
				}
				
				for (int i = 0; i < 2; i++) {
					gra.setColor(colors[random.nextInt(colors.length)]);
					//������
					gra.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
				}
				
				ServletOutputStream outputStream = response.getOutputStream();
				//������
				ImageIO.write(image, "jpg", outputStream);
				
				//����֤����뵽session��
				HttpSession session = request.getSession();
				session.setAttribute("code", ""+randList.get(0)+randList.get(1)+randList.get(2)+randList.get(3));
		
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
