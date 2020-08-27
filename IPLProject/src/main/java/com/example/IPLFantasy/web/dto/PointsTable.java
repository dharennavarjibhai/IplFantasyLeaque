package com.example.IPLFantasy.web.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PointsTable {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String teamName;
	private Integer points;
	
	public PointsTable() {}

	public PointsTable(Integer id, String teamName, Integer points) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.points = points;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
