package com.gmo.controller.student;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import com.gmo.model.Enrolment;
import com.gmo.model.Profile;
import com.gmo.model.Role;
import com.gmo.model.Users;
import com.gmo.service.GenericService;

@Controller
public class StudentController {
	@Autowired
	private GenericService<Enrolment> enrolmentService;
	@Autowired
	private GenericService<Course> courseService;
	@Autowired
	private GenericService<Users> userService;
	@Autowired
	private GenericService<Role> roleService;
	@Autowired
	private GenericService<Profile> profileService;

	public StudentController() {
		System.out.println("StudentController()");
	}

	// take register form
	@RequestMapping(value = "/register")
	public ModelAndView addUser(ModelAndView model) {
		Users user = new Users();
		model.addObject("message", user.getUsername());
		model.addObject("user", user);
		model.setViewName("student/register");
		return model;
	}

	// Register to save user
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("user") @Validated Users user, BindingResult br, ModelAndView model)
			throws Exception {
		if (br.hasErrors()) {
			model.setViewName("student/register");
			return model;
		} else {
			if (!userService.checkUser(user.getUsername())) {
				if (user.getPassword().equals(user.getConfirmPassword())) {
					user.setRoleid(roleService.getDefaultRole(user.getIdRole()));
					// mã hóa password
					String password = null;
					String passwordMD5 = user.getPassword();
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(passwordMD5.getBytes());
					byte[] byteData = md.digest();

					StringBuilder sb = new StringBuilder(32);
					for (byte b : byteData) {
						sb.append(String.format("%02x", b & 0xff));
						password = sb.toString();

					}
					// kết thúc mã hóa
					user.setPassword(password);
					userService.create(user);
					Profile profile = new Profile(user.getUsername(), "10/10/1998", "Nam", user);
					profileService.create(profile);
					return new ModelAndView("redirect:/login");
				} else {
					model.setViewName("student/register");
					model.addObject("message", "Password not match !!!");
					return model;
				}
			} else {
				model.setViewName("student/register");
				model.addObject("message", "Username has been existed !!!");
				return model;
			}
		}
	}

	// take the list Teacher
	@RequestMapping(value = "/teachers")
	public String listTeacher(ModelMap model, HttpSession session) {
		List<Users> listTeacher = userService.listTeacher();
		model.addAttribute("listTeacher", listTeacher);
		return "student/listTeacher";
	}

	// take the enrollist
	@RequestMapping(value = "/enrolments")
	public String listEnrolment(ModelMap model, HttpSession session) {
		int userId = (int) session.getAttribute("userid");
		List<Enrolment> list = enrolmentService.listEnrolmentOfAStudent(userId);
		model.addAttribute("list", list);
		return "student/listEnrol";
	}

	// take the list of course
	@RequestMapping(value = "/courses")
	public String listCourse(ModelMap model, HttpSession session) {
		List<Course> list = courseService.listAll();
		model.addAttribute("list", list);
		return "student/listCourse";
	}

	// enrol course
	@RequestMapping(value = "/enrolCourseStudent")
	public ModelAndView Enrol(HttpSession session, HttpServletRequest request, ModelAndView model) {
		int courseID = Integer.parseInt(request.getParameter("courseid"));
		Course course = courseService.get(courseID);
		int userId = (int) session.getAttribute("userid");
		Users user = userService.get(userId);
		System.err.println(user.getId());
		System.err.println(courseID);
		Enrolment enrolment = new Enrolment();
		enrolment.setUser(user);
		enrolment.setCourse(course);
		if (!enrolmentService.checkEnrolment(user, course)) {
			enrolmentService.create(enrolment);
			model.setViewName("redirect:/enrolments");
			return model;
		} else {
			model.setViewName("redirect:/enrolments");
			model.addObject("message", "Student has been enrolment course");
			return model;
		}

	}

	// delete Enrol
	@RequestMapping(value = "/deleteEnrolmentStudent", method = RequestMethod.GET)
	public ModelAndView deleteEnrolment(HttpServletRequest request) {
		int enrolId = Integer.parseInt(request.getParameter("id"));
		enrolmentService.delete(enrolId);
		return new ModelAndView("redirect:/enrolments");
	}

}
