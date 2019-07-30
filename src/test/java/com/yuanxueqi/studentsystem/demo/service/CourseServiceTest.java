package com.yuanxueqi.studentsystem.demo.service;

import java.util.List;

import com.yuanxueqi.studentsystem.demo.pojo.Course;
import org.junit.Assert;
import org.junit.Before;
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

  @Before
  public void set_up(){
    courseService.create("math");
    courseService.create("English");
  }
  @Test
  public void create() {
    String str = courseService.create("biology");
    Assert.assertEquals(str, "success!");

  }

  @Test
  public void delete() {
    String res = courseService.delete(2);
    Assert.assertEquals(res, "success!");
  }


  @Test
  public void change_name() {


    String res = courseService.changeName(1, "xxx");
    Assert.assertEquals(res, "success!");
  }


  @Test
  public void show_course() {
    Assert.assertEquals(courseService.showCourse(1).getName(),"xxx");
  }

  @Test
  public void show_courses() {
    List<Course> res = courseService.showCourses();
    Assert.assertTrue(res.size()>0);
  }
}
