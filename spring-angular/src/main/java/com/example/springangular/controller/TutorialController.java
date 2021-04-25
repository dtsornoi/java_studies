package com.example.springangular.controller;

import com.example.springangular.model.Tutorial;
import com.example.springangular.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TutorialController {

    private TutorialService tutorialService;

    @Autowired
    public TutorialController(TutorialService service) {
        this.tutorialService = service;
    }

    /**
     * GET: <code>/tutorials</code>
     * @return all tutorials in database
     * @param title to lookup the database for - optional
     */
    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title){

        List<Tutorial> foundTutorials = tutorialService.getAllTutorials(title);

        if (foundTutorials.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(foundTutorials, HttpStatus.OK);
    }

    /**
     * GET: <code>/tutorials/id</code>
     * @return a tutorial with respective id
     * @param id path variable for the tutorial id to lookup
     */
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id){
        Optional<Tutorial> tutorial = tutorialService.getTutorialById(id);
        if (tutorial.isPresent()){
            return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
    * POST: <code>/tutorials</code>
     * @param  tutorial The tutorial to persist in database
     * @return created tutorial
    */
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
       Tutorial upcomingTutorial =  tutorialService.createTutorial(tutorial);

       return new ResponseEntity<>(upcomingTutorial, HttpStatus.CREATED);
    }


    /**
     * PUT: <code>/tutorials/id</code>
     * @param id the id of the old tutorial to replace
     * @param tutorial The new tutorial
     * @return updated tutorial
     */
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial){
        Tutorial newTutorial = tutorialService.updateTutorial(id, tutorial);
        if (newTutorial == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(newTutorial, HttpStatus.OK);
    }

    /**
     * DELETE: <code>/tutorials/id</code>
     * @param id the id of the tutorial to be deleted
     * Deletes tutorial with a specified tutorial id;
     */
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> deleteTutorial(@PathVariable("id") long id){
        Optional<Tutorial> tutorial = tutorialService.getTutorialById(id);
        boolean success = tutorialService.deleteTutorial(id);
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * DELETE: <code>/tutorials</code>
     * Delete all of the tutorials stored in database
     */
    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials(){
        tutorialService.deleteAllTutorials();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET: <code>/tutorials/published</code>
     * @return All published tutorials
     */
    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findPublishedTutorials(){
        List<Tutorial> tutorials = tutorialService.getTutorialsByPublished(true);
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }
}
