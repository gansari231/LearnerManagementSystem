package org.airtribe.LearnerManagementSystemBelC14.controller;

import org.airtribe.LearnerManagementSystemBelC14.dto.AuthRequest;
import org.airtribe.LearnerManagementSystemBelC14.dto.RegisterRequest;
import org.airtribe.LearnerManagementSystemBelC14.entity.User;
import org.airtribe.LearnerManagementSystemBelC14.repository.UserRepository;
import org.airtribe.LearnerManagementSystemBelC14.utility.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          UserRepository userRepository,
                          PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    // ✅ Register endpoint
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        // Check if user already exists
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "User already exists";
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);

        return "User registered successfully";
    }

    // ✅ Login endpoint
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );

        return jwtUtil.generateToken(request.getEmail());
    }
}
