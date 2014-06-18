package net.gp.gestade.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Schedules")
public class Schedule {
	
	@Id
	@Column(name="ScheduleID")
	@GeneratedValue
	Integer scheduleID;
	
	@Column(name="StadeID")
	Integer stadeID;
	
	@Column(name="AccountID")
	Integer accountID;
	
	@Column(name="DateOrder")
	String dateOrder;
	
	@Column(name="FromHour")
	String fromHour;
	
	@Column(name="ToHour")
	String toHour;
	
	@Column(name="TotalTime")
	String totalTime;
	
	@Column(name="Price")
	String price;
	
	@Column(name="Promotion")
	String promotion;
	
	@Column(name="Status")
	String status;

	public Integer getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}

	public Integer getStadeID() {
		return stadeID;
	}

	public void setStadeID(Integer stadeID) {
		this.stadeID = stadeID;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getFromHour() {
		return fromHour;
	}

	public void setFromHour(String fromHour) {
		this.fromHour = fromHour;
	}

	public String getToHour() {
		return toHour;
	}

	public void setToHour(String toHour) {
		this.toHour = toHour;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
