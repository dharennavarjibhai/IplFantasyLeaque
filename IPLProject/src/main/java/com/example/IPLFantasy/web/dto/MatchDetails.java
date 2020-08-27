package com.example.IPLFantasy.web.dto;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class MatchDetails {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	
	private Integer matchId;
	@NotNull
    @NotEmpty
	private String team1;
	@NotNull
    @NotEmpty
	private String team2;
	
	private Date date;
	
	private boolean toss;
	private String winner;
	@NotNull
    @NotEmpty
	private String venue;
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isToss() {
		return toss;
	}
	public void setToss(boolean toss) {
		this.toss = toss;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public MatchDetails(Integer matchId, @NotNull @NotEmpty String team1, @NotNull @NotEmpty String team2,
			 Date date,  boolean toss, String winner,
			@NotNull @NotEmpty String venue) {
		super();
		this.matchId = matchId;
		this.team1 = team1;
		this.team2 = team2;
		this.date = date;
		this.toss = toss;
		this.winner = winner;
		this.venue = venue;
	}
	
	public MatchDetails() {
		
	}
	
	
	
	
	

}
