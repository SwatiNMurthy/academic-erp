package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Course;
import org.iiitb.bean.Faculty;
import org.iiitb.bean.Student;
import org.iiitb.service.FacultyService;
import org.iiitb.service.impl.FacultyServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Path("/faculty")
public class FacultyController {
    private FacultyService facultyService = new FacultyServiceImpl();
    @POST
    @Path("/login")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@FormDataParam("username") String username,
                             @FormDataParam("password") String password) throws URISyntaxException{
        //System.out.println(username+"--------------"+password);
        boolean valid =  facultyService.validate(username, password);
        if (valid) {
            return Response.seeOther(new URI("/academic_erp_war/courselist.html")).build();
            //return Response.ok().build();
        }

        return Response.status(401, "Wrong username or password").build();
    }

    @POST
    @Path("/signup")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addStudent(@FormDataParam("firstName") String firstName,
                               @FormDataParam("lastName") String lastName,
                               @FormDataParam("username") String username,
                               @FormDataParam("password") String password,
                               @FormDataParam("secretKey") String secretKey)
                               throws URISyntaxException {
        Faculty faculty = new Faculty();
        String name = firstName + " " + lastName;
        faculty.setName(name);
        faculty.setUsername(username);
        faculty.setPassword(password);

        //System.out.println(username+"*****"+password+"*******"+secretKey);

        facultyService.save(faculty);

        return Response.seeOther(new URI("/academic_erp_war/login.html")).build();
    }

    /*@POST
    @Path("/login")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response login(@FormDataParam("username")String username,
                          @FormDataParam("password")String password) {
        //System.out.println(username+"==="+password);
        boolean valid =  facultyService.validate(username, password);
        System.out.println(valid);
        if (valid) {
            return Response.ok().build();
        }

        return Response.status(401, "Wrong username or password").build();
    }*/

    /*@POST
    @Path("/getCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showCourses (@FormDataParam("username") String username) {
        List<Course> courseList = facultyService.findCourses(username);
        if (courseList == null)
            return Response.noContent().build();
        return Response.ok().entity(courseList).build();
    }*/


    @POST
    @Path("/updateGrade")
    public void updateGrade(String obj) {
        facultyService.updateGrade(obj);
    }
}
