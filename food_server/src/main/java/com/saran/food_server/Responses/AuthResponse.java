package com.saran.food_server.Responses;

import com.saran.food_server.Models.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;

    private String message;

    private USER_ROLE role;
}
