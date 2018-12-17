package com.wl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wl.pojo.Courses;


public interface SelCouMapper {
	/**
	 * 通过学生ID查找该学生的所有选课信息
	 * @param stuid
	 * @return
	 */
      List<Courses> selCouByStuid(@Param("stuid")String stuid);
}
