package peaksoft.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "service_seq")
    @SequenceGenerator(name = "service_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "service",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "service",
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH},
            orphanRemoval = true)
    private List<Doctors> doctors = new ArrayList<>();
    @OneToMany(mappedBy = "service",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Appointment> appointment = new ArrayList<>();



}