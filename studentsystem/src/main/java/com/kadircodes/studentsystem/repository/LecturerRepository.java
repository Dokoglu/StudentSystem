package com.kadircodes.studentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kadircodes.studentsystem.model.Lecturer;

@Repository
public interface LecturerRepository  extends JpaRepository<Lecturer,Integer>{

}
