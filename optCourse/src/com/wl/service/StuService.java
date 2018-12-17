package com.wl.service;

import java.io.IOException;

import com.wl.pojo.Students;

public interface StuService {
	/**
	 * ��¼�ɹ�
	 * @param stuname
	 * @param stupwd
	 * @return
	 * @throws IOException
	 */
	String SUCCESS="success";
	/**
	 * û�и��û�
	 */
	String NOT_THE_STUDENT="not_the_student";
	/**
	 * ͬ���������벻ƥ��
	 */
	String NAME_PWD_MATCH="name_pwd_match";
	/**
	 * ��֤�벻��ȷ
	 */
	String CODE_MATCH="code_match";
	/**
	 * �û���¼��֤
	 * @param stuname
	 * @param stupwd
	 * @param code
	 * @param codeSession
	 * @return
	 * @throws IOException
	 */

	Students checkStuLoginService(String stuname, String stupwd,String code,String codeSession) throws IOException;

	/**
	 * �û�ע��
	 * @param stuid
	 * @param stuname
	 * @param pwd
	 * @param sex
	 * @param stuinstitute
	 * @return
	 * @throws IOException 
	 */
	int regStuService(String stuid, String stuname, String pwd, String sex,
			String stuinstitute) throws IOException;

	/**
	 * �жϸ��û��Ƿ�ע��
	 * @param stuid
	 * @return
	 * @throws IOException 
	 */
	Students regSelService(String stuid) throws IOException;

	
}
