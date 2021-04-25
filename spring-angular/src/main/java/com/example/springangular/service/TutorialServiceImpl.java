package com.example.springangular.service;

import com.example.springangular.model.Tutorial;
import com.example.springangular.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService{

    private TutorialRepository repository;

    @Autowired
    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.repository = tutorialRepository;
    }

    @Override
    public List<Tutorial> getAllTutorials(String title) {
        if (title != null){
            return repository.findTutorialsByTitle(title);
        }else {
            return repository.findAll();
        }
    }

    @Override
    public List<Tutorial> getTutorialsByPublished(boolean isPublished) {
        return repository.findByPublished(isPublished);
    }

    @Override
    public Optional<Tutorial> getTutorialById(long id) {
        return repository.findById(id);
    }

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return repository.save(tutorial);
    }

    @Override
    public Tutorial updateTutorial(long id, Tutorial newTutorial) {
        Optional<Tutorial> oldTutorial = getTutorialById(id);
        if (oldTutorial.isPresent()){
            Tutorial tempTutorial = oldTutorial.get();
            tempTutorial.setDescription(newTutorial.getDescription());
            tempTutorial.setPublished(newTutorial.isPublished());
            tempTutorial.setTitle(newTutorial.getTitle());

            return repository.save(tempTutorial);
        }else {
            throw new RuntimeException("No Such repository");
        }
    }

    @Override
    public boolean deleteTutorial(long id) {
        Optional<Tutorial> tutorial = getTutorialById(id);

        if (tutorial.isPresent()){
            repository.delete(tutorial.get());
            return true;
        }

        return false;
    }

    @Override
    public void deleteAllTutorials() {
        repository.deleteAll();
    }
}
