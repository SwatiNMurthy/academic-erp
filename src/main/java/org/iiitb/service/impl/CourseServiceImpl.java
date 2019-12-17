package org.iiitb.service.impl;

import org.iiitb.bean.Course;
import org.iiitb.bean.Student;
import org.iiitb.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Override
    public void save(Course course) {
        coursedao.save(course);
    }

    @Override
    public List<Student> getCourseStudents() {
        return coursedao.getCourseStudents();
    }

    @Override
    public List<Course> getCourses() {
        return coursedao.getCourses();
    }
}
