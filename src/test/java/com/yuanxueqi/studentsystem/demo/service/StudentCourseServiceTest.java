package com.yuanxueqi.studentsystem.demo.service;


import com.yuanxueqi.studentsystem.demo.pojo.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudentCourseServiceTest {

  @Autowired
  StudentCourseService studentCourseService;
  @Autowired
  StudentInfoService studentInfoService;
  @Autowired
  CourseService courseService;
  Student student = Student
      .builder()
      .age(11)
      .sex("male")
      .name("xiao")
      .phone("111")
      .build();

  @Before
  public void set_up() {

    studentInfoService.insertInfo(student);

    courseService.create("math");

  }

  @Test
  public void create() {

    Assert.assertEquals(studentCourseService.studentSelectCourse(-1, 1), "failed!");
    Assert.assertEquals(studentCourseService.studentSelectCourse(student.getId(), 1), "success!");


  }

}
