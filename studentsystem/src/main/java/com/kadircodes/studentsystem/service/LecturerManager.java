package com.kadircodes.studentsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadircodes.studentsystem.dto.requests.CreateLecturerRequest;
import com.kadircodes.studentsystem.dto.responses.GetAllLecturerResponse;
import com.kadircodes.studentsystem.dto.responses.GetByIdLecturerResponse;
import com.kadircodes.studentsystem.model.Lecturer;
import com.kadircodes.studentsystem.repository.LecturerRepository;

import core.utilities.Mappers.ModelMapperService;

@Service
public class LecturerManager implements LecturerService{
	
	@Autowired
	private  LecturerRepository lecturerRepository;
	

	private final ModelMapper modelMapper;
	
	
	public LecturerManager(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	}

	@Override
	public void add(CreateLecturerRequest createLecturerRequest) {
		// TODO Auto-generated method stub
		//LecturerRequestten gelenleri modelMapper ile veritabanı nesnesine mapleyip veritabanına ekliyoruz
		Lecturer lecturer=this.modelMapper.map(createLecturerRequest, Lecturer.class);
		this.lecturerRepository.save(lecturer);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		//Girilen idye göre öğretim görevlisinin bilgilerini veritabanından silindiği metot.
		Lecturer lecturer=lecturerRepository.findById().orElseThrow(() -> new RuntimeException("There is no lecturer with this id in the repository"))
		this.lecturerRepository.deleteById(id);
		
	}

	@Override
	public void update(CreateLecturerRequest createLecturerRequest, int id) {
		// TODO Auto-generated method stub
		// Güncellenecek öğretim görevlisinin önce idsine göre veritabanında sorgulama yapılıp ardından 
		//veritabanında mevcut olduğu takdirde güncelleme yapıyoruz
		Lecturer lecturer=lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no lecturer with this id, it can't be updated"));
		lecturer.setName(createLecturerRequest.getName());
		lecturer.setSurname(createLecturerRequest.getSurname());
		lecturer.setLectureName(createLecturerRequest.getgivenLectureName());
		this.lecturerRepository.save(lecturer);
		
	}

	@Override
	public List<GetAllLecturerResponse> getAll() {
		// TODO Auto-generated method stub
		//Veritabanı nesnesi olan Lecturer'ı LecturerResponse'a modelMapper kullanarak çevirip öylece dışarıya açıyoruz.
		
		List<Lecturer> lecturers=lecturerRepository.findAll();
		List<GetAllLecturerResponse> lecturerResponse=lecturers.stream()
				.map(lecturer-> this.modelMapper.map(lecturer, GetAllLecturerResponse.class))
				.collect(Collectors.toList());
		
		return lecturerResponse;
	}

	@Override
	public GetByIdLecturerResponse getById(int id) {
		// TODO Auto-generated method stub
		//Öğretim görevlisinin idsine göre bilgilerini getiren metot.
		Lecturer lecturer=this.lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no lecturer with this id!"));
		GetByIdLecturerResponse lecturerResponse=this.modelMapper
				.map(lecturer, GetByIdLecturerResponse.class);
		return lecturerResponse;
	}

}
