package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Domain;
import org.iiitb.service.DomainService;
import org.iiitb.service.impl.DomainServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Path("/domain")
public class DomainController {
    private DomainService domainService = new DomainServiceImpl();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response listDomains() {
        
        List<Domain> domains = domainService.findAll();
        
        return Response.ok().entity(domains).build();
    }

    @POST
    @Path("/addDomain")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addDomain(@FormDataParam("domainBranch") String branch,
                          @FormDataParam("domainDiscipline") String discipline) throws URISyntaxException {
        System.out.println(branch+","+","+discipline);
        Domain domain = new Domain();
        domain.setBranch(branch);
        domain.setDiscipline(discipline);

        if (branch.equals("Computer Science and Engineering")) {
            domain.setCode("CSE");
        } else {
            domain.setCode("ECE");
        }
        domainService.save(domain);
        return Response.seeOther(new URI("/academic_erp_war/adminActions.html")).build();
    }
}
