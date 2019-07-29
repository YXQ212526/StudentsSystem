package com.yuanxueqi.studentsystem.demo.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanxueqi.studentsystem.demo.dao.LiveOrDieMapper;

import org.springframework.stereotype.Service;

@Service
public class LiveOrDieService {

  @Resource
  LiveOrDieMapper liveOrDieMapper;

  public Integer create(int studentId, String name) {
    return liveOrDieMapper.create(studentId, name);

  }

  public List<String> liveOrDie(int studentId) {
    return liveOrDieMapper.select(studentId);
  }
}
