package guru.springframework.Spring5webapp.repositories;

import guru.springframework.Spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>
{
}
