package com.backend.webappserver.payload;

import java.sql.Date;

public class UserModel {
	private Integer userId;
    private Date  selectedDate;
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	
}
