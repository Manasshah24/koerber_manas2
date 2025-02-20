package com.example.q2_jwt.JwtUtil;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}

