package tw.com.phctw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import tw.com.phctw.dao.StudentRepository;
import tw.com.phctw.model.Student;


@Service("StudentService")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository dao;
		
	@Override
	public List<Student> findAllStudents(){
		List<Student> students = dao.findAll();
		return students;
	}
	
	
}
