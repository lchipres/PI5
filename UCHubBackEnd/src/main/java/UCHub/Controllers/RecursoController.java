package UCHub.Controllers;

import java.util.Map;
import java.util.Optional;

import UCHub.Models.RecursoModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


// UCHub.Models
import UCHub.Repositories.*;

@Controller
@RequestMapping(path="/recursos")
public class RecursoController {
    @Autowired
    private RecursoRepository recursoRepository;

//    GET all the resources
    @GetMapping(path="/")
    public @ResponseBody Iterable<RecursoModel> getAllRecursos(){
        return recursoRepository.findAll();
    }

//    POST a new Resource
    @PostMapping(path="/")
    public @ResponseBody RecursoModel addNewRecurso(@RequestBody Map<String, String> body){
        RecursoModel r = new RecursoModel(0, 0, body.get("categoria"),
                body.get("formato"), body.get("nombre"), body.get("autor"), body.get("edicion"),
                body.get("etiquetas"), body.get("descripcion"));
        recursoRepository.save(r);
        return r;
    }

    @GetMapping("/{id}")
    public @ResponseBody RecursoModel getRecurso(@PathVariable( value = "id" ) String id){
        Optional<RecursoModel> recurso = recursoRepository.findById(Long.parseLong(id));

        if(!recurso.isPresent()){
            return new RecursoModel();
        }

        return recurso.get();
    }

    @PutMapping("/{id}/like")
    public @ResponseBody RecursoModel giveLike(@PathVariable( value = "id") String id,
                                               @RequestBody Map<String, String> body) {

//      User is needed
        if(!body.containsKey("userId"))
            return new RecursoModel();

        Optional<RecursoModel> r = recursoRepository.findById(Long.parseLong(id));

        if(!r.isPresent())
            return new RecursoModel();

        r.get().giveLike();

        recursoRepository.save(r.get());
        return r.get();
    }

    @PutMapping("/{id}/seen")
    public @ResponseBody RecursoModel resourceSeen(@PathVariable( value = "id") String id){
        Optional<RecursoModel> r = recursoRepository.findById(Long.parseLong(id));

        if(!r.isPresent())
            return new RecursoModel();

        r.get().seen();

        recursoRepository.save(r.get());

        return r.get();
    }
}
