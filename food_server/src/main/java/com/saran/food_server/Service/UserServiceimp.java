package com.saran.food_server.Service;

import com.saran.food_server.Config.JwtProvider;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimp implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public UserServiceimp(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Users findByEmail(String email) throws Exception {
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found...");
        }
        return user;
    }

    @Override
    public Users findByJwt(String jwt) throws Exception {
        System.out.println("Processing JWT: " + jwt);  // Log the JWT before processing
        jwt = jwt.substring(7);
        String email = jwtProvider.getEmailFromToken(jwt);
        System.out.println("Extracted email: " + email);  // Log the extracted email
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found...");
        }
        return user;
    }
}
