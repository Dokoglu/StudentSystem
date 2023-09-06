package com.kadircodes.studentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kadircodes.studentsystem.dto.requests.CreateStudentRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllStudentResponse;
import com.kadircodes.studentsystem.dto.responses.GetByIdStudentResponse;
import com.kadircodes.studentsystem.model.Student;
import com.kadircodes.studentsystem.repository.StudentRepository;

import core.utilities.Mappers.ModelMapperManager;
import core.utilities.Mappers.ModelMapperService;
@Service

public class StudentManager implements StudentService {
	
	
	private final StudentRepository studentRepository;
	
	private final ModelMapper modelMapper;
	
	
	public StudentManager(StudentRepository studentRepository, ModelMapper modelMapper) {
		
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void add(CreateStudentRequest studentRequest) {
		// TODO Auto-generated method stub
		Student student =modelMapper.map(studentRequest, Student.class);
		
		this.studentRepository.save(student);
		}

	@Override
	public List<GetAllStudentResponse> getAll() {
		// TODO Auto-generated method stub
		//Veritabanındaki Student tablosundaki tüm kayıtları modelMapper aracılığıyla response tipine dönüştürüp 
		//açıyoruz
		List<Student> students=studentRepository.findAll();
		List<GetAllStudentResponse> studentResponse=students.stream().map(student-> this.modelMapper
				.map(student, GetAllStudentResponse.class)).collect(Collectors.toList());
		
		return studentResponse;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		//Girilen idye göre veritabanından öğrencinin bilgilerinin silen metot.
		//Girilen idye sahip bir öğrenci yoksa hata fırlatır.
		Student student=this.studentRepository.findById(id).orElseThrow(() -> new RuntimeException("No student with this id, it can't be deleted"));
		this.studentRepository.deleteById(id);
		
	}

	@Override
	public void update(CreateStudentRequest studentRequest, int id) throws Exception {
		// TODO Auto-generated method stub
		Student student=studentRepository.findById(id).orElseThrow(() -> new RuntimeException("No student with this id, it can't be updated"));
		student.setName(studentRequest.getName());
		student.setSurname(studentRequest.getSurname());
		student.setAddress(studentRequest.getAddress());
		this.studentRepository.save(student);
	
		}
		
		
		
	

	@Override
	public GetByIdStudentResponse getById(int id) {
		// TODO Auto-generated method stub
		//İdye göre veritabanında arama yapıp girilen idye sahip öğrenci varsa
		// response tipinde getirilir. Aksi takdirde hata fırlatılır.
		
		Student student=studentRepository.findById(id).orElseThrow(() -> new RuntimeException("No student with this id!"));
//
		GetByIdStudentResponse studentResponse=this.modelMapper
				.map(student,GetByIdStudentResponse.class );
		return studentResponse;
		

	}
	



		
	}




