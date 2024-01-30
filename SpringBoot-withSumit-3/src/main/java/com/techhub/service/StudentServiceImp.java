package com.techhub.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.exp.ResourceNotFoundException;
import com.techhub.model.Student;
import com.techhub.payload.StudentDTO;
import com.techhub.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	ModelMapper modelmapper;
	
	@Autowired 
	StudentRepository studentrepo;
	
	@Override
	public StudentDTO getbyid(int id) {

		Student s= studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not found with id...."+id));
		StudentDTO sdto=modelmapper.map(s, StudentDTO.class);
		//StudentDTO sdto=this.studentTOdto(s);
		return sdto;
	}

	@Override
	public StudentDTO createstudent(StudentDTO studentDTO) {
		
		Student s= modelmapper.map(studentDTO, Student.class);
		
		Student student=studentrepo.save(s);
		
		return modelmapper.map(student, StudentDTO.class);
	}

	@Override
	public StudentDTO updatestudent(StudentDTO studentDTO, int id) {

		Student s= studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not found with id...."+id));
		
		s.setName(studentDTO.getName());
		
		studentrepo.save(s);
		
		return modelmapper.map(s, StudentDTO.class);
	}

	@Override
	public void deletestudent(int id) {

	Student s= studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not found with id...."+id));
	
	studentrepo.delete(s);
		
		
	}

	@Override
	public List<StudentDTO> listofStudent() {
		List<Student> list = studentrepo.findAll();

		 List<StudentDTO> listDto = new ArrayList<>();

		for(int i=0;i<list.size();i++)
		{
		listDto.add(modelmapper.map(list.get(i), StudentDTO.class));
		}
		return listDto;
	}
}
	
	/*public StudentDTO studentTOdto(Student student) {
		
		StudentDTO sdto = new StudentDTO();
		sdto.setId(student.getId());
		sdto.setName(student.getName());
		return sdto;
	}
	public Student DTOtoStudent(StudentDTO studentdto) {
			
			Student s = new Student();
			s.setId(studentdto.getId());
			s.setName(studentdto.getName());
			return s;
		}*/


