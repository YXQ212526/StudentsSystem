package com.yuanxueqi.studentsystem.demo.dao;

import com.yuanxueqi.studentsystem.demo.POJO.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentInfoMapper {

  Integer insertInfo(Student student);

  Student getById(Integer id);

  Integer updatePhoneById(Integer id,String phone);

}
