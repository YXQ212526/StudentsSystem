package com.yuanxueqi.studentsystem.demo.controller;

import java.util.List;


import com.yuanxueqi.studentsystem.demo.pojo.Course;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "课程")
@RestController
@RequestMapping("/course")

public class CourseController {

  @Autowired
  private CourseService courseService;

  @ApiOperation("建课")
  @PostMapping("/create")
  public String createCourse(@RequestParam(name = "name") String name) {

    return courseService.create(name);
  }

  @ApiOperation("改课名")
  @PostMapping("/update")
  public String changeCourseName(@ApiParam("课程ID") @RequestParam(name = "CourseId") Integer CourseId,
      @ApiParam("新名字") @RequestParam(name = "name") String name) {
    return courseService.changeName(CourseId, name);
  }

  @ApiOperation("删课")
  @DeleteMapping("/delete")
  public String deleteCourse(@ApiParam("课程ID") @RequestParam(name = "CourseId") Integer CourseId) {
    return courseService.delete(CourseId);
  }

  @ApiOperation("根据课程ID显示课名")
  @GetMapping("/{CourseId}")
  public Course showCourse(@PathVariable("CourseId") Integer CourseId) {
    return courseService.showCourse(CourseId);
  }

  @ApiOperation("显示全部课程")
  @GetMapping("/list")
  public List<Course> showCourses() {

    return courseService.showCourses();

  }
}