package com.yuanxueqi.studentsystem.demo.dao;

import java.util.List;

import com.yuanxueqi.studentsystem.demo.POJO.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {

  Integer create(String name);

  Integer delete(Integer id);

  Integer changeName(Integer id,String name);

  Course showCourse(Integer id);

  List<Course> showCourses();

}
