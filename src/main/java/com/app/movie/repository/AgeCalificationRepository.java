package com.app.movie.repository;

import com.app.movie.entities.AgeCalification;
import com.app.movie.interfaces.IAgeCalificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AgeCalificationRepository {

    @Autowired
    IAgeCalificationRepository repository;

    public Iterable<AgeCalification> getAll(){
        return repository.findAll();
    }

    public Optional<AgeCalification> findById(String id){
        Optional<AgeCalification> response = repository.findById(id);
        return response;
    }

    public Boolean existsById(String id){
        return repository.existsById(id);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public AgeCalification save(AgeCalification ageCalification){
        return repository.save(ageCalification);
    }
}
