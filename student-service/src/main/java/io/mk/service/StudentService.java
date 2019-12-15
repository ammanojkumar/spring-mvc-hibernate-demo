package io.mk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mk.dao.StudentDao;
import io.mk.model.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	public Student getStudent(int stuId) {
		return studentDao.getStudent(stuId);
	}

	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public void deleteStudent(int stuId) {
		studentDao.deleteStudent(stuId);
	}
}
