package persistance;

import model.Person;
import model.Team;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Repository {
    private EntityManager entityManager;

    public Repository(){
        entityManager = DBUtil.getEntityManager();
    }

    public List<Person> allStudents(){
        String sql = "FROM Person p " +
                "WHERE p.isTrainer = 0";
        return entityManager.createQuery(sql).getResultList();
    }

    public List<Person> studentsFromTeamPython1Tallinn(){
        String sql = "SELECT p " +
                "FROM Person p " +
                "WHERE p.team.id = 4";

        return entityManager.createQuery(sql).getResultList();
    }

    public List<Team> groupAtBucharest(){
        String sql = "SELECT new Team(m.team.id, m.team.name) " +
                "FROM Module m " +
                "WHERE m.classRooms.id = 1";

        return entityManager.createQuery(sql).getResultList();
    }

    public List<Team> groupCozyInMarch2020(){
        String sql = "SELECT new Team(m.team.id, m.team.name) " +
                "FROM Module m " +
                "WHERE m.classRooms.id = 3 " +
                "AND m.startDate > 2020-03-01";
        return entityManager.createQuery(sql).getResultList();
    }

    public List<Person> studentsFinishedSQL(){
        String sql = "SELECT new Person(m.person.id, m.person.firstName, m.person.lastName, m.person.email, m.person.dateOfBirth, m.person.isTrainer) " +
                "FROM Module m " +
                "WHERE m.topic.id = 3 AND m.person.team.id = 1";

        return entityManager.createQuery(sql).getResultList();
    }

    public List <Person> studentsWith100PercentAttendance(){
        String sql = "SELECT DISTINCT new Person(a.person.firstName, " +
                "a.person.lastName)" +
                "FROM Attendance AS a " +
                "WHERE a.isPresent = 1";

       return entityManager.createQuery(sql).getResultList();
    }

    public List<Person> javaFundTrainers(){
        String sql = "SELECT new Person(m.person.firstName, m.person.lastName) " +
                "FROM Module m " +
                "WHERE m.topic.id = 1 AND m.person.isTrainer = 1";

        return entityManager.createQuery(sql).getResultList();
    }

    public List<Person> trainersFromBucharest(){
        String sql = "SELECT new Person(m.person.firstName, m.person.lastName) " +
                "FROM Module m " +
                "WHERE m.classRooms.id = 1 AND m.person.isTrainer = 1";

        return entityManager.createQuery(sql).getResultList();
    }
}
