package com.gmo.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gmo.model.Course;
import com.gmo.model.Users;
import com.gmo.service.GenericService;

@Controller
public class CourseController {
	@Autowired
	private GenericService<Users> userService;

	@Autowired
	private GenericService<Course> courseService;

	@ModelAttribute("teachers")
	public List<Users> getTeacher() {
		List<Users> teachers = userService.listTeacher();
		return teachers;
	}

	// take the course add Form
	@RequestMapping(value = "/newCourse")
	public ModelAndView newCourse(ModelAndView model) {
		Course course = new Course();
		model.addObject("course", course);
		model.setViewName("admin/course/courseAddForm");
		return model;
	}

	// save new Course
	@RequestMapping(value = "/doaddCourse", method = RequestMethod.POST)
	public ModelAndView saveCourse(@ModelAttribute("course") @Validated Course course, BindingResult br,
			ModelAndView model) {
		if (br.hasErrors()) {
			model.setViewName("admin/course/courseAddForm");
			return model;
		} else {
			//kiểm tra course trong database
			if (!courseService.checkCourse(course.getCode())) {
				//set giáo viên cho course
				course.setUserid(userService.get(course.getIdUser()));
				courseService.create(course);
				model.setViewName("redirect:/courseList");
				return model;
			} else {
				model.addObject("message", "Course has been existed !!!");
				model.setViewName("admin/course/courseAddForm");
				return model;
			}
		}
	}

	// take the list of course
	@RequestMapping(value = "/courseList")
	public String listCourse(ModelMap model, HttpSession session) {
		List<Course> list = courseService.listAll();
		model.addAttribute("list", list);
		return "admin/course/listCourse";
	}

	// delete Course
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public ModelAndView deleteCourse(HttpServletRequest request) {
		int courseId = Integer.parseInt(request.getParameter("id"));
		courseService.delete(courseId);
		return new ModelAndView("redirect:/courseList");
	}

	// update Course
	@RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
	public ModelAndView updateCourse(@ModelAttribute @Validated Course course, BindingResult br, ModelAndView model) {
		Course courseid = courseService.get(course.getId());
		if (br.hasErrors()) {
			model.setViewName("admin/course/courseEditForm");
			return model;
		} else {
			// nếu không thay đổi gì vẫn update được
			if (courseid.getCode().equalsIgnoreCase(course.getCode())) {
				Users userid = userService.get(course.getIdUser());
				course.setUserid(userid);
				courseService.update(course);
				model.setViewName("redirect:/courseList");
				return model;
			}
			// kiểm tra mã Code trong database
			else if (!courseService.checkCourse(course.getCode())) {
				Users userid = userService.get(course.getIdUser());
				course.setUserid(userid);
				courseService.update(course);
				model.setViewName("redirect:/courseList");
				return model;
			} else {
				model.addObject("message", "Course has been existed !!!");
				model.setViewName("admin/course/courseEditForm");
				return model;
			}
		}

	}

	// take the id of Course in URL
	@RequestMapping(value = "/editCourse", method = RequestMethod.GET)
	public ModelAndView editCourse(HttpServletRequest request) {
		int courseId = Integer.parseInt(request.getParameter("id"));
		Course course = courseService.get(courseId);
		ModelAndView model = new ModelAndView("admin/course/courseEditForm");
		model.addObject("course", course);

		return model;
	}

	// type of course
	@ModelAttribute("type")
	public List<String> getType() {
		List<String> type = new ArrayList<String>();
		type.add("Seminar");
		type.add("Đào tạo nội bộ");
		type.add("Đào tạo bên ngoài");
		return type;
	}
}
