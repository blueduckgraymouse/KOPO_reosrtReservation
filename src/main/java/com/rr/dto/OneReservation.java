package com.rr.dto;

public class OneReservation {
	String name = null;
    String resv_date = null;
    int room = 0;
    String addr = null;
    String telnum = null;
    String in_name = null;
    String comment = null;
    String write_date = null;
    int processing = 0;

	public OneReservation(String name, String resv_date, int room, String addr, String telnum, String in_name,
			String comment, String write_date, int processing) {
		this.name = name;
		this.resv_date = resv_date;
		this.room = room;
		this.addr = addr;
		this.telnum = telnum;
		this.in_name = in_name;
		this.comment = comment;
		this.write_date = write_date;
		this.processing = processing;
	}
	
	public OneReservation(String name, String resv_date, int room, String addr, String telnum, String in_name,
			String comment, int processing) {
		this.name = name;
		this.resv_date = resv_date;
		this.room = room;
		this.addr = addr;
		this.telnum = telnum;
		this.in_name = in_name;
		this.comment = comment;
		this.processing = processing;
	}

	public String getName() {
		return name;
	}

	public String getResv_date() {
		return resv_date;
	}

	public int getRoom() {
		return room;
	}

	public String getAddr() {
		return addr;
	}

	public String getTelnum() {
		return telnum;
	}

	public String getIn_name() {
		return in_name;
	}

	public String getComment() {
		return comment;
	}

	public String getWrite_date() {
		return write_date;
	}

	public int getProcessing() {
		return processing;
	}
	
	@Override
	public String toString() {
		return "OneReservation [name=" + name + ", resv_date=" + resv_date + ", room=" + room + ", addr=" + addr
				+ ", telnum=" + telnum + ", in_name=" + in_name + ", comment=" + comment + ", write_date=" + write_date
				+ ", processing=" + processing + "]";
	}
}
