package com.kadircodes.studentsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadircodes.studentsystem.dto.requests.CreateSubjectRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllSubjectResponse;
import com.kadircodes.studentsystem.model.Subject;
import com.kadircodes.studentsystem.repository.SubjectRepository;

@Service
public class SubjectManager implements SubjectService{
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	private final ModelMapper modelMapper;
	

	public SubjectManager(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	}

	@Override
	public void add(CreateSubjectRequest createSubjectRequest) {
		
		//Gelen requesti subject nesnesine mapleyerek veritabanına ekliyoruz
		Subject subject=modelMapper.map(createSubjectRequest, Subject.class);
		this.subjectRepository.save(subject);
		
		
	}

	@Override
	public void deleteById(int id) {
		//Veritabanından idye göre dersi silme işlemini yapıyoruz
		//Girilen idye sahip ders varsa siler, yoksa hata fırlatır.
		Subject subject=this.subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("No data!"));
		this.subjectRepository.deleteById(id);
		
	}

	@Override
	public List<GetAllSubjectResponse> getAll() {
		// Veritabanındaki Subject nesnesini modelMapper aracılığıyla GetAllSubjectResponse'a
		//çevirip o şekilde dışarıya açıyoruz
		
		List<Subject> subjects=this.subjectRepository.findAll();
		List<GetAllSubjectResponse> subjectResponses=subjects.stream().map(subject->this.modelMapper
				.map(subject, GetAllSubjectResponse.class)).collect(Collectors.toList());
		return subjectResponses;
	}

	@Override
	public void update(CreateSubjectRequest createSubjectRequest, int id) {
		// Güncellenecek dersin önce idsine göre veritabanında sorgulama yapılıp ardından 
		//veritabanında mevcut olduğu takdirde güncelleme yapıyoruz
		Subject subject=this.subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("No data, it can't be updated"));
		subject.setName(createSubjectRequest.getName());
		this.subjectRepository.save(subject);
		
	}

}
