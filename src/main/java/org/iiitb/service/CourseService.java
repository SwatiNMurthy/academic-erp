package org.iiitb.service;

import org.iiitb.bean.Course;
import org.iiitb.dao.CourseDao;

public interface CourseService {
    CourseDao coursedao = new CourseDao();

    void save(Course course);
}
