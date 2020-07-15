package tw.com.phctw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.phctw.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
