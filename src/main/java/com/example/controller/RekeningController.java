package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TransferRequest;
import com.example.entity.RekeningEntity;
import com.example.services.RekeningServices;

@RestController
@RequestMapping("/rekening")
public class RekeningController {
    
    @Autowired
    private RekeningServices rekeningServices;

    @PostMapping
    public RekeningEntity create(@RequestBody RekeningEntity rekeningEntity){
        return rekeningServices.create(rekeningEntity);
    }

    @GetMapping
    public Iterable<RekeningEntity> findAll(){
        return rekeningServices.findAll();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transfer){
        rekeningServices.transfer(transfer.getNorek1(), transfer.getNorek2(), transfer.getAmount());
    }


}
