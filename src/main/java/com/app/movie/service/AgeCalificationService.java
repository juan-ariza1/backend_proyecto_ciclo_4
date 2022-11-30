package com.app.movie.service;

import com.app.movie.entities.AgeCalification;
import com.app.movie.repository.AgeCalificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgeCalificationService {
    @Autowired
    AgeCalificationRepository repository;

    public Iterable<AgeCalification> get(){
        Iterable<AgeCalification> response = repository.getAll();
        return response;
    }

    public AgeCalification create(AgeCalification request){
        return repository.save(request);
    }

    public AgeCalification update(AgeCalification ageCalification){
        AgeCalification ageCalificationToUpdate = new AgeCalification();
        Optional<AgeCalification> currentAgeCalification = repository.findById(ageCalification.getId());
        if (!currentAgeCalification.isEmpty()){
            ageCalificationToUpdate = ageCalification;
            ageCalificationToUpdate = repository.save(ageCalificationToUpdate);
        }
        return ageCalificationToUpdate;
    }

    public Boolean delete(String id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }
}
