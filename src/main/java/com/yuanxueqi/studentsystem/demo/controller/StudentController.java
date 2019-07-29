package com.yuanxueqi.studentsystem.demo.controller;

import com.yuanxueqi.studentsystem.demo.pojo.Student;
import com.yuanxueqi.studentsystem.demo.service.StudentCourseService;
import com.yuanxueqi.studentsystem.demo.service.StudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Api(description = "学生相关")
public class StudentController {

  @Autowired
  private StudentInfoService studentInfoService;
  @Autowired
  public StudentCourseService studentCourseService;

  @ApiOperation("根据学生ID获取详细信息")
  @GetMapping("/get/{studentId}")
  public Student getById(@PathVariable(value = "studentId") int studentId) {
    return studentInfoService.getById(studentId);
  }

  @ApiOperation("根据学生ID改学生电话号")
  @PostMapping("/update")
  public int updatePhoneById(@RequestParam(name = "studentId") Integer studentId,
      @RequestParam(name = "newPhone") String newPhone) {
    return studentInfoService.updatePhoneById(studentId, newPhone);
  }

  @ApiOperation("新增学生信息")
  @PostMapping("/insert")
  public int insertInfo(@RequestBody Student student) {
    return studentInfoService.insertInfo(student);
  }

  @ApiOperation("新增学生选课")
  @PostMapping("/course")
  public String studentSelectCourse(@ApiParam("学生ID") @RequestParam(name = "studentId") Integer studentId,
      @RequestParam(name = "courseId") @ApiParam("课程ID") Integer courseId) {
    return studentCourseService.studentSelectCourse(studentId, courseId);
  }

}
