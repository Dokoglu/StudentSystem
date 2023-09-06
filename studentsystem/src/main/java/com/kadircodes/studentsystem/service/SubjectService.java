package com.kadircodes.studentsystem.service;

import java.util.List;

import com.kadircodes.studentsystem.dto.requests.CreateSubjectRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllSubjectResponse;

public interface SubjectService {
	
	void add(CreateSubjectRequest createSubjectRequest);
	void deleteById(int id);
	List<GetAllSubjectResponse> getAll();
	void update(CreateSubjectRequest createSubjectRequest,  int id);

}
