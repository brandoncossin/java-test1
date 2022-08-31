package com.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.models.SignupForm;
import com.ecommerce.models.LoginForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("In index page");
        return getIndexPage;
    }
    @GetMapping("/login")
	public String loginFormPage() {
		System.out.println("in login");
		return "login";
	}
	@PostMapping("/login")
	public String loginPage(@ModelAttribute("LoginForm") LoginForm LoginForm, BindingResult result,
	@RequestParam("phone_number") String phone_number,
	@RequestParam("password") String password) {
		System.out.println(phone_number + " " + password);
		return "index";
	}
	@GetMapping("/signup")
	public String signupFormPage() {
		System.out.println("in sign up");
		return "signup";
	}
	@PostMapping("/signup")
	public String signupPage(@ModelAttribute("SignupForm") SignupForm SignupForm, BindingResult result,
	@RequestParam("phone_number") String phone_number,
	@RequestParam("first_name") String first_name,
	@RequestParam("last_name") String last_name,
	@RequestParam("password") String password) {
		//model.put("message", this.message);
		System.out.println(phone_number);
		return "login";
	}
}
