package com.springstudent.springbootdatajpa.controller;

import com.springstudent.springbootdatajpa.entity.Tutorial;
import com.springstudent.springbootdatajpa.repository.TutorialDAO;
import com.springstudent.springbootdatajpa.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TutorialController {

    private TutorialService tutorialService;

    @Autowired
    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(){
        List<Tutorial> response = tutorialService.getAllTutorials();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> findById(@PathVariable("id") long id){
        Optional<Tutorial> tutorial = tutorialService.findById(id);

        if (tutorial.isPresent()){
            return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
       Tutorial response =  tutorialService.save(tutorial);

       return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable long id,
                                                   @RequestBody Tutorial tutorial){

        Optional<Tutorial> oldTutorial = tutorialService.findById(id);

        if (oldTutorial.isPresent()){
            Tutorial oldTutorialItem = oldTutorial.get();
            oldTutorialItem.setDescription(tutorial.getDescription());
            oldTutorialItem.setPublished(tutorial.isPublished());
            oldTutorialItem.setTitle(tutorial.getTitle());
            Tutorial response = tutorialService.save(oldTutorialItem);
            return new ResponseEntity<>( response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id){
        try {
            tutorialService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
