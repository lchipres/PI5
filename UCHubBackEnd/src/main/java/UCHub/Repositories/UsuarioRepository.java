package UCHub.Repositories;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

import UCHub.Models.UsuarioModel;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    UsuarioModel findByCuenta(long accountNumber);

    boolean existsUsuarioModelById(ID primarKey);
    boolean existsUsuarioModelByCuenta(long cuenta);
}
