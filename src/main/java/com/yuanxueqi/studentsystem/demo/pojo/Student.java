package com.yuanxueqi.studentsystem.demo.pojo;

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

  private Integer id;
  private String name;
  private String sex = "female";
  private Integer age;
  private String phone;

}
