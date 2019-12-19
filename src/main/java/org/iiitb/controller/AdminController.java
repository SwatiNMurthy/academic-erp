package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Course;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Faculty;
import org.iiitb.dao.FacultyDao;
import org.iiitb.service.CourseService;
import org.iiitb.service.FacultyService;
import org.iiitb.service.impl.CourseServiceImpl;
import org.iiitb.service.impl.FacultyServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/admin")
public class AdminController {
    FacultyService facultyService = new FacultyServiceImpl();
    CourseService courseService = new CourseServiceImpl();

    @POST
    @Path("/login")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@FormDataParam("username") String username,
                          @FormDataParam("password") String password) throws URISyntaxException {
        //System.out.println("*********"+username+"**********"+password);
        if (password.equals("admin1")) {
            return Response.seeOther(new URI("/academic_erp_war/adminActions.html")).build();
        }
        else
            return Response.status(401, "Wrong Username or password").build();
    }

    @POST
    @Path("/addCourse")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addCourse (@FormDataParam("courseId") Integer courseId,
                               @FormDataParam("courseName") String courseName,
                               @FormDataParam("facultyId") Integer facultyId) throws URISyntaxException {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);

        System.out.println("CHOTA BHEEM "+facultyId);

        Faculty faculty = facultyService.findFacultyByFacultyID(facultyId);
        course.setFaculty(faculty);

        courseService.save(course);
        return Response.seeOther(new URI("/academic_erp_war/adminActions.html")).build();
    }
}
