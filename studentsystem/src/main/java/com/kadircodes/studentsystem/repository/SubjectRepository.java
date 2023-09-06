package com.kadircodes.studentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kadircodes.studentsystem.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
