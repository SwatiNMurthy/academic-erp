package org.iiitb.service;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.iiitb.bean.Course;
import org.iiitb.bean.Faculty;
import org.iiitb.bean.Student;
import org.iiitb.dao.FacultyDao;
import org.iiitb.dao.StudentDao;
import org.iiitb.service.impl.DomainServiceImpl;
import org.iiitb.service.impl.FileServiceImpl;

import java.io.InputStream;
import java.util.List;

public interface FacultyService {

    StudentDao studentDao = new StudentDao();
    FacultyDao facultyDao = new FacultyDao();

    FileService fileService = new FileServiceImpl(); //Later use it for image


    boolean validate(String username, String password);

    //List<Course> findCourses(String username);

    List<Student> findStudents();

    List<Course> findCoursesAll();

    void save(String s);

}
