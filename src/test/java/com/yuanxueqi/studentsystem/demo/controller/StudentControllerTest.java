package com.yuanxueqi.studentsystem.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Multimap;

import com.yuanxueqi.studentsystem.demo.pojo.Student;
import com.yuanxueqi.studentsystem.demo.service.CourseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudentControllerTest {

  @Autowired
  TestRestTemplate testRestTemplate;
  @Autowired
  CourseService courseService;

  private final static String URL = "/student";
  private final static int CODE = 200;
  public final static Student student = Student
      .builder()
      .sex("male")
      .phone("111")
      .name("jim")
      .age(11)
      .build();


  @Test
  public void insert_student() {

    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URL + "/insert", student, String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

  @Test
  public void change_phone() {

    MultiValueMap<String, String > map = new LinkedMultiValueMap<>();
    map.add("studentId", "1");
    map.add("newPhone", "123");
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URL + "/update", map, String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

  @Test
  public void select_course() {
    courseService.create("math");
    MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
    map.add("studentId", "1");
    map.add("courseId", "1");
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URL + "/course", map, String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

  @Test
  public void get() {

    ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(URL + "/get/1", String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

}
