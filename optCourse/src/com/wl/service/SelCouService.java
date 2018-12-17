package com.wl.service;

import java.io.IOException;
import java.util.List;

import com.wl.pojo.Courses;
import com.wl.pojo.Students;

public interface SelCouService {

	List<Courses> selCourseByStu(Students stu) throws IOException;

	int delCouByCouid(String stuid, String couid) throws IOException;

}
