package com.wl.service.impl;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wl.mapper.CouMapper;
import com.wl.pojo.Courses;
import com.wl.pojo.PageInfo;
import com.wl.service.CouService;

public class CouServiceImpl implements CouService{
    private PageInfo pageinfo = new PageInfo();
    /**
     * 获取该页面的所有选课
     */
	@Override
	public PageInfo pageInfoService(int pageSize,int pageNumber,String stuid,String couname,String teacher) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		CouMapper coumapper = session.getMapper(CouMapper.class);
		//开始页
		int pageStart=pageSize*(pageNumber-1);
		//结束页
		int pageEnd=pageSize+pageSize*(pageNumber-1);
		//查询当前页数课程
		List<Courses> listCou = coumapper.selAll(pageStart,pageEnd,couname,teacher);
		for(Courses ListCou:listCou){
			ListCou.setOptCou("NOT_OPT");
		}
		//查询该页学生已选的课
		List<Courses> listSelCou = coumapper.selByStuid(pageStart,pageEnd,stuid,couname,teacher);
	    if(listSelCou!=null){
	    	for(Courses ListCou:listCou){
	    		for(Courses ListSelCou: listSelCou)
	    			if(ListCou.getCouid().equals( ListSelCou.getCouid())){
          				ListCou.setOptCou("OPT");
	    			}
	    	}
	    }
		pageinfo.setList(listCou);
		
		//查询课程总页数
		int count=coumapper.selCount(couname,teacher);
		pageinfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		//设置当前页数
		pageinfo.setPageNumber(pageNumber);
		//设置当前页数的总数
		pageinfo.setPageSize(pageSize);
		
		session.close();	
		return pageinfo;
	}
    /**
     * 选择指定的课程
     * @throws IOException 
     */
	@Override
	public int optCouService(String couid, String stuid) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		CouMapper coumapper = session.getMapper(CouMapper.class);
		int index=0;
		try{
			index = coumapper.inseCouByCouidStuid(couid ,stuid);
			session.commit();
		}catch(Exception e){
			session.rollback();
		}finally{
			session.close();
			
		}
		
		return index;
	}

}
