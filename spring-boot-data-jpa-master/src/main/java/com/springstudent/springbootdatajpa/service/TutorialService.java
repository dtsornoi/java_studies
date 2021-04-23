package com.springstudent.springbootdatajpa.service;

import com.springstudent.springbootdatajpa.entity.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {
    List<Tutorial> getAllTutorials();

    Optional<Tutorial> findById(long id);

    Tutorial save(Tutorial tutorial);

    void deleteById(long id);
}
