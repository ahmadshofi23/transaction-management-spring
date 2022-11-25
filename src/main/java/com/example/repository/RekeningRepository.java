package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.RekeningEntity;

public interface RekeningRepository extends CrudRepository<RekeningEntity, Long>{

    public RekeningEntity findByNorek(String norek);
}
