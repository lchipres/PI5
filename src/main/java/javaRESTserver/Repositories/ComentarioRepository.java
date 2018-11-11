package javaRESTserver.Repositories;

import javaRESTserver.Models.ComentarioModel;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<ComentarioModel, Long> {

}
