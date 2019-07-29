package com.yuanxueqi.studentsystem.demo.service;

import javax.annotation.Resource;

import com.yuanxueqi.studentsystem.demo.dao.StudentInfoMapper;
import com.yuanxueqi.studentsystem.demo.pojo.Student;

import org.springframework.stereotype.Service;

@Service
public class StudentInfoService {

  @Resource
  StudentInfoMapper studentInfoMapper;

  public int insertInfo(Student student) {
    return studentInfoMapper.insertInfo(student);
  }

  public Student getById(int id) {
    return studentInfoMapper.getById(id) == null ? null : studentInfoMapper.getById(id);

  }

  public int updatePhoneById(int id, String phone) {
    return studentInfoMapper.updatePhoneById(id, phone);
  }

}
