package SpringApplication.repositories;

import SpringApplication.model.Gericht;
import SpringApplication.model.Kategorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerichtRepository extends CrudRepository<Gericht, Long> {
}
