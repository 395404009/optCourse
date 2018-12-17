package com.wl.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wl.mapper.DelCouMapper;
import com.wl.mapper.SelCouMapper;
import com.wl.pojo.Courses;
import com.wl.pojo.Students;
import com.wl.service.SelCouService;

public class SelCouServiceImpl implements SelCouService{
   /**
    *查询本人的所有选课信息
 * @throws IOException 
    */
	@Override
	public List<Courses> selCourseByStu(Students stu) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		SelCouMapper coumapper = session.getMapper(SelCouMapper.class);
		List<Courses> list = coumapper.selCouByStuid(stu.getStuid());
		session.close();
		return list;
	}
	/**
	 * 删除指定的已选课程
	 * @throws IOException 
	 */
	@Override
	public int delCouByCouid(String stuid, String couid) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		DelCouMapper coumapper = session.getMapper(DelCouMapper.class);
		
		int index=0;
		try{
			 index = coumapper.delCouByCouid(stuid, couid);
			session.commit();
		}catch(Exception e){
			session.rollback();
		}finally{
			session.close();
			
		}
		
		
		return index;
	}

}
