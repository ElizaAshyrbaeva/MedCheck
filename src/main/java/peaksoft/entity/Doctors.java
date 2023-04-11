package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Position;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_seq")
    @SequenceGenerator(name = "doctors_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
    private Boolean isActive;
    private String description;
    @OneToMany(mappedBy = "doctors",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Schedule> schedules = new LinkedHashSet<>();
    @OneToMany(mappedBy = "doctors",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Service service;

}