package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Mobil;
import com.example.entity.Sedan;
public interface MobilRepo extends CrudRepository<Mobil ,Long>{

    void save(Sedan mobil);


    
}
