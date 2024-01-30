package com.techhub.service;

import java.util.List;

import com.techhub.payload.StudentDTO;

public interface StudentService {

	public StudentDTO getbyid(int id);
	public StudentDTO createstudent(StudentDTO studentDTO);
	public StudentDTO updatestudent(StudentDTO studentDTO, int id);
	public void deletestudent(int id);
	public List<StudentDTO> listofStudent();
	
}
