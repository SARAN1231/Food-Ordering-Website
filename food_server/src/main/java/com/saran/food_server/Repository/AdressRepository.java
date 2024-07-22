package com.saran.food_server.Repository;

import com.saran.food_server.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address, Long> {
}
