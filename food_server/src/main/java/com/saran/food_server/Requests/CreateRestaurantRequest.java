package com.saran.food_server.Requests;

import com.saran.food_server.Models.Address;
import com.saran.food_server.Models.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;
    private String name;
    private Address address;
    private String description;
    private ContactInformation contactInformation;
    private List<String> images;
    private String OpeningHours;
    private String CuisineTpe;
}
