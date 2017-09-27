package neu.edu.bean;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import neu.edu.entity.UserAccount;

public class ProjectServicesBean {
	
	private Integer userId;
	private String name;
	private String serviceStatus;
	private int noOfServices;
	private ArrayList<String> serviceName;
	private ArrayList<String> serviceDesc;
	private ArrayList<Float> servicePrice;
	private Integer projectId;
	private Integer serviceId;
	private String nameService;
	private String nameDesc;
	private Float namePrice;
	public String getNameService() {
		return nameService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
	}

	public String getNameDesc() {
		return nameDesc;
	}

	public void setNameDesc(String nameDesc) {
		this.nameDesc = nameDesc;
	}

	public Float getNamePrice() {
		return namePrice;
	}

	public void setNamePrice(Float namePrice) {
		this.namePrice = namePrice;
	}

	public ProjectServicesBean() {
	}

	public ProjectServicesBean(Integer userId,Integer projectId, Integer serviceId, String name,int noOfServices, String serviceStatus, ArrayList<String> serviceName, ArrayList<String> serviceDesc, ArrayList<Float> servicePrice) {
		this.userId = userId;
		this.projectId = projectId;
		this.name = name;
		this.serviceDesc = serviceDesc;
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
		this.noOfServices = noOfServices;
		this.serviceId = serviceId;
	}

	
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public int getNoOfServices() {
		return noOfServices;
	}

	public void setNoOfServices(int noOfServices) {
		this.noOfServices = noOfServices;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public ArrayList<String> getServiceName() {
		return serviceName;
	}

	public void setServiceName(ArrayList<String> serviceName) {
		this.serviceName = serviceName;
	}

	public ArrayList<String> getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(ArrayList<String> serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public ArrayList<Float> getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(ArrayList<Float> servicePrice) {
		this.servicePrice = servicePrice;
	}

	

}
