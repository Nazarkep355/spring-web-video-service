package com.example.springwebvideoservice.controller;

import com.example.springwebvideoservice.securityconfig.AuthRequest;
import com.example.springwebvideoservice.securityconfig.AuthResponse;
import com.example.springwebvideoservice.securityconfig.AuthService;
import com.example.springwebvideoservice.securityconfig.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
@PostMapping("/api/login")
    public AuthResponse login(  AuthRequest request){
        return service.login(request);
}
    @PostMapping("/api/register")
    public AuthResponse register(  AuthRequest request){
        return service.register(request);
    }
    @GetMapping("/api/open")
    public ResponseEntity<String> openMapping(){
        return ResponseEntity.ok("OPEN MAPPING");
    }
    @GetMapping("/api/closed")
    public ResponseEntity<String> closedMapping(){
        return ResponseEntity.ok("CLOSED MAPPING");
    }
}
