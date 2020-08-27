package com.example.IPLFantasy.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.IPLFantasy.web.dto.MatchDetails;
import com.example.IPLFantasy.web.dto.MatchPrediction;

@Repository
public interface MatchPredictionRepository extends JpaRepository<MatchPrediction, Integer>{
	 @Query(value = "select user_id FROM Match_Prediction where match_id = :matchId and winner = :winner", nativeQuery = true)
	List<Integer> getDetailsByMatchIdAndWinner(@Param("matchId") Integer matchId, @Param("winner") String winner);
}
