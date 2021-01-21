package SpringApplication.repositories;

import SpringApplication.model.Kategorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface KategorieRepository extends CrudRepository<Kategorie, Long> {
}
