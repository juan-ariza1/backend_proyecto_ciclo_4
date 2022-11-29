/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.ReportClientDto;
import com.app.movie.entities.User;

import com.app.movie.repository.ClientRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public Iterable<User> get() {
        Iterable<User> response = repository.getAll();
        return response;
    }

    public ReportClientDto getReport() {
        Optional<User> client = repository.findById("6380442df71ad74770fc57e1");
        ReportClientDto reportClientDto= new ReportClientDto();
        reportClientDto.birthDate=client.get().getBirthDate();
        reportClientDto.email=client.get().getEmail();
        reportClientDto.id=client.get().getIdUser();
        return reportClientDto;
    }

    public User create(User request) {

        return repository.save(request);

    }

    public User update(User client) {
        User clientToUpdate = new User();

        Optional<User> currentClient = repository.findById(client.getIdUser());
        if (!currentClient.isEmpty()) {            
            clientToUpdate = client;
            clientToUpdate=repository.save(clientToUpdate);
        }
        return clientToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
