package hider.sanchez.challengebcp.repository;

import hider.sanchez.challengebcp.entity.Change;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChangeRepository extends JpaRepository<Change, Integer> {
    Optional<Change> findOneByCurrencyCode(String currencyCode);

}
