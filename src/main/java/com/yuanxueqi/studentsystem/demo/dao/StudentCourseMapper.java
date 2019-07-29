package com.yuanxueqi.studentsystem.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentCourseMapper {

  Integer create(Integer studentId, Integer courseId);
  List<Integer> findBySId( Integer courseId);
}
