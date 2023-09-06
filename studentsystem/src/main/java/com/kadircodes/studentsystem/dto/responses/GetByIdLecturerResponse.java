package com.kadircodes.studentsystem.dto.responses;

public class GetByIdLecturerResponse {
	
	private String name;
	private String surname;
	private String givenLectureName;
	
	public GetByIdLecturerResponse(String name, String surname, String givenLectureName) {
		this.name = name;
		this.surname = surname;
		this.givenLectureName = givenLectureName;
	}

	public GetByIdLecturerResponse() {
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

	public String getGivenLectureName() {
		return givenLectureName;
	}

	public void setGivenLectureName(String givenLectureName) {
		this.givenLectureName = givenLectureName;
	}
	
	
	

}
