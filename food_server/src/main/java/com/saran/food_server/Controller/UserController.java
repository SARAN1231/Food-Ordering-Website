package com.saran.food_server.Controller;

import com.saran.food_server.Models.Users;
import com.saran.food_server.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<Users> findUserByJwtToken(@RequestHeader("Authorization") String token) throws Exception {
        System.out.println("Received Token: " + token);  // Log the received token
        Users user = userService.findByJwt(token);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

