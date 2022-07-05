package com.rr.dto;

public class OneDay {
	String date = null;
	String day = null;
	String room1 = "예약가능";
	String room2 = "예약가능";
	String room3 = "예약가능";
	
	public OneDay(String date) {
		this.date = date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public void setRoom1(String room1) {
		this.room1 = room1;
	}
	public void setRoom2(String room2) {
		this.room2 = room2;
	}
	public void setRoom3(String room3) {
		this.room3 = room3;
	}

	public String getDate() {
		return date;
	}

	public String getRoom1() {
		return room1;
	}

	public String getRoom2() {
		return room2;
	}

	public String getRoom3() {
		return room3;
	}

	@Override
	public String toString() {
		return "OneDay [date=" + date + ", room1=" + room1 + ", room2=" + room2 + ", room3=" + room3 + "]";
	}
	
	
}
