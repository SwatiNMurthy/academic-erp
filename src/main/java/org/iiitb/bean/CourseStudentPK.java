package org.iiitb.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseStudentPK implements Serializable {
    @Column(name = "COURSE_ID")
    private int  courseId;

    @Column(name = "STUDENT_ID")
    private int studentId;
}
