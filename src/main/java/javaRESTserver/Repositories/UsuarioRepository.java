package javaRESTserver.Repositories;

import org.springframework.data.repository.CrudRepository;
import javaRESTserver.Models.UsuarioModel;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    Optional<UsuarioModel> findByCuenta(long accountNumber);
}
