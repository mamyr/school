package com.mycompany.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.school.model.Student;
import com.mycompany.school.service.StudentService;
import com.mycompany.school.validator.StudentFormValidator;

@Controller
@SessionAttributes("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	StudentFormValidator studentFormValidator;

	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(studentFormValidator);
	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public String showAllStudents(Model model) {
		model.addAttribute("students", studentService.getStudentList());
		return "success";
	}
	
	// delete student
	@RequestMapping(value = "/students/{id}/delete", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id,
		final RedirectAttributes redirectAttributes) {

		studentService.deleteStudent(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Student is deleted!");

		return "redirect:/success.html";
	}

	// show add student form
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "student";

	}

	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String studentAdd(@ModelAttribute("student") @Validated Student student, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("msg", "Please fix the errors");
			model.addAttribute("css", "danger");
			return "student";
		} else if(studentService.getStudentByUserName(student.getUserName())) {
			model.addAttribute("msg", "User Name exists. Try another user name");
			model.addAttribute("css", "danger");
			return "student";
		} else {
			studentService.insertStudent(student);
			redirectAttributes.addFlashAttribute("msg", "Saved student details!");
			redirectAttributes.addFlashAttribute("css", "success");
			return "redirect:success.html";
		}
	}
}
