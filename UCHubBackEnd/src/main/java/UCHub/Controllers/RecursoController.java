package UCHub.Controllers;

import java.util.Map;
import java.util.Optional;

// import UCHub.Models.ComentarioModel;
import UCHub.Models.ComentarioModel;
import UCHub.Models.RecursoModel;
import UCHub.Models.UsuarioModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


// UCHub.Models
import UCHub.Repositories.*;

import javax.swing.text.html.Option;

@Controller
@RequestMapping(path="/recursos")
public class RecursoController {
    @Autowired
    private RecursoRepository recursoRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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

//   Get resource by id
    @GetMapping("/{id}")
    public @ResponseBody RecursoModel getRecurso(@PathVariable( value = "id" ) String id){
        Optional<RecursoModel> recurso = recursoRepository.findById(Long.parseLong(id));

        if(!recurso.isPresent()){
            return new RecursoModel();
        }

        return recurso.get();
    }

//   Give a like to a resource
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

//    The resource was clicked
    @PutMapping("/{id}/seen")
    public @ResponseBody RecursoModel resourceSeen(@PathVariable( value = "id") String id){
        Optional<RecursoModel> r = recursoRepository.findById(Long.parseLong(id));

        if(!r.isPresent())
            return new RecursoModel();

        r.get().seen();

        recursoRepository.save(r.get());

        return r.get();
    }

//    Find by a column
    @PostMapping("/find")
    public @ResponseBody Iterable<RecursoModel> findByColumn(@RequestBody Map<String, String> body){

        if(body.containsKey("author"))
            return recursoRepository.findRecursoModelsByAutorContaining(body.get("author"));
        else if(body.containsKey("description"))
            return recursoRepository.findRecursoModelsByDescripcionContaining(body.get("description"));
        else if(body.containsKey("tags"))
            return recursoRepository.findRecursoModelsByEtiquetasContaining(body.get("tags"));
        else if(body.containsKey("name"))
            return recursoRepository.findRecursoModelsByNombreContaining(body.get("name"));
        else if(body.containsKey("format"))
            return recursoRepository.findRecursoModelsByFormatoEquals(body.get("format"));
        else if(body.containsKey("category"))
            return recursoRepository.findRecursoModelsByCategoriaContaining(body.get("category"));
        else if(body.containsKey("numConsultas"))
            return recursoRepository.findRecursoModelsByOrderByNumConsultasDesc();
        else if(body.containsKey("numLikes"))
            return recursoRepository.findRecursoModelsByOrderByNumLikesDesc();

        return recursoRepository.findAll();
    }

//  Modify a resource
    @PutMapping("/{id}")
    public @ResponseBody RecursoModel updateAResource(@RequestBody Map<String, String> map,
                                                      @PathVariable( value = "id" ) String id){
        // Get the resource by id
        Optional<RecursoModel> resource = recursoRepository.findById(Long.parseLong(id));

        if(!resource.isPresent())
            return new RecursoModel();

        resource.get().setAutor(map.get("autor"));
        resource.get().setCategoria(map.get("categoria"));
        resource.get().setDescripcion(map.get("descripcion"));
        resource.get().setEdicion(map.get("edicion"));
        resource.get().setEtiquetas(map.get("etiquetas"));
        resource.get().setFormato(map.get("formato"));
        resource.get().setNombre(map.get("nombre"));

        recursoRepository.save(resource.get());

        return resource.get();
    }

    @PostMapping("/{recursoID}/comentarios/")
    public @ResponseBody ComentarioModel newComment(@PathVariable String recursoID,
                                                    @RequestBody Map<String, String> body){
        Optional<RecursoModel> recurso = recursoRepository.findById(Long.parseLong(recursoID));

        if(recurso.isPresent()){
            if( body.containsKey("cuentaUsuario") ){
                Optional<UsuarioModel> usuario =
                        usuarioRepository.findByCuenta(Long.parseLong(body.get("cuentaUsuario")));

                if(usuario.isPresent()){
                    ComentarioModel nuevoComentario = new ComentarioModel(recurso.get(), usuario.get(), body.get("contenido"));

                    comentarioRepository.save(nuevoComentario);

                    return nuevoComentario;
                }
            }
        }


        return new ComentarioModel();
    }

}
