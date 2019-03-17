package com.example.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String name, String password) {
		 return name.equalsIgnoreCase("Shabbir")
	                && password.equalsIgnoreCase("dummy");
	}

}
