package com.example.IPLFantasy.model;

import java.util.List;

import com.example.IPLFantasy.web.dto.UserDto;

public class LeaderBoard {
	
	private Integer points;
	private int position;
	private List<UserDto> topUsers;
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public List<UserDto> getTopUsers() {
		return topUsers;
	}
	public void setTopUsers(List<UserDto> topUsers) {
		this.topUsers = topUsers;
	}
	
	
	

}
