package com.app.movie.controller;

import com.app.movie.entities.AgeCalification;
import com.app.movie.service.AgeCalificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agecalification")
@CrossOrigin(origins = "*")
public class AgeClasificationController {
    @Autowired
    AgeCalificationService service;

    @GetMapping("")
    public Iterable<AgeCalification> get(){
        return service.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public AgeCalification create(@RequestBody AgeCalification request){
        return service.create(request);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AgeCalification update(@RequestBody AgeCalification request){
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }

}
