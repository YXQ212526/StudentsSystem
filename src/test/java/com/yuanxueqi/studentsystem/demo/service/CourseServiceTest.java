package com.yuanxueqi.studentsystem.demo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CourseServiceTest {

  @Autowired
  CourseService courseService;

  @Test
  public void create() {
    String str = courseService.create("math");
    Assert.assertEquals(str, "success!");
  }

//  @Test
//  public void delete() {
//    String res = courseService.delete(1);
//    Assert.assertEquals(res, "success");
//  }
//
//
//  @Test
//  public void change_name() {
//    String res = courseService.changeName(2, "english");
//    Assert.assertEquals(res, "success");
//  }
//
//
//  @Test
//  public void show_course() {
//    Course res = courseService.showCourse(2);
//    Assert.assertEquals(res.getName(), "english");
//  }
//
//  @Test
//  public void show_courses() {
//    List<Course> res = courseService.showCourses();
//    Assert.assertSame(res.size(), 3);
//  }
}
