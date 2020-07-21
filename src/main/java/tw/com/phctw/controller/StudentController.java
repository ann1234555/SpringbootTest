package tw.com.phctw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tw.com.phctw.model.Student;
import tw.com.phctw.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/query")
	public List<Student> query(){
		List<Student> students = service.getAllStudents();
		return students;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/get/{id}")
	public Student get(@PathVariable Long id){
		Student student = service.getStudentById(id);
		return student;
	}
	
	
	
	
	
}
