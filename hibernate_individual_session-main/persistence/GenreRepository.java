package persistence;

import module.Genre;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GenreRepository {
    private EntityManager entityManager;

    public  GenreRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public List<Genre> findAll(){
        String sql = "FROM genres";
        return entityManager.createQuery(sql).getResultList();
    }

    public Optional<Genre> findById(UUID id){
        return Optional.ofNullable(entityManager.find(Genre.class, id));
    }

    public List<Genre> findAllByName(String name){
        String sql = "SELECT g FROM genres WHERE name = :name";

        return entityManager.createQuery(sql).setParameter("name", name).getResultList();
    }

    public void save (Genre genre){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(genre);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Genre genre){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(genre);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
