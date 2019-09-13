package com.gmo.controller.admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gmo.model.Users;
import com.gmo.service.GenericService;

@Controller
public class HomeController {
	@Autowired
	private GenericService<Users> userService;

	public HomeController() {
		System.out.println("HomeController()");
	}

	// come to index
	@RequestMapping(value = { "/", "/trang-chu" })
	public String returnHome() {
		return "admin/home/index";
	}

	// come to index
	@RequestMapping(value = "/home")
	public String homePage() {
		return "admin/home/home";
	}

	// take login form
	@RequestMapping(value = "/login")
	public ModelAndView returnLoginPage(ModelAndView model) {
		Users user = new Users();
		model.addObject("user", user);
		model.setViewName("admin/home/login");
		return model;
	}

	// login
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("user") Users user, ModelAndView model, HttpServletRequest rq,
			HttpSession session) throws Exception {
		Map<String, String> hashMap = new HashMap<>();
		// kiểm tra username và password
		if (userService.checkLogin(user.getUsername(), decryptPass(user.getPassword()))) {
			// lấy quyền của user
			String role = userService.checkRole(user.getUsername()).getRoleid().getRole_name();
			//lấy id của user
			int userid = userService.checkRole(user.getUsername()).getId();
			//truy cập trang chủ
			if ("ADMIN".equals(userService.checkRole(user.getUsername()).getRoleid().getRole_name())) {
				hashMap.put("loadallrole", "List of Roles");
				hashMap.put("userList", "List of Users");
				hashMap.put("courseList", "List of Courses");
				hashMap.put("teacherList", "List of Teachers");
				hashMap.put("enrolmentList", "List of Enrolments");
				model.addObject("menu", hashMap);
			} else {
				hashMap.put("teachers", "List of Teachers");
				hashMap.put("enrolments", "List of Enrolments");
				hashMap.put("courses", "List of Courses");
				model.addObject("menu", hashMap);
			}
			//dùng session để lưu user,name,menu
			session.setAttribute("user", user);
			session.setAttribute("userid", userid);
			session.setAttribute("role", role);

			session.setAttribute("name", user.getUsername());
			session.setAttribute("menu", hashMap);
			
			//trả về trang chủ
			model.setViewName("admin/home/home");
			return model;
		} else {
			model.setViewName("admin/home/login");
			model.addObject("message", "Incorrect Usename or Password !!!");
			return model;
		}
	}

	// logout
	@RequestMapping(value = "/logout")
	public ModelAndView logout(@ModelAttribute("user") Users user, ModelAndView model, HttpServletRequest rq) {
		HttpSession session = rq.getSession();
		session.removeAttribute("user");
		session.removeAttribute("name");
		session.removeAttribute("menu");
		
		return new ModelAndView("redirect:/trang-chu");
	}

	// return 403 page
	@RequestMapping("403")
	public String errorPage() {
		return "admin/home/403";
	}

	// giải mã password
	public static String decryptPass(String passwordMD5) throws Exception {
		String password = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(passwordMD5.getBytes());
		byte[] byteData = md.digest();

		StringBuilder sb = new StringBuilder(32);
		for (byte b : byteData) {
			sb.append(String.format("%02x", b & 0xff));
			password = sb.toString();
		}
		return password;
	}

}
