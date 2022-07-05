package com.rr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rr.dto.OneDay;
import com.rr.dto.OneReservation;
import com.rr.service.ReservationService;

@WebServlet(name = "ReservationAdminContoller", urlPatterns = {"/admin.rr"})	
public class ReservationAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService reservationService = new ReservationService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = (String)req.getSession().getAttribute("userid");
		if (userid == null) {
			req.getRequestDispatcher("./admin_login.jsp").forward(req, resp);
		} else {
			String date = req.getParameter("date");
			String roomNumber = req.getParameter("room");
			
			if (date == null || roomNumber == null) {
				List<OneDay> monthReservation = reservationService.getMonthReservation();
				req.setAttribute("monthReservation", monthReservation);
				req.getRequestDispatcher("./reservation_list.jsp").forward(req, resp);
			} else {
				OneReservation oneReservation = reservationService.getOneReservation(roomNumber, date);
				
				req.setAttribute("oneReservation", oneReservation);
				req.getRequestDispatcher("./reservation_inputform.jsp").forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = (String)req.getSession().getAttribute("userid");
		if (userid == null) {
			req.getRequestDispatcher("./admin_login.jsp").forward(req, resp);
		} else {
			reservationService.insertReservation(req);
			resp.sendRedirect("./Admin.rr");
		}
	}
}
