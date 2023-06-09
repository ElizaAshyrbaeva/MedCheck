package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Account;

import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
Optional<Account>findByEmail(String email);
}