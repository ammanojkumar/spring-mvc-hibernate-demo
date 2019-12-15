package io.mk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.mk.model.Student;
import io.mk.service.StudentService;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * @category Learning
 * @since May 2019
 */
@Controller
@RequestMapping(value = "student")
public class StudentController {

	static Logger log = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "list")
	public ModelAndView listStudent(ModelAndView model) {
		List<Student> studentList = studentService.getAllStudents();
		log.info("Total students size: " + studentList.size());
		model.addObject("studentList", studentList);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addStudent(ModelAndView model) {
		Student student = new Student();
		model.addObject("student", student);
		model.setViewName("StudentForm");
		return model;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		if (student.getStuId() == 0) {
			studentService.addStudent(student);
		} else {
			studentService.updateStudent(student);
		}
		return new ModelAndView("redirect:/student/list");
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
		int stuId = Integer.parseInt(request.getParameter("stuId"));
		Student student = studentService.getStudent(stuId);
		ModelAndView modelAndView = new ModelAndView("StudentForm");
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		int stuId = Integer.parseInt(request.getParameter("stuId"));
		studentService.deleteStudent(stuId);
		return new ModelAndView("redirect:/student/list");
	}
}
