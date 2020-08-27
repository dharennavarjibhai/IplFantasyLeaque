package com.example.IPLFantasy.web.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchPrediction {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer Id;
	private Integer MatchId;
	private Integer UserId;
	private String winner;
	
	public MatchPrediction()
	{}

	public MatchPrediction(Integer matchId, Integer userId, Integer id, String winner) {
		super();
		MatchId = matchId;
		UserId = userId;
		Id = id;
		this.winner = winner;
	}

	public Integer getMatchId() {
		return MatchId;
	}

	public void setMatchId(Integer matchId) {
		MatchId = matchId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	
}
