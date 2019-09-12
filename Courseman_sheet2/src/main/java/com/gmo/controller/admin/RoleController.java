package com.gmo.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gmo.model.Role;
import com.gmo.service.GenericService;

@Controller
public class RoleController {
	@Autowired
	private GenericService<Role> roleService;

	public RoleController() {
		System.out.println("RoleController()");
	}

	// take addRole Form
	@RequestMapping(value = "/newRole")
	public ModelAndView addRole(ModelAndView model) {
		Role role = new Role();
		model.addObject("role", role);
		model.setViewName("admin/role/addRole");
		return model;
	}

	// save new role
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public ModelAndView saveRole(@Valid @ModelAttribute("role") Role role, BindingResult br, ModelAndView model) {
		if (br.hasErrors()) {
			model.setViewName("admin/role/addRole");
			return model;
		} else {
			if (!roleService.checkRoleName(role.getRole_name())) {
				roleService.create(role);
				return new ModelAndView("redirect:/loadallrole");
			} else {
				model.setViewName("admin/role/addRole");
				model.addObject("message", "Role_Name has been existed !!!");
				return model;
			}
		}

	}

	// take list of role
	@RequestMapping(value = "loadallrole")
	public String loadAllRole(ModelMap model, HttpSession session) {
		List<Role> list = roleService.listAll();
		model.addAttribute("list", list);
		return "admin/role/listRole";
	}

	// update Role
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public ModelAndView updateRole(@ModelAttribute Role role) {
//			if (br.hasErrors()) {
//				return new ModelAndView("student/studentEditForm");
//			} else {
//				studentService.updateStudent(student);
		roleService.update(role);
		return new ModelAndView("redirect:/loadallrole");

	}

	// take the idRole in URL
	@RequestMapping(value = "/editRole", method = RequestMethod.GET)
	public ModelAndView editRole(HttpServletRequest request) {
		int roleId = Integer.parseInt(request.getParameter("id"));
		Role role = roleService.get(roleId);
		ModelAndView model = new ModelAndView("admin/role/roleEditForm");
		model.addObject("role", role);

		return model;
	}

	// Delete Role
	@RequestMapping(value = "/deleteRole", method = RequestMethod.GET)
	public ModelAndView deleteRole(HttpServletRequest request) {
		int roleId = Integer.parseInt(request.getParameter("id"));
		roleService.delete(roleId);
		return new ModelAndView("redirect:/loadallrole");
	}
}
