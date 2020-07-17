package tw.com.phctw.dao;


import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


import tw.com.phctw.model.Student;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long>{

	//getOne
	
	//findAll
	
	//save
	
	//delete
	@Override 
	@RestResource(exported = false)
	void deleteById(Long id);
	
	//login
	@RestResource(exported = true)
	@Query("FROM Student WHERE SACC = :sacc and SPWD = :spwd")
	Student getStudentForSaccAndSpwd(@Param("sacc") String sacc,@Param("spwd") String spwd);
	
	//register
	@RestResource(exported = true)
	@Query("FROM Student WHERE SACC = :sacc")
	Student getStudentBySacc(@Param("sacc") String sacc);
	
	
	//forget password
	@RestResource(exported = true)
	@Query("FROM Student WHERE SACC = :sacc and SMAIL = :smail")
	Student getStudentBySaccAndSmail(@Param("sacc") String sacc,@Param("smail") String smail);
	
}
