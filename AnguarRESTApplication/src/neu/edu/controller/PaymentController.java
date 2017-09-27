package neu.edu.controller;

import java.util.Date;
import java.util.Random;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import neu.edu.bean.PaymentInfoBean;
import neu.edu.bean.UserAccountBean;
import neu.edu.bean.UserSessionInfo;
import neu.edu.controller.error.ResponseError;
import neu.edu.controller.input.UserLoginBean;
import neu.edu.service.UserService;

@Controller
@PermitAll
@Path("/finalPayment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentController {

	@Autowired
	private UserService userService;
	
	@POST
	@PermitAll
	public void finalPayment(PaymentInfoBean paymentInfoBean) {
		//System.out.println("Service is called");


		userService.finalPayment(paymentInfoBean);
          
		

	}
	
	
	
	
}
