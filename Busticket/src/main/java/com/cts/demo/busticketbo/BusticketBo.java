package com.cts.demo.busticketbo;

import java.sql.Date;
import java.sql.Time;



public class BusticketBo {

	private int busno;
	private int seats;
	private int price;
	private Date date;
	private Time time;
	private String source;
	private String Destination;
    private String name;
    private int mobile;
	@Override
	public String toString() {
		return "BusticketBo [busno=" + busno + ", seats=" + seats + ", price=" + price + ", date=" + date + ", time="
				+ time + ", source=" + source + ", Destination=" + Destination + ", name=" + name + ", mobile=" + mobile
				+ "]";
	}
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
}
