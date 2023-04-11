package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Doctors;
@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
}