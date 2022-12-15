/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.movie.interfaces;

import com.app.movie.entities.Client;
import com.app.movie.entities.Movie;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Andres
 */
public interface IClientRepository extends CrudRepository<Client, String> {
    @Query(value = "{email : ?0}")
    List<Client> getClientsByEmail(String email);

    @Query(value= "{email : ?0}")
    Optional<Client> findByEmail(String email);
}
