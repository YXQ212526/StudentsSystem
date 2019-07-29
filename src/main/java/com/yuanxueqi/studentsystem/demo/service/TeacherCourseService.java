package com.yuanxueqi.studentsystem.demo.service;

import javax.annotation.Resource;

import com.yuanxueqi.studentsystem.demo.dao.CourseMapper;
import com.yuanxueqi.studentsystem.demo.dao.LiveOrDieMapper;
import com.yuanxueqi.studentsystem.demo.dao.StudentCourseMapper;
import com.yuanxueqi.studentsystem.demo.dao.TeacherCourseMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class TeacherCourseService {

  @Resource
  TeacherCourseMapper teacherCourseMapper;
  @Resource
  CourseMapper courseMapper;
  @Resource
  LiveOrDieMapper liveOrDieMapper;
  @Resource
  StudentCourseMapper studentCourseMapper;

  public String addTeacherCourse(Integer courseId, String name) {
    if (courseMapper.showCourse(courseId) == null) {
      return "没有这门课！";
    }

    if (teacherCourseMapper.insert(courseId, name) > 0) {
      if (!CollectionUtils.isEmpty(studentCourseMapper.findBySId(courseId))) {
       // studentCourseMapper.findBySId(courseId).stream().map((val) -> liveOrDieMapper.create(val, name));
        for (Integer val:studentCourseMapper.findBySId(courseId))
        {
          liveOrDieMapper.create(val,name);
        }
        return "success!";

      }
    }
    return "failed!";

  }

}
