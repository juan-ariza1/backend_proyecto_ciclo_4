/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Category;
import com.app.movie.interfaces.ICategoryRepository;

import com.app.movie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author Andres
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Iterable<Category> get() {
        Iterable<Category> response = repository.getAll();
        return response;
    }

    public ResponseDto create(Category request) {

        Category newCategory = repository.save(request);

        ResponseDto responseDto = new ResponseDto();
        responseDto.status=true;
        responseDto.message="Genero creado correctamente";
        responseDto.id= newCategory.getId();
        return responseDto;
    }

    public Category update(Category category) {
        Category categoryToUpdate = new Category();

        Optional<Category> currentCategory = repository.findById(category.getId());
        if (repository.existsById(category.getId())) {
            categoryToUpdate = category;
            repository.save(categoryToUpdate);
        }
        return categoryToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
