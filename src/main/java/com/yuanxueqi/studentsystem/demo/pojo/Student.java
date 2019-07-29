package com.yuanxueqi.studentsystem.demo.pojo;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Student {

  @ApiParam("学生ID")
  private Integer id;

  @ApiParam("学生名字")
  private String name;

  @ApiParam("学生性别")
  private String sex = "female";

  @ApiParam("学生年龄")
  private Integer age;

  @ApiParam("学生电话号码")
  private String phone;

}
