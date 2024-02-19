package com.example.springwebvideoservice.securityconfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthRequest {
    private String name;
    private String email;
    private String password;
}
