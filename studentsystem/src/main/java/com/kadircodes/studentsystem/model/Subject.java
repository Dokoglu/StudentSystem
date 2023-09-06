package com.kadircodes.studentsystem.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity

public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	

	 @ManyToMany
	   @JoinTable(
	        name = "student_subject",
	        joinColumns = @JoinColumn(name = "subject_id"),
	        inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	    private List<Student> students = new ArrayList<>();
	 
	 @OneToMany()
	 private List<Lecturer> lecturers;
	 
	
	public Subject() {
		
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
	
	
	
	

}
