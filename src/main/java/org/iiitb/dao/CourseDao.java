package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Course;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class CourseDao {
    public void save(Course course) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(course);

        transaction.commit();
        session.close();
    }

    public List<Student> getCourseStudents() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM CourseStudent";
        Query query = session.createQuery(hql);
        List<Student> studentList = query.list();

        transaction.commit();
        session.close();
        return studentList;
    }

    public List<Course> getCourses() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Course";
        Query query = session.createQuery(hql);
        List<Course> courseList = query.list();
        transaction.commit();
        session.close();
        return courseList;
    }
}
