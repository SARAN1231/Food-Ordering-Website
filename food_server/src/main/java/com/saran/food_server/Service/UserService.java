package com.saran.food_server.Service;

import com.saran.food_server.Models.Users;

public interface UserService {


    public Users findByEmail(String email) throws Exception;
    public Users findByJwt(String jwt) throws Exception;
}
