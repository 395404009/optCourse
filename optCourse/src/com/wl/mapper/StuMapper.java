package com.wl.mapper;

import org.apache.ibatis.annotations.Param;

import com.wl.pojo.Students;

public interface StuMapper {
     Students selByNamePwd(@Param("stuname") String stuname,@Param("stupwd") String stupwd);
     Students selByName(@Param("stuname") String stuname);
	 int insStu(@Param("stuid") String stuid,@Param("stuname") String stuname,@Param("pwd") String pwd,@Param("sex") String sex,
			@Param("stuinstitute") String stuinstitute);
	Students selByRegStuid(@Param("stuid") String stuid);
     
}
