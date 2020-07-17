package tw.com.phctw.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.phctw.model.Student;

public interface StudentService{
	Student getStudentById(Long id);
	List<Student> getAllStudents();
	Student validateStudent(Student s);
	Student checkSaccExist(String sacc);
	Student checkForgotenStd(Student s);
	boolean deleteStudentBySid(Long id);
	boolean saveStudent(Student s);
//	boolean register(Student s);
	boolean resetPwd(Student s);
//	String getMD5Endocing(String message);
}
