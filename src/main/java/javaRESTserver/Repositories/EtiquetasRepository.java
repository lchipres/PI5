package javaRESTserver.Repositories;

import javaRESTserver.Models.EtiquetaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EtiquetasRepository extends CrudRepository<EtiquetaModel, Long> {
    Optional<EtiquetaModel> getAllByNombreContaining(String name);
}
