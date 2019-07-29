package com.yuanxueqi.studentsystem.demo.enums;

public enum Sex {
  MALE("male"),
  FEMALE("female");
  private final String sex;

  Sex(String sex) {
    this.sex = sex;
  }

  public static boolean judge(String in) {
    for (Sex sex : Sex.values()) {
      if (sex.sex.equals(in.toLowerCase())) {
        return true;
      }

    }
    return false;
  }

}
