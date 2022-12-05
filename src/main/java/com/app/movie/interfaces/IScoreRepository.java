package com.app.movie.interfaces;

import com.app.movie.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface IScoreRepository extends CrudRepository <Score, String> {
}
