package com.yuanxueqi.studentsystem.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LiveOrDieMapper {

  Integer create(Integer studentId, String name);

  List<String> select(Integer studentId);

}
