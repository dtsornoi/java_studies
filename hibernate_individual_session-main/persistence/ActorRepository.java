package persistence;

import module.Actor;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public class ActorRepository {
    private EntityManager entityManager;

    public ActorRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Actor actor){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(actor);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public Actor findById(UUID id){
        return entityManager.find(Actor.class, id);
    }

    public List<Actor> findAllBornAfter(int year){
        String sql = "SELECT a FROM actors a WHERE a.yearOfBirth > :year";

        return entityManager.createQuery(sql).setParameter("year", year).getResultList();
    }

    public List<Actor> findAllWithLastNameEndsWith(String surnameEndsWith){
        String sql = "SELECT a FROM actors a WHERE a.lastName LIKE :lastName";

        return entityManager.createQuery(sql).setParameter("lastName", "%" + surnameEndsWith).getResultList();
    }
}
