package com.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("In index page");
        return getIndexPage;
    }
    @RequestMapping("/login")
	public String loginPage() {
		//model.put("message", this.message);
		return "login";
	}
	@RequestMapping("/signup")
	public String signupPage() {
		//model.put("message", this.message);
		return "signup";
	}
}
