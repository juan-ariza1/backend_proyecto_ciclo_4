package com.app.movie.repository;

import com.app.movie.entities.PlayList;
import com.app.movie.interfaces.IPlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PlayListRepository {
    @Autowired
    IPlayListRepository repository;

    public Iterable<PlayList> getAll(){
        return repository.findAll();
    }

    public Optional<PlayList> findById(String id){
        Optional<PlayList> response= repository.findById(id);
        return response;
    }

    public Boolean existsById(String id){
        return repository.existsById(id);
    }

    public void  deleteById(String id){
        repository.deleteById(id);
    }

    public PlayList save(PlayList playList){
        return repository.save(playList);
    }
}
