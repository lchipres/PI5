package UCHub.Controllers;

import UCHub.Models.RecursoModel;
import UCHub.Models.RepositorioModel;
import UCHub.Models.UsuarioModel;
import UCHub.Repositories.RecursoRepository;
import UCHub.Repositories.RepositorioRepository;
import UCHub.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path="/repositorios")
public class RepositorioController {
    @Autowired
    RepositorioRepository repositorioRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RecursoRepository recursoRepository;

    @GetMapping(path="/")
    public @ResponseBody Iterable<RepositorioModel> getAllRepositories(){
        return repositorioRepository.findAll();
    }

    @PostMapping(path="/")
    public @ResponseBody RepositorioModel
    addNewRepository(@RequestBody Map<String, String> body){
        // get the user by account passed by post body
        Optional<UsuarioModel> user = usuarioRepository.findByCuenta(
                Long.parseLong(body.get("cuenta")));
        if(user.isPresent()) {
            RepositorioModel r = new RepositorioModel(body.get("nombre"),
                                body.get("descripcion"), body.get("etiquetas"),
                                user.get());
            repositorioRepository.save(r);
            return r;
        }
        return null;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody RepositorioModel getRepo(@PathVariable String id){
        Optional<RepositorioModel> repo = repositorioRepository.findById(Long.parseLong(id));
        return repo.orElse(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody RepositorioModel editRepository(@PathVariable(value="id") Integer id,
                                                         @RequestBody Map<String, String> body){
        Optional<RepositorioModel> r = repositorioRepository.findById((long)id);
        if(r.isPresent()){
            r.get().setDescripcion(body.get("descripcion"));
            r.get().setEtiquetas(body.get("etiquetas"));
            r.get().setNombre(body.get("nombre"));
            repositorioRepository.save(r.get());
            return r.get();
        }
        return null;
    }

    @PostMapping(path="/{id}/recursos")
    public @ResponseBody RepositorioModel
    addResourceToRepo(@PathVariable(value="id") String id, @RequestBody Map<String, String> body){
        // getting repo
        Optional<RepositorioModel> repo =
                repositorioRepository.findById(Long.parseLong(id));

        if(repo.isPresent()){
            Optional<RecursoModel> res =
                    recursoRepository.findById(Long.parseLong(body.get("recursoId")));
            if(res.isPresent()){
                repo.get().addRecurso(res.get());
                repositorioRepository.save(repo.get());
                return repo.get();
            }
        }
        return null;
    }

    @PostMapping(path="/{id}/newrecurso")
    public @ResponseBody RepositorioModel
    createResourceToRepo(@PathVariable(value="id") String id, @RequestBody Map<String, String> body){
        // getting repo
        Optional<RepositorioModel> repo = repositorioRepository.findById(Long.parseLong(id));

        if(repo.isPresent()){
            RecursoModel r = new RecursoModel(0, 0, body.get("categoria"),
                    body.get("formato"), body.get("nombre"), body.get("autor"), body.get("edicion"),
                    body.get("etiquetas"), body.get("descripcion"));
            recursoRepository.save(r);
            repo.get().addRecurso(r);
            repositorioRepository.save(repo.get());
            return repo.get();
        }
        return null;
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody Iterable<RepositorioModel> deleteRepository(@PathVariable String id){
        Optional<RepositorioModel> repo = repositorioRepository.findById(Long.parseLong(id));

        repo.ifPresent(repositorioModel -> repositorioRepository.delete(repositorioModel));

        return repositorioRepository.findAll();
    }

}
