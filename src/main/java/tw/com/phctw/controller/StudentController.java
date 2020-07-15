package tw.com.phctw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.phctw.model.Student;
import tw.com.phctw.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/query")
	public List<Student> query(){
		List<Student> students = service.findAllStudents();
		return students;
		
	}
}
