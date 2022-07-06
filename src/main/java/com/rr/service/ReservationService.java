package com.rr.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rr.dao.ReservationDao;
import com.rr.dto.OneDay;
import com.rr.dto.OneReservation;

public class ReservationService {
	private ReservationDao reservationDao = new ReservationDao();
	private Connection conn = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	// JDBC로드
		public ReservationService() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
			} catch (Exception e) {
				throw new IllegalStateException("jdbc 드라이버 로드 실패 : " + e.getMessage());
			}
		}
	
		
		
	public List<OneDay> getMonthReservation() {
		Calendar CalFirst = Calendar.getInstance();
		Calendar CalAfterAMonth = Calendar.getInstance();
		CalAfterAMonth.add(Calendar.MONTH, 1);
		List<OneDay> monthReservation = new ArrayList<OneDay>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kopoctc", "root", "abcd1234");
			
			while (CalFirst.before(CalAfterAMonth)) {
				OneDay oneDay = reservationDao.selectDay(conn, sdf.format(CalFirst.getTime()));
				monthReservation.add(oneDay);
				CalFirst.add(Calendar.DATE, 1);
			}
		} catch (Exception e) {
			throw new IllegalStateException("dao메서드 호출 실패" + e.getMessage());
		} finally {
			close(conn);
		}
		
		return monthReservation;
	}
	
	
	
	public OneReservation getOneReservation(HttpServletRequest req) {
		String date = req.getParameter("date");
		String roomNumber = req.getParameter("room");
		OneReservation oneReservation =  null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kopoctc", "root", "abcd1234");
			oneReservation = reservationDao.selectOneReservation(conn, roomNumber, date);
		} catch (Exception e) {
			throw new IllegalStateException("dao메서드 호출 실패" + e.getMessage());
		} finally {
			close(conn);
		}
		
		return oneReservation;
	}
	
	
	public void insertReservation(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar CalNow = Calendar.getInstance();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kopoctc", "root", "abcd1234");
			OneReservation oneReservation = new OneReservation(
											req.getParameter("name"),
											req.getParameter("date"),
											Integer.parseInt(req.getParameter("room")),
											req.getParameter("addr"),
											req.getParameter("tel"),
											req.getParameter("in_name"),
											req.getParameter("comment"),
											sdf.format(CalNow.getTime()),
											1
										);
			reservationDao.insertReservation(conn, oneReservation);
		} catch (Exception e) {
			throw new IllegalStateException("dao메서드 호출 실패" + e.getMessage());
		} finally {
			close(conn);
		}
	}
	
	
	public void updateReservation(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kopoctc", "root", "abcd1234");
			OneReservation oneReservation = new OneReservation(
											req.getParameter("name"),
											req.getParameter("date"),
											Integer.parseInt(req.getParameter("room")),
											req.getParameter("addr"),
											req.getParameter("tel"),
											req.getParameter("in_name"),
											req.getParameter("comment"),
											Integer.parseInt(req.getParameter("processing"))
										);
			reservationDao.updateReservation(conn, oneReservation);
		} catch (Exception e) {
			throw new IllegalStateException("dao메서드 호출 실패" + e.getMessage());
		} finally {
			close(conn);
		}
	}
	
	public void deleteReservation(HttpServletRequest req) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kopoctc", "root", "abcd1234");
			String date = req.getParameter("date");
			String roomNumber = req.getParameter("room");
			reservationDao.deleteReservation(conn, date, roomNumber);
		} catch (Exception e) {
			throw new IllegalStateException("dao메서드 호출 실패" + e.getMessage());
		} finally {
			close(conn);
		}
	}
	
	
	/* 파라미터로 들어온 connection의 트렌젝션을 rollback하는 메서드 */
	public void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			throw new IllegalStateException("rollback 실패" + e.getMessage());
		}
	}
	
	
	/* 파라미터로 들어온 connection 자원을 반납하는 메서드 */
	public void close(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			throw new IllegalStateException("connection 자원 반납 실패" + e.getMessage());
		}
	}
}
