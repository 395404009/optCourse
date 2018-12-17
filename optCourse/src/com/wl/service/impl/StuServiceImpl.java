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
     * ѧ����¼ҵ���
     * @throws IOException 
     */
	@Override
	public Students checkStuLoginService(String stuname, String stupwd,String code,String codeSession) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		StuMapper stumapper = session.getMapper(StuMapper.class);
		Students stuna = stumapper.selByName(stuname);
		
		//�ж���֤���Ƿ���ȷ
		if(code.equals(codeSession)){
			if(stuna!=null){
				//�ж��û����������Ƿ�ƥ��
				Students stunapwd = stumapper.selByNamePwd(stuname, stupwd);
				if(stunapwd!=null){
					//��ѯ�ɹ�
					stunapwd.setLogin(SUCCESS);
					session.close();
					return stunapwd;
				}else{
					//�û��������벻ƥ��
					Students stuError = new Students();
					stuError.setLogin(NAME_PWD_MATCH);
					session.close();
					return stuError;
				}
			}else{
				//û�и��û�
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
	 *ѧ��ע��
	 * @throws IOException 
	 */
	@Override
	public int regStuService(String stuid, String stuname, String pwd,
			String sex, String stuinstitute) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
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
	 * �жϸ��û��Ƿ��Ѿ�ע��
	 * @throws IOException 
	 */
	@Override
	public Students regSelService(String stuid) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		StuMapper stumapper = session.getMapper(StuMapper.class);
		Students student = null;
		student = stumapper.selByRegStuid(stuid);
		return student;
	}

}
