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
public class LiveOrDieServiceTest {

  @Autowired
  LiveOrDieService liveOrDieService;
  @Autowired
  StudentInfoService studentInfoService;
  @Autowired
  StudentCourseService studentCourseService;
  @Autowired
  TeacherCourseService teacherCourseService;
  @Autowired
  CourseService courseService;

  @Before
  public void set_up() {
    studentInfoService.insertInfo(Student.builder()
        .age(11)
        .name("marry")
        .phone("177")
        .sex("female")
        .build());
    courseService.create("math");
    studentCourseService.studentSelectCourse(1, 1);
    teacherCourseService.addTeacherCourse(1, "jim");

  }

  @Test
  public void live_die() {

    Assert.assertTrue(liveOrDieService.liveOrDie(1).size() > 0);
    Assert.assertEquals(liveOrDieService.liveOrDie(1).get(0) ,"jim");
  }

}
