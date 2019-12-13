package org.iiitb.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@PersistenceContext(type = PersistenceContextType.EXTENDED)
@Table(name="CourseStudent")
public class CourseStudent implements Serializable{
    @EmbeddedId
    private CourseStudentPK id;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name="COURSE_ID")
    private Course course;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @Column(name = "grade")
    private int grade;

    public CourseStudentPK getId() {
        return id;
    }

    public void setId(CourseStudentPK id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}