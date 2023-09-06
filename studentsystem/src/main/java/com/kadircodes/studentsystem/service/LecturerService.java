package com.kadircodes.studentsystem.service;

import java.util.List;

import com.kadircodes.studentsystem.dto.requests.CreateLecturerRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllLecturerResponse;
import com.kadircodes.studentsystem.dto.responses.GetByIdLecturerResponse;

public interface LecturerService {
	
	void add(CreateLecturerRequest createLecturerRequest);
	void delete(int id);
	void update(CreateLecturerRequest createLecturerRequest, int id);
	List<GetAllLecturerResponse> getAll();
	GetByIdLecturerResponse getById(int id);
	

}
