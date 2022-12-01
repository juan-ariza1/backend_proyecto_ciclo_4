package com.app.movie.service;

import com.app.movie.entities.PlayList;
import com.app.movie.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayListService {

    @Autowired
    PlayListRepository repository;

    public Iterable<PlayList> get(){
        Iterable<PlayList> response = repository.getAll();
        return response;
    }

    public PlayList create(PlayList request){
        return repository.save(request);
    }

    public PlayList update(PlayList playList){
        PlayList playListToUpdate = new PlayList();
        Optional<PlayList> currentPlayList = repository.findById(playList.getId());
        if (!currentPlayList.isEmpty()){
            playListToUpdate = playList;
            playListToUpdate = repository.save(playListToUpdate);
        }
        return playListToUpdate;
    }

    public Boolean  delete(String id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }
}
