package com.yuanxueqi.studentsystem.demo.service;

import java.util.List;

import com.yuanxueqi.studentsystem.demo.pojo.Course;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceTest {

  @Autowired
  CourseService courseService;

  @Test
  public void create() {
    String str = courseService.create("math");
    Assert.assertEquals(str, "success");
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
