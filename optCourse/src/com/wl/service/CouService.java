package com.wl.service;

import java.io.IOException;

import com.wl.pojo.PageInfo;

public interface CouService {
	PageInfo pageInfoService(int pageSize,int pageNumber,String stuid,String couname,String teacher) throws IOException;

	int optCouService(String couid, String stuid) throws IOException;

}
