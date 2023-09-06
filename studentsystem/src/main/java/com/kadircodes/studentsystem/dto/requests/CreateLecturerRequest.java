package com.kadircodes.studentsystem.dto.requests;

public class CreateLecturerRequest {
	
	private String name;
	
	private String surname;
	
	private String givenLectureName;
	public CreateLecturerRequest(String name, String surname, String givenLectureName) {
		
		this.name = name;
		this.surname = surname;
		this.givenLectureName=givenLectureName;
	}
	public CreateLecturerRequest() {
	
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
	public String getgivenLectureName() {
		return givenLectureName;
	}
	public void setLectureName(String givenLectureName) {
		this.givenLectureName = givenLectureName;
	}
	
	
	

}
