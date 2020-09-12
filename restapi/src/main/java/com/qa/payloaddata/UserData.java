package com.qa.payloaddata;

// POJO class created to generate response in the form of json
public class UserData {
	
	String name;
	String job;
	String createdAt;
	String id;
	
	
	public UserData() {
		
		
	}
	
	public UserData(String name, String job) {
		this.name=name;
		this.job=job;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
