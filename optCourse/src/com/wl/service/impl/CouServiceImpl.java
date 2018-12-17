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
     * ��ȡ��ҳ�������ѡ��
     */
	@Override
	public PageInfo pageInfoService(int pageSize,int pageNumber,String stuid,String couname,String teacher) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		CouMapper coumapper = session.getMapper(CouMapper.class);
		//��ʼҳ
		int pageStart=pageSize*(pageNumber-1);
		//����ҳ
		int pageEnd=pageSize+pageSize*(pageNumber-1);
		//��ѯ��ǰҳ���γ�
		List<Courses> listCou = coumapper.selAll(pageStart,pageEnd,couname,teacher);
		for(Courses ListCou:listCou){
			ListCou.setOptCou("NOT_OPT");
		}
		//��ѯ��ҳѧ����ѡ�Ŀ�
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
		
		//��ѯ�γ���ҳ��
		int count=coumapper.selCount(couname,teacher);
		pageinfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		//���õ�ǰҳ��
		pageinfo.setPageNumber(pageNumber);
		//���õ�ǰҳ��������
		pageinfo.setPageSize(pageSize);
		
		session.close();	
		return pageinfo;
	}
    /**
     * ѡ��ָ���Ŀγ�
     * @throws IOException 
     */
	@Override
	public int optCouService(String couid, String stuid) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBatis.xml");
		//ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
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
