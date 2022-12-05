package com.app.movie.service;

import com.app.movie.entities.Score;
import com.app.movie.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository repository;

    public Iterable<Score> get() {
        Iterable<Score> response = repository.getAll();
        return response;
    }

    public Score create(Score request) {
        return repository.save(request);
    }

    public Score update(Score score) {
        Score scoreToUpdate = new Score();

        Optional<Score> currentScore = repository.findById(score.getId());
        if (!currentScore.isEmpty()) {
            scoreToUpdate = score;
            scoreToUpdate = repository.save(scoreToUpdate);
        }
        return scoreToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
