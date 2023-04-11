package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Service;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}