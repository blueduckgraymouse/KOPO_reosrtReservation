package com.rr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rr.dto.OneReservation;
import com.rr.service.ReservationService;

// 예약 상세 보기, 수정, 삭제 처리
@WebServlet(name = "ReservationAdminContoller", urlPatterns = {"/admin.rr"})	
public class ReservationAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService reservationService = new ReservationService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String authUser = (String)req.getSession().getAttribute("authUser");
		// 관리자 로그인 확인
		if (authUser != null) {
			if (authUser.equals("true")) {
				// 수정 양식 페이지 로드 (get)
				if (req.getParameter("_method") == null || req.getParameter("_method") == "") {
					OneReservation oneReservation = reservationService.getOneReservation(req);
					req.setAttribute("oneReservation", oneReservation);
					System.out.println(oneReservation);
					req.getRequestDispatcher("./reservation_updateForm.jsp").forward(req, resp);
					return;
				// 예약 삭제 처리 (delete)	<- form태그에서 delete method를 지원하지 않아 요소로 method를 추가해 명시적으로 delete임을 전달.
				} else if (req.getParameter("_method").equals("DELETE")) {
					reservationService.deleteReservation(req);
					resp.sendRedirect("./userReservation.rr");
				}
			}
		}
	}
	
	// 예약 수정 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String authUser = (String)req.getSession().getAttribute("authUser");
		if (authUser.equals("true")) {
			reservationService.updateReservation(req);
			req.setAttribute("resv_date", req.getParameter("resv_date"));
			req.setAttribute("room", req.getParameter("room"));
			resp.sendRedirect("./userReservation.rr");
			return;
		} else {
			req.getRequestDispatcher("./admin_login.jsp").forward(req, resp);
			return;
		}
	}
}
