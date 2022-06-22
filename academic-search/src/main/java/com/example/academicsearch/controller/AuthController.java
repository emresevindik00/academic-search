package com.example.academicsearch.controller;


import com.example.academicsearch.model.UserRequest;
import com.example.academicsearch.security.JwtTokenProvider;
import com.example.academicsearch.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    public AuthController(AuthenticationManager authenticationManager,UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;

    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest userRequest) {
        String jwtToken = jwtTokenProvider.generateJwtTokenByUserMail(userRequest.getEmail());
        return jwtToken;
    }

    /*@GetMapping("/find/{email}")
    public ResponseEntity<User> register(@PathVariable String email) {
        return ResponseEntity.ok(userService.getOneUserByEmail(email));
    }*/
}
