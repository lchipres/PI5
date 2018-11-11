package javaRESTserver.Repositories;

import javaRESTserver.Models.RepositorioModel;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioRepository extends CrudRepository<RepositorioModel, Long> {
}
