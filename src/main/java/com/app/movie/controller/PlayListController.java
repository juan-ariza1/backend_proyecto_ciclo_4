package com.app.movie.controller;

import com.app.movie.entities.PlayList;
import com.app.movie.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlist")
@CrossOrigin(origins = "*")
public class PlayListController {
    @Autowired
    PlayListService service;

    @GetMapping("")
    public Iterable<PlayList> get(){
        return service.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayList create(@RequestBody PlayList request){
        return service.create(request);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PlayList update(@RequestBody PlayList request){
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
