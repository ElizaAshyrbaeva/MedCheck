package peaksoft.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Repeat;
import peaksoft.enums.Repetition;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
    @SequenceGenerator(name = "schedule_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;
    private LocalTime startTime;
    private LocalTime finishTime;
    private LocalTime lunchFrom;
    private LocalTime lunchTo;
    private int intervalOfHours;
    @ElementCollection
    private Map<Repeat, Boolean> repeatDays = new LinkedHashMap<>();
    private Repetition typeOfRepetition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctors_id")
    private Doctors doctors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Service service;
    @OneToMany(cascade = {CascadeType.ALL})
    List< ScheduleDateAndTime> dateAndTimes;

}