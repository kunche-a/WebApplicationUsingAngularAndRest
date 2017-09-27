package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.bean.CartBean;
import neu.edu.bean.ProjectCategoriesBean;
import neu.edu.bean.ProjectServicesBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.dao.UserDAO;
import neu.edu.entity.ProjectCategories;
import neu.edu.entity.UserAccount;
import neu.edu.entity.UserProject;
import neu.edu.entity.UserProjectServices;

@Service
public class ProjectService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	
	public void submitProject(UserProjectBean userProjectBean){
	
		userDAO.submitProject(userProjectBean);
	}
	
	public void buyThisService(CartBean cartBean){
	
		userDAO.buyThisService(cartBean);
	}
	
	public void submitServices(ProjectServicesBean projectServicesBean){
		 userDAO.submitServices(projectServicesBean);
	}
	

	
	
	@Transactional
	public void deleteProject(UserProjectBean userProjectBean) {
		// TODO Auto-generated method stub
		
		UserProject userProject = new UserProject();
		userProject.setProjectDesc(userProjectBean.getDesc());
		UserAccount userAccount = new UserAccount();
		userAccount.setId(userProjectBean.getUserId());
		userProject.setUserAccount(userAccount);
		userProject.setCategoryId(userProjectBean.getCategoryId());
		userProject.setProjectStatus(userProjectBean.getStatus());

		userDAO.deleteProject(userProject);
		
		
	}
	
	@Transactional
	public List<UserProjectBean> getAllProject( Integer userId) {
		// TODO Auto-generated method stub
		List<UserProject> userProjects = userDAO.getAllProjects(userId);
		
		List<UserProjectBean> response = new ArrayList<>();
		for(UserProject userProject:userProjects){
			UserProjectBean userProjectBean = new UserProjectBean();
			userProjectBean.setName(userProject.getProjectName());
			userProjectBean.setDesc(userProject.getProjectDesc());
			userProjectBean.setCategoryId(userProject.getCategoryId());
			response.add(userProjectBean);
		}
		return response;
	}
	@Transactional
	public List<UserProjectBean> viewAllProjects(Integer categoryId) {
		// TODO Auto-generated method stub
		List<UserProject> userProjects = userDAO.viewAllProjects(categoryId);
		
		List<UserProjectBean> response = new ArrayList<>();
		for(UserProject userProject:userProjects){
			UserProjectBean userProjectBean = new UserProjectBean();
			userProjectBean.setUserId(userProject.getUserAccount().getId());
			userProjectBean.setName(userProject.getProjectName());
			userProjectBean.setDesc(userProject.getProjectDesc());
			userProjectBean.setStatus(userProject.getProjectStatus());
			userProjectBean.setCategoryId(userProject.getCategoryId());
			userProjectBean.setEndDate(userProject.getEndDate());
			userProjectBean.setLocation(userProject.getProjectLocation());
			userProjectBean.setPicture(userProject.getProjectPicture());
			userProjectBean.setPrice(userProject.getProjectPrice());
			userProjectBean.setProjectId(userProject.getProjectId());
			userProjectBean.setStartDate(userProject.getStartDate());
			response.add(userProjectBean);
		}
		return response;
	}
	

	@Transactional
	public List<ProjectServicesBean> viewAllServicesActive(Integer projectId) {
		// TODO Auto-generated method stub
		List<Object[]> userProjectServices = userDAO.viewAllServicesActive(projectId);
		/*List<Object> result = (List<Object>) LoadSource.list(); 
		Iterator itr = result.iterator();
		while(itr.hasNext()){
		   Object[] obj = (Object[]) itr.next();
		   //now you have one array of Object for each row
		   String client = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String 
		   Integer service = Integer.parseInt(String.valueOf(obj[1])); //SERVICE assumed as int
		   //same way for all obj[2], obj[3], obj[4]
		}*/
		int num_serv = userProjectServices.size();
		ArrayList<String> abcd =new ArrayList<>();
		ArrayList<String> efgh = new ArrayList<>();
		ArrayList<Float> ijkl= new ArrayList<>();
		List<ProjectServicesBean> response = new ArrayList<>();
		//for(int i=0;i<num_serv;i++){
		for(Object[] userProjectService:userProjectServices){
			ProjectServicesBean projectServicesBean = new ProjectServicesBean();
			projectServicesBean.setName((String) userProjectService[1]);
			/* abcd.add((String) userProjectService[3]);
			 efgh.add((String) userProjectService[4]);
			 ijkl.add((Float) userProjectService[5]);*/
			projectServicesBean.setNameDesc((String) userProjectService[4]);
			projectServicesBean.setNameService((String) userProjectService[3]);
			projectServicesBean.setNamePrice((Float) userProjectService[5]);
			projectServicesBean.setProjectId(projectId);
			projectServicesBean.setServiceStatus((String) userProjectService[6]);
			projectServicesBean.setUserId((Integer) userProjectService[0]);
			projectServicesBean.setServiceId((Integer) userProjectService[2]);
			response.add(projectServicesBean);
		}//}
		return response;
	}
	
	
	@Transactional
	public List<UserProjectBean> viewAllProjectsActive(Integer categoryId) {
		// TODO Auto-generated method stub
		List<UserProject> userProjects = userDAO.viewAllProjectsActive(categoryId);
		
		List<UserProjectBean> response = new ArrayList<>();
		for(UserProject userProject:userProjects){
			UserProjectBean userProjectBean = new UserProjectBean();
			userProjectBean.setUserId(userProject.getUserAccount().getId());
			userProjectBean.setName(userProject.getProjectName());
			userProjectBean.setDesc(userProject.getProjectDesc());
			userProjectBean.setStatus(userProject.getProjectStatus());
			userProjectBean.setCategoryId(userProject.getCategoryId());
			userProjectBean.setEndDate(userProject.getEndDate());
			userProjectBean.setLocation(userProject.getProjectLocation());
			userProjectBean.setPicture(userProject.getProjectPicture());
			userProjectBean.setPrice(userProject.getProjectPrice());
			userProjectBean.setProjectId(userProject.getProjectId());
			userProjectBean.setStartDate(userProject.getStartDate());
			response.add(userProjectBean);
		}
		return response;
	}
	@Transactional
	public List<ProjectCategoriesBean> getAllProjectsCategories() {
		// TODO Auto-generated method stub
		List<ProjectCategories> userProjectCategories = userDAO.getAllProjectsCategory();
		
		List<ProjectCategoriesBean> response1 = new ArrayList<>();
		for(ProjectCategories userProjectCategories1:userProjectCategories){
			ProjectCategoriesBean userProjectCategoriesBean = new ProjectCategoriesBean();
			userProjectCategoriesBean.setCategoryName(userProjectCategories1.getCategoryName());
			userProjectCategoriesBean.setCategoryDesc(userProjectCategories1.getCategoryDesc());
			userProjectCategoriesBean.setCategoryId(userProjectCategories1.getCategoryId());
			userProjectCategoriesBean.setStatus(userProjectCategories1.getStatus());

			response1.add(userProjectCategoriesBean);
		}
		return response1;
	}
	@Transactional
	public List<ProjectCategoriesBean> getAllProjectsCategoriesActive() {
		// TODO Auto-generated method stub
		List<ProjectCategories> userProjectCategories = userDAO.getAllProjectsCategoryActive();
		
		List<ProjectCategoriesBean> response1 = new ArrayList<>();
		for(ProjectCategories userProjectCategories1:userProjectCategories){
			ProjectCategoriesBean userProjectCategoriesBean = new ProjectCategoriesBean();
			userProjectCategoriesBean.setCategoryName(userProjectCategories1.getCategoryName());
			userProjectCategoriesBean.setCategoryDesc(userProjectCategories1.getCategoryDesc());
			userProjectCategoriesBean.setCategoryId(userProjectCategories1.getCategoryId());
			userProjectCategoriesBean.setStatus(userProjectCategories1.getStatus());

			response1.add(userProjectCategoriesBean);
		}
		return response1;
	}
	@Transactional
	public void updateCategories(ProjectCategoriesBean projectCategoriesBean) {
		// TODO Auto-generated method stub
		ProjectCategories projectCategories = new ProjectCategories();
		projectCategories.setCategoryDesc(projectCategoriesBean.getCategoryDesc());
		projectCategories.setCategoryName(projectCategoriesBean.getCategoryName());
		projectCategories.setCategoryId(projectCategoriesBean.getCategoryId());
		projectCategories.setStatus(projectCategoriesBean.getStatus());

		userDAO.updateCategories(projectCategories);
		
		
	}
	@Transactional
	public void addCategory(ProjectCategoriesBean projectCategoriesBean) {
		// TODO Auto-generated method stub
		ProjectCategories projectCategories = new ProjectCategories();
		projectCategories.setCategoryDesc(projectCategoriesBean.getCategoryDesc());
		projectCategories.setCategoryName(projectCategoriesBean.getCategoryName());
		//projectCategories.setCategoryId(projectCategoriesBean.getCategoryId());
		projectCategories.setStatus(projectCategoriesBean.getStatus());

		userDAO.addCategory(projectCategories);
		
		
	}
	
	@Transactional
	public void deleteCategories(ProjectCategoriesBean projectCategoriesBean) {
		// TODO Auto-generated method stub
		List<UserProject> userProjects = userDAO.getAllProjectsForThisCategory(projectCategoriesBean.getCategoryId());
		ProjectCategories projectCategories = new ProjectCategories();

		if(userProjects.isEmpty()){
		projectCategories.setCategoryDesc(projectCategoriesBean.getCategoryDesc());
		projectCategories.setCategoryName(projectCategoriesBean.getCategoryName());
		projectCategories.setCategoryId(projectCategoriesBean.getCategoryId());
		projectCategories.setStatus(projectCategoriesBean.getStatus());

		userDAO.deleteCategories(projectCategories);
		}
		else{
			projectCategories.setCategoryDesc(projectCategoriesBean.getCategoryDesc());
			projectCategories.setCategoryName(projectCategoriesBean.getCategoryName());
			projectCategories.setCategoryId(projectCategoriesBean.getCategoryId());
			projectCategories.setStatus("Inactive");
			userDAO.disableCategories(projectCategories);

		}
	}
}
