package com.yuanxueqi.studentsystem.demo.service;

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
public class TeacherCourseServiceTest {

  @Autowired
  TeacherCourseService teacherCourseService;
  @Autowired
  CourseService courseService;

  @Before
  public void set_up() {

    courseService.create("math");

  }

  @Test
  public void add() {

    Assert.assertEquals(teacherCourseService.addTeacherCourse(1, "jim"), "success!");
    Assert.assertEquals(teacherCourseService.addTeacherCourse(0, "jim"), "没有这门课!");
  }

}
