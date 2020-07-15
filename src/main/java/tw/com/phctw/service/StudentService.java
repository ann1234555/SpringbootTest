package tw.com.phctw.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.phctw.model.Student;

public interface StudentService{
	public List<Student> findAllStudents();
}
