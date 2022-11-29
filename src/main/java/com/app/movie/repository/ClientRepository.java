/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.User;
import com.app.movie.interfaces.IClientRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres
 */
@Repository
public class ClientRepository {
    
    @Autowired
    IClientRepository repository;
    
    public Iterable<User> getAll(){
        return repository.findAll();
    }
    
    public Optional<User> findById(String id){
        Optional<User> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public User save(User client){
        return repository.save(client);
    }
    
}
