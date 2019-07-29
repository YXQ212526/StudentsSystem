package com.yuanxueqi.studentsystem.demo.controller;

import java.util.List;


import com.yuanxueqi.studentsystem.demo.POJO.Course;
import com.yuanxueqi.studentsystem.demo.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "课程")
@RestController
@RequestMapping("/course")

public class CourseController {

  @Autowired
  CourseService courseService;

  @ApiOperation("建课")
  @PostMapping("/create")
  String createCourse(String name) {

    return courseService.create(name);
  }

  @ApiOperation("改课名")
  @PostMapping("/update")
  String changeCourseName(@ApiParam("课程ID") Integer id, @ApiParam("新名字") String name) {
    return courseService.changeName(id, name);
  }

  @ApiOperation("删课")
  @DeleteMapping("/delete")
  String deleteCourse(@ApiParam("课程ID") Integer id) {
    return courseService.delete(id);
  }

  @ApiOperation("根据课程ID显示课名")
  @GetMapping("/{id}")
  public Course showCourse(@PathVariable("id") Integer id) {
    return courseService.showCourse(id);
  }

  @ApiOperation("显示全部课程")
  @GetMapping("/list")
  public List<Course> showCourses() {

    return courseService.showCourses();

  }
}