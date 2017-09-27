package neu.edu.entity;
// Generated Apr 27, 2017 11:34:47 PM by Hibernate Tools 5.2.1.Final

/**
 * UserProjectServices generated by hbm2java
 */
public class UserProjectServices implements java.io.Serializable {

	private Integer serviceId;
	private UserProject userProject;
	private Integer userId;
	private String name;
	private String serviceName;
	private String serviceDesc;
	private Float servicePrice;
	private String serviceStatus;

	public UserProjectServices() {
	}

	public UserProjectServices(UserProject userProject, Integer userId, String name, String serviceName,
			String serviceDesc, Float servicePrice, String serviceStatus) {
		this.userProject = userProject;
		this.userId = userId;
		this.name = name;
		this.serviceName = serviceName;
		this.serviceDesc = serviceDesc;
		this.servicePrice = servicePrice;
		this.serviceStatus = serviceStatus;
	}

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public UserProject getUserProject() {
		return this.userProject;
	}

	public void setUserProject(UserProject userProject) {
		this.userProject = userProject;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDesc() {
		return this.serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public Float getServicePrice() {
		return this.servicePrice;
	}

	public void setServicePrice(Float servicePrice) {
		this.servicePrice = servicePrice;
	}

	public String getServiceStatus() {
		return this.serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}
