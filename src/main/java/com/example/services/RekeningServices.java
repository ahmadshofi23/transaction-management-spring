package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.RekeningEntity;
import com.example.repository.RekeningRepository;

@Service
@Transactional
public class RekeningServices {
    
    @Autowired
    private RekeningRepository rekeningRepository;


    public RekeningEntity create(RekeningEntity rekeningEntity){
        return rekeningRepository.save(rekeningEntity);
    }

    public Iterable<RekeningEntity> findAll(){
        return rekeningRepository.findAll();
    }

    public void transfer(String  norek1, String norek2, double ammount){
        RekeningEntity rekening1 = rekeningRepository.findByNorek(norek1);
        if(rekening1 == null){
            throw new RuntimeException("Norek 1 tidak valid");
        }
        if(rekening1.getSaldo() <= ammount){
            throw new RuntimeException("Saldo tidak cukup");
        }
        rekening1.setSaldo(rekening1.getSaldo() - ammount);
        rekeningRepository.save(rekening1);

        RekeningEntity rekening2 = rekeningRepository.findByNorek(norek2);
        if (rekening2 == null) {
            throw new RuntimeException("Norek2 tidak valid");
        }
        rekening2.setSaldo(rekening2.getSaldo() + ammount);
        rekeningRepository.save(rekening2);
    }
}
