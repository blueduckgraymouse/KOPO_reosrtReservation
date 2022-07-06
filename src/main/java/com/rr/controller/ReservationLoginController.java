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

// 로그인 처리
@WebServlet(name = "ReservationLoginContoller", urlPatterns = {"/login.rr"})	
public class ReservationLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService = new LoginService();
	
	// 로그인 페이지 로드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String authUser = (String)req.getSession().getAttribute("authUser");
		// 로그인이 되어있으면 예약 현황으로 이동
		if (authUser != null) {
			if (authUser.equals("true")) {
				req.getRequestDispatcher("./userReservation.rr").forward(req, resp);
				return;		// redirect, forward 후에 return이 없으면 에러가 발생할 수 있다.
			}
		}
		// 안되 있으면 로그인 페이지로 이동
		req.getRequestDispatcher("./admin_login.jsp").forward(req, resp);
		return;
	}
	
	// 로그인페이지에서 ajax로 호출, 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서비스.login()메서드에서 id,비번 확인
		boolean result = loginService.login(req, resp);
		if (result) {
			req.getSession().setAttribute("authUser", "true");	// authUser라는 세션의 값을 true로 생성
			resp.getWriter().println("1");		// ajax통신 응답
		}
	}
}
