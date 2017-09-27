package neu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.bean.PaymentInfoBean;
import neu.edu.bean.UserAccountBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.bean.UserSessionInfo;
import neu.edu.dao.UserDAO;
import neu.edu.entity.UserAccount;
import neu.edu.entity.UserProject;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDao;
	
	
	public Integer validateUser(String username,String password){
		System.out.println("Service is called Called");
		UserAccount user = userDao.validateUser(username,password);
		
		if (user == null) {
			System.out.println("User Not Found");
			return null;
		} else {
			System.out.println("User  Found");
			return user.getId();
		}
	}
	
	public Integer registerUser(UserAccountBean userAccountBean){
		System.out.println("Service is called");
		UserAccount userAccount = userDao.registerUser(userAccountBean);
		return userAccount.getId();

		
	}
	
	public void finalPayment(PaymentInfoBean paymentInfoBean){
		//System.out.println("Service is called");
		userDao.finalPayment(paymentInfoBean);

		
	}

	public UserSessionInfo fetchUserAccountDetails(Integer userId) {
		// TODO Auto-generated method stub
		UserSessionInfo userSessionInfo=null;
		
		UserAccount userAccount = userDao.fetchUserAccount(userId);
		if(userAccount!=null){
			userSessionInfo = new UserSessionInfo(userAccount.getId());
			userSessionInfo.setName(userAccount.getName());
			userSessionInfo.setRole(userAccount.getRole());
			userSessionInfo.getUserInformationBean().setUserName(userAccount.getUserName()); 
		}
		
		/*System.out.println(userAccount.getName());
		for(UserProject userProject:userAccount.getUserProjects()){
			UserProjectBean userProjectBean = new UserProjectBean(userProject.getUserAccount().getId(),userProject.getName(), userProject.getDesc(),userProject.getCategoryId(),userProject.getStatus(),userProject.getPrice(),userProject.getStartDate(),userProject.getEndDate(),userProject.getLocation());
			userSessionInfo.getUserProjectBeans().add(userProjectBean);
			System.out.println(userProject.getName());
		}*/
		return userSessionInfo;
	}

	

	
	

}
