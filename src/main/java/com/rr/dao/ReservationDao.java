package com.rr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rr.dto.OneDay;
import com.rr.dto.OneReservation;

public class ReservationDao {
	
	public OneDay selectDay(Connection conn, String date) {
		String sql = "select * from resortresv where resv_date = ?";
		OneDay oneday = new OneDay(date);
		
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, date);
			
			try (ResultSet rset = pstmt.executeQuery()) {
				while (rset.next()) {
					switch(rset.getString("room")) {
					case "1":
						oneday.setRoom1(rset.getString("name"));
						break;
					case "2":
						oneday.setRoom2(rset.getString("name"));
						break;
					case "3":
						oneday.setRoom3(rset.getString("name"));
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return oneday;
	}
	
	public OneReservation selectOneReservation(Connection conn, String roomNumber, String date) {
		String sql = "select * from resortresv where room=? and resv_date = ?";
		OneReservation oneReservation = null;
		
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, roomNumber);
			pstmt.setString(2, date);
			
			try (ResultSet rset = pstmt.executeQuery()) {
				while (rset.next()) {
					oneReservation = new OneReservation(
								rset.getString("name"),
								rset.getString("resv_date"),
								rset.getInt("room"),
								rset.getString("addr"),
								rset.getString("telnum"),
								rset.getString("in_name"),
								rset.getString("comment"),
								rset.getString("write_date"),
								rset.getInt("processing")
							);
				}
			}
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return oneReservation;
	}
	
	public int insertReservation(Connection conn, OneReservation oneReservation) {
		String sql = "insert into resortresv values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, oneReservation.getName());
			pstmt.setString(2, oneReservation.getResv_date());
			pstmt.setInt(3, oneReservation.getRoom());
			pstmt.setString(4, oneReservation.getAddr());
			pstmt.setString(5, oneReservation.getTelnum());
			pstmt.setString(6, oneReservation.getIn_name());
			pstmt.setString(7, oneReservation.getComment());
			pstmt.setString(8, oneReservation.getWrite_date());
			pstmt.setInt(9, oneReservation.getProcessing());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return result;
	}
}
