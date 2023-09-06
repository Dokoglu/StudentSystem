package com.kadircodes.studentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kadircodes.studentsystem.dto.requests.CreateSubjectRequest;
import com.kadircodes.studentsystem.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllSubject() {
		
		return ResponseEntity.ok(subjectService.getAll());
		}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addSubject(@RequestBody CreateSubjectRequest createSubjectRequest) {
		
		subjectService.add(createSubjectRequest);
		
	}
	
	@DeleteMapping("/deleteById")
	public void deleteSubject(@RequestParam int id) {
		subjectService.deleteById(id);
	}
	@PutMapping("/updateSubject")
	public void updateSubject(@RequestBody CreateSubjectRequest createSubjectRequest, @RequestParam int id) {
		subjectService.update(createSubjectRequest, id);
	}
		
	

}
