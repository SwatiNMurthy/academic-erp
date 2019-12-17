package org.iiitb.controller;

import org.iiitb.bean.Course;
import org.iiitb.bean.Student;
import org.iiitb.service.CourseService;
import org.iiitb.service.impl.CourseServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/course")
public class CourseController {
    CourseService courseService = new CourseServiceImpl();

    @GET
    @Path("/getCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showAllCourses() {
        List<Course> courseList = courseService.getCourses();
        if (courseList == null)
            return Response.noContent().build();
        return Response.ok().entity(courseList).build();
    }

    @GET
    @Path("/getCourseStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents () {
        List<Student> studentList = courseService.getCourseStudents();
        if (studentList == null)
            return Response.noContent().build();
        return Response.ok().entity(studentList).build();
    }
}
