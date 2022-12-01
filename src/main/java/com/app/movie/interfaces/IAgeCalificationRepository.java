package com.app.movie.interfaces;

import com.app.movie.entities.AgeCalification;
import org.springframework.data.repository.CrudRepository;

public interface IAgeCalificationRepository extends CrudRepository<AgeCalification, String> {
}
