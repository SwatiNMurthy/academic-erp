package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.iiitb.bean.Course;
import org.iiitb.util.SessionUtil;

public class CourseDao {
    public void save(Course course) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(course);

        transaction.commit();
        session.close();
    }
}
