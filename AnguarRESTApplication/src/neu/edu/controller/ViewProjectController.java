package neu.edu.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import neu.edu.bean.CartBean;
import neu.edu.bean.ProjectCategoriesBean;
import neu.edu.bean.ProjectServicesBean;
import neu.edu.bean.UserAccountBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.bean.UserSessionInfo;
import neu.edu.controller.error.ResponseError;
import neu.edu.controller.input.UserLoginBean;
import neu.edu.service.ProjectService;

@Controller
@PermitAll
@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ViewProjectController {
	
	
	@Autowired
	private ProjectService projectService;
	
	@GET
	@PermitAll
	public Response getAllProjectsCategories(){
		
		List<ProjectCategoriesBean> userProjectCategoriesBeans =  projectService.getAllProjectsCategories();
		return  Response.ok().status(200).entity(userProjectCategoriesBeans).build();
		
	}
	
	@GET
	@PermitAll
	@Path("/categoryGuest")
	public Response getAllProjectsCategoriesActive(){
		
		List<ProjectCategoriesBean> userProjectCategoriesBeans =  projectService.getAllProjectsCategoriesActive();
		return  Response.ok().status(200).entity(userProjectCategoriesBeans).build();
		
	}

	@POST
	@PermitAll
	@Path("/submitProject")
	public Response submitProject(UserProjectBean userProjectBean) {
		System.out.println("Service is called");


		projectService.submitProject(userProjectBean);
        System.out.println("Inside submit");
		return  Response.ok().status(200).build();


	}
	
	@POST
	@PermitAll
	@Path("/buyThisService")
	public Response buyThisService(CartBean cartBean) {
		System.out.println("Service is called");


		projectService.buyThisService(cartBean);
        System.out.println("Inside submit");
		return  Response.ok().status(200).build();


	}
	
	@POST
	@PermitAll
	@Path("/submitServices")
	public void submitServices(ProjectServicesBean projectServicesBean) {
		System.out.println("Service is called");
		projectService.submitServices(projectServicesBean);
	}
	
	@POST
	@RolesAllowed({ "admin" })
	@Path("/update")
	public void updateCategories(ProjectCategoriesBean projectCategoriesBean) {

		projectService.updateCategories(projectCategoriesBean);

		

	}
	
	@POST
	@RolesAllowed({ "admin" })
	@Path("/delete")
	public void deleteCategories(ProjectCategoriesBean projectCategoriesBean) {

		projectService.deleteCategories(projectCategoriesBean);

		

	}
	@POST
	@PermitAll
	@Path("/project/delete")
	public void deleteProject(UserProjectBean userProjectBean) {

		projectService.deleteProject(userProjectBean);

		

	}
	@POST
	@RolesAllowed({ "admin" })
	@Path("/add")
	public void addCategory(ProjectCategoriesBean projectCategoriesBean) {

		projectService.addCategory(projectCategoriesBean);

		

	}

	


}
