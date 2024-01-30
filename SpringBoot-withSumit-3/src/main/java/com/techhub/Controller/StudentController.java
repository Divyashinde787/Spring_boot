package com.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.techhub.payload.ApiResponse;
import com.techhub.payload.StudentDTO;
import com.techhub.service.StudentServiceImp;


@RestController
public class StudentController {
	
	@Autowired
	StudentServiceImp serviceImp;
	
	@GetMapping("/student/{id}")     //localhost:8080/student/1
	public ResponseEntity<StudentDTO>studentID(@PathVariable int id){
		
		StudentDTO s= serviceImp.getbyid(id);		
	return ResponseEntity.ok(s);	
	
	}
	
	@PostMapping("/student")
	public ResponseEntity<StudentDTO>createstudent(@RequestBody StudentDTO studentDTO){
		
		StudentDTO s=serviceImp.createstudent(studentDTO);
		
		return new ResponseEntity(s,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<StudentDTO>updatestudent(@RequestBody StudentDTO studentDTO, @PathVariable int id){
		
		StudentDTO s=serviceImp.updatestudent(studentDTO, id);
		
		return ResponseEntity.ok(s);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<ApiResponse>deletestudent(@PathVariable int id){
		
		serviceImp.deletestudent(id);
	
		ApiResponse res= new ApiResponse("record delete sucessfully ",true);
		
		return  ResponseEntity.ok(res);	
	}
	
	@GetMapping("/student")
		public ResponseEntity<List<StudentDTO>>listofStudent(){
			
		return ResponseEntity.ok(serviceImp.listofStudent());
	}
	
	@GetMapping("/sample")
	public String sampleRun() {
	
		return "Hello World!";
	}
	
	
}
