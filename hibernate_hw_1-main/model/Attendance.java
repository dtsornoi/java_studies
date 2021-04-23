package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendances")
@NoArgsConstructor
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendanceId")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "isPresent")
    private int isPresent;

    @ManyToOne
    @JoinColumn(name = "moduleId")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public Attendance(int id, Date date, int isPresent) {
        this.id = id;
        this.date = date;
        this.isPresent = isPresent;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", date=" + date +
                ", isPresent=" + isPresent +
                '}';
    }
}
