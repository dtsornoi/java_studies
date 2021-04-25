package com.example.springangular.repository;

import com.example.springangular.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findTutorialsByTitle(String title);


    Optional<Tutorial> findTutorialByTitle(String title);
}
