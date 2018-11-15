package javaRESTserver.Repositories;

import javaRESTserver.Models.RepositorioModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioRepository extends CrudRepository<RepositorioModel, Long> {
  public Iterable<RepositorioModel> findRepositoryModelByNombreContaining(String nombre);
}
