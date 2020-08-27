package com.example.IPLFantasy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.IPLFantasy.web.dto.User;
import com.example.IPLFantasy.web.dto.UserDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HomeController {

    @GetMapping(value = "/signin")
    public String signin_cli() {
        return "index.html";
    }
    @PostMapping("/signup")
    @ResponseBody
    public String register_cli(@RequestBody User user) {
    	System.out.println("hihello");
    	
    	System.out.println(user.getName() + user.getEmail() +user.getPassword());
    	return "index.html";
    }
    /*@GetMapping(value = "/home{email}")
    public String home_cli() { return "index.html";}
    @GetMapping(value = "/dashboard")
    public String dashboard_cli() { return "index.html";}
    @GetMapping(value = "/rules")
    public String rules_cli() { return "index.html";}
    @GetMapping(value = "/playing11{email}")
    public String playing11_cli(){ return "index.html";}
    @GetMapping(value = "/powerplayer{email}")
    public String powerplayer_cli(){ return "index.html";}
*/
}


