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

// 예약 현황(목록 조회), 입력 처리
@WebServlet(name = "ReservationContoller", urlPatterns = {"/userReservation.rr"})	
public class ReservationUserContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService reservationService = new ReservationService();
	
	// 예약 현황(목록 조회) 로드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String date = req.getParameter("date");
		String roomNumber = req.getParameter("room");
		String authUser = (String)req.getSession().getAttribute("authUser");
		
		// 관리자 로그인 && 방번호/예약일자 파라미터로 전달됨 -> 예약 정보 페이지
		if (date != null && roomNumber != null && authUser != null) {
			if (authUser.equals("true")) {
				OneReservation oneReservation = reservationService.getOneReservation(req);
				req.setAttribute("oneReservation", oneReservation);
				req.getRequestDispatcher("./reservation_view.jsp").forward(req, resp);
				return;
			}
		}
		
		// 관리자 로그인 OFF && 방번호/예약일자 파라미터 없음 -> 예약 현황 페이지
		List<OneDay> monthReservation = reservationService.getMonthReservation();
		req.setAttribute("monthReservation", monthReservation);
		req.getRequestDispatcher("./reservation_list.jsp").forward(req, resp);
		return;
	}
	
	// 예약 입력 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reservationService.insertReservation(req);
		resp.sendRedirect("./userReservation.rr");
		return;
	}
}
