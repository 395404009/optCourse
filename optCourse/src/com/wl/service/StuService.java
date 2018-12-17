package com.wl.service;

import java.io.IOException;

import com.wl.pojo.Students;

public interface StuService {
	/**
	 * 登录成功
	 * @param stuname
	 * @param stupwd
	 * @return
	 * @throws IOException
	 */
	String SUCCESS="success";
	/**
	 * 没有改用户
	 */
	String NOT_THE_STUDENT="not_the_student";
	/**
	 * 同户名和密码不匹配
	 */
	String NAME_PWD_MATCH="name_pwd_match";
	/**
	 * 验证码不正确
	 */
	String CODE_MATCH="code_match";
	/**
	 * 用户登录验证
	 * @param stuname
	 * @param stupwd
	 * @param code
	 * @param codeSession
	 * @return
	 * @throws IOException
	 */

	Students checkStuLoginService(String stuname, String stupwd,String code,String codeSession) throws IOException;

	/**
	 * 用户注册
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
	 * 判断该用户是否注册
	 * @param stuid
	 * @return
	 * @throws IOException 
	 */
	Students regSelService(String stuid) throws IOException;

	
}
