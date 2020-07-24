package tw.com.phctw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tw.com.phctw.model.Student;
import tw.com.phctw.service.StudentService;

@RestController
@RequestMapping("/login")
@CrossOrigin()
public class LoginController {

	@Autowired
	private StudentService service;
	
	//login
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/loginProcess")
	public Student query(@RequestBody Student s){
		Student student = null;
		try {
			student = service.validateStudent(s);
			if(student != null) {
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//forget pwd
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/resetPwd")
	public boolean resetPwd(@RequestBody Student s){
		Student student = null;
		try {
			student = service.checkForgotenStd(s);
			if(student != null) {
				service.resetPwd(student);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
}
