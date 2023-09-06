package com.kadircodes.studentsystem.dto.requests;

public class CreateSubjectRequest {
	
	
	private String name;
	
	public CreateSubjectRequest( String name) {
		
		
		this.name = name;
	}

	public CreateSubjectRequest() {
		
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
