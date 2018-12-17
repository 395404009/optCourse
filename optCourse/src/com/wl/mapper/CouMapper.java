package com.wl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wl.pojo.Courses;


public interface CouMapper {
	/**
	 * ��ѯ��ǰҳ�����пγ�
	 * @param pageStart
	 * @param pageEnd
	 * @return
	 */
	List<Courses> selAll(@Param("pageStart") int pageStart,@Param("pageEnd") int pageEnd,@Param("couname")String couname,@Param("teacher")String teacher);
	/**
	 * ��ѯ���пγ̵�����
	 * @return
	 */
	int selCount(@Param("couname")String couname,@Param("teacher")String teacher);
	/**
	 * ��ѯ��ѧ����ѡ����Ϣ
	 * @param stuid
	 * @return
	 */
	List<Courses> selByStuid(@Param("pageStart") int pageStart,@Param("pageEnd") int pageEnd,@Param("stuid") String stuid,@Param("couname")String couname,@Param("teacher")String teacher);
	/**
	 * ѧ��ѡ��ָ���γ�
	 * @param couid
	 * @param stuid
	 * @return
	 */
	int inseCouByCouidStuid(@Param("couid")String couid, @Param("stuid")String stuid);

}
