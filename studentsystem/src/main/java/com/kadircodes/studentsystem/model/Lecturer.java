package com.kadircodes.studentsystem.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Lecturer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String givenLectureName;
	
	public Lecturer(int id, String name, String surname, String givenLectureName) {
	
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.givenLectureName=givenLectureName;
	}

	@ManyToOne()
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@ManyToMany(mappedBy = "lecturers")
    private List<Student> students = new ArrayList<>();
	
	public Lecturer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
