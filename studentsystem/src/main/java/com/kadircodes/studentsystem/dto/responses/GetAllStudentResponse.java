package com.kadircodes.studentsystem.dto.responses;

public class GetAllStudentResponse {
	
	private String name;
	private String address;
	
	public GetAllStudentResponse(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public GetAllStudentResponse() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
