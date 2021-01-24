package SpringApplication.repositories;

import SpringApplication.model.Gericht;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GerichtRepository extends CrudRepository<Gericht, Long> {
    @Query(value = "select Gericht.beschreibung from Gericht", nativeQuery = true)
    List<String> allGerichte();
}
