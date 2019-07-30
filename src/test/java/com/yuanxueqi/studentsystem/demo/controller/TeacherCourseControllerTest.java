package com.yuanxueqi.studentsystem.demo.controller;

import java.util.HashMap;
import java.util.Map;

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
public class TeacherCourseControllerTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Autowired
  CourseService courseService;

  private final static String URL = "/teacher";
  private final static int CODE = 200;

  @Test
  public void insert() {
    courseService.create("math");
    MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
    map.add("courseId", 1);
    map.add("name", "jim");
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URL + "", map, String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

}
