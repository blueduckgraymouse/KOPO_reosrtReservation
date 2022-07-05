package com.rr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rr.dto.OneDay;
import com.rr.service.LoginService;
import com.rr.service.ReservationService;

@WebServlet(name = "ReservationAdminContoller", urlPatterns = {"/Login.rr"})	
public class ReservationLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService reservationService = new ReservationService();
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = (String)req.getSession().getAttribute("userid");
		if (userid == null) {
			req.getRequestDispatcher("./admin_login.jsp").forward(req, resp);
		} else {
			List<OneDay> monthReservation = reservationService.getMonthReservation();
			req.setAttribute("monthReservation", monthReservation);
			req.getRequestDispatcher("./reservation_list.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = loginService.login(req, resp);
		if (result) {
			resp.sendRedirect("./Login.rr?result=false");
		} else {
			resp.sendRedirect("./admin.rr");
		}
	}
}
