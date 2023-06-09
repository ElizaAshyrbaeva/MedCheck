package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Schedule;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}