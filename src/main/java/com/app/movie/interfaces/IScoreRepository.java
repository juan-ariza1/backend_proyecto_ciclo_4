package com.app.movie.interfaces;

import com.app.movie.entities.Movie;
import com.app.movie.entities.Score;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IScoreRepository extends CrudRepository<Score, String> {
    @Query(value= "{movie.id : ?0,client.id:?1}")
    Iterable<Score> getScoreByMovieAndClient(String movieId,String clientId);
}
