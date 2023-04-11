package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "days")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDateAndTime {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_date_and_time_seq")
    @SequenceGenerator(name = "schedule_date_and_time_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate date;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private Boolean isBusy;
    @ManyToOne
    Schedule schedule;
}
