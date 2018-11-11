package javaRESTserver.Repositories;

import org.springframework.data.repository.CrudRepository;

import javaRESTserver.Models.RecursoModel;

import java.util.List;

public interface RecursoRepository extends CrudRepository<RecursoModel, Long>{
    List<RecursoModel> findRecursoModelsByAutorContaining(String autor);
    List<RecursoModel> findRecursoModelsByDescripcionContaining(String description);
    List<RecursoModel> findRecursoModelsByEtiquetasContaining(String labels);
    List<RecursoModel> findRecursoModelsByFormatoEquals(String format);
    List<RecursoModel> findRecursoModelsByCategoriaContaining(String category);
    List<RecursoModel> findRecursoModelsByNombreContaining(String name);
    List<RecursoModel> findRecursoModelsByOrderByNumConsultasDesc();
    List<RecursoModel> findRecursoModelsByOrderByNumLikesDesc();

}
