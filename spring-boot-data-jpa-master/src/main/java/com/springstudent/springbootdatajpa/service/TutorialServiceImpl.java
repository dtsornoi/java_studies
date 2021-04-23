package com.springstudent.springbootdatajpa.service;

import com.springstudent.springbootdatajpa.entity.Tutorial;
import com.springstudent.springbootdatajpa.repository.TutorialDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService{

    private TutorialDAO tutorialDAO;

    @Autowired
    public TutorialServiceImpl(TutorialDAO tutorialDAO) {
        this.tutorialDAO = tutorialDAO;
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return tutorialDAO.findAll();
    }

    @Override
    public Optional<Tutorial> findById(long id) {
        return tutorialDAO.findById(id);
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        return tutorialDAO.save(tutorial);
    }

    @Override
    public void deleteById(long id) {
        tutorialDAO.deleteById(id);
    }
}
