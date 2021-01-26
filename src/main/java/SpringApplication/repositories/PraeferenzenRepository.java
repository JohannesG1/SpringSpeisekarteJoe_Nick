package SpringApplication.repositories;

import SpringApplication.model.Gericht;
import SpringApplication.model.Praeferenzen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PraeferenzenRepository extends CrudRepository<Praeferenzen, Long> {
    @Query(value = "select * from Praeferenzen", nativeQuery = true)
    Collection<Praeferenzen> allPraeferenzen();
}
