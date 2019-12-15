package io.mk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import io.mk.model.Student;

@Repository
public class StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		return getSession().createQuery("from Student").list();
	}

	@Cacheable(value = "student", key = "#stuId")
	public Student getStudent(int stuId) {
		return (Student) getSession().get(Student.class, stuId);
	}

	public void addStudent(Student student) {
		getSession().saveOrUpdate(student);
	}

	public Student updateStudent(Student student) {
		getSession().update(student);
		return student;
	}

	public void deleteStudent(int stuId) {
		Student student = (Student) getSession().load(Student.class, stuId);
		if (student != null) {
			getSession().delete(student);
		}
	}
}
