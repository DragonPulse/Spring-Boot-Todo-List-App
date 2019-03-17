package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService loginServie;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("login");
    	return model;
    }
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView showWelcomePage(@RequestParam String name, @RequestParam String password){

        boolean isValidUser = loginServie.validateUser(name, password);
        ModelAndView model = new ModelAndView();
        
        if (!isValidUser) {
        	model.setViewName("login");
            model.addObject("errorMessage", "Invalid Credentials");
            return model;
        }
        model.setViewName("welcome");
        model.addObject("name", name);
        model.addObject("password", password);
       
        return model;
    }
	
}
