package neu.edu.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.bean.CartBean;
import neu.edu.bean.PaymentInfoBean;
import neu.edu.bean.ProjectServicesBean;
import neu.edu.bean.UserAccountBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.bean.UserRegistrationBean;
import neu.edu.entity.Cart;
import neu.edu.entity.CartId;
import neu.edu.entity.PaymentInfo;
import neu.edu.entity.PaymentInfoId;
import neu.edu.entity.ProjectCategories;
import neu.edu.entity.UserAccount;
import neu.edu.entity.UserProject;
import neu.edu.entity.UserProjectServices;

@Repository
public class UserDAO {

	int abc;
	String def;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public UserAccount validateUser(String username, String password) {
		int thisPass = password.hashCode();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserAccount where userName=:username and password=:password ");
		query.setString("username", username);
		query.setInteger("password", thisPass);

		UserAccount user = (UserAccount) query.uniqueResult();

		return user;

	}
	

	@Transactional
	public UserAccount registerUser(UserAccountBean userAccountBean) {
		Session session = sessionFactory.openSession();

		UserAccount userAccount = new UserAccount();
		//userAccount.setAge(userAccountBean.getAge());
		userAccount.setId(userAccountBean.getId());
		userAccount.setName(userAccountBean.getName());
		int thisPass = userAccountBean.getPassword().hashCode();
		userAccount.setPassword(thisPass);
		userAccount.setRole(userAccountBean.getRole());
		userAccount.setUserName(userAccountBean.getUsername());

		session.save(userAccount);
		return userAccount;
	}
	

	@Transactional
	public void finalPayment(PaymentInfoBean paymentInfoBean) {
		Session session = sessionFactory.openSession();

		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setCardCvv(paymentInfoBean.getCardCvv().hashCode());
		paymentInfo.setCardMonth(paymentInfoBean.getCardMonth());
		paymentInfo.setCardYear(paymentInfoBean.getCardYear());
		PaymentInfoId paymentInfoId = new PaymentInfoId();
		paymentInfoId.setCardNumber(paymentInfoBean.getCardNumber().hashCode());
		paymentInfoId.setUserId(paymentInfoBean.getUserId());
		paymentInfo.setId(paymentInfoId);
		session.save(paymentInfo);
		session.flush();
	}
	@Transactional
	public UserAccount createUser(UserAccount userAccount) {
		Session session = sessionFactory.openSession();
		session.save(userAccount);
		return userAccount;
	}

	public UserAccount fetchUserAccount(Integer userId) {
		Session session = sessionFactory.openSession();
		return session.load(UserAccount.class, userId);
	}

	
	@Transactional
	public void submitProject(UserProjectBean userProjectBean) {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println("Inside Service of Submit project");
		UserProject userProject = new UserProject();
		UserAccount userAccount = new UserAccount();
		userAccount.setId(userProjectBean.getUserId());
		userProject.setUserAccount(userAccount);
		userProject.setCategoryId(userProjectBean.getCategoryId());
		userProject.setProjectName(userProjectBean.getName());
		userProject.setProjectDesc(userProjectBean.getDesc());
		userProject.setEndDate(userProjectBean.getEndDate());
		userProject.setProjectLocation(userProjectBean.getLocation());
		userProject.setProjectPrice(userProjectBean.getPrice());
		userProject.setProjectPicture("aaa");
		userProject.setStartDate(userProjectBean.getStartDate());
		userProject.setProjectStatus(userProjectBean.getStatus());
		session.save(userProject);
		
		 abc = userProject.getProjectId();
		 def = userProject.getProjectName();
	}
	@Transactional
	public void buyThisService(CartBean cartBean) {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Cart cart = new Cart();
		CartId cartId = new CartId();
		cartId.setUserId(cartBean.getUserId());
		cartId.setThisServiceId(cartBean.getThisServiceId());
		cart.setId(cartId);
		session.save(cart);
		session.flush();
		
		 
	}
	
	@Transactional
	public boolean submitServices(ProjectServicesBean projectServicesBean) {
		
		// TODO Auto-generated method stub
		System.out.println("im am here");
		Session session = sessionFactory.openSession();
			for(int i=0;i<projectServicesBean.getNoOfServices();i++){
		
		UserProjectServices userProjectServices = new UserProjectServices();
		userProjectServices.setUserId(projectServicesBean.getUserId());
		UserProject userProject = new UserProject();
		userProject.setProjectId(abc);
		userProjectServices.setName(def);
		userProjectServices.setUserProject(userProject);
		userProjectServices.setServiceStatus(projectServicesBean.getServiceStatus());
		userProjectServices.setServiceDesc(projectServicesBean.getServiceDesc().get(i));
		userProjectServices.setServiceName(projectServicesBean.getServiceName().get(i));
		userProjectServices.setServicePrice(projectServicesBean.getServicePrice().get(i));
		session.save(userProjectServices);
		
			}
		return true;
	}
	
	@Transactional
	public boolean deleteProject(UserProject userProject) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.delete(userProject);
		session.flush();

		return true;
	}
	
	@Transactional
	public List<UserProject> getAllProjects(Integer userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return session.createQuery(" from UserProject where id.userId = :userid")
			    .setParameter("userid", userId)
			    .list();

	}

	@Transactional
	public List<UserProject> viewAllProjects(Integer categoryId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return session.createQuery(" from UserProject where categoryId = :categoryId")
			    .setParameter("categoryId", categoryId)
			    .list();

	}
	@Transactional
	public List<UserProject> viewAllProjectsActive(Integer categoryId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return session.createQuery(" from UserProject where categoryId = :categoryId and project_status='Active'")
			    .setParameter("categoryId", categoryId)
			    .list();

	}
	
	@Transactional
	public List<Object[]> viewAllServicesActive(Integer projectId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		return session.createSQLQuery(" select * from user_project_services where project_id = :projectId and service_status='Active'")
			    .setParameter("projectId", projectId)
			    .list();

	}
	@Transactional
	public List<ProjectCategories> getAllProjectsCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return session.createQuery(" from ProjectCategories")
			    .list();

	}
	@Transactional
	public List<ProjectCategories> getAllProjectsCategoryActive() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return session.createQuery(" from ProjectCategories where status = 'Active'")
			    .list();

	}
	@Transactional
	public void updateCategories(ProjectCategories projectCategories) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.update(projectCategories);
		session.flush();
	}
	@Transactional
	public void addCategory(ProjectCategories projectCategories) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		session.save(projectCategories);
		//session.flush();
	}
	
	@Transactional
	public void deleteCategories(ProjectCategories projectCategories) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.delete(projectCategories);
		session.flush();
	}
	@Transactional
	public void disableCategories(ProjectCategories projectCategories) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.update(projectCategories);
		session.flush();
	}

	@Transactional
	public List<UserProject> getAllProjectsForThisCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return session.createQuery(" from UserProject where categoryId=:categoryId")
			    .setParameter("categoryId", categoryId)
			    .list();

	}
}
