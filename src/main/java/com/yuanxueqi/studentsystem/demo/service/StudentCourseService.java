package com.yuanxueqi.studentsystem.demo.service;


import javax.annotation.Resource;

import com.yuanxueqi.studentsystem.demo.dao.CourseMapper;
import com.yuanxueqi.studentsystem.demo.dao.StudentCourseMapper;
import com.yuanxueqi.studentsystem.demo.dao.StudentInfoMapper;



import org.springframework.stereotype.Service;
@Service
public class StudentCourseService {

  @Resource
  StudentCourseMapper studentCourseMapper;
  @Resource
  StudentInfoMapper studentInfoMapper;

  @Resource
  CourseMapper courseMapper;

  public String studentSelectCourse(Integer studentId, Integer courseId) {

    if (studentInfoMapper.getById(studentId) == null || courseMapper.showCourse(courseId) == null) {
      return "failed!";
    }

    return studentCourseMapper.create(studentId, courseId) == 1 ? "success!" : "failed!";

  }


}
