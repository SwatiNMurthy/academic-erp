package org.iiitb.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.iiitb.bean.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionUtil {
    private static final SessionFactory sessionFactory;
    
    static {
        Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        try {
            Configuration configuration = new Configuration();
            
            configuration.addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Faculty.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(CourseStudent.class)
                    .addAnnotatedClass(CourseStudentPK.class);
            
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
