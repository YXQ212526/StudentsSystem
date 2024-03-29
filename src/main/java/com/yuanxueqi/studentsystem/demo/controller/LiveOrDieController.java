package com.yuanxueqi.studentsystem.demo.controller;

import java.util.List;


import com.yuanxueqi.studentsystem.demo.service.LiveOrDieService;
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
  private LiveOrDieService liveOrDieService;

  @ApiOperation("输入学生ID查看所有授课老师")
  @GetMapping("/live/die/{studentId}")
  public List<String> liveOrDie(@PathVariable("studentId") int studentId) {
    return liveOrDieService.liveOrDie(studentId);
  }

}
