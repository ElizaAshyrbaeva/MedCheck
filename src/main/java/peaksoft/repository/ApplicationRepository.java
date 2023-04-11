package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}