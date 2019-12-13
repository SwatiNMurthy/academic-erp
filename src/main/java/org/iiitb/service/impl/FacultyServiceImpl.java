package org.iiitb.service.impl;

import org.iiitb.bean.Course;
import org.iiitb.bean.Student;
import org.iiitb.dao.FacultyDao;
import org.iiitb.service.FacultyService;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    @Override
    public boolean validate(String username, String password) {
        return facultyDao.validate(username, password);
    }

   /* @Override
    public List<Course> findCourses(String username) {
        return facultyDao.findCourses(username);
    }*/

    @Override
    public List<Student> findStudents() {
        return facultyDao.findStudents();
    }

    @Override
    public List<Course> findCoursesAll() {
        return facultyDao.findCoursesAll();
    }

    @Override
    public void save(String s) {
        facultyDao.save(s);
    }
}