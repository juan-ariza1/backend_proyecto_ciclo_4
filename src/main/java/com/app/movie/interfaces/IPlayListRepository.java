package com.app.movie.interfaces;

import com.app.movie.entities.PlayList;
import org.springframework.data.repository.CrudRepository;

public interface IPlayListRepository extends CrudRepository<PlayList, String> {
}
