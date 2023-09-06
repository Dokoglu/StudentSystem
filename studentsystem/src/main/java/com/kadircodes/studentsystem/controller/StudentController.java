package com.kadircodes.studentsystem.controller;

import java.util.List;

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

import com.kadircodes.studentsystem.dto.requests.CreateStudentRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllStudentResponse;
import com.kadircodes.studentsystem.dto.responses.GetByIdStudentResponse;
import com.kadircodes.studentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	private final StudentService studentService;
	
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody CreateStudentRequest studentRequest ) {
		
		studentService.add(studentRequest);
		
		}
	@GetMapping("/getAll")
	public ResponseEntity<List<GetAllStudentResponse>> getAll() {
		
		return ResponseEntity.ok(studentService.getAll());
	}
	
	@DeleteMapping("/deleteById")
	public void delete (@RequestParam int id){
	studentService.deleteById(id);
	}
	
	@PutMapping("/updateById")
	public void update( @RequestBody CreateStudentRequest createStudentRequest, @RequestParam int id) throws Exception {
		studentService.update(createStudentRequest, id);
	}
	
	@GetMapping("/getById")
		public ResponseEntity<?> getById(@RequestParam int id) {
			return ResponseEntity.ok(studentService.getById(id));
		
	}
	

	
		
	
}
