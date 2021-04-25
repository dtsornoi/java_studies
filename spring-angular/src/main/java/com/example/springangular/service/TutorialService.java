package com.example.springangular.service;

import com.example.springangular.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {
    List<Tutorial> getAllTutorials(String title);

    List<Tutorial> getTutorialsByPublished(boolean isPublished);

    Optional<Tutorial> getTutorialById(long id);

    Tutorial createTutorial(Tutorial tutorial);

    Tutorial updateTutorial(long id, Tutorial newTutorial);

    boolean deleteTutorial(long id);

    void deleteAllTutorials();
}
