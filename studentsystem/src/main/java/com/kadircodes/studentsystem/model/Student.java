package com.kadircodes.studentsystem.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private int id;
	private String name;
	private String surname;
	private String address;
	
	public Student(int id, String name, String surname ,String address) {
		this.id = id;
		this.name = name;
		this.surname=surname;
		this.address = address;
	}
	
	 @ManyToMany(mappedBy = "students")
	    private List<Subject> subjects = new ArrayList<>();
	 
	 @ManyToMany
	   @JoinTable(
	        name = "lecturer_student",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "lecturer_id")
	    )
	    private List<Lecturer> lecturers = new ArrayList<>();
	 

	public Student() {
		
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


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	
	
	
	

}
