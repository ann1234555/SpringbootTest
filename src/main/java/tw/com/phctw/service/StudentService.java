package tw.com.phctw.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.phctw.model.Student;

public interface StudentService{
	Student getStudentById(Long id);
	List<Student> getAllStudents();
	boolean deleteStudentBySid(Long id);
	boolean saveStudent(Student s);
	Student validateStudent(Student s);
	boolean checkSaccExist(String sacc);
//	boolean register(Student s);
	Student checkForgotenStd(Student s);
	boolean resetPwd(Student s);
//	String getMD5Endocing(String message);
}
