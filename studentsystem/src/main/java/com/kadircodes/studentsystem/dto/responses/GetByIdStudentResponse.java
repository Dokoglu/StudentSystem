package com.kadircodes.studentsystem.dto.responses;

public class GetByIdStudentResponse {
	
	private String name;
	private String surname;
	

	public GetByIdStudentResponse() {
	
	}

	public GetByIdStudentResponse(String name, String surname) {
		this.name = name;
		this.surname=surname;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	
	
	

}
