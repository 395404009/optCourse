package com.wl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wl.pojo.Courses;


public interface CouMapper {
	/**
	 * 查询当前页数所有课程
	 * @param pageStart
	 * @param pageEnd
	 * @return
	 */
	List<Courses> selAll(@Param("pageStart") int pageStart,@Param("pageEnd") int pageEnd,@Param("couname")String couname,@Param("teacher")String teacher);
	/**
	 * 查询所有课程的总数
	 * @return
	 */
	int selCount(@Param("couname")String couname,@Param("teacher")String teacher);
	/**
	 * 查询该学生的选课信息
	 * @param stuid
	 * @return
	 */
	List<Courses> selByStuid(@Param("pageStart") int pageStart,@Param("pageEnd") int pageEnd,@Param("stuid") String stuid,@Param("couname")String couname,@Param("teacher")String teacher);
	/**
	 * 学生选择指定课程
	 * @param couid
	 * @param stuid
	 * @return
	 */
	int inseCouByCouidStuid(@Param("couid")String couid, @Param("stuid")String stuid);

}
