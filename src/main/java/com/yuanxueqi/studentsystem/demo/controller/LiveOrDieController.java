package com.yuanxueqi.studentsystem.demo.controller;

import java.util.List;


import com.yuanxueqi.studentsystem.demo.service.LiveOrDieSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "生死表")
public class LiveOrDieController {

  @Autowired
  LiveOrDieSerivce liveOrDieSerivce;

  @ApiOperation("输入学生ID查看所有授课老师")
  @GetMapping("/live/die/{id}")
  List<String> liveOrDie(@PathVariable("id") int id) {
    return liveOrDieSerivce.liveOrDie(id);
  }

}
