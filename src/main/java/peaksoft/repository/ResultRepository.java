package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Result;
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}