package com.wl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wl.pojo.Courses;


public interface SelCouMapper {
	/**
	 * ͨ��ѧ��ID���Ҹ�ѧ��������ѡ����Ϣ
	 * @param stuid
	 * @return
	 */
      List<Courses> selCouByStuid(@Param("stuid")String stuid);
}
