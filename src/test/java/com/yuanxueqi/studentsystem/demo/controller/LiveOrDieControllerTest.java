package com.yuanxueqi.studentsystem.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.yuanxueqi.studentsystem.demo.pojo.Student;
import com.yuanxueqi.studentsystem.demo.service.CourseService;
import com.yuanxueqi.studentsystem.demo.service.StudentCourseService;
import com.yuanxueqi.studentsystem.demo.service.StudentInfoService;
import com.yuanxueqi.studentsystem.demo.service.TeacherCourseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LiveOrDieControllerTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Autowired
  StudentInfoService studentInfoService;
  @Autowired
  CourseService courseService;
  @Autowired
  StudentCourseService studentCourseService;
  @Autowired
  TeacherCourseService teacherCourseService;

  private final static int CODE = 200;

  @Test
  public void live_die() {

    studentInfoService.insertInfo(Student.builder()
        .age(11)
        .name("marry")
        .phone("177")
        .sex("female")
        .build());
    courseService.create("math");

    studentCourseService.studentSelectCourse(1,1);
    teacherCourseService.addTeacherCourse(1,"jim");
    ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/live/die/1", String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

}
