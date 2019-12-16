package org.iiitb.service.impl;

import org.iiitb.bean.Course;
import org.iiitb.service.CourseService;

public class CourseServiceImpl implements CourseService {

    @Override
    public void save(Course course) {
        coursedao.save(course);
    }
}
