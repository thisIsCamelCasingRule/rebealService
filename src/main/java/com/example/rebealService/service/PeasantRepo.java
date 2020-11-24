package com.example.rebealService.service;

import com.example.rebealService.model.Peasant;
import org.springframework.data.repository.CrudRepository;

public interface PeasantRepo extends CrudRepository<Peasant, Integer> {
    Peasant getPeasantByName(String name);
}
