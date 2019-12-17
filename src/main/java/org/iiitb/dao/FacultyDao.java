package org.iiitb.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.*;
import org.iiitb.util.SessionUtil;

import java.util.List;


public class FacultyDao {
    public boolean validate(String username, String password) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT f.password FROM Faculty f WHERE f.username = :username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        boolean valid = false;
        String myPass="";

        if (!query.list().isEmpty())
            myPass = (String) query.list().get(0);
        if (myPass.equals(password)) {
            valid = true;
        }
        transaction.commit();
        session.close();
        System.out.println(valid);
        return valid;
    }

    public int findFacultyIdForUsername(String username) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT f.facultyId from Faculty f where f.username=:username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);

        int fid = 0;
        if (!query.list().isEmpty()) {
            fid = (Integer) query.list().get(0);
        }
        transaction.commit();
        session.close();
        return fid;
    }
    public Faculty findFacultyByFacultyID(int facultyId) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Faculty WHERE facultyId = :facultyId";
        Query query = session.createQuery(hql);
        query.setParameter("facultyId", facultyId);

        Faculty faculty=null;
        if (!query.list().isEmpty()) {
            faculty = (Faculty) query.list().get(0);
        }

        transaction.commit();
        session.close();

        return faculty;
    }
    /*public List<Course> findCourses (String username) {
        int fid = findFacultyIdForUsername(username);
        System.out.println("Faculty ID is : "+fid);
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //String hql = "FROM Course c, Faculty f WHERE f.username = :username and c.faculty=f.facultyId";
        String hql = "FROM Course c where c.faculty.facultyId="+fid;
        System.out.println(hql);
        Query query = session.createQuery(hql);
        //query.setParameter("username", username);
        List<Course> courseList = query.list();
        for (int i=0; i<courseList.size(); i++){
            System.out.println(courseList.get(i));
        }
        transaction.commit();
        session.close();
        return courseList;
    }*/

    public void updateGrade(String s) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            CourseStudent[] pp1 = mapper.readValue(s, CourseStudent[].class);

            //System.out.println("JSON array to Array objects..."+pp1);
            for (CourseStudent person : pp1) {
                Session session = SessionUtil.getSession();
                Transaction transaction = session.beginTransaction();

                System.out.println(person.getCourse().getCourseId()+" "+person.getStudent().getStudentId()+" "+person.getGrade());
                int cid = person.getCourse().getCourseId();
                int sid = person.getStudent().getStudentId();
                int grade = person.getGrade();
                String hql = "UPDATE CourseStudent SET grade=:grade WHERE COURSE_ID=:cid and STUDENT_ID=:sid";
                Query query = session.createQuery(hql);
                query.setParameter("grade", grade);
                query.setParameter("cid", cid);
                query.setParameter("sid", sid);

                query.executeUpdate();
                //session.save();
                transaction.commit();
                session.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void save(Faculty faculty) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(faculty);

        transaction.commit();
        session.close();
    }

    public List<Faculty> listAllFaculty() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT facultyId, name FROM Faculty";
        Query query = session.createQuery(hql);

        List<Faculty> faculties = query.list();
        transaction.commit();
        session.close();
        return faculties;
    }

    /*public Student find(Integer id) {
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
    }*/
}