package UCHub.Repositories;

import org.springframework.data.repository.CrudRepository;

import UCHub.Models.UsuarioModel;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    UsuarioModel findByCuenta(long accountNumber);
}
