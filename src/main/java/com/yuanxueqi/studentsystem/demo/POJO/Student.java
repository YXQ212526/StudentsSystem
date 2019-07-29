package com.yuanxueqi.studentsystem.demo.POJO;

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

  public Integer id;
  public String name;
  public String sex;
  public Integer age;
  public String phone;

}
