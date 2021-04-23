package persistence;

import module.Movie;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public class MovieRepository {
    private EntityManager entityManager;

    public MovieRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public List<Movie> findAll(){
        String sql = "FROM movies";

        return entityManager.createQuery(sql).getResultList();
    }

    public Movie findById(UUID id){
        return entityManager.find(Movie.class, id);
    }

    public List<Movie> findAllByName(String title){
        String sql = "SELECT m FROM movies m WHERE m.title = :title";

        return entityManager.createQuery(sql).setParameter("title", title).getResultList();
    }

    public void save(Movie movie){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Movie movie){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(movie);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
