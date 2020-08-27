package com.example.IPLFantasy;

import com.example.IPLFantasy.web.dto.MatchDetails;
import com.example.IPLFantasy.web.dto.PointsTable;
import com.example.IPLFantasy.web.repository.MatchRepository;
import com.example.IPLFantasy.web.repository.PointsTableRepository;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication(scanBasePackages = {"com.example.IPLFantasy.web"})
@EnableJpaAuditing
@RestController
public class IPLFantasyApplication {
	public static void main(String[] args) {
		SpringApplication.run(IPLFantasyApplication.class, args);
	}
	

	

}
