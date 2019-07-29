package com.yuanxueqi.studentsystem.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherCourseMapper {
  Integer insert(Integer id,String name);

}
