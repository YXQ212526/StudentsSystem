package com.yuanxueqi.studentsystem.demo.service;

import java.util.List;

import javax.annotation.Resource;


import com.yuanxueqi.studentsystem.demo.dao.CourseMapper;
import com.yuanxueqi.studentsystem.demo.dao.StudentCourseMapper;
import com.yuanxueqi.studentsystem.demo.dao.StudentInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger("StudentCourseService.class");
    if (studentId == null || courseId == null) {
      logger.info("input null!!!");
    }
    if (studentInfoMapper.getById(studentId) == null || courseMapper.showCourse(courseId) != null) {
      return "failed!";
    }

    return studentCourseMapper.create(studentId, courseId) == 1 ? "success!" : "failed!";

  }



}
