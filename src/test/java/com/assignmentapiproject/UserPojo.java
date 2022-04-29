package com.assignmentapiproject;

import java.util.List;

public class UserPojo {
	
	private String name;
		private String job;
	private List<String> location;
		
	public UserPojo(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	
	public UserPojo() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "UserPojo [name=" + this.name + ", job=" + this.job + "]";
	}
	
	

}
