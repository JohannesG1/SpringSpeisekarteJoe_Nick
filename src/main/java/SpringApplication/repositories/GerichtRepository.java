package SpringApplication.repositories;

import SpringApplication.model.Gericht;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GerichtRepository extends CrudRepository<Gericht, Long> {
    @Query(value = "select * from Gericht", nativeQuery = true)
    Collection<Gericht> allGerichte();
}
