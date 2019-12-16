package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class StudentDao {
    public void save(Student student) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(student);
        
        transaction.commit();
        session.close();
    }
    
    public Student find(Integer id) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        Student student = session.get(Student.class, id);
        
        transaction.commit();
        session.close();
        return student;
    }
    
    public Student findByRollNumber(String rollNumber) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "FROM Student WHERE rollNumber = :roll_number";
        Query query = session.createQuery(hql);
        query.setParameter("roll_number", rollNumber);
        Student student = (Student) query.getSingleResult();
        
        transaction.commit();
        session.close();
        return student;
    }
    
    public List<Student> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        List<Student> studentList = query.list();
        
        transaction.commit();
        session.close();
        return studentList;
    }
    
    public String getLastRollNumber(Domain domain) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
    
        String hql = "SELECT s.rollNumber FROM Student s WHERE s.domain = :givenDomain ORDER BY s.rollNumber DESC";
        Query query = session.createQuery(hql);
        query.setParameter("givenDomain", domain);
        String rollNumber = null;
    
        if (!query.list().isEmpty())
            rollNumber = (String) query.list().get(0);
    
        transaction.commit();
        session.close();
        return rollNumber;
    }

    public String generateRollNumber(Domain domain) {
        String lastRollNumber = getLastRollNumber(domain);
        Integer newSerialNumber;
        if (lastRollNumber == null)
            newSerialNumber = 1;
        else {
            String serialNumber = lastRollNumber.substring(lastRollNumber.length() - 3);
            newSerialNumber = Integer.parseInt(serialNumber) + 1;
        }
        String tempSerialNumber = newSerialNumber.toString();
        switch (tempSerialNumber.length()) {
            case 1:
                tempSerialNumber = "00" + tempSerialNumber;
                break;
            case 2:
                tempSerialNumber = "0" + tempSerialNumber;
                break;
            default:
                break;
        }
        String currentYear = new SimpleDateFormat("yyyy").format(new Date());
        String newRollNumber = domain.getCode() + currentYear + tempSerialNumber;
        return newRollNumber;
    }

    public boolean validate(String username, String password) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT s.password FROM Student s WHERE s.username=:username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);

        String pwd = (String)query.list().get(0);
        transaction.commit();
        session.close();

        if (pwd.equals(password))
            return true;
        return false;
    }
}