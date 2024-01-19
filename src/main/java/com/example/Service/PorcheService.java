package com.example.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Porche;
import com.example.repo.PorcheRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PorcheService {

    @Autowired
    private PorcheRepo repo;   

    public Iterable<Porche> findAll(){
        return repo.findAll();
    }

    public void addPorche(Porche porche){
       repo.save(porche);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Porche> findById(long id){
        return repo.findById(id);
    }

    public void updatePorche(Porche porche){
        repo.save(porche);
    }
}