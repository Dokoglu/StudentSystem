package com.kadircodes.studentsystem.service;

import java.util.List;

import com.kadircodes.studentsystem.dto.requests.CreateStudentRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllStudentResponse;
import com.kadircodes.studentsystem.dto.responses.GetByIdStudentResponse;

public interface StudentService {
	
	void add(CreateStudentRequest studentRequest);
	public List<GetAllStudentResponse> getAll(); 
	void deleteById(int id);
	void update(CreateStudentRequest studentRequest, int id) throws Exception;
	GetByIdStudentResponse getById(int id);
	

}
