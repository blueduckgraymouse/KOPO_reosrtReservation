package com.rr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginService {
	public boolean login(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");

		return (id.equals("admin") && password.equals("abcd1234")) ? true : false;
	}
}
