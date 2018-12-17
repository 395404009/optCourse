package com.wl.service.impl;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wl.mapper.StuMapper;
import com.wl.pojo.Students;
import com.wl.service.StuService;

public class StuServiceImpl implements StuService{
   
    /**
     * 学生登录业务层
     * @throws IOException 
     */
	@Override
	public Students checkStuLoginService(String stuname, String stupwd,String code,String codeSession) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		StuMapper stumapper = session.getMapper(StuMapper.class);
		Students stuna = stumapper.selByName(stuname);
		
		//判断验证码是否正确
		if(code.equals(codeSession)){
			if(stuna!=null){
				//判断用户名和秘密是否匹配
				Students stunapwd = stumapper.selByNamePwd(stuname, stupwd);
				if(stunapwd!=null){
					//查询成功
					stunapwd.setLogin(SUCCESS);
					session.close();
					return stunapwd;
				}else{
					//用户名和密码不匹配
					Students stuError = new Students();
					stuError.setLogin(NAME_PWD_MATCH);
					session.close();
					return stuError;
				}
			}else{
				//没有改用户
				Students stuError = new Students();
				stuError.setLogin(NOT_THE_STUDENT);
				session.close();
				return stuError;
			}
		}else{
			Students stuError = new Students();
			stuError.setLogin(CODE_MATCH);
			session.close();
			return stuError;
		}
	
	}

	/**
	 *学生注册
	 * @throws IOException 
	 */
	@Override
	public int regStuService(String stuid, String stuname, String pwd,
			String sex, String stuinstitute) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		StuMapper stumapper = session.getMapper(StuMapper.class);
		int index=0;
		try{
			index =stumapper.insStu(stuid,stuname,pwd,sex,stuinstitute);
			session.commit();
		}catch(Exception e){
			session.rollback();
		}finally{
			session.close();
			
		}
		
		return index;
	}

	/**
	 * 判断该用户是否已经注册
	 * @throws IOException 
	 */
	@Override
	public Students regSelService(String stuid) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		StuMapper stumapper = session.getMapper(StuMapper.class);
		Students student = null;
		student = stumapper.selByRegStuid(stuid);
		return student;
	}

}
