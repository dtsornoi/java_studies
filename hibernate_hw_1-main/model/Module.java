package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "modules")
@Getter
@Setter
@NoArgsConstructor
public class Module {
    @Id
    @Column(name = "moduleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "classroomId")
    private ClassRooms classRooms;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
