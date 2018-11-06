package UCHub.Repositories;

//import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

import UCHub.Models.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    Optional<UsuarioModel> findByCuenta(long accountNumber);

    boolean existsUsuarioModelById(long primarKey);
    boolean existsUsuarioModelByCuenta(long cuenta);
}
