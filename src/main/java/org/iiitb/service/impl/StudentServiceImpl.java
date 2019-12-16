package org.iiitb.service.impl;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Faculty;
import org.iiitb.bean.Student;
import org.iiitb.service.StudentService;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    
    @Override
    public void save(Student student) {
        studentDao.save(student);
        /*Domain domain = domainService.find(domainId);
        student.setDomain(domain);
        
        String rollNumber = generateRollNumber(domain);
        student.setRollNumber(rollNumber);
    
        String photographPath = "images/student/" + rollNumber + "_" + fileDetail.getFileName();
        if (!fileService.upload(photograph, photographPath))
            System.out.println("File Upload Error!");
        else {
            student.setPhotograph(photographPath);
            studentDao.save(student);
        }*/
    }
    
    @Override
    public Student find(Integer id) {
        return studentDao.find(id);
    }
    
    @Override
    public Student findByRollNumber(String rollNumber) {
        return studentDao.findByRollNumber(rollNumber);
    }
    
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
    
    @Override
    public String generateRollNumber(Domain domain) {
        return studentDao.generateRollNumber(domain);
    }

    @Override
    public boolean validate(String username, String password){ return studentDao.validate(username, password);}


}
