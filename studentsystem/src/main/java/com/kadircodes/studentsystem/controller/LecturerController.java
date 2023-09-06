package com.kadircodes.studentsystem.controller;

import java.util.List;

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

import com.kadircodes.studentsystem.dto.requests.CreateLecturerRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllLecturerResponse;
import com.kadircodes.studentsystem.dto.responses.GetByIdLecturerResponse;
import com.kadircodes.studentsystem.service.LecturerService;

@RestController
@RequestMapping("/lecturers")

public class LecturerController {
	
	private final LecturerService lecturerService;

	public LecturerController(LecturerService lecturerService) {
		
		this.lecturerService = lecturerService;
	}
	
	@PostMapping("/addLecturer")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addLceturer(@RequestBody CreateLecturerRequest createLecturerRequest){
		this.lecturerService.add(createLecturerRequest);
	}
	
	@DeleteMapping("/deleteLecturerbyId")
	public void deleteLecturer(@RequestParam int id) {
		this.lecturerService.delete(id);
	}
	
	@PutMapping("/updateLecturer")
	public void updateLecturer(@RequestBody CreateLecturerRequest createLectureRequest, @RequestParam int id) {
		this.lecturerService.update(createLectureRequest, id);
	}
	
	@GetMapping("/getAllLecturersResponse")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok( lecturerService.getAll());		
	}
	
	@GetMapping("/getLecturerById")
	public ResponseEntity<?> getById(@RequestParam int id) {
		return ResponseEntity.ok(lecturerService.getById(id));
	}

}
