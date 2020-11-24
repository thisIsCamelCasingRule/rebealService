package com.example.rebealService.service;

import com.example.rebealService.model.Kingdom;
import org.springframework.data.repository.CrudRepository;


public interface KingdomRepo extends CrudRepository<Kingdom, Integer> {
    Kingdom getKingdomByName(String name);
}
