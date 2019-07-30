package com.yuanxueqi.studentsystem.demo.service;

import com.yuanxueqi.studentsystem.demo.pojo.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudentInfoServiceTest {

  @Autowired
  StudentInfoService studentInfoService;

  @Test
  public void create() {
    Student student = Student.builder()
        .age(11)
        .name("marry")
        .phone("177")
        .sex("female")
        .build();
    Assert.assertEquals(studentInfoService.insertInfo(student), "success!");
    Student student_wrong = Student.builder()
        .age(11)
        .name("marry")
        .phone("177")
        .sex("xxx")
        .build();
    Assert.assertEquals(studentInfoService.insertInfo(student_wrong), "please input male or female ");

  }

//  @Test
//  public void get() {
//    Assert.assertEquals(studentInfoService.getById(1).getAge().intValue(),12);
//  }
}
