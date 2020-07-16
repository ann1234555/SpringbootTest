package tw.com.phctw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.phctw.model.Student;
import tw.com.phctw.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/query")
	public List<Student> query(){
		List<Student> students = service.getAllStudents();
		return students;
	}
	
	@GetMapping("/get/{id}")
	public Student get(@PathVariable Long id){
		Student student = service.getStudentById(id);
		return student;
	}
	
	
	
	
	
}
