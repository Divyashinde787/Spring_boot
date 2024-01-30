package com.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.model.Student;

@Repository
//Interface
public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}

