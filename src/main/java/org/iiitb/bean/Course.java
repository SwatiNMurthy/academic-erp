package org.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private int courseId;

    @NotBlank
    private String courseName;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /*@JsonIgnore
        @ManyToOne(fetch = FetchType.EAGER)*/
    @JoinColumn(name="facultyId")
    @ManyToOne
    private Faculty faculty = new Faculty();

    /*@JsonIgnore
    @ManyToMany(mappedBy = "course")
    private List<Student> student = new ArrayList<Student>();

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }*/
//
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<CourseStudent> courseStudent = new ArrayList<CourseStudent>();


    public List<CourseStudent> getCourseStudent() {
        return courseStudent;
    }

    public void setCourseStudent(List<CourseStudent> courseStudent) {
        this.courseStudent = courseStudent;
    }
//
    public Course() {
    }

    public Course(int id) {
        this.courseId = id;
    }

    public Course(int courseId, @NotBlank String courseName, Faculty faculty, List<CourseStudent> courseStudent) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.faculty = faculty;
        this.courseStudent = courseStudent;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}
