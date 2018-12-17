package com.wl.mapper;

import org.apache.ibatis.annotations.Param;

public interface DelCouMapper {
    int delCouByCouid(@Param("stuid")String stuid,@Param("couid")String couid);
}
