/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.ReportClientDto;
import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Client;

import com.app.movie.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class ClientService {

    private final String CLIENT_REGISTERED = "El email ya se encuentra asociado a otra cuenta";
    private final String CLIENT_SUCCESS = "Usuario registrado correctamente";

    @Autowired
    ClientRepository repository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //Revisar validacion de que el usuario no pueda ingresar dos veces el score-----
    public Iterable<Client> get() {
        Iterable<Client> response = repository.getAll();
        return response;
    }

    public Optional<Client> getByCredential(String credential) {
        String pair = new String(Base64.decodeBase64(credential.substring(6)));
        String email = pair.split(":")[0];
        String pass = pair.split(":")[1];

        Optional<Client> client = repository.findByEmail(email);
        if(!matchPass(pass,client.get().getPassword())){
            return null;
        }
        return client;
    }

    public ReportClientDto getReport() {
        Optional<Client> client = repository.findById("");  //6380442df71ad74770fc57e1
        ReportClientDto reportClientDto = new ReportClientDto();
        reportClientDto.birthDate=client.get().getBirthDate();
        reportClientDto.email=client.get().getEmail();
        reportClientDto.id=client.get().getId();
        return reportClientDto;
    }

    public ResponseDto create(Client request) {
        ResponseDto responseDto = new ResponseDto();
        List<Client> emails = repository.getByEmail(request.getEmail());
        if (emails.size()>0){
            responseDto.status = false;
            responseDto.message = CLIENT_REGISTERED;
        }else {
            request.setPassword(encrypt(request.getPassword()));
            repository.save(request);
            responseDto.status = true;
            responseDto.message = CLIENT_SUCCESS;
            responseDto.id = request.getId();
        }
        return responseDto;
    }

    public Client update(Client client) {
        Client clientToUpdate = new Client();

        Optional<Client> currentClient = repository.findById(client.getId());
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

    //Recibe contraseña
    private String encrypt(String pass){
        return this.passwordEncoder.encode(pass);
    }
    private Boolean matchPass(String pass,String dbPass){
        return this.passwordEncoder.matches(pass,dbPass);
    }
}
