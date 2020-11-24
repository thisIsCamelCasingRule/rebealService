package com.example.rebealService.service;

import com.example.rebealService.model.King;
import org.springframework.data.repository.CrudRepository;

public interface KingRepo extends CrudRepository<King, Integer> {
    King getKingByName(String name);
}
