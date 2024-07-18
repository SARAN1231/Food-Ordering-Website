package com.saran.food_server.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class Restaurantdto {

    private Long id;
    private String title;
    private String description;
    @Column(length = 1000)
    private List<String> image;
}
