package tw.com.phctw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private StudentService service;
	
	//register
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/registerProcess")
	public boolean register(@RequestBody Student s){
		try {
			if(service.saveStudent(s)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/checkacc/{sacc}")
	public Student checkacc(@PathVariable String sacc){
		Student student = null;
		try {
			student = service.checkSaccExist(sacc);
			if(student != null) {
				return student;
			}
			System.out.println("No account found.");
//			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
}
