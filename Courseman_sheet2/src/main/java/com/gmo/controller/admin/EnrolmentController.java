package com.gmo.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gmo.model.Enrolment;
import com.gmo.service.GenericService;

@Controller
public class EnrolmentController {
	@Autowired
	private GenericService<Enrolment> enrolmentService;
//	@Autowired
//	private GenericService<Course> courseService;
//	@Autowired
//	private GenericService<Users> userService;

	public EnrolmentController() {
		System.out.println("EnrolmentController()");
	}
	// take the enrollist
		@RequestMapping(value = "/enrolmentList")
		public String listEnrolment(ModelMap model, HttpSession session) {
			List<Enrolment> list = enrolmentService.listAll();
			model.addAttribute("list", list);
			return "admin/course/listEnrol";
		}
	
		// delete Enrol
			@RequestMapping(value = "/deleteEnrolment", method = RequestMethod.GET)
			public ModelAndView deleteEnrolment(HttpServletRequest request) {
				int enrolId = Integer.parseInt(request.getParameter("id"));
				enrolmentService.delete(enrolId);
				return new ModelAndView("redirect:/enrolmentList");
			}
		
}
