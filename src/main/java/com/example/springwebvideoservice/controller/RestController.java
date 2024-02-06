package com.example.springwebvideoservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/open")
    public ResponseEntity<String> openMapping(){
        return ResponseEntity.ok("OPEN MAPPING");
    }
    @GetMapping("/closed")
    public ResponseEntity<String> closedMapping(){
        return ResponseEntity.ok("CLOSED MAPPING");
    }
}
