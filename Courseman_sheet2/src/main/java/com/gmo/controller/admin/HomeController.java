package com.gmo.controller.admin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

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
		// kiểm tra username và password
		if (userService.checkLogin(user.getUsername(), encryptPass(user.getPassword()).concat("a"))) {
			// lấy quyền của user
			String role = userService.checkRole(user.getUsername()).getRoleid().getRole_name();
			// lấy id của user
			int userid = userService.checkRole(user.getUsername()).getId();
			// dùng session để lưu user,name,menu
			session.setAttribute("user", user);
			session.setAttribute("userid", userid);
			session.setAttribute("role", role);
			session.setAttribute("name", user.getUsername());

			// trả về trang chủ
			model.setViewName("redirect:/home");
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

		return new ModelAndView("redirect:/trang-chu");
	}

	// return 403 page
	@RequestMapping("403")
	public String errorPage() {
		return "admin/home/403";
	}

	// mã hóa password
	public static String encryptPass(String passwordMD5) throws Exception {
		String password = null;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashInBytes = md.digest(passwordMD5.getBytes(StandardCharsets.UTF_8));

		// bytes to hex
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}
		password = sb.toString();
		return password;
	}

	@ModelAttribute("userLogin")
	public int getUser(HttpSession session) {
		int id = 0;
		Users user = null;
		user = (Users) session.getAttribute("user");
		if (user != null)
			id = (int) session.getAttribute("userid");
		session.setAttribute("userLogin", id);
		return id;
	}

	@ModelAttribute("roleId")
	public String getRole(HttpSession session) {
		String roleId = null;
		Users user = null;
		user = (Users) session.getAttribute("user");
		if (user != null)
			roleId = (String) session.getAttribute("role");
		session.setAttribute("roleId", roleId);
		return roleId;

	}
}
