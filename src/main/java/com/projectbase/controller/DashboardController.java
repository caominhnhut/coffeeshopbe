package com.projectbase.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectbase.dto.ResponseDto;

@RestController
@RequestMapping(value ="/dashboards")
public class DashboardController{

    @GetMapping
    public ResponseEntity<ResponseDto<Map<String, Integer>>> getAll() {
        return ResponseEntity.ok(ResponseDto.response(Map.of("product",1, "bill",2, "category",3)));
    }
}
