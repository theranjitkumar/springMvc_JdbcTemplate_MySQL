package com.rk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rk.model.Student;
import com.rk.repository.StudentImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentImpl studentImpl;
	
	@RequestMapping(path="/studentList", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws IOException{
		List<Student> studentList = studentImpl.list();
		mv.addObject("studentList", studentList);
		mv.setViewName("studentList");
		System.out.println(studentList);
		return mv;
	}
	@RequestMapping("/addNewStudent")
	public ModelAndView add(ModelAndView mv){
		return new ModelAndView("addStudent", "command", new Student());
	}
	
//	   @RequestMapping(value = "/addNewStudent", method = RequestMethod.GET)
//	   public ModelAndView student() {
//	      return new ModelAndView("addStudent", "command", new Student());
//	   }	
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("student") Student student) {
	    studentImpl.addStudent(student);
	    return new ModelAndView("redirect:/studentList");
	}
	
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(ModelAndView mv){
		mv.setViewName("addNewStudent");
		return mv;
	}
	
	@RequestMapping(path="/deleteStudent", method=RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest req){
		int sid = Integer.parseInt(req.getParameter("id"));
		studentImpl.deleteStudent(sid);
		return new ModelAndView("redirect:/studentList");
	}
	
}
