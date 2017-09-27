package neu.edu.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import neu.edu.bean.ProjectServicesBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.service.ProjectService;

@Controller
@PermitAll
@Path("/project/{projectId}/viewServicesGuest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProjectController4 {
	
	
	@Autowired
	private ProjectService projectService;
	
	@GET
	@PermitAll
	public Response viewAllServicesActive(@PathParam("projectId") Integer projectId){
		
		List<ProjectServicesBean> projectServiceBean =  projectService.viewAllServicesActive(projectId);
		return  Response.ok().status(200).entity(projectServiceBean).build();
		
			
		
	}
	

}
