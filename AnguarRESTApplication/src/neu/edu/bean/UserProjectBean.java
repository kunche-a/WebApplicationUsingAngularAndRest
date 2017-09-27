package neu.edu.bean;

import java.util.Date;

import neu.edu.entity.UserAccount;

public class UserProjectBean {
	
	private Integer userId;
	private String name;
	private String desc;
	private Integer categoryId;
	private String status;
	private Float price;
	private String startDate;
	private String endDate;
	private Integer projectId;
	private String picture;
	private String location;

	public UserProjectBean() {
	}

	public UserProjectBean(int userId, String name, String desc, Integer categoryId, String status, Float price, String startDate, String endDate, String location) {
		this.userId = userId;
		this.name = name;
		this.desc = desc;
		this.categoryId = categoryId;
		this.status = status;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.picture = picture;
		this.location = location;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}