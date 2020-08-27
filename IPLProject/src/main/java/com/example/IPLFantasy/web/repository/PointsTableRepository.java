package com.example.IPLFantasy.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.IPLFantasy.web.dto.MatchDetails;
import com.example.IPLFantasy.web.dto.PointsTable;
@Repository
public interface PointsTableRepository extends JpaRepository<PointsTable, Integer> {

}
