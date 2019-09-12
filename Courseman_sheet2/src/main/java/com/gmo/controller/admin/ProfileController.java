package com.gmo.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gmo.model.Profile;
import com.gmo.model.Users;
import com.gmo.service.GenericService;

@Controller
public class ProfileController {
	@Autowired
	private GenericService<Users> userService;
	@Autowired
	private GenericService<Profile> profileService;

	public ProfileController() {
		System.out.println("ProfileController()");
	}

	// edit profile
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile(ModelAndView model, HttpSession session) {
		String username = (String) session.getAttribute("name");
		Users user = userService.checkRole(username);
		Profile profile = profileService.getProfile(user);
		model.addObject("profile", profile);
		model.setViewName("admin/profile/ProfileForm");

		return model;
	}

	// update Profile
	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public String saveProfile(@ModelAttribute("profile") @Validated Profile profile, BindingResult br, Model model,
			HttpSession session) {

		if (br.hasErrors()) {
			return "admin/profile/ProfileForm";
		} else {

			profileService.updateProfile(profile.getName(), profile.getAddress(), profile.getDob(), profile.getGender(),
					profile.getPhone(), profile.getEmail(), profile.getStatus(), profile.getId());
			model.addAttribute("message", "update profile successfully");

			return "redirect:/home";
		}
	}

	// take the status of profile
	@ModelAttribute("status")
	public List<String> getStatus() {
		List<String> status = new ArrayList<String>();
		status.add("Trong Run");
		status.add("Ngoài Run");
		return status;
	}
}
