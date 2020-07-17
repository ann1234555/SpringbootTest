package tw.com.phctw.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import tw.com.phctw.dao.StudentRepository;
import tw.com.phctw.model.Student;
import tw.com.phctw.util.ForgetPwdMail;


@Service("StudentService")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository dao;
		
	@Autowired
	private ForgetPwdMail fpm;
	
	@Override
	public Student getStudentById(Long id) {
		Student student = null;
		try {
			student = dao.getOne(id);
			if(student != null) {
				return student;
			}
			return null;
		} catch (Exception e) {
			System.out.println("getStudentById: "+e);
			throw e;
		}
	}
	
	@Override
	public List<Student> getAllStudents(){
		List<Student> students = null;
		try {
			students = dao.findAll();
			if(students != null) {
				return students;
			}
			return null;
		} catch (Exception e) {
			System.out.println("getAllStudents" + e);
			throw e;
		}
	}
	
	@Override
	public boolean deleteStudentBySid(Long id) {
		try {
			if(dao.getOne(id)!=null) {
				dao.deleteById(id);
				return true;
			}else {
				System.out.println("No Such Student with the id");
				return false;
			}
		} catch (Exception e) {
			System.out.println("deleteStudentBySid: " + e);
			throw e;
		}
	}
	
	//save - register
	@Override
	public boolean saveStudent(Student s) {
		try {
			s.setSpwd(getMD5Endocing(s.getSpwd()));
			if(dao.save(s) != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("saveStudent: " + e);
			throw e;
		}
	}
	
	@Override
	public Student checkSaccExist(String sacc) {
		Student student = null;
		try {
			student = dao.getStudentBySacc(sacc);
			if(student != null) {
				return student;
			}
			return null;
		} catch (Exception e) {
			System.out.println("checkSaccExist:"+e);
			throw e;
		}
	}
	
	
	
	//login
	@Override
	public Student validateStudent(Student s) {
		Student student = null;
		try {
			s.setSpwd(getMD5Endocing(s.getSpwd()));
			student = dao.getStudentForSaccAndSpwd(s.getSacc(), s.getSpwd());
			if(student != null) {
				return student;
			}
			return null;
		} catch (Exception e) {
			System.out.println("ValidateStudent: " + e);
			throw e;
		}
	}

	

	//register
//	@Override
//	public boolean register(Student s) {
//		try {
//			s.setSpwd(getMD5Endocing(s.getSpwd()));
//			if (dao.save(s) != null) {
//				return true;
//			}
//			return false;
//		} catch (Exception e) {
//			System.out.println("saveStudent: " + e);
//			throw e;
//		}
//	}
	
	//forget pwd
	@Override
	public Student checkForgotenStd(Student s) {
		Student student = null;
		try {
			student = dao.getStudentBySaccAndSmail(s.getSacc(), s.getSmail());
			if(student != null) {
				return student;
			}
			return null;
		} catch (Exception e) {
			System.out.println("checkForgotenStd:" + e);
			throw e;
		}
	}

	@Override
	public boolean resetPwd(Student s) {
		try {
			String newPwd = fpm.createPwd();
			String encPwd = getMD5Endocing(newPwd);
			String toAddr = s.getSmail();

			s.setSpwd(encPwd);
			
			if(dao.save(s) != null) {
				fpm.send(toAddr, newPwd);
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("resetPwd: " + e);
			throw e;
		}
	}
	
	
	// MD5 encryption
	private String getMD5Endocing(String message) {
		final StringBuffer buffer = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(message.getBytes());
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; ++i) {
				final byte b = digest[i];
				final int value = Byte.toUnsignedInt(b);
				buffer.append(value < 16 ? "0" : "");
				buffer.append(Integer.toHexString(value));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		return buffer.toString();
	}

	
}
