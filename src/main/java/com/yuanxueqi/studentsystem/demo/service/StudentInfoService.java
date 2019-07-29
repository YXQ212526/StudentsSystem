package com.yuanxueqi.studentsystem.demo.service;

import javax.annotation.Resource;

import com.yuanxueqi.studentsystem.demo.dao.StudentInfoMapper;
import com.yuanxueqi.studentsystem.demo.enums.Sex;
import com.yuanxueqi.studentsystem.demo.pojo.Student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentInfoService {

  @Resource
  StudentInfoMapper studentInfoMapper;

  public String insertInfo(@RequestBody Student student) {
    if (!Sex.judge(student.getSex())) {
      return "please input male or female ";
    }
    return studentInfoMapper.insertInfo(student) == 1 ? "success!" : "failed!";
  }

  public Student getById(int id) {
    return studentInfoMapper.getById(id);

  }

  public String updatePhoneById(int id, String phone) {
    return studentInfoMapper.updatePhoneById(id, phone) == 1 ? "success!" : "failed!";
  }

}
