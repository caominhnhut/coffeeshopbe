package com.projectbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectbase.dto.BillDto;
import com.projectbase.dto.ResponseDto;
import com.projectbase.factory.ValidationType;
import com.projectbase.mapper.BillMapper;
import com.projectbase.model.Bill;
import com.projectbase.service.BillService;
import com.projectbase.validator.ValidatorProvider;

@RestController
@RequestMapping(value ="/bills")
public class BillController{

    @Autowired
    private BillService billService;

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private ValidatorProvider validatorProvider;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ResponseDto<String>> generateBill(@RequestBody BillDto billDto) {

        //validatorProvider.execute(ValidationType.BILL_CREATION, billDto);

        Bill bill = billMapper.toModel(billDto);
        String categoryId = billService.generate(bill);

        return ResponseEntity.ok(ResponseDto.response(categoryId));
    }
}
