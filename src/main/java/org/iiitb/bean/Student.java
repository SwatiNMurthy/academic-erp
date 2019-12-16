package org.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    
    @Column(unique = true)
    private String rollNumber;

    @NotBlank
    private String name;

    private String username;

    private String password;

    /*@JsonIgnore
    @ManyToMany
    @JoinTable(name="StudentCourse",
            joinColumns={@JoinColumn(name="studentId")},
            inverseJoinColumns={@JoinColumn(name="courseId")})
    private List<Course> course = new ArrayList<Course>();
    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }*/
//
    /*public Set<CourseStudent> getCourseStudent() {
        return courseStudent;
    }*/

    public void setCourseStudent(Set<CourseStudent> courseStudent) {
        this.courseStudent = courseStudent;
    }

    public Set<CourseStudent> getCourseStudent() {
        return courseStudent;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private Set<CourseStudent> courseStudent = new HashSet<CourseStudent>();
//
    public Student() {
    }

    public Student(Integer id) {
        this.studentId = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(String rollNumber, @NotBlank String name, String username, String password, Set<CourseStudent> courseStudent) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.username = username;
        this.password = password;
        this.courseStudent = courseStudent;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
