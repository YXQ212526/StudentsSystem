package com.yuanxueqi.studentsystem.demo.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanxueqi.studentsystem.demo.pojo.Course;
import com.yuanxueqi.studentsystem.demo.dao.CourseMapper;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Resource
  CourseMapper courseMapper;

  public String create(String name) {

    return courseMapper.create(name) == 1 ? "success!" : "fail!";
  }

  public String delete(int id) {
    return courseMapper.delete(id) == 1 ? "success!" : "fail!";
  }

  public String changeName(int id, String name) {
    return courseMapper.changeName(id, name) == 1 ? "success!" : "fail!";
  }

  public Course showCourse(int id) {
    return courseMapper.showCourse(id);
  }


  public List<Course> showCourses() {
    return courseMapper.showCourses();
  }
}
