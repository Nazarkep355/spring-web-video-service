package com.example.springwebvideoservice.securityconfig;

import com.example.springwebvideoservice.entity.Role;
import com.example.springwebvideoservice.entity.User;
import com.example.springwebvideoservice.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return AuthResponse.builder()
                    .token("User exists").build();
        }
        userRepository.save(user);
        String token= jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token).build();
    }
    public AuthResponse login(AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token= jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token).build();
    }
}
