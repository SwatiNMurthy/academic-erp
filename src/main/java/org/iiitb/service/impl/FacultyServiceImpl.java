package org.iiitb.service.impl;

import org.iiitb.bean.Course;
import org.iiitb.bean.Faculty;
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
    public void updateGrade(String s) {
        facultyDao.updateGrade(s);
    }

    @Override
    public void save(Faculty faculty) {facultyDao.save(faculty);}

    @Override
    public List<Faculty> listAllFaculty() {
        return facultyDao.listAllFaculty();
    }

    @Override
    public Faculty findFacultyByFacultyID(int facultyId) {
        return facultyDao.findFacultyByFacultyID(facultyId);
    }
}