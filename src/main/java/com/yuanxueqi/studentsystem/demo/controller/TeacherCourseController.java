package com.yuanxueqi.studentsystem.demo.controller;

import com.yuanxueqi.studentsystem.demo.service.TeacherCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "教师选课")
@RestController
public class TeacherCourseController {

  @Autowired
  TeacherCourseService teacherCourseService;

  @ApiOperation("需要提供课程ID以及教师名字")
  @PostMapping("/teacher")
  String addTeacherCourse(Integer courseId, String name) {
    return teacherCourseService.addTeacherCourse(courseId, name);
  }

}
