package com.kadircodes.studentsystem.dto.requests;

public class CreateStudentRequest {
	
	
	private String name;
	private String address;
	private String surname;
	
	public CreateStudentRequest( String name, String address, String surname) {
		
		this.name = name;
		this.address=address;
		this.surname=surname;
	}

	public CreateStudentRequest() {
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
