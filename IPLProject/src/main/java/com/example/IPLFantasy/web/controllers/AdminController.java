package com.example.IPLFantasy.web.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.IPLFantasy.web.dto.MatchDetails;
import com.example.IPLFantasy.web.dto.PointsTable;
import com.example.IPLFantasy.web.dto.UserDto;
import com.example.IPLFantasy.web.repository.MatchPredictionRepository;
import com.example.IPLFantasy.web.repository.MatchRepository;
import com.example.IPLFantasy.web.repository.PointsTableRepository;
import com.example.IPLFantasy.web.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {

	 @Autowired MatchRepository matchRepo;
	 @Autowired MatchPredictionRepository predictionRepo;
	 @Autowired PointsTableRepository pointsTableRepo;
	 @Autowired UserRepository userRepo;
	 
	@PostMapping(value = "/api/winner")
	public ResponseEntity<String> declareWinner(@RequestParam("matchId") Integer matchId, @RequestParam("winningTeam") String winningTeam){
		 MatchDetails match= matchRepo.findById(matchId).get();
		 match.setWinner(winningTeam);
		matchRepo.save(match);
		calculatedPoints(matchId,winningTeam);
		return new ResponseEntity<>("Succussful", HttpStatus.OK);
		 
	}
	 
	 public void calculatedPoints(Integer matchId,String winner) {
		 List<Integer> users=predictionRepo.getDetailsByMatchIdAndWinner(matchId,winner);
		 MatchDetails match=matchRepo.findById(matchId).get();
		 PointsTable pointTable=new  PointsTable();
		 pointTable.setTeamName(winner);
		 Example<PointsTable> example= Example.of(pointTable);
		 PointsTable pointsWinningTeam=pointsTableRepo.findOne( example).get();
		 PointsTable pointsLoosingTeam;
		 if(winner.equalsIgnoreCase(match.getTeam1())) {
			 pointTable.setTeamName(match.getTeam2());
			 example= Example.of(pointTable);
			 pointsLoosingTeam =pointsTableRepo.findOne( example).get();
		 }else {
			 pointTable.setTeamName(match.getTeam1());
			 example= Example.of(pointTable);
			 pointsLoosingTeam =pointsTableRepo.findOne( example).get();
		 }
		 
		 users.forEach(userId->{
			UserDto user=userRepo.findById(userId).get();
			int points;
			int pointsDiff=pointsLoosingTeam.getPoints()-pointsWinningTeam.getPoints();
			if(pointsDiff>=6) {
				points=5;
			}else if(pointsDiff>0) {
				points=3;
			}else {
				points=2;
			}
			user.setPoints(user.getPoints()+points);
			userRepo.save(user);
			 
		 });
		 
		 pointsWinningTeam.setPoints(pointsWinningTeam.getPoints()+2);
		 pointsTableRepo.save(pointsWinningTeam);
		 
		 
		 
	 }
}
