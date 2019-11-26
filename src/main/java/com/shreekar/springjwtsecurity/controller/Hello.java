package com.shreekar.springjwtsecurity.controller;

import com.shreekar.springjwtsecurity.config.MyUserDetailService;
import com.shreekar.springjwtsecurity.models.AuthRequest;
import com.shreekar.springjwtsecurity.models.AuthResponse;
import com.shreekar.springjwtsecurity.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public MyUserDetailService myUserDetailService;

    @Autowired
    public JwtUtils jwtUtils;

    @RequestMapping(value= "/test")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Invalid username password");
        }
        final UserDetails userDetails = myUserDetailService.loadUserByUsername(authRequest.getUserName());
        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));


    }


    @GetMapping("/home")
    public String home() {
        return "<h1>home<h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>user<h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>admin<h1>";
    }
}
