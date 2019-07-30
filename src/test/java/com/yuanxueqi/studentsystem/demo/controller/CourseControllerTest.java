package com.yuanxueqi.studentsystem.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.yuanxueqi.studentsystem.demo.pojo.Student;
import org.junit.Assert;
import org.junit.Before;
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
public class CourseControllerTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  private final static String URL = "/course";
  private final static int CODE = 200;


  @Test
  public void create() {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("name", "math");
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URL + "/create", map, String.class);
    ResponseEntity<String> responseEntity1 = testRestTemplate.postForEntity(URL + "/create", map, String.class);
    ResponseEntity<String> responseEntity2 = testRestTemplate.postForEntity(URL + "/create", map, String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);
    Assert.assertEquals(responseEntity1.getStatusCodeValue(), CODE);
    Assert.assertEquals(responseEntity2.getStatusCodeValue(), CODE);
  }

  @Test
  public void change_name() {

    MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
    map.add("CourseId", 1);
    map.add("name", "eng");
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URL + "/update", map, String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

  @Test
  public void delete() {
//    MultiValueMap<String, Integer> map = new LinkedMultiValueMap<>();
//    map.add("CourseId", 1);
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URL + "/delete?CourseId=3", String.class, String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);
  }

  @Test
  public void show_course() {
    ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(URL + "/1", String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);


  }

  @Test
  public void show_courses() {
    ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(URL + "/list", String.class);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), CODE);

  }

}
