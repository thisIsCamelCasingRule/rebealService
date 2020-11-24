package com.example.rebealService.api;


import com.example.rebealService.service.RebealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rebeal")
public class RebealController {
    @Autowired
    private RebealService service;

    @GetMapping
    public ResponseEntity<Boolean> rebeal(@RequestParam String oldKing, @RequestParam String newKing)
    {
        return ResponseEntity.ok(service.rebeal(oldKing, newKing));
    }

}
